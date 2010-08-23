<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tlds/tags-catalogador.tld" prefix="cat" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/metametadatos/meta-metadatos-form-vars.jspf" %>

<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" id="rea">
<jsp:include page="/layout/messages.jsp" flush="true"/>
<h2><bean:message key="catalogadorAvanzado.SoloMetaMetadatos"/></h2>
<form method="post" name="metaMetadatosMetaMetadatosFormSubmitForm" action="<html:rewrite action="/MetaMetadatos/MetaMetadatosFormSubmit"/>" >
<p class="parrafo_comun" id="separacion2"><bean:message key="catalogadorAvanzado.General.TextoObligacion"/></p>

<input type="hidden" id="seleccionar" name="seleccionar" value="<bean:write name="form" property="accion"/>"/> 

<script type="text/javascript">
<!--
function seleccionarCampo() {
	ancla=document.getElementById('seleccionar').value;
	if (ancla != null) {
		var partes = new Array();
		partes=ancla.split("-");
		
		if(partes[0] == "Añadir Identificador"){
			document.location.href="#identificador";
		}
		else if(partes[0]=="Eliminar Identificador"){
			document.location.href="#identificador";
		}
		if(partes[0] == "Añadir Esquemas"){
			document.location.href="#esquemas";
		}
		else if(partes[0]=="Eliminar Esquemas"){
			document.location.href="#esquemas";
		}
		else if(partes[0]=="Añadir Contribucion"){
			document.location.href="#contribuciones";
		}
		else if(partes[0]=="Eliminar Contribucion"){
			indice = partes[1];
			if(indice>0){
				indice = indice -1;
			}
			document.location.href="#contribucion-"+indice;
		}
		else if(partes[0]=="Añadir Identidad"){
			indice = partes[1];//indice de la contribucion
			document.location.href="#entidades-"+indice;
		}
		else if(partes[0]=="Eliminar Identidad"){
			indice1 = partes[1];//indice dentro de la entidad
			indice2 = partes[2];//indice de la contribucion
			if(indice1>0){
				indice1 = indice1 -1;
			}
			document.location.href="#entidad-"+indice1+"-"+indice2;
		}
		else if(partes[0]=="Añadir Descripcion"){
			indice = partes[1];//indice de la contribucion
			document.location.href="#descripciones-"+indice;
		}
		else if(partes[0]=="Eliminar Descripcion"){
			indice1 = partes[1];//indice dentro de la entidad
			indice2 = partes[2];//indice de la contribucion
			if(indice1>0){
				indice1 = indice1 -1;
			}
			document.location.href="#descripcion-"+indice1+"-"+indice2;
		}
		
	}
	
}
window.onload=seleccionarCampo;
//-->
</script> 


<!--  INICIO GLOBO GRIS Identificador  -->
<!--  INICIO GLOBO GRIS Identificador  -->
<a id="identificador"></a>
<div class="globo_gris"  >
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
					
						<div class="fila_de_tabla_especial_03" style="padding-left:0 !important">
							<div class="contenedor_izquierda_esp">
								<div class="text">
									<label for="Cat${estado.index}"><bean:message key="catalogadorAvanzado.Meta.Catalogo"/>:</label>
								</div>
							</div>
							<div class="contenedor_izquierda_esp">
								<div class="text">
									<html:text styleClass="input_medio_largo" style="width:164px !important" property="IdCat${estado.index}" value="${identificador.catalogo}" styleId="Cat${estado.index}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaCatalogo" />
								</div>
							</div>
							<div class="contenedor_izquierda_esp">
								<div class="text">
									<label for="Ent${estado.index}" class="lab_ie"><bean:message key="catalogadorAvanzado.Meta.Entrada"/>:</label>
								</div>
							</div>
							<div class="contenedor_izquierda_esp">
								<div class="text">
									<html:text styleClass="input_medio" style="width:100px !important" property="IdEnt${estado.index}" value="${identificador.entrada}" styleId="Ent${estado.index}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaEntrada" />
								</div>
							</div>
							<div class="limpiar">
							</div><br class="oculto"/>
							
							</div>
							<!--  Fin Fila de Campos   -->
						</div>
					</div>
				</div>
			</div>

							<div class="flotder">
							<c:choose>
		                        <c:when test="${estado.index==0}">   
			                        <span class="oculto">-</span> 
			                        <span class="flotder enlace_anadir_02">
			                        <input class="boton_anadir flotder" type="submit" name="accion_Añadir Identificador" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
							        </span>
		                        </c:when>
		                        <c:otherwise>
		                        <span class="oculto">-</span> 
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
			                        <span class="flotder enlace_eliminar_02">
			                        <html:hidden property="posi" value="${ estado.index }" />
			                        <input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Identificador-${ estado.index }" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/>  
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
							<div class="limpiar">
							</div><br class="oculto"/>
						
					</c:forEach>
					<!--  Fin Fila de Campos   -->
					<!--  Fin Fila de Campos   -->
					<!-- -->
