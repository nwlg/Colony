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

	<h2><bean:message key="enviar.email.amigo.boton.enviar"/></h2>
		<form name="accept" method="post" action="<html:rewrite action="/EnviarMailCU/ResultadoEnvioAceptar.do" />">	


<!-- Start of blue bubble -->		
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

					<!--  INICIO CAJA DE FORMULARIO   -->
					<div id="formulario" class="ali_c">
					<br />
					 <p><em class="correcto">
					    <bean:message key="enviar.email.amigo.envio.correcto"/>
					 </em></p>
					  
						<br />
						</div>
						<!--  FIN CAJA DE FORMULARIO   -->
</div></div></div></div>
<!--  End of blue bubble -->

<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">	
	<input style="display: none;" class="boton_125"  type="submit"  value="<bean:message key="previsualizar.conSinSecuencia.botonAceptar"/>" />
	<input name="idioma" value="${form.idioma}" type="hidden">					
	<input name="identificadorODE" value="${form.identificadorODE}" type="hidden">
	<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
	<input name="mostrarVuelta" value="${form.mostrarVuelta}" type="hidden">
</fieldset>

<div style="margin-left: 50%; margin-top: 12px; text-align: center;">
<div style="float: left;">

<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	<div class="db_bubble_content">
		<a href="javascript:document.forms['accept'].submit();"><bean:message key="previsualizar.conSinSecuencia.botonAceptar"/></a>
	</div>
</div></div></div></div>

</div>
</div>
<!-- End of bubble -->

<!-- Fin Botones  -->
</form>

</div>
<!-- Fin plantilla contenido  -->

</tiles:put>
</tiles:insert>
