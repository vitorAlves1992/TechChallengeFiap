package com.fiap.techChallenge.TechChallenge.repository;

import com.fiap.techChallenge.TechChallenge.domain.Eletrodomestico;
import com.fiap.techChallenge.TechChallenge.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface IEnderecoRepository extends JpaRepository<Endereco, Long> ,
        JpaSpecificationExecutor<Endereco> {
    List<Endereco> findByUsuarioId(Long id);
}
