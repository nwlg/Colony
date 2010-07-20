<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado-verMetadatos">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/metametadatos/meta-metadatos-form-vars.jspf" %>

<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" id="rea">
<jsp:include page="/layout/messages.jsp" flush="true"/>
<h2><bean:message key="catalogadorAvanzado.MetaMetadatos"/></h2>
<form method="post" name="metaMetadatosMetaMetadatosFormSubmitForm" action="<html:rewrite action="/VerMetadatos/MetaMetadatosFormVuelveDeMetaMetadatos"/>" >

<!--  INICIO GLOBO GRIS Identificador  -->
<!--  INICIO GLOBO GRIS Identificador  -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
			<h3><bean:message key="catalogadorAvanzado.Meta.Identificador"/></h3>
		<c:forEach var="identificador" items="${form.identificadores }" varStatus="estado">
<div class="globo_blanco globito flotder">
										<div class="globo_blanco_01">
											<div class="globo_blanco_02">
												<div class="globo_blanco_03">	<!-- -->
					<!--  INICIO Fila de Campos   -->
					<!--  INICIO Fila de Campos   -->

						<div class="fila_de_tabla_especial" style="padding-left:0 !important">
							<div class="contenedor_izquierda_esp">
								<div class="text">
									<label for="Cat${estado.index}"><bean:message key="catalogadorAvanzado.Meta.Catalogo"/>:</label>
								</div>
							</div>
							<div class="contenedor_izquierda_esp">
								<div class="text">
									<html:text readonly="true" styleClass="input_medio_largo" style="width:164px !important" property="IdCat${estado.index}" value="${identificador.catalogo}" styleId="Cat${estado.index}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Meta.Catalogo" />
								</div>
							</div>
							<div class="contenedor_izquierda_esp">
								<div class="text">
									<label for="Ent${estado.index}" class="lab_ie"><bean:message key="catalogadorAvanzado.Meta.Entrada"/>:</label>
								</div>
							</div>
							<div class="contenedor_izquierda_esp">
								<div class="text">
									<html:text readonly="true" styleClass="input_medio" style="width:100px !important" property="IdEnt${estado.index}" value="${identificador.entrada}" styleId="Ent${estado.index}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Meta.Entrada" />
								</div>
							</div>

						</div>
					
					<!--  Fin Fila de Campos   -->
					<!--  Fin Fila de Campos   -->
					<!-- -->
												</div>
											</div>
										</div>
									</div>	<!--  FIN GLOBO BLANCO   -->
	<!--  FIN GLOBO BLANCO   -->
								<div class="flotder">
							<c:choose>
		                        <c:when test="${estado.index==0}">   
			                        <span class="oculto">-</span> 			                        
		                        </c:when>
		                        <c:otherwise>
		                         &nbsp;
		                        </c:otherwise>
		                    </c:choose>	
							</div>
							<div class="flotder">
							<c:set var="longitud" value="${ fn:length(form.identificadores) }"/>
							<c:choose>
		                        <c:when test="${longitud>1}">   
			                        <span class="oculto">-</span> 
			                        <html:hidden property="posi" value="${ estado.index }" />			                        
		                        </c:when>
		                        <c:otherwise>
		                         &nbsp;
		                        </c:otherwise>
		                    </c:choose>	
							</div>
							<div class="limpiar">
							</div><br class="oculto"/>
							</c:forEach>
								</div>	<!--  FIN CAJA DE FORMULARIO   -->
								
							</div>
						</div>
					</div>
				</div>	<!--  FIN GLOBO GRIS   -->
	<!--  FIN GLOBO GRIS   -->

