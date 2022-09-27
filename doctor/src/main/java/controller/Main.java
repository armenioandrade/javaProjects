
package controller;

import dao.MedicoDao;
import dao.PacienteDao;
import dao.ReceitaDao;
import entity.Medico;
import entity.Paciente;
import entity.Receita;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
 
    public static void main(String[] args) {
       
        MedicoDao dao = new MedicoDao();
        PacienteDao pdao = new PacienteDao();
        ReceitaDao rdao = new ReceitaDao();
        Medico medico = new Medico();
        Paciente paciente = new Paciente();
        medico.setNome("Adeilton");
        paciente.setNome("juma");
        Receita receita = new Receita();
        ReceitaDao daoReceita = new ReceitaDao();
        receita.setId(5);
        receita.setMedico(medico);
        receita.setDescricao("paracetamol");
        receita.setPaciente(paciente);
        /*
        
        try {
            System.out.println(dao.getIdByName(medico).getId());
            System.out.println(pdao.getIdByName(paciente).getId());
            dao.getDetailsById(medico);
            pdao.getDetailsById(paciente);
        } catch (SQLException ex) {
        }
        
        try {
            daoReceita.create(receita);
        } catch (SQLException ex) {
        }
        */
        try {
            System.out.println(rdao.findAll().toString());
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
