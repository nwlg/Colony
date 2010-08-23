<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado-verMetadatos">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/relacion/detalleRelacion/detalle-relacion-form-vars.jspf" %>
<!-- Inicio plantilla contenido  -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido"  id="rea">
<jsp:include page="/layout/messages.jsp" flush="true"/>
<h2><bean:message key="relaciones.Relacion"/> ${form.tituloRelacion}</h2>
<form method="post" action="<html:rewrite action="/VerMetadatos/DetalleRelacionFormVuelveDeDetalleRelacion" />" >

<p class="parrafo_comun" id="separacion2"><bean:message key="catalogadorAvanzado.General.TextoObligacion"/></p>

<!--  INICIO GLOBO GRIS Tipo  -->
<!--  INICIO GLOBO GRIS Tipo  -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >

			
			<h3><bean:message key="catalogadorAvanzado.DetalleRel.Tipo"/></h3>
			<!--  INICIO GLOBO Blanco   -->
			<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
				<!--  INICIO Fila de Campos   -->

				<!--  INICIO Fila de Campos   -->
				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda_esp">
  						<div class="text"><label for="SeleccionTipo" class="oculto">Seleccione Tipo:</label>
						<html:select disabled="true" styleClass="select_lrg" name="form" title="Seleccione Tipo" property="tipo">
					             <c:forEach  items="${form.tipoBackingList}" var="listaTipo">
					               <html:option value="${listaTipo.value }">${listaTipo.label }</html:option>
					             </c:forEach>
					    </html:select>
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!-- -->
				<!--  Fin Fila de Campos   -->
				<!--  Fin Fila de Campos   -->

				</div>
			</div>
		</div>
	</div>
<!--  Fin GLOBO Blanco   -->
<!--  Fin GLOBO Blanco   -->
	</div>
	<!--  FIN CAJA DE FORMULARIO   -->
		</div>
	</div>

</div>
</div>
<!--  FIN GLOBO GRIS Tipo  -->
<!--  FIN GLOBO GRIS Tipo  -->

<!--  INICIO GLOBO GRIS  Recurso -->
<!--  INICIO GLOBO GRIS  Recurso -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario_02" >

					
					<h3><bean:message key="catalogadorAvanzado.DetalleRel.Recurso"/></h3>
			<!--  INICIO GLOBO Blanco   -->
			<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<h3 class="int_h3"><bean:message key="catalogadorAvanzado.DetalleRel.Identificador"/></h3>

							<div class="globo_gris">
										<div class="globo_gris_01">
											<div class="globo_gris_02">
												<div class="globo_gris_03">	<!-- -->
					<!--  INICIO Fila de Campos   -->
					<!--  INICIO Fila de Campos   -->
													<div class="fila_de_tabla_especial" style="padding-left:6px !important">
														<div class="contenedor_izquierda_esp">

															<div class="text">
																<label for="Cat01"><bean:message key="catalogadorAvanzado.DetalleRel.Catalogo"/>:</label>
															</div>
														</div>
														<div class="contenedor_izquierda_esp">
															<div class="text"><label for="form" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleRel.SoloCatalogo"/>:</label>
  																<html:text readonly="true" styleClass="input_medio" property="Cat" value="${catalogo}" styleId="Cat" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.DetalleRel.Catalogo" />
															</div>

														</div>
														<div class="contenedor_izquierda_esp">
															<div class="text">
																<label for="Ent01" class="lab_ie"><bean:message key="catalogadorAvanzado.DetalleRel.Entrada"/>:</label>
															</div>
														</div>
														<div class="contenedor_izquierda_esp">
															<div class="text"><label for="form" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleRel.SoloEntrada"/>:</label>
  																<html:text readonly="true" styleClass="input_medio" property="Ent" value="${entrada}" styleId="Ent" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.DetalleRel.Entrada" />
															</div>
														</div>
														<div class="limpiar">
														</div><br class="oculto"/>
													</div>	<!--  Fin Fila de Campos   -->
					<!--  Fin Fila de Campos   -->
					<!-- -->

					<!-- -->
												</div>
											</div>
										</div>
									</div>	<!--  FIN GLOBO BLANCO   -->
<!-- -->
				</div>
		</div>
	</div>

</div>

