<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="ISO-8859-1">
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <!-- Estilos personalizados -->
    <link rel="stylesheet" type="text/css" href="../css/login.css">
    <script src="../js/login.js" defer></script>
</head>
<body class="bg-primary-subtle">
<div class="login-box">
    <div class="container">
        <div class="row d-flex align-items-center justify-content-center bg-primary text-light py-3">
            <div class="col-auto">
                <svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="currentColor"
                     class="bi bi-person-bounding-box" viewBox="0 0 16 16">
                    <path
                            d="M1.5 1a.5.5 0 0 0-.5.5v3a.5.5 0 0 1-1 0v-3A1.5 1.5 0 0 1 1.5 0h3a.5.5 0 0 1 0 1zM11 .5a.5.5 0 0 1 .5-.5h3A1.5 1.5 0 0 1 16 1.5v3a.5.5 0 0 1-1 0v-3a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 1-.5-.5M.5 11a.5.5 0 0 1 .5.5v3a.5.5 0 0 0 .5.5h3a.5.5 0 0 1 0 1h-3A1.5 1.5 0 0 1 0 14.5v-3a.5.5 0 0 1 .5-.5m15 0a.5.5 0 0 1 .5.5v3a1.5 1.5 0 0 1-1.5 1.5h-3a.5.5 0 0 1 0-1h3a.5.5 0 0 0 .5-.5v-3a.5.5 0 0 1 .5-.5" />
                    <path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm8-9a3 3 0 1 1-6 0 3 3 0 0 1 6 0" />
                </svg>
            </div>
            <div class="col-auto">
                <h1>Login</h1>
            </div>
        </div>

        <div class="row bg-white py-4">
            <!-- formulario -->
            <form action="Login" method="post" id="formularioLogin">
                <input type="hidden" name="accion" value="iniciarSesion" id="accion">
                <div class="col-12 d-flex flex-column">
                    <!-- input username -->
                    <div class="input-group pb-2">
                        <input type="text" name="username" id="username"
                               class="form-control border-top-0 border-end-0 border-start-0 rounded-0 border-2"
                               placeholder="Username" autofocus/>
                        <div class="input-group-append">
									<span
                                            class="input-group-text border-top-0 border-end-0 border-start-0 rounded-0 border-2">
										<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32"
                                             fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
											<path
                                                    d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6" />
										</svg>
									</span>
                        </div>
                    </div>
                    <!-- inuput password -->
                    <div class="input-group pb-2">
                        <input type="password" name="password" id="password"
                               class="form-control border-top-0 border-end-0 border-start-0 rounded-0 border-2"
                               placeholder="Password" />
                        <div class="input-group-append">
									<span
                                            class="input-group-text border-top-0 border-end-0 border-start-0 rounded-0 border-2">
										<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32"
                                             fill="currentColor" class="bi bi-lock-fill" viewBox="0 0 16 16">
											<path
                                                    d="M8 1a2 2 0 0 1 2 2v4H6V3a2 2 0 0 1 2-2m3 6V3a3 3 0 0 0-6 0v4a2 2 0 0 0-2 2v5a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2" />
										</svg>
									</span>
                        </div>
                    </div>
                    <a href="#" class="text-primary align-self-end pb-4">I forgot my password</a>
                    <input id="enviar" type="submit" name="enviar" value="Submit &#10132;" class="btn btn-primary rounded-5" />
                </div>
            </form>
            <input type="hidden" id="loginError" value="<s:property value="#request.loginError"/>"/>
        </div>

        <div class="row bg-white">
            <div class="col-12">
                <p class="text-center m-0 text-muted">Konki Burger &#169; 2025</p>
            </div>
            <div class="col-12">
                <p class="text-center mt-0 text-muted">All rights reserved</p>
            </div>
        </div>
    </div>
</div>
<input type="hidden" name="errorMessage" id="errorMessage" value="<s:property value="#request.errorMessage"/>"/>
<s:include value="/includes/scripts.jsp"/>
</body>

</html>