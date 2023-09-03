package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.dto.PessoaDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.PessoaResultDTO;

import java.time.LocalDate;
import java.util.List;

public interface PessoaService {

    public PessoaResultDTO salvar(PessoaDTO pessoa);
    public List<PessoaResultDTO> listarPessoasUsuario (Long idUsuario);
    public PessoaResultDTO listar(Long idUsuario);
    public void deletar(Long idPessoa);
    public PessoaResultDTO atualizar(PessoaDTO pessoa, Long id);

    List<PessoaResultDTO> buscaAvancada(String nome, LocalDate date, String sexo, String parentesco, Long idUsuario);
}
