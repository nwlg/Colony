<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN"
"DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>

<title>${redes}</title>

<link rel="stylesheet" media="screen" href="static/css/red.css" type="text/css" />

</head>

<frameset rows="122,*" class="frame_set" border="0" >
	<frame name="cabecera" title="Cabecera" src="cabecera.html" frameborder="0" scrolling="no" marginwidth="0" marginheight="0" />
	<frameset cols="187,*" style="max-width:1024px;" border="5" >
		<frame name="menu" title="Menu" src="menu.html" frameborder="0" scrolling="yes" marginwidth="0" marginheight="0" class="frame_menu" />
		<frame title="Contenido_Principal" name="contenido_principal" src="contenido_index.html" frameborder="0" scrolling="auto" marginwidth="0" marginheight="0" />
	</frameset>	
<noframes>
<body>
<p>
${noframesmensaje}
<br />
<br />
Frames:
<a href="cabecera.html">${enlaceCabecera}</a>
<a href="menu.html">${enlaceMenu}</a>
<a href="contenido_index.html">${enlaceContenido}</a>
</p>
</body>
</noframes>
</frameset>


</html>
