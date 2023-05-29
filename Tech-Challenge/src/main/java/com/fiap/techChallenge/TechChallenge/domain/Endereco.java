package com.fiap.techChallenge.TechChallenge.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Random;

@Getter
@Setter
@Component
@EqualsAndHashCode(exclude = {"id"})
public class Endereco {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
