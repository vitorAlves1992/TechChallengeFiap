package com.fiap.techChallenge.TechChallenge.service;

import java.util.*;

import com.fiap.techChallenge.TechChallenge.domain.Parente;
import com.fiap.techChallenge.TechChallenge.domain.Usuario;
import com.fiap.techChallenge.TechChallenge.domain.enums.ParentescoEnum;
import com.fiap.techChallenge.TechChallenge.repository.IUsuarioRepository;
import com.fiap.techChallenge.TechChallenge.repository.ParenteRepository;
import com.fiap.techChallenge.TechChallenge.service.parente.strategies.ConjugeStrategy;
import com.fiap.techChallenge.TechChallenge.service.parente.strategies.IrmaoStrategy;
import com.fiap.techChallenge.TechChallenge.service.parente.strategies.RebalanceStrategy;
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

    //@TODO trazer todas as excecoes do repository para dentro service

    @Autowired
    private IPessoaRepository pessoaRepository;
    @Autowired
    private IEnderecoRepository enderecoRepository;

    @Autowired
    protected ParenteRepository parenteRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Transactional
    @Override
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
                case PAIS:
                    Parente filho = parenteFactory(pessoaUsuario, ParentescoEnum.FILHOS.getId(), pessoa);
                    parenteRepository.save(filho);
                    break;
                case FILHOS:
                    Parente pai = parenteFactory(pessoaUsuario, ParentescoEnum.PAIS.getId(), pessoa);
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


            pessoaRepository.saveAndFlush(pessoa);

            Set<Parente> relacionamentosDerivados = new HashSet<>();

                        RebalanceStrategy strategy;
                        switch (novoParente.getParentesco()){
                            case PAIS:
                                 strategy = new PaiStrategy(parenteRepository);
                                 relacionamentosDerivados.addAll(strategy.rebalance(pessoa,usuario));
                                 break;
                            case IRMAOS:
                                strategy = new IrmaoStrategy(parenteRepository);
                                relacionamentosDerivados.addAll(strategy.rebalance(pessoa,usuario));
                                break;
                            case FILHOS:
                                strategy = new FilhoStrategy(parenteRepository);
                                relacionamentosDerivados.addAll(strategy.rebalance(pessoa,usuario));
                                break;
                            case CONJUGE:
                                strategy = new ConjugeStrategy(parenteRepository);
                                relacionamentosDerivados.addAll(strategy.rebalance(pessoa,usuario));
                                break;
                        }


            relacionamentosDerivados.stream().forEach(
                    p -> parenteRepository.save(p)
            );

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
