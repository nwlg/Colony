<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tlds/tags-catalogador.tld" prefix="cat" %>
<html:xhtml/>

<%@page import="es.pode.catalogacion.negocio.servicios.RutaTaxonomicaVO"%>
<tiles:insert definition="layout-avanzado">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/clasificacion/detalleClasificacion/detalle-clasificacion-vars.jspf" %>

<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" id="rea">
<jsp:include page="/layout/messages.jsp" flush="true"/>
<h2><bean:message key="catalogadorAvanzado.Clasificacion"/> ${tituloClasificacion }</h2>
<form method="post" action="<html:rewrite action="/DetalleClasificacion/DetalleClasificacionSubmit" />">
<p class="parrafo_comun" id="separacion2"><bean:message key="catalogadorAvanzado.General.TextoObligacion"/></p>

<input type="hidden" id="seleccionar" name="seleccionar" value="<bean:write name="form" property="accion"/>"/> 

<script type="text/javascript">
function seleccionarCampo() {
	ancla=document.getElementById('seleccionar').value;
	if (ancla != null) {
		var partes = new Array();
		partes=ancla.split("-");
		if(partes[0] == "Añadir Ruta Taxonomica"){
			document.location.href="#ruta";
		}
		else if(partes[0]=="Eliminar Ruta Taxonomica"){
			indice = partes[1];
			if(indice>0){
				indice = indice -1;
			}
			document.location.href="#ruta-"+indice;
		}
		if(partes[0] == "Añadir Descripcion"){
			document.location.href="#descripciones";
		}
		else if(partes[0]=="Eliminar Descripcion"){
			document.location.href="#descripciones";
		}
		else if(partes[0]=="Añadir Palabra Clave"){
			document.location.href="#palabras";
		}
		else if(partes[0]=="Eliminar Palabra Clave"){
			indice = partes[1];
			if(indice>0){
				indice = indice -1;
			}
			document.location.href="#palabras-"+indice;
		}
		else if(partes[0]=="Añadir Detalle Palabra Clave"){
			indice = partes[1];//indice de la contribucion
			document.location.href="#detallepalabras-"+indice;
		}
		else if(partes[0]=="Eliminar Detalle Palabra Clave"){
			indice1 = partes[1];//indice dentro de la entidad
			indice2 = partes[2];//indice de la contribucion
			if(indice1>0){
				indice1 = indice1 -1;
			}
			document.location.href="#detallepalabras-"+indice1+"-"+indice2;
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
  			<bean:define id="propo"><bean:message key="catalogadorAvanzado.SeleccioneProposito"/></bean:define>
			<cat:select name="form" property="razon" value="${form.razon}" backingList="${form.razonBackingList}" estiloSelect="select_lrg" estiloOscuro="oscura" title="${propo}"/>
			
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

<div class="globo_gris conmargen pos_relative real" >
<div class="globo_gris_01">
<div class="globo_gris_02">
<div class="globo_gris_03">
	<!--  INICIO CAJA DE FORMULARIO   -->
	<div id="formulario_02" >
	<h3><bean:message key="detalleclasi.RutaTaxonomica"/></h3>
 
 <logic:iterate name="rutaTaxonomica" id="ruta" indexId="i"> 
 
	 <!--SE COMPRUEBA QUE HAY INFORMACION EN LOS TAXONES; ASI SE DECIDE SI SE PINTA UNA CAJA DE TEXTO O UN COMBO-->  
	 <c:set var="comboTexto" value="0"/> 
	 <c:set var="rutaTaxonArray" value="${ruta.taxones}"/> <!--Es un array de TaxonVO[]--> 
	 	 <c:if test="${!empty rutaTaxonArray}" > <!--Se recorre el vector de TaxonVO[] pero solo nos quedamos con la primera posicion--> 
		 	 <c:forEach var="taxonVO" items="${rutaTaxonArray}">
		 	 	<c:if test="${!empty taxonVO}"> <!--Contiene informacion-->
			 	 	<c:set var="entryVO" value="${taxonVO.entry}"/>
			 	 	<c:if test="${!empty entryVO}"> 
			 	 		<c:set var="langStringVOArray" value="${entryVO.textos}"/>
			 	 		<c:if test="${!empty langStringVOArray}"> <!--Se recorre el vector pero solo nos quedamos con la primera posicion-->
			 	 			<c:forEach var="langStringVOArrayActual" items="${langStringVOArray}" >			 	 			
			 	 				<c:if test="${!empty langStringVOArrayActual}">
			 	 					<c:set var="texto" value="${langStringVOArrayActual.texto}"/>
			 	 					<c:if test="${!empty texto}">
			 	 						 <c:set var="comboTexto" value="1"/> 
			 	 					</c:if>
			 	 				</c:if>	
		 	 				</c:forEach>
			 	 		</c:if>
			 	 	</c:if>
			 	 	<c:set var="idVO" value="${taxonVO.id}"/>
			 	 	<c:if test="${!empty idVO}"> 
			 	 		<c:set var="langStringVO" value="${idVO.texto}"/>
			 	 		<c:if test="${!empty langStringVO}"> <!--Se recorre el vector pero solo nos quedamos con la primera posicion-->			 	 						 	 					 	 				
	 	 					<c:set var="comboTexto" value="1"/> 	 	 				
			 	 		</c:if>
			 	 	</c:if>
			 	 </c:if>			 	
		 	 </c:forEach>	 	 
	 	 </c:if>
	 	
 					<!--anclas-->
					<c:choose>
                        <c:when test="${i== fn:length(form.rutaTaxonomica)-1}">   
	                     <a id="ruta"></a>
                        </c:when>
                    </c:choose>	
					<a id="ruta-${i}"></a>
					<!--fin de anclas-->
	<!--  Enlaces de fuera   -->
	<div class="pos_relative" id="flotantederecha2">
		
		 <span class="flotder enlace_anadir_06">
		 <span class="oculto">-</span>
			<c:choose>
			<c:when test="${i==0}">
				<input class="boton_anadir flotder" name="accion_Añadir Ruta Taxonomica" type="submit"  value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"></input>
			</c:when>
			<c:otherwise>
				&nbsp;
			</c:otherwise>
			</c:choose>
		 </span>
		 <span class="flotder enlace_eliminar_06">
		  <c:set var="longi" value="${fn:length(form.rutaTaxonomica)}" />
		  <span class="oculto">-</span>
		  <c:choose>
			<c:when test="${longi>0}">			
				<input class="boton_eliminar flotder" name="accion_Eliminar Ruta Taxonomica-${i}" type="submit"  value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"></input>
			</c:when>
			<c:otherwise>
				&nbsp;
			</c:otherwise>
		 </c:choose>
		</span>
	</div>
	<!--  Fin Enlaces de fuera   -->
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
					<c:choose>	
						<c:when test="${comboTexto==0}">
							<bean:define id="fuen"><bean:message key="catalogadorAvanzado.SeleccioneFuente"/></bean:define>
							<cat:select name="form" property="rutaTax${i }_source" value="${taxRutaSI.texto}" backingList="${form.sourceBackingList}" estiloSelect="input_medio_largo inp_se_ie input_mder" estiloOscuro="oscura" title="${fuen}"/>
						</c:when>					
						<c:when test="${comboTexto==1}">
							<bean:define id="fuent"><bean:message key="catalogadorAvanzado.SeleccioneFuente"/></bean:define>	
							<html:text readonly="true" styleClass="input_medio input_mder" name="form" property="rutaTax${i }_source" value="${taxRutaSI.texto}"  onblur="this.style.backgroundColor='#e1e1e1'" title="${fuent }"/>
						</c:when>	
					</c:choose>
				</div> 
			</div>
			<div class="contenedor_izquierda_esp" >
				<div class="text">
					<label for="Idio8" class="oculto" ><bean:message key="detalleclasi.Idioma"/></label>
					<!--  idioma  -->
					<c:choose>	
						<c:when test="${comboTexto==0}">
						<bean:define id="fue"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>	
							<cat:select name="form" property="rutaTax${i}_idio" value="${taxRutaSI.idioma}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq inp_se_ie" estiloOscuro="oscura" title="${fue}"/>
						</c:when>	
						<c:when test="${comboTexto==1}">
						<bean:define id="fu"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
							<html:text readonly="true" styleClass="select_peq_n inp_se_ie" name="form" property="rutaTax${i}_idio" value="${taxRutaSI.idioma}"  onblur="this.style.backgroundColor='#e1e1e1'" title="${fu}"/>
						</c:when>
					</c:choose>	
				</div>
			</div>
			<div class="float_izquierda">
				<span class="oculto">-</span>
				<!--  Boton del Taxon   -->
				<c:choose>	
					<c:when test="${comboTexto==0}">
						<input class="boton_90" name="accion_Seleccionar Taxones-${i}" type="submit"  value="<bean:message key="detalleclasi.Taxones"/>"></input>
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
					<html:text readonly="true" styleClass="input_medio input_mder" property="rutaTax${i}_taxon${t}_EntryTex${u}" styleId="rutaTax${i}_taxon${t}_EntryTex${u}" value="${unEntryTex.texto}"  onblur="this.style.backgroundColor='#e1e1e1'" titleKey="detalleclasi.enty" />
					</div>
				</div>
				<div class="contenedor_izquierda_esp" >
					<div class="text"><label for="Idios218" class="oculto" ><bean:message key="detalleclasi.SoloIdioma"/></label>
						<html:text readonly="true" styleClass="select_peq_n inp_se_ie" property="rutaTax${i}_taxon${t}_EntryIdio${u}" styleId="rutaTax${i}_taxon${t}_EntryIdio${u}" value="${unEntryTex.idioma}"  onblur="this.style.backgroundColor='#e1e1e1'" titleKey="detalleclasi.SoloIdioma" />
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
		<!--anclas-->
					<c:choose>
                        <c:when test="${i== fn:length(form.descripciones)-1}">   
	                     <a id="descripciones"></a>
                        </c:when>
                    </c:choose>	
					<a id="descripciones-${i}"></a>
					<!--fin de anclas-->
			<!--  INICIO Fila de Campos   -->
			<div class="fila_de_tabla_especial" style="padding-left:0 !important">
			<div class="contenedor_izquierda_esp" >
				<div class="text">
					<label for="DesTex${i}" class="oculto" ><bean:message key="detalleclasi.SoloDescripcion"/></label>
					<html:textarea styleClass="input_medio_largo input_mder" property="DesTex${i}" styleId="DesTex${i }" value="${desc.texto}" onblur="this.style.backgroundColor='#e1e1e1'" cols="5" rows="4" titleKey="catalogadorAvanzado.IntroduzcaDescripcion"/>	
				</div>
			</div>
			<div class="contenedor_izquierda_esp" >
			<div class="text">
				<label for="DesIdio${i}" class="oculto" ><bean:message key="detalleclasi.SoloIdioma"/></label>
				<bean:define id="descripcion1"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
				<cat:select name="form" property="DesIdio${i}" value="${desc.idioma}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq inp_se_ie" estiloOscuro="oscura" title="${descripcion1}"/>
				
			</div>
			</div>
			<div class="float_izquierda_n">
				<span class="oculto">-</span>
				<c:choose>
					<c:when test="${i==0}">
						<input class="boton_anadir cms2" name="accion_Añadir Descripcion" type="submit"  value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"></input>
					</c:when>
					<c:otherwise>
						&nbsp;
					</c:otherwise>
				</c:choose>
			</div>
			<div class="float_izquierda_n">
				<span class="oculto">-</span>
				<c:set var="longD" value="${fn:length(form.descripciones)}" />
				<c:choose>
					<c:when test="${longD>1}">
						<input class="boton_eliminar cms2" name="accion_Eliminar Descripcion-${i}" type="submit"  value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"></input>
					</c:when>
					<c:otherwise>
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

<!--  INICIO GLOBO GRIS Palabra Clave  -->
<div class="globo_gris conmargen">
<div class="globo_gris_01">
<div class="globo_gris_02">
<div class="globo_gris_03">	<!--  INICIO CAJA DE FORMULARIO   -->
	<div class="formu">
	<h3 class="h3flotante"><bean:message key="detalleclasi.PalabraClave"/></h3>
	<c:set var="longPalabrasAnterior" value="0"/>
	<logic:iterate name="palabrasClave" id="palabra" indexId="i">
	
						<!--anclas-->
					<c:choose>
                        <c:when test="${i== fn:length(form.palabrasClave)-1}">   
	                     <a id="palabras"></a>
                        </c:when>
                    </c:choose>	
					<a id="palabras-${i}"></a>
					<!--fin de anclas-->
	<!--  INICIO GLOBO BLANCO   -->
		<div class="globo_blanco globito flotder">
		<div class="globo_blanco_01">
		<div class="globo_blanco_02">
		<div class="globo_blanco_03">	<!--  INICIO Fila de Campos   -->
		<!--  INICIO Fila de Campos   -->
		<c:set var="textos" value="${palabra.textos }"/>
		<c:set var="longPalabras" value="${ fn:length(textos) }"/>				
		<logic:iterate id="contenido" name="textos" indexId="j">
						<!--anclas-->
						<c:choose>
							<c:when test="${j== fn:length(textos)-1}">   
							 <a id="detallepalabras-${i}"></a>
							</c:when>
						</c:choose>	
						<a id="detallepalabras-${j}-${i}"></a>
						<!--fin de anclas-->
			<c:set var="indice" value="${j + longPalabrasAnterior}"/>
			<div class="fila_de_tabla_especial_03">
			<div class="contenedor_izquierda_esp">
			<div class="text">
				<label for="PalClave01" class="oculto" ><bean:message key="detalleclasi.SoloPalabraClave"/>:</label>
				<html:text styleClass="input_medio input_mder" property="Pcla${i}_Tex${j}" value="${contenido.texto}" styleId="PalClave${i}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaPalabraClave" />
			</div>
			</div>
			<div class="contenedor_izquierda_esp">
			<div class="text">
				<label for="Idio05" class="oculto" ><bean:message key="detalleclasi.SoloIdioma"/></label>
				<bean:define id="palabra"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
				<cat:select name="form" property="Pcla${i}_Idio${j}" value="${contenido.idioma}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq_n inp_se_ie" estiloOscuro="oscura" title="${palabra}"/>
				
			</div>
			</div>
			<div class="float_izquierda_n">
				<c:choose>
					<c:when test="${j==0}">   
						<span class="oculto">-</span> 
						<input class="boton_anadir cms_ie" name="accion_Añadir Detalle Palabra Clave-${i}" type="submit"  value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"></input>
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
						<input class="boton_eliminar cms_ie" name="accion_Eliminar Detalle Palabra Clave-${j}-${i}" type="submit"  value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"></input>
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
						<input class="boton_anadir flotder" name="accion_Añadir Palabra Clave" type="submit"  value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"></input>
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
					<input class="boton_eliminar flotder" name="accion_Eliminar Palabra Clave-${i}" type="submit"  value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"></input>
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
	<input class="boton_125" id="reset_but" type="submit" name="accion" value="<bean:message key="detalleclasi.Reset"/>" /><br />

	<input class="boton_125_de_2"  type="submit" name="accion"  value="<bean:message key="detalleclasi.Aceptar"/>" />
	<input class="boton_125_de_2_izq"  type="submit" name="accion" value="<bean:message key="detalleclasi.Cancelar"/>" />
	<input class="boton_125"  type="submit" name="accion" value="<bean:message key="detalleclasi.Validar"/>" />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
</div>
<!-- Fin plantilla contenido  -->
</tiles:put>
</tiles:insert>
