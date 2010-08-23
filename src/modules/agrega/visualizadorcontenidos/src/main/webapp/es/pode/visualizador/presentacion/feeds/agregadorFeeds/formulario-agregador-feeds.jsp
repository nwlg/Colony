<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>


<tiles:insert definition="layout-usuario">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>


<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido">
<form id="agregadorFeedsCUAgregadorFeedsCUForm" action='<html:rewrite action="/AgregadorFeedsCU/AgregadorFeedsCU"/>' method="post" >

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2><bean:message key="feeds.agregador.titulo"/></h2>
<a href="<html:rewrite action="/AgregadorFeedsCU/FormularioAgregadorFeedsQueEsEsto"/>" class="resultados_bb" title="<bean:message key='feeds.agregador.queEsEsto.titulo'/>"><bean:message key='feeds.agregador.queEsEsto.titulo'/></a>
<p class="parrafo_comun" id="separacion3"><bean:message key="feeds.agregador.descripcion"/></p>

<!--		Inicio del formulario principal		-->




	
		<logic:iterate id="feed" collection="${form.feeds}">
					<logic:equal name="feed" property="periodicidad" value="si">
						<!--  INICIO GLOBO GRIS   -->
						<!--  INICIO GLOBO GRIS   -->
						<div class="globo_gris uno_b" >
							<div class="globo_gris_01">
								<div class="globo_gris_02">
									<div class="globo_gris_03">
										<!--  INICIO CAJA DE FORMULARIO   -->
									<div class="caja_dinamica"><a title='<bean:message key="feeds.agregador.ver"/>' class="desplegado" id="pm${feed.id}" href="#" onclick="expandirCaja('m${feed.id}');return false;" onkeypress="expandirCaja('m${feed.id}');return false;"><br class="falso" /><strong id="dm${feed.id}"><bean:message key="feeds.agregador.ver"/></strong></a><h3><bean:message key='${feed.titulo}'/></h3></div>
									<div id="m${feed.id}" class="caja_cerrada" >
						
						<br />
						<!--  INICIO CAJA DE FORMULARIO   -->
						<div id="formulario" >
							<!--  INICIO CAPA TABLA   -->
							<!--  INICIO CAPA TABLA   -->					
							 <div class="caja_tabla" style="margin-bottom:0">
							<table border="0" class="administracion_usuarios" cellpadding="0"  cellspacing="0" width="100%" summary="Tabla de RSS">
							<caption><strong>Tabla de RSS</strong></caption>
							
							<tr class="tr_gris">
								<td class="new sp_top" style="width:100px">
							
								<strong class="bld"><bean:message key='feeds.agregador.semana'/></strong> </td>
								<td class="new">
									<ul class="ul_up">
													<li><a title='<bean:message key="feeds.agregador.otros"/>' href="http://${feed.path}_semana_rss.xml" class="rss_rss">RSS</a>  |</li>
													<li><a title='<bean:message key="feeds.agregador.google"/>' href="http://www.google.com/ig/add?feedurl=http://${feed.path}_semana_atom.xml" class="rss_google"><bean:message key="feeds.agregador.google"/></a>  |</li>
													<li><a title='<bean:message key="feeds.agregador.blogLines"/>' href="http://www.bloglines.com/sub/http://${feed.path}_semana_rss.xml" class="rss_bloglines"><bean:message key="feeds.agregador.blogLines"/></a>  |</li>
													<li><a title='<bean:message key="feeds.agregador.netvibes"/>' href="http://www.netvibes.com/subscribe.php?url=http://${feed.path}_semana_rss.xml" class="rss_netvibes"><bean:message key="feeds.agregador.netvibes"/></a>  |</li>
													<li><a title='<bean:message key="feeds.agregador.live"/>' href="http://www.live.com/Default.aspx?add=http://${feed.path}_semana_rss.xml" class="rss_windows"><bean:message key="feeds.agregador.live"/></a>  |</li>
													<li><a title='<bean:message key="feeds.agregador.yahoo"/>' href="http://add.my.yahoo.com/content?url=http://${feed.path}_semana_rss.xml" class="rss_miyahoo"><bean:message key="feeds.agregador.yahoo"/></a>  |</li>
									
									</ul></td>
							</tr>
							<tr class="tr_blanco">
								<td class="new sp_top" style="width:100px">
								<strong class="bld"><bean:message key='feeds.agregador.mes'/></strong> </td>
								<td class="new">
									<ul class="ul_up">
							
													<li><a title='<bean:message key="feeds.agregador.otros"/>' href="http://${feed.path}_mes_rss.xml" class="rss_rss">RSS</a>  |</li>
													<li><a title='<bean:message key="feeds.agregador.google"/>' href="http://www.google.com/ig/add?feedurl=http://${feed.path}_mes_atom.xml" class="rss_google"><bean:message key="feeds.agregador.google"/></a>  |</li>
													<li><a title='<bean:message key="feeds.agregador.blogLines"/>' href="http://www.bloglines.com/sub/http://${feed.path}_mes_rss.xml" class="rss_bloglines"><bean:message key="feeds.agregador.blogLines"/></a>  |</li>
													<li><a title='<bean:message key="feeds.agregador.netvibes"/>' href="http://www.netvibes.com/subscribe.php?url=http://${feed.path}_mes_rss.xml" class="rss_netvibes"><bean:message key="feeds.agregador.netvibes"/></a>  |</li>
													<li><a title='<bean:message key="feeds.agregador.live"/>' href="http://www.live.com/Default.aspx?add=http://${feed.path}_mes_rss.xml" class="rss_windows"><bean:message key="feeds.agregador.live"/></a>  |</li>
													<li><a title='<bean:message key="feeds.agregador.yahoo"/>' href="http://add.my.yahoo.com/content?url=http://${feed.path}_mes_rss.xml" class="rss_miyahoo"><bean:message key="feeds.agregador.yahoo"/></a>  |</li>
									</ul></td>
							</tr>
							<tr class="tr_gris">
								<td class="new sp_top" style="width:100px">
								<strong class="bld"><bean:message key='feeds.agregador.anio'/></strong> </td>
							
								<td class="new">
									<ul class="ul_up">
													<li><a title='<bean:message key="feeds.agregador.otros"/>' href="http://${feed.path}_anio_rss.xml" class="rss_rss">RSS</a>  |</li>
													<li><a title='<bean:message key="feeds.agregador.google"/>' href="http://www.google.com/ig/add?feedurl=http://${feed.path}_anio_atom.xml" class="rss_google"><bean:message key="feeds.agregador.google"/></a>  |</li>
													<li><a title='<bean:message key="feeds.agregador.blogLines"/>' href="http://www.bloglines.com/sub/http://${feed.path}_anio_rss.xml" class="rss_bloglines"><bean:message key="feeds.agregador.blogLines"/></a>  |</li>
													<li><a title='<bean:message key="feeds.agregador.netvibes"/>' href="http://www.netvibes.com/subscribe.php?url=http://${feed.path}_anio_rss.xml" class="rss_netvibes"><bean:message key="feeds.agregador.netvibes"/></a>  |</li>
													<li><a title='<bean:message key="feeds.agregador.live"/>' href="http://www.live.com/Default.aspx?add=http://${feed.path}_anio_rss.xml" class="rss_windows"><bean:message key="feeds.agregador.live"/></a>  |</li>
													<li><a title='<bean:message key="feeds.agregador.yahoo"/>' href="http://add.my.yahoo.com/content?url=http://${feed.path}_anio_rss.xml" class="rss_miyahoo"><bean:message key="feeds.agregador.yahoo"/></a>  |</li>
							
									</ul></td>
							</tr>
							</table>
							</div>
								<!--  FIN CAPA TABLA   -->		
								<!--  FIN CAPA TABLA   -->	
								<br/>	
							<a href="<html:rewrite action="/ListarFeedsCU/ListarFeedsCU.do?fichero=${feed.path}&periodicidad=si&titulo=${feed.titulo}"/>" class="new"><bean:message key="feeds.agregador.verListado"/></a>
							</div>
						<!--  FIN CAJA DE FORMULARIO   -->
						</div>
						<br />
										<!--  FIN   -->
										
									</div>
								</div>
							</div>
						</div>
						<!--  FIN GLOBO GRIS   -->
						<!--  FIN GLOBO GRIS   -->
					</logic:equal>
					<logic:equal name="feed" property="periodicidad" value="no">
						<!--  INICIO GLOBO GRIS   -->
						<!--  INICIO GLOBO GRIS   -->
						<div class="globo_gris uno_b" >
							<div class="globo_gris_01">
								<div class="globo_gris_02">
									<div class="globo_gris_03">
										<!--  INICIO CAJA DE FORMULARIO   -->
									<div class="caja_dinamica"><a title='<bean:message key="feeds.agregador.ver"/>' class="desplegado" id="pm${feed.id}" href="#" onclick="expandirCaja('m${feed.id}');return false;" onkeypress="expandirCaja('m${feed.id}');return false;"><br class="falso" /><strong id="dm${feed.id}"><bean:message key="feeds.agregador.ver"/></strong></a><h3><bean:message key='${feed.titulo}'/></h3></div>
									<div id="m${feed.id}" class="caja_cerrada" >
						
						<br />
						<!--  INICIO CAJA DE FORMULARIO   -->
						<div id="formulario" >
							<!--  INICIO CAPA TABLA   -->
							<!--  INICIO CAPA TABLA   -->					
							 <div class="caja_tabla" style="margin-bottom:0">
							<table border="0" class="administracion_usuarios" cellpadding="0"  cellspacing="0" width="100%" summary="Tabla de RSS">
							<caption><strong>Tabla de RSS</strong></caption>
							
							<tr class="tr_gris">
								<td class="new sp_top" style="width:100px">
								<td class="new">
									<ul class="ul_up">
										<li><a title='<bean:message key="feeds.agregador.otros"/>' href="http://${feed.path}_rss.xml" class="rss_rss">RSS</a>  |</li>
										<li><a title='<bean:message key="feeds.agregador.google"/>' href="http://www.google.com/ig/add?feedurl=http://${feed.path}_atom.xml" class="rss_google"><bean:message key="feeds.agregador.google"/></a>  |</li>
										<li><a title='<bean:message key="feeds.agregador.blogLines"/>' href="http://www.bloglines.com/sub/http://${feed.path}_rss.xml" class="rss_bloglines"><bean:message key="feeds.agregador.blogLines"/></a>  |</li>
										<li><a title='<bean:message key="feeds.agregador.netvibes"/>' href="http://www.netvibes.com/subscribe.php?url=http://${feed.path}_rss.xml" class="rss_netvibes"><bean:message key="feeds.agregador.netvibes"/></a>  |</li>
										<li><a title='<bean:message key="feeds.agregador.live"/>' href="http://www.live.com/Default.aspx?add=http://${feed.path}_rss.xml" class="rss_windows"><bean:message key="feeds.agregador.live"/></a>  |</li>
										<li><a title='<bean:message key="feeds.agregador.yahoo"/>' href="http://add.my.yahoo.com/content?url=http://${feed.path}_rss.xml" class="rss_miyahoo"><bean:message key="feeds.agregador.yahoo"/></a>  |</li>
									
									</ul></td>
							</tr>
							</table>
							</div>
								<!--  FIN CAPA TABLA   -->		
								<!--  FIN CAPA TABLA   -->		
								<br/>	
							<a href="<html:rewrite action="/ListarFeedsCU/ListarFeedsCU.do?fichero=${feed.path}&periodicidad=no&titulo=${feed.titulo}"/>" class="new"><bean:message key="feeds.agregador.verListado"/></a>
							</div>
						<!--  FIN CAJA DE FORMULARIO   -->
						</div>
						<br />
										<!--  FIN   -->
										
									</div>
								</div>
							</div>
						</div>
						<!--  FIN GLOBO GRIS   -->
						<!--  FIN GLOBO GRIS   -->
					</logic:equal>

			</logic:iterate>
	
					<!--		FIN CAJA DE FORMULARIO (Feeds)		-->
					
		
	
</form>

<!--		Fin del Formulario principal		-->



</div>

<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>


<SCRIPT LANGUAGE="JavaScript">
	var ocultar="<bean:message key="feeds.agregador.ocultar"/>";
	var ver="<bean:message key="feeds.agregador.ver"/>";
	
	
	function expandirCaja (i) {

if (document.getElementById(i).className=='caja_abierta') {
document.getElementById('p' + i).className = 'caja_cerrada';
document.getElementById('d'+i).innerHTML=ver;
document.getElementById(i).className = 'caja_cerrada';


}
        else {
document.getElementById('p' + i).className = 'caja_abierta';
document.getElementById('d'+i).innerHTML=ocultar;
document.getElementById(i).className = 'caja_abierta';
}
}
</SCRIPT>	