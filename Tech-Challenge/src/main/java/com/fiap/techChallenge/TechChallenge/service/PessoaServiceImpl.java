package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.dto.EnderecoResultDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.PessoaDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.PessoaResultDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.eletrodomestico.EletrodomesticoResultDTO;
import com.fiap.techChallenge.TechChallenge.domain.Endereco;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import com.fiap.techChallenge.TechChallenge.repository.IEnderecoRepository;
import com.fiap.techChallenge.TechChallenge.repository.IPessoaRepository;
import com.fiap.techChallenge.TechChallenge.specification.SpecificationPessoa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;


@Service
@Slf4j
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private IPessoaRepository pessoaRepository;
    @Autowired
    private IEnderecoRepository enderecoRepository;

    @Transactional
    @Override
    public PessoaResultDTO salvar(PessoaDTO pessoaDto) {
        try {
            Pessoa pessoa = new Pessoa(pessoaDto);
            Endereco endereco = enderecoRepository.getReferenceById(pessoaDto.getIdEndereco());
            pessoa.setEndereco(endereco);

            return new PessoaResultDTO(pessoaRepository.save(pessoa), true);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao criar pessoa: " + e.getMessage());
        }
    }

    @Override
    public List<PessoaResultDTO> listarPessoasUsuario(Long id) {
        List <Pessoa> pessoasEncontradas = pessoaRepository.findByEnderecoUsuarioId(id);

        if(pessoasEncontradas.isEmpty())
            throw new IllegalArgumentException(String.format("Não foram encontradas pessoas para o id " + id));

        List<PessoaResultDTO> pessoasForm = new ArrayList<>();
        for (Pessoa pessoa : pessoasEncontradas) {
            pessoasForm.add(new PessoaResultDTO(pessoa, true));
        }

        return pessoasForm;

    }

    @Override
    public PessoaResultDTO listar(Long id) {
        Optional<Pessoa> pessoaEncontrada = pessoaRepository.findById(id);
        if(pessoaEncontrada.isEmpty()){
            throw new IllegalArgumentException(String.format("Não foram encontradas pessoas para o id " + id));
        }
        return new PessoaResultDTO(pessoaRepository.findById(id).get(), true);
    }

    @Override
    public List<PessoaResultDTO> buscaAvancada(String nome, LocalDate date, String sexo, String parentesco) {

        List<Pessoa> pessoas = pessoaRepository.findAll(Specification
                .where(
                        SpecificationPessoa.nome(nome))
                .or(SpecificationPessoa.dataNascimento(date))
                .or(SpecificationPessoa.sexo(sexo))
                .or(SpecificationPessoa.parentesco(parentesco))
        );

        return pessoas.stream().map(pessoa -> new PessoaResultDTO(pessoa, true)).collect(toList());
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
            return new PessoaResultDTO(pessoaRepository.save(pessoa), true);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao atualizar pessoa: " + e.getMessage());
        }
    }

}
