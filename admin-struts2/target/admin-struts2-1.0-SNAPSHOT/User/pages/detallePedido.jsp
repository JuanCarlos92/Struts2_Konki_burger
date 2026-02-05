<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Detalle de Pedido</title>
    <link rel="stylesheet" type="text/css" href="../css/page.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="../js/detallePedido.js" defer></script>
</head>
<body class="bg-primary-subtle">
<div class="container-fluid">
    <div class="row">
        <s:include value="/User/components/menu-lateral.jsp"/>
        <div class="col-8 col-md-9 col-lg-10 contenido">
            <s:include value="/User/components/header.jsp"/>

            <div class="container-fluid bg-white mt-3 py-3 px-3">
                <h3 class="h3 my-3">Detalle del Pedido</h3>

                <form id="formPedido" action="PedidoDetalle" method="post">
                    <input type="hidden" name="accion" value="guardar"/>
                    <input type="hidden" name="pedidoId" value="<s:property value='pedido.id'/>"/>

                    <div class="row mb-3">
                        <div class="col-md-4">
                            <label for="email">Email del Cliente</label>
                            <input type="email" class="form-control" id="email" name="email"
                                   value="<s:property value='pedido.email'/>" required>
                        </div>
                        <div class="col-md-4">
                            <label for="metodoPago">Método de Pago</label>
                            <select class="form-control" id="metodoPago" name="metodoPago" required>
                                <option value="tarjeta" <s:if test="pedido.metodoPago == 'tarjeta'">selected</s:if>>
                                    Tarjeta
                                </option>
                                <option value="efectivo" <s:if test="pedido.metodoPago == 'efectivo'">selected</s:if>>
                                    Efectivo
                                </option>
                            </select>
                        </div>
                        <div class="col-md-4">
                            <label for="horaRecogida">Hora de Recogida</label>
                            <input type="time" class="form-control" id="horaRecogida" name="horaRecogida"
                                   value="<s:property value='pedido.horaRecogida'/>">
                        </div>
                    </div>

                    <h5>Productos del Pedido</h5>
                    <button type="button" class="btn btn-success mb-2" id="btnAgregarProducto">Agregar Producto</button>

                    <table class="table table-striped" id="tabla-detalles">
                        <thead>
                        <tr>
                            <th>Producto</th>
                            <th>Cantidad</th>
                            <th>Precio Unitario (€)</th>
                            <th>Subtotal (€)</th>
                            <th>Acciones</th>
                        </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="pedido.detalles" var="d">
                            <tr>
                                <td>
                                    <input type="hidden" name="productoId"
                                           value="<s:property value='#d.producto.id'/>"/>
                                    <s:property value="#d.producto.nombre"/>
                                </td>
                                <td><input type="number" name="cantidad" value="<s:property value='#d.cantidad'/>"
                                           min="1" required/></td>
                                <td><input type="number" name="precioUnitario"
                                           value="<s:property value='#d.precioUnitario'/>" step="0.01" required/></td>
                                <td><input type="number" name="subtotal" value="<s:property value='#d.subtotal'/>"
                                           step="0.01" readonly/></td>
                                <td>
                                    <button type="button" class="btn btn-sm btn-danger btn-eliminar">Eliminar</button>
                                </td>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>

                    <div class="mt-3">
                        <button type="submit" class="btn btn-primary">Guardar Pedido</button>
                        <a href="Pedidos" class="btn btn-secondary">Volver</a>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
<s:include value="/includes/scripts.jsp"/>
</body>
</html>
