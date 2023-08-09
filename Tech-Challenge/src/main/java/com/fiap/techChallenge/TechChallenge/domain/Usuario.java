package com.fiap.techChallenge.TechChallenge.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
    private List<Endereco> enderecos;
    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
    private List<Pessoa> usuarios;
    @OneToMany(mappedBy = "usuario",fetch = FetchType.LAZY)
    private List<Eletrodomestico> eletrodomesticos;
}
