package com.fiap.techChallenge.TechChallenge.service.parente.strategies;

import com.fiap.techChallenge.TechChallenge.domain.Parente;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import com.fiap.techChallenge.TechChallenge.domain.Usuario;


import java.util.List;


public interface RebalanceStrategy {

    List<Parente> rebalance(Pessoa pessoa, Usuario u);
}
