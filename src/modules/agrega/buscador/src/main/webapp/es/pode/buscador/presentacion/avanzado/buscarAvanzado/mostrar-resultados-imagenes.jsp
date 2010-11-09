<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="/WEB-INF/tags/serverProperties.tld" prefix="server" %>
<%@ taglib uri="/WEB-INF/tags/tablaImagenes.tld" prefix="imagenes" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>

<tiles:insert definition="layout-sinlateralYsinbuscadorSuperior">

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="body" type="string">
		<%@ include file="/taglib-imports.jspf" %>
		<!-- Inicio plantilla contenido  -->
		<div class="plantilla_contenido">
			<!-- Pintar mensajes de error  -->
			<jsp:include page="/layout/messages.jsp" flush="true" />
			
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" style="margin-right:260px;">

<!-- Display the search keyword and RSS feed -->
<div class="results_header">

<div class="results_header_text"><bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.resultadoBusqueda"/>: ${form.buscadorContenidoEnlace}</div>

<div class="results_header_rss"><a href="<html:rewrite action="/BuscarAvanzadoCU/MostrarResultadosImagenesGenerarRSS.do"/>?buscadorContenido=${form.buscadorContenidoEnlace}&amp;idioma=${form.idioma}&amp;pagina=${form.anterior}&amp;formato=${form.formato}&amp;recurso=${form.recurso}&amp;procesoCognitivo=${form.procesoCognitivo}&amp;contexto=${form.contexto}&amp;edad=${form.edad}&amp;autor=${form.autor}&amp;diaPublicacion=${form.diaPublicacion}&amp;mesPublicacion=${form.mesPublicacion}&amp;anyoPublicacion=${form.anyoPublicacion}&amp;c_s_secuencia=${form.c_s_secuencia}&amp;valoracion=${form.valoracion}&amp;areaCurricular=${form.areaCurricular}&amp;enlaceComunidadesSeleccionadas=${form.enlaceComunidadesSeleccionadas}&amp;enlaceTodoAgrega=${form.enlaceTodoAgrega}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;idTesauro=${form.idTesauro}&amp;nomTesauros=${form.nomTesauros}&amp;nivelAgregacion=${form.nivelAgregacion}&amp;destinatarios=${form.destinatarios}&amp;keyword=${form.keyword}&amp;tipoBusqueda=${form.tipoBusqueda}"><bean:message key="listar.odecu.mostrar.resultados.suscribirse"/></a></div>

</div>

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

<!-- Display the search result total -->
<div class="results_bubble_text">
<table><tr><td width="25%">
<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.desdeHasta" arg0="${form.resultadosDesde}" arg1="${form.resultadosHasta}" arg2="${form.numMaxRes}"/>
</td>
<td width="75%">
        <center>
<%--
//09/11/2010    Fernando Garcia
//Temporary code for a combo to sort items
<html:select name="form" property="sortingMethod" styleClass="search_filter_select">
    <c:forEach items="${form.sortingMethodBackingList}" var="listItem" begin="0" end="${fn:length(form.sortingMethodLabelList)}">
        <html:option value="${listItem.value}">${listItem.label}</html:option>
    </c:forEach>
</html:select>
--%>
        </center>
</td>
</tr>
</table>
</div>


<!-- INICIO SUGERENCIAS -->

