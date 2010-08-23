<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<tiles:insert definition="layout-administrador">
<tiles:put name="title" type="string">
	<bean:message key="title.Comun"/>
</tiles:put>
<tiles:put name="body" type="string">
<%@ include file="/taglib-imports.jspf" %>

<!--************************          Inicio plantilla contenido       ****************************-->
<div class="plantilla_contenido">
<jsp:include page="/layout/messages.jsp" flush="true" />

 <h2> <bean:message key="estructuras.tesauros.crear"/> </h2>
 
<form id="altaTesaurosFormNuevoTesauroSubmitForm" 
	action="<html:rewrite action="/AltaTesauros/FormNuevoTesauroSubmit"/>" method="post" enctype="multipart/form-data">





<!--   FICHERO 1  -->

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
  							<label for="<bean:message key="estructuras.tesauros.seleccione"/>">
  								<bean:message key="estructuras.tesauros.alta.label"/>&nbsp;01:
  							</label>
  						</div>
 					</div>
					<div class="contenedor_derecha_may">
						<div class="text">
							<input  name="fichero1"
									onfocus="limpiarTexto(this)"  
									value="&nbsp;"  
									onblur="this.style.backgroundColor='#e1e1e1'" id="fichero1" 
									type="file" 
									class="selfuente" 
									title="<bean:message key="estructuras.tesauros.seleccione"/>"  />
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
<!--   FICHERO 1    -	FICHERO 1   -	FICHERO 1   -	FICHERO 1  	-	FICHERO 1   -	FICHERO 1  	  -->


<!--   FICHERO 2	-   FICHERO 2	-   FICHERO 2	-   FICHERO 2	-   FICHERO 2	-   FICHERO 2	  -->
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris"  id="conmargen">
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
				<div class="fila_de_tabla" >
  					<div class="contenedor_izquierda_may">
  						<div class="text">
  							<label for="<bean:message key="estructuras.tesauros.seleccione"/>">
  								<bean:message key="estructuras.tesauros.alta.label"/>&nbsp;02:
  							</label>
  						</div>
 					</div>
					<div class="contenedor_derecha_may">
						<div class="text">
							<input  name="fichero2"
									onfocus="limpiarTexto(this)"  
									value="&nbsp;"  
									onblur="this.style.backgroundColor='#e1e1e1'" id="fichero2" 
									type="file" 
									class="selfuente" 
									title="<bean:message key="estructuras.tesauros.seleccione"/>"  />
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
<!--   FICHERO 2	-   FICHERO 2	-   FICHERO 2	-   FICHERO 2	-   FICHERO 2	-   FICHERO 2	  -->

<!--   FICHERO 3	-   FICHERO 3	-   FICHERO 3	-   FICHERO 3	-   FICHERO 3	-   FICHERO 3	  -->
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris"  id="conmargen">
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
				<div class="fila_de_tabla" >
  					<div class="contenedor_izquierda_may">
  						<div class="text">
  							<label for="<bean:message key="estructuras.tesauros.seleccione"/>">
  								<bean:message key="estructuras.tesauros.alta.label"/>&nbsp;03:
  							</label>
  						</div>
 					</div>
					<div class="contenedor_derecha_may">
						<div class="text">
							<input  name="fichero3"
									onfocus="limpiarTexto(this)"  
									value="&nbsp;"  
									onblur="this.style.backgroundColor='#e1e1e1'" id="fichero3" 
									type="file" 
									class="selfuente" 
									title="<bean:message key="estructuras.tesauros.seleccione"/>"  />
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
<!--   FICHERO 3	-   FICHERO 3	-   FICHERO 3	-   FICHERO 3	-   FICHERO 3	-   FICHERO 3	  -->

<!--   FICHERO 4	-   FICHERO 4	-   FICHERO 4	-   FICHERO 4	-   FICHERO 4	-   FICHERO 4	  -->
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris"  id="conmargen">
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
				<div class="fila_de_tabla" >
  					<div class="contenedor_izquierda_may">
  						<div class="text">
  							<label for="<bean:message key="estructuras.tesauros.seleccione"/>">
  								<bean:message key="estructuras.tesauros.alta.label"/>&nbsp;04:
  							</label>
  						</div>
 					</div>
					<div class="contenedor_derecha_may">
						<div class="text">
							<input  name="fichero4"
									onfocus="limpiarTexto(this)"  
									value="&nbsp;"  
									onblur="this.style.backgroundColor='#e1e1e1'" id="fichero4" 
									type="file" 
									class="selfuente" 
									title="<bean:message key="estructuras.tesauros.seleccione"/>"  />
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
<!--   FICHERO 4	-   FICHERO 4	-   FICHERO 4	-   FICHERO 4	-   FICHERO 4	-   FICHERO 4	  -->

<!--   FICHERO 5	-   FICHERO 5	-   FICHERO 5	-   FICHERO 5	-   FICHERO 5	-   FICHERO 5	  -->
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris"  id="conmargen">
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
				<div class="fila_de_tabla" >
  					<div class="contenedor_izquierda_may">
  						<div class="text">
  							<label for="<bean:message key="estructuras.tesauros.seleccione"/>">
  								<bean:message key="estructuras.tesauros.alta.label"/>&nbsp;05:
  							</label>
  						</div>
 					</div>
					<div class="contenedor_derecha_may">
						<div class="text">
							<input  name="fichero5"
									onfocus="limpiarTexto(this)"  
									value="&nbsp;"  
									onblur="this.style.backgroundColor='#e1e1e1'" id="fichero5" 
									type="file" 
									class="selfuente" 
									title="<bean:message key="estructuras.tesauros.seleccione"/>"  />
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
<!--   FICHERO 5	-   FICHERO 5	-   FICHERO 5	-   FICHERO 5	-   FICHERO 5	-   FICHERO 5	  -->

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->

<input class="boton_125_de_2_izq"   type="submit" name="action"  value="<bean:message key="estructuras.cancelar"/>" />
<input class="boton_125_de_2"   type="submit" name="action"  value="<bean:message key="estructuras.aceptar"/>" />

<!-- Fin Botones  -->
<!-- Fin Botones  --> 

</form>


</div><!-- plantilla contenido -->
</tiles:put>
</tiles:insert>