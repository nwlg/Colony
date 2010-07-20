<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cc" %>
<%@ taglib uri="/WEB-INF/tags/faqs.tld" prefix="faqs" %>

<tiles:insert definition="layout-administrador">
<tiles:put name="title" type="string">
	<bean:message key="title.Comun"/>
</tiles:put>
<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/es/pode/administracion/presentacion/noticias/noticias/noticias-vars.jspf" %>

<!--************************          Inicio plantilla contenido       ****************************-->
<form method="post" action="<html:rewrite action="/Faqs/Faqs"/>">	
	<div class="plantilla_contenido">
		<!-- ## Para pintar los mensajes de error ## -->
		<jsp:include page="/layout/messages.jsp" flush="true" />	
		<h2><bean:message key="faqs.ver.titulo.dos"/></h2>	
		<faqs:faqsTag action="verFaq" 
					    sessionScope="${sessionScope['org.apache.struts.action.LOCALE']}" 
						idiomas="${form.idiomas}" 
						nombreCategoria="${form.nombreCategoria}" 
						titulo="${form.titulo}" 
						descripcion="${form.descripcion}" 
						idiomasAlta="${form.idiomasAlta}" 
						idiomasCategoriasBBDD="" 
						posicionesCastellano="" 
						posicionesCatalan="" 
						posicionesIngles="" 
						posicionesValenciano="" 
						posicionesGallego="" 
						posicionesEuskera=""
						valuePosicion="${form.valuePosicion}"/> 	
	</div>
	<!-- Inicio Botones  -->
	<!-- Inicio Botones  -->
	<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key="estructuras.aceptar"/>" />			

</form>	
	<form action='<html:rewrite action="/VerFaq/VerFaq.do"/>' method="post">	
	<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="informes.crearInforme.volver"/>" />				
		<input type="hidden" name="id" value="${form.id}"/>
	</form>
	<form method="post" action="<html:rewrite action="/Faqs/Faqs"/>">	
		<input class="boton_125 tipo"  type="submit"  value="<bean:message key="estructuras.cancelar"/>" />
	</form>
	<!-- Fin Botones  -->
	<!-- Fin Botones  -->

<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->		

</tiles:put>
</tiles:insert>
