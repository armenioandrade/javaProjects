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

@WebServlet(urlPatterns = {"/DoctorController", "/insert", "/view", "/delete", "/DoctorView"})
public class DoctorController extends HttpServlet {

    Medico medico = new Medico();
    MedicoDao dao = new MedicoDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();

        if (response.getStatus() == 404) {
            System.out.println("OPS 404 " + request.getServletPath());
        }

        switch (path) {
            case "/view":
                response.sendRedirect(("index.jsp"));
                System.out.println(path);
                break;
            case "/delete":
                delete(request, response);
                System.out.println(path);
                break;
            case "/DoctorView":
                System.out.println(path);
                findAllMedico(request, response);
                break;
            default:
                throw new AssertionError();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String path = request.getServletPath();
        switch (path) {
            case "/insert":
                createMedico(request, response);
                break;
            default:
                throw new AssertionError();
        }
        System.out.println(path);
        System.out.println(request.getMethod());
    }

    protected void createMedico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        medico.setNome(request.getParameter("nome"));
        medico.setCpf(request.getParameter("cpf"));
        medico.setCrm(request.getParameter("crm"));
        medico.setSexo(request.getParameter("selectSexo"));
        try {

            dao.create(medico);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/view");
    }

    protected void findAllMedico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("findall");
        ArrayList<Medico> lista = new ArrayList<Medico>();
        lista = dao.findAll();
        request.setAttribute("medicos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("DoctorView.jsp");
        rd.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Setar as variaveis JavaBeans
        medico.setId(Integer.valueOf(request.getParameter("id")));
        //redirecionar para o documento agenda.jsp (atualizando as alteracoes)
        try {
            dao.delete(medico.getId());
        } catch (Exception e) {
        }
        response.sendRedirect(request.getContextPath()+"/DoctorView");
    }

}
