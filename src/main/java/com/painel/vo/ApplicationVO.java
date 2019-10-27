package com.painel.vo;

import com.painel.model.Application;
import lombok.Data;

@Data
public class ApplicationVO {

    private Long id;
    private String nome;
    private String nomeResponsavel;
    private String emailResponsavel;

    public ApplicationVO(Application application){

        this.id = application.getId();
        this.nome = application.getName();
        this.emailResponsavel = application.getEmailResponsavel();
        this.nomeResponsavel = application.getNomeResponsavel();

    }
}
