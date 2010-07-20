<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado-verMetadatos">

<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/derechos/derechos-form-vars.jspf" %>

<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" id="rea">
<jsp:include page="/layout/messages.jsp" flush="true"/>
<h2><bean:message key="catalogadorAvanzado.Derechos"/></h2>
<form method="post" action="<html:rewrite action="/VerMetadatos/DerechosFormVuelveDeDerechos"/>" >

<!--  INICIO GLOBO GRIS Coste  -->
<div class="globo_gris conmargen"  >
<div class="globo_gris_01">
<div class="globo_gris_02">
<div class="globo_gris_03">
	<!--  INICIO CAJA DE FORMULARIO  COSTE -->
	<div class="formu" >
					
		<h3><bean:message key="catalogadorAvanzado.Derechos.Coste"/></h3>
	<!--  INICIO GLOBO Blanco   -->
	<div class="globo_blanco pos_relative conmargen" >
	<div class="globo_blanco_01">
	<div class="globo_blanco_02">
	<div class="globo_blanco_03">
	<!--  INICIO Fila de Campos   -->
	<div class="fila_de_tabla_especial_03" >
  	<div class="contenedor_izquierda_esp" >
  	<div class="text">
  		<label for="Nivel025" class="oculto" ><bean:message key="catalogadorAvanzado.Derechos.SoloCoste"/>:</label>
  		<html:select disabled="true" styleClass="select_lrg" name="form" property="coste">
             <c:forEach  items="${form.costeBackingList}" var="listaCoste">
               <html:option value="${listaCoste.value }">${listaCoste.label }</html:option>
             </c:forEach>
        </html:select>
	</div>
	</div>
	<div class="limpiar"></div>
	<br class="oculto" />
			</div>	
	<!--  FILM Fila de Campos   -->
	</div>
	</div>
	</div>
	</div>
	</div>
	<!--  FIN GLOBO GRIS   -->
	
	<!--  FIN CAJA DE FORMULARIO  COSTE -->
	</div>
</div>
</div>
</div>
<!--  FIN GLOBO GRIS Coste  -->


<!--  INICIO GLOBO GRIS Copyright  -->
<div class="globo_gris conmargen"  >
<div class="globo_gris_01">
<div class="globo_gris_02">
<div class="globo_gris_03">
	<!--  INICIO CAJA DE FORMULARIO  Copyright -->
	<div class="formu" >
					
	<h3><bean:message key="catalogadorAvanzado.Derechos.CopyrightyOtrasRestricciones"/></h3>
	<!--  INICIO GLOBO Blanco   -->
	<div class="globo_blanco pos_relative conmargen" >
	<div class="globo_blanco_01">
	<div class="globo_blanco_02">
	<div class="globo_blanco_03">
	<!--  INICIO Fila de Campos   -->
	<div class="fila_de_tabla_especial_03" >
  	<div class="contenedor_izquierda_esp" >
  	<div class="text">
  		<label for="Nivel025" class="oculto" ><bean:message key="catalogadorAvanzado.Derechos.SoloCopyrightyOtrasRestricciones"/>:</label>
  		<html:select disabled="true" styleClass="select_lrg" name="form" property="copyRestricciones">
             <c:forEach  items="${form.copyRestriccionesBackingList}" var="listaCopy">
               <html:option value="${listaCopy.value }">${listaCopy.label }</html:option>
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
	<!--  FIN CAJA DE FORMULARIO Copyright  -->
	</div>
</div>
</div>
</div>
<!--  FIN GLOBO GRIS Copyright  -->

<!--  INICIO GLOBO GRIS Descripción  -->
<div class="globo_gris pos_relative conmargen" >
<div class="globo_gris_01">
<div class="globo_gris_02">
<div class="globo_gris_03">
			
	<!--  INICIO CAJA DE FORMULARIO  Descripción -->
	<div id="formulario" >
	
	<h3><bean:message key="catalogadorAvanzado.Derechos.Descripcion"/></h3>		
	<!--  INICIO GLOBO Blanco   -->
	<div class="globo_blanco" >
	<div class="globo_blanco_01">
	<div class="globo_blanco_02">
	<div class="globo_blanco_03">
	<!--  INICIO Fila de Campos   -->
	<logic:iterate id="descripcion" name="descripciones" indexId="i">	
				<c:set var="textos" value="${descripcion.textos }"/>
					<logic:iterate id="texto" name="textos" indexId="j">	
					<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="Des${j} }" class="oculto" ><bean:message key="catalogadorAvanzado.Derechos.SoloDescripcion"/>:</label>
  						<html:textarea readonly="true" styleClass="input_largo input_mder" property="DesTex${j}" value="${texto.texto}" styleId="Des${j}" onblur="this.style.backgroundColor='#e1e1e1'" title="${texto.texto}" cols="5" rows="4"/>
  						</div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text"><label for="Idio01" class="oculto" ><bean:message key="catalogadorAvanzado.Derechos.SoloDescripcion"/>:</label>
						<html:select disabled="true" styleClass="select_peq_n inp_se_ie" name="form" property="DesIdio${j}" value="${texto.idioma}" >
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
	                        <!-- quito el button  -->
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
	            			<!-- quito el button  -->
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
	
	
	</div>
	</div>
	</div>
	</div>
	<!--  FIN GLOBO BLANCO   -->
	</div>
	<!--  FIN CAJA DE FORMULARIO  Descripción -->
	</div>
	</div>
	</div>
	</div>
