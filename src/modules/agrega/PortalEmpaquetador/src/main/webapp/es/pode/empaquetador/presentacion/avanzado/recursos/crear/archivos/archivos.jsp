<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<bean:define id="urlArchivos"><html:rewrite action="/CrearRecursoAvanzadoArchivos/ArchivosArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/CrearRecursoAvanzadoArchivos/ArchivosRecursos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/CrearRecursoAvanzadoArchivos/ArchivosOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/CrearRecursoAvanzadoArchivos/ArchivosSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/CrearRecursoAvanzadoArchivos/ArchivosRecursos"/></bean:define>
<bean:define id="selected" value="recursos"/>
<emp:layout selected="${selected}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
<bean:define id="empaquetadorSesion" name="<%=es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY%>" scope="session"/>
<bean:define id="crearRecursoArchivoSession" name="<%=es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession.SESSION_KEY %>" scope="session"/>

<script>

function deshabilitarArchivosSeleccionados(){
	var num_seleccionados = document.getElementById("num_seleccionados");
	var rutaArchivos = document.getElementById("rutaArchivos").value;
	for(var i=0;i<num_seleccionados.value;i++){
		id="seleccionado_" + i;
		
		var seleccion = document.getElementById(id);
		var partes =new Array();
		selec = new String(seleccion);
		partes = selec.split("/");
		idCheck = rutaArchivos + unescape(partes[partes.length - 1]);

		var check = document.getElementById(idCheck);

		if(check != null){
			check.disabled=true;
		}
	}
}
window.onload=deshabilitarArchivosSeleccionados;

</script>

<script language="javascript">
function doSubmit(formname, sAction) {
        document.forms[formname].action.value = sAction;
        document.forms[formname].submit();
}
</script>


<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>

<!-- Inicio  PESTANIAS de FICHA -->
<!-- Inicio  PESTANIAS de FICHA -->
<bean:define id="vistaArbol" value="${crearRecursoAvanzadoSession.vistaArbol}" ></bean:define>
<div id="ficha_pestanias">
<div><h2><bean:message key="presentacion.avanzado.recursos.crear.archivos.cabecera.h2"/></h2></div>
<ul>
	<logic:equal name="vistaArbol" value="true">
		<li><a href="<html:rewrite action="/CrearRecursoAvanzadoArchivos/ArchivosVista"/>?vistaArbol=false"><bean:message key="presentacion.avanzado.recursos.crear.archivos.pestanias.vista.por.carpeta"/></a></li>
		<li><a href="<html:rewrite action="/CrearRecursoAvanzadoArchivos/ArchivosVista"/>?vistaArbol=true"  id="seleccionada"><bean:message key="presentacion.avanzado.recursos.crear.archivos.pestanias.vista.por.arbol"/></a></li>
	</logic:equal>
	<logic:equal name="vistaArbol" value="false">
		<li><a href="<html:rewrite action="/CrearRecursoAvanzadoArchivos/ArchivosVista"/>?vistaArbol=false" id="seleccionada" ><bean:message key="presentacion.avanzado.recursos.crear.archivos.pestanias.vista.por.carpeta"/></a></li>
		<li><a href="<html:rewrite action="/CrearRecursoAvanzadoArchivos/ArchivosVista"/>?vistaArbol=true"><bean:message key="presentacion.avanzado.recursos.crear.archivos.pestanias.vista.por.arbol"/></a></li>
	</logic:equal>
</ul>
</div>
<!-- Fin PESTANIAS de FICHA -->
<!-- Fin PESTANIAS de FICHA -->


<!-- Inicio CONTENIDO PESTANIAS -->
<!-- Inicio CONTENIDO PESTANIAS -->
<div class="interno_ficha">



<div class="plantilla_contenido_pestanias">



<!-- inicio no existen archivos seleccionados  -->
<logic:empty name="crearRecursoArchivoSession" property= "archivos">
<input type="hidden" id="num_seleccionados" name="num_seleccionados" value="0"/> 
	<!-- start bubble -->
	<div class="lb_bubble_topleft" id="conmargen2" >
		<div class="lb_bubble_bottomleft">
			<div class="lb_bubble_topright">
				<div class="lb_bubble_bottomright">
				<div class="lb_bubble_content">
					<!--  Inicio CAJA DE FORMULARIO   -->
					<div id="formulario" >
					
						<div class="caja_tabla bordeada limpiar_breadcrumb" >
							<table border="1" class="generica_02" cellpadding="0" cellspacing="0" width="100%" summary="Tabla de Archivos">
								<caption><strong><bean:message key="portalempaquetado.avanzado.recursos.crear.archivo.tablaArchivos"/></strong></caption>
								<tr class="tr_beige">
									<td valign="top" class="td_larga acentrado"> <bean:message key="portalempaquetado.avanzado.recursos.crear.paso2.noArchivos"/> </td>

								</tr>
							</table>
						</div>
					
					</div>
					<!--  FIN CAJA DE FORMULARIO   -->
					<br class="limpiar" />
				</div>
			</div>
		</div>
	</div>
	</div>
	<!-- end bubble -->

