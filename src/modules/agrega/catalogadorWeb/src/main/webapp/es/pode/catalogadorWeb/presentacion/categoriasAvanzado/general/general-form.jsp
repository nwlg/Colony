<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tlds/tags-catalogador.tld" prefix="cat" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/general/general-form-vars.jspf" %>

<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" id="rea">
<jsp:include page="/layout/messages.jsp" flush="true"/>
<h2><bean:message key="catalogadorAvanzado.SoloGeneral"/></h2>

<form name="mainform" method="post" action="<html:rewrite action="/General/GeneralFormSubmit"/>" >
<p class="parrafo_comun" id="separacion2"><bean:message key="catalogadorAvanzado.General.TextoObligacion"/></p>
<input type="hidden" id="seleccionar" name="seleccionar" value="<bean:write name="form" property="accion"/>"/> 
<input type="hidden" name="accion" value="">


<script type="text/javascript">
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
		if(partes[0] == "Añadir Idioma"){
			document.location.href="#idiomas";
		}
		else if(partes[0]=="Eliminar Idioma"){
			document.location.href="#idiomas";
		}
		if(partes[0] == "Añadir Titulo"){
			document.location.href="#titulos";
		}
		else if(partes[0]=="Eliminar Titulo"){
			document.location.href="#titulos";
		}
		else if(partes[0]=="Añadir Descripcion"){
			document.location.href="#descripciones";
		}
		else if(partes[0]=="Eliminar Descripcion"){
			indice=partes[1];
			if(indice>0){
				indice = indice -1;
			}
			document.location.href="#descripcion-"+indice;
		}
		else if(partes[0]=="Añadir ContDescripcion" ){
			indice=partes[1];//indice de la descripcion
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
		else if( partes[0]=="Añadir Caracteristica" || partes[0]=="Eliminar Caracteristica"){
			indice1 = partes[1];//indice dentro de la descripcion
			indice2 = partes[2];//indice de la descripcion
			document.location.href="#contDescripcion-"+indice2+"-"+indice1;
		}
		else if(partes[0]=="Añadir PalabraClave"){
			document.location.href="#palabrasClave";
		}
		else if(partes[0]=="Eliminar PalabraClave"){
			indice=partes[1];
			if(indice>0){
				indice = indice -1;
			}
			document.location.href="#palabraClave-"+indice;
		}
		else if(partes[0]=="Añadir ContPalabraClave"){
			indice=partes[1];//indice del ambito
			document.location.href="#contPalabrasClave-"+indice;
		}
		else if(partes[0]=="Eliminar ContPalabraClave"){
			indice1 = partes[1];//indice dentro del ambito
			indice2 = partes[2];//indice del ambito
			if(indice1>0){
				indice1 = indice1 -1;
			}
			document.location.href="#contPalabraClave-"+indice1+"-"+indice2;
		}
		else if(partes[0]=="Añadir Ambitos"){
			document.location.href="#ambitos";
		}
		else if(partes[0]=="Eliminar Ambitos"){
			indice=partes[1];
			if(indice>0){
				indice = indice -1;
			}
			document.location.href="#ambito-"+indice;
		}
		else if(partes[0]=="Añadir ContAmbito"){
			indice=partes[1];//indice del ambito
			document.location.href="#contAmbitos-"+indice;
		}
		else if(partes[0]=="Eliminar ContAmbito"){
			indice1 = partes[1];//indice dentro del ambito
			indice2 = partes[2];//indice del ambito
			if(indice1>0){
				indice1 = indice1 -1;
			}
			document.location.href="#contAmbito-"+indice1+"-"+indice2;
		}
		
	}
	
}
window.onload=seleccionarCampo;


	function expandirCaja (nomcaja) 
	{
		if (document.getElementById(nomcaja).className == 'caja_cerrada')
		{ 
			document.getElementById(nomcaja).className = 'caja_abierta';
			document.getElementById('enlace-'+nomcaja).innerHTML = '<bean:message key="general.Descripcion.Ocultar"/>';
			return false;
		} else {
			document.getElementById(nomcaja).className = 'caja_cerrada';
			document.getElementById('enlace-'+ nomcaja).innerHTML = '<bean:message key="general.Descripcion.masDatos"/>';
			return false;
		}
		
	}

function doSubmit(formname, sAction) {
        document.forms[formname].accion.value = sAction;
        document.forms[formname].submit();
}

</script> 



