// $(document).ready(function () {
//
//     function recalcularTotal() {
//         let total = 0;
//         $("#tabla-detalles tbody tr").each(function () {
//             const subtotal = parseFloat($(this).find("input[name='subtotal']").val()) || 0;
//             total += subtotal;
//         });
//         $("#totalPedido").text(total.toFixed(2));
//     }
//
//     // Agregar fila con select de productos
//     $("#btnAgregarProducto").click(function () {
//         const lista = $("#listaProductos").clone().removeClass("d-none").attr("name", "productoId");
//         const fila = `
//             <tr>
//                 <td></td>
//                 <td><input type="number" name="cantidad" value="1" min="1" class="form-control"/></td>
//                 <td><input type="number" name="precioUnitario" step="0.01" class="form-control" readonly/></td>
//                 <td><input type="number" name="subtotal" step="0.01" class="form-control" readonly/></td>
//                 <td><button type="button" class="btn btn-sm btn-danger btn-eliminar">Eliminar</button></td>
//             </tr>`;
//         $("#tabla-detalles tbody").append(fila);
//
//         const nuevaFila = $("#tabla-detalles tbody tr:last");
//         nuevaFila.find("td:first").append(lista);
//
//         // Al cambiar de producto, actualizar precio
//         lista.on("change", function () {
//             const precio = parseFloat($(this).find("option:selected").data("precio"));
//             nuevaFila.find("input[name='precioUnitario']").val(precio.toFixed(2));
//             const cantidad = parseInt(nuevaFila.find("input[name='cantidad']").val());
//             nuevaFila.find("input[name='subtotal']").val((precio * cantidad).toFixed(2));
//             recalcularTotal();
//         });
//
//         nuevaFila.find("input[name='cantidad']").on("input", function () {
//             const cantidad = parseInt($(this).val());
//             const precio = parseFloat(nuevaFila.find("input[name='precioUnitario']").val());
//             nuevaFila.find("input[name='subtotal']").val((cantidad * precio).toFixed(2));
//             // recalcularTotal();
//         });
//
//         nuevaFila.find(".btn-eliminar").click(function () {
//             nuevaFila.remove();
//             recalcularTotal();
//         });
//     });
//
// });
