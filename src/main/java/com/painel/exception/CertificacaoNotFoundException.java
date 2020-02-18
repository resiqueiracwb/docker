/**
 * 
 */
package com.painel.exception;


import com.painel.enums.ErrorCode;

/**
 * @author A0051460
 *
 */
public class CertificacaoNotFoundException extends PainelException {

private static final long serialVersionUID = 1L;
	
	public CertificacaoNotFoundException() {
		super(ErrorCode.CERTIFICACAO_NOT_FOUND);
	}
}
