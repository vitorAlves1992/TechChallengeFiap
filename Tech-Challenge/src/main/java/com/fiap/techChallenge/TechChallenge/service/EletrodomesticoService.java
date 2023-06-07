package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoForm;
import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoResultForm;

import java.util.List;

public interface EletrodomesticoService {
    public EletrodomesticoResultForm salvar(EletrodomesticoForm eletrodomesticoForm);
    public List<EletrodomesticoResultForm> listarEletrodomesticosDeUsuario (String idUsuario);
    public EletrodomesticoResultForm listar(String idEletrodomestico);
    public void deletar(String idEletrodomestico);
    public EletrodomesticoResultForm atualizar(EletrodomesticoForm eletrodomestico, String id);
}