<!--  start bubble IDENTIFICADOR  -->
<a id="identificador"></a>
<div class="lb_bubble_topleft" >
	<div class="lb_bubble_bottomleft">
		<div class="lb_bubble_topright">
			<div class="lb_bubble_bottomright">
			<div class="lb_bubble_content">
			
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
			
			<h3 class="h3flotante"><bean:message key="catalogadorAvanzado.General.Identificador"/></h3>
			<!--  INICIO GLOBO Blanco   -->
			<!--  INICIO GLOBO Blanco   -->
			<c:forEach var="identificador" items="${form.identificadores }" varStatus="estado">
			<div class="globo_blanco globito flotder" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
					<div class="globo_blanco_03">
				<!-- -->
				<!--  INICIO Fila de Campos   -->
				<!--  INICIO Fila de Campos   -->
				
				<div class="fila_de_tabla_especial_03" style="padding-left:0 !important">
  					<div class="contenedor_izquierda_esp">
  						<div class="text"><label for="Cat${estado.index}" ><bean:message key="catalogadorAvanzado.General.Catalogo"/>:</label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
						<html:text styleClass="input_medio_largo" style="width:164px !important" property="IdCat${estado.index}" value="${identificador.catalogo}" styleId="Cat${estado.index}" onblur="this.style.backgroundColor='#e1e1e1'"  titleKey="catalogadorAvanzado.IntroduzcaCatalogo" />
						</div>
					</div>
					<div class="contenedor_izquierda_esp">
  						<div class="text"><label for="Ent${estado.index}"  class="lab_ie"><bean:message key="catalogadorAvanzado.General.Entrada"/>:</label></div>
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
					<!--  Fin Fila de Campos   -->
					</div>
					</div>
					</div>
					</div>	<!--  FIN GLOBO BLANCO   -->
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
	                        <input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Identificador-${estado.index}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
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
	</div>
	<!--  end bubble -->

<!--  start bubble -->
<a id="titulos"></a>
<div class="lb_bubble_topleft conmargen"  >
        <div class="lb_bubble_bottomleft">
                <div class="lb_bubble_topright">
                        <div class="lb_bubble_bottomright">
                        <div class="lb_bubble_content">

			<!--  INICIO CAJA DE FORMULARIO   -->
			<div class="formu" >
			<h3><bean:message key="catalogadorAvanzado.General.Titulo"/></h3>
<!--  INICIO GLOBO Blanco   -->
<!--  INICIO GLOBO Blanco   -->
			<div class="globo_blanco pos_relative conmargen" >
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							<!--  INICIO Fila de Campos   -->
				<logic:iterate id="titulo" name="titulos" indexId="i">	
				<c:set var="textos" value="${titulo.textos }"/>
					<logic:iterate id="texto" name="textos" indexId="j">	
					<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="Tit${j} }" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloTitulo"/>:</label>
  						<html:text styleClass="input_largo input_mder" property="TitTex${j}" value="${texto.texto}" styleId="Tit${j}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaTitulo" />
  						</div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text"><label for="Idio01" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloIdioma"/>:</label>
							<bean:define id="titulo"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
							<cat:select name="form" property="TitIdio${j}"  estiloSelect="select_peq_n inp_se_ie" estiloOscuro="oscura"  backingList="${form.comboIdiomaBackingList}" value="${texto.idioma}" title="${titulo}"/>
						</div>
					</div>
					<div class="float_izquierda_n">
					<c:choose>
                   		<c:when test="${j==0}">   
					    	<span class="oculto">-</span> 
	                        <input class="boton_anadir cms_ie" type="submit" name="accion_Añadir Titulo" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>" /> 
					        
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
	            			<input class="boton_eliminar cms_ie" type="submit" name="accion_Eliminar Titulo-${j}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
					        
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
				<!--  Fin Fila de Campos   -->
				<!--  FIN GLOBO BLANCO   -->
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
</div>
<!--  end bubble -->
<!--  start bubble -->
<a id="idiomas"></a>
<div class="lb_bubble_topleft conmargen"  >
        <div class="lb_bubble_bottomleft">
                <div class="lb_bubble_topright">
                        <div class="lb_bubble_bottomright">
                        <div class="lb_bubble_content">
	<!--  INICIO CAJA DE FORMULARIO   -->
	<div class="formu" >
					
	<h3 class="h3flotante"><bean:message key="catalogadorAvanzado.General.Idioma"/></h3>
	<!--  INICIO GLOBO Blanco   -->
	<logic:iterate id="idioma" name="idiomas" indexId="i">
			<div class="globo_blanco globito flotder">
				<div class="globo_blanco_01">
					<div class="globo_blanco_02">
						<div class="globo_blanco_03">
							<!--  INICIO Fila de Campos   -->
							 
								<div class="fila_de_tabla_especial_03" >
		  							<div class="contenedor_izquierda_esp">
			  							<div class="text">
			  								<label for="form" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloIdioma"/>:</label>
												<bean:define id="idio"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
												<cat:select name="form" property="Idio${i}" value="${idioma.texto}" title="${idio}" backingList="${form.idiomasBackingList}" estiloSelect="select_lrg inp_se_ie " estilo="width:430px !important" estiloOscuro="oscura"/>
										</div>
									</div>
									<div class="limpiar">
									</div><br class="oculto"/>
								</div>
									<!--  Fin Fila de Campos   -->
									<!--  Fin Fila de Campos   -->
						
							<!--  INICIO Fila de Campos   -->

					<!--  INICIO Fila de Campos   -->
					<!--  FIN GLOBO BLANCO   -->
					<!--  FIN GLOBO BLANCO   -->
						</div>
					</div>
				</div>
			</div>

									<!--  Enlaces de fuera   -->

								<!--  Enlaces de fuera   -->
									<div class="flotder">
									<c:choose>
                   						<c:when test="${i==0}">   
					                        <span class="oculto">-</span>
					                        <span class="flotder enlace_anadir_02"> 
					                        <input class="boton_anadir flotder" type="submit" name="accion_Añadir Idioma" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
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
									<c:set var="longitud" value="${ fn:length(form.idiomas) }"/>
									<c:choose>
				                        <c:when test="${longitud>1}">   
	            				            <span class="oculto">-</span>
	            				            <span class="flotder enlace_eliminar_02"> 
	            				             <input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Idioma-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>" /> 
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
										</logic:iterate>
								</div>	
				

