package com.fiap.techChallenge.TechChallenge.service;

import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoForm;
import com.fiap.techChallenge.TechChallenge.controller.form.EletrodomesticoResultForm;

public interface EletrodomesticoService {
    public EletrodomesticoResultForm salvar(EletrodomesticoForm eletrodomesticoForm);
}
