package com.fiap.techChallenge.TechChallenge.domain;

import com.fiap.techChallenge.TechChallenge.domain.enums.ParentescoEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "parente",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"pessoa_id", "pessoa_relacionada_id"})})
@Getter@Setter
public class Parente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ManyToOne
    @JoinColumn(name = "pessoa_relacionada_id")
    private Pessoa pessoaRelacionada;

    @Enumerated(EnumType.STRING)
    private ParentescoEnum parentesco;

}
