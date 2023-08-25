package com.fiap.techChallenge.TechChallenge.domain.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ParentescoEnum {

    MAE(1L, "Mãe"),
    PAI(2L, "Pai"),
    CONJUGE(3L, "Conjuge"),
    IRMAO(4L, "Irmão"),
    IRMA(5L, "Irmã"),
    FILHO(6L, "Filho"),
    FILHA(7L, "Filha");

    private Long id;
    private String descricao;
    private ParentescoEnum(Long id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }

    public Long getId(){
        return this.id;
    }

    public String getDescricao(){
        return this.descricao;
    }

    public static Optional<ParentescoEnum> fromLong(Long id) {
        return Arrays.stream(ParentescoEnum.values()).filter(p -> p.getId().equals(id)).findFirst();
    }

}
