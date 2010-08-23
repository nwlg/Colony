<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<bean:define id="urlArchivos"><html:rewrite action="/GestorArchivos/GestorArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/GestorRecursos/GestorRecusos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/GestorRecursos/GestorRecursos"/></bean:define>
<bean:define id="selected" value="recursos"/>
<emp:layout selected="${selected}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
	<!-- Inicio plantilla contenido  -->
	<div class="plantilla_contenido">
		<%@ include file="/layout/messages.jsp" %>	
		<h2><bean:message key="portalempaquetado.avanzado.recursos.importar.titulo" /></h2>
		<form method="post" 
			action="<html:rewrite action="/ImportarRecursos/LocalAceptar"/>" 
			id="importarRecursosLocalAceptarForm"
			 enctype="multipart/form-data">	
			<p class="parrafo_comun" id="separacion2"><bean:message key="portalempaquetado.avanzado.recursos.exportar.mensaje" /></p>
			<!--  INICIO GLOBO GRIS   -->
			<!--  INICIO GLOBO GRIS   -->
			<div class="globo_gris" >
				<div class="globo_gris_01">
					<div class="globo_gris_02">
						<div class="globo_gris_03">
							<!--  INICIO CAJA DE FORMULARIO   -->
							<div id="formulario" >				
								<!--  INICIO ITEMS DE FORMULARIO   -->			
								<div class="fila_de_tabla ft_centrada">
			  						<div class="text">
			  							<label class="oculto" for="SelRecurso01"><bean:message key="portalempaquetado.avanzado.recursos.importar.tooltip"/></label>
			  							<html:file name="form" property="fichero" onfocus="limpiarTexto(this)" value="&nbsp;"  onblur="this.style.backgroundColor='#e1e1e1'" styleId="SelRecurso01" styleClass="selimagen0" titleKey="portalempaquetado.avanzado.recursos.importar.tooltip"/>
			  						</div>
										<div class="linea_separadora"></div>
										<br class="oculto" />
								</div>
								<!-- -->
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
				<!-- Cargando  -->
				<input class="boton_125_de_2_izq"  type="submit" name="action" 
						value="<bean:message key="portalempaquetado.avanzado.recursos.cancelar"/>" />
				<div id="capa1"><em><bean:message key="comunes.cargando"/></em><img src="<rewrite:rewrite url="static/img/loading_01.gif"/>" alt="<bean:message key="comunes.cargando"/>" /></div>
				<input class="boton_125_de_2" onclick="cambio('capa1')" onkeypress="cambio('capa1')" type="submit" name="action" value="<bean:message key="portalempaquetado.avanzado.recursos.aceptar"/>" /> 
			</fieldset>
			<!-- Fin Botones  -->			
			<!-- Fin Botones  -->
		</form>		
	</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
</emp:layout>
