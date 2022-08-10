<%-- 
    Document   : response
    Created on : 8 de ago. de 2022, 13:30:37
    Author     : amaf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <h1>Hello, <%=request.getParameter("name") %>!</h1>
        <h1>Hello1, <%=request.getParameter("lastName") %>!</h1>
        <br>
    </body>
</html>
