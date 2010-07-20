<!-- *****************************************************************************************************
*********************************       Listado.jsp de Tag     ** ***********************************
******************************************************************************************************-->
  
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ include file="/taglib-imports.jspf" %>


<tiles:insert definition="${form.tipoLayoutBuscador == 'NEUTRO'? 'layout-sinlateral' : 'layout-usuario'}">


<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">



<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador }"/>	

<!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
<div class="plantilla_contenido">

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<!-- *****************************   Inicio  PESTANIAS de FICHA      ********************************** -->

	<div id="ficha_pestanias">
		<div><h2> <bean:message key="tagging.listar.etiquetadoSocial"/> </h2></div>
		<ul>
			<c:if test="${!form.esAnonimo }" >
				<li><a href="<html:rewrite action="/ListarMisTags/ListarMisTags"/>"><bean:message key="tagging.listar.misTags"/></a></li>
			</c:if>
			<li id="pest_activa"><a id="seleccionada"> <bean:message key="tagging.listar.agregaTags"/></a></li>
		</ul>
	</div>

<!-- *****************************   Fin  PESTANIAS de FICHA      ********************************** -->

<!-- ***************************** Inicio CONTENIDO PESTANIAS ****************************** -->


	<div class="interno_ficha">

		<div class="plantilla_contenido_pestanias">
		<h3 class="h3_generico_small"><bean:message key="tagging.listar.agregaTags"/></h3>
		<p class="parrafo_comun" style="line-height:150%"><bean:message key="tagging.buscadorTag.explicacionBusc"/></p>
<!-- Inicio caja buscador -->
<!-- Inicio caja buscador -->
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" id="conmargen" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<form method="post" action="<html:rewrite action="/ListarAgregaTags/ListadoMostrarOdesAgrega"/>">
			
			<div id="formulario" >
		
  				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda"><label class="oculto" for="buscadorContenido02">Buscador:</label></div>
					<div class="contenedor_derecha2">
						<div class="text">
						<input name="tag" onfocus="limpiarTexto(this)" value=""  onblur="this.style.backgroundColor='#e1e1e1'" id="buscadorContenido02" type="text" title="<bean:message key="tagging.buscadorTag.introduzcaBuscar"/>"  />
						<br class="oculto" /><br class="oculto" />
						<input class="buscar"  type="submit" name="buscar" value="<bean:message key="comun.buscar"/>" />
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
	
		
		
		
			<!-- ******************************      Inicio del formulario    ************************************ -->
			<form id="" action="" method="post" enctype="multipart/form-data">

				<!-- ******************************      CAJA TABLA     ************************************ -->
				<div class="caja_tabla" style="margin-top:10px">

					<display:table name="${form.tags}" requestURI=""
					export="false" id="fila" class="administracion_tareas" 
					style="width:100%;" cellpadding="0" cellspacing="0" 
					summary="${summary}" sort="list" pagesize="8">
					
						<display:setProperty name="css.tr.odd" value="tr_gris"/>
						<display:setProperty name="css.tr.even" value="tr_blanco"/>
						<display:setProperty name="basic.show.header" value="false"/>	
						<display:setProperty name="basic.msg.empty_list"><bean:message key="tagging.listar.listaTagsVacia"/></display:setProperty>
					
						<display:caption>
							<strong><bean:message key="tagging.listar.tablaEtiquetas" /></strong>
						</display:caption>	
						<!--  ******************** COLUMNA QUE MUESTRA EL TAG **********************-->
			
						<display:column style="valign:top;" class="tar2">
							<html:link styleClass="ver_docu" action="/ListarAgregaTags/ListadoMostrarOdesAgrega?tag=${fila.nombre}" >
               					${fila.nombre} <em>(${fila.numOdes } <bean:message key="tagging.objetos"/>)</em>
               				</html:link>
            			</display:column>
        					
					</display:table>

						
				<!-- No se cierra el div aqui porque se hace en el archivo displaytag.properties al paginar -->
				<!-- en caso de no tener registros de usuarios se tiene que poner el div		-->
			
				<c:if test="${fn:length(form.tags) < 1}" >

            		</div>
                 	<hr/>
					<!--		Fin caja tabla		-->
				
           		</c:if>
           		
           		

				<!-- ******************************      FIN CAJA TABLA     ************************************ -->
<!--  FIN PAGINACION   -->		

<!-- Inicio Botones  -->

<!-- Inicio Botones  -->
	<br class="oculto" />
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