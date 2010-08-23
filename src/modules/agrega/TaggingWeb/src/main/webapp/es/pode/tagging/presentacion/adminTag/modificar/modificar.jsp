<!-- *****************************************************************************************************
*********************************       listado-odes.jsp       *************************************
******************************************************************************************************-->
  
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>


<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>



<!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
<div class="plantilla_contenido">

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />



<h2><bean:message key="tagging.modificarTag"/></h2>

<form id="modificarModificarSelectActionForm" action="<html:rewrite action="/Modificar/ModificarSelectAction"/>"  method="post">

<p class="parrafo_comun" id="separacion2"><bean:message key="tagging.modificarTag.introducirNombreTag"/>:</p>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >

			 <div class="fila_de_tabla">

  					<div class="text" style="text-align:center">
  					<label for="crearTarea"><span class="oculto"></span></label>
  					<input name="newTag" class="nombreGrupo" value="${form.tag}"  onblur="this.style.backgroundColor='#e1e1e1'" id="newTag" type="text" title="<bean:message key="tagging.modificarTag.input.title"/>"/>
					<input name="tagOld" value="${form.tag}"  id="tagOld" type="hidden"/>
					
  					</div>
  		
					<br class="oculto" />
				</div>
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
<input class="boton_125_de_2"  name="accion" type="submit"  value="<bean:message key="comun.aceptar"/>" />
<input class="boton_125_de_2_izq" name="accion" type="submit"  value="<bean:message key="comun.cancelar"/>" />

</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
</div>
</tiles:put>

</tiles:insert>
