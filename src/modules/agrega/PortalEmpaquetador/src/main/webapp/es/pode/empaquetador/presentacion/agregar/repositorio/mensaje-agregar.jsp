<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<bean:define id="urlArchivos"><html:rewrite action="/GestorArchivos/GestorArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/GestorRecursos/GestorRecusos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlEstructura"><html:rewrite action="/GestorBasico/GestorBasico"/></bean:define>
<bean:define id="selected" value="submanifiestos"/>
<emp:layout selected="${selected}" urlEstructura="${urlEstructura}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
<bean:define id="empaquetadorSesion" name="<%=es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY%>" scope="session"/>

<!-- Inicio plantilla contenido  -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">


<h2><bean:message key="presentacion.importar.desde.repositorio.titulo.pagina"/></h2>
<form method="post" action="<html:rewrite action="/AbrirBuscador/MensajeAgregarVolver"/>" >
<bean:define id="buscadorUrl"><rewrite:rewrite url="${initParam.url_buscadorAvanzado }"/>?empIdOde=${form.idOde}<logic:notEmpty name="form" property="idDestino">&empIdDestino=${form.idDestino}</logic:notEmpty>&empTipoEmpaquetador=${form.tipoEmpaquetador}</bean:define>
	<!--  INICIO GLOBO GRIS   -->
	<!--  INICIO GLOBO GRIS   -->
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
					<!--  INICIO CAJA DE FORMULARIO   -->
					<div id="formulario" class="ali_c">	
					<br />
						 <p>
						 	<span>
						 		<bean:message key="presentacion.importar.desde.repositorio.mensaje.enlace.1"/> <a href="${buscadorUrl }" target="_blank"><bean:message key="presentacion.importar.desde.repositorio.mensaje.enlace.2"/></a> <bean:message key="presentacion.importar.desde.repositorio.mensaje.enlace.3"/>
						 	</span>
						 </p>
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
	<fieldset class="tipo ft_centrada">
	<input class="boton_125"  type="submit"  value="<bean:message key="presentacion.importar.desde.repositorio.boton.volver"/>" />
	</fieldset>
	<!-- Fin Botones  -->
	<!-- Fin Botones  -->
</form>

<script type="text/javascript">
  document.forms[0].origen[0].focus();
</script>

</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
</emp:layout>
<bean:define id="parametros">empIdOde=${form.idOde}<logic:notEmpty name="form" property="idDestino">&empIdDestino=${form.idDestino}</logic:notEmpty>&empTipoEmpaquetador=${form.tipoEmpaquetador}</bean:define>
<script type="text/javascript">
	
	window.open("${buscadorUrl}");
	
</script>






