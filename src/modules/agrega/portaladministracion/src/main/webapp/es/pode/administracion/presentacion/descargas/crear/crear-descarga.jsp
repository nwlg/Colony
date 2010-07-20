<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/es/pode/administracion/presentacion/descargas/crear/crear-descarga-vars.jspf" %>

<!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
<div class="plantilla_contenido">
<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />
<h2><bean:message key="crearDescarga.titulo" /></h2>
<form method="post" id="crearDescargaCrearDescargaSubmitForm" action="<html:rewrite action="/CrearDescarga/CrearDescargaSubmit"/>">

<div class="globo_gris uno_b" >
    	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
					<div id="formulario" >
			<div class="fila_de_tabla">
                    <c:if test="${empty form.path}">
                       <div class="text"><p><bean:message key="crearDescarga.nuevoPath" /></p></div>
                    </c:if>
                    <c:if test="${!empty form.path}">
                       <div class="text"><p><bean:message key="crearDescarga.modificarPath" /></p></div>
                    </c:if>
  					<div class="contenedor_izquierda">
  						<div class="text"><label for="Url"><bean:message key="crearDescarga.descarga.url" /></label></div>

 					</div>
					<div class="contenedor_derecha">
						<div class="text"><input name="path" value="${form.path }" onblur="this.style.backgroundColor='#e1e1e1'" id="Url" type="text" title="<bean:message key="crearDescarga.descarga.url.tooltip" />" /></div>
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

<c:forEach items="${form.descripciones}" var="descripcion" varStatus="status">

<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris uno_b" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="caja_dinamica" ><a class="desplegado" id="pm${status.index }" href="#" onclick="expandirCaja('m${status.index }','<bean:message key="crearDescarga.verCampos" />','<bean:message key="crearDescarga.ocultarCampos" />');return false;" onkeypress="expandirCaja('m${status.index }','<bean:message key="crearDescarga.verCampos" />','<bean:message key="crearDescarga.ocultarCampos" />');return false;"><br class="falso" /><strong id="dm${status.index }" ><bean:message key="crearDescarga.verCampos" /></strong></a><h3>${descripcion.idiomadesc}</h3></div>

<div id="m${status.index }" class="caja_cerrada"  >
<br />
<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
  				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda">
  						<div class="text"><label for="Descarga0${status.index }"><bean:message key="crearDescarga.descarga.titulo" /></label></div>
 					</div>
					<div class="contenedor_derecha">
						<div class="text"><input name="titulo_${descripcion.idioma}" value="${descripcion.titulo }"  onblur="this.style.backgroundColor='#e1e1e1'" id="Descarga0${status.index }" type="text" title="<bean:message key="crearDescarga.descarga.titulo.tooltip" />"  /></div>

					</div>
					<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>
				
				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda">
  						<div class="text"><label for="Descripcion0${status.index }" ><bean:message key="crearDescarga.descarga.descripcion" /></label></div>
 					</div>
					<div class="contenedor_derecha">
						<div class="text"><textarea name="descripcion_${descripcion.idioma}" rows="10" cols="40" class="ta_minimo_ancho" onblur="this.style.backgroundColor='#e1e1e1'" id="Descripcion0${status.index }"  title="<bean:message key="crearDescarga.descarga.descripcion.tooltip" />" >${descripcion.descripcion }</textarea></div>
					</div>
					<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>
				<!-- -->
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
</div>
<br />
				<!--  FIN   -->
			</div>
		</div>
	</div>

</div>
<!--  FIN GLOBO GRIS   -->
</c:forEach>

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo">
<input class="boton_125_de_2_izq"  type="submit" name="action"  value="<bean:message key="comun.cancelar"/>" />
<input class="boton_125_de_2"  type="submit" name="action"  value="<bean:message key="comun.aceptar"/>" />

</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
<!-- Fin plantilla contenido  -->

</div>
</tiles:put>

</tiles:insert>