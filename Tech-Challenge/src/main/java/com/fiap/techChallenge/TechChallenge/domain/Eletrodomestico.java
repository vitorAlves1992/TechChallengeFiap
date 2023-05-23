package com.fiap.techChallenge.TechChallenge.domain;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class Eletrodomestico {
    private Integer idUsuario;
    private Integer id ;
    private String nome;
    private String modelo;
    private Integer potencia;

    public void setId(){
        Random random = new Random();
        this.id = Math.abs(random.nextInt());
    }
}
