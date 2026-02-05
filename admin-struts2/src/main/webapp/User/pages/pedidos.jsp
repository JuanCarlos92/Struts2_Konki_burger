<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Pedidos</title>
    <link rel="stylesheet" type="text/css" href="../css/page.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="../js/pedidos.js" defer></script>
</head>
<body class="bg-primary-subtle">
<div class="container-fluid">
    <div class="row">
        <s:include value="/User/components/menu-lateral.jsp"/>
        <div class="col-8 col-md-9 col-lg-10 contenido">
            <s:include value="/User/components/header.jsp"/>
            <div class="container-fluid bg-white mt-3 py-3 px-3">

                <div class="d-flex align-items-center gap-2 mt-3 mb-3">
<%--                    <button class="btn btn-success" onclick="location.href='Pedidos?accion=crear'">--%>
<%--                        Crear Pedido--%>
<%--                    </button>--%>
                    <button class="btn btn-secondary" id="btnCompletar" disabled>Completar</button>
                    <button class="btn btn-secondary" id="btnCancelar" disabled>Cancelar</button>
                </div>

                <h3 class="h3 my-3">Listado de Pedidos</h3>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th></th>
                        <th>Nº Pedido</th>
                        <th>Email</th>
                        <th>Estado</th>
                        <th>Fecha</th>
                        <th>Hora recogida</th>
                        <th>Método de pago</th>
                        <th>Total (€)</th>
                        <th>Detalle</th>
                    </tr>
                    </thead>
                    <tbody id="tabla-pedidos">
                    <s:iterator value="pedidos" var="p">
                        <tr data-id="<s:property value='#p.id'/>">
                            <td>
                                <input type="checkbox" class="check-pedido"
                                       data-id="<s:property value='#p.id'/>"
                                       data-estado="<s:property value='#p.estado'/>"/>
                            </td>
                            <td><s:property value="#p.numPedido"/></td>
                            <td><s:property value="#p.email"/></td>
                            <td><s:property value="#p.estado"/></td>
                            <td><s:property value="#p.fecha"/></td>
                            <td><s:property value="#p.horaRecogida"/></td>
                            <td><s:property value="#p.metodoPago"/></td>
                            <td><s:property value="#p.total"/></td>
                            <td>
                                <a href="PedidoDetalle?accion=listar&pedidoId=<s:property value='#p.id'/>"
                                   class="btn btn-sm btn-primary">Ver Detalle</a>
                            </td>
                            <td>
                                <ul class="mb-0">
                                    <s:iterator value="#p.detalles" var="d">
                                        <li><s:property value="#d.producto.nombre"/> (x<s:property value="#d.cantidad"/>)</li>
                                    </s:iterator>
                                </ul>
                            </td>
                            <td>
                                <a href="PedidoDetalle?accion=ver&id=<s:property value='#p.id'/>" class="btn btn-sm btn-primary">Detalle</a>
                            </td>
                        </tr>
                    </s:iterator>
                    </tbody>

                </table>

            </div>
        </div>
    </div>
</div>
<s:include value="/includes/scripts.jsp"/>
</body>
</html>
