package com.fiap.techChallenge.TechChallenge.domain.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ParentescoEnum {

    PAIS(1L, "Mãe"),
    CONJUGE(2L, "Conjuge"),
    IRMAOS(3L, "Irmãos"),
    FILHOS(4L, "Filhos");


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
