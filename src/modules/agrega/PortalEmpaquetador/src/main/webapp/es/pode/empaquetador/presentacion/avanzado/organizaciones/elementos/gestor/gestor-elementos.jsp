<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<bean:define id="urlArchivos"><html:rewrite action="/GestorArchivos/GestorArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/GestorRecursos/GestorRecursos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/GestorElementos/GestorElementos"/></bean:define>
<bean:define id="selected" value="organizaciones"/>
<emp:layout selected="${selected}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
<bean:define id="empaquetadorSesion" name="<%=es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY%>" scope="session"/>
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>

	<bean:define id="vistaCarpeta" value="${empaquetadorSesion.vistaCarpeta}"></bean:define>
<!-- ******Inicio  PESTANIAS de FICHA ******-->
<!-- ******Inicio  PESTANIAS de FICHA ******-->
	<div id="ficha_pestanias">
	<div><h2><bean:message key="portal_empaquetado_avanzado.principalElementosTitulo"/></h2></div>
		<ul>
			<logic:equal name="vistaCarpeta" value="true">
				<li><a href="<html:rewrite action="/GestorElementos/GestorElementosVista"/>?vistaArbol=true" id="seleccionada"><bean:message key="gestor_basico.vistaPorCarpeta"/></a></li>
				<li><a href="<html:rewrite action="/GestorElementos/GestorElementosVista"/>?vistaArbol=false"><bean:message key="gestor_basico.vistaPorArbol"/></a></li>
			</logic:equal>
			<logic:equal name="vistaCarpeta" value="false">
				<li><a href="<html:rewrite action="/GestorElementos/GestorElementosVista"/>?vistaArbol=true"><bean:message key="gestor_basico.vistaPorCarpeta"/></a></li>
				<li><a href="<html:rewrite action="/GestorElementos/GestorElementosVista"/>?vistaArbol=false" id="seleccionada"><bean:message key="gestor_basico.vistaPorArbol"/></a></li>
			</logic:equal>
			
		</ul>
	</div>

<!-- ******Fin PESTANIAS de FICHA****** -->
<!-- ******Fin PESTANIAS de FICHA****** -->
<div class="interno_ficha">
<!-- ******Inicio CONTENIDO PESTANIAS******-->
<!-- ******Inicio CONTENIDO PESTANIAS ******-->

<div class="plantilla_contenido_pestanias">
<form id="gestorElementosGestorElementosSubmitForm" method="post" action="<html:rewrite action="/GestorElementos/GestorElementosSubmit"/>" enctype="multipart/form-data"> 		
<!-- ***********PORTAPAPELES***********-->
<logic:notEmpty name="form" property="portapapeles">
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
  <div class="globo_gris_01">
	<div class="globo_gris_02">
 		<div class="globo_gris_03">
<!-- ******************************************* INICIO CAJA DE FORMULARIO   *****************************-->
				<div id="formulario_02" >
				<html:link action="/GestorElementos/GestorElementosVaciarPortapapeles" styleClass="flotder_enlace"><bean:message key="gestor_basico.vaciarPortapapeles"/></html:link>
				<h3><bean:message key="gestor_basico.portapapeles"/></h3>
				
				<!-- ****************** INICIO CAPA TABLA PORTAPAPELES ******************  -->
			
				<c:set var="portapapeles" value="${form.portapapeles}"/>				
 				<div class="caja_tabla bordeada" >
					<table border="1" class="generica_02" id="portapapeles" cellpadding="0" cellspacing="0" width="100%" summary="Tabla de Portapapales">
						<logic:iterate id="idportapapeles" name="portapapeles">
							<caption><strong><bean:message key="gestor_basico.tablaPortapapeles"/></strong></caption>
							<tr class="tr_beige">
								<td valign="top" class="td_larga"><a href="#" class="recurso">${fn:escapeXml(idportapapeles.title)}</a></td>
								<td class="td_corta02"><a href="<html:rewrite action="/GestorElementos/GestorElementosEliminarPortapapeles"/>?identifier=${idportapapeles.identifier}" ><bean:message key="gestor_basico.eliminar"/></a></td>
							</tr>
						</logic:iterate>
					</table>
				</div>
			
			<!-- ***************************** FIN CAPA TABLA PORTAPAPELES *****************************  -->
				
			</div>
			
