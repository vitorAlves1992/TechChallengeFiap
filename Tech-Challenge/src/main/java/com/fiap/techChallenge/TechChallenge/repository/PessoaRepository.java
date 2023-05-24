package com.fiap.techChallenge.TechChallenge.repository;

import com.fiap.techChallenge.TechChallenge.controller.form.PessoaForm;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PessoaRepository {
    private Collection<Pessoa> pessoas;

    public PessoaRepository(){
        this.pessoas = new ArrayList<>();
    }

    public Pessoa salvar(Pessoa pessoa){
        pessoa.setId();
        pessoas.add(pessoa);
        return pessoa;
    }

    public List<Pessoa> listarPessoasUsuario(int idUsuario){
        List<Pessoa> pessoasUsuario = pessoas.stream().
                filter(pessoa -> pessoa.getIdUsuario().equals(idUsuario)).collect(Collectors.toList());

        return pessoasUsuario;
    }

    public boolean deletarPessoa(int idPessoa) {
        return pessoas.removeIf(pessoa -> (pessoa.getId().equals(idPessoa)));
    }

    public Pessoa atualizar(Pessoa pessoa) {
        Optional<Pessoa> pessoaEncontrada = pessoas.stream()
                .filter(pessoaLista -> pessoaLista.getId().equals(pessoa.getId()))
                .findFirst();

        if (pessoaEncontrada.isPresent()) {
            Pessoa pessoaAtualizada = pessoaEncontrada.get();
            pessoaAtualizada.setNome(pessoa.getNome());
            pessoaAtualizada.setSexo(pessoa.getSexo());
            pessoaAtualizada.setParentesco(pessoa.getParentesco());
            pessoaAtualizada.setDataNascimento(pessoa.getDataNascimento());
            return pessoaAtualizada;
        } else {
            // Lidar com o caso em que a pessoa não foi encontrada, por exemplo, lançar uma exceção ou retornar null
            throw new RuntimeException("Pessoa não encontrada na lista.");
        }
    }

    public Pessoa listar(int id) {
        Optional<Pessoa> pessoaEncontrada = pessoas.stream()
                .filter(pessoaLista -> pessoaLista.getId().equals(id))
                .findFirst();

        if (pessoaEncontrada.isPresent()) {
            Pessoa pessoa = pessoaEncontrada.get();
             return pessoa;
        } else {
            // Lidar com o caso em que a pessoa não foi encontrada, por exemplo, lançar uma exceção ou retornar null
            throw new RuntimeException("Pessoa não encontrada na lista.");
        }
    }
}
