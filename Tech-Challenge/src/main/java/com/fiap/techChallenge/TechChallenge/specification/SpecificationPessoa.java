package com.fiap.techChallenge.TechChallenge.specification;

import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class SpecificationPessoa {
    public static Specification<Pessoa> nome(String nome) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }
    public static Specification<Pessoa> dataNascimento(LocalDate date) {
        return (root, criteriaQuery, criteriaBuilder) ->
             criteriaBuilder.equal(root.get("dataNascimento"), date);
    }
    public static Specification<Pessoa> sexo(String sexo) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("sexo"), "%" + sexo + "%");
    }

    public static Specification<Pessoa> parentesco(String parentesco) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("parentesco"), "%" + parentesco + "%");
    }
}
