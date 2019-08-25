package br.com.boali.graphschool.config.beans;

import br.com.boali.graphschool.business.model.Dependente;
import br.com.boali.graphschool.business.model.ItemCardapio;
import br.com.boali.graphschool.business.model.Pedido;
import br.com.boali.graphschool.business.model.Representante;
import br.com.boali.graphschool.business.model.Usuario;
import br.com.boali.graphschool.business.repository.DependentesRepository;
import br.com.boali.graphschool.business.repository.ItemCardapioRepository;
import br.com.boali.graphschool.business.repository.PedidoRepository;
import br.com.boali.graphschool.business.repository.RepresentantesRepository;
import br.com.boali.graphschool.business.repository.UsuarioRepository;
import br.com.boali.graphschool.business.service.PerfilFactory;
import br.com.boali.graphschool.business.service.enuns.PerfilEnum;
import br.com.boali.graphschool.resource.dto.enums.StatusPedido;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.Date;

@Configuration
@Profile("test")
public class MockData {

    private UsuarioRepository repository;
    private RepresentantesRepository representantesRepository;
    private DependentesRepository dependentesRepository;
    private PerfilFactory perfilFactory;
    private ItemCardapioRepository itemCardapioRepository;
    private PedidoRepository pedidoRepository;

    public MockData(UsuarioRepository repository, RepresentantesRepository representantesRepository, DependentesRepository dependentesRepository, PerfilFactory perfilFactory, ItemCardapioRepository itemCardapioRepository, PedidoRepository pedidoRepository){
        this.repository = repository;
        this.representantesRepository = representantesRepository;
        this.dependentesRepository = dependentesRepository;
        this.perfilFactory = perfilFactory;
        this.itemCardapioRepository = itemCardapioRepository;
        this.pedidoRepository = pedidoRepository;
        startCardapio();
        startData();
    }

    private void startCardapio() {
        itemCardapioRepository.save(ItemCardapio
                .builder()
                    .descricao("Mix Brasil, fusilli integral com azeite e ervas, tomate cereja e ricota temperada.\n" +
                            "Você escolhe a proteína (filet de frango, falafel, carne desfiada, filet de salmão) e o molho (apimentado, árabe, balsâmico, caesar, italiano, mil ilhas, mostarda e mel, oriental)")
                    .titulo("Bowl fusilli integral")
                    .valor(18.50)
                .build());
        itemCardapioRepository.save(ItemCardapio
                .builder()
                .descricao("Filet de frango desfiado, parmesao, croutons integrais e molho caesar.\n" +
                        "Acompanha saladinha com granola ou chips. Pode ser quente (com cream cheese) ou fresco (com folhas)")
                .titulo("Wrap frango caesar")
                .valor(24.50)
                .build());
        itemCardapioRepository.save(ItemCardapio
                .builder()
                .descricao("requeijao, parmesão, cebola crocante, molho apimentado")
                .titulo("Burrito carne")
                .valor(22.30)
                .build());
        itemCardapioRepository.save(ItemCardapio
                .builder()
                .descricao("Atum em pedaços, cebola roxa, ovo de codorna, requeijão light e molho apimentado.\n" +
                        "Acompanha saladinha com granola ou chips. São feitos com massa integral.")
                .titulo("Crepe de atum apimentado")
                .valor(26.70)
                .build());
        itemCardapioRepository.save(ItemCardapio
                .builder()
                .descricao("Miz verdes, atum, fusilli integral, ricota temperada, tomate cereja, azeitona, amêndoas, molho mostarda e mel.")
                .titulo("Salada sem desculpa")
                .valor(22.30)
                .build());

    }

    private void startData() {
        massaBruno();
    }

    private void massaBruno() {
        Usuario bruno = Usuario.builder()
                                        .email("kitokoioto@gmail.com")
                                        .nome("Bruno Vidal")
                                    .build();
        bruno.setSenha("kitokoioto22");
        bruno.setPerfis(Arrays.asList(perfilFactory.buscarPerfil(PerfilEnum.REPRESENTANTES)));
        repository.saveAndFlush(bruno);
        Representante repBruno = new Representante(bruno);
        representantesRepository.save(repBruno);

        Usuario leia = Usuario.builder()
                .email("leia@email.com")
                .nome("Leia Vidal")
                .build();
        leia.setSenha("kitokoioto22");
        repository.saveAndFlush(leia);
        leia.setPerfis(Arrays.asList(perfilFactory.buscarPerfil(PerfilEnum.DEPENDENTES)));
        Dependente depLeia = new Dependente(leia);
        depLeia.setFoto("foto leia");
        depLeia.setRepresentante(repBruno);
        depLeia.setDataNascimento(new Date());

        Pedido pedido = new Pedido();
        pedido.setDataAgendada(new Date(System.currentTimeMillis()));
        pedido.setDependente(depLeia);
        pedido.setStatus(StatusPedido.A_CAMINHO);
        pedido.setItens(itemCardapioRepository.findAllById(Arrays.asList(1L,2L,3L)));
        pedidoRepository.saveAndFlush(pedido);


        dependentesRepository.save(depLeia);


    }
}
