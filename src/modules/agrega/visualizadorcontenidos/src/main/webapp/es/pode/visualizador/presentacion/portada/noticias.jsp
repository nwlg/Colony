<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="/WEB-INF/tags/cabeceraTag.tld" prefix="cabecera" %>

<tiles:insert definition="layout-portada">
<tiles:put name="title" type="string">
	<bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/es/pode/visualizador/presentacion/portada/noticias-vars.jspf" %>
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>


<!-- Middle column -->

<div id="contenido_central_middle">
<div class="heading_text heading_indent">search</div>

<!-- Search box bubble -->
<div class="search_box_bubble">

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

<div class="lb_bubble_content">

<form name="search" method="get" action="<rewrite:rewrite url="${initParam.url_buscador}"/>">
	<div style="">

	<!-- Start of search bubble -->
	<div style="float: right;">
	<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
		<div class="db_bubble_content">
		<a href="javascript:document.forms['search'].submit();"><bean:message key="buscador.buscador.boton"/></a>
		</div>
	</div></div></div></div>
	</div>

	<p style="float:left; display:inline;">Keywords</p>
	<div id="arrow_grey_right"/></div>

	<input type="text" id="buscadorGeneral" class="caja_buscador" value="" title="<bean:message key="buscador.buscador.alt"/>" name="buscadorGeneral" />

	<br/>

	<input style="display:none;" type="submit" alt="<bean:message key="buscador.boton.buscar.alt"/>" class="buscar" value="<bean:message key="buscador.buscador.boton"/>" name="buscar" />

	</div>

</div>

	</div></div></div></div>
</div>
<!-- End of search box bubble -->

<div class="lb_bubble_end"></div>



<!-- Search filters bubble -->
<div class="heading_text heading_indent search_filter_triangle">search filters</div>
<div class="search_filter_bubble">

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

<div class="lb_bubble_content">

	<!-- Fix some display bugs... -->
	<div style="float: left; display: inline;">

	<!-- Subject -->
	<div class="search_filter_row">
		<div class="search_filter_name">Subject:</div>
		<div class="search_filter_choice">
			<html:select name="form" property="subjectSearchFilter" styleClass="search_filter_select">
				<c:forEach items="${form.subjectSearchFilterBackingList}" var="listItem" begin="0" end="${fn:length(form.subjectSearchFilterLabelList)}">
					<html:option value="${listItem.value}">${listItem.label}</html:option>
				</c:forEach>
			</html:select>
		</div>
		<div style="clear:left;"></div>
	</div>
	
	<!-- Keystage -->
	<div class="search_filter_row">
		<div class="search_filter_name">Keystage:</div>
		<div class="search_filter_choice">
			<html:select name="form" property="keystageSearchFilter" styleClass="search_filter_select">
				<c:forEach items="${form.keystageSearchFilterBackingList}" var="listItem" begin="0" end="${fn:length(form.keystageSearchFilterLabelList)}">
					<html:option value="${listItem.value}">${listItem.label}</html:option>
				</c:forEach>
			</html:select>
		</div>
		<div style="clear:left;"></div>
	</div>
	
	<!-- Learning Time -->
	<div class="search_filter_row">
		<div class="search_filter_name">Learning Time:</div>
		<div class="search_filter_choice">
			<html:select name="form" property="learningTimeSearchFilter" styleClass="search_filter_select">
				<c:forEach items="${form.learningTimeSearchFilterBackingList}" var="listItem" begin="0" end="${fn:length(form.learningTimeSearchFilterLabelList)}">
					<html:option value="${listItem.value}">${listItem.label}</html:option>
				</c:forEach>
			</html:select>
		</div>
		<div style="clear:left;"></div>
	</div>
	
	<!-- End user -->
	<div class="search_filter_row">
		<div class="search_filter_name">End User:</div>
		<div class="search_filter_choice">
			<html:select name="form" property="intendedEndUserRoleSearchFilter" styleClass="search_filter_select">
				<c:forEach items="${form.intendedEndUserRoleSearchFilterBackingList}" var="listItem" begin="0" end="${fn:length(form.intendedEndUserRoleSearchFilterLabelList)}">
					<html:option value="${listItem.value}">${listItem.label}</html:option>
				</c:forEach>
			</html:select>
		</div>
		<div style="clear:left;"></div>
	</div>
	
	</div>
	<div style="clear:both;"></div>
		
