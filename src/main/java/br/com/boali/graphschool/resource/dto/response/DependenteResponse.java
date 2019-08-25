package br.com.boali.graphschool.resource.dto.response;

import br.com.boali.graphschool.business.model.Dependente;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class DependenteResponse {
    private String nome;
    private String email;
    private List<PedidosResponse> refeicoes;

    public DependenteResponse(Dependente dependente){
        this.setEmail(dependente.getUsuario().getEmail());
        this.setNome(dependente.getUsuario().getNome());
        this.setRefeicoes(dependente.getPedidos().stream().map(PedidosResponse::new).collect(Collectors.toList()));
    }
}
