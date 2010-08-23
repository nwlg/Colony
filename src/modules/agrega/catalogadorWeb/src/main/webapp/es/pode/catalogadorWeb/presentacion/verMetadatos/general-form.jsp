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
<h2><bean:message key="catalogadorAvanzado.General"/></h2>

<form method="post" name="AccionSubmitForm" action="<html:rewrite action="/VerMetadatos/GeneralFormVuelveDeGeneral"/>" >



<!--  INICIO GLOBO GRIS  IDENTIFICADOR  -->
<!--  INICIO GLOBO GRIS  IDENTIFICADOR  -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
			
			<h3><bean:message key="catalogadorAvanzado.General.Identificador"/></h3>
			<!--  INICIO GLOBO Blanco   -->
			<!--  INICIO GLOBO Blanco   -->
			<c:forEach var="identificador" items="${form.identificadores }" varStatus="estado">
			<div class="globo_blanco globito flotder" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
					<div class="globo_blanco_03">
				<!-- -->
				<!--  INICIO Fila de Campos   -->
				<!--  INICIO Fila de Campos   -->
				<div class="fila_de_tabla_especial" style="padding-left:0 !important">
  					<div class="contenedor_izquierda_esp">
  						<div class="text"><label for="Cat${estado.index}" ><bean:message key="catalogadorAvanzado.General.Catalogo"/>:</label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
						<html:text readonly="true" styleClass="input_medio_largo" style="width:164px !important" property="IdCat${estado.index}" value="${identificador.catalogo}" styleId="Cat${estado.index}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.General.Catalogo" />
						</div>
					</div>
					<div class="contenedor_izquierda_esp">
  						<div class="text"><label for="Ent${estado.index}"  class="lab_ie"><bean:message key="catalogadorAvanzado.General.Entrada"/>:</label></div>
 					</div>
					<div class="contenedor_izquierda_esp">
						<div class="text">
						<html:text readonly="true" styleClass="input_medio" style="width:100px !important" property="IdEnt${estado.index}" value="${identificador.entrada}" styleId="Ent${estado.index}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.General.Entrada" />
						</div>
					</div>
				</div>
				<!--  Fin Fila de Campos   -->
				<!--  Fin Fila de Campos   -->
				<!-- -->
				<!-- -->
				</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO BLANCO   -->
<!--  FIN GLOBO BLANCO   -->

					<div class="flotder">
  					<c:choose>
                        <c:when test="${estado.index==0}">   
	                        <span class="oculto">-</span> 
							<span class="flotder enlace_anadir_02"></span>
                        </c:when>
                        <c:otherwise>
                        <span class="flotder enlace_anadir_02">
                         &nbsp;
						</span>
                        </c:otherwise>
                    </c:choose>
					</div>
					<div class="flotder">
 					<c:set var="longitud" value="${ fn:length(form.identificadores) }"/>
					<c:choose>
                        <c:when test="${longitud>1}">   
	                        <span class="oculto">-</span> 
	                        <span class="flotder enlace_eliminar_02"></span>
                        </c:when>
                        <c:otherwise>
                        <span class="flotder enlace_eliminar_02">
                         &nbsp;
                         </span>
                        </c:otherwise>
                    </c:choose>	
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
					
				</c:forEach>
	</div>
	<!--  FIN CAJA DE FORMULARIO   -->
		</div>
	</div>
</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
			<h3><bean:message key="catalogadorAvanzado.General.Titulo"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco pos_relative conmargen" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
				<logic:iterate id="titulo" property="titulos" name="form" indexId="i">	
				<c:set var="textos" value="${titulo.textos }"/>
					<logic:iterate id="texto" name="textos" indexId="j">	
					<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="Tit${j} }" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloTitulo"/>:</label>
  						<html:text readonly="true" styleClass="input_largo input_mder" property="TitTex${j}" value="${texto.texto}" styleId="Tit${j}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.General.SoloTitulo" />
  						</div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text"><label for="Idio01" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloIdioma"/>:</label>
						<html:select disabled="true" styleClass="select_peq_n inp_se_ie" name="form" property="TitIdio${j}" value="${texto.idioma}" >
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
				<!--  Fin Fila de Campos   -->
				<!--  FIN GLOBO BLANCO   -->
				<!--  FIN GLOBO BLANCO   -->
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
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
	<div class="globo_gris_02">
	<div class="globo_gris_03">
	<!--  INICIO CAJA DE FORMULARIO   -->
	<div class="formu" >
					
	<h3><bean:message key="catalogadorAvanzado.General.Idioma"/></h3>
	<!--  INICIO GLOBO Blanco   -->
	<logic:iterate id="idioma" property="idiomas" name="form" indexId="i">
			<div class="globo_blanco globito flotder" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							 
								<div class="fila_de_tabla_especial_03" >
		  							<div class="contenedor_izquierda_esp">
		  							<div class="text">
		  								<label for="form" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloIdioma"/>:</label>
										<html:select disabled="true" styleClass="select_lrg inp_se_ie " style="width:430px !important" name="form" property="Idio${i}" value="${idioma.texto}" >
											<c:forEach  items="${form.idiomasBackingList}" var="listaIdioma">
                               				 	<html:option value="${listaIdioma.value }">${listaIdioma.label }</html:option>
    		                  				</c:forEach>
										</html:select>
									</div>
								</div>
								</div>	
				
							 <!--  Fin Fila de Campos   -->	
				<!--  FIN GLOBO BLANCO   -->
				
			</div>
		</div>
	</div>
