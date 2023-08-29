package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.dto.EnderecoDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.EnderecoResultDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.PessoaResultDTO;
import com.fiap.techChallenge.TechChallenge.domain.Endereco;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import com.fiap.techChallenge.TechChallenge.domain.Usuario;
import com.fiap.techChallenge.TechChallenge.repository.IEnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


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
            return new EnderecoResultDTO(enderecoRepository.save(endereco));
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao criar endereco: " + e.getMessage());
        }
    }

    @Override
    public EnderecoResultDTO listar(Long id) {
       return new EnderecoResultDTO(enderecoRepository.findById(id).get());
    }

    @Override
    public List<EnderecoResultDTO> listarEnderecosDeUsuario(Long id) {
        List <Endereco> enderecosEncontradas = enderecoRepository.findByUsuarioId(id);

        if(enderecosEncontradas.isEmpty())
            throw new IllegalArgumentException(String.format("Não foram encontradas pessoas para o id " + id));

        List<EnderecoResultDTO> enderecosResultDto = new ArrayList<>();
        for (Endereco endereco : enderecosEncontradas) {
            enderecosResultDto.add(new EnderecoResultDTO(endereco));
        }
        return enderecosResultDto;
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
