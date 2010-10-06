<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<tiles:insert definition="layout-usuario">
<tiles:put name="title" type="string">
	<bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">
<%@ include file="/taglib-imports.jspf" %>

<%@ include file="/es/pode/visualizador/presentacion/informes/formulario-listar-informes-vars.jspf" %>
<div class="plantilla_contenido">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2><bean:message key="informes.cabecera"/></h2>


<div class="caja_tabla" > 

<display:table name="${form.informes}" uid="fila" requestURI=""
		        export="false" pagesize="8" sort="list" style="border:1;width:100%;" class="administracion_tareas"
				cellpadding="0" cellspacing="0" summary="${summary}">
				
				<display:setProperty name="css.tr.odd" value="tr_gris"/>
				<display:setProperty name="css.tr.even" value="tr_blanco"/>
				<display:setProperty name="basic.show.header" value="true"/>
				
				<!--		Columna de Informes		-->
										
				<display:column sortable="true" sortProperty="nombre" style="valign:top;" class="tar">
					<a style="text-decoration:none;color:#585858;font-size:90%;" href="../../${form.pathInformes}${fila.nombre}" id="informe" target="blank">${fila.nombre}
					</a>
				</display:column>
				
		</display:table>
		
		
		<!-- </div> Fin de la caja tabla (SE CIERRA EN displaytag.properties) -->
		<!-- en caso de no tener registros de usuarios se tiene que poner el div		-->
			
		<c:if test="${fn:length(form.informes) < 1}" >

            </div>
                  
			<!--		Fin caja tabla		-->
	
		</c:if>




</div>
<!--  Establecer el cursor por defecto en la caja del buscador   -->	
<script type="text/javascript">
  document.forms[0].buscadorGeneral.focus();
</script>

</tiles:put>
</tiles:insert>

