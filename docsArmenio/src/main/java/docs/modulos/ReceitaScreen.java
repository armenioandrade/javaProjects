package docs.modulos;

import docs.control.MedicoControl;
import docs.control.PacienteControl;
import docs.control.ReceitaControl;
import docs.entity.Medico;
import docs.entity.Paciente;
import docs.entity.Receita;
import java.util.ArrayList;
import java.util.List;

public class ReceitaScreen  {

    private List<Receita> page;
    private MedicoControl mcontrol;
    private PacienteControl pcontrol;
    private ReceitaControl rcontrol;
    private Receita form;

    public String call() {
        mcontrol = new MedicoControl();
        
                return "/WEB-INF/views/docs/modulos/Receita/View.jsp";
                
    }   

    


    public Object callSelect() {
            return "/WEB-INF/views/docs/modulos/Paciente/ViewSelect.jsp";
    }

    public Object callInsert() {
  
        return "/WEB-INF/views/docs/modulos/Paciente/ViewInsert.jsp";
    }


    public Object callUpdate() {
        
        return "/WEB-INF/views/docs/modulos/Paciente/ViewUpdate.jsp";
    }


    public void callDelete() {
       
    }

    public List<Receita> getPage() {
        return page;
    }

    public void setPage(List<Receita> page) {
        this.page = page;
    }

    public MedicoControl getMcontrol() {
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

}
