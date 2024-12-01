<%-- 
    Document   : Carrito
    Author     : Desktop
--%>

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
        <title>Carrito</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/carrito.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
        <style>
            body {
                display: flex;
                flex-direction: column;
                min-height: 100vh;
                font-family: 'Poppins', sans-serif;
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
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item font1" href="${pageContext.request.contextPath}/miscompras">Mis Compras <i class="fa-brands fa-shopify"></i></a>
                        </div>
                    </li>
                </ul>

            </div>
        </nav>
        <div class="mt-4">
            <h2>CARRITO DE COMPRAS</h2>
            <br>
            <div class="carritocontainer">
                <c:choose>
                    <c:when test="${empty Carrito}">
                        <div class="alert alert-warning" style="grid-column: span 2;" role="alert">
                            Tu carrito está vacío <i class="fa-solid fa-face-frown"></i>.
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="conttable">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th class="text-center desa font4">ITEM</th>
                                        <th class="text-center font4">NOMBRE</th>
                                        <th class="text-center desa font4">DESCRIPCION</th>
                                        <th class="text-center font4">IMAGEN</th>
                                        <th class="text-center font4">PRECIO</th>
                                        <th class="text-center font4">CANTIDAD</th>
                                        <th class="text-center font4">SUBTOTAL</th>
                                        <th class="text-center font4"></th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach var="car" items="${Carrito}">
                                        <tr>
                                            <td class="text-center desa font4">${car.getItem()}</td>
                                            <td class="text-center font4">${car.getNombres()}</td>
                                            <td class="text-center desa font4">${car.getDescrpcion()}</td>
                                            <td class="text-center"> <img src="img/${car.getFoto()}" width="100" height="100"></td>
                                            <td class="text-center font4">${car.getPrecioCompra()}</td>
                                            <td class="text-center font4">
                                                <input type="hidden" id="idpro" value="${car.getIdProducto()}">
                                                <input type="number" id="Cantidad" value="${car.getCantidad()}"  class="form-control text-center cantidad font4" min="1" max="10">
                                            </td>
                                            <td class="text-center font4">${car.getSubtotal()}</td>
                                            <td class="text-center font4">
                                                <input type="hidden" id="idp" value="${car.getIdProducto()}">
                                                <a href="#" id="btnDelete"><i class="fa-solid fa-trash"></i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>    
                                </tbody>
                            </table>
                        </div>
                        <div class="contcompra">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="font3"> Generar Compra </h4>
                                </div>
                                <div class="card-body font4">
                                    <label>SUBTOTAL:</label>
                                    <input type="text" value="S/.${totalPagar}0" readonly="" class="form-control font4">
                                    <br>
                                    <label>DESCUENTO:</label>
                                    <input type="text" value="S/.0.00" readonly="" class="form-control font4">
                                    <br>
                                    <label>TOTAL:</label>
                                    <input type="text" value="S/.${totalPagar}0" readonly="" class="form-control font4">
                                </div>
                                <div class="card-footer">
                                    <a href="ControladorCarrito01?accion=RealizarPago" class="btn btn-info btn-block font4" disable> Realizar Pago</a>
                                    <a href="ControladorCarrito01?accion=GenerarVenta" class="btn btn-danger btn-block font4" disable>Generar Venta</a>
                                </div>
                            </div>        
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
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
        <script src="https://code.jquery.com/jquery-3.6.0.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script src="js/funciones.js" type="text/javascript"></script>
        <script src="js/alertas.js" type="text/javascript"></script>
    </body>

</html>
