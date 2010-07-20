<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="/WEB-INF/tags/serverProperties.tld" prefix="server" %>
<%@ taglib uri="/WEB-INF/tags/tablaImagenes.tld" prefix="imagenes" %>


<tiles:insert definition="layout-sinlateralYsinbuscadorSuperior">

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="body" type="string">
		<%@ include file="/taglib-imports.jspf" %>
		<!-- Inicio plantilla contenido  -->
		<div class="plantilla_contenido">
			<!-- Pintar mensajes de error  -->
			<jsp:include page="/layout/messages.jsp" flush="true" />
			<div class="resultados_b">
				<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.desdeHasta" arg0="${form.resultadosDesde}" arg1="${form.resultadosHasta}" arg2="${form.numMaxRes}"/>
			</div>
			<h2><bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.resultadoBusqueda"/></h2>			
			
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">

<!-- Inicio caja buscador -->
<!-- Inicio caja buscador -->
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">

			<!--  INICIO CAJA DE FORMULARIO   -->
								<div id="formulario" >
								<form method="post" action="<html:rewrite action="/BuscarAvanzadoCU/MostrarResultadosAvanzadoBuscarResultados.do"/>" name="formularioBusqueda">
										
					  				<div class="fila_de_tabla">
					  					<div class="contenedor_izquierda_00">
											&nbsp;<label class="oculto" for="buscadorContenido"><bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.buscador"/>:</label>
										</div>
										<div class="contenedor_derecha_00">
											<div class="text"><input name="buscadorContenido" value="${form.buscadorContenido}"  onblur="this.style.backgroundColor='#e1e1e1'" id="buscadorContenido" type="text" title="<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.descripcionTextoBusqueda"/>"  /><br class="oculto" />
												<label class="oculto" for="idiomaBuscadorContenido">
													<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.elijaIdioma"/>:
												</label>
												<bean:define id="tituloSeleccioneTipoIdioma"><bean:message key="configurar.avanzado.atributo.seleccionar.tipoIdioma"/></bean:define>
												<html:select name="form" property="idiomaBuscador" styleId="idiomaBuscadorContenido" title="${tituloSeleccioneTipoIdioma}">
													<html:optionsCollection name="form"  property="idiomaBuscadorBackingList" label="label" value="value"/>
												</html:select>
												
												<label class="oculto" for="idiomaBuscadorContenido">
													<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.numeroResultados"/>
												</label>
												<bean:define id="tituloSeleccioneNumeroResultados"><bean:message key="configurar.avanzado.atributo.seleccionar.tipoIdioma"/></bean:define>
												
												
												<br class="oculto" /><input type="submit" alt="<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.botonBuscar"/>"  class="buscar"  value="<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.buscar"/>" name="buscar" /><br class="oculto" />
												<a href="<html:rewrite action="/FormularioAvanzadoCU/FormularioAvanzadoCU.do"/>" class="avanzado"><bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.avanzado"/></a>
												<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
											</div>
											
										</div>
										<div class="linea_separadora"></div>
										<br class="oculto" />
									</div>
									<!-- -->
									<!-- -->
												
									<div class="fila_de_tabla">
								  		<div class="contenedor_izquierda_00">
											&nbsp;<label class="oculto" for="todosNodos">Nodos:</label>
										</div>
										<bean:define id="tituloSeleccioneNumeroResultados"><bean:message key="configurar.avanzado.atributo.seleccionar.numeroResultados"/></bean:define>
										<div class="contenedor_derecha_00">
											<div class="text"><span class="vert"><bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.numeroResultados"/></span>&nbsp;&nbsp;
												<html:select name="form" property="numeroResultados" styleId="numeroResultados" onchange="enviarFormulario();" title="${tituloSeleccioneNumeroResultados}" style="width:126px">
													<html:optionsCollection name="form"  property="numeroResultadosBackingList" label="label" value="value"/>
												</html:select>
											</div>
										</div>
										<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>
								<!-- -->
											
									<logic:equal name="form" property="mostrarAmbito" value="true">	
										<div class="fila_de_tabla">
						  					<div class="contenedor_izquierda_00">
												&nbsp;<label class="oculto" for="todosNodos"><bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.nodos"/>:</label>
											</div>
											<div class="contenedor_derecha_00">
	   										 <div class="text">
	   										 	<span class="vert">
	   										 		<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.buscarEn"/>
	   										 	</span>
	            								<html:radio property="tipoBusqueda" onclick="habilitarCombos();" styleClass="boton_radio" styleId="todosNodos" name="form" value="01" />
	           									 <span class="vert">
	                  								<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.nodosTodos"/>
	            								 </span>
	            								<html:radio property="tipoBusqueda" onclick="habilitarCombos();" styleClass="boton_radio marginadito" styleId="todosNodos" name="form" value="02" />
	                 							 <span class="vert">
	                        						<server:serverProperties property="ccaa"/>
	                  							 </span>
	                  							 <html:radio property="tipoBusqueda" onclick="deshabilitarCombos();" styleClass="boton_radio marginadito" styleId="todosNodos" name="form" value="04" />
	                 							 <span class="vert">
	                        						<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.otros"/>
	                  							 </span>
	                  							 <logic:equal name="form" property="tipoBusqueda" value="03">
	                  							 &nbsp;&nbsp;&nbsp;
		                  							 <html:radio property="tipoBusqueda" onclick="habilitarCombos();" styleClass="boton_radio" styleId="Personalizada" name="form" value="03" />
		                  							 <span class="vert">
														<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.personalizada"/>&nbsp;&nbsp;
													 </span>
												 </logic:equal>
	      									 </div>
											</div>	
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>
									</logic:equal>
									</form>
								</div>
								<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->
