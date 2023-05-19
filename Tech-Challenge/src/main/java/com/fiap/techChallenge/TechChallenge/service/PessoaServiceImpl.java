package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import com.fiap.techChallenge.TechChallenge.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public Pessoa salvar(Pessoa pessoa) {
        return pessoaRepository.salvar(pessoa);
    }

    @Override
    public List<Pessoa> listarPessoasUsuario(int idUsuario) {
        return pessoaRepository.listarPessoasUsuario(idUsuario);
    }

    @Override
    public Pessoa listarPessoa(int id) {
        return pessoaRepository.listarPessoa(id);
    }

    @Override
    public boolean deletarPessoa(int idPessoa) {
        return pessoaRepository.deletarPessoa(idPessoa);
    }

    @Override
    public Pessoa atualizarPessoa(Pessoa pessoa) {
        return pessoaRepository.atualizarPessoa(pessoa);
    }
}
