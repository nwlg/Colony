<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">

<head lang="es" dir="ltr">
<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tlds/rewriteTag.tld" prefix="rewrite" %> 
<%@ taglib uri="/WEB-INF/tlds/tags-visualizador.tld" prefix="vis" %>

<title><bean:message key="title.Comun"/></title>

	<link type="text/css" rel="stylesheet" media="screen" href="<rewrite:rewrite url='static/css/red.css'/>"/>
	<script type="text/javascript" src="<rewrite:rewrite url='static/js/menu.js'/>"></script>

<script type="text/javascript">
//<![CDATA[
	function clickItem(idNodo,identificador, usuario)
	{
	  parent.parent.location='<html:rewrite action="/Visualizar/VisualizarDatosNavSecuenciaNodo"/>?identificador=' + identificador + '&usuario=' + usuario + '&idNodo='+ idNodo;
	}

	function mostrarItem(href, id ,offline)
	{
		parent.mostrarItem(href, id ,offline);
	}
	function abrirCerrar(item,abierto,cerrado)
	{
		parent.abrirCerrar(item,abierto,cerrado);
	}

//]]>
</script>

</head>

<body class="fondo_menu_frame">
<div id="menu_frame">
	 <vis:visualizarConSec 	organizaciones="${form.datosSalidaAsArray}" 
	 localizacion="${localizacion}" 
	 idSeleccionado="${visualizadorSession.idSeleccionado}"
	 identificador="${visualizadorSession.identificador}" 
	 usuario="${visualizadorSession.usuario}"
 	 abiertos="${visualizadorSession.abiertos}"
	 rutaSeleccionado="${visualizadorSession.rutaSeleccionado}"/>
</div>

<div id="contenido_central_largo">

</div>

<form name="f1">
	<input type="hidden" value="${visualizadorSession.idSeleccionado }" name="seleccion" id="seleccion" >
	<input type="hidden" value="${visualizadorSession.urlContenido}" name="urlContenido" id="urlContenido">
	<input type="hidden" value="${visualizadorSession.offLine}" name="offline" id="offline">
</form>

</body>
</html>