</logic:empty>
<!-- inicio existen archivos seleccionados  -->
<logic:notEmpty name="crearRecursoArchivoSession" property= "archivos">
		<!--  INICIO CAJA REDONDEADA BLANCA   -->		
		<!-- start bubble -->
			<div class="lb_bubble_topleft" id="conmargen2" >
				<div class="lb_bubble_bottomleft">
					<div class="lb_bubble_topright">
						<div class="lb_bubble_bottomright">
						<div class="lb_bubble_content">
		
						<!--  Inicio CAJA DE FORMULARIO   -->
							<div id="formulario" >
						<a href="<html:rewrite action="/CrearRecursoAvanzadoArchivos/ArchivosEliminarTodos"/>" class="resultados_d" >
							<bean:message key="presentacion.avanzado.recursos.crear.archivos.seleccionados.eliminar.todos"/>
						</a>
						<h3 ><bean:message key="presentacion.avanzado.recursos.crear.archivos.seleccionados.cabecera.h3"/></h3>
		<!--  INICIO CAPA TABLA   -->
		<!--  INICIO CAPA TABLA   -->					
		 <div class="caja_tabla bordeada"   >
		<table border="1" class="generica_02" cellpadding="0" cellspacing="0" width="100%" summary="<bean:message key="presentacion.avanzado.recursos.crear.archivos.seleccionados.table.summary"/>">
		<caption><strong><bean:message key="presentacion.avanzado.recursos.crear.archivos.seleccionados.table.caption"/></strong></caption>

<c:set var="contador" value="true"/>


<logic:iterate id="file" name="crearRecursoArchivoSession" property="archivos" indexId="i">
<input type="hidden" id="num_seleccionados" name="num_seleccionados" value="${fn:length(crearRecursoArchivoSession.archivos)}"/>
<logic:equal name="contador" value="true">
		<tr class="tr_gris">
</logic:equal>
<logic:equal name="contador" value="false">
		<tr class="tr_blanco">
</logic:equal>
<c:set var="contador" value="${!contador}"/>
			<bean:define id="urlConHost"><rewrite:rewrite url="${file.url }"/></bean:define>
			<td valign="top" class="td_larga"><a id="seleccionado_${i}" target="_blank" href="<emp:encodeURL url="${urlConHost }"/>" class="archivo">${file.href }</a></td>
			<td valign="top" class="td_corta_sin" align="center"><span class="oculto">- </span>
				<a href="<html:rewrite action="/CrearRecursoAvanzadoArchivos/ArchivosEliminar"/>?href=${file.href}" >
					<bean:message key="presentacion.avanzado.recursos.crear.archivos.seleccionados.link.eliminar"/>
				</a>
			</td>
		</tr>
</logic:iterate>		
		 </table>
		</div>
			<!--  FIN CAPA TABLA   -->		
			<!--  FIN CAPA TABLA   -->	
			
		</div>
		<!--  FIN CAJA DE FORMULARIO   -->
		<form name=fileform method="post" action="<html:rewrite action="/CrearRecursoAvanzadoArchivos/ArchivosAAdir"/>">
		<input type=hidden name=action value="">
			<fieldset class="tipo ft_centrada">
			<div class="packer_addfiles">
 			<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 			<a href='javascript:doSubmit("fileform", "<bean:message key="presentacion.avanzado.recursos.crear.archivos.seleccionados.submit.aniadir"/>");'><bean:message key="presentacion.avanzado.recursos.crear.archivos.seleccionados.submit.aniadir"/></a>
 			</div></div></div></div></div>
			</div>
			</fieldset>
		</form>
					
		<br class="limpiar" />
						</div>
					</div>
				</div>
		
			</div>
			</div>
		<!-- end bubble -->
		<!--  FIN CAJA REDONDEADA BLANCA   -->
</logic:notEmpty>
<!-- fin   existen archivos seleccionados  -->

<form name=mainform method="post"
	  id="crearRecursoAvanzadoArchivosArchivosSeleccionarForm"
	  action="<html:rewrite action="/CrearRecursoAvanzadoArchivos/ArchivosSeleccionar"/>" >
<input type=hidden name=action value="">


<!-- *****************************INICIO ARBOL VERTICAL *****************************-->
<logic:equal name="vistaArbol" value="true">
<div id="menu_arbol"  >
<ul >
<bean:define id="actionNavegar"><html:rewrite action="/CrearRecursoAvanzadoArchivos/ArchivosNavegar"/></bean:define>
	<emp:archivos arbol="${form.arbol}" niveles="1" actionNavegar="${actionNavegar}" path="${form.pathArchivos}"/>
</ul>
</div>
</logic:equal>
<!-- ***************************** ARBOL VERTICAL *****************************-->


