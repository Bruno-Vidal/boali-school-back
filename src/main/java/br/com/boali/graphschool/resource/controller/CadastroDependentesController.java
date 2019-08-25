package br.com.boali.graphschool.resource.controller;

import br.com.boali.graphschool.business.service.DependentesService;
import br.com.boali.graphschool.resource.api.CadastroDependentesControllerAPI;
import br.com.boali.graphschool.resource.dto.request.DependenteRequest;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CadastroDependentesController implements CadastroDependentesControllerAPI {

    private DependentesService dependentesService;

    public CadastroDependentesController(DependentesService dependentesService) {
        this.dependentesService = dependentesService;
    }


    @Override
    public void cadastroDependentes(DependenteRequest request) throws IOException {
        dependentesService.cadastrar(request);
    }
}
