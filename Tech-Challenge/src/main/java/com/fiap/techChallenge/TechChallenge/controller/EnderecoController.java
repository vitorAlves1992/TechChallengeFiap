package com.fiap.techChallenge.TechChallenge.controller;

import com.fiap.techChallenge.TechChallenge.controller.form.EnderecoForm;
import com.fiap.techChallenge.TechChallenge.controller.form.EnderecoResultDTO;
import com.fiap.techChallenge.TechChallenge.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoResultDTO> inserir(@RequestBody @Valid EnderecoForm enderecoForm){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.salvar(enderecoForm));
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<EnderecoResultDTO> atualizar(@RequestBody @Valid EnderecoForm enderecoForm, @PathVariable @Positive Long id){
        return ResponseEntity.ok(enderecoService.atualizar(enderecoForm, id));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EnderecoResultDTO> listar(@PathVariable("id") @Positive Long id){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.listar(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") @Positive Long id){
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
