package com.fiap.techChallenge.TechChallenge.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class UsuarioResultDTO {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String email;



}
