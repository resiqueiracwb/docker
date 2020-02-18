package com.painel.repository;

import com.painel.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuarioRepository  extends JpaRepository<Usuario, Long> {
    @Override
    Optional<Usuario> findById(Long aLong);

    Optional<Usuario> findOneByEmail(String username);

    Optional<Usuario> findOneByEmailAndPassword(String email, String password);

    Optional<List<Usuario>> findByEmailOrNomeContaining(String email, String nome);

}
