package com.fiap.techChallenge.TechChallenge.domain;

import com.fiap.techChallenge.TechChallenge.controller.dto.EnderecoDTO;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"id"})
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_sequence")
    @SequenceGenerator(name = "endereco_sequence", sequenceName = "end_seq", initialValue = 8)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToMany(mappedBy = "endereco",fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Pessoa> pessoas;

    @OneToMany(mappedBy = "endereco",fetch = FetchType.LAZY , cascade = CascadeType.REMOVE)
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

    public Endereco() {
    }

    public Endereco(EnderecoDTO form) {
        this.usuario = new Usuario(form.getIdUsuario());
        this.rua = form.getRua();
        this.numero = form.getNumero();
        this.bairro = form.getBairro();
        this.cidade = form.getCidade();
        this.estado = form.getEstado();
    }

    public Endereco(Long id) {
        this.id = id;
    }
}
