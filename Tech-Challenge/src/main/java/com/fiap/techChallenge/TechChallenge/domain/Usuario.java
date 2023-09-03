package com.fiap.techChallenge.TechChallenge.domain;

import com.fiap.techChallenge.TechChallenge.controller.dto.UsuarioDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
    @SequenceGenerator(name = "usuario_sequence", sequenceName = "user_seq", initialValue = 6)
    private Long id;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY , cascade = CascadeType.REMOVE)
    private List<Endereco> enderecos;


    public Usuario() {
    }

    public Usuario(Long id) {
        this.id = id;
    }

}
