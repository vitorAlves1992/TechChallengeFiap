package com.fiap.techChallenge.TechChallenge.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroValidacaoResponse> handleValidationException(MethodArgumentNotValidException ex) {
        ErroValidacaoResponse response = new ErroValidacaoResponse();
        response.setStatus(400);
        response.setMensagem("Erro de validação");

        List<String> erros = new ArrayList<>();

        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError) {
                FieldError fieldError = (FieldError) error;
                String mensagemErro = "Campo '" + fieldError.getField() + "': " + fieldError.getDefaultMessage();
                erros.add(mensagemErro);
            } else {
                erros.add(error.getDefaultMessage());
            }
        }

        response.setErros(erros);

        return ResponseEntity.badRequest().body(response);
    }
}
