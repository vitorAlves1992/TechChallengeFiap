package com.fiap.techChallenge.TechChallenge.config;

import com.fiap.techChallenge.TechChallenge.controller.form.*;
import com.fiap.techChallenge.TechChallenge.domain.Eletrodomestico;
import com.fiap.techChallenge.TechChallenge.domain.Endereco;
import com.fiap.techChallenge.TechChallenge.domain.Pessoa;
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.googlecode.jmapper.api.JMapperAPI.attribute;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;


@Configuration
public class MapperBean {
    @Bean
    public JMapper<Pessoa, PessoaForm> pessoaMapper(){
        JMapperAPI jmapperAPI = new JMapperAPI()
                .add(mappedClass(Pessoa.class)
                        .add(attribute("idUsuario").value("idUsuario"))
                        .add(attribute("nome").value("nome"))
                        .add(attribute("dataNascimento").value("dataNascimento"))
                        .add(attribute("sexo").value("sexo"))
                        .add(attribute("parentesco").value("parentesco")));

        return new JMapper<>(Pessoa.class, PessoaForm.class, jmapperAPI);
    }
    @Bean
    public JMapper<PessoaResultForm, Pessoa> pessoaFormMapper(){
        JMapperAPI jmapperAPI = new JMapperAPI()
                .add(mappedClass(PessoaResultForm.class)
                        .add(attribute("idUsuario").value("idUsuario"))
                        .add(attribute("id").value("id"))
                        .add(attribute("nome").value("nome"))
                        .add(attribute("dataNascimento").value("dataNascimento"))
                        .add(attribute("sexo").value("sexo"))
                        .add(attribute("parentesco").value("parentesco")));

        return new JMapper<>(PessoaResultForm.class, Pessoa.class, jmapperAPI);
    }
    @Bean
    public JMapper<Eletrodomestico, EletrodomesticoForm> eletrodomesticoMapper(){
        JMapperAPI jmapperAPI = new JMapperAPI()
                .add(mappedClass(Eletrodomestico.class)
                        .add(attribute("idUsuario").value("idUsuario"))
                        .add(attribute("nome").value("nome"))
                        .add(attribute("modelo").value("modelo"))
                        .add(attribute("potencia").value("potencia")));

        return new JMapper<>(Eletrodomestico.class, EletrodomesticoForm.class, jmapperAPI);
    }
    @Bean
    public JMapper<EletrodomesticoResultForm, Eletrodomestico> eletrodomesticoResultMapper(){
        JMapperAPI jmapperAPI = new JMapperAPI()
                .add(mappedClass(EletrodomesticoResultForm.class)
                        .add(attribute("idUsuario").value("idUsuario"))
                        .add(attribute("id").value("id"))
                        .add(attribute("nome").value("nome"))
                        .add(attribute("modelo").value("modelo"))
                        .add(attribute("potencia").value("potencia")));

        return new JMapper<>(EletrodomesticoResultForm.class, Eletrodomestico.class, jmapperAPI);
    }

    @Bean
    public JMapper<Endereco, EnderecoForm> enderecoMapper(){
        JMapperAPI jmapperAPI = new JMapperAPI()
                .add(mappedClass(Endereco.class)
                        .add(attribute("rua").value("rua"))
                        .add(attribute("numero").value("numero"))
                        .add(attribute("bairro").value("bairro"))
                        .add(attribute("cidade").value("cidade"))
                        .add(attribute("estado").value("estado")));

        return new JMapper<>(Endereco.class, EnderecoForm.class, jmapperAPI);
    }
    @Bean
    public JMapper<EnderecoResultForm, Endereco> enderecoResultFormMapper(){
        JMapperAPI jmapperAPI = new JMapperAPI()
                .add(mappedClass(EnderecoResultForm.class)
                        .add(attribute("id").value("id"))
                        .add(attribute("rua").value("rua"))
                        .add(attribute("numero").value("numero"))
                        .add(attribute("bairro").value("bairro"))
                        .add(attribute("cidade").value("cidade"))
                        .add(attribute("estado").value("estado")));

        return new JMapper<>(EnderecoResultForm.class, Endereco.class, jmapperAPI);
    }

}
