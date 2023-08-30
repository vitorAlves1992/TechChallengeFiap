package com.fiap.techChallenge.TechChallenge.specification;

import com.fiap.techChallenge.TechChallenge.domain.Eletrodomestico;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationEletrodomestico {

    public static Specification<Eletrodomestico> nome(String nome) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }

    public static Specification<Eletrodomestico> modelo(String modelo) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("modelo"), "%" + modelo + "%");
    }

    public static Specification<Eletrodomestico> potencia(Double potencia) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("potencia"), potencia);
    }
}
