<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-principal">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">

<h2><bean:message key="avanzado.Eliminar" /></h2>
<form method="post" enctype="multipart/form-data" action="<html:rewrite action="/Anotacion/ConfirmacionEliminarDatosAsesion"/>" >

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" class="ali_c">
			<br />
			 <p><bean:message key="avanzado.eliminarpres.textoSeguro"/></p>
				<p>
				<!--		INICIO CAJA TABLA		-->
					<div class="caja_tabla" >
						<display:table name="${form.tituloAnotacionRowSelection}" uid="fila" requestURI="${pageContext.request.requestURL}"
			        	export="false" pagesize="8" sort="list" style="border:1;width:100%;" class="administracion_tareas"
						cellpadding="0" cellspacing="0" >
				<!--		COLUMNA DE USUARIOS		-->
						<display:column>
			            	<bean:message key="anotaciones.Anotacion"/> ${fila}
			        	</display:column>
			        	
			        	</display:table>
					</div>
				<!--		FIN CAJA DE FORMULARIO		-->
				</p>
				</div>

			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->

<!-- Inicio Botones  -->
<input type="submit" class="boton_125_de_2" value="<bean:message key="confirmar.Aceptar"/>"/>
</form>	
<form method="post" enctype="multipart/form-data" action="<html:rewrite action="/Anotacion/ConfirmacionEliminarCancelarEliminar"/>">
  <input class="boton_125_de_2_izq"  type="submit"  value="<bean:message key="confirmar.Cancelar"/>"/>
</form>
<!-- Fin Botones  -->
<!-- Fin plantilla contenido  -->
</div>
</tiles:put>
</tiles:insert>