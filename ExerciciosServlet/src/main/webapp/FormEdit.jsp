<%-- 
    Document   : NovoUsuario
    Created on : 10 de ago. de 2022, 12:57:18
    Author     : amaf
--%>

<%@page import="model.Pessoa"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.EditUsuario" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
    </head>
    <body>
        <a href="MenuUser.jsp">Voltar</a>
        <h1>Editar Usuario</h1>
        <form name="CommitEditUser" action="CommitEditUser" method="POST">
            
            <table>
                <tr>
                    <td>Nome:</td>
                    <td><input type="text" name="nome" value="<%out.print(request.getAttribute("nome"));%>"></td>
                </tr>
                <tr>
                    <td>Cpf:</td>
                    <td><input type="text" name="cpf" value="<%out.print(request.getAttribute("cpf"));%>"></td>></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email" value="<%out.print(request.getAttribute("email"));%>"></td>></td>
                </tr>
                <tr>
                    <td>Telefone:</td>
                    <td><input type="text" name="telefone" value="<%out.print(request.getAttribute("telefone"));%>"></td>></td>
                </tr>
                <tr>
            </table>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