<!--  INICIO GLOBO GRIS Contribucion   -->
<!--  INICIO GLOBO GRIS Contribucion  -->
<div class="globo_gris conmargen pos_relative"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario_02" >
					
					<h3><bean:message key="catalogadorAvanzado.Meta.Contribucion"/></h3>
					<logic:iterate id="contrib" name="contribucion" indexId="i">
									<!--  Enlaces de fuera   -->
								<!--  Enlaces de fuera   -->
									<div class="pos_relative" id="flotantederecha">
										<c:choose>
											<c:when test="${i==0}">
												<span class="oculto">-</span>
												<span class="flotder enlace_anadir_03">												
												</span>
											</c:when>
											<c:otherwise>
												<span class="oculto">-</span>
												<span class="flotder enlace_anadir_03">
												 &nbsp;
												 </span>
											</c:otherwise>
										</c:choose>
										<c:set var="longi" value="${fn:length(contribucion)}" />
										<c:choose>
											<c:when test="${longi>1}">
												<span class="oculto">-</span>
												<span class="flotder enlace_eliminar_03">												
												</span>
											</c:when>
											<c:otherwise>
												<span class="oculto">-</span>
												<span class="flotder enlace_eliminar_03">
												 &nbsp;
												</span>
											</c:otherwise>
										</c:choose>
									</div>
									<!--  Fin Enlaces de fuera   -->
								<!--  Fin Enlaces de fuera   -->
						
				
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco pos_relative conmargen" id="rail2">
				<div class="globo_blanco_01" >
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
									
							<!--  INICIO GLOBO GRIS   -->
							<!--  INICIO GLOBO GRIS   -->
									<div class="globo_gris globito2 pos_relative" >
										<div class="globo_gris_01">
											<div class="globo_gris_02">
												<div class="globo_gris_03">
												<!--  INICIO Fila de Campos   -->
												<h3 class="int__h3"><bean:message key="catalogadorAvanzado.Meta.Rol"/></h3>
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_02" >
  					<div class="contenedor_izquierda_esp">
  						<div class="text"><label for="SeleccionRol" class="oculto"><bean:message key="catalogadorAvanzado.Meta.SoloRol"/>:</label>
  						<c:set var="rol" value="${contrib.rol}" />
						<html:select disabled="true" styleClass="select_lrg" title="Seleccion Rol" property="Cont${i}_Rol" value="${rol.valor}">
							<c:forEach  items="${form.crolBackingList}" var="listaRol">
  		             			<html:option value="${listaRol.value }">${listaRol.label }</html:option>
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
						<!--  FIN GLOBO GRIS   -->
						<!--  FIN GLOBO GRIS   -->
											
						<!--  INICIO GLOBO GRIS   -->
						<!--  INICIO GLOBO GRIS   -->
						
						
									<div class="globo_gris pos_relative conmargen" >
										<div class="globo_gris_01">
											<div class="globo_gris_02">
												<div class="globo_gris_03">
												<h3 class="int__h3"><bean:message key="catalogadorAvanzado.Meta.Identidad"/></h3>
							<c:set var="entidades" value="${contrib.entidades }"/>
							<logic:iterate id="entidad" name="entidades" indexId="j">
										<div class="globo_blanco globito3 flotder pos_relative" >
										<div class="globo_blanco_01">
											<div class="globo_blanco_02">
												<div class="globo_blanco_03"  >
												
													
				<!--  INICIO Fila de Campos   -->
				<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_03">
  					<div class="contenedor_izquierda_esp lab_igual">
  						<div class="text"><label for="Nombre01" ><bean:message key="catalogadorAvanzado.Meta.Nombre"/></label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
							<html:text readonly="true" styleClass="input_medio" property="Cont${i}_Ent${j}_Nom" value="${entidad.nombre}" styleId="Cont${i}_Ent${j}_Nom" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Meta.Nombre" />
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  Fin Fila de Campos   -->
				<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp lab_igual">
  						<div class="text"><label for="Organizacion01" ><bean:message key="catalogadorAvanzado.Meta.Organizacion"/></label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
						<html:text readonly="true" styleClass="input_medio" property="Cont${i}_Ent${j}_Org" value="${entidad.organizacion}" styleId="Cont${i}_Ent${j}_Org" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Meta.Organizacion" />
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  Fin Fila de Campos   -->
				<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp lab_igual">
  						<div class="text"><label for="Email01" ><bean:message key="catalogadorAvanzado.Meta.Correo"/></label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
						<html:text readonly="true" styleClass="input_medio" property="Cont${i}_Ent${j}_Cor" value="${entidad.correo}" styleId="Cont${i}_Ent${j}_Cor" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Meta.Correo" />
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
								<!--  Enlaces de fuera   -->
									<div class="flotder pos_relative" >
										<c:choose>
											<c:when test="${j==0}">
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
										<c:set var="longi" value="${fn:length(entidades)}" />
										<c:choose>
											<c:when test="${longi>1}">
												<span class="oculto">-</span>
												<span class="flotder enlace_eliminar_02">
												</span>
											</c:when>
											<c:otherwise>
												<span class="oculto">-</span>
												<span class="flotder enlace_eliminar_02">
												 &nbsp;</span>
											</c:otherwise>
										</c:choose>
									</div>
									<!--  Fin Enlaces de fuera   -->
								<!--  Fin Enlaces de fuera   -->
							<div class="limpiar"></div>
				</logic:iterate>
				</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO BLANCO Contribucion  -->
