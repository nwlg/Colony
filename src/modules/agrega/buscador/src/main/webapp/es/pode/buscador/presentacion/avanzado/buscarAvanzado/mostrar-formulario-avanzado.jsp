<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.andromda.org/tags-breadcrumbs" prefix="breadcrumbs" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>

	<tiles:insert definition="layout-sinlateralYsinbuscadorSuperior">
    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>
    <tiles:put name="body" type="string">
		<%@ include file="/taglib-imports.jspf" %>
		<script type="text/javascript" src="<rewrite:rewrite url="static/js/mootools.js"/>"></script>
		<script type="text/javascript" src="<rewrite:rewrite url="static/js/calendar.rc4.js"/>"></script>
		<script type="text/javascript" src="<rewrite:rewrite url="static/js/busqueda_avanzada.js"/>"></script>
		<!-- ATENCION!! RREMPLAZAR ESTA CAPA DE LA  PLANTILLA DE CONTENIDO ("plantilla_contenido") POR LA QUE SE DESEE EN LA PLANTILLA BASE  -->
		<!-- Inicio plantilla contenido  -->
		<div class="plantilla_contenido">
			<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
			<jsp:include page="/layout/messages.jsp" flush="true" />
			<h2><bean:message key="configurar.avanzado.cabecera"/></h2>
			<form method="post" name="formularioAvanzado" action="<html:rewrite action="/BuscarAvanzadoCU/MostrarFormularioAvanzadoAnalizaPulsacion"/>" >
				<!--  INICIO GLOBO GRIS   -->
				<input type="hidden" name="contadorPropiedadesContenido" value="${form.contadorPropiedadesContenido}"/>
				<input type="hidden" name="contadorAreasCurriculares" value="${form.contadorAreasCurriculares}"/>
				<input type="hidden" name="contadorAmbito" value="${form.contadorAmbito}"/>
				<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
				<input type="hidden" name="tipoBusqueda" value="${form.tipoBusqueda}"/>
				<div class="globo_gris" >
					<div class="globo_gris_01">
						<div class="globo_gris_02">
							<div class="globo_gris_03">
								<!--  INICIO CAJA DE FORMULARIO   -->
								<div id="formulario" >
							 		<div class="fila_de_tabla">
			  							<div class="contenedor_izquierda">			  							
			  								<div class="text"><label for="<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.buscar"/>"><bean:message key="configurar.avanzado.buscar.buscarDosPuntos"/></label></div>
											</div>
											<div class="contenedor_derecha">
											<div class="text"><input name="buscadorContenido" value="${form.buscadorContenido}" onkeypress="return focusSubmit(event)" onblur="this.style.backgroundColor='#e1e1e1'" id="nombreGrupo" type="text" title="<bean:message key="configurar.avanzado.introduzcaTextoBuscar"/>"  /></div>
										</div>
										<div class="linea_separadora"></div>
									</div>
									<div class="fila_de_tabla">
					  					<div class="contenedor_izquierda">					  					
					  						<div class="text"><label for="areaC"><bean:message key="listar.odecu.mostrar.resultados.consulta.vo.area.curricular"/>:</label></div>
					 					</div>
										<div class="contenedor_derecha" >
												<logic:empty name="form" property="areaCurricularTexto">
													<div class="text"><input class="boton_200" type="submit" style="height:22px;" name="pulsacion" value="<bean:message key="configurar.avanzado.areaCurricular.aniadir"/>" /></div>
													<input type="hidden" id="areaCurricular" name="areaCurricular" value="${form.areaCurricular}"/>
												</logic:empty>
												<logic:notEmpty name="form" property="areaCurricularTexto">
													<table border="0" cellpadding="0" cellspacing="0"  class="inv_curricular" width="90%">
														<tr>
															<td align="left">
																<table border="0" cellpadding="0" cellspacing="0" width="auto">
																	<tr>
																		<td style="padding-right:10px;"><span class="sola_rea2">${form.areaCurricularTexto}</span></td>
																		<td valign="top" align="left"><div class="text"><input class="boton_125"  id="areaC" type="submit" style="top:0;height:22px;margin:0" name="pulsacion" value="<bean:message key="configurar.avanzado.areaCurricular.eliminar"/>"/></div></td>		
																	</tr>
																</table>
															</td>
														</tr>
													</table>
													<input type="hidden" id="areaCurricular" name="areaCurricular" value="${form.areaCurricular}"/>
												</logic:notEmpty>
										</div>
										
										
										<div class="linea_separadora"></div>
										<br class="oculto" />
									</div>
									<!-- -->
									<!-- -->
									<div class="fila_de_tabla" id="solo">
										<div class="contenedor_izquierda">
											<div class="text"><label for="nivel_agregacion"><bean:message key="listar.odecu.mostrar.resultados.detalles.nivelAgregacion"/>:</label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">
												<bean:define id="tituloSeleccioneNivelAgregacion"><bean:message key="configurar.avanzado.atributo.nivelAgregacion"/></bean:define>
												<html:select name="form" property="nivelAgregacion" title="${tituloSeleccioneNivelAgregacion}" styleId="nivelAgregacion">
													<option value="" class="oscura"><bean:message key="configurar.avanzado.todos"/></option>
													<html:optionsCollection name="form"  property="nivelAgregacionBackingList" label="label" value="value"/>
												</html:select>
											</div>
										</div>
										<div class="linea_separadora"></div>
										<br class="oculto" />
									</div>
									<!-- -->
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text">
												<label for="tipoFormato"><bean:message key="configurar.avanzado.atributo.tipoFormato"/>:</label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">
												<bean:define id="tituloSeleccioneTipoFormato"><bean:message key="configurar.avanzado.atributo.seleccionar.tipoFormato"/></bean:define>
												<html:select name="form" property="formato" title="${tituloSeleccioneTipoFormato}" styleId="tipoFormato">
													<option value="" class="oscura"><bean:message key="configurar.avanzado.todos"/></option>
													<html:optionsCollection name="form"  property="formatoBackingList" label="label" value="value"/>
												</html:select>
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>
									<!-- -->
									<fieldset class="tipo ft_centrada">
										<input class="boton_125" style="height:20px;" type="submit" id="pulsacion" name="pulsacion" value="<bean:message key="configurar.avanzado.buscar.buscar"/>" />
									</fieldset>
									<br />
								</div>
								<!--  FIN CAJA DE FORMULARIO   -->
							</div>
						</div>
					</div>
				</div>
				<!--  FIN GLOBO GRIS   -->
				<logic:equal name="form" property="sinResultados" value="true">
					<div class="parrafo_comun" id="separacion">
						<bean:message key="listar.odecu.mostrar.resultados.quiso.sinSugerencias"/><br />
						<bean:message key="listar.odecu.mostrar.resultados.quiso.sinTesauros"/><br />
						<bean:message key="listar.odecu.mostrar.resultados.quiso.sinResultados"/>:
						<ul id="error">
							<li><bean:message key="listar.odecu.mostrar.resultados.quiso.comprobarSintaxis"/></li>
							<li><bean:message key="listar.odecu.mostrar.resultados.quiso.otraPalabra"/></li>
							<li><bean:message key="listar.odecu.mostrar.resultados.quiso.sinonimo"/></li>
						</ul>
						<br class="oculto"/>
					</div>
				</logic:equal>
				<logic:equal name="form" property="sinResultados" value="false">
					<p class="parrafo_comun" id="separacion3"><bean:message key="configurar.avanzado.acotarBusqueda"/></p>
				</logic:equal>	
				
				<!--  INICIO GLOBO GRIS   -->
				<div class="globo_gris uno_b" >
					<div class="globo_gris_01">
						<div class="globo_gris_02">
							<div class="globo_gris_03">
								<!--  INICIO CAJA DE FORMULARIO   -->
								<div class="caja_dinamica" ><a class="desplegado" id="pm1" href="#" onclick="expandirCaja('m1');return false;"><br class="falso" /><strong id="dm1" ><bean:message key="configurar.avanzado.texto.verCamposbusqueda"/></strong></a><h3><bean:message key="configurar.avanzado.texto.porPropiedadesContenido"/></h3><em>(<bean:message key="configurar.avanzado.numeroFiltrosSeleccionadosTiene"/>&nbsp;<label id="contadorPropiedades" >${form.contadorPropiedadesContenido}</label>&nbsp;
									<c:if test="${form.contadorPropiedadesContenido==1 }">
							    		<bean:message key="configurar.avanzado.numeroFiltroSeleccionado"/>)</em>
									</c:if>
								    <c:if test="${form.contadorPropiedadesContenido!=1 }">
								      	<bean:message key="configurar.avanzado.numeroFiltrosSeleccionados"/>)</em>
								    </c:if>
								</div>
								<div id="m1" class="caja_cerrada" >
									<br />
									<div class="formu" >
										<div class="fila_de_tabla">
											<div class="contenedor_izquierda">
												<div class="text"><label for="tipoRecurso"><bean:message key="configurar.avanzado.atributo.recurso"/>:</label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">
													<bean:define id="tituloSeleccioneTipoRecurso"><bean:message key="configurar.avanzado.atributo.seleccionar.tipoRecurso"/></bean:define>
													<html:select name="form" property="recurso" title="${tituloSeleccioneTipoRecurso}" styleId="tipoRecurso">
														<option value="" class="oscura"><bean:message key="configurar.avanzado.todos"/></option>
														<html:optionsCollection name="form"  property="recursoBackingList" label="label" value="value"/>
													</html:select>
												</div>
											</div>
											<div class="linea_separadora"></div>
											<br class="oculto" />
										</div>
										<div class="fila_de_tabla">
											<div class="contenedor_izquierda">
												<div class="text"><label for="Idioma"><bean:message key="listar.odecu.mostrar.resultados.detalles.idioma"/>:</label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">
													<bean:define id="tituloSeleccioneTipoIdioma"><bean:message key="configurar.avanzado.atributo.seleccionar.tipoIdioma"/></bean:define>
													<html:select name="form" property="idiomaBuscador" title="${tituloSeleccioneTipoIdioma}">
														<html:optionsCollection name="form"  property="idiomaBuscadorBackingList" label="label" value="value"/>
													</html:select>
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>
										<!-- -->
										<div class="fila_de_tabla">
											<div class="contenedor_izquierda">
												<div class="text"><label for="tipoProceso"><bean:message key="configurar.avanzado.atributo.procesoCognitivo"/>:</label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">
													<bean:define id="tituloSeleccioneTipoProcesoCognitivo"><bean:message key="configurar.avanzado.atributo.seleccionar.tipoProcesoCognitivo"/></bean:define>
													<html:select name="form" property="procesoCognitivo" title="${tituloSeleccioneTipoProcesoCognitivo}" styleId="procesoCognitivo">
														<option value="" class="oscura"><bean:message key="configurar.avanzado.todos"/></option>
														<html:optionsCollection name="form"  property="procesoCognitivoBackingList" label="label" value="value"/>
													</html:select>
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>
										<div class="fila_de_tabla">
											<div class="contenedor_izquierda">
												<div class="text"><label for="tipoContexto"><bean:message key="configurar.avanzado.atributo.contexto"/>:</label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">
													<bean:define id="tituloSeleccioneTipoContexto"><bean:message key="configurar.avanzado.atributo.seleccionar.tipoContexto"/></bean:define>
													<html:select name="form" property="contexto" title="${tituloSeleccioneTipoContexto}" styleId="tipoContexto">
														<option value="" class="oscura"><bean:message key="configurar.avanzado.todos"/></option>
														<html:optionsCollection name="form"  property="contextoBackingList" label="label" value="value"/>
													</html:select>
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>
										<div class="fila_de_tabla">
											<div class="contenedor_izquierda">
												<div class="text"><label for="edad"><bean:message key="configurar.avanzado.atributo.edad"/>:</label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">
													<input name="edad" value="${form.edad}" onkeypress="return focusSubmit(event)" onblur="this.style.backgroundColor='#e1e1e1'" id="edad" type="text" title="<bean:message key="configurar.avanzado.atributo.introducir.edad"/>"  />
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>
										<div class="fila_de_tabla">
											<div class="contenedor_izquierda">
												<div class="text"><label for="autor"><bean:message key="configurar.avanzado.atributo.autor"/>:</label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">
													<input name="autor" value="${form.autor}" onkeypress="return focusSubmit(event)" onblur="this.style.backgroundColor='#e1e1e1'" id="autor" type="text" title="<bean:message key="configurar.avanzado.atributo.introducir.autor"/>"  />
												</div>
	
											</div>
											<div class="linea_separadora">
											</div><br/>
										</div>
										
							
										
								  		<bean:define id="nomMeses"><bean:message key="configurar.avanzado.atributo.nombresMeses"/></bean:define>
										<bean:define id="nomDias"><bean:message key="configurar.avanzado.atributo.nombresDias"/></bean:define>
										<div class="fila_de_tabla">
					  						<div class="contenedor_izquierda">
 													<div class="text"><label for="fecha_publi"><bean:message key="configurar.avanzado.atributo.fechaPublicacion"/>:</label></div>
						 					</div>
											<div class="contenedor_derecha" id="cont_esp_fech">
												<div class="text">
													<label class="oculto" for="fecha_publi"><bean:message key="configurar.avanzado.atributo.fechaPublicacionDia"/>:</label>
													<input onkeypress="return focusSubmit(event)" name="diaPublicacion" value="${form.diaPublicacion}" class="fechazo_02" onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" id="diaPublicacion" type="text" title="<bean:message key="configurar.avanzado.atributo.introducir.diaFechaPublicacion"/>"  />
													<label class="oculto" for="fecha_mes_fin"><bean:message key="configurar.avanzado.atributo.fechaPublicacionMes"/>:</label>
													<input name="mesPublicacion" maxlength="2" onkeypress="return focusSubmit(event)" value="${form.mesPublicacion}" class="fechazo_02" onblur="this.style.backgroundColor='#e1e1e1'" id="mesPublicacion" type="text" title="<bean:message key="configurar.avanzado.atributo.introducir.mesFechaPublicacion"/>"  />
													<label class="oculto" for="fecha_anio_fin"><bean:message key="configurar.avanzado.atributo.fechaPublicacionAnyo"/>:</label>	
													<input name="anyoPublicacion" maxlength="4" onkeypress="return focusSubmit(event)" value="${form.anyoPublicacion}" class="fechazo_02" onblur="this.style.backgroundColor='#e1e1e1'" id="anyoPublicacion" type="text" title="<bean:message key="configurar.avanzado.atributo.introducir.anyoFechaPublicacion"/>"  />
												</div>
											</div>
											<div class="linea_separadora">
											</div>
											<br class="oculto" />
										</div>
										<!-- -->
										<!-- -->	
										<div class="fila_de_tabla">
											<div class="contenedor_izquierda">
												<div class="text"><label for="secuencia"><bean:message key="configurar.avanzado.atributo.conSinSecuencia"/>:</label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">
													<bean:define id="tituloSeleccioneTipoSecuencia"><bean:message key="configurar.avanzado.atributo.introducir.secuencia"/></bean:define>
													<html:select name="form" property="c_s_secuencia" title="${tituloSeleccioneTipoSecuencia}" styleId="tipoSecuencia">
														<option value="" class="oscura"><bean:message key="configurar.avanzado.todas"/></option>
														<html:optionsCollection name="form"  property="c_s_secuenciaBackingList" label="label" value="value"/>
													</html:select>
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>
										<!-- -->
										<div class="fila_de_tabla">
											<div class="contenedor_izquierda">
												<div class="text"><label for="valor"><bean:message key="listar.odecu.mostrar.resultados.detalles.valoracion"/>:</label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">
													<bean:define id="tituloSeleccioneTipoValoracion"><bean:message key="configurar.avanzado.atributo.valoracion"/></bean:define>
													<html:select name="form" property="valoracion" title="${tituloSeleccioneTipoValoracion}" styleId="tipoValoracion">
														<option value="" class="oscura"><bean:message key="configurar.avanzado.todas"/></option>
														<html:optionsCollection name="form"  property="valoracionBackingList" label="label" value="value"/>
													</html:select>
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>
										<div class="fila_de_tabla">
											<div class="contenedor_izquierda">
												<div class="text"><label for="valor"><bean:message key="listar.odecu.mostrar.resultados.detalles.destinatarios"/>:</label>
												</div>
											</div>
											<div class="contenedor_derecha">
												<div class="text">
													<bean:define id="tituloSeleccioneDestinatarios"><bean:message key="configurar.avanzado.atributo.destinatarios"/></bean:define>
													<html:select name="form" property="destinatarios" title="${tituloSeleccioneDestinatarios}" styleId="destinatarios">
														<option value="" class="oscura"><bean:message key="configurar.avanzado.todos"/></option>
														<html:optionsCollection name="form"  property="destinatariosBackingList" label="label" value="value"/>
													</html:select>
												</div>
											</div>
											<div class="linea_separadora">
											</div><br class="oculto"/>
										</div>
									</div>
								</div>
								<br />
								<!--  FIN CAJA DE FORMULARIO   -->
							</div>
						</div>
					</div>
				</div>
				<!--  FIN GLOBO GRIS   -->
				<!--  INICIO GLOBO GRIS   -->
				<div class="globo_gris uno_b" >
					<div class="globo_gris_01">
						<div class="globo_gris_02">
							<div class="globo_gris_03">
								<!--  INICIO CAJA DE FORMULARIO   -->
								<div class="caja_dinamica" ><a class="desplegado" id="pm4" href="#" onclick="expandirCaja('m4');return false;"><br class="falso" /><strong id="dm4" ><bean:message key="configurar.avanzado.texto.verCamposbusqueda"/></strong></a><h3><bean:message key="configurar.avanzado.texto.porTesauro"/> </h3> <em>(<bean:message key="configurar.avanzado.numeroFiltrosSeleccionadosTiene"/> ${form.contadorTesauros} 
									<c:if test="${form.contadorTesauros==1 }">
								     	<bean:message key="configurar.avanzado.numeroFiltroSeleccionado"/>)</em>
								    </c:if>
								    <c:if test="${form.contadorTesauros!=1 }">
							    	  	<bean:message key="configurar.avanzado.numeroFiltrosSeleccionados"/>)</em>
								    </c:if>
								</div>
								<div id="m4" class="caja_cerrada" ><br />
									<!--  INICIO CAJA DE FORMULARIO   -->
									<div id="formulario_02" >
									<!--  INICIO GLOBO Blanco   -->
										<div class="globo_blanco" >
											<div class="globo_blanco_01">
												<div class="globo_blanco_02">
													<div class="globo_blanco_03">
														<input type="hidden" name="idTesauro" value="${form.idTesauro}"/>
														<logic:empty name="form" property="nomTesauros">
															<p class="parrafo_comun" ><bean:message key="configurar.avanzado.texto.tesauro.aniadir"/>:</p>
														</logic:empty>
														<logic:notEmpty name="form" property="nomTesauros">
															<p class="parrafo_comun" ><bean:message key="configurar.avanzado.texto.tesauro.eliminar"/>:</p>
														</logic:notEmpty>
														<!--  INICIO Criterios Nivel Educativo   -->						
										 				<div class="caja_tabla bordeada"  >
															<table border="1" class="generica_02" id="portapapeles" cellpadding="0" cellspacing="0" width="100%" summary="Tabla de Criterios Nivel Educativo">
																<caption><strong><bean:message key="configurar.avanzado.texto.tesauro.tabla"/></strong></caption>
																<tr class="tr_beige">
																	<td valign="top" class="td_larga">${form.nomTesauros}</td>
																</tr>
															</table>
														</div>
														<fieldset class="tipo ft_centrada">
															<logic:empty name="form" property="nomTesauros">
																<input class="boton_125"  type="submit"  name="pulsacion" value="<bean:message key="configurar.avanzado.tesauros.aniadir"/>" />
																<input type="hidden" id="nomTesauros" name="nomTesauros" value="${form.nomTesauros}"/>
															</logic:empty>
															<logic:notEmpty name="form" property="nomTesauros">
																<input class="boton_125"  type="submit"  name="pulsacion" value="<bean:message key="configurar.avanzado.tesauros.eliminar"/>" />
																<input type="hidden" id="nomTesauros" name="nomTesauros" value="${form.nomTesauros}"/>
															</logic:notEmpty>
														</fieldset>
														<br class="limpiar" />
														<!--  FIN Criterios Nivel Educativo   -->	
													</div>
												</div>
											</div>
										</div>
										<!--  Fin GLOBO Blanco   -->
									</div>
									<!--  FIN CAJA DE FORMULARIO   -->
								</div>
								<br />
							</div>
						</div>
					</div>
				</div>
				<!--  INICIO GLOBO GRIS   -->
				<logic:equal name="form" property="mostrarAmbito" value="true">
				<div class="globo_gris" >
					<div class="globo_gris_01">
						<div class="globo_gris_02">
							<div class="globo_gris_03">
								<!--  INICIO CAJA DE FORMULARIO   -->
								<div class="caja_dinamica" ><a class="desplegado" id="pm3" href="#" onclick="expandirCaja('m3');return false;"><br class="falso" /><strong id="dm3" ><bean:message key="configurar.avanzado.texto.verCamposbusqueda"/></strong></a><h3><bean:message key="configurar.avanzado.texto.porAmbito"/></h3> <em>(<bean:message key="configurar.avanzado.numeroFiltrosSeleccionadosTiene"/>&nbsp; <label id="contadorComunidades">${form.contadorAmbito}</label>&nbsp; 
									<c:if test="${form.contadorAmbito==1 }">
								     	<bean:message key="configurar.avanzado.numeroFiltroSeleccionado"/>)</em>
								    </c:if>
			    					<c:if test="${form.contadorAmbito!=1 }">
								      	<bean:message key="configurar.avanzado.numeroFiltrosSeleccionados"/>)</em>
								    </c:if>
								</div>
								<div id="m3" class="caja_cerrada" ><br />
								 <div class="formu" >
								  <!-- INICIO TABLA  -->
									<div class="caja_de_tabla_invisible">
									<table cellspacing="0" cellpadding="0" border="1" width="100%"  summary="Asignacion Comunidades">
										<tr>
											<td>
												<!--impares y 0-->
												<table cellspacing="0" cellpadding="0" border="1" width="50%"  summary="Asignacion Comunidades">
										    		<fmt:formatNumber var="contIndices" value="0" type="number"/>
													<logic:iterate id="comunidad"   name="form" property="comunidades">
														<!-- el primer elemento -->
														<c:if test="${contIndices==0}">
	  														<tr height="30">
	   															<td>
	   																<html:multibox name="form" styleId="${comunidad}" property="comunidadesSeleccionadas" value="${contIndices}" onclick="marcarTodas();"/>
										         			 	</td>	
										           			  	<td class="td_largo_09" valign="top"><label for="${comunidad}">${comunidad}</label></td>
   															</tr>
									 					</c:if>
									 					<c:if test="${contIndices==1}">
  															<tr height="30">
	   															<td>
	   																<html:multibox name="form" styleId="${comunidad}" disabled="true" property="comunidadesSeleccionadas" value="${contIndices}"/>
										         			 	</td>	
										           			  	<td class="td_largo_09" valign="top"><label for="${comunidad}">${comunidad}</label></td>
	   														</tr>
									 					</c:if>
									 					<!-- fin primer elemento -->
									 					<!--  mayor de 0   -->		
									 					<c:if test="${contIndices>1}">
														<!--  impar   -->		
															<c:if test="${contIndices%2!=0}">
									        					<tr height="30">
																	<td>
   																		<html:multibox name="form" styleId="${comunidad}" property="comunidadesSeleccionadas" value="${contIndices}" onclick="comprobarTodas();"/>								          	          											         			 			</td>					
									        			  			<td class="td_largo_09" valign="top"><label for="${comunidad}">${comunidad}</label></td>
										 				 		</tr> 	
										    				</c:if>
										    			</c:if>
														<c:set var="contIndices" value="${contIndices+1}"/>
													</logic:iterate>
												</table>
											</td>
											<td>		
												<table cellspacing="0" cellpadding="0" border="1" width="50%"  summary="Asignacion Comunidades">
													<fmt:formatNumber var="contIndices" value="0" type="number"/>
													<!--  par -->
													<tr height="30">
   														<td>&nbsp;</td>
  											 			<td>&nbsp;</td>
 										 			</tr>
									 		    	<logic:iterate id="comunidad"   name="form" property="comunidades">
									 		    		<c:if test="${contIndices!=0}">
									 		    			<c:if test="${contIndices%2==0}">
									 		    				<tr height="30">
	        														<td>
   																		<html:multibox name="form" styleId="${comunidad}" property="comunidadesSeleccionadas" value="${contIndices}" onclick="comprobarTodas();"/>									          	          
									         			 			</td>					
									        			  			<td class="td_largo_09" valign="top"><label for="${comunidad}">${comunidad}</label></td>
	      										 				</tr>
       														</c:if>
								  						</c:if>
 														<!--  end mayor 0 -->										
														<c:set var="contIndices" value="${contIndices+1}"/>
													</logic:iterate>
												</table>
											</td>
										</tr>
									</table>
										</div>
									</div>
								</div>
								<br /><!--  FIN CAJA DE FORMULARIO   -->
							</div>
						</div>
					</div>
				</div>
				</logic:equal>
				<!-- Inicio Botones  -->
				<fieldset class="tipo">
					<input class="boton_125_de_2_izq" name="pulsacion" type="submit"  value="<bean:message key="configurar.avanzado.buscar.limpiar"/>" />
					<input type="submit" class="boton_125_de_2" name="pulsacion" value="<bean:message key="configurar.avanzado.buscar.buscar"/>"  /><br />
				</fieldset>
				<!-- Fin Botones  -->
				<!-- Fin Botones  -->
			</form>
			
			<!--  Establecer el cursor por defecto en la caja del buscador   -->
		</div>
		<div id="m6" class="caja_cerrada" ></div>
	<!-- Fin plantilla contenido  -->
	</tiles:put>