</div>

</div></div></div></div>
</div>
<!-- End of bubble -->


<div class="lb_bubble_end"></div>
<!-- End of search filters bubble -->

</form>


<!-- News bubble -->
<div class="heading_text heading_indent">news</div>
<div class="news_bubble">

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

<div class="lb_bubble_content">

<display:table name="${form.noticias}"
			requestURI="" export="false"
			id="noticia"  style="border:1"
			cellpadding="0" cellspacing="0"  sort="list"
			partialList="False" pagesize="2">
			
			<display:column style="valign:top;" >
				<ul id="lista_de_noticias">
				<li>
				<a href="<rewrite:rewrite url="${initParam.url_portada_noticias}"/>/${fn:replace(fn:replace(noticia.tituloCodex,"?", "_"),"&#37","_")}/${noticia.id }">${noticia.titulo}</a><br/>
				<em><fmt:formatDate value="${noticia.fechaPublicacion.time}" pattern="dd/MM/yyyy"/></em>
				<p>${noticia.resumen}<br/>
				<span><bean:message key="mostrarNoticia.categoria"/> 
				<a href="<rewrite:rewrite url="${initParam.url_noticias_categorias}"/>/${noticia.categoriaCodex}/${noticia.idCategoria}">${noticia.categoria}</a></span></p>
				</li>
				</ul>

			</display:column>
			<display:setProperty name="basic.msg.empty_list"> </display:setProperty>
			<!-- sobreescribimos las propiedades del displayTag porque aqui no tenemos el div caja tabla  -->
			<c:set var="paginacion"> <bean:message key="noticias.paginacion"/> </c:set>
			<c:set var="anterior"> <bean:message key="noticias.anterior"/> </c:set>
			<c:set var="siguiente"> <bean:message key="noticias.siguiente"/> </c:set>
			
			<display:setProperty name="paging.banner.full"> <hr/><strong class="oculto">${paginacion}:</strong><div class="paginacion"><ul id="navlist"></a><li><a href="{2}">${anterior}</a></li>{0}<li><a href="{3}">${siguiente}</a></li></ul></div> </display:setProperty>
		    <display:setProperty name="paging.banner.first"> <hr/><strong class="oculto">${paginacion}:</strong><div class="paginacion" ><ul id="navlist">{0}<li><a href="{3}">${siguiente}</a></li></ul></div> </display:setProperty>
		    <display:setProperty name="paging.banner.last"> <hr/><strong class="oculto">${paginacion}:</strong><div class="paginacion" ><ul id="navlist"><li><a href="{2}">${anterior}</a></li>{0}</ul></div> </display:setProperty>
		    <display:setProperty name="paging.banner.onepage"> </display:setProperty>
</display:table>

</div>

	</div></div></div></div>
</div>
<!-- End of bubble -->
</div>
<!-- End of news bubble -->

</div>
<!-- End of middle column -->

<!-- End of plantilla_contenido -->
</div>

<!--  Establecer el cursor por defecto en la caja del buscador   -->	
<script type="text/javascript">
  document.forms[0].buscadorGeneral.focus();
</script>


</tiles:put>

<tiles:put name="menu.cabacera.top.rhs" type="string">
<!-- User and object counts -->
<div style="float: right;">
<span class="header_users">${form.usuarios} <bean:message key="portada.mensaje.usuarios"/></span>
<br class="oculto" />
<span class="header_objects">${form.objetos} <bean:message key="portada.mensaje.objetos"/></span>
<br class="oculto" />
</div> 

</tiles:put>


<tiles:put name="menu-rhs" type="string">
<!-- Front page contains the tag cloud -->
<div id="search-menu-rhs">

<div id="tagcloud">
<div class="heading_text">social tags </div>
<tiles:insert definition="agrega.tagcloud" flush="false"/>
</div>

</div>
</tiles:put>

</tiles:insert>
