<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado-verMetadatos">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">


<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" id="rea">
<jsp:include page="/layout/messages.jsp" flush="true"/>
<h2><bean:message key="educaciones.Educacion"/> ${form.tituloUsoEducativo}</h2>
<form method="post" action="<html:rewrite action="/VerMetadatos/DetalleUsoEducativoFormVuelveDeDetalleUsoEducativo" />" >
<p class="parrafo_comun" id="separacion2"><bean:message key="catalogadorAvanzado.General.TextoObligacion"/></p>





<!--  INICIO GLOBO GRIS Tipo de Interactividad   -->
<!--  INICIO GLOBO GRIS Tipo de Interactividad  -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.TipoInteractividad"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco pos_relative conmargen" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="Interactividad01" class="oculto" >Tipo:</label>
							<html:select disabled="true" styleClass="select_lrg" name="form" title="Seleccione Interactividad" property="tipoInteractividad">
					             <c:forEach  items="${form.tipoInteractividadBackingList}" var="listaTipoInteractividad">
					               <html:option value="${listaTipoInteractividad.value }">${listaTipoInteractividad.label }</html:option>
					             </c:forEach>
					        </html:select>
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  FIn Fila de Campos   -->
				<!--  fIN Fila de Campos   -->
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
<!--  FIN GLOBO GRIS  Tipo de Interactividad -->
<!--  FIN GLOBO GRIS  Tipo de Interactividad -->




<!--  INICIO GLOBO GRIS Tipo de Recurso de Aprendizaje  -->
<!--  INICIO GLOBO GRIS Tipo de Recurso de Aprendizaje  -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
		<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.TipoRecurso"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
<logic:iterate id="recurso" property="tipoRecurso" name="form" indexId="i">
			<div class="globo_blanco globito flotder" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
							
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp">
  						<div class="text"><label for="Tipo01" class="oculto" >Idioma:</label>
							<html:select disabled="true" styleClass="select_lrg inp_se_ie " style="width:420px !important" name="form" title="Seleccione Tipo" property="TRecur${i}" value="${recurso.valor}" >
								<c:forEach  items="${form.comboTipoRecursoBackingList}" var="listaRecurso">
                            	 	<html:option value="${listaRecurso.value }">${listaRecurso.label }</html:option>
 		                  		</c:forEach>
							</html:select>
						</div>
					</div>

					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				
				<!--  Fin Fila de Campos   -->
				<!--  Fin Fila de Campos   -->	
				<!--  FIN GLOBO BLANCO   -->
				<!--  FIN GLOBO BLANCO   -->
			</div>
		</div>
	</div>
</div>

					<div class="flotder">
						<c:choose>
                			<c:when test="${i==0}">   
		                        <span class="oculto">-</span> 
		                        

             				</c:when>
	                        <c:otherwise>
             					&nbsp;
	                        </c:otherwise>
             			</c:choose>
					</div>
					<div class="flotder">
						<c:set var="longitud" value="${ fn:length(form.tipoRecurso) }"/>
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
</logic:iterate>
</div>
			
<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS  Tipo de Recurso de Aprendizaje -->
<!--  FIN GLOBO GRIS   -->

<!--  INICIO GLOBO GRIS Nivel    -->
<!--  INICIO GLOBO GRIS Nivel   -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.NivelInteractividad"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco pos_relative conmargen" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="Interactividad02" class="oculto" >Interactividad:</label>
							<html:select disabled="true" styleClass="select_lrg" name="form" title="Seleccione Nivel Interactividad" property="nivelInteractividad">
					             <c:forEach  items="${form.nivelInteractividadBackingList}" var="listaNivelInteractividad">
					               <html:option value="${listaNivelInteractividad.value }">${listaNivelInteractividad.label }</html:option>
					             </c:forEach>
					        </html:select>
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  FIn Fila de Campos   -->
				<!--  fIN Fila de Campos   -->
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
<!--  FIN GLOBO GRIS Nivel    -->
<!--  FIN GLOBO GRIS Nivel   -->


<!--  INICIO GLOBO GRIS Densidad  -->
<!--  INICIO GLOBO GRIS Densidad  -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.DensidadSemantica"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco pos_relative conmargen" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="Densidad01" class="oculto" >Densidad:</label>
							<html:select disabled="true" styleClass="select_lrg" name="form" title="Seleccione Densidad Semántica" property="densidadSemantica">
					             <c:forEach  items="${form.densidadSemanticaBackingList}" var="listaDensidad">
					               <html:option value="${listaDensidad.value }">${listaDensidad.label }</html:option>
					             </c:forEach>
					        </html:select>
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  FIn Fila de Campos   -->
				<!--  fIN Fila de Campos   -->
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
<!--  FIN GLOBO GRIS Densidad  -->
<!--  FIN GLOBO GRIS Densidad  -->


