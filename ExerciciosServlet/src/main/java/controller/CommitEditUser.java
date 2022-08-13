/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.PessoaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;

/**
 *
 * @author amaf
 */
public class CommitEditUser extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PessoaDAO pd = new PessoaDAO();
        Pessoa p = new Pessoa();        
        PrintWriter pw = res.getWriter();
        p.setNome(req.getParameter("nome"));
        p.setCpf(req.getParameter("cpf"));
        p.setEmail(req.getParameter("email"));
        p.setTelefone(req.getParameter("telefone"));
        
        pd.atualizarPessoaByCpf(p);
        res.sendRedirect("AcaoRealizada.jsp");
        
    }
}