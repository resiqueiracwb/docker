/**
 * 
 */
package com.painel.exception;


import com.painel.enums.ErrorCode;

/**
 * @author A0051460
 *
 */
public class EsteiraInicialMaiorException extends PainelException {

	private static final long serialVersionUID = 1L;
	
	public EsteiraInicialMaiorException() {
		super(ErrorCode.ESTEIRA_INICIAL_MAIOR);
	}


}