<!--  INICIO GLOBO GRIS Rol Usuario  -->
<!--  INICIO GLOBO GRIS Rol Usuario  -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.RolUsuario"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
	<logic:iterate id="rol" property="rolUsuario" name="form" indexId="i">
			<div class="globo_blanco globito flotder" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
							
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp">
  						<div class="text"><label for="Rol01" class="oculto" >Rol usuario:</label>
							<html:select disabled="true" style="width:420px !important" styleClass="select_lrg inp_se_ie " name="form" title="Seleccione Rol Usuario Final" property="Rol${i}" value="${rol.valor}" >
								<c:forEach  items="${form.comboRolBackingList}" var="listaRoles">
                            	 	<html:option value="${listaRoles.value }">${listaRoles.label }</html:option>
 		                  		</c:forEach>
							</html:select>
						</div>
					</div>

					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				
				<!--  Fin Fila de Campos   -->
				<!--  Fin Fila de Campos   -->
				<!--  FIN GLOBO BLANCO   -->
				<!--  FIN GLOBO BLANCO   -->
				</div>
		</div>
	</div>
</div>
					<div class="flotder">
						<c:choose>
                			<c:when test="${i==0}">   
		                        <span class="oculto">-</span> 
		                        

             				</c:when>
	                        <c:otherwise>
             					&nbsp;
	                        </c:otherwise>
             			</c:choose>
					</div>
					<div class="flotder">
						<c:set var="longitud" value="${ fn:length(form.rolUsuario) }"/>
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
</logic:iterate>
</div>
		<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS Rol Usuario  -->
<!--  FIN GLOBO GRIS Rol Usuario  -->


<!--  INICIO GLOBO GRIS Contexto  -->
<!--  INICIO GLOBO GRIS Contexto  -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.Contexto"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
<logic:iterate id="context" property="contexto" name="form" indexId="i">
			<div class="globo_blanco globito flotder" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
							
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp">
  						<div class="text"><label for="Contexto01" class="oculto" >Contexto:</label>
							<html:select disabled="true" style="width:420px !important" styleClass="select_lrg inp_se_ie " name="form" title="Seleccione Contexto" property="Contxt${i}" value="${context.valor}" >
								<c:forEach  items="${form.comboContextoBackingList}" var="listaContexto">
                            	 	<html:option value="${listaContexto.value }">${listaContexto.label }</html:option>
 		                  		</c:forEach>
							</html:select>
						</div>
					</div>

					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				
				<!--  Fin Fila de Campos   -->
				<!--  Fin Fila de Campos   -->
				<!--  FIN GLOBO BLANCO   -->
				<!--  FIN GLOBO BLANCO   -->
				</div>
		</div>
	</div>
</div>
					<div class="flotder">
						<c:choose>
                			<c:when test="${i==0}">   
		                        <span class="oculto">-</span> 
		                        

             				</c:when>
	                        <c:otherwise>
             					&nbsp;
	                        </c:otherwise>
             			</c:choose>
					</div>
					<div class="flotder">
						<c:set var="longitud" value="${ fn:length(form.contexto) }"/>
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
</logic:iterate>
</div>
		<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS Contexto  -->
<!--  FIN GLOBO GRIS Contexto  -->

