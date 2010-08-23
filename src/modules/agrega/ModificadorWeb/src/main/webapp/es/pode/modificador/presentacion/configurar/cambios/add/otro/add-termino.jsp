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
<!-- Inicio plantilla contenido  -->



<h2><bean:message key="otroAddTermino.titulo"/></h2>
<form id="addTerminoAddTerminoActionForm" action="<html:rewrite action="/AddTermino/AddTerminoAction"/>"  method="post">
<p class="parrafo_comun" id="separacion2"><bean:message key="otroAddTermino.rellenarCompletar"/>.</p>


<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->

			<div id="formulario" >
			 <!-- -->
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text"><label for="terminoCambio"><bean:message key="otroAddTermino.termnioLom"/>:</label>
											</div>
										</div>
										<div class="contenedor_derecha">

											<div class="text">
												<textarea name="valor" rows="10" cols="40" class="ta_minimo_ancho" onblur="this.style.backgroundColor='#e1e1e1'" id="terminoCambio"  title="Introduzca aquí" >${form.valor}</textarea>
											</div>
										</div>
										<div class="linea_separadora">
										</div>
									</div>	<!-- -->
						<!-- -->

				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<!-- Inicio Botones  -->

<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">
<input class="boton_125_de_2"  type="submit" name="action"  value="<bean:message key="otroAddTermino.aceptar"/>" />
<input class="boton_125_de_2_izq"  type="submit" name="action"  value="<bean:message key="otroAddTermino.volver"/>" />
<input class="boton_125"  type="submit" name="action"  value="<bean:message key="otroAddTermino.cancelar"/>" />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
</div>
<!-- Fin plantilla contenido  -->
    </tiles:put>

</tiles:insert>
