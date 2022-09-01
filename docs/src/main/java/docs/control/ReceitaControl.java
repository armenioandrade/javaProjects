
package docs.control;

import docs.dao.MedicoDao;
import docs.entity.Medico;
import java.util.List;
import java.util.ResourceBundle.Control;


public class ReceitaControl extends Control{
    
        	public List<Medico> searchAll(Medico filtro)
	{
		try ( MedicoDao dao = new MedicoDao())
		{
			return dao.search(filtro);
		}
	}
}
