package com.fiap.techChallenge.TechChallenge.controller.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

@Getter@Setter
public class PessoaForm {
    @JsonProperty
    private Integer idUsuario;
    @JsonProperty
    private Integer id;
    @JsonProperty
    private String nome;
    @JsonProperty
    private Date dataNascimento;
    @JsonProperty
    private Character sexo;
    @JsonProperty
    private String parentesco;


}
