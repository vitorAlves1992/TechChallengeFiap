package com.fiap.techChallenge.TechChallenge.repository;

import com.fiap.techChallenge.TechChallenge.domain.Eletrodomestico;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
@Repository
public class EletrodomesticoRepository {
    private Collection <Eletrodomestico> eletrodomesticos = new ArrayList<>();

    public Eletrodomestico salvar (Eletrodomestico eletrodomestico){
        eletrodomestico.setId();
        eletrodomesticos.add(eletrodomestico);
        return eletrodomestico;
    }

}
