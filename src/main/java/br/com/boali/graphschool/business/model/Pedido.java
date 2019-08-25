package br.com.boali.graphschool.business.model;

import br.com.boali.graphschool.resource.dto.enums.StatusPedido;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.Date;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(exclude = {"itens"})
public class Pedido {
    public Pedido(){
        this.valor = 0.0;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "pedidos_seq")
    @SequenceGenerator(name = "pedidos_seq", sequenceName = "PEDIDOS_SEQ",allocationSize = 3,initialValue = 15467)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "depedente_id")
    private Dependente dependente;



    private Double valor;

    @Enumerated(value = EnumType.STRING)
    private StatusPedido status;

    @OneToMany
    private List<ItemCardapio> itens;

    private Date dataAgendada;

    private void calcValor() {
        this.itens.forEach(itemCardapio -> valor+=itemCardapio.getValor());
    }

    public void setItens(List<ItemCardapio> itens) {
        this.itens = itens;
        this.calcValor();
    }
}
