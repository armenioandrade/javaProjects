package com.springsystem.service;
import com.springsystem.dao.CargoDao;
import com.springsystem.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/*
* A anotação @Service indica ao Spring que essa é uma classe de Serviço. A anotação Transactional indica ao Spring quais métodos ou classes
* precisam de uma transação no banco de dados. Ex: Os métodos de insert,update e delete precisam de uma transação pra caso algo dê errado ter como voltar
* */

@Service @Transactional(readOnly = false)
public class CargoServiceImpl implements CargoService{
    @Autowired
    private CargoDao dao;

    @Override
    public void salvar(Cargo cargo) {
    dao.save(cargo);
    }

    @Override
    public void editar(Cargo cargo) {
    dao.update(cargo);
    }

    @Override
    public void excluir(Long id) {
    dao.delete(id);
    }

    @Override @Transactional(readOnly = true)
    public Cargo buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override @Transactional(readOnly = true)
    public List<Cargo> buscarTodos() {
        return dao.findAll();
    }
}

