<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<html:xhtml/>
<tiles:insert definition="${sessionScope.offline == true ? 'layout-offline' : 'layout-administrador'}">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<!--  -->
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">
<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2><bean:message key="buscarObjeto.titulo"/></h2>
<form method="post" action="<html:rewrite action="/BuscarObjetos/BuscarObjetoSelectAction"/>" id="buscarObjetosForm">
<p class="parrafo_comun" id="separacion2"><bean:message key="resultadosObjetos.introduzca"/></p>

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->

			<div id="formulario" >
				<!-- -->
				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda">
  						<div class="text"><label for="iden"><bean:message key="buscarObjeto.identificador"/>:</label></div>
 					</div>
					<div class="contenedor_derecha">
						<div class="text"><input name="identificador" onfocus="limpiarTexto(this)" value="${form.identificador}"  onblur="this.style.backgroundColor='#e1e1e1'" id="identificador" type="text" title="Introduzca Identificador "  /></div>

					</div>
					<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>
				<!-- -->
				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda">
  						<div class="text"><label for="titulo"><bean:message key="buscarObjeto.titulo"/>:</label></div>

 					</div>
					<div class="contenedor_derecha">
						<div class="text"><input name="titulo" onfocus="limpiarTexto(this)" value="${form.titulo}"  onblur="this.style.backgroundColor='#e1e1e1'" id="titulo" type="text" title="Introduzca Título "  /></div>
					</div>
					<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>
				<!-- -->
				<div class="fila_de_tabla">

  					<div class="contenedor_izquierda">
  						<div class="text"><label for="autor"><bean:message key="buscarObjeto.autor"/>:</label></div>
 					</div>
					<div class="contenedor_derecha">
						<div class="text"><input name="autor" onfocus="limpiarTexto(this)" value="${form.autor}"  onblur="this.style.backgroundColor='#e1e1e1'" id="autor" type="text" title="Introduzca Autor "  /></div>
					</div>
					<div class="linea_separadora"></div>
					<br class="oculto" />

				</div>
				<!-- -->
				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda">
  						<div class="text"><label for="fecha_inicio"><bean:message key="buscarObjeto.fechaPublicacion"/>:</label></div>
 					</div>
					<div class="contenedor_derecha">
					
						<div class="text">

						<span class="vert2"><bean:message key="buscarObjeto.entre"/>:&nbsp;&nbsp;</span>
						<input name="diaDesde"  value="${form.diaDesde}" class="fecha_dia" onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" id="diaDesde" type="text" title="Introduzca Día Inicio "  />
<label class="oculto" for="mesDesde"><bean:message key="buscarObjeto.fechaMes"/>:</label>
<input name="mesDesde"  maxlength="2" value="${form.mesDesde }" class="fecha_mes" onblur="this.style.backgroundColor='#e1e1e1'" id="mesDesde" type="text" title="Introduzca Mes Inicio "  />
<label class="oculto" for="anyoDesde"><bean:message key="buscarObjeto.fechaAnio"/>:</label>	<input name="anyoDesde"  maxlength="4" value="${form.anyoDesde}" class="fecha_anio" onblur="this.style.backgroundColor='#e1e1e1'" id="anyoDesde" type="text" title="Introduzca Año Inicio "  />
<span class="vert2"><bean:message key="comun.and"/>&nbsp;&nbsp;</span>
<label class="oculto" for="diaHasta"><bean:message key="buscarObjeto.fechaFin"/>:</label><input name="diaHasta"  value="${form.diaHasta}" class="fecha_dia" onblur="this.style.backgroundColor='#e1e1e1'" maxlength="2" id="diaHasta" type="text" title="Introduzca Día Fin "  />
<label class="oculto" for="mesHasta"><bean:message key="buscarObjeto.fechaMes"/>:</label>

<input name="mesHasta" maxlength="2" value="${form.mesHasta}" class="fecha_mes" onblur="this.style.backgroundColor='#e1e1e1'" id="mesHasta" type="text" title="Introduzca Mes Fin "  />
<label class="oculto" for="anyoHasta"><bean:message key="buscarObjeto.fechaAnio"/>:</label>	<input name="anyoHasta" onfocus="limpiarTexto(this)" maxlength="4" value="${form.anyoHasta}" class="fecha_anio" onblur="this.style.backgroundColor='#e1e1e1'" id="anyoHasta" type="text" title="Introduzca Año Fin "  />

</div>
					</div>
					<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>
				<!-- Idioma de busqueda -->
				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda">
  						<div class="text"><label for="idiomaBusqueda"><bean:message key="buscarObjeto.idioma"/></label></div>
 					</div>
					<div class="contenedor_derecha">
						<div class="text"><html:select name="form" property="idioma" titleKey="buscarObjeto.seleccioneIdioma" styleId="idiomaBusqueda"  styleClass="caja_buscador_selector">
							<html:optionsCollection name="form" property="idiomaBackingList" label="label" value="value"/>
						</html:select></div>
					</div>
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
<fieldset class="tipo ft_centrada">
<input class="boton_125_de_2"  name="action" type="submit"  value=<bean:message key="buscarObjeto.Buscar"/> />
<input class="boton_125_de_2_izq"  name="action" type="submit"  value=<bean:message key="comun.volver"/> />

</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->

</form>
</div>
<!-- Fin plantilla contenido  -->


    </tiles:put>

</tiles:insert>
<script type="text/javascript">		
//<![CDATA[
	window.addEvent('domready', function() { 
	myCal1 = new Calendar({ anyoDesde: {diaDesde:'d',mesDesde:'m',anyoDesde:'Y'}}, { direction: 0, tweak: {x: 6, y: 0} }); });
	myCal2 = new Calendar({ anyoHasta:{diaHasta:'d',mesHasta:'m',anyoHasta:'Y'}}, { direction: 0, tweak: {x: 6, y: 0} }); 
	//]]>
</script>