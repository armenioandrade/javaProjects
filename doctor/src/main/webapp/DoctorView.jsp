
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="dao.MedicoDao"%>
<%@page import="java.util.List" %>
<%@page import="entity.Medico" %>
<%@page import="java.util.ArrayList" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Médicos</title>
        <script defer src="/doctor/scripts/validador.js"></script>
    </head>
    <body>
        <h1>Doctor</h1>
        <a href="DoctorInsert.jsp">Inserir Médico</a>
        <a href="DoctorView">Visualizar Médico</a>
        <a href="PacientInsert.jsp">Inserir Paciente</a>
        <a href="PacientView">Visualizar Paciente</a>
        <a href="index.jsp">Voltar</a>
        <h1>Lista de Médicos</h1>
        <%
            ArrayList<Medico> lista = (ArrayList<Medico>) request.getAttribute("medicos");

            out.print("Quantidade de médicos: " + lista.size());
        %>

        <table id="tabela">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Sexo</th>
                    <th>CPF</th>
                    <th>CRM</th>
                    <th>Opções</th>
                </tr>
            </thead>
            <tbody>

                <%for (int i = 0; i < lista.size(); i++) {%>
                <tr>

                    <td> <%= lista.get(i).getId()%> </td>
                    <td> <%= lista.get(i).getNome()%> </td>
                    <td> <%= lista.get(i).getSexo()%> </td>
                    <td> <%= lista.get(i).getCpf()%> </td>
                    <td> <%= lista.get(i).getCrm()%> </td>
                    <td><a href="DoctorSelect?id=<%=lista.get(i).getId()%>" class="botao1">Editar</a>
                        <a href="javascript: confirmarDelete(<%=lista.get(i).getId()%>)" class="botao2">Excluir</a>
                    </td>

                </tr>
                <%}%>



                </body>
                </html>
