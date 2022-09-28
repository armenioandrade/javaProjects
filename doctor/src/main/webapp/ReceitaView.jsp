<%-- 
    Document   : ReceitaView
    Created on : 27 de set. de 2022, 14:54:27
    Author     : armenioandrade
--%>

<%@page import="entity.Receita"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        ArrayList<Receita> lista = (ArrayList<Receita>) request.getAttribute("receitas");
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Visualização de receitas</title>
        <script defer src="scripts/validador.js"></script>
    </head>
    <body>
        <a href="ReceitaView">Visualizar Receitas</a>
        <a href="index.jsp">Voltar</a>
        <h1>Receitas cadastradas</h1>
        <table id="tabela">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Médico</th>
                    <th>Paciente</th>
                    <th>Descrição</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>

                <%for (int i = 0; i < lista.size(); i++) {%>
                <tr>

                    <td> <%= lista.get(i).getId()%> </td>
                    <td><%= lista.get(i).getMedico().getNome()%></td>
                    <td><%= lista.get(i).getPaciente().getNome()%></td>
                    <td><%= lista.get(i).getDescricao()%></td>
                    <td>
                        <a href="javascript: confirmarDelete(<%=lista.get(i).getId()%>)" class="botao2">Excluir</a>
                    </td>

                </tr>
                <%}%>
                </body>
                </html>
