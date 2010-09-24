<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/valoracion.tld" prefix="estrellas" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="/WEB-INF/tags/social.tld" prefix="social" %>
<%@ taglib uri="/WEB-INF/tags/formato.tld" prefix="format" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<%@ page import="es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils" %>

<tiles:insert definition="layout-sinlateral">

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="body" type="string">
	<%@ include file="/taglib-imports.jspf" %>

	<!-- Inicio plantilla contenido  -->
	<div class="plantilla_contenido">
		<jsp:include page="/layout/messages.jsp" flush="true" />

		<div class="heading_text" style="float: left; display: inline;">
			details
		</div>		

		<div class="valorame" style="float:left; display: inline;">
			<ul id="res_com">

<!-- Display the comments link -->
<logic:equal name="form" property="existeSesion" value="true">	
	<!--  #############################################################################   -->
	<!--  ############################## ENLACE COMENTARIOS ###########################   -->
	<!--  #############################################################################   -->
													<!--  ######### LAYOUTBUSCADOR = EMPAQUETADOR O FEDERADO ############   -->			<logic:notEqual name="form" property="tipoLayoutBuscador" value="BUSCADOR">	
		<logic:equal name="form" property="nrComentarios" value="0">
			<li class="comentarios_an"><a title="<bean:message key="listar.odecu.mostrar.resultados.detalles.no.comentarios"/>"><span><bean:message key="listar.odecu.mostrar.resultados.detalles.comentarios"/>(${form.nrComentarios})</span></a></li>
		</logic:equal>
														<logic:notEqual name="form" property="nrComentarios" value="0">						<li class="comentarios_an"><a href="<html:rewrite action="/ListarComentariosCU/ListarComentariosCU.do"/>?idODE=${form.identificadorODE}&amp;tituloODE=${form.titulo}&amp;imagen=${form.imagen}&amp;idiomaODE=${form.idioma}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;busquedaSimpleAvanzada=${form.busquedaSimpleAvanzada}&amp;mostrarVuelta=${form.mostrarVuelta}"  title="<bean:message key="listar.odecu.mostrar.resultados.detalles.comentarios"/>" ><span><bean:message key="listar.odecu.mostrar.resultados.detalles.comentarios"/>(${form.nrComentarios})</span></a></li>
		</logic:notEqual>
	</logic:notEqual>		
													<!--  ########### LAYOUTBUSCADOR = BUSCADOR ##############   -->				<logic:equal name="form" property="tipoLayoutBuscador" value="BUSCADOR">
		<logic:equal name="form" property="usuarioLogado" value="true">				<li class="comentarios_an"><a href="<html:rewrite action="/IntroducirComentariosCU/IntroducirComentariosCU.do"/>?idODE=${form.identificadorODE}&amp;tituloODE=${form.titulo}&amp;imagen=${form.imagen}&amp;idiomaODE=${form.idioma}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;busquedaSimpleAvanzada=${form.busquedaSimpleAvanzada}&amp;mostrarVuelta=${form.mostrarVuelta}&amp;urlODE=${initParam.url_buscadorDetalleCorta}&amp;valoracion=${form.valoracion}"  title="<bean:message key="listar.odecu.mostrar.resultados.detalles.comentarios"/>"><span><bean:message key="listar.odecu.mostrar.resultados.detalles.comentarios"/>(${form.nrComentarios})</span></a></li>
		</logic:equal>

		<logic:equal name="form" property="usuarioLogado" value="false">
			<logic:equal name="form" property="nrComentarios" value="0">			<li class="comentarios_an"><a title="<bean:message key="listar.odecu.mostrar.resultados.detalles.no.comentarios"/>"><span><bean:message key="listar.odecu.mostrar.resultados.detalles.comentarios"/>(${form.nrComentarios})</span></a></li>
			</logic:equal>
			
			<logic:notEqual name="form" property="nrComentarios" value="0">			<li class="comentarios_an"><a href="<html:rewrite action="/ListarComentariosCU/ListarComentariosCU.do"/>?idODE=${form.identificadorODE}&amp;tituloODE=${form.titulo}&amp;imagen=${form.imagen}&amp;idiomaODE=${form.idioma}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;busquedaSimpleAvanzada=${form.busquedaSimpleAvanzada}&amp;mostrarVuelta=${form.mostrarVuelta}"  title="<bean:message key="listar.odecu.mostrar.resultados.detalles.comentarios"/>" ><span><bean:message key="listar.odecu.mostrar.resultados.detalles.comentarios"/>(${form.nrComentarios})</span></a></li>
			</logic:notEqual>
		</logic:equal>
	</logic:equal>
</logic:equal>

