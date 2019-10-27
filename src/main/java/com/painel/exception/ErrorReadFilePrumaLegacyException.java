/**
 * 
 */
package com.painel.exception;


import com.painel.enums.ErrorCode;

/**
 * @author renato
 *
 */
public class ErrorReadFilePrumaLegacyException   extends PainelException {

	private static final long serialVersionUID = 1L;
	
	public ErrorReadFilePrumaLegacyException() {
		super(ErrorCode.ERRO_LER_ARQUIVO_LEGADO);
	}

}