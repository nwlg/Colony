<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="/WEB-INF/tags/valoracion.tld" prefix="estrellas" %>
<%@ taglib uri="/WEB-INF/tags/serverProperties.tld" prefix="server" %>
<%@ taglib uri="/WEB-INF/tags/checkboxTag.tld" prefix="chk" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<tiles:insert definition="layout-sinlateralYsinbuscadorSuperior">
    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>

    <tiles:put name="body" type="string">
		<%@ include file="/taglib-imports.jspf" %>
		<!-- Inicio plantilla contenido  -->
		<div class="plantilla_contenido">
			<jsp:include page="/layout/messages.jsp" flush="true" />
			<div class="resultados_b">
				<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.desdeHasta" arg0="${form.resultadosDesde}" arg1="${form.resultadosHasta}" arg2="${form.numMaxRes}"/>
			</div>
			<h2><bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.resultadoBusqueda"/></h2>			
			
<!-- Inicio plantilla contenido  -->
<div class="plantilla_contenido">

<!-- Inicio caja buscador -->
<!-- Inicio caja buscador -->
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">

			<!--  INICIO CAJA DE FORMULARIO   -->
								<div id="formulario" >
								<form method="post" action="<html:rewrite action="/BuscarAvanzadoCU/MostrarResultadosAvanzadoBuscarResultados.do"/>">
										
					  				<div class="fila_de_tabla">
					  					<div class="contenedor_izquierda_00">
											&nbsp;<label class="oculto" for="buscadorContenido"><bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.buscador"/>:</label>
										</div>
										<div class="contenedor_derecha_00">
											<div class="text"><input name="buscadorContenido" value="${form.buscadorContenido}"  onblur="this.style.backgroundColor='#e1e1e1'" id="buscadorContenido" type="text" title="Introduzca Búsqueda "  /><br class="oculto" />
												<label class="oculto" for="idiomaBuscadorContenido">
													<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.elijaIdioma"/>:
												</label>
												<bean:define id="tituloSeleccioneTipoIdioma"><bean:message key="configurar.avanzado.atributo.seleccionar.tipoIdioma"/></bean:define>
												<html:select name="form" property="idiomaBuscador" styleId="idiomaBuscadorContenido" title="${tituloSeleccioneTipoIdioma}">
													<html:optionsCollection name="form"  property="idiomaBuscadorBackingList" label="label" value="value"/>
												</html:select>
												<br class="oculto" /><input type="submit" alt="<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.botonBuscar"/>"  class="buscar"  value="<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.buscar"/>" name="buscar" /><br class="oculto" />
												<a href="/buscador/BuscarAvanzadoCU/MostrarResultadosAvanzadoMostrarAvanzadoResultados.do?buscadorContenido=${form.buscadorContenidoEnlace}&amp;idioma=${form.idioma}&amp;pagina=${form.anterior}&amp;formato=${form.formato}&amp;recurso=${form.recurso}&amp;procesoCognitivo=${form.procesoCognitivo}&amp;contexto=${form.contexto}&amp;edad=${form.edad}&amp;autor=${form.autor}&amp;diaPublicacion=${form.diaPublicacion}&amp;mesPublicacion=${form.mesPublicacion}&amp;anyoPublicacion=${form.anyoPublicacion}&amp;c_s_secuencia=${form.c_s_secuencia}&amp;valoracion=${form.valoracion}&amp;areaCurricular=${form.areaCurricular}&amp;enlaceComunidadesSeleccionadas=${form.enlaceComunidadesSeleccionadas}&amp;enlaceTodoAgrega=${form.enlaceTodoAgrega}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;idTesauro=${form.idTesauro}&amp;nomTesauros=${form.nomTesauros}&amp;tipoBusqueda=${form.tipoBusqueda}&amp;nivelAgregacion=${form.nivelAgregacion}" class="avanzado"><bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.avanzado"/></a>
												<input type="hidden" name="enlaceTodoAgrega" value="${form.enlaceTodoAgrega}"/>
												<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
												<input type="hidden" name="busquedaSimpleAvanzada" value="${form.busquedaSimpleAvanzada}"/>
												<input type="hidden" name="keyword" value="${form.keyword}"/>
												<logic:equal name="form" property="tipoBusqueda" value="03">
													<input type="hidden" name="formato" value="${form.formato}"/>
													<input type="hidden" name="recurso" value="${form.recurso}"/>
													<input type="hidden" name="procesoCognitivo" value="${form.procesoCognitivo}"/>
													<input type="hidden" name="contexto" value="${form.contexto}"/>
													<input type="hidden" name="edad" value="${form.edad}"/>
													<input type="hidden" name="autor" value="${form.autor}"/>
													<input type="hidden" name="diaPublicacion" value="${form.diaPublicacion}"/>
													<input type="hidden" name="mesPublicacion" value="${form.mesPublicacion}"/>
													<input type="hidden" name="anyoPublicacion" value="${form.anyoPublicacion}"/>
													<input type="hidden" name="c_s_secuencia" value="${form.c_s_secuencia}"/>
													<input type="hidden" name="valoracion" value="${form.valoracion}"/>
													<input type="hidden" name="nivelAgregacion" value="${form.nivelAgregacion}"/>
													<input type="hidden" name="areaCurricular" value="${form.areaCurricular}"/>
													<input type="hidden" name="idTesauro" value="${form.idTesauro}"/>
													<input type="hidden" name="nomTesauros" value="${form.nomTesauros}"/>
													<input type="hidden" name="enlaceComunidadesSeleccionadas" value="${form.enlaceComunidadesSeleccionadas}"/>	
												</logic:equal>
											</div>
											
										</div>
										<div class="linea_separadora"></div>
										<br class="oculto" />
									</div>
									<div class="fila_de_tabla">
					  					<div class="contenedor_izquierda_00">
											&nbsp;<label class="oculto" for="todosNodos"><bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.nodos"/>:</label>
										</div>										
										<div class="contenedor_derecha_00">
   										 <div class="text">
   										 	<span class="vert">
   										 		<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.buscarEn"/>
   										 	</span>
            								<html:radio property="tipoBusqueda" styleClass="boton_radio" styleId="todosNodos" name="form" value="01" />
           									 <span class="vert">
                  								<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.nodosTodos"/>
            								 </span>
            								<html:radio property="tipoBusqueda" styleClass="boton_radio marginadito" styleId="todosNodos" name="form" value="02" />
                 							 <span class="vert">
                        						<server:serverProperties property="ccaa"/>&nbsp;&nbsp;
                  							 </span>
                  							 <logic:equal name="form" property="tipoBusqueda" value="03">
	                  							 <html:radio property="tipoBusqueda" styleClass="boton_radio" styleId="Personalizada" name="form" value="03" />
	                  							 <span class="vert">
													<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.personalizada"/>
												 </span>
											 </logic:equal>
      									 </div>
										</div>											
										<div class="linea_separadora"></div>
										<br class="oculto" />
									</div>
									</form>
								</div>
								<!--  FIN CAJA DE FORMULARIO   -->
			</div>
		</div>
	</div>
