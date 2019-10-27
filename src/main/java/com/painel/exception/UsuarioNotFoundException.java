package com.painel.exception;


import com.painel.enums.ErrorCode;

public class UsuarioNotFoundException extends PainelException {
	
	private static final long serialVersionUID = 1L;
	
	public UsuarioNotFoundException() {
		super(ErrorCode.USUARIO_NOT_FOUND);
	}

}
