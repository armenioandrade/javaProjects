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
        <title>Editar Médico</title>
    </head>
    <body>
        <a href="DoctorInsert.jsp">Inserir Médico</a>
        <a href="DoctorView">Visualizar Médico</a>
        <a href="index.jsp">Voltar</a>
        <h1>Alteração de Médicos</h1>
        

        
        
        <form id="formDefault" action="DoctorUpdate" method="POST">
            
            ID: <input type="text" name="id" readonly="" value="<%out.print(request.getParameter("id"));%>">
            Nome:<input type="text" name="nome" value="<%out.print(request.getAttribute("nome"));%>"> 
            Cpf:<input type="text" name="cpf" value="<%out.print(request.getAttribute("cpf"));%>">
            Crm:<input type="text" name="crm" value="<%out.print(request.getAttribute("crm"));%>">
            <select name="sexo">
                <option>--<%out.print(request.getAttribute("sexo"));%>--</option>
                <option>MASCULINO</option>
                <option>FEMININO</option>
            </select>
            <input type="submit" value="Atualizar">
        </form>
    </body>
</html>
