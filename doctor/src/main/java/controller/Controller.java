package controller;

import dao.MedicoDao;
import entity.Medico;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Controller", "/main", "/insert", " /view"})
public class Controller extends HttpServlet {

    Medico medico = new Medico();
    MedicoDao dao = new MedicoDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.write(request.getServletPath());
        String path = request.getServletPath();
        System.out.println(path);
        System.out.println(request.getContextPath());
        System.out.println(request.getMethod());

    }

    protected void createMedico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        medico.setNome(request.getParameter("nome"));
        medico.setCpf(request.getParameter("cpf"));
        medico.setCrm(request.getParameter("crm"));
        medico.setSexo(request.getParameter("sexo"));
        try {

            dao.create(medico);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        response.sendRedirect("/doctor/View");
    }

    protected List<Medico> findAllMedico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("findall");
        List<Medico> lista = new ArrayList<Medico>();
        try {
            lista = dao.findAll();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("medicos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("/doctor/views/modulos/medico/View.jsp");
        rd.forward(request, response);
        return lista;
    }

    /*
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

         createMedico(request, response);
         System.out.println("req-veio-de: "+request.getServletPath());
    }
     */
}
