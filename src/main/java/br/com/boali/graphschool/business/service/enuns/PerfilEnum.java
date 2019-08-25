package br.com.boali.graphschool.business.service.enuns;

import lombok.Getter;

public enum PerfilEnum {
    DEPENDENTES(1L),
    REPRESENTANTES(2L),
    PARCEIROS(3L);

    @Getter
    private Long code;

    PerfilEnum(Long code) {
        this.code = code;
    }
}
