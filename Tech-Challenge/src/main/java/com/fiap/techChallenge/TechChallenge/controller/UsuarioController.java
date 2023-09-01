package com.fiap.techChallenge.TechChallenge.controller;

import com.fiap.techChallenge.TechChallenge.controller.dto.UsuarioDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.UsuarioResultDTO;
import com.fiap.techChallenge.TechChallenge.service.usuario.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @PostMapping
    @Operation(summary = "Criar usuario")
    public ResponseEntity<UsuarioResultDTO> createUser(@Valid @RequestBody UsuarioDTO usuario) {
        UsuarioResultDTO novoUsuario = service.criarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Busca todos usuarios")
    public ResponseEntity<List<UsuarioResultDTO>> getAll() {
        List<UsuarioResultDTO> usuarios = service.listarUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca usuario por ID")
    public ResponseEntity<UsuarioResultDTO> userById(@PathVariable Long id) {
        return service.encontrarUsuarioPorId(id)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza Usuario")
    public ResponseEntity<UsuarioResultDTO> atualizarUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuario) {
        UsuarioResultDTO usuarioAtualizado = service.atualizarUsuario(id, usuario);
        return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar usuario por Id")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deletarUsuario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
