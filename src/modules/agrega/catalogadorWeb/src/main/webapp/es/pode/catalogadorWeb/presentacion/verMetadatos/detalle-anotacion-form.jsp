<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado-verMetadatos">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/anotacion/detalleAnotacion/detalle-form-vars.jspf" %>


<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" id="rea">
<jsp:include page="/layout/messages.jsp" flush="true"/>
<h2><bean:message key="anotaciones.Anotacion"/> ${tituloAnotacion}</h2>
<form method="post" action="<html:rewrite action="/VerMetadatos/DetalleAnotacionFormVuelveDeDetalleAnotacion"/>" >

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
				<html:text readonly="true" styleClass="input_medio"  property="Nombre" styleId="Nombre" value="${nombre }"  onblur="this.style.backgroundColor='#e1e1e1'"  titleKey="catalogadorAvanzado.detalleAnotacion.Nombre"  />
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
				<html:text readonly="true" styleClass="input_medio"  property="Organizacion" styleId="Organizacion" value="${organizacion}"  onblur="this.style.backgroundColor='#e1e1e1'"  titleKey="catalogadorAvanzado.detalleAnotacion.Organizacion"  />
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
				<html:text readonly="true" styleClass="input_medio"  property="Email" styleId="Email01" value="${email}" onblur="this.style.backgroundColor='#e1e1e1'"  titleKey="catalogadorAvanzado.detalleAnotacion.correoelectronico"  />
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
			<div class="contenedor_izquierda_esp"  id="cont_esp_fech">
				<div class="text">
					<html:text readonly="true" styleClass="fechazo" value="${fechaCorta}" property="FechaCorta" styleId="FechaCorta" onblur="this.style.backgroundColor='#e1e1e1'" maxlength="10" titleKey="catalogadorAvanzado.IntroduzcaFecha" />
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
				<html:text readonly="true" styleClass="in_peq input_mder2 acentrado"   property="HoraDur" styleId="HoraDur" value="${thora } "  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" titleKey="catalogadorAvanzado.detalleAnotacion.Hora"  />
			</div>
			</div>
			<div class="contenedor_izquierda_esp" >
  			<div class="text"><label for="MinutosDur" class="rdr" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Minutos"/></label>
				<html:text readonly="true" styleClass="in_peq input_mder2 acentrado"   property="MinutosDur" styleId="MinutosDur" value="${tminuto}"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2"  titleKey="catalogadorAvanzado.detalleAnotacion.Minutos"  />
			</div>
			</div>
			<div class="contenedor_izquierda_esp" >
  			<div class="text"><label for="SegundosDur" class="rdr" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Segundos"/></label>
				<html:text readonly="true" styleClass="in_peq input_mder2 acentrado"   property="SegDurP1" styleId="SegDurP1" value="${tsegundoP1 } "  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2"  titleKey="catalogadorAvanzado.detalleAnotacion.Segundos"  />
			</div>
			</div>
			<div class="contenedor_izquierda_esp " >
			<div class="text input_mder2">.</div>
			</div>
			<div class="contenedor_izquierda_esp" >
  			<div class="text"><label for="SegundosDur2" class="oculto" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Segundos"/></label>
				<html:text readonly="true" styleClass="in_peq  acentrado"   property="SegDurP2" styleId="SegDurP2" value="${tsegundoP2 }"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2"  titleKey="catalogadorAvanzado.detalleAnotacion.Segundos"  />
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
				<html:radio disabled="true" styleClass="boton_radio" property="meridianocero" styleId="meridianocero" name="form" value="0" /><!-- radio 1 MeridianoCero-->
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
				<html:radio disabled="true" styleClass="boton_radio" property="meridianocero" styleId="meridianoCero" name="form" value="1" /><!-- radio 2 -->
				<label for="meridianoCero" class="oculto"><bean:message key="detalleAnotacion.meridianocero"/></label>
			</div>
			</div>
			<div class="contenedor_izquierda_esp" >
  			<div class="text"><label for="Idio0a15" class="oculto" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Hora"/></label>
				<html:select disabled="true" styleClass="select_peq_n inp_se_ie"  name="comboZonaH" title="Seleccione Idioma" property="comboZonaH" value="${form.comboZonaH}">
					<html:option value="" styleClass="oscura">&nbsp;</html:option>
					<html:option value="0" >+</html:option>
					<html:option value="1" styleClass="oscura">-</html:option>
				</html:select>
			</div>
			</div>
			<div class="contenedor_izquierda_esp" >
  			<div class="text"><label for="HoraDur2"  class="rdr" >&nbsp;&nbsp; <bean:message key="catalogadorAvanzado.detalleAnotacion.Hora"/></label>
				<html:text readonly="true" styleClass="in_peq input_mder2 acentrado"   property="zhHora" styleId="zhHora" value="${zhHora}"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2"  titleKey="catalogadorAvanzado.detalleAnotacion.Hora"  />
			</div>
			</div>
			<div class="contenedor_izquierda_esp" >
  			<div class="text"><label for="MinutosDur2" class="rdr" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Minutos"/></label>
				<html:text readonly="true" styleClass="in_peq input_mder2 acentrado"   property="zhMinutos" styleId="zhMinutos" value="${zhMinutos}"  onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2"  titleKey="catalogadorAvanzado.detalleAnotacion.Minutos"  />
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

		<!--  INICIO Descripción   -->
		<div class="globo_gris globito2 conmargen" >
		<div class="globo_gris_01">
		<div class="globo_gris_02">
		<div class="globo_gris_03">
		<!--  INICIO Fila de Campos   -->
		<logic:iterate name="descripcionFecha" id="descFecha" indexId="i">
			<div class="fila_de_tabla_especial_02" >
  			<div class="contenedor_izquierda_esp">
  			<div class="text"><label for="Mas01" ><bean:message key="catalogadorAvanzado.detalleAnotacion.SoloDescripcion"/></label></div>
 			</div>
 			<div class="contenedor_izquierda_esp" >
			<div class="text">
				<html:textarea readonly="true" styleClass="input_medio_largo input_mder"  property="DesFecTex${i}" styleId="DesFec${i}" value="${descFecha.texto}" onblur="this.style.backgroundColor='#e1e1e1'" cols="5" rows="4" title="${descFecha.texto}" />
			</div>
			</div>
			<div class="contenedor_izquierda_esp" >
			<div class="text"><label for="Idio015" class="oculto" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Idioma"/></label>
				<html:select disabled="true" styleClass="select_peq_n inp_se_ie" name="form" property="DesFecIdio${i}" value="${descFecha.idioma}" >
					<c:forEach  items="${form.comboIdiomaBackingList}" var="idiomaValor">
                    	<html:option value="${ idiomaValor.value}">${idiomaValor.label}</html:option>
    		        </c:forEach>
				</html:select>
			</div>
			</div>
			<div class="float_izquierda_n">
				<c:choose>
					<c:when test="${i==0}">
						<span class="oculto">-</span>						
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
			<logic:iterate name="descripcion" id="unaDesc" indexId="di">
				<div class="fila_de_tabla_especial" style="padding-left:0 !important">
  				<div class="contenedor_izquierda_esp" >
				<div class="text"><label for="Des01" class="oculto" ><bean:message key="catalogadorAvanzado.detalleAnotacion.SoloDescripcion"/></label>
					<html:textarea readonly="true" styleClass="input_medio_largo input_mder" property="DesTex${di}" styleId="DesTex${di }" value="${unaDesc.texto}" onblur="this.style.backgroundColor='#e1e1e1'" cols="5" rows="4" title="${unaDesc.texto}"/>	
				</div>
				</div>
				<div class="contenedor_izquierda_esp" >
				<div class="text"><label for="Idio013" class="oculto" ><bean:message key="catalogadorAvanzado.detalleAnotacion.Idioma"/></label>
					<html:select disabled="true" styleClass="select_peq_n inp_se_ie" name="form" property="DesIdio${di}" value="${unaDesc.idioma}" >
						<c:forEach  items="${form.comboIdiomaBackingList}" var="descIdioma">
                        	<html:option value="${ descIdioma.value}">${descIdioma.label}</html:option>
    		            </c:forEach>
					</html:select>
				</div>
				</div>
				<div class="float_izquierda_n">
					<c:choose>
					<c:when test="${di==0}">
						<span class="oculto">-</span>						
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
	<button class="boton_125" type="submit" name="accion" value="<bean:message key="verAvanzado.volver"/>" >
		<bean:message key="verAvanzado.volver"/>
	</button>
</fieldset>
<!-- Fin Botones  -->
</form>
</div>
<!-- Fin plantilla contenido  -->
</tiles:put>

</tiles:insert>
