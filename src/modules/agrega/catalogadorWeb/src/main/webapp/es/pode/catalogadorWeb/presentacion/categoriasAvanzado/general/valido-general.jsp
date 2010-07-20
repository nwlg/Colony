<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>
<script language="javascript">
function doSubmit(formname, sAction) {
        document.forms[formname].action.value = sAction;
        document.forms[formname].submit();
}
</script>

<tiles:insert definition="layout-avanzado">
<tiles:put name="title" type="string">
	<bean:message key="title.Avanzado"/>
</tiles:put>

<tiles:put name="body" type="string">
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">

<h2><bean:message key="title.Validacion"/></h2>
<form name="mainform" method="post" action="<html:rewrite action="/General/ValidoGeneralVolver" />" >
<input type=hidden name=action value="">
<!--  begin bubble -->

<div class="lb_bubble_topleft" >
        <div class="lb_bubble_bottomleft">
                <div class="lb_bubble_topright">
                        <div class="lb_bubble_bottomright">
                        <div class="lb_bubble_content">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" class="ali_c">
			<br />
			 <p><em class="correcto">
			    <bean:message key="CAV.0.0"/>
			 </em></p>
			  
				<br />
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
</div>
<!--  end bubble -->
<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">
<div class="catalog_return">
 <div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright"><div class="db_bubble_content">
 <a href='javascript:doSubmit("mainform", "<bean:message key="catalogadoravanzado.validacion.Volver"/>");'><bean:message key="catalogadoravanzado.validacion.Volver"/></a>
 </div></div></div></div></div>
</div>
</fieldset>
<!-- Fin Botones  -->
</form>
</div>
<!-- Fin plantilla contenido  -->
</tiles:put>

</tiles:insert>