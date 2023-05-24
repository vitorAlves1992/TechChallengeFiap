package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.EnderecoForm;
import com.fiap.techChallenge.TechChallenge.domain.Endereco;
import com.fiap.techChallenge.TechChallenge.repository.EnderecoRepository;
import com.googlecode.jmapper.JMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService{

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private JMapper<Endereco, EnderecoForm> enderecoMapper;

    @Autowired
    private JMapper<EnderecoForm, Endereco> enderecoFormMapper;

    @Override
    public EnderecoForm salvar(EnderecoForm enderecoForm) {
        Endereco endereco = enderecoMapper.getDestination(enderecoForm);
        Optional<Endereco> enderecoSalvo = Optional.ofNullable(enderecoRepository.salvar(endereco));
        if(enderecoSalvo.isEmpty())
            throw new IllegalArgumentException("Erro ao criar endereco");

        return enderecoFormMapper.getDestination(enderecoSalvo.get());
    }

    @Override
    public EnderecoForm listar(String id) {
        int idEndereco = Integer.parseInt(id);
        Optional<Endereco> endereco = Optional.ofNullable(enderecoRepository.listar(idEndereco));
        if(endereco.isEmpty())
            return enderecoFormMapper.getDestination(endereco.get());
        else {
            throw new IllegalArgumentException("Erro ao buscar endereco");
        }
    }

    @Override
    public void deletar(String id) {
        int idEndereco = Integer.parseInt(id);
        enderecoRepository.deletar(idEndereco);
    }

    @Override
    public void atualizar(EnderecoForm enderecoForm) {

        Endereco endereco = enderecoMapper.getDestination(enderecoForm);
        Optional<Endereco> enderecoAtualizado = Optional.ofNullable(enderecoRepository.atualizar(endereco));

        if(enderecoAtualizado.isEmpty())
            throw new IllegalArgumentException("Erro ao atualizar endereco");

    }
}