<!-- Display all of the social networking links -->
<social:social url="/${initParam.url_buscadorDetalleCorta}/${form.idioma}/${form.identificadorODE}" mostrarVuelta="${form.mostrarVuelta}" busquedaSimpleAvanzada="${form.busquedaSimpleAvanzada}" buscadorEmpaquetador="${form.tipoLayoutBuscador}" identificadorODE="${form.identificadorODE}" idioma="${form.idioma}" titulo="${form.titulo}" urlImagen="${form.imagen}"/>
			</ul>
		</div>
                <%-- --%>

<!-- Clear div after the social tags -->
<div style="clear: both;"></div>

<!-- Start of results_detail_bubble -->
<div class="results_detail_bubble">
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

<!-- Results detail container -->
<div class="results_detail_wrapper">

<!-- White box (results_detail_outline) -->
<div class="results_detail_outline">

<!-- Show the title -->
<div class="results_detail_title">${form.titulo}</div>

<!-- Main body -->
<div class="results_detail_body">

<!-- Show the thumbnail image -->
<div class="results_detail_image">
<img src="${form.imagen}" />
</div>


<!-- Allow the user to give a rating if they are logged in -->
<logic:equal name="form" property="usuarioLogado" value="true">
<div class="results_detail_rating">
	<span><bean:message key="valorar"/></span>
	<ul class="valorar-estrellas" >
		<li class="rating-actual" style="width:60%;"><bean:message key="valorar.estrellas0"/></li>
		<li><a href="<html:rewrite action="/DetallarODECU/MostrarDetalleODEValorarODE.do"/>?identificadorODE=${form.identificadorODE}&amp;idioma=${form.idioma}&amp;mostrarVuelta=${form.mostrarVuelta}&amp;valoracion=1" title="<bean:message key="valorar.estrellas1"/>" class="uno-estrella">1</a></li>
		<li><a href="<html:rewrite action="/DetallarODECU/MostrarDetalleODEValorarODE.do"/>?identificadorODE=${form.identificadorODE}&amp;idioma=${form.idioma}&amp;mostrarVuelta=${form.mostrarVuelta}&amp;valoracion=2" title="<bean:message key="valorar.estrellas2"/>" class="dos-estrellas">2</a></li>
		<li><a href="<html:rewrite action="/DetallarODECU/MostrarDetalleODEValorarODE.do"/>?identificadorODE=${form.identificadorODE}&amp;idioma=${form.idioma}&amp;mostrarVuelta=${form.mostrarVuelta}&amp;valoracion=3" title="<bean:message key="valorar.estrellas3"/>" class="tres-estrellas">3</a></li>
		<li><a href="<html:rewrite action="/DetallarODECU/MostrarDetalleODEValorarODE.do"/>?identificadorODE=${form.identificadorODE}&amp;idioma=${form.idioma}&amp;mostrarVuelta=${form.mostrarVuelta}&amp;valoracion=4" title="<bean:message key="valorar.estrellas4"/>" class="cuatro-estrellas">4</a></li>
		<li><a href="<html:rewrite action="/DetallarODECU/MostrarDetalleODEValorarODE.do"/>?identificadorODE=${form.identificadorODE}&amp;idioma=${form.idioma}&amp;mostrarVuelta=${form.mostrarVuelta}&amp;valoracion=5" title="<bean:message key="valorar.estrellas5"/>" class="cinco-estrellas">5</a></li>
	</ul>
</div>
</logic:equal>


<!-- Show the results detail -->
<div class="results_detail">

<!-- Show the published date -->
<div class="results_detail_row">
<div class="results_detail_heading">
<span><bean:message key="listar.odecu.mostrar.resultados.detalles.fechaPublicacion"/>:&nbsp;</span>
</div>
<div class="results_detail_nowid_text">
${form.fechaPublicacion}
</div>
</div>

<!-- This tag (handler) painfully retrieves, computes and displays the assessment -->
<estrellas:valoracion valoracion="${form.valoracion}" pagina="detallar" mensaje="listar.odecu.mostrar.resultados.detalles.valoracion"/>

<!-- Show the description -->
<div class="results_detail_row">
<div class="results_detail_heading">
<span><bean:message key="listar.odecu.mostrar.resultados.consulta.vo.descripcion"/>:&nbsp;</span>
</div>
<div class="results_detail_nowid_text">
${form.descripcion}
</div>
</div>

<!-- Show the format -->
<div class="results_detail_row">
<div class="results_detail_heading">
<span><span><bean:message key="listar.odecu.mostrar.resultados.detalles.formato"/>:&nbsp;</span>
</div>
<div class="results_detail_text">

