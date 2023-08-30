package com.fiap.techChallenge.TechChallenge.domain;

import com.fiap.techChallenge.TechChallenge.domain.enums.ParentescoEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "parente",uniqueConstraints = {@UniqueConstraint(columnNames = {"pessoa_id", "pessoa_relacionada_id"})})
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parente parente = (Parente) o;

        if (!Objects.equals(pessoa, parente.pessoa)) return false;
        if (!Objects.equals(pessoaRelacionada, parente.pessoaRelacionada))
            return false;
        return parentesco == parente.parentesco;
    }

    @Override
    public int hashCode() {
        int result = pessoa != null ? pessoa.hashCode() : 0;
        result = 31 * result + (pessoaRelacionada != null ? pessoaRelacionada.hashCode() : 0);
        result = 31 * result + (parentesco != null ? parentesco.hashCode() : 0);
        return result;
    }
}
