package com.painel.exception;


import com.painel.enums.ErrorCode;

public class DocumentNotFoundPrumaException  extends PainelException {

	private static final long serialVersionUID = 1L;
	
	public DocumentNotFoundPrumaException() {
		super(ErrorCode.DOCUMENTO_NAO_ENCONTRADO_PRUMA);
	}

}
