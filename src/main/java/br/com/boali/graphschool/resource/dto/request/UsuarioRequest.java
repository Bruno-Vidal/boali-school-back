package br.com.boali.graphschool.resource.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioRequest {
    private String email;
    private String senha;
    private String nome;
}
