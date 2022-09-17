package docs.control;

import docs.dao.ReceitaDao;
import docs.entity.Receita;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle.Control;

public class ReceitaControl {

    List<Receita> lista = new ArrayList();

    public List<Receita> searchAll(Receita filtro) {
        return lista;
    }

    public void insert(Receita receita) {


    }

    public List<Receita> search(Receita filtro) {
        return lista;
    }

    public Receita select(Receita receita) {
        return receita;
    }

    public void delete(Receita receita) {

    }

    public void update(Receita receita) {

    }
}

