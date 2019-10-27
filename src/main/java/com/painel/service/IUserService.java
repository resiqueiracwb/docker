package com.painel.service;

import com.painel.model.Usuario;
import com.painel.vo.TrocaSenhaVO;
import com.painel.vo.UsuarioVO;

import java.util.List;

public interface IUserService {
    public String getLoggedInUserId();
    public Usuario getLoggedInUser();
    public Usuario getUserInfoByUserId(Long userId);
    public boolean insertOrSaveUser(Usuario user);
    public void addNewUser(UsuarioVO userVO);
    public void atualizaSenha(TrocaSenhaVO trocaSenhaVO);
    public List<UsuarioVO> findUserByEmail(UsuarioVO userVO);
    public String delete(Long id);
    public UsuarioVO findById(Long id);
    public void sendEmailResetSenha(String email);
}
