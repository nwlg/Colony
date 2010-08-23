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

    

 <div class="plantilla_contenido">

<%@ include file="/layout/messages.jsp" %>


<h2><bean:message key="portal_empaquetado_desagregarSubmanifiestos.titulo"/></h2>
<form id="desagregarSubmanifiestoSeleccionarDestinoAceptarForm" method="post" action="<html:rewrite action="/DesagregarSubmanifiesto/SeleccionarDestinoAceptar"/>" enctype="multipart/form-data">
<p class="parrafo_comun" id="separacion2"><bean:message key="portal_empaquetado_desagregarSubmanifiestos.seleccionar"/>:</p>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >

			 <div class="fila_de_tabla">
  					
  				<div class="text ft_lateral">
  					<input type="radio" class="boton_radio" id="Origen01" checked="checked" name="destino" value="repositorio"/>
  					<label for="Origen01" class="alineada"><bean:message key="portal_empaquetado_desagregarSubmanifiestos.aSusObjetos"/></label>
  				</div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
				<!--     -->
			<div class="fila_de_tabla">
  				<div class="text ft_lateral"><input  type="radio" class="boton_radio" id="Origen02"  name="destino" value="local"/><label for="Origen02"  class="alineada2"><bean:message key="portal_empaquetado_desagregarSubmanifiestos.aSuOrdenador"/></label></div>

				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
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
<input class="boton_125_de_2"  type="submit"  name="action"  value="<bean:message key='portal_empaquetado_desagregarSubmanifiestos.continuar'/>" />
<input class="boton_125_de_2_izq"  type="submit"  name="action"  value="<bean:message key='portal_empaquetado_desagregarSubmanifiestos.cancelar'/>" />

</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
</div>
    </tiles:put>

</tiles:insert>
