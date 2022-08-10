
package controller;

import dao.PessoaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pessoa;


@WebServlet(name = "NovoUsuario", urlPatterns = {"/NovoUsuario"})
public class NovoUsuario extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        PessoaDAO pd = new PessoaDAO();
        Pessoa p = new Pessoa();
        try ( PrintWriter pw = res.getWriter()) {
            res.setContentType("text/html");
            String nome = req.getParameter("nome");
            String cpf = req.getParameter("cpf");
            String email = req.getParameter("email");
            String telefone = req.getParameter("telefone");
            p.setNome(nome);
            p.setCpf(cpf);
            p.setEmail(email);
            p.setTelefone(telefone);
            pd.adicionarPessoa(p);
            String message = "Usuario cadastrado";           
            req.setAttribute("message", message);
            res.sendRedirect("NovoUsuario.jsp");
            
        }
    }
}
