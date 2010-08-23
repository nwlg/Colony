<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cc" %>
<%@ taglib uri="/WEB-INF/tags/noticias.tld" prefix="news" %>

<tiles:insert definition="layout-administrador">
<tiles:put name="title" type="string">
	<bean:message key="title.Comun"/>
</tiles:put>
<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/es/pode/administracion/presentacion/noticias/noticias/noticias-vars.jspf" %>

<!--************************          Inicio plantilla contenido       ****************************-->
<div class="plantilla_contenido">
	<form method="post" action="<html:rewrite action="/CategoriasNoticiasCU/CategoriasNoticiasCU"/>" >		
		<!-- ## Para pintar los mensajes de error ## -->
		<jsp:include page="/layout/messages.jsp" flush="true" />			
		<h2><bean:message key='categorias.noticias.titulo.ver'/></h2>	
		<news:noticiasTag action="verCategoriaNoticia" 
							sessionScope="" 
							idiomas="${form.idiomas}" 
							nombreCategoria="${form.nombreCategoria}" 
							titulo="" 
							resumen="" 
							cuerpo="" 
							idiomasAlta="" 
							idiomasCategoriasBBDD=""/> 	
		
		<!-- Inicio Botones  -->		
		<input class="boton_125 tipo"  type="submit"  value="<bean:message key='usuarios.volver'/>" />
	</form>
	
</div>
<!-- Fin Botones  -->

<!-- Fin plantilla contenido  -->	
</tiles:put>
</tiles:insert>