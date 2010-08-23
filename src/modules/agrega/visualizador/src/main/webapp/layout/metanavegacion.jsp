<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">

<head lang="es" dir="ltr">



<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tlds/rewriteTag.tld" prefix="rewrite" %> 
<%@ taglib uri="/WEB-INF/tlds/tags-visualizador.tld" prefix="link" %>


<title><bean:message key="title.Comun"/></title>

	<link type="text/css" rel="stylesheet" media="screen" href="<rewrite:rewrite url='static/css/red.css'/>"/>
	<script type="text/javascript" src="<rewrite:rewrite url='static/js/plantilla.js'/>"></script>
	<script type="text/javascript" src="<rewrite:rewrite url='static/js/plantilla_capa_slide.js'/>"></script>
	<script type="text/javascript" src="<rewrite:rewrite url='static/js/jquery.clipboard.js'/>"></script>
	<script type="text/javascript" src="<rewrite:rewrite url='static/js/jquery.clipboard.pack.js'/>"></script>
	<style>body {height:10px;}</style>
	<link href="" id="aepref-keyboardnav.enabled"  />

<script type="text/javascript">
//<![CDATA[

$(document).ready(function(){ //Inicializacion
		$('#ci_form').hide();
		$('#ci_ok').hide();
		$('#ci_error').hide();
		$('#tagg_form').hide();
		$('#tagg_ok').hide();
		$('#tagg_form_error').hide();
        return false; 
});

$(document).ready(function(){ //desplegar o contraer contenido inapropiado
    $("[name='ContenidoInapropiado']").click(function(){ 
        if($("#panelwrapper").css("top") != "0px")
        {
			$("input#comentario").val("");
			$("input#comentario").focus();
	        $('#ci_form').show();
			$('#ci_ok').hide();
			$('#ci_error').hide();
		}

        var targetX = $("#panelwrapper").css("top") == "0px"? '-106px': '0'; 
        $("#panelwrapper").animate({"top": targetX, "opacity": 0.9}, { duration: "slow" }); 
       
        return false; 
    }); 
});

$(document).ready(function(){ //contenido inapropiado Volver
    $("[name='ci_botonVolver']").click(function(){ 
		$("input#comentario").val("");
		$("input#comentario").focus();
		$('#ci_form').show();
		$('#ci_ok').hide();
		$('#ci_error').hide();
        return false; 
    }); 
});


$(document).ready(function(){ //contenido inapropiado

	$("[name='enviar_CI']").click(function() {
			var comentario = $("input#comentario").val();
			if (comentario == "") {
			      $("input#comentario").focus();
			        $('#ci_form').hide();
					$('#ci_ok').hide();
					$('div#comentario_error').show();
					$('div#servidor_error').hide();					
					$('#ci_error').show();
			      return false;
		    }

			var dataString = 'comentario='+ comentario ;
			$.ajax({
			      type: "POST",
			      url: "<html:rewrite action='/ContenidoInapropiado/ContenidoInapropiado'/>",
			      data: dataString,
			      error: function(){
        				$('#ci_form').hide();
        				$('#ci_ok').hide();
						$('div#comentario_error').hide();
						$('div#servidor_error').show();
        				$('#ci_error').show();
    				},
			      success: function() {
        				$('#ci_form').hide();
        				$('#ci_ok').show();
        				$('#ci_error').hide();
						$('input#comentario').val("");
				      }
	     });
	    return false;
	});
}); 




$(document).ready(function(){ // contenido embebido 
    $("[name='ContenidoEmbebido']").click(function(){ 
        var targetX = $("#panelwrapper2").css("top") == "0px"? '-106px': '0'; 
        $("#panelwrapper2").animate({"top": targetX, "opacity": 0.9}, { duration: "slow" }); 
        return false; 
    }); 
});


