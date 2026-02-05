<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Hamburguesas</title>
    <link rel="stylesheet" type="text/css" href="../css/page.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="../js/productos.js" defer></script>
</head>
<body class="bg-primary-subtle">
<div class="container-fluid">
    <div class="row">
        <!-- Menú lateral -->
        <s:include value="/User/components/menu-lateral.jsp"/>
        <!-- Contenido principal -->
        <div class="col-8 col-md-9 col-lg-10 contenido">
            <!--Header-->
            <s:include value="/User/components/header.jsp"/>
            <!--Main-->
            <div class="container-fluid bg-white mt-3 py-3 px-3">
                <!-- BARRA SUPERIOR DE BOTONES -->
                <div class="d-flex align-items-center gap-2 mt-3 mb-3">
                    <button class="btn btn-outline-primary" id="btnCrear">Crear Hamburguesa</button>
                    <a href="Categorias" class="btn btn-outline-primary">Categorías</a>
                    <button class="btn btn-secondary" id="btnModificar" disabled>Modificar</button>
                    <button class="btn btn-secondary" id="btnEliminar" disabled>Eliminar</button>
                </div>

                <!-- LISTADO DE PRODUCTOS -->
                <h3 class="h3 my-3">Listado de Hamburguesas</h3>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th></th>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Precio (€)</th>
                        <th>Categoría</th>
                        <th>Disponibilidad</th>
                    </tr>
                    </thead>
                    <tbody>
                    <s:iterator value="productos" var="p">
                        <tr>
                            <td>
                                <input type="checkbox" class="check-producto"
                                       data-id="<s:property value='#p.id'/>"
                                       data-nombre="<s:property value='#p.nombre'/>"
                                       data-descripcion="<s:property value='#p.descripcion'/>"
                                       data-precio="<s:property value='#p.precio'/>"
                                       data-categoria="<s:property value='#p.categoriaId'/>"
                                       data-estado="<s:property value='#p.estado'/>"/>
                            </td>
                            <td><s:property value="#p.id"/></td>
                            <td><s:property value="#p.nombre"/></td>
                            <td><s:property value="#p.descripcion"/></td>
                            <td><s:property value="#p.precio"/></td>
                            <td><s:property value="#p.categoriaNombre"/></td>
                            <td><s:property value="#p.estado"/></td>
                        </tr>
                    </s:iterator>
                    </tbody>
                </table>

                <!-- FORMULARIO CREAR (oculto) -->
                <div id="seccionCrear" class="d-none">
                    <h3 class="h3 mb-4">Nueva Hamburguesa</h3>
                    <form action="Productos" method="post" id="formCrear">
                        <input type="hidden" name="accion" value="crear"/>

                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="nombreCrear" name="nombre"/>
                            <label for="nombreCrear">Nombre</label>
                        </div>

                        <div class="form-floating mb-3">
                            <textarea class="form-control" id="descripcionCrear" name="descripcion"></textarea>
                            <label for="descripcionCrear">Descripción</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="number" step="0.01" class="form-control" id="precioCrear" name="precio"/>
                            <label for="precioCrear">Precio (€)</label>
                        </div>

                        <div class="form-floating mb-3">
                            <s:select id="categoriaCrear" list="categorias" name="categoriaId" listKey="id"
                                      listValue="nombre" cssClass="form-select"/>
                            <label for="categoriaCrear">Categoría</label>
                        </div>

                        <div class="form-floating mb-3">
                            <select class="form-select" id="estadoCrear" name="estado">
                                <option value="Disponible">Disponible</option>
                                <option value="No disponible">No disponible</option>
                            </select>
                            <label for="estadoCrear">Disponibilidad</label>
                        </div>

                        <button class="btn btn-outline-primary mb-3">Crear</button>
                        <button type="button" class="btn btn-secondary mb-3" id="cerrarCrear">Cancelar</button>
                    </form>
                </div>

                <!-- FORMULARIO MODIFICAR (oculto) -->
                <div id="seccionModificar" class="d-none">
                    <h3 class="h3 my-3">Modificar Hamburguesa</h3>
                    <form action="Productos" method="post" id="formModificar">
                        <input type="hidden" name="accion" value="modificar"/>

                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="idModificar" name="id" readonly/>
                            <label for="idModificar">Id</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="nombreModificar" name="nombre"/>
                            <label for="nombreModificar">Nombre</label>
                        </div>

                        <div class="form-floating mb-3">
                            <textarea class="form-control" id="descripcionModificar" name="descripcion"></textarea>
                            <label for="descripcionModificar">Descripción</label>
                        </div>

                        <div class="form-floating mb-3">
                            <input type="number" step="0.01" class="form-control" id="precioModificar" name="precio"/>
                            <label for="precioModificar">Precio (€)</label>
                        </div>

                        <div class="form-floating mb-3">
                            <s:select id="categoriaModificar" list="categorias" name="categoriaId" listKey="id"
                                      listValue="nombre" cssClass="form-select"/>
                            <label for="categoriaModificar">Categoría</label>
                        </div>

                        <div class="form-floating mb-3">
                            <select class="form-select" id="estadoModificar" name="estado">
                                <option value="Disponible">Disponible</option>
                                <option value="No disponible">No disponible</option>
                            </select>
                            <label for="estadoModificar">Disponibilidad</label>
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
