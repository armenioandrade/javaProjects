/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.PessoaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;

/**
 *
 * @author amaf
 */
public class DeletarUsuario extends HttpServlet {

     @Override
     public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter pw = res.getWriter();
        PessoaDAO pd = new PessoaDAO();
        pd.deletarPessoaByCpf(req.getParameter("cpf"));
        res.sendRedirect("AcaoRealizada.jsp");
    }

}