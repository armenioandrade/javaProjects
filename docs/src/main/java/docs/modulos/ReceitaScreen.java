package docs.modulos;

import docs.control.MedicoControl;
import docs.control.PacienteControl;
import docs.control.ReceitaControl;
import docs.entity.Medico;
import docs.entity.Paciente;
import docs.entity.Receita;
import gate.annotation.Color;
import gate.annotation.Confirm;
import gate.annotation.CopyIcon;
import gate.annotation.CopyName;
import gate.annotation.Icon;
import gate.annotation.Name;
import gate.command.Command;
import gate.error.AppException;
import gate.error.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

@CopyIcon(Receita.class)
@CopyName(Receita.class)
public class ReceitaScreen extends Screen {
    
    private PacienteControl pcontrol;
    @Inject
    private ReceitaControl rcontrol;
    private Receita form;
    private List<Receita> page;
    private MedicoControl mcontrol;
    private MedicoScreen mscreen;
    private Medico medico;
    private List<Medico> pageMedico;
    
    public String call() {
        
                if(isPOST()){
                    pageMedico = mcontrol.searchAll();
                }
                return "/WEB-INF/views/docs/modulos/Receita/GateView.jsp";
                
    }   

    

    @Icon("select")
    @Name("Detalhes")
    public Object callSelect() {
        try {
            form = rcontrol.select(getForm().getId());
            return "/WEB-INF/views/docs/modulos/Paciente/ViewSelect.jsp";
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
                rcontrol.insert(getForm());
                return Command.redirect()
                        .module(getModule())
                        .screen(getScreen())
                        .action("Select")
                        .parameter("form.id", getForm().getId());
            } catch (AppException ex) {
                setMessages(ex.getMessages());
            }
        }
        return "/WEB-INF/views/docs/modulos/Paciente/ViewInsert.jsp";
    }

    @Name("Alterar")
    @Icon("update")
    public Object callUpdate() {
        if (isGET()) {
            try {
                form = rcontrol.select(getForm().getId());
            } catch (NotFoundException ex) {
                return Command.redirect()
                        .module(getModule())
                        .screen(getScreen())
                        .messages(ex.getMessages());
            }
        } else if (isPOST()) {
            try {
                rcontrol.update(getForm());
                return Command.redirect()
                        .module(getModule())
                        .screen(getScreen())
                        .action("Select")
                        .parameter("form.id", getForm().getId());
            } catch (AppException ex) {
                setMessages(ex.getMessages());
            }
        }
        return "/WEB-INF/views/docs/modulos/Paciente/ViewUpdate.jsp";
    }

    @Icon("delete")
    @Name("Remover")
    @Color("#660000")
    @Confirm("Tem certeza de que deseja remover este registro?")
    public Object callDelete() {
        try {
            rcontrol.delete(getForm());
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

    public List<Receita> getPage() {
        return page;
    }

    public void setPage(List<Receita> page) {
        this.page = page;
    }

    public MedicoControl getMcontrol() {
        if(mcontrol == null)
            mcontrol = new MedicoControl();
        return mcontrol;
    }

    public void setMcontrol(MedicoControl mcontrol) {
        this.mcontrol = mcontrol;
    }

    public PacienteControl getPcontrol() {
        return pcontrol;
    }

    public void setPcontrol(PacienteControl pcontrol) {
        this.pcontrol = pcontrol;
    }

    public ReceitaControl getRcontrol() {
        return rcontrol;
    }

    public void setRcontrol(ReceitaControl rcontrol) {
        this.rcontrol = rcontrol;
    }

    public Receita getForm() {
        if (form == null) {
            form = new Receita();
            new Medico();
            new Paciente();
        }
        return form;
    }

    public void setForm(Receita form) {
        this.form = form;
    }

    public MedicoScreen getMscreen() {
        return mscreen;
    }

    public void setMscreen(MedicoScreen mscreen) {
        this.mscreen = mscreen;
    }

    public Medico getMedico() {
        if(medico == null){
            medico = new  Medico();
        }
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
        public List<Medico> getPageMedico() {
        if (pageMedico == null) {
            pageMedico = new ArrayList<>();
        }
        return pageMedico;
    }

}
