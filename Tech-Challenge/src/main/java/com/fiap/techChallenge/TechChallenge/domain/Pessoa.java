package com.fiap.techChallenge.TechChallenge.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Getter@Setter
@Component
public class Pessoa {
    private Integer idUsuario;
    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private String sexo;
    private String parentesco;


    public void setId(){
        Random random = new Random();
        this.id = Math.abs(random.nextInt());
    }
}
