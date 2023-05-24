package com.fiap.techChallenge.TechChallenge.config;

import com.fiap.techChallenge.TechChallenge.controller.form.EnderecoForm;
import com.fiap.techChallenge.TechChallenge.domain.Endereco;
import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.googlecode.jmapper.api.JMapperAPI.attribute;
import static com.googlecode.jmapper.api.JMapperAPI.mappedClass;

@Configuration
public class EnderecoMapperBean {
    @Bean
    public JMapper<Endereco, EnderecoForm> enderecoMapper(){
        JMapperAPI jmapperAPI = new JMapperAPI()
                .add(mappedClass(Endereco.class)
                        .add(attribute("id").value("id"))
                        .add(attribute("rua").value("rua"))
                        .add(attribute("numero").value("numero"))
                        .add(attribute("bairro").value("bairro"))
                        .add(attribute("cidade").value("cidade"))
                        .add(attribute("estado").value("estado")));

        return new JMapper<>(Endereco.class, EnderecoForm.class, jmapperAPI);
    }
    @Bean
    public JMapper<EnderecoForm, Endereco> enderecoFormMapper(){
        JMapperAPI jmapperAPI = new JMapperAPI()
                .add(mappedClass(EnderecoForm.class)
                        .add(attribute("id").value("id"))
                        .add(attribute("rua").value("rua"))
                        .add(attribute("numero").value("numero"))
                        .add(attribute("bairro").value("bairro"))
                        .add(attribute("cidade").value("cidade"))
                        .add(attribute("estado").value("estado")));

        return new JMapper<>(EnderecoForm.class, Endereco.class, jmapperAPI);
    }


}
