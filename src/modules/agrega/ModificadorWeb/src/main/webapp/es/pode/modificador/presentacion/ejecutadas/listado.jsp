<!-- *****************************************************************************************************
*********************************       Listar.jsp de Tareas Ejecutadas      ** ***********************************
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
		<div><h2> <bean:message key="tareas.cabeceraEjecutadas"/> </h2></div>
		<ul>
			<li><a href="<html:rewrite action="/ModificacionesEjecutadas/ListadoPendientes"/>" ><bean:message key="tareas.Pendientes"/></a></li>
			<c:if test="${not offline }"><li><a href="<html:rewrite action="/ModificacionesEjecutadas/ListadoEjecutandose"/>"> <bean:message key="tareas.Ejecutandose"/></a></li></c:if>
			<li id="pest_activa"><a href="<html:rewrite action="/ModificacionesEjecutadas/ModificacionesEjecutadas"/>"id="seleccionada"> <bean:message key="tareas.Ejecutadas"/></a></li>
		</ul>
	</div>

<!-- *****************************   Fin  PESTANIAS de FICHA      ********************************** -->

<!-- ***************************** Inicio CONTENIDO PESTANIAS ****************************** -->


	<div class="interno_ficha">

		<div class="plantilla_contenido_pestanias">
			
			<!-- ******************************      Inicio del formulario    ************************************ -->
			<form id="modificacionesEjecutadasListadoEliminarForm" action="<html:rewrite action='/ModificacionesEjecutadas/ListadoEliminar'/>" method="post" >
			
				<!-- ******************************      CAJA TABLA     ************************************ -->
				<div class="caja_tabla">
					
					<display:table name="${form.modificaciones}" requestURI=""
					export="false" id="fila" class="administracion_tareas" 
					style="border:1;width:100%;" cellpadding="0" 
					cellspacing="0" summary="${summary}" sort="list" pagesize="8">
			
						<display:setProperty name="css.tr.odd" value="tr_gris"/>
						<display:setProperty name="css.tr.even" value="tr_blanco"/>
						<display:setProperty name="basic.show.header" value="false"/>	
						
						<!--  ******************** COLUMNA DE CHECKBOX ***********************-->
					    
						<display:column style="valign:top;" class="sin_b" >  
							<input type="checkbox" name="idModificacionRowSelectionAsArray" value="${fila.idModificacion}" title='<bean:message key="tareasEjecutadas.Seleccione"/>'/>
						</display:column>

					
						<!--  ******************** COLUMNA QUE MUESTRA LA TAREA **********************-->
						
						
						<display:column style="valign:top;" class="tar" >		
                				${fila.nombre}      				
            			</display:column>						
					
			
				        <!--  ******************** COLUMNA QUE MUESTRA ESTADO *******************-->
				        
					
						<display:column  style="valign:top;" class="alinea_a_izq">
							<bean:message key="estado.${fila.resultado}"/>
						</display:column>
						
						
						<!--  ******************** COLUMNA QUE MUESTRA LA OPCION "VER INFORME" *******************-->
					
						<display:column style="valign:top;" class="ejec">  
				            <html:link action="/ModificacionesEjecutadas/ListadoInforme?idModificacion=${fila.idModificacion}"><bean:message key="tareasEjecutadas.VerInforme"/></html:link>
				        </display:column>
				       
					</display:table>
						
				<!-- No se cierra el div aqui porque se hace en el archivo displaytag.properties al paginar -->
				<!-- en caso de no tener registros de usuarios se tiene que poner el div		-->
			
					<c:if test="${fn:length(form.modificaciones) < 1}" >
            			</div>     
						<!--		Fin caja tabla		-->
            		</c:if>
       		     <!--  ****** Fin caja tabla *******-->
           		<hr />
				<!-- ******************************      FIN CAJA TABLA     ************************************ -->
				<c:if test="${fn:length(form.modificaciones) > 0}" >
				<!-- ******************************      Boton Ejecutar    ********************************** -->
					<fieldset class="tipo">	
						<input class="boton_125_de_2" name="action" type="submit" value="<bean:message key="tareasPendientes.Eliminar"/>" />		
					</fieldset>		
				</c:if>
			</form>
			<!-- ******************************      Fin del formulario    ***************************************** -->
				
		</div>	<!-- ************     plantilla contenido pestania  ************ -->	

	<!-- ************     fin <div class="interno_ficha">  ************ -->	
	
	<!-- ***************************** FIN  CONTENIDO PESTANIAS ****************************** -->
	
</div>
</div>
</tiles:put>
</tiles:insert>