</tiles:insert>

<SCRIPT LANGUAGE="JavaScript">
window.addEvent('domready', function() {
			jsMeses = "${nomMeses}"; arrayMeses = jsMeses.split(",");
			jsDias = "${nomDias}"; arrayDias = jsDias.split(",");
			myCal1 = new Calendar({ anyoPublicacion: { diaPublicacion: 'd', mesPublicacion: 'm', anyoPublicacion: 'Y' }}, { direction: 0, tweak: {x: 6, y: 0},months: arrayMeses ,days: arrayDias });
			});
	var ocultar="<bean:message key='configurar.avanzado.ocultar'/>";
	var ver="<bean:message key='configurar.avanzado.ver'/>";
	var propiedades = getChildsCount();
	var checkboxes= document.getElementsByTagName("input");
	var mostrarAmbito="${form.mostrarAmbito}";
	if(mostrarAmbito=="true"){
		var comunidades = 0;
		comunidades = contarComunidades();
		var totalComunidades = "${ fn:length(form.comunidades)}";
		document.getElementById("contadorComunidades").innerHTML=comunidades;
		if(comunidades<(totalComunidades-2)){
			expandirCaja('m3');
		}
	}
	if(propiedades>1){
		expandirCaja('m1');
	}
	
	if(trim(document.getElementById("nomTesauros").value)!=""){
		expandirCaja('m4');
	}
	
	document.getElementById("contadorPropiedades").innerHTML=propiedades;
	
	document.getElementById("m6").className = 'caja_abierta';
	document.forms[0].buscadorContenido.focus();
	
	function expandirCaja (i) 
	{
		if (document.getElementById(i).className=='caja_abierta') 
		{
			document.getElementById('p' + i).className = 'caja_cerrada';
			document.getElementById('d'+i).innerHTML=ver;
			document.getElementById(i).className = 'caja_cerrada';
			document.getElementById("contadorPropiedades").innerHTML=getChildsCount();
			var checkboxes= document.getElementsByTagName("input");
			document.getElementById("contadorComunidades").innerHTML=contarComunidades();
		}
		else 
		{
			document.getElementById('p' + i).className = 'caja_abierta';
			document.getElementById('d'+i).innerHTML=ocultar;
			document.getElementById(i).className = 'caja_abierta';
		}
	}
	
	function marcarTodas()
	{
	 	var checkboxes= document.getElementsByTagName("input");
	 	
		if(checkboxes[17].checked)
		{
		
			for (var x=19; x < checkboxes.length; x++) 
			{
				if(checkboxes[x].type=="checkbox")
				{
			   	 	checkboxes[x].checked=true;
				}
      		 }
		}
		else
		{
		for (var x=19; x < checkboxes.length; x++) 
			{
				if(checkboxes[x].type=="checkbox")
				{
			   	 	checkboxes[x].checked=false;
				}
      		 }
		}
	}

	function comprobarTodas(){
		var vacio=false;
		var checkboxes= document.getElementsByTagName("input");
		for (var x=18; x < checkboxes.length; x++){
				if(checkboxes[x].type=="checkbox" && checkboxes[x].checked==true)
				{
			   	 	vacio=true;
				}
		}
		if(vacio==true && checkboxes[17].checked == true) checkboxes[17].checked = false
	}
	
	function focusSubmit(evt) {
		evt = (evt) ? evt : event;
		var charCode = (evt.charCode) ? evt.charCode :
		((evt.which) ? evt.which : evt.keyCode);
		if (charCode == 13 || charCode == 3) {
			document.getElementById("pulsacion").focus();
			document.formularioAvanzado.submit();
			return false;
		}
		return true;
	}
</SCRIPT>