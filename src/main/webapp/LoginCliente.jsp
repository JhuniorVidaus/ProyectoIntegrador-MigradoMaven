<%-- 
    Document   : LoginCliente
    Author     : User
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Iniciar Sesión</title>

    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">
    <link rel="stylesheet" href="css/logincliente.css">
</head>
<body>

    <div class="main">
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Registrarse</h2>
                        <form action="ValidarLoginCliente" method="POST">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="txtnombre" placeholder="Usuario"/>
                            </div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="txtcorreo" placeholder="E-mail"/>
                            </div>
                            <div class="form-group">
                                <label for="dni"><i class="zmdi zmdi-account-box-mail"></i></label>
                                <input type="dni" name="txtdni" placeholder="DNI"/>
                            </div>
                            <div class="form-group">
                                <label for="adress"><i class="zmdi zmdi-pin"></i></label>
                                <input type="adress" name="txtdireccion" placeholder="Dirección"/>
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="txtpassword" placeholder="Contraseña"/>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="accionvalidar" class="form-submit" style="font-weight: 700" value="Registrar"/>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="img/registro.jpg" alt="sing up image"></figure>
                        <a href="#" class="signup-image-link iniciar-sesion form-submit" style="text-decoration: none; font-weight: 600">Ya tengo una cuenta</a>
                    </div>
                </div>
            </div>
        </section>
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="img/iniciarsesion.jpg" alt="sing up image"></figure>
                        <a href="#" class="signup-image-link crear-cuenta form-submit" style="text-decoration: none; font-weight: 600">Crear Cuenta</a>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Iniciar Sesión</h2>
                        <form method="POST" class="register-form" action="ValidarLoginCliente">
                            <div class="form-group">
                                <label for="correo"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="email" name="txtcorreo" placeholder="E-mail"/>
                            </div>
                            <div class="form-group">
                                <label for="passcliente"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="txtpassclient"  placeholder="Contraseña"/>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="accionvalidar" class="form-submit" style="font-weight: 700" value="Ingresar"/>
                            </div>
                        </form>
                        <div class="social-login">
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </div>
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/scrolllogincliente.js"></script>
</body>
</html>
