package com.fiap.techChallenge.TechChallenge.domain;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fiap.techChallenge.TechChallenge.controller.dto.PessoaDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
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
    @Column (name = "parentesco")
    private String parenstesco;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


    public Pessoa() {
    }

    public Pessoa(PessoaDTO dto) {
        this.nome = dto.getNome();
        this.dataNascimento = dto.getDataNascimento();
        this.sexo = dto.getSexo();
        this.parenstesco = dto.getParentesco();
        this.usuario = new Usuario(dto.getIdUsuario());
    }
}
