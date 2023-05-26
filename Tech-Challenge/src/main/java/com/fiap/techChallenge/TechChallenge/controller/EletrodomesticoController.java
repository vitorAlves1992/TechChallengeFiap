package com.fiap.techChallenge.TechChallenge.controller;

import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoForm;
import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoResultForm;
import com.fiap.techChallenge.TechChallenge.controller.form.PessoaForm;
import com.fiap.techChallenge.TechChallenge.service.EletrodomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Eletrodomestico")
public class EletrodomesticoController {
    @Autowired
    private EletrodomesticoService eletrodomesticoService;

    @PostMapping
    public ResponseEntity<EletrodomesticoResultForm> inserir(@RequestBody EletrodomesticoForm eletrodomesticoForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eletrodomesticoService.salvar(eletrodomesticoForm));
    }
    @GetMapping(path = "/Usuario/{id}")
    public ResponseEntity<List<EletrodomesticoResultForm>> listarEletrodomesticosDeUsuario(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(eletrodomesticoService.listarEletrodomesticosDeUsuario(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody EletrodomesticoForm eletrodomesticoForm, @PathVariable String id) {
        eletrodomesticoService.atualizar(eletrodomesticoForm, id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EletrodomesticoResultForm> listar(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(eletrodomesticoService.listar(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
        eletrodomesticoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
