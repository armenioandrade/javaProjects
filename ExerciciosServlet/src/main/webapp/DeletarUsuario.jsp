<%-- 
    Document   : DeletarUsuario
    Created on : 10 de ago. de 2022, 12:58:38
    Author     : amaf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Deletar Usuario</title>
    </head>
    <body>
        <a href="MenuUser.jsp">Voltar</a>
        <h1>Remover usuário</h1>
        <form name="DeletarUsuario" action="DeletarUsuario" method="POST">
            <table>
                <tr>
                    <td>Informe o cpf do usuário:</td>
                    <td><input type="text" name="cpf"></td>
                </tr>
            </table>
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
