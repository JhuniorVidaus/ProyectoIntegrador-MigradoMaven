<%-- 
    Document   : Index
    Created on : 21 may. 2024, 6:04:39 p. m.
    Author     : Desktop
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
        <script src="https://kit.fontawesome.com/e7d86b2e04.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mueblería Lucía</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/carrito.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&display=swap" rel="stylesheet">
        <style>
            body {
                display: flex;
                flex-direction: column;
                min-height: 100vh;
                margin: 0;
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

            .navbar-brand {
                margin-right: auto;
            }

            .d-flex {
                flex-grow: 1;
                justify-content: center;
            }

            .collapse.navbar-collapse {
                margin-left: auto;
            }

            .xd{
                margin: 2rem auto 0;
            }

            .buscarproducto{
                display: flex;
                justify-content: center;
                margin-top: 2rem;
            }
            .contadorpagina{
                display: none;
            }
        </style>
        <script type="text/javascript">
            window.onload = function() {
                const urlParams = new URLSearchParams(window.location.search);
                const accion = urlParams.get('accion');
                const buscar = urlParams.get('Buscar');

                // Verifica si se ha realizado una búsqueda
                if (accion === 'BuscarProducto' && buscar) {
                    // No hagas nada si se ha realizado una búsqueda
                } else {
                    // Realiza la redirección solo si no se ha realizado una búsqueda y no estamos ya en la página de inicio
                    if (accion !== 'home') {
                        window.location.href = 'ControladorCarrito01?accion=home';
                    }
                }
            };
        </script>
    </head>
    <body>
        <script>
                window.addEventListener('mouseover', initLandbot, { once: true });
                window.addEventListener('touchstart', initLandbot, { once: true });
                var myLandbot;
                function initLandbot() {
                  if (!myLandbot) {
                    var s = document.createElement('script');s.type = 'text/javascript';s.async = true;
                    s.addEventListener('load', function() {
                      myLandbot = new Landbot.Popup({
                        configUrl: 'https://storage.googleapis.com/landbot.online/v3/H-2537195-7P244QM7OJ9UIZMK/index.json',
                      });
                    });
                    s.src = 'https://cdn.landbot.io/landbot-3/landbot-3.0.0.js';
                    var x = document.getElementsByTagName('script')[0];
                    x.parentNode.insertBefore(s, x);
                  }
                }
        </script>
        <nav class="navbar navbar-expand-lg navbar-dark bgindex catalogo sticky-top">
            <div class="container-fluid d-flex justify-content-between align-items-center">
                <a class="navbar-brand classtitulo" href="#">Muebleria Lucia</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active font2">
                            <a class="nav-link disabled menubtn font1" href="ControladorCarrito01?accion=home">Catalogo de Productos<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active font2">
                            <a class="nav-link disabled menubtn font1" href="ControladorCarrito01?accion=Carrito">Carrito <i class="fas fa-cart-plus" style="color:tomato">
                                    ( <label style="color:black">
                                        <c:choose>
                                            <c:when test="${contador != null}">
                                                ${contador}
                                            </c:when>
                                            <c:otherwise>
                                                0
                                            </c:otherwise>
                                        </c:choose>
                                    </label> )
                                </i></a>
                        </li>
                    </ul>
                    <c:choose>
                        <c:when test="${empty sessionScope.nombrecliente}">
                            <a href="LoginCliente.jsp" class="btn btn-dark font2 ">Iniciar Sesión</a>
                        </c:when>
                        <c:otherwise>
                            <ul class="navbar-nav">
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle font2 text-dark fwi" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Bienvenido ${sessionScope.nombrecliente} <i class="fa-solid fa-user" style="color:black"></i>
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <a class="dropdown-item font1" href="${pageContext.request.contextPath}/miscompras">Mis Compras <i class="fa-brands fa-shopify"></i></a>
                                        <form action="ValidarLoginCliente" method="POST">
                                            <button name="accionvalidar" value="salir" class="dropdown-item font1">Cerrar Sesión <i class="fa-solid fa-arrow-right-from-bracket"></i></button>
                                        </form>  
                                    </div>
                                </li>
                            </ul>
                        </c:otherwise>
                    </c:choose>         
                </div>
            </div>
        </nav>
        <form>
            <div class="buscarproducto">
                <div class="form-outline" data-mdb-input-init>
                    <input id="search-input" name="Buscar" type="search" class="form-control" />
                </div>
                <button id="search-button" name="accion" type="submit" value="BuscarProducto" class="btn btn-primary">
                    <i class="fas fa-search"></i>
                </button>
            </div>
        </form>
        <div class="xd">
            <h1>PRODUCTOS DISPONIBLES</h1>
        </div>
        <div class="containerproductosgrid">
            <c:forEach var="p" items="${productos}">                         
                <div class="containerproducts">
                    <div class="card containerraaa">
                        <div class="card-header text-center"> 
                            <label class="h5 nombrepr">${p.getNombre()}</label>
                        </div>
                        <div class="card-body d-flex justify-content-center align-items-center ">

                            <img src="img/${p.getFoto()}" width="200" height="180" class="imgproducto">
                        </div>
                        <div class="card-body d-flex justify-content-center align-items-center">
                            <p class="precio"> S/.${p.getPrecio()} </p>
                        </div>
                        <div class="card-footer text-center">
                            <label class="font1"> ${p.getDescripcion()}  </label>
                            <div>
                                <a href="javascript:void(0);" onclick="agregarAlCarrito('ControladorCarrito01?accion=AgregarCarrito&id=${p.getId_producto()}')" class="btn btn-info btncomprar font1">Agregar Carrito</a>                             
                            </div>
                        </div>   
                    </div>    
                </div>  

            </c:forEach>
        </div>
        <br>
        <br> 
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
        <div class="contadorpagina" id="sfc6byl42zwr2rrsuqhjg8xf5x5rgldylzb"></div> 
        <script src="js/restablecerscroll.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="js/alertas.js" type="text/javascript"></script>
</html>
