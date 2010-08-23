<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
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
 <h2><bean:message key="noticias.cabeceraNoticias"/></h2>
 <form action="<html:rewrite action="/Noticias/NoticiasEliminar"/>" method="post" enctype="multipart/form-data">

  <div class="caja_tabla" >
	<bean:define id="summary"><bean:message key="noticias.tablaAdministracionNoticias"/></bean:define>
	<bean:define id="tituloTitulo"><b><bean:message key="noticias.titulo.cabecera"/></b></bean:define>
	<bean:define id="estado"><b><bean:message key="noticias.estado.cabecera"/></b></bean:define>
	<bean:define id="fecha"><b><bean:message key="noticias.fecha.cabecera"/></b></bean:define>
	<bean:define id="idiomas"><b><bean:message key="noticias.idiomas.cabecera"/></b></bean:define>
	<bean:define id="categoria"><b><bean:message key="noticias.categoria.cabecera"/></b></bean:define>
	
	<bean:define id="valor" value="${form.idModificado}" scope="page"/>
	<bean:define id="atributo" value="idNoticia" scope="page"/>	
	   <display:table name="${form.noticias}"
	      requestURI="${pageContext.request.requestURL}"
	      export="false" id="fila" class="administracion_tareas"
		  style="border:2px;width:100%;" 
	  	  sort="list"
	  	  defaultorder="descending"
	  	  defaultsort="5"
		  cellpadding="0" cellspacing="0"
		  summary="${summary}" pagesize="10"
		  decorator="es.pode.administracion.presentacion.MarcarModificado">
		         
		        <display:caption><strong> <bean:message key="noticias.tablaAdministracionNoticias"/></strong></display:caption>
		        <display:setProperty name="css.tr.odd" value="tr_gris"/>
		        <display:setProperty name="css.tr.even" value="tr_blanco"/>
		        <display:setProperty name="basic.show.header" value="true"/>
		        
		        <display:column 
		        	style="valign:top;" 
		        	class="numeracion">        	
						<label for="${fila.idNoticia}" class="etiq_invisible"><bean:message key="noticias.Seleccione"/></label>	
		            	<input type="checkbox"  id="${fila.idNoticia}" value="${fila.idNoticia}" name="idNoticiaRowSelectionAsArray"/>
		        </display:column>
			
		<display:column 
			media="html"
			title="${tituloTitulo}" 
			sortProperty="titulo"
			sortable="true"
			style="valign:top;" 
			headerClass="max_tab alinea_a_izq2"
			class="alinea_a_izq2">
		      	<html:link action="/VerNoticia/VerNoticia.do?idNoticia=${fila.idNoticia}">${fila.titulo}</html:link>
	   </display:column>
	
	  
	   <display:column 
	   		media="html"
	   		title="${estado}" 
	   		sortProperty="activa"
			sortable="true"
	   		autolink="true" 
	   		paramId="activa">
		    	<span class="oculto">-</span>
		    	<logic:equal name="fila" property="activa" value="true">
	        		<bean:message key="estado.notica.activada"/>
	        	</logic:equal>
	        	<logic:equal name="fila" property="activa" value="false">
	        		<bean:message key="estado.notica.noactivada"/>
	        	</logic:equal>
	   </display:column>
		
	   <display:column 
	   		media="html"
	   		title="${fecha}" 
	   		sortProperty="fechaPublicacion"
			sortable="true"
	   		autolink="true" 
	   		paramId="fechaPublicacion"
	   		property="fechaPublicacion"
	   		decorator="es.pode.administracion.presentacion.noticias.noticias.ListarNoticiasColumDecorator" >
		    	<span class="oculto">-</span>	    		
					    
	   </display:column>	   
	   	   
	    <display:column 
	    	title="${idiomas}"
	    	style="valign:top;"
	    	class="td_idiomas">  
				<flags:banderas banderas="${fila.idiomas}" action="actionListado"/>            				
		</display:column>  
		
		<display:column 
			media="html"
			title="${categoria}" 
			sortProperty="categoria"
			sortable="true"
			autolink="true" 
			style="valign:top;"
			class="categoria_td">	
			${fila.categoria}
		      	
	   </display:column> 
		
	   <display:column 
	   		media="html" 
	   		autolink="true" 
	   		paramId="titulo">
		    	<span class="oculto">-</span>
		    	<html:link action="/Noticias/NoticiasModificar?idNoticia=${fila.idNoticia}"><bean:message key="noticias.modificar"/></html:link>
	   </display:column>		   

	  </display:table>
	<c:if test="${empty form.noticias}">
		</div>
	</c:if>
		<c:if test="${!empty form.noticias}">
	  		<input class="boton_125_de_2 tipo" style="position:relative" type="submit" value="<bean:message key="noticias.noticias.eliminar"/>" />
		</c:if>
	</form>
	<form id="noticiasNoticiasCrearNoticiaForm" action='<html:rewrite action="/Noticias/NoticiasCrearNoticia"/>' method="post">
		<p><input class="boton_125_de_2_izq tipo" style="position:relative" type="submit" value="<bean:message key="noticias.crearNoticia"/>" /></p>
	</form>	
	
	<fieldset class="tipo ft_centrada" >
		<form method="post" action="<html:rewrite action="/CategoriasNoticiasCU/CategoriasNoticiasCU"/>" >															
			<input class="boton_125" type="submit"  value="<bean:message key="noticias.listado.boton.categorias"/>" />			
		</form>
	</fieldset>
	
	
</div>
<!-- Fin plantilla contenido  -->

</tiles:put>
</tiles:insert>