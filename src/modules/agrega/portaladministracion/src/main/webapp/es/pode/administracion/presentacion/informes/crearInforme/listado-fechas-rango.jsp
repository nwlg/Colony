<%@taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">


	<head lang="es" dir="ltr">
	
	<title>
		<bean:message key="title.Comun"/>
	</title>
	
	<link rel="shortcut icon" href="/static/img/favicon.ico" />
	<link rel="stylesheet" media="screen" href="/static/css/red.css" type="text/css" />
	<script type="text/javascript" src="/static/js/plantilla.js"></script>
	<script type="text/javascript" src="/static/js/mootools.js"></script>
    <script type="text/javascript" src="/static/js/calendar.rc4.js"></script>
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

	<li class="oculto"><a href="#contenido_central" title="<bean:message key="informe.contenidoPrincipal"/>"><strong><bean:message key="informe.contenido"/> </strong></a></li>
	<li><a href="javascript:window.close();" title="<bean:message key="informe.salir"/>" id="li_inicial"><bean:message key="informe.cerrarVentana"/> </a></li>
		
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
	
	<html:form styleId="crearInformeListadoFechasRangoAceptarForm" action="/CrearInforme/ListadoFechasRangoAceptar" method="post" enctype="multipart/form-data">
	
		<!--  ********************     INICIO GLOBO GRIS   *********************  -->
		<div class="globo_gris" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					<!--  *********************       INICIO CAJA DE FORMULARIO     *******************  -->
						<div id="formulario" >
							
							<input name="informe" value="${form.informe}" type="hidden" />
							<!--  *********************       Caja de Texto de Nombre de Informe     *******************  -->
							<div class="fila_de_tabla">
								<div class="contenedor_izquierda">
									<div class="text">
										<label for="informe"><bean:message key="informes.nombreInforme"/></label>
									</div>
								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<label id="informe" style="width:400;"><bean:message key="informes.${form.informe}"/></label>
										<br/>
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							
							<!--  *********************       Cajas de Texto de Fecha Desde     *******************  -->
							<div class="fila_de_tabla">
								<div class="contenedor_izquierda" >
									<div class="text">
										<label for="fecha_inicio"><bean:message key="informes.crearInforme.fechaDesde"/></label>
									</div>
								</div>
								<div class="contenedor_derecha" id="cont_esp_fech">
									<div class="text">
									
										<label class="oculto" for="day1"><bean:message key="informes.crearInforme.fechaDia"/></label>
										<input name="diaDesde" value="${form.diaDesde}" class="fechazo"  maxlength="2" id="day1" onblur="this.style.backgroundColor='#e1e1e1'" type="text" title="<bean:message key="informes.crearInforme.introduzcaDia"/> "  />
										
										<label class="oculto" for="month1"><bean:message key="informes.crearInforme.fechaMes"/></label>
            							<input class="fechazo" value="${form.mesDesde}" maxlength="2" onblur="this.style.backgroundColor='#e1e1e1'" id="month1" name="mesDesde" type="text" title="<bean:message key="informes.crearInforme.introduzcaMes"/> "/>
										<label class="oculto" for="year1"><bean:message key="informes.crearInforme.fechaAnio"/></label>	
										<input name="anioDesde" value="${form.anioDesde}" maxlength="4"  class="fechazo" id="year1" onblur="this.style.backgroundColor='#e1e1e1'" type="text" title="<bean:message key="informes.crearInforme.introduzcaAnio"/> "  />
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
							
							
							<!--  *********************       Cajas de Texto de Fecha Hasta    *******************  -->
							<div class="fila_de_tabla">
								<div class="contenedor_izquierda">
									<div class="text">
										<label for="fecha_inicio"><bean:message key="informes.crearInforme.fechaHasta"/></label>
									</div>
								</div>
								<div class="contenedor_derecha" id="cont_esp_fech">
									<div class="text">
									
										<label class="oculto" for="day2"><bean:message key="informes.crearInforme.fechaDia"/></label>
										<input name="diaHasta" value="${form.diaHasta}" class="fechazo"  maxlength="2" id="day2" onblur="this.style.backgroundColor='#e1e1e1'" type="text" title="<bean:message key="informes.crearInforme.introduzcaDia"/> "  />
										
										<label class="oculto" for="month2"><bean:message key="informes.crearInforme.fechaMes"/></label>
            							<input class="fechazo" value="${form.mesHasta}" maxlength="2" onblur="this.style.backgroundColor='#e1e1e1'" id="month2" name="mesHasta" type="text" title="<bean:message key="informes.crearInforme.introduzcaMes"/> "/>
										<label class="oculto" for="year2"><bean:message key="informes.crearInforme.fechaAnio"/></label>	
										<input name="anioHasta" value="${form.anioHasta}" maxlength="4" class="fechazo" id="year2" onblur="this.style.backgroundColor='#e1e1e1'" type="text" title="<bean:message key="informes.crearInforme.introduzcaAnio"/> "  />
										
									</div>
								</div>
								<div class="linea_separadora"></div>
								<br class="oculto" />
							</div>
				 
				 
				 			
				 			<!--		CAMPO rango (desplegable)		-->
						
							<div class="fila_de_tabla">
								<div class="contenedor_izquierda">
									<div class="text">
										<label for="rango"><bean:message key="informes.crearInforme.rango"/></label>
									</div>
								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<html:select  style="width:107px" property="rango" titleKey="informes.crearInforme.seleccioneRango" styleId="rango">
											<html:option key="informes.crearInforme.rango.5" 		value="5" />
											<html:option key="informes.crearInforme.rango.10"	 	value="10" styleClass="oscura" />
											<html:option key="informes.crearInforme.rango.15"	 	value="15" />
											<html:option key="informes.crearInforme.rango.20"	 	value="20" styleClass="oscura" />
											<html:option key="informes.crearInforme.rango.30"	 	value="30" />
											<html:option key="informes.crearInforme.rango.40"	 	value="40" styleClass="oscura" />
											<html:option key="informes.crearInforme.rango.50"	 	value="50" />
											<html:option key="informes.crearInforme.rango.100"	 	value="100" styleClass="oscura" />
										</html:select>
									</div>
								</div>
								<div class="linea_separadora"></div>
								
								<br class="oculto" />
							</div>	
							
				 			
				 			<!-- *********************		CAMPO formato (desplegable)		********************* -->
						
							<div class="fila_de_tabla">
								<div class="contenedor_izquierda">
									<div class="text">
										<label for="formato"><bean:message key="informes.crearInforme.formato"/></label>
									</div>
								</div>
								<div class="contenedor_derecha">
									<div class="text">
										<html:select  style="width:107px" property="formato" titleKey="informes.crearInforme.seleccioneFormato" styleId="formato">
											<html:option key="informes.crearInforme.formato.html" 		value="html" />
											<html:option key="informes.crearInforme.formato.pdf" 		value="pdf" styleClass="oscura"/>
											<html:option key="informes.crearInforme.formato.excel"	 	value="excel"  />
										</html:select>
									</div>
								</div>
								<div class="linea_separadora"></div>
								
								<br class="oculto" />
							</div>	
							
							
						</div >
						<!--  ********************     FIN CAJA FORMULARIO   *********************  -->
					</div>	
				</div>		
			</div>			
		</div>			
		<!--  ********************     FIN GLOBO GRIS   *********************  -->
		
		<!--********************     Boton Continuar      *********************  -->
		
		<bean:define id="aceptValue"><bean:message key="informes.crearInforme.verInforme"/></bean:define>	
		<html:submit styleClass="boton_125 tipo ft_centrada" value="${aceptValue}" ></html:submit>
			 
	</html:form>
	

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
<bean:define id="nomMeses"><bean:message key="catalogadorAvanzado.nombresMeses"/></bean:define>
<bean:define id="nomDias"><bean:message key="catalogadorAvanzado.nombresDias"/></bean:define>
<script type="text/javascript">		
//<![CDATA[

	window.addEvent('domready', function() { 
		jsMeses = "${nomMeses}"; arrayMeses = jsMeses.split(",");
		jsDias = "${nomDias}"; arrayDias = jsDias.split(",");
		myCal1 = new Calendar({ year1: { day1: 'd', month1: 'm', year1: 'Y' }}, { direction: 0, tweak: {x: 6, y: 0}, 
			months: arrayMeses ,days: arrayDias });
		myCal2 = new Calendar({ year2: { day2: 'd', month2: 'm', year2: 'Y' }}, { direction: 0, tweak: {x: 6, y: 0},months: arrayMeses ,days: arrayDias });
			});
	//]]>
</script>	
	
	

   </body>

	
</html>
