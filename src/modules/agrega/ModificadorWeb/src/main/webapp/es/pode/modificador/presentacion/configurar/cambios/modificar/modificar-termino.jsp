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

<h2><bean:message key="modificarTermino.titulo"/></h2>
<form id="modificarTerminoModificarTerminoSelectActionForm" action="<html:rewrite action="/ModificarTermino/ModificarTerminoSelectAction"/>"  method="post">
<p class="parrafo_comun" id="separacion2"><bean:message key="modificarTermino.esNecesarioRellenarCompletar"/>.</p>

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
  						<div class="text"><label for="valor"><bean:message key="modificarTermino.valor"/>:</label></div>
 					</div>
					<div class="contenedor_derecha">
						<div class="text"><input name="valorViejo"value="${form.valorViejo}"  onblur="this.style.backgroundColor='#e1e1e1'" id="valor" type="text" title="Introduzca Valor"  /></div>
					</div>

					<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>
				<!-- -->
				<div class="fila_de_tabla" >
  					<div class="contenedor_izquierda">
  						<div class="text"><label for="nuevo_valor"><bean:message key="modificarTermino.nuevoValor"/>:</label></div>
 					</div>

					<div class="contenedor_derecha">
					<c:if test="${form.formulario.esCombo == false}" >		
						<div class="text"><input name="valorNuevo" value="${form.valorNuevo}"  onblur="this.style.backgroundColor='#e1e1e1'" id="valorNuevo" type="text" title="Introduzca Nuevo Valor"  /></div>
					</c:if>
					<c:if test="${form.formulario.esCombo == true}" >	
						<html:select name="form" property="valorNuevo" title="" styleId="nuevo_valor">
								<html:optionsCollection name="form"  property="valorNuevoBackingList" label="label" value="value"/>
						</html:select>	 			
					</c:if>
					</div>
					<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>
				<!-- -->
				<!-- -->
				<div class="fila_de_tabla">

  					<div class="contenedor_izquierda">
  						<div class="text"><label for="expRegular_si"><bean:message key="modificarTermino.expresionRegular"/>:</label></div>
 					</div>
					<div class="contenedor_derecha">
						<div class="text">
						    <html:radio styleClass="boton_radio" styleId="exprReg" name="form" property="exprReg" value="true" />
							<span class="vert"><bean:message key="modificarTermino.si"/></span>
						</div>
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
							<span class="vert"><bean:message key="modificarTermino.no"/></span>
						</div>
					</div>

					<div class="linea_separadora"></div>
				</div>
				<!-- -->
				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda">
  						<div class="text"><label for="Idioma"><bean:message key="modificarTermino.idioma"/>:</label></div>
 					</div>
					<div class="contenedor_derecha">
					<c:if test="${form.formulario.langString == true}" >	
					
						<div class="text"><input name="idioma" value=""  onblur="this.style.backgroundColor='#e1e1e1'" id="Idioma" type="text" title="Introduzca Idioma"  /></div>
					</c:if>
					
					<c:if test="${form.formulario.langString == false}" >	
						<div class="text"><input name="idioma" disabled="true" onfocus="limpiarTexto(this)" value=""  onblur="this.style.backgroundColor='#e1e1e1'" id="Idioma" type="text" title="Introduzca Idioma"  /></div>
					</c:if>
					</div>
					<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>	
				<!-- -->				
				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda">
  						<div class="text"><label for="alcMeta01"><bean:message key="modificarTermino.alcanceMetadatos"/>:</label></div>

 					</div>
					<div class="contenedor_derecha">
						<div class="text">
						<html:radio styleClass="boton_radio" styleId="alcanceMetadatos" name="form" property="alcanceMetadatos" value="true" />
						<span class="vert"><bean:message key="modificarTermino.soloCatalogPpal"/></span></div>
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
						<html:radio styleClass="boton_radio" styleId="alcanceMetadatos" name="form" property="alcanceMetadatos" value="false" />
						<span class="vert"><bean:message key="modificarTermino.todosMetadatos"/></span></div>
					</div>
					<div class="linea_separadora"></div>
				</div>

				<!-- -->				
				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda">
  						<div class="text"><label for="alcTerminos01"><bean:message key="modificarTermino.alcanceTerminos"/>:</label></div>
 					</div>
					<div class="contenedor_derecha">
						<div class="text"><html:radio styleClass="boton_radio" styleId="alcanceTermino" name="form" property="alcanceTermino" value="false" />
						<span class="vert"><bean:message key="modificarTermino.primerTerminoEncontrado"/></span></div>
					</div>

					<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>	
				<!-- -->
				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda">
  						<div class="text"><label for="alcTerminos02">&nbsp;</label></div>
 					</div>
					<div class="contenedor_derecha">

						<div class="text"><html:radio styleClass="boton_radio" styleId="alcanceTermino" name="form" property="alcanceTermino" value="true" /><span class="vert"><bean:message key="modificarTermino.todoTerminoEncontrado"/></span></div>
					</div>
					<div class="linea_separadora"></div>
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
<input class="boton_125_de_2"  type="submit" name="action" value="<bean:message key="modificarTermino.aceptar"/>" />
<input class="boton_125_de_2_izq"  type="submit" name="action" value="<bean:message key="modificarTermino.volver"/>" />
<input class="boton_125"  type="submit" name="action" value="<bean:message key="modificarTermino.cancelar"/>" />
</fieldset>
<!-- Fin Botones  -->
<!-- Fin Botones  -->

</form>
</div>
<!-- Fin plantilla contenido  -->
    </tiles:put>

</tiles:insert>
