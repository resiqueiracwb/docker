package com.painel.exception;

public class ArmarioInvalidException extends RuntimeException {
    public ArmarioInvalidException(String msgErro) {
        super(msgErro);
    }
}
