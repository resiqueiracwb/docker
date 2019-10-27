/**
 * 
 */
package com.painel.exception;


import com.painel.enums.ErrorCode;

/**
 * @author A0051460
 *
 */
public class ProjetoNotFoundException extends PainelException {

private static final long serialVersionUID = 1L;
	
	public ProjetoNotFoundException() {
		super(ErrorCode.PROJETO_NOT_FOUND);
	}
}