<div class="parrafo_comun" id="separacion">

		<logic:notEmpty name="form"	property="quisoDecir">
			<bean:message key="listar.odecu.mostrar.resultados.quiso.quisoDecir"/>:  
				<logic:iterate name="form" property="quisoDecir" id="sugerencia">
					<a href="<html:rewrite action="/BuscarAvanzadoCU/MostrarQuisoDecirAvanzadoBuscarQuisoDecir.do"/>?buscadorContenido=${sugerencia}&idiomaBuscador=${form.idioma}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;enlaceComunidadesSeleccionadas=${form.enlaceComunidadesSeleccionadas}&amp;tipoBusqueda=${form.tipoBusqueda}">${sugerencia}</a> 
				</logic:iterate>
		</logic:notEmpty>
		
		<logic:notEmpty name="form" property="tesauros">
			<bean:message key="listar.odecu.mostrar.resultados.quiso.tesauros"/>
				<logic:iterate name="form" property="tesauros" id="taxon"> 
					<a href="<html:rewrite action="/BuscarAvanzadoCU/MostrarQuisoDecirAvanzadoQuisoDecir.do"/>?idTesauroSugerencia=${taxon.identificador}&idiomaBuscador=${form.idioma}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;enlaceComunidadesSeleccionadas=${form.enlaceComunidadesSeleccionadas}&amp;tipoBusqueda=${form.tipoBusqueda}">${taxon.nombre}</a> 
				</logic:iterate>
			<br />
		</logic:notEmpty>
		
</div>

<!--  FIN SUGERENCIAS-->







<!-- Inicio  PESTANIAS de FICHA -->
<!-- Inicio  PESTANIAS de FICHA -->
<!--  <div id="ficha_pestanias">
	<ul> -->
		<!-- <li ><a href="/buscador/BuscarAvanzadoCU/MostrarResultadosAvanzadoBuscarResultados.do?buscadorContenido=${form.buscadorContenidoEnlace}&amp;idiomaBuscador=${form.idioma}&amp;pagina=${form.pagina}&amp;formato=${form.formato}&amp;recurso=${form.recurso}&amp;procesoCognitivo=${form.procesoCognitivo}&amp;contexto=${form.contexto}&amp;edad=${form.edad}&amp;autor=${form.autor}&amp;diaPublicacion=${form.diaPublicacion}&amp;mesPublicacion=${form.mesPublicacion}&amp;anyoPublicacion=${form.anyoPublicacion}&amp;c_s_secuencia=${form.c_s_secuencia}&amp;valoracion=${form.valoracion}&amp;areaCurricular=${form.areaCurricular}&amp;enlaceComunidadesSeleccionadas=${form.enlaceComunidadesSeleccionadas}&amp;enlaceTodoAgrega=${form.enlaceTodoAgrega}&amp;tipoBusqueda=${form.tipoBusqueda}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;busquedaSimpleAvanzada=${form.busquedaSimpleAvanzada}&amp;tipoVisualizacion=SIN_IMAGENES&amp;idTesauro=${form.idTesauro}&amp;nomTesauros=${form.nomTesauros}&amp;nivelAgregacion=${form.nivelAgregacion}&amp;destinatarios=${form.destinatarios}"><bean:message key="listar.odecu.mostrar.resultados.listado"/></a></li>
		<li id="pest_activa"><a  id="seleccionada" href="#"><bean:message key="listar.odecu.mostrar.resultados.imagenes"/></a></li> -->
<!-- 	</ul>
</div>  -->


<!-- Fin PESTANIAS de FICHA -->
<!-- Fin PESTANIAS de FICHA -->

<!-- Inicio CONTENIDO PESTANIAS -->
<!-- Inicio CONTENIDO PESTANIAS -->
<!-- <div class="interno_ficha"> -->

