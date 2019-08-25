package br.com.boali.graphschool.business.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Representante {
    public Representante(Usuario usuario){
        this.usuario = usuario;
        this.id = usuario.getId();
    }
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    private Usuario usuario;

    @OneToMany(mappedBy = "representante")
    private List<Dependente> dependentes;
}
