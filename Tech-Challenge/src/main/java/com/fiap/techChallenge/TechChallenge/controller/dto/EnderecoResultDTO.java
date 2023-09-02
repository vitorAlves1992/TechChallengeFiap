package com.fiap.techChallenge.TechChallenge.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.techChallenge.TechChallenge.controller.dto.eletrodomestico.EletrodomesticoResultDTO;
import com.fiap.techChallenge.TechChallenge.domain.Endereco;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL) // Exclui propriedades com valores nulos
public class EnderecoResultDTO {

    @JsonProperty
    private Long id;
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
    @JsonProperty ()
    private List<EletrodomesticoResultDTO> eletromesticos;
    @JsonProperty
    private List<PessoaResultDTO> pessoas;

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

    public EnderecoResultDTO(Endereco endereco, List<EletrodomesticoResultDTO> eletrodomesticos , List<PessoaResultDTO> pessoas) {
        this.id = endereco.getId();
        this.rua = endereco.getRua();
        this.numero = endereco.getNumero();
        this.bairro = endereco.getBairro();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
        this.eletromesticos = eletrodomesticos;
        this.pessoas = pessoas;
    }

}
