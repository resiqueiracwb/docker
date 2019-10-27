/**
 * 
 */
package com.painel.exception;


import com.painel.enums.ErrorCode;

/**
 * @author A0051460
 *
 */
public class PredioNotFoundException extends PainelException {

	private static final long serialVersionUID = 1L;
	
	public PredioNotFoundException() {
		super(ErrorCode.PREDIO_NOT_FOUND);
	}

}