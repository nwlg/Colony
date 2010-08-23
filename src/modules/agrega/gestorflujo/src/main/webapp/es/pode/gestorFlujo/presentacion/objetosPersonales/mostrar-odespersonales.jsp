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
			<li id="pest_activa"><a
				href="<html:rewrite action="${initParam.url_objetosPersonales }"/>"
				id="seleccionada"><bean:message
				key="gestorFlujo.mostrarOdes.personales" /></a></li>
<!-- Remove shared items from NDRB
			<li><a
				href="<html:rewrite action="${initParam.url_objetosCompartidos }"/>" ><bean:message
				key="gestorFlujo.mostrarOdes.compartidos" /></a></li>
-->
			<li><a
				href="<html:rewrite action="${initParam.url_objetosPropuestos }"/>" ><bean:message
				key="gestorFlujo.mostrarOdes.propuestos" /></a></li>
			<li><a
				href="<html:rewrite action="${initParam.url_objetosPublicados }"/>" ><bean:message
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
		<form name="delete" method="post" id="objetosPersonalesCUMostrarODESPersonalesEliminarForm"
			action="<html:rewrite action="${initParam.url_objetosPersonales_mostrar_eliminar }"/>">


		<!-- CAJA TABLA --> <!-- CAJA TABLA -->
		<div class="caja_tabla">
		<span class="flotizq"><bean:message key="utilizar"/> <strong>${form.porcentajeMemoriaCubierta}<bean:message key="porcentaje"/></strong> <bean:message key="limite"/> ${form.cuotaUsuario} <bean:message key="Mbyte"/>.</span>
		<h3 class="h3_generico"><bean:message key="gestorFlujo.mostrarOdes.personales" /></h3>
	
		<c:if test="${fn:length(form.listaODES) > 1}">
			<h5 class="h5_generico"><a href="#" onclick="marcarTodas()"><bean:message
				key="gestorFlujo.mostrarOdes.selDesel" /></a></h5>
				<br>
		</c:if> 


		<bean:define id="textoMod">
			<bean:message key="gestorFlujo.mostrarOdes.modificar" />
		</bean:define> <bean:define id="idUsuarioLocal">${form.idUsuario}</bean:define> 
		<display:table
			name="${form.listaODES}" requestURI="" export="false" uid="fila"
			class="administracion_tareas" style="border:1;width:100%;"
			cellpadding="0" cellspacing="0" summary="${summary}" sort="list"
			pagesize="20">

			<display:caption>
				<bean:message key="gestorFlujo.mostrarOdes.tablaPendientes" />
			</display:caption>
			<display:setProperty name="css.tr.odd" value="tr_gris" />
			<display:setProperty name="css.tr.even" value="tr_blanco" />
			<display:setProperty name="css.table" value="tr_foo" />
			<display:setProperty name="basic.show.header" value="true" />

			<!--  ******************** COLUMNA DE CHECKBOX ***********************-->

			<display:column style="valign:top;" class="sin_b">
				<input type="checkbox" name="idODERowSelectionAsArray"
					value="${fila.idODE},${fila.titulo}"
					title="<bean:message key="gestorFlujo.mostrarOdes.seleccione"/>" />
			</display:column>

			<!--  ******************** COLUMNA DE TITULO ***********************-->
			
			<bean:define id="tituloValue"><b><bean:message key="titulo"/></b></bean:define>
				<display:column sortable="true" sortProperty="titulo" style="valign:top;" class="tar10" title="${tituloValue}" >
					<a href="<rewrite:rewrite url="${initParam.url_visualizar}?identificador=${fila.idODE}&secuencia=true&comunidadAgrega=false"/>" class="paquete" target="blank">${fn:escapeXml(fila.titulo)}</a>
			</display:column>
			<td valign="top"></td>
			<!--  *******************COLUMNA TAMAINO**************** -->
			<bean:define id="tamainoValue"><b><bean:message key="tamaino"/></bean:define>
			<display:column sortable="true" sortProperty="tamaino" style="valign:top;" class="tar011" title="${tamainoValue}">
				 ${fn:escapeXml(fila.tamaino)} <bean:message key="Mbyte"/>
			</display:column>
			<td valign="top"></td>
			
			<!--  ******************** COLUMNA DE HISTORIAL ***********************-->
			<display:column style="valign:top;" class="ejec12">
				<span class="oculto">-</span>
				<html:link target="blank"
					action="${initParam.url_objetosPersonales_mostrar_historial}?idODE=${fila.idODE}&idUsuario=${idUsuarioLocal}&titulo=${fila.titulo}">
					<bean:message key="gestorFlujo.mostrarOdes.verHistorial" />
				</html:link>
			</display:column>
			
			<!--  ******************** COLUMNA DE MODIFICAR ***********************-->
			<display:column style="valign:top;" class="tar11">
				<span class="oculto">-</span>
				<c:choose>
					<c:when test="${form.espacioLibre>'0'}">
						<a href="<rewrite:rewrite url="${initParam.url_objetos}?identificador=${fila.idODE}&espacioLibre=${form.espacioLibre }&espacioODE=${fila.tamaino}"/>">${textoMod}</a>
					</c:when>
					<c:otherwise>
						${textoMod}
					</c:otherwise>
				</c:choose>
			</display:column>
			<!--  ******************** COLUMNA DE COMPARTIR/DESCOMPARTIR ***********************-->
			<display:column style="valign:top;" class="oculto">
				<span class="oculto">-</span>
				<c:if test="${fila.compartir}" >
					<html:link 
					action="${initParam.url_compartir_descompartir_personal}?idODE=${fila.idODE}&compartidoSN=true"><bean:message key="gestorFlujo.mostrarOdes.descompartir" /></html:link>
					</c:if>
				<c:if test="${!fila.compartir}" >
					<html:link 
					action="${initParam.url_compartir_descompartir_personal}?idODE=${fila.idODE}&compartidoSN=false"><bean:message key="gestorFlujo.mostrarOdes.compartir" /></html:link>
				</c:if>
				
			</display:column>
			
			<!--  ******************** COLUMNA DE EXPORTAR ***********************-->
			<display:column style="valign:top;">
				<span class="oculto">-</span>
				<html:link
					action="${initParam.url_objetosPersonales_exportar}?idODE=${fila.idODE}&titulo=${fila.titulo}">
					<bean:message key="gestorFlujo.mostrarOdes.exportar" />
				</html:link>

			</display:column>

			<!--  ******************** COLUMNA DE PROPONER ***********************-->
			<display:column style="valign:top;" class="ejec">
				<span class="oculto">-</span>
				<html:link
					action="${initParam.url_objetosPersonales_proponer}?idODE=${fila.idODE}&idUsuario=${idUsuarioLocal}&titulo=${fila.titulo}">
					<bean:message key="gestorFlujo.mostrarOdes.proponer" />
				</html:link>

			</display:column>

		</display:table> <!-- No se cierra el div aqui porque se hace en el archivo displaytag.properties al paginar -->
		<!-- No se cierra el div aqui porque se hace en el archivo displaytag.properties al paginar -->
		<c:if test="${fn:length(form.listaODES) < 1}" >
  			</div>
		</c:if>
		<!-- No se cierra el div aqui porque se hace en el archivo displaytag.properties al paginar -->
		<!-- FIN CAJA TABLA --> <!-- FIN CAJA TABLA --> <!-- Inicio Botones  -->
		<!-- Inicio Botones  --> 
		<c:if test="${fn:length(form.listaODES) > 0}" >

			<div class="pfolder_delete">
				<!-- Start of bubble -->
				<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">

				<div class="db_bubble_content">
					<a href="javascript:document.forms['delete'].submit();"><bean:message key="gestorFlujo.mostrarOdes.eliminar"/></a>
				</div>

				</div></div></div></div>
				<!-- End of bubble -->
			</div>

		</c:if>
		</form>
		<!-- *********************    Boton Crear Ode    ********************-->
		<c:choose>
			<c:when test="${form.espacioLibre>'0'}">
				<form name="create" action="<rewrite:rewrite url="${initParam.url_objetos}?espacioLibre=${form.espacioLibre }&espacioODE='0'"/>" method="post">

				<div class="pfolder_create">
					<!-- Start of bubble -->
					<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	
					<div class="db_bubble_content">
						<a href="javascript:document.forms['create'].submit();"><bean:message key="gestorFlujo.mostrarOdes.crear"/></a>
					</div>
	
					</div></div></div></div>
					<!-- End of bubble -->
				</div>

				</form>
			</c:when>
			<c:otherwise>
				<form name="create" action="" method="post">
