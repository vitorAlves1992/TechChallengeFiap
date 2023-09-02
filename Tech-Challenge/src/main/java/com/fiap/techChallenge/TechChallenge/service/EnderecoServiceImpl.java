package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.dto.EnderecoDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.EnderecoResultDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.PessoaResultDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.eletrodomestico.EletrodomesticoResultDTO;
import com.fiap.techChallenge.TechChallenge.domain.Eletrodomestico;
import com.fiap.techChallenge.TechChallenge.domain.Endereco;
import com.fiap.techChallenge.TechChallenge.domain.Usuario;
import com.fiap.techChallenge.TechChallenge.repository.IEletrodomesticoRepository;
import com.fiap.techChallenge.TechChallenge.repository.IEnderecoRepository;
import com.fiap.techChallenge.TechChallenge.repository.IPessoaRepository;
import com.fiap.techChallenge.TechChallenge.specification.SpecificationEletrodomestico;
import com.fiap.techChallenge.TechChallenge.specification.SpecificationEndereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private IEnderecoRepository enderecoRepository;

    @Override
    public EnderecoResultDTO salvar(EnderecoDTO enderecoForm) {
        Endereco endereco = new Endereco(enderecoForm);
        Usuario usuario = new Usuario();
        usuario.setId(enderecoForm.getIdUsuario());
        endereco.setUsuario(usuario);
        try {
            endereco = enderecoRepository.save(endereco);
            return new EnderecoResultDTO(endereco);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao criar endereco: " + e.getMessage());
        }
    }

    @Override
    public EnderecoResultDTO listar(Long id) {
       Optional<Endereco> endereco = enderecoRepository.findById(id);

       if (endereco.isEmpty()) {
           throw new RuntimeException("Endereco não encontrado");
       }
       return new EnderecoResultDTO(endereco.get(),
               endereco.get().getEletrodomesticos().stream().
                       map(eletrodomestico -> new EletrodomesticoResultDTO(eletrodomestico, false)).collect(toList()),
               endereco.get().getPessoas().stream().map(pessoa -> new PessoaResultDTO(pessoa, false)).collect(toList()));
    }
    @Override
    public List<EnderecoResultDTO> listarEnderecosUsuario(Long id) {
        List<Endereco> enderecos = enderecoRepository.findByUsuarioId(id);

        if (enderecos.isEmpty()) {
            throw new RuntimeException("Endereco não encontrado");
        }
        return enderecos.stream().map(endereco -> new EnderecoResultDTO(endereco,
                endereco.getEletrodomesticos().stream().
                        map(eletrodomestico -> new EletrodomesticoResultDTO(eletrodomestico, false)).collect(toList()),
                endereco.getPessoas().stream().map(pessoa -> new PessoaResultDTO(pessoa, false)).collect(toList()))).collect(toList());
    }

    @Override
    public List<EnderecoResultDTO> buscaAvancada(String rua, Integer numero, String bairro, String cidade, String estado) {

        List<Endereco> enderecos = enderecoRepository.findAll(Specification
                .where(
                        SpecificationEndereco.rua(rua))
                .or(SpecificationEndereco.bairro(bairro))
                .or(SpecificationEndereco.cidade(cidade))
                .or(SpecificationEndereco.estado(estado))
                .or(SpecificationEndereco.numero(numero))
        );

        return enderecos.stream().map(endereco -> new EnderecoResultDTO(endereco,
                endereco.getEletrodomesticos().stream().
                        map(eletrodomestico -> new EletrodomesticoResultDTO(eletrodomestico, false)).collect(toList()),
                endereco.getPessoas().stream().map(pessoa -> new PessoaResultDTO(pessoa, false)).collect(toList()))).collect(toList());
    }

    @Override
    public void deletar(Long id) {
        Endereco endereco = enderecoRepository.getReferenceById(id);
        enderecoRepository.delete(endereco);
    }

    @Override
    public EnderecoResultDTO atualizar(EnderecoDTO enderecoForm, Long id) {

        Endereco endereco = new Endereco(enderecoForm);
        Usuario usuario = new Usuario();
        usuario.setId(enderecoForm.getIdUsuario());
        endereco.setId(enderecoRepository.getReferenceById(id).getId());
        endereco.setUsuario(usuario);

        try {
            return new EnderecoResultDTO(enderecoRepository.save(endereco));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar endereco: "+ e.getMessage());
        }

    }
}
