package com.painel.model;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "senha")
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "grupo_id", referencedColumnName = "id")
    private Grupo grupo;

    @Column(name = "ativo")
    private boolean isActive;
}
