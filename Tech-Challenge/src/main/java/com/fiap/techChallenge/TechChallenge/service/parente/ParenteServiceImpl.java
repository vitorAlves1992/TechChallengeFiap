package com.fiap.techChallenge.TechChallenge.service.parente;

import com.fiap.techChallenge.TechChallenge.controller.dto.ParenteDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.ParenteResultDTO;
import com.fiap.techChallenge.TechChallenge.domain.Parente;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import com.fiap.techChallenge.TechChallenge.domain.enums.ParentescoEnum;
import com.fiap.techChallenge.TechChallenge.repository.IPessoaRepository;
import com.fiap.techChallenge.TechChallenge.repository.ParenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParenteServiceImpl implements ParenteService {

    @Autowired
    private ParenteRepository repository;
    @Autowired
    private IPessoaRepository pessoaRepository;

    @Override
    public List<ParenteResultDTO> getByPessoaId(Long id) {
        return repository.findByPessoaId(id)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ParenteResultDTO getById(Long id) {
        return repository.findById(id)
                .map(this::toDTO)
                .orElseThrow(() -> new EntityNotFoundException("Parente com o ID " + id + " não existe."));
    }

    @Override
    public ParenteResultDTO save(ParenteDTO request) {
        Parente savedParente = repository.save(toEntity(request));
        return toDTO(savedParente);
    }

    @Override
    public ParenteResultDTO update(Long id, ParenteDTO request) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Parente com o ID " + id + " não existe.");
        }
        Parente parente = toEntity(request);
        parente.setId(id);
        repository.save(parente);
        return toDTO(parente);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Parente com o ID " + id + " não existe.");
        }
        repository.deleteById(id);
    }

    private Parente toEntity(ParenteDTO dto) {
        Parente parente = new Parente();
        Pessoa pessoa = pessoaRepository.findById(dto.getPessoaId())
                .orElseThrow(() -> new EntityNotFoundException("Pessoa com o ID " + dto.getPessoaId() + " não encontrada."));
        parente.setPessoa(pessoa);
        Pessoa pessoaRelacionada = pessoaRepository.findById(dto.getPessoaRelacionadaId())
                .orElseThrow(() -> new EntityNotFoundException("Pessoa relacionada com o ID " + dto.getPessoaRelacionadaId() + " não encontrada."));
        parente.setPessoaRelacionada(pessoaRelacionada);
        parente.setParentesco(ParentescoEnum.valueOf((dto.getParentesco())));

        return parente;
    }

    private ParenteResultDTO toDTO(Parente entity) {
        ParenteResultDTO dto = new ParenteResultDTO();
        dto.setId(entity.getId());
        dto.setPessoaId(Long.valueOf(entity.getPessoa().getId()));
        dto.setPessoaRelacionadaId(Long.valueOf(entity.getPessoaRelacionada().getId()));
        dto.setParentesco(entity.getParentesco().getDescricao());
        return dto;
    }
}
