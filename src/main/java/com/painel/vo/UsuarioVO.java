package com.painel.vo;

import com.painel.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class UsuarioVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String senha;
    private GrupoVO grupoVO;
    private boolean isActive;

    public UsuarioVO(String name, Long id) {
        this.nome = name;
        this.id = id;
    }

    public UsuarioVO(Usuario user) {

        if (user != null) {
            this.id = user.getId();
            this.nome = user.getNome();
            this.isActive = user.isActive();
            this.telefone = user.getTelefone();
            this.email = user.getEmail();
            this.senha = user.getPassword();

            if (user.getGrupo() != null) {
                this.grupoVO = new GrupoVO(user.getGrupo());
            }

        }
    }

    public UsuarioVO() {
    }
}
