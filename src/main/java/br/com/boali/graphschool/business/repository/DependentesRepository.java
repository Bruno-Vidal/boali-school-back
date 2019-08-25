package br.com.boali.graphschool.business.repository;

import br.com.boali.graphschool.business.model.Dependente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DependentesRepository extends JpaRepository<Dependente,Long> {
}
