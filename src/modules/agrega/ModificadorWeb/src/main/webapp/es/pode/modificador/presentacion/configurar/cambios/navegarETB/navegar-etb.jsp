<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<tiles:insert definition="${sessionScope.offline == true ? 'layout-offline' : 'layout-administrador'}">
<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>
<tiles:put name="body" type="string">
<div class="plantilla_contenido">
<jsp:include page="/layout/messages.jsp" flush="true"/>
  <form method="post" id="navegarETBNavegarETBSeleccionarForm" action="<html:rewrite action="/NavegarETB/NavegarETBSeleccionar"/>">
	<h2>${tesauroSession.taxonomia.nombreTaxonomia}</h2>
	<p class="parrafo_comun" id="separacion2"><bean:message key="tesauro.explicacion"/></p>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
			<div class="breadcrumb_arbol">
		<html:link styleClass="br_carpeta_abierta" action="/NavegarETB/NavegarETBNavegar">
        				<bean:message key="tesauro.breadcrumb.inicio"/><br/>
      	</html:link>
		 <c:if test="${!empty form.taxonomia.taxonPath}">
		 <c:forEach items="${form.taxonomia.taxonPath}" var="ruta" varStatus="status">
		 <em class="oculto">-</em>
		 <c:choose>
		 <c:when test="${status.last}">
			<span class="br_carpeta_cerrada">
			${ruta.valorTax}<br/>
			</span>			
        </c:when>
        <c:otherwise>
	        <html:link styleClass="br_carpeta_abierta" action="/NavegarETB/NavegarETBNavegar?idTermino=${ruta.id}">
			${ruta.valorTax}<br/>
			</html:link>
        </c:otherwise>
        </c:choose>
		</c:forEach>
    	</c:if>
		</div>
<!--  INICIO CAPA TABLA   -->
<!--  INICIO CAPA TABLA   -->					
<div class="caja_tabla limpiar_breadcrumb_00">
		<bean:define id="summary"><bean:message key="tesauro.tablaTaxonesSummary"/></bean:define>
		<input type="hidden" value="${form.idTermino }"/>
		<display:table name="${form.taxonomia.hijos}" id="taxonesvoact" 
				style="border:1;width:100%" class="administracion_usuarios" cellpadding="0" 
				cellspacing="0" pagesize="10"
				summary="${summary}" requestURI="${pageContext.request.requestURL}">
				<display:caption><strong> <bean:message key="tesauro.tablaTaxonesvo"/></strong></display:caption>
        		<display:setProperty name="css.tr.odd" value="tr_gris"/>
        		<display:setProperty name="css.tr.even" value="tr_blanco"/>
        		<display:setProperty name="basic.show.header" value="false"/>
  				<display:column style="valign:top" class="new" autolink="true">
  					<html:link styleClass="carpeta_cerrada" action="/NavegarETB/NavegarETB?idTermino=${taxonesvoact.id}">
  						${taxonesvoact.valorTax}
  					</html:link>        		 
  				</display:column>
		</display:table>
	<%//Omito el cierre de capa </div>: se cierra en la paginacion %>
	<hr/>
	</div>
			

			<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->
	<!-- Inicio Botones  -->
	<!-- Inicio Botones  -->
	<fieldset class="tipo ft_centrada">
	<logic:notEmpty name="form" property="idTermino"><input class="boton_125_de_2" name="action" type="submit"  value="<bean:message key="tesauro.navegar.aceptar"/>" /></logic:notEmpty>
	<input class="boton_125_de_2_izq" name="action" type="submit"  value="<bean:message key="tesauro.navegar.cancelar"/>"/>
	</fieldset>
	</form>
</tiles:put>
</tiles:insert>