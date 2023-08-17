package com.fiap.techChallenge.TechChallenge.repository;

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

    public List<Pessoa> listarPessoasUsuario(Long idUsuario){

        Optional<List<Pessoa>> pessoasUsuario = Optional.of(
                pessoas.stream()
                        .filter(pessoa -> pessoa.getIdUsuario().equals(idUsuario))
                        .collect(Collectors.toList()));

        if(pessoasUsuario.get().isEmpty())
            throw new RuntimeException("Não há pessoas cadastradas para esse usuário." );

        return pessoasUsuario.get();
    }

    public void deletarPessoa(Long idPessoa) {
        if(!pessoas.removeIf(pessoa -> pessoa.getId().equals(idPessoa)))
            throw new RuntimeException("Não Existe Pessoa para ser deletada.");
    }

    public Pessoa atualizar(Pessoa pessoa, Long id) {
        Optional<Pessoa> pessoaEncontrada = pessoas.stream()
                .filter(pessoaLista -> pessoaLista.getId().equals(id))
                .findFirst();

        if (pessoaEncontrada.isPresent()) {
            Pessoa pessoaAtualizada = pessoaEncontrada.get();
            pessoaAtualizada.setNome(pessoa.getNome());
            pessoaAtualizada.setSexo(pessoa.getSexo());
            pessoaAtualizada.setParentesco(pessoa.getParentesco());
            pessoaAtualizada.setDataNascimento(pessoa.getDataNascimento());
            return pessoaAtualizada;
        } else {
            throw new RuntimeException("Pessoa não encontrada na lista.");
        }
    }

    public Pessoa listar(Long id) {
        Optional<Pessoa> pessoaEncontrada = pessoas.stream()
                .filter(pessoaLista -> pessoaLista.getId().equals(id))
                .findFirst();

        if (pessoaEncontrada.isPresent()) {
            Pessoa pessoa = pessoaEncontrada.get();
             return pessoa;
        } else {
            throw new RuntimeException("Pessoa não encontrada na lista.");
        }
    }
}
