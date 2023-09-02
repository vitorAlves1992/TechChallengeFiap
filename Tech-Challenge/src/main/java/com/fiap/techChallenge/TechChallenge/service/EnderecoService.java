package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.dto.EnderecoDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.EnderecoResultDTO;

import java.util.List;

public interface EnderecoService {
    public EnderecoResultDTO salvar(EnderecoDTO enderecoForm);
    public EnderecoResultDTO listar(Long idEndereco);
    List<EnderecoResultDTO> listarEnderecosUsuario(Long id);
    public void deletar(Long idEndereco);
    public EnderecoResultDTO atualizar(EnderecoDTO endereco, Long id);

    List<EnderecoResultDTO> buscaAvancada(String rua, Integer numero, String bairro, String cidade, String estado);
}
