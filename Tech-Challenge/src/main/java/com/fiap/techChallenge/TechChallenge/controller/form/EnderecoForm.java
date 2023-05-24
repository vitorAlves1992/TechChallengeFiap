package com.fiap.techChallenge.TechChallenge.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

//TODO fazer validacoes
@Getter
@Setter
public class EnderecoForm {

    @JsonProperty
    private String rua;

    @JsonProperty
    private Integer numero;

    @JsonProperty
    private String bairro;

    @JsonProperty
    private String cidade;

    @JsonProperty
    private String estado;

    @JsonProperty
    private Integer id;
}
