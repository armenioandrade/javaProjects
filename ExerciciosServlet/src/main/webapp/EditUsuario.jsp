<%-- 
    Document   : EditUsuario
    Created on : 10 de ago. de 2022, 12:57:42
    Author     : amaf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Usuario</title>
    </head>
    <body>
        <a href="MenuUser.jsp">Voltar</a>
        <h1>Editar Usuario</h1>
        <form name="EditUsuario" action="EditUsuario" method="POST">
            <table>
                <tr>
                    <td>Cpf:</td>
                    <td><input type="text" name="cpf"></td>
                    <td><% request.getAttribute("nome"); %></td>
                </tr>
            </table>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