<!--  FIN GLOBO BLANCO Contribucion  -->

<!--  INICIO GLOBO GRIS Fecha  -->
<!--  INICIO GLOBO GRIS Fecha  -->
									<div class="globo_gris globito2 pos_relative conmargen" >
										<div class="globo_gris_01">
											<div class="globo_gris_02">
												<div class="globo_gris_03"  style="padding:15px 15px 5px 15px">
												<!--  INICIO Fila de Campos   -->
												<h3 class="int_h3"><bean:message key="catalogadorAvanzado.Meta.Fecha"/></h3>
							<div class="globo_blanco globito2" >
							<div class="globo_blanco_01">
							<div class="globo_blanco_02">
							<div class="globo_blanco_03">
												
													
				<!--  INICIO Fila de Campos   -->
				<!--  INICIO Fila de Campos   -->
				<c:set var="fecha" value="${contrib.fecha }"/>
				<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp lab_igual2">
  						<div class="text"><label ><bean:message key="catalogadorAvanzado.Meta.SoloFecha"/></label></div>
 					</div>
					<div class="contenedor_izquierda_esp"  id="cont_esp_fech">
  						<div class="text">
  							<html:text readonly="true" styleClass="fechazo" value="${fecha.fechaCorta}" property="Cont${i}_FechaCorta" styleId="Cont${i}_FechaCorta" onblur="this.style.backgroundColor='#e1e1e1'" maxlength="10" titleKey="catalogadorAvanzado.IntroduzcaFecha" />
  						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  Fin Fila de Campos   -->
				<!--  INICIO Fila de Campos   -->
				<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp lab_igual2">
  						<div class="text"><label ><bean:message key="catalogadorAvanzado.Meta.Tiempo"/></label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="HoraDur"  class="rdr" ><bean:message key="catalogadorAvanzado.Meta.Hora"/></label>
						<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="Cont${i}_FechaHora" value="${fecha.hora}" styleId="Cont${i}_FechaHora"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.Meta.Hora" />
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="MinutosDur"  class="rdr" ><bean:message key="catalogadorAvanzado.Meta.Minutos"/></label>
						<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="Cont${i}_FechaMin" value="${fecha.minutos}" styleId="Cont${i}_FechaMin"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.Meta.Minutos" />						
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="SegundosDur"  class="rdr" ><bean:message key="catalogadorAvanzado.Meta.Segundos"/></label>
						<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="Cont${i}_FechaSeg1" value="${fecha.segundoP1}" styleId="Cont${i}_FechaSeg1"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.Meta.Segundos" />
					</div>
					</div>
					<div class="contenedor_izquierda_esp " >
					<div class="text input_mder2">.</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="SegundosDur2" class="oculto" ><bean:message key="catalogadorAvanzado.Meta.Segundos"/></label>
						<html:text readonly="true" styleClass="in_peq  acentrado" property="Cont${i}_FechaSeg2" value="${fecha.segundoP2}" styleId="Cont${i}_FechaSeg2"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.Meta.Segundos" />
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  Fin Fila de Campos   -->
				<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp lab_igual2">
  						<div class="text"><label><bean:message key="catalogadorAvanzado.Meta.ZonaHoraria"/></label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
						 <!-- <input type="radio" class="boton_radio" id="ZHor01" checked="checked" name="zona" />
						<label for="ZHor01" class="alineada">XYZ</label>-->
 							<c:choose>
								<c:when test="${fecha.meridianoCero==0}">
									<input type="radio" disabled="true" checked name="Cont${i}_meridianoCero" onclick="document.getElementById('Cont${i}_FechaZonaH').disabled=true;document.getElementById('Cont${i}_FechaZHMinutos').disabled=true;document.getElementById('Cont${i}_FechaZHHora').disabled=true;document.getElementById('Cont${i}_FechaZHHora').style.backgroundColor='#e1e1e1';document.getElementById('Cont${i}_FechaZHMinutos').style.backgroundColor='#e1e1e1'" class="boton_radio" value="0" id="Cont${i}_meridianoCero"/>							
								</c:when>
								<c:otherwise>
								<input type="radio" disabled="true" name="Cont${i}_meridianoCero" onclick="document.getElementById('Cont${i}_FechaZonaH').disabled=true;document.getElementById('Cont${i}_FechaZHMinutos').disabled=true;document.getElementById('Cont${i}_FechaZHHora').disabled=true;document.getElementById('Cont${i}_FechaZHHora').style.backgroundColor='#e1e1e1';document.getElementById('Cont${i}_FechaZHMinutos').style.backgroundColor='#e1e1e1'" class="boton_radio" value="0" id="Cont${i}_meridianoCero"/>							
								</c:otherwise>
							</c:choose>
							<label for="Cont${i}_meridianoCero1" class="alineada"><bean:message key="catalogadorAvanzado.Meta.MeridianoCero"/></label>
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  Fin Fila de Campos   -->
				<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp lab_igual2">
  						<div class="text">&nbsp;</div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
						<!-- <input type="radio" class="boton_radio" id="ZHor02" name="zona" />
						<label for="ZHor02" class="oculto">XYZ</label>-->
							<c:choose>
								<c:when test="${fecha.meridianoCero==1}">
									<input type="radio" disabled="true" checked name="Cont${i}_meridianoCero" onclick="document.getElementById('Cont${i}_FechaZonaH').disabled=false;document.getElementById('Cont${i}_FechaZHMinutos').disabled=false;document.getElementById('Cont${i}_FechaZHHora').disabled=false;document.getElementById('Cont${i}_FechaZHHora').style.backgroundColor='#e1e1e1';document.getElementById('Cont${i}_FechaZHMinutos').style.backgroundColor='#e1e1e1'" class="boton_radio" value="1" id="Cont${i}_meridianoCero"/>							
								</c:when>
								<c:otherwise>
									<input type="radio" disabled="true" name="Cont${i}_meridianoCero" onclick="document.getElementById('Cont${i}_FechaZonaH').disabled=false;document.getElementById('Cont${i}_FechaZHMinutos').disabled=false;document.getElementById('Cont${i}_FechaZHHora').disabled=false;document.getElementById('Cont${i}_FechaZHHora').style.backgroundColor='#e1e1e1';document.getElementById('Cont${i}_FechaZHMinutos').style.backgroundColor='#e1e1e1'" class="boton_radio" value="1" id="Cont${i}_meridianoCero"/>							
								</c:otherwise>
							</c:choose>
							<label for="Cont${i}_meridianoCero2" class="oculto"><bean:message key="catalogadorAvanzado.Meta.MeridianoCero"/></label>
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="HoraDur2" class="oculto" ><bean:message key="catalogadorAvanzado.Meta.Hora"/></label>
						<html:select disabled="true" styleClass="select_peq_n inp_se_ie"  name="comboZonaH" title="Seleccione" property="Cont${i}_FechaZonaH" styleId="Cont${i}_FechaZonaH" value="${fecha.masOmenos}">
							<html:option value="" styleClass="oscura">&nbsp;</html:option>
							<html:option value="0" >+</html:option>
							<html:option value="1" styleClass="oscura">-</html:option>
						</html:select>
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="HoraDur2"  class="rdr" >&nbsp;&nbsp;<bean:message key="catalogadorAvanzado.Meta.Hora"/></label>
						<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="Cont${i}_FechaZHHora" value="${fecha.zhHora}" styleId="Cont${i}_FechaZHHora" onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.Meta.Hora" />
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="MinutosDur2" class="rdr" ><bean:message key="catalogadorAvanzado.Meta.Minutos"/></label>
						<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="Cont${i}_FechaZHMinutos" value="${fecha.zhMinutos}" styleId="Cont${i}_FechaZHMinutos"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.Meta.Minutos" />
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
<div class="globo_blanco globito2" >
							<div class="globo_blanco_01">
							<div class="globo_blanco_02">
							<div class="globo_blanco_03">
							<!-- -->
				<!--  INICIO Fila de Campos   -->
				<!--  INICIO Fila de Campos   -->
			<c:set var="textos" value="${descripciones[i].textos}"/>
				<logic:iterate id="texto" name="textos" indexId="k">
				<div class="fila_de_tabla_especial" style="padding-left:0 !important">
  					<div class="contenedor_izquierda_esp">
  						<div class="text"><label for="Mas01" ><bean:message key="catalogadorAvanzado.Meta.Descripcion"/></label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
							<html:textarea readonly="true" styleClass="input_medio input_mder"  property="Cont${i}_DesFecTex${k}" styleId="Cont${i}_DesFec${k}" value="${texto.texto}" onblur="this.style.backgroundColor='#e1e1e1'" cols="5" rows="4" titleKey="catalogadorAvanzado.Meta.Descripcion" />
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text"><label for="Idio019" class="oculto" ><bean:message key="catalogadorAvanzado.Meta.SoloIdioma"/>:</label>
						<html:select disabled="true" styleClass="select_peq_n inp_se_ie" name="form" property="Cont${i}_DesFecIdio${k}" value="${texto.idioma}" >
							<c:forEach  items="${form.comboIdiomaBackingList}" var="idiomaValor">
                    			<html:option value="${ idiomaValor.value}">${idiomaValor.label}</html:option>
    		        		</c:forEach>
						</html:select>
						</div>
					</div>
					<div class="float_izquierda_n">
						<c:choose>
							<c:when test="${k==0}">
								<span class="oculto">-</span>								
							</c:when>
							<c:otherwise>
								<span class="oculto">-</span>
								 &nbsp;
							</c:otherwise>
						</c:choose>
					</div>
					<div class="float_izquierda_n">
						<c:set var="longi" value="${fn:length(textos)}" />
						<c:choose>
							<c:when test="${longi>1}">
								<span class="oculto">-</span>								
							</c:when>
							<c:otherwise>
								<span class="oculto">-</span>
								 &nbsp;
							</c:otherwise>
						</c:choose>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>
				</logic:iterate>
				<!--  Fin Fila de Campos   -->
				
												</div>
											</div>
										</div>
									</div>					
