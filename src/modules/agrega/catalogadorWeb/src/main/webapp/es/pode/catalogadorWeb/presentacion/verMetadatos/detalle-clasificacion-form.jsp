<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado-verMetadatos">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/clasificacion/detalleClasificacion/detalle-clasificacion-vars.jspf" %>

<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" id="rea">
<jsp:include page="/layout/messages.jsp" flush="true"/>
<h2><bean:message key="catalogadorAvanzado.Clasificacion"/> ${tituloClasificacion }</h2>
<form method="post" action="<html:rewrite action="/VerMetadatos/DetalleClasificacionFormVuelveDeDetalleClasificacion" />">





<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris conmargen"  >
<div class="globo_gris_01">
<div class="globo_gris_02">
<div class="globo_gris_03">
	<!--  INICIO CAJA DE FORMULARIO   -->
	<div class="formu" >
	<h3><bean:message key="detalleclasi.Razon"/></h3>
	<!--  INICIO GLOBO Blanco   -->
	<div class="globo_blanco pos_relative conmargen" >
	<div class="globo_blanco_01">
	<div class="globo_blanco_02">
	<div class="globo_blanco_03">
		<!--  INICIO Fila de Campos   -->
		<div class="fila_de_tabla_especial_03" >
  		<div class="contenedor_izquierda_esp" >
  		<div class="text">
  			<label for="Razon01" class="oculto" ><bean:message key="detalleclasi.SoloRazon"/></label>
			<html:select  disabled="true" name="form" property="proposito" styleClass="select_lrg">
				 <c:forEach  items="${form.propositoBackingList}" var="listaRazon">
               		<html:option value="${listaRazon.value }">${listaRazon.label }</html:option>
             	</c:forEach>
			</html:select>
		</div>
		</div>
		<div class="limpiar"></div>
		<br class="oculto" />
		</div>	
		<!--  FIn Fila de Campos   -->
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

<!--  INICIO GLOBO GRIS Ruta Taxonomica  -->
<!--  INICIO GLOBO GRIS Ruta Taxonomica  -->

