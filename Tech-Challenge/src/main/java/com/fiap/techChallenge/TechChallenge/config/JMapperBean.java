package com.fiap.techChallenge.TechChallenge.config;

import com.fiap.techChallenge.TechChallenge.controller.form.PessoaForm;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.googlecode.jmapper.api.JMapperAPI.attribute;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;


@Configuration
public class JMapperBean {
    @Bean
    public JMapper<Pessoa, PessoaForm> pessoaMapper(){
        JMapperAPI jmapperAPI = new JMapperAPI()
                .add(mappedClass(Pessoa.class)
                        .add(attribute("idUsuario").value("idUsuario"))
                        .add(attribute("id").value("id"))
                        .add(attribute("nome").value("nome"))
                        .add(attribute("dataNascimento").value("dataNascimento"))
                        .add(attribute("sexo").value("sexo"))
                        .add(attribute("parentesco").value("parentesco")));

        return new JMapper<>(Pessoa.class, PessoaForm.class, jmapperAPI);
    }
    @Bean
    public JMapper<PessoaForm, Pessoa> pessoaFormMapper(){
        JMapperAPI jmapperAPI = new JMapperAPI()
                .add(mappedClass(PessoaForm.class)
                        .add(attribute("idUsuario").value("idUsuario"))
                        .add(attribute("id").value("id"))
                        .add(attribute("nome").value("nome"))
                        .add(attribute("dataNascimento").value("dataNascimento"))
                        .add(attribute("sexo").value("sexo"))
                        .add(attribute("parentesco").value("parentesco")));

        return new JMapper<>(PessoaForm.class, Pessoa.class, jmapperAPI);
    }
}
