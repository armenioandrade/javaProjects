package controller;

import control.MedicoControl;
import dao.MedicoDao;
import entity.Medico;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/DoctorController", "/DoctorInsert", "/view", "/DoctorDelete", "/DoctorView", "/DoctorUpdate", "/DoctorSelect"})
public class DoctorController extends HttpServlet {

    Medico medico = new Medico();
    MedicoDao dao = new MedicoDao();
    MedicoControl control = new MedicoControl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();

        if (response.getStatus() == 404) {
            System.out.println("OPS 404 " + request.getServletPath());
        }

        switch (path) {
            case "/view":
                System.out.println(path);
                response.sendRedirect(("index.jsp"));
                break;
            case "/DoctorDelete":
                System.out.println(path);
                delete(request, response);
                break;
            case "/DoctorView":
                System.out.println(path);
                findAllMedico(request, response);
                break;
            case "/DoctorSelect":
                System.out.println(path);
                getMedicoById(request, response);
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
            case "/DoctorInsert":
                System.out.println(path);
                createMedico(request, response);
                break;
            case "/DoctorUpdate":
                System.out.println(path);
                updateMedico(request, response);
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

            control.insert(medico);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/DoctorView");
    }

    protected void findAllMedico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("findall");
        ArrayList<Medico> lista = new ArrayList<Medico>();
        lista = control.list();
        request.setAttribute("medicos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("DoctorView.jsp");
        rd.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        medico.setId(Integer.valueOf(request.getParameter("id")));
        try {
            control.delete(medico.getId());
        } catch (Exception e) {
        }
        response.sendRedirect(request.getContextPath() + "/DoctorView");
    }

    protected void getMedicoById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        medico.setId(Integer.valueOf(request.getParameter("id")));
        
        try {
            control.selectById(medico.getId());
        } catch (Exception e) {
        }
        request.setAttribute("id", medico.getId());
        request.setAttribute("nome", medico.getNome());
        request.setAttribute("cpf", medico.getCpf());
        request.setAttribute("crm", medico.getCrm());
        request.setAttribute("sexo", medico.getSexo());
        
        RequestDispatcher rd = request.getRequestDispatcher("DoctorEdit.jsp");
        rd.forward(request, response);
        
    }

    protected void updateMedico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        medico.setId(Integer.parseInt(request.getParameter("id")));
        medico.setNome(request.getParameter("nome"));
        medico.setCrm(request.getParameter("crm"));
        medico.setCpf(request.getParameter("cpf"));
        medico.setSexo(request.getParameter("sexo"));
        try {
            control.update(medico);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        response.sendRedirect(request.getContextPath() + "/DoctorView");
    }
    
        protected void findIdByName(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("findidbyname");
        medico.setNome(request.getParameter("name"));
        try {
            control.selectByName(medico);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        RequestDispatcher rd = request.getRequestDispatcher("/ReceitaInsert");
        rd.forward(request, response);
    }
}
