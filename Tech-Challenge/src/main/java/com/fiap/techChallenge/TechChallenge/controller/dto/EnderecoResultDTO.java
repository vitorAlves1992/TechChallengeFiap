package com.fiap.techChallenge.TechChallenge.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.techChallenge.TechChallenge.domain.Endereco;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoResultDTO {

    @JsonProperty
    private Integer id;
    @JsonProperty
    private String rua;
    @JsonProperty
    private Integer numero;
    @JsonProperty
    private String bairro;
    @JsonProperty
    private String cidade;
    @JsonProperty
    private String estado;


    public EnderecoResultDTO() {
    }

    public EnderecoResultDTO(Endereco endereco) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();

    }
}