</div>
<!--  FIN GLOBO GRIS   -->
<!--  FIN GLOBO GRIS   -->
<!-- Fin caja buscador -->
<!-- Fin caja buscador -->
<br />

<!-- Inicio  PESTANIAS de FICHA -->
<!-- Inicio  PESTANIAS de FICHA -->
<div id="ficha_pestanias">
	<ul>
		<li id="pest_activa"><a href="#" id="seleccionada"><bean:message key="listar.odecu.mostrar.resultados.listado"/></a></li>
		<li><a href="/buscador/BuscarAvanzadoCU/MostrarResultadosImagenesBuscarResultadosImagenes.do?buscadorContenido=${form.buscadorContenidoEnlace}&amp;idioma=${form.idioma}&amp;formato=${form.formato}&amp;recurso=${form.recurso}&amp;procesoCognitivo=${form.procesoCognitivo}&amp;contexto=${form.contexto}&amp;edad=${form.edad}&amp;autor=${form.autor}&amp;diaPublicacion=${form.diaPublicacion}&amp;mesPublicacion=${form.mesPublicacion}&amp;anyoPublicacion=${form.anyoPublicacion}&amp;c_s_secuencia=${form.c_s_secuencia}&amp;valoracion=${form.valoracion}&amp;areaCurricular=${form.areaCurricular}&amp;enlaceComunidadesSeleccionadas=${form.enlaceComunidadesSeleccionadas}&amp;enlaceTodoAgrega=${form.enlaceTodoAgrega}&amp;tipoBusqueda=${form.tipoBusqueda}&amp;idTesauro=${form.idTesauro}&amp;nomTesauros=${form.nomTesauros}&amp;nivelAgregacion=${form.nivelAgregacion}"><bean:message key="listar.odecu.mostrar.resultados.suscribirse"/></a></li>
	</ul>
