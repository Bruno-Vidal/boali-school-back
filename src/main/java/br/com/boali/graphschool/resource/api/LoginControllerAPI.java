package br.com.boali.graphschool.resource.api;


import br.com.boali.graphschool.resource.dto.request.LoginRequest;
import br.com.boali.graphschool.resource.dto.response.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/login")
@CrossOrigin
public interface LoginControllerAPI {

    @PostMapping
    ResponseEntity<TokenResponse> autenticar(@RequestBody @Valid LoginRequest form);
}
