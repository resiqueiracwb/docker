package com.painel.controller;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.Resources;
import com.painel.assembler.PredioResourceAssembler;
import com.painel.model.Predio;
import com.painel.repository.IPredioRepository;

import io.swagger.annotations.Api;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@Api(value = "BuildingController")
@RestController
public class BuildingController {

    private final IPredioRepository predioRepository;
    private final PredioResourceAssembler assembler;

    BuildingController(IPredioRepository predioRepository, PredioResourceAssembler assembler) {
        this.predioRepository = predioRepository;
        this.assembler = assembler;
    }
    @GetMapping(value = "/buildings", produces = "application/json; charset=UTF-8")
    public Resources<Resource<Predio>> all() {

        List<Resource<Predio>> predios = predioRepository.findAll().stream()
                .map(assembler::toResource)
                .collect(Collectors.toList());

        return new Resources<>(predios,  linkTo(methodOn(BuildingController.class).all()).withSelfRel());
    }

    @GetMapping(value ="/buildings/{id}", produces = "application/json; charset=UTF-8")
    public Resource<Predio> one(@PathVariable Long id) {
        return assembler.toResource(predioRepository.findById(id).orElseThrow());
    }


    @PostMapping(value ="/buildings", produces = "application/json; charset=UTF-8")
    public ResponseEntity<Resource<Predio>> newPredio(@RequestBody Predio predio) {

        Predio newPredio = predioRepository.save(predio);

        return ResponseEntity
                .created(linkTo(methodOn(BuildingController.class).one(newPredio.getId())).toUri())
                .body(assembler.toResource(newPredio));
    }

    @PutMapping(value ="/buildings/{id}/portaria", produces = "application/json; charset=UTF-8")
    public ResponseEntity<ResourceSupport> complete(@PathVariable Long id) {

        Predio predio = predioRepository.findById(id).orElseThrow();

        if (predio.isPortaria()) {
            predio.setPortaria(false);
            return ResponseEntity.ok(assembler.toResource(predioRepository.save(predio)));
        }

        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(new VndErrors.VndError("Method not allowed", "Não foi possivel alterar status da portaria do prédio  " + predio.getId() + " porque o prédio não tem portaria"));
    }

}
