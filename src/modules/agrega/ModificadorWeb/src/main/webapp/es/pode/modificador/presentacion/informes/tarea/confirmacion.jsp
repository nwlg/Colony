<!-- *****************************************************************************************************
*********************************       Listar.jsp de Tareas Pendientes      ** ***********************************
******************************************************************************************************-->
  
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>


<tiles:insert definition="${sessionScope.offline == true ? 'layout-offline' : 'layout-administrador'}">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>


<!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
<div class="plantilla_contenido">

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<form id="informeTareaConfirmacionSubmitConfirmacionForm" action="<html:rewrite action="/InformeTarea/ConfirmacionSubmitConfirmacion"/>">
	<h2><bean:message key="modificador.restaurar.confirmacion.tituloGuardar"/></h2>
	<!--  INICIO GLOBO GRIS   -->
	<!--  INICIO GLOBO GRIS   -->
	<input type="hidden" name="id" value="${form.id}"/>
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
					<!--  INICIO CAJA DE FORMULARIO   -->
					<div id="formulario" class="ali_c">	
						<br />
						<p ><bean:message key="modificador.restaurar.confirmacion"/></p>
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
	<bean:define id="aceptValue"><bean:message key="modificador.restaurar.confirmacion.BotonAceptar"/></bean:define>	
		 <input type="submit" name="action" class="boton_125_de_2" value="${aceptValue}" />
		 <bean:define id="cancelValue"><bean:message key="modificador.restaurar.confirmacion.BotonCancelar"/></bean:define>
		 <input type="submit" name="action" class="boton_125_de_2_izq" value="${cancelValue }"/>
		 
	</fieldset>
</form>
</div>

    </tiles:put>

</tiles:insert>
