package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.PessoaForm;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;

import java.util.List;

public interface PessoaService {

    public PessoaForm salvar(PessoaForm pessoa);
    public List<PessoaForm> listarPessoasUsuario (String idUsuario);
    public PessoaForm listar(String idUsuario);
    public void deletar(String idPessoa);
    public void atualizar(PessoaForm pessoa);

}
