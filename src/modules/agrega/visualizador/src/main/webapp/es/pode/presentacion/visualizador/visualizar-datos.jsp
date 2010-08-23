<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN"
"DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="es" lang="es">
<head>
<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tlds/rewriteTag.tld" prefix="rewrite" %> 

	<title><bean:message key="title.Comun"/></title>
	<link rel="shortcut icon" href="<rewrite:rewrite url='static/img/favicon.ico'/>" />
	<link type="text/css" rel="stylesheet" media="screen" href="<rewrite:rewrite url='static/css/red.css'/>"/>


</head>
	 <frameset rows="87,*" cols="100%"  class="frame_set" border="0" style="max-width:100% !important;">
		<frame name="cabecera" title="Cabecera" src="../layout/metanavegacion.jsp" frameborder="0" scrolling="no" marginwidth="0" marginheight="0" />
		<frame name="Contenido" title="Contenido" src="../layout/contenido_frame.jsp" frameborder="0" scrolling="no" marginwidth="0" style="z-index:1" marginheight="0" />
	
<noframes>
<body>
<p>
<bean:message key="visualizar.noframes"/><br />
<br />
<bean:message key="visualizar.frames"/>
<html:link action="../layout/metanavegacion.jsp"><bean:message key="visualizar.enlaceCabecera"/></html:link>
<html:link action="../layout/menu.jsp"><bean:message key="visualizar.enlaceMenu"/></html:link>
<html:link action="../layout/contenido_index.jsp"><bean:message key="visualizar.enlaceContenido"/></html:link>
</p>
</body>
</noframes>
</frameset>
</html>