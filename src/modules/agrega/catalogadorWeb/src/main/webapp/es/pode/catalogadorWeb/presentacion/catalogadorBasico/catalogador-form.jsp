<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>
<tiles:insert definition="layout-principalInicio">
<tiles:put name="title" type="string">
	<bean:message key="title.Basico"/>
</tiles:put> 

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/catalogadorBasico/catalogador-form-vars.jspf" %>
	

		<div class="plantilla_contenido"><h2><bean:message key="catalogadorBasico.Catalogador"/></h2>
		<jsp:include page="/layout/messages.jsp" flush="true"/>
			<form method="post" enctype="multipart/form-data" action="<html:rewrite action="/CatalogadorBasico/CatalogadorFormSubmit"/>">
					<p class="parrafo_comun" id="separacion2"><bean:message key="catalogadorBasico.Rellenar"/></p>
			<!--  INICIO GLOBO GRIS   -->
			<!--  INICIO GLOBO GRIS   -->
				<div class="globo_gris">
					<div class="globo_gris_01">
						<div class="globo_gris_02">
							<div class="globo_gris_03">	<!--  INICIO CAJA DE FORMULARIO   -->
								<div id="formulario">
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text"><label for="Titulo"><bean:message key="catalogadorBasico.Titulo"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">												
												
												<html:text property="titulo" value="${titulo}" styleId="Titulo" maxlength="125" titleKey="catalogadorBasico.IntroduzcaTitulo" />
												
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>	<!-- -->
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text">
											 <label for="Idioma"><bean:message key="catalogadorBasico.Idioma"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">											
											                              
											    <c:choose>
				                                <c:when test="${!empty form.idiomaBackingList}">	
                                  					<html:select name="form" property="idioma" titleKey="catalogadorBasico.SeleccioneIdioma" >
                                  						<c:set var="colorblanco" value="true"/>
                                  					    <c:set var="long" value="${fn:length(form.idiomaLabelList)}"/>
                                  						<fmt:formatNumber var="longIdiomaList" value="${long - 1 }" type="number"/>
                                  						<c:forEach  items="${form.idiomaBackingList}" var="listaIdioma" begin ="0" end="${longIdiomaList}">
                                  							<c:choose>
                                  							<c:when test="${colorblanco}">   
                                  								<html:option value="${listaIdioma.value }">${listaIdioma.label }</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:when>
                                  							<c:otherwise>
                                  								<html:option value="${listaIdioma.value }" styleClass="oscura">${listaIdioma.label }</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:otherwise>
                                  							</c:choose>	
                                  						</c:forEach>
                                  					</html:select>
                               					</c:when>
                               					<c:otherwise>
                                   					<html:select name="form" property="idioma" />
                               					</c:otherwise>
                           						</c:choose>						 	
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>	
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text"><label for="Descripcion"><bean:message key="catalogadorBasico.Descripcion"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">
												<textarea name="descripcion" style="maxlength: 150; font-style: normal; font-size: 1em;" 
												 rows="10" cols="40" class="ta_minimo_ancho"  id="Descripcion" title="<bean:message key="catalogadorBasico.IntroduzcaDescripcion"/>">${descripcion}</textarea>
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>	<!-- -->
									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text"><label for="tipoRecurso"><bean:message key="catalogadorBasico.TipoRecurso"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">											
											    <c:choose>
				                                <c:when test="${!empty form.tipoRecursoBackingList}">	
                                  					<html:select name="form" property="tipoRecurso" titleKey="catalogadorBasico.SeleccioneTipoRecurso">
                                  						<c:set var="colorblanco" value="true"/>
                                  					    <c:set var="long" value="${fn:length(form.tipoRecursoLabelList)}"/>
                                  						<fmt:formatNumber var="longTipoRecursoList" value="${long - 1 }" type="number"/>
                                  						<c:forEach  items="${form.tipoRecursoBackingList}" var="listaTipoRecurso" begin ="0" end="${longTipoRecursoList}">
                                  							<c:choose>
                                  							<c:when test="${colorblanco}">   
                                  								<html:option value="${listaTipoRecurso.value }">${listaTipoRecurso.label}</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:when>
                                  							<c:otherwise>
                                  								<html:option value="${listaTipoRecurso.value }" styleClass="oscura">${listaTipoRecurso.label}</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:otherwise>
                                  							</c:choose>	
                                  						</c:forEach>
                                  					</html:select>
                               					</c:when>
                               					<c:otherwise>
                                   					<html:select name="form" property="tipoRecurso" />
                               					</c:otherwise>
                           						</c:choose>						 	
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>	

									<div class="fila_de_tabla">
										<div class="contenedor_izquierda">
											<div class="text"><label for="idiomaDestinatario"><bean:message key="catalogadorBasico.IdiomaDestinatario"/></label>
											</div>
										</div>
										<div class="contenedor_derecha">
											<div class="text">											                      
											    <c:choose>
				                                <c:when test="${!empty form.idiomaDestinatarioBackingList}">	
                                  					<html:select name="form" property="idiomaDestinatario" titleKey="catalogadorBasico.SeleccioneIdiomaDestinatario">
                                  						<c:set var="colorblanco" value="true"/>
                                  					    <c:set var="long" value="${fn:length(form.idiomaDestinatarioLabelList)}"/>
                                  						<fmt:formatNumber var="longIdiomaDestinatario" value="${long - 1 }" type="number"/>
                                  						<c:forEach  items="${form.idiomaDestinatarioBackingList}" var="listaIdiomaDestinatario" begin ="0" end="${longIdiomaDestinatario}">
                                  							<c:choose>
                                  							<c:when test="${colorblanco}">   
                                  								<html:option value="${listaIdiomaDestinatario.value }">${listaIdiomaDestinatario.label}</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:when>
                                  							<c:otherwise>
                                  								<html:option value="${listaIdiomaDestinatario.value }" styleClass="oscura">${listaIdiomaDestinatario.label}</html:option>
                                  								<c:set var="colorblanco" value="${!colorblanco }"/>
                                  							</c:otherwise>
                                  							</c:choose>	
                                  						</c:forEach>
                                  					</html:select>
                               					</c:when>
                               					<c:otherwise>
					                                   <html:select name="form" property="idiomaDestinatario" styleId="taxonomiasIdiomaDestinatario"/>
					                               </c:otherwise>
                           						</c:choose>						 	
											</div>
										</div>
										<div class="linea_separadora">
										</div><br class="oculto"/>
									</div>	
								</div>	<!--  FIN CAJA DE FORMULARIO   -->
							</div>
						</div>
					</div>
				</div>	<!--  FIN GLOBO GRIS   -->
	<!--  FIN GLOBO GRIS   -->