</div>
			
<!--  FIN CAJA DE FORMULARIO   -->
		</div>
	</div>
</div>
</div>

<!--  end bubble -->

	<!--  start bubble Descripción -->
				<div class="lb_bubble_topleft conmargen">
	        			<div class="lb_bubble_bottomleft">
                				<div class="lb_bubble_topright">
                        				<div class="lb_bubble_bottomright">
                        				<div class="lb_bubble_content">
		<!--  INICIO CAJA DE FORMULARIO   -->
								<div class="formu">
									<h3 class="h3flotante"><bean:message key="catalogadorAvanzado.General.Descripcion"/></h3>
									<c:set var="longDescripcionAnterior" value="0"/>
									<logic:iterate id="descripcion" name="descripciones" indexId="i">
													<!--anclas-->
													<c:choose>
								                        <c:when test="${i== fn:length(form.descripciones)-1}">   
									                     <a id="descripciones"></a>
								                        </c:when>
								                    </c:choose>	
													<a id="descripcion-${i}"></a>
													<!--fin de anclas-->
									<!--  INICIO GLOBO BLANCO   -->
									<!--  INICIO GLOBO BLANCO   -->
									<div class="globo_blanco globito flotder">
										<div class="globo_blanco_01">
											<div class="globo_blanco_02">
												<div class="globo_blanco_03">	<!--  INICIO Fila de Campos   -->
								<!--  INICIO Fila de Campos   -->
										<c:set var="textos" value="${descripcion.textos }"/>
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
			<c:set var="caracteristica" value="${ form.caracteristicas[i][j] }"/>
			
										
											<c:set var="indice" value="${j + longDescripcionAnterior}"/>
													<div class="fila_de_tabla_especial_03">
														<div class="contenedor_izquierda_esp">
															<div class="text">
															<label for="Des${j}" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloDescripcion"/>:</label>
															<html:textarea readonly="${caracteristica!=null && !caracteristica.vacio }" styleClass="input_medio_largo input_mder" property="Des${i}_Tex${j}" value="${contenido.texto}" styleId="Des${i}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaDescripcion"  cols="5" rows="4"  />
															</div>
														</div>
														<div class="contenedor_izquierda_esp">
															<div class="text">
																<label for="Idio05" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloIdioma"/>:</label>
																<bean:define id="descripcion"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
																<cat:select name="form" property="Des${i}_Idio${j}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq_n inp_se_ie" estiloOscuro="oscura"  value="${contenido.idioma}" title="${descripcion}" />
															</div>
														</div>
														<div class="float_izquierda_n">
															<c:choose>
																<c:when test="${j==0}">   
																	<span class="oculto">-</span> 
																	<input class="boton_anadir cms_ie" type="submit" name="accion_Añadir ContDescripcion-${i}" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>" /> 
																</c:when>
																<c:otherwise>
																	&nbsp;
																</c:otherwise>
															</c:choose>
														</div>
														<div class="float_izquierda_n">
																<span class="oculto">-</span>
																<input class="boton_eliminar cms_ie" type="submit" name="accion_Eliminar ContDescripcion-${j}-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
														</div>
														<br class="limpiar"/>
														

			<a class="desplegado" id="p-caract-${i}-${j}" href="javascript:;" onclick="expandirCaja('caract-${i}-${j}');return false;" onkeypress="expandirCaja('caract-${i}-${j}');return false;">
				<br class="falso" /><span id="enlace-caract-${i}-${j}" ><bean:message key="general.Descripcion.masDatos"/></span>
			</a>
			

													</div>
