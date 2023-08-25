package com.fiap.techChallenge.TechChallenge.repository;

import com.fiap.techChallenge.TechChallenge.domain.Parente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ParenteRepository extends JpaRepository<Parente, Long> {
    List<Parente> findByPessoaId(Long id);

    @Query(value = "select p from Parente p where p.pessoa.id = :pessoaId and p.pessoaRelacionada.id = :usuarioId")
    Parente findRelacionamentoBase(Long pessoaId, Long usuarioId);
}
