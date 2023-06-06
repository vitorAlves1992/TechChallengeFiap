package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.EnderecoForm;
import com.fiap.techChallenge.TechChallenge.controller.form.EnderecoResultForm;

public interface EnderecoService {
    public EnderecoResultForm salvar(EnderecoForm enderecoForm);
    public EnderecoResultForm listar(String idEndereco);
    public void deletar(String idEndereco);
    public EnderecoResultForm atualizar(EnderecoForm endereco, String id);

}
