<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-tax">
<tiles:put name="title" type="string">
	<bean:message key="title.Taxonomia"/>
</tiles:put>


<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/taxonomias/taxonomia-vars.jspf" %>

<!-- CUERPO PRINCIPAL  -->
  <div class="plantilla_contenido">
  <!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
  <jsp:include page="/layout/messages.jsp" flush="true"/>
  <form method="post" id="taxonomiaAsociarForm" action="<html:rewrite action="/Taxonomias/TaxonomiaAsociar.do?nomTaxonomia=${nomTaxonomia}&idioma=${idioma}&vocabName=${vocabName }"/>" enctype="multipart/form-data">
	<h2>${vocabName}</h2>
	<!--<h2>${catalogadorBasico.NomTaxonomia}</h2>-->
	
	
	<div class="caja_tabla" >
		<p><bean:message key="taxonomia.explicacion"/></p>
		<div class="breadcrumb_curricular">
		<html:link styleClass="br_carpeta_abierta" action="/Taxonomias/Taxonomias?idioma=${idioma}&nomTaxonomia=${nomTaxonomia}&vocabName=${vocabName }">
        				<bean:message key="taxonomia.Inicio"/><br/>
      	</html:link>
		 <c:if test="${!empty form.rutaPadrevo}">
		 <c:set var="longitud" value="${ fn:length(form.rutaPadrevo)}"/>
		 <fmt:formatNumber var="nombre" value="${longitud -1}" type="number"/>
		 <fmt:formatNumber var="nombre2" value="${longitud -2}" type="number"/>
		 <c:if test="${longitud>1 }">
		   <c:forEach items="${form.rutaPadrevo}" var="ruta" begin="0" end="${nombre2}">
		    		<em class="oculto">-</em>
		    		<html:link styleClass="br_carpeta_abierta" action="/Taxonomias/TaxonomiaConsultaPadre?id=${ruta.id}&nomTaxonomia=${nomTaxonomia}&idioma=${idioma}&vocabName=${vocabName }">
        				<c:out value="${ruta.valorTax}"/><br/>
        			</html:link>
		    </c:forEach>
		 </c:if>  
		  
      	 <c:forEach items="${form.rutaPadrevo}" var="ruta3" begin="${nombre}" end="${nombre}">
			 <em class="oculto">-</em>
				 <span class="br_carpeta_abierta">
			    	 <c:out value="${ruta3.valorTax}"/><br/>
			     </span>
		 </c:forEach>           	
        	 			
    	 </c:if>
		  
		</div>
		<bean:define id="summary"><bean:message key="taxonomia.tablaTaxonesSummary"/></bean:define>
		<display:table name="${taxonesvo}" id="taxonesvoact" 
				style="border:1;width:100%" class="generica" cellpadding="0" 
				cellspacing="0" 
				summary="${summary}" requestURI="${pageContext.request.requestURL}">
				
				<display:caption><strong> <bean:message key="taxonomia.tablaTaxonesvo"/></strong></display:caption>
        		<display:setProperty name="css.tr.odd" value="tr_gris"/>
        		<display:setProperty name="css.tr.even" value="tr_blanco"/>
        		<display:setProperty name="basic.show.header" value="false"/>
        		<!-- definimos las columnas -->
        		<display:column style="valign:top" class="sin_b">        	
					<label for="${taxonesvoact.id}" class="etiq_invisible" >
						<bean:message key="taxonomia.Seleccione"/> 
					</label>
					<input type="radio" name="id" id="${taxonesvoact.id}" value="${taxonesvoact.id}"/>
		        </display:column>
		        <c:choose>
        			<c:when test="${taxonesvoact.esHoja}">
        				<display:column style="valign:top" class="new" autolink="true">
            				<c:out value="${taxonesvoact.valorTax}"/>
            			</display:column>	
	       			</c:when>
        			<c:otherwise>
        				<display:column style="valign:top" class="new" autolink="true">
        					<html:link action="/Taxonomias/TaxonomiaConsultarNodo?id=${taxonesvoact.id}&nomTaxonomia=${nomTaxonomia}&idioma=${idioma}&vocabName=${vocabName }">
        						${taxonesvoact.valorTax}
        					</html:link>        		 
        				</display:column>	
        			</c:otherwise>
    			</c:choose>		        
		</display:table>
	</div>
	
	
	<!-- Inicio Botones  -->
	<!-- Inicio Botones  -->
	<input class="boton_125_de_2"  type="submit"  value="<bean:message key="catalogadorBasico.Asociar"/>" />
	</form>
	<form method="post" enctype="multipart/form-data" action="<html:rewrite action="/Taxonomias/TaxonomiaCancelar"/>">
	  <input class="boton_125_de_2_izq"  type="submit"  value="<bean:message key="catalogadorBasico.Cancelar"/>"/>
	</form>
	<!-- Fin Botones  -->
	</div>
	
</tiles:put>
</tiles:insert>
