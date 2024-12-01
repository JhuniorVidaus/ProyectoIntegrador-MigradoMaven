<%-- 
    Document   : Cliente
    Author     : User
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${empty sessionScope.usuario}">
    <% response.sendRedirect("loginadmin.jsp"); %>
</c:if>
<c:if test="${sessionScope.rol == 'Operador'}">
    <% response.sendRedirect("loginadmin.jsp"); %>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="css/paneladmin.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/e7d86b2e04.js" crossorigin="anonymous"></script>
        <title>Adm Clientes</title>
    </head>
    <body>
        <div class="t_empleados">ADMINISTRAR CLIENTES</div>
        <br>
        <div class="containeradmin">
            <div class="card contcontenido">
                <div class="card-body">
                    <form action="Controlador?menu=Cliente" method="POST">
                        <div class="form-group">
                            <label>ID</label>
                            <input type="text" value="${cliente.getId_cliente()}" name="txtidcliente" class="form-control" disabled>
                        </div>
                        <div class="form-group">
                            <label>DNI</label>
                            <input type="text" value="${cliente.getDni()}" name="txtdni" class="form-control" maxlength="8" oninput="validateDNI(this, 8)">
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${cliente.getNombre()}" name="txtnombre" class="form-control" maxlength="50" oninput="validateLetras(this)">
                        </div>
                        <div class="form-group">
                            <label>Direccion</label>
                            <input type="text" value="${cliente.getDirección()}"  name="txtdireccion" class="form-control" maxlength="250">
                        </div>
                        <div class="form-group">
                            <label>Correo</label>
                            <input type="email" value="${cliente.getCorreo()}" name="txtcorreo" class="form-control" maxlength="50">
                        </div>
                        <div class="form-group">
                            <label>Password</label>
                            <input type="text" value="${cliente.getPassword()}"  name="txtpassword" class="form-control" maxlength="50">
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
                            <th>DNI</th>
                            <th>Nombre</th>
                            <th>Direccion</th>
                            <th>Correo</th>
                            <th style="display:none">Password</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="cl" items="${clientes}">          
                        <tr>
                            <td>${cl.getId_cliente()}</td>
                            <td>${cl.getDni()}</td>
                            <td>${cl.getNombre()}</td>
                            <td>${cl.getDirección()}</td>
                            <td>${cl.getCorreo()}</td>
                            <td style="display:none">${cl.getPassword()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Cliente&accion=Modificar&idcl=${cl.getId_cliente()}">Modificar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Cliente&accion=Eliminar&idcl=${cl.getId_cliente()}">Eliminar</a>
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
            
            function validateDNI(input, maxLength) {
                input.value = input.value.replace(/[^0-9]/g, '');

                if (input.value.length > maxLength) {
                    input.value = input.value.slice(0, maxLength);
                }
            }
        </script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
