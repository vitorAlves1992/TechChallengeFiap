package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.domain.Pessoa;

import java.util.List;

public interface PessoaService {

    public Pessoa salvar(Pessoa pessoa);
    public List<Pessoa> listarPessoasUsuario (int idUsuario);
    public Pessoa listarPessoa(int idUsuario);
    public boolean deletarPessoa(int idPessoa);
    public Pessoa atualizarPessoa(Pessoa pessoa);

}
