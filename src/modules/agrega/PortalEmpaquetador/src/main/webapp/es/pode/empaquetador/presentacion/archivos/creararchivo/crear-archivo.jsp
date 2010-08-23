<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tlds/tags-empaquetador.tld" prefix="emp" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<bean:define id="urlArchivos"><html:rewrite action="/GestorArchivos/GestorArchivos"/></bean:define>
<bean:define id="urlRecursos"><html:rewrite action="/GestorRecursos/GestorRecursos"/></bean:define>
<bean:define id="urlOrganizaciones"><html:rewrite action="/GestorOrganizaciones/GestorOrganizaciones"/></bean:define>
<bean:define id="urlSubmanifiestos"><html:rewrite action="/GestorSubmanifiestos/GestorSubmanifiestos"/></bean:define>
<bean:define id="urlGuardar"><html:rewrite action="/GestorRecursos/GestorRecursos"/></bean:define>
<bean:define id="urlEstructura"><html:rewrite action="/GestorBasico/GestorBasico"/></bean:define>
<bean:define id="selected" value="archivos"/>
<emp:layout selected="${selected}" urlEstructura="${urlEstructura}" urlArchivos="${urlArchivos}" urlRecursos="${urlRecursos}" urlSubmanifiestos="${urlSubmanifiestos}" urlOrganizaciones="${urlOrganizaciones}" urlGuardar="${urlGuardar}" titleKey="title.Comun">

 <!-- Inicio plantilla contenido  -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>

<h2><bean:message key="presentacion.archivos.creararchivo.cabecera.h2"/></h2>
<form name="form" method="post" action="<html:rewrite action="/CrearArchivo/CrearArchivoAceptar"/>" enctype="multipart/form-data">
<p class="parrafo_comun" id="separacion2"><bean:message key="presentacion.archivos.creararchivo.cabecera.texto"/></p>


<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

			<!--  INICIO CAJA DE FORMULARIO   -->

			<div id="formulario" ><br/>
			 <div class="fila_de_tabla">
  						<div class="text" ><label for="SelArchivo1" class="red_cc"><span>01&nbsp;&nbsp;</span></label><input name="fichero1" class="nombreGrupo" onfocus="limpiarTexto(this)" style="width:50%" value="&nbsp;"  onblur="this.style.backgroundColor='#e1e1e1'" id="SelArchivo1"  type="file" title="<bean:message key="presentacion.archivos.creararchivo.input.text.title"/> 01"  /></div>
					<br class="oculto" />
				</div>
			
			<div class="fila_de_tabla">
				<div class="text ft_lateral"><input type="radio" name="tipo1" class="boton_radio" id="ArchivoSolo1" value="FICHERO" checked="checked"  /><label for="ArchivoSolo1" class="alineada"><bean:message key="presentacion.archivos.creararchivo.input.radio.unico"/></label></div>
				<div class="linea_separadora"></div>

				<br class="oculto" />
				</div>
				<!--     -->
			 <div class="fila_de_tabla">
  				<div class="text ft_lateral"><input  type="radio" class="boton_radio" id="ArchivoComprimido1" value="ZIP"  name="tipo1" /><label for="ArchivoComprimido1"  class="alineada2"><bean:message key="presentacion.archivos.creararchivo.input.radio.zip"/></label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
				</div>

				<!--     -->
					</div>
				<!--  FIN CAJA DE FORMULARIO   -->

</div></div></div></div>
<!-- End of bubble -->

