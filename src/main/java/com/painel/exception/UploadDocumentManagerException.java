/**
 * 
 */
package com.painel.exception;


import com.painel.enums.ErrorCode;

/**
 * @author renato
 *
 */
public class UploadDocumentManagerException   extends PainelException {

	private static final long serialVersionUID = 1L;
	
	public UploadDocumentManagerException() {
		super(ErrorCode.UPLOAD_REPLICA_PREDIO);
	}

}

