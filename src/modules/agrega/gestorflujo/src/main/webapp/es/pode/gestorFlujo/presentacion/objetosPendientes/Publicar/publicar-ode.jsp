<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>

<tiles:insert definition="layout-administrador">

	<tiles:put name="title" type="string">
		<bean:message key="title.Admnistracion" />
	</tiles:put>
	<tiles:put name="body" type="string">
		<!--************************          Inicio plantilla contenido       ****************************-->
		<div class="plantilla_contenido"><jsp:include
			page="/layout/messages.jsp" flush="true" /> 

		<h2><bean:message key="gestorFlujo.mostrarOdes.publicar" /></h2>

		
		<form name="formulario" method="post" action ="<rewrite:rewrite url="${initParam.url_publicar_ode_aceptar }"/>" />
		
			<!--  INICIO GLOBO GRIS   -->
		<!--  INICIO GLOBO GRIS   --><!--  INICIO GLOBO GRIS   -->
		<div class="globo_gris">
		<div class="globo_gris_01">
		<div class="globo_gris_02">
		<div class="globo_gris_03">
		
		<!--  INICIO CAJA DE FORMULARIO   -->
		<div id="formulario_02"><!--  INICIO GLOBO Blanco   --> <!--  INICIO GLOBO Blanco   -->
		<div class="globo_blanco">
		<div class="globo_blanco_01">
		<div class="globo_blanco_02">

		<div class="globo_blanco_03">

		<p class="parrafo_comun"><bean:message key="gestorFlujo.publicar.licencia"/></p>

		<!--  INICIO CAPA TABLA PORTAPAPELES   --> <!--  INICIO CAPA TABLA PORTAPAPELES   -->
		
		<!--  ******************** LICENCIAS ***********************-->
		<div class="fila_de_tabla">
  			<div class="text"><input READONLY name="Tipo" value="${form.tipoLicencia}"  onblur="this.style.backgroundColor='#e1e1e1'" id="Tipo" type="text" title="<bean:message key="gestorFlujo.aplicar.tipo.licencia"/>"  />
  				
  			</div>
			<br class="oculto" />
		</div>
		<br />
		

				 <c:choose>  
				<c:when test="${fn:length(form.comunidadesMostrar) > 0}">				
				<label for="Ambito" style="white-space:nowrap"><bean:message key="gestorFlujo.agregarLicencia.ambito"/><br /><br /></label>			
				<div class="fila_de_tabla">
				<div class="text">
				<select id="Ambito" class="mul_ti" title="<bean:message key="gestorFlujo.aplicar.licencia"/>" name="Ambito" multiple="multiple">
				<logic:iterate id="comunidad" collection="${form.comunidadesMostrar}" indexId="indice">
				
					<c:if test="${indice % 2 == 0}">
						<option value="#">${comunidad }</option>
					</c:if>		
					<c:if test="${indice % 2 != 0}">
						<option value="#" option class="oscura">${comunidad }</option>
					</c:if>		

					
				</logic:iterate>
				</select>
				</div>
				<br class="oculto"/>
				</div>
				 </c:when>
				 <c:otherwise>
				 <label for="Ambito" style="white-space:nowrap"><bean:message key="gestorFlujo.agregarLicencia.ambito"/><br /><br /></label>				
				<div class="fila_de_tabla">
				<div class="text">
				<select id="Ambito" class="mul_ti" title="<bean:message key="gestorFlujo.aplicar.licencia"/>" name="Ambito" multiple="multiple">
				<option value="#"></option>			
				</select>
				</div>
				<br class="oculto"/>
				</div>
				 </c:otherwise>
				 </c:choose>  
				 
			
		
		<div id="botones_centrados">	
		<a id="b_descargar" href="<html:rewrite action="${initParam.url_publicar_ode_modificar}"/>"><bean:message key="gestorFlujo.agregarLicencia.anadir"/></a>
		</div>
			
		<!--  FIN CAPA TABLA PORTAPAPELES   --> <!--  FIN CAPA TABLA PORTAPAPELES   -->

		</div>

		</div>
		</div>
		</div>
		<!--  Fin GLOBO Blanco   --> <!--  Fin GLOBO Blanco   --></div>
		<!--  FIN CAJA DE FORMULARIO   -->
		
		
		<!--  INICIO CAJA DE FORMULARIO   -->
		<div id="formulario"><!--  INICIO GLOBO Blanco   --> <!--  INICIO GLOBO Blanco   -->
		<div class="globo_blanco">
		<div class="globo_blanco_01">
		<div class="globo_blanco_02">
		<div class="globo_blanco_03">

		<p class="parrafo_comun"><bean:message
			key="gestorFlujo.proponer.comentarios" /></p>
		<div class="fila_de_tabla">
		<div class="text" ><label
			for="publicar"><span class="oculto"><bean:message key="gestorFlujo.mostrarOdes.publicar" /></span>
			</label>
			<textarea name="comentarios" rows="5" cols="40" class="ta_minimo_ancho"
			onfocus="limpiarTexto(this)" onblur="this.style.backgroundColor='#e1e1e1'" 
			id="proponer" title="<bean:message key="gestorFlujo.proponer.introduzca" />">${form.comentarios}</textarea>
		</div>
		<br class="oculto" />
		</div>
		<br />
		<!-- --></div>
		</div>
		</div>
		</div>
		<!--  Fin GLOBO Blanco   --> <!--  Fin GLOBO Blanco   --></div>
		<!--  FIN CAJA DE FORMULARIO   --> </div>
		</div>
		</div>
		</div>

		<!--  FIN GLOBO GRIS   --> <!--  FIN GLOBO GRIS   --> <!-- Inicio Botones  -->
		<!-- Inicio Botones  --> 
		<input type="hidden" name="action" value="publicar"/>
		<input class="boton_125_de_2 tipo"
			type="submit" value="<bean:message key="gestorFlujo.aceptar"/>" />
			</form>
		<form
			action="<html:rewrite action="${initParam.url_publicar_ode_cancelar}"/>"
			method="post">
			<input class="boton_125_de_2_izq tipo"
			type="submit" value="<bean:message key="gestorFlujo.cancelar"/>" /></form>
		<!-- Fin Botones  --></div>


		<!-- Fin plantilla CONTENIDO -->
	</tiles:put>

</tiles:insert>
