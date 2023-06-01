package com.fiap.techChallenge.TechChallenge.controller;

import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoForm;
import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoResultForm;
import com.fiap.techChallenge.TechChallenge.service.EletrodomesticoService;
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
@RequestMapping("/eletrodomestico")
public class EletrodomesticoController {
    @Autowired
    private EletrodomesticoService eletrodomesticoService;

    @PostMapping
    public ResponseEntity<EletrodomesticoResultForm> inserir(@RequestBody @Valid EletrodomesticoForm eletrodomesticoForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eletrodomesticoService.salvar(eletrodomesticoForm));
    }
    @GetMapping(path = "/usuario/{id}")
    public ResponseEntity<List<EletrodomesticoResultForm>> listarEletrodomesticosDeUsuario(@PathVariable("id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(eletrodomesticoService.listarEletrodomesticosDeUsuario(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Void> atualizar(@RequestBody @Valid EletrodomesticoForm eletrodomesticoForm, @PathVariable String id) {
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
