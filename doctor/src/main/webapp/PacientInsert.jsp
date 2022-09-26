<%-- 
    Document   : DoctorPacient
    Created on : 26 de set. de 2022, 11:44:14
    Author     : armenioandrade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
       <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor</title>
    </head>
    <body>
        <a href="PacientView">Visualizar Paciente</a>
        <a href="index.jsp">Voltar</a>
        <h1>Cadastro de Pacientes</h1>
        <form id="formDefault" action="PacientInsert" method="POST">
            Nome:<input type="text" name="nome">
            Cpf:<input type="text" name="cpf">
            Data de Nascimento:<input type="date" name="data">
            <select id="id" name="selectSexo">
                <option value="Masculino">Masculino</option>
                <option value="Feminino">Feminino</option>
            </select>
            <input type="submit" value="Cadastrar">
        </form>
    </body>
</html>
