<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<bean:define id="urlArchivos"><html:rewrite action="/CrearRecursoAvanzado/TipoRecursoArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/CrearRecursoAvanzado/TipoRecursoRecursos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/CrearRecursoAvanzado/TipoRecursoOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/CrearRecursoAvanzado/TipoRecursoSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/CrearRecursoAvanzado/TipoRecursoRecursos"/></bean:define>
<bean:define id="selected" value="recursos"/>
<emp:layout selected="${selected}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
<bean:define id="empaquetadorSesion" name="<%=es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY%>" scope="session"/>
<bean:define id="crearRecurso" name="<%=es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession.SESSION_KEY%>" scope="session"/>
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>
 <script language="javascript">
 function doSubmit(sAction) {
        document.forms["mainform"].action.value = sAction;
        document.forms["mainform"].submit();
 }
 </script>


<logic:equal name="crearRecurso" property="modificar" value="false">
	<h2> <bean:message key="portalempaquetado.avanzado.recursos.crear.paso1.titulo" /></h2>
</logic:equal>
<logic:equal name="crearRecurso" property="modificar" value="true">
	<h2> <bean:message key="portalempaquetado.avanzado.recursos.modificar.paso1.titulo" /> </h2>
</logic:equal>





<form 
	name="mainform"
	method="post"
	id="crearRecursoAvanzadoTipoRecursoContinuarForm" 
	action="<html:rewrite action="/CrearRecursoAvanzado/TipoRecursoContinuar"/>">
<input type=hidden name=action value="">
	

<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->
<p class="parrafo_comun" id="separacion3">
	<bean:message key="portalempaquetado.avanzado.recursos.crear.paso1.tiposcorm"/>
	</p>
<bean:define id="tipoScorm" value="${form.tipo}" />
<!--  start bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright"><div class="lb_bubble_content">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario_02" >
			 <div class="fila_de_tabla">
  						<div class="text ft_lateral">

<logic:equal name="tipoScorm" value="asset">
  							<input type="radio" class="boton_radio" checked="checked" name="tipo"
  								 value="asset" id="tipoAsset"/>
</logic:equal>
<logic:notEqual name="tipoScorm" value="asset">
  							<input type="radio" class="boton_radio" name="tipo" value="asset" id="tipoAsset"/>
</logic:notEqual>
  								<label for="tipoAsset" class="alineada">
  									<bean:message key="portalempaquetado.avanzado.recursos.crear.paso1.asset"/>
  								</label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />

				</div>
				<!--     -->
			<div class="fila_de_tabla">
  						<div class="text ft_lateral">
<logic:equal name="tipoScorm" value="sco">
  							<input  type="radio" class="boton_radio" checked="checked"  name="tipo" value="sco" id="tipoSco"/>
</logic:equal>
<logic:notEqual name="tipoScorm" value="sco">
  							<input  type="radio" class="boton_radio" name="tipo" value="sco" id="tipoSco"/>
</logic:notEqual>
  								<label for="tipoSco"  class="alineada2">
  									<bean:message key="portalempaquetado.avanzado.recursos.crear.paso1.sco"/>
  								</label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
				</div>

				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
</div>
<!--  end bubble -->

<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">

<div class="packer_continue">
 <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 <a href='javascript:doSubmit("Continue");'>Continue</a>
 </div></div></div></div></div>
</div>

<div class="packer_cancel">
 <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 <a href='javascript:doSubmit("Cancel");'>Cancel</a>
 </div></div></div></div></div>
</div>

</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>

<script type="text/javascript">
  document.forms[0].tipo[0].focus();
</script>

</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
</emp:layout>
