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
public class ListarUsuario extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        PrintWriter pw = res.getWriter();
        PessoaDAO pd = new PessoaDAO();
        pw.write("<a href='MenuUser.jsp'>Voltar</a>");
        pw.write("<br>");
        pw.write("<table border='1'>");
        pw.write("<tr>");
        pw.write("<th>Nome</th>");
        pw.write("<th>CPF</th>");
        pw.write("<th>Email</th>");
        pw.write("<th>Telefone</th>");
        pw.write("</tr>");
        pw.write("Total de Usuários cadastrados: "+pd.listarPessoas().size());
        pw.write("<br>");
        
        for (Pessoa listarPessoa : pd.listarPessoas()) {
            pw.write("<tr>");
            pw.write("<td>");
            pw.write(listarPessoa.getNome());
            pw.write("<td>");
            pw.write(listarPessoa.getCpf());
            pw.write("<td>");
            pw.write(listarPessoa.getEmail());
            pw.write("<td>");
            pw.write(listarPessoa.getTelefone());
            
        }
        pw.write("</tr> ");
        pw.write("</table> ");
        
        //Fazendo com Steam e Lambda
        pw.write("<h1>Usando Lambda e Stream</h1>");
        pw.write("<br>");
        pw.write("<table border='1'>");
        pw.write("<tr>");
        pw.write("<th>Nome</th>");
        pw.write("<th>CPF</th>");
        pw.write("<th>Email</th>");
        pw.write("<th>Telefone</th>");
        pw.write("</tr>");
        pw.write("Total de Usuários cadastrados: "+pd.listarPessoas().size());
        pw.write("<br>");
        
        pd.listarPessoas().stream().forEach(p -> pw.write("<tr>"+"<td>"+p.getNome()+"<td>"+p.getCpf()+"<td>"+p.getEmail()+"<td>"+p.getTelefone()));
        
        

    }
}
