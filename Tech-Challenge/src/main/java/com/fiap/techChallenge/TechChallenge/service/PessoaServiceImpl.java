package com.fiap.techChallenge.TechChallenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.techChallenge.TechChallenge.controller.dto.PessoaDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.PessoaResultDTO;
import com.fiap.techChallenge.TechChallenge.domain.Endereco;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import com.fiap.techChallenge.TechChallenge.repository.IEnderecoRepository;
import com.fiap.techChallenge.TechChallenge.repository.IPessoaRepository;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class PessoaServiceImpl implements PessoaService {

    //@TODO trazer todas as excecoes do repository para dentro service

    @Autowired
    private IPessoaRepository pessoaRepository;
    @Autowired
    private IEnderecoRepository enderecoRepository;

    @Override
    public PessoaResultDTO salvar(PessoaDTO pessoaDto) {
        try {
            Pessoa pessoa = new Pessoa(pessoaDto);
            Endereco endereco = enderecoRepository.getReferenceById(pessoaDto.getIdEndereco());
            pessoa.setEndereco(endereco);
            return new PessoaResultDTO(pessoaRepository.save(pessoa));
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao criar pessoa: " + e.getMessage());
        }
    }




    @Override
    public List<PessoaResultDTO> listarPessoasUsuario(Long id) {
        List <Pessoa> pessoasEncontradas = pessoaRepository.findByUsuarioId(id);

        if(pessoasEncontradas.isEmpty())
            throw new IllegalArgumentException(String.format("Não foram encontradas pessoas para o id " + id));

        List<PessoaResultDTO> pessoasForm = new ArrayList<>();
        for (Pessoa pessoa : pessoasEncontradas) {
            pessoasForm.add(new PessoaResultDTO(pessoa));
        }

        return pessoasForm;

    }

    @Override
    public PessoaResultDTO listar(Long id) {
        Optional<Pessoa> pessoaEncontrada = pessoaRepository.findById(id);
        if(pessoaEncontrada.isEmpty()){
            throw new IllegalArgumentException(String.format("Não foram encontradas pessoas para o id " + id));
        }
        return new PessoaResultDTO(pessoaRepository.findById(id).get());
    }

    @Override
    public void deletar(Long id) {
        Pessoa pessoa = pessoaRepository.getReferenceById(id);
        try {
            pessoaRepository.delete(pessoa);
        }catch (Exception e) {
            throw new IllegalArgumentException("Erro ao deletar pessoa " + e.getMessage());
        }

    }

    @Override
    public PessoaResultDTO atualizar(PessoaDTO pessoaDto, Long id) {
        try {
            Pessoa pessoa = pessoaRepository.getReferenceById(id);
            Endereco endereco = enderecoRepository.getReferenceById(pessoaDto.getIdEndereco());
            pessoa.setEndereco(endereco);
            return new PessoaResultDTO(pessoaRepository.save(pessoa));
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao atualizar pessoa: " + e.getMessage());
        }
    }
}
