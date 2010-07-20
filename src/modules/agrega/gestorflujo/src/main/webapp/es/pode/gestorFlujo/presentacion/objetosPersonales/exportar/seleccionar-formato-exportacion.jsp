<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<tiles:insert definition="layout-gestor-flujo-con-style">

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="body" type="string">
    
    <!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
<div class="plantilla_contenido">

<!--  INICIO CAPA MADRE   -->
<div id="capa_madre">


<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- ATENCION!! RREMPLAZAR ESTA CAPA DE LA  PLANTILLA DE CONTENIDO ("plantilla_contenido") POR LA QUE SE DESEE EN LA PLANTILLA BASE  -->
<!-- Inicio plantilla contenido  -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2><bean:message key="gestorFlujo.mostrarOdes.exportar"/></h2>
<form method="post" action="<html:rewrite action="/${initParam.url_exportar_formato}?idODE=${form.idODE}&titulo=${form.titulo}"/>" >

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario_02" >

			 <div class="fila_de_tabla">
  						<div class="text ft_lateral" >
  						<input type="radio" class="boton_radio" value="CONTENIDOS" id="Formato06" checked="checked" name="formatoExportacion" />
  						<label for="Descarga01" class="alineada"><bean:message key ="gestorFlujo.exportar.formato6"/></label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
				       
				<div class="fila_de_tabla">
  						<div class="text ft_lateral">
  						<input  type="radio" class="boton_radio" value="HTML" id="Formato04"  name="formatoExportacion" />
  						<label for="Formato04"  class="alineada2"><bean:message key ="gestorFlujo.exportar.formato5"/></label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
				
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>

		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<p class="parrafo_comun" id="separacion3"><bean:message key ="gestorFlujo.exportar.seleccione"/></p>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >

			 <div class="fila_de_tabla">
  						<div class="text ft_lateral" >
  						<input type="radio" class="boton_radio" value="SCORM_2004_SIN_SUBMANIFIESTO" id="Formato01" name="formatoExportacion" /><label for="Formato01" class="alineada">
							<bean:message key ="gestorFlujo.exportar.formato1"/> </label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
				<!--     -->
			<div class="fila_de_tabla">
  						<div class="text ft_lateral">
  						<input type="radio" class="boton_radio" value="SCORM_2004" id="Formato02" name="formatoExportacion" /><label for="Formato02"  class="alineada2">
  						<bean:message key ="gestorFlujo.exportar.formato2"/></label></div>

				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
				<!--     -->
			<div class="fila_de_tabla">
  						<div class="text ft_lateral">
  						<input type="radio" class="boton_radio" value="SCORM_12" id="Formato03"  name="formatoExportacion" /><label for="Formato03"  class="alineada2">
  						<bean:message key ="gestorFlujo.exportar.formato3"/>  </label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />

				</div>
				<!--     -->
			<div class="fila_de_tabla">
  						<div class="text ft_lateral">
  						<input  type="radio" class="boton_radio" value="IMS_CP" id="Formato03"  name="formatoExportacion" /><label for="Formato03"  class="alineada2">
  						<bean:message key ="gestorFlujo.exportar.formato4"/></label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>
				
				<!--     -->
				
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

<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key="gestorFlujo.exportar.descargar"/>" />
</form>
	<form action = "<html:rewrite action="/${initParam.url_objetosPersonales }"/>" method = "post">
		<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="gestorFlujo.exportar.volver"/>" />
	</form>



<!-- Fin Botones  -->
<!-- Fin Botones  -->
  </div>
    <!-- Fin CONTENIDO PESTANIAS -->
    <!-- Fin CONTENIDO PESTANIAS -->
    <!-- HASTA AQUI EL REEEMPLAZO -->
    <!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
    <!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
    
    </div>
    <!-- Fin plantilla CONTENIDO -->
    

  
   </tiles:put>

</tiles:insert>