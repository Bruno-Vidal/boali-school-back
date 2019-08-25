package br.com.boali.graphschool.business.service;

import br.com.boali.graphschool.business.model.Representante;
import br.com.boali.graphschool.business.model.Usuario;
import br.com.boali.graphschool.business.repository.RepresentantesRepository;
import br.com.boali.graphschool.business.service.enuns.PerfilEnum;
import br.com.boali.graphschool.resource.dto.request.RepresentanteRequest;
import br.com.boali.graphschool.resource.dto.response.DependenteResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepresentanteService {
    private UsuarioService usuarioService;
    private RepresentantesRepository representantesRepository;
    public RepresentanteService(UsuarioService usuarioService, RepresentantesRepository representantesRepository) {
        this.usuarioService = usuarioService;
        this.representantesRepository = representantesRepository;
    }

    @Transactional
    public void cadastrar(RepresentanteRequest request) {
        Usuario usuario = usuarioService.cadastrar(request, PerfilEnum.REPRESENTANTES);
        Representante representante = new Representante(usuario);
        representante.setUsuario(usuario);
        representantesRepository.save(representante);
    }

    public List<DependenteResponse> buscarDependentes(Long userId) {
        return representantesRepository
                                .findById(userId)
                                .orElseThrow(EntityNotFoundException::new)
                                .getDependentes()
                                        .stream()
                                                .map(DependenteResponse::new)
                                .collect(Collectors.toList());
    }
}