<!--  FIN GLOBO GRIS   -->

<!--  INICIO GLOBO GRIS  Acceso   -->
<div class="globo_gris pos_relative conmargen" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
			
			<h3><bean:message key="catalogadorAvanzado.Derechos.Acceso"/></h3>		
			<!--  INICIO GLOBO Blanco   -->
			<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco pos_relative" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
					<div class="globo_blanco_03">
				<!-- -->

				<!-- -->
				<!--  INICIO Fila de Campos   -->
				<!--  INICIO Fila de Campos   -->
				<div class="fila_de_tabla_especial" style="padding-left:0 !important">
  					<div class="contenedor_izquierda_esp">
  						<div class="text"><label for="Tipoacceso" ><bean:message key="catalogadorAvanzado.Derechos.SoloTipoAcceso"/>:</label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<html:select disabled="true" styleClass="select_lrg" name="form" property="tipoAcceso">
             				<c:forEach  items="${form.tipoAccesoBackingList}" var="listaTipo">
               					<html:option value="${listaTipo.value }">${listaTipo.label }</html:option>
             				</c:forEach>
       					 </html:select>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  Fin Fila de Campos   -->
				<!--  Fin Fila de Campos   -->
				<!-- -->
				<!-- -->
				</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO BLANCO   -->
<!--  FIN GLOBO BLANCO   -->
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco pos_relative conmargen" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
				<!--  INICIO Fila de Campos   -->
				<div class="fila_de_tabla_especial" style="padding-left:0 !important">
  					<div class="contenedor_izquierda_esp">
  						<div class="text"><label >Ámbito:</label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
						<div class="caja_de_tabla_invisible" id="cata">
						
						

						
<table cellspacing="0" cellpadding="0" border="0"  width="100%"  summary="Asignacion Comunidades">
	<logic:iterate id="nodo" name="form" property="listadoNodos" indexId="inodo">
	
		<c:if test="${inodo==0}">
			<tr>
				<td>
					<html:multibox styleClass="check" disabled="true" property="listadoComunidades" name="form" styleId="listadoComunidades" value="${nodo.idNodo}" onclick="marcarTodas();" />
				</td>
				<td colspan="3" valign="top">
					<label for="listadoComunidades${inodo}">${nodo.nodo}</label>
				</td>
			</tr>
		</c:if>
		<c:if test="${inodo==1}"> 
			<tr>
				<td>
					<html:multibox styleClass="check" disabled="true" property="listadoComunidades" name="form" styleId="listadoComunidades" value="${nodo.idNodo}"  onclick="seleccionMarcado();" />
				</td>
				<td colspan="3" valign="top">
					<label for="listadoComunidades${inodo}">${nodo.nodo}</label>
				</td>
			</tr>
		</c:if>
		<c:if test="${inodo>1}">
		<c:if test="${inodo%2==0}">	
			<tr>
				<td>
					<html:multibox styleClass="check" disabled="true" property="listadoComunidades" name="form"  styleId="listadoComunidades" value="${nodo.idNodo}"  onclick="seleccionMarcado();"/>
				</td>
				<td class="td_largo_09"  valign="top">
					<label for="listadoComunidades${inodo}">${nodo.nodo}</label>
				</td>
		</c:if>
		<c:if test="${inodo%2!=0}">	
				<td>
					<html:multibox styleClass="check" disabled="true" property="listadoComunidades" name="form"  styleId="listadoComunidades" value="${nodo.idNodo}"  onclick="seleccionMarcado();"/>
				</td>
				<td class="td_largo_09"  valign="top">
					<label for="listadoComunidades${inodo}">${nodo.nodo}</label>
				</td>
			</tr>
		</c:if>
		</c:if>
	
</logic:iterate>
</table>

</div>
						</div>
					</div>
					<div class="limpiar"></div>
					<br class="oculto" />
				</div>	
				<!--  Fin Fila de Campos   -->
				<!--  Fin Fila de Campos   -->
				<!--  fIN Fila de Campos   -->
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
</div>
<!-- Fin plantilla contenido  -->
</form>
</tiles:put>

</tiles:insert>
