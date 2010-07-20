<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/tags/serverProperties.tld" prefix="server" %>

<tiles:insert definition="layout-sinlateral">

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="body" type="string">


		<%@ include file="/layout/messages.jsp"%>
 
<!--  INICIO CAPA MADRE   -->
<div id="capa_madre">


	<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
	<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
	<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
	<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
	<!-- ATENCION!! RREMPLAZAR ESTA CAPA DE LA  PLANTILLA DE CONTENIDO ("plantilla_contenido") POR LA QUE SE DESEE EN LA PLANTILLA BASE  -->
	<!-- Inicio plantilla contenido  -->
	<!-- Inicio plantilla contenido  -->
	
	<div class="plantilla_contenido">


	<h2><bean:message key="seleccionTipoBusqueda.titulo"/></h2>
	<form method="get" action="<html:rewrite action="/SeleccionTipoBusquedaCU/SeleccionTipoBusquedaDecidirSalida.do"/>" >
	<logic:equal name="form" property="mostrarAmbito" value="true">
		<p class="parrafo_comun" id="separacion2"><bean:message key="seleccionTipoBusqueda.seleccionar.ambitoBusqueda"/></p>
		<!--  INICIO GLOBO GRIS   -->
		<!--  INICIO GLOBO GRIS   -->
		<div class="globo_gris" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
						<!--  INICIO CAJA DE FORMULARIO   -->
						<div id="formulario" >
						
							 <div class="fila_de_tabla">
				  				<div class="text ft_lateral">
				  					<html:radio property="tipoBusquedaArbol" styleClass="boton_radio" styleId="Formato01" name="form" value="01" />
									<span class="vert">
										<bean:message key="seleccionTipoBusqueda.ambito.todosNodos"/>
									</span>
								</div>
								
								<div class="linea_separadora"></div>
								
								<br class="oculto" />
								
							</div>
								<!--     -->
							<div class="fila_de_tabla">
								<div class="text ft_lateral">
									<html:radio property="tipoBusquedaArbol" styleClass="boton_radio" styleId="Formato01" name="form" value="02" />
										<span class="vert">
											<server:serverProperties property="ccaa"/>
										</span>
								</div>
								
								<div class="linea_separadora"></div>
								
								<br class="oculto" />
								
							</div>
						</div>
						<!--  FIN CAJA DE FORMULARIO   -->
					</div>
				</div>
			</div>
		</div>
		</logic:equal>
		<!--  FIN GLOBO GRIS   -->
		<!--  FIN GLOBO GRIS   -->
		<p class="parrafo_comun" id="separacion3"><bean:message key="seleccionTipoBusqueda.seleccionar.tipoBusqueda"/></p>
		<!--  INICIO GLOBO GRIS   -->
		<!--  INICIO GLOBO GRIS   -->
		<div class="globo_gris" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
						<!--  INICIO CAJA DE FORMULARIO   -->
						<div id="formulario_02" >
			
							<div class="fila_de_tabla">
					  			<div class="text ft_lateral">
					  				<html:radio property="tipoNavegacion" styleClass="boton_radio" styleId="Formato01" name="form" value="01" />
										<span class="vert">
											<bean:message key="seleccionTipoBusqueda.arbol.arbolCurricular"/>
										</span>
								</div>
									
								<div class="linea_separadora"></div>
									
								<br class="oculto" />
									
							</div>
							<!--     -->
							
							<div class="fila_de_tabla">
								<div class="text ft_lateral">
									<html:radio property="tipoNavegacion" styleClass="boton_radio" styleId="Formato01" name="form" value="02" />
										<span class="vert">
											${form.tituloTesauro}
										</span>
								</div>
									
								<div class="linea_separadora"></div>
								
								<br class="oculto" />
									
							</div>
						</div>
						<!--  FIN CAJA DE FORMULARIO   -->
					</div>
				</div>
			</div>
		</div>

		<!--  FIN GLOBO GRIS   -->
		<!--  FIN GLOBO GRIS   -->		
		<!-- Inicio Botones  -->	
		<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
		<input type="hidden" name="tituloTesauro" value="${form.tituloTesauro}"/>
		<!-- Inicio Botones  -->
		<fieldset class="tipo ft_centrada">
			<input class="boton_125"  type="submit" value="<bean:message key="seleccionTipoBusqueda.boton.seleccionar"/>"/>
		</fieldset>
		<!-- Fin Botones  -->
		<!-- Fin Botones  -->

	</form>

	
	</div>
	<!-- Fin plantilla contenido  -->
	<!-- Fin plantilla contenido  -->
	<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
	<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
	<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->

</div>
<!--  FIN CAPA MADRE   -->
	</tiles:put>

</tiles:insert>