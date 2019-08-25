package br.com.boali.graphschool.business.service;

import br.com.boali.graphschool.business.model.Usuario;
import br.com.boali.graphschool.config.security.TokenService;
import br.com.boali.graphschool.resource.dto.request.LoginRequest;
import br.com.boali.graphschool.resource.dto.response.TokenResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class LoginService {

    private AuthenticationManager authManager;
    private TokenService tokenService;

    public LoginService(AuthenticationManager authManager, TokenService tokenService) {
        this.authManager = authManager;
        this.tokenService = tokenService;
    }

    public TokenResponse autenticar(LoginRequest form) {
        UsernamePasswordAuthenticationToken dadosLogin = form.converter();
        Authentication authentication = authManager.authenticate(dadosLogin);
        String token = tokenService.gerarToken(authentication);
        Usuario logado = (Usuario) authentication.getPrincipal();
        return TokenResponse
                .builder()
                .role(logado.getPerfis().stream().findFirst().orElseThrow(EntityNotFoundException::new).getRole())
                .nome(logado.getNome())
                .token(token)
                .build();
    }

}
