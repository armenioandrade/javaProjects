package docs.entity;

import docs.type.Sexo;
import gate.annotation.Description;
import gate.annotation.Icon;
import gate.annotation.Name;
import gate.constraint.Maxlength;
import gate.constraint.Required;
import gate.type.CPF;
import gate.type.ID;
import java.time.LocalDate;

@Icon("3046")
@Name("Paciente")
public class Paciente
{

	@Required
	@Name("ID")
	@Description("ID do paciente")
	private ID id;

	@Required
	@Name("Sexo")
	@Description("Sexo do paciente")
	private Sexo sexo;

	@Required
	@Name("CPF")
	@Description("CPF do paciente")
	private CPF cpf;

	@Required
	@Name("Nome")
	@Maxlength(64)
	@Description("Nome do paciente")
	private String nome;

	@Required
	@Name("Data de Nascimento")
	@Description("Data de nascimento do paciente")
	private LocalDate dataNascimento;

	public ID getId()
	{
		return id;
	}

	public void setId(ID id)
	{
		this.id = id;
	}

	public CPF getCpf()
	{
		return cpf;
	}

	public void setCpf(CPF cpf)
	{
		this.cpf = cpf;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public LocalDate getDataNascimento()
	{
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento)
	{
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo()
	{
		return sexo;
	}

	public void setSexo(Sexo sexo)
	{
		this.sexo = sexo;
	}
}
