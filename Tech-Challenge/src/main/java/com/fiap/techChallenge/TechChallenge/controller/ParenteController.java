package com.fiap.techChallenge.TechChallenge.controller;

import com.fiap.techChallenge.TechChallenge.controller.dto.ParenteDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.ParenteResultDTO;
import com.fiap.techChallenge.TechChallenge.service.parente.ParenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
@RequestMapping("/parente")
public class ParenteController {

    @Autowired
    private ParenteService parenteService;

    @GetMapping("/pessoa/{id}")
    public ResponseEntity<List<ParenteResultDTO>> getByPessoaId(@PathVariable Long id) {
        return ResponseEntity.ok(parenteService.getByPessoaId(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParenteResultDTO> getById(@PathVariable Long id) {
        ParenteResultDTO parente = parenteService.getById(id);
        if(parente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(parente);
    }

    @PostMapping
    public ResponseEntity<ParenteResultDTO> create(@RequestBody ParenteDTO request) {
        try {
            ParenteResultDTO savedParente = parenteService.save(request);
            return new ResponseEntity<>(savedParente, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ParenteResultDTO> update(@PathVariable Long id, @RequestBody ParenteDTO request) {
        try {
            return ResponseEntity.ok(parenteService.update(id, request));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            parenteService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
