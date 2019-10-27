/**
 * 
 */
package com.painel.exception;


import com.painel.enums.ErrorCode;

/**
 * @author renato
 *
 */
public class DocumentNotFoundException extends PainelException {

	private static final long serialVersionUID = 1L;
	
	public DocumentNotFoundException() {
		super(ErrorCode.DOCUMENTO_NAO_ENCONTRADO);
	}

}
