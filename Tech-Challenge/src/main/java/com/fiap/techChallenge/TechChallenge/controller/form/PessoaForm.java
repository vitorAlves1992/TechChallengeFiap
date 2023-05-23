package com.fiap.techChallenge.TechChallenge.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

//@TODO validar dados e jogar mensagens de erro

//@TODO criar form para enviar (sem id) e para response (com id)

@Getter@Setter
public class PessoaForm {
    @JsonProperty
    private Integer idUsuario;
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String nome;
    @JsonProperty
    private LocalDate dataNascimento;
    @JsonProperty
    private String sexo;
    @JsonProperty
    private String parentesco;


}
