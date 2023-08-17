package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.PessoaForm;
import com.fiap.techChallenge.TechChallenge.controller.form.PessoaResultDTO;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import com.fiap.techChallenge.TechChallenge.repository.PessoaRepository;
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


    @Override
    public PessoaResultDTO salvar(PessoaForm pessoaForm) {
        try {
            return new PessoaResultDTO(pessoaRepository.salvar(new Pessoa(pessoaForm)));
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao criar pessoa: " + e.getMessage());
        }
    }

    @Override
    public List<PessoaResultDTO> listarPessoasUsuario(Long id) {
        Optional<List<Pessoa>> pessoasEncontradas = Optional.ofNullable(pessoaRepository.listarPessoasUsuario(id));

        if(pessoasEncontradas.isEmpty())
            throw new IllegalArgumentException(String.format("Não foram encontradas pessoas para o id %s", id));

        List<PessoaResultDTO> pessoasForm = new ArrayList<>();
        for (Pessoa pessoa : pessoasEncontradas.get()) {
            pessoasForm.add(new PessoaResultDTO(pessoa));
        }

        return pessoasForm;

    }

    @Override
    public PessoaResultDTO listar(Long id) {
        return new PessoaResultDTO(pessoaRepository.listar(id));
    }

    @Override
    public void deletar(Long id) {
        pessoaRepository.deletarPessoa(id);
    }

    @Override
    public PessoaResultDTO atualizar(PessoaForm pessoaForm, Long id) {
        Pessoa pessoa = new Pessoa(pessoaForm);
        Optional<Pessoa> pessoaAtualizada = Optional.ofNullable(pessoaRepository.atualizar(pessoa, id));

        if(pessoaAtualizada.isEmpty())
            throw new IllegalArgumentException("Erro ao atualizar pessoa");

        return new PessoaResultDTO(pessoaAtualizada.get());

    }
}
