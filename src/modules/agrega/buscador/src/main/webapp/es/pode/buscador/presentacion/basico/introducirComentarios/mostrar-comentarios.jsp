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
				<div class="plantilla_contenido" >
					<jsp:include page="/layout/messages.jsp" flush="true" />
					<form method="post" action="<html:rewrite action="/IntroducirComentariosCU/MostrarComentariosEliminar"/>" >				
					
<!-- Start of top bubble -->
<div class="comment_header">
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">	


<!--  INICIO CAJA DE FORMULARIO   -->
<div class="comment_body">
	<div style="font-size: 80%;">

	<h3 class="grande_h2"><bean:message key="introducir.comentarios.ode.comentarios"/></h3>
	<a href="#<bean:message key="introducir.comentarios.ode.marca.enlece.interno"/>"><bean:message key="introducir.comentarios.ode.aniadir.comentarios"/></a>

	<logic:notEmpty name="form" property="comentarios">
		<logic:iterate name="form" property="comentarios" id="comentario">
			<div class="comment_list">
				<div>
					<label for="Comen01" class="etiq_invisible" ><bean:message key="introducir.comentarios.ode.seleccione"/></label>

					<logic:equal name="form" property="usuarioAdministrador" value="true">
																	<input type="checkbox" id="${comentario.id}" name="idRowSelectionAsArray" value="${comentario.id}" class="boton_check" />
					</logic:equal>

<%-- <em>${comentario.usuario}</em> --%>
					<strong><fmt:formatDate value="${comentario.fecha}" pattern="dd/MM/yyyy HH:mm:ss"/>&nbsp;</strong>

					<p>${comentario.comentario}<br /></p>
				</div>
			</div>
		</logic:iterate>
	</logic:notEmpty>

	</div>
	<!-- Put font size back -->

	<!-- Inicio Botones  -->
	<!-- Inicio Botones  -->
	<fieldset class="tipo ft_centrada">
		<logic:equal name="form" property="usuarioAdministrador" value="true">
			<logic:equal name="form" property="listaVacia" value="false">
				<input class="boton_125"  type="submit"  value="<bean:message key="introducir.comentarios.ode.eliminar"/>" />
				<input type="hidden" name="idODE" value="${form.idODE}"/>
				<input type="hidden" name="tituloODE" value="${form.tituloODE}"/>
				<input type="hidden" name="imagen" value="${form.imagen}"/>
				<input type="hidden" name="idiomaODE" value="${form.idiomaODE}"/>
				<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
				<input type="hidden" name="mostrarVuelta" value="${form.mostrarVuelta}"/>
				<input type="hidden" name="busquedaSimpleAvanzada" value="${form.busquedaSimpleAvanzada}"/>
				<input type="hidden" name="urlODE" value="${form.urlODE}"/>
				<input type="hidden" name="valoracion" value="${form.valoracion}"/>
			</logic:equal>
		</logic:equal>
	</fieldset>
	<!-- Fin Botones  -->
	<!-- Fin Botones  -->
	<br />
	<br />

</div>
<!--  FIN CAJA DE FORMULARIO   -->

</div>
<!-- End of content header -->

</div></div></div></div>	
<!-- End of top blue bubble -->


</form>		
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->				
				
				

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<form name="savecomment" method="post" action="<html:rewrite action="/IntroducirComentariosCU/MostrarComentariosInsertarComentario"/>" >				
<p class="parrafo_comun" id="separacion2"><bean:message key="introducir.comentarios.ode.texto.obligacion"/></p>														
<!-- Bottom bubble -->
<div class="comment_header">
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">	

