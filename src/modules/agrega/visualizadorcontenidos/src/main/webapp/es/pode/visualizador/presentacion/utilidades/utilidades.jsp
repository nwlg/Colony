<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>

<tiles:insert definition="layout-usuario">

<tiles:put name="title" type="string">
	<bean:message key="portada.title"/>
</tiles:put>

    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="body" type="string">
    
    	<%@ include file="/taglib-imports.jspf" %>
    
        <%@ include file="/es/pode/visualizador/presentacion/utilidades/utilidades-javascript.jspf" %>

    	<div class="plantilla_contenido">


			<h2><bean:message key="utilidades.titulo"/></h2>
			
			
			<!--  ENLACE PARA EL AGREGASLIDER   -->
			
			<!--  INICIO GLOBO GRIS   -->
			<div class="globo_gris" >
				<div class="globo_gris_01">
					<div class="globo_gris_02">
						<div class="globo_gris_03">
						
							<!--  INICIO CAJA DE FORMULARIO   -->
							<div class="formulario" style="padding-left:10px">
								<a href="<html:rewrite action="/AgregaSlider/AgregaSlider.do"/>" class="titular_03"><strong><bean:message key="utilidades.agregaSlider.titulo"/></strong></a>
								<p class="parrafo_comun" ><bean:message key="utilidades.agregaSlider.texto"/></p>
							</div>
							<!--  FIN CAJA DE FORMULARIO   -->
							
						</div>
					</div>
				</div>
			</div>
			<!--  FIN GLOBO GRIS   -->
			

			<!--  ENLACE PARA EL CONTENIDO DINAMICO   -->
			
			<!--  INICIO GLOBO GRIS   -->
			<div class="globo_gris" style="margin-top:10px" >
				<div class="globo_gris_01">
					<div class="globo_gris_02">
						<div class="globo_gris_03">
						
							<!--  INICIO CAJA DE FORMULARIO   -->
							<div class="formulario" style="padding-left:10px">
								<a href="<html:rewrite action="/AgregaContenidoDinamico/AgregaContenidoDinamico.do"/>" class="titular_03"><strong><bean:message key="utilidades.contenidoDinamico.titulo"/></strong></a>
								<p class="parrafo_comun" ><bean:message key="utilidades.contenidoDinamico.texto"/></p>
							</div>
							<!--  FIN CAJA DE FORMULARIO   -->
							
						</div>
					</div>
				</div>
			</div>
			<!--  FIN GLOBO GRIS   -->
									
			
		</div>

	</tiles:put>

</tiles:insert>