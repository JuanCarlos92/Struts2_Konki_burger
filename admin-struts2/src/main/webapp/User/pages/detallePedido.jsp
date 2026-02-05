<%--<%@ page contentType="text/html; charset=UTF-8" %>--%>
<%--<%@ taglib prefix="s" uri="/struts-tags" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="es">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Detalle del Pedido</title>--%>
<%--    <link rel="stylesheet" type="text/css" href="../css/page.css">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>--%>
<%--    <script src="../js/detallePedido.js" defer></script>--%>
<%--</head>--%>
<%--<body class="bg-primary-subtle">--%>
<%--<div class="container-fluid">--%>
<%--    <div class="row">--%>
<%--        <s:include value="/User/components/menu-lateral.jsp"/>--%>
<%--        <div class="col-8 col-md-9 col-lg-10 contenido">--%>
<%--            <s:include value="/User/components/header.jsp"/>--%>

<%--            <div class="container-fluid bg-white mt-3 py-3 px-3">--%>
<%--                <h3 class="h3 my-3">Crear Pedido</h3>--%>

<%--                <form id="formPedido" action="Pedidos" method="post">--%>
<%--                    <input type="hidden" name="accion" value="guardar"/>--%>

<%--                    <div class="row mb-3">--%>
<%--                        <div class="col-md-4">--%>
<%--                            <label for="email">Email del Cliente</label>--%>
<%--                            <input type="email" class="form-control" id="email" name="email"--%>
<%--                                   value="<s:property value='pedido.email'/>" required>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-4">--%>
<%--                            <label for="metodoPago">Metodo de Pago</label>--%>
<%--                            <select class="form-control" id="metodoPago" name="metodoPago" required>--%>
<%--                                <option value="tarjeta">Tarjeta</option>--%>
<%--                                <option value="efectivo">Efectivo</option>--%>
<%--                            </select>--%>
<%--                        </div>--%>
<%--                        <div class="col-md-4">--%>
<%--                            <label for="horaRecogida">Hora de Recogida</label>--%>
<%--                            <input type="time" class="form-control" id="horaRecogida" name="horaRecogida">--%>
<%--                        </div>--%>
<%--                    </div>--%>

<%--                    <h5>Productos del Pedido</h5>--%>
<%--                    <button type="button" class="btn btn-success mb-3" id="btnAgregarProducto">Agregar Producto</button>--%>

<%--                    <table class="table table-striped" id="tabla-detalles">--%>
<%--                        <thead>--%>
<%--                        <tr>--%>
<%--                            <th>Producto</th>--%>
<%--                            <th>Cantidad</th>--%>
<%--                            <th>Precio Unitario (€)</th>--%>
<%--                            <th>Subtotal (€)</th>--%>
<%--                            <th>Acciones</th>--%>
<%--                        </tr>--%>
<%--                        </thead>--%>
<%--                        <tbody></tbody>--%>
<%--                    </table>--%>

<%--                    <div class="d-flex justify-content-end mt-3">--%>
<%--                        <h5>Total: <span id="totalPedido">0.00</span> €</h5>--%>
<%--                    </div>--%>

<%--                    <div class="mt-3">--%>
<%--                        <button type="submit" class="btn btn-primary">Guardar Pedido</button>--%>
<%--                        <a href="Pedidos" class="btn btn-secondary">Volver</a>--%>
<%--                    </div>--%>
<%--                </form>--%>

<%--                <!-- Lista de productos disponibles (para JS) -->--%>
<%--                <select id="listaProductos" class="d-none">--%>
<%--                    <s:iterator value="productos" var="p">--%>
<%--                        <option value="<s:property value='#p.id'/>" data-precio="<s:property value='#p.precio'/>">--%>
<%--                            <s:property value="#p.nombre"/>--%>
<%--                        </option>--%>
<%--                    </s:iterator>--%>
<%--                </select>--%>

<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>
<%--<s:include value="/includes/scripts.jsp"/>--%>
<%--</body>--%>
<%--</html>--%>
