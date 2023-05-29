package com.fiap.techChallenge.TechChallenge.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;
@Getter@Setter
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
