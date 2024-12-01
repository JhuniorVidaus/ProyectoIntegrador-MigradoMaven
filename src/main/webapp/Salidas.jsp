<%-- 
    Document   : Salidas
    Created on : 28/06/2024, 04:03:01 PM
    Author     : User
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty sessionScope.usuario}">
    <% response.sendRedirect("loginadmin.jsp");%>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Salidas</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href="css/entradas.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container-ordenes">
            <h3>LISTA DE SALIDAS</h3>
            <br>
            <table id="tablaSalidas" class="table table-bordered table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>ID Pedido</th>
                        <th>Cliente</th>
                        <th>Correo Cliente</th>
                        <th>Productos x Cantidad</th>
                        <th>Fecha</th>
                        <th>Monto</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="pedido" items="${pedidos}">
                        <tr>
                            <td>${pedido.idPedido}</td>
                            <td>${pedido.nombreCliente}</td>
                            <td>${pedido.correo}</td>
                            <td>${pedido.nombreProductos}</td>
                            <td>${pedido.fecha}</td>
                            <td>S/.${pedido.monto}0</td>
                            <td>${pedido.estado}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#tablaSalidas').DataTable({
                    "language": {
                        "decimal": "",
                        "emptyTable": "No hay datos disponibles en la tabla",
                        "info": "Mostrando _START_ a _END_ de _TOTAL_ entradas",
                        "infoEmpty": "Mostrando 0 a 0 de 0 entradas",
                        "infoFiltered": "(filtrado de _MAX_ entradas totales)",
                        "infoPostFix": "",
                        "thousands": ",",
                        "lengthMenu": "Mostrar _MENU_ entradas",
                        "loadingRecords": "Cargando...",
                        "processing": "Procesando...",
                        "search": "Buscar:",
                        "zeroRecords": "No se encontraron registros coincidentes",
                        "paginate": {
                            "first": "Primero",
                            "last": "Último",
                            "next": "Siguiente",
                            "previous": "Anterior"
                        },
                        "aria": {
                            "sortAscending": ": activar para ordenar la columna ascendente",
                            "sortDescending": ": activar para ordenar la columna descendente"
                        }
                    }
                });
            });
        </script>
    </body>
</html>