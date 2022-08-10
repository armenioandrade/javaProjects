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
public class EditUsuario extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PessoaDAO pd = new PessoaDAO();
        Pessoa p = new Pessoa();        
        PrintWriter pw = res.getWriter();
        pw.write(pd.selecionarPessoaByCpf(req.getParameter("cpf")).getNome());
        req.setAttribute("nome", pd.selecionarPessoaByCpf(req.getParameter("cpf")).getNome());
        req.setAttribute("cpf", pd.selecionarPessoaByCpf(req.getParameter("cpf")).getCpf());
        req.setAttribute("email", pd.selecionarPessoaByCpf(req.getParameter("cpf")).getEmail());
        req.setAttribute("telefone", pd.selecionarPessoaByCpf(req.getParameter("cpf")).getTelefone());
        RequestDispatcher rd = req.getRequestDispatcher("FormEdit.jsp");
        rd.forward(req, res);
        //res.sendRedirect("FormEdit.jsp");
        //pw.write(pd.selecionarPessoaByCpf(cpfantigo).toString());
        
    }
}
