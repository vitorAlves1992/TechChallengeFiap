package com.fiap.techChallenge.TechChallenge.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UsuarioDTO {

    @JsonProperty
    @Email(message = "Digite um e-mail válido")
    @NotBlank(message = "O e-mail não pode ser nulo")
    private String email;

}
