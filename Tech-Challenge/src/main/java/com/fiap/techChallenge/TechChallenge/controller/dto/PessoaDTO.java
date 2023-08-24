package com.fiap.techChallenge.TechChallenge.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter@Setter
public class PessoaDTO {
    @JsonProperty
    @Min(value = 1, message = "Id do usuario deve ser maior do que zero")
    @NotNull
    private Long idUsuario;

    @JsonProperty
    @Min(value = 1, message = "Id do usuario deve ser maior do que zero")
    @NotNull
    private Long idEndereco;

    @JsonProperty
    @NotBlank(message = "Nome obrigatorio")
    private String nome;

    @JsonProperty
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @NotNull(message = "Data de nascimento obrigatorio")
    @Past(message = "A data de nascimento nao pode ser maior ou igual a data atual")
    private LocalDate dataNascimento;

    @JsonProperty
    //@TODO validar a string sexo somente M ou N
    @NotNull(message = "Sexo obrigatorio")
    private String sexo;
}
