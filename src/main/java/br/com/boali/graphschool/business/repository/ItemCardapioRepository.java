package br.com.boali.graphschool.business.repository;

import br.com.boali.graphschool.business.model.ItemCardapio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio,Long> {
}
