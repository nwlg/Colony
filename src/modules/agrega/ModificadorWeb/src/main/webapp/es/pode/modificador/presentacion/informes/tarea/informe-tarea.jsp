<!-- *****************************************************************************************************
*********************************       Listar.jsp de Tareas Pendientes      ** ***********************************
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


<!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
<div class="plantilla_contenido">

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2><bean:message key="tareas.cabeceraInforme"/> </h2>
	<form action="<html:rewrite action="/InformeTarea/InformeTareaSelectOrigin"/>"  method="post" enctype="multipart/form-data">

<!--  INICIO CAJA DE FORMULARIO   -->
<div class="caja_de_tabla_invisible" >
	<table cellspacing="0" cellpadding="0"  border="0" width="100%"  summary="Asignacion Comunidades">
	<tr>
		<td class="nt" valign="top"  ><bean:message key="tareas.nombreTarea"/>:&nbsp;</td>
		<td  class="nt2" valign="top"><label>${form.nombreTarea}</label></td>
	</tr>
	<tr>
		<td class="nt" valign="top" ><bean:message key="tareas.Resultado"/>:</td>
		<td class="nt2" valign="top" ><label><bean:message key="tareas.${form.resultadoTarea}"/>
		<logic:notEmpty name="form" property="descResultado">
			- <bean:message key="${form.descResultado}"/>
		</logic:notEmpty>
		</label></td>
	</tr>
	</table>
</div>

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" id="conmargen">
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->

			<div id="formulario_02" >
<!--  INICIO CAPA TABLA   -->
<!--  INICIO CAPA TABLA   -->
			
 <div class="caja_tabla bordeada"  >
					<display:table name="${form.odes}" requestURI=""
					export="false" id="fila" class="administracion_tareas" 
					style="border:1;width:100%;" cellpadding="0" cellspacing="0" 
					summary="${summary}" sort="list" pagesize="8">
			
						<display:setProperty name="css.tr.odd" value="tr_gris"/>
						<display:setProperty name="css.tr.even" value="tr_blanco"/>
						<display:setProperty name="basic.show.header" value="false"/>	
						<display:setProperty name="basic.empty.showtable" value="true"/>
						<display:setProperty name="basic.msg.empty_list_row"><tr><td valign="top"  class="tar" ><bean:message key="informe.sinOdes"/></td></tr></display:setProperty>
            			
            			<!--  ******************** COLUMNA Titulo ODE **********************-->
						<display:column style="valign:top;" class="tar">  
							<span class="paquete">
								${fila.titulo}
							</span>
            			</display:column>
            			
            			<!--  ******************** COLUMNA QUE MUESTRA Estado *******************-->
						
						<display:column style="valign:top;" class="alinea_a_izq"> 
							<bean:message key="tareas.${fila.status}"/>
				        </display:column>
            			
            			<!--  ******************** COLUMNA MAS INFORMACION **********************-->
            			<display:column style="valign:top;" class="ejec">
							<html:link  target="_blank" action="/InformeTarea/InformeTareaTraza?id=${fila.id}&amp;nombreTarea=${form.nombreTarea}&amp;resultadoTarea=${form.resultadoTarea}">
								<bean:message key="tareas.masInformacion"/>
							</html:link>
				        </display:column>
				        
				        <!--  ******************** COLUMNA QUE MUESTRA Deshacer *******************-->
				        <c:if test="${(!empty informeSession.idModificacion) and (!empty fila.pathBackup)}">
				        <display:column style="valign:top;" class="ejec">
				        <c:if test="${(fila.status == 'FINALIZADA')}">
							<html:link action="/InformeTarea/InformeTareaRestaurar?id=${fila.id}">
								<bean:message key="tareas.deshacer"/>
							</html:link>
						</c:if>
				        </display:column>
				        </c:if>
				        
					</display:table>
				

</div>
<!--  FIN CAPA TABLA   -->		
<!--  FIN CAPA TABLA   -->	
</div>
<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<br class="oculto" />

<!-- Fin Botones  -->
<!-- Fin Botones  -->		
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>

		</div>
	</div>

<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->


	<fieldset class="tipo ft_centrada">
		<input class="boton_125"  type="submit"  value="<bean:message key="tareas.volver"/>" />
	</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->

</form>
</div>

    </tiles:put>

</tiles:insert>