<!--  INICIO CAJA DE FORMULARIO   -->
<div class="comment_list" >
	<div style="font-size: 80%;">

	<a name="<bean:message key="introducir.comentarios.ode.marca.enlece.interno"/>"></a>
	<h3 class="grande_h2"><bean:message key="introducir.comentarios.ode.aniadir.comentarios"/></h3>
	
	<div class="fila_de_tabla">
		<div class="text">
			<label for="comentario" ><bean:message key="introducir.comentarios.ode.comentario"/>:</label>
		</div>
	</div>

	<div class="text">
		<textarea name="comentario" rows="10" cols="40" class="ta_minimo_ancho" onblur="this.style.backgroundColor='#e1e1e1'" id="comentario"  title="<bean:message key="introducir.comentarios.ode.introduzca.comentario"/>" >${form.comentario}</textarea>
	</div>						

	</div>
	<!-- Put font size back -->

	<div class="fila_de_tabla">
		<div class="text" >
			<label for="conInaprop" class="oculto" ><bean:message key="introducir.comentarios.ode.inapropiado"/>:</label>
	
			<html:checkbox styleId="conInaprop" styleClass="boton_radio" name="form" property="conInaprop" value="true"/>										
			<span class="vert"><bean:message key="introducir.comentarios.ode.contenido.inapropiado"/></span>
		</div>
		<div class="linea_separadora"></div>
		<br class="oculto" />
	</div>								


				<!--  FIN GLOBO GRIS   -->
				<!--  FIN GLOBO GRIS   -->	
				
				<!-- Inicio Botones  -->
				<div class="comment_savecomment">
					<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">	
					<a href="javascript:document.forms['savecomment'].submit();">
					<div class="db_bubble_content"><bean:message key="introducir.comentarios.ode.guardar"/>
					</div>
					</a>
					
					</div></div></div></div>
				</div>

				<!-- Inicio Botones  -->					
				<input style="display:none;" class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key="introducir.comentarios.ode.guardar"/>"/>
					<input type="hidden" name="idODE" value="${form.idODE}"/>	
					<input type="hidden" name="tituloODE" value="${form.tituloODE}"/>	
					<input type="hidden" name="imagen" value="${form.imagen}"/>	
					<input type="hidden" name="idiomaODE" value="${form.idiomaODE}"/>
					<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>	
					<input type="hidden" name="mostrarVuelta" value="${form.mostrarVuelta}"/>	
					<input type="hidden" name="busquedaSimpleAvanzada" value="${form.busquedaSimpleAvanzada}"/>	
					<input type="hidden" name="urlODE" value="${form.urlODE}"/>	
					<input type="hidden" name="valoracion" value="${form.valoracion}"/>	
																																														
								
					</form>	
						<logic:equal name="form" property="mostrarVuelta" value="true">
							<logic:equal name="form" property="busquedaSimpleAvanzada" value="BUSQUEDA_ARBOL">
								<form name="back" action="<html:rewrite action="/DetallarODECU/DetallarODECU.do"/>?identificadorODE=${form.idODE}&amp;idioma=${form.idiomaODE}&amp;mostrarVuelta=${form.mostrarVuelta}&amp;areaCurricularBusqueda=" method="post">
									<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
									<input style="display:none;" class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="descargar.boton.volver"/>"/>
									<div class="comment_back">
										<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">	
										<a href="javascript:document.forms['back'].submit();">
										<div class="db_bubble_content"><bean:message key="descargar.boton.volver"/>
										</div>
										</a>

										</div></div></div></div>
									</div>
								</form>
							</logic:equal>
							<logic:notEqual name="form" property="busquedaSimpleAvanzada" value="BUSQUEDA_ARBOL">
								<form name="back" action="<html:rewrite action="/DetallarODECU/DetallarODECU.do"/>?identificadorODE=${form.idODE}&amp;idioma=${form.idiomaODE}&amp;mostrarVuelta=${form.mostrarVuelta}" method="post">
									<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
									<input style="display:none;" class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="descargar.boton.volver"/>"/>
									<div class="comment_back">
										<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">	
										<a href="javascript:document.forms['back'].submit();">
										<div class="db_bubble_content"><bean:message key="descargar.boton.volver"/>
										</div>
										</a>

										</div></div></div></div>
									</div>
								</form>
							</logic:notEqual>
						</logic:equal>
						<logic:notEqual name="form" property="mostrarVuelta" value="true">
							<form action="<html:rewrite action="/DetallarODECU/DetallarODECU.do"/>?identificadorODE=${form.idODE}&amp;idioma=${form.idiomaODE}&amp;mostrarVuelta=${form.mostrarVuelta}" method="post">
								<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
								<input style="display:none;" class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="descargar.boton.volver"/>"/>
								<div class="comment_back">
									<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">	
									<a href="javascript:document.forms['name'].submit();">
									<div class="db_bubble_content"><bean:message key="descargar.boton.volver"/>
									</div>
									</a>
								
									</div></div></div></div>
								</div>
							</form>
						</logic:notEqual>									
						<!-- Fin Botones  -->
						<!-- Fin Botones  -->

					<!-- Clear the bubble down past the buttons -->
					<div style="clear:both;"></div>
<!-- End of bubble -->
</div></div></div></div>	
<!-- End of bottom bubble -->

</div>
<!-- End of comment list -->

					
				</div>					

			<!-- Fin plantilla contenido  -->	
	</tiles:put>
</tiles:insert>
	
	
		
	
