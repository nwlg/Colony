<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<bean:define id="urlArchivos"><html:rewrite action="/GestorArchivos/GestorArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/GestorRecursos/GestorRecusos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlEstructura"><html:rewrite action="/GestorBasico/GestorBasico"/></bean:define>
<bean:define id="selected" value="submanifiestos"/>
<emp:layout selected="${selected}" urlEstructura="${urlEstructura}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>




<h2><bean:message key="portal_empaquetado_agregarSubmanifiestos.subirArchivo"/></h2>
<form id="agregarLocalSubirArchivoAceptarForm" method="post" action="<html:rewrite action="/AgregarLocal/SubirArchivoAceptar"/>" enctype="multipart/form-data">
<p class="parrafo_comun" id="separacion2"><bean:message key="portal_empaquetado_agregarSubmanifiestos.seleccionarArchivoRepositorio"/></p>
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario" >

	
	<!--  INICIO ITEMS DE FORMULARIO   -->			
				<div class="fila_de_tabla ft_centrada">
  					<div class="text"><label class="oculto" for="SelRecurso01"><bean:message key="portal_empaquetado_agregarSubmanifiestos.recurso.numero"/>:</label> <input name="archivo" onfocus="limpiarTexto(this)" value="&nbsp;"  onblur="this.style.backgroundColor='#e1e1e1'" type="file" id="SelRecurso01" type="text" class="selimagen0" title="Seleccione un submanifiesto"  /></div>
				<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>	
				<!-- -->
				</div>
				<!--  FIN CAJA DE FORMULARIO   -->

			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->

<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo">
<input class="boton_125_de_2_izq" type="submit" name="action" value="<bean:message key='portal_empaquetado_agregarSubmanifiestos.cancelar'/>" />
<!-- Cargando  -->
<div id="capa1"><em><bean:message key="comunes.cargando"/></em><img src="<rewrite:rewrite url="static/img/loading_01.gif"/>" alt="<bean:message key="comunes.cargando"/>" /></div>
<input class="boton_125_de_2" onclick="cambio('capa1')" onkeypress="cambio('capa1')" type="submit" name="action"  value="<bean:message key='portal_empaquetado_agregarSubmanifiestos.aceptar'/>" />
</fieldset>
<!-- Fin Botones  -->

<!-- Fin Botones  -->
</form>
</div>
</emp:layout>
