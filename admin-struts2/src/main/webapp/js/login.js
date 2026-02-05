$(document).ready(function() {
    // Validación de campos antes de enviar
    $('#formularioLogin').on('submit', function(event){
        event.preventDefault(); // detenemos el submit por defecto

        let usuario = $('#username').val();
        let password = $('#password').val();

        if(usuario && password){
            this.submit(); // enviamos si hay datos
        } else {
            Swal.fire({
                title: "Error!",
                text: "Por favor, rellene todos los campos",
                icon: "error"
            });
        }
    });

    // Mostrar error de login del servidor
    let mensajeError = $('#errorMessage').val();
    if(mensajeError && mensajeError.trim() !== ""){
        Swal.fire({
            title: "Error de Login",
            text: mensajeError,
            icon: "error"
        });
    }
});
