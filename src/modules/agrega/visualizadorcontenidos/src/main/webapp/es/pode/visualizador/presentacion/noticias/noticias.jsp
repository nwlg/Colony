<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>

<tiles:insert definition="layout-usuario">
<tiles:put name="title" type="string">
	<bean:message key="title.Comun"/>
</tiles:put>
<tiles:put name="body" type="string">
<%@ include file="/taglib-imports.jspf" %>

<%@ include file="/es/pode/visualizador/presentacion/portada/noticias-vars.jspf" %>


<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>
	<h2>
		<bean:message key="portada.mensaje.noticias"/>
		
			<logic:notEmpty name="form" property="categoria">
				- ${form.categoria}
			</logic:notEmpty>
	</h2>

	<!-- Inicio NOTICIAS  -->

	<display:table name="${form.noticias}"
			requestURI="" export="false"
			id="noticia"  style="border:1;width:100%;"
			cellpadding="0" cellspacing="0"  sort="list"
			partialList="False" pagesize="3">
			
			<display:column style="valign:top;" >
				<ul id="lista_de_noticias">
				<li>
				<a href="<rewrite:rewrite url="${initParam.url_portada_noticias}"/>/${fn:replace(fn:replace(noticia.tituloCodex,"?", "_"),"&#37","_")}/${noticia.id}">${noticia.titulo}</a><br/>
				<em><fmt:formatDate value="${noticia.fechaPublicacion.time}" pattern="dd/MM/yyyy"/></em>
				<p>${noticia.resumen}<br/>
				<span><bean:message key="mostrarNoticia.categoria"/> 
				<a href="<rewrite:rewrite url="${initParam.url_noticias_categorias}"/>/${noticia.categoriaCodex}/${noticia.idCategoria}">${noticia.categoria}</a></span></p>
				</li>
				</ul>

			</display:column>
			
			<!-- sobreescribimos las propiedades del displayTag porque aqui no tenemos el div caja tabla  -->
			<c:set var="paginacion"> <bean:message key="noticias.paginacion"/> </c:set>
			<c:set var="anterior"> <bean:message key="noticias.anterior"/> </c:set>
			<c:set var="siguiente"> <bean:message key="noticias.siguiente"/> </c:set>
			
			<display:setProperty name="paging.banner.full"> <hr/><strong class="oculto">${paginacion}:</strong><div class="paginacion"><ul id="navlist"></a><li><a href="{2}">${anterior}</a></li>{0}<li><a href="{3}">${siguiente}</a></li></ul></div> </display:setProperty>
		    <display:setProperty name="paging.banner.first"> <hr/><strong class="oculto">${paginacion}:</strong><div class="paginacion" ><ul id="navlist">{0}<li><a href="{3}">${siguiente}</a></li></ul></div> </display:setProperty>
		    <display:setProperty name="paging.banner.last"> <hr/><strong class="oculto">${paginacion}:</strong><div class="paginacion" ><ul id="navlist"><li><a href="{2}">${anterior}</a></li>{0}</ul></div> </display:setProperty>
		    <display:setProperty name="paging.banner.onepage"> <br><br> </display:setProperty>
		   
	</display:table>



</div>

</tiles:put>
</tiles:insert>