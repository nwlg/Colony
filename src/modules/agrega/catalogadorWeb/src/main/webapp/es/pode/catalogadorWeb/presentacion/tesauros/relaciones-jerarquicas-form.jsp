<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado">

<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/tesauros/tesauros-form-vars.jspf" %>

<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
  <jsp:include page="/layout/messages.jsp" flush="true"/>
<form method="post" name="tesaurosRelacionesJerarquicasFormDatosRelacionForm" action="<html:rewrite action="/Tesauros/RelacionesJerarquicasFormDatosRelacion.do?nomTesauro=${nomTesauro}&idioma=${idioma}"/>" enctype="multipart/form-data">
<h2>${nomTesauro}</h2>

<div class="caja_tabla" >
		<p><bean:message key="tesauro.explicacion"/></p>
		<div class="breadcrumb_curricular"> 
		</div> 



<bean:define id="summary"><bean:message key="tesauro.tablaTaxonesSummary"/></bean:define>
		<display:table name="${taxonesvo}" id="taxonesvoact" 
				style="border:1;width:100%" class="generica" cellpadding="0" 
				cellspacing="0" 
				summary="${summary}"  requestURI="${pageContext.request.requestURL}">
				
				<display:caption><strong> <bean:message key="tesauro.tablaTaxonesvo"/></strong></display:caption>
        		<display:setProperty name="css.tr.odd" value="tr_gris"/>
        		<display:setProperty name="css.tr.even" value="tr_blanco"/>
        		<display:setProperty name="basic.show.header" value="false"/>
        		<display:setProperty name="paging.banner.placement" value="bottom" />
        		<!-- definimos las columnas -->
        		<display:column style="valign:top" class="sin_b">        	
					<label for="${taxonesvoact.id}" class="etiq_invisible" >
						<bean:message key="tesauro.Seleccione"/> 
					</label>
					<input type="radio" name="id" id="${taxonesvoact.id}" value="${taxonesvoact.id}"/>
				
		        </display:column>
		        <c:choose>
        			<c:when test="${!taxonesvoact.esHoja}">
        				<display:column  style="valign:top" class="new" autolink="true">
            				<c:out value="${taxonesvoact.valorTax}"/>
            			</display:column>	
	       			</c:when>
        			
    			</c:choose>		        
		</display:table>
</div>


<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo">



<input class="boton_125_de_2" type="submit" name="accionSubmit" value="<bean:message key="tesauro.Asociar"/>" />
</form>
<form method="post" enctype="multipart/form-data" action="<html:rewrite action="/Tesauros/TesaurosFormConsultaPadre?id=${form.id }&nomTesauro=${nomTesauro}&idioma=${idioma}"/>">

	 
        <input class="boton_125_de_2_izq"  type="submit"  value="<bean:message key="tesauro.Cancelar"/>"/>
</form>
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->

</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->

</tiles:put>

</tiles:insert>

