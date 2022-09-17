package docs.control;

import docs.dao.MedicoDao;
import docs.entity.Medico;
import java.util.ArrayList;
import java.util.List;


public class MedicoControl {
    private Medico medico;
    
    public void insert(Medico medico){

         MedicoDao dao = new MedicoDao();
                 
    }

    public List<Medico> search(Medico filtro) {
        List<Medico> lista = new ArrayList<>();
        return lista;
    }

    public Medico select(){
        return medico;
    }

    public void delete(Medico medico) {

 
    }

    public void update(Medico medico){

    }

    public List<Medico> searchAll() {
        List<Medico> lista = new ArrayList<>();
        return lista;
    }

}
