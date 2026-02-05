
$(document).ready(function() {
    let height = $(window).height();
    $('#aside').css('height', height);
    
    // Recoger todas las opciones del menú
    let paginas = $('#aside>.row>a');
	//iteración que coloca la clase a la opción del menú según la ruta
	paginas.each(function(){
		let rutaPaginaActual = window.location.href;
		let paginaActual = rutaPaginaActual.substring(rutaPaginaActual.lastIndexOf('/')+1)
		if($(this).attr('href')===paginaActual || ($(this).attr('href')+".action")===paginaActual){
			$('.enfocado').removeClass('enfocado');
			$(this).addClass('enfocado');
		}
	});
	
	//comprobamos que pestaña está señalada y escribimos su nombre en la ruta
	//asignación del valor de la ruta
	$('#ruta').text($('.enfocado').attr('href'));
	
	$(`#cerrarSesion`).click(function(event){
		event.preventDefault();
		$('#variableCerrarSesion').val('true');
		$(this).closest('form').submit();//enviamos formulario
	});
});
