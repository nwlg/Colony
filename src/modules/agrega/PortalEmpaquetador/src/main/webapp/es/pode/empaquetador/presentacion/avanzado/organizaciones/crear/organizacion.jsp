<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<bean:define id="urlArchivos"><html:rewrite action="/CrearOrganizacion/OrganizacionArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/CrearOrganizacion/OrganizacionRecursos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/CrearOrganizacion/OrganizacionOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/CrearOrganizacion/OrganizacionSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/CrearOrganizacion/OrganizacionOrganizaciones"/></bean:define>
<bean:define id="selected" value="organizaciones"/>
<emp:layout selected="${selected}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
<bean:define id="empaquetadorSesion" name="<%=es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY%>" scope="session"/>
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>
<bean:define id="crear"><bean:message key="portal_empaquetado_crearOrganizaciones.crear"/></bean:define>
<bean:define id="modificar"><bean:message key="portal_empaquetado_gestorOrganizaciones.modificar"/></bean:define>
<h2><bean:message key="portal_empaquetado_gestorOrganizaciones.titulo" arg0="${empty crearOrganizacionSession.title ? crear : modificar }"/></h2>
<form id="crearOrganizacionOrganizacionSubmitForm" method="post" action="<html:rewrite action="/CrearOrganizacion/OrganizacionSubmit"/>" enctype="multipart/form-data">
<p class="parrafo_comun" id="separacion2"><bean:message key="portal_empaquetado_crearOrganizaciones.introducirNombre"/>:</p>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >

			 <div class="fila_de_tabla">
  						<div class="text" style="text-align:center"><label for="nombreOrg"><span class="oculto"><bean:message key="portal_empaquetado_crearOrganizaciones.nombreOrganizacion"/></span></label><input name="title" class="nombreOrg" value="${fn:escapeXml(crearOrganizacionSession.title)}"  onblur="this.style.backgroundColor='#e1e1e1'" id="nombreOrg" type="text" title=<bean:message key="portal_empaquetado_crearOrganizaciones.nombreOrganizacion.tooltip"/>  /></div>
					<br class="oculto" />
				</div>
				<br />
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>

		</div>
	</div>
</div>

<fieldset class="tipo ft_centrada">
<input class="boton_125_de_2"  type="submit"  name="action"  value="<bean:message key="portal_empaquetado_crearOrganizaciones.aceptar"/>" />
<input class="boton_125_de_2_izq"  type="submit"  name="action"  value="<bean:message key="portal_empaquetado_crearOrganizaciones.cancelar"/>" />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
<script type="text/javascript">
  document.forms[0].title.focus();
</script>
</div>
</emp:layout>