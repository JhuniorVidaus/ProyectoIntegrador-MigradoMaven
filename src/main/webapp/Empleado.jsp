<%-- 
    Document   : Empleado
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${empty sessionScope.usuario}">
    <% response.sendRedirect("loginadmin.jsp"); %>
</c:if>
<c:if test="${sessionScope.rol == 'Operador'}">
    <% response.sendRedirect("loginadmin.jsp");%>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="css/paneladmin.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/e7d86b2e04.js" crossorigin="anonymous"></script>
        <title>Adm Empleados</title>
    </head>
    <body>
        <div class="t_empleados">ADMINISTRAR EMPLEADOS</div>
        <br>
        <div class="containeradmin">
            <div class="contcontenido">
                <div class="card-body">
                    <form action="Controlador?menu=Empleado" method="POST">
                        <div class="form-group">
                            <label>ID</label>
                            <input type="text" value="${empleado.getId_empleado()}" name="txtidempleado" class="form-control" disabled>
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" value="${empleado.getNombre()}" name="txtnombre" class="form-control" maxlength="50" oninput="validateLetras(this)">
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" value="${empleado.getUsuario()}" name="txtusuario" class="form-control" maxlength="50">
                        </div>
                        <div class="form-group">
                            <label>Contraseña</label>
                            <input type="text" value="${empleado.getContraseña()}"  name="txtcontrasena" class="form-control" maxlength="50">
                        </div>
                        <div class="form-group">
                            <label>Rol</label>
                            <select value="${empleado.getRol()}" name="txtrol" class="form-control">
                                <option value="">Seleccione un rol</option>
                                <option value="Administrador">Administrador</option>
                                <option value="Operador">Operador</option>
                            </select>
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn btn-success">
                    </form>
                        <br>
                    <% if (request.getAttribute("success") != null) {%>
                    <div class="alert alert-success" role="alert">
                        <%= request.getAttribute("success")%>
                    </div>
                    <% } %>
                    <% if (request.getAttribute("actualizar") != null) {%>
                    <div class="alert alert-warning" role="alert">
                        <%= request.getAttribute("actualizar")%> 
                    </div>
                    <% }%>
                    <% if (request.getAttribute("error") != null) {%>
                    <div class="alert alert-danger" role="alert">
                        <%= request.getAttribute("error")%> 
                    </div>
                    <% }%>
                </div>
            </div>
            <div class="conttable">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombres</th>
                            <th>Usuario</th>
                            <th style="display:none">Contraseña</th>
                            <th>Rol</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="em" items="${empleados}">          
                            <tr>
                                <td>${em.getId_empleado()}</td>
                                <td>${em.getNombre()}</td>
                                <td>${em.getUsuario()}</td>
                                <td style="display:none">${em.getContraseña()}</td>
                                <td>${em.getRol()}</td>
                                <td>
                                    <a class="btn btn-warning" href="Controlador?menu=Empleado&accion=Modificar&id=${em.getId_empleado()}">Modificar</a>
                                    <a class="btn btn-danger" href="Controlador?menu=Empleado&accion=Eliminar&id=${em.getId_empleado()}">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script>
            function validateLetras(input) {
                input.value = input.value.replace(/[^a-zA-ZáéíóúÁÉÍÓÚñÑ\s]/g, '');
            }
        </script>    
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