<!-- *********************************************** FIN CAJA DE FORMULARIO   *****************************-->
		</div>
	</div>
  </div>
</div>
 
</logic:notEmpty>
<!--***********PORTAPAPELES***********-->

<!-- *****************************INICIO ARBOL VERTICAL *****************************-->
<logic:equal name="vistaCarpeta" value="false">
<div id="menu_arbol_org">
  <ul>

    <!--***************************** Primer Nivel ***************************** -->

	<c:set var="contNiveles" value="1" />
	<fmt:formatNumber var="nivel" value="${contNiveles}" minIntegerDigits="2" maxIntegerDigits="3"/>
	<c:set var="claseOrgAbierto" value="nivel${nivel}_organizacion_abierto" />
	<c:set var="claseOrgCerrado" value="nivel${nivel}_organizacion_cerrado" />


	<bean:define id="idCollection" name="form" property="idCollection"/>
	
	
	<c:set var="esAbierta" value="false"/>
	<logic:iterate id="elemento" name="idCollection">
		<logic:equal name="elemento" property="identifier" value="${form.organizacion.identifier }">
			<c:set var="esAbierta" value="true"/>
		</logic:equal>
	</logic:iterate>
	
	<logic:equal name="esAbierta" value="false">
		<li id= "${form.organizacion.identifier }" class="nivel01_submanifiesto_abierto">
	</logic:equal>
	<logic:equal name="esAbierta" value="true">

		<li id= "${form.organizacion.identifier }" class="nivel01_submanifiesto_cerrado">
	</logic:equal>
		<span onkeypress="P7_swapClass(1,'${form.organizacion.identifier }','nivel01_submanifiesto_abierto','nivel01_submanifiesto_cerrado','li');return false" onclick="P7_swapClass(1,'${form.organizacion.identifier }','nivel01_submanifiesto_abierto','nivel01_submanifiesto_cerrado','li');return false">&nbsp;</span>
		<a href="<html:rewrite action="/GestorElementos/GestorElementosNavegar"/>?identifier=${form.organizacion.identifier }" onkeypress="P7_swapClass(1,'${form.organizacion.identifier }','nivel01_submanifiesto_abierto','nivel01_submanifiesto_cerrado','li');return true" onclick="P7_swapClass(1,'${form.organizacion.identifier }','nivel01_submanifiesto_abierto','nivel01_submanifiesto_cerrado','li');return true">${fn:escapeXml(form.organizacion.title)}</a>	
		<bean:define id="organizacion" name="form" property="organizacion"/>
		<logic:notEmpty name="organizacion" property="grupos">
		<!--  entra en empty -->
		<bean:define id="actionNavegar"><html:rewrite action="/GestorElementos/GestorElementosNavegar"/></bean:define>
			<logic:iterate id="grupo" name="organizacion" property="grupos">
				<emp:arbol niveles="${contNiveles +1}" datosIter="${grupo}" idCollection="${idCollection}" actionNavegar="${actionNavegar}" tipoEmpaquetador="avanzado"/>
			</logic:iterate>
		</logic:notEmpty>
	</li>

	<!--***************************** Fin Primer Nivel ***************************** -->
  </ul>
</div>
</logic:equal>
<!-- *****************************FIN ARBOL VERTICAL *****************************-->