<!--  FIN GLOBO BLANCO   -->
<!--  FIN GLOBO BLANCO   -->
<div class="limpiar"></div>
<br class="oculto" />

												</div>
											</div>
										</div>
								</div>
						<!--  FIN GLOBO GRIS   -->
						<!--  FIN GLOBO GRIS   -->
						
						
			</div>
		</div>
	</div>
</div>
</logic:iterate>
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



<!--  INICIO GLOBO GRIS Esquema Metadatos   -->
<!--  INICIO GLOBO GRIS Esquema Metadatos   -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
			<h3><bean:message key="catalogadorAvanzado.Meta.Esquema"/></h3>
			<c:forEach var="esquema" items="${form.esquemasMeta }" varStatus="estado">
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco globito flotder" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->

				<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text">
	 						<label for="Metadatos01" class="oculto" ><bean:message key="catalogadorAvanzado.Meta.Metadatos"/>:</label>
  							<html:text readonly="true" styleClass="input_medio_largo" style="width:420px !important" property="Esq${estado.index}" value="${esquema.texto}" styleId="Esq${estado.index}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Meta.Metadatos" />
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
				<!--  FIN GLOBO BLANCO   -->
				<!--  FIN GLOBO BLANCO   -->
					<div class="flotder">
					<c:choose>
                        <c:when test="${estado.index==0}">   
	                        <span class="oculto">-</span> 	                        
                        </c:when>
                        <c:otherwise>
                         &nbsp;
                        </c:otherwise>
                    </c:choose>	
					</div>
					<div class="flotder">
					<c:set var="longitud" value="${ fn:length(form.esquemasMeta) }"/>
					<c:choose>
                        <c:when test="${longitud>1}">   
	                        <span class="oculto">-</span> 
	                        <html:hidden property="posi" value="${ estado.index }" />	                        
                        </c:when>
                        <c:otherwise>
                         &nbsp;
                        </c:otherwise>
                    </c:choose>	
					</div>
					<div class="limpiar"></div>
					
				</c:forEach>
			</div>
		</div>
	</div>
</div>
</div>
<!--  FIN CAJA DE FORMULARIO   -->

<!--  FIN GLOBO GRIS  Esquema Metadatos  -->
<!--  FIN GLOBO GRIS  Esquema Metadatos  -->

<!--  INICIO GLOBO GRIS Idioma  -->
<!--  INICIO GLOBO GRIS Idioma  -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.Meta.Idioma"/></h3>
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
  						<div class="text"><label for="Idioma01" class="oculto" ><bean:message key="catalogadorAvanzado.Meta.SoloIdioma"/>:</label>
					  		<html:select disabled="true" styleClass="select_lrg" name="form" property="comboIdiomaMeta">
					             <c:forEach  items="${form.comboIdiomaMetaBackingList}" var="listaIdioma">
					               <html:option value="${listaIdioma.value }">${listaIdioma.label }</html:option>
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
<!--  FIN GLOBO GRIS Idioma  -->
<!--  FIN GLOBO GRIS Idioma  -->


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

</tiles:insert>