<br/>													
					<!--  Fila de Campos  caracteristica -->
			<!--  INICIO CAJA DE FORMULARIO   -->
			

			<script type="text/javascript" languaje="JavaScript">
			//<![CDATA[
				document.write('<div id="caract-${i}-${j}" class="caja_cerrada" >');
			//]]>
			</script>
			<noscript><div id="caract-${i}-${j}" class="caja_abierta" ></noscript>

			  <!-- INICIO TABLA  -->

				<div class="globo_blanco" >
					<div class="globo_blanco_01">
						<div class="globo_blanco_02">
							<div class="globo_blanco_03" style="padding: 0pt;margin-left:0px;">
<div class="fila_de_tabla_especial_03">
<!--  INICIO Fila de Campos - Resolución  -->
		<div class="contenedor_izquierda_esp" style="width:120px;margin-top:5px">
			<div class="text">
			<label for="Resolucion"><bean:message key="general.Descripcion.Resolucion.label"/></label>
			</div>
		</div>
		<div class="contenedor_izquierda_esp">
		<div class="text">
				<label for="Resolucion" class="oculto"><bean:message key="general.Descripcion.Resolucion.label"/></label>
				<input type="text" name="Des${i}_CRes${j}" style="width:260px !important;"  class="input_largo input_mder"   value="${caracteristica.resolucion}" onblur="this.style.backgroundColor='#e1e1e1'" title="${caracteristica.resolucion}"/>
		</div>
		</div>
		<br class="limpiar" />
<!--  Fin Fila de Campos - Resolución  -->

<!--  INICIO Fila de Campos - dimension  -->
		<div class="contenedor_izquierda_esp" style="width:120px;">
			<div class="text">
				<label for="Dimension" ><bean:message key="general.Descripcion.Dimension.label"/></label>
			</div>
		</div>
		<div class="contenedor_izquierda_esp">
			<div class="text">		
					<label for="Dimension" class="oculto"><bean:message key="general.Descripcion.Dimension.label"/></label>
					<bean:define id="msjDimension"><bean:message key="general.Descripcion.Dimension.title"/></bean:define>
					<cat:select value="${caracteristica.dimension}" name="form" property="Des${i}_CDim${j}" backingList="${form.comboCaractDimensionBackingList}" estiloSelect="input_medio_largo" estiloOscuro="oscura"   title="${msjDimension}" />
			</div>
		</div>
		<br class="limpiar"/>
<!--  Fin Fila de Campos - dimension  -->
												
<!--  INICIO Fila de Campos  - Color -->
		<div class="contenedor_izquierda_esp" style="width:120px;">
			<div class="text">
				<label for="Color"><bean:message key="general.Descripcion.Color.label"/></label>
			</div>
		</div>
		<div class="contenedor_izquierda_esp">
			<div class="text">		
				<label for="Color" class="oculto"><bean:message key="general.Descripcion.Color.label"/></label>
				<bean:define id="msjColor"><bean:message key="general.Descripcion.Color.title"/></bean:define>
				<cat:select   value="${caracteristica.modoColor}" name="form" property="Des${i}_CCol${j}" backingList="${form.comboCaractColorBackingList}" estiloSelect="input_medio_largo" estiloOscuro="oscura" title="${msjColor}" />
			</div>
		</div>
		<br class="limpiar"/>
<!--  Fin Fila de Campos  - Color  -->
								
<!--  INICIO Fila de Campos - banda sonora  -->
		<div class="contenedor_izquierda_esp" style="width:120px;">
			<div class="text">
				<label for="BandaSonora"><bean:message key="general.Descripcion.BandaSonora.label"/></label>
			</div>
		</div>
		<div class="contenedor_izquierda_esp">
			<div class="text">		
				<label for="BandaSonora" class="oculto"><bean:message key="general.Descripcion.BandaSonora.label"/></label>
				<bean:define id="msjBandaSonora"><bean:message key="general.Descripcion.BandaSonora.title"/></bean:define>
				<cat:select  value="${caracteristica.bandaSonora}" name="form" property="Des${i}_CBan${j}" backingList="${form.comboCaractBandaSonoraBackingList}" estiloSelect="input_medio_largo" estiloOscuro="oscura"  title="${msjBandaSonora}" />
			</div>
		</div>
		<br class="limpiar"/>
