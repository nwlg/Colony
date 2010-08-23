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
	<form method="post" action="<html:rewrite action="/CrearNoticia/FormularioCrearValidarFormu"/>" enctype="multipart/form-data">		
		<!-- ## Para pintar los mensajes de error ## -->
		<jsp:include page="/layout/messages.jsp" flush="true" />	
		<h2><bean:message key="noticias.crear.titulo.dos"/></h2>	
		
		<!--************************          TAG QUE PINTA LAS PANTALLAS DE CATEGORIASNOTICIAS Y NOTICIAS      ****************************-->
		<news:noticiasTag action="altaNoticia" 
							sessionScope="${sessionScope['org.apache.struts.action.LOCALE']}" 
							idiomas="${form.idiomas}" 
							nombreCategoria="${form.nombreCategoria}" 
							titulo="${form.titulo}" 
							resumen="${form.resumen}" 
							cuerpo="${form.cuerpo}" 
							idiomasAlta="${form.idiomasAlta}" 
							idiomasCategoriasBBDD="${form.idiomasCategoriasBBDD}"/> 	
		
	
	<!-- Inicio Botones  -->
	<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key="estructuras.aceptar"/>" />
			<input type="hidden" name="alineamiento" value="${form.alineamiento}"/>
			<input type="hidden" name="categoria" value="${form.categoria}"/>
			<input type="hidden" name="estado" value="${form.estado}"/>
			<input type="hidden" name="activarImagen" value="${form.activarImagen}"/>	
			<input type="hidden" name="nombreImagen" value="${form.nombreImagen}"/>				
	</form>	
	<form action='<html:rewrite action="/CrearNoticia/FormularioCrearVolver"/>' method="post">	
		<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="informes.crearInforme.volver"/>" />
			<input type="hidden" name="alineamiento" value="${form.alineamiento}"/>
			<input type="hidden" name="categoria" value="${form.categoria}"/>
			<input type="hidden" name="estado" value="${form.estado}"/>
			<input type="hidden" name="activarImagen" value="${form.activarImagen}"/>	
			<input type="hidden" name="nombreImagen" value="${form.nombreImagen}"/>	
	</form>
	<form method="post" action="<html:rewrite action="/Noticias/Noticias"/>">	
		<input class="boton_125 tipo"  type="submit"  value="<bean:message key="estructuras.cancelar"/>" />
	</form>
	<!-- Fin Botones  -->

</div>
<!-- Fin plantilla contenido  -->	

</tiles:put>
</tiles:insert>
