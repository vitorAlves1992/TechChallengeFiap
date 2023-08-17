package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.PessoaForm;
import com.fiap.techChallenge.TechChallenge.controller.form.PessoaResultDTO;

import java.util.List;

public interface PessoaService {

    public PessoaResultDTO salvar(PessoaForm pessoa);
    public List<PessoaResultDTO> listarPessoasUsuario (Long idUsuario);
    public PessoaResultDTO listar(Long idUsuario);
    public void deletar(Long idPessoa);
    public PessoaResultDTO atualizar(PessoaForm pessoa, Long id);

}
