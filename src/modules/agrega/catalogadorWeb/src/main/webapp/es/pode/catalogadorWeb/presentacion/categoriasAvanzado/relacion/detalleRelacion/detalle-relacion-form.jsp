<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tlds/tags-catalogador.tld" prefix="cat" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado">
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
<form method="post" action="<html:rewrite action="/DetalleRelacionCU/DetalleRelacionFormSubmitForm" />" >


 

<p class="parrafo_comun" id="separacion2"><bean:message key="catalogadorAvanzado.General.TextoObligacion"/></p>

<input type="hidden" id="seleccionar" name="seleccionar" value="<bean:write name="form" property="accion"/>"/> 

<script type="text/javascript"> 
function seleccionarCampo() {
	ancla=document.getElementById('seleccionar').value;
	if (ancla != null) {
		var partes = new Array();
		partes=ancla.split("-");
		if(partes[0]=="Añadir Descripcion"){
			document.location.href="#descripciones";
		}
		else if(partes[0]=="Eliminar Descripcion"){
			indice = partes[1];
			if(indice>0){
				indice = indice -1;
			}
			document.location.href="#descripcion-"+indice;
		}
		else if(partes[0]=="Añadir ContDescripcion"){
			indice = partes[1];//indice de la descripcion
			document.location.href="#contDescripciones-"+indice;
		}
		else if(partes[0]=="Eliminar ContDescripcion"){
			indice1 = partes[1];//indice dentro de la descripcion
			indice2 = partes[2];//indice de la descripcion
			if(indice1>0){
				indice1 = indice1 -1;
			}
			document.location.href="#contDescripcion-"+indice1+"-"+indice2;
		}
		
	}
	
}
window.onload=seleccionarCampo;
</script>
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
  						<div class="text">
  							<label for="SeleccionTipo" class="oculto">Seleccione Tipo:</label>
  							<bean:define id="tipo"><bean:message key="catalogadorAvanzado.SeleccioneTipo"/></bean:define>
							<cat:select name="form" property="tipo" value="${form.tipo}" backingList="${form.tipoBackingList}" estiloSelect="select_lrg"  title="${tipo}"  estiloOscuro="oscura"/>
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
  																<html:text styleClass="input_medio" property="Cat" value="${catalogo}" styleId="Cat" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaCatalogo" />
															</div>

														</div>
														<div class="contenedor_izquierda_esp">
															<div class="text">
																<label for="Ent01" class="lab_ie"><bean:message key="catalogadorAvanzado.DetalleRel.Entrada"/>:</label>
															</div>
														</div>
														<div class="contenedor_izquierda_esp">
															<div class="text"><label for="form" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleRel.SoloEntrada"/>:</label>
  																<html:text styleClass="input_medio" property="Ent" value="${entrada}" styleId="Ent" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaEntrada" />
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
<logic:iterate id="descrip" name="descripcion" indexId="i">	
					<!--anclas-->
													<c:choose>
								                        <c:when test="${i== fn:length(form.descripcion)-1}">   
									                     <a id="descripciones"></a>
								                        </c:when>
								                    </c:choose>	
													<a id="descripcion-${i}"></a>
													<!--fin de anclas-->							
							
							<!--  INICIO GLOBO GRIS   -->
							<!--  INICIO GLOBO GRIS   -->
									<div class="globo_gris globito flotder" >
										<div class="globo_gris_01">
											<div class="globo_gris_02">
												<div class="globo_gris_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
							<c:set var="textos" value="${descrip.textos }"/>
							<c:set var="longDescripcion" value="${ fn:length(textos) }"/>				
							<logic:iterate id="contenido" name="textos" indexId="j">
							<!--anclas-->
													<c:choose>
								                        <c:when test="${j== fn:length(textos)-1}">   
									                     <a id="contDescripciones-${i}"></a>
								                        </c:when>
								                    </c:choose>	
													<a id="contDescripcion-${j}-${i}"></a>
													<!--fin de anclas-->	
							<c:set var="indice" value="${j + longDescripcionAnterior}"/>
						<div class="fila_de_tabla_especial_02" >

  					<div class="contenedor_izquierda_esp" >
  						<div class="text">
  							<label for="Des${i}" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleRel.SoloDescripcion"/>:</label>
								<html:textarea styleClass="input_medio_largo input_mder" property="Des${i}_Tex${j}" value="${contenido.texto}" styleId="Des${i}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaDescripcion" cols="5" rows="4"  />
						</div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
							<label for="Idio01" class="oculto" ><bean:message key="catalogadorAvanzado.DetalleRel.SoloIdioma"/>:</label>
							<bean:define id="descr"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
							<cat:select name="form" property="Des${i}_Idio${j}" value="${contenido.idioma}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq_n inp_se_ie"  estiloOscuro="oscura" title="${descr}"/>
						</div>
					</div>
					<div class="float_izquierda_n">

							<c:choose>
								<c:when test="${j==0}">   
									<span class="oculto">-</span> 
									<input class="boton_anadir cms_ie" type="submit" name="accion_Añadir ContDescripcion-${i}" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"> 
									</input>
								
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
								<input class="boton_eliminar cms_ie" type="submit" name="accion_Eliminar ContDescripcion-${j}-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"> 
								</input>
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
													<input class="boton_anadir flotder" type="submit" name="accion_Añadir Descripcion" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"> 
													</input>
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
													<input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Descripcion-${i }" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"> 
													</input>
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
	<input class="boton_125" id="reset_but" type="submit" name="accion" value="<bean:message key="detallerelacion.Reset"/>" /><br />

	<input class="boton_125_de_2_izq"  type="submit"  name="accion"  value="<bean:message key="detallerel.Cancelar"/>" />
	<input class="boton_125_de_2"  type="submit" name="accion" value="<bean:message key="detallerel.Aceptar"/>" />
	<input class="boton_125"  type="submit"  name="accion" value="<bean:message key="detallerel.Validar"/>" />
</fieldset>


</form>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</div>
<!-- Fin plantilla contenido  -->
</tiles:put>

</tiles:insert>