<p class="parrafo_comun" id="separacion3"><bean:message key="catalogadorBasico.frase"/></p>

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->

				<div id="formulario_02" >
			<!--  INICIO CAPA TABLA PORTAPAPELES   -->
			<!--  INICIO CAPA TABLA PORTAPAPELES   -->						
 					<div class="caja_tabla bordeada" ><display:table name="${form.arboles}" id="asociacion" 
							style="border:1;width:100%" class="generica_02" cellpadding="0" 
							cellspacing="0" 
							summary="${summary}" requestURI="${pageContext.request.requestURL}">
				
							<display:caption><strong> <bean:message key="catalogadorBasico.tablaAsociacionSummary"/></strong></display:caption>
							<display:setProperty name="css.tr.even" value="tr_gris"/>
        					<display:setProperty name="css.tr.odd" value="tr_blanco"/>
		    				<display:setProperty name="basic.show.header" value="false"/>
		    
		    				<c:if test="${!empty asociacion.taxones }">
		   	 					<c:set var="longitud" value="${ fn:length(asociacion.taxones)}"/>
		        				<c:set var="rutaAsociada" value=""/>
		        				<c:forEach items="${asociacion.taxones }" var="ruta" begin="0" end="0">
		    						<em class="oculto">-</em>
		    						<c:set var="rutaAsociada" value="${ruta.valorTax }"/>
		  						</c:forEach>
		        				<c:if test="${longitud>1 }">
			   						<c:forEach items="${asociacion.taxones }" var="ruta" begin="1" end="${longitud }">
			    						<em class="oculto">-</em>
			    						<c:set var="rutaAsociada" value="${ruta.valorTax }/${rutaAsociada }"/>
			  						</c:forEach>
			  					</c:if>
		 					</c:if>
		 					<display:column>        	
								<input type="checkbox" name="idArbol" id="asociacion${asociacion.idArbol}" value="${asociacion.idArbol}"/>	
		    				</display:column>
		    				<display:column style="valign:top" class="td_larga" >
		    					${rutaAsociada}

							</display:column>
						</display:table>
					</div>
					
					<fieldset class="tipo acentrado">
						<div class="asociareliminar" style="width:auto">
						<c:choose>
							<c:when test="${!empty form.arboles}">
								<input class="boton_125_de_2"  style="height:2em" type="submit"  name="accionSubmit"  value="<bean:message key="catalogadorBasico.Eliminar"/>" />
								<input class="boton_125_de_2_izq" style="height:2em" type="submit"  name="accionSubmit"  value="<bean:message key="catalogadorBasico.ArbolCurricular"/>" />
	             			</c:when> 
	             			<c:otherwise>
								<input class="boton_125_de_2_izq" style="height:2em" type="submit"  name="accionSubmit"  value="<bean:message key="catalogadorBasico.ArbolCurricular"/>" />
	             			</c:otherwise>
						</c:choose>
						</div>
					</fieldset>
					<br class="limpiar" />
			<!--  FIN CAPA TABLA PORTAPAPELES   -->
			<!--  FIN CAPA TABLA PORTAPAPELES   -->	
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>

	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<!-- Inicio Botones  -->

<fieldset class="tipo ft_centrada">
      <input class="boton_125_de_2" type="submit" name="accionSubmit" value="<bean:message key="catalogadorBasico.Aceptar"/>" />
       <input class="boton_125_de_2_izq"  type="submit" name="accionSubmit" value="<bean:message key="catalogadorBasico.Cancelar"/>" />
      <input class="boton_125"  type="submit" name="accionSubmit" value="<bean:message key="catalogadorBasico.Validar"/>" />

</fieldset>

<!-- Fin Botones  -->

			</form>
		</div>	<!-- Fin plantilla contenido  -->
	<!-- Fin plantilla contenido  -->
	
	
</tiles:put>

</tiles:insert>