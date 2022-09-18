/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package docs.modulos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author armenioandrade
 */
@WebServlet(name = "Controller", urlPatterns = {"/Controller", "/"})
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtendo o caminho que o usuário clicou
        String action = request.getServletPath();
        System.out.println(action);
        if(action.equals("/")){
            menuMedico(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    public void menuMedico(HttpServletRequest request, HttpServletResponse reponse) throws ServletException, IOException{
        RequestDispatcher rd = request.getRequestDispatcher("index.html");
        rd.forward(request, reponse);
    }

}
