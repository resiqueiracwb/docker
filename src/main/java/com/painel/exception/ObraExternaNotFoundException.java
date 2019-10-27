/**
 * 
 */
package com.painel.exception;


import com.painel.enums.ErrorCode;

/**
 * @author A0051460
 *
 */
public class ObraExternaNotFoundException extends PainelException {

private static final long serialVersionUID = 1L;
	
	public ObraExternaNotFoundException() {
		super(ErrorCode.OBRA_NOT_FOUND);
	}
}