$(document).ready(function(){ //tagging
    $("[name='Tagging']").click(function(){ 
    
        if($("#panelwrapper3").css("top") != "0px")
        {
	        $('input#tags').val("");
	        $('input#tags').focus();
	        $('#tagg_form').show();
			$('#tagg_ok').hide();
			$('#tagg_error').hide();
			$('div#tagg_val_error').hide();
			$('div#tagg_servidor_error').hide();	
		}
    
        var targetX = $("#panelwrapper3").css("top") == "0px"? '-106px': '0'; 
        $("#panelwrapper3").animate({"top": targetX, "opacity": 0.9}, { duration: "slow" }); 
       
        return false; 
    }); 
}); 
$(document).ready(function(){ //Tagging Volver
    $("[name='tagg_botonVolver']").click(function(){ 
        $('input#tags').val("");
        $('input#tags').focus();
		$('#tagg_form').show();
		$('#tagg_ok').hide();
		$('#tagg_error').hide();
		
        return false; 
    }); 
});


$(document).ready(function(){ 

	$("[name='enviar_tags']").click(function() {
	    
			var tags = $("input#tags").val();
			if (tags == "") {
			        $("input#tags").focus();
			        $('#tagg_form').hide();
					$('#tagg_ok').hide();
					$('div#tagg_val_error').show();
					$('div#tagg_servidor_error').hide();		
					$('#tagg_error').show();
			      return false;
		    }
			
			
			var dataString = 'tags='+ tags + '&titulo=' + $("input#taggTitulo").val() + '&idOde=' + $("input#taggIdOde").val() + '&idUsuario='+  $("input#taggIdUsuario").val() + '&idiomaCat=' + $("input#taggIdiomaCat").val();
			//alert (dataString);return false;
			
			$.ajax({
			      type: "POST",
			      url: "<html:rewrite action='/Tagging/Tagging'/>",
			      data: dataString,
			      error: function(){
        				$('#tagg_form').hide();
        				$('#tagg_ok').hide();
						$('div#tagg_val_error').hide();
						$('div#tagg_servidor_error').show();
        				$('#tagg_error').show();
    				},
			      success: function() {
        				$('#tagg_form').hide();
        				$('#tagg_ok').show();
        				$('#tagg_error').hide();
						$('input#tags').val("");
				      }
	     });
	    return false;
	});
	
}); 



$(document).ready(function(){ //seleccionar la caja del codigo embebido
    $("[name='embed_caja']").click(function(){ 
		$("[name='embed_caja']").focus();
		$("[name='embed_caja']").select();
		return false; 
    }); 
});

$(document).ready(function(){ //copiar el contenido embebido en el clipboard
	
	
	$.clipboardReady(function(){
	    $("[name='copiarEmbebido']").click(function(){ 
			
			$("[name='embed_caja']").focus();
			$("[name='embed_caja']").select();
			$.clipboard( $("[name='embed_caja']").val());
			
			return false; 
	    }); 

	
	});
});



//]]>
</script>
</head>

<body id="pseudo_iframe" >

<div id="capa_madre" style="max-width:100% !important">

<div id="cabecera"  >
<h1><span>${fn:escapeXml(visualizadorSession.tituloOde) }</span></h1>
<h2 id="agrega_logo">&nbsp;<span class="oculto">AGREGA</span></h2>
<!-- INICIO METANAVEGACION   -->
<!-- INICIO METANAVEGACION   -->
<div id="metanavegacion" style='float: right; margin-right: 125px'>
<ol id="container">
							<li class="oculto">
								<html:link href="#contenido_central" title="Contenido Principal">
								   <strong><bean:message key="cabecera.Contenido"/></strong>
								</html:link></li>
								<bean:define id="cerrar"><bean:message key="cabecera.Cerrar"/></bean:define>
							<li><html:link href="#" title="${cerrar }" styleId="li_inicial" onclick="window.parent.close()"><bean:message key="metanavegacion.Cerrar"/></html:link></li>
								<bean:define id="ayuda"><bean:message key="cabecera.Ayuda"/></bean:define>
