
<%@ taglib tagdir="/WEB-INF/tags" prefix="arb" %>
<%@ attribute name="taxonomia" type="es.pode.modificador.negocio.servicio.TaxonomiaVO" required="true" %>
<%@ attribute name="urlNavegar" required="true" %>
<%@ attribute name="urlActionKey" required="true" %>

<form method="post" id="tesauroAsociarForm" action="<html:rewrite action="${urlActionKey}"/>"><h2>
<bean:message key="tesauro.NomTesauro"/></h2>

<div class="caja_tabla" >
		<p><bean:message key="tesauro.explicacion"/></p>
		<div class="breadcrumb_curricular">
		<html:link styleClass="br_carpeta_abierta" action="${urlNavegar}?idTesauro=${form.idTesauro}&idioma=${form.idioma}">
        				<bean:message key="tesauro.Inicio"/><br/>
      	</html:link>
 		<c:if test="${!empty taxonomia.taxonPath}">
			 <c:set var="longitud" value="${ fn:length(taxonomia.taxonPath)}"/>
			 <fmt:formatNumber var="nombre" value="${longitud -1}" type="number"/>
			 <fmt:formatNumber var="nombre2" value="${longitud -2}" type="number"/>
			 <c:if test="${longitud>1 }">
 				<c:forEach items="${taxonomia.taxonPath}" var="ruta" begin="0" end="${nombre2}">
		    		<em class="oculto">-</em>
		    		<html:link styleClass="br_carpeta_abierta" action="${urlNavegar}?idTesauro=${ruta.id}">
        				<c:out value="${ruta.valorTax}"/><br/>
        			</html:link>
			    </c:forEach>
			 </c:if> 
			 <c:forEach items="${taxonomia.taxonPath}" var="ruta3" begin="${nombre}" end="${nombre}">
				 <em class="oculto">-</em>
					 <span class="br_carpeta_abierta">
				    	 <c:out value="${ruta3.valorTax}"/><br/>
				     </span>
			 </c:forEach>   
    	 </c:if>		  
		</div>
		<bean:define id="summary"><bean:message key="tesauro.tablaTaxonesSummary"/></bean:define>
		<display:table name="${taxonomia.hijos}" id="taxonesvoact" 
				style="border:1;width:100%" class="generica" cellpadding="0" 
				cellspacing="0" 
				summary="${summary}"  requestURI="" sort="list" pagesize="20" partialList="False">
				
				<display:caption><strong> <bean:message key="tesauro.tablaTaxonesvo"/></strong></display:caption>
        		<display:setProperty name="css.tr.odd" value="tr_gris"/>
        		<display:setProperty name="css.tr.even" value="tr_blanco"/>
        		<display:setProperty name="basic.show.header" value="false"/>
        		<display:setProperty name="paging.banner.placement" value="bottom" />
        		<!-- definimos las columnas -->
        		
		        <c:choose>
        			<c:when test="${taxonesvoact.esHoja}">
        				<display:column  class="carpeta_cerrada" autolink="true">
            				<c:out value="${taxonesvoact.valorTax}"/>
            			</display:column>	
	       			</c:when>
        			<c:otherwise>
        				<display:column  class="new" autolink="true">
        					<html:link styleClass="carpeta_cerrada" action="${urlNavegar}?idTesauro=${taxonesvoact.id}&nomTesauros=${taxonesvoact.valorTax}&idioma=${taxonomia.idioma}">
        						${taxonesvoact.valorTax}
        					</html:link>        		 
        				</display:column>	
        			</c:otherwise>
    			</c:choose>		        
		</display:table>
</div>
</form>
