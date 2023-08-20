package com.fiap.techChallenge.TechChallenge.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter @Setter
public class ParenteResultDTO {

    @JsonProperty
    private Long id;

    @NotNull(message = "pessoaId não pode ser nulo.")
    @JsonProperty
    private Long pessoaId;

    @NotNull(message = "pessoaRelacionadaId não pode ser nulo.")
    @JsonProperty
    private Long pessoaRelacionadaId;

    private String parentesco;
}
