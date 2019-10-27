/**
 * 
 */
package com.painel.exception;


import com.painel.enums.ErrorCode;

/**
 * @author A0051460
 *
 */
public class FormatBairroException extends PainelException {

private static final long serialVersionUID = 1L;
	
	public FormatBairroException() {
		super(ErrorCode.FORMAT_BAIRRO_MUNICPIO);
	}
}
