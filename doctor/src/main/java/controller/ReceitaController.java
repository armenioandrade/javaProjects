package controller;

import dao.ReceitaDao;
import entity.Medico;
import entity.Paciente;
import entity.Receita;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/ReceitaController", "/ReceitaInsert", "/ReceitaInsertView", "/ReceitaView", "/ReceitaUpdate", "/ReceitaDelete"})
public class ReceitaController extends HttpServlet {

    Receita receita = new Receita();
    ReceitaDao dao = new ReceitaDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println(path);
        switch (path) {
            case "/ReceitaInsertView":
                System.out.println(path);
                insertViewReceita(request, response);
                break;
            case "/ReceitaView":
                System.out.println(path);
                findAllReceita(request, response);
                break;
            case "/ReceitaDelete":
                System.out.println(path);
                deleteReceita(request, response);
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
            case "/ReceitaInsert":
                System.out.println(path);
                createReceita(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void createReceita(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Medico> listaMedicos = null;
        ArrayList<Paciente> listaPacientes = null;
        try {
            listaMedicos = dao.getMedicoDao().findAll();
            listaPacientes = dao.getPacienteDao().findAll();
        } catch (SQLException ex) {
        }
        System.out.println("Enviando atributos");
        request.setAttribute("medicos", listaMedicos);
        request.setAttribute("pacientes", listaPacientes);

        RequestDispatcher rd = request.getRequestDispatcher("ReceitaInsert.jsp");
        rd.forward(request, response);

        receita
                .setDescricao(request.getParameter("descricao"));
        receita
                .getMedico().setNome(request.getParameter("medico"));
        receita
                .getPaciente().setNome(request.getParameter("paciente"));
        System.out.println("obj Receita: " + receita.toString());

        try {
            dao.getMedicoDao().getIdByName(receita.getMedico());
            dao.getPacienteDao().getIdByName(receita.getPaciente());
        } catch (SQLException ex) {
        }

        try {
            dao.create(receita);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void insertViewReceita(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Medico> listaMedicos = null;
        ArrayList<Paciente> listaPacientes = null;
        try {
            listaMedicos = dao.getMedicoDao().findAll();
            listaPacientes = dao.getPacienteDao().findAll();
        } catch (SQLException ex) {
        }
        request.setAttribute("medicos", listaMedicos);
        request.setAttribute("pacientes", listaPacientes);
        RequestDispatcher rd = request.getRequestDispatcher("ReceitaInsertView.jsp");
        rd.forward(request, response);
    }

    protected void findAllReceita(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("findallReceita");
        ArrayList<Receita> lista = new ArrayList<Receita>();
        try {
            lista = dao.findAll();
        } catch (Exception e) {
        }
        request.setAttribute("receitas", lista);
        System.out.println(lista.toString());
        RequestDispatcher rd = request.getRequestDispatcher("ReceitaView.jsp");
        rd.forward(request, response);
    }

    protected void deleteReceita(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("deleteReceita");
        receita.setId(Integer.valueOf(request.getParameter("id")));
        dao.delete(receita);
        RequestDispatcher rd = request.getRequestDispatcher("ReceitaView");
        rd.forward(request, response);
    }
}
