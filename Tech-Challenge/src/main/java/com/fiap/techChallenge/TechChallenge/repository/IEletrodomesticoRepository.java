package com.fiap.techChallenge.TechChallenge.repository;

import com.fiap.techChallenge.TechChallenge.domain.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IEletrodomesticoRepository extends JpaRepository<Eletrodomestico, Long> {

    @Query(value = "select e from Eletrodomestico e where e.usuario.id = :idUsuario ")
    Optional<List<Eletrodomestico>> listarEletrodomesticosDeUsuario(Long idUsuario);
}
