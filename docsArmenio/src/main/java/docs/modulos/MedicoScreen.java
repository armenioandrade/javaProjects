/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package docs.modulos;

import docs.control.MedicoControl;
import docs.entity.Medico;
import java.util.ArrayList;
import java.util.List;

public class MedicoScreen {

  
    private MedicoControl control;
    private Medico form;
    private List<Medico> page;

    public String call() {

        
        return "/WEB-INF/views/docs/modulos/Medico/View.jsp";

    }


    public Medico callSelect() {
        return form;
    }

    public Object callInsert() {
        
        return "/WEB-INF/views/docs/modulos/Medico/ViewInsert.jsp";

    }


    public void callDelete() {
        
    }


    public void callUpdate() {
      
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
