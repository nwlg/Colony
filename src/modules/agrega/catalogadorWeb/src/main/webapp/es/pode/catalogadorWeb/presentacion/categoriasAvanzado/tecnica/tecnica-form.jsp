<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tlds/tags-catalogador.tld" prefix="cat" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/> 
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/tecnica/tecnica-form-vars.jspf" %>

<!-- Inicio plantilla contenido  -->
<!-- Inicio plantilla contenido  -->
	<div class="plantilla_contenido" id="rea">
	<jsp:include page="/layout/messages.jsp" flush="true"/>
	<h2><bean:message key="catalogadorAvanzado.Tecnica"/></h2>		
	<form method="post" action="<html:rewrite action="/Tecnica/TecnicaFormAccionSubmit"/> " >		
		<p class="parrafo_comun" id="separacion2"><bean:message key="catalogadorAvanzado.Tecnica.TextoObligacion"/></p>				
		<input type="hidden" id="seleccionar" name="seleccionar" value="<bean:write name="form" property="accion"/>"/> 
<script type="text/javascript">
function seleccionarCampo() {
	ancla=document.getElementById('seleccionar').value;
	if (ancla != null) {
		var partes = new Array();
		partes=ancla.split("-");
		
		if(partes[0] == "Añadir Localizacion"){
			document.location.href="#localizacion";
		}
		else if(partes[0]=="Eliminar Localizacion"){
			document.location.href="#localizacion";
		}
		else if(partes[0]=="Añadir Formato"){
			document.location.href="#formato";
		}
		else if(partes[0]=="Eliminar Formato"){
			document.location.href="#formato";
		}
		else if(partes[0]=="Añadir MasRequerimientos"){
			document.location.href="#masRequerimientos";
		}
		else if(partes[0]=="Eliminar MasRequerimientos"){
			document.location.href="#masRequerimientos";
		}
		else if(partes[0]=="Añadir Instalacion"){
			document.location.href="#instalacion";
		}
		else if(partes[0]=="Eliminar Instalacion"){
			document.location.href="#instalacion";
		}
		else if(partes[0]=="Añadir DescDuracion"){
			document.location.href="#descDuracion";
		}
		else if(partes[0]=="Eliminar DescDuracion"){
			indice = partes[1];
			if(indice>0){
				indice = indice -1;
			}
			document.location.href="#descDuracion-"+indice;
		}
		else if(partes[0]=="Añadir Requerimiento"){
			document.location.href="#requerimiento";
		}
		else if(partes[0]=="Eliminar Requerimiento"){
			indice = partes[1];
			if(indice>0){
				indice = indice -1;
			}
			document.location.href="#requerimiento-"+indice;
		}
		else if(partes[0]=="Añadir AgregadorOR"){
			indice = partes[1];//indice de la contribucion
			document.location.href="#agregadorOR-"+indice;
		}
		else if(partes[0]=="Eliminar AgregadorOR"){
			indice1 = partes[1];//indice de la contribucion
			indice2 = partes[2];//indice dentro de la entidad
			if(indice2>0){
				indice2 = indice2 -1;
			}
			document.location.href="#agregadorOR-"+indice1+"-"+indice2;
		}	
	}
}
function nombreRequisitos(nombreR,tipoRequisito){
      //se cargan los valores en combo nombre segun el valor seleccionado en el combo tipo
      var form = document.forms[0];
      cTipo = form.elements[tipoRequisito].options;
      nombre = form.elements[nombreR];
      var nombreOculto = form.elements["H"+nombreR];
 
      var indiceTipo=cTipo.selectedIndex;
      tipo=cTipo[indiceTipo].value;
      
      var indice=nombre.selectedIndex;
      
      seleccion="";
      if(indice >-1){
            seleccion = nombre.options[indice].value;
      }
      
      //combo oculto con todas las opciones tanto las del navegador como las de sistema operativo
      var opcionesOcultas = nombreOculto.options;
      
      //borramos el combo
      while(nombre.hasChildNodes()) nombre.removeChild(nombre.lastChild);
      
      //añadimos opcion vacía
      opcion = document.createElement('option');
      opcion.setAttribute("value","");
      opcion.setAttribute("text","");
      opt = nombre.appendChild(opcion);
      
      if(tipo == "4.4.1.1.2"){//NAVEGADOR
 
            oscura=true;
            clase="";
            var j=0;
            //recorremos el combo oculto que contiene todos los valores y cargamos, en el combo
            //que sera visible, los valores que correspondan en este casos  los del NAVEGADOR
            for(var i=0;i<nombreOculto.length;i++){
                  
                  valor=opcionesOcultas[i].value;
                  texto=opcionesOcultas[i].text;                 
                  
                  if(valor=="4.4.1.2.8" || valor=="4.4.1.2.9" || valor=="4.4.1.2.10" || valor=="4.4.1.2.11" || valor=="4.4.1.2.12"
                  || valor=="4.4.1.2.13"){
                        opcion = document.createElement('option');
                        opcion.setAttribute("value",valor);
                        if(oscura){
                             oscura=false;
                             clase="oscura";
                        }
                        else{
                             oscura=true;
                             clase="";
                        }
                        opcion.className=clase;
                        if(seleccion==valor){
                             opcion.setAttribute("selected","selected");
                        }
                        opcion.appendChild(document.createTextNode(texto));
                        opt = nombre.appendChild(opcion);
                  }
            }
      }
      else if(tipo == "4.4.1.1.1"){//SISTEMA OPERATIVO
 
            
            oscura=true;
            clase="";
            var j=0;
            //recorremos el combo oculto que contiene todos los valores y cargamos, en el combo
            //que sera visible, los valores que correspondan en esta casos  los del SISTEMA OPERATIVO   
            for(var i=0;i<nombreOculto.length;i++){
                  
                  valor=opcionesOcultas[i].value;
                  texto=opcionesOcultas[i].text;
                                         
                  if(valor=="4.4.1.2.1" || valor=="4.4.1.2.2" || valor=="4.4.1.2.3" || valor=="4.4.1.2.4" || valor=="4.4.1.2.5"
                  || valor=="4.4.1.2.6" || valor=="4.4.1.2.7"){
                        opcion = document.createElement('option');
                        opcion.setAttribute("value",valor);
                        if(oscura){
                             oscura=false;
                             clase="oscura";
                        }
                        else{
                             oscura=true;
                             clase="";
                        }
                        opcion.className=clase;
                        if(seleccion==valor){
                             opcion.setAttribute("selected","selected");
                        }
                        opcion.appendChild(document.createTextNode(texto));
                        opt = nombre.appendChild(opcion);
                  }
            }
      }
} // fin fun
 
