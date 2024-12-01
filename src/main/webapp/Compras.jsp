<%-- 
    Document   : Compras
    Author     : Desktop
--%>

<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${empty sessionScope.idcliente}">
    <% response.sendRedirect("NecesitaIniciarSesion.jsp");%>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://kit.fontawesome.com/e7d86b2e04.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis Compras</title>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/carrito.css" rel="stylesheet" type="text/css"/>
        <style>
            body {
                font-family: 'Poppins', sans-serif;
                display: flex;
                flex-direction: column;
                min-height: 100vh;
            }
            .container {
                flex: 1;
            }
            .footer {
                background-color: #343a40;
                color: white;
                padding: 1rem 0;
            }
            .fwi{
                font-weight: 700;
                text-transform: uppercase;
            }

            .mt-4{
                margin: 2rem;
            }
            .cantidad{
                width: 100px
            }
            .navbar-nav{
                margin-right: 50px;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bgindex">
            <a class="navbar-brand classtitulo" href="#">Muebleria Lucia</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item font2">
                        <a class="nav-link active menubtn font1" href="ControladorCarrito01?accion=home">Seguir Comprando <i class="fa-solid fa-store"></i></a>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item dropdown font2">
                        <a class="nav-link dropdown-toggle text-dark fwi" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Bienvenido ${sessionScope.nombrecliente} <i class="fa-solid fa-user" style="color:black"></i>
                        </a>
                    </li>
                </ul>

            </div>
        </nav>
        <br>
        <div class="container-ordenes">
            <h2>MIS COMPRAS</h2>
            <table class="table table-bordered table-striped" id="tablaCompras">
                <thead class="thead-dark">
                    <tr>
                        <th>ID Pedido</th>
                        <th>Datos: Nombre</th>
                        <th>Correo</th>
                        <th>Productos</th>
                        <th>Fecha</th>
                        <th>Monto</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Modelos.Pedido> pedidos = (List<Modelos.Pedido>) request.getAttribute("pedidos");
                        if (pedidos != null) {
                            for (Modelos.Pedido pedido : pedidos) {
                    %>
                    <tr>
                        <td><%= pedido.getIdPedido()%></td>
                        <td><%= pedido.getNombreCliente()%></td>
                        <td><%= pedido.getCorreo()%></td>
                        <td><%= pedido.getNombreProductos()%></td>
                        <td><%= pedido.getFecha()%></td>
                        <td>S/.<%= pedido.getMonto()%>0</td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="7">No hay pedidos para mostrar.</td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
            <br>
        </div>
        <footer class="footer mt-auto py-3 bg-dark text-white">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12 text-center">
                        Síguenos en nuestras redes sociales:
                        <a href="#" class="text-white"><i class="fab fa-facebook-f mx-2"></i></a>
                        <a href="#" class="text-white"><i class="fab fa-twitter mx-2"></i></a>
                        <a href="#" class="text-white"><i class="fab fa-instagram mx-2"></i></a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-center">
                        © 2024 MuebleriaLucia. Todos los derechos reservados.
                    </div>
                </div>
            </div>
        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
        <script>
            $(document).ready(function () {
                $('#tablaCompras').DataTable({
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