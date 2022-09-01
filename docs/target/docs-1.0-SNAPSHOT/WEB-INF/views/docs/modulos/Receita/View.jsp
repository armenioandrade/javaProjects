<%@ page import="docs.entity.Medico" %>
<%@ page import="docs.control.MedicoControl" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <%
            MedicoControl mc = new MedicoControl();
            ArrayList<Medico> lista = (ArrayList<Medico>) mc.searchAll();
        %>
    </head>
    <body>
        <label for="Médicos">Selecione um nome:</label>
        <select name="" id="">
            <%for (int i = 0; i < lista.size(); i++) {
                        out.println("<option>" + lista.get(i).getNome() + "</option><br>");
                    }%>
        </select>

    </body>
</html>