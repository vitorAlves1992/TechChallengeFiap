package com.fiap.techChallenge.TechChallenge.controller;

import com.fiap.techChallenge.TechChallenge.controller.form.PessoaForm;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import com.fiap.techChallenge.TechChallenge.repository.PessoaRepository;
import com.fiap.techChallenge.TechChallenge.service.PessoaService;
import com.googlecode.jmapper.JMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/Pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaForm> inserir(@RequestBody PessoaForm pessoaForm){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvar(pessoaForm));
    }
    @PutMapping
    public ResponseEntity<Void> atualizar(@RequestBody PessoaForm pessoaForm){
        pessoaService.atualizar(pessoaForm);
        return ResponseEntity.noContent().build();
    }
    @GetMapping(path = "/Usuario/{id}")
    public ResponseEntity<List<PessoaForm>> listarPessoasDeUsuario(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listarPessoasUsuario(id));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PessoaForm> listar(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listar(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id){
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
