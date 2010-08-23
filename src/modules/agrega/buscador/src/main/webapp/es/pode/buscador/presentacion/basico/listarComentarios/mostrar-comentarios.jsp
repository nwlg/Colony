<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/valoracion.tld" prefix="estrellas" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<tiles:insert definition="layout-sinlateral">

    <tiles:put name="title" type="string">
        <bean:message key="title.comun.comentarios"/>
    </tiles:put>

    <tiles:put name="body" type="string">
	<%@ include file="/taglib-imports.jspf" %>						
	<!-- Inicio plantilla contenido  -->
	<div class="plantilla_contenido" id="ventana_flotante">
	<jsp:include page="/layout/messages.jsp" flush="true" />			

			
<!-- Start of top bubble -->
<div class="comment_header">
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">						
	<!--  INICIO CAJA DE FORMULARIO   -->
	<div class="comment_header" >										
	<logic:notEmpty name="form" property="imagen">
		<a href="#" class="imagen_tab" id="imt"><img  src="${form.imagen}" alt="Imagen 02"/></a>
	</logic:notEmpty>
	<logic:empty name="form" property="imagen">
		<img  src="${form.imagen}" alt="Imagen 02" class="imagen_tab" id="imt" />
	</logic:empty>	
								
	<div class="comment_title">
		<span ><h2><bean:message key="introducir.comentarios.ode.titulo.sin.asteriscos"/>:</h2><h2><b>${form.tituloODE}</b></h2>&nbsp;</span>
	</div>
	<br /><br /><br /><br />
	</div>
	<!--  FIN CAJA DE FORMULARIO   -->
	<br class="limpiar" />

<!-- End of bubble -->
</div></div></div></div>		
						
<!-- Start of comments bubble -->
<div class="comment_header">
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">	

	<!--  INICIO CAJA DE FORMULARIO   -->
	<div class="comment_body" >				
												<h3 class="grande_h2"><bean:message key="introducir.comentarios.ode.comentarios"/></h3>							<logic:notEmpty name="form" property="comentarios">	
			<logic:iterate name="form" property="comentarios" id="comentario">						
														<div class="comment_list">
			<div>
															<label for="Comen01" class="etiq_invisible" ><bean:message key="introducir.comentarios.ode.seleccione"/></label>									<em>${comentario.usuario}</em>								<strong><fmt:formatDate value="${comentario.fecha}" pattern="dd/MM/yyyy HH:mm:ss"/>&nbsp;</strong>										<p>${comentario.comentario}<br /></p>
			</div>
			</div>
														</logic:iterate>
		</logic:notEmpty>

		<br /><br />
										
	</div>
	<!--  FIN CAJA DE FORMULARIO   -->

<!-- End of bubble -->
</div></div></div></div>	
				
				
<!-- Inicio Botones  -->
<!-- Inicio Botones  -->

<!-- Start of back bubble -->
<div class="comment_back">
<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	<div class="db_bubble_content">

<logic:equal name="form" property="mostrarVuelta" value="true">
	<logic:equal name="form" property="busquedaSimpleAvanzada" value="BUSQUEDA_ARBOL">
		<form name="back" action="<html:rewrite action="/DetallarODECU/DetallarODECU.do"/>?identificadorODE=${form.idODE}&amp;idioma=${form.idiomaODE}&amp;mostrarVuelta=${form.mostrarVuelta}&amp;areaCurricularBusqueda=" method="post">
			<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
			<input style="display:none;" class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="descargar.boton.volver"/>"/>
		</form>
	</logic:equal>
	<logic:notEqual name="form" property="busquedaSimpleAvanzada" value="BUSQUEDA_ARBOL">
		<form name="back" action="<html:rewrite action="/DetallarODECU/DetallarODECU.do"/>?identificadorODE=${form.idODE}&amp;idioma=${form.idiomaODE}&amp;mostrarVuelta=${form.mostrarVuelta}" method="post">
			<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
			<input style="display:none;" class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="descargar.boton.volver"/>"/>
		</form>
	</logic:notEqual>
</logic:equal>
<logic:notEqual name="form" property="mostrarVuelta" value="true">
	<form name="back" action="<html:rewrite action="/DetallarODECU/DetallarODECU.do"/>?identificadorODE=${form.idODE}&amp;idioma=${form.idiomaODE}&amp;mostrarVuelta=${form.mostrarVuelta}" method="post">
		<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
		<input style="display:none;" class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="descargar.boton.volver"/>"/>
	</form>
</logic:notEqual>

	<a href="javascript:document.forms['back'].submit();"><bean:message key="descargar.boton.volver"/></a>
	</div>

</div></div></div></div>

<!-- Fin Botones  -->							
			
</div>					
<!-- Fin plantilla contenido  -->	

	</tiles:put>
</tiles:insert>
	
	
		