<!-- Fin caja buscador -->
<!-- Fin caja buscador -->
<br />
<br />
<br />


<!-- Inicio Resultados Busqueda -->
<!-- Inicio Resultados Busqueda -->

<!-- CAJA TABLA -->
<!-- CAJA TABLA -->
<div  id="nueva_cap_int_02">
<!-- Inicio Resultados de Búsqueda -->
<!-- Inicio Resultados de Búsqueda -->
	<div class="caja_tabla" id="marg_resultados_lis" style="margin-top:2px;"> 
		<bean:define id="summary"><bean:message key="listar.odecu.mostrar.resultados.consulta.tablaResultadosBusquedaSQI"/></bean:define>
		<bean:define id="summary2"><bean:message key="listar.odecu.mostrar.resultados.consulta.tablaResultadosBusqueda"/></bean:define>
		
		<c:set var="numeroElemento" value="${form.resultadosDesde}"/>
		<display:table name="${form.lomEsVO}" 
			        	requestURI="${pageContext.request.requestURL}"
			        	class="resultados_listados"
				        export="false" uid="fila"
				        cellpadding="0" cellspacing="0" 
				        summary="${summary }" 
				        id="resultado" sort="list">
   			<caption><strong><bean:message key="listar.odecu.mostrar.resultados.consulta.tablaResultadosBusqueda"/></strong></caption>
   			<display:setProperty name="css.tr.odd" value="tr_blanco"/>
	        <display:setProperty name="css.tr.even" value="tr_gris"/>  		        		        
	        	<display:column style="valign:top">
	        	
	        		<strong class="numeracion_imagen">${numeroElemento}</strong>
	        			<table border="0" style="margin-bottom:5px;border:0" class="resultados_listados" cellpadding="0" cellspacing="0" width="100%" summary="${summary2 }">
	        				<tr>
								<td class="ancho_tab_min_" valign="top"><span><bean:message key="listar.odecu.mostrar.resultados.consulta.vo.titulo"/>:</span></td>
								<td class="ancho_tab_min_03"  valign="top"><span ><a href="${resultado.localizacion}" target="_blank">${resultado.titulo}</a></span></td>
							</tr>
							<tr>
								<td class="ancho_tab_min_" valign="top"><span><bean:message key="listar.odecu.mostrar.resultados.consulta.vo.descripcion"/>:</span></td>
								<td class="ancho_tab_min_03"  valign="top"><span >${resultado.descripcion}</span></td>
							</tr>
	        			</table>	        
	        			
		        	<fmt:formatNumber var="numeroElemento" value="${numeroElemento +1}" type="number"/>
	        	</display:column>
		</display:table>
	</div>
</div>