<!--  Fin Fila de Campos - BandaSonora  -->
										
<!--  INICIO Fila de Campos  - Formato -->
		<div class="contenedor_izquierda_esp" style="width:120px;">
			<div class="text">
				<label for="Formato"><bean:message key="general.Descripcion.Formato.label"/></label>
			</div>
		</div>
		<div class="contenedor_izquierda_esp">
			<div class="text">		
				<label for="Formato" class="oculto"><bean:message key="general.Descripcion.Formato.label"/></label>
				<bean:define id="msjFormato"><bean:message key="general.Descripcion.Formato.title"/></bean:define>
				<cat:select  value="${caracteristica.formato}" name="form" property="Des${i}_CFor${j}" backingList="${form.comboCaractFormatoBackingList}" estiloSelect="input_medio_largo" estiloOscuro="oscura"  title="${msjFormato}" />
			</div>
		</div>
		<br class="limpiar"/>
<!--  Fin Fila de Campos  - Formato -->

<!--  INICIO Fila de Campos - Tipo de Plano  -->
		<div class="contenedor_izquierda_esp" style="width:120px;">
			<div class="text">
				<label for="TipoPlano"><bean:message key="general.Descripcion.TipoPlano.label"/></label>
			</div>
		</div>
		<div class="contenedor_izquierda_esp">
			<div class="text">		
				<label for="TipoPlano" class="oculto" ><bean:message key="general.Descripcion.TipoPlano.label"/></label>
				<bean:define id="msjTipoPlano"><bean:message key="general.Descripcion.TipoPlano.title"/></bean:define>
				<cat:select  value="${caracteristica.tipoPlano}"  name="form" property="Des${i}_CTip${j}" backingList="${form.comboCaractTipoPlanoBackingList}" estiloSelect="input_medio_largo" estiloOscuro="oscura"  title="${msjTipoPlano}" />
			</div>
		</div>
		<br class="limpiar"/>
<!--  Fin Fila de Campos  - Tipo de Plano -->
									
<!--  INICIO Fila de Campos  - Luz -->
		<div class="contenedor_izquierda_esp" style="width:120px;">
			<div class="text">
				<label for="Luz"><bean:message key="general.Descripcion.Luz.label"/></label>
			</div>
		</div>
		<div class="contenedor_izquierda_esp">
			<div class="text">		
				<label for="Luz" class="oculto" ><bean:message key="general.Descripcion.Luz.label"/></label>
				<bean:define id="msjLuz"><bean:message key="general.Descripcion.Luz.title"/></bean:define>
				<cat:select  value="${caracteristica.luz}" name="form" property="Des${i}_CLuz${j}" backingList="${form.comboCaractLuzBackingList}" estiloSelect="input_medio_largo" estiloOscuro="oscura"  title="${msjLuz}" />
			</div>
		</div>
		<br class="limpiar"/>
<!--  Fin Fila de Campos  - Luz -->
							
<!--  INICIO Fila de Campos - Estructura Formal  -->
		<div class="contenedor_izquierda_esp" style="width:120px;">
			<div class="text">
				<label for="EstructuraFormal"><bean:message key="general.Descripcion.EstructuraFormal.label"/></label>
			</div>
		</div>
		<div class="contenedor_izquierda_esp">
			<div class="text">		
				<label for="EstructuraFormal" class="oculto" ><bean:message key="general.Descripcion.EstructuraFormal.label"/></label>
				<bean:define id="msjEstructuraFormal"><bean:message key="general.Descripcion.EstructuraFormal.title"/></bean:define>
				<cat:select  value="${caracteristica.estructuraFormal}"  name="form" property="Des${i}_CEst${j}" backingList="${form.comboCaractEstructuraFormalBackingList}" estiloSelect="input_medio_largo" estiloOscuro="oscura" title="${msjEstructuraFormal}" />
			</div>
		</div>
		<br class="limpiar"/>
<!--  Fin Fila de Campos - Estructura Formal  -->
									
										
<!--  INICIO Fila de Campos  - Angulación -->
		<div class="contenedor_izquierda_esp" style="width:120px;">
			<div class="text">
				<label for="Angulacion" ><bean:message key="general.Descripcion.Angulacion.label"/></label>
			</div>
		</div>
		<div class="contenedor_izquierda_esp">
			<div class="text">		
				<label for="Angulacion" class="oculto" ><bean:message key="general.Descripcion.Angulacion.label"/></label>
				<bean:define id="msjAngulacion"><bean:message key="general.Descripcion.Angulacion.title"/></bean:define>
				<cat:select  value="${caracteristica.angulacion}"  name="form" property="Des${i}_CAng${j}" backingList="${form.comboCaractAngulacionBackingList}" estiloSelect="input_medio_largo" estiloOscuro="oscura"  title="${msjAngulacion}" />
			</div>
		</div>
		<br class="limpiar"/>
