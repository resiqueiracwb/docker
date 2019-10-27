package com.painel.service.impl;

import com.painel.model.Usuario;
import com.painel.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        final Usuario usuario = this.usuarioRepository.findOneByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado para o  email: " + username));

        return new User(usuario.getEmail(), usuario.getPassword(), getAuthority(usuario));
    }

    private Set<SimpleGrantedAuthority> getAuthority(Usuario usuario) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_" + usuario.getGrupo().getNome().toUpperCase()));
        return authorities;
    }
}
