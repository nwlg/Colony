<?xml version="1.0" encoding="iso-8859-1" ?> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">
<%@ page import="es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/serverProperties.tld" prefix="server" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<%@ include file="/taglib-imports.jspf" %>
<%@ taglib uri="/WEB-INF/tags/idiomasBanderas.tld" prefix="banderas" %>
<%@ taglib uri="/WEB-INF/tags/agregaProperties.tld" prefix="agrega" %>

	<head lang="es" dir="ltr">
	<title><tiles:insert attribute="title" flush="true"/></title>
	<link rel="shortcut icon" href="<rewrite:rewrite url="static/img/favicon.ico"/>" />
	<logic:equal name="form" property="tipoLayoutBuscador" value="FEDERADO">
		<link rel="stylesheet" media="screen" href="<rewrite:rewrite url="static/css/red_neutro.css"/>" type="text/css"/>
	</logic:equal>
	<logic:notEqual name="form" property="tipoLayoutBuscador" value="FEDERADO">	
		<logic:equal name="form" property="tipoLayoutBuscador" value="NEUTRO">
			<link rel="stylesheet" media="screen" href="<rewrite:rewrite url="static/css/red_neutro.css"/>" type="text/css" />
		</logic:equal>
		<logic:notEqual name="form" property="tipoLayoutBuscador" value="NEUTRO">	
			<link rel="stylesheet" media="screen" href="<rewrite:rewrite url="static/css/red.css"/>" type="text/css" />
		</logic:notEqual>	
	</logic:notEqual>	
	<!--[if IE 6]>
	<link rel="stylesheet" media="screen" href="<rewrite:rewrite url="static/css/ie6compat.css"/>" type="text/css" />
	<![endif]-->
	<script type="text/javascript" src="<rewrite:rewrite url="static/js/plantilla.js"/>"></script>
	<link rel="search" type="application/opensearchdescription+xml" title="NDRB" href="<rewrite:rewrite url="searchPlugin/searchPlugin.xml"/>"/>
	</head>
		<body>
		<div id="capa_madre">
			<div id="cuerpo">
				<div class="minwidth">
					<div class="contenido_general">					
						
						<!-- Aqui va la cabecera -->
							<logic:equal name="form" property="tipoLayoutBuscador" value="EMPAQUETADOR">
								<div id="cabecera">
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
									
									<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
									<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
									<div class="tronco_de_contenido">
								
										<div id="madre_barra">
											<div class="fondolat"></div>
										</div>
								
										<!-- Inicio Contenido ESPECÍFICO  -->
										<!-- Inicio Contenido ESPECÍFICO  -->
										<div id="contenido_central_largo">
											<tiles:insert attribute="body" flush="true"/>
											<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
										</div>
										<!-- Fin Contenido ESPECÍFICO  -->
										<!-- Inicio Contenido ESPECÍFICO  -->
								
										<!-- Pie de pagina -->
										<tiles:insert attribute="pie" flush="true"/>
								
							</logic:equal>
							<logic:equal name="form" property="tipoLayoutBuscador" value="BUSCADOR">

							<!-- NDRB logo header -->
							<div id="cabecera" class="heading_text">
							<a href="http://<agrega:agregaProperties property="host"/>">
							<div class="cabecera_logo">
							</div>
							</a>
							<div class="cabecera_text">
							national digital resource bank
							</div>
							</div>

							<!-- Header bar (menu bar underneath logo) -->
							<div class="header_bar">

							<!-- Menu/User options set by each page -->
							<div style="margin: 4px 4px;">
							<tiles:insert definition="menu.cabecera.metanavegacion" flush="true"/>
							</div>

							<!-- End of header bar -->
							</div>

								<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
								<div class="tronco_de_contenido">
								<!-- Menu de cabecera -->
								<tiles:insert attribute="menu-principal" flush="true"/>
								<!-- Menu lateral -->
								
								<!-- Insert the RHS menu -->
								<tiles:insert attribute="menu-rhs" flush="true"/>

								<!-- Inicio Contenido ESPECÍFICO  -->
								<div id="contenido_central_largo">
								<tiles:insert attribute="body" flush="true"/>
								</div>	
								
								<!-- Pie de pagina -->
								<tiles:insert attribute="pie" flush="true"/>
											
							</logic:equal>
							<logic:equal name="form" property="tipoLayoutBuscador" value="NEUTRO">
								<div id="metanavegacion" style="height:14px" >
									<ol>
										<banderas:idiomasBanderasTag urlIdiomasBanderas="${initParam.url_idiomas_banderas}"/>
									</ol>
								</div>
								
								<div id="cabecera02">
									<div id="ccaa_flash">
										<object width="140" height="47"  name="base">
											<param value="<rewrite:rewrite url="static/flash/ccaa.swf"/>"  />
											<param name="wmode" value="transparent"  />
											<embed base="." src="<rewrite:rewrite url="static/flash/ccaa.swf"/>" quality="high" width="140"
											height="47" name="base" type="application/x-shockwave-flash" /> 
										</object>
									</div>
									<div title="<server:serverProperties property="ccaa"/>">
										<a href="http://www.proyectoagrega.es" title="<bean:message key="buscador.pagina.inicio"/>" id="logo"><span><bean:message key="buscador.pagina.inicio" /></span></a>
									</div>						
									<div class="destacado_patros" >
										<strong class="oculto"><bean:message key="pie.colaboran"/>:</strong>
										<ul id="patros">
											<li id="pat_01_gob"><a href="http://www.la-moncloa.es/default.htm" target="_blank" title="<bean:message key="pie.gobiernoEspania"/>" ><bean:message key="pie.gobiernoEspania"/></a>&nbsp;</li>
											<li id="pat_02_edu"><a href="http://www.mec.es" target="_blank" title="<bean:message key="pie.ministeEducionCiencia"/>"><bean:message key="pie.ministeEducionCiencia"/></a>&nbsp;</li>								
											<li id="pat_03_ind"><a href="http://www.mityc.es" target="_blank" title="<bean:message key="pie.ministeIndusTursComer"/>"><bean:message key="pie.ministeIndusTursComer"/></a>&nbsp;</li>
											<li id="pat_04_cnice"><a href="http://www.cnice.es"  target="_blank" title="<bean:message key="pie.cnice"/>"><bean:message key="pie.cnice"/></a>&nbsp;</li>
											<li id="pat_05_red"><a href="http://www.red.es" target="_blank" title="<bean:message key="pie.tituloComun"/>"><bean:message key="pie.tituloComun"/></a>&nbsp;</li>								
										</ul>
									</div>
								</div>
								</div>								
								<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
								<div class="tronco_de_contenido">
								<!-- Menu de cabecera -->
								<tiles:insert attribute="menu-principal" flush="true"/>
								<!-- Menu lateral -->
								
								<!-- Inicio Contenido ESPECÍFICO  -->
								<div id="contenido_central_largo">
								<tiles:insert attribute="body" flush="true"/>
								</div>	
								
								<!-- Inicio Pie de pagina  -->
								<div id="pie_pagina">
									<hr />
									<a href="/${initParam.url_informacionLegal}" id="info" title="<bean:message key="pie.informacionLegal"/>"><span><bean:message key="pie.informacionLegal"/></span></a>
									<a href="/${initParam.url_politicaPrivacidad}" id="politica" title="<bean:message key="pie.politicaPrivacidad"/>"><span><bean:message key="pie.politicaPrivacidad"/></span></a>									
								</div>
								<!-- Fin Pie de pagina  -->
								
							</logic:equal>
							<logic:equal name="form" property="tipoLayoutBuscador" value="FEDERADO">
								<div id="cabecera">																
									<br class="oculto" />
									<div title="<server:serverProperties property="ccaa"/>" id="logo">
										<span><server:serverProperties property="ccaa"/></span>
									</div>
									<br class="oculto" />
									
									<div id="ccaa_flash">
										<object width="140" height="47"  name="base">
											<param value="<rewrite:rewrite url="static/flash/ccaa.swf"/>"  />
											<param name="wmode" value="transparent"  />
											<embed base="." src="<rewrite:rewrite url="static/flash/ccaa.swf"/>" quality="high" width="140"
											height="47" name="base" type="application/x-shockwave-flash" /> 
										</object>
									</div>							
									<div class="destacado_patros" >
										<strong class="oculto"><bean:message key="pie.colaboran"/>:</strong>
										<ul id="patros">
											<li id="pat_01_gob"><a href="http://www.la-moncloa.es/default.htm" target="_blank" title="<bean:message key="pie.gobiernoEspania"/>" ><bean:message key="pie.gobiernoEspania"/></a>&nbsp;</li>
											<li id="pat_02_edu"><a href="http://www.mec.es" target="_blank" title="<bean:message key="pie.ministeEducionCiencia"/>"><bean:message key="pie.ministeEducionCiencia"/></a>&nbsp;</li>								
											<li id="pat_03_ind"><a href="http://www.mityc.es" target="_blank" title="<bean:message key="pie.ministeIndusTursComer"/>"><bean:message key="pie.ministeIndusTursComer"/></a>&nbsp;</li>
											<li id="pat_04_cnice"><a href="http://www.cnice.es"  target="_blank" title="<bean:message key="pie.cnice"/>"><bean:message key="pie.cnice"/></a>&nbsp;</li>
											<li id="pat_05_red"><a href="http://www.red.es" target="_blank" title="<bean:message key="pie.tituloComun"/>"><bean:message key="pie.tituloComun"/></a>&nbsp;</li>								
										</ul>
									</div>
								
								</div>								
								<!-- Inicio cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->
								<div class="tronco_de_contenido">
									<!-- Menu de cabecera -->
									<tiles:insert attribute="menu-principal" flush="true"/>
									<!-- Menu lateral -->
									
									<!-- Inicio Contenido ESPECÍFICO  -->
									<div id="contenido_central_largo">
										<tiles:insert attribute="body" flush="true"/>
									</div>	
								
									<!-- Inicio Pie de pagina  -->
									<div id="pie_pagina">
										<hr />
										<a href="/${initParam.url_informacionLegal}" id="info" title="<bean:message key="pie.informacionLegal"/>"><span><bean:message key="pie.informacionLegal"/></span></a>
										<a href="/${initParam.url_politicaPrivacidad}" id="politica" title="<bean:message key="pie.politicaPrivacidad"/>"><span><bean:message key="pie.politicaPrivacidad"/></span></a>									
									</div>
									<!-- Fin Pie de pagina  -->
										
							</logic:equal>
						</div>
					<!-- Fin cuerpo central de pagina con Menu Principal, capa Lateral y capa Central  -->				
					
					
					</div>
					</div>
				</div>
			</div>
		</body>
	</html>