<!--  Fin Fila de Campos - Angulación -->
				<fieldset class="tipo ft_centrada" style="margin-top:0 !important;">
					<input class="boton_125" style="height:2.2em;"  type="submit"  name="accion_Añadir Caracteristica-${i}-${j}" value="<bean:message key="general.Descripcion.caracteristica.Anadir"/>" />
					<div class="limpiar"/>
				</fieldset>
	<br class="limpiar" />

</div>

				<!--  Fin capa oculta -->		
				

				<br class="limpiar"/>
				<br class="oculto" />
				
					<!--  Fin Fila de Campos  caracteristica  -->
</div>
</div>
</div>
</div>
			<script type="text/javascript" languaje="JavaScript">
			//<![CDATA[
				document.write('</div>');
			//]]>
			</script>												
										</logic:iterate>	
										<c:set var="longDescripcionAnterior" value="${ longDescripcion + longDescripcionAnterior }"/>

	
				    <!--  Fin Fila de Campos   -->
					<!--  Fin Fila de Campos   -->
					
					
												</div>
											</div>
										</div>
									</div>	
	<!-- FIN GLOBO -->
									<!--  Enlaces de fuera   -->
									<div class="flotder">
										<c:choose>
											<c:when test="${i==0}">   
												<span class="oculto">-</span>	
												<span class="flotder enlace_anadir_02">
													<input class="boton_anadir flotder" type="submit" name="accion_Añadir Descripcion" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>" /> 
													
												</span>
											</c:when>
											<c:otherwise>
												<span class="oculto">-</span>	
												<span class="flotder enlace_anadir_02">											
												&nbsp;
												</span>
											</c:otherwise>
										</c:choose>	
										<c:set var="longitud" value="${ fn:length(form.descripciones) }"/>
										<c:choose>
											<c:when test="${longitud>1}">   
												<span class="oculto">-</span>	
												<span class="flotder enlace_eliminar_02">
													<input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Descripcion-${i }" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
													
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
				</div>
				</div>
					
	<!-- end bubble -->


	<!--  start bubble Palabra Clave -->
				<div class="lb_bubble_topleft conmargen">
        				<div class="lb_bubble_bottomleft">
                				<div class="lb_bubble_topright">
                        				<div class="lb_bubble_bottomright">
                        				<div class="lb_bubble_content">
	<!--  INICIO CAJA DE FORMULARIO   -->
								<div class="formu">
									<h3 class="h3flotante"><bean:message key="catalogadorAvanzado.General.PalabraClave"/></h3>
									<c:set var="longPalabrasAnterior" value="0"/>
									<logic:iterate id="palabra" name="palabrasClave" indexId="i">
													<!--anclas-->
													<c:choose>
								                        <c:when test="${i== fn:length(form.palabrasClave)-1}">   
									                     <a id="palabrasClave"></a>
								                        </c:when>
								                    </c:choose>	
													<a id="palabraClave-${i}"></a>
													<!--fin de anclas-->
									<!--  INICIO GLOBO BLANCO   -->
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
									                     <a id="contPalabrasClave-${i}"></a>
									                     </c:when>
								                    </c:choose>	
													<a id="contPalabraClave-${j}-${i}"></a>
													<!--fin de anclas-->	
										
											<c:set var="indice" value="${j + longPalabrasAnterior}"/>
													<div class="fila_de_tabla_especial_03">
														<div class="contenedor_izquierda_esp">
															<div class="text">
															<label for="PalClave01" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloPalabraClave"/>:</label>
														<html:text styleClass="input_medio input_mder" property="Pcla${i}_Tex${j}" value="${contenido.texto}" styleId="PalClave${i}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaPalabraClave" />
															</div>
														</div>
														<div class="contenedor_izquierda_esp">
															<div class="text">
																<label for="Idio05" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloIdioma"/>:</label>
																<bean:define id="palabra"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
																<cat:select name="form" property="Pcla${i}_Idio${j}" value="${contenido.idioma}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq_n inp_se_ie" estiloOscuro="oscura" title="${palabra }"/>
															</div>
														</div>
														<div class="float_izquierda_n">
															<c:choose>
																<c:when test="${j==0}">   
																	<span class="oculto">-</span> 
																	<input class="boton_anadir cms_ie" type="submit" name="accion_Añadir ContPalabraClave-${i}" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>" /> 
																	
																
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
																	<input class="boton_eliminar cms_ie" type="submit" name="accion_Eliminar ContPalabraClave-${j}-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
																	
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
					<!--  Fin Fila de Campos   -->
												</div>
											</div>
										</div>
										</div>
									</div>	
	<!--  end bubble -->
								<!--  Enlaces de fuera   -->
								<div class="flotder">
									<c:choose>
										<c:when test="${i==0}">   
											<span class="oculto">-</span>	
											<span class="flotder enlace_anadir_02">
												<input class="boton_anadir flotder" type="submit" name="accion_Añadir PalabraClave" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>" /> 
												
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
												<input class="boton_eliminar flotder" type="submit" name="accion_Eliminar PalabraClave-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
												
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


	<!--  start bubble Ambito -->
				<div class="lb_bubble_topleft conmargen">
        				<div class="lb_bubble_bottomleft">
                				<div class="lb_bubble_topright">
                        				<div class="lb_bubble_bottomright">
                        				<div class="lb_bubble_content">
							<!--  INICIO CAJA DE FORMULARIO   -->
								<div class="formu">
									<h3 class="h3flotante"><bean:message key="catalogadorAvanzado.General.Ambito"/></h3>
									<c:set var="longAmbitoAnterior" value="0"/>
									<logic:iterate id="ambito" name="ambitos" indexId="i">
													<!--anclas-->
													<c:choose>
								                        <c:when test="${i== fn:length(form.ambitos)-1}">   
									                     <a id="ambitos"></a>
								                        </c:when>
								                    </c:choose>	
													<a id="ambito-${i}"></a>
													<!--fin de anclas-->
									<!--  INICIO GLOBO BLANCO   -->
									<!--  INICIO GLOBO BLANCO   -->
									<div class="globo_blanco globito flotder">
										<div class="globo_blanco_01">
											<div class="globo_blanco_02">
												<div class="globo_blanco_03">	<!--  INICIO Fila de Campos   -->
								<!--  INICIO Fila de Campos   -->
												<c:set var="textos" value="${ambito.textos }"/>
												<c:set var="longAmbito" value="${ fn:length(textos) }"/>				
												<logic:iterate id="contenido" name="textos" indexId="j">
														<!--anclas-->
														<c:choose>
									                        <c:when test="${j== fn:length(textos)-1}">   
										                     <a id="contAmbitos-${i}"></a>
									                        </c:when>
									                    </c:choose>	
														<a id="contAmbito-${j}-${i}"></a>
														<!--fin de anclas-->	
													<c:set var="indice" value="${j + longAmbitoAnterior}"/>
													<div class="fila_de_tabla_especial_03">
														<div class="contenedor_izquierda_esp">
															<div class="text">
																<label for="Ambito01" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloAmbito"/>:</label>
	  															<html:text styleClass="input_medio_largo input_mder" property="Amb${i}_Tex${j}" value="${contenido.texto}" styleId="Ambito${i}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaAmbito" />
															</div>
														</div>
														<div class="contenedor_izquierda_esp">
															<div class="text">
																<label for="Idio05" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloIdioma"/>:</label>
																<bean:define id="ambito"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
																<cat:select name="form" property="Amb${i}_Idio${j}" value="${contenido.idioma}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq_n inp_se_ie" estiloOscuro="oscura" title="${ambito}"/>
																
															</div>
														</div>
														<div class="float_izquierda_n">
															<c:choose>
																<c:when test="${j==0}">   
																	<span class="oculto">-</span> 
																	<input class="boton_anadir cms_ie" type="submit" name="accion_Añadir ContAmbito-${i}" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
																	
																
																</c:when>
																<c:otherwise>
																	&nbsp;
																</c:otherwise>
															</c:choose>
														</div>
														<div class="float_izquierda_n">
															<c:set var="longitud" value="${ longAmbito }"/>
															<c:choose>
																<c:when test="${longitud>1}">   
																	<span class="oculto">-</span>
																	<input class="boton_eliminar cms_ie" type="submit" name="accion_Eliminar ContAmbito-${j}-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
																	
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
					<!--  Fin Fila de Campos   -->
												</div>
											</div>
										</div>
									</div>	
									</div>	
	<!-- end bubble -->
								<!--  Enlaces de fuera   -->
								<div class="flotder">
									<c:choose>
							        <c:when test="${i==0}">   
									<span class="oculto">-</span>	
									<span class="flotder enlace_anadir_02">
										<input class="boton_anadir flotder" type="submit" name="accion_Añadir Ambitos" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
										
									</span>
							        </c:when>
									<c:otherwise>
									<span class="oculto">-</span>	
									<span class="flotder enlace_anadir_02">
							        	&nbsp;
							        </span>
									</c:otherwise>
							        </c:choose>	
							        
									<c:set var="longitud" value="${ fn:length(form.ambitos) }"/>
									<c:choose>
									<c:when test="${longitud>1}">   
								    <span class="oculto">-</span>	
								    <span class="flotder enlace_eliminar_02">
								    	<input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Ambitos-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
										 
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
	



