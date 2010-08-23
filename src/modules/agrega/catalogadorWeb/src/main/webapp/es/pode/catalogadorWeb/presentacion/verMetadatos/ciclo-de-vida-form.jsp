<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado-verMetadatos">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/ciclodevida/ciclo-form-vars.jspf" %>

<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" id="rea">
<jsp:include page="/layout/messages.jsp" flush="true"/>
<h2><bean:message key="catalogadorAvanzado.CicloDeVida"/></h2>
<form method="post" name="cicloDeVidaCicloFormAccionSubmitForm" action="<html:rewrite action="/VerMetadatos/CicloDeVidaFormVuelveDeCicloDeVida"/>" >



<!--  INICIO GLOBO GRIS  Version -->
<!--  INICIO GLOBO GRIS  Version -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
			<h3><bean:message key="catalogadorAvanzado.Ciclo.Version"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco pos_relative conmargen" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
			<logic:iterate id="version" property="versiones" name="form" indexId="i">	
				<c:set var="textos" value="${version.textos }"/>
					<logic:iterate id="texto" name="textos" indexId="j">
						<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text">
  						<label for="Ver${j} }" class="oculto" ><bean:message key="catalogadorAvanzado.Ciclo.SoloVersion"/>:</label>
  						<html:text readonly="true" styleClass="input_medio_largo input_mder" property="VerTex${j}" value="${texto.texto}" styleId="Ver${j}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Ciclo.SoloVersion" />
  						</div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text"><label for="Idio01" class="oculto" ><bean:message key="catalogadorAvanzado.Ciclo.SoloIdioma"/>:</label>
							<html:select disabled="true" styleClass="select_peq_n inp_se_ie" name="form" property="VerIdio${j}" value="${texto.idioma}" >
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
<!--  FIN GLOBO GRIS  Version -->
<!--  FIN GLOBO GRIS Version  -->


<!--  INICIO GLOBO GRIS Estatus  -->
<!--  INICIO GLOBO GRIS  Estatus -->
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.Ciclo.Estatus"/></h3>
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
  						<div class="text"><label for="Status01" class="oculto" ><bean:message key="catalogadorAvanzado.Ciclo.SoloEstatus"/>:</label>
						  	<html:select disabled="true" styleClass="select_lrg" name="form" property="estatus">
             					<c:forEach  items="${form.estatusBackingList}" var="listaEstatus">
               						<html:option value="${listaEstatus.value }">${listaEstatus.label }</html:option>
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
<!--  FIN GLOBO GRIS Estatus  -->
<!--  FIN GLOBO GRIS Estatus  -->


