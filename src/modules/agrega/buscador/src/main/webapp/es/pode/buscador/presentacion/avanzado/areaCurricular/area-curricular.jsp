<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<tiles:insert definition="layout-sinlateralYsinbuscadorSuperior">

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="body" type="string">
	<%@ include file="/taglib-imports.jspf" %>
	
<!-- CUERPO PRINCIPAL  -->
  <div class="plantilla_contenido">
  <jsp:include page="/layout/messages.jsp" flush="true" />
  <form method="post" id="taxonomiaAsociarForm" action="<html:rewrite action="/AreaCurricularCU/AreaCurricularVolcarAreaCurricular"/>" enctype="multipart/form-data">
	<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
	<h2><bean:message key="areaCurricular.nombre"/></h2>
	<!--<h2>${catalogadorBasico.NomTaxonomia}</h2>-->
	
	
	<div class="caja_tabla" >
		<p><bean:message key="areaCurricular.explicacion.taxonomia"/></p>
		<div class="breadcrumb_curricular">
		<html:link styleClass="br_carpeta_abierta" action="/AreaCurricularCU/AreaCurricularCU.do?tipoLayoutBuscador=${form.tipoLayoutBuscador}">
        				<bean:message key="areaCurricular.inicio.taxonomia"/><br/>
      	</html:link>
		 <c:if test="${!empty form.rutaArbol}">
		 <c:set var="longitud" value="${ fn:length(form.rutaArbol)}"/>
		 <fmt:formatNumber var="nombre" value="${longitud -1}" type="number"/>
		 <fmt:formatNumber var="nombre2" value="${longitud -2}" type="number"/>
		 <c:if test="${longitud>1 }">
		   <c:forEach items="${form.rutaArbol}" var="ruta" begin="0" end="${nombre2}">
		    		<em class="oculto">-</em>
		    		<html:link styleClass="br_carpeta_abierta" action="/AreaCurricularCU/AreaCurricularSeleccionaPadre.do?id=${ruta.id}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}">
        				<c:out value="${ruta.valorTax}"/><br/>
        			</html:link>
		    </c:forEach>
		 </c:if>  
		  
      	 <c:forEach items="${form.rutaArbol}" var="ruta3" begin="${nombre}" end="${nombre}">
			 <em class="oculto">-</em>
				 <span class="br_carpeta_abierta">
			    	 <c:out value="${ruta3.valorTax}"/><br/>
			     </span>
		 </c:forEach>           	
        	 			
    	 </c:if>
		  
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
					<label for="${taxonesvoact.id}" class="etiq_invisible" >
						<bean:message key="areaCurricular.seleccione.taxon"/> 
					</label>
					<input type="radio" name="areaCurricular" id="${taxonesvoact.id}" value="${taxonesvoact.id}"/>
		        </display:column>
		        <c:choose>
        			<c:when test="${taxonesvoact.esHoja}">
        				<display:column  class="new" autolink="true">
            				<c:out value="${taxonesvoact.valorTax}"/>
            			</display:column>	
	       			</c:when>
        			<c:otherwise>
        				<display:column  class="new" autolink="true">
        					<html:link action="/AreaCurricularCU/AreaCurricularSeleccionaHijo?id=${taxonesvoact.id}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}">
        						${taxonesvoact.valorTax}
        					</html:link>        		 
        				</display:column>	
        			</c:otherwise>
    			</c:choose>		        
		</display:table>
	</div>
	
	
	<!-- Inicio Botones  -->
	<!-- Inicio Botones  -->
	<input class="boton_125_de_2"  type="submit"  value="<bean:message key="areaCurricular.boton.asociar"/>" />
	</form>
	<form method="post" enctype="multipart/form-data" action="/${initParam.url_buscadorAvanzado}">
		<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
	    <input class="boton_125_de_2_izq"  type="submit"  value="<bean:message key="areaCurricular.cancelar.seleccion"/>"/>
	</form>
	<!-- Fin Botones  -->
	</div>
	
</tiles:put>
</tiles:insert>