<!-- CAJA TABLA -->
<!-- CAJA TABLA -->
<div class="results_box">
<form method="post" action="<html:rewrite action="/BuscarAvanzadoCU/MostrarResultadosImagenesEliminarODE.do"/>">
	<!-- Inicio Resultados de Búsqueda -->
	<!-- Inicio Resultados de Búsqueda -->
			
				<logic:iterate name="form" property="resultadosVO" id="resultados" indexId="idx">

					<imagenes:imagenes
					 usuarioAdministrador="${form.usuarioAdministrador}"
					 identificadorODE="${resultados.id}"
					 titulo="${resultados.titulo}"
					 esVisualizable ="${resultados.esVisualizable}"
					 numeroODE="${resultados.numeroODE}"
					 formato="${resultados.formato}"
					 nivelAgregacionTexto="${resultados.nivelAgregacionTexto}"
					 urlImagen="${resultados.urlImagen}"
					 contador="${form.resultadosDesde+idx}"
					 valoracion="${resultados.valoracion}"
					 tipoRecurso="${resultados.tipoRecurso}"
					 areaCurricular="${resultados.areaCurricular}"
					 nodo="${resultados.nodo}"
					 descripcion="${resultados.descripcion}"
					 contentProviders="${resultados.contentProviders}"
					 autores="${resultados.authors}"
					 typicalLearningTime="${resultados.typicalLearningTime}"
                     url="/buscador/BuscarAvanzadoCU/MostrarResultadosImagenesPrepararRetornoDetalleImagenes.do?idioma=${form.idioma}&amp;buscadorContenido=${form.buscadorContenidoEnlace}&amp;pagina=${form.pagina}&amp;formato=${form.formato}&amp;recurso=${form.recurso}&amp;procesoCognitivo=${form.procesoCognitivo}&amp;contexto=${form.contexto}&amp;edad=${form.edad}&amp;autor=${form.autor}&amp;diaPublicacion=${form.diaPublicacion}&amp;mesPublicacion=${form.mesPublicacion}&amp;anyoPublicacion=${form.anyoPublicacion}&amp;c_s_secuencia=${form.c_s_secuencia}&amp;valoracion=${form.valoracion}&amp;areaCurricular=${form.areaCurricular}&amp;identificadorODE=${resultados.id}&amp;tipoVisualizacion=${form.tipoVisualizacion}&amp;nodoDestino=${resultados.nodo}&amp;enlaceComunidadesSeleccionadas=${form.enlaceComunidadesSeleccionadas}&amp;tipoBusqueda=${form.tipoBusqueda}&amp;enlaceTodoAgrega=${form.enlaceTodoAgrega}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;idTesauro=${form.idTesauro}&amp;nomTesauros=${form.nomTesauros}&amp;idTesauroSugerencia=${form.idTesauroSugerencia}&amp;nivelAgregacion=${form.nivelAgregacion}&amp;destinatarios=${form.destinatarios}&amp;keyword=${form.keyword}&amp;numeroResultados=${form.numeroResultados}"/>

				</logic:iterate>					
		<!--  -->
		<!--  -->
	<!-- Fin Resultados de Búsqueda -->
</div>

	<!-- Fin Resultados de Búsqueda -->

<!-- Fin CONTENIDO PESTANIAS -->
<!-- Fin CONTENIDO PESTANIAS -->


<!-- Inicio Boton de Eliminar  -->
<!-- Inicio Boton de Eliminar  -->


		
	
	<logic:equal name="form" property="usuarioAdministrador" value="true">  
		<fieldset class="tipo ft_centrada" style='padding-bottom: 10px'>
				<input type="hidden" name="idioma" value="${form.idioma}"/>
				<input type="hidden" name="buscadorContenido" value="${form.buscadorContenido}"/>
				<input type="hidden" name="formato" value="${form.formato}"/>
				<input type="hidden" name="recurso" value="${form.recurso}"/>
				<input type="hidden" name="procesoCognitivo" value="${form.procesoCognitivo}"/>
				<input type="hidden" name="contexto" value="${form.contexto}"/>
				<input type="hidden" name="edad" value="${form.edad}"/>
				<input type="hidden" name="autor" value="${form.autor}"/>
				<input type="hidden" name="diaPublicacion" value="${form.diaPublicacion}"/>
				<input type="hidden" name="mesPublicacion" value="${form.mesPublicacion}"/>
				<input type="hidden" name="anyoPublicacion" value="${form.anyoPublicacion}"/>
				<input type="hidden" name="c_s_secuencia" value="${form.c_s_secuencia}"/>
				<input type="hidden" name="valoracion" value="${form.valoracion}"/>
				<input type="hidden" name="nivelAgregacion" value="${form.nivelAgregacion}"/>
				<input type="hidden" name="areaCurricular" value="${form.areaCurricular}"/>
				<input type="hidden" name="destinatarios" value="${form.destinatarios}"/>
				<input type="hidden" name="keyword" value="${form.keyword}"/>
				<input type="hidden" name="idTesauro" value="${form.idTesauro}"/>
				<input type="hidden" name="nomTesauros" value="${form.nomTesauros}"/>
				<input type="hidden" name="usuarioAdministrador" value="${form.usuarioAdministrador}"/>
				<input type="hidden" name="enlaceComunidadesSeleccionadas" value="${form.enlaceComunidadesSeleccionadas}"/>	
				<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>	
				<input type="hidden" name="tipoBusqueda" value="${form.tipoBusqueda}"/>
				<input type="hidden" name="pagina" value="${form.pagina}"/>	
				<input type="hidden" name="numeroResultados" value="${form.numeroResultados}"/>
			<input class="boton_125_de_22" type="submit"  value="<bean:message key='listar.odecu.mostrar.resultados.consulta.cabecera.eliminar'/>" />
		</fieldset> 
	</logic:equal>  
