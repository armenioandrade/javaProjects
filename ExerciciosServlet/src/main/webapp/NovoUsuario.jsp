<%-- 
    Document   : NovoUsuario
    Created on : 10 de ago. de 2022, 12:57:18
    Author     : amaf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="controller.NovoUsuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Usuario</title>
    </head>
    <body>
        <a href="MenuUser.jsp">Voltar</a>
        <h1>Cadastro de Usuario</h1>
        <form name="NovoUsuario" action="NovoUsuario" method="POST">
            <table>
                <tr>
                    <td>Nome:</td>
                    <td><input type="text" name="nome"></td>
                </tr>
                <tr>
                    <td>Cpf:</td>
                    <td><input type="text" name="cpf"></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" name="email"></td>
                </tr>
                <tr>
                    <td>Telefone:</td>
                    <td><input type="text" name="telefone"></td>
                </tr>
                <tr>
            </table>
            <input type="submit" value="Submit">
            <% request.getAttribute("message"); %>
        </form>
    </body>
</html>
