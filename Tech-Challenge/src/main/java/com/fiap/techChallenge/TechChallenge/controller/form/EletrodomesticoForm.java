package com.fiap.techChallenge.TechChallenge.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter@Setter
public class EletrodomesticoForm {

    @JsonProperty
    @NotNull(message = "O ID do usuário não pode ser nulo")
    @Min(value = 1, message = "O ID do usuário deve ser maior que 0")
    private Long idUsuario;

    @JsonProperty
    @NotBlank(message = "Nome obrigatorio")
    private String nome;

    @JsonProperty
    @NotBlank(message = "Modelo obrigatorio")
    private String modelo;

    @JsonProperty
    @Digits(integer = 4, fraction = 2, message = "Potencia deve ter no máximo 4 digitos e 2 casas decimais")
    @NotNull(message = "Potencia obrigatorio")
    @Positive(message = "Potencia deve ser maior que 0")
    private Double potencia;
}
