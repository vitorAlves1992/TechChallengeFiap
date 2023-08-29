package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.domain.Parente;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import com.fiap.techChallenge.TechChallenge.domain.Usuario;
import com.fiap.techChallenge.TechChallenge.domain.enums.ParentescoEnum;
import com.fiap.techChallenge.TechChallenge.repository.ParenteRepository;
import com.fiap.techChallenge.TechChallenge.service.parente.strategies.RebalanceStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class PaiStrategy implements RebalanceStrategy {


    protected   ParenteRepository repository;

    PaiStrategy(ParenteRepository repository) {
        this.repository = repository;
    }





    @Override
    public Set<Parente> rebalance(Pessoa pessoa, Usuario u) {
        Set<Parente> parentescosDerivados = new HashSet<>();
        for (Pessoa pessoaParente: u.getUsuarios()) {
            if (pessoa.equals(pessoaParente)) continue;
            Parente relacionamentoBase = repository.findRelacionamentoBase(pessoaParente.getId(), u.getPessoaUsuario().getId());
            if (relacionamentoBase != null) {
                Parente novoParentesco = new Parente();
                Parente novoParentescoReverso = new Parente();
                switch (relacionamentoBase.getParentesco()){
                    case IRMAOS:
                        novoParentesco.setParentesco(ParentescoEnum.PAIS);
                        novoParentesco.setPessoa(pessoaParente);
                        novoParentesco.setPessoaRelacionada(pessoa);
                        parentescosDerivados.add(novoParentesco);

                        novoParentescoReverso.setParentesco(ParentescoEnum.FILHOS);
                        novoParentescoReverso.setPessoa(pessoa);
                        novoParentescoReverso.setPessoaRelacionada(pessoaParente);
                        parentescosDerivados.add(novoParentescoReverso);
                        break;

                    case PAIS:
                        novoParentesco.setParentesco(ParentescoEnum.CONJUGE);
                        novoParentesco.setPessoa(pessoaParente);
                        novoParentesco.setPessoaRelacionada(pessoa);
                        parentescosDerivados.add(novoParentesco);

                        novoParentescoReverso.setParentesco(ParentescoEnum.CONJUGE);
                        novoParentescoReverso.setPessoa(pessoa);
                        novoParentescoReverso.setPessoaRelacionada(pessoaParente);
                        parentescosDerivados.add(novoParentescoReverso);
                        break;
                }}
        };




        return parentescosDerivados;
    }
}
