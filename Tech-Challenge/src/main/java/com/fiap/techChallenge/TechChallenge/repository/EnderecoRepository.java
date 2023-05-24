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
        endereco.setId();
        enderecos.add(endereco);
        return  endereco;
    }

    public void deletar (int idEndereco) {
        enderecos.removeIf(endereco -> endereco.getId().equals(idEndereco));
    }

    public Endereco atualizar(Endereco enderecoNovo) {
        Optional<Endereco> enderecoEncontrado = enderecos
                .stream()
                .filter(endereco -> endereco.equals(enderecoNovo))
                .findFirst();

        if(enderecoEncontrado.isPresent()) {
            Endereco enderecoAtualizado = enderecoEncontrado.get();
            enderecoAtualizado.setNumero(enderecoNovo.getNumero());
            enderecoAtualizado.setEstado(enderecoNovo.getEstado());
            enderecoAtualizado.setCidade(enderecoNovo.getCidade());
            enderecoAtualizado.setBairro(enderecoNovo.getBairro());
            enderecoAtualizado.setRua(enderecoNovo.getRua());
            return enderecoAtualizado;
        }

        return new Endereco();
    }

    public Endereco listar(int idEndereco) {
        Optional<Endereco> enderecoEncontrado = enderecos
                .stream()
                .filter(endereco -> endereco.getId().equals(idEndereco))
                .findFirst();

        return enderecoEncontrado.orElseGet(null);

    }
}
