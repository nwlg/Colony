<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<tiles:insert definition="layout-administrador">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/es/pode/administracion/presentacion/descargas/activas/activas-vars.jspf" %>

<!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
<div class="plantilla_contenido">
<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />
<!-- Inicio  PESTANIAS de FICHA -->

<div id="ficha_pestanias">
<ul>
<li id="pest_activa"><a href="<html:rewrite action="/Activas/Activas"/>" id="seleccionada"><bean:message key="descargasComun.activadas" /></a></li>
<li><a href="<html:rewrite action="/NoActivas/NoActivas"/>"><bean:message key="descargasComun.desactivadas" /></a></li>
</ul>
</div>
<!-- Fin PESTANIAS de FICHA -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<form method="post" id="activasSubmitForm" action="<html:rewrite action="/Activas/ActivasSubmit"/>" method="post" enctype="multipart/form-data">

<h2><bean:message key="descargasComun.titulo" /></h2>


<div class="caja_tabla" >

		<bean:define id="valor" value="${form.idModificada}" scope="page"/>
		<bean:define id="atributo" value="identificador" scope="page"/>
<display:table name="${form.descargas}" requestURI=""
					export="false" id="fila" class="administracion_tareas" 
					style="width:100%;" cellpadding="0" cellspacing="0" 
					summary="${descargasComun.tabla.summary}" sort="list" pagesize="8"
					decorator="es.pode.administracion.presentacion.MarcarModificado">
						<display:setProperty name="css.tr.odd" value="tr_gris"/>
						<display:setProperty name="css.tr.even" value="tr_blanco"/>
						<display:setProperty name="basic.show.header" value="false"/>
						
						<!--  ******************** COLUMNA DE CHECKBOX ***********************-->
					    
						<display:column style="valign:top;" class="sin_b">  
							<input type="checkbox" name="identificadorRowSelectionAsArray" value="${fila.identificador}" title='<bean:message key="descargasComun.seleccione"/>'/>
						</display:column>
						
						<!--  ******************** COLUMNA QUE MUESTRA LA DESCARGA  ********************-->
						
						<display:column style="valign:top;" class="tar4">							
                				${fila.titulo}
            			</display:column>
            			
            			<!--  ******************** COLUMNA QUE MUESTRA LA FECHA  ********************-->
						
						<display:column style="valign:top;" class="tar6">							
                				${fila.fecha}
            			</display:column>
            			
            			<!--  ******************** COLUMNA QUE MUESTRA LA OPCION "MODIFICAR" *******************-->
						
						<display:column style="valign:top;" class="tar6"> 
							<html:link action="/Activas/ActivasModificar?identificador=${fila.identificador}">
								<bean:message key="descargasActivas.modificar"/>
							</html:link>
				        </display:column>
            			
            			<!--  ******************** COLUMNA QUE MUESTRA LA OPCION "DESACTIVAR" *******************-->
						
						<display:column style="valign:top;"> 
							<html:link action="/Activas/ActivasDesactivar?identificador=${fila.identificador}">
								<bean:message key="descargasActivas.desactivar"/>
							</html:link>
				        </display:column>
</display:table>
</div>


<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo">
<input class="boton_125_de_2_izq"  type="submit" name="action" value="<bean:message key="descargasActivas.crear" />" />
<input class="boton_125_de_2"  type="submit" name="action" value="<bean:message key="descargasActivas.eliminar" />" />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->

</form>
</div>
<!-- Fin plantilla contenido  -->

</div>
</tiles:put>

</tiles:insert>