</div>
<!-- Fin PESTANIAS de FICHA -->
<!-- Fin PESTANIAS de FICHA -->

<!-- Inicio CONTENIDO PESTANIAS -->
<!-- Inicio CONTENIDO PESTANIAS -->
<form method="post" action="<html:rewrite action="/BuscarAvanzadoCU/MostrarResultadosAvanzadoEliminarODE.do"/>">
	<div class="interno_ficha">
		<!-- CAJA TABLA -->
		<!-- CAJA TABLA -->
		<div class="plantilla_contenido_pestanias" id="nueva_cap_int">
			<!-- Inicio Resultados de Búsqueda -->
			<!-- Inicio Resultados de Búsqueda -->
			<div class="caja_tabla" id="marg_resultados_lis" style="margin-top:2px;"> 
				<bean:define id="summary"><b><bean:message key="listar.odecu.mostrar.resultados.consulta.tablaResultadosBusqueda"/></b></bean:define>
				<bean:define id="tituloTitulo"><b><bean:message key="listar.odecu.mostrar.resultados.consulta.vo.titulo"/></b></bean:define>
				<bean:define id="tituloAreaCurricular"><b><bean:message key="listar.odecu.mostrar.resultados.consulta.vo.area.curricular"/></b></bean:define>
				<bean:define id="tituloCurso"><b><bean:message key="listar.odecu.mostrar.resultados.consulta.vo.curso"/></b></bean:define>
				<bean:define id="tituloTipoRecurso"><b><bean:message key="listar.odecu.mostrar.resultados.consulta.vo.tipo.recurso"/></b></bean:define>
				<bean:define id="tituloValracion"><b><bean:message key="listar.odecu.mostrar.resultados.consulta.vo.valoracion"/></b></bean:define>
				<display:table name="${form.resultadosVO}" 
			        requestURI="${pageContext.request.requestURL}"
			        class="resultados_listados"
			        export="false" uid="fila"
			        cellpadding="0" cellspacing="0"
			        summary="${summary }" 
			        id="resultado">
	      
			        <display:caption><strong><bean:message key="listar.odecu.mostrar.resultados.consulta.tablaResultadosBusqueda"/></strong></display:caption>
			        <display:setProperty name="css.tr.odd" value="tr_blanco"/>
			        <display:setProperty name="css.tr.even" value="tr_gris"/>  		        		        
			        
			        <display:column>  	
	             		<chk:checkbox name="idRowSelectionAsArray" identificadorODE="${resultado.id}" url="/buscador/BuscarAvanzadoCU/MostrarResultadosAvanzadoPrepararRetornoDetalle.do?idioma=${form.idioma}&amp;buscadorContenido=${form.buscadorContenido}&amp;pagina=${form.pagina}&amp;formato=${form.formato}&amp;recurso=${form.recurso}&amp;procesoCognitivo=${form.procesoCognitivo}&amp;contexto=${form.contexto}&amp;edad=${form.edad}&amp;autor=${form.autor}&amp;diaPublicacion=${form.diaPublicacion}&amp;mesPublicacion=${form.mesPublicacion}&amp;anyoPublicacion=${form.anyoPublicacion}&amp;c_s_secuencia=${form.c_s_secuencia}&amp;valoracion=${form.valoracion}&amp;areaCurricular=${form.areaCurricular}&amp;identificadorODE=${resultado.id}&amp;nodoDestino=${resultado.nodo}&amp;enlaceComunidadesSeleccionadas=${form.enlaceComunidadesSeleccionadas}&amp;enlaceTodoAgrega=${form.enlaceTodoAgrega}&amp;idTesauro=${form.idTesauro}&amp;nomTesauros=${form.nomTesauros}&amp;tipoBusqueda=${form.tipoBusqueda}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;nivelAgregacion=${form.nivelAgregacion}" titulo="${resultado.titulo}" administrador="${form.usuarioAdministrador}" numeroODE="${resultado.numeroODE}" nodoODE="${resultado.nodo}"/>	
	      			</display:column> 
	      			
	      			<display:column
			            title="${tituloTitulo}"
			            headerClass="max_tab alinea_a_izq2"
			            class="alinea_a_izq">				            
			        	<a href="/buscador/BuscarAvanzadoCU/MostrarResultadosAvanzadoPrepararRetornoDetalle.do?idioma=${form.idioma}&buscadorContenido=${form.buscadorContenidoEnlace}&pagina=${form.pagina}&formato=${form.formato}&recurso=${form.recurso}&procesoCognitivo=${form.procesoCognitivo}&contexto=${form.contexto}&edad=${form.edad}&autor=${form.autor}&diaPublicacion=${form.diaPublicacion}&mesPublicacion=${form.mesPublicacion}&anyoPublicacion=${form.anyoPublicacion}&c_s_secuencia=${form.c_s_secuencia}&valoracion=${form.valoracion}&areaCurricular=${form.areaCurricular}&identificadorODE=${resultado.id}&nodoDestino=${resultado.nodo}&enlaceComunidadesSeleccionadas=${form.enlaceComunidadesSeleccionadas}&enlaceTodoAgrega=${form.enlaceTodoAgrega}&tipoBusqueda=${form.tipoBusqueda}&tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;idTesauro=${form.idTesauro}&amp;nomTesauros=${form.nomTesauros}&amp;nivelAgregacion=${form.nivelAgregacion}&amp;tipoVisualizacion=SIN_IMAGENES">${resultado.titulo}</a>
		        	</display:column>
			        <display:column
			        	headerClass="max_tab alinea_a_izq2"
			        	class="alinea_a_izq"
			            paramId="titulo"
			            property="areaCurricular"
			            title="${tituloAreaCurricular}" 
			            decorator="es.pode.buscador.presentacion.basico.listar.ListarAreaCurricularColumDecorator">
			        </display:column>
			     
			        <display:column
			            paramId="tipoRecurso"
			            property="tipoRecurso"
			            class="mas_info" 
			            title="${tituloTipoRecurso}"
			            decorator="es.pode.buscador.presentacion.basico.listar.ListarTipoRecursoColumDecorator">		            
			        </display:column>
			        
			        <display:column title="${tituloValracion}">	            				
	          			<estrellas:valoracion valoracion="${resultado.valoracion}" pagina="resultados" mensaje="vide" />	            				
	      			</display:column>   
				</display:table>	        
			</div>
		<!-- Fin Resultados de Búsqueda -->
		<!-- Fin Resultados de Búsqueda -->
		<!-- Paginacion -->
			<hr />
				<div class="paginacion">
					<ul id="navlist">								
						<logic:notEmpty name="form" property="anterior">									
							<li><a href="/buscador/BuscarAvanzadoCU/MostrarResultadosAvanzadoPaginar.do?buscadorContenido=${form.buscadorContenidoEnlace}&amp;idioma=${form.idioma}&amp;pagina=${form.anterior}&amp;formato=${form.formato}&amp;recurso=${form.recurso}&amp;procesoCognitivo=${form.procesoCognitivo}&amp;contexto=${form.contexto}&amp;edad=${form.edad}&amp;autor=${form.autor}&amp;diaPublicacion=${form.diaPublicacion}&amp;mesPublicacion=${form.mesPublicacion}&amp;anyoPublicacion=${form.anyoPublicacion}&amp;c_s_secuencia=${form.c_s_secuencia}&amp;valoracion=${form.valoracion}&amp;areaCurricular=${form.areaCurricular}&amp;enlaceComunidadesSeleccionadas=${form.enlaceComunidadesSeleccionadas}&amp;enlaceTodoAgrega=${form.enlaceTodoAgrega}&amp;tipoBusqueda=${form.tipoBusqueda}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;idTesauro=${form.idTesauro}&amp;nomTesauros=${form.nomTesauros}&amp;nivelAgregacion=${form.nivelAgregacion}&amp;tipoVisualizacion=SIN_IMAGENES"><bean:message key="listarODE.arbolCurricular.anterior"/></a></li>
						</logic:notEmpty>
			
						<logic:iterate name="form" property="paginas" id="pagina">									
							<logic:equal name="form" property="pagina" value="${pagina}">
								<li>${pagina}</li>
							</logic:equal>
							<logic:notEqual name="form" property="pagina" value="${pagina}">
								<li><a href="/buscador/BuscarAvanzadoCU/MostrarResultadosAvanzadoPaginar.do?buscadorContenido=${form.buscadorContenidoEnlace}&amp;idioma=${form.idioma}&amp;pagina=${pagina}&amp;formato=${form.formato}&amp;recurso=${form.recurso}&amp;procesoCognitivo=${form.procesoCognitivo}&amp;contexto=${form.contexto}&amp;edad=${form.edad}&amp;autor=${form.autor}&amp;diaPublicacion=${form.diaPublicacion}&amp;mesPublicacion=${form.mesPublicacion}&amp;anyoPublicacion=${form.anyoPublicacion}&amp;c_s_secuencia=${form.c_s_secuencia}&amp;valoracion=${form.valoracion}&amp;areaCurricular=${form.areaCurricular}&amp;enlaceComunidadesSeleccionadas=${form.enlaceComunidadesSeleccionadas}&amp;enlaceTodoAgrega=${form.enlaceTodoAgrega}&amp;tipoBusqueda=${form.tipoBusqueda}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;idTesauro=${form.idTesauro}&amp;nomTesauros=${form.nomTesauros}&amp;nivelAgregacion=${form.nivelAgregacion}&amp;tipoVisualizacion=SIN_IMAGENES">${pagina}</a></li>
							</logic:notEqual>
						</logic:iterate>
			
						<logic:notEmpty name="form" property="siguiente">
							<li><a href="/buscador/BuscarAvanzadoCU/MostrarResultadosAvanzadoPaginar.do?buscadorContenido=${form.buscadorContenidoEnlace}&amp;idioma=${form.idioma}&amp;pagina=${form.siguiente}&amp;formato=${form.formato}&amp;recurso=${form.recurso}&amp;procesoCognitivo=${form.procesoCognitivo}&amp;contexto=${form.contexto}&amp;edad=${form.edad}&amp;autor=${form.autor}&amp;diaPublicacion=${form.diaPublicacion}&amp;mesPublicacion=${form.mesPublicacion}&amp;anyoPublicacion=${form.anyoPublicacion}&amp;c_s_secuencia=${form.c_s_secuencia}&amp;valoracion=${form.valoracion}&amp;areaCurricular=${form.areaCurricular}&amp;enlaceComunidadesSeleccionadas=${form.enlaceComunidadesSeleccionadas}&amp;enlaceTodoAgrega=${form.enlaceTodoAgrega}&amp;tipoBusqueda=${form.tipoBusqueda}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;idTesauro=${form.idTesauro}&amp;nomTesauros=${form.nomTesauros}&amp;nivelAgregacion=${form.nivelAgregacion}&amp;tipoVisualizacion=SIN_IMAGENES"><bean:message key="listarODE.arbolCurricular.siguiente"/></a></li>
						</logic:notEmpty>
					</ul>
				</div>
		</div>
	</div>
