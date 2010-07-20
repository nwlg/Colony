<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://www.andromda.org/tags-breadcrumbs" prefix="breadcrumbs" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<tiles:insert definition="layout-sinlateral">
    <tiles:put name="title" type="string">
        <bean:message key="title.Comun"/>
    </tiles:put>
	<tiles:put name="body" type="string">
		<%@ include file="/layout/messages.jsp"%>
     <div class="plantilla_contenido">
			<h2>${form.tituloTesauro}</h2>
			
			<!--  INICIO CAJA DE FORMULARIO   -->
			<form method="post" action="<html:rewrite action="/NavegarTesauroCU/NavegarTesauroBuscarTerminos?tipoBusquedaArbol=${form.tipoBusquedaArbol}&tituloTesauro=${form.tituloTesauro}"/>">

				<div id="formulario" >
		
  				<div class="fila_de_tabla">
  					<div class="contenedor_izquierda"><label class="oculto" for="buscadorContenido02"><bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.buscador"/>:</label></div>
					<div class="contenedor_derecha2">
						<div class="text">
						<input name="textoBusqueda" onfocus="limpiarTexto(this)" value="${form.textoBusqueda}"  onblur="this.style.backgroundColor='#e1e1e1'" id="buscadorContenido02" type="text" title="<bean:message key="navegar.tesauro.introduzcaTextoBusqueda"/>"  />
						<br class="oculto" /><br class="oculto" />
						<input class="buscar boton_60" style="font-size: 130%; font-weight: normal;" type="submit" name="buscar" value="<bean:message key="listar.odecu.mostrar.resultados.consulta.cabecera.buscar"/>" />
						<br class="oculto" /></div>
					</div>
					<div class="linea_separadora"></div>
					<br class="oculto" />
				</div>
				<input type="hidden" name="tituloTesauro" value="${form.tituloTesauro}"/>
				<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
				</div>
			</form>
			<!--  FIN CAJA DE FORMULARIO   -->
			
			<div class="caja_tabla" >
				<p><bean:message key="navegar.tesauro.explicacion.taxonomia"/></p>
				<div class="breadcrumb_curricular">
				<form method="post" action="<html:rewrite action="/NavegarTesauroCU/NavegarTesauroListarODETesauro.do?tesauroBusqueda=${form.idTesauro}&tipoBusquedaArbol=${form.tipoBusquedaArbol}&tituloTesauro=${form.tituloTesauro}"/>" enctype="multipart/form-data">
					<input type="hidden" name="tipoLayoutBuscador" value="${form.tipoLayoutBuscador}"/>
					<html:link styleClass="br_carpeta_abierta" action="/NavegarTesauroCU/NavegarTesauroCU.do?tipoBusquedaArbol=${form.tipoBusquedaArbol}&tituloTesauro=${form.tituloTesauro}">
	        				<bean:message key="navegar.tesauro.nombre.inicio"/><br/>
			      	</html:link>
 					<c:if test="${!empty form.rutaPadreVO}">
						 <c:set var="longitud" value="${ fn:length(form.rutaPadreVO)}"/>
						 <fmt:formatNumber var="nombre" value="${longitud -1}" type="number"/>
						 <fmt:formatNumber var="nombre2" value="${longitud -2}" type="number"/>
						 
						 <c:if test="${longitud>1 }">
			 				<c:forEach items="${form.rutaPadreVO}" var="ruta" begin="0" end="${nombre2}">
		    					<em class="oculto">-</em>
					    		<html:link styleClass="br_carpeta_abierta" action="/NavegarTesauroCU/NavegarTesauroSeleccionarPadre.do?tipoBusquedaArbol=${form.tipoBusquedaArbol}&idTesauro=${ruta.id}&tituloTesauro=${form.tituloTesauro}">
        							<c:out value="${ruta.valorTax}"/><br/>
        						</html:link>
			    			</c:forEach>
						 </c:if> 
						 <c:forEach items="${form.rutaPadreVO}" var="ruta3" begin="${nombre}" end="${nombre}">
								 <em class="oculto">-</em>
								 <span class="br_carpeta_abierta">
				   				 	 <c:out value="${ruta3.valorTax}"/><br/>
							     </span>
							     <em>(<c:out value="${form.numeroResultados}"/>
									     <c:if test="${form.numeroResultados==1 }">
									     	<bean:message key="navegar.tesauro.objeto"/>
									     </c:if>
									      <c:if test="${form.numeroResultados!=1 }">
									      	<bean:message key="navegar.tesauro.objetos"/>
									     </c:if>)</em>
									     <c:if test="${form.numeroResultados>0 }">
								 			<input class="boton_60" type="submit"  value="<bean:message key="navegar.tesauro.ver"  />"/>
								 		</c:if>
						 </c:forEach>   
    				</c:if>	
    				</form>	  
				</div>
				
				<bean:define id="summary"><bean:message key="navegar.tesauro.tabla.taxones.resumen"/></bean:define>
					<display:table name="${form.taxonesVO}" id="taxonesvoact" 
						style="border:1;width:100%" class="generica" cellpadding="0" 
						cellspacing="0" 
						summary="${summary}"  requestURI="" sort="list" pagesize="20" partialList="False">
				
						<display:caption><strong> <bean:message key="areaCurricular.tabla.taxones.vo"/></strong></display:caption>
        				<display:setProperty name="css.tr.odd" value="tr_gris"/>
        				<display:setProperty name="css.tr.even" value="tr_blanco"/>
        				<display:setProperty name="basic.show.header" value="false"/>
        				<display:setProperty name="paging.banner.placement" value="bottom" />
        				<!-- definimos las columnas -->
        		
				        <c:choose>
		        			<c:when test="${taxonesvoact.esHoja}">
		        				<display:column class="new2" autolink="true" style="valign:top">
		        					<c:if test="${taxonesvoact.numeroOdesAsociados==0}">
		        						<!-- <span class="carpeta_cerrada"  style="display:inline"> -->
									    	 <strong><!--<c:out value="${taxonesvoact.nombre}"/>--><html:link styleClass="carpeta_cerrada" style="display:inline" action="/NavegarTesauroCU/NavegarTesauroListarODETesauro.do?tipoBusquedaArbol=${form.tipoBusquedaArbol}&numeroResultados=${taxonesvoact.numeroOdesAsociados}&idTesauro=${taxonesvoact.identificador}&nomTesauros=${taxonesvoact.nombre}&idioma=${form.idioma}&esRuta=${form.esRuta}&tituloTesauro=${form.tituloTesauro}">
				        					${taxonesvoact.nombre} 
				        				</html:link></strong>
									     <!-- </span> -->
		        					</c:if>
		        					<c:if test="${taxonesvoact.numeroOdesAsociados!=0}">
				            			<strong><html:link styleClass="carpeta_cerrada" style="display:inline" action="/NavegarTesauroCU/NavegarTesauroListarODETesauro.do?tipoBusquedaArbol=${form.tipoBusquedaArbol}&numeroResultados=${taxonesvoact.numeroOdesAsociados}&idTesauro=${taxonesvoact.identificador}&nomTesauros=${taxonesvoact.nombre}&idioma=${form.idioma}&esRuta=${form.esRuta}&tituloTesauro=${form.tituloTesauro}">
				        					${taxonesvoact.nombre} 
				        				</html:link></strong>
			        				</c:if>
		        					<em  style="display:inline;">(<c:out value="${taxonesvoact.numeroOdesAsociados}"/>
										     <c:if test="${taxonesvoact.numeroOdesAsociados==1 }">
										     	<bean:message key="navegar.tesauro.objeto"/>
										     </c:if>
										      <c:if test="${taxonesvoact.numeroOdesAsociados!=1 }">
										      	<bean:message key="navegar.tesauro.objetos"/>
										     </c:if>)</em>
	            				</display:column>	
			       			</c:when>
		        			<c:otherwise>
		        					<c:choose>
			        					<c:when test="${form.esRuta}">
			        						<display:column  class="new2" autolink="true" style="valign:top">
					        					<strong>
					        						<html:link styleClass="carpeta_cerrada" style="display:inline" action="/NavegarTesauroCU/NavegarTesauroSeleccionarHijo?tipoBusquedaArbol=${form.tipoBusquedaArbol}&numeroResultados=${taxonesvoact.numeroOdesAsociados}&idTesauro=${taxonesvoact.identificador}&nomTesauros=${taxonesvoact.nombre}&idioma=${form.idioma}&esRuta=${form.esRuta}&tituloTesauro=${form.tituloTesauro}">
						        						${taxonesvoact.nombre} 
							        				</html:link>
							        			</strong>
										    </display:column>
										</c:when>
			        					<c:otherwise>
			        						<display:column  class="new2" autolink="true" style="valign:top">
				        						<c:if test="${taxonesvoact.numeroOdesAsociados==0}">
				        							<!-- <span class="carpeta_cerrada"  style="display:inline"> -->
											    		<strong><!--<c:out value="${taxonesvoact.nombre}"/>--><html:link styleClass="carpeta_cerrada" style="display:inline" action="/NavegarTesauroCU/NavegarTesauroSeleccionarHijo?tipoBusquedaArbol=${form.tipoBusquedaArbol}&numeroResultados=${taxonesvoact.numeroOdesAsociados}&idTesauro=${taxonesvoact.identificador}&nomTesauros=${taxonesvoact.nombre}&idioma=${form.idioma}&esRuta=${form.esRuta}&tituloTesauro=${form.tituloTesauro}">
						        					${taxonesvoact.nombre} 
							        				</html:link></strong>
											     	<!-- </span> -->
				        						</c:if>
				        						<c:if test="${taxonesvoact.numeroOdesAsociados!=0}">
					        						<strong><html:link styleClass="carpeta_cerrada" style="display:inline" action="/NavegarTesauroCU/NavegarTesauroSeleccionarHijo?tipoBusquedaArbol=${form.tipoBusquedaArbol}&numeroResultados=${taxonesvoact.numeroOdesAsociados}&idTesauro=${taxonesvoact.identificador}&nomTesauros=${taxonesvoact.nombre}&idioma=${form.idioma}&esRuta=${form.esRuta}&tituloTesauro=${form.tituloTesauro}">
						        					${taxonesvoact.nombre} 
							        				</html:link></strong>
					        					</c:if>
					        					  
					        					<em  style="display:inline;">(<c:out value="${taxonesvoact.numeroOdesAsociados}"/>
												     <c:if test="${taxonesvoact.numeroOdesAsociados==1 }">
												     	<bean:message key="navegar.tesauro.objeto"/>
												     </c:if>
												      <c:if test="${taxonesvoact.numeroOdesAsociados!=1 }">
												      	<bean:message key="navegar.tesauro.objetos"/>
												     </c:if>)</em>
											</display:column>
			        					</c:otherwise>
			        				</c:choose>
		        			</c:otherwise>
		    			</c:choose>		        
					</display:table>
									
			</div>
			
		</div>
		<form action="<html:rewrite action="/SeleccionTipoBusquedaCU/SeleccionTipoBusquedaCU.do"/>" method="post">
			<fieldset class="tipo ft_centrada">
				<input class="boton_125" type="submit" value="<bean:message key="navegar.tesauro.volver"/>"/>
			</fieldset>
		</form>
   	</tiles:put>
</tiles:insert>
