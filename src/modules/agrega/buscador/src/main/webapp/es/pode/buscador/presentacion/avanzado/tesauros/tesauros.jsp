<%@ include file="/taglib-imports.jspf" %>

<tiles:insert definition="layout-sinlateralYsinbuscadorSuperior">

<tiles:put name="title" type="string">
	<bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/taglib-imports.jspf" %>
      

<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">				
				

<h2>${form.tituloTesauro}</h2>

<!--  INICIO CAJA DE FORMULARIO   -->
			<form method="post" action="<html:rewrite action="/TesaurosCU/TesaurosBuscarTerminos?idTesauro=${form.idTesauro}&idioma=${form.idioma}&tipoLayoutBuscador=${form.tipoLayoutBuscador}&nomTesauros=${taxonesvoact.nombre}&esRuta=${form.esRuta}&tituloTesauro=${form.tituloTesauro}"/>">

			<div id="formulario" >
		
  				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda"><label class="oculto" for="buscadorContenido02">Buscador:</label></div>
					<div class="contenedor_derecha2">
						<div class="text">
						<input name="textoBusqueda" onfocus="limpiarTexto(this)" value="${form.textoBusqueda}"  onblur="this.style.backgroundColor='#e1e1e1'" id="buscadorContenido02" type="text" title="<bean:message key="navegar.tesauro.introduzcaTextoBusqueda"/>"  />
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

<form method="post" name="CargarTesaurosForm" action="<html:rewrite action="/TesaurosCU/TesaurosAsociarTesauro.do?nomTesauros=${form.nomTesauros}&idioma=${form.idioma}&idTesauro=${form.idTesauro}&tipoLayoutBuscador=${form.tipoLayoutBuscador}&tituloTesauro=${form.tituloTesauro}"/>" enctype="multipart/form-data">

				
<div class="caja_tabla" >

		<p><bean:message key="tesauro.explicacion"/></p>
		
		<div class="breadcrumb_curricular">
		<html:link styleClass="br_carpeta_abierta" action="/TesaurosCU/TesaurosCU.do?idTesauro=${form.idTesauro}&idioma=${form.idioma}&tipoLayoutBuscador=${form.tipoLayoutBuscador}&nomTesauros=${taxonesvoact.nombre}&esRuta=${form.esRuta}&tituloTesauro=${form.tituloTesauro}">
        				<bean:message key="tesauro.Inicio"/><br/>
      	</html:link>
 		<c:if test="${!empty form.rutaPadreVO}">
			 <c:set var="longitud" value="${ fn:length(form.rutaPadreVO)}"/>
			 <fmt:formatNumber var="nombre" value="${longitud -1}" type="number"/>
			 <fmt:formatNumber var="nombre2" value="${longitud -2}" type="number"/>
			 <c:if test="${longitud>1 }">
 				<c:forEach items="${form.rutaPadreVO}" var="ruta" begin="0" end="${nombre2}">
		    		<em class="oculto">-</em>
		    		<html:link styleClass="br_carpeta_abierta" action="/TesaurosCU/TesaurosConsultaPadre?idTesauro=${ruta.id}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;tituloTesauro=${form.tituloTesauro}">
        				<c:out value="${ruta.valorTax}"/><br/>
        			</html:link>
			    </c:forEach>
			 </c:if> 
			 <c:forEach items="${form.rutaPadreVO}" var="ruta3" begin="${nombre}" end="${nombre}">
				 <em class="oculto">-</em>
					 <span class="br_carpeta_abierta">
				    	 <c:out value="${ruta3.valorTax}"/><br/>
				     </span>
			 </c:forEach>   
    	 </c:if>		  
		</div>
<bean:define id="summary"><bean:message key="tesauro.tablaTaxonesSummary"/></bean:define>
		<display:table name="${form.taxonesVO}" id="taxonesvoact" 
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
        					<html:link styleClass="carpeta_cerrada" action="/TesaurosCU/TesaurosConsultaNodo?idTesauro=${taxonesvoact.id}&nomTesauros=${taxonesvoact.valorTax}&idioma=${form.idioma}&tipoLayoutBuscador=${form.tipoLayoutBuscador}&esRuta=${form.esRuta}&tituloTesauro=${form.tituloTesauro}">
        						${taxonesvoact.valorTax}
        					</html:link>        		 
        				</display:column>	
        			</c:otherwise>
    			</c:choose>		        
		</display:table>
</div>


<!-- Inicio Botones  -->
<!-- Inicio Botones  -->

<fieldset class="tipo">
<c:if test="${!empty form.rutaPadreVO}">
		<input class="boton_125_de_2" type="submit" name="accionSubmit" value="<bean:message key="tesauro.Asociar"/>" />
 </c:if> 
 </form>

<form method="post" enctype="multipart/form-data" action="/buscador/TesaurosCU/TesaurosCancelar.do?tipoLayoutBuscador=${form.tipoLayoutBuscador}">
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

