package com.fiap.techChallenge.TechChallenge.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ErroValidacaoResponse {
    private int status;
    private String mensagem;
    private List<String> erros;


}
