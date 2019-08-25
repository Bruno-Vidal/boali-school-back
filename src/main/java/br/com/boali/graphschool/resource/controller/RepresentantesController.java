package br.com.boali.graphschool.resource.controller;

import br.com.boali.graphschool.business.service.RepresentanteService;
import br.com.boali.graphschool.config.security.TokenService;
import br.com.boali.graphschool.resource.api.RepresentantesControllerAPI;
import br.com.boali.graphschool.resource.dto.response.DependenteResponse;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RepresentantesController implements RepresentantesControllerAPI {

    private RepresentanteService representanteService;
    private TokenService tokenService;

    public RepresentantesController(RepresentanteService representanteService, TokenService tokenService) {
        this.representanteService = representanteService;
        this.tokenService = tokenService;
    }

    @Override
    public List<DependenteResponse> buscarDependentes() {
        Long idUsuario = tokenService.getIdUsuario();
        return representanteService.buscarDependentes(idUsuario);
    }
}
