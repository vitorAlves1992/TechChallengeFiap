package com.fiap.techChallenge.TechChallenge.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter@Setter
public class EletrodomesticoForm {

    @JsonProperty
    @Min(value = 0L, message = "Valor deve ser maior do que zero")
    @NotNull
    private Long idUsuario;

    @JsonProperty
    @NotBlank(message = "Nome obrigatorio")
    private String nome;

    @JsonProperty
    @NotBlank(message = "Modelo obrigatorio")
    private String modelo;

    @JsonProperty
    private Integer potencia;
}
