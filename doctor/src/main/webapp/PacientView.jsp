
<%@page import="entity.Paciente"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Pacientes</title>
        <script defer src="/doctor/scripts/validador.js"></script>
    </head>
    <body>
        <h1>Doctor</h1>
        <a href="PacientInsert.jsp">Inserir Paciente</a>
        <a href="PacientView">Visualizar Paciente</a>
        <a href="index.jsp">Voltar</a>
        <h1>Lista de Pacientes</h1>
        <%
            ArrayList<Paciente> lista = (ArrayList<Paciente>) request.getAttribute("pacientes");

            out.print("Quantidade de Pacientes " + lista.size());
        %>

        <table id="tabela">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Sexo</th>
                    <th>CPF</th>
                    <th>Data de Nascimento</th>
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
                    <td> <%= lista.get(i).getDataNascimento()%> </td>
                    <td><a href="PacientSelect?id=<%=lista.get(i).getId()%>" class="botao1">Editar</a>
                        <a href="javascript: confirmarDelete(<%=lista.get(i).getId()%>)" class="botao2">Excluir</a>
                    </td>

                </tr>
                <%}%>



                </body>
                </html>
