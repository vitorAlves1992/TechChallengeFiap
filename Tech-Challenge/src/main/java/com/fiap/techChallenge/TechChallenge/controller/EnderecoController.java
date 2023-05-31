package com.fiap.techChallenge.TechChallenge.controller;

import com.fiap.techChallenge.TechChallenge.controller.form.EnderecoForm;
import com.fiap.techChallenge.TechChallenge.controller.form.EnderecoResultForm;
import com.fiap.techChallenge.TechChallenge.service.EnderecoService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Processo realizado com sucesso"),
            @ApiResponse(code = 400, message = "Näo foi possivel inserir"),
            @ApiResponse(code = 401, message = "Autenticação não realizada / Usuario e/ou senha inválida"),
            @ApiResponse(code = 403, message = "Usuario não possui permissão para acessar esta API"),
            @ApiResponse(code = 404, message = "Status não encontrado"),
            @ApiResponse(code = 500, message = "Erro de servidor")
    })
    public ResponseEntity<EnderecoResultForm> inserir(@RequestBody @Valid EnderecoForm enderecoForm){
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
