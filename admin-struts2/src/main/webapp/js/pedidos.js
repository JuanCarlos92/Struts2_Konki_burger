$(document).ready(function () {

    function cargarPedidos() {
        fetch("Pedidos")
            .then(res => res.text())
            .then(html => {
                const parser = new DOMParser();
                const doc = parser.parseFromString(html, "text/html");
                const nuevaTabla = doc.querySelector("#tabla-pedidos").innerHTML;
                $("#tabla-pedidos").html(nuevaTabla);
                checkEventos();
            })
            .catch(err => console.error("Error al recargar pedidos:", err));
    }

    cargarPedidos();
    setInterval(cargarPedidos, 5000);

    // ===== CREAR PEDIDO =====
    // $("#btnCrearPedido").click(function () {
    //     Swal.fire({
    //         title: "Crear nuevo pedido",
    //         html: `
    //     <input type="email" id="email" class="swal2-input" placeholder="Email del cliente">
    //     <input type="text" id="metodoPago" class="swal2-input" placeholder="Método de Pago">
    //     <input type="date" id="fecha" class="swal2-input" placeholder="Fecha">
    //     <input type="time" id="horaRecogida" class="swal2-input" placeholder="Hora Recogida">
    // `,
    //         focusConfirm: false,
    //         showCancelButton: true,
    //         preConfirm: () => {
    //             return {
    //                 email: document.getElementById("email").value,
    //                 metodoPago: document.getElementById("metodoPago").value,
    //                 fecha: document.getElementById("fecha").value,
    //                 horaRecogida: document.getElementById("horaRecogida").value
    //             };
    //         },
    //         confirmButtonText: "Crear Pedido"
    //     }).then(result => {
    //         if(result.isConfirmed) {
    //             const data = result.value;
    //             const params = new URLSearchParams(data).toString();
    //             window.location.href = `PedidoDetalle?accion=crear&${params}`;
    //         }
    //     });
    //
    // });

    // ===== CHECKBOXES =====
    function checkEventos() {
        $(".check-pedido").off("change").on("change", function () {
            const checked = $(".check-pedido:checked").length;
            if (checked > 0) {
                $("#btnCompletar").prop("disabled", false).removeClass("btn-secondary").addClass("btn-success");
                $("#btnCancelar").prop("disabled", false).removeClass("btn-secondary").addClass("btn-danger");
            } else {
                $("#btnCompletar").prop("disabled", true).removeClass("btn-success").addClass("btn-secondary");
                $("#btnCancelar").prop("disabled", true).removeClass("btn-danger").addClass("btn-secondary");
            }
        });
    }
    checkEventos();
});
