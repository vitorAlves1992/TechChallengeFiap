package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.dto.eletrodomestico.EletrodomesticoConsumoDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.eletrodomestico.EletrodomesticoDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.eletrodomestico.EletrodomesticoResultDTO;

import java.util.List;

public interface EletrodomesticoService {
    public EletrodomesticoResultDTO salvar(EletrodomesticoDTO eletrodomesticoForm);
    public List<EletrodomesticoResultDTO> listarEletrodomesticosPorEndereco (Long idEndereco);
    public EletrodomesticoResultDTO listar(Long idEletrodomestico);
    public void deletar(Long idEletrodomestico);
    public EletrodomesticoResultDTO atualizar(EletrodomesticoDTO eletrodomestico, Long id);

    public EletrodomesticoConsumoDTO calculoConsumo(Long idEletrodomestico, Double tempoUso);

    public List<EletrodomesticoResultDTO> buscaAvancada(String nome, String modelo, Double potencia);
}
