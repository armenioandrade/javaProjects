/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.PacienteDao;
import entity.Medico;
import entity.Paciente;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/PacientController", "/PacientView", "/PacientInsert", "/PacientUpdate", "/PacientDelete", "/PacientSelect"})
public class PacientController extends HttpServlet {

    Paciente pacient = new Paciente();
    PacienteDao dao = new PacienteDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/PacientView":
                System.out.println(path);
                findAllPaciente(request, response);
                break;
            case "/PacientSelect":
                System.out.println(path);
                getPacientById(request, response);
                break;
            case "/PacientDelete":
                System.out.println(path);
                delete(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/PacientInsert":
                System.out.println(path);
                createPacient(request, response);
                break;
            case "/PacientUpdate":
                System.out.println(path);
                updatePaciente(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    protected void createPacient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/YYYY");
        String path = request.getServletPath();
        pacient.setNome(request.getParameter("nome"));
        pacient.setCpf(request.getParameter("cpf"));
        pacient.setDataNascimento(LocalDate.parse(request.getParameter("data")));
        pacient.setSexo(request.getParameter("selectSexo"));
        try {

            dao.create(pacient);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/PacientView");
    }

    protected void findAllPaciente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("findall");
        ArrayList<Paciente> lista = new ArrayList<Paciente>();
        try {
            lista = dao.findAll();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        request.setAttribute("pacientes", lista);
        RequestDispatcher rd = request.getRequestDispatcher("PacientView.jsp");
        rd.forward(request, response);
    }

    protected void getPacientById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        pacient.setId(Integer.valueOf(request.getParameter("id")));

        try {
            System.out.println("Fazendo consulta");
            dao.getDetailsById(pacient);
        } catch (Exception e) {
        }
        System.out.println("paciente no controller: " + pacient.toString());
        request.setAttribute("id", pacient.getId());
        request.setAttribute("nome", pacient.getNome());
        request.setAttribute("cpf", pacient.getCpf());
        request.setAttribute("data", pacient.getDataNascimento());
        request.setAttribute("sexo", pacient.getSexo());
        RequestDispatcher rd = request.getRequestDispatcher("PacientEdit.jsp");
        rd.forward(request, response);

    }

    protected void updatePaciente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        pacient.setId(Integer.parseInt(request.getParameter("id")));
        pacient.setNome(request.getParameter("nome"));
        pacient.setDataNascimento(LocalDate.parse(request.getParameter("data"), DateTimeFormatter.ISO_DATE));
        pacient.setCpf(request.getParameter("cpf"));
        pacient.setSexo(request.getParameter("sexo"));
        try {
            dao.update(pacient);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/PacientView");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        pacient.setId(Integer.valueOf(request.getParameter("id")));
        try {
            dao.delete(pacient.getId());
        } catch (Exception e) {
        }
        response.sendRedirect(request.getContextPath() + "/PacientView");
    }
}
