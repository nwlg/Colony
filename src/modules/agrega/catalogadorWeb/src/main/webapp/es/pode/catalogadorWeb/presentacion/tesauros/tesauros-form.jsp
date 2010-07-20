<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<tiles:insert definition="layout-avanzado">

<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/es/pode/catalogadorWeb/presentacion/tesauros/tesauros-form-vars.jspf" %>


<div class="plantilla_contenido">

<h2>${form.vocabName}</h2>
<p class="parrafo_comun" id="separacion2"><bean:message key="tesauro.explicacionBusc"/></p>
<!-- Inicio caja buscador -->
<!-- Inicio caja buscador -->
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" id="conmargen" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<form method="post" action="<html:rewrite action="/Tesauros/TesaurosFormBuscar?nomTesauro=${nomTesauro}&idioma=${idioma}&vocabName=${form.vocabName }"/>">
			
			<div id="formulario" >
		
  				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda"><label class="oculto" for="buscadorContenido02">Buscador:</label></div>
					<div class="contenedor_derecha2">
						<div class="text">
						<input name="textoBusqueda" onfocus="limpiarTexto(this)" value="${textoBusqueda}"  onblur="this.style.backgroundColor='#e1e1e1'" id="buscadorContenido02" type="text" title="<bean:message key="catalogadorAvanzado.IntroduzcaBuscar"/>"  />
						<br class="oculto" /><br class="oculto" />
						<input class="buscar"  type="submit" name="buscar" value="Buscar" />
						<br class="oculto" /></div>
					</div>
					<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>
				
				</div>
				</form>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->
<!-- Fin caja buscador -->
<!-- Fin caja buscador --> 

<form method="post" name="tesauroAsociarForm" action="<html:rewrite action="/Tesauros/TesaurosFormAsociarTesauro.do?nomTesauro=${nomTesauro}&idioma=${idioma}&id=${identificador }"/>" enctype="multipart/form-data">


<div class="caja_tabla" >
		
		<div class="breadcrumb_curricular">
		<p class="parrafo_comun" id="separacion2"><bean:message key="tesauro.explicacion"/></p>
		<html:link styleClass="br_carpeta_abierta" action="/Tesauros/Tesauros?idioma=${idioma}&nomTesauro=${nomTesauro}&vocabName=${form.vocabName }">
        				<bean:message key="tesauro.Inicio"/><br/>
      	</html:link>
 
      
		 <c:if test="${!empty form.rutaPadrevo}">
		 <c:forEach items="${form.rutaPadrevo}" var="jerarquiaVO">
		 	<c:set var="rutaVO" value="${ jerarquiaVO.jerarquia}"/>
		 	<c:set var="longitud" value="${ fn:length(rutaVO)}"/>
		 	<fmt:formatNumber var="nombre" value="${longitud -1}" type="number"/>
		 	<c:if test="${longitud>=1 }">
		   	<c:forEach items="${rutaVO}" var="ruta" begin="0" end="${nombre}" varStatus="status">
		    		<em class="oculto">-</em>

        			<c:if test="${status.index==nombre}" >
        				<c:set var="identificador" value="${ruta.id}"/>

        			</c:if>

		    		<html:link styleClass="br_carpeta_abierta" action="/Tesauros/TesaurosFormConsultaPadre?id=${ruta.id}&nomTesauro=${nomTesauro}&idioma=${idioma}&vocabName=${form.vocabName }">
        				<c:out value="${ruta.valorTax}"/><br/>
        			</html:link>
        			

		    </c:forEach>
		 </c:if> 
		 </c:forEach>
		
		 
	
		     	
        	 			
    	 </c:if>
		  
		</div> 



<bean:define id="summary"><bean:message key="tesauro.tablaTaxonesSummary"/></bean:define>
		<display:table name="${taxonesvo}" id="taxonesvoact" 
				style="border:1;width:100%" class="generica" cellpadding="0" 
				cellspacing="0" 
				summary="${summary}"  requestURI="" sort="list" pagesize="20" partialList="False">
				
				<display:caption><strong> <bean:message key="tesauro.tablaTaxonesvo"/></strong></display:caption>
        		<display:setProperty name="css.tr.odd" value="tr_gris"/>
        		<display:setProperty name="css.tr.even" value="tr_blanco"/>
        		<display:setProperty name="basic.show.header" value="false"/>
        		<display:setProperty name="paging.banner.placement" value="bottom" />
        		<display:setProperty name="basic.msg.empty_list"><bean:message key="busquedaTesauroVacia"/></display:setProperty>
        		
        		<!-- definimos las columnas -->
        		
		        <c:choose>
        			<c:when test="${taxonesvoact.esHoja}">
        				<display:column  class="carpeta_cerrada" autolink="true">
            				<c:out value="${taxonesvoact.valorTax}"/>
            			</display:column>	
	       			</c:when>
        			<c:otherwise>
        				<display:column  class="new" autolink="true">
        				 <c:choose>
	        				<c:when test="${ taxonesvoact.tipoRelacion!=null}">
	        					<html:link styleClass="carpeta_cerrada" action="/Tesauros/TesaurosFormConsultaNodo?id=${taxonesvoact.id}&nomTesauro=${nomTesauro}&idioma=${idioma}&vocabName=${form.vocabName }">
	        						(${taxonesvoact.tipoRelacion}) ${taxonesvoact.valorTax }
	        					</html:link> 
	        				</c:when>
	        				<c:otherwise>
	        					<html:link styleClass="carpeta_cerrada" action="/Tesauros/TesaurosFormConsultaNodo?id=${taxonesvoact.id}&nomTesauro=${nomTesauro}&idioma=${idioma}&vocabName=${form.vocabName }">
	        						${taxonesvoact.valorTax }
	        					</html:link>
	        				</c:otherwise>  
	        			</c:choose>     		 
        				</display:column>	
        			</c:otherwise>
    			</c:choose>		        
		</display:table>
</div>

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->

<fieldset class="tipo">
<c:if test="${!empty form.rutaPadrevo}">
		<input class="boton_125_de_2" type="submit" name="accionSubmit" value="<bean:message key="tesauro.Asociar"/>" />
 </c:if> 
 </form>
 
<form method="post" enctype="multipart/form-data" action="<html:rewrite action="/DetalleClasificacion/DetalleClasificacion"/>">
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

