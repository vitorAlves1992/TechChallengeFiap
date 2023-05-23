package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoForm;
import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoResultForm;
import com.fiap.techChallenge.TechChallenge.domain.Eletrodomestico;
import com.fiap.techChallenge.TechChallenge.repository.EletrodomesticoRepository;
import com.googlecode.jmapper.JMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class EletrodomesticoServiceImpl implements EletrodomesticoService {
@Autowired
private EletrodomesticoRepository eletrodomesticoRepository;
@Autowired
private JMapper <Eletrodomestico, EletrodomesticoForm > eletrodomesticoMapper;
@Autowired
private JMapper <EletrodomesticoResultForm, Eletrodomestico > eletrodomesticoResultMapper;

    @Override
    public EletrodomesticoResultForm salvar(EletrodomesticoForm eletrodomesticoForm) {
        Eletrodomestico eletrodomestico = eletrodomesticoMapper.getDestination(eletrodomesticoForm);
        Optional <Eletrodomestico> eletrodomesticoSalvo = Optional.ofNullable(eletrodomesticoRepository.salvar(eletrodomestico));
        if(eletrodomesticoSalvo.isEmpty())
            throw new IllegalArgumentException("Erro ao criar eletrodomestico.");

        return eletrodomesticoResultMapper.getDestination(eletrodomesticoSalvo.get());
    }
}
