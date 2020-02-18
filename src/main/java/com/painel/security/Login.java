package com.painel.security;

import io.swagger.annotations.*;
import lombok.*;


@Data
public class Login {

    @ApiModelProperty(example = "admin@telefonica.com", required = true)
    private String username = "";

    @ApiModelProperty(example = "!78G2klsVivo", required = true)
    private String password = "";

}