<br/>

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario_02" ><br/>
			 <div class="fila_de_tabla">
  					<div class="text" ><label for="SelArchivo2" class="red_cc"><span>02&nbsp;&nbsp;</span></label><input name="fichero2" class="nombreGrupo" onfocus="limpiarTexto(this)" style="width:50%" value="&nbsp;"  onblur="this.style.backgroundColor='#e1e1e1'" id="SelArchivo2"  type="file"  title="<bean:message key="presentacion.archivos.creararchivo.input.text.title"/> 02 "  /></div>
					<br class="oculto" />
 			 </div>
			
			<div class="fila_de_tabla">
  				  	<div class="text ft_lateral"><input type="radio" name="tipo2" class="boton_radio" id="ArchivoSolo2" value="FICHERO" checked="checked"  /><label for="ArchivoSolo2" class="alineada"><bean:message key="presentacion.archivos.creararchivo.input.radio.unico"/></label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
			</div>
				<!--     -->

			 <div class="fila_de_tabla">
  						 <div class="text ft_lateral"><input  type="radio" class="boton_radio" id="ArchivoComprimido2" value="ZIP"  name="tipo2" /><label for="ArchivoComprimido2"  class="alineada2"><bean:message key="presentacion.archivos.creararchivo.input.radio.zip"/></label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
			 </div>
				<!--     -->
					</div>
				<!--  FIN CAJA DE FORMULARIO   -->

</div></div></div></div>
<!-- End of bubble -->

<br/>

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario_03" ><br/>
			 <div class="fila_de_tabla">
  					<div class="text" ><label for="SelArchivo3" class="red_cc"><span>03&nbsp;&nbsp;</span></label><input name="fichero3" class="nombreGrupo" onfocus="limpiarTexto(this)" style="width:50%" value="&nbsp;"  onblur="this.style.backgroundColor='#e1e1e1'" id="SelArchivo3" type="file"  title="<bean:message key="presentacion.archivos.creararchivo.input.text.title"/> 03"  /></div>
				<br class="oculto" />
			 </div>
			
			<div class="fila_de_tabla">
				<div class="text ft_lateral"><input type="radio" name="tipo3" class="boton_radio" id="ArchivoSolo3" value="FICHERO" checked="checked"  /><label for="ArchivoSolo3" class="alineada"><bean:message key="presentacion.archivos.creararchivo.input.radio.unico"/></label></div>
					<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>
				<!--     -->
			 <div class="fila_de_tabla">
  			  		<div class="text ft_lateral"><input  type="radio" class="boton_radio" id="ArchivoComprimido3" value="ZIP"  name="tipo3" /><label for="ArchivoComprimido3"  class="alineada2"><bean:message key="presentacion.archivos.creararchivo.input.radio.zip"/></label></div>
				<div class="linea_separadora"></div>
				<br class="oculto" />
			 </div>
				<!--     -->
			</div>
				<!--  FIN CAJA DE FORMULARIO   -->

</div></div></div></div>
<!-- End of bubble -->


<!-- Inicio Botones  -->
<!-- Inicio Botones  -->
<fieldset class="tipo">

	<input type="hidden" name="action" value="" />

	<div class="packer_newfolder_accept">
		<!-- Start of Accept button -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	
		<div class="db_bubble_content">
			<a href="javascript:doSubmitUpload('<bean:message key='presentacion.archivos.creararchivo.input.submit.aceptar'/>');"><bean:message key='presentacion.archivos.creararchivo.input.submit.aceptar'/></a>
		</div>
	
		</div></div></div></div>
		<!-- End of bubble -->
	</div>

	<!-- Cargando  -->
	<div id="capa1"><em><bean:message key="comunes.cargando"/></em><img src="<rewrite:rewrite url="static/img/loading_01.gif"/>" alt="<bean:message key="comunes.cargando"/>" /></div>
	<!-- Cargando  -->

	<div class="packer_newfolder_cancel">
		<!-- Start of Cancel button -->
		<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
	
		<div class="db_bubble_content">
			<a href="javascript:doSubmit('<bean:message key='presentacion.archivos.creararchivo.input.submit.cancelar'/>');"><bean:message key='presentacion.archivos.creararchivo.input.submit.cancelar'/></a>
		</div>
	
		</div></div></div></div>
		<!-- End of bubble -->
	</div>

</fieldset>
<!-- Fin Botones  -->

<!-- Fin Botones  -->
</form>
<script type="text/javascript">
  document.forms[0].tipo1[0].focus();

function doSubmit(sAction)
{
	document.forms["form"].action.value = sAction;
	document.forms["form"].submit();
}

function doSubmitUpload(sAction)
{
	/* Display the loading graphic during submission */
	cambio('capa1');

	document.forms["form"].action.value = sAction;
	document.forms["form"].submit();
}

</script>
</div>

</emp:layout>
