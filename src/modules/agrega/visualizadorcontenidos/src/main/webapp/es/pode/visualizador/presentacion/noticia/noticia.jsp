<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tags/imagenNoticias.tld" prefix="image" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>

<tiles:insert definition="layout-usuario">

<tiles:put name="title" type="string">
	<bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/visualizador/presentacion/noticia/noticia-vars.jspf" %>
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>

	<h2>${form.titulo}</h2>
	<c:set var="noticiavo" value="${form.noticiavo}"/>
	<div id="contenido_noticia">
		<em><fmt:formatDate value="${noticiavo.fechaPublicacion.time}" pattern="dd/MM/yyyy"/></em>
		<em>${form.resumen}<br/><br/>
		
		
		<!--************************          TAG QUE PINTA LAS IMAGENES DE LAS NOTICIAS Y EL TEXTO      ****************************-->
		<image:imagenNoticias alineamiento="${form.alineamientoImg}" cuerpo="${form.cuerpo}" imagen="${form.URLImagen}"/> 	
		<p>
		<span>
			<bean:message key="mostrarNoticia.categoria"/>
			<a href="<rewrite:rewrite url="${initParam.url_noticias_categorias}"/>/${form.nombreCategoriaCodex}/${form.idCategoria }">
				${form.categoria}
			</a>
		</span>

		<span>
              <a href="<rewrite:rewrite url="${initParam.url_noticias_portada}"/>"><bean:message key="mostrarNoticia.verMasNoticias"/></a>
		</span>
		</p>
		</em>
	</div>	
	
</div>
</tiles:put>
<!-- Fin plantilla contenido  -->

</tiles:insert>
