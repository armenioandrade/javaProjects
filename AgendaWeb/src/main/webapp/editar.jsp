<%-- 
    Document   : editar
    Created on : 24 de ago. de 2022, 12:02:10
    Author     : amaf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Novo Contato</title>
        <link rel="icon" href="imagens/favicon.png">
        <link rel="stylesheet" href="style.css">
        <title>Agenda de contatos</title>
    </head>
    <body>
        <h1>Editar contato</h1>
        <form name="frmContato" action="update">
            <table>
                <tr>
                    <td>
                        <input type="text" name="idcon"  id="caixa3" readonly value="<%out.print(request.getAttribute("idcon"));%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="nome"  class="caixa1" value="<%out.print(request.getAttribute("nome"));%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="fone"  class="caixa2" value="<%out.print(request.getAttribute("fone"));%>">
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="text" name="email"  class="caixa1" value="<%out.print(request.getAttribute("email"));%>">
                    </td>
                </tr>
            </table>
            <input type="button" value="Salvar" class="botao1" onclick="validar()">
        </form>
        <script src="scripts/validador.js"></script>
    </body>
</html>
