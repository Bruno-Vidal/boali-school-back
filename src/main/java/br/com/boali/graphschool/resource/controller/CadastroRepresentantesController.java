package br.com.boali.graphschool.resource.controller;

import br.com.boali.graphschool.business.service.RepresentanteService;
import br.com.boali.graphschool.resource.api.CadastroRepresentanteControllerAPI;
import br.com.boali.graphschool.resource.dto.request.RepresentanteRequest;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastroRepresentantesController implements CadastroRepresentanteControllerAPI {

    private RepresentanteService representanteService;

    public CadastroRepresentantesController(RepresentanteService representanteService) {
        this.representanteService = representanteService;
    }

    @Override
    public void cadastroRepresentante(RepresentanteRequest request) {
        representanteService.cadastrar(request);
    }
}
