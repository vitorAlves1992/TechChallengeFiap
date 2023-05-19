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

@RestController
@RequestMapping("/Pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private JMapper<Pessoa, PessoaForm> pessoaMapper;

    @Autowired
    private JMapper<PessoaForm, Pessoa> pessoaFormMapper;

    @PostMapping
    public ResponseEntity<PessoaForm> cadastro(@RequestBody PessoaForm pessoaForm){
        Pessoa pessoa = pessoaMapper.getDestination(pessoaForm);
        Pessoa pessoaSalva = pessoaService.salvar(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaFormMapper.getDestination(pessoaSalva));
    }
    @PutMapping
    public ResponseEntity<PessoaForm> atualizarPessoa(@RequestBody PessoaForm pessoaForm){
        Pessoa pessoa = pessoaMapper.getDestination(pessoaForm);
        Pessoa pessoaAtualizada = pessoaService.atualizarPessoa(pessoa);
        return ResponseEntity.status(HttpStatus.OK).body(pessoaFormMapper.getDestination(pessoaAtualizada));
    }
    @GetMapping(path = "/Usuario/{id}")
    public ResponseEntity<List<Pessoa>> listarPessoasDeUsuario(@PathVariable("id") String id){
        int idUsuario = Integer.parseInt(id);
        List<Pessoa> pessoasUsuario = pessoaService.listarPessoasUsuario(idUsuario);

        return ResponseEntity.status(HttpStatus.OK).body(pessoasUsuario);
    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<PessoaForm> listarPessoa(@PathVariable("id") String id){
        int idUsuario = Integer.parseInt(id);
        PessoaForm pessoaForm = pessoaFormMapper.getDestination(pessoaService.listarPessoa(idUsuario));
        return ResponseEntity.status(HttpStatus.OK).body(pessoaForm);
    }
    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Integer> deletarPessoa(@PathVariable("id") String idPessoaInput){
        int idPessoa = Integer.parseInt(idPessoaInput);
        boolean delete  = pessoaService.deletarPessoa(idPessoa);
        if(delete)
            return ResponseEntity.status(HttpStatus.OK).build();
        else
            return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }
}
