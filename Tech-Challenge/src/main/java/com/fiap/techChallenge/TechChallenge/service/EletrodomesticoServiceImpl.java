package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.dto.EletrodomesticoDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.EletrodomesticoResultDTO;
import com.fiap.techChallenge.TechChallenge.domain.Eletrodomestico;
import com.fiap.techChallenge.TechChallenge.domain.Usuario;
import com.fiap.techChallenge.TechChallenge.repository.IEletrodomesticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        Usuario usuario = new Usuario();
        usuario.setId(eletrodomesticoForm.getIdUsuario());
        eletrodomestico.setUsuario(usuario);

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
        Usuario usuario = new Usuario();
        usuario.setId(eletrodomesticoForm.getIdUsuario());
        eletrodomestico.setId(eletrodomesticoRepository.getReferenceById(id).getId());
        eletrodomestico.setUsuario(usuario);

        try {
            return new EletrodomesticoResultDTO(eletrodomesticoRepository.save(eletrodomestico));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar eletrodomestico: "+ e.getMessage());
        }
    }

}
