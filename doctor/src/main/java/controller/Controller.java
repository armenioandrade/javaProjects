package controller;

import dao.MedicoDao;
import entity.Medico;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Controller", "/View", "/insert", "/"})
public class Controller extends HttpServlet {

    Medico medico = new Medico();
    MedicoDao dao = new MedicoDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println("PRIMEIRO OUT" + path);
        switch (path) {
            case "/":
                response.sendRedirect("index.jsp");
                System.out.println(path);
                break;
            case "/views/modulos/medico/insert":
                createMedico(request, response);
                System.out.println("CHEGOU NO CASE");
                break;
            default:
                response.sendRedirect("index.jsp");
                System.out.println("default do case");
        }
    }

    protected void createMedico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println("CHEGOU NO METODO");
        medico.setNome(request.getParameter("nome"));
        medico.setCpf(request.getParameter("cpf"));
        medico.setCrm(request.getParameter("crm"));
        medico.setSexo(request.getParameter("sexo"));
        System.out.println(medico.toString());
        System.out.println("cadastrado");
        try {

            dao.create(medico);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
