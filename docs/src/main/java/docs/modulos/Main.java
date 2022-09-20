    
package docs.modulos;

import docs.dao.MedicoDao;
import docs.entity.Medico;

public class Main {
    public static void main(String[] args) {
            Medico medico = new Medico();
            MedicoDao md = new MedicoDao();
            System.out.println(md.search(medico));
    }
}
