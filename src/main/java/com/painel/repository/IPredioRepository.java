package com.painel.repository;

import com.painel.model.Predio;

import com.painel.model.QPredio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPredioRepository extends JpaRepository<Predio, Long>{
      //  QuerydslPredicateExecutor<Predio>, QuerydslBinderCustomizer<QPredio> {

    List<Predio> findAll();
}
