<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib uri="/WEB-INF/tlds/tags-modificadorWeb.tld"  prefix="mod" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<tiles:insert definition="${sessionScope.offline == true ? 'layout-offline' : 'layout-administrador'}">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
<div class="plantilla_contenido">

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2>${configurarModificacionSession.nombre}</h2>
<form id="configurarModificacionConfigurarModificacionSelectActionForm" action="<html:rewrite action="/ConfigurarModificacion/ConfigurarModificacionSelectAction"/>"  method="post">
<c:if test="${empty form.cambios or empty form.objetos}">
<p class="parrafo_comun" id="separacion2"><bean:message key="configurarModificacion.explicacion"/></p>
</c:if>

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris">
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<logic:empty name="form" property="cambios">
			<div id="formulario" >

			<h3 class="h3_generico"><bean:message key="configurarModificacion.cambios"/></h3>
			<!--  INICIO CAPA TABLA Añadir archivos   -->
			<!--  INICIO CAPA TABLA Añadir archivos   -->
				<div class="caja_tabla bordeada">
					<table  style="border:1;width:100%;" class="generica_02 sin_clear" cellpadding="0" cellspacing="0" summary="<bean:message key="configurarModificacion.TablaCambios"/>">
						<caption><strong><bean:message key="configurarModificacion.TablaCambios"/></strong></caption>
						<tr class="tr_beige"><td valign="top" class="td_larga acentrado"><bean:message key="configurarModificacion.cambios.tabla.vacia"/></td></tr>
					</table>
				</div>
				<fieldset class="tipo ft_centrada">
					<input class="boton_125" name="action" type="submit"  value="<bean:message key="configurarModificacion.cambios.crear"/>" />
				</fieldset>
				<br/>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
			</logic:empty>
			<logic:notEmpty name="form" property="cambios">
			<div id="formulario" >
			<h3 class="h3_generico"><bean:message key="configurarModificacion.cambios"/></h3>
				<div class="caja_tabla bordeada" >
				<table border="1" class="generica_02 sin_clear" cellpadding="0" cellspacing="0" width="100%" summary="<bean:message key="configurarModificacion.TablaCambios"/>">
				<caption><strong><bean:message key="configurarModificacion.TablaCambios"/></strong></caption>
				<c:set var="contador" value="true"/>
				<c:forEach items="${form.cambios}" var="cambio" varStatus="status">
					<logic:equal name="contador" value="true">
						<tr class="tr_gris">
					</logic:equal>
					<logic:equal name="contador" value="false">
						<tr class="tr_blanco">
					</logic:equal>
					<c:set var="contador" value="${!contador}"/>
						<td valign="top"  class="sin_b">
						<label for="cambio${status.index }" class="oculto" ><bean:message key="configurarModificacion.cambios.checkbox"/> </label>
						<input type="checkbox" id="cambio${status.index }" name="posiciones" value="${status.index }"/></td>					
						<td valign="top" class="td_larg"><mod:cambios cambio="${cambio}"/></td>
						<td valign="top"><span class="oculto">-</span><a href="<html:rewrite action="/ConfigurarModificacion/ConfigurarModificacionModificar"/>?&amp;posicion=${status.index }"><bean:message key="configurarModificacion.cambios.modificar"/></a></td>
						</tr>
				</c:forEach>
				</table>
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
				<fieldset class="tipo_interior_04 ft_centrada">
					<input class="boton_125_de_2_izq"  name="action" type="submit"  value="<bean:message key="configurarModificacion.cambios.crear"/>" />
					<input class="boton_125_de_2"  name="action" type="submit"  value="<bean:message key="configurarModificacion.cambios.eliminar"/>" />
				</fieldset>
				<br/>
			</logic:notEmpty>
			
			
			<!--  FIN CAPA TABLA Añadir archivos   -->
			<!--  FIN CAPA TABLA Añadir archivos   -->
			</div>
			
		</div>
	</div>
