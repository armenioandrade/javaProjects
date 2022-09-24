
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de médicos</title>
    </head>
    <body>
        <h1>Bem-Vindo!</h1>
        <a href="DoctorInsert.jsp">Inserir Médico</a>
        <a href="DoctorView">Visualizar Médico</a>
        <h1>Cadastro de Médicos</h1>
        <form id="formDefault" action="insert" method="POST">
            Nome:<input type="text" name="nome">
            Cpf:<input type="text" name="cpf">
            Crm:<input type="text" name="crm">
            <select id="id" name="selectSexo">
                <option value="Masculino">Masculino</option>
                <option value="Feminino">Feminino</option>
            </select>
            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