<!-- Don't bother displaying a disabled button if we can't create
					<input class="boton_125_de_2_izq bot_mar_der" type="submit" disabled="true" value="<bean:message key="gestorFlujo.mostrarOdes.crear"/>" />
-->
				</form>
			</c:otherwise>
		</c:choose>
		<!-- *********************    Boton Importar Ode    ********************-->
		<c:choose>
			<c:when test="${form.espacioLibre>'0'}">
				<form name="import" action="<html:rewrite action="${initParam.url_objetosPersonales_importar}?espacioLibre=${form.espacioLibre}"/>" method="post">

				<div class="pfolder_import">
					<!-- Start of bubble -->
					<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	
					<div class="db_bubble_content">
						<a href="javascript:document.forms['import'].submit();"><bean:message key="gestorFlujo.mostrarOdes.importar"/></a>
					</div>
	
					</div></div></div></div>
					<!-- End of bubble -->
				</div>

				</form>
			</c:when>
			<c:otherwise>
				<form action="" method="post">
<!-- Don't bother displaying a disabled button if we can't create
					<input class="boton_125_de_2_izq bot_mar_der" type="submit" disabled="true"	value="<bean:message key="gestorFlujo.mostrarOdes.importar"/>" />
-->
				</form>
			</c:otherwise>
		</c:choose>
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
