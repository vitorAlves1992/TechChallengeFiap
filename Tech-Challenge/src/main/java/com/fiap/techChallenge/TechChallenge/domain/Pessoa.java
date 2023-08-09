package com.fiap.techChallenge.TechChallenge.domain;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

@Getter@Setter
@Component
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_nascimento",columnDefinition = "DATE")
    private LocalDate dataNascimento;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "parentesco")
    private String parentesco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @OneToMany(mappedBy = "pessoa")
    private List<Parente> parentes;

    @OneToMany(mappedBy = "pessoaRelacionada")
    private List<Parente> parentesRelacionados;


    public void setId(){
        Random random = new Random();
        this.id = Math.abs(random.nextInt());
    }
}
