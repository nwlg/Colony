<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="/WEB-INF/tags/serverProperties.tld" prefix="server" %>

<tiles:insert definition="layout-sinlateral">

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="body" type="string">


		<%@ include file="/layout/messages.jsp"%>
  <!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- ATENCION!! RREMPLAZAR ESTA CAPA DE LA  PLANTILLA DE CONTENIDO ("plantilla_contenido") POR LA QUE SE DESEE EN LA PLANTILLA BASE  -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
		<h2><bean:message key="seleccionar.ambitoBusqueda.titulo"/></h2>
		<form method="post" action="<html:rewrite action="/NavegarArbolCurricularCU/SeleccionAmbitoBusquedaCargarArbol.do"/>">
		<p class="parrafo_comun" id="separacion2"><bean:message key="seleccionar.ambitoBusqueda.parrafo"/></p>
		<div class="globo_gris">
		<div class="globo_gris_01">
		<div class="globo_gris_02">
		<div class="globo_gris_03">

		<div id="formulario">
		
		<div class="text ft_lateral">
			<div class="fila_de_tabla">
				<html:radio property="tipoBusquedaArbol" styleClass="boton_radio" styleId="Formato01" name="form" value="01" />
				<span class="vert">
					<bean:message key="navegar.arbolCurricular.todosNodos"/>
				</span>
			</div>
		</div>
		<div class="linea_separadora"></div>
		<br class="oculto" />

		<div class="text ft_lateral">
			<div class="fila_de_tabla">
				<html:radio property="tipoBusquedaArbol" styleClass="boton_radio" styleId="Formato01" name="form" value="02" />
				<span class="vert">
					<bean:message key="navegar.arbolCurricular.nodoParticular"/><server:serverProperties property="ccaa"/>
				</span>
			</div>
		</div>
		<div class="linea_separadora"></div>
		<br class="oculto" />

		<div class="linea_separadora"></div>
		<br class="oculto" />
		</div>
		</div>
		<!--  FIN CAJA DE FORMULARIO   --></div>
		</div>
		</div>
		</div>
		<!--  FIN GLOBO GRIS   --> <!--  FIN GLOBO GRIS   --> <!-- Inicio Botones  -->
		<!-- Inicio Botones  -->
		<fieldset class="tipo"><input class="boton_125_de_2"
			type="submit" value="<bean:message key="seleccionar.boton.seleccionar"/>"/></fieldset>
		<!-- Fin Botones  --> <!-- Fin Botones  --></form>
		</div>
		<!-- Fin plantilla contenido  --> <!-- Fin plantilla contenido  --> <!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
		<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
		<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->


		</div>
		<!--  FIN CAPA MADRE   -->
	</tiles:put>

</tiles:insert>
