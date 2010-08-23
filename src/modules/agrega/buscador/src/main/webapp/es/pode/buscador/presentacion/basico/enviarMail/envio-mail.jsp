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

	<h2>${form.titulo}</h2>	
	<h2><bean:message key="enviar.email.amigo.boton.enviar"/></h2>	
		<form name="send" method="post" action="<html:rewrite action="/EnviarMailCU/EnvioMailAceptar.do"/>" >	
		<p class="parrafo_comun" id="separacion2"><bean:message key="enviar.email.amigo.general.texto.obligacion"/></p>	


<!-- Start of top bubble -->
<div class="comment_header">
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">


<!--  INICIO CAJA DE FORMULARIO   -->
<div id="formulario" >	
<div class="comment_body">	
	<fieldset >
		<div class="cja">
			<div class="cja_02">
				<label for="CorreoE" ><bean:message key="enviar.email.amigo.correos.electronicos"/></label>
				<input name="correosHasta" value="${form.correosHasta}" class="cajatexto"  id="CorreoE"  title="<bean:message key="enviar.email.amigo.correos.electronicos.tooltip"/>" onblur="this.style.backgroundColor='#e1e1e1'" type="text"/>
				<br />
			</div>
			<div class="cja_02" >
				<label for="Nombre"><bean:message key="enviar.email.amigo.nombres"/></label>
				<input name="nombresHasta" value="${form.nombresHasta}" onblur="this.style.backgroundColor='#e1e1e1'"  class="cajatexto"  id="Nombre"  title="<bean:message key="enviar.email.amigo.nombres.tooltip"/>" type="text"/>
			</div>
		</div>
								
		<div class="cja limpiar" >
			<div class="cja_02">
				<label for="Tucorreo"><bean:message key="enviar.email.amigo.tu.correo"/></label>		<input name="correoDesde" value="${form.correoDesde}"onblur="this.style.backgroundColor='#e1e1e1'"  class="cajatexto"  id="Tucorreo"  title="<bean:message key="enviar.email.amigo.tu.correo.tooltip"/>" type="text" />
			</div>								
			<div class="cja_02" >
				<label for="Tunombre"><bean:message key="enviar.email.amigo.tu.nombre"/></label>
				<input name="nombreDesde" value="${form.nombreDesde}" onblur="this.style.backgroundColor='#e1e1e1'"  class="cajatexto"  id="Tunombre"  title="<bean:message key="enviar.email.amigo.tu.nombre.tooltip"/>" type="text"/>
			</div>
		</div>
								
		<div class="limpiar"></div>
		
		<html:checkbox styleId="Enviarcorreo" styleClass="boton_check" name="form" property="enviarRemitente" value="true"/>												
		<label for="Enviarcorreo" class="lb_long" ><bean:message key="enviar.email.amigo.enviar.tu.correo"/></label>
		
		<div class="tu_comm">
			<label for="resumen" ><bean:message key="enviar.email.amigo.comentarios"/>:</label>
			<textarea name="resumen" rows="5" cols="20" onblur="this.style.backgroundColor='#e1e1e1'" style="width:60%" id="resumen"  title="<bean:message key="enviar.email.amigo.resumen.tooltip"/>">${form.resumen}</textarea>
		</div>

		<div class="limpiar"></div>
						
	</fieldset>							
	
	<!-- Normas de uso -->
	<p class="normas">
		<em ><bean:message key="enviar.email.amigo.normas.de.uso.titulo"/></em>
		<br />

		<span>
			<bean:message key="enviar.email.amigo.normas.de.uso.cuerpo2"/>
		</span>
		<br />
	</p>							


</div>
<!--  End of comment_body -->
</div>
<!-- End of formulario -->




<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->	

<!-- Start of send bubble -->
<div class="sendmail_send">
<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	<div class="db_bubble_content">

<input style="display: none;" class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key="enviar.email.amigo.boton.enviar"/>" />
	<input name="identificadorODE" value="${form.identificadorODE}" type="hidden">
	<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
	<input name="idioma" value="${form.idioma}" type="hidden">
	<input name="titulo" value="${form.titulo}" type="hidden">
	<input name="urlODE" value="${form.urlODE}" type="hidden">
	<input name="mostrarVuelta" value="${form.mostrarVuelta}" type="hidden">
	<input name="urlImagen" value="${form.urlImagen}" type="hidden">
</form>	
	
	<a href="javascript:document.forms['send'].submit();"><bean:message key="enviar.email.amigo.boton.enviar"/></a>

	</div>
</div></div></div></div>
</div>
<!-- End of send bubble -->


<!-- Start of cancel bubble -->
<div class="sendmail_cancel">
<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	<div class="db_bubble_content">


	<form name="cancel" method="post" action="<html:rewrite action="/EnviarMailCU/EnvioMailCancelar.do" />">		
		<input style="display: none;" class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="areaCurricular.cancelar.seleccion"/>" />
		<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
		<input name="identificadorODE" value="${form.identificadorODE}" type="hidden">
		<input name="idioma" value="${form.idioma}" type="hidden">
		<input name="idiomaBuscador" value="${form.idiomaBuscador}" type="hidden">
		<input name="mostrarVuelta" value="${form.mostrarVuelta}" type="hidden">
	
	<!-- Fin Botones  -->
	<!-- Fin Botones  -->
	</form>

	<a href="javascript:document.forms['cancel'].submit();"><bean:message key="areaCurricular.cancelar.seleccion"/></a>

	</div>
</div></div></div></div>
</div>
<!-- End of send bubble -->


<!-- Clear outer bubble around buttons -->
<div style="clear:both;"></div>

</div></div></div></div>
<!-- End of bubble -->


</div>
<!-- Fin plantilla contenido  -->

</tiles:put>
</tiles:insert>
