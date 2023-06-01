package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.PessoaForm;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import com.fiap.techChallenge.TechChallenge.repository.PessoaRepository;
import com.googlecode.jmapper.JMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PessoaServiceImpl implements PessoaService {

    //@TODO trazer todas as excecoes do repository para dentro service

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private JMapper<Pessoa, PessoaForm> pessoaMapper;

    @Autowired
    private JMapper<PessoaForm, Pessoa> pessoaFormMapper;

    @Override
    public PessoaForm salvar(PessoaForm pessoaForm) {
        Pessoa pessoa = pessoaMapper.getDestination(pessoaForm);
        Optional<Pessoa> pessoaSalva = Optional.ofNullable(pessoaRepository.salvar(pessoa));
        if(pessoaSalva.isEmpty())
            throw new IllegalArgumentException("Erro ao criar pessoa");

        return pessoaFormMapper.getDestination(pessoaSalva.get());
    }

    @Override
    public List<PessoaForm> listarPessoasUsuario(String id) {
        int idUsuario = Integer.parseInt(id);
        Optional<List<Pessoa>> pessoasEncontradas = Optional.ofNullable(pessoaRepository.listarPessoasUsuario(idUsuario));

        if(pessoasEncontradas.isEmpty())
            throw new IllegalArgumentException(String.format("Não foram encontradas pessoas para o id %s", id));

        List<PessoaForm> pessoasForm = new ArrayList<>();
        for (Pessoa pessoa : pessoasEncontradas.get()) {
            pessoasForm.add(pessoaFormMapper.getDestination(pessoa));
        }

        return pessoasForm;

    }

    @Override
    public PessoaForm listar(String id) {
        return pessoaFormMapper.getDestination(pessoaRepository.listar(Integer.parseInt(id)));
    }

    @Override
    public void deletar(String id) {
        int idPessoa = Integer.parseInt(id);
        pessoaRepository.deletarPessoa(idPessoa);
    }

    @Override
    public void atualizar(PessoaForm pessoaForm) {
        Pessoa pessoa = pessoaMapper.getDestination(pessoaForm);
        Optional<Pessoa> pessoaAtualizada = Optional.ofNullable(pessoaRepository.atualizar(pessoa));

        if(pessoaAtualizada.isEmpty())
            throw new IllegalArgumentException("Erro ao atualizar pessoa");

    }
}
