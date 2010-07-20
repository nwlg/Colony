
//Se marca el dominio de la pagina para permitir
//la comunicacion entre Iframes

function setAppDomain(){
	try{
		document.domain="npa.com";
		}
	catch(e){
	  //No se hace nada
	  //El catch permite que pueda funcionar desde o fuera del escritorio
	  //Solo se puede cambiar el document.domain cuando este sea parte de nombre del servidor
	  //cuando no lo sea se produce un error "Argumento no v?lido."
	}
}
