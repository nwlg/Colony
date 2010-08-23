<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.andromda.org/tags-breadcrumbs" prefix="breadcrumbs" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<tiles:insert definition="layout-sinlateral">
    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>
	<tiles:put name="body" type="string">
		<%@ include file="/layout/messages.jsp"%>
     <div class="plantilla_contenido">
			<h2><bean:message key="navegar.arbolCurricular.nombre"/></h2>
			<div class="caja_tabla" >
				<p><bean:message key="navegar.arbolCurricular.explicacion.taxonomia"/></p>
				<div class="breadcrumb_curricular">
					<c:set var="longitud" value="${ fn:length(form.rutaArbol)}"/>
					<fmt:formatNumber var="nombre" value="${longitud -1}" type="number"/>
					<fmt:formatNumber var="nombre2" value="${longitud -2}" type="number"/>
					<c:set var="ultimo" value="${ form.rutaArbol[nombre]}"/>
					<form method="post" action="<html:rewrite action="/NavegarArbolCurricularCU/ArbolCurricularListarODEArea.do?areaCurricularBusqueda=${ultimo.id}&tipoBusquedaArbol=${form.tipoBusquedaArbol}"/>" enctype="multipart/form-data">
						<html:link styleClass="br_carpeta_abierta" action="/NavegarArbolCurricularCU/ArbolCurricularSeleccionarHijo.do?tipoBusquedaArbol=${form.tipoBusquedaArbol}">
       						<bean:message key="navegar.arbolCurricular.taxonomia"/><br/>
			      		</html:link>
					 	<c:if test="${!empty form.rutaArbol}">
							<c:if test="${longitud>1 }">
							   <c:forEach items="${form.rutaArbol}" var="ruta" begin="0" end="${nombre2}">
							    	<em class="oculto">-</em>
							    	<html:link styleClass="br_carpeta_abierta" action="/NavegarArbolCurricularCU/ArbolCurricularSeleccionarPadre.do?areaCurricularBusqueda=${ruta.id}&tipoBusquedaArbol=${form.tipoBusquedaArbol}">
					        			<c:out value="${ruta.valorTax}"/><br/>
					        			</html:link>
							    </c:forEach>
	 						</c:if>
				      	 	<c:forEach items="${form.rutaArbol}" var="ruta3" begin="${nombre}" end="${nombre}">
								 <em class="oculto">-</em>
									 <span class="br_carpeta_abierta">
								    	 <c:out value="${ruta3.valorTax}"/><br/>
								     </span>
								     <em>(<c:out value="${form.numeroResultados}"/>
									     <c:if test="${form.numeroResultados==1 }">
									     	<bean:message key="navegar.arbolCurricular.objeto"/>
									     </c:if>
									      <c:if test="${form.numeroResultados!=1 }">
									      	<bean:message key="navegar.arbolCurricular.objetos"/>
									     </c:if>)</em>
									     <c:if test="${form.numeroResultados>0 }">
								 			<input class="boton_60" type="submit"  value="<bean:message key="navegar.arbolCurricular.ver"  />"/>
								 		</c:if>
						 	</c:forEach>
  	 					</c:if>
  	 				</form>
				</div>
				<bean:define id="summary"><bean:message key="areaCurricular.tabla.taxones.resumen"/></bean:define>
				<display:table name="${form.nodos}" id="taxonesvoact" 
					class="generica" cellpadding="0" 
					cellspacing="0"
					summary="${summary}" requestURI="${pageContext.request.requestURL}">
					
					<display:caption><strong> <bean:message key="areaCurricular.tabla.taxones.vo"/></strong></display:caption>
	        		<display:setProperty name="css.tr.odd" value="tr_gris"/>
	        		<display:setProperty name="css.tr.even" value="tr_blanco"/>
	        		<display:setProperty name="basic.show.header" value="false"/>
	        		<!-- definimos las columnas -->
	        		<display:column  class="sin_b">        	
						<label for="${taxonesvoact.identificador}" class="etiq_invisible" >
							<bean:message key="areaCurricular.seleccione.taxon"/> 
						</label>
			        </display:column> 
			        <c:choose>
	        			<c:when test="${taxonesvoact.esHoja}">
	        				<display:column class="new" autolink="true">
	        					<c:if test="${taxonesvoact.numeroOdesAsociados==0}">
	        						<span class="carpeta_cerrada"  style="display:inline">
								    	 <strong><c:out value="${taxonesvoact.nombre}"/></strong>
								     </span>
	        					</c:if>
	        					<c:if test="${taxonesvoact.numeroOdesAsociados!=0}">
			            			<strong><html:link styleClass="carpeta_cerrada" style="display:inline" action="/NavegarArbolCurricularCU/ArbolCurricularListarODEArea.do?areaCurricularBusqueda=${taxonesvoact.identificador}&tipoBusquedaArbol=${form.tipoBusquedaArbol}&numMaxResultados=${taxonesvoact.numeroOdesAsociados}">
			        					${taxonesvoact.nombre} 
			        				</html:link></strong>
		        				</c:if>
	        					<em  style="display:inline;">(<c:out value="${taxonesvoact.numeroOdesAsociados}"/>
									     <c:if test="${taxonesvoact.numeroOdesAsociados==1 }">
									     	<bean:message key="navegar.arbolCurricular.objeto"/>
									     </c:if>
									      <c:if test="${taxonesvoact.numeroOdesAsociados!=1 }">
									      	<bean:message key="navegar.arbolCurricular.objetos"/>
									     </c:if>)</em>
	            			</display:column>	
		       			</c:when>
	        			<c:otherwise>
	        				<display:column  class="new" autolink="true">
	        					<c:if test="${taxonesvoact.numeroOdesAsociados==0}">
	        						<span class="carpeta_cerrada"  style="display:inline">
								    	 <strong ><c:out value="${taxonesvoact.nombre}"/></strong>
								     </span>
	        					</c:if>
	        					<c:if test="${taxonesvoact.numeroOdesAsociados!=0}">
		        				<strong><html:link styleClass="carpeta_cerrada" style="display:inline" action="/NavegarArbolCurricularCU/ArbolCurricularSeleccionarHijo?areaCurricularBusqueda=${taxonesvoact.identificador}&tipoBusquedaArbol=${form.tipoBusquedaArbol}&numeroResultados=${taxonesvoact.numeroOdesAsociados}">
		        					${taxonesvoact.nombre} 
		        				</html:link></strong>
	        					</c:if>
	        					<em  style="display:inline;">(<c:out value="${taxonesvoact.numeroOdesAsociados}"/>
									     <c:if test="${taxonesvoact.numeroOdesAsociados==1 }">
									     	<bean:message key="navegar.arbolCurricular.objeto"/>
									     </c:if>
									      <c:if test="${taxonesvoact.numeroOdesAsociados!=1 }">
									      	<bean:message key="navegar.arbolCurricular.objetos"/>
									     </c:if>)</em>    
	        				</display:column>	
	        			</c:otherwise>
	    			</c:choose>	      
				</display:table>
				
			</div>
		</div>
		<form action="<html:rewrite action="/SeleccionTipoBusquedaCU/SeleccionTipoBusquedaCU.do"/>" method="post">
					<fieldset class="tipo ft_centrada">
						<input class="boton_125" type="submit" value="<bean:message key="navegar.arbolCurricular.volver"/>"/>
					</fieldset>
		</form>
   	</tiles:put>
</tiles:insert>
