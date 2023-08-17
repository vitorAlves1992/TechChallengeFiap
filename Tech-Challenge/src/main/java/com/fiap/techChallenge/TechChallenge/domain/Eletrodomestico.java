package com.fiap.techChallenge.TechChallenge.domain;

import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoForm;
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
    private Long id ;
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

    public Eletrodomestico() {
    }

    public Eletrodomestico(EletrodomesticoForm form) {
        this.nome = form.getNome();
        this.modelo = form.getModelo();
        this.potencia = form.getPotencia();
        this.usuario = new Usuario(form.getIdUsuario());
    }

}
