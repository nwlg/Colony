var vActual;
var urlContenido;
var offline;

var menu;
var contenido;

function inicializar()
{
	if (document.all)
	{
		menu = document.all.tags("frame")[0].contentWindow.document;
		contenido = document.all.tags('frame')[1].contentWindow.document.getElementById("contenido_externo");
	}
	else if (document.getElementsByTagName)
	{
		menu =  document.getElementsByTagName('frame')[0].contentDocument;
		contenido =  document.getElementsByTagName('frame')[1].contentDocument.getElementById("contenido_externo");
	}
	
	vActual= menu.forms['f1'].elements['seleccion'];
   	urlContenido = menu.forms['f1'].elements['urlContenido'].value;
	offline = menu.forms['f1'].elements['offline'].value;
	
   	menu.getElementById('seleccion').className = 'escogido';
   	
   	var idSeleccionado=vActual.value;
   	if(idSeleccionado!='' && idSeleccionado!=null && menu.getElementById(idSeleccionado)!=null)
	   	menu.getElementById(idSeleccionado).className = 'escogido';
   	

   	mostrarItem(urlContenido,idSeleccionado,offline );

}
function tipoDocumento(href){
		tipoDoc="";
		
		if(href==null || href=="")
			tipoDoc = "default";
		else{
			var i = href.lastIndexOf(".");
			var extension=href.substring(i,href.length);
			extension = extension.toLowerCase();
			if(	extension==".doc" || extension==".ppt" || extension==".pps" || extension==".xls" ||
				extension==".odt" || extension==".odp" || extension==".ods" ||
				extension==".sxw" || extension==".sxi" || extension==".sxc" ||
				extension==".pdf" || extension==".rtf" || extension==".txt" ||
				extension==".csv")
				tipoDoc="viewer";
			else 
				tipoDoc="default";
   		}
}

function cambiar(id){
	if(id!=vActual.value){
		if (vActual.value != 'seleccion'){
			var aux=vActual.value;
          	
          	if(menu.getElementById(aux)!=null)
          		menu.getElementById(aux).className = '';
      	} 
      	else{
         	menu.getElementById('seleccion').className = '';
      	}
   	  	menu.getElementById(id).className = 'escogido';
   	 	vActual.value=id;
   	}
}

function abrirCerrar(item,abierto,cerrado)
{
	var elemento =	menu.getElementById(item)

	if(elemento.className == cerrado){
		elemento.className=abierto;
	}
	else if(elemento.className == abierto){
		elemento.className = cerrado;
	}
}

function mostrarItem(href, id ,offline)
{

	if(href !='' && href!=null && id!='' && id!=null){
	  	//marcamos el item que vamos a mostrar
	   	if(menu.getElementById(id)!=null)//si es null estamos en secuencia y no tenemos ids la seleccion se ha hecho en el tag
			cambiar(id);
		
		if((href ==null) || (href=="") || (href.charAt(href.length-1)=='#')){
			if(contenido!=null)
				contenido.innerHTML="";
		}
		else{
		
			//obtenemos el tipo documento
			tipoDocumento(href);
			cadenaIframe="<IFRAME id='frameContenido' name='frameContenido' onload='redimensionarContenido();' ";
			if(tipoDoc =='viewer' && offline == 'false'){
				cadenaIframe = "<p>If you cannot see the document click <a href='"+ href +"' target='frameContenido'>here</a></p>" + cadenaIframe;
				cadenaIframe= cadenaIframe + " src='http://viewer.zoho.com/api/view.do?url="+ href +"&apikey=250db5bba77aaabd5736536d9c6851ea&embed=true' ";
			}else{
				cadenaIframe= cadenaIframe + " src='"+ href +"'";
			}

			cadenaIframe= cadenaIframe + "scrolling='auto'  frameborder='0' marginheight='0' marginwidth='0' style=' height:100; width=100; '>[Su agente de usuario no soporta marcos o está actualmente configurado para no mostrar marcos. Sin embargo, puede visitar <A href='"+ href +"'>Documento relacionado.</A>]</IFRAME>";
			if(contenido!=null)
					contenido.innerHTML=cadenaIframe ;

		}
	}else{
		if(id!='' && id!=null ){
			if(menu.getElementById(id)!=null)//si es null estamos en secuencia y no tenemos ids  a seleccion se ha hecho en el tag
				cambiar(id);
		}
		if ((href ==null) || (href=="") || (href.charAt(href.length-1)=='#')){
			if(contenido!=null)
				contenido.innerHTML="";
		}
		
	}
}

