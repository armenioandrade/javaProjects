package docs.modulos;


import docs.control.MedicoControl;
import docs.entity.Medico;
import docs.entity.Receita;
import gate.annotation.CopyIcon;
import gate.annotation.CopyName;
import gate.annotation.Name;
import java.util.ArrayList;
import java.util.List;

@CopyIcon(Receita.class)
@CopyName(Receita.class)
public class ReceitaScreen extends Screen {
    private Receita receitaForm;
    private List<Medico> page;
    private MedicoScreen medicoScreen;
    private MedicoControl mc;
    @Name("Property")
    String property;
    
    public String call(){
        return "/WEB-INF/views/docs/modulos/Receita/View.jsp";
    }
    
        public Receita getForm() {
        if (receitaForm == null) {
            receitaForm = new Receita();
        }
        return receitaForm;
    }

    public List<Medico> getPage() {
        if (page == null) {
            page = new ArrayList<>();
        }
        return page;
    }

    public Receita getReceitaForm() {
        return receitaForm;
    }

    public void setReceitaForm(Receita receitaForm) {
        this.receitaForm = receitaForm;
    }

    public MedicoScreen getMedicoScreen() {
        if(medicoScreen == null){
            medicoScreen = new MedicoScreen();
        }
        return medicoScreen;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
       
    
}
