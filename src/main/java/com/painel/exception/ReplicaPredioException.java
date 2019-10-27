/**
 * 
 */
package com.painel.exception;


import com.painel.enums.ErrorCode;

/**
 * @author A0051460
 *
 */
public class ReplicaPredioException  extends PainelException {

	private static final long serialVersionUID = 1L;
	
	public ReplicaPredioException() {
		super(ErrorCode.REPLICA_PREDIO);
	}

}