<!--  INICIO GLOBO GRIS  Edad Típica -->
<!--  INICIO GLOBO GRIS Edad Típica  -->
				<div class="globo_gris conmargen">
					<div class="globo_gris_01">
						<div class="globo_gris_02">
							<div class="globo_gris_03">	<!--  INICIO CAJA DE FORMULARIO   -->
								<div class="formu">
									<h3 class="h3flotante"><bean:message key="catalogadorAvanzado.DetalleEdu.EdadTipica"/></h3>
									<c:set var="longEdadAnterior" value="0"/>
									<logic:iterate id="edad" property="edadTipica" name="form" indexId="i">
									<!--  INICIO GLOBO BLANCO   -->
									<!--  INICIO GLOBO BLANCO   -->
									<div class="globo_blanco globito flotder">
										<div class="globo_blanco_01">
											<div class="globo_blanco_02">
												<div class="globo_blanco_03">	<!--  INICIO Fila de Campos   -->
								<!--  INICIO Fila de Campos   -->
										<c:set var="textos" value="${edad.textos }"/>
										<c:set var="longEdad" value="${ fn:length(textos) }"/>				
										<logic:iterate id="contenido" name="textos" indexId="j">
											<c:set var="indice" value="${j + longEdadAnterior}"/>
													<div class="fila_de_tabla_especial_03">
														<div class="contenedor_izquierda_esp">
															<div class="text">
															<label for="Edad${j}" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloEdadTipica"/>:</label>
															<html:text readonly="true" styleClass="input_medio_largo input_mder" property="Edad${i}_Tex${j}" value="${contenido.texto}" styleId="Edad${i}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.DetalleEdu.SoloEdadTipica"/>
															</div>
														</div>
														<div class="contenedor_izquierda_esp">
															<div class="text">
																<label for="Idio05" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloIdioma"/>:</label>
																<html:select disabled="true" styleClass="select_peq_n inp_se_ie" name="form" property="Edad${i}_Idio${j}" value="${contenido.idioma}" >
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
															<c:set var="longitud" value="${ longEdad }"/>
															<c:choose>
																<c:when test="${longitud>1}">   
																	<span class="oculto">-</span>
																	

																</c:when>
																<c:otherwise>
																	&nbsp;
																</c:otherwise>
															</c:choose>	 
														</div>
														<div class="limpiar">
														</div><br class="oculto"/>
													</div>
										</logic:iterate>	
										<c:set var="longDescripcionAnterior" value="${ longEdad + longEdadAnterior }"/>
				    <!--  Fin Fila de Campos   -->
					<!--  Fin Fila de Campos   -->
												</div>
											</div>
										</div>
									</div>	
	<!--  FIN GLOBO GRIS   -->
	<!--  FIN GLOBO GRIS   -->
									<!--  Enlaces de fuera   -->
									<div class="flotder">
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
										<c:set var="longitud" value="${ fn:length(form.edadTipica) }"/>
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
									<div class="limpiar">
									</div>
									</logic:iterate>
								</div>	
								<!--  FIN CAJA DE FORMULARIO   -->							
							</div>
						</div>
					</div>
				</div>	<!--  FIN GLOBO GRIS   -->
	<!--  FIN GLOBO GRIS   -->

<!--  INICIO GLOBO GRIS Dificultad -->
<!--  INICIO GLOBO GRIS Dificultad  -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.Dificultad"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco pos_relative conmargen" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="Dificultad01" class="oculto" >Tipo:</label>
							<html:select disabled="true" styleClass="select_lrg" name="form" title="Seleccione Dificultad" property="dificultad">
					             <c:forEach  items="${form.dificultadBackingList}" var="listaDificultad">
					               <html:option value="${listaDificultad.value }">${listaDificultad.label }</html:option>
					             </c:forEach>
					        </html:select>
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  FIn Fila de Campos   -->
				<!--  fIN Fila de Campos   -->
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
<!--  FIN GLOBO GRIS Dificultad  -->
<!--  FIN GLOBO GRIS Dificultad  -->

<!--  INICIO GLOBO GRIS  Tiempo de Aprendizaje Típico  -->
<!--  INICIO GLOBO GRIS  Tiempo de Aprendizaje Típico  -->
<div class="globo_gris pos_relative conmargen" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
			
			<h3><bean:message key="catalogadorAvanzado.DetalleEdu.TiempoAprendizaje"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco pos_relative conmargen" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="AnioDur" class="rdr" ><bean:message key="catalogadorAvanzado.DetalleEdu.Años"/>:</label>
							<html:text readonly="true"  styleClass="in_peq input_mder2 acentrado" property="Anyos" value="${anyo}" styleId="Anyos" onfocus="limpiarTexto(this)" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.DetalleEdu.Años"/>
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="MesDur" class="rdr" ><bean:message key="catalogadorAvanzado.DetalleEdu.Meses"/>:</label>
							<html:text readonly="true"  styleClass="in_peq input_mder2 acentrado" property="Meses" value="${mes}" styleId="Meses" onfocus="limpiarTexto(this)" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.DetalleEdu.Meses"/>						
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="DiaDur" class="rdr" ><bean:message key="catalogadorAvanzado.DetalleEdu.Dias"/>:</label>
							<html:text readonly="true"  styleClass="in_peq input_mder2 acentrado" property="Dias" value="${dia}" styleId="Anyos" onfocus="limpiarTexto(this)" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.DetalleEdu.Dias"/>
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="HoraDur" class="rdr" ><bean:message key="catalogadorAvanzado.DetalleEdu.Horas"/>:</label>
							<html:text readonly="true"  styleClass="in_peq input_mder2 acentrado" property="Horas" value="${hora}" styleId="Horas" onfocus="limpiarTexto(this)" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.DetalleEdu.Horas"/>
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="MinutosDur" class="rdr" ><bean:message key="catalogadorAvanzado.DetalleEdu.Minutos"/>:</label>
							<html:text readonly="true"  styleClass="in_peq input_mder2 acentrado" property="Minutos" value="${minutos}" styleId="Minutos" onfocus="limpiarTexto(this)" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.DetalleEdu.Minutos"/>
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="SegundosDur" class="rdr" ><bean:message key="catalogadorAvanzado.DetalleEdu.Segundos"/>:</label>
							<html:text readonly="true"  styleClass="in_peq input_mder2 acentrado" property="SegundosP1" value="${segundosP1}" styleId="SegundosP1" onfocus="limpiarTexto(this)" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.DetalleEdu.Segundos"/>
						</div>
					</div>
					<div class="contenedor_izquierda_esp " >
					<div class="text input_mder2">.</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="SegundosDur2" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.Segundos"/>:</label>
							<html:text readonly="true"  styleClass="in_peq input_mder2 acentrado" property="SegundosP2" value="${segundosP2}" styleId="SegundosP2" onfocus="limpiarTexto(this)" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.DetalleEdu.Segundos"/>
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  FIn Fila de Campos   -->
				<!--  fIN Fila de Campos   -->
				</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO BLANCO   -->
