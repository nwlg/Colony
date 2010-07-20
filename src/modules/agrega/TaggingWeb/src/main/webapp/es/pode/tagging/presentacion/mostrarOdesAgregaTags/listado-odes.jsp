<!-- *****************************************************************************************************
*********************************       listado-odes.jsp       *************************************
******************************************************************************************************-->
  
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>

<tiles:insert definition="${form.tipoLayoutBuscador == 'NEUTRO'? 'layout-sinlateral' : 'layout-usuario'}">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>

<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador }"/>	


<!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
<div class="plantilla_contenido">

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />
			
			
	<!-- *****************************   Inicio  PESTANIAS de FICHA      ********************************** -->
		
	<div id="ficha_pestanias">
	<div><h2> <bean:message key="tagging.listar.etiquetadoSocial"/> - ${form.tag }</h2></div>
		<ul>
			<c:if test="${!form.esAnonimo}" >
				<li><a href="<html:rewrite action="/ListarMisTags/ListarMisTags"/>"><bean:message key="tagging.listar.misTags"/></a></li>
			</c:if>
			<li id="pest_activa"><a id="seleccionada"> <bean:message key="tagging.listar.agregaTags"/></a></li>
		</ul>
	</div>

<!-- *****************************   Fin  PESTANIAS de FICHA      ********************************** -->	
			<!-- ***************************** Inicio CONTENIDO PESTANIAS ****************************** -->


	<div class="interno_ficha">

		<div class="plantilla_contenido_pestanias">
			<!-- ******************************      Inicio del formulario    ************************************ -->
			<form action="<html:rewrite action="/MostrarOdesAgregaTags/ListadoOdesVolver"/>" method="post" enctype="multipart/form-data">

				<!-- ******************************      CAJA TABLA     ************************************ -->
				<div class="caja_tabla">
					<h3 class="h3_generico"><bean:message key="tagging.listar.listadoDeOdes"/></h3>
					<display:table name="${form.odes}" requestURI=""
					export="false" id="fila" class="administracion_tareas" 
					style="width:100%;" cellpadding="0" cellspacing="0" 
					summary="${summary}" sort="list" pagesize="8">
					
						<display:setProperty name="css.tr.odd" value="tr_gris"/>
						<display:setProperty name="css.tr.even" value="tr_blanco"/>
						<display:setProperty name="basic.show.header" value="false"/>	
						<display:setProperty name="basic.msg.empty_list"><bean:message key="tagging.listar.listaOdesVacia"/></display:setProperty>
						
						<display:caption>
							<strong><bean:message key="tagging.listar.tablaOdes" /></strong>
						</display:caption>
						
						<!--  ******************** COLUMNA QUE MUESTRA EL ODE **********************-->
						<bean:define id="urlCorta" ><rewrite:rewrite url="${initParam.url_buscadorDetalleCorta}/${fila.idiomaCat}/${fila.idOde}"/></bean:define>
						<display:column style="valign:top;" class="tar7">
 							<html:link href="${urlCorta}" styleClass="paquete">
               					${fila.titulo}
               				</html:link>
            			</display:column>
                  		
					</display:table>

						
				<!-- No se cierra el div aqui porque se hace en el archivo displaytag.properties al paginar -->
				<!-- en caso de no tener registros de usuarios se tiene que poner el div		-->
			
				<c:if test="${fn:length(form.odes) < 1}" >

            		</div>
                    <hr/>
					<!--		Fin caja tabla		-->
				
           		</c:if>
           		
           		

				<!-- ******************************      FIN CAJA TABLA     ************************************ -->
<!--  FIN PAGINACION   -->	
	
<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">
	<input class="boton_125" name="accion" type="submit" value="<bean:message key="comun.volver"/>" />				
</fieldset>

<!-- Fin Botones  -->
<!-- Fin Botones  -->

		</form>
		<!-- ******************************      Fin del formulario  con datos  ***************************************** -->
		</div>
	</div>
	
	<!-- ***************************** FIN  CONTENIDO PESTANIAS ****************************** -->


			


</div>
</tiles:put>
</tiles:insert>