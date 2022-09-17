package docs.dao;

import docs.entity.Paciente;
import java.util.ArrayList;
import java.util.List;

public class PacienteDao {

    Paciente paciente = new Paciente();
    List<Paciente> lista = new ArrayList<>();

    public PacienteDao() {
    }

    public List<Paciente> search(Paciente filtro) {
        return lista;
    }

    public Paciente select() {
        return paciente;
    }

    public void insert(Paciente paciente) {

    }

    public void update(Paciente paciente) {

    }

    public void delete(Paciente paciente) {

    }

    public List<Paciente> searchAll() {
        return lista;
    }
}
