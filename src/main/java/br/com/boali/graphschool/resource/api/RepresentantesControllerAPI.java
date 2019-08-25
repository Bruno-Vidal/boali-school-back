package br.com.boali.graphschool.resource.api;

import br.com.boali.graphschool.resource.dto.response.DependenteResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/representantes")
@CrossOrigin
public interface RepresentantesControllerAPI {
    @GetMapping("/this/dependentes")
    List<DependenteResponse> buscarDependentes();
}
