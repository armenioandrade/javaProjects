package com.springsystem.web.validator;

import com.springsystem.domain.Funcionario;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.ConstraintViolation;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;
import java.time.LocalDate;
import java.util.Set;

public class FuncionarioValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Funcionario.class.equals(clazz);
    }

    @Override
    public void validate(Object object, Errors errors) {
        Funcionario f = (Funcionario) object;
        LocalDate entrada = f.getDataEntrada();
        if(f.getDataSaida() != null){
            if (f.getDataSaida().isBefore(entrada))
                errors.rejectValue("dataSaida", "PosteriorDataEntrada.funcionario.dataSaida");
        }

    }
}