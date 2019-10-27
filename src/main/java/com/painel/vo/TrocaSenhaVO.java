/**
 * 
 */
package com.painel.vo;

import lombok.Data;


@Data
public class TrocaSenhaVO {

	private String token;
	private String novaSenha;
	private String confirmaSenha;

	public TrocaSenhaVO(String token, String novaSenha, String confirmaSenha) {
		this.token = token;
		this.novaSenha = novaSenha;
		this.confirmaSenha = confirmaSenha;
	}

}