<!-- Fin Resultados de Búsqueda -->
<!-- Fin Resultados de Búsqueda -->
		

	<!-- Paginacion -->
				<hr />
							<div class="paginacion">
								<ul id="navlist">								
									<logic:notEmpty name="form" property="anterior">									
										<li><a href="<html:rewrite action="/BusquedaSQICU/MostrarResultadosPaginarSQI.do"/>?buscadorContenido=${form.buscadorContenidoEnlace}&amp;pagina=${form.anterior}&amp;tipoBusqueda=${form.tipoBusqueda}"><bean:message key="listarODE.arbolCurricular.anterior"/></a></li>
									</logic:notEmpty>
					
									<logic:iterate name="form" property="paginas" id="pagina">									
										<logic:equal name="form" property="pagina" value="${pagina}">
											<li>${pagina}</li>
										</logic:equal>
										<logic:notEqual name="form" property="pagina" value="${pagina}">
											<li><a href="<html:rewrite action="/BusquedaSQICU/MostrarResultadosPaginarSQI.do"/>?buscadorContenido=${form.buscadorContenidoEnlace}&amp;pagina=${pagina}&amp;tipoBusqueda=${form.tipoBusqueda}">${pagina}</a></li>
										</logic:notEqual>
									</logic:iterate>
						
									<logic:notEmpty name="form" property="siguiente">
										<li><a href="<html:rewrite action="/BusquedaSQICU/MostrarResultadosPaginarSQI.do"/>?buscadorContenido=${form.buscadorContenidoEnlace}&amp;pagina=${form.siguiente}&amp;tipoBusqueda=${form.tipoBusqueda}"><bean:message key="listarODE.arbolCurricular.siguiente"/></a></li>
									</logic:notEmpty>
								</ul>
							</div>
	<!-- Fin Paginacion -->
	
<br />

<!-- Inicio caja buscador -->
<!-- Inicio caja buscador -->
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario_02" >
  				<div class="fila_de_tabla">
  					<form method="post" action="<html:rewrite action="/BuscarAvanzadoCU/MostrarResultadosAvanzadoBuscarResultados.do"/>">
	  					<div class="contenedor_izquierda_00">
	  						<div class="text">
	  							<label class="oculto" for="buscadorContenidoSolo"><bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.buscador"/>:</label>
	  						</div>
						</div>
						<div class="contenedor_derecha_00" >
							<div class="text"><input name="buscadorContenidoSolo" value="${form.buscadorContenido}"  onblur="this.style.backgroundColor='#e1e1e1'" id="buscadorContenidoSolo" type="text" title="<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.descripcionTextoBusqueda"/>"  /><br class="oculto" />
								<input type="hidden" name="tipoBusqueda" value="${form.tipoBusqueda}"/>
								<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
								<input type="submit" alt="<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.botonBuscar"/>"  class="buscar"  value="<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.buscar"/>" name="buscar2" /><br class="oculto" />
								<a href="<html:rewrite action="/FormularioAvanzadoCU/FormularioAvanzadoCU.do"/>" class="avanzado"><bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.avanzado"/></a>
							</div>
						</div>
					</form>
					<div class="linea_separadora"></div>
					<br />
				</div>
				<!-- -->
				
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>

</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->
<!-- Fin caja buscador -->
<!-- Fin caja buscador -->
</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->


    </tiles:put>

</tiles:insert>
<SCRIPT LANGUAGE="JavaScript">
var tipoBusqueda="${form.tipoBusqueda}";
var numeroResultados="${form.numeroResultados}";
if(tipoBusqueda=="04"){
	deshabilitarCombos();
}

function deshabilitarCombos(){
	var oComboIdioma = document.getElementById('idiomaBuscadorContenido');
	var oComboNumeroResultados = document.getElementById('numeroResultados');
	oComboIdioma.disabled=true;
	oComboNumeroResultados.disabled=true;
}

function habilitarCombos(){
	var oComboIdioma = document.getElementById('idiomaBuscadorContenido');
	var oComboNumeroResultados = document.getElementById('numeroResultados');
	oComboIdioma.disabled=false;
	oComboNumeroResultados.disabled=false;
}

function enviarFormulario(){
	if(numeroResultados!=document.getElementById('numeroResultados').value){
		document.formularioBusqueda.submit();
	}
}
</SCRIPT>

