/**
 * 
 */
package com.painel.exception;


import com.painel.enums.ErrorCode;

/**
 * @author A0051460
 *
 */
public class FormatUFException extends PainelException {

private static final long serialVersionUID = 1L;
	
	public FormatUFException() {
		super(ErrorCode.FORMAT_UF);
	}
}
