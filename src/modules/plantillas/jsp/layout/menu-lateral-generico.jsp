<%@ include file="/taglib-imports.jspf"%>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<!-- INICIO LATERAL IZQUIERDO  -->
<!-- <div id="lateral" > -->

<!-- INICIO NAVEGACIÓN VERTICAL NUEVO -->
<!-- INICIO NAVEGACIÓN VERTICAL -->
<div id="menu_vertical" style="float:left;" >

<br class="oculto" />
<strong class="oculto"><bean:message key="menu.lateral.generico.menuVertical" /></strong>

<!-- Spacer for menu heading -->
<div class="heading_text"></div>

<!-- Navigation menu bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

<ul>
<tiles:importAttribute name="MENU_LATERAL" scope="page"/>
<logic:iterate name="MENU_LATERAL" id="menuItem">
	<li>
		<logic:equal name="menuItem" property="selected" value="false">
			<a href="<bean:write name="menuItem" property="link"/>" <logic:notEqual name="menuItem" property="target" value="">target="<bean:write name="menuItem" property="target"/>"</logic:notEqual>>
		</logic:equal>
		<logic:equal name="menuItem" property="selected" value="true">
			<div>
		</logic:equal>
			<span><bean:write name="menuItem" property="i18nKey"/></span>
		<logic:equal name="menuItem" property="selected" value="false">
			</a>
		</logic:equal>
		<logic:equal name="menuItem" property="selected" value="true">
			</div>
		</logic:equal>
	</li>
</logic:iterate>
</ul>

	</div></div></div></div>


<%-- 08/09/2010 Fernando Garcia --%>
<%--            The news block is moved to this location --%>
<%--            TODO: maybe a good idea could be to change the controller or whatever --%>
<% if (session.getAttribute("form") instanceof es.pode.visualizador.presentacion.portada.PortadaFormImpl) { %>
<div><p style="font-size: 100%">&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p></div>

<!-- News bubble -->
<div class="heading_text heading_indent">news</div>
<div class="news_bubble" style="font-size: 80%;">

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

<div class="lb_bubble_content" style="padding: 10px;">
<%-- TODO: quick fix to have a horizontal menu and no vertical. Maybe we need to change display custom tag. --%>
<style>
#menu_vertical a {
        display:inline;
        padding:3px;
}
</style>
<display:table name="${form.noticias}"
                        requestURI="" export="false"
                        id="noticia"  style="border:1"
                        cellpadding="0" cellspacing="0"  sort="list"
                        partialList="False" pagesize="1">

                        <display:column style="valign:top;" >
                                <ul id="lista_de_noticias" style="padding-left:0px;line-height: 150%;">
                                <li>
                                <a href="<rewrite:rewrite url="${initParam.url_portada_noticias}"/>/${fn:replace(fn:replace(noticia.tituloCodex,"?", "_"),"&#37","_")}/${noticia.id }"><b>${noticia.titulo}</b></a>
                                <em><fmt:formatDate value="${noticia.fechaPublicacion.time}" pattern="dd/MM/yyyy"/></em>
                                <p style="background: white;font-size:90%;padding: 6px;">${noticia.resumen}<br>
                                </li>
                                </ul>

                        </display:column>
                        <display:setProperty name="basic.msg.empty_list"> </display:setProperty>
                        <!-- sobreescribimos las propiedades del displayTag porque aqui no tenemos el div caja tabla  -->
                        <c:set var="paginacion"> <bean:message key="noticias.paginacion"/> </c:set>
                        <c:set var="anterior"> <bean:message key="noticias.anterior"/> </c:set>
                        <c:set var="siguiente"> <bean:message key="noticias.siguiente"/> </c:set>

                        <display:setProperty name="paging.banner.full"> <hr/><strong class="oculto">${paginacion}:</strong><div class="paginacion"><ul id="navlist" style="font-size: 100%;widht: 85%; display:inline;"></a><li><a href="{2}">${anterior}</a></li>{0}<li><a href="{3}" style="display:inline;">${siguiente}</a></li></ul></div> </display:setProperty>
                    <display:setProperty name="paging.banner.first"> <hr/><strong class="oculto">${paginacion}:</strong><div class="paginacion" ><ul id="navlist" style="font-size: 100%;widht: 85%; display:inline;">{0}<li><a href="{3}" style="display:inline;">${siguiente}</a></li></ul></div> </display:setProperty>
                    <display:setProperty name="paging.banner.last"> <hr/><strong class="oculto">${paginacion}:</strong><div class="paginacion" ><ul id="navlist" style="font-size: 100%;widht: 85%; display:inline;"><li><a href="{2}" style="display:inline;">${anterior}</a></li>{0}</ul></div> </display:setProperty>

                    <display:setProperty name="paging.banner.onepage"> </display:setProperty>
</display:table>

</div>

        </div></div></div></div>
</div>
<!-- End of bubble -->
</div>
<!-- End of news bubble -->
<% }//if } %>
<%-- 08/09/2010 Fernando Garcia --%>
<%--            End of the new block --%>



</div>
<!-- End of navigation menu bubble -->

</div>
<!-- FIN NAVEGACIÓN VERTICAL -->
<!-- FIN NAVEGACIÓN VERTICAL -->

<!--
<ul class="destacados">
<li><a href="<rewrite:rewrite url="${initParam.url_feeds}"/>" class="des_01" title="<bean:message key="menu.lateral.generico.rssFeeds" />"><span><bean:message key="menu.lateral.generico.rssFeeds" /></span></a></li>
</ul>
-->



<!-- <hr/> -->
<!-- </div> -->
<!-- FIN LATERAL IZQUIERDO -->
<!-- FIN LATERAL IZQUIERDO -->
