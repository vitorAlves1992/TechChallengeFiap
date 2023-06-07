package com.fiap.techChallenge.TechChallenge.controller;

import com.fiap.techChallenge.TechChallenge.controller.form.PessoaForm;
import com.fiap.techChallenge.TechChallenge.controller.form.PessoaResultForm;
import com.fiap.techChallenge.TechChallenge.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/*@ApiResponses(value = {
        @ApiResponse(code = 200, message = "Processo realizado com sucesso"),
        @ApiResponse(code = 400, message = "Näo foi possivel inserir"),
        @ApiResponse(code = 401, message = "Autenticação não realizada / Usuario e/ou senha inválida"),
        @ApiResponse(code = 403, message = "Usuario não possui permissão para acessar esta API"),
        @ApiResponse(code = 404, message = "Status não encontrado"),
        @ApiResponse(code = 500, message = "Erro de servidor")
})*/

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
    public ResponseEntity<PessoaResultForm> atualizar(@RequestBody @Valid PessoaForm pessoaForm, @PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.atualizar(pessoaForm, id));
    }

    @GetMapping(path = "/usuario/{id}")
    public ResponseEntity<List<PessoaResultForm>> listarPessoasDeUsuario(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listarPessoasUsuario(id));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PessoaResultForm> listar(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listar(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") String id) {
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
