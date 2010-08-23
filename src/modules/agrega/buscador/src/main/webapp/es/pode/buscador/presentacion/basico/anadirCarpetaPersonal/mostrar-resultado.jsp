<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<tiles:insert definition="layout-sinlateral">

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="body" type="string">
<%@ include file="/taglib-imports.jspf" %>



<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido" >
<!-- ## Para pintar los mensajes de error ## -->
	<jsp:include page="/layout/messages.jsp" flush="true" />

	<h2><bean:message key="anadir.ode.carpeta.personal.titulo"/></h2>		
		<!--  INICIO GLOBO GRIS   -->
		<!--  INICIO GLOBO GRIS   -->
		
		<div class="globo_gris" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					<logic:equal name="form" property="resultadoOperacion" value="true">	
					<!--  INICIO CAJA DE FORMULARIO   -->
					<div id="formulario" class="ali_c">
					<br />
					 <p><em class="correcto">
					    <bean:message key="anadir.ode.carpeta.peronal.resultado.correcto"/>
					 </em></p>
					  
						<br />
					</div>
					</logic:equal>					
					<!--  FIN CAJA DE FORMULARIO   -->
					<logic:equal name="form" property="resultadoOperacion" value="false">	
					<!--  INICIO CAJA DE FORMULARIO   -->
					<div id="formulario" class="ali_c">
					<br />
					 <p><em class="incorrecto">
					    <bean:message key="anadir.ode.carpeta.peronal.resultado.incorrecto"/> ${form.descripcionCodigoErroneo}
					 </em></p>					 
						<br />
					</div>
						<!--  FIN CAJA DE FORMULARIO   -->
						</logic:equal>
					</div>
				</div>
			</div>
		</div>
		<!--  FIN GLOBO GRIS   -->

			<!-- Inicio Botones  -->
			<fieldset class="tipo ft_centrada">	
				<logic:equal name="form" property="mostrarVuelta" value="true">
					<logic:equal name="form" property="busquedaSimpleAvanzada" value="BUSQUEDA_ARBOL">
						<form action="<html:rewrite action="/DetallarODECU/DetallarODECU.do"/>?identificadorODE=${form.identificadorODE}&amp;idioma=${form.idiomaODE}&amp;mostrarVuelta=${form.mostrarVuelta}&amp;areaCurricularBusqueda=" method="post">
							<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
							<input class="boton_125"  type="submit"  value="<bean:message key="previsualizar.conSinSecuencia.botonAceptar"/>"/>
						</form>
					</logic:equal>
					<logic:notEqual name="form" property="busquedaSimpleAvanzada" value="BUSQUEDA_ARBOL">
						<form action="<html:rewrite action="/DetallarODECU/DetallarODECU.do"/>?identificadorODE=${form.identificadorODE}&amp;idioma=${form.idiomaODE}&amp;mostrarVuelta=${form.mostrarVuelta}" method="post">
							<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
							<input class="boton_125"  type="submit"  value="<bean:message key="previsualizar.conSinSecuencia.botonAceptar"/>"/>
						</form>
					</logic:notEqual>
				</logic:equal>
				<logic:notEqual name="form" property="mostrarVuelta" value="true">
					<form action="<html:rewrite action="/DetallarODECU/DetallarODECU.do"/>?identificadorODE=${form.identificadorODE}&amp;idioma=${form.idiomaODE}&amp;mostrarVuelta=${form.mostrarVuelta}" method="post">
						<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
						<input class="boton_125"  type="submit"  value="<bean:message key="previsualizar.conSinSecuencia.botonAceptar"/>"/>
					</form>
				</logic:notEqual>
			</fieldset>
			<!-- Fin Botones  -->			
			
</div>
<!-- Fin plantilla contenido  -->

</tiles:put>
</tiles:insert>

