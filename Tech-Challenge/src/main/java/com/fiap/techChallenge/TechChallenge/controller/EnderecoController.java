package com.fiap.techChallenge.TechChallenge.controller;

import com.fiap.techChallenge.TechChallenge.controller.dto.EnderecoDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.EnderecoResultDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.eletrodomestico.EletrodomesticoResultDTO;
import com.fiap.techChallenge.TechChallenge.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoResultDTO> inserir(@RequestBody @Valid EnderecoDTO enderecoForm){
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecoService.salvar(enderecoForm));
    }
    @PutMapping(path = "/{id}")
    public ResponseEntity<EnderecoResultDTO> atualizar(@RequestBody @Valid EnderecoDTO enderecoForm, @PathVariable @Positive Long id){
        return ResponseEntity.ok(enderecoService.atualizar(enderecoForm, id));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EnderecoResultDTO> listar(@PathVariable("id") @Positive Long id){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.listar(id));
    }

    @GetMapping(path = "/usuario/{id}")
    public ResponseEntity<List<EnderecoResultDTO>> listarEnderecosUsuario(@PathVariable("id") @Positive Long id){
        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.listarEnderecosUsuario(id));
    }
    @GetMapping
    public ResponseEntity<List<EnderecoResultDTO>> buscaAvancada(@RequestParam(required = false) String rua,
                                                                        @RequestParam(required = false) Integer numero,
                                                                        @RequestParam(required = false) String bairro,
                                                                        @RequestParam(required = false) String cidade,
                                                                        @RequestParam(required = false) String estado) {

        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.buscaAvancada(rua, numero, bairro, cidade, estado));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") @Positive Long id){
        enderecoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
