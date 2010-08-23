<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<tiles:insert definition="${sessionScope.offline == true ? 'layout-offline' : 'layout-administrador'}">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>
<tiles:put name="body" type="string">
<!-- Inicio plantilla contenido  -->
	<div class="plantilla_contenido">
		<%@ include file="/layout/messages.jsp" %>	
		<h2><bean:message key="importarModificacion.titulo" /></h2>
		<form method="post" 
			action="<html:rewrite action="/ImportarModificacion/ImportarModificacionImportar"/>" 
			id=""
			 enctype="multipart/form-data">
			 <c:choose>
			 	<c:when test="${sessionScope.offline}">
			 		<bean:define id="helpURL" value="/help/Manual_de_Usuario.pdf"/>
			 	</c:when>
			 	<c:otherwise>
			 		<bean:define id="helpURL" value="${requestScope.HELP_URL }/Formato_para_configuraci%C3%B3n_de_tareas"/>
			 	</c:otherwise>
			 </c:choose>	
			<p class="parrafo_comun" id="separacion2"><bean:message key="importarModificacion.explicacion" />&nbsp;<a href="${helpURL }" target="_blank"><bean:message key="importarModificacion.link.ayuda"/></a></p>
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
			  							<label class="oculto" for="ficheroXML"><bean:message key="importarModificacion.label"/></label>
			  							<html:file name="form" property="fichero" onfocus="limpiarTexto(this)" value="&nbsp;"  onblur="this.style.backgroundColor='#e1e1e1'" styleId="ficheroXML" styleClass="selimagen0" titleKey="importarModificacion.label"/>
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
			
			 
				
				<input class="boton_125_de_2_izq"  type="submit" name="action" value="<bean:message key="comun.cancelar"/>" /> 
				<!-- Cargando  -->
				<div id="capa1"><em><bean:message key="comunes.cargando"/></em><img src="<rewrite:rewrite url="static/img/loading_01.gif"/>" alt="<bean:message key="comunes.cargando"/>" /></div>
				<input class="boton_125_de_2" onclick="cambio('capa1')" onkeypress="cambio('capa1')" type="submit" name="action" value="<bean:message key="comun.aceptar"/>" />
			</fieldset>
			<!-- Fin Botones  -->			
			<!-- Fin Botones  -->
		</form>		
	</div>
</tiles:put>
</tiles:insert>