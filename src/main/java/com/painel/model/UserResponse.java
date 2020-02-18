package com.painel.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserResponse extends OperationResponse {
    private Usuario data = new Usuario();
}
