package com.painel.model;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "Application")
public class Application {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name="nome")
    private String name;

    @Column(name="nome_responsavel")
    private String nomeResponsavel;

    @Column(name="email_responsavel")
    private String emailResponsavel;
}