<!-- ******** INICIO GLOBO GRIS  ******** -->
<!-- ******** INICIO GLOBO GRIS  ******** -->
<div class="globo_gris" >
	<div class="globo_gris_01">

		<div class="globo_gris_02">
			<div class="globo_gris_03">
			
			<!-- ******** INICIO CAJA DE FORMULARIO  ******** -->
			<div id="formulario" >
			
			<!-- ******** INICIO ICONOS SECUENCIA ********  -->
			<!-- ******** INICIO ICONOS SECUENCIA ********  -->
			<div class="capa_iconos">
			<strong class="oculto">Secuencia:</strong>

			<ul>
			  <bean:define id="choice" value="${form.secuencia.choice}" ></bean:define>
			  <logic:equal name="choice" value="false">
			  <li><a class="icono_choice_no" href="<html:rewrite action="/GestorElementos/GestorElementosSecuencia"/>"  title="<bean:message key="secuencia.choice.no"/>">&nbsp;<strong><bean:message key="secuencia.choice.no"/></strong></a></li>
			  </logic:equal>
			  <logic:equal name="choice" value="true">
			  <li><a class="icono_choice_si" href="<html:rewrite action="/GestorElementos/GestorElementosSecuencia"/>"  title="<bean:message key="secuencia.choice.si"/>">&nbsp;<strong><bean:message key="secuencia.choice.si"/></strong></a></li>
			  </logic:equal>
			  <bean:define id="choiceExit" value="${form.secuencia.choiceExit}" ></bean:define>
  			  <logic:equal name="choiceExit" value="true">
  			  	<li><a class="icono_choice_exit_si" href="<html:rewrite action="/GestorElementos/GestorElementosSecuencia"/>" title="<bean:message key="secuencia.choice_exit.si"/>">&nbsp;<strong><bean:message key="secuencia.choice_exit.si"/></strong></a></li>
  			  </logic:equal>
  			  <logic:equal name="choiceExit" value="false">
  				<li><a class="icono_choice_exit_no" href="<html:rewrite action="/GestorElementos/GestorElementosSecuencia"/>" title="<bean:message key="secuencia.choice_exit.no"/>">&nbsp;<strong><bean:message key="secuencia.choice_exit.no"/></strong></a></li>
  			  </logic:equal>
  			  <bean:define id="flow" value="${form.secuencia.flow}" ></bean:define>
			  <logic:equal name="flow" value="true">
			  <li><a class="icono_flow_si" href="<html:rewrite action="/GestorElementos/GestorElementosSecuencia"/>" title="<bean:message key="secuencia.flow.si"/>">&nbsp;<strong><bean:message key="secuencia.flow.si"/></strong></a></li>
			  </logic:equal>
			  <logic:equal name="flow" value="false">
				 <li><a class="icono_flow_no" href="<html:rewrite action="/GestorElementos/GestorElementosSecuencia"/>" title="<bean:message key="secuencia.flow.no"/>">&nbsp;<strong><bean:message key="secuencia.flow.no"/></strong></a></li>
			  </logic:equal>
			  <bean:define id="forwardOnly" value="${form.secuencia.forwardOnly}" ></bean:define>
  			  <logic:equal name="forwardOnly" value="true">
  				 <li><a class="icono_forward_only_si" href="<html:rewrite action="/GestorElementos/GestorElementosSecuencia"/>" title="<bean:message key="secuencia.forward_only.si"/>">&nbsp;<strong><bean:message key="secuencia.forward_only.si"/></strong></a></li>
  			  </logic:equal>
  			  <logic:equal name="forwardOnly" value="false">
  				  <li><a class="icono_forward_only_no" href="<html:rewrite action="/GestorElementos/GestorElementosSecuencia"/>" title="<bean:message key="secuencia.forward_only.no"/>">&nbsp;<strong><bean:message key="secuencia.forward_only.no"/></strong></a></li>
  			  </logic:equal>
			  </ul>
			
			</div>
			<!-- ******** FIN ICONOS SECUENCIA  ******** -->
			<!-- ******** FIN ICONOS SECUENCIA  ******** -->
			
			<!-- ********inicio Breadcrumb********   -->
			<div class="breadcrumb_arbol"><em class="oculto">-</em>
			<logic:iterate id="grupo" name="form" property="idCollection">	
				<a class="br_grupo" href="<html:rewrite action="/GestorElementos/GestorElementosNavegar"/>?identifier=${grupo.identifier}">${fn:escapeXml(grupo.title)}</a>
			</logic:iterate>
		 	</div>
			<!-- ******** Fin Breadcrumb ********  -->

<!-- ******** INICIO CAPA TABLA ********  -->
<!-- ******** INICIO CAPA TABLA ********  -->
 <div class="caja_tabla limpiar_breadcrumb" id="org" >					

