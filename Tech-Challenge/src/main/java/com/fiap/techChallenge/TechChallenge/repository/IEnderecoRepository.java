package com.fiap.techChallenge.TechChallenge.repository;

import com.fiap.techChallenge.TechChallenge.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEnderecoRepository extends JpaRepository<Endereco, Long> {
    List<Endereco> findByUsuarioId(Long id);
}
