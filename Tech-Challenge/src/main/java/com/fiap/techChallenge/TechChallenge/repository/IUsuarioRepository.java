package com.fiap.techChallenge.TechChallenge.repository;

import com.fiap.techChallenge.TechChallenge.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

<<<<<<<< HEAD:Tech-Challenge/src/main/java/com/fiap/techChallenge/TechChallenge/repository/IUsuarioRepository.java
@Repository
public interface IUsuarioRepository extends JpaRepository <Usuario, Long> {
========
import java.util.Collection;
import java.util.List;

@Repository
public interface ParenteRepository extends JpaRepository<Parente, Long> {
    List<Parente> findByPessoaId(Long id);

    @Query(value = "select p from Parente p where p.pessoa.id = :pessoaId and p.pessoaRelacionada.id = :usuarioId")
    Parente findRelacionamentoBase(Long pessoaId, Long usuarioId);
>>>>>>>> fase2/main:Tech-Challenge/src/main/java/com/fiap/techChallenge/TechChallenge/repository/ParenteRepository.java
}
