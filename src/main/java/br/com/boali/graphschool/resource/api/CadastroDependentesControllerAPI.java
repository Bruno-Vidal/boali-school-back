package br.com.boali.graphschool.resource.api;

import br.com.boali.graphschool.resource.dto.request.DependenteRequest;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@RequestMapping("/cadastro-dependentes")
@CrossOrigin
public interface CadastroDependentesControllerAPI {

    @PostAuthorize("hasRole('ROLE_BANANA')")
    @PostMapping
    void cadastroDependentes(@RequestBody DependenteRequest request) throws IOException;
}
