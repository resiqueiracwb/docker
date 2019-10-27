/**
 * 
 */
package com.painel.exception;


import com.painel.enums.ErrorCode;

/**
 * @author renato
 *
 */
public class ErrorSaveAgendamentoException  extends PainelException {

	private static final long serialVersionUID = 1L;
	
	public ErrorSaveAgendamentoException() {
		super(ErrorCode.ERRO_SAVE_AGENDAMENTO);
	}

}