<!-- Fin CONTENIDO PESTANIAS -->
<!-- Fin CONTENIDO PESTANIAS -->

	<!-- Inicio Botones  -->
	<!-- Inicio Botones  -->
	<logic:equal name="form" property="usuarioAdministrador" value="true">
		<fieldset class="tipo ft_centrada">
			<input type="hidden" name="idioma" value="${form.idioma}"/>
			<input type="hidden" name="buscadorContenido" value="${form.buscadorContenido}"/>
			<input type="hidden" name="formato" value="${form.formato}"/>
			<input type="hidden" name="recurso" value="${form.recurso}"/>
			<input type="hidden" name="procesoCognitivo" value="${form.procesoCognitivo}"/>
			<input type="hidden" name="contexto" value="${form.contexto}"/>
			<input type="hidden" name="edad" value="${form.edad}"/>
			<input type="hidden" name="autor" value="${form.autor}"/>
			<input type="hidden" name="diaPublicacion" value="${form.diaPublicacion}"/>
			<input type="hidden" name="mesPublicacion" value="${form.mesPublicacion}"/>
			<input type="hidden" name="anyoPublicacion" value="${form.anyoPublicacion}"/>
			<input type="hidden" name="c_s_secuencia" value="${form.c_s_secuencia}"/>
			<input type="hidden" name="valoracion" value="${form.valoracion}"/>
			<input type="hidden" name="nivelAgregacion" value="${form.nivelAgregacion}"/>
			<input type="hidden" name="areaCurricular" value="${form.areaCurricular}"/>
			<input type="hidden" name="idTesauro" value="${form.idTesauro}"/>
			<input type="hidden" name="nomTesauros" value="${form.nomTesauros}"/>
			<input type="hidden" name="enlaceComunidadesSeleccionadas" value="${form.enlaceComunidadesSeleccionadas}"/>	
			<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>	
			
			<input class="boton_125"  type="submit"  value="<bean:message key="listar.odecu.mostrar.resultados.consulta.eliminar"/>" />
		</fieldset>
	</logic:equal>
