<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">

	<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
	<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
	<%@ taglib uri="/WEB-INF/tags/serverProperties.tld" prefix="server" %>
	<%@ taglib uri="/WEB-INF/tags/link.tld" prefix="link" %>
	<%@ include file="/taglib-imports.jspf" %>
	<head lang="es" dir="ltr">
		<title>
			<tiles:insert attribute="title" flush="true"/>
		</title>
		
		<link rel="shortcut icon" href="/static/img/favicon.ico" />
		
		<!--  Se comprueba si la busqueda realizada fue federada  -->
		<logic:notEqual name="form" property="tipoLayoutBuscador" value="FEDERADO">	
			<link rel="stylesheet" media="screen" href="/static/css/red.css" type="text/css" />
		</logic:notEqual>
		<logic:equal name="form" property="tipoLayoutBuscador" value="FEDERADO">
			<link rel="stylesheet" media="screen" href="/static/css/red_neutro.css" type="text/css" />
		</logic:equal>
		
		<script type="text/javascript" src="/static/js/plantilla.js"></script>
		<link rel="search" type="application/opensearchdescription+xml" title="NDRB" href="/searchPlugin/searchPlugin.xml">
	</head>
	
	<!--  INICIO BODY  -->
	<body >
		<!--  CAPA QUE CONTIENE TODAS LAS DEMAS  -->
		<!--  INICIO CAPA MADRE   -->
		<div id="capa_madre"  >	
			<!--  INICIO CUERPO GENERAL   -->
			<div id="cuerpo"  >
				<div class="minwidth">
					<div class="contenido_general">
					
						<!-- ##############################################################################################  -->
						<!-- ##################################### LAYOUT EMPAQUETADOR ####################################  -->
						<!-- ##############################################################################################  -->
						<logic:equal name="form" property="tipoLayoutBuscador" value="EMPAQUETADOR">
							<!-- INICIO CABECERA  -->
							<div id="cabecera" >							
								<h1 class="oculto"><span class="oculto"><bean:message key="cabecera.buscador.empaquetador"/></span></h1>
								
								<!-- INICIO METANAVEGACION   -->
								<div id="metanavegacion">
									<ol>
										<li class="oculto"><a href="#contenido_central" title="Contenido Principal"><strong>Contenido</strong></a></li>
										<li><a href="#" onclick="window.close()" title="<bean:message key="metanavegacion.cerrar"/>" id="li_inicial"><bean:message key="metanavegacion.cerrar"/></a></li>
									</ol>
								</div>
								<!-- FIN METANAVEGACION   -->
								<!-- FIN METANAVEGACION   -->
								
								<h2 id="arb"><span><bean:message key="cabecera.buscador.empaquetador"/></span></h2>
								<div class="limpiar"><br class="oculto" /></div>								
							</div>
							<!-- FIN CABECERA  -->							
							
							<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
							<div class="tronco_de_contenido">							
								<div id="madre_barra">
									<div class="fondolat"></div>
								</div>						
								<!-- Inicio Contenido ESPECÍFICO  -->
								<div id="contenido_central_largo">
								<tiles:insert attribute="body" flush="true"/>
								</div>							
							</div>
							<!-- Fin Contenido ESPECÍFICO  -->
							
							<!-- Pie de pagina -->
							<tiles:insert attribute="pie" flush="true"/>	
												
						</logic:equal>
						
						<!-- ##############################################################################################  -->
						<!-- ####################################### LAYOUT BUSCADOR ######################################  -->
						<!-- ##############################################################################################  -->
						<logic:equal name="form" property="tipoLayoutBuscador" value="BUSCADOR">
							<!-- INICIO CABECERA  -->
							<div id="cabecera" >
								<h1>
									<span>
										<server:serverProperties property="ccaa"/>
									</span>
								</h1>													
								<!-- INICIO METANAVEGACION   -->
								<div id="metanavegacion" >
									<ol>
										<li class="oculto"><a href="#contenido_central" title="Contenido Principal"><strong><bean:message key="metanavegacion.contenido"/></strong></a></li>
										
										<li><a href="/${initParam.url_acercaDeAgrega}" title="<bean:message key="metanavegacion.acercade"/>" ><bean:message key="metanavegacion.acercade"/></a></li>
										<li><a href="/${initParam.url_accesibilidad }" title="<bean:message key="metanavegacion.accesibilidad"/>"><bean:message key="metanavegacion.accesibilidad"/></a></li>
										<li><a href="/${initParam.url_faqs }" title="<bean:message key="metanavegacion.faqs"/>"><bean:message key="metanavegacion.faqs"/></a></li>
										<li><a href="/${initParam.url_mapa }" title="<bean:message key="metanavegacion.mapa"/>"><bean:message key="metanavegacion.mapa"/></a></li>
										<li><a href="/${initParam.url_contacto }" title="<bean:message key="metanavegacion.contacto"/>" id="contacto"><bean:message key="metanavegacion.contacto"/></a></li>										
									</ol>
								</div>
								<!-- FIN METANAVEGACION   -->
								<br class="oculto" />
								<a href="#" title="Volver A Página de Inicio" id="logo"><span>Volver A Página de Inicio</span></a><br class="oculto" />
																	
							</div>	
							<!-- INICIO CABECERA  -->
							
							<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
							<div class="tronco_de_contenido" >
								<div id="madre_barra" >
									<div class="fondolat">
									</div>
								</div>			
								<!-- Inicio Contenido ESPECÍFICO  -->
								<div id="contenido_central_largo">
								<tiles:insert attribute="body" flush="true"/>
								</div>	
								<!-- Fin Contenido ESPECÍFICO  -->	
							</div>
							<!-- Fin cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->	
							
							<!-- Pie de pagina -->
							<tiles:insert attribute="pie" flush="true"/>					
							
						</logic:equal>
						
						
						<!-- ##############################################################################################  -->
						<!-- ####################################### LAYOUT FEDERADA ######################################  -->
						<!-- ##############################################################################################  -->
						<logic:equal name="form" property="tipoLayoutBuscador" value="FEDERADO">
							<!-- INICIO CABECERA  -->
							<div id="cabecera" >	
								<div title="<server:serverProperties property="ccaa"/>" id="logo">
									<span><server:serverProperties property="ccaa"/></span>
								</div>
								<br class="oculto" />					
								<div id="ccaa_flash"><span class="no_flash"><a href="http://www.adobe.com/shockwave/download/"><bean:message key="cabecera.federado.instalar.adobe.flash"/></a></span>
									<script type="text/javascript">
									// <![CDATA[
									var fo = new 
									FlashObject("ccaa.swf", "comunidades", "140", "47", "7", "transparent"); 
									fo.write("ccaa_flash");
									// ]]> 
									</script>
								</div>								
								<div class="destacado_patros" >
									<strong class="oculto"><bean:message key="pie.colaboran"/>:</strong>
									<ul id="patros">
										<li id="pat_01_gob"><a href="http://www.la-moncloa.es/default.htm" target="_blank" title="<bean:message key="pie.gobiernoEspania"/>" ><bean:message key="pie.gobiernoEspania"/></a>&nbsp;</li>
										<li id="pat_02_edu"><a href="http://www.mec.es" target="_blank" title="<bean:message key="pie.ministeIndusTursComer"/>"><bean:message key="pie.ministeIndusTursComer"/></a>&nbsp;</li>								
										<li id="pat_03_ind"><a href="http://www.mityc.es" target="_blank" title="<bean:message key="pie.ministeIndusTursComer"/>"><bean:message key="pie.ministeIndusTursComer"/></a>&nbsp;</li>
										<li id="pat_04_cnice"><a href="http://www.cnice.es"  target="_blank" title="<bean:message key="pie.cnice"/>"><bean:message key="pie.cnice"/></a>&nbsp;</li>
										<li id="pat_05_red"><a href="http://www.red.es" target="_blank" title="<bean:message key="pie.tituloComun"/>"><bean:message key="pie.tituloComun"/></a>&nbsp;</li>								
									</ul>
								</div>						
							</div>
							<!-- INICIO CABECERA  -->
							
							<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
							<div class="tronco_de_contenido" >
								<div id="madre_barra" >
									<div class="fondolat">
									</div>
								</div>			
								<!-- Inicio Contenido ESPECÍFICO  -->
								<div id="contenido_central_largo">
								<tiles:insert attribute="body" flush="true"/>
								</div>									
								<!-- Fin Contenido ESPECÍFICO  -->	
							</div>
							<!-- Fin cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->	
							
							<!-- Inicio Pie de pagina  -->
							<div id="pie_pagina">
								<hr />
								<a href="/${initParam.url_informacionLegal}" id="info" title="<bean:message key="pie.informacionLegal"/>"><span><bean:message key="pie.informacionLegal"/></span></a>
								<a href="/${initParam.url_politicaPrivacidad}" id="politica" title="<bean:message key="pie.politicaPrivacidad"/>"><span><bean:message key="pie.politicaPrivacidad"/></span></a>									
							</div>
							<!-- Fin Pie de pagina  -->
							
						</logic:equal>
						
					</div>
				</div>
			</div>
			<!--  FIN CUERPO GENERAL   -->	
		</div>
		<!--  FIN CAPA MADRE   -->
	</body>
	<!--  INICIO BODY  -->
</html>