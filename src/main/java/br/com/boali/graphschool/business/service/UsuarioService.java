package br.com.boali.graphschool.business.service;

import br.com.boali.graphschool.business.model.Usuario;
import br.com.boali.graphschool.business.repository.UsuarioRepository;
import br.com.boali.graphschool.business.service.enuns.PerfilEnum;
import br.com.boali.graphschool.resource.dto.request.UsuarioRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class UsuarioService {
    private PerfilFactory perfilFactory;
    private UsuarioRepository usuarioRepository;

    public UsuarioService(PerfilFactory perfilFactory, UsuarioRepository usuarioRepository) {
        this.perfilFactory = perfilFactory;
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional
    public Usuario cadastrar(UsuarioRequest request,PerfilEnum perfil) {
        Usuario usuario =  new Usuario();
        usuario.setEmail(request.getEmail());
        usuario.setNome(request.getNome());
        usuario.setPerfis(Arrays.asList(perfilFactory.buscarPerfil(perfil)));
        usuario.setSenha(request.getSenha());
        usuarioRepository.saveAndFlush(usuario);
        return usuario;
    }
}
