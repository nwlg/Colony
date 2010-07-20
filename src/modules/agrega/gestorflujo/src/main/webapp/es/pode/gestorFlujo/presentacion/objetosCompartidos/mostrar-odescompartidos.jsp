<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>


<tiles:insert definition="layout-gestor-flujo-con-style">

	<tiles:put name="title" type="string">
		<bean:message key="title.Comun" />
	</tiles:put>

	<tiles:put name="body" type="string">

		<!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
		<div class="plantilla_contenido"><!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
		<jsp:include page="/layout/messages.jsp" flush="true" /> <!-- Inicio  PESTANIAS de FICHA -->
		<!-- Inicio  PESTANIAS de FICHA -->

		<div id="ficha_pestanias">
		<div>
		<h2><bean:message key="gestorFlujo.mostrarOdes.title" /></h2>
		</div>
		<ul>
			<li><a
				href="<html:rewrite action="${initParam.url_objetosPersonales }"/>"><bean:message
				key="gestorFlujo.mostrarOdes.personales" /></a></li>
			<li id="pest_activa"><a
				href="<html:rewrite action="${initParam.url_objetosCompartidos }"/>" id="seleccionada"><bean:message
				key="gestorFlujo.mostrarOdes.compartidos" /></a></li>
			<li><a
				href="<html:rewrite action="${initParam.url_objetosPropuestos }"/>"><bean:message
				key="gestorFlujo.mostrarOdes.propuestos" /></a></li>				
			<li><a
				href="<html:rewrite action="${initParam.url_objetosPublicados }"/>"><bean:message
				key="gestorFlujo.mostrarOdes.publicados" /></a></li>
			
		</ul>
		</div>
		<!-- Fin PESTANIAS de FICHA --> <!-- Fin PESTANIAS de FICHA --> <!-- Inicio CONTENIDO PESTANIAS -->

		<!-- Inicio CONTENIDO PESTANIAS -->
		<div class="interno_ficha"><!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
		<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
		<!-- ATENCION!! E3TA ES LA CAPA QUE DEBE REEMPLAZARSE POR LA DEL MISMO NOMBRE (plantilla contenido pestanias ) EN LA PLANTILLA DE  CONTENIDO  CON EL CONTENIDO DE FICHA -->
		<div class="plantilla_contenido_pestanias">
		<fieldset>
		<form method="post"	action="">


		<!-- CAJA TABLA --> <!-- CAJA TABLA -->
		<div class="caja_tabla">

		<h3 class="h3_generico"><bean:message key="gestorFlujo.mostrarOdes.compartidos" /></h3>

		<bean:define id="textoMod">
			<bean:message key="gestorFlujo.mostrarOdes.modificar" />
		</bean:define> <display:table
			name="${form.listaODES}" requestURI="" export="false" uid="fila"
			class="administracion_tareas" style="border:1;width:100%;"
			cellpadding="0" cellspacing="0" summary="${summary}" sort="list"
			pagesize="20">

			<display:caption>
				<bean:message key="gestorFlujo.mostrarOdes.tablaPendientes" />
			</display:caption>
			
			<display:setProperty name="css.tr.odd" value="tr_gris" />
			<display:setProperty name="css.tr.even" value="tr_blanco" />
			<display:setProperty name="basic.show.header" value="true" />

			

			<!--  ******************** COLUMNA DE TITULO ***********************-->
			<bean:define id="tituloValue"><b><bean:message key="titulo"/></b></bean:define>
			<display:column sortable="true" sortProperty="titulo" style="valign:top;" class="tar10" title="${tituloValue}" >
				<a
				href="<rewrite:rewrite url="${initParam.url_visualizar}?identificador=${fila.idODE}&secuencia=true&comunidadAgrega=false"/>"
				class="paquete" target="blank">${fn:escapeXml(fila.titulo)}</a>
			</display:column>
			<td valign="top"></td>
			
			<!--  *******************COLUMNA TAMAINO**************** -->
			<bean:define id="tamainoValue"><b><bean:message key="tamaino"/></b></bean:define>
			<display:column sortable="true" sortProperty="tamaino" style="valign:top;" class="tar011" title="${tamainoValue}">
				${fn:escapeXml(fila.tamaino)} <bean:message key="Mbyte"/>
			</display:column>
			<td valign="top"></td>
			<!--  *******************COLUMNA AUTOR**************** -->
			<bean:define id="autorValue"><b><bean:message key="autor"/></b></bean:define>
			<display:column  sortable="true" sortProperty="idUsuario" style="valign:top;" class="tar11" title="${autorValue}">
				 ${fn:escapeXml(fila.idUsuario)} 
			</display:column>
			<td valign="top"></td>
			

			<!--  ******************** COLUMNA DE EXPORTAR ***********************-->
			<display:column style="valign:top;">
				<span class="oculto">-</span>
				<html:link
					action="${initParam.url_objetosPersonales_exportar}?idODE=${fila.idODE}&titulo=${fila.titulo}">
					<bean:message key="gestorFlujo.mostrarOdes.exportar" />
				</html:link>

			</display:column>

		<!--  ******************** COLUMNA DE IMPORTAR ***********************-->
			<display:column style="valign:top;">
				<span class="oculto">-</span>

	
				<html:link
					action="${initParam.url_objetosCompartidos_importar}?idODE=${fila.idODE}&titulo=${fila.titulo }">
					<bean:message key="gestorFlujo.mostrarOdes.importar" />
				</html:link>


			</display:column>			

		</display:table> <!-- No se cierra el div aqui porque se hace en el archivo displaytag.properties al paginar -->
		<!-- No se cierra el div aqui porque se hace en el archivo displaytag.properties al paginar -->
		
		</form>
		
		
			
		</fieldset>

		<!-- Fin Botones  --> <!-- Fin Botones  --></div>
		<!-- HASTA AQUI EL REEEMPLAZO --> <!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
		<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->


		</div>
		<!-- Fin CONTENIDO PESTANIAS --> <!-- Fin CONTENIDO PESTANIAS --> <!-- HASTA AQUI EL REEEMPLAZO -->
		<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
		<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->

		</div>
		<!-- Fin plantilla CONTENIDO -->



	</tiles:put>

</tiles:insert>

<SCRIPT LANGUAGE="JavaScript">
var checkTodas=1;
function marcarTodas()
	{
		
	 	var checkboxes= document.getElementsByTagName("input");
		
		
		if(checkTodas==1)
		{			
			for (var x=0; x < checkboxes.length; x++) 
			{
				
				if(checkboxes[x].type=="checkbox")
				{
				
			   	 	checkboxes[x].checked=true;
				}
      		 }
      		 checkTodas=0;
			
		}
		else
		{
		
		for (var x=0; x < checkboxes.length; x++) 
			{
			
				if(checkboxes[x].type=="checkbox")
				{
			   	 	checkboxes[x].checked=false;
				}
      		 }
      		 checkTodas=1;
		}
	}	
</SCRIPT>
