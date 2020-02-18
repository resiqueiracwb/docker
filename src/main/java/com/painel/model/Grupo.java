package com.painel.model;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "Grupo")
public class Grupo {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nome;

    @Column(name = "chave")
    private String chave;

    @OneToOne(mappedBy = "grupo")
    private Usuario usuario;

}
