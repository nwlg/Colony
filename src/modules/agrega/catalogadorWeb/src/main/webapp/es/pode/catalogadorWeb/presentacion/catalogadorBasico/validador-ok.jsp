<%@ include file="/taglib-imports.jspf" %>
<html:xhtml/>
<tiles:insert definition="layout-principal">
<tiles:put name="title" type="string">
	<bean:message key="title.Basico"/>
</tiles:put>

<tiles:put name="body" type="string">
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">

<h2><bean:message key="title.Validacion"/></h2>
<form method="post" action="<html:rewrite action="/CatalogadorBasico/CatalogadorBasico" />" >
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->

<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" class="ali_c">
			<br />
			 <p><em class="correcto">
			    <c:if test="${!empty form.mensajesError}">
			       <c:forEach var="iteracion" items="${form.mensajesError}" >
			       		${iteracion }
			       </c:forEach>
			    </c:if>
			 </em></p>
			  
				<br />
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">
	<input type="submit" class="boton_125" value="<bean:message key="catalogador.basico.validador.form.Volver"/>"/>
</fieldset>
<!-- Fin Botones  -->
</form>
</div>
<!-- Fin plantilla contenido  -->
</tiles:put>

</tiles:insert>
