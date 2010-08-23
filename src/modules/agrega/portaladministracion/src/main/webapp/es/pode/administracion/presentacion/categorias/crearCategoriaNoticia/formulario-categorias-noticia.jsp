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
	<form method="post" action="<html:rewrite action="/CrearCategoriaNoticiaCU/FormularioCategoriasNoticiaValidaFormulario"/>" >
		<!-- ## Para pintar los mensajes de error ## -->
		<jsp:include page="/layout/messages.jsp" flush="true" />	
		<h2><bean:message key="categorias.noticias.crear.titulo" /></h2>	
		<news:noticiasTag action="altaCategoriaNoticia" 
							sessionScope="" 
							idiomas="${form.idiomas}" 
							nombreCategoria="${form.nombreCategoria}" 
							titulo="" 
							resumen="" 
							cuerpo="" 
							idiomasAlta="" 
							idiomasCategoriasBBDD=""/> 	
		
		<!-- Inicio Botones  -->		
		<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key="estructuras.aceptar"/>" />
	</form>
	<form method="post" action="<html:rewrite action="/CategoriasNoticiasCU/CategoriasNoticiasCU"/>" >	
		<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="estructuras.cancelar"/>" />
	</form>	
</div>
<!-- Fin Botones  -->

<!-- Fin plantilla contenido  -->	
</tiles:put>
</tiles:insert>


