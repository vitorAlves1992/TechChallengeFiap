package com.fiap.techChallenge.TechChallenge.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class EnderecoForm {

    @JsonProperty
    @NotBlank(message = "Rua obrigatoria")
    private String rua;

    @JsonProperty
    @Min(value = 1, message = "Numero e obrigatorio e deve ser maior que zero")
    @NotNull(message = "Numero obrigatorio")
    private Integer numero;

    @JsonProperty
    @NotBlank(message = "Bairro obrigatorio")
    private String bairro;

    @JsonProperty
    @NotBlank(message = "Cidade obrigatoria")
    private String cidade;

    @JsonProperty
    @NotBlank(message = "Estado obrigatorio")
    private String estado;

    @JsonProperty
    @NotNull(message = "Id Usuario Obrigatorio")
    @Positive
    private Long idUsuario;
}
