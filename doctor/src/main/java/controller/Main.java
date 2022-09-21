
package controller;

import dao.PacienteDao;
import entity.Paciente;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
 
    public static void main(String[] args) {
        
        
      Paciente p = new  Paciente();
      p.setCpf("123");
      p.setDataNascimento(LocalDate.now());
      p.setNome("carmelo");
      p.setSexo("masc");
        PacienteDao pd = new PacienteDao();
        try {
            pd.create(p);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        System.out.println(p.toString());
        
    }
}
