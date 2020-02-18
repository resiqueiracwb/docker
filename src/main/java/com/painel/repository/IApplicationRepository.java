package com.painel.repository;

import com.painel.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IApplicationRepository extends JpaRepository<Application, Long> {
}
