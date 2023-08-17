package com.fiap.techChallenge.TechChallenge.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.techChallenge.TechChallenge.domain.Eletrodomestico;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EletrodomesticoResultDTO {


    @JsonProperty
    private Long id;

    @JsonProperty
    private String nome;

    @JsonProperty
    private String modelo;

    @JsonProperty
    private Double potencia;

    @JsonProperty
    private Long idUsuario;

    public EletrodomesticoResultDTO(Eletrodomestico eletrodomestico) {
        this.id = eletrodomestico.getId();
        this.nome = eletrodomestico.getNome();
        this.modelo = eletrodomestico.getModelo();
        this.potencia = eletrodomestico.getPotencia();
        this.idUsuario = eletrodomestico.getUsuario().getId();
    }
}