<!-- MCA: Temporarily disable help
							<li>
							<html:link href="http://ute.agrega.indra.es/wiki/index.php/Previsualizador" title="${ayuda}" styleId="restringida" target="blank"><bean:message key="metanavegacion.Ayuda"/></html:link>
							<link:link attrProperty="HELP_URL" title="${ayuda }" id="ayuda" target="blank" i18nMessage="cabecera.Ayuda"></link:link>
							</li>
-->


	 					<c:if test="${visualizadorSession.masOpciones}" >
							<li><a href="#" name="Tagging" title="<bean:message key="tagging.titulo"/>"  class="btn-slide3" ><span><bean:message key="tagging.titulo"/></span></a></li>
							<li><a href="#" name="ContenidoInapropiado" title="<bean:message key="contenidoInapropiado.titulo"/>" class="btn-slide"><span><bean:message key="contenidoInapropiado.titulo"/></span></a></li>
							<li><a href="#" name="ContenidoEmbebido" title="<bean:message key="embebido.titulo"/>" class="btn-slide2"  id="sinbarra"><span><bean:message key="embebido.titulo"/></span></a></li>
						</c:if>
</ol>
</div>
<!-- no quitar para que no se suba  el título -->
<div style="text-align:center;">
<span class="flechas">
</span>
</div>
<!-- no quitar para que no se suba el título -->

<br class="oculto" />

</div>
<div class="tronco_de_contenido">
<div id="madre_barra"><div class="fondolat"></div></div>
</div>

<!-- formulario de Contenido inapropiados -->
<!-- formulario de Contenido inapropiados -->
<!-- formulario de Contenido inapropiados -->
<!-- formulario de Contenido inapropiados -->
<div id="panelwrapper">
<div id="panel">
<div class="pop_int">
	<form  action="">
		<h3><bean:message key="contenidoInapropiado.titulo"/>&nbsp;</h3>
	<div id="ci_form" style="display:none" >	
			<label for="comentario"><bean:message key="contenidoInapropiado.popup.titulo"/></label>
			<input type="text" id="comentario" name="comentario" class="in_box" onfocus="limpiarTexto(this)"  onblur="this.style.backgroundColor='#e1e1e1'" title="<bean:message key="contenidoInapropiado.popup.titulo"/>" ></input>
		<fieldset class="tipo">
			<a href="#" name="ContenidoInapropiado" class="btn-slide"><bean:message key="contenidoInapropiado.popup.cancelar"/></a>
			<input name="enviar_CI" class="boton_90_de_2" type="button"  value="<bean:message key="contenidoInapropiado.popup.aceptar"/>" />
		</fieldset>
	</div>
	<div id="ci_error" style="display:none" >
		<br/>
		<div id="comentario_error" class="in_box"><bean:message key="contenidoInapropiado.popup.error.mensaje.vacio"/></div>
		<div id="servidor_error" class="in_box"><bean:message key="contenidoInapropiado.popup.error.servidor"/></div>
		<fieldset class="tipo ft_centrada" >
			<a href="#"  class="btn-slide" id="volver_centrado" name="ci_botonVolver" ><bean:message key="contenidoInapropiado.popup.volver"/></a>
		</fieldset>
	</div>
	<div id="ci_ok" style="display:none" >
		<br/>
		<div class="in_box" id="succes" ><bean:message key="contenidoInapropiado.popup.mensaje.exito"/></div>
		<fieldset class="tipo ft_centrada" >
			<a href="#" class="btn-slide" id="volver_centrado" name="ContenidoInapropiado"><bean:message key="contenidoInapropiado.popup.mensaje.cerrar"/></a>
		</fieldset>
	</div>
	</form>

</div>
</div>
<div class="slide" ></div>
</div> 

<!-- FIN formulario de Contenido inapropiados -->
<!-- FIN formulario de Contenido inapropiados -->
<!-- FIN formulario de Contenido inapropiados -->
<!-- FIN formulario de Contenido inapropiados -->


