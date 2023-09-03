package com.fiap.techChallenge.TechChallenge.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.fiap.techChallenge.TechChallenge.controller.dto.PessoaDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_nascimento", columnDefinition = "DATE")
    private LocalDate dataNascimento;
    @Column(name = "sexo")
    private String sexo;
    @Column
    private String parentesco;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;


    public Pessoa() {
    }

    public Pessoa(PessoaDTO dto) {
        this.nome = dto.getNome();
        this.dataNascimento = dto.getDataNascimento();
        this.sexo = dto.getSexo();
        this.parentesco = dto.getParentesco();
    }
}
