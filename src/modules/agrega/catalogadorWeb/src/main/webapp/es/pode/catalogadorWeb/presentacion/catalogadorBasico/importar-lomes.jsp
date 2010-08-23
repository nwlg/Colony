<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>
<tiles:insert definition="layout-principal">
<tiles:put name="title" type="string">
	<bean:message key="title.Basico"/>
</tiles:put>

<tiles:put name="body" type="string">
<jsp:include page="/layout/messages.jsp" flush="true"/>

<div class="plantilla_contenido">
<h2><bean:message key="catalogadorBasico.importar.titulo"/></h2>

<form method="post" action="<html:rewrite action="/CatalogadorBasico/ImportarLomesSubmit"/>" enctype="multipart/form-data">


<!--   FICHERO  -->

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
				<div class="fila_de_tabla" >
  					<div class="contenedor_izquierda_may">
  						<div class="text">
  							<label for="<bean:message key="catalogadorBasico.importar.seleccione"/>">
  								<bean:message key="catalogadorBasico.importar.label"/>
  							</label>
  						</div>
 					</div>

					<div class="contenedor_derecha_may">
						
						<div class="text">
							<input  name="fichero"
									onfocus="limpiarTexto(this)"  
									value="&nbsp;"  
									onblur="this.style.backgroundColor='#e1e1e1'" id="fichero" 
									type="file" 
									class="selfuente" 
									title="<bean:message key="catalogadorBasico.importar.seleccione"/>"  />
						</div>
					</div>
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
<!--   FICHERO   	  -->


<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo">
<button class="boton_125_de_2_izq" name="accion" type="submit"  value="<bean:message key="catalogadorBasico.importar.cancelar"/>" >
	<bean:message key="catalogadorBasico.importar.cancelar"/>
</button>
<button class="boton_125_de_2" name="accion" type="submit"  value="<bean:message key="catalogadorBasico.importar.aceptar"/>" >
	<bean:message key="catalogadorBasico.importar.aceptar"/>
</button>
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->



</form>
</div>	<!-- Fin plantilla contenido  -->
</tiles:put>

</tiles:insert>








