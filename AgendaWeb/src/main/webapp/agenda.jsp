<%-- 
    Document   : agenda
    Created on : 24 de ago. de 2022, 02:27:01
    Author     : amaf
--%>
<%@ page import="model.JavaBeans" %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agenda de contatos</title>
        <link rel="icon" href="imagens/favicon.png">
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1>Agenda de contatos</h1>
        <a link href="novo.html" class="botao1">Novo contato</a>
        <a link href="report" class="botao2">Relatório</a>
        <table id="tabela">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Fone</th>
                    <th>Email</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>
                <%for (int i = 0; i < lista.size(); i++) {%>
                <tr>

                    <td> <%= lista.get(i).getIdcon()%> </td>
                    <td> <%= lista.get(i).getNome()%> </td>
                    <td> <%= lista.get(i).getEmail()%> </td>
                    <td> <%= lista.get(i).getFone()%> </td>
                    <td><a href="select?idcon=<%=lista.get(i).getIdcon()%>" class="botao1">Editar</a>
                        <a href="javascript: confirmarDelete(<%=lista.get(i).getIdcon()%>)" class="botao2">Excluir</a>
                    </td>

                </tr>
                <%}%>

            </tbody>
        </table>
        <script src="scripts/validador.js"></script>
    </body>
</html>
