package br.com.boali.graphschool.resource.api;

import br.com.boali.graphschool.resource.dto.request.RepresentanteRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/cadastro-representantes")
@CrossOrigin
public interface CadastroRepresentanteControllerAPI {
    @PostMapping
    void cadastroRepresentante(@RequestBody RepresentanteRequest request);
}