<format:formato formato="${form.formato}" literalApli="listar.odecu.mostrar.resultados.consulta.vo.aplicacion" literalText="listar.odecu.mostrar.resultados.consulta.vo.texto" literalImag="listar.odecu.mostrar.resultados.consulta.vo.imagen" literalAud="listar.odecu.mostrar.resultados.consulta.vo.audio" literalVid="listar.odecu.mostrar.resultados.consulta.vo.video" />

</div>
</div>

<!-- Show the size -->
<div class="results_detail_row">
<div class="results_detail_heading">
<span><bean:message key="listar.odecu.mostrar.resultados.detalles.tamanio"/>:&nbsp;</span>
</div>
<div class="results_detail_text">
${form.tamanio} <bean:message key="listar.odecu.mostrar.resultados.detalles.tamanio.mb"/>
</div>
</div>

<!-- Show the Learning resource type -->
<div class="results_detail_row">
<div class="results_detail_heading">
<span><span><bean:message key="listar.odecu.mostrar.resultados.detalles.learningResourceType"/>:&nbsp;</span>
</div>
<div class="results_detail_text">
${form.learningResourceType}
</div>
</div>

<!-- Show the intended users -->
<div class="results_detail_row">
<div class="results_detail_heading">
<span><bean:message key="listar.odecu.mostrar.resultados.detalles.destinatarios"/>:&nbsp;</span>
</div>
<div class="results_detail_text">
${form.destinatarios}
</div>
</div>

<!-- Show the license -->
<div class="results_detail_row">
<div class="results_detail_heading">
<span><bean:message key="listar.odecu.mostrar.resultados.detalles.licencias"/>:&nbsp;</span>
</div>
<div class="results_detail_text">
${form.licencias}
</div>
</div>

<!-- Show the Notes -->
<div class="results_detail_row">
<div class="results_detail_heading">
<span><span><bean:message key="listar.odecu.mostrar.resultados.detalles.annotation"/>:&nbsp;</span>
</div>
<div class="results_detail_text">
${form.annotation}
</div>
</div>

<!-- Show the summary detail -->
<div class="results_detail_row">
<div class="results_detail_heading" style="padding-top: 24px;">
<span><bean:message key="listar.odecu.mostrar.resultados.detalles.datos.estadisticas"/>:&nbsp;</span>
</div>
<div class="results_detail_text" style="padding-top: 24px;">

<!-- Number of previews -->
<span><bean:message key="listar.odecu.mostrar.resultados.detalles.previsualizado"/>:&nbsp;
${form.numVecesPrevisualizado}</span>&nbsp;&nbsp;&nbsp;

<!-- Number of views -->
<span><bean:message key="listar.odecu.mostrar.resultados.detalles.visto"/>:&nbsp;
${form.numVecesVisto}</span>&nbsp;&nbsp;&nbsp;

<!-- Number of downloads -->
<span><bean:message key="listar.odecu.mostrar.resultados.detalles.descargado"/>:&nbsp;
${form.numVecesDescargado}</span>&nbsp;&nbsp;&nbsp;

<!-- Number of times sent -->
<span><bean:message key="listar.odecu.mostrar.resultados.detalles.enviado"/>:&nbsp;
${form.numVecesEnviado}</span>
</div>
</div>

<!-- End of the results detail -->
</div>


</div>
<!-- End of white box (results_detail_outline) -->

<div style="clear: both;"></div>
</div>
<!-- End of results_detail_wrapper -->

<!-- Spacer -->
<div style="height: 12px;"></div>


<!-- Start of back to search results bubble -->
<logic:equal name="form" property="existeSesion" value="true">
	<logic:notEqual name="form" property="busquedaSimpleAvanzada" value="BUSQUEDA_ARBOL">
		<logic:notEqual name="form" property="busquedaSimpleAvanzada" value="">
			<form style="display:none;" name="backtosearch" action="<html:rewrite action="/DetallarODECU/MostrarDetalleODEVolverBusqueda.do"/>" method="post">	
			<input class="boton_125" id="ancho210" type="submit" value="<bean:message key="listarODE.arbolCurricular.resultados.busqueda"/>" /></form>

<div class="results_detail_back">
<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
		<div class="db_bubble_content">
		<a href="javascript:document.forms['backtosearch'].submit();">
		<bean:message key="listarODE.arbolCurricular.resultados.busqueda"/>
		</a>
		</div>
</div></div></div></div>
</div>

		</logic:notEqual>
	</logic:notEqual>
</logic:equal>
<!-- End of bubble -->

