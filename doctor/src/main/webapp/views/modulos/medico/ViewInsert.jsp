
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de médicos</title>
    </head>
    <body>
        <h1>Cadastro de Médicos</h1>
        <form id="formMedico" action="insert">
            Nome:<input type="text" name="nome">
            Cpf:<input type="text" name="cpf">
            Crm:<input type="text" name="crm">
            Sexo:<input type="text" name="sexo">
            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
