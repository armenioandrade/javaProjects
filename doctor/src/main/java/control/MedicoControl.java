package control;

import dao.MedicoDao;
import entity.Medico;
import java.util.ArrayList;

public class MedicoControl {

    MedicoDao dao = new MedicoDao();
    Medico medico = new Medico();

    public void insert(Medico medico) {
        try {
            dao.create(medico);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(Medico medico) {
        try {
            dao.update(medico);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Medico> list() {
        try {
            return dao.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void delete(int id) {
        try {
            dao.delete(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Medico selectById(int id) {
        try {
            medico = dao.getDetailsById(id);
            return medico;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Medico selectByName(Medico medico) {
        try {
            medico = dao.getIdByName(medico);
            return medico;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}
