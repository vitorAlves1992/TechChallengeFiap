package com.fiap.techChallenge.TechChallenge.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Random;
@Getter@Setter
@Entity
@Table(name = "eletrodomestico")
public class Eletrodomestico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    @Column(name = "nome")
    private String nome;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "potencia")
    private Double potencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public void setId(){
        Random random = new Random();
        this.id = Math.abs(random.nextInt());
    }

}
