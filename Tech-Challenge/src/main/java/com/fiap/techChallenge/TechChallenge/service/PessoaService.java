package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.PessoaForm;
import com.fiap.techChallenge.TechChallenge.controller.form.PessoaResultForm;

import java.util.List;

public interface PessoaService {

    public PessoaResultForm salvar(PessoaForm pessoa);
    public List<PessoaResultForm> listarPessoasUsuario (String idUsuario);
    public PessoaResultForm listar(String idUsuario);
    public void deletar(String idPessoa);
    public void atualizar(PessoaForm pessoa, String id);

}