<div class="globo_gris conmargen pos_relative real" >
<div class="globo_gris_01">
<div class="globo_gris_02">
<div class="globo_gris_03">
	<!--  INICIO CAJA DE FORMULARIO   -->
	<div id="formulario_02" >
	<h3><bean:message key="detalleclasi.RutaTaxonomica"/></h3>
 
 <logic:iterate name="rutaTaxonomica" id="ruta" indexId="i"> 
	<!--  INICIO GLOBO Blanco   -->
	<div class="globo_blanco pos_relative ancho_2 " id="sinpad_especial">
	<div class="globo_blanco_01" >
	<div class="globo_blanco_02">
	<div class="globo_blanco_03">
	<!--  INICIO GLOBO GRIS   -->
		<div class="globo_gris globito2 pos_relative" >
		<div class="globo_gris_01">
		<div class="globo_gris_02">
		<div class="globo_gris_03">
		<!--  INICIO Fila de Campos   -->
		<c:set var="fuente" value="${ruta.fuente }"/>
		<c:set var="textoRuta" value="${fuente.textos }"/> <!-- ojo -->
		<c:forEach var="taxRutaSI" items="${textoRuta }">
			<div class="fila_de_tabla_especial_02" >
	  		<div class="contenedor_izquierda_esp">
	  			<div class="text"><label for="Source01" ><bean:message key="detalleclasi.Source"/></label></div>
	 		</div>
			<div class="contenedor_izquierda_esp" >
				<div class="text">
					<!--  taxonomia   -->					
							<bean:define id="fuent"><bean:message key="catalogadorAvanzado.SeleccioneFuente"/></bean:define>	
							<html:text readonly="true" styleClass="input_medio input_mder" name="form" property="rutaTax${i }_source" value="${taxRutaSI.texto}"  onblur="this.style.backgroundColor='#e1e1e1'" title="${fuent }"/>
				</div> 
			</div>
			<div class="contenedor_izquierda_esp" >
				<div class="text">
					<label for="Idio8" class="oculto" ><bean:message key="detalleclasi.Idioma"/></label>
					<!--  idioma  -->
						<bean:define id="fu"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
							<html:text readonly="true" styleClass="select_peq_n inp_se_ie" name="form" property="rutaTax${i}_idio" value="${taxRutaSI.idioma}"  onblur="this.style.backgroundColor='#e1e1e1'" title="${fu} "/>
				</div>
			</div>
			<div class="float_izquierda">
				<span class="oculto">-</span>
				<!--  Boton del Taxon   -->
				<c:choose>	
					<c:when test="${comboTexto==0}">
						<input class="boton_90" name="accion_<bean:message key="detalleclasi.SeleccionarTaxones"/>-${i}" type="submit"  value="<bean:message key="detalleclasi.Taxones"/>"></input>
					</c:when>
				</c:choose>	
			</div>
			<div class="limpiar"></div>
			<br class="oculto" />
			</div>	
			<!--  Fin Fila de Campos   -->
		</c:forEach>
		</div>
		</div>
		</div>
		</div>
		<!--  FIN GLOBO GRIS   -->
		<!--  INICIO GLOBO GRIS   -->
		<div class="globo_gris pos_relative conmargen">
		<div class="globo_gris_01">
		<div class="globo_gris_02">
		<div class="globo_gris_03">
		
		<c:set var="taxRuta" value="${ruta.taxones}"/>
		<logic:iterate name="taxRuta" id="taxon" indexId="t">
		 	<c:set var="entryAux" value="${taxon.entry}" />
		 	<c:set var="entryTex" value="${entryAux.textos}" />
		 	<c:set var="idTax" value="${taxon.id}"/>
		 
			  
			  <div class="globo_blanco globito4 flotder pos_relative" >
			  <div class="globo_blanco_01">
			  <div class="globo_blanco_02">
			  <div class="globo_blanco_03">
			  <logic:iterate name="entryTex" id="unEntryTex" indexId="u">
				<!--  INICIO Fila de Campos   -->
				<div class="fila_de_tabla_especial_03" style="padding-left:6px !important">
	  			<div class="contenedor_izquierda_esp">
	  				<div class="text2">
	  				<label for="Taxon"  ><bean:message key="detalleclasi.taxonid"/>&nbsp;</label></div>
	 			</div>
	 			<div class="contenedor_izquierda_esp" >
					<div class="text2">
						<html:text readonly="true" styleClass="select_peq_n inp_se_ie" property="rutaTax${i}_taxon${t}_Id${u }" styleId="rutaTax${i}_taxon${t}_Id${u }" value="${idTax.texto}"  onblur="this.style.backgroundColor='#e1e1e1'" titleKey="detalleclasi.taxonid" />
					</div>
				</div>
				<div class="contenedor_izquierda_esp">
	  				<div class="text2"><label for="Entry0232" >&nbsp;&nbsp;<bean:message key="detalleclasi.enty"/>&nbsp;</label></div>
	 			</div>
				<div class="contenedor_izquierda_esp" >
					<div class="text2">
					<html:text readonly="true" styleClass="input_medio input_mder" property="rutaTax${i}_taxon${t}_EntryTex${u}" styleId="rutaTax${i}_taxon${t}_EntryTex${u}" value="${unEntryTex.texto}"  onblur="this.style.backgroundColor='#e1e1e1'"  titleKey="detalleclasi.taxonid"/>
					</div>
				</div>
				<div class="contenedor_izquierda_esp" >
					<div class="text"><label for="Idios218" class="oculto" ><bean:message key="detalleclasi.SoloIdioma"/></label>
						<html:text readonly="true" styleClass="select_peq_n inp_se_ie" property="rutaTax${i}_taxon${t}_EntryIdio${u}" styleId="rutaTax${i}_taxon${t}_EntryIdio${u}" value="${unEntryTex.idioma}"  onblur="this.style.backgroundColor='#e1e1e1'" titleKey="detalleclasi.taxonid"/>
						<!-- aqui estaba el combo -->
					</div>
				</div>
				<div class="float_izquierda_n " >
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
		  <!--  Enlaces de fuera   -->
		  <div class="limpiar"></div>

	</logic:iterate>
	
</div>
</div>
</div>
</div>
<!--  FIN GLOBO BLANCO   -->
</div>
</div>
</div>
</div>
<!--  FIN GLOBO BLANCO   -->
<!-- aqi debe terminar el logic iterate -->
</logic:iterate>
</div>
<!--  FIN CAJA DE FORMULARIO   -->
</div>
</div>
</div>
</div>
<!--  FIN GLOBO GRIS   -->