<!--  FIN GLOBO BLANCO   -->
	<!--  FIN GLOBO BLANCO   -->
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
					
					<!--anclas-->
					<c:choose>
                        <c:when test="${i== fn:length(form.contribucion)-1}">   
	                     <a id="contribuciones"></a>
                        </c:when>
                    </c:choose>	
					<a id="contribucion-${i}"></a>
					<!--fin de anclas-->
									<!--  Enlaces de fuera   -->
								<!--  Enlaces de fuera   -->
									<div class="pos_relative" id="flotantederecha">
										<c:choose>
											<c:when test="${i==0}">
												<span class="oculto">-</span>
												<span class="flotder enlace_anadir_03">
												<input class="boton_anadir flotder" type="submit" name="accion_Añadir Contribucion" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/>
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
												<input class="boton_eliminar foltder" type="submit" name="accion_Eliminar Contribucion-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/>
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
  						<bean:define id="tipo"><bean:message key="catalogadorAvanzado.SeleccioneTipo"/></bean:define>
  						<cat:select name="form" property="Cont${i}_Rol" value="${rol.valor}" backingList="${form.crolBackingList}" estiloSelect="select_lrg" estiloOscuro="oscura" title="${tipo}" />
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
										<!--anclas-->
										<c:choose>
					                        <c:when test="${j== fn:length(entidades)-1}">   
						                     <a id="entidades-${i}"></a>
					                        </c:when>
					                    </c:choose>	
										<a id="entidad-${j}-${i}"></a>
										<!--fin de anclas-->	
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
							<html:text styleClass="input_medio" property="Cont${i}_Ent${j}_Nom" value="${entidad.nombre}" styleId="Cont${i}_Ent${j}_Nom" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaNombre" />
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
						<html:text styleClass="input_medio" property="Cont${i}_Ent${j}_Org" value="${entidad.organizacion}" styleId="Cont${i}_Ent${j}_Org" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaOrganizacion" />
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
						<html:text styleClass="input_medio" property="Cont${i}_Ent${j}_Cor" value="${entidad.correo}" styleId="Cont${i}_Ent${j}_Cor" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaCorreo" />
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
												<input class="boton_anadir flotder" type="submit" name="accion_Añadir Identidad-${i}" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
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
												<input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Identidad-${j}-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/>
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
									<div class="globo_gris globito2 pos_relative conmargen" id="ficha">
										<div class="globo_gris_01">
											<div class="globo_gris_02">
												<div class="globo_gris_03"  style="padding:15px 15px 5px 15px">
												<!--  INICIO Fila de Campos   -->
												<h3 class="int_h3"><bean:message key="catalogadorAvanzado.Meta.Fecha"/></h3>
							<div class="globo_blanco globito2" >
							<div class="globo_blanco_01">
							<div class="globo_blanco_02">
							<div class="globo_blanco_03">
							<div class="yui-skin-sam">
													
				<!--  INICIO Fila de Campos   -->
				<!--  INICIO Fila de Campos   -->
				<c:set var="fecha" value="${contrib.fecha }"/>
				<bean:define id="nomMeses"><bean:message key="catalogadorAvanzado.nombresMeses"/></bean:define>
				<bean:define id="nomDias"><bean:message key="catalogadorAvanzado.nombresDias"/></bean:define>
				
				<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp lab_igual2">
  						<div class="text"><label ><bean:message key="catalogadorAvanzado.Meta.SoloFecha"/></label></div>
 					</div>
					<div class="contenedor_izquierda_esp"  id="cont_esp_fech">
  						<div class="text">
							<c:choose> 
  								<c:when test="${empty fecha.fechaCorta}">
  									<bean:define id="fechaFormato"><bean:message key="catalogadorAvanzado.formatoFecha"/></bean:define>
									<html:text styleClass="fechazo" value="${fechaFormato}" property="Cont${i}_FechaCorta" styleId="Cont${i}_FechaCorta" onblur="this.style.backgroundColor='#e1e1e1'" maxlength="10" titleKey="catalogadorAvanzado.IntroduzcaFecha" />
								</c:when>
								<c:otherwise >
									<html:text styleClass="fechazo" value="${fecha.fechaCorta}" property="Cont${i}_FechaCorta" styleId="Cont${i}_FechaCorta" onblur="this.style.backgroundColor='#e1e1e1'" maxlength="10" titleKey="catalogadorAvanzado.IntroduzcaFecha" />
								</c:otherwise>
							</c:choose>
							<script type="text/javascript">
							//<![CDATA[
  								
								window.addEvent('domready', function() 
								{ 
									jsMeses = "${nomMeses}"; arrayMeses = jsMeses.split(",");
									jsDias = "${nomDias}"; arrayDias = jsDias.split(",");
									myCal1 = new Calendar({ Cont${i}_FechaCorta : '${fecha.formato}' }, 
									{ direction: 0,tweak: {x: 6, y: 0},offset: ${fecha.offSet},months: arrayMeses ,days: arrayDias }); 
								} ); //]]>
							</script>
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
						<html:text styleClass="in_peq input_mder2 acentrado" property="Cont${i}_FechaHora" value="${fecha.hora}" styleId="Cont${i}_FechaHora"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.IntroduzcaHora" />
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="MinutosDur"  class="rdr" ><bean:message key="catalogadorAvanzado.Meta.Minutos"/></label>
						<html:text styleClass="in_peq input_mder2 acentrado" property="Cont${i}_FechaMin" value="${fecha.minutos}" styleId="Cont${i}_FechaMin"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.IntroduzcaMinutos" />						
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="SegundosDur"  class="rdr" ><bean:message key="catalogadorAvanzado.Meta.Segundos"/></label>
						<html:text styleClass="in_peq input_mder2 acentrado" property="Cont${i}_FechaSeg1" value="${fecha.segundoP1}" styleId="Cont${i}_FechaSeg1"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.IntroduzcaSegundos" />
					</div>
					</div>
					<div class="contenedor_izquierda_esp " >
					<div class="text input_mder2">.</div>
					</div>
					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="SegundosDur2" class="oculto" ><bean:message key="catalogadorAvanzado.Meta.Segundos"/></label>
						<html:text styleClass="in_peq  acentrado" property="Cont${i}_FechaSeg2" value="${fecha.segundoP2}" styleId="Cont${i}_FechaSeg2"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.IntroduzcaSegundos" />
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
									<input type="radio" checked name="Cont${i}_meridianoCero" onclick="document.getElementById('Cont${i}_FechaZonaH').disabled=true;document.getElementById('Cont${i}_FechaZHMinutos').disabled=true;document.getElementById('Cont${i}_FechaZHHora').disabled=true;document.getElementById('Cont${i}_FechaZHHora').style.backgroundColor='#e1e1e1';document.getElementById('Cont${i}_FechaZHMinutos').style.backgroundColor='#e1e1e1'" class="boton_radio" value="0" id="Cont${i}_meridianoCero"/>							
								</c:when>
								<c:otherwise>
								<input type="radio" name="Cont${i}_meridianoCero" onclick="document.getElementById('Cont${i}_FechaZonaH').disabled=true;document.getElementById('Cont${i}_FechaZHMinutos').disabled=true;document.getElementById('Cont${i}_FechaZHHora').disabled=true;document.getElementById('Cont${i}_FechaZHHora').style.backgroundColor='#e1e1e1';document.getElementById('Cont${i}_FechaZHMinutos').style.backgroundColor='#e1e1e1'" class="boton_radio" value="0" id="Cont${i}_meridianoCero"/>							
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
									<input type="radio" checked name="Cont${i}_meridianoCero" onclick="document.getElementById('Cont${i}_FechaZonaH').disabled=false;document.getElementById('Cont${i}_FechaZHMinutos').disabled=false;document.getElementById('Cont${i}_FechaZHHora').disabled=false;document.getElementById('Cont${i}_FechaZHHora').style.backgroundColor='#e1e1e1';document.getElementById('Cont${i}_FechaZHMinutos').style.backgroundColor='#e1e1e1'" class="boton_radio" value="1" id="Cont${i}_meridianoCero"/>							
								</c:when>
								<c:otherwise>
									<input type="radio" name="Cont${i}_meridianoCero" onclick="document.getElementById('Cont${i}_FechaZonaH').disabled=false;document.getElementById('Cont${i}_FechaZHMinutos').disabled=false;document.getElementById('Cont${i}_FechaZHHora').disabled=false;document.getElementById('Cont${i}_FechaZHHora').style.backgroundColor='#e1e1e1';document.getElementById('Cont${i}_FechaZHMinutos').style.backgroundColor='#e1e1e1'" class="boton_radio" value="1" id="Cont${i}_meridianoCero"/>							
								</c:otherwise>
							</c:choose>
							<label for="Cont${i}_meridianoCero2" class="oculto"><bean:message key="catalogadorAvanzado.Meta.MeridianoCero"/></label>
						</div>
					</div>
					<c:choose>
						<c:when test="${fecha.meridianoCero==1}">
							<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="HoraDur2" class="oculto" ><bean:message key="catalogadorAvanzado.Meta.Hora"/></label>
		  						<bean:define id="franja"><bean:message key="catalogadorAvanzado.SeleccioneFranjaHoraria"/></bean:define>
								<html:select styleClass="select_peq_n inp_se_ie"  name="comboZonaH" title="${franja }" property="Cont${i}_FechaZonaH" styleId="Cont${i}_FechaZonaH" value="${fecha.masOmenos}">
									<html:option value="" styleClass="oscura">&nbsp;</html:option>
									<html:option value="0" >+</html:option>
									<html:option value="1" styleClass="oscura">-</html:option>
								</html:select>
								</div>
							</div>
							<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="HoraDur2"  class="rdr" >&nbsp;&nbsp;<bean:message key="catalogadorAvanzado.Meta.Hora"/></label>
								<html:text styleClass="in_peq input_mder2 acentrado" property="Cont${i}_FechaZHHora" value="${fecha.zhHora}" styleId="Cont${i}_FechaZHHora"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.IntroduzcaHora" />
								</div>
							</div>
							<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="MinutosDur2" class="rdr" ><bean:message key="catalogadorAvanzado.Meta.Minutos"/></label>
								<html:text styleClass="in_peq input_mder2 acentrado" property="Cont${i}_FechaZHMinutos" value="${fecha.zhMinutos}" styleId="Cont${i}_FechaZHMinutos"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.IntroduzcaMinutos" />
								</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="HoraDur2" class="oculto" ><bean:message key="catalogadorAvanzado.Meta.Hora"/></label>
		  						<bean:define id="fran"><bean:message key="catalogadorAvanzado.SeleccioneFranjaHoraria"/></bean:define>
								<html:select styleClass="select_peq_n inp_se_ie" disabled="true" name="comboZonaH" title="${fran }" property="Cont${i}_FechaZonaH" styleId="Cont${i}_FechaZonaH" value="${fecha.masOmenos}">
									<html:option value="" styleClass="oscura">&nbsp;</html:option>
									<html:option value="0" >+</html:option>
									<html:option value="1" styleClass="oscura">-</html:option>
								</html:select>
								</div>
							</div>
							<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="HoraDur2"  class="rdr" >&nbsp;&nbsp;<bean:message key="catalogadorAvanzado.Meta.Hora"/></label>
								<html:text styleClass="in_peq input_mder2 acentrado" disabled="true" property="Cont${i}_FechaZHHora" value="${fecha.zhHora}" styleId="Cont${i}_FechaZHHora"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.IntroduzcaHora" />
								</div>
							</div>
							<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="MinutosDur2" class="rdr" ><bean:message key="catalogadorAvanzado.Meta.Minutos"/></label>
								<html:text styleClass="in_peq input_mder2 acentrado" disabled="true" property="Cont${i}_FechaZHMinutos" value="${fecha.zhMinutos}" styleId="Cont${i}_FechaZHMinutos"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.IntroduzcaMinutos" />
								</div>
							</div>
						</c:otherwise>
					</c:choose>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  Fin Fila de Campos   -->
				</div>
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
						<!--anclas-->
						<c:choose>
							<c:when test="${k== fn:length(textos)-1}">   
							 <a id="descripciones-${i}"></a>
							</c:when>
						</c:choose>	
						<a id="descripcion-${k}-${i}"></a>
						<!--fin de anclas-->	
				<div class="fila_de_tabla_especial" style="padding-left:0 !important">
  					<div class="contenedor_izquierda_esp">
  						<div class="text"><label for="Mas01" ><bean:message key="catalogadorAvanzado.Meta.Descripcion"/></label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
							<html:textarea styleClass="input_medio input_mder"  property="Cont${i}_DesFecTex${k}" styleId="Cont${i}_DesFec${k}" value="${texto.texto}" onblur="this.style.backgroundColor='#e1e1e1'" cols="5" rows="4" titleKey="catalogadorAvanzado.IntroduzcaDescripcion" />
						</div>
					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
							<label for="Idio019" class="oculto" ><bean:message key="catalogadorAvanzado.Meta.SoloIdioma"/>:</label>
							<bean:define id="descrip"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
							<cat:select name="form" property="Cont${i}_DesFecIdio${k}" value="${texto.idioma}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq_n inp_se_ie" estiloOscuro="oscura" title="${descrip}"/>
						</div>
					</div>
					<div class="float_izquierda_n">
						<c:choose>
							<c:when test="${k==0}">
								<span class="oculto">-</span>
								<input class="boton_anadir cms" type="submit" name="accion_Añadir Descripcion-${i}" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/>
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
								<input class="boton_eliminar cms" type="submit" name="accion_Eliminar Descripcion-${k}-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/>
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
<a id="esquemas"></a>
<div class="globo_gris conmargen"  >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
			<h3 class="h3flotante"><bean:message key="catalogadorAvanzado.Meta.Esquema"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
