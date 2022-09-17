<%@page import="docs.entity.Paciente"%>
<%@page import="docs.control.PacienteControl"%>
<%@ page import="docs.entity.Medico" %>
<%@ page import="docs.control.MedicoControl" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <%
            MedicoControl mc = new MedicoControl();
            PacienteControl pc = new PacienteControl();
            ArrayList<Medico> lista = (ArrayList<Medico>) mc.searchAll();
            ArrayList<Paciente> listap = (ArrayList<Paciente>) pc.searchAll();
        %>
    </head>
    <body>
        <div>
        <label for="Médicos">Selecione um médico:</label>
        <select name="" id="">
            <%for (int i = 0; i < lista.size(); i++) {
                        out.println("<option>" + lista.get(i).getNome() + "</option><br>");
                    }%>
        </select>
        <label for="Médicos">Selecione um Paciente:</label>
        <select name="" id="">
            <%for (int i = 0; i < listap.size(); i++) {
                        out.println("<option>" + listap.get(i).getNome() + "</option><br>");
                    }%>
        </select>
        Adicione uma descricao: <input type="text" name="descricao">
        <input type="submit" value="Gerar Receita">
        </div>
    </body>
</html>