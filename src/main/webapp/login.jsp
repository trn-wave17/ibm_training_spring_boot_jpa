<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Employee Details</h3>
        <form method="POST" action="login">
             <table>
             	
                <tr>
                    <td><label path="username">Username</label></td>
                    <td><input path="username"/></td>
                </tr>
                <tr>
                    <td><label path="password">Password</label></td>
                    <td><input type="password" path="password"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>