<!--  Fin GLOBO Blanco Recurso  -->
<!--  Fin GLOBO Blanco Recurso  -->

<!--  INICIO GLOBO Blanco  Descripcion -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco  conmargen" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<h3 class="h3flotante"><bean:message key="catalogadorAvanzado.DetalleRel.Descripcion"/></h3>
							<c:set var="longDescripcionAnterior" value="0"/> 							
<logic:iterate id="descripcion" name="descripcion" indexId="i">	
												
							
							<!--  INICIO GLOBO GRIS   -->
							<!--  INICIO GLOBO GRIS   -->
									<div class="globo_gris globito flotder" >
										<div class="globo_gris_01">
											<div class="globo_gris_02">
												<div class="globo_gris_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
							<c:set var="textos" value="${descripcion.textos }"/>
							<c:set var="longDescripcion" value="${ fn:length(textos) }"/>				
							<logic:iterate id="contenido" name="textos" indexId="j">
							<c:set var="indice" value="${j + longDescripcionAnterior}"/>
						<div class="fila_de_tabla_especial_02" >

  					<div class="contenedor_izquierda_esp" >
  						<div class="text">
  							<label for="Des${i}" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleRel.SoloDescripcion"/>:</label>
								<html:textarea readonly="true" styleClass="input_medio_largo input_mder" property="Des${i}_Tex${j}" value="${contenido.texto}" styleId="Des${i}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.DetalleRel.SoloDescripcion" cols="5" rows="4"  />
						</div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text"><label for="Idio01" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleRel.SoloIdioma"/>:</label>
						<html:select disabled="true" styleClass="select_peq_n inp_se_ie" name="form" property="Des${i}_Idio${j}" value="${contenido.idioma}" >
									<c:forEach  items="${form.comboIdiomaBackingList}" var="idiomaValor">
											<html:option value="${ idiomaValor.value}">${idiomaValor.label}</html:option>
									</c:forEach>
							</html:select>
						</div>
					</div>
					<div class="float_izquierda_n">

							<c:choose>
								<c:when test="${j==0}">   
									<span class="oculto">-</span> 
	
								
								</c:when>
								<c:otherwise>
									&nbsp;
								</c:otherwise>
							</c:choose>
						</div>
						<div class="float_izquierda_n">
							<c:set var="longitud" value="${ longDescripcion }"/>
						<c:choose>
							<c:when test="${longitud>1}">   
								<span class="oculto">-</span>

							</c:when>
							<c:otherwise>
								&nbsp;
							</c:otherwise>
						</c:choose>	
						</div>
					<div class="limpiar"></div>
					<br class="oculto" />

				</div>	
				</logic:iterate>
				<!--  Fin Fila de Campos   -->
				<!--  Fin Fila de Campos   -->
				
				</div>

		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

								<!--  Enlaces de fuera   -->
								<!--  Enlaces de fuera   -->
									<div class="flotder" >
										<c:choose>
											<c:when test="${i==0}">   
												<span class="oculto">-</span>	
												<span class="flotder enlace_anadir_02">
				
												</span>
											</c:when>
											<c:otherwise>
												<span class="oculto">-</span>	
												<span class="flotder enlace_anadir_02">											
												&nbsp;
												</span>
											</c:otherwise>
										</c:choose>	
										<c:set var="longitud" value="${ fn:length(form.descripcion) }"/>
										<c:choose>
											<c:when test="${longitud>1}">   
												<span class="oculto">-</span>	
												<span class="flotder enlace_eliminar_02">
				
												</span>
											</c:when>
											<c:otherwise>
												<span class="oculto">-</span>	
												<span class="flotder enlace_eliminar_02">
												&nbsp;
												</span>
											</c:otherwise>
										</c:choose>
									</div>
									<!--  Fin Enlaces de fuera   -->
								<!--  Fin Enlaces de fuera   -->

									<div class="limpiar">&nbsp;</div>
</logic:iterate>
							
							
							

				</div>
		</div>
	</div>
</div>

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
<fieldset class="tipo ft_centrada">
	<button class="boton_125" type="submit" name="accion" value="<bean:message key="verAvanzado.volver"/>" >
		<bean:message key="verAvanzado.volver"/>
	</button> 
</fieldset>
</form>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</div>
<!-- Fin plantilla contenido  -->
</tiles:put>

</tiles:insert>
