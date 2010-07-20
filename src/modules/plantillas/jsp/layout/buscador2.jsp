<%@ include file="/taglib-imports.jspf"%>
<%@ taglib uri="/WEB-INF/tags/serverProperties.tld" prefix="server" %>
<!-- BUSCADOR  -->
<div id="buscador2">
<hr />
<!--  <a href="#" class="avanzado"><bean:message key="buscador.avanzado" /></a>-->
 <strong class="oculto"><bean:message key="buscador.buscador" /></strong> 
<br class="oculto" />
<br class="oculto" />
<form method="post" action="/${initParam.url_buscar }" >
<fieldset>

<bean:define id="i18nValue"><bean:message key="modificar.noticia.formulario.SeleccioneIdioma"/></bean:define>

<c:choose>

<c:when test="${!empty form.idiomaBuscadorBackingList}">
   <html:select name="form" property="idiomaBuscador" styleId="Idioma" title="${i18nValue }" styleClass="caja_buscador_selector">
     <html:optionsCollection name="form" property="idiomaBuscadorBackingList" label="label" value="value"/>
   </html:select>
</c:when>

<c:otherwise>
    <html:select name="form" property="idiomaBuscador" styleId="Idioma" title="${i18nValue }"/>
</c:otherwise>

</c:choose>
<input type="submit" alt="<bean:message key="buscador.boton.buscar.alt"/>"
	class="buscar" value=" Buscar" name="buscar" /><br />
<input type="radio" id="activar_busqueda_red" checked="checked"
	class="botonradio" value="si" name="activar" /><label
	for="activar_busqueda_red"><bean:message
	key="buscador.radio.buscar.en.red" /></label><input type="radio"
	class="botonradio" value="no" id="activar_busqueda_local"
	name="activar" /><label for="activar_busqueda_local"><bean:message
	key="buscador.radio.buscar.en.local" /><server:serverProperties property="ccaa"/></label>
</fieldset>
</form>
<br class="oculto" />

<hr />
<!-- FIN BUSCADOR  -->

<br class="oculto" />
<a href="/${initParam.url_portada }" title="<bean:message key="buscador.pagina.inicio"/>"
	id="logo"><span><bean:message key="buscador.pagina.inicio" /></span></a>
<br class="oculto" />
</div>