</form>

<!-- Fin Boton de Eliminar  -->
<!-- Fin Boton de Eliminar  -->


<!-- End of IE6 float hack -->

	</div></div></div></div>
<!-- End of bubble -->

<!-- Paginacion -->
<div class="paginacion">
	<ul id="navlist">								
		<logic:notEmpty name="form" property="anterior">									
			<li><a href="<html:rewrite action="/BuscarAvanzadoCU/MostrarResultadosImagenesPaginarImagenes.do"/>?buscadorContenido=${form.buscadorContenidoEnlace}&amp;idiomaBuscador=${form.idioma}&amp;pagina=${form.anterior}&amp;formato=${form.formato}&amp;recurso=${form.recurso}&amp;procesoCognitivo=${form.procesoCognitivo}&amp;contexto=${form.contexto}&amp;edad=${form.edad}&amp;autor=${form.autor}&amp;diaPublicacion=${form.diaPublicacion}&amp;mesPublicacion=${form.mesPublicacion}&amp;anyoPublicacion=${form.anyoPublicacion}&amp;c_s_secuencia=${form.c_s_secuencia}&amp;valoracion=${form.valoracion}&amp;areaCurricular=${form.areaCurricular}&amp;enlaceComunidadesSeleccionadas=${form.enlaceComunidadesSeleccionadas}&amp;enlaceTodoAgrega=${form.enlaceTodoAgrega}&amp;tipoBusqueda=${form.tipoBusqueda}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;nivelAgregacion=${form.nivelAgregacion}&amp;destinatarios=${form.destinatarios}&amp;keyword=${form.keyword}&amp;idTesauro=${form.idTesauro}&amp;nomTesauros=${form.nomTesauros}&amp;idTesauroSugerencia=${form.idTesauroSugerencia}&amp;numeroResultados=${form.numeroResultados}&amp;tipoVisualizacion=CON_IMAGENES"><bean:message key="listarODE.arbolCurricular.anterior"/></a></li>
		</logic:notEmpty>
				
		<logic:iterate name="form" property="paginas" id="pagina">									
			<logic:equal name="form" property="pagina" value="${pagina}">
				<li>${pagina}</li>
			</logic:equal>

			<logic:notEqual name="form" property="pagina" value="${pagina}">
				<li><a href="<html:rewrite action="/BuscarAvanzadoCU/MostrarResultadosImagenesPaginarImagenes.do"/>?buscadorContenido=${form.buscadorContenidoEnlace}&amp;idiomaBuscador=${form.idioma}&amp;pagina=${pagina}&amp;formato=${form.formato}&amp;recurso=${form.recurso}&amp;procesoCognitivo=${form.procesoCognitivo}&amp;contexto=${form.contexto}&amp;edad=${form.edad}&amp;autor=${form.autor}&amp;diaPublicacion=${form.diaPublicacion}&amp;mesPublicacion=${form.mesPublicacion}&amp;anyoPublicacion=${form.anyoPublicacion}&amp;c_s_secuencia=${form.c_s_secuencia}&amp;valoracion=${form.valoracion}&amp;areaCurricular=${form.areaCurricular}&amp;enlaceComunidadesSeleccionadas=${form.enlaceComunidadesSeleccionadas}&amp;enlaceTodoAgrega=${form.enlaceTodoAgrega}&amp;tipoBusqueda=${form.tipoBusqueda}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;nivelAgregacion=${form.nivelAgregacion}&amp;destinatarios=${form.destinatarios}&amp;keyword=${form.keyword}&amp;idTesauro=${form.idTesauro}&amp;nomTesauros=${form.nomTesauros}&amp;idTesauroSugerencia=${form.idTesauroSugerencia}&amp;numeroResultados=${form.numeroResultados}&amp;tipoVisualizacion=CON_IMAGENES">${pagina}</a></li>
			</logic:notEqual>
		</logic:iterate>
						
		<logic:notEmpty name="form" property="siguiente">
			<li><a href="<html:rewrite action="/BuscarAvanzadoCU/MostrarResultadosImagenesPaginarImagenes.do"/>?buscadorContenido=${form.buscadorContenidoEnlace}&amp;idiomaBuscador=${form.idioma}&amp;pagina=${form.siguiente}&amp;formato=${form.formato}&amp;recurso=${form.recurso}&amp;procesoCognitivo=${form.procesoCognitivo}&amp;contexto=${form.contexto}&amp;edad=${form.edad}&amp;autor=${form.autor}&amp;diaPublicacion=${form.diaPublicacion}&amp;mesPublicacion=${form.mesPublicacion}&amp;anyoPublicacion=${form.anyoPublicacion}&amp;c_s_secuencia=${form.c_s_secuencia}&amp;valoracion=${form.valoracion}&amp;areaCurricular=${form.areaCurricular}&amp;enlaceComunidadesSeleccionadas=${form.enlaceComunidadesSeleccionadas}&amp;enlaceTodoAgrega=${form.enlaceTodoAgrega}&amp;tipoBusqueda=${form.tipoBusqueda}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;nivelAgregacion=${form.nivelAgregacion}&amp;destinatarios=${form.destinatarios}&amp;keyword=${form.keyword}&amp;idTesauro=${form.idTesauro}&amp;nomTesauros=${form.nomTesauros}&amp;idTesauroSugerencia=${form.idTesauroSugerencia}&amp;numeroResultados=${form.numeroResultados}&amp;tipoVisualizacion=CON_IMAGENES"><bean:message key="listarODE.arbolCurricular.siguiente"/></a></li>
		</logic:notEmpty>
	</ul>
