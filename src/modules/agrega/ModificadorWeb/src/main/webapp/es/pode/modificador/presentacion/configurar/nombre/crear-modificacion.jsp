<!-- *****************************************************************************************************
*********************************       Listar.jsp de Tareas Pendientes      ** ***********************************
******************************************************************************************************-->
  
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<tiles:insert definition="${sessionScope.offline == true ? 'layout-offline' : 'layout-administrador'}">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>


<!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
<div class="plantilla_contenido">

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<c:if test="${empty form.nombre}">
<h2><bean:message key="nombre.crearTarea"/></h2>
</c:if>
<c:if test="${!empty form.nombre}">
<h2><bean:message key="nombre.modificarTarea"/></h2>
</c:if>
<form id="configurarNombreCrearModificacionContinuarForm" action="<html:rewrite action="/ConfigurarNombre/CrearModificacionContinuar"/>"  method="post">

<p class="parrafo_comun" id="separacion2"><bean:message key="nombre.introducirNombre"/>:</p>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >

			 <div class="fila_de_tabla">
			 <c:if test="${empty configurarModificacionSession.idModificacion}">
  				<c:if test="${!empty form.nombre}">
  					<div class="text" style="text-align:center"><label for="crearTarea"><span class="oculto"></span></label><input name="nombre" class="nombreGrupo" value="${form.nombre}"  onblur="this.style.backgroundColor='#e1e1e1'" id="nombre" type="text" title="<bean:message key="nombre.input.title"/>"/></div>
  			   </c:if>
  			   <c:if test="${empty form.nombre}">
  					<div class="text" style="text-align:center"><label for="nombre"><span class="oculto"></span></label><input name="nombre" class="nombreGrupo" value=""  onblur="this.style.backgroundColor='#e1e1e1'" id="nombre" type="text" title="<bean:message key="nombre.input.title"/>"/></div>
  			   </c:if>
			 </c:if>
			 <c:if test="${!empty configurarModificacionSession.idModificacion}">
			   <c:if test="${!empty form.nombre}">
  						<div class="text" style="text-align:center"><label for="crearTarea"><span class="oculto"></span></label><input name="nombre" class="nombreGrupo" value="${form.nombre}"  onblur="this.style.backgroundColor='#e1e1e1'" id="nombre" type="text" title="<bean:message key="nombre.input.title"/>"/></div>
  			   </c:if>
  			   <c:if test="${empty form.nombre}">
  					<div class="text" style="text-align:center"><label for="nombre"><span class="oculto"></span></label><input name="nombre" class="nombreGrupo" value=""  onblur="this.style.backgroundColor='#e1e1e1'" id="nombre" type="text" title="<bean:message key="nombre.input.title"/>"/></div>
  			   </c:if>
			 </c:if>
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

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo">
<input class="boton_125_de_2"  name="action" type="submit"  value="<bean:message key="nombre.continuar"/>" />
<input class="boton_125_de_2_izq" name="action" type="submit"  value="<bean:message key="nombre.cancelar"/>" />

</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
</div>
</tiles:put>

</tiles:insert>
