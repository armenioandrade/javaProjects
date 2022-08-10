/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.PessoaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author amaf
 */
//@WebFilter(urlPatterns = "/Login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PessoaDAO pd = new PessoaDAO();
        try ( PrintWriter pw = res.getWriter()) {
            res.setContentType("text/html");
            String user = req.getParameter("userName");
            String pass = req.getParameter("userPassword");
            String message = "";
            
            if (pd.autenticarPessoa(user, pass)) {
                message = "Login Success...!\n";
                pw.write(message);
                res.sendRedirect("MenuUser.jsp");
            } else {
                message = "Login Failed...!";
                pw.write(message);
            }
            //req.setAttribute("message", message);
            //res.sendRedirect("response.jsp");
        }
    }

}
