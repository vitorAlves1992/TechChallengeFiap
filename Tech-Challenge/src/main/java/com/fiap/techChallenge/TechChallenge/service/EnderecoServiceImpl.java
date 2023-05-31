package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.EnderecoForm;
import com.fiap.techChallenge.TechChallenge.controller.form.EnderecoResultForm;
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
    private JMapper<EnderecoResultForm, Endereco> enderecoResultFormMapper;

    @Override
    public EnderecoResultForm salvar(EnderecoForm enderecoForm) {
        Endereco endereco = enderecoMapper.getDestination(enderecoForm);
        Optional<Endereco> enderecoSalvo = Optional.ofNullable(enderecoRepository.salvar(endereco));
        if(enderecoSalvo.isEmpty())
            throw new IllegalArgumentException("Erro ao criar endereco");

        return enderecoResultFormMapper.getDestination(enderecoSalvo.get());
    }

    @Override
    public EnderecoResultForm listar(String id) {
        Endereco endereco = enderecoRepository.listar(Integer.parseInt(id));
        if(endereco == null)
            throw new IllegalArgumentException("Erro ao buscar endereco");
        else {
            return enderecoResultFormMapper.getDestination(endereco);
        }
    }

    @Override
    public void deletar(String id) {
        int idEndereco = Integer.parseInt(id);
        enderecoRepository.deletar(idEndereco);
    }

    @Override
    public void atualizar(EnderecoForm enderecoForm, String id) {

        Endereco endereco = enderecoMapper.getDestination(enderecoForm);
        Optional<Endereco> enderecoAtualizado = Optional.ofNullable(enderecoRepository.atualizar(endereco, id));

        if(enderecoAtualizado.isEmpty())
            throw new IllegalArgumentException("Erro ao atualizar endereco");


    }
}