</div>
	<!--  Enlaces de fuera   -->

								<!--  Enlaces de fuera   -->
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
									<br class="oculto" />
									
							 </logic:iterate>	
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
									<h3 class="h3flotante"><bean:message key="catalogadorAvanzado.General.Descripcion"/></h3>
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
															<label for="Des${j}" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloDescripcion"/>:</label>
															<html:textarea readonly="true" styleClass="input_medio_largo input_mder" property="Des${i}_Tex${j}" value="${contenido.texto}" styleId="Des${i}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.General.SoloDescripcion" cols="5" rows="4"  />
															</div>
														</div>
														<div class="contenedor_izquierda_esp">
															<div class="text">
																<label for="Idio05" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloIdioma"/>:</label>
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


	<!--  INICIO GLOBO GRIS  Palabra Clave -->
	<!--  INICIO GLOBO GRIS Palabra Clave  -->
				<div class="globo_gris conmargen">
					<div class="globo_gris_01">
						<div class="globo_gris_02">
							<div class="globo_gris_03">	<!--  INICIO CAJA DE FORMULARIO   -->
								<div class="formu">
									<h3 class="h3flotante"><bean:message key="catalogadorAvanzado.General.PalabraClave"/></h3>
									<c:set var="longPalabrasAnterior" value="0"/>
									<logic:iterate id="palabra" property="palabrasClave" name="form" indexId="i">
									<!--  INICIO GLOBO BLANCO   -->
									<!--  INICIO GLOBO BLANCO   -->
									<div class="globo_blanco globito flotder">
										<div class="globo_blanco_01">
											<div class="globo_blanco_02">
												<div class="globo_blanco_03">	<!--  INICIO Fila de Campos   -->
								<!--  INICIO Fila de Campos   -->
										<c:set var="textos" value="${palabra.textos }"/>
										<c:set var="longPalabras" value="${ fn:length(textos) }"/>				
										<logic:iterate id="contenido" name="textos" indexId="j">
											<c:set var="indice" value="${j + longPalabrasAnterior}"/>
													<div class="fila_de_tabla_especial_03">
														<div class="contenedor_izquierda_esp">
															<div class="text">
															<label for="PalClave01" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloPalabraClave"/>:</label>
														<html:text readonly="true" styleClass="input_medio input_mder" property="Pcla${i}_Tex${j}" value="${contenido.texto}" styleId="PalClave${i}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.General.SoloPalabraClave" />
															</div>
														</div>
														<div class="contenedor_izquierda_esp">
															<div class="text">
																<label for="Idio05" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloIdioma"/>:</label>
																<html:select disabled="true" styleClass="select_peq_n inp_se_ie" name="form" property="Pcla${i}_Idio${j}" value="${contenido.idioma}" >
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
															<c:set var="longitud" value="${ longPalabras }"/>
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
										<c:set var="longPalabrasAnterior" value="${ longPalabras + longPalabrasAnterior }"/>
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
				
									<c:set var="longitud" value="${ fn:length(form.palabrasClave) }"/>
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
								<div class="limpiar"></div>
									</logic:iterate>
								</div>	
								<!--  FIN CAJA DE FORMULARIO   -->							
							</div>
						</div>
					</div>
				</div>	<!--  FIN GLOBO GRIS   -->
	<!--  FIN GLOBO GRIS   -->


	<!--  INICIO GLOBO GRIS  Ambito -->
	<!--  INICIO GLOBO GRIS Ambito  -->
				<div class="globo_gris conmargen">
					<div class="globo_gris_01">
						<div class="globo_gris_02">
							<div class="globo_gris_03">	<!--  INICIO CAJA DE FORMULARIO   -->
								<div class="formu">
									<h3 class="h3flotante"><bean:message key="catalogadorAvanzado.General.Ambito"/></h3>
									<c:set var="longAmbitoAnterior" value="0"/>
									<logic:iterate id="ambito" property="ambitos" name="form" indexId="i">
									<!--  INICIO GLOBO BLANCO   -->
									<!--  INICIO GLOBO BLANCO   -->
									<div class="globo_blanco globito flotder">
										<div class="globo_blanco_01">
											<div class="globo_blanco_02">
												<div class="globo_blanco_03">	<!--  INICIO Fila de Campos   -->
								<!--  INICIO Fila de Campos   -->
												<c:set var="textos" value="${ambito.textos }"/>
												<c:set var="longAmbito" value="${ fn:length(textos) }"/>				
												<logic:iterate id="contenido" name="textos" indexId="j">
													<c:set var="indice" value="${j + longAmbitoAnterior}"/>
													<div class="fila_de_tabla_especial_03">
														<div class="contenedor_izquierda_esp">
															<div class="text">
																<label for="Ambito01" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloAmbito"/>:</label>
	  															<html:text readonly="true" styleClass="input_medio_largo input_mder" property="Amb${i}_Tex${j}" value="${contenido.texto}" styleId="Ambito${i}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.General.SoloAmbito" />
															</div>
														</div>
														<div class="contenedor_izquierda_esp">
															<div class="text">
																<label for="Idio05" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloIdioma"/>:</label>
																<html:select disabled="true" styleClass="select_peq_n inp_se_ie" name="form" property="Amb${i}_Idio${j}" value="${contenido.idioma}" >
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
															<c:set var="longitud" value="${ longAmbito }"/>
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
										<c:set var="longPalabrasAnterior" value="${ longPalabras + longPalabrasAnterior }"/>
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
							        
									<c:set var="longitud" value="${ fn:length(form.ambitos) }"/>
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
								<div class="limpiar"></div>
									</logic:iterate>
								</div>	
								<!--  FIN CAJA DE FORMULARIO   -->							
							</div>
						</div>
					</div>
				</div>	<!--  FIN GLOBO GRIS   -->
	<!--  FIN GLOBO GRIS   -->
	



