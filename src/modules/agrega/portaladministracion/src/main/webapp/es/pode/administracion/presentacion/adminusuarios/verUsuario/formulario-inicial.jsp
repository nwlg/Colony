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

<h2><bean:message key="usuarios.verUsuario.cabecera"/></h2>


<!--		Inicio del formulario principal		-->

<form id="verUsuarioFormularioInicialAceptarForm" action='<html:rewrite action="/VerUsuario/FormularioInicialAceptar"/>' method="post" >
	
	
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
			  									<div class="text"><label for="Nombre"><bean:message key="usuarios.nombre"/></label></div>
			 								</div>
											<div class="contenedor_derecha">
												<div class="text">
													<input DISABLED style="background-color:white" name="nombre" value="${form.nombre}" id="Nombre" maxlength="50" type="text" />
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>

										
										<!-- 		CAMPO PRIMER APELLIDO		-->
										
										<div class="fila_de_tabla">
			  								<div class="contenedor_izquierda">
			  									<div class="text"><label for="Apellido1"><bean:message key="usuarios.apellido1"/></label></div>
			 								</div>
											<div class="contenedor_derecha">
												<div class="text">
													<input DISABLED style="background-color:white" name="apellido1" value="${form.apellido1}" id="Apellido1" maxlength="50" type="text" />
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
													<input DISABLED style="background-color:white" name="apellido2" value="${form.apellido2}" id="Apellido2" maxlength="50" type="text" />
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
													<input DISABLED style="background-color:white" name="NIF" value="${form.NIF}" id="NIF" maxlength="11" type="text" />
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>

										
										<!--		CAMPO EMAIL		 -->
										
										<div class="fila_de_tabla">
					  						<div class="contenedor_izquierda">
					  							<div class="text"><label for="Email"><bean:message key="usuarios.mail"/></label></div>
					 						</div>
											<div class="contenedor_derecha">
												<div class="text">
													<input DISABLED style="background-color:white" name="email" value="${form.email}" id="Email" maxlength="100" type="text" />
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
	  											<div class="text"><label for="Usuario"><bean:message key="usuarios.usuario"/></label></div>
	 										</div>
											<div class="contenedor_derecha">
												<div class="text">
													<input DISABLED style="background-color:white" name="usuario" value="${form.usuario}" id="Usuario" maxlength="25" type="text" />
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
													<input DISABLED  style="background-color:white" name="openIdUrl" value="${form.openIdUrl}" id="openIdUrl" maxlength="100" type="text"  />
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
						  						<div class="text"><label for="TipoEmpaquetador"><bean:message key="usuarios.tipoDeEmpaquetador"/></label></div>
						 					</div>
											<div class="contenedor_derecha">
												<div class="text">
													<bean:define id="tipoEmpaquetadorValue"><bean:message key="usuarios.${form.tipoEmpaquetador}"/></bean:define>
													<input DISABLED style="background-color:white" name="tipoEmpaquetador" value="${tipoEmpaquetadorValue}" id="TipoEmpaquetador" type="text" />
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>
										
										
										<!--		CAMPO DE TIPO DE CATALOGADOR		 -->
					  					
										<div class="fila_de_tabla">
						  					<div class="contenedor_izquierda">
						  						<div class="text"><label for="tipoCatalogador"><bean:message key="usuarios.tipoCatalogador"/></label></div>
						 					</div>
											<div class="contenedor_derecha">
												<div class="text">
													
													<bean:define id="tipoCatalogadorValue"><bean:message key="usuarios.${form.tipoCatalogador}"/></bean:define>
													<input DISABLED style="background-color:white" name="tipoCatalogador" value="${tipoCatalogadorValue}" id="TipoCatalogador" type="text" />
											
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
												
													<input DISABLED type="text" style="background-color:white;width:50px" name="cuota" value="${form.cuota}" id="cuota" maxlength="5"  />
													<bean:message key="usuarios.Mb"/>
											
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>

											
										<!--		CAMPO DE IDIOMA DE APLICACION		 -->
										
										<div class="fila_de_tabla">
						  					<div class="contenedor_izquierda">
						  						<div class="text"><label for="Idioma"><bean:message key="usuarios.idiomaAplicacion"/></label></div>
						 					</div>
											<div class="contenedor_derecha">
												<div class="text">
													<bean:define id="idiomaValue"><bean:message key="crearTarea.${form.idioma}"/></bean:define>
													<input DISABLED style="background-color:white" name="idioma" value="${idiomaValue}" id="Idioma" type="text"  />
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>	
										<!-- 		CAMPO DE IDIOMA DE CONSULTA			-->
										
										<div class="fila_de_tabla">
						  					<div class="contenedor_izquierda">
						  						<div class="text"><label for="IdiomaBusqueda"><bean:message key="usuarios.idiomaConsultas"/></label></div>
						 					</div>
											<div class="contenedor_derecha">
												<div class="text">
													<bean:define id="idiomaBusquedaValue"><bean:message key="crearTarea.${form.idiomaBusqueda}"/></bean:define>
													<input DISABLED style="background-color:white" name="idiomaBusqueda" value="${idiomaBusquedaValue}" id="IdiomaBusqueda" type="text" />
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
					
					
					<!--		INICIO CAJA DE FORMULARIO 4 (tabla de permisos)		-->
				
					<div id="formulario_03" >
					
					
						<!--		INICIO GLOBO Blanco		-->
						
						<div class="globo_blanco" >
							<div class="globo_blanco_01">
								<div class="globo_blanco_02">
									<div class="globo_blanco_03">
							
										<h3><bean:message key="grupos.cabecera"/></h3>
	  									
	  									
	  									<!-- 		Inicio Caja Tabla		 -->
	  									
										<div class="caja_tabla">
	  										
	  										
	  										<display:table name="${form.grupos}" uid="fila" requestURI="${pageContext.request.requestURL}"
										        export="false" sort="list" style="border:1;width:100%;" class="administracion_tareas"
												cellpadding="0" cellspacing="0" summary="${summary}">
												
												<display:setProperty name="css.tr.odd" value="tr_gris"/>
												<display:setProperty name="css.tr.even" value="tr_blanco"/>
												<display:setProperty name="basic.show.header" value="true"/>
												
												
												<!--		Columna de Usuario		-->
												
												<display:column style="valign:top;" class="tar14" >
													${fila.descripcion}
												</display:column>
	  										
	  										</display:table>
	  										
	  										
										</div>
										
										<!--		Fin Caja Tabla 		-->
										
										
									</div>
								</div>
							</div>
						</div>
						
						<!--		Fin GLOBO Blanco		-->
						
						
					</div>
					
					<!--		FIN CAJA DE FORMULARIO 4(tala de permisos)	-->
					
					
					
					<!--		INICIO CAJA DE FORMULARIO 5 (tabla de grupos de trabajo)		-->
				
					<div id="formulario_03" >
					
					
						<!--		INICIO GLOBO Blanco		-->
						
						<div class="globo_blanco" >
							<div class="globo_blanco_01">
								<div class="globo_blanco_02">
									<div class="globo_blanco_03">
							
										<h3><bean:message key="gruposTrabajo.cabecera"/></h3>
	  									
	  									
	  									<!-- 		Inicio Caja Tabla		 -->
	  									
										<div class="caja_tabla">
	  										
	  										
	  										<display:table name="${form.gruposTrabajo}" uid="fila" requestURI="${pageContext.request.requestURL}"
										        export="false" sort="list" style="border:1;width:100%;" class="administracion_tareas"
												cellpadding="0" cellspacing="0" summary="${summary}">
												
												<display:setProperty name="css.tr.odd" value="tr_gris"/>
												<display:setProperty name="css.tr.even" value="tr_blanco"/>
												<display:setProperty name="basic.show.header" value="true"/>
												
												
												<!--		Columna de Usuario		-->
												
												<display:column style="valign:top;" class="tar14" >
													${fila.nombre}
												</display:column>
	  										
	  										</display:table>
	  										
	  										
										</div>
										
										<!--		Fin Caja Tabla 		-->
										
										
									</div>
								</div>
							</div>
						</div>
						
						<!--		Fin GLOBO Blanco		-->
						
						
					</div>
					
					<!--		FIN CAJA DE FORMULARIO 5(tala de grupos de trabajo)	-->
					
					
				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->
	
	
	<!--		Boton Siguiente		-->
	
	<input class="boton_125 tipo"  type="submit"  value="<bean:message key='usuarios.volver'/>" />
	
	
</form>

<!--		Fin del Formulario principal		-->
	

</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>