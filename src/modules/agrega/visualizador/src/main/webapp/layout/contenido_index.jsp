<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">
<head lang="es" dir="ltr">

<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tlds/rewriteTag.tld" prefix="rewrite" %> 

<title><bean:message key="title.Comun"/></title>

	<link type="text/css" rel="stylesheet" media="screen" href="<rewrite:rewrite url='static/css/red.css'/>"/>
	<script type="text/javascript" src="<rewrite:rewrite url='static/js/menu.js'/>"></script>

<script type="text/javascript" >
//<![CDATA[

	function redimensionarContenido()
	{
		var iframeEl = document.getElementById? document.getElementById("frameContenido"): document.all? document.all["frameContenido"]: null;
		
		if(iframeEl!=null)
		{
			var alto =getAlto();
			var ancho=getAncho();
			iframeEl.style.height = alto - 20 +'px';
			iframeEl.style.width = ancho -40 +'px';
		}
	}
	
	function getAlto() 
	{
		  var myHeight = 0;
		  if( typeof( window.innerWidth ) == 'number' ) {
		    //Non-IE
		    myHeight = window.innerHeight;
		  } else if( document.documentElement && ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) {
		    //IE 6+ in 'standards compliant mode'
		    myHeight = document.documentElement.clientHeight;
		  } else if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) {
		    //IE 4 compatible
		    myHeight = document.body.clientHeight;
		  }
		  //window.alert( 'Height = ' + myHeight );
		  return myHeight;
	}

	function getAncho() 
	{
		  var myWidth = 0;
		  if( typeof( window.innerWidth ) == 'number' ) {
		    //Non-IE
		    myWidth = window.innerWidth ;
		  } else if( document.documentElement && ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) {
		    //IE 6+ in 'standards compliant mode'
		    myWidth = document.documentElement.clientWidth;
		  } else if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) {
		    //IE 4 compatible
		    myWidth = document.body.clientWidth;
		  }

		  return myWidth;
	}
//]]>
</script>

</head>
<body   onresize="redimensionarContenido();" >

<div id="contenido_central_largo">
<a href="javascript:parent.resizeFrame('1,*')" title="<bean:message key="contenido.menu.title"/>" class="solapa_frame"><span><bean:message key="contenido.menu.enlace"/></span></a>

<div class="plantilla_contenido" id="contenido_externo" >

</div>
</div>

</body>
</html>

