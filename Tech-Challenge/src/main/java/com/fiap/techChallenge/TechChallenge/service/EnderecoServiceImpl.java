package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.dto.EnderecoDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.EnderecoResultDTO;
import com.fiap.techChallenge.TechChallenge.domain.Endereco;
import com.fiap.techChallenge.TechChallenge.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public EnderecoResultDTO salvar(EnderecoDTO enderecoForm) {
        try {
            return new EnderecoResultDTO(enderecoRepository.salvar(new Endereco(enderecoForm)));
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao criar endereco: " + e.getMessage());
        }
    }

    @Override
    public EnderecoResultDTO listar(Long id) {
        Endereco endereco = enderecoRepository.listar(id);
        if(endereco == null)
            throw new IllegalArgumentException("Erro ao buscar endereco");
        else {
            return new EnderecoResultDTO(endereco);
        }
    }

    @Override
    public void deletar(Long id) {
        /*int idEndereco = Integer.parseInt(id);*/
        enderecoRepository.deletar(id);
    }

    @Override
    public EnderecoResultDTO atualizar(EnderecoDTO enderecoForm, Long id) {

        Endereco endereco = new Endereco(enderecoForm);

        Optional<Endereco> enderecoAtualizado = Optional.ofNullable(enderecoRepository.atualizar(endereco, id));

        if(enderecoAtualizado.isEmpty())
            throw new IllegalArgumentException("Erro ao atualizar endereco");

        return new EnderecoResultDTO(enderecoAtualizado.get());
    }
}
