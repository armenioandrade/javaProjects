package com.springsystem.service;

import com.springsystem.dao.DepartamentoDao;
import com.springsystem.domain.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
/*
 * A anotação @Service indica ao Spring que essa é uma classe de Serviço. A anotação Transactional indica ao Spring quais métodos ou classes
 * precisam de uma transação no banco de dados. Ex: Os métodos de insert,update e delete precisam de uma transação pra caso algo dê errado ter como voltar
 * */
@Service
public class DepartamentoServiceImpl implements DepartamentoService{
    @Autowired
    private DepartamentoDao dao;

    @Override @Transactional
    public void salvar(Departamento departamento) {
    dao.save(departamento);
    }

    @Override @Transactional
    public void editar(Departamento departamento) {
    dao.update(departamento);
    }

    @Override @Transactional
    public void excluir(Long id) {
    dao.delete(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Departamento buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Departamento> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public boolean departamentoTemCargos(Long id) {
        if(buscarPorId(id).getCargos().isEmpty()){
            return false;
        }
        return true;
    }
}
