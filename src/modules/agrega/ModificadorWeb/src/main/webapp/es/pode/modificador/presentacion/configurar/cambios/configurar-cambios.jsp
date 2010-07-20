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

<h2><bean:message key="configurarCambios.titulo"/></h2>

<form id="configurarCambiosConfigurarCambiosSelectActionForm" action="<html:rewrite action="/ConfigurarCambios/ConfigurarCambiosSelectAction"/>"  method="post">

<p class="parrafo_comun" id="separacion2"><bean:message key="configurarCambios.seleccioneTipo"/>:</p>

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
				<logic:iterate id="current" name="form" property="tipos">
					<div class="fila_de_tabla">
  						<div class="text ">
							
							<html:radio property="option" styleClass="boton_radio" styleId="${current}" name="form" value="${current}" />
							<label for="${current}" class="alineada">
							 		<bean:message key="configurarCambios.${current}"/>
							 </label>					
						 </div>
						 <div class="linea_separadora"></div>
						<br class="oculto" />
					</div>
				</logic:iterate>
			
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo">
<input class="boton_125_de_2"  name="action" type="submit"  value="<bean:message key="configurarCambios.continuar"/>" />
<input class="boton_125_de_2_izq"  name="action" type="submit"  value="<bean:message key="configurarCambios.cancelar"/>" />

</fieldset>
<!-- Fin Botones  -->

<!-- Fin Botones  -->
</form>
</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->


    </tiles:put>

</tiles:insert>
