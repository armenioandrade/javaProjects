<%-- 
    Document   : combobox
    Created on : 29 de ago. de 2022, 22:14:35
    Author     : amaf
--%>

<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="model.JavaBeans" %>
<%@ page import="java.util.ArrayList" %>

<%
    ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatoscb");
    PrintWriter pw = response.getWriter();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" href="style.css">
    </head>
    <body>

        <form action="" id="tabela">
            <label for="cars">Selecione um nome:</label>
            <select name="" id="">
                <%for (int i = 0; i < lista.size(); i++) {
                            out.println("<option>" + lista.get(i).getNome() + "</option><br>");
                        }%>
            </select>
        </form>
    </body>
</html>
