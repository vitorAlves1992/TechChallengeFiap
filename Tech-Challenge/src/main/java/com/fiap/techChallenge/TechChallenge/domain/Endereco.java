package com.fiap.techChallenge.TechChallenge.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


import javax.persistence.*;
import java.util.List;
import java.util.Random;

@Getter
@Setter
@Component
@EqualsAndHashCode(exclude = {"id"})
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @OneToMany(mappedBy = "endereco",fetch = FetchType.LAZY)
    private List<Pessoa> pessoas;
    @OneToMany(mappedBy = "endereco",fetch = FetchType.LAZY)
    private List<Eletrodomestico> eletrodomesticos;


    @Column(name = "rua")
    private String rua;
    @Column(name = "numero")
    private Integer numero;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;

    public void setId(){
        Random random = new Random();
        this.id = Math.abs(random.nextInt());
    }
}
