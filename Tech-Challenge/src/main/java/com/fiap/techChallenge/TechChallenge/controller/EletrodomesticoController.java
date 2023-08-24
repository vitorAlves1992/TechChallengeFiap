package com.fiap.techChallenge.TechChallenge.controller;

import com.fiap.techChallenge.TechChallenge.controller.dto.EletrodomesticoDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.EletrodomesticoResultDTO;
import com.fiap.techChallenge.TechChallenge.service.EletrodomesticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
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
    public ResponseEntity<EletrodomesticoResultDTO> inserir(@RequestBody @Valid EletrodomesticoDTO eletrodomesticoForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(eletrodomesticoService.salvar(eletrodomesticoForm));
    }
    @GetMapping(path = "/usuario/{id}")
    public ResponseEntity<List<EletrodomesticoResultDTO>> listarEletrodomesticosDeUsuario(@PathVariable("id") @Positive Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(eletrodomesticoService.listarEletrodomesticosDeUsuario(id));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EletrodomesticoResultDTO> atualizar(@RequestBody @Valid EletrodomesticoDTO eletrodomesticoForm, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(eletrodomesticoService.atualizar(eletrodomesticoForm, id));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<EletrodomesticoResultDTO> listar(@PathVariable("id") @Positive Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(eletrodomesticoService.listar(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") @Positive Long id) {
        eletrodomesticoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
