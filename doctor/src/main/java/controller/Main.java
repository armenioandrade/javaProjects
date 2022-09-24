
package controller;

import dao.MedicoDao;
import dao.PacienteDao;
import entity.Paciente;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class Main {
 
    public static void main(String[] args) {
        MedicoDao dao = new MedicoDao();
        System.out.println(dao.findAll().toString());
        
        
    }
}
