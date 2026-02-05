$(document).ready(function () {
    // Inicializar DataTable sobre la tabla que ya tiene los datos
    $('#tabla').DataTable({
        pageLength: 5,
        lengthChange: false,
        language: {
            "decimal": ",",
            "thousands": ".",
            "lengthMenu": "Mostrar _MENU_ registros",
            "zeroRecords": "No se encontraron resultados",
            "info": "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
            "infoEmpty": "Mostrando registros del 0 al 0 de un total de 0 registros",
            "infoFiltered": "(filtrado de un total de _MAX_ registros)",
            "sSearch": "Buscar:",
            "sProcessing": "Cargando..."
        }
    });

    // MODIFICAR
    $('.btn-editar').on('click', function() {
        $('#modificarUsuarioContenedor').removeClass('d-none').addClass('d-block');
        $('#idModificarUsuario').val($(this).data('id'));
        $('#usernameModificarUsuario').val($(this).data('username'));
        $('#nombreModificarUsuario').val($(this).data('nombre'));
        $('#emailModificarUsuario').val($(this).data('email'));
        $('#rolModificarUsuario').val($(this).data('rol'));
        $('#direccionModificarUsuario').val($(this).data('direccion'));
    });

    $('#formularioModificarUsuario').on('submit', function(event){
        let camposValidos = $('#idModificarUsuario').val().length > 0 &&
            $('#usernameModificarUsuario').val().length > 0 &&
            $('#nombreModificarUsuario').val().length > 0 &&
            $('#emailModificarUsuario').val().length > 0 &&
            $('#rolModificarUsuario').val().length > 0 &&
            $('#direccionModificarUsuario').val().length > 0;
        if(!camposValidos){
            event.preventDefault();
            Swal.fire({
                title: "¡Error!",
                text: "Por favor, rellena todos los campos.",
                icon: "error"
            });
        }
    });

    // Cerrar formulario de modificar
    $('#cerrarFormulario').on('click', function() {
        $('#modificarUsuarioContenedor').removeClass('d-block').addClass('d-none');
    })

    // ELIMINAR
    $('.btn-danger').on('click', function(event){
        event.preventDefault();
        var form = $(this).closest('form');
        Swal.fire({
            title: "¿Estás seguro?",
            text: "No podrás recuperar el usuario una vez eliminado",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "¡Sí!, ¡bórralo!",
            cancelButtonText: "¡No!, ¡Cancélalo!"
        }).then((result) => {
            if (result.isConfirmed) {
                form.submit();
            }
        });
    });
});
