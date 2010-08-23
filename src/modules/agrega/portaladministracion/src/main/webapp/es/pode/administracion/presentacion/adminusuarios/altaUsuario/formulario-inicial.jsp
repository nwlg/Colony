<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>


<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2><bean:message key="usuarios.alta.cabecera"/></h2>


<!--		Inicio del formulario principal		-->

<form id="altaUsuarioFormularioInicialContinuarForm" action='<html:rewrite action="/AltaUsuario/FormularioInicialContinuar"/>' method="post" >
	
	
	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
					
					
					<!--		INICIO CAJA DE FORMULARIO (Datos personales)		-->
					
					<div id="formulario" >
				
				
						<!--		INICIO GLOBO Blanco		-->
						
						<div class="globo_blanco" >
							<div class="globo_blanco_01">
								<div class="globo_blanco_02">
									<div class="globo_blanco_03">
									
										<h3><bean:message key="usuarios.datosPersonales"/></h3>

										
			  							<!-- 		CAMPO NOMBRE		-->
			  							
										<div class="fila_de_tabla">
			  								<div class="contenedor_izquierda">
			  									<div class="text"><label for="Nombre">*<bean:message key="usuarios.nombre"/></label></div>
			 								</div>
											<div class="contenedor_derecha">
												<div class="text">
													<input name="nombre" value="${form.nombre}" id="Nombre" maxlength="50" type="text" title="<bean:message key='usuarios.introduzcaNombre' />" />
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>

										
										<!-- 		CAMPO PRIMER APELLIDO		-->
										
										<div class="fila_de_tabla">
			  								<div class="contenedor_izquierda">
			  									<div class="text"><label for="Apellido1">*<bean:message key="usuarios.apellido1"/></label></div>
			 								</div>
											<div class="contenedor_derecha">
												<div class="text">
													<input name="apellido1" value="${form.apellido1}" id="Apellido1" maxlength="50" type="text" title="<bean:message key='usuarios.introduzcaApellido1'/>"  />
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>
										
										
										<!-- 		CAMPO SEGUNDO APELLIDO		-->
										
										<div class="fila_de_tabla">
			  								<div class="contenedor_izquierda">
			  									<div class="text"><label for="Apellido2"><bean:message key="usuarios.apellido2"/></label></div>
			 								</div>
											<div class="contenedor_derecha">
												<div class="text">
													<input name="apellido2" value="${form.apellido2}" id="Apellido2" maxlength="50" type="text" title="<bean:message key='usuarios.introduzcaApellido2'/>"  />
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>

										
										<!-- 		CAMPO NIF		-->
										
										<div class="fila_de_tabla">
						  					<div class="contenedor_izquierda">
					  							<div class="text"><label for="NIF"><bean:message key="usuarios.NIF"/></label></div>
					 						</div>
											<div class="contenedor_derecha">
												<div class="text">
													<input name="nif" value="${form.nif}" id="NIF" maxlength="11" type="text" title="<bean:message key="usuarios.introduzcaNIF"/>"  />
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>

										
										<!--		CAMPO EMAIL		 -->
										
										<div class="fila_de_tabla">
					  						<div class="contenedor_izquierda">
					  							<div class="text"><label for="Email">*<bean:message key="usuarios.mail"/></label></div>
					 						</div>
											<div class="contenedor_derecha">
												<div class="text">
													<input name="email" value="${form.email}" id="Email" maxlength="100" type="text" title="<bean:message key="usuarios.introduzcaMail"/>"  />
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>
						

									</div>
								</div>
							</div>
						</div>
						
						<!--		Fin GLOBO Blanco		-->
						
						
					</div>
					
					<!--		FIN CAJA DE FORMULARIO (Datos personales)		-->
					
					
					<!--		INICIO CAJA DE FORMULARIO 2 (Datos de acceso)		-->
					
					<div id="formulario_02" >
					
					
						<!--		INICIO GLOBO Blanco		-->
						
						<div class="globo_blanco" >
							<div class="globo_blanco_01">
								<div class="globo_blanco_02">
									<div class="globo_blanco_03">
							
										<h3><bean:message key="usuarios.datosAcceso"/></h3>
										
										
	  									<!-- 		CAMPO DE USUARIO		-->
	  									
										<div class="fila_de_tabla">
	  										<div class="contenedor_izquierda">
	  											<div class="text"><label for="Usuario">*<bean:message key="usuarios.usuario"/></label></div>
	 										</div>
											<div class="contenedor_derecha">
												<div class="text">
													<input name="usuario" value="${form.usuario}" id="Usuario" maxlength="25" type="text" title="<bean:message key="usuarios.introduzcaUsuario"/> "  />
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>
										
										
										<!-- 		CAMPO DE CONTRASEÑA			-->
										
										<div class="fila_de_tabla">
						  					<div class="contenedor_izquierda">
						  						<div class="text"><label for="Contrasenia">*<bean:message key="usuarios.clave"/></label></div>
						 					</div>
											<div class="contenedor_derecha">
												<div class="text">
													<input type="password" name="clave" value="" id="Contrasenia" maxlength="20" title="<bean:message key="usuarios.introduzcaClave"/>"  />
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>
										
										
										<!-- 		CAMPO DE CONFIRMACION CONTRASEÑA		-->
										
										<div class="fila_de_tabla">
						  					<div class="contenedor_izquierda">
						  						<div class="text"><label for="ConfContrasenia">*<bean:message key="usuarios.confirmarClave"/></label></div>
						 					</div>
											<div class="contenedor_derecha">
												<div class="text">
													<input type="password" name="repitaClave" value="" id="ConfContrasenia" maxlength="20" title="<bean:message key="usuarios.introduzcaClave"/> "  />
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>
										
										
										<!-- 		CAMPO DE IDENTIFICADOR OPENID		-->
										
										<div class="fila_de_tabla">
						  					<div class="contenedor_izquierda">
						  						<div class="text"><label for="openIdUrl"><bean:message key="usuarios.openIdUrl"/></label></div>
						 					</div>
											<div class="contenedor_derecha">
												<div class="text">
													<input type="text" name="openIdUrl" value="${form.openIdUrl}" id="openIdUrl" maxlength="100" title="<bean:message key="usuarios.introduzcaopenIdUrl"/> "  />
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>
											
									</div>
								</div>
							</div>
						</div>
						
						<!--		Fin GLOBO Blanco		-->
					
					
					</div>
					
					<!--		FIN CAJA DE FORMULARIO 2 (Datos de acceso)		-->
					
					
					<!--		INICIO CAJA DE FORMULARIO 3 (Preferencias)		-->
					
					<div id="formulario_03" >
					
					
						<!--		INICIO GLOBO Blanco		-->
						
						<div class="globo_blanco" >
							<div class="globo_blanco_01">
								<div class="globo_blanco_02">
									<div class="globo_blanco_03">
									
										<h3><bean:message key="usuarios.preferencias"/></h3>
										
										
					  					<!--		CAMPO DE TIPO DE EMPAQUETADOR		 -->
					  					
										<div class="fila_de_tabla">
						  					<div class="contenedor_izquierda">
						  						<div class="text"><label for="Editor">*<bean:message key="usuarios.tipoDeEmpaquetador"/></label></div>
						 					</div>
											<div class="contenedor_derecha">
												<div class="text">
												
													<html:select name="form" property="tipoEmpaquetador" titleKey="usuarios.seleccioneEmpaquetador" styleId="Editor">
														<html:option key="usuarios.basico" value="basico" />
														<html:option key="usuarios.avanzado" value="avanzado" styleClass="oscura" />
													</html:select>
											
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>
										
										
										<!--		CAMPO DE TIPO DE CATALOGADOR		 -->
					  					
										<div class="fila_de_tabla">
						  					<div class="contenedor_izquierda">
						  						<div class="text"><label for="Editor">*<bean:message key="usuarios.tipoCatalogador"/></label></div>
						 					</div>
											<div class="contenedor_derecha">
												<div class="text">
												
													<html:select name="form" property="tipoCatalogador" titleKey="usuarios.seleccioneCatalogador" styleId="Editor">
														<html:option key="usuarios.basico" value="basico" />
														<html:option key="usuarios.basicplus" value="basicplus" />
														<html:option key="usuarios.avanzado" value="avanzado" styleClass="oscura" />
													</html:select>
											
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>
										
										
										<!--		CAMPO DE CUOTA		 -->
					  					
										<div class="fila_de_tabla">
						  					<div class="contenedor_izquierda">
						  						<div class="text"><label for="cuota"><bean:message key="usuarios.cuota"/></label></div>
						 					</div>
											<div class="contenedor_derecha">
												<div class="text">
												
													<input type="text" name="cuota" style="width:50px" value="" id="cuota" maxlength="5" title="<bean:message key="usuarios.IntroduzcaCuota"/> "  />
													<bean:message key="usuarios.Mb"/>
											
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>
										
											
										<!-- 		CAMPO DE IDIOMA DE CONSULTA			-->
										
										<div class="fila_de_tabla">
						  					<div class="contenedor_izquierda">
						  						<div class="text"><label for="Idiomaconsultas">*<bean:message key="usuarios.idiomaConsultas"/></label></div>
						 					</div>
											<div class="contenedor_derecha">
												<div class="text">
												
													<c:choose>
						                               <c:when test="${!empty form.idiomaBackingList}">
						                                  <html:select name="form" property="idioma"  titleKey="usuarios.seleccioneIdiomaConsultas" styleId="Idiomaconsultas">
						                                      <html:optionsCollection name="form" property="idiomaBackingList" label="label" value="value"/>
						                                  </html:select>
						                               </c:when>
						                               <c:otherwise>
						                                   <html:select name="form" property="idioma"  styleId="Idiomaconsultas"/>
						                               </c:otherwise>
						                           </c:choose>
												
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>
										
											
										<!--		CAMPO DE IDIOMA DE APLICACION		 -->
										
										<div class="fila_de_tabla">
						  					<div class="contenedor_izquierda">
						  						<div class="text"><label for="Idiomaaplicaciones">*<bean:message key="usuarios.idiomaAplicacion"/></label></div>
						 					</div>
											<div class="contenedor_derecha">
												<div class="text">
												
													<c:choose>
						                               <c:when test="${!empty form.idiomaBusquedaBackingList}">
						                                  <html:select name="form" property="idiomaBusqueda"  titleKey="usuarios.seleccioneIdiomaAplicacion" styleId="Idiomaaplicaciones">
						                                      <html:optionsCollection name="form" property="idiomaBusquedaBackingList" label="label" value="value"/>
						                                  </html:select>
						                               </c:when>
						                               <c:otherwise>
						                                   <html:select name="form" property="idiomaBusqueda" styleId="Idiomaaplicaciones"/>
						                               </c:otherwise>
						                           </c:choose>
												
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>	
										
										
									</div>
								</div>
							</div>
						</div>
						
						<!--		Fin GLOBO Blanco		-->
						
			
					</div>
					
					<!--		FIN CAJA DE FORMULARIO 3 (Preferencias)		-->
					
					
				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->
	
	
	<!--		Boton Siguiente		-->
	
	<input class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key='usuarios.siguiente'/>" />
	
	
</form>

<!--		Fin del Formulario principal		-->


<!--		Inicio formulario secundario y boton Cancelar		-->
	
<form id="altaUsuarioFormularioInicialCancelarForm" action="<html:rewrite action='/AltaUsuario/FormularioInicialCancelar'/>" method="post" >
	<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key='usuarios.cancelar'/>" />
</form>
	
<!--		Fin formulario secundario		-->
	

</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>
