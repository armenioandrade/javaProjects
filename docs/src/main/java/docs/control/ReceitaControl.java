package docs.control;

import docs.dao.ReceitaDao;
import docs.entity.Receita;
import gate.constraint.Constraints;
import gate.error.AppException;
import gate.error.NotFoundException;
import gate.type.ID;
import java.util.List;
import java.util.ResourceBundle.Control;

public class ReceitaControl extends Control {

    public List<Receita> searchAll(Receita filtro) {
        try ( ReceitaDao dao = new ReceitaDao()) {
            return dao.search(filtro);
        }
    }

    public void insert(Receita receita) throws AppException {
        Constraints.validate(receita, "medico", "paciente", "descricao");
        try ( ReceitaDao dao = new ReceitaDao()) {
            dao.insert(receita);
        }

    }

    public List<Receita> search(Receita filtro) {
        try ( ReceitaDao dao = new ReceitaDao()) {
            return dao.search(filtro);
        }
    }

    public Receita select(ID id) throws NotFoundException {
        try ( ReceitaDao dao = new ReceitaDao()) {
            return dao.select(id);
        }
    }

    public void delete(Receita receita) throws AppException {

        try ( ReceitaDao dao = new ReceitaDao()) {
            dao.delete(receita);
        }
    }

    public void update(Receita receita) throws AppException {

        Constraints.validate(receita, "medico", "paciente", "descricao");
        try ( ReceitaDao dao = new ReceitaDao()) {
            dao.update(receita);
        }
    }
}
