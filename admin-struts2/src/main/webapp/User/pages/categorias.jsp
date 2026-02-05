<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestión de Categorías</title>
    <link rel="stylesheet" type="text/css" href="../css/page.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="../js/categorias.js" defer></script>
</head>
<body class="bg-primary-subtle">
<div class="container-fluid">
    <div class="row">
        <s:include value="/User/components/menu-lateral.jsp"/>
        <div class="col-8 col-md-9 col-lg-10 contenido">
            <s:include value="/User/components/header.jsp"/>

            <div class="row bg-white mt-3 ms-2">

                <!-- Barra superior -->
                <div class="d-flex align-items-center gap-2 mt-3 mb-3">
                    <button class="btn btn-outline-primary" id="btnCrear">Crear Categoría</button>
                    <button class="btn btn-outline-primary" id="btnModificar" disabled>Modificar</button>
                    <button class="btn btn-secondary" id="btnEliminar" disabled>Eliminar</button>
                </div>

                <!-- LISTADO DE CATEGORÍAS -->
                <h3 class="h3 my-3">Listado de Categorías</h3>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th></th>
                        <th>Id</th>
                        <th>Nombre</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="categorias" var="c">
                        <tr>
                            <td>
                                <input type="checkbox" class="check-categoria"
                                       data-id="<s:property value='#c.id'/>"
                                       data-nombre="<s:property value='#c.nombre'/>"/>
                            </td>
                            <td><s:property value="#c.id"/></td>
                            <td><s:property value="#c.nombre"/></td>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>

                <!-- FORM CREAR -->
                <div id="seccionCrear" class="d-none">
                    <h3 class="h3 mb-4">Nueva Categoría</h3>
                    <form action="Categorias" method="post" id="formCrear">
                        <input type="hidden" name="accion" value="crear"/>

                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="nombreCrear" name="nombre"/>
                            <label for="nombreCrear">Nombre</label>
                        </div>

                        <button class="btn btn-outline-primary mb-3">Crear</button>
                        <button type="button" class="btn btn-secondary mb-3" id="cerrarCrear">Cancelar</button>
                    </form>
                </div>

                <!-- FORM MODIFICAR -->
                <div id="seccionModificar" class="d-none">
                    <h3 class="h3 my-3">Modificar Categoría</h3>
                    <form action="Categorias" method="post" id="formModificar">
                        <input type="hidden" name="accion" value="modificar"/>

                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="idModificar" name="id" readonly/>
                            <label for="idModificar">Id</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="nombreModificar" name="nombre"/>
                            <label for="nombreModificar">Nombre</label>
                        </div>

                        <button class="btn btn-outline-primary mb-3">Guardar cambios</button>
                        <button type="button" class="btn btn-secondary mb-3" id="cerrarModificar">Cancelar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<s:include value="/includes/scripts.jsp"/>
</body>
</html>
