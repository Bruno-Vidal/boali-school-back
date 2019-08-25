package br.com.boali.graphschool.business.repository;

import br.com.boali.graphschool.business.model.AbstractModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbstractRepository extends JpaRepository<AbstractModel, Long> {
}
