/**
 * 
 */
package com.painel.exception;


import com.painel.enums.ErrorCode;

/**
 * @author A0051460
 *
 */
public class FormatMunicipioException extends PainelException {

private static final long serialVersionUID = 1L;
	
	public FormatMunicipioException() {
		super(ErrorCode.FORMAT_COD_MUNICPIO);
	}
}