<!-- inicio listado de archivos -->
<logic:notEmpty  name="form" property="archivos">
		<!--  start bubble -->
		<div class="lb_bubble_topleft" >
			<div class="lb_bubble_bottomleft">
				<div class="lb_bubble_topright">
					<div class="lb_bubble_bottomright">
					<div class="lb_bubble_content">
					<!--  INICIO CAJA DE FORMULARIO   -->
					<div id="formulario_02" >
		
					
					<!--  *****************************bucle coleccion  ***************************** -->	
					<!--  Breadcrumb   -->
						<div class="breadcrumb_arbol"><em class="oculto">-</em>
							<c:set var="rutaArchivos" value=""/>
							<logic:iterate name="form" property="pathArchivos" id="archivo" indexId="n">	
								<a class="br_carpeta_abierta" href="<html:rewrite action="/CrearRecursoAvanzadoArchivos/ArchivosNavegar"/>?href=${archivo.href}"> ${archivo.nombre} </a>
								<c:if test="${n>0}">
									<c:set var="rutaArchivos" value="${rutaArchivos}${archivo.nombre }/"/>
								</c:if>
							</logic:iterate>
							<input type="hidden" id="rutaArchivos" name="rutaArchivos" value="${rutaArchivos}"/> 
						 </div>
		
		 <div class="caja_tabla limpiar_breadcrumb" >
		<table border="1" class="generica_02" cellpadding="0" cellspacing="0" width="100%" summary="<bean:message key="presentacion.avanzado.recursos.crear.archivos.table.summary"/>">
		<caption><strong><bean:message key="presentacion.avanzado.recursos.crear.archivos.table.caption"/></strong></caption>

<c:set var="contador" value="true"/>
<c:set var="sinArchivos" value="true"/>
<logic:iterate id="archivo" name="form" property="archivos" indexId="j">
<bean:define id="esProtegido" name="archivo" property="esProtegido"/>
<logic:equal name="esProtegido" value="false">
<logic:equal name="contador" value="true">
		<tr class="tr_gris">
</logic:equal>
<logic:equal name="contador" value="false">
		<tr class="tr_blanco">
</logic:equal>
<c:set var="contador" value="${!contador}"/>
			<td valign="top"  class="sin_b">
			<input id="${rutaArchivos}${archivo.nombre}" type="checkbox" name="nombreRowSelectionAsArray" value="${archivo.nombre}" />
			</td>
			<bean:define id="esFichero" value="${archivo.esFichero}"/>
			<logic:equal name="esFichero" value="false">
						<td valign="top" class="td_larga"><a href="<html:rewrite action="/CrearRecursoAvanzadoArchivos/ArchivosNavegar"/>?href=${archivo.href}" class="carpeta_cerrada"> ${archivo.nombre} </a></td>
			</logic:equal>
			<logic:equal name="esFichero" value="true">
					<bean:define id="urlConHost"><rewrite:rewrite url="${archivo.href}"/></bean:define>
					<td valign="top" class="td_larga"><a target="_blank" href="<emp:encodeURL url="${urlConHost}"/>" class="archivo"> ${archivo.nombre} </a></td>
			</logic:equal>
		
		</tr>
<c:set var="sinArchivos" value="false"/>
</logic:equal>
</logic:iterate>		
<logic:equal name="sinArchivos" value="true">
<tr class="tr_blanco">
<td><bean:message key="presentacion.avanzado.recursos.crear.archivos.table.empty.message"/></td>
</tr>
</logic:equal>
		 </table>
		</div>
			<!--  FIN CAPA TABLA   -->		
			<!--  FIN CAPA TABLA   -->		
		</div>
					
		<!-- Inicio Botones  -->
		<!-- Inicio Botones  -->
		<br class="oculto" />
		<fieldset class="tipo_interior_02">

<div class="packer_cancel">
 <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 <a href='javascript:doSubmit("mainform", "<bean:message key="presentacion.avanzado.recursos.crear.archivos.submit.cancelar"/>");'><bean:message key="presentacion.avanzado.recursos.crear.archivos.submit.cancelar"/></a>
 </div></div></div></div></div>
</div>

<div class="packer_select">
 <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 <a href='javascript:doSubmit("mainform", "<bean:message key="presentacion.avanzado.recursos.crear.archivos.submit.seleccionar"/>");'><bean:message key="presentacion.avanzado.recursos.crear.archivos.submit.seleccionar"/></a>
 </div></div></div></div></div>
</div>

		
		<!-- Fin Botones  -->
		<!-- Fin Botones  -->
					<!--  FIN CAJA DE FORMULARIO   -->
					</div>
				</div>
			</div>
		</div>
		</div>
		<!--  end bubble -->	
</logic:notEmpty>
<!-- fin listado de archivos -->
 
</form>
</div>
<!-- HASTA AQUI EL REEEMPLAZO -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->

<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->

</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->

</div>
<!-- Fin CONTENIDO PESTANIAS -->
<!-- Fin CONTENIDO PESTANIAS -->

</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->


</emp:layout>
