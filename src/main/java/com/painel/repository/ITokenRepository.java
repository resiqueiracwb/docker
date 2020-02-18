/**
 * 
 */
package com.painel.repository;

import java.util.Optional;

import com.painel.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ITokenRepository extends JpaRepository<Token, Long> {

	Optional<Token> findOneByToken(String Token);

}
