<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado-verMetadatos">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/catalogadorAvanzado/categorias-form-vars.jspf" %>

<div class="plantilla_contenido">
<form method="post" action="<html:rewrite action="/CatalogadorAvanzado/CategoriasFormSubmit"/>" >

<div class="caja_tabla" >

<table border="1" class="administracion_noticias" cellpadding="0" cellspacing="0" width="100%" summary="<bean:message key="catalogadorAvanzado.Tabla"/>">
<caption><strong><bean:message key="catalogadorAvanzado.Tabla"/></strong></caption>
<c:set var="sesion" value="${catalogadorAvSession.MDSesion}"/> 

<tr class="tr_gris">
	<c:if test="${empty sesion.general }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.General"/></strong></td>
		<td valign="top"><span class="oculto">-</span><a><bean:message key="verAvanzado.ver"/></a></td>
	</c:if>
	<c:if test="${!empty sesion.general }"> 
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.General"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/VerMetadatos/CategoriasFormGeneral"><bean:message key="verAvanzado.ver"/></html:link></td>
	</c:if>
</tr>
<tr class="tr_blanco">
	<c:if test="${empty sesion.lifeCycle }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.CicloDeVida"/></strong></td>
		<td valign="top"><span class="oculto">-</span><a><bean:message key="verAvanzado.ver"/></a></td>
	</c:if>
	<c:if test="${!empty sesion.lifeCycle }">
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.CicloDeVida"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/VerMetadatos/CategoriasFormCicloDeVida"><bean:message key="verAvanzado.ver"/></html:link></td>
	</c:if> 
</tr>
<tr class="tr_gris">
	<c:if test="${empty sesion.metaMetadata }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.MetaMetadatos"/></strong></td>
		<td valign="top"><span class="oculto">-</span><a><bean:message key="verAvanzado.ver"/></a></td>
	</c:if>
	<c:if test="${!empty sesion.metaMetadata }">
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.MetaMetadatos"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/VerMetadatos/CategoriasFormMetaMetadatos"><bean:message key="verAvanzado.ver"/></html:link></td>
	</c:if> 
</tr>
<tr class="tr_blanco">
	<c:if test="${empty sesion.technical }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.Tecnica"/></strong></td>
		<td valign="top"><span class="oculto">-</span><a><bean:message key="verAvanzado.ver"/></a></td>
	</c:if>
	<c:if test="${!empty sesion.technical }">
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.Tecnica"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/VerMetadatos/CategoriasFormTecnica"><bean:message key="verAvanzado.ver"/></html:link></td>
	</c:if> 
</tr>
<tr class="tr_gris">
	<c:if test="${empty sesion.educational }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.UsoEducativo"/></strong></td>
		<td valign="top"><span class="oculto">-</span><a><bean:message key="verAvanzado.ver"/></a></td>
	</c:if>
	<c:if test="${!empty sesion.educational }">
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.UsoEducativo"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/VerMetadatos/CategoriasFormUsoEducativo"><bean:message key="verAvanzado.ver"/></html:link></td>
	</c:if> 
</tr>
<tr class="tr_blanco">
	<c:if test="${empty sesion.derechos }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.Derechos"/></strong></td>
		<td valign="top"><span class="oculto">-</span><a><bean:message key="verAvanzado.ver"/></a></td>
	</c:if>
	<c:if test="${!empty sesion.derechos }">
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.Derechos"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/VerMetadatos/CategoriasFormDerechos"><bean:message key="verAvanzado.ver"/></html:link></td>
	</c:if>
</tr>
<tr class="tr_gris">
	<c:if test="${empty sesion.relaciones }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.Relacion"/></strong></td>
		<td valign="top"><span class="oculto">-</span><a><bean:message key="verAvanzado.ver"/></a></td>
	</c:if>
	<c:if test="${!empty sesion.relaciones }">
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.Relacion"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/VerMetadatos/CategoriasFormRelacion"><bean:message key="verAvanzado.ver"/></html:link></td>
	</c:if>
</tr>
<tr class="tr_blanco">
	<c:if test="${empty sesion.anotaciones }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.Anotacion"/></strong></td>
		<td valign="top"><span class="oculto">-</span><a><bean:message key="verAvanzado.ver"/></a></td>
	</c:if>
	<c:if test="${!empty sesion.anotaciones }">
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.Anotacion"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/VerMetadatos/CategoriasFormAnotacion"><bean:message key="verAvanzado.ver"/></html:link></td>
	</c:if>
</tr>
<tr class="tr_gris">
	<c:if test="${empty sesion.clasificaciones }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.Clasificacion"/></strong></td>
		<td valign="top"><span class="oculto">-</span><a><bean:message key="verAvanzado.ver"/></a></td>
	</c:if>
	<c:if test="${!empty sesion.clasificaciones }">
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.Clasificacion"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/VerMetadatos/CategoriasFormClasificacion"><bean:message key="verAvanzado.ver"/></html:link></td>
	</c:if>
</tr>
</table>
</div>


</form>
</div>	<!-- Fin plantilla contenido  -->
</tiles:put>

</tiles:insert>
