<!-- *****************************************************************************************************
*********************************       Listar.jsp de Tareas Ejecutandose      ** ***********************************
******************************************************************************************************-->
  
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>


<tiles:insert definition="${sessionScope.offline == true ? 'layout-offline' : 'layout-administrador'}">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>


<div class="plantilla_contenido">

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<!-- *****************************   Inicio  PESTANIAS de FICHA      ********************************** -->

	<div id="ficha_pestanias">
		<div><h2> <bean:message key="tareas.cabeceraEjecutandose"/> </h2></div>
		<ul>
			<li><a href="<html:rewrite action="/ModificacionesEjecutandose/ListadoPendientes"/>" ><bean:message key="tareas.Pendientes"/></a></li>
			<li id="pest_activa"><a href="<html:rewrite action="/ModificacionesEjecutandose/ModificacionesEjecutandose"/>"id="seleccionada"> <bean:message key="tareas.Ejecutandose"/></a></li>
			<li><a href="<html:rewrite action="/ModificacionesEjecutandose/ListadoEjecutadas"/>"> <bean:message key="tareas.Ejecutadas"/></a></li>
		</ul>
	</div>

<!-- *****************************   Fin  PESTANIAS de FICHA      ********************************** -->

<!-- ***************************** Inicio CONTENIDO PESTANIAS ****************************** -->


	<div class="interno_ficha">

		<div class="plantilla_contenido_pestanias">
			
			<!-- ******************************      Inicio del formulario    ************************************ -->
			<form id="modificacionesEjecutandoseModificacionesEjecutandoseForm" action="<html:rewrite action="/ModificacionesEjecutandose/ModificacionesEjecutandose"/>"  method="post" enctype="multipart/form-data">
			
				<!-- ******************************      CAJA TABLA     ************************************ -->
				<div class="caja_tabla">
					
					<display:table name="${form.modificaciones}" requestURI=""
					export="false" id="fila" class="administracion_tareas" 
					style="border:1;width:100%;" cellpadding="0" cellspacing="0"
					summary="${summary}" pagesize="8">
			
						<display:setProperty name="css.tr.odd" value="tr_gris"/>
						<display:setProperty name="css.tr.even" value="tr_blanco"/>
						<display:setProperty name="basic.show.header" value="false"/>	

					
						<!--  ******************** COLUMNA QUE MUESTRA LA TAREA **********************-->
						
						<display:column style="valign:top;" class="tar4">
							${fila.nombre}
						</display:column>
						
							

					</display:table>
						
				<!-- No se cierra el div aqui porque se hace en el archivo displaytag.properties al paginar -->
				<!-- en caso de no tener registros de usuarios se tiene que poner el div		-->
			
				<c:if test="${fn:length(form.modificaciones) < 1}" >

            		</div>
                  
					<!--		Fin caja tabla		-->
				
            	</c:if>
				<!-- ******************************      FIN CAJA TABLA     ************************************ -->
				
				
			</form>
			<!-- ******************************      Fin del formulario    ***************************************** -->
				
		</div>
	</div>
	
	<!-- ***************************** FIN  CONTENIDO PESTANIAS ****************************** -->
	
</div>
</tiles:put>
</tiles:insert>

