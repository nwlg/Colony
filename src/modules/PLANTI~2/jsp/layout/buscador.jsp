<%@ include file="/taglib-imports.jspf"%>
<tiles:importAttribute name="idiomasBuscablesPlataforma" scope="page"/>
<tiles:importAttribute name="localizacionBusqueda" scope="page"/>
<tiles:importAttribute name="existenNodosSQI" scope="page"/>
<%@ taglib uri="/WEB-INF/tags/serverProperties.tld" prefix="server" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<div id="buscador">
<hr />
<div id="nuevo_buscador">
<a href="<rewrite:rewrite url="${initParam.url_formularioAvanzado}"/>" class="avanzado"><bean:message key="buscador.avanzado" /></a>
<strong class="oculto"><bean:message key="buscador.buscador" /></strong>
<br class="oculto" />
<br class="oculto" />
<form method="get" action="<rewrite:rewrite url="${initParam.url_buscador}"/>">
<fieldset>
  <label class="oculto" for="buscadorGeneral"><bean:message	key="buscador.buscador" />:&nbsp;</label> 
	<input type="text" id="buscadorGeneral" class="caja_buscador" value="" title="<bean:message key="buscador.buscador.alt"/>" name="buscadorGeneral" /><br class="oculto" />
<bean:define id="i18nValue"><bean:message key="buscador.idioma.por.defecto"/></bean:define>
<label class="oculto" for="Idioma"><bean:message key="buscador.idioma.del.contenido"/>:&nbsp;</label>
<c:choose>
<c:when test="${!empty idiomasBuscablesPlataforma}">
   <select name="idiomaBuscador" class="caja_buscador_selector" title="<bean:message key="buscador.idioma.del.contenido"/>" id="Idioma" >
		<option value="#" selected="selected" ><bean:message key="buscador.idioma.del.contenido"/></option>
		<logic:iterate name="idiomasBuscablesPlataforma" id="idiomaItem">
		     <option value="<bean:write name="idiomaItem" property="idLocalizacion"/>" ><bean:write name="idiomaItem" property="name"/></option>
		</logic:iterate>
   </select>
</c:when>
<c:otherwise>
	<select name="idiomaBuscador" class="caja_buscador_selector" title="${i18nValue }"/>" id="Idioma" >
		<option value="#" selected="selected" ><bean:message key="buscador.idioma.del.contenido"/></option>
   </select>
</c:otherwise>
</c:choose>
<input type="submit" alt="<bean:message key="buscador.boton.buscar.alt"/>" class="buscar" value="<bean:message key="buscador.buscador.boton"/>" name="buscar" /><br />
<div>	
	<label class="lb_primera"><bean:message key="buscador.radio.buscar.en" /></label>
	<html:radio property="tipoBusqueda" onclick="document.getElementById('Idioma').disabled=false;" styleClass="botonradio" styleId="todo_agrega" name="localizacionBusqueda" value="01" />
	<label for="todo_agrega"><bean:message	key="buscador.radio.buscar.en.red" /></label>
	<html:radio property="tipoBusqueda" onclick="document.getElementById('Idioma').disabled=false;" styleClass="botonradio" styleId="comunidad" name="localizacionBusqueda" value="02" />
	<label for="comunidad"><server:serverProperties property="ccaa"/></label>
	<c:choose>
		<c:when test="${!empty existenNodosSQI}">
			<c:choose>
				<c:when test="${existenNodosSQI}">
					<html:radio property="tipoBusqueda" onclick="document.getElementById('Idioma').disabled=true;" styleClass="botonradio" styleId="todo_agrega" name="localizacionBusqueda" value="04" />
					<label for="todo_agrega"><bean:message	key="buscador.radio.buscar.en.otros" /></label>
				</c:when>
			</c:choose>
		</c:when>
	</c:choose>
</div>

</fieldset>
</form>
</div>
<br class="oculto" />
</div>
<hr />
<!-- FIN BUSCADOR  -->
<br class="oculto" />
<a href="<rewrite:rewrite url="${initParam.url_portada}"/>" title="<bean:message key="buscador.pagina.inicio"/>" id="logo"><span><bean:message key="buscador.pagina.inicio" /></span></a>
<br class="oculto" />
				