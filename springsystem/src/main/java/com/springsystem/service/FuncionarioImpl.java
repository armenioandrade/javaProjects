package com.springsystem.service;

import com.springsystem.dao.FuncionarioDao;
import com.springsystem.domain.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/*
 * A anotação @Service indica ao Spring que essa é uma classe de Serviço. A anotação Transactional indica ao Spring quais métodos ou classes
 * precisam de uma transação no banco de dados. Ex: Os métodos de insert,update e delete precisam de uma transação pra caso algo dê errado ter como voltar
 * */
@Transactional(readOnly = true) @Service
public class FuncionarioImpl implements  FuncionarioService{
    
    @Autowired
    private FuncionarioDao dao;

    @Override @Transactional(readOnly = false)
    public void salvar(Funcionario funcionario) {
    dao.save(funcionario);
    }
    @Transactional(readOnly = false)
    @Override
    public void editar(Funcionario funcionario) {
    dao.update(funcionario);
    }
    @Transactional(readOnly = false)
    @Override
    public void excluir(Long id) {
    dao.delete(id);
    }

    @Override
    public Funcionario buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    public List<Funcionario> buscarTodos() {
        return dao.findAll();
    }
}
