package com.roadmap.vo;


import com.roadmap.model.Predio;
import lombok.Data;

@Data
public class PredioVO {

    private Long id;
    private String name;
    private Integer qtdeAndares;
    private String cor;
    private String tipoPadrao;
    private boolean isPortaria;
    private Integer qtdeElevadores;
    private String nomeSindico;
    private boolean vagasCobertas;
    private Integer qtdeApartamentos;
    private boolean isSalaoFestas;

    public PredioVO(Predio predio){
        this.id = predio.getId();
        this.name = predio.getName();
        this.qtdeAndares = predio.getQtdeAndares();
        this.cor = predio.getCor();
        this.tipoPadrao = predio.getTipoPadrao();
        this.isPortaria = predio.isPortaria();
        this.qtdeElevadores = predio.getQtdeElevadores();
        this.nomeSindico = predio.getNomeSindico();
        this.vagasCobertas = predio.isVagasCobertas();
        this.qtdeApartamentos = predio.getQtdeApartamentos();
        this.isSalaoFestas = predio.isSalaoFestas();
    }

}
