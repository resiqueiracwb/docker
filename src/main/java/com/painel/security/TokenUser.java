package com.painel.security;

import com.painel.model.Usuario;
import com.painel.vo.LoginVO;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class TokenUser extends User {
    private Usuario usuario;

    private LoginVO loginVO;

    public TokenUser(LoginVO loginVO) {
        super(String.valueOf(loginVO.getId()), loginVO.getPassword(), AuthorityUtils.createAuthorityList(loginVO.getRoles()));
        this.loginVO = loginVO;
    }

    public Usuario getUser() {
        return usuario;
    }

    public String getRole() {
        return usuario.getGrupo().toString();
    }

    public LoginVO getLoginVO() {
        return loginVO;
    }
}
