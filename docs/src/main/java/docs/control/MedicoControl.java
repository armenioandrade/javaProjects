package docs.control;

import docs.dao.MedicoDao;
import docs.entity.Medico;
import gate.constraint.Constraints;
import gate.error.AppException;
import gate.error.NotFoundException;
import gate.type.ID;
import java.util.List;
import java.util.ResourceBundle.Control;

public class MedicoControl extends Control {

    public void insert(Medico medico) throws AppException {
        Constraints.validate(medico, "nome", "sexo", "crm", "cpf");
        try ( MedicoDao dao = new MedicoDao()) {
            dao.insert(medico);
        }

    }
    	public List<Medico> search(Medico filtro)
	{
		try ( MedicoDao dao = new MedicoDao())
		{
			return dao.search(filtro);
		}
	}
        
        	public Medico select(ID id) throws NotFoundException
	{
		try ( MedicoDao dao = new MedicoDao())
		{
			return dao.select(id);
		}
	}
                
                	public void delete(Medico medico) throws AppException
	{

		try ( MedicoDao dao = new MedicoDao())
		{
			dao.delete(medico);
		}
	}
                        
                        	public void update(Medico medico) throws AppException
	{

		Constraints.validate(medico, "nome", "sexo", "crm", "cpf");
		try ( MedicoDao dao = new MedicoDao())
		{
			dao.update(medico);
		}
	}
        public List<Medico> searchAll()
	{
		try ( MedicoDao dao = new MedicoDao())
		{
			return dao.searchAll();
		}
	}                        
                                
}
