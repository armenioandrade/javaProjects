package docs.control;

import com.sun.mail.imap.protocol.ID;
import docs.dao.PacienteDao;
import docs.entity.Paciente;
import java.util.ArrayList;

import java.util.List;
import javax.swing.SpringLayout.Constraints;
import javax.ws.rs.NotFoundException;

public class PacienteControl {

    Paciente paciente;
    List<Paciente> lista = new ArrayList<>();

    public List<Paciente> search(Paciente filtro) {
        return lista;
    }

    public Paciente select(Paciente paciente) {
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
