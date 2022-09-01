package docs.dao;

import docs.entity.Medico;
import docs.entity.Paciente;
import gate.base.Dao;
import gate.error.AppException;
import gate.error.ConstraintViolationException;
import gate.error.NotFoundException;
import gate.sql.Link;
import gate.sql.condition.Condition;
import gate.sql.delete.Delete;
import gate.sql.insert.Insert;
import gate.sql.select.Select;
import gate.sql.update.Update;
import gate.type.ID;
import java.util.List;

public class PacienteDao extends Dao
{

	public PacienteDao()
	{
	}

	public PacienteDao(Link link)
	{
		super(link);
	}

	public List<Paciente> search(Paciente filtro)
	{
		return Select.of(getClass().getResource("PacienteDao/search(Paciente).sql"))
			.where(Condition.TRUE
				.and("id").eq(filtro.getId())
				.and("sexo").eq(filtro.getSexo())
				.and("nome").lk(filtro.getNome())
				.and("dataNascimento").lk(filtro.getDataNascimento()))
			.build()
			.connect(getLink())
			.fetchEntityList(Paciente.class);
	}

	public Paciente select(ID id) throws NotFoundException
	{
		return getLink()
			.from(getClass().getResource("PacienteDao/select(ID).sql"))
			.parameters(id)
			.fetchEntity(Paciente.class)
			.orElseThrow(NotFoundException::new);
	}

	public void insert(Paciente paciente) throws ConstraintViolationException
	{
		Insert.into("Paciente")
			.set("sexo", paciente.getSexo())
			.set("cpf", paciente.getCpf())
			.set("nome", paciente.getNome())
			.set("dataNascimento", paciente.getDataNascimento())
			.build()
			.connect(getLink())
			.fetchGeneratedKey(ID.class)
			.ifPresent(paciente::setId);
	}

	public void update(Paciente paciente) throws AppException
	{
		Update.table("Paciente")
			.set("sexo", paciente.getSexo())
			.set("cpf", paciente.getCpf())
			.set("nome", paciente.getNome())
			.set("dataNascimento", paciente.getDataNascimento())
			.where(Condition.of("id").eq(paciente.getId()))
			.build()
			.connect(getLink())
			.orElseThrow(NotFoundException::new);
	}

	public void delete(Paciente paciente) throws AppException
	{
		Delete.from("Paciente")
			.where(Condition.of("id").eq(paciente.getId()))
			.build()
			.connect(getLink())
			.orElseThrow(NotFoundException::new);

	}

}
