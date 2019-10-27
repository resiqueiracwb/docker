/**
 * 
 */
package com.painel.exception;

import com.painel.enums.ErrorCode;


public class PainelException extends Exception implements IPainelException {
	private static final long serialVersionUID = 1L;

	private ErrorCode errorCode;

	private String activitiErrorCode;

	public PainelException(String message) {
		super(message);
	}

	public PainelException(Exception e) {
		super(e);
	}

	public PainelException(String message, Throwable cause) {
		super(message, cause);
	}

	public PainelException() {
		super();
	}

	public PainelException(ErrorCode errorCode) {
		super(errorCode.getDescription());
		this.errorCode = errorCode;

	}

	public PainelException(ErrorCode errorCode, Throwable cause) {
		super(errorCode.getDescription(), cause);
		this.errorCode = errorCode;

	}

	public PainelException(ErrorCode errorCode, String message) {
		super(errorCode.getDescription() + " - " + message);
		this.errorCode = errorCode;

	}

	public PainelException(String errorCode, String message) {
		super(message);
		this.activitiErrorCode = errorCode;

	}

	public PainelException(Throwable cause) {
		super(cause);
	}


	public ErrorCode getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString() {
		if (this.errorCode != null) {
			return "Erro: " + this.errorCode.getCode() + " -> " + this.errorCode.getDescription();
		} else {
			return "Erro!";
		}
	}
	public String getActivitiErrorCode() {
		return activitiErrorCode;
	}

}