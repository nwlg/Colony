<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<tiles:insert definition="layout-administrador">
<tiles:put name="title" type="string">
	<bean:message key="title.Comun"/>
</tiles:put>
<tiles:put name="body" type="string">
<%@ include file="/taglib-imports.jspf" %>

<!--************************          Inicio plantilla contenido       ****************************-->
<div class="plantilla_contenido">

<jsp:include page="/layout/messages.jsp" flush="true" />



	<!--		Inicio  PESTANIAS de FICHA		 -->

	<div id="ficha_pestanias">
		<div> <h2> <bean:message key="estructuras.tesauros.titulo"/> </h2></div>
		<ul>
			<li><a href="<html:rewrite action="/ListarArboles/ListarArboles"/>"><bean:message key="estructuras.estructuras.arboles"/></a></li>
			<li id="pest_activa"><a href="<html:rewrite action="/ListarTesauros/ListarTesauros"/>" id="seleccionada"><bean:message key="estructuras.estructuras.tesauros"/></a></li>
			<li><a href="<html:rewrite action="/ListarTaxonomias/ListarTaxonomias"/>"><bean:message key="estructuras.estructuras.taxonomias"/></a></li>
		</ul>
	</div>

	<!--		Fin  PESTANIAS de FICHA		-->


	<!--		Inicio CONTENIDO PESTANIAS		-->

	<div class="interno_ficha">
	<div class="plantilla_contenido_pestanias">
		








<form id="listarTesaurosFormListarTesaurosBaja" 
	action="<html:rewrite action="/ListarTesauros/FormListarTesaurosValidar"/>" method="post">

<div class="caja_tabla" >

	  <display:table name="${form.tesauros}" requestURI=""
        export="false" id="row" class="administracion_tareas"
        style="border:1;width:100%;" cellpadding="0" cellspacing="0" 
        summary="<bean:message key='estructuras.tesauros.titulo.summary'/>" sort="list" pagesize="10">
        

        <display:setProperty name="css.tr.odd" value="tr_gris"/>
        <display:setProperty name="css.tr.even" value="tr_blanco"/>
        <display:setProperty name="basic.show.header" value="true"/>

 
        <bean:define id="titulo"><b><bean:message key="estructuras.tesauros.titulo"/></b></bean:define>
        <display:column  media="html" sortable="true" sortProperty="nombre" style="valign:top;" class="tar" title="${titulo}" >
        	 	${row.nombre}
        </display:column>
        
        
        <!--		Columna de exportar	(html)	-->
		
		<display:column media="html" style="valign:top;"> 
			<html:link action="/ListarTesauros/FormListarTesaurosExportar?nombre=${row.nombre}">
				<bean:message key="estructuras.tesauros.exportar"/>
			</html:link>
        </display:column>

        
      </display:table>

		
			<!-- </div>		Fin de la caja tabla (SE CIERRA EN displaytag.properties)		-->
			
			
			<c:if test="${fn:length(form.tesauros) < 1}" >

            	</div>
                  
				<!--		Fin caja tabla		-->
				
            </c:if>


<!-- Inicio Botones  -->
<!-- Inicio Botones  -->

	<!-- <input class="boton_125_de_2" style="position:relative"  type="submit"  value="<bean:message key="estructuras.eliminar"/>" /> -->
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
<form id="listarTesaurosAltaTesauro"
	  action="<html:rewrite action="/ListarTesauros/FormListarTesaurosAlta"/>"
	  method="post">
	  <input class="boton_125_de_2_izq" style="position:relative"  type="submit"  value="<bean:message key="estructuras.tesauros.crear"/>" />
</form>


<br/>
<br/>



	</div>
	</div>
	
	<!--		Fin CONTENIDO PESTANIAS		-->	
	





</div><!-- plantilla contenido -->
</tiles:put>
</tiles:insert>