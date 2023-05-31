package com.fiap.techChallenge.TechChallenge.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EnderecoForm {

    @JsonProperty
    @NotBlank(message = "Rua obrigatorio")
    private String rua;

    @JsonProperty
    @Min(value = 0L, message = "Numero e obrigatorio e deve ser maior que zero")
    @NotNull
    private Integer numero;

    @JsonProperty
    @NotBlank(message = "Bairro obrigatorio")
    private String bairro;

    @JsonProperty
    @NotBlank(message = "Cidade obrigatorio")
    private String cidade;

    @JsonProperty
    @NotBlank(message = "Estado obrigatorio")
    private String estado;
}
