package sistemaservicos.modulos;

import gate.annotation.CopyName;
import gate.annotation.Public;
import sistemaservicos.entity.Equipamento;

@Public
@CopyName(Equipamento.class)
public class EquipamentoScreen extends Screen{
    
    public String call(){
        return "/WEB-INF/views/docs/modulos/Equipamento/View.jsp";
    }
}
