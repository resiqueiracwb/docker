/**
 * 
 */
package com.painel.exception;


import com.painel.enums.ErrorCode;

/**
 * @author A0051460
 *
 */
public class VistoriaNotFoundException extends PainelException {

private static final long serialVersionUID = 1L;
	
	public VistoriaNotFoundException() {
		super(ErrorCode.VISTORIA_NOT_FOUND);
	}
}
