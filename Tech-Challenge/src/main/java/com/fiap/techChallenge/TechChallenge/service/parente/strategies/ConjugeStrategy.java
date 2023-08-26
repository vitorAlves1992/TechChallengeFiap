package com.fiap.techChallenge.TechChallenge.service.parente.strategies;

import com.fiap.techChallenge.TechChallenge.domain.Parente;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import com.fiap.techChallenge.TechChallenge.domain.Usuario;
import com.fiap.techChallenge.TechChallenge.domain.enums.ParentescoEnum;
import com.fiap.techChallenge.TechChallenge.repository.ParenteRepository;

import java.util.HashSet;
import java.util.Set;

public class ConjugeStrategy implements RebalanceStrategy {
    private ParenteRepository repository;

    public ConjugeStrategy(ParenteRepository parenteRepository) {
    this.repository = parenteRepository;

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
                    case FILHOS:
                        novoParentesco.setParentesco(ParentescoEnum.FILHOS);
                        novoParentesco.setPessoa(pessoaParente);
                        novoParentesco.setPessoaRelacionada(pessoa);
                        parentescosDerivados.add(novoParentesco);

                        novoParentescoReverso.setParentesco(ParentescoEnum.PAIS);
                        novoParentescoReverso.setPessoa(pessoa);
                        novoParentescoReverso.setPessoaRelacionada(pessoaParente);
                        parentescosDerivados.add(novoParentescoReverso);
                        break;

                    case CONJUGE:
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