<!--  start bubble -->
<div class="lb_bubble_topleft conmargen">
<div class="lb_bubble_bottomleft">
<div class="lb_bubble_topright">
<div class="lb_bubble_bottomright">
<div class="lb_bubble_content">
	<!--  INICIO CAJA DE FORMULARIO ESTRUCTURA  -->
	<div class="formu" >
					
	<h3><bean:message key="catalogadorAvanzado.General.Estructura"/></h3>
	<!--  INICIO GLOBO Blanco   -->
	<div class="globo_blanco pos_relative conmargen" >
	<div class="globo_blanco_01">
	<div class="globo_blanco_02">
	<div class="globo_blanco_03">
	<!--  INICIO Fila de Campos   -->
	<div class="fila_de_tabla_especial_03" >
  	<div class="contenedor_izquierda_esp" >
  		<div class="text">
	  		<label for="Est022" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloEstructura"/>:</label>
	  		<bean:define id="estruc"><bean:message key="catalogadorAvanzado.SeleccioneEstructura"/></bean:define>
			<cat:select name="form" property="estructura" value="${form.estructura}" backingList="${form.estructuraBackingList}" estiloSelect="select_lrg" estiloOscuro="oscura" title="${estruc}"/>
		
		</div>
	</div>
	<div class="limpiar"></div>
	<br class="oculto" />
	</div>	
	<!--  fIN Fila de Campos   -->
	</div>
	</div>
	</div>
	</div>
	</div>
	<!--  FIN CAJA DE FORMULARIO  ESTRUCTURA -->
