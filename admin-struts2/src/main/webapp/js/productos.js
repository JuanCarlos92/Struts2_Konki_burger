$(document).ready(function () {
    // ===== REFERENCIAS A SECCIONES =====
    const $seccionCrear = $('#seccionCrear');
    const $seccionModificar = $('#seccionModificar');
    const $btnCrear = $('#btnCrear');
    const $btnModificar = $('#btnModificar');
    const $btnEliminar = $('#btnEliminar');

    let productoSeleccionado = null; // para almacenar datos del check seleccionado

    // ===== FUNCIONES AUXILIARES =====
    function mostrar($seccion) {
        $('#seccionCrear, #seccionModificar').addClass('d-none');
        if ($seccion) $seccion.removeClass('d-none');
    }

    function validarCampo($campo, mensaje, isNumber = false) {
        const valor = $campo.val();
        if (!valor || (isNumber && (isNaN(parseFloat(valor)) || parseFloat(valor) <= 0)) || (!isNumber && valor.trim() === '')) {
            Swal.fire({title: "¡Error!", text: mensaje, icon: "error"});
            return false;
        }
        return true;
    }

    // ===== CHECK DE PRODUCTOS =====
    $(document).on('change', '.check-producto', function () {
        // Solo permitir seleccionar uno
        $('.check-producto').not(this).prop('checked', false);

        if ($(this).is(':checked')) {
            productoSeleccionado = {
                id: $(this).data('id'),
                nombre: $(this).data('nombre'),
                descripcion: $(this).data('descripcion'),
                precio: $(this).data('precio'),
                categoria: $(this).data('categoria'),
                estado: $(this).data('estado')
            };
            $btnModificar.removeClass('btn-secondary').addClass('btn-warning').prop('disabled', false);
            $btnEliminar.removeClass('btn-secondary').addClass('btn-danger').prop('disabled', false);
        } else {
            productoSeleccionado = null;
            $btnModificar.removeClass('btn-warning').addClass('btn-secondary').prop('disabled', true);
            $btnEliminar.removeClass('btn-danger').addClass('btn-secondary').prop('disabled', true);
        }
    });

    // ===== BOTÓN CREAR =====
    $btnCrear.click(() => mostrar($seccionCrear));
    $('#cerrarCrear').click(() => mostrar(null));

    // ===== BOTÓN MODIFICAR =====
    $btnModificar.click(() => {
        if (!productoSeleccionado) return;
        $('#idModificar').val(productoSeleccionado.id);
        $('#nombreModificar').val(productoSeleccionado.nombre);
        $('#descripcionModificar').val(productoSeleccionado.descripcion);
        $('#precioModificar').val(productoSeleccionado.precio);
        $('#categoriaModificar').val(productoSeleccionado.categoria);
        $('#estadoModificar').val(productoSeleccionado.estado);
        mostrar($seccionModificar);
    });
    $('#cerrarModificar').click(() => mostrar(null));

    // ===== VALIDACIÓN CREAR =====
    $('#formCrear').on('submit', function (e) {
        e.preventDefault();
        const $form = $(this);
        if (!validarCampo($form.find('#nombreCrear'), "El nombre es obligatorio")) return;
        if (!validarCampo($form.find('#descripcionCrear'), "La descripción es obligatoria")) return;
        if (!validarCampo($form.find('#precioCrear'), "El precio debe ser mayor que 0", true)) return;
        if (!validarCampo($form.find('#categoriaCrear'), "Debe seleccionar una categoría")) return;
        if (!validarCampo($form.find('#estadoCrear'), "Debe seleccionar un estado")) return;
        this.submit();
    });

    // ===== VALIDACIÓN MODIFICAR =====
    $('#formModificar').on('submit', function (e) {
        e.preventDefault();
        const $form = $(this);
        if (!validarCampo($form.find('#idModificar'), "El ID no es válido")) return;
        if (!validarCampo($form.find('#nombreModificar'), "El nombre es obligatorio")) return;
        if (!validarCampo($form.find('#descripcionModificar'), "La descripción es obligatoria")) return;
        if (!validarCampo($form.find('#precioModificar'), "El precio debe ser mayor que 0", true)) return;
        if (!validarCampo($form.find('#categoriaModificar'), "Debe seleccionar una categoría")) return;
        if (!validarCampo($form.find('#estadoModificar'), "Debe seleccionar un estado")) return;

        Swal.fire({
            title: "¡Éxito!",
            text: "Producto modificado correctamente",
            icon: "success"
        }).then((result) => {
            if (result.isConfirmed) this.submit();
        });
    });

    // ===== ELIMINAR =====
    $btnEliminar.click(() => {
        if (!productoSeleccionado) return;
        Swal.fire({
            title: "¿Estás seguro?",
            text: "No podrás recuperar el producto una vez eliminado",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "¡Sí!, bórralo",
            cancelButtonText: "Cancelar"
        }).then((result) => {
            if (result.isConfirmed) {
                // Creamos un form dinámico para enviar la petición POST
                $('<form>', {
                    method: 'post',
                    action: 'Producto'
                }).append($('<input>', {
                    type: 'hidden',
                    name: 'accion',
                    value: 'eliminar'
                })).append($('<input>', {
                    type: 'hidden',
                    name: 'id',
                    value: productoSeleccionado.id
                })).appendTo('body').submit();
            }
        });
    });
});
