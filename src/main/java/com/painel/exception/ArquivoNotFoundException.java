/**
 * 
 */
package com.painel.exception;


import com.painel.enums.ErrorCode;

/**
 * @author A0051460
 *
 */
public class ArquivoNotFoundException extends PainelException {

private static final long serialVersionUID = 1L;
	
	public ArquivoNotFoundException() {
		super(ErrorCode.ARQUIVO_NOT_FOUND);
	}
}