<!--  INICIO GLOBO GRIS Descripción  -->
<!--  INICIO GLOBO GRIS Descripción  -->
<div class="globo_gris pos_relative conmargen" >
<div class="globo_gris_01">
<div class="globo_gris_02">
<div class="globo_gris_03">
	<!--  INICIO CAJA DE FORMULARIO   -->
	<div id="formulario" >
		<h3><bean:message key="detalleclasi.Descripcion"/></h3>
		<!--  INICIO GLOBO Blanco   -->
		<div class="globo_blanco" >
		<div class="globo_blanco_01">
		<div class="globo_blanco_02">
		<div class="globo_blanco_03">
		
		<logic:iterate name="descripciones" id="desc" indexId="i">
			<!--  INICIO Fila de Campos   -->
			<div class="fila_de_tabla_especial" style="padding-left:0 !important">
			<div class="contenedor_izquierda_esp" >
				<div class="text">
					<label for="DesTex${i}" class="oculto" ><bean:message key="detalleclasi.SoloDescripcion"/></label>
					<html:textarea readonly="true" styleClass="input_medio_largo input_mder" property="DesTex${i}" styleId="DesTex${i }" value="${desc.texto}" onblur="this.style.backgroundColor='#e1e1e1'" cols="5" rows="4" title="${desc.texto}"/>	
				</div>
			</div>
			<div class="contenedor_izquierda_esp" >
			<div class="text">
				<label for="DesIdio${i}" class="oculto" ><bean:message key="detalleclasi.SoloIdioma"/></label>
				<html:select  disabled="true"  styleClass="select_peq inp_se_ie" name="form" property="DesIdio${i}" value="${desc.idioma}" >
					<c:forEach  items="${form.comboIdiomaBackingList}" var="descIdioma">
                        <html:option value="${ descIdioma.value}">${descIdioma.label}</html:option>
    		        </c:forEach>
				</html:select>
			</div>
			</div>
			<div class="float_izquierda_n">
				<span class="oculto">-</span>
						&nbsp;
			</div>
			<div class="float_izquierda_n">
				<span class="oculto">-</span>
						 &nbsp;
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

<!--  INICIO GLOBO GRIS Palabra Clave  -->
<div class="globo_gris conmargen">
<div class="globo_gris_01">
<div class="globo_gris_02">
<div class="globo_gris_03">	<!--  INICIO CAJA DE FORMULARIO   -->
	<div class="formu">
	<h3 class="h3flotante"><bean:message key="detalleclasi.PalabraClave"/></h3>
	<c:set var="longPalabrasAnterior" value="0"/>
	<logic:iterate name="palabrasClave" id="palabra" indexId="i">
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
				<label for="PalClave01" class="oculto" ><bean:message key="detalleclasi.SoloPalabraClave"/>:</label>
				<html:text readonly="true" styleClass="input_medio input_mder" property="Pcla${i}_Tex${j}" value="${contenido.texto}" styleId="PalClave${i}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.General.SoloPalabraClave" />
			</div>
			</div>
			<div class="contenedor_izquierda_esp">
			<div class="text">
				<label for="Idio05" class="oculto" ><bean:message key="detalleclasi.SoloIdioma"/></label>
				<html:select  disabled="true" styleClass="select_peq_n inp_se_ie" name="form" property="Pcla${i}_Idio${j}" value="${contenido.idioma}" >
					<c:forEach  items="${form.comboIdiomaBackingList}" var="idiomaValor">
						<html:option value="${ idiomaValor.value}">${idiomaValor.label}</html:option>
					</c:forEach>
				</html:select>
			</div>
			</div>
			<div class="float_izquierda_n">
						<span class="oculto">-</span> 
			</div>
			<div class="float_izquierda_n">
						<span class="oculto">-</span>
			</div>
			<div class="limpiar">
			</div><br class="oculto"/>
			</div>
		</logic:iterate>	
		<c:set var="longPalabrasAnterior" value="${ longPalabras + longPalabrasAnterior }"/>
		<!--  Fin Fila de Campos   -->
		</div>
		</div>
		</div>
		</div>	
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