<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris conmargen">
<div class="globo_gris_01">
<div class="globo_gris_02">
<div class="globo_gris_03">
	<!--  INICIO CAJA DE FORMULARIO ESTRUCTURA  -->
	<div class="formu" >
					
	<h3><bean:message key="catalogadorAvanzado.General.Estructura"/></h3>
	<!--  INICIO GLOBO Blanco   -->
	<div class="globo_blanco pos_relative conmargen" >
	<div class="globo_blanco_01">
	<div class="globo_blanco_02">
	<div class="globo_blanco_03">
	<!--  INICIO Fila de Campos   -->
	<div class="fila_de_tabla_especial_03" >
  	<div class="contenedor_izquierda_esp" >
  		<div class="text">
  		<label for="Est022" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloEstructura"/>:</label>
		<html:select disabled="true" styleClass="select_lrg" name="form" property="estructura">
         	<c:forEach  items="${form.estructuraBackingList}" var="listaEstructura">
               <html:option value="${listaEstructura.value }">${listaEstructura.label }</html:option>
            </c:forEach>
        </html:select>
		</div>
	</div>
	<div class="limpiar"></div>
	<br class="oculto" />
	</div>	
	<!--  fIN Fila de Campos   -->
	</div>
	</div>
	</div>
	</div>
	</div>
	<!--  FIN CAJA DE FORMULARIO  ESTRUCTURA -->
</div>
</div>
</div>
</div>
<!--  FIN GLOBO GRIS   -->

<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris conmargen">
<div class="globo_gris_01">
<div class="globo_gris_02">
<div class="globo_gris_03">
	<!--  INICIO CAJA DE FORMULARIO NIVEL AGREGACION  -->
	<div class="formu" >
					
	<h3><bean:message key="catalogadorAvanzado.General.NivelAgregacion"/></h3>
	<!--  INICIO GLOBO Blanco   -->
	<div class="globo_blanco pos_relative conmargen" >
	<div class="globo_blanco_01">
	<div class="globo_blanco_02">
	<div class="globo_blanco_03">
	<!--  INICIO Fila de Campos   -->
	<div class="fila_de_tabla_especial_03" >
  	<div class="contenedor_izquierda_esp" >
  	<div class="text">
  		<label for="Nivel025" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloNivel"/>:</label>
  		<html:select disabled="true" styleClass="select_lrg" name="form" property="nivelAgregacion">
             <c:forEach  items="${form.nivelAgregacionBackingList}" var="listaNivelAgregacion">
               <html:option value="${listaNivelAgregacion.value }">${listaNivelAgregacion.label }</html:option>
             </c:forEach>
        </html:select>
	</div>
	</div>
	<div class="limpiar"></div>
	<br class="oculto" />
	</div>	
	<!--  FILM Fila de Campos   -->
	</div>
	</div>
	</div>
	</div>
	</div>
				
	<!--  FIN CAJA DE FORMULARIO   NIVEL AGREGACION-->
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
</form>
</div>
<!-- Fin plantilla contenido  -->
</tiles:put>

</tiles:insert>