<table border="1" class="generica_02" cellpadding="0" cellspacing="0" width="100%" summary="Tabla de Organización">
<caption><strong><bean:message key="portal_empaquetado_gestorElementos.tablaDeOrganizacion"/></strong></caption>

 <c:set var="contador" value="true"/>
 <c:set var="contflechas" value="0"/>
 <bean:size id="longitud" name="form" property="grupos"/>	
 <logic:notEmpty name="form" property="grupos">
 <logic:iterate id="grupo" name="form" property="grupos">
	<logic:equal name="contador" value="true">
		<tr class="tr_gris">
	</logic:equal>
	<logic:equal name="contador" value="false">
		<tr class="tr_blanco">
	</logic:equal>
	<c:set var="contador" value="${!contador}"/>
	<emp:checkbox portapapeles="${form.portapapeles}" accion="${empaquetadorSession.accion}" name="identifierRowSelectionAsArray" grupo="${grupo}"/>

	<c:choose>
	  <c:when test="${grupo.esRecurso}">
	  	<bean:define id="iconoElemento" value="recurso"/>
	  </c:when>
	  <c:when test="${grupo.esSubmanifiesto}">
	  	<bean:define id="iconoElemento" value="sub"/>
	  </c:when>
	  <c:otherwise>
	  	<bean:define id="iconoElemento" value="grupo_elementos"/>
	  </c:otherwise>
	</c:choose>
	<td valign="top"  class="tar4" ><a href="<html:rewrite action="/GestorElementos/GestorElementosNavegar"/>?identifier=${grupo.identifier}" class="${iconoElemento}">${fn:escapeXml(grupo.title)}</a></td>
	<td valign="top" class="ejec"><span class="oculto">-</span>
	<logic:equal name="grupo" property="esRecurso" value="true">
	<logic:notEmpty name="grupo" property="recursoURL">
		<bean:define id="urlConHost"><rewrite:rewrite url="${grupo.recursoURL }"/></bean:define>
	 	<a href="<emp:encodeURL url="${urlConHost}"/>"  target="_blank"><bean:message key="portal_empaquetado_gestorOrganizaciones.ver"/></a></td>
	</logic:notEmpty>
	</logic:equal>
	<logic:equal name="grupo" property="esRecurso" value="false">
	  	<a href="#"></a></td>
	</logic:equal>

	 <logic:empty name="grupo" property="lom" >
			<td valign="top" class="meta_datos_mas" >
	 </logic:empty>
	 <logic:notEmpty name="grupo" property="lom" >
			<td valign="top" class="meta_datos" >
	 </logic:notEmpty>
	 <span class="oculto">-</span><a href="<html:rewrite action="/GestorElementos/GestorElementosMetadato"/>?identifier=${grupo.identifier}&amp;returnURL=<html:rewrite action="/GestorElementos/GestorElementos"/>" ><bean:message key="portalempaquetado.avanzado.recursos.crear.paso2.archivos.metadatos"/></a></td>
  	 <td valign="top" class="ejec"><span class="oculto">-</span><a href="<html:rewrite action="/GestorElementos/GestorElementosModificarElemento"/>?identifier=${grupo.identifier}"><bean:message key="presentacion.avanzado.organizaciones.elementos.gestor.link.modificar"/></a></td>
 
 	<logic:equal name="contflechas" value="0">
	  	<td valign="top" class="td_corta" align="center"><span class="oculto">-</span><a href="<html:rewrite action="/GestorElementos/GestorElementosBajar"/>?identifier=${grupo.identifier}" class="icono_bajar" title="Bajar"><strong><bean:message key="portal_empaquetado_gestorOrganizaciones.bajar"/></strong></a></td>
  	</logic:equal>
  
  	<logic:notEqual name="contflechas" value="0">
    	<logic:notEqual name="contflechas" value="${longitud-1}">
    		<td valign="top" class="td_corta" align="center"><span class="oculto">-</span><a href="<html:rewrite action="/GestorElementos/GestorElementosSubir"/>?identifier=${grupo.identifier}" class="icono_subir_02" title="Subir"><strong><bean:message key="portal_empaquetado_gestorOrganizaciones.subir"/></strong></a><span class="oculto">&nbsp;y&nbsp;</span><a href="../GestorElementos/GestorElementosBajar.do?identifier=${grupo.identifier}" class="icono_bajar_02" title="Bajar"><strong><bean:message key="portal_empaquetado_gestorOrganizaciones.bajar"/></strong></a></td>
    	</logic:notEqual>
  	</logic:notEqual>
  
  	<logic:equal name="contflechas" value="${longitud-1}">
  		<logic:notEqual name="contflechas" value="0">
  		<td valign="top" class="td_corta" align="center"><span class="oculto">-</span><a href="<html:rewrite action="/GestorElementos/GestorElementosSubir"/>?identifier=${grupo.identifier}" class="icono_subir" title="Subir"><strong><bean:message key="portal_empaquetado_gestorOrganizaciones.bajar"/></strong></a></td>
  		</logic:notEqual>
  	</logic:equal>
	</tr>
 	<c:set var="contflechas" value="${contflechas+1}"/>

	</logic:iterate>
	</logic:notEmpty>
	<logic:empty name="form" property="grupos">
		<td><bean:message key="portal_empaquetado_crearElemento.gestorElementos.noHayElementos"/></td>
	</logic:empty>
	
 </table>
