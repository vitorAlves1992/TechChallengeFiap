package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoForm;
import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoResultForm;
import com.fiap.techChallenge.TechChallenge.domain.Eletrodomestico;
import com.fiap.techChallenge.TechChallenge.repository.EletrodomesticoRepository;
import com.googlecode.jmapper.JMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EletrodomesticoServiceImpl implements EletrodomesticoService {
    @Autowired
    private EletrodomesticoRepository eletrodomesticoRepository;
    @Autowired
    private JMapper<Eletrodomestico, EletrodomesticoForm> eletrodomesticoMapper;
    @Autowired
    private JMapper<EletrodomesticoResultForm, Eletrodomestico> eletrodomesticoResultMapper;

    @Override
    public EletrodomesticoResultForm salvar(EletrodomesticoForm eletrodomesticoForm) {
        Eletrodomestico eletrodomestico = eletrodomesticoMapper.getDestination(eletrodomesticoForm);
        Optional<Eletrodomestico> eletrodomesticoSalvo = Optional.ofNullable(eletrodomesticoRepository.salvar(eletrodomestico));
        if (eletrodomesticoSalvo.isEmpty())
            throw new RuntimeException("Erro ao criar eletrodomestico.");

        return eletrodomesticoResultMapper.getDestination(eletrodomesticoSalvo.get());
    }

    @Override
    public EletrodomesticoResultForm listar(String id) {
        return eletrodomesticoResultMapper.getDestination(eletrodomesticoRepository.listar(Integer.parseInt(id)));
    }
    @Override
    public List<EletrodomesticoResultForm> listarEletrodomesticosDeUsuario(String id) {
        int idUsuario = Integer.parseInt(id);
        Optional<List<Eletrodomestico>> eletrodomesticosEncontrados = Optional.ofNullable(eletrodomesticoRepository.listarEletrodomesticosDeUsuario(idUsuario));

        List<EletrodomesticoResultForm> eletrodomesticoResultForm = new ArrayList<>();
        for (Eletrodomestico eletrodomestico : eletrodomesticosEncontrados.get()) {
            eletrodomesticoResultForm.add(eletrodomesticoResultMapper.getDestination(eletrodomestico));
        }

        return eletrodomesticoResultForm;

    }

    @Override
    public void deletar(String id) {
        int idEletrodomestico = Integer.parseInt(id);
        eletrodomesticoRepository.deletarEletrodomestico(idEletrodomestico);
    }

    @Override
    public EletrodomesticoResultForm atualizar(EletrodomesticoForm eletrodomesticoForm, String id) {
        Eletrodomestico eletrodomestico = eletrodomesticoMapper.getDestination(eletrodomesticoForm);
        Optional<Eletrodomestico> eletrodomesticoAtualizar = Optional.ofNullable(eletrodomesticoRepository.atualizar(eletrodomestico, id));
        if (eletrodomesticoAtualizar.isEmpty())
            throw new RuntimeException("Erro ao atualizar eletrodomestico.");

        return eletrodomesticoResultMapper.getDestination(eletrodomesticoAtualizar.get());
    }
}
