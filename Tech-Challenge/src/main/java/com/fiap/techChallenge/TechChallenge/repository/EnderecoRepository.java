package com.fiap.techChallenge.TechChallenge.repository;

import com.fiap.techChallenge.TechChallenge.domain.Endereco;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Repository
public class EnderecoRepository {

    private Collection<Endereco> enderecos;

    public  EnderecoRepository() {
        this.enderecos = new ArrayList<>();
    }

    public Endereco salvar (Endereco endereco) {
//        endereco.setId(); //TODO corrigir o ID
        enderecos.add(endereco);
        return  endereco;
    }

    public void deletar (Long idEndereco) {
        if(!enderecos.removeIf(endereco -> endereco.getId().equals(idEndereco)))
            throw new RuntimeException("Endereco não encontrado na lista.");
    }

    public Endereco atualizar(Endereco enderecoNovo, Long id) {
        Optional<Endereco> enderecoEncontrado = enderecos
                .stream()
                .filter(endereco -> endereco.getId().equals(id))
                .findFirst();

        if(enderecoEncontrado.isPresent()) {
            Endereco enderecoAtualizado = enderecoEncontrado.get();
            enderecoAtualizado.setNumero(enderecoNovo.getNumero());
            enderecoAtualizado.setEstado(enderecoNovo.getEstado());
            enderecoAtualizado.setCidade(enderecoNovo.getCidade());
            enderecoAtualizado.setBairro(enderecoNovo.getBairro());
            enderecoAtualizado.setRua(enderecoNovo.getRua());
            return enderecoAtualizado;
        }else {
            throw new RuntimeException("Endereco não encontrada na lista.");
        }
    }

    public Endereco listar(Long idEndereco) {
        Optional<Endereco> enderecoEncontrado = enderecos
                .stream()
                .filter(endereco -> endereco.getId().equals(idEndereco))
                .findFirst();
        if(enderecoEncontrado.isPresent())
            return enderecoEncontrado.get();
        else
            throw new RuntimeException("Endereco não encontrado na lista.");
    }
}
