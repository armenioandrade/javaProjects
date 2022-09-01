package docs.modulos;

import docs.control.PacienteControl;
import docs.entity.Paciente;
import gate.annotation.Color;
import gate.annotation.Confirm;
import gate.annotation.CopyIcon;
import gate.annotation.CopyName;
import gate.annotation.Icon;
import gate.annotation.Name;
import gate.annotation.Public;
import gate.base.Screen;
import gate.command.Command;
import gate.error.AppException;
import gate.error.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@Public
@CopyName(Paciente.class)
@CopyIcon(Paciente.class)
public class PacienteScreen extends Screen
{

	@Inject
	private PacienteControl control;
	private Paciente form;
	private List<Paciente> page;

	public String call()
	{
		if (isPOST())
			page = control.search(getForm());
		return "/WEB-INF/views/docs/modulos/Paciente/View.jsp";
	}

	@Icon("select")
	@Name("Detalhes")
	public Object callSelect()
	{
		try
		{
			form = control.select(getForm().getId());
			return "/WEB-INF/views/docs/modulos/Paciente/ViewSelect.jsp";
		} catch (NotFoundException ex)
		{
			return Command.redirect()
				.module(getModule())
				.screen(getScreen())
				.messages(ex.getMessages());
		}
	}

	@Name("Novo")
	@Icon("insert")
	public Object callInsert()
	{
		if (isPOST())
		{
			try
			{
				control.insert(getForm());
				return Command.redirect()
					.module(getModule())
					.screen(getScreen())
					.action("Select")
					.parameter("form.id", getForm().getId());
			} catch (AppException ex)
			{
				setMessages(ex.getMessages());
			}
		}
		return "/WEB-INF/views/docs/modulos/Paciente/ViewInsert.jsp";
	}

	@Name("Alterar")
	@Icon("update")
	public Object callUpdate()
	{
		if (isGET())
		{
			try
			{
				form = control.select(getForm().getId());
			} catch (NotFoundException ex)
			{
				return Command.redirect()
					.module(getModule())
					.screen(getScreen())
					.messages(ex.getMessages());
			}
		} else if (isPOST())
		{
			try
			{
				control.update(getForm());
				return Command.redirect()
					.module(getModule())
					.screen(getScreen())
					.action("Select")
					.parameter("form.id", getForm().getId());
			} catch (AppException ex)
			{
				setMessages(ex.getMessages());
			}
		}
		return "/WEB-INF/views/docs/modulos/Paciente/ViewUpdate.jsp";
	}

	@Icon("delete")
	@Name("Remover")
	@Color("#660000")
	@Confirm("Tem certeza de que deseja remover este registro?")
	public Object callDelete()
	{
		try
		{
			control.delete(getForm());
			return Command.redirect()
				.module(getModule())
				.screen(getScreen())
				.messages("Registro removido com sucesso");

		} catch (AppException ex)
		{
			return Command.redirect()
				.module(getModule())
				.screen(getScreen())
				.action("Select")
				.parameter("form.id", getForm().getId())
				.messages(ex.getMessages());
		}
	}

	public Paciente getForm()
	{
		if (form == null)
			form = new Paciente();
		return form;
	}

	public List<Paciente> getPage()
	{
		if (page == null)
			page = new ArrayList<>();
		return page;
	}

}
