<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/tags-modificadorWeb.tld" prefix="mod" %>
<tiles:insert definition="${sessionScope.offline == true ? 'layout-offline' : 'layout-administrador'}">
<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>
<tiles:put name="body" type="string">
<div class="plantilla_contenido">
<h2><bean:message key="navegarLom.h2"/></h2>
<form method="post" action="<html:rewrite action="/NavegarLom/NavegarLOMSeleccionar"/>" >
<p class="parrafo_comun" id="separacion2"><bean:message key="navegarLom.explicacion"/></p>

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->

			<div id="formulario" >
			<div class="breadcrumb_arbol">
			<c:forEach items="${form.termino.padres}" var="termino" varStatus="status">
			<c:choose>
				<c:when test="${status.last}">
				<em class="oculto">-</em><span class="ver_docu" >${termino.nombreTermino }</span></div>
				</c:when>
				<c:otherwise>
				<em class="oculto">-</em><a href="<html:rewrite action="/NavegarLom/NavegarLOMNavegar"/>?<logic:notEmpty name="termino" property="idTermino">idTermino=${termino.idTermino }</logic:notEmpty>" class="ver_docu">${termino.nombreTermino }</a>
				</c:otherwise>
			</c:choose>
			</c:forEach>
<!--  INICIO CAPA TABLA   -->
<!--  INICIO CAPA TABLA   -->					
<div class="caja_tabla limpiar_breadcrumb_00" >
<table border="1" class="administracion_usuarios" cellpadding="0" cellspacing="0" width="100%" summary="<bean:message key="navegarLom.tabla.titulo"/>">
<caption><strong><bean:message key="navegarLom.tabla.titulo"/></strong></caption>
<c:set var="contador" value="true"/>
<c:forEach items="${form.termino.hijos}" var="termino" varStatus="status">
<c:choose>
<c:when test="${contador}">
<tr class="tr_gris">
</c:when>
<c:otherwise>
<tr class="tr_blanco">
</c:otherwise>
</c:choose>
<c:set var="contador" value="${!contador}"/>
<td valign="top" class="new"><a href="<html:rewrite action="/NavegarLom/NavegarLOMNavegar"/>?<logic:notEmpty name="termino" property="idTermino">idTermino=${termino.idTermino }</logic:notEmpty>" class="ver_docu">${termino.nombreTermino }</a></td>
</tr>
</c:forEach>
</table>
<logic:notEmpty name="form" property="idTermino"><input type="hidden" name="idTermino" value="${form.termino.idTermino }"/></logic:notEmpty>
<input type="hidden" name="terminoLom" value="${form.termino.rutaTermino}"/>
</div>
	<!--  FIN CAPA TABLA   -->		
	<!--  FIN CAPA TABLA   -->
<hr />
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
<input class="boton_125_de_2_izq" name="action" type="submit"  value="<bean:message key="comun.cancelar"/>" />
<mod:selectorTerminoLom action="action" termino="${form.termino }" tipoCambio="${cambioSession.tipo}"/>
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->

</form>
</div>
</tiles:put>
</tiles:insert>