<!--  INICIO GLOBO GRIS Contribucion   -->
<!--  INICIO GLOBO GRIS Contribucion  -->
<div class="globo_gris conmargen pos_relative"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario_02" >
					
					<h3><bean:message key="catalogadorAvanzado.Ciclo.Contribucion"/></h3>
					<logic:iterate id="contribucion" property="contribuciones" name="form" indexId="i">
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
										<c:set var="longi" value="${fn:length(contribuciones)}" />
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
												<h3 class="int__h3"><bean:message key="catalogadorAvanzado.Ciclo.Rol"/></h3>
							<!--  INICIO Fila de Campos   -->
						<div class="fila_de_tabla_especial_02" >
  					<div class="contenedor_izquierda_esp">
  						<div class="text"><label for="SeleccionRol" class="oculto"><bean:message key="catalogadorAvanzado.Ciclo.SoloRol"/>:</label>
  						<c:set var="rol" value="${contribucion.rol}" />
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
												<h3 class="int__h3"><bean:message key="catalogadorAvanzado.Ciclo.Identidad"/></h3>
							<c:set var="entidades" value="${contribucion.entidades }"/>
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
  						<div class="text"><label for="Nombre01" ><bean:message key="catalogadorAvanzado.Ciclo.Nombre"/></label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
							<html:text readonly="true" styleClass="input_medio" property="Cont${i}_Ent${j}_Nom" value="${entidad.nombre}" styleId="Cont${i}_Ent${j}_Nom" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Ciclo.Nombre" />
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
  						<div class="text"><label for="Organizacion01" ><bean:message key="catalogadorAvanzado.Ciclo.Organizacion"/></label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
						<html:text readonly="true" styleClass="input_medio" property="Cont${i}_Ent${j}_Org" value="${entidad.organizacion}" styleId="Cont${i}_Ent${j}_Org" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Ciclo.Organizacion" />
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
  						<div class="text"><label for="Email01" ><bean:message key="catalogadorAvanzado.Ciclo.Correo"/></label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
						<html:text readonly="true" styleClass="input_medio" property="Cont${i}_Ent${j}_Cor" value="${entidad.correo}" styleId="Cont${i}_Ent${j}_Cor" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.Ciclo.Correo" />
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
												&nbsp;
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
												&nbsp;
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
												<h3 class="int_h3"><bean:message key="catalogadorAvanzado.Ciclo.Fecha"/></h3>
							<div class="globo_blanco globito2" >
							<div class="globo_blanco_01">
							<div class="globo_blanco_02">
							<div class="globo_blanco_03">
												
													
				<!--  INICIO Fila de Campos   -->
				<!--  INICIO Fila de Campos   -->
				<c:set var="fecha" value="${contribucion.fecha }"/>
				<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp lab_igual2">
  						<div class="text"><label ><bean:message key="catalogadorAvanzado.Ciclo.SoloFecha"/></label></div>
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
  						<div class="text"><label ><bean:message key="catalogadorAvanzado.Ciclo.Tiempo"/></label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="HoraDur"  class="rdr" ><bean:message key="catalogadorAvanzado.Ciclo.Hora"/></label>
						<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="Cont${i}_FechaHora" value="${fecha.hora}" styleId="Cont${i}_FechaHora"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.Ciclo.Hora" />
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="MinutosDur"  class="rdr" ><bean:message key="catalogadorAvanzado.Ciclo.Minutos"/></label>
						<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="Cont${i}_FechaMin" value="${fecha.minutos}" styleId="Cont${i}_FechaMin"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.Ciclo.Minutos" />						
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="SegundosDur"  class="rdr" ><bean:message key="catalogadorAvanzado.Ciclo.Segundos"/></label>
						<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="Cont${i}_FechaSeg1" value="${fecha.segundoP1}" styleId="Cont${i}_FechaSeg1"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.Ciclo.Segundos" />
					</div>
					</div>
					<div class="contenedor_izquierda_esp " >
					<div class="text input_mder2">.</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="SegundosDur2" class="oculto" ><bean:message key="catalogadorAvanzado.Ciclo.Segundos"/></label>
						<html:text readonly="true" styleClass="in_peq  acentrado" property="Cont${i}_FechaSeg2" value="${fecha.segundoP2}" styleId="Cont${i}_FechaSeg2"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.Ciclo.Segundos" />
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
  						<div class="text"><label><bean:message key="catalogadorAvanzado.Ciclo.ZonaHoraria"/></label></div>
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
							<label for="Cont${i}_meridianoCero" class="alineada"><bean:message key="catalogadorAvanzado.Ciclo.MeridianoCero"/></label>
						
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
							<label for="Cont${i}_meridianoCero" class="oculto"><bean:message key="catalogadorAvanzado.Ciclo.MeridianoCero"/></label>
						
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="HoraDur2" class="oculto" ><bean:message key="catalogadorAvanzado.Ciclo.Hora"/></label>
						<html:select disabled="true" styleClass="select_peq_n inp_se_ie"  name="comboZonaH" title="Seleccione" property="Cont${i}_FechaZonaH" styleId="Cont${i}_FechaZonaH" value="${fecha.masOmenos}">
							<html:option value="" styleClass="oscura">&nbsp;</html:option>
							<html:option value="0" >+</html:option>
							<html:option value="1" styleClass="oscura">-</html:option>
						</html:select>
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="HoraDur2"  class="rdr" >&nbsp;&nbsp;<bean:message key="catalogadorAvanzado.Ciclo.Hora"/></label>
						<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="Cont${i}_FechaZHHora" value="${fecha.zhHora}" styleId="Cont${i}_FechaZHHora"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.Ciclo.Hora" />
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="MinutosDur2" class="rdr" ><bean:message key="catalogadorAvanzado.Ciclo.Minutos"/></label>
						<html:text readonly="true" styleClass="in_peq input_mder2 acentrado" property="Cont${i}_FechaZHMinutos" value="${fecha.zhMinutos}" styleId="Cont${i}_FechaZHMinutos"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.Ciclo.Minutos" />
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
  						<div class="text"><label for="Mas01" ><bean:message key="catalogadorAvanzado.Ciclo.Descripcion"/></label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
							<html:textarea readonly="true" styleClass="input_medio input_mder"  property="Cont${i}_DesFecTex${k}" styleId="Cont${i}_DesFec${k}" value="${texto.texto}" onblur="this.style.backgroundColor='#e1e1e1'" cols="5" rows="4" titleKey="catalogadorAvanzado.Ciclo.Descripcion" />
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text"><label for="Idio019" class="oculto" ><bean:message key="catalogadorAvanzado.Ciclo.Idioma"/>:</label>
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
