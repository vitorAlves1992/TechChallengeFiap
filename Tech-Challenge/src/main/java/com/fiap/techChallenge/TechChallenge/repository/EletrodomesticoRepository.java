package com.fiap.techChallenge.TechChallenge.repository;

import com.fiap.techChallenge.TechChallenge.domain.Eletrodomestico;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class EletrodomesticoRepository {
    private Collection <Eletrodomestico> eletrodomesticos = new ArrayList<>();

    public Eletrodomestico salvar (Eletrodomestico eletrodomestico){
        eletrodomestico.setId();
        eletrodomesticos.add(eletrodomestico);
        return eletrodomestico;
    }

    public boolean deletarEletrodomestico(int idEletrodomestico) {
        return eletrodomesticos.removeIf(eletrodomesticos -> (eletrodomesticos.getId().equals(idEletrodomestico)));
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
            // TODO Lidar com o caso em que o eletrodomestico não foi encontrado, por exemplo, lançar uma exceção ou retornar null
            throw new RuntimeException("Eletrodomestico não encontrada na lista.");
        }
    }
    public List<Eletrodomestico> listarEletrodomesticosDeUsuario(int idUsuario){
        List<Eletrodomestico> eletrodomesticosDeUsuario = eletrodomesticos.stream().
                filter(eletrodomestico -> eletrodomestico.getIdUsuario().equals(idUsuario)).collect(Collectors.toList());

        return eletrodomesticosDeUsuario;
    }
    public Eletrodomestico listar(int id) {
        Optional<Eletrodomestico> eletrodomesticoEncontrado = eletrodomesticos.stream()
                .filter(eletrodomesticoLista -> eletrodomesticoLista.getId().equals(id))
                .findFirst();

        if (eletrodomesticoEncontrado.isPresent()) {
            Eletrodomestico eletrodomestico = eletrodomesticoEncontrado.get();
            return eletrodomestico;
        } else {
            // TODO Lidar com o caso em que o eletrodomestico não foi encontrado, por exemplo, lançar uma exceção ou retornar null
            throw new RuntimeException("Eletrodomestico não encontrada na lista.");
        }
    }
}