function limpiaNombre(nomb){
      var form = document.forms[0];
      nombre = form.elements[nomb];
      nombre.value="";
}
 
function iniciaAgregadores(){
//inicializamos todos los combos tipo y nombre
//cargamos los valores adecuados para el valor seleccionado en el combo
      var form = document.forms[0]; 
      var tipo="";
      var nombre="";
      var noEnc=true;
      var cad="";
      for(var i=0;i<form.elements.length;i++){
            tipo= form.elements[i].name;
            if((tipo != undefined) && (tipo.substring(0,4) == "Tipo")){//buscamos el indice del tipo
            	  var aux=tipo.substring(4,tipo.length);
                  var partes = new Array();
                  partes = aux.split("_");
                  nRequisitoT=partes[0];
                  nAgregadorT=partes[1];
                  // buscamos el nombre que le corresponde al tipo encontrado
                  for(var j=0;j<form.elements.length && noEnc;j++){ 
                        nombre= form.elements[j].name;
                        if(nombre.substring(0,3)=="Nom"){
                             var aux2=nombre.substring(3,nombre.length);
                             var partesN = new Array();
                             partesN = aux2.split("_");
                             //si lo encontramos llamamos al metodo nombreRequisito para que carge los valores
                             //adecuado en los combos
                             if(nRequisitoT==partesN[0] && nAgregadorT==partesN[1]){
                                   nombreRequisitos(nombre,tipo);
                                   noEnc=false;
                             }
                        }     
                  }
                  noEnc=true;       
            }
      }
}


function inicio(){
	seleccionarCampo();
	iniciaAgregadores();
}
	
window.onload=inicio;
</script>

		
		<a id="formato"></a>
		<!--  INICIO GLOBO GRIS Formato  -->
		<!--  INICIO GLOBO GRIS Formato   -->
		<div class="globo_gris conmargen"  >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					<!--  INICIO CAJA DE FORMULARIO   -->
						<div class="formu" >
						<h3><bean:message key="catalogadorAvanzado.Tecnica.Formato"/></h3>
		<!--  INICIO GLOBO Blanco   -->
		<!--  INICIO GLOBO Blanco   -->
