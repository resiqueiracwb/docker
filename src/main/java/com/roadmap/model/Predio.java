package com.roadmap.model;



import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "Predio")
public class Predio {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "qtde_andares")
    private Integer qtdeAndares;

    @Column(name = "cor")
    private String cor;

    @Column(name = "tipo_padrao")
    private String tipoPadrao;

    @Column(name = "is_portaria")
    private boolean isPortaria;

    @Column(name = "qtde_elevadores")
    private Integer qtdeElevadores;

    @Column(name = "nome_sindico")
    private String nomeSindico;

    @Column(name = "vagas_cobertas")
    private boolean vagasCobertas;

    @Column(name = "qtde_apartamentos")
    private Integer qtdeApartamentos;

    @Column(name = "salao_festas")
    private boolean isSalaoFestas;

}
