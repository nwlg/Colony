<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<tiles:insert definition="layout-gestor-flujo-con-style">

	<tiles:put name="title" type="string">
		<bean:message key="title.Comun" />
	</tiles:put>
	<tiles:put name="body" type="string">

<script language="javascript">

function doSubmitAccept(sAction)
{
	document.forms["formaccept"].action = '<html:rewrite action="/${initParam.url_personales_eliminar_aceptar}"/>';
	document.forms["formaccept"].action.value = sAction;
	document.forms["formaccept"].submit();
}

function doSubmitCancel(sAction)
{
	document.forms["formcancel"].action = '<html:rewrite action="/${initParam.url_personales_eliminar_cancelar}"/>';
	document.forms["formcancel"].action.value = sAction;
	document.forms["formcancel"].submit();
}

</script>


		<!--************************          Inicio plantilla contenido       ****************************-->
		<div class="plantilla_contenido"><jsp:include
			page="/layout/messages.jsp" flush="true" />

		<h2><bean:message key="gestorFlujo.mostrarOdes.eliminar" /></h2>
		
		
		
		
	<!--		Inicio del formulario principal		-->

<form name="formaccept" action='<html:rewrite action="/${initParam.url_personales_eliminar_aceptar}"/>' method="post"  >

	
<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">
					
					
					<!--		INICIO CAJA DE FORMULARIO		-->
					
					<div id="formulario" class="ali_c"><br/>
					
						<p><bean:message key="gestorFlujo.eliminar.confirmacion"/></p>
						
						<p>
						
						<!--		INICIO CAJA TABLA		-->
						
						<div class="caja_tabla" >
						
						<display:table name="${form.titulos}" uid="fila" requestURI=""
			        	export="false" style="border:1;width:100%;" class="administracion_tareas"
						cellpadding="0" cellspacing="0" summary="">
						
						
						<!--		COLUMNA DE ODES		-->
						
						<display:column>
			            	${fila}
			        	</display:column>
			        	
			        	</display:table>			        	
			        	
						</div>
						</p>
						
					</div>
					
					<!--		FIN CAJA DE FORMULARIO		-->
					
					
</div></div></div></div>
<!-- End of search box bubble -->



	<!-- Inicio Botones  -->
	<input type="hidden" name="action" value="">

	<div class="pfolder_accept">
		<!-- Start of bubble -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">

		<div class="db_bubble_content">
			<a href="javascript:doSubmitAccept('<bean:message key='gestorFlujo.aceptar'/>');"><bean:message key='gestorFlujo.aceptar'/></a>
		</div>

		</div></div></div></div>
		<!-- End of bubble -->
	</div>

</form>


<!--		Formulario secundario y boton cancelar		-->

<form name="formcancel" action='<html:rewrite action="/${initParam.url_personales_eliminar_cancelar}"/>' method="post">

	<input type="hidden" name="action" value="">

	<div class="pfolder_cancel">
		<!-- Start of bubble -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">

		<div class="db_bubble_content">
			<a href="javascript:doSubmitCancel('<bean:message key='gestorFlujo.cancelar'/>');"><bean:message key='gestorFlujo.cancelar'/></a>
		</div>

		</div></div></div></div>
		<!-- End of bubble -->
	</div>

</form>


</div>
		
		
		
		
			<!-- Fin plantilla CONTENIDO -->
	</tiles:put>

</tiles:insert>