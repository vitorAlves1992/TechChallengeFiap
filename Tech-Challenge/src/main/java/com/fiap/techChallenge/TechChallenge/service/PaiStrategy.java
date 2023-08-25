package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.domain.Parente;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import com.fiap.techChallenge.TechChallenge.domain.Usuario;
import com.fiap.techChallenge.TechChallenge.domain.enums.ParentescoEnum;
import com.fiap.techChallenge.TechChallenge.repository.ParenteRepository;
import com.fiap.techChallenge.TechChallenge.service.parente.strategies.RebalanceStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PaiStrategy implements RebalanceStrategy {


    protected   ParenteRepository repository;

    PaiStrategy(ParenteRepository repository) {
        this.repository = repository;
    }





    @Override
    public List<Parente> rebalance(Pessoa pessoa, Usuario u) {
        List<Parente> parentescosDerivados = new ArrayList<>();
        for (Pessoa pessoaParente: u.getUsuarios()) {
            if (pessoa.equals(pessoaParente)) continue;
            Parente relacionamentoBase = repository.findRelacionamentoBase(pessoaParente.getId(), u.getPessoaUsuario().getId());
            if (relacionamentoBase != null) {
                Parente novoParentesco = new Parente();
                novoParentesco.setPessoaRelacionada(u.getPessoaUsuario());
                switch (relacionamentoBase.getParentesco()){
                    case IRMAOS:
                        novoParentesco.setParentesco(ParentescoEnum.FILHOS);
                        novoParentesco.setPessoa(pessoaParente);
                        novoParentesco.setPessoaRelacionada(pessoa);
                        parentescosDerivados.add(novoParentesco);
                        break;

                    case PAIS:
                        novoParentesco.setParentesco(ParentescoEnum.CONJUGE);
                        novoParentesco.setPessoa(pessoaParente);
                        novoParentesco.setPessoaRelacionada(pessoa);
                        parentescosDerivados.add(novoParentesco);
                        break;
                }}
        };




        return parentescosDerivados;
    }
}
