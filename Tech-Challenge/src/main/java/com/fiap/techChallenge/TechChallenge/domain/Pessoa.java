package com.fiap.techChallenge.TechChallenge.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

@Getter@Setter
@Component
public class Pessoa {
    private Integer idUsuario;
    private Integer id;
    private String nome;
    private LocalDate dataNascimento;
    private String sexo;  //@Todo para trocar enum
    private String parentesco;


    public void setId(){
        Random random = new Random();
        this.id = Math.abs(random.nextInt());
    }
}
