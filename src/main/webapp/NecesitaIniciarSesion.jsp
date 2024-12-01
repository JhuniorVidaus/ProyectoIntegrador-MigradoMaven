<%-- 
    Document   : NecesitaIniciarSesion
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Necesita Registrarse</title>
        <link href="css/alerts.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script>
            window.onload = function () {
                Swal.fire({
                    title: "OOPS!",
                    text: "Para ver el carrito primero necesita iniciar sesión en la página.",
                    icon: "error", 
                    showConfirmButton: false,
                    footer: '<div class="d-flex justify-content-center" style="gap:5px"><a class="btn btn-warning" href="LoginCliente.jsp">Iniciar Sesión</a><a class="btn btn-success" href="ControladorCarrito01?accion=home.jsp">Volver a la Tienda</a><div>',
                    allowOutsideClick: false,
                    allowEscapeKey: false,
                    allowEnterKey: false,
                    customClass: {
                        popup: 'popup-alerts',
                        footer: 'popup-footer',
                    }
                });
            };
        </script>
        <style>
            body{
                background: tomato;
            }
        </style>
    </head>
    <body>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
