<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tiles:insert definition="layout-empaquetador-avanzado">
 <tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
 </tiles:put>

<tiles:put name="selected" type="string" value="submanifiestos"/>


<tiles:put name="urlArchivos" type="string">
      <html:rewrite action="/GestorArchivos/GestorArchivos"/>
</tiles:put>
<tiles:put name="urlRecursos" type="string">
      <html:rewrite action="/GestorRecursos/GestorRecursos"/>
</tiles:put>
<tiles:put name="urlOrganizaciones" type="string">
      <html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/>
</tiles:put>
<tiles:put name="urlSubmanifiestos" type="string">
      <html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/>
</tiles:put>
<tiles:put name="body" type="string">

<bean:define id="empaquetadorSesion" name="<%=es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY%>" scope="session"/>
<!-- gestor de archivos session -->


<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>





<h2><bean:message key="portalempaquetado.avanzado.submanifiestos.eliminar.tituloAdvertencia"/></h2>
<form 	method="post" 
		action="<html:rewrite action="/EliminarSubmanifiestos/AdvertenciaAceptar"/>"
		id="eliminarSubmanifiestosAdvertenciaAceptarForm">



<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" class="ali_c">

			<br />
			<p ><bean:message key="portalempaquetado.avanzado.submanifiestos.eliminar.referencia"/></p>
			 <p ><bean:message key="portalempaquetado.avanzado.submanifiestos.eliminar.advertencia"/></p>
				<br />
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>

</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo">
<input class="boton_125_de_2_izq"  type="submit" name="action" 
	value="<bean:message key="portalempaquetado.avanzado.submanifiestos.cancelar"/>" />
<input class="boton_125_de_2"  type="submit" name="action" 
	value="<bean:message key="portalempaquetado.avanzado.submanifiestos.aceptar"/>" />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>






</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->

</tiles:put>
</tiles:insert>
