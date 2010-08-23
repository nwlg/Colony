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
<div class="plantilla_contenido" >
<!-- ## Para pintar los mensajes de error ## -->
	<jsp:include page="/layout/messages.jsp" flush="true" />
	<h2><bean:message key="noticias.ver.titulo.uno"/></h2>	
	<form method="post" action="<html:rewrite action="/VerNoticia/FormularioUnoSiguiente"/>" enctype="multipart/form-data">	
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
					                     <html:select disabled="true" name="form" property="categoria"  style="width:320px" styleId="Categoria" title="${categValue } " >
					                           <option value="#" selected="selected" ><bean:message key="comun.seleccione"/></option>
					                           <html:optionsCollection name="form" property="categoriaBackingList"  label="label" value="value"/>
					                     </html:select>                                 							
									</div>
								</div>							
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>	
							
							<!-- ***********************     CAMPO DE IMAGEN      **************************-->														
							<div class="fila_de_tabla">
			  					<div class="contenedor_izquierda">
			  						<div class="text"><label for="SelSinImagen"><bean:message key="modificar.noticia.formulario.Imagen"/></label></div>			
			 					</div>	
			 					<!-- ***********************     SIN IMAGEN     **************************-->			 					
			 										 							
								<div class="contenedor_derecha">
									<div class="text">
									<html:radio disabled="true" name="form" property="activarImagen" styleClass="boton_radio" value="2"/>									
									<span class="vert"><bean:message key="noticias.crear.sin.imagen"/></span>									
									</div>
								</div>
								<div class="linea_separadora"></div>		
								<br class="oculto" />
							</div>		
			 								 							 					
			 					<!-- ***********************     IMAGEN ANTERIOR     **************************-->	
			 					<div class="fila_de_tabla">
  									<div class="contenedor_izquierda">
  										<div class="text"><label for="SelSinImagen">&nbsp;</label></div>
 									</div>			 					
				 				<div class="contenedor_derecha">
										<div class="text">
											<html:radio disabled="true" name="form" property="activarImagen" styleClass="boton_radio" value="1"/>	
											<span class="vert"><bean:message key="noticias.crear.modificar.imagen.inicio"/> ${form.nombreImagen}</span>											
										</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>	 					
			 				
							<!-- ***********************     RADIO-BUTTON ALINEAMIENTOS      **************************-->				
							<div class="fila_de_tabla">
			  					<div class="contenedor_izquierda">
			  						<div class="text"><label>&nbsp;</label></div>
			 					</div>
								<div class="contenedor_derecha">		
									<div class="text">
										<table cellspacing="0" cellpadding="0" border="0" width="100%"  summary="Opciones" style="font-size:100%;width:400px">		
											<tr>
												<td class="td_largo_11" valign="top"><span class="vert"><bean:message key="noticias.crear.alinear.arriba"/>&nbsp;&nbsp;&nbsp;</span></td>
												<td  valign="top">
													<html:radio disabled="true" name="form" property="alineamiento" styleClass="boton_radio" value="0"/><span class="vert"><bean:message key="modificar.noticia.formulario.AlinearIzq"/></span>
												</td>
											</tr>
											<tr>
												<td class="td_largo_11">&nbsp;</td>
												<td valign="top">
													<html:radio disabled="true" name="form" property="alineamiento" styleClass="boton_radio" value="1"/><span class="vert"><bean:message key="modificar.noticia.formulario.AlinearDer"/></span>
												</td>										
											</tr>
											<tr>
												<td class="td_largo_11" valign="top"><span class="vert"><bean:message key="noticias.crear.alinear.abajo"/>&nbsp;&nbsp;&nbsp;</span></td>
												<td valign="top">
													<html:radio disabled="true" name="form" property="alineamiento" styleClass="boton_radio" value="2"/><span class="vert"><bean:message key="noticias.crear.alinear.abajo.izquierda"/></span>
												</td>
											</tr>
											<tr>
												<td class="td_largo_11">&nbsp;</td>
												<td  valign="top">
													<html:radio disabled="true" name="form" property="alineamiento" styleClass="boton_radio" value="3"/><span class="vert"><bean:message key="noticias.crear.alinear.abajo.derecha"/></span>
												</td>
											</tr>
										</table>											
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>	
							
							<!-- ***********************     RADIO-BUTTON CAMPO DE ESTADO - DESACTIVADO      **************************-->
							<div class="fila_de_tabla">
			  					<div class="contenedor_izquierda">
			  						<div class="text"><label for="SelEstado"><bean:message key="modificar.noticia.formulario.Estado"/></label></div>
			 					</div>
								<div class="contenedor_derecha">
									<div class="text">
										<html:radio disabled="true" name="form" property="estado" styleClass="boton_radio" value="false" styleId="SelEstado" /><span class="vert"><bean:message key="modificar.noticia.formulario.EstadoDesact"/></span>											
									</div>
								</div>
								<div class="linea_separadora"></div>
			
								<br class="oculto" />
							</div>	
							<!-- -->					
							
							<!-- ***********************     RADIO-BUTTON CAMPO DE ESTADO - ACTIVADO      **************************-->
							<div class="fila_de_tabla">
			  					<div class="contenedor_izquierda">
			  						<div class="text"><label for="SelEstado_02">&nbsp;</label></div>
			 					</div>
								<div class="contenedor_derecha">									
									<div class="text">
										<html:radio disabled="true" name="form" property="estado" styleClass="boton_radio" value="true" styleId="SelEstado_02"/><span class="vert"><bean:message key="modificar.noticia.formulario.EstadoActiv"/></span>
									</div>				
								</div>
								<div class="linea_separadora"></div>
							</div>
							<!-- -->
			
							</div>
							<!--  FIN CAJA DE FORMULARIO   -->
					</div>
				</div>
			</div>
		</div>
		<!--  FIN GLOBO GRIS   -->

		<!-- Inicio Botones  -->
		<!-- Inicio Botones  -->		
		<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key="comun.continuar"/>" />					
			<input type="hidden" name="idNoticia" value="${form.idNoticia}"/>
			
		</form>
		<form method="post" action="<html:rewrite action="/Noticias/Noticias"/>">			
		<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="estructuras.cancelar"/>" />
		</form>
		
		<!-- Fin Botones  -->
		<!-- Fin Botones  -->

</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->

</tiles:put>
</tiles:insert>
