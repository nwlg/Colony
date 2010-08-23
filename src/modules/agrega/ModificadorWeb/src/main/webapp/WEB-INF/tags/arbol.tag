
<%@ tag body-content="empty" %>
<%@ attribute name="taxonomia" type="es.pode.modificador.negocio.servicio.TaxonomiaVO" required="true" %>
<%@ attribute name="urlNavegar" required="true" %>
<%@ attribute name="urlActionKey" required="true" %>
<%@ attribute name="textoSeleccionar" required="true" %>
<%@ attribute name="textoCancelar" required="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<form method="post" id="taxonomiaAsociarForm" action="<html:rewrite action="${urlActionKey}"/>">
	<p class="parrafo_comun" id="separacion2"><bean:message key="modificacorWeb.explicacion.taxonomia"/></p>

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->

			<div id="formulario" >
			<div class="breadcrumb_arbol"><em class="oculto">-</em>
	
		<html:link styleClass="br_carpeta_abierta" action="${urlNavegar}">
   				<bean:message key="modificarWeb.inicio.taxonomia"/>
      	</html:link>
		 <c:if test="${!empty taxonomia.taxonPath}">
		   <c:forEach items="${taxonomia.taxonPath}" var="ruta" varStatus="status">
		    		<em class="oculto">-</em>
		    		<c:choose>
		    		<c:when test="${status.last}">
		    		<span class="br_carpeta_abierta no_b">
        				<c:out value="${ruta.valorTax}"/><br/>
        			</span>
        			</c:when>
        			<c:otherwise>
        			<html:link styleClass="br_carpeta_abierta" action="${urlNavegar}?idTermino=${ruta.id}">
        				<c:out value="${ruta.valorTax}"/><br/>
        			</html:link>
        			</c:otherwise>
        			</c:choose>
		    </c:forEach>
    	 </c:if>
		</div>
		
		<bean:define id="summary"><bean:message key="modificadorWeb.tabla.taxones.resumen"/></bean:define>
		<!--  INICIO CAPA TABLA   -->
		<!--  INICIO CAPA TABLA   -->	

		<div class="caja_tabla limpiar_breadcrumb_00" >
		
		
		<display:table name="${taxonomia.hijos}" id="taxonesvoact" 
				class="administracion_usuarios" cellpadding="0" 
				cellspacing="0"
				summary="${summary}" requestURI="${pageContext.request.requestURL}">
				
				<display:caption><strong> <bean:message key="modificadorWeb.tabla.taxones.vo"/></strong></display:caption>
        		<display:setProperty name="css.tr.odd" value="tr_gris"/>
        		<display:setProperty name="css.tr.even" value="tr_blanco"/>
        		<display:setProperty name="basic.show.header" value="false"/>
        		<!-- definimos las columnas -->
        		<display:column  class="sin_b">        	
					<label for="${taxonesvoact.id}" class="oculto" >
						<bean:message key="areaCurricular.seleccione.taxon"/> 
					</label>
					<input type="radio" name="idTermino" value="${taxonesvoact.id}"/>
		        </display:column>
		        <c:choose>
        			<c:when test="${taxonesvoact.esHoja}">
        				<display:column  class="new" autolink="true">
            				<c:out value="${taxonesvoact.valorTax}"/>
            			</display:column>	
	       			</c:when>
        			<c:otherwise>
        				<display:column  class="new" autolink="true">
        					<html:link action="${urlNavegar}?idTermino=${taxonesvoact.id}">
        						${taxonesvoact.valorTax}
        					</html:link>        		 
        				</display:column>	
        			</c:otherwise>
    			</c:choose>		        
		</display:table>
		</div>
	<!--  FIN CAPA TABLA   -->		
	<!--  FIN CAPA TABLA   -->
	
	</div>
	<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
	<!--  boton de seleccionar -->	
			<input type="hidden" name="action" value="Aceptar" />
	<input type="submit" class="boton_125_de_2 tipo" value="${textoSeleccionar}" />
</form>
<form	action="<html:rewrite action="${urlActionKey}"/>" method="post"><input class="boton_125_de_2_izq tipo"
			type="submit"
			value="${textoCancelar}" />
			<input type="hidden" name="action" value="Volver" />
</form>
		
