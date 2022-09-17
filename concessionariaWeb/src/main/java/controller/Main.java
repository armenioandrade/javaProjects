/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import entity.Cliente;
import dao.ClienteDao;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author armenioandrade
 */
public class Main {
    public static void main(String[] args) {
        Cliente c = new Cliente("nome", "cpf", "email", "sexo", "telefone", LocalDateTime.now());
        System.out.println(c.toString());
        ClienteDao cd = new ClienteDao();
        try {
            cd.create(c);
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
