$(document).ready(function () {
    const $seccionCrear = $('#seccionCrear');
    const $seccionModificar = $('#seccionModificar');
    const $btnCrear = $('#btnCrear');
    const $btnModificar = $('#btnModificar');
    const $btnEliminar = $('#btnEliminar');

    let categoriaSeleccionada = null;

    function mostrar($seccion) {
        $('#seccionCrear, #seccionModificar').addClass('d-none');
        if ($seccion) $seccion.removeClass('d-none');
    }

    function validarCampo($campo, mensaje) {
        const valor = $campo.val();
        if (!valor || valor.trim() === '') {
            Swal.fire({title: "¡Error!", text: mensaje, icon: "error"});
            return false;
        }
        return true;
    }

    // ===== CHECK DE CATEGORÍAS =====
    $(document).on('change', '.check-categoria', function () {
        $('.check-categoria').not(this).prop('checked', false);
        if ($(this).is(':checked')) {
            categoriaSeleccionada = {
                id: $(this).data('id'),
                nombre: $(this).data('nombre'),
            };
            $btnModificar.removeClass('btn-secondary').addClass('btn-warning').prop('disabled', false);
            $btnEliminar.removeClass('btn-secondary').addClass('btn-danger').prop('disabled', false);
        } else {
            categoriaSeleccionada = null;
            $btnModificar.removeClass('btn-warning').addClass('btn-secondary').prop('disabled', true);
            $btnEliminar.removeClass('btn-danger').addClass('btn-secondary').prop('disabled', true);
        }
    });

    // ===== CREAR =====
    $btnCrear.click(() => mostrar($seccionCrear));
    $('#cerrarCrear').click(() => mostrar(null));

    $('#formCrear').on('submit', function (e) {
        e.preventDefault();
        const $form = $(this);
        if (!validarCampo($form.find('#nombreCrear'), "El nombre es obligatorio")) return;
        this.submit();
    });

    // ===== MODIFICAR =====
    $btnModificar.click(() => {
        if (!categoriaSeleccionada) return;
        $('#idModificar').val(categoriaSeleccionada.id);
        $('#nombreModificar').val(categoriaSeleccionada.nombre);
        mostrar($seccionModificar);
    });
    $('#cerrarModificar').click(() => mostrar(null));

    $('#formModificar').on('submit', function (e) {
        e.preventDefault();
        const $form = $(this);
        if (!validarCampo($form.find('#idModificar'), "El ID no es válido")) return;
        if (!validarCampo($form.find('#nombreModificar'), "El nombre es obligatorio")) return;
        Swal.fire({title: "¡Éxito!", text: "Categoría modificada", icon: "success"})
            .then(() => this.submit());
    });

    // ===== ELIMINAR =====
    $btnEliminar.click(() => {
        if (!categoriaSeleccionada) return;
        Swal.fire({
            title: "¿Estás seguro?",
            text: "No podrás recuperar la categoría eliminada",
            icon: "warning",
            showCancelButton: true,
            confirmButtonText: "Sí, eliminar",
            cancelButtonText: "Cancelar"
        }).then((result) => {
            if (result.isConfirmed) {
                $('<form>', {method: 'post', action: 'Categoria'})
                    .append($('<input>', {type: 'hidden', name: 'accion', value: 'eliminar'}))
                    .append($('<input>', {type: 'hidden', name: 'id', value: categoriaSeleccionada.id}))
                    .appendTo('body').submit();
            }
        });
    });
});
