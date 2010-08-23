<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<bean:define id="urlGuardar"><html:rewrite action="/AsociacionArchivos/ArchivosEstructura"/></bean:define>
<bean:define id="urlEstructura"><html:rewrite action="/AsociacionArchivos/ArchivosEstructura"/></bean:define>
<bean:define id="urlArchivos"><html:rewrite action="/AsociacionArchivos/ArchivosArchivos"/></bean:define>
<bean:define id="selected" value="estructura"/>

<script language="javascript">

function doSubmit(sAction)
{
	document.forms["form"].action.value = sAction;
	document.forms["form"].submit();
}

</script>

<emp:layout selected="${selected}" urlArchivos="${urlArchivos}" urlEstructura="${urlEstructura}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
	<!-- Inicio plantilla contenido  -->
	<!-- Inicio plantilla contenido  -->
	<div class="plantilla_contenido">
		<%@ include file="/layout/messages.jsp" %>
			<h2><bean:message key="portalempaquetado.basico.asociar.archivos.titulo"/></h2>
			<form name="form" id="asociacionArchivosArchivosSubmitForm" method="post" action="<html:rewrite action="/AsociacionArchivos/ArchivosSubmit"/>" >
			<p class="parrafo_comun" id="separacion2"><bean:message key="portalempaquetado.basico.asociar.archivos.seleccioneArch"/>:</p>

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

							<!--  INICIO CAJA DE FORMULARIO   -->
							<div id="formulario" >							<br/>
								<div class="breadcrumb_arbol"><em class="oculto">-</em>
									<logic:iterate id="archivo" name="form" property="path">	
										<a class="br_carpeta_abierta" href="<html:rewrite action="/AsociacionArchivos/ArchivosNavegar"/>?href=${archivo.href}">${archivo.nombre}</a>
									</logic:iterate>
							 	</div>
							
							 <div class="caja_tabla limpiar_breadcrumb" >
								<table border="1" class="generica_02" cellpadding="0" cellspacing="0" width="100%" summary="Tabla de Vista por Carpeta">
									<caption>
										<strong>
											<bean:message key="portalempaquetado.basico.asociar.archivos.tablaCarpeta"/>
										</strong>
									</caption>
								 
									<bean:define id="navegarUrl"><html:rewrite action="/AsociacionArchivos/ArchivosNavegar"/></bean:define>
									<bean:define id="asociarUrl"><html:rewrite action="/AsociacionArchivos/ArchivosAsociar"/></bean:define>
									<bean:define id="desasociarUrl"><html:rewrite action="/AsociacionArchivos/ArchivosDesasociar"/></bean:define>
								 
								 	<c:set var="contador" value="true"/>
									 <logic:iterate id="archivo" name="form" property="ficheros">
									 <c:if test="${!archivo.esProtegido}">
										 <logic:equal name="contador" value="true">
											<tr class="tr_gris">
										 </logic:equal>
										 <logic:equal name="contador" value="false">
											<tr class="tr_blanco">
										 </logic:equal>
										 <c:set var="contador" value="${!contador}"/>
										 <emp:asociar 	seleccionados="${form.ficherosSeleccionados}" 
														archivo="${archivo}"
														keyAso="portalempaquetado.basico.asociar"
														keyDes="portalempaquetado.basico.desasociar"
														urlAso="${asociarUrl}"
														urlDes="${desasociarUrl}"
														urlArc="${navegarUrl}" />										
										</tr>
									</c:if>
									</logic:iterate>
								 </table>
							</div>
					<!--  FIN CAPA TABLA   -->		
					<!--  FIN CAPA TABLA   -->		
						</div>
		
						<!--  FIN CAJA DE FORMULARIO   -->
</div></div></div></div>
<!-- End of bubble -->
				
		<div class="leyendas">
			<br/>
			<h3><bean:message key='portalempaquetado.basico.asociar.archivos.leyenda.simbologia'/>:</h3>
			<br/>
			<span class="carpeta_vacio"><bean:message key='portalempaquetado.basico.asociar.archivos.leyenda.vacia'/></span>&nbsp;&nbsp;
			<span class="carpeta_parcial"><bean:message key='portalempaquetado.basico.asociar.archivos.leyenda.parcial'/></span>&nbsp;&nbsp;
			<span class="carpeta_completa"><bean:message key='portalempaquetado.basico.asociar.archivos.leyenda.completa'/></span>
		</div>			
		
		<input type="hidden" name="action" value="" />

		<!-- Inicio Botones  -->
		<!-- Inicio Botones  -->
		<fieldset class="tipo">

			<div class="packer_newfolder_accept">
				<!-- Start of Accept button -->
				<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
			
				<div class="db_bubble_content">
					<a href="javascript:doSubmit('<bean:message key='portalempaquetado.basico.asociar.archivos.aceptar'/>');"><bean:message key='portalempaquetado.basico.asociar.archivos.aceptar'/></a>
				</div>
			
				</div></div></div></div>
				<!-- End of bubble -->
			</div>

			<div class="packer_newfolder_cancel">
				<!-- Start of Cancel button -->
				<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
			
				<div class="db_bubble_content">
					<a href="javascript:doSubmit('<bean:message key='portalempaquetado.basico.asociar.archivos.cancelar'/>');"><bean:message key='portalempaquetado.basico.asociar.archivos.cancelar'/></a>
				</div>
			
				</div></div></div></div>
				<!-- End of bubble -->
			</div>

		</fieldset>
		<!-- Fin Botones  -->
		<!-- Fin Botones  -->			
		</form>
	</div>
	<!-- Fin plantilla contenido  -->
	<!-- Fin plantilla contenido  -->

</emp:layout>