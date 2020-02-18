package com.painel.exception;


import com.painel.enums.ErrorCode;

public class InvalidFieldException extends PainelException{
	
	private static final long serialVersionUID = 1L;
	
	public InvalidFieldException() {
		super(ErrorCode.CAMPO_INVALIDO);
	}

}