<!--  FIN GLOBO BLANCO   -->
		<!--  INICIO GLOBO Blanco   -->
			<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
					<div class="globo_blanco_03">
				<!-- -->
	<!--  INICIO Fila de Campos   -->
				<logic:iterate id="taDesc" property="tiempoApDescripcion" name="form" indexId="i">	
					<c:set var="textos" value="${taDesc.textos }"/>
					<logic:iterate id="texto" name="textos" indexId="j">	
					<div class="fila_de_tabla_especial" style="padding-left:0 !important">
  					<div class="contenedor_izquierda_esp">
  						<div class="text"><label for="Dur01" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloDescripcion"/>:</label></div>
 					</div>
  					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="DesTA${j} }" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloDescripcion"/>:</label>
  						<html:textarea  readonly="true" styleClass="input_medio_largo input_mder" property="TADesTex${j}" value="${texto.texto}" styleId="TADes${j}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.DetalleEdu.SoloDescripcion" cols="5" rows="4"/>
  						</div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text"><label for="Idio01" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloDescripcion"/>:</label>
						<html:select disabled="true" styleClass="select_peq_n inp_se_ie" name="form" property="TADesIdio${j}" value="${texto.idioma}" >
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
					<c:set var="longitud" value="${ fn:length(textos) }"/>
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
				</logic:iterate>
	<!--  Fin Fila de Campos   -->
				<!-- -->
				<!-- -->
				</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO BLANCO   -->
<!--  FIN GLOBO BLANCO   -->
	</div>
	<!--  FIN CAJA DE FORMULARIO   -->
		</div>
	</div>
</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

	<!--  INICIO GLOBO GRIS  Descripción -->
	<!--  INICIO GLOBO GRIS Descripción  -->
				<div class="globo_gris conmargen">
					<div class="globo_gris_01">
						<div class="globo_gris_02">
							<div class="globo_gris_03">	<!--  INICIO CAJA DE FORMULARIO   -->
								<div class="formu">
									<h3 class="h3flotante"><bean:message key="catalogadorAvanzado.DetalleEdu.Descripcion"/></h3>
									<c:set var="longDescripcionAnterior" value="0"/>
									<logic:iterate id="descripcion" property="descripciones" name="form" indexId="i">
									<!--  INICIO GLOBO BLANCO   -->
									<!--  INICIO GLOBO BLANCO   -->
									<div class="globo_blanco globito flotder">
										<div class="globo_blanco_01">
											<div class="globo_blanco_02">
												<div class="globo_blanco_03">	<!--  INICIO Fila de Campos   -->
								<!--  INICIO Fila de Campos   -->
										<c:set var="textos" value="${descripcion.textos }"/>
										<c:set var="longDescripcion" value="${ fn:length(textos) }"/>				
										<logic:iterate id="contenido" name="textos" indexId="j">
											<c:set var="indice" value="${j + longDescripcionAnterior}"/>
													<div class="fila_de_tabla_especial_03">
														<div class="contenedor_izquierda_esp">
															<div class="text">
															<label for="Des${j}" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloDescripcion"/>:</label>
															<html:textarea  readonly="true" styleClass="input_medio_largo input_mder" property="Des${i}_Tex${j}" value="${contenido.texto}" styleId="Des${i}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.DetalleEdu.SoloDescripcion" cols="5" rows="4"  />
															</div>
														</div>
														<div class="contenedor_izquierda_esp">
															<div class="text">
																<label for="Idio05" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloIdioma"/>:</label>
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
														<div class="limpiar">
														</div><br class="oculto"/>
													</div>
										</logic:iterate>	
										<c:set var="longDescripcionAnterior" value="${ longDescripcion + longDescripcionAnterior }"/>
				    <!--  Fin Fila de Campos   -->
					<!--  Fin Fila de Campos   -->
												</div>
											</div>
										</div>
									</div>	
	<!--  FIN GLOBO GRIS   -->
	<!--  FIN GLOBO GRIS   -->
									<!--  Enlaces de fuera   -->
									<div class="flotder">
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
										<c:set var="longitud" value="${ fn:length(form.descripciones) }"/>
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
									<div class="limpiar">
									</div>
									</logic:iterate>
								</div>	
								<!--  FIN CAJA DE FORMULARIO   -->							
							</div>
						</div>
					</div>
				</div>	<!--  FIN GLOBO GRIS   -->
	<!--  FIN GLOBO GRIS   -->


