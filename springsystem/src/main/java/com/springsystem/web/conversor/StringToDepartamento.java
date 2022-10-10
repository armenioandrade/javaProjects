package com.springsystem.web.conversor;

import com.springsystem.domain.Departamento;
import com.springsystem.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToDepartamento implements Converter<String, Departamento> {

    @Autowired
    DepartamentoService service;

    @Override
    public Departamento convert(String text) {
        if(text.isEmpty()){
            return null;
        }
        Long id = Long.valueOf(text);
        return service.buscarPorId(id);
    }
}
