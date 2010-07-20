<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>

<script language="javascript">
function doSubmit(formname, sAction) {
        document.forms[formname].accion.value = sAction;
        document.forms[formname].submit();
}
</script>
<tiles:insert definition="layout-avanzado">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">

<div class="plantilla_contenido">
<h2><bean:message key="catalogadorAvanzado.importar.advertencia.titulo"/></h2>

<form name="mainform" method="post" action="<html:rewrite action="/InicioPortal/InicioPortal"/>" enctype="multipart/form-data">
<input type=hidden name=accion value="">
<!--  start bubble -->
<div class="lb_bubble_topleft" >
        <div class="lb_bubble_bottomleft">
                <div class="lb_bubble_topright">
                        <div class="lb_bubble_bottomright">
                        <div class="lb_bubble_content">

			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" class="ali_c">
			<br />
			 <p><bean:message key="catalogadorWeb.ErrorSesion"/></p>

			</div>
			</div>
		</div>
	</div>
</div>
</div>
<!--  end bubble -->
<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">

<div class="error_accept">
 <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 <a href='javascript:doSubmit("mainform", "<bean:message key="catalogadorAvanzado.importar.advertencia.aceptar"/>");'><bean:message key="catalogadorAvanzado.importar.advertencia.aceptar"/></a>
 </div></div></div></div></div>
</div>

</fieldset>

<!-- Fin Botones  -->
</form>
</div>	<!-- Fin plantilla contenido  -->
</tiles:put>

</tiles:insert>
