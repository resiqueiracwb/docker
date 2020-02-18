package com.painel.service.impl;

import com.painel.model.Usuario;
import com.painel.repository.IUsuarioRepository;
import com.painel.security.TokenUser;
import com.painel.security.UserAuthentication;
import com.painel.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Optional;
import java.util.stream.Collectors;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenUtil {private static final long VALIDITY_TIME_MS = 2 * 60 * 60 * 1000; // 2 hours  validity
    private static final String AUTH_HEADER_NAME = "Authorization";

    private String secret = "mrin";

    @Autowired
    private IUsuarioRepository userRepository;

    public Optional<Authentication> verifyToken(HttpServletRequest request) {
        final String token = request.getHeader(AUTH_HEADER_NAME);

        if (token != null && !token.isEmpty()) {
            final TokenUser user = parseUserFromToken(token.replace("Bearer", "").trim());
            if (user != null) {
                return Optional.of(new UserAuthentication(user));
            }
        }
        return Optional.empty();

    }

    //Get User Info from the Token
    public TokenUser parseUserFromToken(String token) {

        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();


        LoginVO loginVO = new LoginVO();

        String roles =  (claims.get("role").toString());
        roles = roles.replace("[", "");
        roles = roles.replace("]", "");
        roles = roles.replace("{", "");
        roles = roles.replace("}", "");

        String[] output = roles.split(",");

        loginVO.setPermissoes(roles);
        loginVO.setRoles(output);
        loginVO.setEmail((String) claims.get("sub"));
        loginVO.setPassword((String) claims.get("password"));
        Optional<Usuario> result = this.userRepository.findOneByEmail(loginVO.getEmail());

        result.ifPresent(item ->{
            loginVO.setId(item.getId());
            loginVO.setPassword(item.getPassword());
        });


        if (String.valueOf(loginVO.getId()) != null && loginVO.getRoles() != null) {
            return new TokenUser(loginVO);
        } else {
            return null;
        }
    }

    public String createTokenForUser(org.springframework.security.core.userdetails.User user) {

        final String authorities = user.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + VALIDITY_TIME_MS))
                .setSubject(user.getUsername())
                .claim("role", authorities)
                .claim("password", user.getPassword())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }


}
