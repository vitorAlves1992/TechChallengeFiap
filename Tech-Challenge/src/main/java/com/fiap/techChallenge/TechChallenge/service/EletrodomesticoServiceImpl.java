package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.dto.eletrodomestico.EletrodomesticoConsumoDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.eletrodomestico.EletrodomesticoDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.eletrodomestico.EletrodomesticoResultDTO;
import com.fiap.techChallenge.TechChallenge.domain.Eletrodomestico;
import com.fiap.techChallenge.TechChallenge.repository.IEletrodomesticoRepository;
import com.fiap.techChallenge.TechChallenge.specification.SpecificationEletrodomestico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EletrodomesticoServiceImpl implements EletrodomesticoService {
    @Autowired
    private IEletrodomesticoRepository eletrodomesticoRepository;

    @Override
    public EletrodomesticoResultDTO salvar(EletrodomesticoDTO eletrodomesticoForm) {
        Eletrodomestico eletrodomestico = new Eletrodomestico(eletrodomesticoForm);
        try {
            return new EletrodomesticoResultDTO(eletrodomesticoRepository.save(eletrodomestico));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao criar eletrodomestico: " + e.getMessage());
        }

    }

    @Override
    public EletrodomesticoResultDTO listar(Long id) {
        return new EletrodomesticoResultDTO(eletrodomesticoRepository.findById(id).get());
    }
    @Override
    public List<EletrodomesticoResultDTO> listarEletrodomesticosDeUsuario(Long id) {
        List<Eletrodomestico> eletrodomesticosEncontrados =
                eletrodomesticoRepository.listarEletrodomesticosDeUsuario(id);

        List<EletrodomesticoResultDTO> eletrodomesticoResultForm = new ArrayList<>();
        for (Eletrodomestico eletrodomestico : eletrodomesticosEncontrados) {
            eletrodomesticoResultForm.add(new EletrodomesticoResultDTO(eletrodomestico));
        }

        return eletrodomesticoResultForm;

    }

    @Override
    public void deletar(Long id) {
        Eletrodomestico eletrodomestico = eletrodomesticoRepository.getReferenceById(id);
        eletrodomesticoRepository.delete(eletrodomestico);
    }

    @Override
    public EletrodomesticoResultDTO atualizar(EletrodomesticoDTO eletrodomesticoForm, Long id) {
        Eletrodomestico eletrodomestico = new Eletrodomestico(eletrodomesticoForm);

        try {
            return new EletrodomesticoResultDTO(eletrodomesticoRepository.save(eletrodomestico));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar eletrodomestico: "+ e.getMessage());
        }
    }

    @Override
    public EletrodomesticoConsumoDTO calculoConsumo(Long idEletrodomestico, Double tempoUso) {
        Eletrodomestico eletrodomestico = eletrodomesticoRepository.findById(idEletrodomestico).get();
        return new EletrodomesticoConsumoDTO(eletrodomestico.getPotencia().doubleValue() * tempoUso);
    }

    @Override
    public List<EletrodomesticoResultDTO> buscaAvancada(String nome, String modelo, Double potencia) {

        List<Eletrodomestico> eletrodomesticosEncontrados = eletrodomesticoRepository.findAll(Specification
                .where(
                        SpecificationEletrodomestico.nome(nome))
                .or(SpecificationEletrodomestico.modelo(modelo))
                .or(SpecificationEletrodomestico.potencia(potencia))
        );

        List<EletrodomesticoResultDTO> eletrodomesticoResultForm = new ArrayList<>();
        for (Eletrodomestico eletrodomestico : eletrodomesticosEncontrados) {
            eletrodomesticoResultForm.add(new EletrodomesticoResultDTO(eletrodomestico));
        }
        return eletrodomesticoResultForm;
    }


}