<logic:iterate id="formato" name="formatos" indexId="i">
	<div class="globo_blanco globito flotder" >
		<div class="globo_blanco_01">
			<div class="globo_blanco_02">
				<div class="globo_blanco_03">
									<!--  INICIO Fila de Campos   -->
									<!--  INICIO Fila de Campos   -->
									
					<div class="fila_de_tabla_especial_03" >
		  				<div class="contenedor_izquierda_esp" >
						  	<div class="text">
						  		<label for="form" class="oculto" ><bean:message key="catalogadorAvanzado.Tecnica.SoloFormato"/>:</label>
						  		<bean:define id="format"><bean:message key="catalogadorAvanzado.SeleccioneFormato"/></bean:define>
						  		<cat:select name="form" property="Form${i}" value="${formato.texto}" backingList="${form.formatosBackingList}" estiloSelect="select_lrg" estilo="width:420px !important" estiloOscuro="oscura" title="${format}"/>
						  	</div>
		 				</div>
		 			</div>
					<div class="limpiar"></div>
					<br class="oculto" />
		 		</div>
		 	</div>
		 </div>
	</div>
	<div class="flotder">
		<c:choose>
           <c:when test="${i==0}">   
               <span class="oculto">-</span> 
                <span class="flotder enlace_anadir_02">
                <input class="boton_anadir flotder" type="submit" name="accion_Añadir Formato" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
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
		<c:set var="longitud" value="${ fn:length(form.formatos) }"/>
			<c:choose>
                      <c:when test="${longitud>1}">   
       				            <span class="oculto">-</span>
       				            <span class="flotder enlace_eliminar_02"> 
       				             <input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Formato-${i}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/>  
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
						<!--  Fin Fila de Campos   -->
						<!--  Fin Fila de Campos   -->
		
						<!--  FIN GLOBO BLANCO   -->
						<!--  FIN GLOBO BLANCO   -->

					</div>
		<!--  FIN CAJA DE FORMULARIO   -->
					</div>
				</div>
			</div>
		</div>
		<!--  FIN GLOBO GRIS Formato  -->
		<!--  FIN GLOBO GRIS Formato  -->
		
		<!--  INICIO GLOBO GRIS Tamaño  -->
		<!--  INICIO GLOBO GRIS Tamaño  -->
		<div class="globo_gris conmargen"  >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
		
					<div class="globo_gris_03">
					<!--  INICIO CAJA DE FORMULARIO   -->
					<div class="formu" >
							
							<h3><bean:message key="catalogadorAvanzado.Tecnica.Tamaño"/></h3>
		<!--  INICIO GLOBO Blanco   -->
		<!--  INICIO GLOBO Blanco   -->
					<div class="globo_blanco pos_relative conmargen" >
						<div class="globo_blanco_01">
							<div class="globo_blanco_02">
		
								<div class="globo_blanco_03">
									<!--  INICIO Fila de Campos   -->
									<!--  INICIO Fila de Campos   -->
								<div class="fila_de_tabla_especial_03" >
		  					<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="form" class="oculto" ><bean:message key="catalogadorAvanzado.Tecnica.SoloTamaño"/>:</label>
		  						<html:text styleClass="input_medio" property="Tam" value="${tamanio}" styleId="Tam" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaTamano" />
								</div>
		
							</div>
							<div class="limpiar"></div>
							<br class="oculto" />
						</div>	
						<!--  FIn Fila de Campos   -->
						<!--  fIN Fila de Campos   -->
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
		<!--  FIN GLOBO GRIS  Tamaño  -->
		<!--  FIN GLOBO GRIS Tamaño  -->
		
		<!--  INICIO GLOBO GRIS   -->
		<!--  INICIO GLOBO GRIS   -->
		<a id="localizacion"></a>
		<div class="globo_gris conmargen"  >
		
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					<!--  INICIO CAJA DE FORMULARIO   -->
					<div class="formu" >
					<h3><bean:message key="catalogadorAvanzado.Tecnica.Localizacion"/></h3>
		<!--  INICIO GLOBO Blanco   -->
		<!--  INICIO GLOBO Blanco   -->
		<logic:iterate id="localiza" name="localizacion" indexId="j">
					<div class="globo_blanco globito flotder" >
		
						<div class="globo_blanco_01">
							<div class="globo_blanco_02">
								<div class="globo_blanco_03">
								
									<!--  INICIO Fila de Campos   -->
									<!--  INICIO Fila de Campos   -->
									
					<div class="fila_de_tabla_especial_03" >
		  					<div class="contenedor_izquierda_esp" >
		  						<div class="text">
		  							<label for="form" class="oculto" ><bean:message key="catalogadorAvanzado.Tecnica.SoloLocalizacion"/>:</label>
		  							<html:text styleClass="input_medio" style="width:420px !important" property="Loc${j }" value="${localiza.texto}" styleId="Loc${j }" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaLocalizacion" />
		  						</div>
		
		 					</div>
		 					<div class="limpiar"></div>
							<br class="oculto" />
		 			</div>
		 						</div>
		 					</div>
		 				</div>
		 			</div>
							<div class="flotder">
								<c:choose>
		               				<c:when test="${j==0}">   
			                        	<span class="oculto">-</span> 
			                        	<span class="flotder enlace_anadir_02">
			                        	<input class="boton_anadir flotder" type="submit" name="accion_Añadir Localizacion" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
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
								<c:set var="longitud" value="${ fn:length(form.localizacion) }"/>
								<c:choose>
			                        <c:when test="${longitud>1}">   
		          				            <span class="oculto">-</span> 
		          				            <span class="flotder enlace_eliminar_02">
		          				             <input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Localizacion-${j}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/>
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
									
						<!--  Fin Fila de Campos   -->
						<!--  Fin Fila de Campos   -->
						</logic:iterate>
					</div>
				</div>
		
			</div>
		</div>
		</div>
		<!--  FIN CAJA DE FORMULARIO   -->

		<!--  FIN GLOBO GRIS Localizacion   -->
		<!--  FIN GLOBO GRIS Localizacion  -->
		
		<!--  INICIO GLOBO GRIS Requerimiento  -->
		
		<!--  INICIO GLOBO GRIS Requerimiento  -->
		<div class="globo_gris conmargen pos_relative"  >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					
					<!--  INICIO CAJA DE FORMULARIO   -->
					<div id="formulario_02" >
							
							<h3><bean:message key="catalogadorAvanzado.Tecnica.Requerimientos"/></h3>
							<logic:iterate id="requerimientos" name="requerimiento" indexId="k">
									<!--anclas-->
									<c:choose>
				                        <c:when test="${k== fn:length(form.requerimiento)-1}">   
					                     <a id="requerimiento"></a>
				                        </c:when>
				                    </c:choose>	
									<a id="requerimiento-${k}"></a>
									<!--fin de anclas-->
							
							
							<!--  Enlaces de fuera   -->
		
										<!--  Enlaces de fuera   -->
											<div class="pos_relative" id="flotantederecha">
											<span class="oculto">-</span>
												<c:choose>
					               				<c:when test="${k==0}">   
						                        	
						                        	<span class="flotder enlace_anadir_04"> 
						                        	<input class="boton_anadir flotder" type="submit" name="accion_Añadir Requerimiento" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
						        					</span>
					            				 </c:when>
					                        		<c:otherwise>
					            					    	&nbsp;
					                        		</c:otherwise>
				               					 </c:choose>	
											
												<c:set var="longitud" value="${ fn:length(form.requerimiento) }"/>
												<span class="oculto">-</span>
												<c:choose>
							                        <c:when test="${longitud>1}">   
						          				            
						          				            <span class="flotder enlace_eliminar_04"> 
						          				             <input class="boton_eliminar flotder" type="submit" name="accion_Eliminar Requerimiento-${k}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
									    				 </span>
							                        </c:when>
						             				        <c:otherwise>
						                      				&nbsp;
							                        </c:otherwise>
								                </c:choose>				
												
											</div>
		
											<!--  Fin Enlaces de fuera   -->
										<!--  Fin Enlaces de fuera   -->
										
		<!--  INICIO GLOBO Blanco   -->
		<!--  INICIO GLOBO Blanco   -->
					<div class="globo_blanco pos_relative conmargen" id="rail">
						<div class="globo_blanco_01" >
							<div class="globo_blanco_02">
								<div class="globo_blanco_03">
									<h3 class="int_h3"><bean:message key="catalogadorAvanzado.Tecnica.AgregadorOR"/></h3>
									<c:forEach items="${requerimientos.agregadoresOR }" var="agregador" varStatus="status">
										<cat:select name="form" estilo="visibility: hidden;" property="HNom${k }_${status.index}" value="${nombre.valor}" backingList="${form.comboNombreBackingList}" estiloSelect="input_medio" estiloOscuro="oscura" title=""/>								
										<!--anclas-->
										<c:choose>
					                        <c:when test="${status.index == fn:length(requerimientos.agregadoresOR) -1}">   
						                     <a id="agregadorOR-${k}"></a>
					                        </c:when>
					                    </c:choose>	
										<a id="agregadorOR-${k}-${status.index}"></a>
										<!--fin de anclas-->											
									<!--  INICIO GLOBO GRIS   -->
									<!--  INICIO GLOBO GRIS   -->
											<div class="globo_gris globito5 flotder pos_relative"  >
												<div class="globo_gris_01">
													<div class="globo_gris_02">
														<div class="globo_gris_03">
									<!--  INICIO Fila de Campos   -->
									<!--  INICIO Fila de Campos   -->
								<div class="fila_de_tabla_especial_02" >
		
		  					<div class="contenedor_izquierda_esp lab_igual">
		  						<div class="text"><label for="form" ><bean:message key="catalogadorAvanzado.Tecnica.SoloTipo"/>:</label></div>
		 					</div>
							<div class="contenedor_izquierda_esp" >
								<div class="text">
									<c:set var="tipo" value="${agregador.tipo }"/>
							  		<bean:define id="tipe"><bean:message key="catalogadorAvanzado.SeleccioneTipo"/></bean:define>
									<cat:select name="form" onchange="nombreRequisitos('Nom${k }_${status.index}','Tipo${k }_${status.index}')" property="Tipo${k }_${status.index}" value="${tipo.valor}" backingList="${form.comboTipoBackingList}" estiloSelect="input_medio" estiloOscuro="oscura" title="${tipe}"/>								
									
								</div>
							</div>
							<div class="limpiar"></div>
							<br class="oculto" />
						</div>	
						<!--  Fin Fila de Campos   -->
		
						<!--  Fin Fila de Campos   -->
						<!--  INICIO Fila de Campos   -->
						<!--  INICIO Fila de Campos   -->
						<!--  INICIO Fila de Campos   -->
									<!--  INICIO Fila de Campos   -->
								<div class="fila_de_tabla_especial_02" >
		  					<div class="contenedor_izquierda_esp lab_igual">
		  						<div class="text"><label for="form" ><bean:message key="catalogadorAvanzado.Tecnica.SoloNombre"/>:</label></div>
		
		 					</div>
							<div class="contenedor_izquierda_esp" >
								<div class="text">
									<c:set var="nombre" value="${agregador.nombre }"/>
									<bean:define id="nombr"><bean:message key="catalogadorAvanzado.SeleccioneNombre"/></bean:define>
									<cat:select name="form" property="Nom${k }_${status.index}" value="${nombre.valor}" backingList="${form.comboNombreBackingList}" estiloSelect="input_medio" estiloOscuro="oscura" title="${nombr}"/>
		
								</div>

							</div>
							<div class="limpiar"></div>
							<br class="oculto" />
						</div>	
						<!--  Fin Fila de Campos   -->
						<!--  INICIO Fila de Campos   -->
									<!--  INICIO Fila de Campos   -->
								<div class="fila_de_tabla_especial_02" >
		
		  					<div class="contenedor_izquierda_esp lab_igual">
		  						<div class="text"><label for="VersMin01" ><bean:message key="catalogadorAvanzado.Tecnica.SoloVersionMinima"/>:</label></div>
		 					</div>
							<div class="contenedor_izquierda_esp" >
								<div class="text">
									<c:set var="minimo" value="${agregador.versionMin }"/>
									<html:text styleClass="input_medio" property="Mini${k }_${status.index}" value="${minimo.texto}" styleId="Mini${k }_${status.index}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaMinima" />
								</div>
							</div>
		
							<div class="limpiar"></div>
							<br class="oculto" />
						</div>	
						<!--  Fin Fila de Campos   -->
						<!--  INICIO Fila de Campos   -->
									<!--  INICIO Fila de Campos   -->
								<div class="fila_de_tabla_especial_02" >
		  					<div class="contenedor_izquierda_esp lab_igual">
		  						<div class="text"><label for="VersMax01" ><bean:message key="catalogadorAvanzado.Tecnica.SoloVersionMaxima"/>:</label></div>
		
		 					</div>
							<div class="contenedor_izquierda_esp" >
								<div class="text">
									<c:set var="maximo" value="${agregador.versionMax }"/>
									<html:text styleClass="input_medio" property="Max${k }_${status.index}" value="${maximo.texto}" styleId="Max${k }_${status.index}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaMaxima" />
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
		<!--  FIN GLOBO GRIS   -->
		<!--  FIN GLOBO GRIS   -->
			<!--  Enlaces de fuera   -->
											<div class="flotder pos_relative" >
												  <span class="oculto">-</span>
												  <span class="flotder enlace_anadir_02">
						                        	<c:choose>
					               				<c:when test="${status.index==0}">   
						                        	
						                        	 
						                        	<input class="boton_anadir flotder" type="submit" name="accion_Añadir AgregadorOR-${k }" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
						        					
					            				 </c:when>
					                        		<c:otherwise>
					            					    	&nbsp;
					                        		</c:otherwise>
				               					 </c:choose>	
				               					 </span>
											</div>
											<div class="flotder pos_relative" >
												<c:set var="longitud" value="${ fn:length(requerimientos.agregadoresOR ) }"/>
												<span class="oculto">-</span>
												<span class="flotder enlace_eliminar_02"> 
												<c:choose>
							                        <c:when test="${longitud>1}">   
						          				            
						          				            
						          				             <input class="boton_eliminar flotder" type="submit" name="accion_Eliminar AgregadorOR-${k }-${status.index}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
									    				 
							                        </c:when>
						             				        <c:otherwise>
						                      				&nbsp;
							                        </c:otherwise>
								                </c:choose>				
							                      </span>  
											</div>
											<!--  Fin Enlaces de fuera   -->
										<!--  Fin Enlaces de fuera   -->
		
									<div class="limpiar"></div>
		</c:forEach>
		
						</div>
				</div>
			</div>
		</div>
		<!--  FIN GLOBO BLANCO   -->
		<!--  FIN GLOBO BLANCO   -->
		</logic:iterate>
		</div>
		<!--  FIN CAJA DE FORMULARIO   -->
					</div>
				</div>
			</div>
		
		</div>
		<!--  FIN GLOBO GRIS  Requerimiento -->
		<!--  FIN GLOBO GRIS Requerimiento  -->
		
		<!--  INICIO GLOBO GRIS Notas de InstalaciOn  -->
		<!--  INICIO GLOBO GRIS Notas de InstalaciOn  -->
		<a id="instalacion"></a>
		<div class="globo_gris pos_relative conmargen" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					
					<!--  INICIO CAJA DE FORMULARIO   -->
					<div id="formulario" >
		
					
					<h3><bean:message key="catalogadorAvanzado.Tecnica.NotasDeInstalacion"/></h3>
					<!--  INICIO GLOBO Blanco   -->
					<!--  INICIO GLOBO Blanco   -->
					<div class="globo_blanco" >
						<div class="globo_blanco_01">
							<div class="globo_blanco_02">
							<div class="globo_blanco_03">
						<!-- -->
		
						<!--  INICIO Fila de Campos   -->
						<!--  INICIO Fila de Campos   -->
						<logic:iterate id="instalacion" name="descripcionInstalacion" indexId="l">	
							<c:set var="textos" value="${instalacion.textos }"/>
							<logic:iterate id="texto" name="textos" indexId="m">	
								<div class="fila_de_tabla_especial" style="padding-left:0 !important">
		  							<div class="contenedor_izquierda_esp">
		  								<div class="text"><label for="Not01" ><bean:message key="catalogadorAvanzado.Tecnica.SoloDescripcion"/>:</label></div>
		 							</div>
									<div class="contenedor_izquierda_esp" >
										<div class="text"><label for="Desc${m} }" class="oculto" ><bean:message key="catalogadorAvanzado.Tecnica.SoloNotasDeInstalacion"/>:</label>
		  									<html:text styleClass="input_largo input_mder" property="InsTex${m}" value="${texto.texto}" styleId="InsTex${m}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaDescripcion" />
		  								</div>
									</div>
							<div class="contenedor_izquierda_esp" >
								<div class="text">
									<label for="Idio01" class="oculto" ><bean:message key="catalogadorAvanzado.Tecnica.SoloIdioma"/>:</label>
									<bean:define id="notas"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
									<cat:select name="form" property="InsIdio${m}" value="${texto.idioma}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq_n inp_se_ie" estiloOscuro="oscura" title="${notas}"/>
									
								</div>
							</div>
							<div class="float_izquierda_n">
							<c:choose>
		                   		<c:when test="${m==0}">   
							    	<span class="oculto">-</span> 
			                        <input class="boton_anadir cms2" type="submit" name="accion_Añadir Instalacion" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
							        
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
			            			<input class="boton_eliminar cms2" type="submit" name="accion_Eliminar Instalacion-${m}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
							        
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
		<!--  INICIO GLOBO GRIS Mas Requerimientos-->
		<!--  INICIO GLOBO GRIS Mas Requerimientos-->
		<a id="masRequerimientos"></a>
		<div class="globo_gris pos_relative conmargen" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">					
					<!--  INICIO CAJA DE FORMULARIO   -->
						<div id="formulario" >
							<h3><bean:message key="catalogadorAvanzado.Tecnica.MasRequerimientos"/></h3>
								<!--  INICIO GLOBO Blanco   -->
								<!--  INICIO GLOBO Blanco   -->
									<div class="globo_blanco" >
										<div class="globo_blanco_01">
											<div class="globo_blanco_02">
												<div class="globo_blanco_03">								
													<!--  INICIO Fila de Campos   -->
													<logic:iterate id="requerimiento" name="descripcionRequerimientos" indexId="n">	
														<c:set var="textos" value="${requerimiento.textos }"/>
														<logic:iterate id="texto" name="textos" indexId="p">
															<div class="fila_de_tabla_especial" style="padding-left:0 !important">		
			  													<div class="contenedor_izquierda_esp">
			  														<div class="text">
				  														<label for="Not01" >
				  															<bean:message key="catalogadorAvanzado.Tecnica.SoloDescripcion"/>:
				  														</label>
			  														</div>
			 													</div>
																<div class="contenedor_izquierda_esp" >
																	<div class="text">
																		<label for="Desc${p} }" class="oculto" >
																			<bean:message key="catalogadorAvanzado.Tecnica.SoloMasRequerimientos"/>:
																		</label>
																		<html:text styleClass="input_largo input_mder" property="MasReqTex${p}" value="${texto.texto}" styleId="MasReqTex${p}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaDescripcion" />
																	</div>
																</div>
			
																<div class="contenedor_izquierda_esp" >
																	<div class="text">
																		<label for="Idio01" class="oculto" >
																			<bean:message key="catalogadorAvanzado.Tecnica.SoloIdioma"/>:
																		</label>
																		<bean:define id="mas"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
																		<cat:select name="form" property="MasReqIdio${p}" value="${texto.idioma}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq_n inp_se_ie" estiloOscuro="oscura" title="${mas}"/>
																				
																	</div>
																</div>
																<div class="float_izquierda_n">
																	<c:choose>
												                   		<c:when test="${p==0}">   
																	    	<span class="oculto">-</span> 
													                        <input class="boton_anadir cms_ie" type="submit" name="accion_Añadir MasRequerimientos" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
																	        
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
													            			<input class="boton_eliminar cms_ie" type="submit" name="accion_Eliminar MasRequerimientos-${p}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
																	        
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
		
		
		
		<!--  INICIO GLOBO GRIS  DURACION  -->
		<!--  INICIO GLOBO GRIS  DURACION  -->
		<div class="globo_gris pos_relative conmargen" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					<!--  INICIO CAJA DE FORMULARIO   -->
		
					<div class="formu" >
					
					<h3><bean:message key="catalogadorAvanzado.Tecnica.Duracion"/></h3>
		<!--  INICIO GLOBO Blanco   -->
		<!--  INICIO GLOBO Blanco   -->
					<div class="globo_blanco pos_relative conmargen" >
						<div class="globo_blanco_01">
							<div class="globo_blanco_02">
								<div class="globo_blanco_03">
									<!--  INICIO Fila de Campos   -->		
									<!--  INICIO Fila de Campos   -->
								<div class="fila_de_tabla_especial_03" >
		  					<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="AnioDur" class="rdr" ><bean:message key="catalogadorAvanzado.Tecnica.Aino"/>:</label>
									<html:text styleClass="in_peq input_mder2 acentrado" property="Anyos" value="${anyo}" styleId="Anyos" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaAno"/>
								</div>
							</div>
							<div class="contenedor_izquierda_esp" >
		
		  						<div class="text"><label for="MesDur" class="rdr" ><bean:message key="catalogadorAvanzado.Tecnica.Mes"/>:</label>
									<html:text styleClass="in_peq input_mder2 acentrado" property="Meses" value="${mes}" styleId="Meses"  onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaMes"/>
								</div>
							</div>
							<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="DiaDur" class="rdr" ><bean:message key="catalogadorAvanzado.Tecnica.Dia"/>:</label>
								<html:text styleClass="in_peq input_mder2 acentrado" property="Dias" value="${dia}" styleId="Dias" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaDia"/>
								</div>
		
							</div>
							<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="HoraDur" class="rdr" ><bean:message key="catalogadorAvanzado.Tecnica.Hora"/>:</label>
								<html:text styleClass="in_peq input_mder2 acentrado" property="Horas" value="${hora}" styleId="Horas"  onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaHora"/>
								</div>
							</div>
							<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="MinutosDur" class="rdr" ><bean:message key="catalogadorAvanzado.Tecnica.Minutos"/>:</label>
		
									<html:text styleClass="in_peq input_mder2 acentrado" property="Minutos" value="${minutos}" styleId="Minutos" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaMinutos"/>
								</div>
							</div>
							<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="SegundosDur" class="rdr" ><bean:message key="catalogadorAvanzado.Tecnica.Segs"/>:</label>
								<html:text styleClass="in_peq input_mder2 acentrado" property="SegundosP1" value="${segundosP1}" styleId="SegundosP1"  onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaSegundos"/>
								</div>
							</div>
		
							<div class="contenedor_izquierda_esp " >
							<div class="text input_mder2">.</div>
							</div>
							<div class="contenedor_izquierda_esp" >
		  						<div class="text"><label for="SegundosDur2" class="oculto" ><bean:message key="catalogadorAvanzado.Tecnica.Segundos"/>:</label>
								<html:text styleClass="in_peq input_mder2 acentrado" property="SegundosP2" value="${segundosP2}" styleId="SegundosP2"  onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaSegundos"/>
								</div>
							</div>
		
							<div class="limpiar"></div>
							<br class="oculto" />
						</div>	
						<!--  FIn Fila de Campos   -->
						<!--  fIN Fila de Campos   -->
						</div>
				</div>
			</div>
		</div>
		<!--  FIN GLOBO BLANCO   -->		
		<!--  FIN GLOBO BLANCO   -->
		
				<!--  INICIO GLOBO Blanco   -->
					<!--  INICIO GLOBO Blanco   -->
					<div class="globo_blanco pos_relative" >
						<div class="globo_blanco_01">
							<div class="globo_blanco_02">
							<div class="globo_blanco_03">
						<!-- -->
						<!--  INICIO Fila de Campos   -->
		
						<!--  INICIO Fila de Campos   -->
						<logic:iterate id="descDur" name="descripcionDuracion" indexId="i">	
						<c:set var="textos" value="${descDur.textos }"/>
							<logic:iterate id="texto" name="textos" indexId="j">
									<!--anclas-->
									<c:choose>
				                        <c:when test="${j== fn:length(textos)-1}">   
					                     <a id="descDuracion"></a>
				                        </c:when>
				                    </c:choose>	
									<a id="descDuracion-${j}"></a>
									<!--fin de anclas-->
							
						<div class="fila_de_tabla_especial" style="padding-left:0 !important">
		  					<div class="contenedor_izquierda_esp">
		  						<div class="text"><label for="Dur01" ><bean:message key="catalogadorAvanzado.Tecnica.SoloDescripcion"/>:</label></div>
		 					</div>
							<div class="contenedor_izquierda_esp" >
							<div class="text"><label for="DesDu${j} }" class="oculto" ><bean:message key="catalogadorAvanzado.Tecnica.SoloDescripcion"/>:</label>
		  						<html:textarea styleClass="input_medio_largo input_mder" property="DesDurTex${j}" value="${texto.texto}" styleId="descDur${j}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaDescripcion" cols="5" rows="4"/>
		  						</div>
							</div>
							<div class="contenedor_izquierda_esp" >
								<div class="text"><label for="Idio018" class="oculto" ><bean:message key="catalogadorAvanzado.Tecnica.SoloIdioma"/>:</label>
								<bean:define id="desc"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
								<cat:select name="form" property="DesDurIdio${j}" value="${texto.idioma}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq_n inp_se_ie" estiloOscuro="oscura" title="${desc}"/>
								
								</div>
							</div>
							<div class="float_izquierda_n">
								<c:choose>
		                   		<c:when test="${j==0}">   
							    	<span class="oculto">-</span> 
			                        <input class="boton_anadir cms_ie" type="submit" name="accion_Añadir DescDuracion" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"/> 
							        
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
			            			<input class="boton_eliminar cms_ie" type="submit" name="accion_Eliminar DescDuracion-${j}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"/> 
							        
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
						<!-- -->
		
						<!-- -->
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
	</div>
	<!-- Fin plantilla contenido  -->
	
	<!-- Inicio Botones  -->
	<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada"> 
	<input class="boton_125" id="reset_but" type="submit" name="accion" value="<bean:message key="tecnica.Reset"/>" /><br />

	<input class="boton_125_de_2"  type="submit" name="accion" value="<bean:message key="tecnica.Aceptar"/>" />
	<input class="boton_125_de_2_izq"  type="submit"  name="accion"  value="<bean:message key="tecnica.Cancelar"/>" />
	<input class="boton_125"  type="submit"  name="accion" value="<bean:message key="tecnica.Validar"/>" />
</fieldset>
	<!-- Fin Botones  -->
	<!-- Fin Botones  -->
	
</form>



</tiles:put>

</tiles:insert>
