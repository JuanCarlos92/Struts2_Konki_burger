<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inicio</title>
    <link rel="stylesheet" type="text/css" href="../css/page.css">
    <script src="../js/inicio.js" defer></script>
</head>
<body class="bg-primary-subtle">
<div class="container-fluid">
    <div class="row">
        <!--Menu lateral-->
        <s:include value="/User/components/menu-lateral.jsp"/>
        <!--Contenido-->
        <div class="col-8 col-md-9 col-lg-10 contenido">
            <!--Header-->
            <s:include value="/User/components/header.jsp"/>
            <!--Main-->
            <div class="container-fluid bg-white mt-3 py-3 px-3">
            <table id="tabla" class="display">
                    <thead>
                    <tr>
                        <th class="bg-primary text-light">Id</th>
                        <th class="bg-primary text-light">Nombre de usuario</th>
                        <th class="bg-primary text-light">Nombre completo</th>
                        <th class="bg-primary text-light">Email</th>
                        <th class="bg-primary text-light">Rol</th>
                        <th class="bg-primary text-light">Dirección</th>
                        <th class="bg-primary text-light">Fecha de registro</th>
                        <th class="bg-primary text-light">Acciones</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="usuarios" var="u">
                        <tr>
                            <td><s:property value="#u.id"/></td>
                            <td><s:property value="#u.username"/></td>
                            <td><s:property value="#u.nombre"/></td>
                            <td><s:property value="#u.email"/></td>
                            <td><s:property value="#u.rol"/></td>
                            <td><s:property value="#u.direccion"/></td>
                            <td><s:property value="#u.fechaRegistro"/></td>
                            <td>
                                <div class="d-flex gap-1">
                                    <s:form action="Inicio" method="post" style="display:inline;">
                                        <s:hidden name="accion" value="eliminarUsuario"/>
                                        <s:hidden name="idUsuario" value="%{#u.id}"/>
                                        <button class="btn btn-sm btn-danger">Eliminar</button>
                                    </s:form>

                                    <button type="button" class="btn btn-sm btn-warning btn-editar"
                                            data-id="<s:property value='#u.id'/>"
                                            data-username="<s:property value='#u.username'/>"
                                            data-nombre="<s:property value='#u.nombre'/>"
                                            data-email="<s:property value='#u.email'/>"
                                            data-rol="<s:property value='#u.rol'/>"
                                            data-direccion="<s:property value='#u.direccion'/>">
                                        Modificar
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>

                <!-- FORMULARIO MODIFICAR (oculto, mostrar con JS) -->
                <div class="col-12 d-none" id="modificarUsuarioContenedor">
                    <form action="Inicio" method="post" id="formularioModificarUsuario">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h3 class="h3 my-0">Modificar usuario</h3>
                            <button type="button" id="cerrarFormulario" class="btn btn-sm btn-secondary">Cerrar</button>
                        </div>
                        <div class="form-floating mb-2">
                            <input type="text" class="form-control" id="idModificarUsuario" name="idUsuario" placeholder="Id" readonly/>
                            <label for="idModificarUsuario">Id</label>
                        </div>
                        <div class="form-floating mb-2">
                            <input type="text" class="form-control" id="usernameModificarUsuario" name="username" placeholder="Nombre de usuario"/>
                            <label for="usernameModificarUsuario">Nombre de usuario</label>
                        </div>
                        <div class="form-floating mb-2">
                            <input type="text" class="form-control" id="nombreModificarUsuario" name="nombre" placeholder="Nombre completo"/>
                            <label for="nombreModificarUsuario">Nombre completo</label>
                        </div>
                        <div class="form-floating mb-2">
                            <input type="email" class="form-control" id="emailModificarUsuario" name="email" placeholder="Email"/>
                            <label for="emailModificarUsuario">Email</label>
                        </div>
                        <div class="form-floating mb-2">
                            <input type="text" class="form-control" id="rolModificarUsuario" name="rol" placeholder="Rol"/>
                            <label for="rolModificarUsuario">Rol</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="direccionModificarUsuario" name="direccion" placeholder="Dirección"/>
                            <label for="direccionModificarUsuario">Dirección</label>
                        </div>
                        <input type="hidden" name="accion" value="modificarUsuario"/>
                        <input type="submit" class="btn btn-primary mb-4" value="Guardar cambios"/>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>
<s:include value="/includes/scripts.jsp"/>
</body>
</html>
