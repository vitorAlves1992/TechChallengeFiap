package com.fiap.techChallenge.TechChallenge.controller.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class ParenteDTO {

    @NotNull(message = "pessoaId não pode ser nulo.")
    private Long pessoaId;

    @NotNull(message = "pessoaRelacionadaId não pode ser nulo.")
    private Long pessoaRelacionadaId;

    private String parentesco;
}
