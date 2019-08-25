package br.com.boali.graphschool.business.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"pedidos"})
public class Dependente {

    public Dependente(Usuario usuario){
        this.usuario = usuario;
        this.id = usuario.getId();
    }
    @Id
    private Long id;

    private String foto;

    private Date dataNascimento;

    @OneToOne
    @JoinColumn(name = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "representante_id")
    private Representante representante;

    @OneToMany(mappedBy = "dependente",cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

}
