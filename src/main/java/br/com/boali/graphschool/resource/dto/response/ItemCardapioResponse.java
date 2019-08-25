package br.com.boali.graphschool.resource.dto.response;

import br.com.boali.graphschool.business.model.ItemCardapio;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemCardapioResponse {
    private String titulo;
    private String desc;
    private Double valor;

    public ItemCardapioResponse(ItemCardapio item){
        this.desc = item.getDescricao();
        this.titulo = item.getTitulo();
        this.valor = item.getValor();
    }
}
