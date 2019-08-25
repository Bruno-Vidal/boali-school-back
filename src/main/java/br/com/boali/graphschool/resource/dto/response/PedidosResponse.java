package br.com.boali.graphschool.resource.dto.response;

import br.com.boali.graphschool.business.model.ItemCardapio;
import br.com.boali.graphschool.business.model.Pedido;
import br.com.boali.graphschool.resource.dto.enums.StatusPedido;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class PedidosResponse {

    private Long numero;
    @JsonProperty("itens")
    private List<ItemCardapioResponse> item;
    private StatusPedido statusPedido;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private Date dataAgendada;

    public PedidosResponse(Pedido pedido){
         this.setDataAgendada(pedido.getDataAgendada());
         this.setStatusPedido(pedido.getStatus());
         this.setItem(pedido.getItens().stream().map(ItemCardapioResponse::new).collect(Collectors.toList()));
         this.numero = pedido.getId();
    }
}