<c:forEach var="esquema" items="${form.esquemasMeta }" varStatus="estado">
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
  							<html:text styleClass="input_medio_largo" style="width:420px !important" property="Esq${estado.index}" value="${esquema.texto}" styleId="Esq${estado.index}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaEsquema" />
  						</div>
  						<div class="limpiar"></div>
					<br class="oculto" />
 					</div>
 				</div>
 						</div>
 					</div>
 				</div>
 			</div>
					<div class="flotder">
					<c:choose>
                        <c:when test="${estado.index==0}">   
	                        <span class="oculto">-</span> 
		                        <span class="flotder enlace_anadir_02">
		                        	<input class="boton_anadir flotder" type="submit" name="accion_Añadir Esquemas" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
						        </span>
                        </c:when>
                        <c:otherwise>
	                        <span class="oculto">-</span>
							<span class="flotder enlace_anadir_02">
	                         &nbsp;
	                         </span>
                        </c:otherwise>
                    </c:choose>	
					</div>
					<div class="flotder">
					<c:set var="longitud" value="${ fn:length(form.esquemasMeta) }"/>
					<c:choose>
                        <c:when test="${longitud>1}">   
	                        <span class="oculto">-</span>
							<span class="flotder enlace_eliminar_02">
	                        <html:hidden property="posi" value="${ estado.index }" />
	                        <input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Esquemas-${ estado.index }" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
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
					<div class="limpiar"></div>
					</c:forEach>
				</div>	
				</div>
				</div>
				</div>
				</div>
			
			
				<!--  Fin Fila de Campos   -->
				<!--  Fin Fila de Campos   -->	
				<!--  FIN GLOBO BLANCO   -->
				<!--  FIN GLOBO BLANCO   -->

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
  						<div class="text">
  							<label for="Idioma01" class="oculto" ><bean:message key="catalogadorAvanzado.Meta.SoloIdioma"/>:</label>
  							<bean:define id="idiom"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
					  		<cat:select name="form" property="comboIdiomaMeta" value="${form.comboIdiomaMeta}" backingList="${form.comboIdiomaMetaBackingList}" estiloSelect="select_lrg" estiloOscuro="oscura" title="${idiom}"/>
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
	<input class="boton_125" id="reset_but" type="submit" name="accion" value="<bean:message key="metadatos.Reset"/>" /><br />

	<input class="boton_125_de_2"  type="submit" name="accion" value="<bean:message key="metadatos.Aceptar"/>" />
	<input class="boton_125_de_2_izq"  type="submit"  name="accion"  value="<bean:message key="metadatos.Cancelar"/>" />
	<input class="boton_125"  type="submit"  name="accion" value="<bean:message key="metadatos.Validar"/>" />
</fieldset>
</form>

<!-- Fin Botones  -->
<!-- Fin Botones  -->
</div>
<!-- Fin plantilla contenido  -->
</tiles:put>

</tiles:insert>
