package com.painel.exception;


import com.painel.enums.ErrorCode;

public class ContratadaDisponibilidadeException extends PainelException {

	private static final long serialVersionUID = 1L;
	
	public ContratadaDisponibilidadeException() {
		super(ErrorCode.SEM_DISPONIBILIDADE);
	}

}
