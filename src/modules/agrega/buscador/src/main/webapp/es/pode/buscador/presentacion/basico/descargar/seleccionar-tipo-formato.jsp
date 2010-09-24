<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%-- --%>

<tiles:insert definition="layout-sinlateral">

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="body" type="string">
<%@ include file="/taglib-imports.jspf" %>

	<div class="plantilla_contenido">
	
	<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
	<jsp:include page="/layout/messages.jsp" flush="true" />

	<div class="heading_text">
		<bean:message key="descargar.tipoFormato.titulo"/>
	</div>	


<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">
<div class="lb_bubble_content">


<!-- White outline -->
<div class="results_detail_outline">

<!-- Show the title -->
<div class="results_detail_title">${form.titulo}</div>
<form name="download" method="get" action="<html:rewrite action="/DescargarODECU/SeleccionarTipoFormatoAceptar"/>" >

<!-- Download formats --> <!-- TODO: we have to improve this -->
<div class="text ft_lateral download_text_normal" style="clear:left">
    <c:if test="${fn:contains(fn:toLowerCase(param.formats),'application/x-www-form-urlencoded')==true}">
        <input id="Descarga01" class="boton_radio" type="radio" disabled="true" value="descargar.formatos.CONTENIDOS_VALUE" name="formato" />
    </c:if>
    <c:if test="${fn:contains(fn:toLowerCase(param.formats),'application/x-www-form-urlencoded')!=true}">
        <input id="Descarga01" class="boton_radio" type="radio" checked="true" value="descargar.formatos.CONTENIDOS_VALUE" name="formato" />
    </c:if>
        <label for="Descarga01" class="alineada"><bean:message key="descargar.formatos.CONTENIDOS"/></label>
</div>

<div class="text ft_lateral download_text_normal">
    <c:if test="${fn:contains(fn:toLowerCase(param.formats),'application/x-www-form-urlencoded')==true}">
         <input id="Descarga01" class="boton_radio" type="radio" checked="true" value="descargar.formatos.HTML_VALUE" name="formato" />
    </c:if>
    <c:if test="${fn:contains(fn:toLowerCase(param.formats),'application/x-www-form-urlencoded')!=true}">
         <html:radio property="formato" styleClass="boton_radio" styleId="Descarga01" name="form"  value="descargar.formatos.HTML_VALUE" />
    </c:if>
	<label for="Descarga01" class="alineada"><bean:message key="descargar.formatos.HTML"/></label>
</div>

<!-- Gap! -->
<div class="text ft_lateral download_text_gap">
            <html:radio property="formato" styleClass="boton_radio" styleId="Formato01" name="form"  value="descargar.formatos.SCORM_2004_Sin_Sub_Manifiesto_VALUE" />
	<label for="Formato01" class="alineada"><bean:message key="descargar.formatos.SCORM_2004_Sin_Sub_Manifiesto"/></label>
</div>

<div class="text ft_lateral download_text_normal">
	<html:radio property="formato" styleClass="boton_radio" styleId="Formato02" name="form"  value="descargar.formatos.SCORM_2004_VALUE" />
	<label for="Formato02"  class="alineada2"><bean:message key="descargar.formatos.SCORM_2004"/></label>
</div>

<div class="text ft_lateral download_text_normal">
	<html:radio property="formato" styleClass="boton_radio" styleId="Formato03" name="form"  value="descargar.formatos.SCORM_1.2_VALUE" />
	<label for="Formato03"  class="alineada2"><bean:message key="descargar.formatos.SCORM_1.2"/></label>
</div>

<div class="text ft_lateral download_text_normal">
	<html:radio property="formato" styleClass="boton_radio" styleId="Formato04" name="form"  value="descargar.formatos.IMS_CP_VALUE" />
	<label for="Formato04"  class="alineada3"><bean:message key="descargar.formatos.IMS_CP"/></label>
</div>

<!-- Spacer -->
<div style="height:36px;"></div>

<!-- Additional form fields for download form -->
<input type="hidden" name="idioma" value="${form.idioma}"/>
<input type="hidden" name="titulo" value="${form.titulo}"/>
<input type="hidden" name="identificadorODE" value="${form.identificadorODE}"/>
<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
<input style="display:none;" class="boton_125_de_2 tipo"  type="submit"  value="<bean:message key="listar.odecu.mostrar.resultados.detalles.descargar"/>" alt="Descarga fichero ZIP"/>

</form>
</div>
<!-- End of outline -->

<!-- Show the download button -->
<div class="download_download">
<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">

	<a href="javascript:document.forms['download'].submit();">
	<div class="db_bubble_content">
	<bean:message key="listar.odecu.mostrar.resultados.detalles.descargar"/>
	</div>
	</a>

</div>
</div></div></div></div>
<!-- End of download button -->

<!-- Show back button (depends upon session) -->

<logic:equal name="form" property="mostrarVuelta" value="true">
	<logic:equal name="form" property="busquedaSimpleAvanzada" value="BUSQUEDA_ARBOL">
		<form name="back" style="display:none;" action="<html:rewrite action="/DetallarODECU/DetallarODECU.do"/>?identificadorODE=${form.identificadorODE}&amp;idioma=${form.idioma}&amp;mostrarVuelta=${form.mostrarVuelta}&amp;areaCurricularBusqueda=&amp;posicionamiento=POSICIONADO" method="post">
		<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
		<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="descargar.boton.volver"/>"/>
		</form>
	</logic:equal>
	<logic:notEqual name="form" property="busquedaSimpleAvanzada" value="BUSQUEDA_ARBOL">
		<form name="back" style="display:none;" action="<html:rewrite action="/DetallarODECU/DetallarODECU.do"/>?identificadorODE=${form.identificadorODE}&amp;idioma=${form.idioma}&amp;mostrarVuelta=${form.mostrarVuelta}&amp;posicionamiento=POSICIONADO" method="post">
		<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
		<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="descargar.boton.volver"/>"/>
		</form>
	</logic:notEqual>
</logic:equal>

<logic:notEqual name="form" property="mostrarVuelta" value="true">
	<form name="back" style="display:none;" action="<html:rewrite action="/DetallarODECU/DetallarODECU.do"/>?identificadorODE=${form.identificadorODE}&amp;idioma=${form.idioma}&amp;mostrarVuelta=${form.mostrarVuelta}" method="post">
	<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
	<input class="boton_125_de_2_izq tipo"  type="submit"  value="<bean:message key="descargar.boton.volver"/>"/>
	</form>
</logic:notEqual>

<div class="download_back">
<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">

	<a href="javascript:document.forms['back'].submit();">
	<div class="db_bubble_content">
	<bean:message key="descargar.boton.volver"/>
	</div>
	</a>

</div>
</div></div></div></div>
<!-- End of back button -->



<!-- Clear to the end of the outer bubble -->
<div style="clear: both;"></div>

</div>
</div></div></div></div>
<!-- End of bubble -->

</div>
<!-- End of results detail outline -->

	</div>
	<!-- End of plantilla contenido -->

</tiles:put>
</tiles:insert>