</div>
</div>
</div>
</div>
</div>
<!--  end bubble -->

<!--  start bubble -->
<div class="lb_bubble_topleft conmargen">
<div class="lb_bubble_bottomleft">
<div class="lb_bubble_topright">
<div class="lb_bubble_bottomright">
<div class="lb_bubble_content">
	<!--  INICIO CAJA DE FORMULARIO NIVEL AGREGACION  -->
	<div class="formu" >
					
	<h3><bean:message key="catalogadorAvanzado.General.NivelAgregacion"/></h3>
	<!--  INICIO GLOBO Blanco   -->
	<div class="globo_blanco pos_relative conmargen" >
	<div class="globo_blanco_01">
	<div class="globo_blanco_02">
	<div class="globo_blanco_03">
	<!--  INICIO Fila de Campos   -->
	<div class="fila_de_tabla_especial_03" >
  	<div class="contenedor_izquierda_esp" >
  	<div class="text">
  		<label for="Nivel025" class="oculto" ><bean:message key="catalogadorAvanzado.General.SoloNivel"/>:</label>
  		<bean:define id="nivel"><bean:message key="catalogadorAvanzado.SeleccioneNivelAgregacion"/></bean:define>
  		<cat:select name="form" property="nivelAgregacion" value="${form.nivelAgregacion}" backingList="${form.nivelAgregacionBackingList}" estiloSelect="select_lrg" estiloOscuro="oscura" title="${nivel}"/>
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
				
	<!--  FIN CAJA DE FORMULARIO   NIVEL AGREGACION-->
</div>
</div>
</div>
</div>
</div>
<!--  end bubble -->

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->


<fieldset class="tipo ft_centrada"> 

<div class="packer_reset">
 <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 <a href='javascript:doSubmit("mainform", "<bean:message key="general.Reset"/>");'><bean:message key="general.Reset"/></a>
 </div></div></div></div></div>
</div>

<div class="packer_accept">
 <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 <a href='javascript:doSubmit("mainform", "<bean:message key="general.Aceptar"/>");'><bean:message key="general.Aceptar"/></a>
 </div></div></div></div></div>
</div>
<div class="packer_cancel">
 <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 <a href='javascript:doSubmit("mainform", "<bean:message key="general.Cancelar"/>");'><bean:message key="general.Cancelar"/></a>
 </div></div></div></div></div>
</div>

<div class="packer_validate">
 <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 <a href='javascript:doSubmit("mainform", "<bean:message key="general.Validar"/>");'><bean:message key="general.Validar"/></a>
 </div></div></div></div></div>
</div>

</fieldset>


<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
</div>
<!-- Fin plantilla contenido  -->
</tiles:put>

</tiles:insert>



