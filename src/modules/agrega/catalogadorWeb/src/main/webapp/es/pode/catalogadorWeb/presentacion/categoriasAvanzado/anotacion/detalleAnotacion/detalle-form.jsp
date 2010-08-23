<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tlds/tags-catalogador.tld" prefix="cat" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/anotacion/detalleAnotacion/detalle-form-vars.jspf" %>


<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" id="rea">
<jsp:include page="/layout/messages.jsp" flush="true"/>
<h2><bean:message key="anotaciones.Anotacion"/> ${tituloAnotacion}</h2>
<form method="post" action="<html:rewrite action="/DetalleAnotacionCU/DetalleFormSubmitForm"/>" >
<p class="parrafo_comun" id="separacion2"><bean:message key="catalogadorAvanzado.General.TextoObligacion" /></p>

<input type="hidden" id="seleccionar" name="seleccionar" value="<bean:write name="form" property="accion"/>"/> 

<script type="text/javascript">
function seleccionarCampo() {
	ancla=document.getElementById('seleccionar').value;
	if (ancla != null) {
		var partes = new Array();
		partes=ancla.split("-");
		
		if(partes[0] == "Añadir Descripcion"){
			document.location.href="#descripciones";
		}
		else if(partes[0]=="Eliminar Descripcion"){
			indice = partes[1];
			if(indice>0){
				indice = indice -1;
			}
			document.location.href="#descripciones-"+indice;
		}
		if(partes[0] == "Añadir DescFecha"){
			document.location.href="#descripcionesFech";
		}
		else if(partes[0]=="Eliminar DescFecha"){
			indice = partes[1];
			if(indice>0){
				indice = indice -1;
			}
			document.location.href="#descripcionesFech-"+indice;
		}
		
	}
	
}
window.onload=seleccionarCampo;
</script>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris conmargen"  >
<div class="globo_gris_01">
<div class="globo_gris_02">
<div class="globo_gris_03">
	<!--  INICIO CAJA DE FORMULARIO   -->
	<div class="formu" >
		<h3><bean:message key="catalogadorAvanzado.detalleAnotacion.Recurso"/></h3>
		<!--  INICIO GLOBO Blanco   -->
		<div class="globo_blanco pos_relative conmargen" >
		<div class="globo_blanco_01">
		<div class="globo_blanco_02">
		<div class="globo_blanco_03">
		<!--  INICIO Fila de Campos   -->
			<div class="fila_de_tabla_especial_03" >
  			<div class="contenedor_izquierda_esp lab_igual">
  			<div class="text"><label for="Nombre01" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Nombre"/></label></div>
 			</div>
			<div class="contenedor_izquierda_esp" >
			<div class="text">
				<html:text styleClass="input_medio"  property="Nombre" styleId="Nombre" value="${nombre }"  onblur="this.style.backgroundColor='#e1e1e1'"  titleKey="catalogadorAvanzado.IntroduzcaNombre"  />
			</div>
			</div>
			<div class="limpiar"></div>
			<br class="oculto" />
			</div>	
			<!--  Fin Fila de Campos   -->
			<!--  INICIO Fila de Campos   -->
			<div class="fila_de_tabla_especial_03" >
  			<div class="contenedor_izquierda_esp lab_igual">
  			<div class="text"><label for="Organizacion01" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Organizacion"/></label></div>
 			</div>
			<div class="contenedor_izquierda_esp" >
			<div class="text">
				<html:text styleClass="input_medio"  property="Organizacion" styleId="Organizacion" value="${organizacion}"  onblur="this.style.backgroundColor='#e1e1e1'"  titleKey="catalogadorAvanzado.IntroduzcaOrganizacion"  />
			</div>
			</div>
			<div class="limpiar"></div>
			<br class="oculto" />
			</div>	
			<!--  Fin Fila de Campos   -->
			<!--  INICIO Fila de Campos   -->
			<div class="fila_de_tabla_especial_03" >
  			<div class="contenedor_izquierda_esp lab_igual">
  			<div class="text"><label for="Email01" ><bean:message key="catalogadorAvanzado.detalleAnotacion.correoelectronico"/></label></div>
 			</div>
			<div class="contenedor_izquierda_esp" >
			<div class="text">
				<html:text styleClass="input_medio"  property="Email" styleId="Email01" value="${email}" onblur="this.style.backgroundColor='#e1e1e1'"  titleKey="catalogadorAvanzado.IntroduzcaCorreo"  />
			</div>
			</div>
			<div class="limpiar"></div>
			<br class="oculto" />
			</div>	
			<!--  Fin Fila de Campos   -->
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
<div class="globo_gris conmargen pos_relative"  >
<div class="globo_gris_01">
<div class="globo_gris_02">
<div class="globo_gris_03">
	<!--  INICIO CAJA DE FORMULARIO   -->
	<div id="formulario_02" >
		<div class="yui-skin-sam">
		<h3><bean:message key="catalogadorAvanzado.detalleAnotacion.Fecha"/></h3>
		<!--  INICIO GLOBO Blanco   -->
		<div class="globo_blanco pos_relative conmargen">
		<div class="globo_blanco_01" >
		<div class="globo_blanco_02">
		<div class="globo_blanco_03">
		<!--  INICIO GLOBO GRIS   -->
		<div class="globo_gris globito2 pos_relative" >
		<div class="globo_gris_01">
		<div class="globo_gris_02">
		<div class="globo_gris_03">
		<!--  INICIO Fila de Campos   -->
			<div class="fila_de_tabla_especial_02" >
  			<div class="contenedor_izquierda_esp lab_igual">
  			<div class="text"><label ><bean:message key="catalogadorAvanzado.detalleAnotacion.SoloFecha"/></label></div>
 			</div>
			<bean:define id="nomMeses"><bean:message key="catalogadorAvanzado.nombresMeses"/></bean:define>
			<bean:define id="nomDias"><bean:message key="catalogadorAvanzado.nombresDias"/></bean:define>
 			
			<div class="contenedor_izquierda_esp" id="cont_esp_fech">
			<div class="text">
					<c:choose> 
						<c:when test="${empty fechaCorta}">
							<bean:define id="fechaFormato"><bean:message key="catalogadorAvanzado.formatoFecha"/></bean:define>
							<html:text styleClass="fechazo" value="${fechaFormato}" property="FechaCorta" styleId="FechaCorta" onblur="this.style.backgroundColor='#e1e1e1'" maxlength="10" titleKey="catalogadorAvanzado.IntroduzcaFecha" />
						</c:when>
						<c:otherwise >
							<html:text styleClass="fechazo" value="${fechaCorta}" property="FechaCorta" styleId="FechaCorta" onblur="this.style.backgroundColor='#e1e1e1'" maxlength="10" titleKey="catalogadorAvanzado.IntroduzcaFecha" />
						</c:otherwise>
					</c:choose>
					<script type="text/javascript">
					//<![CDATA[
								
						window.addEvent('domready', function() 
						{ 
							jsMeses = "${nomMeses}"; arrayMeses = jsMeses.split(",");
							jsDias = "${nomDias}"; arrayDias = jsDias.split(",");
							myCal1 = new Calendar({ "FechaCorta" : '${formato}' }, 
							{ direction: 0,tweak: {x: 6, y: 0},offset: ${offSet},months: arrayMeses ,days: arrayDias }); 
						} ); //]]>
					</script>
			</div>
			</div>

			<div class="limpiar"></div>
			<br class="oculto" />
			</div>	
			<!--  Fin Fila de Campos   -->
			<!--  INICIO Fila de Campos   -->
			<div class="fila_de_tabla_especial_02" >
  			<div class="contenedor_izquierda_esp lab_igual">
  			<div class="text"><label ><bean:message key="catalogadorAvanzado.detalleAnotacion.Tiempo"/></label></div>
 			</div>
			<div class="contenedor_izquierda_esp" >
  			<div class="text"><label for="HoraDur" class="rdr" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Hora"/></label>
				<html:text styleClass="in_peq input_mder2 acentrado"   property="HoraDur" styleId="HoraDur" value="${thora }"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.IntroduzcaHora"  />
			</div>
			</div>
			<div class="contenedor_izquierda_esp" >
  			<div class="text"><label for="MinutosDur" class="rdr" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Minutos"/></label>
				<html:text styleClass="in_peq input_mder2 acentrado"   property="MinutosDur" styleId="MinutosDur" value="${tminuto}"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2"  titleKey="catalogadorAvanzado.IntroduzcaMinutos"  />
			</div>
			</div>
			<div class="contenedor_izquierda_esp" >
  			<div class="text"><label for="SegundosDur" class="rdr" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Segundos"/></label>
				<html:text styleClass="in_peq input_mder2 acentrado"   property="SegDurP1" styleId="SegDurP1" value="${tsegundoP1 }"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2"  titleKey="catalogadorAvanzado.IntroduzcaSegundos"  />
			</div>
			</div>
			<div class="contenedor_izquierda_esp " >
			<div class="text input_mder2">.</div>
			</div>
			<div class="contenedor_izquierda_esp" >
  			<div class="text"><label for="SegundosDur2" class="oculto" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Segundos"/></label>
				<html:text  styleClass="in_peq  acentrado"   property="SegDurP2" styleId="SegDurP2" value="${tsegundoP2 }"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2"  titleKey="catalogadorAvanzado.IntroduzcaSegundos"  />
			</div>
			</div>
			<div class="limpiar"></div>
			<br class="oculto" />
			</div>	
			<!--  Fin Fila de Campos   -->
			<!--  INICIO Fila de Campos   -->
			<div class="fila_de_tabla_especial_02" >
  			<div class="contenedor_izquierda_esp lab_igual">
  			<div class="text"><label><bean:message key="catalogadorAvanzado.detalleAnotacion.ZonaHoraria"/></label></div>
 			</div>
			<div class="contenedor_izquierda_esp" >
			<div class="text">
				<c:choose>
					<c:when test="${meridianoCero==0}">
						<input type="radio" checked name="meridianoCero" onclick="document.getElementById('comboZonaH').disabled=true;document.getElementById('zhMinutos').disabled=true;document.getElementById('zhHora').disabled=true;document.getElementById('zhHora').style.backgroundColor='#e1e1e1';document.getElementById('zhMinutos').style.backgroundColor='#e1e1e1'" class="boton_radio" value="0" id="meridianoCero"/>							
					</c:when>
					<c:otherwise>
						<input type="radio" name="meridianoCero" onclick="document.getElementById('comboZonaH').disabled=true;document.getElementById('zhMinutos').disabled=true;document.getElementById('zhHora').disabled=true;document.getElementById('zhHora').style.backgroundColor='#e1e1e1';document.getElementById('zhMinutos').style.backgroundColor='#e1e1e1'" class="boton_radio" value="0" id="meridianoCero"/>							
					</c:otherwise>
				</c:choose>
				<label for="meridianoCero" class="alineada"><bean:message key="detalleAnotacion.meridianocero"/></label>
			</div>
			</div>
			<div class="limpiar"></div>
			<br class="oculto" />
			</div>	
			<!--  Fin Fila de Campos   -->
			<!--  INICIO Fila de Campos   -->
			<div class="fila_de_tabla_especial_02" >
  			<div class="contenedor_izquierda_esp lab_igual">
  			<div class="text">&nbsp;</div>
 			</div>
			<div class="contenedor_izquierda_esp" >
			<div class="text">
				<c:choose>
						<c:when test="${meridianoCero==1}">
							<input type="radio" checked name="meridianoCero" onclick="document.getElementById('comboZonaH').disabled=false;document.getElementById('zhMinutos').disabled=false;document.getElementById('zhHora').disabled=false;document.getElementById('zhHora').style.backgroundColor='#e1e1e1';document.getElementById('zhMinutos').style.backgroundColor='#e1e1e1'" class="boton_radio" value="1" id="meridianoCero"/>							
						</c:when>
						<c:otherwise>
							<input type="radio" name="meridianoCero" onclick="document.getElementById('comboZonaH').disabled=false;document.getElementById('zhMinutos').disabled=false;document.getElementById('zhHora').disabled=false;document.getElementById('zhHora').style.backgroundColor='#e1e1e1';document.getElementById('zhMinutos').style.backgroundColor='#e1e1e1'" class="boton_radio" value="1" id="meridianoCero"/>							
						</c:otherwise>
					</c:choose>
				<label for="meridianoCero" class="oculto"><bean:message key="detalleAnotacion.meridianocero"/></label>
			</div>
			</div>
			<c:choose>
						<c:when test="${meridianoCero==1}">
							<div class="contenedor_izquierda_esp" >
				  			<div class="text"><label for="Idio0a15" class="oculto" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Hora"/></label>
				  				<bean:define id="franja"><bean:message key="catalogadorAvanzado.SeleccioneFranjaHoraria"/></bean:define>
								<html:select styleClass="select_peq_n inp_se_ie"  name="comboZonaH" title="${franja }" property="comboZonaH" styleId="comboZonaH" value="${form.comboZonaH}">
									<html:option value="" styleClass="oscura">&nbsp;</html:option>
									<html:option value="0" >+</html:option>
									<html:option value="1" styleClass="oscura">-</html:option>
								</html:select>
							</div>
							</div>
							<div class="contenedor_izquierda_esp" >
				  			<div class="text"><label for="HoraDur2"  class="rdr" >&nbsp;&nbsp; <bean:message key="catalogadorAvanzado.detalleAnotacion.Hora"/></label>
								<html:text styleClass="in_peq input_mder2 acentrado"   property="zhHora" styleId="zhHora" value="${zhHora}"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2"  titleKey="catalogadorAvanzado.detalleAnotacion.Hora"  />
							</div>
							</div>
							<div class="contenedor_izquierda_esp" >
				  			<div class="text"><label for="MinutosDur2" class="rdr" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Minutos"/></label>
								<html:text styleClass="in_peq input_mder2 acentrado"   property="zhMinutos" styleId="zhMinutos" value="${zhMinutos}"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2"  titleKey="catalogadorAvanzado.detalleAnotacion.Minutos"  />
							</div>
							</div>
						</c:when>
						<c:otherwise>
							<div class="contenedor_izquierda_esp" >
				  			<div class="text"><label for="Idio0a15" class="oculto" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Hora"/></label>
				  			<bean:define id="fran"><bean:message key="catalogadorAvanzado.SeleccioneFranjaHoraria"/></bean:define>
								<html:select styleClass="select_peq_n inp_se_ie" disabled="true" name="comboZonaH" title="${fran }" property="comboZonaH" styleId="comboZonaH" value="${form.comboZonaH}">
								
									<html:option value="" styleClass="oscura">&nbsp;</html:option>
									<html:option value="0" >+</html:option>
									<html:option value="1" styleClass="oscura">-</html:option>
								</html:select>
							</div>
							</div>
							<div class="contenedor_izquierda_esp" >
				  			<div class="text"><label for="HoraDur2"  class="rdr" >&nbsp;&nbsp; <bean:message key="catalogadorAvanzado.detalleAnotacion.Hora"/></label>
								<html:text styleClass="in_peq input_mder2 acentrado" disabled="true"  property="zhHora" styleId="zhHora" value="${zhHora}"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2"  titleKey="catalogadorAvanzado.IntroduzcaHora"  />
							</div>
							</div>
							<div class="contenedor_izquierda_esp" >
				  			<div class="text"><label for="MinutosDur2" class="rdr" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Minutos"/></label>
								<html:text styleClass="in_peq input_mder2 acentrado"  disabled="true" property="zhMinutos" styleId="zhMinutos" value="${zhMinutos}"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2"  titleKey="catalogadorAvanzado.IntroduzcaMinutos" />
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
			
		<!--  INICIO Descripción   -->
		<div class="globo_gris globito2 conmargen" >
		<div class="globo_gris_01">
		<div class="globo_gris_02">
		<div class="globo_gris_03">
		<!--  INICIO Fila de Campos   -->
		<logic:iterate name="descripcionFecha" id="descFecha" indexId="i">
		<!--anclas-->
					<c:choose>
                        <c:when test="${i== fn:length(form.descripcionFecha)-1}">   
	                     <a id="descripcionesFech"></a>
                        </c:when>
                    </c:choose>	
					<a id="descripcionesFech-${i}"></a>
					<!--fin de anclas-->
			<div class="fila_de_tabla_especial_02" >
  			<div class="contenedor_izquierda_esp">
  			<div class="text"><label for="Mas01" ><bean:message key="catalogadorAvanzado.detalleAnotacion.SoloDescripcion"/></label></div>
 			</div>
 			<div class="contenedor_izquierda_esp" >
			<div class="text">
				<html:textarea styleClass="input_medio_largo input_mder"  property="DesFecTex${i}" styleId="DesFec${i}" value="${descFecha.texto}" onblur="this.style.backgroundColor='#e1e1e1'" cols="5" rows="4" titleKey="catalogadorAvanzado.IntroduzcaDescripcion" />
			</div>
			</div>
			<div class="contenedor_izquierda_esp" >
			<div class="text"><label for="Idio015" class="oculto" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Idioma"/></label>
				<bean:define id="desc"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
				<cat:select name="form" property="DesFecIdio${i}" value="${descFecha.idioma}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq_n inp_se_ie" estiloOscuro="oscura" title="${desc}"/>
				
			</div>
			</div>
			<div class="float_izquierda_n">
				<c:choose>
					<c:when test="${i==0}">
						<span class="oculto">-</span>
						<input class="boton_anadir cms2" type="submit" name="accion_Añadir DescFecha" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"></input>
					</c:when>
					<c:otherwise>
						<span class="oculto">-</span>
						 &nbsp;
					</c:otherwise>
				</c:choose>
			</div>
			<div class="float_izquierda_n">
				<c:set var="longi" value="${fn:length(form.descripcionFecha)}" />
				<c:choose>
					<c:when test="${longi>1}">
						<span class="oculto">-</span>
						<input class="boton_eliminar cms2" type="submit" name="accion_Eliminar DescFecha-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"></input>
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
		<!--  FIN GLOBO GRIS   -->
	</div>
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
<!--  INICIO GLOBO GRIS Descripción -->
<div class="globo_gris pos_relative conmargen" >
<div class="globo_gris_01">
<div class="globo_gris_02">
<div class="globo_gris_03">
	<!--  INICIO CAJA DE FORMULARIO   -->
	<div id="formulario" >
			
		<h3><bean:message key="catalogadorAvanzado.detalleAnotacion.Descripcion"/></h3>
		<!--  INICIO GLOBO Blanco   -->
		<div class="globo_blanco " >
		<div class="globo_blanco_01">
		<div class="globo_blanco_02">
		<div class="globo_blanco_03">
		<!--  INICIO Fila de Campos   -->
			<logic:iterate name="descripcion" id="unaDesc" indexId="di"><!--anclas-->
					<c:choose>
                        <c:when test="${di== fn:length(form.descripcion)-1}">   
	                     <a id="descripciones"></a>
                        </c:when>
                    </c:choose>	
					<a id="descripciones-${di}"></a>
					<!--fin de anclas-->
			
				<div class="fila_de_tabla_especial" style="padding-left:0 !important">
  				<div class="contenedor_izquierda_esp" >
				<div class="text"><label for="Des01" class="oculto" ><bean:message key="catalogadorAvanzado.detalleAnotacion.SoloDescripcion"/></label>
					<html:textarea styleClass="input_medio_largo input_mder" property="DesTex${di}" styleId="DesTex${di }" value="${unaDesc.texto}" onblur="this.style.backgroundColor='#e1e1e1'" cols="5" rows="4" titleKey="catalogadorAvanzado.IntroduzcaDescripcion"/>	
				</div>
				</div>
				<div class="contenedor_izquierda_esp" >
				<div class="text"><label for="Idio013" class="oculto" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Idioma"/></label>
				<bean:define id="descrip"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
					<cat:select name="form" property="DesIdio${di}" value="${unaDesc.idioma}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq_n inp_se_ie" estiloOscuro="oscura" title="${descrip}"/>
				</div>
				</div>
				<div class="float_izquierda_n">
					<c:choose>
					<c:when test="${di==0}">
						<span class="oculto">-</span>
						<input class="boton_anadir cms2" type="submit" name="accion_Añadir Descripcion" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"></input>
					</c:when>
					<c:otherwise>
						<span class="oculto">-</span>
						 &nbsp;
					</c:otherwise>
					</c:choose>
				</div>
				<div class="float_izquierda_n">
					<c:set var="longD" value="${fn:length(form.descripcion)}" />
					<c:choose>
					<c:when test="${longD>1}">
						<span class="oculto">-</span>
						<input class="boton_eliminar cms2" type="submit" name="accion_Eliminar Descripcion-${di}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"></input>
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
				<!--  Fin Fila de Campos   -->
			</logic:iterate>
		</div>
		</div>
		</div>
		</div>
		<!--  FIN GLOBO BLANCO   -->
	</div>
	<!--  FIN CAJA DE FORMULARIO   -->
</div>
</div>
</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!-- Inicio Botones  -->

<fieldset class="tipo ft_centrada">
	<input class="boton_125" id="reset_but" type="submit" name="accion" value="<bean:message key="anotacion.Reset"/>" /><br />

	<input class="boton_125_de_2"  type="submit" name="accion" value="<bean:message key="anotacion.Aceptar"/>" />
	<input class="boton_125_de_2_izq"  type="submit"  name="accion"  value="<bean:message key="anotacion.Cancelar"/>" />
	<input class="boton_125"  type="submit"  name="accion" value="<bean:message key="anotacion.Validar"/>" />
</fieldset>
<!-- Fin Botones  -->
</form>
</div>
<!-- Fin plantilla contenido  -->
</tiles:put>

</tiles:insert>
