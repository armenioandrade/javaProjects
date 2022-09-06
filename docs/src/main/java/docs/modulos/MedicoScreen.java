/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docs.modulos;

import docs.control.MedicoControl;
import gate.annotation.CopyIcon;
import gate.annotation.CopyName;
import gate.annotation.Icon;
import gate.annotation.Name;
import gate.annotation.Public;
import gate.command.Command;
import gate.error.AppException;
import javax.inject.Inject;
import docs.entity.Medico;
import gate.annotation.Color;
import gate.annotation.Confirm;
import gate.error.NotFoundException;
import java.util.ArrayList;
import java.util.List;

@Public
@CopyName(Medico.class)
@CopyIcon(Medico.class)
public class MedicoScreen extends Screen {

    @Inject
    private MedicoControl control;
    private Medico form;
    private List<Medico> page;

    public String call() {

        if (isPOST()) {
            page = control.search(getForm());
        }
        return "/WEB-INF/views/docs/modulos/Medico/View.jsp";

    }

    @Name("Detalhes")
    @Icon("select")
    public Object callSelect() {
        try {
            form = control.select(getForm().getId());
            return "/WEB-INF/views/docs/modulos/Medico/ViewSelect.jsp";
        } catch (NotFoundException ex) {
            return Command.redirect()
                    .module(getModule())
                    .screen(getScreen())
                    .messages(ex.getMessages());
        }
    }

    @Name("Novo")
    @Icon("insert")
    public Object callInsert() {
        if (isPOST()) {
            try {
                control.insert(getForm());
                return Command.redirect()
                        .module(getModule())
                        .screen(getScreen())
                        .action("Insert")
                        .parameter("form.id", getForm().getId());
            } catch (AppException ex) {
                setMessages(ex.getMessages());
            }
        }
        return "/WEB-INF/views/docs/modulos/Medico/ViewInsert.jsp";

    }

    @Name("Remover")
    @Icon("delete")
    @Color("#660000")
    @Confirm("Tem certeza de que deseja remover este registro?")
    public Object callDelete() {
        try {
            control.delete(getForm());
            return Command.redirect()
                    .module(getModule())
                    .screen(getScreen())
                    .messages("Registro removido com sucesso");

        } catch (AppException ex) {
            return Command.redirect()
                    .module(getModule())
                    .screen(getScreen())
                    .action("Select")
                    .parameter("form.id", getForm().getId())
                    .messages(ex.getMessages());
        }
    }

    @Name("Alterar")
    @Icon("update")
    public Object callUpdate() {
        if (isGET()) {
            try {
                form = control.select(getForm().getId());
            } catch (NotFoundException ex) {
                return Command.redirect()
                        .module(getModule())
                        .screen(getScreen())
                        .messages(ex.getMessages());
            }
        } else if (isPOST()) {
            try {
                control.update(getForm());
                return Command.redirect()
                        .module(getModule())
                        .screen(getScreen())
                        .action("Select")
                        .parameter("form.id", getForm().getId());
            } catch (AppException ex) {
                setMessages(ex.getMessages());
            }
        }
        return "/WEB-INF/views/docs/modulos/Medico/ViewUpdate.jsp";
    }

    public Medico getForm() {
        if (form == null) {
            form = new Medico();
        }
        return form;
    }

    public List<Medico> getPage() {
        if (page == null) {
            page = new ArrayList<>();
        }
        return page;
    }
    


}
