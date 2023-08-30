package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.dto.EnderecoDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.EnderecoResultDTO;

public interface EnderecoService {
    public EnderecoResultDTO salvar(EnderecoDTO enderecoForm);
    public EnderecoResultDTO listar(Long idEndereco);
    public void deletar(Long idEndereco);
    public EnderecoResultDTO atualizar(EnderecoDTO endereco, Long id);

}
