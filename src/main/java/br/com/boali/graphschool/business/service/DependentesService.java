package br.com.boali.graphschool.business.service;

import br.com.boali.graphschool.business.model.Dependente;
import br.com.boali.graphschool.business.model.Representante;
import br.com.boali.graphschool.business.model.Usuario;
import br.com.boali.graphschool.business.repository.DependentesRepository;
import br.com.boali.graphschool.business.repository.RepresentantesRepository;
import br.com.boali.graphschool.business.service.enuns.PerfilEnum;
import br.com.boali.graphschool.config.security.TokenService;
import br.com.boali.graphschool.resource.dto.request.DependenteRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.io.IOException;

@Service
public class DependentesService {

    private UsuarioService usuarioService;
    private DependentesRepository dependentesRepository;
    private TokenService tokenService;
    private RepresentantesRepository representantesRepository;

    public DependentesService(UsuarioService usuarioService, DependentesRepository dependentesRepository, TokenService tokenService, RepresentantesRepository representantesRepository) {
        this.usuarioService = usuarioService;
        this.dependentesRepository = dependentesRepository;
        this.tokenService = tokenService;
        this.representantesRepository = representantesRepository;
    }

    @Transactional
    public void cadastrar(DependenteRequest request) throws IOException {
        Usuario usuario = usuarioService.cadastrar(request, PerfilEnum.DEPENDENTES);
        Dependente dependente = new Dependente(usuario);
        dependente.setDataNascimento(request.getDataNasciento());
        dependente.setFoto(request.getFoto());
        Representante representante = representantesRepository.findById(tokenService.getIdUsuario()).orElseThrow(EntityExistsException::new);
        dependente.setRepresentante(representante);
        dependentesRepository.save(dependente);
    }
}
