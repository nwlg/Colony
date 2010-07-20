<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<tiles:insert definition="layout-sinlateral">

    <tiles:put name="title" type="string">
        <bean:message key="title.comun.comentarios"/>
    </tiles:put>

    <tiles:put name="body" type="string">
	<%@ include file="/taglib-imports.jspf" %>
					
				<!-- Inicio plantilla contenido  -->
				<div class="plantilla_contenido">
					<jsp:include page="/layout/messages.jsp" flush="true" />
					<h2><bean:message key="introducir.comentarios.ode.advertencia.eliminar.titulo.cabecera"/></h2>
						<form method="post" action="<html:rewrite action="/IntroducirComentariosCU/AdvertenciaEliminarAnalizaPulsacion"/>" id="advertenciaEliminarAnalizaPulsacionForm" >	
							<!--  INICIO GLOBO GRIS   -->
							<!--  INICIO GLOBO GRIS   -->
							<div class="globo_gris" >
								<div class="globo_gris_01">
									<div class="globo_gris_02">
										<div class="globo_gris_03">
										<!--  INICIO CAJA DE FORMULARIO   -->
										<div id="formulario" class="ali_c">
							
										<br />
										<p ><bean:message key="introducir.comentarios.ode.advertencia.eliminar.texto"/></p>
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
								<input class="boton_125_de_2_izq"  type="submit" name="action" value="<bean:message key="introducir.comentarios.ode.advertencia.eliminar.boton.cancelar"/>" />
								<input class="boton_125_de_2"  type="submit" name="action" value="<bean:message key="introducir.comentarios.ode.advertencia.eliminar.boton.aceptar"/>" />
								<input type="hidden" name="idODE" value="${form.idODE}"/>	
								<input type="hidden" name="tituloODE" value="${form.tituloODE}"/>
								<input type="hidden" name="imagen" value="${form.imagen}"/>	
								<input type="hidden" name="idiomaODE" value="${form.idiomaODE}"/>
								<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>	
								<input type="hidden" name="mostrarVuelta" value="${form.mostrarVuelta}"/>	
								<input type="hidden" name="busquedaSimpleAvanzada" value="${form.busquedaSimpleAvanzada}"/>	
								<input type="hidden" name="urlODE" value="${form.urlODE}"/>	
								<input type="hidden" name="valoracion" value="${form.valoracion}"/>																																																		
							</fieldset>
							<!-- Fin Botones  -->
							<!-- Fin Botones  -->
						</form>
					</div>
			<!-- Fin plantilla contenido  -->
			<!-- Fin plantilla contenido  -->				
		</tiles:put>
</tiles:insert>

