package docs.modulos;

import docs.control.PacienteControl;
import docs.entity.Paciente;
import java.util.ArrayList;
import java.util.List;

public class PacienteScreen {

    private PacienteControl control;
    private Paciente form;
    private List<Paciente> page;

    public String call() {

        return "/WEB-INF/views/docs/modulos/Paciente/View.jsp";
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

    public Paciente getForm() {
        if (form == null) {
            form = new Paciente();
        }
        return form;
    }

    public List<Paciente> getPage() {
        if (page == null) {
            page = new ArrayList<>();
        }
        return page;
    }

}
