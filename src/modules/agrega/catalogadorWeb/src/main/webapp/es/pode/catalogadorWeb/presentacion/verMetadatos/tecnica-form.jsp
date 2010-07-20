<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado-verMetadatos">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/tecnica/tecnica-form-vars.jspf" %>

<!-- Inicio plantilla contenido  -->
<!-- Inicio plantilla contenido  -->

	<form method="post" name="tecnicaTecnicaFormAccionSubmitForm"  action="<html:rewrite action="/VerMetadatos/TecnicaFormVuelveDeTecnica"/> " >
		<div class="plantilla_contenido" id="rea">
		<jsp:include page="/layout/messages.jsp" flush="true"/>
		<h2><bean:message key="catalogadorAvanzado.Tecnica"/></h2>					
		
		<!--  INICIO GLOBO GRIS Formato  -->
		<!--  INICIO GLOBO GRIS Formato   -->
		<div class="globo_gris conmargen"  >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
						<!--  INICIO CAJA DE FORMULARIO   -->		
						<div class="formu" >
							<h3><bean:message key="catalogadorAvanzado.Tecnica.Formato"/></h3>
							<!--  INICIO GLOBO Blanco   -->
							<!--  INICIO GLOBO Blanco   -->
							<logic:iterate id="formato" name="form" property="formatos" indexId="i">
								<div class="globo_blanco globito flotder" >
									<div class="globo_blanco_01">
										<div class="globo_blanco_02">
											<div class="globo_blanco_03">
												<!--  INICIO Fila de Campos   -->		
												<!--  INICIO Fila de Campos   -->
												
												<div class="fila_de_tabla_especial_03" >
		  											<div class="contenedor_izquierda_esp" >
						  								<div class="text">
						  									<label for="form" class="oculto" ><bean:message key="catalogadorAvanzado.Tecnica.SoloFormato"/>:</label>
						  									<html:select disabled="true" styleClass="select_lrg inp_se_ie " style="width:420px !important" name="form" property="Form${i}" value="${formato.texto}" >
																<c:forEach  items="${form.formatosBackingList}" var="listaFormato">
							                              			<html:option value="${listaFormato.value }">${listaFormato.label }</html:option>
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
				                        <!--  quitado button   -->
	              				      </c:when>
			                        <c:otherwise>
	              					    	&nbsp;
			                        </c:otherwise>
	              				 </c:choose>
							</div>
							<div class="flotder">
								<c:set var="longitud" value="${ fn:length(form.formatos) }"/>
									<c:choose>
				                        <c:when test="${longitud>1}">   
	            				            <span class="oculto">-</span> 
	            				             <!--  quitado button   -->
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
		<!--  FIN GLOBO GRIS Formato  -->
		<!--  FIN GLOBO GRIS Formato  -->
		
		<!--  INICIO GLOBO GRIS Tamaño  -->
		<!--  INICIO GLOBO GRIS Tamaño  -->
		<div class="globo_gris conmargen"  >
			<div class="globo_gris_01">
				<div class="globo_gris_02">		
					<div class="globo_gris_03">
						<!--  INICIO CAJA DE FORMULARIO   -->
						<div class="formu" >							
							<h3><bean:message key="catalogadorAvanzado.Tecnica.Tamaño"/></h3>
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
			  										<div class="text"><label for="form" class="oculto" ><bean:message key="catalogadorAvanzado.Tecnica.SoloTamaño"/>:</label>
			  											<html:text readonly="true" styleClass="input_medio" property="Tam" value="${tamanio}" styleId="Tam" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Tecnica.Tamaño" />
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
		<!--  FIN GLOBO GRIS  Tamaño  -->
		<!--  FIN GLOBO GRIS Tamaño  -->
		
		<!--  INICIO GLOBO GRIS   -->
		<!--  INICIO GLOBO GRIS   -->
		<div class="globo_gris conmargen real"  >		
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					<!--  INICIO CAJA DE FORMULARIO   -->
					<div class="formu" >
						<h3><bean:message key="catalogadorAvanzado.Tecnica.Localizacion"/></h3>
						<!--  INICIO GLOBO Blanco   -->
						<!--  INICIO GLOBO Blanco   -->
						<logic:iterate id="localiza" name="form" property="localizacion" indexId="j">
						<div class="globo_blanco globito flotder" >			
							<div class="globo_blanco_01">
								<div class="globo_blanco_02">
									<div class="globo_blanco_03">
										
											<!--  INICIO Fila de Campos   -->
											<!--  INICIO Fila de Campos   -->
											<div class="fila_de_tabla_especial_03" >
			  									<div class="contenedor_izquierda_esp" >
			  										<div class="text">
			  											<label for="form" class="oculto" ><bean:message key="catalogadorAvanzado.Tecnica.SoloLocalizacion"/>:</label>
			  											<html:text readonly="true" styleClass="input_medio" style="width:420px !important" property="Loc${j }" value="${localiza.texto}" styleId="Loc${j }" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Tecnica.Localizacion" />
			  										</div>
			
			 									</div>
												
												<div class="limpiar"></div>
												<br class="oculto" />
											</div>								
											<!--  Fin Fila de Campos   -->
											<!--  Fin Fila de Campos   -->
										
									</div>
								</div>			
							</div>
						</div>
						<div class="flotder">
							<c:choose>
	            							<c:when test="${j==0}">   
	                       			<span class="oculto">-</span> 
	                       				<!--  quitado button   -->
	         				 			</c:when>
	                       		<c:otherwise>
	           					    	&nbsp;
	                       		</c:otherwise>
	              				</c:choose>	
						</div>
						<div class="flotder">
							<c:set var="longitud" value="${ fn:length(form.localizacion) }"/>
							<c:choose>
		                        <c:when test="${longitud>1}">   
	          				            <span class="oculto">-</span> 
	          				             <!--  quitado button   -->
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
		<!--  FIN GLOBO GRIS Localizacion   -->
		<!--  FIN GLOBO GRIS Localizacion  -->
		
		<!--  INICIO GLOBO GRIS Requerimiento  -->
		
		<!--  INICIO GLOBO GRIS Requerimiento  -->
		<div class="globo_gris conmargen pos_relative"  >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					
					<!--  INICIO CAJA DE FORMULARIO   -->
					<div id="formulario_02" >
							
							<h3><bean:message key="catalogadorAvanzado.Tecnica.Requerimientos"/></h3>
							<logic:iterate id="requerimientos" name="form" property="requerimiento" indexId="k">
							<!--  Enlaces de fuera   -->
		
										<!--  Enlaces de fuera   -->
											<div class="pos_relative" id="flotantederecha">
											<span class="oculto">-</span>
												<c:choose>
					               				<c:when test="${k==0}">   
						                        	
						                        	<span class="flotder enlace_anadir_04"> 
						                        	<!--  quitado button   --></span>
					            				 </c:when>
					                        		<c:otherwise>
					            					    	&nbsp;
					                        		</c:otherwise>
				               					 </c:choose>	
											
												<c:set var="longitud" value="${ fn:length(form.requerimiento) }"/>
												<span class="oculto">-</span>
												<c:choose>
							                        <c:when test="${longitud>1}">   
						          				            
						          				            <span class="flotder enlace_eliminar_04"> 
						          				             <!--  quitado button   --></span>
							                        </c:when>
						             				        <c:otherwise>
						                      				&nbsp;
							                        </c:otherwise>
								                </c:choose>				
												
											</div>
		
											<!--  Fin Enlaces de fuera   -->
										<!--  Fin Enlaces de fuera   -->
										
		<!--  INICIO GLOBO Blanco   -->
		<!--  INICIO GLOBO Blanco   -->
					<div class="globo_blanco pos_relative conmargen" id="rail">
						<div class="globo_blanco_01" >
							<div class="globo_blanco_02">
								<div class="globo_blanco_03">
									<h3 class="int_h3"><bean:message key="catalogadorAvanzado.Tecnica.AgregadorOR"/></h3>
									<c:forEach items="${requerimientos.agregadoresOR }" var="agregador" varStatus="status">
															
									<!--  INICIO GLOBO GRIS   -->
									<!--  INICIO GLOBO GRIS   -->
											<div class="globo_gris globito5 flotder pos_relative"  >
												<div class="globo_gris_01">
													<div class="globo_gris_02">
														<div class="globo_gris_03">
									<!--  INICIO Fila de Campos   -->
									<!--  INICIO Fila de Campos   -->
								<div class="fila_de_tabla_especial_02" >
		
		  					<div class="contenedor_izquierda_esp lab_igual">
		  						<div class="text"><label for="form" ><bean:message key="catalogadorAvanzado.Tecnica.SoloTipo"/>:</label></div>
		 					</div>
							<div class="contenedor_izquierda_esp" >
								<div class="text">
									<c:set var="tipo" value="${agregador.tipo }"/>
							  		<html:select disabled="true" styleClass="input_medio" name="form" property="Tipo${k }_${status.index}" value="${tipo.valor}">
							         <c:forEach  items="${form.comboTipoBackingList}" var="listaTipo">
							          	<html:option value="${listaTipo.value }">${listaTipo.label }</html:option>
							          </c:forEach>
							       </html:select>
								</div>
							</div>
							<div class="limpiar"></div>
							<br class="oculto" />
						</div>	
						<!--  Fin Fila de Campos   -->
		
						<!--  Fin Fila de Campos   -->
						<!--  INICIO Fila de Campos   -->
						<!--  INICIO Fila de Campos   -->
						<!--  INICIO Fila de Campos   -->
									<!--  INICIO Fila de Campos   -->
								<div class="fila_de_tabla_especial_02" >
		  					<div class="contenedor_izquierda_esp lab_igual">
		  						<div class="text"><label for="form" ><bean:message key="catalogadorAvanzado.Tecnica.SoloNombre"/>:</label></div>
		
		 					</div>
							<div class="contenedor_izquierda_esp" >
								<div class="text">
									<c:set var="nombre" value="${agregador.nombre }"/>
							  		<html:select disabled="true" styleClass="input_medio" name="form" property="Nom${k }_${status.index}" value="${nombre.valor}">
							         <c:forEach  items="${form.comboNombreBackingList}" var="listaNombre">
							          	<html:option value="${listaNombre.value }">${listaNombre.label }</html:option>
							          </c:forEach>
							        </html:select>
								</div>
							</div>
							<div class="limpiar"></div>
							<br class="oculto" />
						</div>	
						<!--  Fin Fila de Campos   -->
						<!--  INICIO Fila de Campos   -->
									<!--  INICIO Fila de Campos   -->
								<div class="fila_de_tabla_especial_02" >
		
		  					<div class="contenedor_izquierda_esp lab_igual">
		  						<div class="text"><label for="VersMin01" ><bean:message key="catalogadorAvanzado.Tecnica.SoloVersionMinima"/>:</label></div>
		 					</div>
							<div class="contenedor_izquierda_esp" >
								<div class="text">
									<c:set var="minimo" value="${agregador.versionMin }"/>
									<html:text readonly="true" styleClass="input_medio" property="Mini${k }_${status.index}" value="${minimo.texto}" styleId="Mini${k }_${status.index}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Tecnica.VersionMinima" />
								</div>
							</div>
		
							<div class="limpiar"></div>
							<br class="oculto" />
						</div>	
						<!--  Fin Fila de Campos   -->
						<!--  INICIO Fila de Campos   -->
									<!--  INICIO Fila de Campos   -->
								<div class="fila_de_tabla_especial_02" >
		  					<div class="contenedor_izquierda_esp lab_igual">
		  						<div class="text"><label for="VersMax01" ><bean:message key="catalogadorAvanzado.Tecnica.SoloVersionMaxima"/>:</label></div>
		
		 					</div>
							<div class="contenedor_izquierda_esp" >
								<div class="text">
									<c:set var="maximo" value="${agregador.versionMax }"/>
									<html:text readonly="true" styleClass="input_medio" property="Max${k }_${status.index}" value="${maximo.texto}" styleId="Max${k }_${status.index}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Tecnica.VersionMaxima" />
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
		<!--  FIN GLOBO GRIS   -->
		<!--  FIN GLOBO GRIS   -->
			<!--  Enlaces de fuera   -->
											<div class="flotder pos_relative" >
												  <span class="oculto">-</span>
												  <span class="flotder enlace_anadir_02">
						                        	<c:choose>
					               				<c:when test="${status.index==0}">   
						                        	
						                        	 
						                        	<!--  quitado button   -->
					            				 </c:when>
					                        		<c:otherwise>
					            					    	&nbsp;
					                        		</c:otherwise>
				               					 </c:choose>	
				               					 </span>
											</div>
											<div class="flotder pos_relative" >
												<c:set var="longitud" value="${ fn:length(requerimientos.agregadoresOR ) }"/>
												<span class="oculto">-</span>
												<span class="flotder enlace_eliminar_02"> 
												<c:choose>
							                        <c:when test="${longitud>1}">   
						          				            
						          				            
						          				             <!--  quitado button   -->
							                        </c:when>
						             				        <c:otherwise>
						                      				&nbsp;
							                        </c:otherwise>
								                </c:choose>				
							                      </span>  
											</div>
											<!--  Fin Enlaces de fuera   -->
										<!--  Fin Enlaces de fuera   -->
		
									<div class="limpiar"></div>
		</c:forEach>
		
						</div>
				</div>
			</div>
		</div>
		<!--  FIN GLOBO BLANCO   -->
		<!--  FIN GLOBO BLANCO   -->
		</logic:iterate>
		</div>
		<!--  FIN CAJA DE FORMULARIO   -->
					</div>
				</div>
			</div>
		
		</div>
		<!--  FIN GLOBO GRIS  Requerimiento -->
		<!--  FIN GLOBO GRIS Requerimiento  -->
		
		<!--  INICIO GLOBO GRIS Notas de InstalaciOn  -->
		<!--  INICIO GLOBO GRIS Notas de InstalaciOn  -->
		<div class="globo_gris pos_relative conmargen" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					
					<!--  INICIO CAJA DE FORMULARIO   -->
					<div id="formulario" >
		
					
					<h3><bean:message key="catalogadorAvanzado.Tecnica.NotasDeInstalacion"/></h3>
					<!--  INICIO GLOBO Blanco   -->
					<!--  INICIO GLOBO Blanco   -->
					<div class="globo_blanco" >
						<div class="globo_blanco_01">
							<div class="globo_blanco_02">
							<div class="globo_blanco_03">
						<!-- -->
		
						<!--  INICIO Fila de Campos   -->
						<!--  INICIO Fila de Campos   -->
						<logic:iterate id="instalacion" name="form" property="descripcionInstalacion" indexId="l">	
							<c:set var="textos" value="${instalacion.textos }"/>
							<logic:iterate id="texto" name="textos" indexId="m">	
								<div class="fila_de_tabla_especial" style="padding-left:0 !important">
		  							<div class="contenedor_izquierda_esp">
		  								<div class="text"><label for="Not01" ><bean:message key="catalogadorAvanzado.Tecnica.SoloDescripcion"/>:</label></div>
		 							</div>
									<div class="contenedor_izquierda_esp" >
										<div class="text"><label for="Desc${m} }" class="oculto" ><bean:message key="catalogadorAvanzado.Tecnica.SoloNotasDeInstalacion"/>:</label>
		  									<html:text readonly="true" styleClass="input_largo input_mder" property="InsTex${m}" value="${texto.texto}" styleId="InsTex${m}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Tecnica.SoloNotasDeInstalacion" />
		  								</div>
									</div>
							<div class="contenedor_izquierda_esp" >
								<div class="text"><label for="Idio01" class="oculto" ><bean:message key="catalogadorAvanzado.Tecnica.SoloIdioma"/>:</label>
									<html:select disabled="true" styleClass="select_peq_n inp_se_ie" name="form" property="InsIdio${m}" value="${texto.idioma}" >
										<c:forEach  items="${form.comboIdiomaBackingList}" var="idiomaValor">
		                        	 		<html:option value="${ idiomaValor.value}">${idiomaValor.label}</html:option>
		    		            		</c:forEach>
									</html:select>
								</div>
							</div>
							<div class="float_izquierda_n">
							<c:choose>
		                   		<c:when test="${m==0}">   
							    	<span class="oculto">-</span> 
			                        <!--  quitado button   -->
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
			            			<!--  quitado button   -->
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
		<!--  INICIO GLOBO GRIS Mas Requerimientos-->
		<!--  INICIO GLOBO GRIS Mas Requerimientos-->
		<div class="globo_gris pos_relative conmargen" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">					
					<!--  INICIO CAJA DE FORMULARIO   -->
						<div id="formulario" >
							<h3><bean:message key="catalogadorAvanzado.Tecnica.MasRequerimientos"/></h3>
								<!--  INICIO GLOBO Blanco   -->
								<!--  INICIO GLOBO Blanco   -->
									<div class="globo_blanco" >
										<div class="globo_blanco_01">
											<div class="globo_blanco_02">
												<div class="globo_blanco_03">								
													<!--  INICIO Fila de Campos   -->
													<logic:iterate id="requerimiento" name="form" property="descripcionRequerimientos" indexId="n">	
														<c:set var="textos" value="${requerimiento.textos }"/>
														<logic:iterate id="texto" name="textos" indexId="p">
															<div class="fila_de_tabla_especial" style="padding-left:0 !important">		
			  													<div class="contenedor_izquierda_esp">
			  														<div class="text">
				  														<label for="Not01" >
				  															<bean:message key="catalogadorAvanzado.Tecnica.SoloDescripcion"/>:
				  														</label>
			  														</div>
			 													</div>
																<div class="contenedor_izquierda_esp" >
																	<div class="text">
																		<label for="Desc${p} }" class="oculto" >
																			<bean:message key="catalogadorAvanzado.Tecnica.SoloMasRequerimientos"/>:
																		</label>
																		<html:text readonly="true" styleClass="input_largo input_mder" property="MasReqTex${p}" value="${texto.texto}" styleId="MasReqTex${p}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Tecnica.SoloNotasDeInstalacion" />
																	</div>
																</div>
			
																<div class="contenedor_izquierda_esp" >
																	<div class="text">
																		<label for="Idio01" class="oculto" >
																			<bean:message key="catalogadorAvanzado.Tecnica.SoloIdioma"/>:
																		</label>
																		<html:select disabled="true" styleClass="select_peq_n inp_se_ie" name="form" property="MasReqIdio${p}" value="${texto.idioma}" >
																			<c:forEach  items="${form.comboIdiomaBackingList}" var="idiomaValor">
				                        	 									<html:option value="${ idiomaValor.value}">${idiomaValor.label}</html:option>
				    		            									</c:forEach>
																		</html:select>		
																	</div>
																</div>
																<div class="float_izquierda_n">
																	<c:choose>
												                   		<c:when test="${p==0}">   
																	    	<span class="oculto">-</span> 
													                        <!--  quitado button   -->
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
													            			<!--  quitado button   -->
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
		
		
		
		<!--  INICIO GLOBO GRIS  DURACION  -->
		<!--  INICIO GLOBO GRIS  DURACION  -->
		<div class="globo_gris pos_relative conmargen" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					<!--  INICIO CAJA DE FORMULARIO   -->
		
					<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.Tecnica.Duracion"/></h3>
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
		  						<div class="text"><label for="AnioDur" class="rdr" ><bean:message key="catalogadorAvanzado.Tecnica.Aino"/>:</label>
									<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="Anyos" value="${anyo}" styleId="Anyos" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Tecnica.Aino"/>
								</div>
							</div>
							<div class="contenedor_izquierda_esp" >
		
		  						<div class="text"><label for="MesDur" class="rdr" ><bean:message key="catalogadorAvanzado.Tecnica.Mes"/>:</label>
									<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="Meses" value="${mes}" styleId="Meses"  onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Tecnica.Mes"/>
								</div>
							</div>
							<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="DiaDur" class="rdr" ><bean:message key="catalogadorAvanzado.Tecnica.Dia"/>:</label>
								<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="Dias" value="${dia}" styleId="Dias" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Tecnica.Dia"/>
								</div>
		
							</div>
							<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="HoraDur" class="rdr" ><bean:message key="catalogadorAvanzado.Tecnica.Hora"/>:</label>
								<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="Horas" value="${hora}" styleId="Horas"  onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Tecnica.Hora"/>
								</div>
							</div>
							<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="MinutosDur" class="rdr" ><bean:message key="catalogadorAvanzado.Tecnica.Minutos"/>:</label>
		
									<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="Minutos" value="${minutos}" styleId="Minutos" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Tecnica.Minutos"/>
								</div>
							</div>
							<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="SegundosDur" class="rdr" ><bean:message key="catalogadorAvanzado.Tecnica.Segs"/>:</label>
								<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="SegundosP1" value="${segundosP1}" styleId="SegundosP1"  onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Tecnica.Segs"/>
								</div>
							</div>
		
							<div class="contenedor_izquierda_esp " >
							<div class="text input_mder2">.</div>
							</div>
							<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="SegundosDur2" class="oculto" ><bean:message key="catalogadorAvanzado.Tecnica.Segundos"/>:</label>
								<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="SegundosP2" value="${segundosP2}" styleId="SegundosP2"  onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Tecnica.Segundos"/>
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
					<div class="globo_blanco pos_relative" >
						<div class="globo_blanco_01">
							<div class="globo_blanco_02">
							<div class="globo_blanco_03">
						<!-- -->
						<!--  INICIO Fila de Campos   -->
		
						<!--  INICIO Fila de Campos   -->
						<logic:iterate id="descDur" name="form" property="descripcionDuracion" indexId="i">	
						<c:set var="textos" value="${descDur.textos }"/>
							<logic:iterate id="texto" name="textos" indexId="j">
						<div class="fila_de_tabla_especial" style="padding-left:0 !important">
		  					<div class="contenedor_izquierda_esp">
		  						<div class="text"><label for="Dur01" ><bean:message key="catalogadorAvanzado.Tecnica.SoloDescripcion"/>:</label></div>
		 					</div>
							<div class="contenedor_izquierda_esp" >
							<div class="text"><label for="DesDu${j} }" class="oculto" ><bean:message key="catalogadorAvanzado.Tecnica.SoloDescripcion"/>:</label>
		  						<html:textarea readonly="true" styleClass="input_medio_largo input_mder" property="DesDurTex${j}" value="${texto.texto}" styleId="descDur${j}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Tecnica.SoloDescripcion" cols="5" rows="4"/>
		  						</div>
							</div>
							<div class="contenedor_izquierda_esp" >
								<div class="text"><label for="Idio018" class="oculto" ><bean:message key="catalogadorAvanzado.Tecnica.SoloIdioma"/>:</label>
								<html:select disabled="true" styleClass="select_peq_n inp_se_ie" name="form" property="DesDurIdio${j}" value="${texto.idioma}" >
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
			                        <!--  quitado button   -->
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
			            			<!--  quitado button   -->
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
	</div>
	<!-- Fin plantilla contenido  -->
	
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



</tiles:put>

</tiles:insert>
