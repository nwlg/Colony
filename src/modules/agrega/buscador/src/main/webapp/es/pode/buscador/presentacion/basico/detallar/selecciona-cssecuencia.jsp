<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>

<tiles:insert definition="layout-sinlateral">

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="body" type="string">
<div class="plantilla_contenido">
<jsp:include page="/layout/messages.jsp" flush="true" />
<h2><bean:message key="previsualizar.conSinSecuencia.titulo"/> ${form.titulo}</h2>
<form method="get" action="<html:rewrite action="/DetallarODECU/SeleccionaCSSecuenciaMostrarODECSSecuencia"/>" target="_blank">

<p class="parrafo_comun" id="separacion2"><bean:message key="previsualizar.conSinSecuencia.titulo.explicacion"/>
	<bean:define id="adl"><bean:message key="previsualizar.conSinSecuencia.titulo.visAdl.adlLink"/></bean:define>
 	<html:link href="http://www.adlnet.gov/" title="${adl}" target="blank">
 		<bean:message key="previsualizar.conSinSecuencia.titulo.visAdl.adlLink"/>
 	</html:link>
	<bean:message key="previsualizar.conSinSecuencia.titulo.visAdl.adltexto"/>
	<bean:message key="previsualizar.conSinSecuencia.titulo.visAdl.adladvierte"/>
</p>

<p class="parrafo_comun" id="separacion2"><bean:message key="previsualizar.conSinSecuencia.titulo.seleccioneVisualizacion"/>:</p>
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
			<input name="identificador" value="${form.identificadorODE}" type="hidden">
			<div class="fila_de_tabla">
  						<div class="text ft_lateral" ><input type="radio" class="boton_radio" id="Previsual01" checked="checked" name="secuencia" value="true"/><label for="true" class="alineada"><bean:message key="previsualizar.conSinSecuencia.titulo.conSecuencia"/> </label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
			<div class="fila_de_tabla">
  						<div class="text ft_lateral"><input type="radio" class="boton_radio" id="Previsual02"  name="secuencia" value="false"/><label for="false"  class="alineada2"><bean:message key="previsualizar.conSinSecuencia.titulo.sinSecuencia"/>  </label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
				
				<div class="fila_de_tabla">
  						<div class="text ft_lateral"><input type="radio" class="boton_radio" id="Previsual03"  name="secuencia" value="adl"/><label for="false"  class="alineada3"><bean:message key="previsualizar.conSinSecuencia.titulo.visAdl"/>  </label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
				
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<input class="boton_125_de_2 tipo" target="_blank" type="submit"  value="<bean:message key="previsualizar.conSinSecuencia.botonAceptar"/>" />
</form>
<logic:equal name="form" property="mostrarVuelta" value="true">
	<logic:equal name="form" property="busquedaSimpleAvanzada" value="BUSQUEDA_ARBOL">
		<form action="<rewrite:rewrite url="buscador/DetallarODECU/DetallarODECU.do"/>?identificadorODE=${form.identificadorODE}&amp;idioma=${form.idioma}&amp;mostrarVuelta=${form.mostrarVuelta}&amp;areaCurricularBusqueda=" method="post">
			<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
			<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="descargar.boton.volver"/>"/>
		</form>
	</logic:equal>
	<logic:notEqual name="form" property="busquedaSimpleAvanzada" value="BUSQUEDA_ARBOL">
		<form action="<rewrite:rewrite url="buscador/DetallarODECU/DetallarODECU.do"/>?identificadorODE=${form.identificadorODE}&amp;idioma=${form.idioma}&amp;mostrarVuelta=${form.mostrarVuelta}" method="post">
			<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
			<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="descargar.boton.volver"/>"/>
		</form>
	</logic:notEqual>
</logic:equal>
<logic:notEqual name="form" property="mostrarVuelta" value="true">
	<form action="<rewrite:rewrite url="buscador/DetallarODECU/DetallarODECU.do"/>?identificadorODE=${form.identificadorODE}&amp;idioma=${form.idioma}&amp;mostrarVuelta=${form.mostrarVuelta}" method="post">
		<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
		<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="descargar.boton.volver"/>"/>
	</form>
</logic:notEqual>
</div>
    </tiles:put>

</tiles:insert>
