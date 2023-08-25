package com.fiap.techChallenge.TechChallenge.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fiap.techChallenge.TechChallenge.domain.Parente;
import com.fiap.techChallenge.TechChallenge.domain.Usuario;
import com.fiap.techChallenge.TechChallenge.domain.enums.ParentescoEnum;
import com.fiap.techChallenge.TechChallenge.repository.IUsuarioRepository;
import com.fiap.techChallenge.TechChallenge.repository.ParenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.techChallenge.TechChallenge.controller.dto.PessoaDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.PessoaResultDTO;
import com.fiap.techChallenge.TechChallenge.domain.Endereco;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import com.fiap.techChallenge.TechChallenge.repository.IEnderecoRepository;
import com.fiap.techChallenge.TechChallenge.repository.IPessoaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    private IPessoaRepository pessoaRepository;
    @Autowired
    private IEnderecoRepository enderecoRepository;

    @Autowired
    private ParenteRepository parenteRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Transactional
    @Override
    @Transactional
    public PessoaResultDTO salvar(PessoaDTO pessoaDto) {
        try {
            Pessoa pessoa = new Pessoa(pessoaDto);
            Endereco endereco = enderecoRepository.getReferenceById(pessoaDto.getIdEndereco());
            pessoa.setEndereco(endereco);
            Long idParentesco = pessoaDto.getIdParentesco();
            Usuario usuario = usuarioRepository.findById(pessoaDto.getIdUsuario()).get();
            Pessoa pessoaUsuario = usuario.getPessoaUsuario();
            Parente novoParente = parenteFactory(pessoa, idParentesco, pessoaUsuario);
            parenteRepository.save(novoParente);

            //fazer rebalanceamento de relacionamentos dessa pessoa
            /*
            - para cada pessoa desse usuário fazer o seguinte:
             */
            switch (ParentescoEnum.fromLong(idParentesco).get()) {
                case PAI:
                case MAE:
                    Parente filho = parenteFactory(pessoaUsuario, ParentescoEnum.FILHOS.getId(), pessoa);
                    parenteRepository.save(filho);
                    break;
                case FILHOS:
                    Parente pai = parenteFactory(pessoaUsuario, ParentescoEnum.PAI.getId(), pessoa);
                    parenteRepository.save(pai);
                    break;
                case CONJUGE:
                    Parente conjuge = parenteFactory(pessoaUsuario, ParentescoEnum.CONJUGE.getId(), pessoa);
                    parenteRepository.save(conjuge);
                    break;
                case IRMAOS:
                    Parente irmaos = parenteFactory(pessoaUsuario, ParentescoEnum.IRMAOS.getId(), pessoa);
                    parenteRepository.save(irmaos);
                    break;
            }


        /*    pessoaRepository.saveAndFlush(pessoa);

            usuario.getUsuarios().stream().forEach(
                    p -> {
                        Parente relacionamentoBase = parenteRepository.findRelacionamentoBase(p.getId(), usuario.getId());
                        System.out.println(relacionamentoBase.getParentesco().getDescricao());
                    }
            );*/

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


    private Parente parenteFactory(Pessoa pessoa, Long idParentesco, Pessoa pessoaRelacionada){
        Parente novoParente = new Parente();
        novoParente.setPessoa(pessoa);

        //inserir tratamento de exceção ao não encontrar parente aqui
        novoParente.setParentesco(ParentescoEnum.fromLong(idParentesco).get());
        novoParente.setPessoaRelacionada(pessoaRelacionada);
        return novoParente;
    }

}
