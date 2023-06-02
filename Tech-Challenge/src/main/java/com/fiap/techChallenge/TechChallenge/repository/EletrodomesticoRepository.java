package com.fiap.techChallenge.TechChallenge.repository;

import com.fiap.techChallenge.TechChallenge.domain.Eletrodomestico;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class EletrodomesticoRepository {
    private Collection <Eletrodomestico> eletrodomesticos = new ArrayList<>();

    public Eletrodomestico salvar (Eletrodomestico eletrodomestico){
        eletrodomestico.setId();
        eletrodomesticos.add(eletrodomestico);
        return eletrodomestico;
    }

    public void deletarEletrodomestico(int idEletrodomestico) {
         if(!eletrodomesticos.removeIf(eletrodomesticos -> (eletrodomesticos.getId().equals(idEletrodomestico))))
             throw new RuntimeException("Não Existe Eletrodomestico para ser deletado.");
    }

    public Eletrodomestico atualizar(Eletrodomestico eletrodomestico, String id) {
        Optional<Eletrodomestico> eletrodomesticoEncontrado = eletrodomesticos.stream()
                .filter(eletrodomesticoLista -> eletrodomesticoLista.getId().equals(Integer.parseInt(id)))
                .findFirst();

        if (eletrodomesticoEncontrado.isPresent()) {
            Eletrodomestico eletrodomesticoAtualizado = eletrodomesticoEncontrado.get();
            eletrodomesticoAtualizado.setNome(eletrodomestico.getNome());
            eletrodomesticoAtualizado.setModelo(eletrodomestico.getModelo());
            eletrodomesticoAtualizado.setPotencia(eletrodomestico.getPotencia());
            return eletrodomesticoAtualizado;
        } else {
            throw new RuntimeException("Eletrodomestico não encontrado na lista.");
        }
    }
    public List<Eletrodomestico> listarEletrodomesticosDeUsuario(int idUsuario){
        Optional<List<Eletrodomestico>> eletrodomesticosDeUsuario = Optional.of(eletrodomesticos.stream()
                .filter(eletrodomestico -> eletrodomestico.getIdUsuario().equals(idUsuario))
                .collect(Collectors.toList()));
        if (eletrodomesticosDeUsuario.get().isEmpty())
            throw new RuntimeException("Não há eletrodomesticos cadastrados para esse usuário." );

        return eletrodomesticosDeUsuario.get();
    }
    public Eletrodomestico listar(int id) {
        Optional<Eletrodomestico> eletrodomesticoEncontrado = eletrodomesticos.stream()
                .filter(eletrodomesticoLista -> eletrodomesticoLista.getId().equals(id))
                .findFirst();

        if (eletrodomesticoEncontrado.isPresent()) {
            Eletrodomestico eletrodomestico = eletrodomesticoEncontrado.get();
            return eletrodomestico;
        } else {
            throw new RuntimeException("Eletrodomestico não encontrado na lista.");
        }
    }
}
