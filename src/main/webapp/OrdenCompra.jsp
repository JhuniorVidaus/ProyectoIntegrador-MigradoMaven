<%-- 
    Document   : OrdenCompra
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${empty sessionScope.usuario}">
    <% response.sendRedirect("loginadmin.jsp");%>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://kit.fontawesome.com/e7d86b2e04.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="css/paneladmin.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
        <title>Orden Compra</title>
    </head>
    <body>
        <div class="t_empleados">NUEVA ORDEN DE PEDIDO</div>
        <br>
        <div class="containeradmin siimprimir1">
            <div class="contcontenidoorden noimprimir1">
                <div class="card">
                    <form action="Controlador?menu=OrdenCompra" method="POST">
                        <div class="card-body">
                            <div class="form-group">
                                <label>Datos del Proveedor</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <select name="nombreproveedor" class="form-control">
                                        <c:forEach var="pronom" items="${provenombres}">
                                            <option value="${pronom}" ${pronom == proveedor.nombre ? 'selected' : ''}>${pronom}</option>
                                        </c:forEach>
                                    </select>
                                    <button type="submit" name="accion" value="BuscarProveedor" class="btn btn-outline-info">
                                        <i class="fa-solid fa-magnifying-glass"></i>
                                    </button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="txtidproveedor" value="${proveedor.getId_proveedor()}" class="form-control" placeholder="Código">
                                </div>
                            </div>

                            <div class="form-group">
                                <label>Datos del Producto</label>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6 d-flex">
                                    <select name="productnombre" class="form-control">
                                        <c:forEach var="productnom" items="${productnombres}">
                                            <option value="${productnom}" ${productnom == producto.nombre ? 'selected' : ''}>${productnom}</option>
                                        </c:forEach>
                                    </select>
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">
                                        <i class="fa-solid fa-magnifying-glass"></i>
                                    </button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="txtidproducto" value="${producto.getId_producto()}" class="form-control" placeholder="Código">
                                </div>
                            </div>
                            <div class="form-group d-flex">
                                <div class="col-sm-6">
                                    <small>Cantidad</small>
                                    <input type="number" name="cantidad" value="1" class="form-control" min="1">
                                </div>
                                <div class="col-sm-6">
                                    <small>Stock Actual</small>
                                    <input type="text" name="stock" value="${producto.getStock()}" class="form-control" placeholder="Stock del producto">
                                </div>                               
                            </div>
                            <div class="form-group">
                                <button type="submit" name="accion" value="Agregar" class="btn btn-outline-info">Agregar</button>
                            </div>
                        </div>
                    </form>
                    <br>
                    <% if (request.getAttribute("success") != null) {%>
                    <div class="alert alert-success" role="alert">
                        <%= request.getAttribute("success")%>${nserie-1}
                    </div>
                    <% } %>
                </div>
            </div>
            <div class="conttableorden">
                <div class="card">
                    <div class="card-body">
                        <div class="col-sm-3 ml-auto imprimirp2">
                            <label class="nosalir" style="font-weight: 600">Realizado por:</label>
                            <input type="text" name="NombreEmpleado" value="<%= session.getAttribute("nombreEmpleado")%>" class="form-control nosalir" disabled>
                            <label class="nosalir" style="font-weight: 600">Fecha de Orden:</label>
                            <input type="text" name="fecharaa" value="${f_fecha}" class="form-control nosalir" disabled>
                            <label style="font-weight: 600">Número de Serie:</label>
                            <input type="text" nombre="NroSerie" value="${nserie}" class="form-control" disabled>
                            <br>
                        </div>
                        <br>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Nro</th>
                                    <th>Código</th>
                                    <th>Descripcion</th>
                                    <th>Cantidad</th>
                                    <th>Stock Inicial</th>
                                    <th>Stock Final</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="ordenCompra" items="${lista}">
                                    <tr>
                                        <td>${ordenCompra.getItem()}</td>
                                        <td>${ordenCompra.getId_producto()}</td>
                                        <td>${ordenCompra.getDescripcionOrden()}</td>
                                        <td>${ordenCompra.getCantidad()}</td>
                                        <td>${ordenCompra.getStock_inicial()}</td>
                                        <td>${ordenCompra.getStock_final()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div class="card-footer">
                        <a href="Controlador?menu=OrdenCompra&accion=GenerarOrden" onclick="print()" class="btn btn-success">Generar Orden</a>
                        <a href="Controlador?menu=OrdenCompra&accion=default" class="btn btn-danger">Cancelar Orden</a>
                    </div>
                </div>
            </div>
        </div>


        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>
