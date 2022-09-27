
<%@page import="entity.Paciente"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.Medico"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor</title>
        <%
            ArrayList<Medico> listaMedicos = (ArrayList<Medico>) request.getAttribute("medicos");
            ArrayList<Paciente> listaPacientes = (ArrayList<Paciente>) request.getAttribute("pacientes");
        %>
        <link rel="stylesheet" href="style/style.css"/>
    </head>
    <body>
        <a href="index.jsp">Voltar</a>
        <a href="ReceitaView">Visualizar Receitas</a>
        <h1>Cadastro de Receitas</h1>
        <%
            out.print("Quantidade de médicos: " + listaMedicos.size() + "<br>");
            out.print("Quantidade de pacientes: " + listaPacientes.size());
        %>
        <div class="cadastro">
            <form id="formDefault" action="ReceitaInsert">
                Médico:
                <select name="medico">
                    <%for (int i = 0; i < listaMedicos.size(); i++) {%>
                    <%
                        out.print("<option>" + listaMedicos.get(i).getNome() + "</option>");
                    %>
                    <%}%> 
                </select>
                Paciente:
                <select name="paciente">
                    <%for (int i = 0; i < listaPacientes.size(); i++) {%>
                    <%
                        out.print("<option>" + listaPacientes.get(i).getNome() + "</option>");
                    %>
                    <%}%> 
                </select>
                <textarea name="descricao"></textarea>                
                <input type="submit" value="Cadastrar">
            </form>

        </div>
    </body>
</html>
