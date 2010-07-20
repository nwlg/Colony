<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzadoInicio">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/catalogadorAvanzado/categorias-form-vars.jspf" %>


<div class="plantilla_contenido">

<jsp:include page="/layout/messages.jsp" flush="true"/>
<script language="javascript">
function doSubmit(formname, sAction) {
        document.forms[formname].accion.value = sAction;
        document.forms[formname].submit();
}
</script>


<form name="mainform" method="post" action="<html:rewrite action="/CatalogadorAvanzado/CategoriasFormSubmit"/>" >
<input type=hidden name=accion value="">
<div class="caja_tabla" >
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright"><div class="lb_bubble_content">
<p class="parrafo_comun" id="separacion2"><bean:message key="catalogadorAvanzado.Explicacion"/></p>
<table border="1" class="administracion_noticias" cellpadding="0" cellspacing="0" width="100%" summary="<bean:message key="catalogadorAvanzado.Tabla"/>">
<caption><strong><bean:message key="catalogadorAvanzado.Tabla"/></strong></caption>
<c:set var="sesion" value="${catalogadorAvSession.MDSesion}"/> 

<tr class="tr_gris">
	<c:if test="${empty sesion.general }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.General"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarGeneral"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if>
	<c:if test="${!empty sesion.general }"> 
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.General"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarGeneral"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if>
</tr>
<tr class="tr_blanco">
	<c:if test="${empty sesion.lifeCycle }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.CicloDeVida"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarCicloDeVida"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if>
	<c:if test="${!empty sesion.lifeCycle }">
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.CicloDeVida"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarCicloDeVida"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if> 
</tr>
<tr class="tr_gris">
	<c:if test="${empty sesion.metaMetadata }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.MetaMetadatos"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarMetaMetadatos"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if>
	<c:if test="${!empty sesion.metaMetadata }">
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.MetaMetadatos"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarMetaMetadatos"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if> 
</tr>
<tr class="tr_blanco">
	<c:if test="${empty sesion.technical }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.Tecnica"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarTecnica"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if>
	<c:if test="${!empty sesion.technical }">
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.Tecnica"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarTecnica"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if> 
</tr>
<tr class="tr_gris">
	<c:if test="${empty sesion.educational }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.UsoEducativo"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarUsoEducativo"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if>
	<c:if test="${!empty sesion.educational }">
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.UsoEducativo"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarUsoEducativo"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if> 
</tr>
<tr class="tr_blanco">
	<c:if test="${empty sesion.derechos }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.Derechos"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarDerechos.do"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if>
	<c:if test="${!empty sesion.derechos }">
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.Derechos"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarDerechos"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if>
</tr>
<tr class="tr_gris">
	<c:if test="${empty sesion.relaciones }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.Relacion"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarRelacion"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if>
	<c:if test="${!empty sesion.relaciones }">
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.Relacion"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarRelacion"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if>
</tr>
<tr class="tr_blanco">
	<c:if test="${empty sesion.anotaciones }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.Anotacion"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarAnotacion"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if>
	<c:if test="${!empty sesion.anotaciones }">
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.Anotacion"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarAnotacion"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if>
</tr>
<tr class="tr_gris">
	<c:if test="${empty sesion.clasificaciones }">
		<td valign="top" class="new meta_datos_mas"><strong><bean:message key="catalogadorAvanzado.Clasificacion"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarClasificacion"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if>
	<c:if test="${!empty sesion.clasificaciones }">
		<td valign="top" class="new meta_datos"><strong><bean:message key="catalogadorAvanzado.Clasificacion"/></strong></td>
		<td valign="top"><span class="oculto">-</span><html:link action="/CatalogadorAvanzado/CategoriasFormModificarClasificacion"><bean:message key="catalogadorAvanzado.Modificar"/></html:link></td>
	</c:if>
</tr>
</table>
</div>
</div></div></div></div></div>


<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">

<div class="packer_cancel">
 <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 <a href='javascript:doSubmit("mainform", "<bean:message key="catalogadorAvanzado.Cancelar"/>");'><bean:message key="catalogadorAvanzado.Cancelar"/></a>
 </div></div></div></div></div>
</div>

<div class="packer_accept">
 <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 <a href='javascript:doSubmit("mainform", "<bean:message key="catalogadorAvanzado.Aceptar"/>");'><bean:message key="catalogadorAvanzado.Aceptar"/></a>
 </div></div></div></div></div>
</div>

<div class="packer_validate">
 <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 <a href='javascript:doSubmit("mainform", "<bean:message key="catalogadorAvanzado.Validar"/>");'><bean:message key="catalogadorAvanzado.Validar"/></a>
 </div></div></div></div></div>
</div>

<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
</div>	<!-- Fin plantilla contenido  -->
</tiles:put>

</tiles:insert>
