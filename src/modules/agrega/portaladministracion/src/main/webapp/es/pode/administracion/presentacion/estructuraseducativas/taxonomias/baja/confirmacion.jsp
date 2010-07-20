<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<bean:define id="eeSession" name="<%=es.pode.administracion.presentacion.estructuraseducativas.EstructurasSession.SESSION_KEY %>" scope="session"/>

<tiles:insert definition="layout-administrador">
<tiles:put name="title" type="string">
	<bean:message key="title.Comun"/>
</tiles:put>
<tiles:put name="body" type="string">
<%@ include file="/taglib-imports.jspf" %>

<!--************************          Inicio plantilla contenido       ****************************-->
<div class="plantilla_contenido">

<form id="bajaTaxonomiasConfirmacionSubmitForm" 
	action="<html:rewrite action="/BajaTaxonomias/ConfirmacionSubmit"/>" method="post">
<jsp:include page="/layout/messages.jsp" flush="true" />
 <h2> <bean:message key="estructuras.taxonomias.baja.titulo"/> </h2>


	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
					<div id="formulario" class="ali_c">
					
						<p><bean:message key="estructuras.taxonomias.baja.mensaje"/></p>
						<p>
						<!--		INICIO CAJA TABLA		-->
							<div class="caja_tabla" >
								<display:table name="${eeSession.vdexEliminar}" uid="fila" requestURI="${pageContext.request.requestURL}"
					        	export="false" pagesize="8" sort="list" style="border:1;width:100%;" class="administracion_tareas"
								cellpadding="0" cellspacing="0" summary="${summary}">
						<!--		COLUMNA DE USUARIOS		-->
								<display:column>
					            	${fn:substring(fila, 0, fn:length(fila)-3)} 
					        	</display:column>
					        	
					        	</display:table>
							</div>
						<!--		FIN CAJA DE FORMULARIO		-->
						</p>

				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->








<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
	<input class="boton_125_de_2" style="position:relative"  type="submit" name="action" value="<bean:message key="estructuras.aceptar"/>" />
	<input class="boton_125_de_2_izq" style="position:relative"  type="submit" name="action" value="<bean:message key="estructuras.cancelar"/>" />
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>

</div><!-- plantilla contenido -->
</tiles:put>
</tiles:insert>