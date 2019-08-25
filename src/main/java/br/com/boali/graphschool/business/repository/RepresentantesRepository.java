package br.com.boali.graphschool.business.repository;

import br.com.boali.graphschool.business.model.Representante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepresentantesRepository extends JpaRepository<Representante,Long> {
}
