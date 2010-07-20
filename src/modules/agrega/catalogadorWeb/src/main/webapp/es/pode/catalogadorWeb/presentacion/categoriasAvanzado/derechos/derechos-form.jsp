<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tlds/tags-catalogador.tld" prefix="cat" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado">

<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/categoriasAvanzado/derechos/derechos-form-vars.jspf" %>

<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" id="rea">
<jsp:include page="/layout/messages.jsp" flush="true"/>
<h2><bean:message key="catalogadorAvanzado.SoloDerechos"/></h2>
<form method="post" action="<html:rewrite action="/Derechos/DerechosFormSubmitForm"/>" >
<p class="parrafo_comun" id="separacion2"><bean:message key="catalogadorAvanzado.General.TextoObligacion"/></p>

<input type="hidden" id="seleccionar" name="seleccionar" value="<bean:write name="form" property="accion"/>"/> 

<script type="text/javascript">
function seleccionarCampo() {
	ancla=document.getElementById('seleccionar').value;
	if (ancla != null) {
		var partes = new Array();
		partes=ancla.split("-");
		
		if(partes[0]=="Añadir"){
			document.location.href="#descripciones";
		}
		else if(partes[0]=="Eliminar"){
			indice = partes[1];
			if(indice>0){
				indice = indice -1;
			}
			document.location.href="#descripciones-"+indice;
		}
		
	}
	
}
window.onload=seleccionarCampo;

function marcarCheck(){
	var tipoAcceso=document.getElementById("tipoAcceso").value;
	if(tipoAcceso=="6.4.1.1"){//universal
		var checkTodas=document.getElementById("listadoComunidades");
		checkTodas.checked=true;
		marcarTodas();
	}
	else if (tipoAcceso=="6.4.1.2"){//no universal
		var checkTodas=document.getElementById("listadoComunidades");
		checkTodas.checked=false;
		marcarTodas();
	}
}

function marcarTodas(){
		var checkTodas=document.getElementById("listadoComunidades");
	 	var checkboxes= document.getElementsByTagName("input");		
		if(checkTodas.checked){			
			for (var x=0; x < checkboxes.length; x++) {				
				if(checkboxes[x].type=="checkbox"){				
			   	 	checkboxes[x].checked=true;
				}
      		 }
      		var tipoAcceso = document.getElementById("tipoAcceso");
			tipoAcceso.value="6.4.1.1"			
		}
		else{		
			for (var x=0; x < checkboxes.length; x++) {
				if(checkboxes[x].type=="checkbox"){
			   	 	checkboxes[x].checked=false;
				}
      		 }
    		var tipoAcceso = document.getElementById("tipoAcceso");
			tipoAcceso.value="6.4.1.2"
		}
	}	
