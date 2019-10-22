package com.roadmap.repository;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.roadmap.model.Predio;

import com.roadmap.model.QPredio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPredioRepository extends JpaRepository<Predio, Long>{
      //  QuerydslPredicateExecutor<Predio>, QuerydslBinderCustomizer<QPredio> {

    List<Predio> findAll();
}
