package com.painel.vo;

import lombok.Data;

@Data
public class LoginVO {
    private Long id;
    private String password;
    private String name;
    private String[] roles;
    private String email;
    private String permissoes;
}
