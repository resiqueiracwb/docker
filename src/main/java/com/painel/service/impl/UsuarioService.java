package com.painel.service.impl;

import java.util.UUID;
import com.painel.model.Grupo;
import com.painel.model.Token;
import com.painel.model.Usuario;
import com.painel.repository.ITokenRepository;
import com.painel.repository.IUsuarioRepository;
import com.painel.util.PasswordEncolder;
import com.painel.vo.TrocaSenhaVO;
import com.painel.vo.UsuarioVO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.painel.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UsuarioService  implements IUserService {

    private static Logger logger = LogManager.getLogger(UsuarioService.class);

    static final long ONE_MINUTE_IN_MILLIS = 60000;

    @Autowired
    private IUsuarioRepository userRepo;

    @Autowired
    private ITokenRepository tokenRepository;


    @Override
    public String getLoggedInUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return "nosession";
        }
        return auth.getName();
    }

    @Override
    public Usuario getLoggedInUser() {
        Long loggedInUserId = Long.parseLong(this.getLoggedInUserId());
        Usuario user = this.getUserInfoByUserId(loggedInUserId);
        return user;
    }

    @Override
    public Usuario getUserInfoByUserId(Long userId) {

        Usuario user = this.userRepo.findById(userId).orElseGet(() -> new Usuario());
        return user;
    }

    @Override
    public boolean insertOrSaveUser(Usuario user) {
        this.userRepo.save(user);
        return true;
    }

    @Override
    public void addNewUser(UsuarioVO userVO) {

        logger.info("addNewUser - endPoint para atualizar ou inserir novo usuário - Init");

        Usuario user = new Usuario();

        user.setActive(true);
        user.setNome(userVO.getNome());

        user.setPassword("asdsadsadsa");
        user.setPassword("asdasadasdsa");

        user.setEmail(userVO.getEmail());


        Grupo group = new Grupo();
        group.setId(userVO.getGrupoVO().getId());

        user.setGrupo(group);

        this.insertOrSaveUser(user);

        logger.info("addNewUser - endPoint para atualizar ou inserir novo usuário - Fim");

    }


    @Override
    public void atualizaSenha(TrocaSenhaVO trocaSenhaVO) {

        logger.info("atualizaSenha - Serviço atualizar nova senha - Init");

        String novaSenha = trocaSenhaVO.getNovaSenha();
        String confirmaSenha = trocaSenhaVO.getConfirmaSenha();

        if (novaSenha.equals(confirmaSenha)) {

            Token token = tokenRepository.findOneByToken(trocaSenhaVO.getToken()).orElseThrow(() -> new UsernameNotFoundException("Token inválido: " + trocaSenhaVO.getToken()));

            if (token.getToken() != null) {

                Date dataAtual = new Date();

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                sdf.format(dataAtual);
                sdf.format(token.getDtExpiracao());

                System.out.println(dataAtual + "," + token.getDtExpiracao());

                //if ((token.getDtExpiracao()).after(dataAtual) && token.isActive()) {

                if (token.isActive()) {

                    Usuario user = userRepo.findOneByEmail(token.getEmail()).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado para o  email: " + token.getEmail()));

                    if (user.getId() != 0) {

                        user.setPassword(PasswordEncolder.encodePass(trocaSenhaVO.getNovaSenha()));


                        token.setActive(false);

                        this.tokenRepository.save(token);
                        this.userRepo.save(user);

                    }

                }

            }

        }

        logger.info("atualizaSenha - Serviço atualizar nova senha - End");
    }

    @Override
    public List<UsuarioVO> findUserByEmail(UsuarioVO userVO) {

        logger.info("findUserByEmail - Serviço para buscar usuário por email - Init");

        List<Usuario> listUsuarios = userRepo.findByEmailOrNomeContaining(userVO.getEmail(), userVO.getNome()).orElse(new ArrayList<Usuario>());

        List<UsuarioVO> usuariosVO = new ArrayList<UsuarioVO>();

        listUsuarios.forEach(user -> {
            usuariosVO.add(new UsuarioVO(user));
        });

        logger.info("findUserByEmail - Serviço para buscar usuário por email - End");
        return usuariosVO;
    }

    @Override
    public String delete(Long id) {

        Usuario user = userRepo.findById(id).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado para o  id: " + id));

        if (user.getId() != 0) {

            user.setActive(false);

            this.userRepo.save(user);

            return "Usuário " + user.getNome() + " excluido com sucesso!";

        } else {

            return "Falha ao excluir usuário!";

        }

    }

    @Override
    public UsuarioVO findById(Long id) {
        return new UsuarioVO(userRepo.findById(id).orElse(null));
    }

    @Override
    public void sendEmailResetSenha(String email) {

        logger.info("sendEmail - Serviço para envio de email de reset de senha - Init");


        Usuario user = userRepo.findOneByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Email " + email + " não encontrado em nossos registros."));
        if (user.getId() != 0) {

            Calendar date = Calendar.getInstance();
            long t = date.getTimeInMillis();
            Date dataExpiracao = new Date(t + (90 * ONE_MINUTE_IN_MILLIS));

            Token token = new Token();
            token.setToken(UUID.randomUUID().toString());
            token.setEmail(user.getEmail());
            token.setDtInsercao(new Date());
            token.setDtExpiracao(dataExpiracao);
            token.setActive(true);

            this.tokenRepository.save(token);


        } else {

            logger.info("Email " + email + " não encontrado em nossos registros.");

        }

        logger.info("sendEmail - Serviço para envio de email de reset de senha - Fim");

    }
}
