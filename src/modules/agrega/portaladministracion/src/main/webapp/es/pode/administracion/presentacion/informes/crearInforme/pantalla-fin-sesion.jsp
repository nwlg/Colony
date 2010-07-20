<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">


	<head lang="es" dir="ltr">
	
	<title>
		<bean:message key="title.Comun"/>
	</title>
	
	<link rel="shortcut icon" href="/static/img/favicon.ico" />
	<link rel="stylesheet" media="screen" href="/static/css/red.css" type="text/css" />
	<script type="text/javascript" src="/static/js/plantilla.js"></script>
	
	<!--[if lte IE 6]>
	<style title="Hoja de estilo oculta para Internet Explorer">
	@import url("/static/css/ancho_maximo.css"); 
	</style>
	<![endif]-->
	
	</head>


    <body>
    
	<%@ include file="/taglib-imports.jspf" %>
	
	<!--  CAPA QUE CONTIENE TODAS LAS DEMAS  -->
<!--  INICIO CAPA MADRE   -->
<div id="capa_madre">

<!--  INICIO CUERPO GENERAL   -->
<!--  INICIO CUERPO GENERAL   -->
<div id="cuerpo_ventana_flotante">

<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- INICIO CABECERA  -->
<div id="cabecera">

<!-- INICIO METANAVEGACION   -->
<!-- INICIO METANAVEGACION   -->
<div id="metanavegacion">
<ol>

	<li class="oculto"><a href="#contenido_central" title="<bean:message key="informe.contenidoPrincipal"/>"><strong><bean:message key="contenido"/></strong></a></li>
	<li><a href="javascript:window.close();" title="<bean:message key="informe.salir"/>" id="li_inicial"><bean:message key="informe.cerrarVentana"/></a></li>
		
</ol>
</div>
<!-- FIN METANAVEGACION   -->
<!-- FIN METANAVEGACION   -->



<br class="oculto" />

</div>

<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
<div class="tronco_de_contenido">
<div id="madre_barra"><div class="fondolat"></div></div>


<!-- Inicio Contenido ESPECÍFICO  -->
<!-- Inicio Contenido ESPECÍFICO  -->
<div id="contenido_central_largo">

<!-- ************************     INICIO PLANTILLA CONTENIDO     *************************  -->
    <div class="plantilla_contenido">
    
    <!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
	<jsp:include page="/layout/messages.jsp" flush="true" />

	<h2><bean:message key="informes.crearInforme.cabecera"/></h2>
<form name="crearInformeListadoFechasAceptarForm" action="javascript:window.close();">	

		<!--  ********************     INICIO GLOBO GRIS   *********************  -->
		<div class="globo_gris" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					<!--  *********************       INICIO CAJA DE FORMULARIO     *******************  -->
						<div id="formulario" class="ali_c">
							
							
							
							
							<!--  *********************       Caja de Texto de Nombre de Tarea     *******************  -->
							
								
								<p><em class="incorrecto"><bean:message key="informes.sesion.expirada"/></em></p>
								<br class="oculto" />
						
							
							
							
						
				 
				 
						</div >
						<!--  ********************     FIN CAJA FORMULARIO   *********************  -->
					</div>	
				</div>		
			</div>			
		</div>			
		<!--  ********************     FIN GLOBO GRIS   *********************  -->
		<!--********************     Boton Continuar      *********************  -->
		
		<bean:define id="aceptValue"><bean:message key="informes.crearInforme.verInforme"/></bean:define>	
		<input class="boton_125 tipo ft_centrada"  type="submit"  value="<bean:message key='usuarios.aceptar'/>" />	 
		
	</form>		
	


	</div>
	<!-- ************************     FIN  PLANTILLA  CONTENIDO   *************************  -->
</div>
<!-- Fin Contenido ESPECÍFICO  -->
<!-- Inicio Contenido ESPECÍFICO  -->
</div>
<!-- Fin cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
<!-- Fin cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->



</div>
<!--  FIN CUERPO GENERAL   -->
<!--  FIN CUERPO GENERAL   -->

</div>
<!--  FIN CAPA MADRE   -->
<!--  FIN CAPA MADRE   -->
	
	

    </body>

	
</html>
