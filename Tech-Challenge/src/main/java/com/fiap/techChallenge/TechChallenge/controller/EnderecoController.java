package com.fiap.techChallenge.TechChallenge.controller;

import com.fiap.techChallenge.TechChallenge.controller.form.EnderecoForm;
import com.fiap.techChallenge.TechChallenge.controller.form.EnderecoResultForm;
import com.fiap.techChallenge.TechChallenge.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoResultForm> inserir(@RequestBody EnderecoForm enderecoForm){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.salvar(enderecoForm));
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody EnderecoForm enderecoForm, @PathVariable String id){
        enderecoService.atualizar(enderecoForm, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EnderecoResultForm> listar(@PathVariable("id") String id){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.listar(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id){
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
