package docs.control;

import docs.dao.PacienteDao;
import docs.entity.Paciente;
import gate.constraint.Constraints;
import gate.error.AppException;
import gate.error.NotFoundException;
import gate.type.ID;
import java.util.List;
import java.util.ResourceBundle.Control;

public class PacienteControl extends Control
{

	public List<Paciente> search(Paciente filtro)
	{
		try ( PacienteDao dao = new PacienteDao())
		{
			return dao.search(filtro);
		}
	}

	public Paciente select(ID id) throws NotFoundException
	{
		try ( PacienteDao dao = new PacienteDao())
		{
			return dao.select(id);
		}
	}

	public void insert(Paciente paciente) throws AppException
	{

		Constraints.validate(paciente, "nome", "sexo", "dataNascimento", "cpf");
		try ( PacienteDao dao = new PacienteDao())
		{
			dao.insert(paciente);
		}
	}

	public void update(Paciente paciente) throws AppException
	{

		Constraints.validate(paciente, "nome", "sexo", "dataNascimento", "cpf");
		try ( PacienteDao dao = new PacienteDao())
		{
			dao.update(paciente);
		}
	}

	public void delete(Paciente paciente) throws AppException
	{

		try ( PacienteDao dao = new PacienteDao())
		{
			dao.delete(paciente);
		}
	}
        public List<Paciente> searchAll()
	{
		try ( PacienteDao dao = new PacienteDao())
		{
			return dao.searchAll();
		}
	} 

}
