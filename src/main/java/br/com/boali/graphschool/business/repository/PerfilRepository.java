package br.com.boali.graphschool.business.repository;

import br.com.boali.graphschool.business.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<Perfil,Long> {
}
