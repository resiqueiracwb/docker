package com.painel.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.painel.model.OperationResponse;
import com.painel.model.SessionItem;
import com.painel.model.SessionResponse;
import com.painel.model.Usuario;
import com.painel.repository.IUsuarioRepository;
import com.painel.security.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = {"Login"})
public class SessionController {

    @Autowired
    private IUsuarioRepository userRepo;

    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);


    @ApiResponses(value = {@ApiResponse(code = 200, message = "Irá retornar os dados do usuários bem  como o token para uso - O login da aplicação é feito pelo SPRING", response = SessionResponse.class)})
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SessionResponse newSession(@RequestBody Login login, HttpServletRequest request, HttpServletResponse response) {

        logger.info("newSession- Iniciando uma nova sessão para o usuário: " + login.getUsername());
        System.out.println("Login: " + login.getUsername());
        Usuario user = userRepo.findOneByEmailAndPassword(login.getUsername(), login.getPassword()).orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado para o  email: " + login.getUsername()));
        System.out.println("Usuario retornado: " + user.getNome());
        SessionResponse resp = new SessionResponse();
        SessionItem sessionItem = new SessionItem();
        if (user != null) {
            sessionItem.setToken("xxx.xxx.xxx");
            sessionItem.setEmail(user.getEmail());

            resp.setOperationStatus(OperationResponse.ResponseStatusEnum.SUCCESS);
            resp.setOperationMessage("Dummy Login Success");
            resp.setItem(sessionItem);
        } else {
            resp.setOperationStatus(OperationResponse.ResponseStatusEnum.ERROR);
            resp.setOperationMessage("Login Failed");
        }

        logger.info("newSession- Retornando uma nova sessão para o usuário: " + login.getUsername());

        System.out.println("RESPs: " + resp);

        return resp;
    }

}
