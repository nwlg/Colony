<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.andromda.org/tags-breadcrumbs" prefix="breadcrumbs" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<tiles:insert definition="layout-sinlateral">
    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>
    <tiles:put name="body" type="string">
       <div class="plantilla_contenido">
			<form method="post" action="<html:rewrite action=""/>" >
				<h2>${form.tituloTesauro}</h2>
				<div class="caja_tabla" >
					<p><bean:message key="navegar.tesauro.explicacion.taxonomia"/></p>
					<div class="breadcrumb_curricular">
						<html:link styleClass="br_carpeta_abierta" action="/NavegarTesauroCU/NavegarTesauroCU.do?tipoBusquedaArbol=${form.tipoBusquedaArbol}&tituloTesauro=${form.tituloTesauro}">
    						<bean:message key="navegar.tesauro.nombre.inicio"/><br/>
      					</html:link>
						 <c:if test="${!empty form.rutaTesauro}">
							 <c:set var="longitud" value="${ fn:length(form.rutaTesauro)}"/>
							 <fmt:formatNumber var="nombre" value="${longitud -1}" type="number"/>
							 <fmt:formatNumber var="nombre2" value="${longitud -2}" type="number"/>
							 <c:if test="${longitud>0 }">
							 	<c:if test="${nombre2>=0 }">
								   <c:forEach items="${form.rutaTesauro}" var="ruta" begin="0" end="${nombre2}">
								    	<em class="oculto">-</em>
								    	<html:link styleClass="br_carpeta_abierta" action="/NavegarTesauroCU/NavegarTesauroSeleccionarPadre.do?idTesauro=${ruta.id}&tipoBusquedaArbol=${form.tipoBusquedaArbol}&tituloTesauro=${form.tituloTesauro}">
						        			<c:out value="${ruta.valorTax}"/><br/>
						        		</html:link>
								    </c:forEach>
								</c:if>
							    <c:set var="ultimo" value="${ form.rutaTesauro[nombre]}"/>
							    <logic:equal name="form" property="esHoja" value="false">
							    	<html:link styleClass="br_carpeta_abierta" action="/NavegarTesauroCU/NavegarTesauroSeleccionarPadre.do?idTesauro=${form.rutaTesauro[nombre].id}&tipoBusquedaArbol=${form.tipoBusquedaArbol}&tituloTesauro=${form.tituloTesauro}">
					        			<c:out value="${ultimo.valorTax}"/><br/>
					        		</html:link>
								</logic:equal>
								<logic:equal name="form" property="esHoja" value="true">
							    	<span class="br_carpeta_abierta">
								    	 <c:out value="${ultimo.valorTax}"/><br/>
								     </span>
								</logic:equal>
							</c:if>
							
						     <em>(<c:out value="${form.numMaxResultados}"/>
							     <c:if test="${form.numMaxResultados==1 }">
							     	<bean:message key="listarODE.arbolCurricular.objeto"/>
							     </c:if>
							      <c:if test="${form.numMaxResultados!=1 }">
							      	<bean:message key="listarODE.arbolCurricular.objetos"/>
							 </c:if>)</em>
				 		</c:if>
					</div>
				</div>
				<div class="caja_tabla">
					<display:table name="${form.resultadosVO}" requestURI="" class="generica" export="false" cellpadding="0" cellspacing="0" id="resultado">    
				        <display:setProperty name="css.tr.odd" value="tr_blanco"/>
				        <display:setProperty name="css.tr.even" value="tr_gris"/>
				        <!-- <display:setProperty name="basic.show.header" value="true"/> -->
				        <!-- <display:setProperty name="paging.banner.placement" value="bottom"/> -->
				        
				        <display:column paramProperty="titulo" class="new" >
				        	<logic:equal name="resultado" property="esVisualizable" value="true">
					            <a href="<html:rewrite action="/ListarODETesauroCU/ListadoODEDecidirSalida.do"/>?identificadorODE=${resultado.id}&amp;tesauroBusqueda=${form.tesauroBusqueda}&amp;pagina=${form.pagina}&nodo=${resultado.nodo}&tipoBusquedaArbol=${form.tipoBusquedaArbol}&idioma=${form.idiomaBuscador}" class="paquete"> <c:out value="${resultado.titulo}" /></a>
					        </logic:equal>
					        <logic:equal name="resultado" property="esVisualizable" value="false">
					        	<span class="paquete"><span class="restringido"><c:out value="${resultado.titulo}" /></span></span>
					        </logic:equal>
				        </display:column>
					</display:table>
				</div>
				<!--  INICIO PAGINACION   -->
				<hr />
				
				<div class="paginacion">
					<ul id="navlist">
						
						<logic:notEmpty name="form" property="anterior">
							<li><a href="<html:rewrite action="/ListarODETesauroCU/ListarODETesauroCU.do"/>?idiomaBuscador=${form.idiomaBuscador}&amp;pagina=${form.anterior}&amp;tesauroBusqueda=${form.tesauroBusqueda}&tipoBusquedaArbol=${form.tipoBusquedaArbol}&tituloTesauro=${form.tituloTesauro}">
								<bean:message key="listarODE.arbolCurricular.anterior"/>
							</a></li>
						</logic:notEmpty>
						
						<logic:iterate name="form" property="paginas" id="pagina">
							<logic:equal name="form" property="pagina" value="${pagina}">
								<li>${pagina}</li>
							</logic:equal>
							<logic:notEqual name="form" property="pagina" value="${pagina}">
								<li><a href="<html:rewrite action="/ListarODETesauroCU/ListarODETesauroCU.do"/>?idiomaBuscador=${form.idiomaBuscador}&amp;pagina=${pagina}&amp;tesauroBusqueda=${form.tesauroBusqueda}&tipoBusquedaArbol=${form.tipoBusquedaArbol}&tituloTesauro=${form.tituloTesauro}">${pagina}</a></li>
							</logic:notEqual>
						</logic:iterate>
			
						<logic:notEmpty name="form" property="siguiente">
							<li><a href="<html:rewrite action="/ListarODETesauroCU/ListarODETesauroCU.do"/>?idiomaBuscador=${form.idiomaBuscador}&amp;pagina=${form.siguiente}&amp;tesauroBusqueda=${form.tesauroBusqueda}&tipoBusquedaArbol=${form.tipoBusquedaArbol}&tituloTesauro=${form.tituloTesauro}">
							<bean:message key="listarODE.arbolCurricular.siguiente"/>
							</a></li>
						</logic:notEmpty>
					</ul>
				</div> 
				<!--  FIN PAGINACION   -->		
			</form>
		</div>
    </tiles:put>
</tiles:insert>
