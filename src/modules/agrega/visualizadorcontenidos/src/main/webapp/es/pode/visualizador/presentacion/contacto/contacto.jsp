<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="agrega" uri="/WEB-INF/tags/agregaProperties.tld" %>

<tiles:insert definition="layout-usuario">
<tiles:put name="title" type="string">
	<bean:message key="portada.title"/>
</tiles:put>

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="style" type="string">
        <link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/static/css/red.css"/>"></link>
    </tiles:put>

    
    <tiles:put name="body" type="string">
    <%@ include file="/es/pode/visualizador/presentacion/contacto/contacto-javascript.jspf" %>

<!-- Inicio plantilla contenido  -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">


<h2><bean:message key="visualizador.contacto.titulo"/></h2>


<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >
			<br />
			 <p><span class="oculto" >-</span><span id="cont_tel"><bean:message key="visualizador.contacto.telefono"/><agrega:agregaProperties property="contacto_telefono"/></span></p>
				<br />
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" style="margin-top:10px" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario_02" >
			<br />
			 <p><span class="oculto" >-</span><a href="mailto:<agrega:agregaProperties property="contacto_mail"/>" id="cont_mail"><bean:message key="visualizador.contacto.mail"/></a></p>
				<br />
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->


<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<!--  Si la variable de agrega.properties contacto_incidencias_activar esta activada se vera la opcion de incidencias   -->

<bean:define id='activarIncidencias'><agrega:agregaProperties property="contacto_incidencias_activar"/></bean:define>
<c:if test="${activarIncidencias}">

	<div class="globo_gris" style="margin-top:10px" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
				<!--  INICIO CAJA DE FORMULARIO   -->
				<div id="formulario_03" >
				<br />
				 <p><span class="oculto" >-</span><a href="/incidencias" id="cont_mantis"><bean:message key="visualizador.contacto.herramienta"/></a></p>
					<br />
					</div>
					<!--  FIN CAJA DE FORMULARIO   -->
				</div>
			</div>
		</div>
	</div>
	
</c:if>

<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->


</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->


    </tiles:put>

</tiles:insert>
