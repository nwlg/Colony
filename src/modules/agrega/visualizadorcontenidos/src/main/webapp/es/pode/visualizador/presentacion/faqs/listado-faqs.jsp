<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<tiles:insert definition="layout-usuario">

	<tiles:put name="title" type="string">
		<bean:message key="title.Comun" />
	</tiles:put>
	<tiles:put name="body" type="string">

		<!--*************************        Inicio plantilla contenido      ********************************* -->
		<div class="plantilla_contenido">

		<h2><bean:message key="faqs.faqs.title" /></h2>
		<!-- Inicio  PESTANIAS de FICHA --> <!-- Inicio  PESTANIAS de FICHA -->

		<div id="ficha_pestanias">
		<ul class="alineado_izq">
		<!-- la primera es todas, la siguiente son las categorias -->
		<logic:iterate id="categoria" collection="${form.categorias}" indexId="indice">
			
			<c:if test="${indice==0}">
				<c:if test="${categoria.id==form.categoriaSeleccionada}">
					<li id="pest_activa"><a href="<rewrite:rewrite url="visualizadorcontenidos/Faqs/Faqs.do"/>" id="seleccionada">${categoria.nombre}</a></li>
				</c:if>
				<c:if test="${categoria.id!=form.categoriaSeleccionada}">
					<li><a href="<rewrite:rewrite url="visualizadorcontenidos/Faqs/Faqs.do"/>?categoriaSeleccionada=${categoria.id}">${categoria.nombre}</a></li>
				</c:if>
			 </c:if>
			 
			 <c:if test="${indice!=0}">
	 			<logic:iterate id="categoriaCat" collection="${categoria}" indexId="indiceCat">
	 				<c:if test="${form.categoriaSeleccionada==categoriaCat.id}">
						<li id="pest_activa"><a href="<rewrite:rewrite url="visualizadorcontenidos/Faqs/Faqs.do"/>?categoriaSeleccionada=${categoriaCat.id}"
						 id="seleccionada">${categoriaCat.nombre}</a></li>
					</c:if>
					<c:if test="${form.categoriaSeleccionada!=categoriaCat.id}">
						<li><a href="<rewrite:rewrite url="visualizadorcontenidos/Faqs/Faqs.do"/>?categoriaSeleccionada=${categoriaCat.id}">${categoriaCat.nombre}</a></li>
					</c:if>					
				</logic:iterate>
			</c:if>
		</logic:iterate>
			
		</ul>
		</div>
		<!-- Fin PESTANIAS de FICHA --> <!-- Fin PESTANIAS de FICHA --> 
		
		
		<!-- Inicio CONTENIDO PESTANIAS -->
<!-- Inicio CONTENIDO PESTANIAS -->
<div class="interno_ficha">

<div class="plantilla_contenido_pestanias">


		<!--***********************      Listado preguntas de faqs      ************************** -->
		<div class="caja_tabla"><bean:define id="summary">
			<bean:message key="faqs.faqs.TablaFaqs" />
		</bean:define> 
		<!-- length -->
		<c:if test="${fn:length(form.faqs) > 0}">
		  <display:table name="${form.faqs}"
			requestURI="" export="false"
			id="row" class="administracion_noticias" style="border:1;width:100%;"
			cellpadding="0" cellspacing="0" summary="${summary}">

			<display:caption>
				<strong> <bean:message key="faqs.faqs.TablaFaqs" /> </strong>
			</display:caption>

			<display:setProperty name="css.tr.odd" value="tr_gris" />
			<display:setProperty name="css.tr.even" value="tr_blanco" />
			<display:setProperty name="basic.show.header" value="false" />

			<display:column autolink="true" style="valign:top;" class="faqs_f">
				<a href="#anchor${row.id}">${row.pregunta}</a>
			</display:column>
		  </display:table>
		</c:if>
		<a></a></div>

		<!--*******************       Listado de faqs(pregunta y respuesta)      ****************** -->
		<ul id="lista_de_faqs">
		  <c:if test="${fn:length(form.faqs) > 0}">
			<logic:iterate id="elemento" collection="${form.faqs}">
				<li><a id="anchor${elemento.id }"></a> <strong>${elemento.pregunta}</strong><br />
				${elemento.respuesta }<br />
				<p><span><a href="#"><bean:message key="faqs.faqs.subir" /></a></span>
				</p>
				</li>
			</logic:iterate>
		  </c:if>
  		  <c:if test="${fn:length(form.faqs) == 0}">
  		   <li><p><bean:message key="faqs.noHay"/>	<br/></p></li>  		
  		  </c:if>

		</ul>
		</div>
		
	</div>
	</div>	
<!-- Fin CONTENIDO PESTANIAS -->
<!-- Fin CONTENIDO PESTANIAS -->
		<!-- ********************         Fin plantilla contenido        ******************************-->

	</tiles:put>
</tiles:insert>
