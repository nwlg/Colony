<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>

<tiles:insert definition="layout-usuario">

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="style" type="string">
        <link rel="stylesheet" type="text/css" media="screen" href="<html:rewrite page="/es/pode/visualizador/presentacion/mapa/mapa.css"/>"></link>
    </tiles:put>

        <tiles:put name="body" type="string">
        <%@ include file="/es/pode/visualizador/presentacion/mapa/mapa-javascript.jspf" %>
<div class="plantilla_contenido">

<h2><bean:message key="mapa.nombre"/></h2>

<div id="contenido_mapa">
<p><bean:message key="mapa.texto"/>.</p>

<!-- INICIO  LISTADO MAPA  --> 
<ul class="mapa">
		<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_acercaDeAgrega }"/>"><em><bean:message key="mapa.acercaDeAgrega"/></em></a></div></li>
		<li class="blanco"><div><a href="${initParam.url_comunidad }"><em><bean:message key="mapa.comunidad"/></em></a></div></li>
		<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_accesibilidad }"/>"><em><bean:message key="mapa.accesibilidad"/></em></a></div></li>
		<li class="blanco"><div><a href="<rewrite:rewrite url="${initParam.url_faqs }"/>"><em><bean:message key="mapa.preguntasFrecuentes"/></em></a></div></li>
		<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_contacto }"/>"><em><bean:message key="mapa.contacto"/></em></a></div></li>
		<li class="blanco"><div><a href="<rewrite:rewrite url="${initParam.url_portada }"/>"><em><bean:message key="mapa.portada"/></em></a></div>
				<ul class="submapa">
						<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_noticias }"/>"><em><bean:message key="mapa.noticias"/></em></a></div></li>
						<li class="blanco"><div><a href="<rewrite:rewrite url="${initParam.url_informes}"/>"><em><bean:message key="mapa.informes"/></em></a></div></li>
						<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_descargas_portal}"/>"><em><bean:message key="mapa.descargas"/></em></a></div></li>
						<li class="blanco"><div><a href="<rewrite:rewrite url="${initParam.url_utilidades}"/>"><em><bean:message key="mapa.agrega.en.tu.web"/></em></a></div></li>
						<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_taggingWeb}"/>"><em><bean:message key="mapa.etiquetado"/></em></a></div></li>
				</ul>
		</li>

		<li class="blanco" ><div><a href="<rewrite:rewrite url="${initParam.url_seleccionTipoBusqueda}"/>"><em><bean:message key="mapa.busqueda.taxonomica"/></em></a></div></li>
		<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_gestorFlujo }"/>"><em><bean:message key="mapa.carpetaPersonal"/></em></a></div>
 				<ul class="submapa">
						<li class="blanco"><div><a href="<rewrite:rewrite url="${initParam.url_gestorFlujo }"/>"><em><bean:message key="mapa.personales"/></em></a></div>
						<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_gestorFlujo_init }/ObjetosCompartidosCU/ObjetosCompartidosCU.do"/>"><em><bean:message key="mapa.compartidos"/></em></a></div></li>
						<li class="blanco"><div><a href="<rewrite:rewrite url="${initParam.url_gestorFlujo_init }/ObjetosPropuestosCU/ObjetosPropuestosCU.do"/>"><em><bean:message key="mapa.propuestos"/></em></a></div></li>
						<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_gestorFlujo_init }/ObjetosPublicadosCU/ObjetosPublicadosCU.do"/>"><em><bean:message key="mapa.publicados"/></em></a></div></li>
				</ul>
		</li>		
		<li class="blanco"><div><a href="<rewrite:rewrite url="${initParam.url_portada_admin}"/>"><em><bean:message key="mapa.administracion"/></em></a></div>
				<ul class="submapa">
						<li class="color"><div><span><em><bean:message key="mapa.contenidos"/></em></span></div>
							<ul class="submapa_3nivel">
								<li class="blanco"><div><a href="<rewrite:rewrite url="${initParam.url_noticias_admin }"/>"><em><bean:message key="mapa.noticias"/></em></a></div></li>								
								<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_admin_descargas}"/>"><em><bean:message key="mapa.descargas"/></em></a></div></li>
								<li class="blanco"><div><a href="<rewrite:rewrite url="${initParam.url_faqs_admin }"/>"><em><bean:message key="mapa.preguntasFrecuentes"/></em></a></div></li>
								<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_admin_taggingWeb }"/>"><em><bean:message key="mapa.etiquetado"/></em></a></div></li>
							</ul>
						</li>
						<li class="blanco"><div><span><em><bean:message key="mapa.plataforma"/></em></span></div>
							<ul class="submapa_3nivel">
								<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_nodos_admin}"/>"><em><bean:message key="mapa.nodo"/></em></a></div></li>
								<li class="blanco"><div><a href="<rewrite:rewrite url="${initParam.url_adminusuarios_usuarios}"/>"><em><bean:message key="mapa.usuarios"/></em></a></div></li>
								<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_logs}"/>"><em><bean:message key="mapa.logs"/></em></a></div></li>
								<li class="blanco"><div><a href="<rewrite:rewrite url="${initParam.url_informes}"/>"><em><bean:message key="mapa.informes"/></em></a></div></li>
								<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_planificador}"/>"><em><bean:message key="mapa.planificador"/></em></a></div></li>
								<li class="blanco"><div><a href="<rewrite:rewrite url="${initParam.url_modificador}"/>"><em><bean:message key="mapa.modificador"/></em></a></div></li>
								<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_monitorizar}"/>"><em><bean:message key="mapa.monitorizador"/></em></a></div></li>
								<li class="blanco"><div><a href="<rewrite:rewrite url="${initParam.url_adminusuarios_grupos}"/>"><em><bean:message key="mapa.roles"/></em></a></div></li>
								<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_adminusuarios_gruposTrabajo}"/>"><em><bean:message key="mapa.gruposTrabajo"/></em></a></div></li>
								<li class="blanco"><div><a href="<rewrite:rewrite url="${initParam.url_estructurasEdu}"/>"><em><bean:message key="mapa.taxonomias.tesauros"/></em></a></div></li>
								<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_repositorios_admin}"/>"><em><bean:message key="mapa.repositorios"/></em></a></div></li>
							</ul>

						</li>
						<li class="blanco"><div><span><em><bean:message key="mapa.configuracion"/></em></span></div>
							<ul class="submapa_3nivel">								
								<li class="color"><div><a href="<rewrite:rewrite url="${initParam.url_gestorFlujo_admin}"/>"><em><bean:message key="mapa.publicador"/></em></a></div></li>
								<li class="blanco"><div><a href="<rewrite:rewrite url="${initParam.url_gestorFlujo_catalogacion}"/>"><em><bean:message key="mapa.catalogador"/></em></a></div></li>
							</ul>

						</li>
					</ul>
		</li>
		<li class="color" ><div><a href="<rewrite:rewrite url="${initParam.url_informacionLegal}"/>"><em><bean:message key="mapa.informacionLegal"/></em></a></div></li>
		<li class="blanco" id="final"><div><a href="<rewrite:rewrite url="${initParam.url_politicaPrivacidad }"/>"><em><bean:message key="mapa.politicaPrivacidad"/></em></a></div></li>
</ul>


<!-- FIN LISTADO TIPO  -->


</div>
</div>

    </tiles:put>

</tiles:insert>
