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
<!-- ********************************************************************************************  -->
<!-- ***************************            listado de faqs          ****************************  -->
<!-- ********************************************************************************************  -->

<%@ include file="/es/pode/administracion/presentacion/faqs/faqs/faqs-javascript.jspf" %>

<!-- *******************          Inicio plantilla contenido        *****************************  -->
<div class="plantilla_contenido">
	<jsp:include page="/layout/messages.jsp" flush="true" />
	<h2> <bean:message key="faqs.faqs.title"/> </h2>
	<form id="faqsFaqsEliminarForm" action="<html:rewrite action='Faqs/FaqsEliminar'/>" method="post">
		<div id="ficha_pestanias">
			<ul class="alineado_izq">
				<!-- la primera es todas, la siguiente son las categorias -->
				<logic:iterate id="idioma" collection="${form.idiomas}" indexId="indice">			
					<c:if test="${indice==0}">
						<c:if test="${idioma==form.idiomaSeleccionado}">
							<li id="pest_activa"><a href="<html:rewrite action='/Faqs/Faqs.do'/>" id="seleccionada">${idioma}</a></li>
						</c:if>
						<c:if test="${idioma!=form.idiomaSeleccionado}">
							<li><a href="<html:rewrite action='/Faqs/Faqs.do'/>?idiomaSeleccionado=${idioma}">${idioma}</a></li>
						</c:if>
					 </c:if>
			 
					 <c:if test="${indice!=0}">
			 			<logic:iterate id="idiomaIdi" collection="${idioma}" indexId="indiceIdi">
			 				<c:if test="${idiomaIdi==form.idiomaSeleccionado}">
								<li id="pest_activa">
									<flags:banderas banderas="${idiomaIdi}" action="actionPestanhasSeleccionada"/> 
								 </li>
							</c:if>
							<c:if test="${idiomaIdi!=form.idiomaSeleccionado}">
								<li>
									<flags:banderas banderas="${idiomaIdi}" action="actionPestanhas"/> 
								</li>
							</c:if>					
						</logic:iterate>
					</c:if>
				</logic:iterate>			
			</ul>
		</div>
		<!-- Fin PESTANIAS de FICHA --> 		
		
		<!-- Inicio CONTENIDO PESTANIAS -->
		<div class="interno_ficha">
			<div class="plantilla_contenido_pestanias">
				<div class="caja_tabla" >
					<bean:define id="summary"><bean:message key="faqs.faqs.TablaAdministracionFaqs"/></bean:define>
					<bean:define id="tituloTitulo"><b><bean:message key="noticias.titulo.cabecera"/></b></bean:define>	
					<bean:define id="fecha"><b><bean:message key="noticias.fecha.cabecera"/></b></bean:define>
					<logic:equal name="form" property="idiomaSeleccionado" value="TODAS">	
						<bean:define id="idiomas"><b><bean:message key="noticias.idiomas.cabecera"/></b></bean:define>
					</logic:equal>
					<bean:define id="categoria"><b><bean:message key="noticias.categoria.cabecera"/></b></bean:define>	
					
					<logic:notEqual name="form" property="idiomaSeleccionado" value="TODAS">	
						<bean:define id="posicion"><b><bean:message key="categorias.faqs.columna.posicion"/></b></bean:define>	
					</logic:notEqual>		
    			
    				<bean:define id="valor" value="${form.idModificado}" scope="page"/>
					<bean:define id="atributo" value="id" scope="page"/>	
  						<display:table name="${form.faqs}" 
  						requestURI="${pageContext.request.requestURL}"
       					export="false" id="row" class="administracion_tareas"
       				    style="border:1;width:100%;" sort="list" cellpadding="0" cellspacing="0" 
        				defaultsort="5" summary="${summary}" pagesize="10"
        				decorator="es.pode.administracion.presentacion.MarcarModificado">
         
				        <display:caption><strong> <bean:message key="faqs.faqs.TablaAdministracionFaqs"/></strong></display:caption>
				        <display:setProperty name="css.tr.odd" value="tr_gris"/>
				        <display:setProperty name="css.tr.even" value="tr_blanco"/>
				        <display:setProperty name="basic.show.header" value="true"/>
        
					        <display:column style="valign:top;" class="numeracion">        	
								<label for="${row.id}" class="etiq_invisible" ><bean:message key="faqs.faqs.Seleccione"/> </label>	
					            <input type="checkbox"  id="${row.id}" value="${row.id}" name="idRowSelectionAsArray"/>
					        </display:column>         
	        
					        <display:column  
					        	media="html"
					        	title="${tituloTitulo}" 
					        	sortProperty="pregunta"
								sortable="true"
					        	autolink="true" 
					        	style="valign:top;" 
					        	class="alinea_a_izq2">	
								<c:set var="link"><html:rewrite action="/Faqs/FaqsVerFaq"/>?id=${row.id}</c:set>					        	
					        	<html:link href="${link}">
					        	 	${row.pregunta}
					        	</html:link>
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
						   	        				
	        				<logic:equal name="form" property="idiomaSeleccionado" value="TODAS">
					           <display:column  
					             title="${idiomas}"	
					             style="valign:top;"
					             class="td_idiomas">
					        	   <flags:banderas banderas="${row.idiomas}" action="actionListado"/> 
					           </display:column>
				           </logic:equal> 	
				           
				           <display:column 
					        	media="html"			
								title="${categoria}" 
								sortProperty="categoria"
								sortable="true"
								autolink="true" 
								style="valign:top;"
								class="categoria_td">	
								${row.categoria}		      	
						   </display:column>					       		   						   
						   
						   <logic:notEqual name="form" property="idiomaSeleccionado" value="TODAS">
						   		<display:column 
						   		media="html"				
								title="${posicion}" 
								sortProperty="posicion"
								sortable="true"
								autolink="true" 
								style="valign:top;"
								class="categoria_td">	
								${row.posicion}		      	
						   </display:column>
						   </logic:notEqual>
	        
					        <display:column media="html" autolink="true" paramId="titulo">
					            <span class="oculto">-</span>
					            
					            <c:set var="link"><html:rewrite action="/Faqs/FaqsModificar"/>?id=${row.id}</c:set>
					        	<html:link href="${link }">
									<bean:message key="faqs.faqs.Modificar"/>
					        	</html:link>
					        </display:column>
					</display:table>
					</div>
					</div>
					</div>
			
			<c:if test="${!empty form.faqs}">
	    		<input class="boton_125_de_2 tipo" style="position:relative" type="submit" value="<bean:message key="faqs.faqs.Eliminar"/>"  />
			</c:if>
		</form>		
		<form action='<html:rewrite action="/Faqs/FaqsCrearFaq"/>' method="post">
		   	<p><input class="boton_125_de_2_izq tipo" type="submit" value="<bean:message key="faqs.faqs.CrearFaqs"/>"/></p>
		</form>
		<fieldset class="tipo ft_centrada" >
		<form method="post" action="<html:rewrite action="/CategoriasFaqs/CategoriasFaqs"/>" >														
			<input class="boton_125" type="submit"  value="<bean:message key="noticias.listado.boton.categorias"/>" />			
		</form>
		</fieldset>		
	


<!-- Fin CONTENIDO PESTANIAS -->
</div>
  <!--*********************          Fin plantilla contenido         ***************************  -->
</tiles:put>
</tiles:insert>