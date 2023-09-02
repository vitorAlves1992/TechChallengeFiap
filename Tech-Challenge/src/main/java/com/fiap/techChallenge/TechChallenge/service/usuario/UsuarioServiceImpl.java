package com.fiap.techChallenge.TechChallenge.service.usuario;

import com.fiap.techChallenge.TechChallenge.controller.dto.UsuarioDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.UsuarioResultDTO;
import com.fiap.techChallenge.TechChallenge.domain.Usuario;
import com.fiap.techChallenge.TechChallenge.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private IUsuarioRepository repository;

    @Override
    @Transactional
    public UsuarioResultDTO criarUsuario(UsuarioDTO usuario) {
        Usuario user = new Usuario();
        user.setEmail(usuario.getEmail());
        UsuarioResultDTO response = new UsuarioResultDTO();
        Usuario save = repository.save(user);

        response.setId(save.getId());
        response.setEmail(save.getEmail());

        return response;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioResultDTO> listarUsuarios() {

        List<UsuarioResultDTO> responses = new ArrayList<>();
        List<Usuario> users = repository.findAll();

        for (Usuario e : users) {
            UsuarioResultDTO dto = new UsuarioResultDTO();

            dto.setId(e.getId());
            dto.setEmail(e.getEmail());
            responses.add(dto);

        }

        return responses;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UsuarioResultDTO> encontrarUsuarioPorId(Long id) {
        UsuarioResultDTO response = new UsuarioResultDTO();
        Optional<Usuario> user = repository.findById(id);

        if (user.isPresent()) {
            response.setEmail(user.get().getEmail());
            response.setId(user.get().getId());
            return Optional.of(response);

        } else {
            throw new IllegalArgumentException("Usuário não encontrado com o ID: " + id);
        }
    }

    @Override
    @Transactional
    public UsuarioResultDTO atualizarUsuario(Long id, UsuarioDTO usuario) {
        UsuarioResultDTO response = new UsuarioResultDTO();
        Optional<Usuario> usuarioExistente = repository.findById(id);
        if (usuarioExistente.isPresent()) {
            Usuario usuarioAtualizado = usuarioExistente.get();
            usuarioAtualizado.setEmail(usuario.getEmail());

            Usuario user = repository.saveAndFlush(usuarioAtualizado);
            response.setId(user.getId());
            response.setEmail(user.getEmail());

            return response;
        } else {
            throw new IllegalArgumentException("Usuário não encontrado com o ID: " + id);
        }
    }

    @Override
    @Transactional
    public void deletarUsuario(Long id) {
        Optional<Usuario> usuarioExistente = repository.findById(id);
        if (usuarioExistente.isPresent()){
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Usuário não encontrado com o ID: " + id);
        }
    }
}
