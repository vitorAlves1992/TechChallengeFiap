package com.fiap.techChallenge.TechChallenge.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Optional;

@Getter@Setter
public class PessoaResultDTO {
    @JsonProperty
    private Long id;
    @JsonProperty
    private String nome;
    @JsonProperty
    private LocalDate dataNascimento;
    @JsonProperty
    private String sexo;
    @JsonProperty
    private Long idUsuario;
    @JsonProperty
    private EnderecoResultDTO endereco;
    public PessoaResultDTO() {
    }

    public PessoaResultDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.dataNascimento = pessoa.getDataNascimento();
        this.sexo = pessoa.getSexo();
        this.idUsuario = pessoa.getUsuario().getId();
        this.endereco = new EnderecoResultDTO(pessoa.getEndereco());
    }
}
