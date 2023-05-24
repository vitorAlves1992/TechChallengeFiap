package com.fiap.techChallenge.TechChallenge.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
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
