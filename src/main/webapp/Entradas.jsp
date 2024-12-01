<%-- 
    Document   : Entradas
    Author     : User
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<c:if test="${empty sessionScope.usuario}">
    <% response.sendRedirect("loginadmin.jsp"); %>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <title>Entradas</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <link href="css/entradas.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container-ordenes">
            <h3>LISTA DE ENTRADAS</h3>
            <br>       
            <table id="tablaEntradas" class="table table-bordered table-striped">
                <thead class="thead-dark">
                    <tr>
                        <th>N. Serie</th>
                        <th>Empleado</th>
                        <th>Proveedor</th>
                        <th>Producto</th>
                        <th>Fecha</th>
                        <th>Cantidad Ingresada</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="orden" items="${ordenes}">
                        <tr>
                            <td>${orden.NSerie}</td>
                            <td>${orden.nombreEmpleado}</td>
                            <td>${orden.nombreProveedor}</td>
                            <td>${orden.nombreProducto}</td>
                            <td>${orden.fecha}</td>
                            <td>${orden.cantidadTotal}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#tablaEntradas').DataTable({
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