
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.List" %>
<%@page import="entity.Medico" %>
<%@page import="java.util.ArrayList" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Médicos</title>
    </head>
    <body>
        <h1>Lista de Médicos</h1>
        <%
        ArrayList<Medico> lista = (ArrayList<Medico>) request.getAttribute("medicos");
        
        %>
        
        
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
                <%--
                <%for (int i = 0; i < lista.size(); i++) {%>
                <tr>

                    <td> <%= lista.get(i).getId()%> </td>
                    <td> <%= lista.get(i).getNome()%> </td>
                    <td> <%= lista.get(i).getCpf()%> </td>
                    <td> <%= lista.get(i).getCrm()%> </td>
                    <td><a href="select?idcon=<%=lista.get(i).getId()%>" class="botao1">Editar</a>
                        <a href="javascript: confirmarDelete(<%=lista.get(i).getId()%>)" class="botao2">Excluir</a>
                    </td>

                </tr>
                <%}%>
                --%>
    </body>
</html>
