<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<tiles:insert definition="layout-usuario">

	<tiles:put name="title" type="string">
		<bean:message key="portada.title"/>
	</tiles:put>
	
	<tiles:put name="title" type="string">
	    <bean:message key="title.Comun"/>
	</tiles:put>
	
	<tiles:put name="style" type="string">
	        <link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/es/pode/visualizador/presentacion/politicaPrivacidad/politica-privacidad.css"/>"></link>
	</tiles:put>
	
	
	<tiles:put name="body" type="string">
	    <%@ include file="/es/pode/visualizador/presentacion/politicaPrivacidad/politica-privacidad-javascript.jspf" %>
	
		<div class="plantilla_contenido">
	
			<h2>Pol&iacute;tica Privacidad</h2>
			
			<div id="contenido_noticia">
			
				<p><br/><br/></p>
				<p><strong><bean:message key="visualizador.politica.texto1"/></strong></p>
				<p><bean:message key="visualizador.politica.texto2"/></p>
				<p><bean:message key="visualizador.politica.texto3"/></p>
				<p><bean:message key="visualizador.politica.texto4"/></p>
				<p><bean:message key="visualizador.politica.texto5"/></p>
				<p><br/><br/></p>
				<p><strong><bean:message key="visualizador.politica.texto6"/></strong></p>
				<p><bean:message key="visualizador.politica.texto7"/> <b><bean:message key="visualizador.politica.texto6"/></b> <bean:message key="visualizador.politica.texto8"/></p>
				<p><bean:message key="visualizador.politica.texto9"/> <b><bean:message key="visualizador.politica.texto6"/></b> <bean:message key="visualizador.politica.texto10"/> <b><bean:message key="visualizador.politica.texto6"/></b> <bean:message key="visualizador.politica.texto11"/></p>
		
			</div>
			
		</div>
	
	</tiles:put>
	
</tiles:insert>
