package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoForm;
import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoResultForm;
import com.fiap.techChallenge.TechChallenge.controller.form.PessoaForm;

import java.util.List;

public interface EletrodomesticoService {
    EletrodomesticoResultForm salvar(EletrodomesticoForm eletrodomesticoForm);
    public List<EletrodomesticoResultForm> listarEletrodomesticosDeUsuario (String idUsuario);
    EletrodomesticoResultForm listar(String eletrodomesticoService);

    void deletar(String idEletrodomestico);

    void atualizar(EletrodomesticoForm eletrodomestico, String id);
}
