package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.EnderecoForm;
import com.fiap.techChallenge.TechChallenge.controller.form.EnderecoResultDTO;

public interface EnderecoService {
    public EnderecoResultDTO salvar(EnderecoForm enderecoForm);
    public EnderecoResultDTO listar(Long idEndereco);
    public void deletar(Long idEndereco);
    public EnderecoResultDTO atualizar(EnderecoForm endereco, Long id);

}
