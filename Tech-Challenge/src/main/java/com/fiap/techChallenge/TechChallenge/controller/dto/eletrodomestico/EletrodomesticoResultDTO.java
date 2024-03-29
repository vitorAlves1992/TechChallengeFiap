package com.fiap.techChallenge.TechChallenge.controller.dto.eletrodomestico;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fiap.techChallenge.TechChallenge.controller.dto.EnderecoResultDTO;
import com.fiap.techChallenge.TechChallenge.domain.Eletrodomestico;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonInclude(JsonInclude.Include.NON_NULL) // Exclui propriedades com valores nulos
public class EletrodomesticoResultDTO {


    @JsonProperty
    private Long id;

    @JsonProperty
    private String nome;

    @JsonProperty
    private String modelo;

    @JsonProperty
    private Double potencia;

    @JsonProperty
    private EnderecoResultDTO endereco;

    public EletrodomesticoResultDTO(Eletrodomestico eletrodomestico , boolean hasEndereco) {
        this.id = eletrodomestico.getId();
        this.nome = eletrodomestico.getNome();
        this.modelo = eletrodomestico.getModelo();
        this.potencia = eletrodomestico.getPotencia();
        if(hasEndereco)
            this.endereco = new EnderecoResultDTO(eletrodomestico.getEndereco());
    }


}