function seleccionMarcado(){
	var checkTodas=document.getElementById("listadoComunidades");
	var checkboxes= document.getElementsByTagName("input");
	var vacio=false;
	var vacioToda=false;
	if(checkTodas.checked){
		for(var x=0; x < checkboxes.length && vacio==false; x++){
			if(checkboxes[x].type=="checkbox" && checkboxes[x].checked==false){			
				vacio=true;
			}
		}
	}else{
		for(var x=0; x < checkboxes.length && vacioToda==false; x++){
		var primerNodo=checkTodas.value;
			if(checkboxes[x].type=="checkbox" && checkboxes[x].checked==false && checkboxes[x].value!=primerNodo){			
				vacioToda=true;
			}
		}
	}
	if(vacio==true){
		checkTodas.checked=false;
		var tipoAcceso = document.getElementById("tipoAcceso");
		tipoAcceso.value="6.4.1.2"
	}
	if(vacioToda==false && vacio==false){
		checkTodas.checked=true;
		var tipoAcceso = document.getElementById("tipoAcceso");
		tipoAcceso.value="6.4.1.1"
	}
	if(vacioToda==true){
		var tipoAcceso = document.getElementById("tipoAcceso");
		tipoAcceso.value="6.4.1.2"
	}
	
}
</script>
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
  		<bean:define id="cost"><bean:message key="catalogadorAvanzado.SeleccioneCoste"/></bean:define>
  		<cat:select name="form" property="coste" value="${form.coste}" backingList="${form.costeBackingList}" estiloSelect="select_lrg"  estiloOscuro="oscura" title="${cost}"/>
  		
  		
  		
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
  		<bean:define id="copy"><bean:message key="catalogadorAvanzado.SeleccioneCopy"/></bean:define>
  		<cat:select name="form" property="copyRestricciones" value="${form.copyRestricciones}" backingList="${form.copyRestriccionesBackingList}" estiloSelect="select_lrg" estiloOscuro="oscura" title="${copy}"/>
  		
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
					<!--anclas-->
					<c:choose>
                        <c:when test="${j== fn:length(textos)-1}">   
	                     <a id="descripciones"></a>
                        </c:when>
                    </c:choose>	
					<a id="descripciones-${j}"></a>
					<!--fin de anclas-->			
					<div class="fila_de_tabla_especial_03" >
  					<div class="contenedor_izquierda_esp" >
  						<div class="text"><label for="Des${j} }" class="oculto" ><bean:message key="catalogadorAvanzado.Derechos.SoloDescripcion"/>:</label>
  						<html:textarea styleClass="input_largo input_mder" property="DesTex${j}" value="${texto.texto}" styleId="Des${j}" onblur="this.style.backgroundColor='#e1e1e1'" titleKey="catalogadorAvanzado.IntroduzcaDescripcion" cols="5" rows="4"/>
  						</div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
							<label for="Idio01" class="oculto" ><bean:message key="catalogadorAvanzado.Derechos.SoloDescripcion"/>:</label>
							<bean:define id="de"><bean:message key="catalogadorAvanzado.SeleccioneIdioma"/></bean:define>
							<cat:select name="form" property="DesIdio${j}" value="${texto.idioma}" backingList="${form.comboIdiomaBackingList}" estiloSelect="select_peq_n inp_se_ie"  estiloOscuro="oscura" title="${de}"/>
						</div>
					</div>
					<div class="float_izquierda_n">
					<c:choose>
                   		<c:when test="${j==0}">   
					    	<span class="oculto">-</span> 
	                        <input class="boton_anadir cms_ie" type="submit" name="accion_Añadir" value="" title="<bean:message key="catalogadorAvanzado.Anadir"/>"> 
					        </input>
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
	            			<input class="boton_eliminar cms_ie" type="submit" name="accion_Eliminar-${j}" value="" title="<bean:message key="catalogadorAvanzado.Eliminar"/>"> 
					        </input>
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
					<bean:define id="acces"><bean:message key="catalogadorAvanzado.SeleccioneTipo"/></bean:define>
						<cat:select name="form" property="tipoAcceso" id="tipoAcceso" onchange="marcarCheck()" value="${form.tipoAcceso}" backingList="${form.tipoAccesoBackingList}" estiloSelect="select_lrg"  estiloOscuro="oscura" title="${acces}"/>
						
						
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
  						<div class="text"><label ><bean:message key="catalogadorAvanzado.Derechos.SoloAmbitoAcceso"/>:</label></div>
 					</div>
					<div class="contenedor_izquierda_esp" >
						<div class="text">
						<div class="caja_de_tabla_invisible" id="cata">
<table cellspacing="0" cellpadding="0" border="0"  width="100%"  summary="Asignacion Comunidades">
	<logic:iterate id="nodo" name="form" property="listadoNodos" indexId="inodo">
	
		<c:if test="${inodo==0}">
			<tr>
				<td >
					<html:multibox styleClass="check" property="listadoComunidades" name="form" styleId="listadoComunidades" value="${nodo.idNodo}" onclick="marcarTodas();" />
				</td>
				<td class="td_largo_09" valign="top">
					<label for="listadoComunidades${inodo}">${nodo.nodo}</label>
				</td>
				<td> </td>
				<td class="td_largo_09" valign="top"></td>
			</tr>
		</c:if>
		<c:if test="${inodo==1}"> 
			<tr>
				<td>
					<html:multibox styleClass="check" property="listadoComunidades" name="form" styleId="listadoComunidades" value="${nodo.idNodo}"  onclick="seleccionMarcado();" />
				</td>
				<td  class="td_largo_09"  valign="top">
					<label for="listadoComunidades${inodo}">${nodo.nodo}</label>
				</td>
				<td> </td>
				<td class="td_largo_09" valign="top"></td>
			</tr>
		</c:if>
		<c:if test="${inodo>1}">
		<c:if test="${inodo%2==0}">	
			<tr>
				<td >
					<html:multibox styleClass="check" property="listadoComunidades" name="form"  styleId="listadoComunidades" value="${nodo.idNodo}"  onclick="seleccionMarcado();"/>
				</td>
				<td class="td_largo_09"  valign="top">
					<label for="listadoComunidades${inodo}">${nodo.nodo}</label>
				</td>
		</c:if>
		<c:if test="${inodo%2!=0}">	
				<td>
					<html:multibox styleClass="check" property="listadoComunidades" name="form"  styleId="listadoComunidades" value="${nodo.idNodo}"  onclick="seleccionMarcado();"/>
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
	<input class="boton_125" id="reset_but" type="submit" name="accion" value="<bean:message key="derechos.Reset"/>" /><br />

	<input class="boton_125_de_2"  type="submit" name="accion" value="<bean:message key="derechos.Aceptar"/>" />
	<input class="boton_125_de_2_izq"  type="submit"  name="accion"  value="<bean:message key="derechos.Cancelar"/>" />
	<input class="boton_125"  type="submit"  name="accion" value="<bean:message key="derechos.Validar"/>" />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</div>
<!-- Fin plantilla contenido  -->
</form>
</tiles:put>

</tiles:insert>
