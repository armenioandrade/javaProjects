<%-- 
    Document   : index
    Created on : 10 de ago. de 2022, 09:11:09
    Author     : amaf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login ao site</h1>
        <form action="Login" method="post">

            <table>

                <tr>

                    <td>Name:</td>


                    <td><input type="text" name="userName"></td>

                </tr>


                <tr>

                    <td>Password:</td>


                    <td><input type="password" name="userPassword"></td>

                </tr>

            </table>

            <input type="submit" value="Submit">
            
            <% request.getAttribute("message"); %>
            
            
        </form>
    </body>
</html>
