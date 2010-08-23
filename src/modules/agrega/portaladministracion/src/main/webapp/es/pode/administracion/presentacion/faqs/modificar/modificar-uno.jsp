<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<tiles:insert definition="layout-administrador">
<tiles:put name="title" type="string">
	<bean:message key="title.Comun"/>
</tiles:put>
<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>

<%@ include file="/es/pode/administracion/presentacion/noticias/crear/formulario-vars.jspf" %>


<!--***********************       Inicio plantilla contenido      ************************* -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" >
	<!-- ## Para pintar los mensajes de error ## -->
	<jsp:include page="/layout/messages.jsp" flush="true" />
	<h2><bean:message key="faqs.modificar.titulo.uno"/></h2>	
	
	<form method="post" action="<html:rewrite action="/ModificarFAQ/ModificarUnoAceptar"/>" enctype="multipart/form-data">	
		
		<!--  INICIO GLOBO GRIS   -->
		<div class="globo_gris" id="ficha">
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
						<!--  INICIO CAJA DE FORMULARIO   -->
						<div id="formulario" >					
							<!-- ***********************      DESPLEGABLE DE CATEGORIA     **************************-->										
							<div class="fila_de_tabla">		
			  					<div class="contenedor_izquierda">
			  						<div class="text">
			  							<label for="Categoria"><bean:message key="modificar.noticia.formulario.Categoria"/></label>
			  						</div>
			 					</div>			 					
			 					<div class="contenedor_derecha">
									<div class="text">		 						 					
										 <bean:define id="categValue" ><bean:message key="modificar.noticia.formulario.SelectCategoria"/></bean:define>	                           
					                     <html:select name="form" property="categoria"  style="width:320px" styleId="Categoria" title="${categValue } " >
					                           <option value="#" selected="selected" ><bean:message key="comun.seleccione"/></option>
					                           <html:optionsCollection name="form" property="categoriaBackingList"  label="label" value="value"/>
					                     </html:select>                                 							
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
		
		<!-- Inicio Botones  -->		
		<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key="comun.continuar"/>" />			
			<input type="hidden" name="categoria" value="${form.categoria}"/>	
			<input type="hidden" name="id" value="${form.id}"/>		
	</form>
		<form method="post" action="<html:rewrite action="/Faqs/Faqs"/>">			
			<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="estructuras.cancelar"/>" />
		</form>		
		<!-- Fin Botones  -->
</div>
<!-- Fin plantilla contenido  -->

</tiles:put>
</tiles:insert>