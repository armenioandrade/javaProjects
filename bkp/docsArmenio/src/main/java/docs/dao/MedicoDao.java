/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docs.dao;

import docs.entity.Medico;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amaf
 */
public class MedicoDao {

    Medico medico = new Medico();
    List<Medico> lista = new ArrayList<>();

    public MedicoDao() {
    }

    public void insert(Medico medico) {

    }

    public List<Medico> search(Medico filtro) {
        return lista;
    }

    public Medico select() {
        return medico;
    }

    public void delete(Medico medico) {

    }

    public void update(Medico medico) {

    }

    public List<Medico> searchAll() {
        return lista;
    }
}
