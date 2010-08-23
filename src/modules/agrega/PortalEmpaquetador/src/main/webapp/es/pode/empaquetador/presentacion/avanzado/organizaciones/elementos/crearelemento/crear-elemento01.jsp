<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<bean:define id="urlArchivos"><html:rewrite action="/GestorArchivos/GestorArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/GestorRecursos/GestorRecursos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/GestorElementos/GestorElementos"/></bean:define>
<bean:define id="selected" value="organizaciones"/>
<emp:layout selected="${selected}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
  <div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>
<bean:define id="crear"><bean:message key="portal_empaquetado_crearElemento.paso1.crear"/></bean:define>
<bean:define id="modificar"><bean:message key="portal_empaquetado_crearElemento.paso1.modificar"/></bean:define>
<h2><bean:message key="portal_empaquetado_crearElemento.paso1" arg0="${crearElementoSession.esModificar ? modificar : crear}"/></h2>
<form id="crearElementoCrearElemento01SubmitForm" method="post" action="<html:rewrite action="/CrearElemento/CrearElemento01Submit"/>" enctype="multipart/form-data">
<p class="parrafo_comun" id="separacion2"><bean:message key="portal_empaquetado_crearElemento.paso1.introducirNombre"/>:</p>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
			 <div class="fila_de_tabla">
  						<div class="text" style="text-align:center"><label for="nombreElemento"><span class="oculto"></span></label><input name="title" class="nombreElemento" value="${fn:escapeXml(form.title)}"  onblur="this.style.backgroundColor='#e1e1e1'" id="nombreElemento" type="text" title="Introduzca Nombre de Elemento "  /></div>
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
<p class="parrafo_comun" id="separacion3"><bean:message key="presentacion.avanzado.elementos.crear.tipo"/>:</p>

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">

			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario_02" >
			
			 <div class="fila_de_tabla">
  				<div class="text ft_lateral">
  				<html:radio styleClass="boton_radio" property="referenciado" value="Ninguno" name="form" styleId="Ninguno" />
  					<label for="Ninguno" class="alineada"><bean:message key="portal_empaquetado_crearElemento.paso1.ninguno"/></label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>

			 <div class="fila_de_tabla">
  				<div class="text ft_lateral">
  					<html:radio property="referenciado" styleClass="boton_radio" value="Recurso" name="form" styleId="Recurso" />
  					<label for="Recurso" class="alineada"><bean:message key="portal_empaquetado_crearElemento.paso1.tipoRecurso"/></label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>

				<!--     -->
			<div class="fila_de_tabla">
  				<div class="text ft_lateral">
  					<html:radio property="referenciado" styleClass="boton_radio" value="Submanifiesto" name="form" styleId="Submanifiesto" />
  					<label for="Submanifiesto"  class="alineada2"><bean:message key="portal_empaquetado_crearElemento.paso1.tipoSub-Manifiesto"/></label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->

			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->


<p class="parrafo_comun" id="separacion3"><bean:message key="portal_empaquetado_crearElemento.paso1.estado"/>:</p>

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">

			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
		 	<div id="formulario_03" >

			<div class="fila_de_tabla">
  				<div class="text ft_lateral">
  					<html:radio property="isVisible" styleClass="boton_radio" value="true" name="form" styleId="true" />
  					<label for="true"  class="alineada2">Visible</label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
			</div>
			<div class="fila_de_tabla">
  				<div class="text ft_lateral">
  					<html:radio property="isVisible" styleClass="boton_radio" value="false" name="form" styleId="false" />
  					<label for="false"  class="alineada2">No Visible</label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
			</div>
	        </div>
            </div>
        </div>
    </div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->
<p class="parrafo_comun" id="separacion"><bean:message key="portal_empaquetado_crearElemento.paso1.avanzadas"/>:</p>

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" style="margin-top:10px">
    <div class="globo_gris_01">

        <div class="globo_gris_02">
            <div class="globo_gris_03">
            <div class="formu" >
    
				

				<div class="fila_de_tabla fdt_marginada">
  						<div class="contenedor_izquierda">
	  						<label for="nombreElemento"><span>TimeLimitAction:</span></label>
  						</div>	
  						<div class="contenedor_derecha">
                        <div class="text">  							
				  		<html:select style="width:280px;" name="form" property="timeLimitAction" value="${fn:escapeXml(form.timeLimitAction)}" titleKey="portal_empaquetado_crearElemento.paso1.title.timeLimitAction">
							<c:forEach  items="${form.timeLimit}" var="valor">
                        		<html:option value="${ valor}">${valor}</html:option>
    		            	</c:forEach>
						</html:select>
						</div>
						</div>	
						<div class="linea_separadora"></div>			
					<br class="oculto" />
				</div>
				<div class="fila_de_tabla fdt_marginada">
  						<div class="contenedor_izquierda">
  							<label for="nombreElemento"><span>DataFromLMS:</span></label>
  						</div>
  						<div class="contenedor_derecha">
                        <div class="text">
  						<input name="dataFromLMS" class="input_medio" style="width:280px;" value="${fn:escapeXml(form.dataFromLMS)}"  onblur="this.style.backgroundColor='#e1e1e1'" id="nombreElemento" type="text" title="<bean:message key="portal_empaquetado_crearElemento.paso1.title.dataFromLMS"/>"  />
  						</div></div>
  						<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>
				<div class="fila_de_tabla fdt_marginada">
  						<div class="contenedor_izquierda">
	  						<label for="nombreElemento"><span>CompletionThreshold:</span></label>
  						</div>
  						<div class="contenedor_derecha">
                        <div class="text">		
  						<input name="completionThreshold" class="input_medio" style="width:80px;" value="${fn:escapeXml(form.completionThreshold)}"  onblur="this.style.backgroundColor='#e1e1e1'" id="nombreElemento" type="text" title="<bean:message key="portal_empaquetado_crearElemento.paso1.title.completionThreshold"/>"  />
  						</div></div>
  						<div class="linea_separadora"></div>  						
					<br class="oculto" />
				</div>

				<!--  INICIO TABLA  -->
				<div class="caja_de_tabla_invisible fdt_marginada" >
				<table cellspacing="0" cellpadding="0" border="0"  width="70%"  summary="">
				<tr>
				    <td rowspan="4" valign="top"><label for="com02">Presentation:</label></td>
				    <fmt:formatNumber var="indice" value="0" type="number" />
					<logic:iterate id="hide" name="form" property="presentation" indexId="i">
							<td style="padding-left:10px">
								<html:multibox styleClass="check" property="selectPresentation" name="form"  styleId="selectPresentation" value="${hide}" titleKey="portal_empaquetado_crearElemento.paso1.title.presentation"/>
							</td>
							<td class="td_largo_09"  valign="top">
								<label for="selectPresentation">${hide}</label>
							</td>	
							<c:if test="${indice mod 2!=0}"></tr><tr> </c:if>
							<c:set var="indice" value="${indice+1}" />
				    </logic:iterate>
				    </tr>
				</tr>
				
				</table>
				</div>
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  Fin TABLA   -->
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
<input class="boton_125_de_2"  type="submit"  name="action"  value="<bean:message key='portal_empaquetado_crearElemento.continuar'/>" />
<input class="boton_125_de_2_izq"  type="submit"  name="action"  value="<bean:message key='portal_empaquetado_crearElemento.cancelar'/>" />
</fieldset>

<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
<script type="text/javascript">
  document.forms[0].title.focus();
</script>
</div>
</emp:layout>