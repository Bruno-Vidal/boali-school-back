package br.com.boali.graphschool.resource.controller;


import br.com.boali.graphschool.business.service.LoginService;
import br.com.boali.graphschool.resource.api.LoginControllerAPI;
import br.com.boali.graphschool.resource.dto.request.LoginRequest;
import br.com.boali.graphschool.resource.dto.response.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController implements LoginControllerAPI {

	private LoginService loginService;

	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public ResponseEntity<TokenResponse> autenticar(LoginRequest form) {
		return ResponseEntity.ok(loginService.autenticar(form));
	}
	
}
