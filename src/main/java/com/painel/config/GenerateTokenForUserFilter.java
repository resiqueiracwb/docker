package com.painel.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.painel.model.OperationResponse;
import com.painel.model.SessionItem;
import com.painel.model.SessionResponse;
import com.painel.service.impl.TokenUtil;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GenerateTokenForUserFilter extends AbstractAuthenticationProcessingFilter {

    private TokenUtil tokenUtil;

	protected GenerateTokenForUserFilter(String urlMapping, AuthenticationManager authenticationManager,TokenUtil tokenUtil) {
		super(new AntPathRequestMatcher(urlMapping));
		setAuthenticationManager(authenticationManager);
		this.tokenUtil = tokenUtil;
	}

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException, JSONException {
        try {
            String jsonString = IOUtils.toString(request.getInputStream(), "UTF-8");
            JSONObject userJSON = new JSONObject(jsonString);
            String username = userJSON.getString("username");
            String password = userJSON.getString("password");
            Collection<? extends GrantedAuthority> authorities = null ;
            final UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password, authorities);
            return getAuthenticationManager().authenticate(authToken); // This will take to successfulAuthentication or faliureAuthentication function
        } catch (JSONException | AuthenticationException e) {
            throw new AuthenticationServiceException(e.getMessage());
        }
    }

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication authToken) throws IOException, ServletException {
		SecurityContextHolder.getContext().setAuthentication(authToken);

		User user = (User) authToken.getPrincipal();
		SessionResponse resp = new SessionResponse();
		SessionItem respItem = new SessionItem();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String tokenString = this.tokenUtil.createTokenForUser(user);

		user.getAuthorities().forEach(auth ->{
			respItem.setPermissao(auth.getAuthority());
		});

		respItem.setEmail(user.getUsername());
		respItem.setToken(tokenString);


		resp.setOperationStatus(OperationResponse.ResponseStatusEnum.SUCCESS);
		resp.setOperationMessage("Login Success");
		resp.setItem(respItem);
		String jsonRespString = ow.writeValueAsString(resp);

		res.setStatus(HttpServletResponse.SC_OK);
		res.getWriter().write(jsonRespString);
		res.getWriter().flush();
		res.getWriter().close();

	}
}
