<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="cc" %>
<%@ taglib uri="/WEB-INF/tags/banderas.tld" prefix="flags" %>


<tiles:insert definition="layout-administrador">
<tiles:put name="title" type="string">
	<bean:message key="title.Comun"/>
</tiles:put>
<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/es/pode/administracion/presentacion/noticias/noticias/noticias-vars.jspf" %>

<!--************************          Inicio plantilla contenido       ****************************-->
<div class="plantilla_contenido">
	<jsp:include page="/layout/messages.jsp" flush="true" />	
	<form action="<html:rewrite action="/CategoriasNoticiasCU/CategoriasNoticiasEliminar"/>" method="post" enctype="multipart/form-data">
		<h2><bean:message key="categorias.noticia.titulo.cabecera"/></h2>
		<div class="caja_tabla" id="marg_resultados_lis"> 			 
			<bean:define id="summary"><bean:message key="categorias.noticia.tablaAdministracionCategoria"/></bean:define>
			<bean:define id="nombreCategoriaNoticia"><b><bean:message key="categorias.noticia.columna.nombre"/></b></bean:define>	
			<bean:define id="idiomas"><b><bean:message key="categorias.noticia.columna.idiomas"/></b></bean:define>
		
			<bean:define id="valor" value="${form.idModificado}" scope="page"/>
			<bean:define id="atributo" value="idCategoriaNoticia" scope="page"/>	
		    <display:table name="${form.categoriasNoticias}"
		      requestURI="${pageContext.request.requestURL}"
		      export="false" id="filaCategoria" class="administracion_tareas"
			  style="border:2px;width:100%;" 
		  	  sort="list"
		  	  defaultorder="descending"
		  	  defaultsort="2"
			  cellpadding="0" cellspacing="0"
			  summary="${summary}" pagesize="10"
			  decorator="es.pode.administracion.presentacion.MarcarModificado">
			         
			  <display:caption><strong> <bean:message key="categorias.noticia.tablaAdministracionCategoria"/></strong></display:caption>
			        <display:setProperty name="css.tr.odd" value="tr_gris"/>
			        <display:setProperty name="css.tr.even" value="tr_blanco"/>
			        <display:setProperty name="basic.show.header" value="false"/>			        
			        <display:column 
			        	style="valign:top;" 
			        	class="numeracion">        	
							<label for="${filaCategoria.idCategoriaNoticia}" class="etiq_invisible"><bean:message key="noticias.Seleccione"/></label>	
			            	<input type="checkbox"  id="${filaCategoria.idCategoriaNoticia}" value="${filaCategoria.idCategoriaNoticia}" name="idCategoriaNoticiaRowSelectionAsArray"/>
			        </display:column>				
					<display:column 				
						title="${nombreCategoriaNoticia}" 
						sortProperty="nombreCategoria"
						sortable="true"
						style="valign:top;" 
						headerClass="max_tab alinea_a_izq2"
						class="alinea_a_izq2">						
			      			<html:link action="/VerCategoria/VerCategoria.do?idCategoriaNoticia=${filaCategoria.idCategoriaNoticia}">${filaCategoria.nombreCategoria} </html:link>
		   			</display:column>	   
			
		   			<display:column
		   				title="${idiomas}"
		   				style="valign:top;"
		   				class="td_idiomas">
		   					<flags:banderas banderas="${filaCategoria.idioma}" action="actionListado"/> 
		   			</display:column>
		   
				   <display:column 
				   		media="html" 
				   		autolink="true" 
				   		paramId="titulo"
				   		style="valign:top;">
					    	<span class="oculto">-</span>
					    	<html:link action="/ModificarCategoriaNoticiaCU/ModificarCategoriaNoticiaCU.do?idCategoriaNoticia=${filaCategoria.idCategoriaNoticia}"><bean:message key="noticias.modificar"/></html:link>
				   </display:column>
		   		<display:setProperty name="basic.show.header" value="true"/>
		  </display:table>
		</div>

		<!-- Inicio Botones  -->
		<!-- Inicio Botones  -->	
		<c:if test="${empty form.categoriasNoticias}">
		</div>
		</c:if>
		<c:if test="${!empty form.categoriasNoticias}">
	  		<input class="boton_125_de_2 "  type="submit"  value="<bean:message key="categorias.noticia.boton.eliminar"/>" />
		</c:if>	
	</form>
		
	<form method="post" action="<html:rewrite action="/CrearCategoriaNoticiaCU/CrearCategoriaNoticiaCU"/>" >
		<input class="boton_125_de_2_izq "  type="submit"  value="<bean:message key="categorias.noticia.boton.crear.categoria"/>" />
	</form>
	
	<fieldset class="tipo ft_centrada" >
		<form method="post" action="<html:rewrite action="/Noticias/Noticias"/>" >		
			<input class="boton_125" type="submit"  value="<bean:message key="categorias.noticias.boton.volver.noticias"/>" />
		</form>
	</fieldset>
	<!-- Fin Botones  -->
	<!-- Fin Botones  -->
</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
		

</tiles:put>
</tiles:insert>
