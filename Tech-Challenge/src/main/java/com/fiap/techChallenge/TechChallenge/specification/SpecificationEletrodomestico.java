package com.fiap.techChallenge.TechChallenge.specification;

import com.fiap.techChallenge.TechChallenge.controller.dto.eletrodomestico.EletrodomesticoDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.eletrodomestico.EletrodomesticoResultDTO;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationEletrodomestico {

    public static Specification<EletrodomesticoResultDTO> nome(String nome) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

    public static Specification<EletrodomesticoResultDTO> modelo(String modelo) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("modelo"), "%" + modelo + "%");
    }

    public static Specification<EletrodomesticoResultDTO> potencia(Double potencia) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("potencia"), potencia);
    }
}
