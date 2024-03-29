package com.fiap.techChallenge.TechChallenge.controller;

import com.fiap.techChallenge.TechChallenge.controller.dto.PessoaDTO;
import com.fiap.techChallenge.TechChallenge.controller.dto.PessoaResultDTO;
import com.fiap.techChallenge.TechChallenge.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
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
    public ResponseEntity<PessoaResultDTO> inserir(@RequestBody @Valid PessoaDTO pessoaForm) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.salvar(pessoaForm));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PessoaResultDTO> atualizar(@RequestBody @Valid PessoaDTO pessoaForm, @PathVariable @Positive Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.atualizar(pessoaForm, id));
    }

    @GetMapping(path = "/usuario/{id}")
    public ResponseEntity<List<PessoaResultDTO>> listarPessoasDeUsuario(@PathVariable("id") @Positive  Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listarPessoasUsuario(id));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PessoaResultDTO> listar(@PathVariable("id") @Positive Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.listar(id));
    }
    @GetMapping
    public ResponseEntity<List<PessoaResultDTO>> buscaAvancada(@RequestParam("idUsuario") @Valid @NotNull   (message = "O parâmetro 'idUsuario' é obrigatório")
                                                                   Long idUsuario,
                                                                @RequestParam(required = false) String nome,
                                                                 @RequestParam(required = false)
                                                                 @Valid @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                                                 @RequestParam(required = false) String sexo,
                                                                 @RequestParam(required = false) String parentesco) {

        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscaAvancada(nome, date, sexo, parentesco, idUsuario));
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") @Positive Long id) {
        pessoaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
