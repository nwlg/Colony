<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<tiles:insert definition="layout-sinlateral">

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="body" type="string">
<%@ include file="/taglib-imports.jspf" %>



<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" >
<!-- ## Para pintar los mensajes de error ## -->
	<jsp:include page="/layout/messages.jsp" flush="true" />

	<h2><bean:message key="detalle.buscadorEmpaquetador.agregar.resultado"/></h2>
		<form method="post" action="<html:rewrite action="/DetallarODECU/MostrarDetalleODEVolverBusqueda.do" />">	
		<!--  INICIO GLOBO GRIS   -->
		<!--  INICIO GLOBO GRIS   -->
		
		<div class="globo_gris" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					<!--  INICIO CAJA DE FORMULARIO   -->
					<div id="formulario" class="ali_c">
					<br />
					<logic:equal name="form" property="agregacionCorrecta" value="true">	
						 <p><em class="correcto">
						    <bean:message key="detalle.buscadorEmpaquetador.agregar.correcto"/>
						 </em></p>
					 </logic:equal>
					 <logic:equal name="form" property="agregacionCorrecta" value="false">	
						 <p><em class="incorrecto">
						    <bean:message key="detalle.buscadorEmpaquetador.agregar.incorrecto"/>
						 </em></p>
					 </logic:equal>	 
						<br />
						</div>
						<!--  FIN CAJA DE FORMULARIO   -->
					</div>
				</div>
			</div>
		</div>
		<!--  FIN GLOBO GRIS   -->

			<!-- Inicio Botones  -->
			<fieldset class="tipo ft_centrada">	
				<input class="boton_125"  type="submit"  value="<bean:message key="detalle.buscadorEmpaquetador.agregar.nuevoOde"/>" />
				<input name="identificadorODE" value="${form.identificadorODE}" type="hidden">
				<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
			</fieldset>
			<!-- Fin Botones  -->
		</form>
</div>
<!-- Fin plantilla contenido  -->

</tiles:put>
</tiles:insert>
