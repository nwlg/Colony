<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>

<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
	<bean:message key="title.Admnistracion"/>
</tiles:put>

<tiles:put name="body" type="string">

<!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
		<div class="plantilla_contenido"><!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
		<jsp:include page="/layout/messages.jsp" flush="true" /> 



<h2><bean:message key="gestorFlujo.agregarLicencia.titulo" /></h2>
<form method="post" action="<html:rewrite action="/${initParam.url_publicar_licencia_aceptar }"/>">

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris">
<div class="globo_gris_01">
<div class="globo_gris_02">
<div class="globo_gris_03"><!--  INICIO CAJA DE FORMULARIO   -->
<div id="formulario"><!-- -->
<div class="fila_de_tabla">
<div class="contenedor_izquierda">
<div class="text"><label for="Licencia"><bean:message key="gestorFlujo.agregarLicencia.tipo"/></label>
</div>
</div>
<div class="contenedor_derecha">


	<!--  ******************** LICENCIAS   ***********************-->
	
<div class="text"><select name="tipoLicenciaSeleccionada"
	title="<bean:message key="gestorFlujo.agregarLicencia.seleccione"/>" id="Licencia">
	<logic:iterate id="licencia" collection="${form.licencias}" indexId="indice">
		<c:if test="${licencia.idTermino == form.tipo_licencia}">
			<option value="${licencia.idTermino}" selected="selected">${licencia.nomTermino}</option>
		</c:if>
			<c:if test="${licencia.idTermino != form.tipo_licencia}">
			<option value="${licencia.idTermino}" >${licencia.nomTermino}</option>
		</c:if>
	</logic:iterate>
	
</select></div>

</div>
<div class="linea_separadora"></div>
<br class="oculto" />
</div>
<!-- --></div>
<!--  FIN CAJA DE FORMULARIO   --></div>
</div>

</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->
<p class="parrafo_comun" id="separacion3"><bean:message key="gestorFlujo.agregarLicencia.comunidad"/></p>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris">
<div class="globo_gris_01">
<div class="globo_gris_02">
<div class="globo_gris_03"><!--  INICIO CAJA DE FORMULARIO   -->