<!--  INICIO GLOBO GRIS Idioma -->
<!--  INICIO GLOBO GRIS Idioma  -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.Idioma"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
<logic:iterate id="idioma" property="idiomas" name="form" indexId="i">
			<div class="globo_blanco globito flotder" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
					
					<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="Idioma_tipo01" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloIdioma"/>:</label>
							<html:select disabled="true" style="width:420px !important" styleClass="select_lrg inp_se_ie " name="form" title="Seleccione Idioma" property="Idio${i}" value="${idioma.texto}" >
								<c:forEach  items="${form.idiomasBackingList}" var="listaIdioma">
                            	 	<html:option value="${listaIdioma.value }">${listaIdioma.label }</html:option>
 		                  		</c:forEach>
							</html:select>
						</div>
					</div>

					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				
				<!--  Fin Fila de Campos   -->
				</div>
		</div>
	</div>
</div>

					<div class="flotder">
						<c:choose>
                			<c:when test="${i==0}">   
		                        <span class="oculto">-</span> 
		                        

             				</c:when>
	                        <c:otherwise>
             					&nbsp;
	                        </c:otherwise>
             			</c:choose>
					</div>
					<div class="flotder">
						<c:set var="longitud" value="${ fn:length(form.idiomas) }"/>
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
</logic:iterate>
</div>
		<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->


<!--  INICIO GLOBO GRIS Proceso Cognitivo -->
<!--  INICIO GLOBO GRIS Proceso Cognitivo  -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.DetalleEdu.ProcesoCognitivo"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
	<logic:iterate id="proceso" property="procesoCognitivo" name="form" indexId="i">
			<div class="globo_blanco globito flotder" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
						
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="Proceso_cognitivo01" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleEdu.SoloProcesoCognitivo"/>:</label>
							<html:select disabled="true" style="width:420px !important" styleClass="select_lrg inp_se_ie " name="form" title="Seleccione Proceso cognitivo" property="PCog${i}" value="${proceso.valor}" >
								<c:forEach  items="${form.comboProcesoBackingList}" var="listaProceso">
                 					 <html:option value="${listaProceso.value }">${listaProceso.label }</html:option>
                  				</c:forEach>
							</html:select>
						</div>
					</div>

					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				
				<!--  FIn Fila de Campos   -->
				<!--  fIN Fila de Campos   -->
				</div>
		</div>
	</div>
</div>

					<div class="flotder">
						<c:choose>
                			<c:when test="${i==0}">   
		                        <span class="oculto">-</span> 
		                        

             				</c:when>
	                        <c:otherwise>
             				   	&nbsp;
	                        </c:otherwise>
             			</c:choose>
					</div>
					<div class="flotder">
						<c:set var="longitud" value="${ fn:length(form.procesoCognitivo) }"/>
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
</logic:iterate>
</div>
		<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->


<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">
	<button class="boton_125" type="submit" name="accion" value="<bean:message key="verAvanzado.volver"/>" >
		<bean:message key="verAvanzado.volver"/>
	</button>
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->

</div>
<!-- Fin plantilla contenido  -->
</tiles:put>
</form>
</tiles:insert>
