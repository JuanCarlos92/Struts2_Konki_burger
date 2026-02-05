$(document).ready(function () {

    // ===== Agregar Producto =====
    $("#btnAgregarProducto").click(function () {
        Swal.fire({
            title: "Agregar Producto",
            html: `
                <input type="text" id="productoId" class="swal2-input" placeholder="ID Producto">
                <input type="number" id="cantidad" class="swal2-input" placeholder="Cantidad" min="1">
                <input type="number" id="precioUnitario" class="swal2-input" placeholder="Precio Unitario" step="0.01">
            `,
            focusConfirm: false,
            showCancelButton: true,
            preConfirm: () => {
                return {
                    productoId: document.getElementById("productoId").value,
                    cantidad: document.getElementById("cantidad").value,
                    precioUnitario: document.getElementById("precioUnitario").value
                };
            },
            confirmButtonText: "Agregar"
        }).then(result => {
            if(result.isConfirmed) {
                const data = result.value;
                const subtotal = data.cantidad * data.precioUnitario;
                $("#tabla-detalles tbody").append(`
                    <tr>
                        <td>
                            <input type="hidden" name="productoId" value="${data.productoId}"/>
                            Producto ${data.productoId}
                        </td>
                        <td><input type="number" name="cantidad" value="${data.cantidad}" min="1" required/></td>
                        <td><input type="number" name="precioUnitario" value="${data.precioUnitario}" step="0.01" required/></td>
                        <td><input type="number" name="subtotal" value="${subtotal}" step="0.01" readonly/></td>
                        <td><button type="button" class="btn btn-sm btn-danger btn-eliminar">Eliminar</button></td>
                    </tr>
                `);
                asignarEventosFila();
            }
        });
    });

    function asignarEventosFila() {
        $(".btn-eliminar").off("click").on("click", function () {
            $(this).closest("tr").remove();
        });

        $("input[name='cantidad'], input[name='precioUnitario']").off("input").on("input", function () {
            const fila = $(this).closest("tr");
            const cantidad = parseFloat(fila.find("input[name='cantidad']").val());
            const precio = parseFloat(fila.find("input[name='precioUnitario']").val());
            fila.find("input[name='subtotal']").val((cantidad * precio).toFixed(2));
        });
    }

    asignarEventosFila();
});
