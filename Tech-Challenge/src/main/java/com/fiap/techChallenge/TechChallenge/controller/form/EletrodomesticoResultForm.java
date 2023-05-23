package com.fiap.techChallenge.TechChallenge.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EletrodomesticoResultForm {
    @JsonProperty
    private Integer idUsuario;
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String nome;
    @JsonProperty
    private String modelo;
    @JsonProperty
    private Integer potencia;
}
