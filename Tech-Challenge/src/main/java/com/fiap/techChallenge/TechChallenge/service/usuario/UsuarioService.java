package com.fiap.techChallenge.TechChallenge.service.usuario;

import com.fiap.techChallenge.TechChallenge.controller.dto.UsuarioDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.UsuarioResultDTO;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    UsuarioResultDTO criarUsuario(UsuarioDTO usuario);

    List<UsuarioResultDTO> listarUsuarios();

    Optional<UsuarioResultDTO> encontrarUsuarioPorId(Long id);

    UsuarioResultDTO atualizarUsuario(Long id, UsuarioDTO usuario);

    void deletarUsuario(Long id);
}
