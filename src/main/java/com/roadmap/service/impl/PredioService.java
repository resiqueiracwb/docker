package com.roadmap.service.impl;

import com.roadmap.model.Predio;
import com.roadmap.repository.IPredioRepository;
import com.roadmap.service.IPredioService;
import com.roadmap.vo.PredioVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PredioService implements IPredioService {
    @Autowired
    private IPredioRepository dataBasesRepository;

    @Override
    public List<PredioVO> getAllPredio() {
        List<PredioVO> result = new ArrayList<PredioVO>();

        this.dataBasesRepository.findAll().forEach(predio ->{
            result.add(new PredioVO(predio));
        });

        return result;
    }

    @Override
    public Predio save(Predio predio) {
        return this.dataBasesRepository.save(predio);
    }

    @Override
    public void delete(Integer id) {

        this.dataBasesRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public Predio getById(Long id) {

        return this.dataBasesRepository.findById(id).get();
    }

    @Override
    public void newFeatures() {

        List<Predio> predioList = this.dataBasesRepository.findAll();

        //Converting a stream to the Collection (Collection, List or Set):
        List<String> nameList = predioList.stream()
                .map(Predio::getName)
                .collect(Collectors.toList());

            nameList.forEach(name ->{
             //   System.out.println(name);
            });

        //Reducing to String:
        String listNamesString = predioList.stream()
                .map(Predio::getName)
                .collect(Collectors.joining(", ", "[", "]"));

     //   System.out.println(listNamesString);


        //Processing the average value of all numeric elements of the stream:

        Double averageFloor = predioList.stream()
                .collect(Collectors.averagingInt(Predio::getQtdeAndares));

     //   System.out.println(averageFloor);

        //Processing the sum of all numeric elements of the stream:
        int summingFloor = predioList.stream()
                .collect(Collectors.summingInt(Predio::getQtdeAndares));

      //  System.out.println(summingFloor);

        //Collecting statistical information about stream’s elements:

        IntSummaryStatistics statistics = predioList.stream()
                .collect(Collectors.summarizingInt(Predio::getQtdeAndares));

    //    System.out.println(statistics);


        //Grouping of stream’s elements according to the specified function:

        Map<Integer, List<Predio>> collectorMapOfLists = predioList.stream()
                .collect(Collectors.groupingBy(Predio::getQtdeAndares));

        collectorMapOfLists.forEach((k,v) ->{
          //  System.out.println(k + "," + v);
        });

        //Dividing stream’s elements into groups according to some predicate:
        Map<Boolean, List<Predio>> mapPartioned = predioList.stream()
                .collect(Collectors.partitioningBy(element -> element.getQtdeAndares() > 20));

        mapPartioned.forEach((k,v) ->{
          //  System.out.println(k + "," + v);
        });


        //Pushing the collector to perform additional transformation:

        Set<Predio> unmodifiableSet = predioList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toSet(),
                        Collections::unmodifiableSet));
        unmodifiableSet.forEach(predio -> {
       //     System.out.println(predio.getName());
        });


      //Custom collector:
        //If for some reason, a custom collector should be created,
        // the most easier and the less verbose way of doing so – is to use the method of() of the type Collector.

        Collector<Predio, ?, LinkedList<Predio>> toLinkedList =
                Collector.of(LinkedList::new, LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });

        LinkedList<Predio> linkedListOfPersons =
                predioList.stream().collect(toLinkedList);

        linkedListOfPersons.forEach(predio ->{
            System.out.println(predio.getName());
        });

/**
        List<Integer> list = new ArrayList<Integer>();
                for(int i = 1; i< 10; i++){
                    list.add(i);
                }
                Stream<Integer> stream = list.stream();
                List<Integer> evenNumbersList = stream.filter(i -> i%2 == 0)
                        .collect(Collectors.toList());

                System.out.print(evenNumbersList);

                **/

    }




}
