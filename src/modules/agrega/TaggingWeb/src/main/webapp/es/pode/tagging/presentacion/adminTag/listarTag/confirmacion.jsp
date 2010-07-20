<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ include file="/taglib-imports.jspf" %>
<tiles:insert definition="layout-administrador">
<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>
<tiles:put name="body" type="string">
<div class="plantilla_contenido">
<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />
<h2><bean:message key="tagging.listar.eliminar.confirmacion.h2"/></h2>
<form id="listarTagConfirmacionSubmitConfirmacionForm" action="<html:rewrite action="/ListarTag/ConfirmacionSubmitConfirmacion"/>">
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" class="ali_c">

			<br />
			<p ><bean:message key="tagging.listar.eliminar.confirmacion.explicacion"/></p>
			<p>
			<!--		INICIO CAJA TABLA		-->
				<div class="caja_tabla" >
					<display:table name="${form.tagsEliminar}" uid="fila" requestURI="${pageContext.request.requestURL}"
		        	export="false" pagesize="8" sort="list" style="border:1;width:100%;" class="administracion_tareas"
					cellpadding="0" cellspacing="0" >
			<!--		TAG ELIMINADOS		-->
						<display:column>
							  	${fila }
			        	</display:column>
		        	</display:table>
				</div>
			<!--		FIN CAJA DE FORMULARIO		-->
				</p>
				
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
<input class="boton_125_de_2"  type="submit" name="accion" 
	value="<bean:message key="tagging.listar.eliminar.confirmacion.si"/>" />
<input class="boton_125_de_2_izq"  type="submit" name="accion" 
	value="<bean:message key="tagging.listar.eliminar.confirmacion.no"/>" />

</fieldset>
</form>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</div>
</tiles:put>
</tiles:insert>