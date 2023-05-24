package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.EnderecoForm;

public interface EnderecoService {

    public EnderecoForm salvar(EnderecoForm endereco);
    public EnderecoForm listar(String idEndereco);
    public void deletar(String idEndereco);
    public void atualizar(EnderecoForm endereco);


}
