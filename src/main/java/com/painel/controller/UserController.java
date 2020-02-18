package com.painel.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.painel.model.OperationResponse;
import com.painel.model.SessionResponse;
import com.painel.model.UserResponse;
import com.painel.model.Usuario;
import com.painel.service.IUserService;
import com.painel.util.SwaggerDocumentation;
import com.painel.vo.UsuarioVO;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Strings;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("users")
@Api(tags = { "Users" })
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

	@Autowired
	private IUserService userService;

	@ResponseBody
	@RequestMapping(value = "/logged", method = RequestMethod.GET)
	public String getLoggedUser() {
		System.out.println(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		return "Chegou";

	}

	@ApiOperation(value = "Gets current user information", response = UserResponse.class)
	@RequestMapping(value = "/user", method = RequestMethod.GET, produces = { "application/json" })
	public UserResponse getUserInformation(@RequestParam(value = "name", required = false) String userIdParam,
			HttpServletRequest req) {

		String loggedInUserId = userService.getLoggedInUserId();

		Usuario usuario;
		boolean provideUserDetails = false;

		if (Strings.isNullOrEmpty(userIdParam)) {
			provideUserDetails = true;
			usuario = userService.getLoggedInUser();
		} else if (loggedInUserId.equals(userIdParam)) {
			provideUserDetails = true;
			usuario = userService.getLoggedInUser();
		} else {
			provideUserDetails = true;
			usuario = userService.getUserInfoByUserId(Long.parseLong(userIdParam));
		}

		UserResponse resp = new UserResponse();
		if (provideUserDetails) {
			resp.setOperationStatus(OperationResponse.ResponseStatusEnum.SUCCESS);
		} else {
			resp.setOperationStatus(OperationResponse.ResponseStatusEnum.NO_ACCESS);
			resp.setOperationMessage("No Access");
		}
		resp.setData(usuario);
		return resp;
	}

	
	@ApiOperation(value = SwaggerDocumentation.SAVE_USER_OP)
	@RequestMapping(value = "/save", method = RequestMethod.POST, produces = { "application/json" })
	public void addNewUser(@RequestBody UsuarioVO userVO) {
		
		logger.info("addNewUser - Serviço para atualizar ou inserir novo usuário - Init");
		
		this.userService.addNewUser(userVO);
		
		logger.info("addNewUser - Serviço para atualizar ou inserir novo usuário - Fim");
	}

	@ResponseBody
	@ApiOperation(value = SwaggerDocumentation.LIST_USER_BY_EMAIL_OP)
	@RequestMapping(value = "/listUserByEmail", method = RequestMethod.POST)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = SwaggerDocumentation.LIST_USER_BY_EMAIL, response = SessionResponse.class) })
	public List<UsuarioVO> listUserByEmail(@RequestBody UsuarioVO userVO) {

		logger.info("findUserByEmail - Serviço para buscar usuário por email - Init");

		return this.userService.findUserByEmail(userVO);

	}
	

	@ResponseBody
	@ApiOperation(value = SwaggerDocumentation.DELETE_USER_OP)
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = SwaggerDocumentation.DELETE_USER, response = SessionResponse.class) })
	public String delete(@RequestBody Long id) {
		logger.info("Delete - Deleta Usuário");

		return this.userService.delete(id);
	}
	
	@ResponseBody
	@RequestMapping(value = "/getById", method = RequestMethod.POST, consumes = { "application/json" })
	@ApiOperation(value = SwaggerDocumentation.LIST_USER_BY_ID_OP)
	@ApiResponses(value = {	@ApiResponse(code = 200, message = SwaggerDocumentation.LIST_USER_BY_ID, response = SessionResponse.class) })
	public UsuarioVO findUserById(@RequestBody Long id) {

		return this.userService.findById(id);

	}

}
