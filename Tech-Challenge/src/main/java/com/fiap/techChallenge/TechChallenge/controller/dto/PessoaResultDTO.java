package com.fiap.techChallenge.TechChallenge.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter@Setter
public class PessoaResultDTO {
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

    public PessoaResultDTO() {
    }

    public PessoaResultDTO(Pessoa pessoa) {
        this.idUsuario = pessoa.getIdUsuario();
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
        this.sexo = pessoa.getSexo();
        this.parentesco = pessoa.getParentesco();
    }
}
