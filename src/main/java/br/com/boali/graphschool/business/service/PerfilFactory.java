package br.com.boali.graphschool.business.service;

import br.com.boali.graphschool.business.model.Perfil;
import br.com.boali.graphschool.business.repository.PerfilRepository;
import br.com.boali.graphschool.business.service.enuns.PerfilEnum;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PerfilFactory {
    private PerfilRepository perfilRepository;
    private Map<Long,Perfil> perfis;
    public PerfilFactory(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
        perfis = new HashMap<>();
        perfilRepository.findAll().forEach( perfil -> perfis.put(perfil.getId(),perfil));
    }

    public Perfil buscarPerfil(PerfilEnum perfil){
        return this.perfis.get(perfil.getCode());
    }
}
