package com.fiap.techChallenge.TechChallenge.specification;

import com.fiap.techChallenge.TechChallenge.domain.Endereco;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationEndereco {
    public static Specification<Endereco> rua(String rua) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("rua"), "%" + rua + "%");
    }

    public static Specification<Endereco> bairro(String bairro) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("bairro"), "%" + bairro + "%");
    }
    public static Specification<Endereco> cidade(String cidade) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("cidade"), "%" + cidade + "%");
    }
    public static Specification<Endereco> estado(String estado) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.get("estado"), "%" + estado + "%");
    }
    public static Specification<Endereco> numero(Integer numero) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("numero"), numero);
    }
}
