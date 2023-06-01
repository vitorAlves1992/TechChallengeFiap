package com.fiap.techChallenge.TechChallenge.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorMessage {
    private String message;

    public ErrorMessage(String message) {
        this.message = message;
    }

}
