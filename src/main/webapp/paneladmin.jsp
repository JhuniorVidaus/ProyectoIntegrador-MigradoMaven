<%-- 
    Document   : paneladmin.jsp
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:if test="${empty sessionScope.usuario}">
    <% response.sendRedirect("loginadmin.jsp");%>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="css/paneladmin.css">
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
        <script src="https://kit.fontawesome.com/e7d86b2e04.js" crossorigin="anonymous"></script>
        <title>SISAD ML</title>
        <c:if test="${rol eq 'Administrador'}">
            <style type="text/css">
                .soloadmin {
                    display: inline-block; /* o lo que corresponda para mostrar el botón */
                }
                .footer {
                    position: relative;
                    background-color: #343a40;
                    color: white;
                    padding: 1rem 0;
                }
            </style>
        </c:if>
        <c:if test="${rol ne 'Administrador'}">
            <style type="text/css">
                .soloadmin {
                    display: none;
                }
            </style>
        </c:if>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light sticky-top" style="background-color: #096C66;">
            <a class="navbar-brand classtitulo" href="paneladmin.jsp">SISGES MUEBLERIA LUCIA</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav m-auto">
                    <li class="nav-item dropdown">
                        <a class="btn btn-outline-light dropdown-toggle seccionn soloadmin font1" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Administración <i class="fa-solid fa-cog"></i>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item font1" href="Controlador?menu=Cliente&accion=Listar" target="myframe">Clientes <i class="fa-solid fa-users"></i></a>
                            <a class="dropdown-item font1" href="Controlador?menu=Empleado&accion=Listar" target="myframe">Empleados <i class="fa-solid fa-user-tie"></i></a>
                            <a class="dropdown-item font1" href="Controlador?menu=Producto&accion=Listar" target="myframe">Productos <i class="fa-solid fa-tag"></i></a>
                            <a class="dropdown-item font1" href="Controlador?menu=Proveedor&accion=Listar" target="myframe">Proveedores <i class="fa-solid fa-parachute-box"></i></a>
                        </div>
                    </li>
                    <br>
                    <li class="nav-item dropdown">
                        <a class="btn btn-outline-light dropdown-toggle seccionn font1" href="#" id="navbarDropdownOperaciones" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Acciones <i class="fa-solid fa-cog"></i>
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownOperaciones">
                            <a class="dropdown-item font1" href="Controlador?menu=OrdenCompra&accion=default" target="myframe">Nueva Orden <i class="fa-solid fa-clipboard"></i></a>
                            <a class="dropdown-item font1" href="ordenes" target="myframe">Ver Entradas <i class="fa-sharp fa-solid fa-truck-ramp-box"></i></a>
                            <a class="dropdown-item font1" href="pedidos" target="myframe">Ver Salidas <i class="fa-solid fa-truck"></i></a>
                            <a class="dropdown-item font1" href="Dashboard.jsp" target="myframe">Ver Dashboard <i class="fa-solid fa-chart-line"></i></a>
                        </div>
                    </li>
                    <br>
                    <li class="nav-item">
                        <a class="btn btn-outline-light seccionn tienda font1" href="index.jsp" target="blank">Ir a la tienda <i class="fa-solid fa-shop"></i></a>
                    </li>
                    <br>
                </ul>
                <div class="dropdown userinfo">
                    <button class="btn btn-secondary dropdown-toggle font1" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        ${sessionScope.nombreEmpleado} <i class="fa-solid fa-user" style="color:black"></i>
                    </button>
                    <div class="dropdown-menu text-center font1">
                        <a class="dropdown-item" href="#">
                            <img src="img/adminuser.png" alt="" height="60" width="60"/>
                        </a>
                        <a class="dropdown-item" href="#">Usuario: ${sessionScope.usuario}</a>
                        <a class="dropdown-item" href="#">Rol: ${sessionScope.rol}</a>
                        <div class="dropdown-divider"></div>
                        <form action="Validarlogin" method="POST">
                            <button name="accionvalidar" value="salir" class="dropdown-item" href="#">Cerrar Sesión <i class="fa-solid fa-arrow-right-from-bracket"></i></button>
                        </form>                     
                    </div>
                </div>
            </div>
        </nav>
        <div class="contenido" style="height: 100vh; width: 100%">
            <iframe name="myframe" class="myframe" src="Dashboard.jsp">

            </iframe>
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
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
