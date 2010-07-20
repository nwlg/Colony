<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<tiles:insert definition="layout-administrador">
<tiles:put name="title" type="string">
	<bean:message key="title.Comun"/>
</tiles:put>
<tiles:put name="body" type="string">
<%@ include file="/taglib-imports.jspf" %>

<!--************************          Inicio plantilla contenido       ****************************-->
<div class="plantilla_contenido">
<jsp:include page="/layout/messages.jsp" flush="true" />


<form id="bajaTaxonomiasConfirmacionSubmitForm" 
	action="<html:rewrite action="/AltaTesauros/AdvertenciaSubmitAdvertencia"/>" method="post">
 <h2> <bean:message key="estructuras.tesauros.crear"/> </h2>


	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
					<div id="formulario" class="ali_c">
					
						<p><bean:message key="estructuras.tesauros.alta.advertencia"/></p>
						
					
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