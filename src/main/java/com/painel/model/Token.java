/**
 * 
 */
package com.painel.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author 80649152
 *
 */

@Data
@Entity
@Table(name = "Token")
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "token_seq")
    @SequenceGenerator(name = "token_seq", sequenceName = "token_seq", allocationSize = 1)	
	@Column(name = "id")
	private int id;

	@Column(name = "token")
	private String token;

	@Column(name = "email")
	private String email;

	@Column(name = "dt_insercao")
	private Date dtInsercao;

	@Column(name = "dt_expiracao")
	private Date dtExpiracao;

	@Column(name = "active")
	private boolean active;

}
