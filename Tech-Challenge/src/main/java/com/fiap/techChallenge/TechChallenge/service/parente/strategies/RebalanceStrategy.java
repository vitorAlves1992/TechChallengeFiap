package com.fiap.techChallenge.TechChallenge.service.parente.strategies;

import com.fiap.techChallenge.TechChallenge.domain.Parente;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import com.fiap.techChallenge.TechChallenge.domain.Usuario;


import java.util.List;
import java.util.Set;


public interface RebalanceStrategy {

    Set<Parente> rebalance(Pessoa pessoa, Usuario u);
}
