package com.fiap.techChallenge.TechChallenge.controller;

import com.fiap.techChallenge.TechChallenge.controller.form.PessoaForm;
import com.fiap.techChallenge.TechChallenge.controller.form.PessoaResultForm;
import com.fiap.techChallenge.TechChallenge.service.PessoaService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaResultForm> inserir(@RequestBody @Valid PessoaForm pessoaForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvar(pessoaForm));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody @Valid PessoaForm pessoaForm, @PathVariable String id) {
        pessoaService.atualizar(pessoaForm, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/usuario/{id}")
    public ResponseEntity<List<PessoaResultForm>> listarPessoasDeUsuario(@PathVariable("id") String id) {
        return ResponseEntity.ok(pessoaService.listarPessoasUsuario(id))/*status(HttpStatus.OK).body*/;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PessoaResultForm> listar(@PathVariable("id") String id) {
        return ResponseEntity.ok(pessoaService.listar(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
