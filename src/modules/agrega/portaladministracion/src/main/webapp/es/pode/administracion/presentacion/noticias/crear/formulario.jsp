<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

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
	<h2><bean:message key="noticias.crear.titulo.uno"/></h2>	
	
	<form method="post" action="<html:rewrite action="/CrearNoticia/FormularioValida"/>" enctype="multipart/form-data">	
		
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
							
							<!-- ***********************     CAMPO DE IMAGEN      **************************-->														
							<div class="fila_de_tabla">
			  					<div class="contenedor_izquierda">
			  						<div class="text"><label for="SelSinImagen"><bean:message key="modificar.noticia.formulario.Imagen"/></label></div>			
			 					</div>				 					
			 					<div class="contenedor_derecha">
									<div class="text">
									<html:radio name="form" property="activarImagen" styleClass="boton_radio" value="2"
									onclick="document.getElementById('SelImagen').disabled=true;
													 document.getElementById('SelImagen').style.backgroundColor='white'
													 document.getElementById('alineaArribaIzq').disabled=true;
													 document.getElementById('alineaArribaIzq').style.backgroundColor='white'
													 document.getElementById('alineaArribaDcha').disabled=true;
													 document.getElementById('alineaArribaDcha').style.backgroundColor='white' 
													 document.getElementById('alineaAbajoIzq').disabled=true;
													 document.getElementById('alineaAbajoIzq').style.backgroundColor='white'  
													 document.getElementById('alineaAbajoDcha').disabled=true;
													 document.getElementById('alineaAbajoIzq').style.backgroundColor='white'" >	
									</html:radio>								
									<span class="vert"><bean:message key="noticias.crear.sin.imagen"/></span>									
									</div>
								</div>
								<div class="linea_separadora"></div>		
								<br class="oculto" />	
								</div>	 					
			 					<!-- ***********************     IMAGEN ANTERIOR     **************************-->		
			 					<c:if test="${!empty form.nombreImagen}">
				 					<div class="fila_de_tabla">
	  									<div class="contenedor_izquierda">
	  										<div class="text"><label for="SelSinImagen">&nbsp;</label></div>
	 									</div>
 								
				 					<div class="contenedor_derecha">
										<div class="text">
											<html:radio name="form" property="activarImagen" styleClass="boton_radio" 
											onclick="document.getElementById('SelImagen').disabled=true;
													 document.getElementById('SelImagen').style.backgroundColor='white'
													 document.getElementById('alineaArribaIzq').disabled=false;
													 document.getElementById('alineaArribaIzq').style.backgroundColor='white'
												  	 document.getElementById('alineaArribaDcha').disabled=false;
													 document.getElementById('alineaArribaDcha').style.backgroundColor='white' 
													 document.getElementById('alineaAbajoIzq').disabled=false;
													 document.getElementById('alineaAbajoIzq').style.backgroundColor='white'  
													 document.getElementById('alineaAbajoDcha').disabled=false;
												 	 document.getElementById('alineaAbajoIzq').style.backgroundColor='white'"													 
											value="1"></html:radio>	
											<span class="vert"><bean:message key="noticias.crear.modificar.imagen.inicio"/> ${form.nombreImagen}</span>											
										</div>
									</div>
									<div class="linea_separadora"></div>
									<br class="oculto" />
								</div>	
								</c:if>		 					
			 				
							<div class="fila_de_tabla">
			  					<div class="contenedor_izquierda">
			  						<div class="text"><label for="SelImagen">&nbsp;</label></div>
			 					</div>
								<div class="contenedor_derecha">
									<div class="text">
										<html:radio name="form" property="activarImagen" 
										onclick="document.getElementById('SelImagen').disabled=false;														
												 document.getElementById('SelImagen').style.backgroundColor='white'
												 document.getElementById('alineaArribaIzq').disabled=false;
												 document.getElementById('alineaArribaIzq').style.backgroundColor='white'
												 document.getElementById('alineaArribaDcha').disabled=false;
												 document.getElementById('alineaArribaDcha').style.backgroundColor='white' 
												 document.getElementById('alineaAbajoIzq').disabled=false;
												 document.getElementById('alineaAbajoIzq').style.backgroundColor='white'  
												 document.getElementById('alineaAbajoDcha').disabled=false;
												 document.getElementById('alineaAbajoIzq').style.backgroundColor='white'"
										styleClass="boton_radio" value="3"></html:radio>&nbsp;
										<logic:equal name="form" property="activarImagen" value="3">
											<html:file name="form" property="imagen" style="width:320px" onblur="this.style.backgroundColor='#e1e1e1'" styleId="SelImagen" styleClass="selimagen0" titleKey="modificar.noticia.formulario.SelectImagen"></html:file>																			
										</logic:equal>
										<logic:notEqual name="form" property="activarImagen" value="3">
											<html:file disabled="true" name="form" style="width:320px" property="imagen" onblur="this.style.backgroundColor='#e1e1e1'" styleId="SelImagen" styleClass="selimagen0" titleKey="modificar.noticia.formulario.SelectImagen"></html:file>																			
										</logic:notEqual>
									</div>
								</div>		
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>							
							<!-- -->							
							
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
													<logic:notEqual name="form" property="activarImagen" value="2">
														<html:radio name="form" property="alineamiento" styleId="alineaArribaIzq" styleClass="boton_radio" value="0"></html:radio><span class="vert"><bean:message key="modificar.noticia.formulario.AlinearIzq"/></span>
													</logic:notEqual>
													<logic:equal name="form" property="activarImagen" value="2">
														<html:radio disabled="true" name="form" property="alineamiento" styleId="alineaArribaIzq" styleClass="boton_radio" value="0"></html:radio><span class="vert"><bean:message key="modificar.noticia.formulario.AlinearIzq"/></span>
													</logic:equal>													
												</td>
											</tr>
											<tr>
												<td class="td_largo_11">&nbsp;</td>
												<td valign="top">
													<logic:notEqual name="form" property="activarImagen" value="2">
														<html:radio name="form" property="alineamiento" styleId="alineaArribaDcha" styleClass="boton_radio" value="1"></html:radio><span class="vert"><bean:message key="modificar.noticia.formulario.AlinearDer"/></span>
													</logic:notEqual>	
													<logic:equal name="form" property="activarImagen" value="2">
														<html:radio disabled="true" name="form" property="alineamiento" styleId="alineaArribaDcha" styleClass="boton_radio" value="1"></html:radio><span class="vert"><bean:message key="modificar.noticia.formulario.AlinearDer"/></span>
													</logic:equal>
												</td>										
											</tr>
											<tr>
												<td class="td_largo_11" valign="top"><span class="vert"><bean:message key="noticias.crear.alinear.abajo"/>&nbsp;&nbsp;&nbsp;</span></td>
												<td valign="top">
												<logic:notEqual name="form" property="activarImagen" value="2">
													<html:radio name="form" property="alineamiento" styleId="alineaAbajoIzq" styleClass="boton_radio" value="2"></html:radio><span class="vert"><bean:message key="noticias.crear.alinear.abajo.izquierda"/></span>
												</logic:notEqual>
												<logic:equal name="form" property="activarImagen" value="2">
													<html:radio disabled="true" name="form" property="alineamiento" styleId="alineaAbajoIzq" styleClass="boton_radio" value="2"></html:radio><span class="vert"><bean:message key="noticias.crear.alinear.abajo.izquierda"/></span>
												</logic:equal>	
												</td>
											</tr>
											<tr>
												<td class="td_largo_11">&nbsp;</td>
												<td  valign="top">
												<logic:notEqual name="form" property="activarImagen" value="2">
													<html:radio name="form" property="alineamiento"  styleId="alineaAbajoDcha" styleClass="boton_radio" value="3"></html:radio><span class="vert"><bean:message key="noticias.crear.alinear.abajo.derecha"/></span>
												</logic:notEqual>
												<logic:equal name="form" property="activarImagen" value="2">
													<html:radio disabled="true" name="form" property="alineamiento"  styleId="alineaAbajoDcha" styleClass="boton_radio" value="3"></html:radio><span class="vert"><bean:message key="noticias.crear.alinear.abajo.derecha"/></span>
												</logic:equal>	
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
										<html:radio name="form" property="estado" styleClass="boton_radio" value="false" styleId="SelEstado"></html:radio><span class="vert"><bean:message key="modificar.noticia.formulario.EstadoDesact"/></span>											
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
										<html:radio name="form" property="estado" styleClass="boton_radio" value="true" styleId="SelEstado_02"></html:radio><span class="vert"><bean:message key="modificar.noticia.formulario.EstadoActiv"/></span>
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
		<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key="comun.continuar"/>" />
			<input type="hidden" name="alineamiento" value="${form.alineamiento}"/>
			<input type="hidden" name="categoria" value="${form.categoria}"/>
			<input type="hidden" name="estado" value="${form.estado}"/>	
			<input type="hidden" name="activarImagen" value="${form.activarImagen}"/>	
			<input type="hidden" name="nombreImagen" value="${form.nombreImagen}"/>			
	</form>
		<form method="post" action="<html:rewrite action="/Noticias/Noticias"/>">	
			<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="estructuras.cancelar"/>" />
		</form>		
		<!-- Fin Botones  -->
</div>
<!-- Fin plantilla contenido  -->

</tiles:put>
</tiles:insert>