</div>

</div>

<!-- Fin caja buscador -->
</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->


    </tiles:put>


<tiles:put name="menu-rhs" type="string">
<!-- Front page contains the search box and the tag cloud -->
<div id="search-menu-rhs">

<div id="searchbox">
<div class="heading_text">search</div>
<tiles:insert definition="agrega.search" flush="false"/>
</div>

<div id="tagcloud" style="margin-top:24px;">
<div class="heading_text">social tags </div>
<tiles:insert definition="agrega.tagcloud" flush="false"/>
</div>

</div>
</tiles:put>


</tiles:insert>
<SCRIPT LANGUAGE="JavaScript">
var tipoBusqueda="${form.tipoBusqueda}";
var numeroResultados="${form.numeroResultados}";
if(tipoBusqueda=="04"){
	deshabilitarCombos();
}

function deshabilitarCombos(){
	var oComboIdioma = document.getElementById('idiomaBuscadorContenido');
	var oComboNumeroResultados = document.getElementById('numeroResultados');
	oComboIdioma.disabled=true;
	oComboNumeroResultados.disabled=true;
}

function habilitarCombos(){
	var oComboIdioma = document.getElementById('idiomaBuscadorContenido');
	var oComboNumeroResultados = document.getElementById('numeroResultados');
	oComboIdioma.disabled=false;
	oComboNumeroResultados.disabled=false;
}

function enviarFormulario(){
	if(numeroResultados!=document.getElementById('numeroResultados').value){
		document.formularioBusqueda.submit();
	}
}
</SCRIPT>