<!-- formulario de Contenido Embebidos-->
<!-- formulario de Contenido Embebidos-->
<!-- formulario de Contenido Embebidos-->
<!-- formulario de Contenido Embebidos-->
<div id="panelwrapper2">
<div id="panel">
<div class="pop_int" >
	<form action="">
		<h3 ><bean:message key="embebido.titulo"/>&nbsp;</h3>
		<label for="embed_caja"><bean:message key="embebido.popup.mensaje"/></label>
		<input type="text" name="embed_caja" readonly="readonly" class="in_box" id="embed_caja"  title="<bean:message key="embebido.popup.tootltip"/>" value="${fn:escapeXml(visualizadorSession.contenidoEmbebido)}" />
	<fieldset class="tipo" >
		<a href="#"  class="btn-slide"  name='ContenidoEmbebido'  ><bean:message key="embebido.popup.cerrrar"/></a>
		<input name="copiarEmbebido" class="boton_90_de_2" type="button"  value="<bean:message key="embebido.popup.copiar"/>" />
	</fieldset>

	</form>
</div>
</div>
<div class="slide" ></div>
</div> 
<!-- FIN formulario de Contenido Embebidos-->
<!-- FIN formulario de Contenido Embebidos-->
<!-- FIN formulario de Contenido Embebidos-->
<!-- FIN formulario de Contenido Embebidos-->



<!-- formulario de Tagging-->
<!-- formulario de Tagging-->
<!-- formulario de Tagging-->
<!-- formulario de Tagging-->
<div id="panelwrapper3">
<div id="panel">
<div class="pop_int">
	<form  action="">
<html:hidden styleId="taggTitulo" property="titulo" value="${fn:escapeXml(visualizadorSession.tituloOde)}"/>
<html:hidden styleId="taggIdOde" property="idOde" value="${fn:escapeXml(visualizadorSession.identificador)}" />
<html:hidden styleId="taggIdUsuario" property="idUsuario" value="${fn:escapeXml(visualizadorSession.usuario)}" />
<html:hidden styleId="taggIdiomaCat" property="idiomaCat" value="${fn:escapeXml(visualizadorSession.idiomaCat)}" />

		<h3><bean:message key="tagging.titulo"/>&nbsp;</h3>
	<div id="tagg_form" >
			<label for="tags"><bean:message key="tagging.popup.mensaje"/></label>
			<input type="text" name="tags" id="tags" class="in_box" onfocus="limpiarTexto(this)"  onblur="this.style.backgroundColor='#e1e1e1'"   title="<bean:message key="tagging.popup.titulo"/>" ></input>
		<fieldset class="tipo">
			<a href="#" class="btn-slide3" name="Tagging" ><bean:message key="tagging.popup.cancelar"/></a>
			<input name="enviar_tags" class="boton_90_de_2" type="button"  value="<bean:message key="tagging.popup.aceptar"/>" />
		</fieldset>
		
	</div>
	<div id="tagg_error" style="display:none" >
		<br/>
			<div id="tagg_val_error" class="in_box"><bean:message key="tagging.popup.error.comentario.vacio"/></div>
			<div id="tagg_servidor_error" class="in_box"><bean:message key="tagging.popup.error.servidor"/></div>
		<fieldset class="tipo ft_centrada" >
			<a href="#" class="btn-slide3" name="tagg_botonVolver" id="volver_centrado" ><bean:message key="tagging.popup.volver"/></a>
		</fieldset>
	</div>
	<div id="tagg_ok" style="display:none" >
		<br/>
		<div id="succes" class="in_box"><bean:message key="tagging.popup.mensaje.exito"/></div>
		<fieldset class="tipo ft_centrada" style="text-align:center">
			<a href="#" class="btn-slide3" name="Tagging" id="volver_centrado" ><bean:message key="tagging.popup.cerrar"/></a>
		</fieldset>
	</div>
	</form>
</div>
</div>
<div class="slide"></div>
</div> 
<!-- FIN formulario de Tagging-->
<!-- FIN formulario de Tagging-->
<!-- FIN formulario de Tagging-->
<!-- FIN formulario de Tagging-->

</div>
</body>
</html>
