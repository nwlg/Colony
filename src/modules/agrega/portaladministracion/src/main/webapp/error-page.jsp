<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ page session="false" isErrorPage="true" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>


<link rel="stylesheet" media="screen" href="<rewrite:rewrite url="static/css/red.css"/>" type="text/css" />
<script type="text/javascript" src="<rewrite:rewrite url="static/js/plantilla.js"/>"></script>

<html>

<title>
      <bean:message key="title.Comun"/>
</title>
<!-- 		INICIO DEL BODY		  -->
<body>


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido">

<h2><bean:message key="error.${param.code}.title"/></h2>


<!--		Inicio del formulario principal		-->

<form id="errorAplicacion" action='<rewrite:rewrite url="visualizadorcontenidos/Portada/Portada.do"/>' method="post" >

	<!--		INICIO GLOBO GRIS		-->
	
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03">
				
				
					<!--		INICIO CAJA DE FORMULARIO		-->
				
					<div id="formulario" class="ali_c">
						
						<br />
						<p><bean:message key="error.${param.code}.message"/></p>
						<br />
						
					</div>
					
					<!--		FIN CAJA DE FORMULARIO		-->
						
						
				</div>
			</div>
		</div>
	</div>
	
	<!--		FIN GLOBO GRIS		-->


	<!--		Boton Aceptar		-->
	
	<input class="boton_125 tipo ft_centrada"  type="submit"  value="<bean:message key='usuarios.aceptar'/>" />
	
	
</form>

<!--		Fin del Formulario principal		-->
	

</div>

<!--		Fin de la capa plantilla_contenido		-->


</body>

<!--		FIN DEL BODY		-->


</html>