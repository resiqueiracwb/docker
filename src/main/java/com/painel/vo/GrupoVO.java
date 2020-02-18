package com.painel.vo;

import com.painel.model.Grupo;
import lombok.Data;

@Data
public class GrupoVO {

    private Long id;
    private String nome;
    private String chave;


    public GrupoVO(Grupo grupo) {
        this.id = grupo.getId();
        this.nome = grupo.getNome();
        this.chave = grupo.getChave();
    }
}
