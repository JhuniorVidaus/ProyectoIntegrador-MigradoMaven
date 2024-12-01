<%-- 
    Document   : Producto
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
        <title>Adm Productos</title>
    </head>
    <body>
        <div class="t_empleados">ADMINISTRAR PRODUCTOS</div>
        <br>
        <div class="containeradmin">
            <div class="contcontenido">
                <div class="card-body">
                    <form action="Controlador?menu=Producto" method="POST">
                        <div class="form-group">
                            <label>ID</label>
                            <input type="text" value="${producto.getId_producto()}" name="txtidproducto" class="form-control" disabled>
                        </div>
                        <div class="form-group">
                            <label>Nombre</label>
                            <input type="text" value="${producto.getNombre()}" name="txtnombre" class="form-control" maxlength="50">
                        </div>
                        <div class="form-group">
                            <label>Foto</label>
                            <input type="file" value="${producto.getFoto()}" name="txtfoto" class="form-control" maxlength="250">
                        </div>
                        <div class="form-group">
                            <label>Descripción</label>
                            <input type="text" value="${producto.getDescripcion()}"  name="txtdescripcion" class="form-control" maxlength="255">
                        </div>
                        <div class="form-group">
                            <label>Precio</label>
                            <input type="text" value="${producto.getPrecio()}"  name="txtprecio" class="form-control" maxlength="10" oninput="validateNumeros(this, 10)">
                        </div>
                        <div class="form-group">
                            <label>Stock</label>
                            <input type="text" value="${producto.getStock()}"  name="txtstock" class="form-control" maxlength="5" oninput="validateNumeros(this, 5)">
                        </div>
                        <button type="submit" name="accion" value="Agregar" class="btn btn-info">Agregar</button>
                        <button type="submit" name="accion" value="Actualizar" class="btn btn-success">Actualizar</button>
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
                            <th>Nombre</th>
                            <th>Foto</th>
                            <th>Descripción</th>
                            <th>Precio</th>
                            <th>Stock</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${productos}">          
                        <tr>
                            <td>${p.getId_producto()}</td>
                            <td>${p.getNombre()}</td>
                            <td><img src="img/${p.getFoto()}" height="70" witdh="70"></td>
                            <td>${p.getDescripcion()}</td>
                            <td>S/.${p.getPrecio()}0</td>
                            <td>${p.getStock()}</td>
                            <td>
                                <a class="btn btn-warning" href="Controlador?menu=Producto&accion=Modificar&idp=${p.getId_producto()}">Modificar</a>
                                <a class="btn btn-danger" href="Controlador?menu=Producto&accion=Eliminar&idp=${p.getId_producto()}">Eliminar</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <script>
            function validateNumeros(input, maxLength) {
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
