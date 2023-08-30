package com.fiap.techChallenge.TechChallenge.controller.dto.eletrodomestico;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EletrodomesticoConsumoDTO {

    @JsonProperty
    private Double consumo;

    public EletrodomesticoConsumoDTO(Double consumo) {
        this.consumo = consumo;
    }

    public EletrodomesticoConsumoDTO() {
    }
}
