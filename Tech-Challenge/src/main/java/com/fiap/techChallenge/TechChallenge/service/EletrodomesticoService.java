package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoForm;
import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoResultDTO;

import java.util.List;

public interface EletrodomesticoService {
    public EletrodomesticoResultDTO salvar(EletrodomesticoForm eletrodomesticoForm);
    public List<EletrodomesticoResultDTO> listarEletrodomesticosDeUsuario (Long idUsuario);
    public EletrodomesticoResultDTO listar(Long idEletrodomestico);
    public void deletar(Long idEletrodomestico);
    public EletrodomesticoResultDTO atualizar(EletrodomesticoForm eletrodomestico, Long id);
}
