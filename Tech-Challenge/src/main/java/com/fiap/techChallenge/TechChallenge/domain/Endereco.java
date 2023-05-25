package com.fiap.techChallenge.TechChallenge.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Setter
@Component
@EqualsAndHashCode(exclude = {"id"})
public class Endereco {

    private Integer id;
    private String rua;
    private Integer numero;
    private String bairro;
    private String cidade;
    private String estado;

    public void setId(){
        Random random = new Random();
        this.id = Math.abs(random.nextInt());
    }
}
