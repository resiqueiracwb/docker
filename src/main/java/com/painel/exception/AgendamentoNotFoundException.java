/**
 * 
 */
package com.painel.exception;


import com.painel.enums.ErrorCode;

/**
 * @author A0051460
 *
 */
public class AgendamentoNotFoundException extends PainelException {

private static final long serialVersionUID = 1L;
	
	public AgendamentoNotFoundException() {
		super(ErrorCode.AGENDAMENTO_NOT_FOUND);
	}
}