</div>
	<!-- ******** FIN CAPA TABLA ********  -->		
	<!-- ******** FIN CAPA TABLA ******** -->		
</div>
<!-- ******** FIN CAJA DE FORMULARIO  ******** -->			
<!--******** Inicio Botones ******** -->
<!--******** Inicio Botones ******** -->
<br class="oculto" />
<fieldset class="tipo_interior_02">
<logic:notEmpty name="form" property="portapapeles">
   <logic:equal name="empaquetadorSesion" property="modoPegar" value="true">	
     <logic:notEqual name="empaquetadorSesion" property="accion" value="Normal">	
	   <input class="boton_65_de_3_der bot_mar_izq" type="submit" name="action" value="<bean:message key='portal_empaquetado.pegar'/>" />
	  </logic:notEqual>
	 </logic:equal> 
</logic:notEmpty>
<logic:equal name="empaquetadorSesion" property="modoPegar" value="false">	
	   <logic:equal name="empaquetadorSesion" property="accion" value="Normal">	
	   	<input type="submit" class="boton_65_de_3_der bot_mar_izq" name="action" value="<bean:message key='portal_empaquetado.cortar'/>" />
	   </logic:equal>
	   <logic:equal name="empaquetadorSesion" property="accion" value="Cortar">	
	   	<input type="submit" class="boton_65_de_3_der bot_mar_izq" name="action" value="<bean:message key='portal_empaquetado.cortar'/>" />
	   </logic:equal>
	</logic:equal>
	
	<logic:equal name="empaquetadorSesion" property="modoPegar" value="false">	
	   <logic:equal name="empaquetadorSesion" property="accion" value="Normal">	
	   	       		<input type="submit" class="boton_65_de_3_der bot_mar_izq" name="action" value="<bean:message key='portal_empaquetado.copiar'/>" />
	   </logic:equal>
	   <logic:equal name="empaquetadorSesion" property="accion" value="Copiar">	
       		<input type="submit" class="boton_65_de_3_der bot_mar_izq" name="action" value="<bean:message key='portal_empaquetado.copiar'/>" />
	   </logic:equal>
	</logic:equal>
	
	<logic:equal name="empaquetadorSesion" property="accion" value="Normal">	
	      <input type="submit" class="boton_65_de_3_der  bot_mar_izq" name="action" value="<bean:message key='portal_empaquetado.eliminar'/>" />
	</logic:equal>
<br class="oculto" /><br class="oculto" />

<input class="boton_125_de_2_izq bot_mar_der"  type="submit"  name="action"   value="<bean:message key='portal_empaquetado_gestorOrganizaciones.crearElemento'/>" />

</fieldset>
<!--******** Fin Botones ******** -->
<!--******** Fin Botones ******** -->
			
			</div>
	<!-- ******** FIN GLOBO3 GRIS  ******** -->		
			
		</div>
<!-- ******** FIN GLOBO2 GRIS  ******** -->	
	</div>
	<!-- ******** FIN GLOBO1 GRIS  ******** -->	
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

</div>
</form>
<form  method="post" action="<html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/>" enctype="multipart/form-data">
<div style="text-align:center">
	<input class="boton_125"  type="submit" name="action" value="<bean:message key='portal_empaquetado_gestorOrganizaciones.organizaciones'/>" />

</div>
</div>
<!-- ***Fin CONTENIDO PESTANIAS **-->
<!-- ***Fin CONTENIDO PESTANIAS **-->

</div>

<!--** Fin plantilla contenido ** -->
<!--** Fin plantilla contenido ** -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
</emp:layout>