</div>
</form>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<form id="configurarModificacionConfigurarModificacionSubmitObjetosForm" action="<html:rewrite action="/ConfigurarModificacion/ConfigurarModificacionSubmitObjetos"/>">
<div class="globo_gris" id="conmargen">
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAPA TABLA Añadir archivos   -->
			<!--  INICIO CAPA TABLA Añadir archivos   -->
			<logic:empty name="form" property="objetos">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario_02" >
			<h3 class="h3_generico"><bean:message key="configurarModificacion.objetos"/></h3>
				<div class="caja_tabla bordeada"  >
				<table border="1" class="generica_02 sin_clear" cellpadding="0" cellspacing="0" width="100%" summary="<bean:message key="configurarModificacion.tablaObjetos"/>">
				<caption><strong><bean:message key="configurarModificacion.tablaObjetos"/></strong></caption>
				<tr class="tr_beige">
					<td valign="top" class="td_larga acentrado" ><bean:message key="configurarModificacion.objetos.tabla.vacia"/></td>
				</tr>
				</table>
				</div>
				<fieldset class="tipo ft_centrada">
					<input class="boton_125" name="action" type="submit"  value="<bean:message key="configurarModificacion.objetos.crear"/>"  />
				</fieldset>
				<br/>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
			</logic:empty>
			<logic:notEmpty name="form" property="objetos">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario_02" >
			<h3 class="h3_generico"><bean:message key="configurarModificacion.objetos"/></h3>
 			<div class="caja_tabla bordeada"  >
			<bean:define id="summary"><bean:message key="configurarModificacion.tablaObjetos"/></bean:define>
			<display:table name="${form.objetos}" requestURI=""
					export="false" id="fila" class="generica_02 sin_clear" 
					style="border:1;width:100%;" cellpadding="0" cellspacing="0" 
					summary="${summary}" sort="list" pagesize="8">
						<display:setProperty name="css.tr.odd" value="tr_gris"/>
						<display:setProperty name="css.tr.even" value="tr_blanco"/>
						<display:setProperty name="basic.show.header" value="false"/>	
						<!--  ******************** COLUMNA DE CHECKBOX ***********************-->
						<display:column style="valign:top;" class="sin_b">
							<label for="${fn:replace(fila.path,"/", ".")}" class="oculto" ><bean:message key="configurarModificacion.objetos.checkbox"/> ${fila.path } </label>
							<input id="${fn:replace(fila.path,"/", ".")}" type="checkbox" name="pathRowSelectionAsArray" value="${fila.path }" title='<bean:message key="configurarModificacion.objetos.checkbox"/> ${fila.path }'/>
						</display:column>
						<!--  ******************** COLUMNA QUE MUESTRA LA TAREA **********************-->
						<display:column style="valign:top;" class="td_largo">
							<c:if test="${empty fila.titulo}">
								${fila.path}
							</c:if>
							<c:if test="${!empty fila.titulo}">
								${fila.titulo}
							</c:if>

            			</display:column>
			</display:table>
			<!--  FIN CAJA DE FORMULARIO   -->
			</div>
			<br class="oculto" />
			<fieldset class="tipo_interior_02">
				<input class="boton_125_de_2" name="action" type="submit"  value="<bean:message key="configurarModificacion.objetos.eliminar"/>" />
				<br class="oculto" /><br class="oculto" />
				<input class="boton_125_de_2_izq bot_mar_der" name="action" type="submit"  value="<bean:message key="configurarModificacion.objetos.crear"/>"/>
			</fieldset>
			</logic:notEmpty>
			</div>
		</div>
	</div>
</div>
</form>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<form id="configurarModificacionConfigurarModificacionGuardarForm" action="<html:rewrite action="/ConfigurarModificacion/ConfigurarModificacionGuardar"/>">

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->

<fieldset class="tipo ft_centrada">
	<c:if test="${!empty form.cambios and !empty form.objetos}">
		<input class="boton_125_de_2" name="action" type="submit"  value="<bean:message key="configurarModificacion.objetos.guardar"/>" />
	</c:if>
		<input class="boton_125_de_2_izq"  type="submit" name="action" value="<bean:message key="configurarModificacion.objetos.volver"/>" />
		<input class="boton_125"  type="submit" name="action" value="<bean:message key="configurarModificacion.objetos.cancelar"/>" />

</fieldset>
</form>

<!-- Fin Botones  -->
<!-- Fin Botones  -->
</div>

</tiles:put>

</tiles:insert>
