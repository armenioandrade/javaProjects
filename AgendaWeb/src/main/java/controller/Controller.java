package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = {"/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report", "/combobox"})
public class Controller extends HttpServlet {

    DAO dao = new DAO();
    JavaBeans contato = new JavaBeans();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtendo o caminho que o usuário clicou
        String action = request.getServletPath();
        System.out.println(action);
        switch (action) {
            case "/main":
                contatos(request, response);
                System.out.println(action);
                break;
            case "/insert":
                adicionarContato(request, response);
                System.out.println(action);
                break;
            case "/select":
                listarContato(request, response);
                System.out.println(action);
                break;
            case "/update":
                editarContato(request, response);
                System.out.println(action);
                break;
            case "/delete":
                deletarContato(request, response);
                System.out.println(action);
                break;
            case "/report":
                gerarRelatorio(request, response);
                System.out.println(action);
                break;
            case "/combobox":
                contatosCombobox(request, response);
                System.out.println(action);
                break;
            default:
                response.sendRedirect("index.html");
                System.out.println(action);
                break;
        }

    }

    //Listar contatos
    protected void contatos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Criando um objeto que irá receber os dados JavaBeans
        ArrayList<JavaBeans> lista = dao.listarContatos();
        //Encaminhar a lista de contatos ao documento agenda.jsp
        request.setAttribute("contatos", lista);
        RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
        rd.forward(request, response);
    }

//Adicionar  contato
    protected void adicionarContato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        contato.setNome(request.getParameter("nome"));
        contato.setFone(request.getParameter("fone"));
        contato.setEmail(request.getParameter("email"));
        dao.inserirContato(contato);
        //Redirecionar para o documento agenda.jsp
        response.sendRedirect("main");
    }

    //Editar Contato
    protected void listarContato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Recebimento do ID do contato que será editado
        String idcon = request.getParameter("idcon");
        //setar a variavel JavaBeans
        contato.setIdcon(idcon);
        dao.selecionarContato(contato);
        //Setar os atributos do formulario com o conteudo JavaBeans
        request.setAttribute("idcon", contato.getIdcon());
        request.setAttribute("nome", contato.getNome());
        request.setAttribute("fone", contato.getFone());
        request.setAttribute("email", contato.getEmail());
        //Encaminhar ao documento editar.jsp
        RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
        rd.forward(request, response);

    }

    protected void editarContato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Setar as variaveis JavaBeans
        contato.setIdcon(request.getParameter("idcon"));
        contato.setNome(request.getParameter("nome"));
        contato.setFone(request.getParameter("fone"));
        contato.setEmail(request.getParameter("email"));
        //redirecionar para o documento agenda.jsp (atualizando as alteracoes)
        dao.alterarContato(contato);
        response.sendRedirect("main");
    }

    protected void deletarContato(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Setar as variaveis JavaBeans
        contato.setIdcon(request.getParameter("idcon"));
        //redirecionar para o documento agenda.jsp (atualizando as alteracoes)
        dao.deletarContato(contato);
        response.sendRedirect("main");
    }

    protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Document documento = new Document();
        try {
            //tipo de conteudo
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");
            PdfWriter.getInstance(documento, response.getOutputStream());
            //abrir o documento para gerar o conteúdo
            documento.open();
            documento.add(new Paragraph("Lista de contatos: "));
            documento.add(new Paragraph(" "));
            //Criar uma tabela
            PdfPTable table = new PdfPTable(3);
            //cabeçalho
            PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
            PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
            PdfPCell col3 = new PdfPCell(new Paragraph("Email"));
            table.addCell(col1);
            table.addCell(col2);
            table.addCell(col3);
            //Popular Tabela com contatos
            ArrayList<JavaBeans> lista = dao.listarContatos();
            for (JavaBeans javaBeans : lista) {
                table.addCell(javaBeans.getNome());
                table.addCell(javaBeans.getFone());
                table.addCell(javaBeans.getEmail());
            }
            documento.add(table);
            documento.close();
        } catch (Exception e) {
            System.out.println(e);
            documento.close();
        }
    }
        protected void contatosCombobox(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Criando um objeto que irá receber os dados JavaBeans
        ArrayList<JavaBeans> lista = dao.listarContatos();
        //Encaminhar a lista de contatos ao documento combobox.jsp
        request.setAttribute("contatoscb", lista);
        PrintWriter pw = response.getWriter();
        pw.write("esse veio do pw");
        RequestDispatcher rd = request.getRequestDispatcher("combobox.jsp");
        rd.forward(request, response);

    }
}
