package com.fiap.techChallenge.TechChallenge.repository;

import com.fiap.techChallenge.TechChallenge.domain.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPessoaRepository extends JpaRepository<Pessoa, Long> {

    List<Pessoa> findByUsuarioId(Long id);
}