<div id="formulario_02"><!-- INICIO TABLA  -->
<div class="caja_de_tabla_invisible">
<table cellspacing="0" cellpadding="0" border="1" width="100%"
	summary="Asignacion Comunidades">
	
	
	<!--  ******************** COMUNIDADES   ***********************-->
	
	
	<tr>
		
		<c:if test="${form.ambito_todas == 1}">
			<td><input id="chkb" type="checkbox" checked="checked" class="check" name="universal" value="universal" onclick="marcarTodas()";/></td>
		</c:if>
		<c:if test="${form.ambito_todas != 1}">
			<td><input id="chkb" type="checkbox" class="check" name="universal" value="universal" onclick="marcarTodas()";/></td>
		</c:if>
		<td colspan="3" valign="top"><label for="com01"><bean:message key="gestorFlujo.agregarLicencia.todas"/></label></td>
	</tr>
	<c:set var="longitud" value="${fn:length(form.comunidades)}"/>
	<logic:iterate id="comunidad" collection="${form.comunidades}" indexId="indice">
		<c:if test="${indice<longitud}">
			<c:if test="${indice % 2 == 0}">
				<tr>
				<c:if test="${form.ambito_todas == 1}">
					<td><input  type="checkbox"  checked="checked" class="check" onclick="seleccionMarcado();" name="comunidadesSeleccionadasAsArray" value="${comunidad.idNodo}" title="<bean:message key="gestorFlujo.mostrarOdes.seleccione"/>" /></td>
				</c:if>
				<c:if test="${form.ambito_todas != 1}">
					<c:if test="${comunidad.estaLicenciado}">
						<td><input  type="checkbox"  checked="checked" class="check" onclick="seleccionMarcado();" name="comunidadesSeleccionadasAsArray" value="${comunidad.idNodo}" title="<bean:message key="gestorFlujo.mostrarOdes.seleccione"/>" /></td>
					</c:if>
					<c:if test="${!comunidad.estaLicenciado}">
						<td><input  type="checkbox" class="check" onclick="seleccionMarcado();" name="comunidadesSeleccionadasAsArray" value="${comunidad.idNodo}" title="<bean:message key="gestorFlujo.mostrarOdes.seleccione"/>" /></td>
					</c:if>
				</c:if>
				<td class="td_largo_09" valign="top"><label for="${indice}">${comunidad.nodo}</label></td>
				<c:if test="${fn:length(form.comunidades) == (indice+1)}" >
					</tr>
				</c:if>
			</c:if>
			
			
			<c:if test="${indice % 2 != 0}">
				<c:if test="${form.ambito_todas == 1}">
					<td><input type="checkbox" checked="checked" class="check" onclick="seleccionMarcado();" name="comunidadesSeleccionadasAsArray" value="${comunidad.idNodo}" title="<bean:message key="gestorFlujo.mostrarOdes.seleccione"/>" /></td>
				</c:if>	
				<c:if test="${form.ambito_todas != 1}">			
					
					<c:if test="${comunidad.estaLicenciado}">
						<td><input type="checkbox" checked="checked" class="check" onclick="seleccionMarcado();" name="comunidadesSeleccionadasAsArray" value="${comunidad.idNodo}" title="<bean:message key="gestorFlujo.mostrarOdes.seleccione"/>" /></td>
					</c:if>
					<c:if test="${!comunidad.estaLicenciado}">
						<td><input type="checkbox" class="check" onclick="seleccionMarcado();" name="comunidadesSeleccionadasAsArray" value="${comunidad.idNodo}" title="<bean:message key="gestorFlujo.mostrarOdes.seleccione"/>" /></td>
					</c:if>
				</c:if>
				<td class="td_largo_09" valign="top"><label for="${indice}">${comunidad.nodo}</label></td>
			</tr>
			</c:if>
		</c:if>
		<c:if test="${indice==longitud}">
		<tr><td><input type="checkbox" checked="checked" class="check" DISABLED name="comunidadesSeleccionadasAsArray" value="${comunidad.idNodo}" title="<bean:message key="gestorFlujo.mostrarOdes.seleccione"/>" /></td>
		<td class="td_largo_09" valign="top"><label for="${indice}">${comunidad.nodo}</label></td>	
		</tr>
	</c:if>			
	</logic:iterate>	
	
		
	

</table>
</div>
<!-- fin TABLA  --></div>
<!--  FIN CAJA DE FORMULARIO   --></div>
</div>

</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->

<input class="boton_125_de_2 tipo" type="submit" value="<bean:message key="gestorFlujo.aceptar"/>" />
</form>

<form  method="post" action="<html:rewrite action="${initParam.url_publicar_licencia_cancelar }"/>">
<input class="boton_125_de_2_izq tipo" type="submit"
	value="<bean:message key="gestorFlujo.cancelar"/>" />
</form>

<!-- Fin Botones  --> <!-- Fin Botones  -->
</div>


		<!-- Fin plantilla CONTENIDO -->
	</tiles:put>

</tiles:insert>
<SCRIPT LANGUAGE="JavaScript">
function marcarTodas(){
		var checkTodas=document.getElementById("chkb");
	 	var checkboxes= document.getElementsByTagName("input");		
		if(checkTodas.checked){			
			for (var x=0; x < checkboxes.length; x++) {				
				if(checkboxes[x].type=="checkbox"){				
			   	 	checkboxes[x].checked=true;
				}
      		 }			
		}
		else{		
		for (var x=0; x < checkboxes.length; x++) {
				if(checkboxes[x].type=="checkbox"){
			   	 	checkboxes[x].checked=false;
				}
      		 }
		}
	}	
function seleccionMarcado(){
	var checkTodas=document.getElementById("chkb");
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
	}
	if(vacioToda==false && vacio==false){
		checkTodas.checked=true;
	}
	
}
</SCRIPT>