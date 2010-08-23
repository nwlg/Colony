<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn" %>
<%@ taglib uri="/WEB-INF/tlds/tags-modificadorWeb.tld"  prefix="mod" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<tiles:insert definition="${sessionScope.offline == true ? 'layout-offline' : 'layout-administrador'}">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

 
<!-- *****************************   Inicio  Plantilla contenido      ********************************** -->
<div class="plantilla_contenido">

<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />


<h2><bean:message key="comprobarTermino.titulo"/></h2>
<form id="comprobarTerminoComprobarTerminoSelectActionForm" action="<html:rewrite action="/ComprobarTermino/ComprobarTerminoSelectAction"/>"  method="post">
<p class="parrafo_comun" id="separacion2"><bean:message key="comprobarTermino.necesarioRellenarCompl"/>.</p>

<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->

			<div id="formulario" >
  				<div class="fila_de_tabla" >
  					<div class="contenedor_izquierda">
  						<div class="text"><label for="valor"><bean:message key="comprobarTermino.valor"/>:</label></div>
 					</div>
					<div class="contenedor_derecha">
						<div class="text"><input name="valor" value="${form.valor}"  onblur="this.style.backgroundColor='#e1e1e1'" id="valor" type="text" title="Introduzca Valor"  /></div>
					</div>

					<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>
				<!-- -->
				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda">
  						<div class="text"><label for="expRegular_si"><bean:message key="comprobarTermino.exprRegular"/>:</label></div>
 					</div>

					<div class="contenedor_derecha">
						<div class="text">
							<html:radio styleClass="boton_radio" styleId="exprReg" name="form" property="exprReg" value="true" />
						<span class="vert"><bean:message key="comprobarTermino.si"/></span></div>
					</div>
					<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>	
				<!-- -->
				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda">

  						<div class="text"><label for="expRegular_no">&nbsp;</label></div>
 					</div>
					<div class="contenedor_derecha">
						<div class="text">
						<html:radio styleClass="boton_radio" styleId="exprReg" name="form" property="exprReg" value="false" />
						<span class="vert"><bean:message key="comprobarTermino.no"/></span></div>
					</div>
					<div class="linea_separadora"></div>
				</div>
				<!-- -->

				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda">
  						<div class="text"><label for="Idioma"><bean:message key="comprobarTermino.idioma"/>:</label></div>
 					</div>
					<div class="contenedor_derecha">
						<div class="text">
					<c:if test="${form.formulario.langString == true}" >	
					<input name="idioma" value=""  onblur="this.style.backgroundColor='#e1e1e1'" id="Idioma" type="text" title="Introduzca Idioma"  />
					</c:if>
					<c:if test="${form.formulario.langString == false}" >	
					<input name="idioma" disabled="true" onfocus="limpiarTexto(this)" value=""  onblur="this.style.backgroundColor='#e1e1e1'" id="Idioma" type="text" title="Introduzca Idioma"  />
					</c:if>
					</div>
					</div>
					<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>	
				<!-- -->				
				<div class="fila_de_tabla">

  					<div class="contenedor_izquierda">
  						<div class="text"><label for="alcMeta01"><bean:message key="comprobarTermino.alcanceMetadatos"/>:</label></div>
 					</div>
					<div class="contenedor_derecha">
						<div class="text">
						<html:radio styleClass="boton_radio" styleId="alcance" name="form" property="alcance" value="false" />
						<span class="vert"><bean:message key="comprobarTermino.soloCategoriaPpal"/></span></div>
					</div>
					<div class="linea_separadora"></div>
					<br class="oculto" />

				</div>	
				<!-- -->
				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda">
  						<div class="text"><label for="alcMeta02">&nbsp;</label></div>
 					</div>
					<div class="contenedor_derecha">
						<div class="text">
						<html:radio styleClass="boton_radio" styleId="alcance" name="form" property="alcance" value="true" />
						<span class="vert"><bean:message key="comprobarTermino.todosMetadatos"/></span></div>
					</div>

					<div class="linea_separadora"></div>
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
<!-- Inicio Botones  -->
<fieldset class="tipo ft_centrada">
<input class="boton_125_de_2"  type="submit" name="action" value="<bean:message key="comprobarTermino.aceptar"/>" />
<input class="boton_125_de_2_izq"  type="submit" name="action" value="<bean:message key="comprobarTermino.volver"/>" />
<input class="boton_125"  type="submit" name="action" value="<bean:message key="comprobarTermino.cancelar"/>" />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->
</form>
</div>
<!-- Fin plantilla contenido  -->

    </tiles:put>

</tiles:insert>
