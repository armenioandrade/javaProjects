
package controller;

import dao.MedicoDao;
import dao.PacienteDao;
import entity.Medico;
import entity.Paciente;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class Main {
 
    public static void main(String[] args) {
        try {
            PacienteDao dao = new PacienteDao();
            System.out.println(dao.findAll().toString());
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
