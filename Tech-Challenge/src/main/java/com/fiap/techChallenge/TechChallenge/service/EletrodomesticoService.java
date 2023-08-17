package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.dto.EletrodomesticoDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.EletrodomesticoResultDTO;

import java.util.List;

public interface EletrodomesticoService {
    public EletrodomesticoResultDTO salvar(EletrodomesticoDTO eletrodomesticoForm);
    public List<EletrodomesticoResultDTO> listarEletrodomesticosDeUsuario (Long idUsuario);
    public EletrodomesticoResultDTO listar(Long idEletrodomestico);
    public void deletar(Long idEletrodomestico);
    public EletrodomesticoResultDTO atualizar(EletrodomesticoDTO eletrodomestico, Long id);
}
