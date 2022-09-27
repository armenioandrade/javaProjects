<%-- 
    Document   : DoctorEdit
    Created on : 26 de set. de 2022, 07:43:27
    Author     : armenioandrade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE <html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Paciente</title>
    </head>
    <body>

        <a href="index.jsp">Voltar</a>
        <h1>Alteração de Receitas</h1>

        <form id="formDefault" action="ReceitaUpdate" method="POST">

            ID: <input type="text" name="id" readonly="" value="<%out.print(request.getParameter("id"));%>">
            Medico:
            <select name="medico">
                
            </select>
            Paciente:<input type="text" name="paciente" value="<%out.print(request.getAttribute("paciente"));%>">
            Data de Registro:<input type="date" name="data" value="<%out.print(request.getAttribute("data"));%>">
            Sexo:
            <select name="sexo">
                <option>--<%out.print(request.getAttribute("sexo"));%>--</option>
                <option>MASCULINO</option>
                <option>FEMININO</option>
            </select>
            
            <input type="submit" value="Atualizar">
        </form>
    </body>
</html>
