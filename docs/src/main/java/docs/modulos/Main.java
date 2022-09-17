    
package docs.modulos;

import docs.control.ReceitaControl;
import docs.entity.Receita;

public class Main {
    public static void main(String[] args) {
        ReceitaScreen rs = new ReceitaScreen();
        System.out.println(rs.getMcontrol().searchAll().toString());
    }
}
