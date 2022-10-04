package com.springsystem.dao;
import com.springsystem.domain.Funcionario;

import java.util.List;

public interface FuncionarioDao {
    void save(Funcionario funcionario);
    void update(Funcionario funcionario);
    void delete(Long id);
    Funcionario findById(Long id);
    List<Funcionario> findAll();
}
