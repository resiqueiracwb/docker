package com.painel.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class SessionItem {
    private String token;
    private String email;
    private String permissao;

}