</form>
	<!-- Fin Botones  -->
	<!-- Fin Botones  -->
<br />
<!-- Inicio caja buscador -->
<!-- Inicio caja buscador -->
<!--  INICIO GLOBO GRIS   -->
<!--  INICIO GLOBO GRIS   -->
<div class="globo_gris" >
	<div class="globo_gris_01">
		<div class="globo_gris_02">
			<div class="globo_gris_03">
			<!--  INICIO CAJA DE FORMULARIO   -->
			<div id="formulario_02" >
  				<div class="fila_de_tabla">
  					<form method="post" action="<html:rewrite action="/BuscarAvanzadoCU/MostrarResultadosAvanzadoBuscarResultados.do"/>">
	  					<div class="contenedor_izquierda_00">
	  						<div class="text">
	  							<label class="oculto" for="buscadorContenidoSolo"><bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.buscador"/>:</label>
	  						</div>
						</div>
						<div class="contenedor_derecha_00" >
							<div class="text"><input name="buscadorContenidoSolo" value="${form.buscadorContenido}"  onblur="this.style.backgroundColor='#e1e1e1'" id="buscadorContenidoSolo" type="text" title="<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.descripcionTextoBusqueda"/>"  /><br class="oculto" />
								<input type="hidden" name="idioma" value="${form.idioma}"/>
								<input type="hidden" name="enlaceTodoAgrega" value="${form.enlaceTodoAgrega}"/>
								<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
								<input type="hidden" name="busquedaSimpleAvanzada" value="${form.busquedaSimpleAvanzada}"/>
								<logic:equal name="form" property="tipoBusqueda" value="03">
									<input type="hidden" name="formato" value="${form.formato}"/>
									<input type="hidden" name="recurso" value="${form.recurso}"/>
									<input type="hidden" name="procesoCognitivo" value="${form.procesoCognitivo}"/>
									<input type="hidden" name="contexto" value="${form.contexto}"/>
									<input type="hidden" name="edad" value="${form.edad}"/>
									<input type="hidden" name="autor" value="${form.autor}"/>
									<input type="hidden" name="diaPublicacion" value="${form.diaPublicacion}"/>
									<input type="hidden" name="mesPublicacion" value="${form.mesPublicacion}"/>
									<input type="hidden" name="anyoPublicacion" value="${form.anyoPublicacion}"/>
									<input type="hidden" name="c_s_secuencia" value="${form.c_s_secuencia}"/>
									<input type="hidden" name="valoracion" value="${form.valoracion}"/>
									<input type="hidden" name="nivelAgregacion" value="${form.nivelAgregacion}"/>
									<input type="hidden" name="areaCurricular" value="${form.areaCurricular}"/>
									<input type="hidden" name="idTesauro" value="${form.idTesauro}"/>
									<input type="hidden" name="nomTesauros" value="${form.nomTesauros}"/>
									<input type="hidden" name="enlaceComunidadesSeleccionadas" value="${form.enlaceComunidadesSeleccionadas}"/>	
								</logic:equal>
								<input type="submit" alt="<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.botonBuscar"/>"  class="buscar"  value="<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.buscar"/>" name="buscar2" /><br class="oculto" />
								<a href="/buscador/BuscarAvanzadoCU/MostrarResultadosAvanzadoMostrarAvanzadoResultados.do?buscadorContenido=${form.buscadorContenidoEnlace}&amp;idioma=${form.idioma}&amp;pagina=${form.anterior}&amp;formato=${form.formato}&amp;recurso=${form.recurso}&amp;procesoCognitivo=${form.procesoCognitivo}&amp;contexto=${form.contexto}&amp;edad=${form.edad}&amp;autor=${form.autor}&amp;diaPublicacion=${form.diaPublicacion}&amp;mesPublicacion=${form.mesPublicacion}&amp;anyoPublicacion=${form.anyoPublicacion}&amp;c_s_secuencia=${form.c_s_secuencia}&amp;valoracion=${form.valoracion}&amp;areaCurricular=${form.areaCurricular}&amp;tipoLayoutBuscador=${form.tipoLayoutBuscador}&amp;enlaceComunidadesSeleccionadas=${form.enlaceComunidadesSeleccionadas}&amp;tipoBusqueda=${form.tipoBusqueda}&amp;idTesauro=${form.idTesauro}&amp;nomTesauros=${form.nomTesauros}&amp;nivelAgregacion=${form.nivelAgregacion}" class="avanzado"><bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.avanzado"/></a>
							</div>
						</div>
					</form>
					<div class="linea_separadora"></div>
					<br />
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
<!-- Fin caja buscador -->
<!-- Fin caja buscador -->
</div>
<!-- Fin plantilla contenido  -->
<!-- Fin plantilla contenido  -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->
<!-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX -->



    </tiles:put>

</tiles:insert>
