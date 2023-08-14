package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoForm;
import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoResultForm;
import com.fiap.techChallenge.TechChallenge.domain.Eletrodomestico;
import com.fiap.techChallenge.TechChallenge.domain.Usuario;
import com.fiap.techChallenge.TechChallenge.repository.IEletrodomesticoRepository;
import com.googlecode.jmapper.JMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EletrodomesticoServiceImpl implements EletrodomesticoService {
    @Autowired
    private IEletrodomesticoRepository eletrodomesticoRepository;

    @Autowired
    private JMapper<Eletrodomestico, EletrodomesticoForm> eletrodomesticoMapper;

    @Autowired
    private JMapper<EletrodomesticoResultForm, Eletrodomestico> eletrodomesticoResultMapper;

    @Override
    public EletrodomesticoResultForm salvar(EletrodomesticoForm eletrodomesticoForm) {
        Eletrodomestico eletrodomestico = eletrodomesticoMapper.getDestination(eletrodomesticoForm);
        Usuario usuario = new Usuario();
        usuario.setId(eletrodomesticoForm.getIdUsuario());
        eletrodomestico.setUsuario(usuario);
        Optional<Eletrodomestico> eletrodomesticoSalvo = Optional.ofNullable(eletrodomesticoRepository.save(eletrodomestico));
        if (eletrodomesticoSalvo.isEmpty())
            throw new RuntimeException("Erro ao criar eletrodomestico.");

        return eletrodomesticoResultMapper.getDestination(eletrodomesticoSalvo.get());
    }

    @Override
    public EletrodomesticoResultForm listar(String id) {
        return eletrodomesticoResultMapper.getDestination(eletrodomesticoRepository.findById(Long.parseLong(id)).get());
    }
    @Override
    public List<EletrodomesticoResultForm> listarEletrodomesticosDeUsuario(String id) {
        Long idUsuario = Long.parseLong(id);
        Optional<List<Eletrodomestico>> eletrodomesticosEncontrados =
                eletrodomesticoRepository.listarEletrodomesticosDeUsuario(idUsuario);

        List<EletrodomesticoResultForm> eletrodomesticoResultForm = new ArrayList<>();
        for (Eletrodomestico eletrodomestico : eletrodomesticosEncontrados.get()) {
            eletrodomesticoResultForm.add(eletrodomesticoResultMapper.getDestination(eletrodomestico));
        }

        return eletrodomesticoResultForm;

    }

    @Override
    public void deletar(String id) {
        Long idEletrodomestico = Long.parseLong(id);
        Eletrodomestico eletrodomestico = eletrodomesticoRepository.getReferenceById(idEletrodomestico);
        eletrodomesticoRepository.delete(eletrodomestico);
    }

    @Override
    public EletrodomesticoResultForm atualizar(EletrodomesticoForm eletrodomesticoForm, String id) {
        Eletrodomestico eletrodomestico = eletrodomesticoMapper.getDestination(eletrodomesticoForm);
        Usuario usuario = new Usuario();
        usuario.setId(eletrodomesticoForm.getIdUsuario());
        eletrodomestico.setId(eletrodomesticoRepository.getReferenceById(Long.parseLong(id)).getId());
        eletrodomestico.setUsuario(usuario);
        Optional<Eletrodomestico> eletrodomesticoAtualizar = Optional.ofNullable(eletrodomesticoRepository.save(eletrodomestico));
        if (eletrodomesticoAtualizar.isEmpty())
            throw new RuntimeException("Erro ao atualizar eletrodomestico.");

        return eletrodomesticoResultMapper.getDestination(eletrodomesticoAtualizar.get());
    }

}
