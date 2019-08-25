package br.com.boali.graphschool.business.repository;

import br.com.boali.graphschool.business.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido,Long> {
}
