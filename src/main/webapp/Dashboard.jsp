<%-- 
    Document   : Dashboard
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${empty sessionScope.usuario}">
    <% response.sendRedirect("loginadmin.jsp"); %>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
    </head>
    <body>
<iframe title="MuebleriaLuciaDatos" width="100%" height="800" src="https://app.powerbi.com/view?r=eyJrIjoiMTM4Njc1MTQtODZjNy00NmQ1LTliNGUtMmRlYjYyYjE5MGUwIiwidCI6ImM0YTY2YzM0LTJiYjctNDUxZi04YmUxLWIyYzI2YTQzMDE1OCIsImMiOjR9&pageName=9b3601030cc5e374d602" frameborder="0" allowFullScreen="true"></iframe>
    </body>
</html>