<!-- Start of previous bubble (optional depending upon session state) -->
<logic:notEmpty name="form" property="posicionamientoAnterior">
	<form name="previous" style="display:none;" action="<html:rewrite action="/DetallarODECU/MostrarDetalleODEGestionarPosicionado.do"/>" method="post">
		<input class="boton_125_de_2_izq" id="bot_flot_izq" type="submit" value="<bean:message key="listar.odecu.mostrar.resultados.detalles.anterior"/>" />
		<input type="hidden" name="idioma" value="${form.idioma}"/>
		<input type="hidden" name="nodoOrigen" value="${form.nodoOrigen}"/>
		<input type="hidden" name="identificadorODE" value="${form.identificadorODE}"/>
		<input type="hidden" name="posicionamiento" value="${form.posicionamientoAnterior}"/>
		<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
	</form>

<div class="results_detail_previous">
<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
		<div class="db_bubble_content">
		<a href="javascript:document.forms['previous'].submit();">
		<bean:message key="listar.odecu.mostrar.resultados.detalles.anterior"/>
		</a>
		</div>
</div></div></div></div>
</div>

</logic:notEmpty>
<!-- End of bubble -->

<!-- Start of next bubble (optional depending upon session state) -->
<logic:equal name="form" property="existeSesion" value="true">
	<logic:equal name="form" property="mostrarVuelta" value="true">
		<logic:notEmpty name="form" property="posicionamientoSiguiente">
			<form name="next" style="display:none;" action="<html:rewrite action="/DetallarODECU/MostrarDetalleODEGestionarPosicionado.do"/>" method="post">
			<input class="boton_125_de_2" id="bot_flot_der" type="submit" value="<bean:message key="listar.odecu.mostrar.resultados.detalles.siguiente"/>" />
			<input type="hidden" name="idioma" value="${form.idioma}"/>
			<input type="hidden" name="nodoOrigen" value="${form.nodoOrigen}"/>
			<input type="hidden" name="identificadorODE" value="${form.identificadorODE}"/>
			<input type="hidden" name="posicionamiento" value="${form.posicionamientoSiguiente}"/>				<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
			</form>

<div class="results_detail_next">
<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	<div class="db_bubble_content">
	<a href="javascript:document.forms['next'].submit();">
	<bean:message key="listar.odecu.mostrar.resultados.detalles.siguiente"/>
	</a>
	</div>
</div></div></div></div>
</div>




		</logic:notEmpty>
	</logic:equal>
</logic:equal>
<!-- End of bubble -->

<!-- Start of download bubble -->
<div class="results_detail_download">
<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	<div class="db_bubble_content">

<logic:equal name="form" property="busquedaSimpleAvanzada" value="BUSQUEDA_ARBOL">
	<a href="<html:rewrite action="/DescargarODECU/DescargarODECU.do"/>?identificadorODE=${form.identificadorODE}&amp;idioma=${form.idioma}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;mostrarVuelta=${form.mostrarVuelta}&amp;formats=${form.formato}&amp;areaCurricularBusqueda=" id="b_descargar" >
</logic:equal>
<logic:notEqual name="form" property="busquedaSimpleAvanzada" value="BUSQUEDA_ARBOL">
	<a href="<html:rewrite action="/DescargarODECU/DescargarODECU.do"/>?identificadorODE=${form.identificadorODE}&amp;idioma=${form.idioma}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;mostrarVuelta=${form.mostrarVuelta}&amp;formats=${form.formato}" id="b_descargar" >
</logic:notEqual>

	<bean:message key="listar.odecu.mostrar.resultados.detalles.descargar"/>
	</a>
	</div>
</div></div></div></div>
</div>
<!-- End of bubble -->

<!-- Start of the preview bubble -->
<div class="results_detail_preview">
<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	<div class="db_bubble_content">

<!-- Launch the SCORM previewer, set secuencia so we run "with sequence" --> 
<logic:equal name="form" property="seleccionarSecuencia" value="true">
<a id="b_previsualizar" target="_blank" href="<rewrite:rewrite url="${initParam.url_visualizador}"/>?identificador=${form.identificadorODE}&secuencia=true">
</logic:equal>
								
<logic:equal name="form" property="seleccionarSecuencia" value="false">					<a id="b_previsualizar" target="_blank" href="<rewrite:rewrite url="${initParam.url_previsualizarCorta}"/>/${form.idioma}/${form.identificadorODE}/false">
</logic:equal>

	<bean:message key="listar.odecu.mostrar.resultados.detalles.previsualizar"/>
	</a>
	</div>
</div></div></div></div>
</div>
<!-- End of bubble -->

<!-- Clear the results_detail bubble down to the bottom -->
<div style="clear: both;"></div>

</div>
<!-- End of body (results_detail_body) -->

<!-- End of bubble -->
</div>
</div></div></div></div>

</div>
<!-- End of results_detail_bubble -->

<!-- Fin plantilla contenido  -->
</div>

  </tiles:put>
</tiles:insert>

