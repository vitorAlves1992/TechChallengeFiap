package com.fiap.techChallenge.TechChallenge.service.parente;

import com.fiap.techChallenge.TechChallenge.controller.dto.ParenteDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.ParenteResultDTO;

import java.util.List;

public interface ParenteService {

    List<ParenteResultDTO> getAll();

    ParenteResultDTO getById(Long id);

    ParenteResultDTO save(ParenteDTO parente);

    void delete(Long id);

     ParenteResultDTO update(Long id, ParenteDTO parente);

    }
