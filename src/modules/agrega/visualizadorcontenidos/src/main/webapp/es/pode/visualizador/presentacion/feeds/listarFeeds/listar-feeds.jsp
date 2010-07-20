<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="/WEB-INF/tags/rssutils.tld" prefix="rss" %>

<tiles:insert definition="layout-usuario">

<tiles:put name="title" type="string">
      <bean:message key="title.Comun"/>
</tiles:put>


<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>


<!--		Inicio plantilla contenido		-->

<div class="plantilla_contenido">


<!-- ## Para que los mensajes de error vayan bien en IE6 ## -->
<jsp:include page="/layout/messages.jsp" flush="true" />

<h2><bean:message key="feeds.agregador.titulo"/></h2>

<c:if test="${param.periodicidad=='no' }">

	<!--  INICIO GLOBO GRIS   -->
	<!--  INICIO GLOBO GRIS   -->

 	<rss:feed url="http://${param.fichero}_rss.xml" feedId="${param.fichero}"/>
	<div class="globo_gris" >
		<div class="globo_gris_01">
			<div class="globo_gris_02">
				<div class="globo_gris_03"> 
				<!--  INICIO CAJA DE FORMULARIO   -->
	
 				<div id="formulario" >
				
					<div class="caja_tabla bordeada" >
						<table border="1" class="administracion_tareas" cellpadding="0" cellspacing="0" width="100%" summary="Tabla de Lo Más Mostrado">
							<caption><strong><bean:message key='${param.titulo}'/></strong></caption>
							<tr>
								<th align="left" class="th_001"><bean:message key='${param.titulo}'/></th>
							</tr>
							<%int contItem=1; %>
							<fmt:formatNumber var="contIndicesItem" value="0" type="number"/>
							<rss:forEachItem feedId="${param.fichero}"> 
								<!--  impar   -->		
 								<c:if test="${contIndicesItem%2!=0}">
									<tr class="tr_gris">
										<td colspan="3" valign="top" align="left"  class="tar2"><span class="bld"><%=contItem %>.</span> &nbsp;<a href="<rss:itemLink feedId="${param.fichero}" />"><rss:itemTitle feedId="${param.fichero}" /></a></td>
									</tr>
								</c:if> 
								<!--  impar   -->		
 								<c:if test="${contIndicesItem%2==0}">
									<tr class="tr_blanco">
										<td colspan="3" valign="top" align="left"  class="tar2"><span class="bld"><%=contItem %>.</span> &nbsp;<a href="<rss:itemLink feedId="${param.fichero}" />"><rss:itemTitle feedId="${param.fichero}" /></a></td>
									</tr>
								</c:if>
								<%contItem=contItem+1; %>
								<c:set var="contIndicesItem" value="${contIndicesItem+1}"/>
							</rss:forEachItem>
	
						</table>
					</div>
				
				</div> 
							
				<!--  FIN CAJA DE FORMULARIO   -->
	
	
 				</div>
			</div>
		</div>
	</div> 
	<!--  FIN GLOBO GRIS   -->
	<!--  FIN GLOBO GRIS   -->		
</c:if>
	
	
	

<c:if test="${param.periodicidad=='si' }">

	<c:forEach var="repetir" begin="0" end="2">
	
		<!--  INICIO GLOBO GRIS   -->
		<!--  INICIO GLOBO GRIS   -->
		<c:if test="${repetir==0}">
			<rss:feed url="http://${param.fichero}_semana_rss.xml" feedId="${param.fichero}${repetir}"/>
			<c:set value="feeds.agregador.semana" scope="page" var="titulo"/>
		</c:if>
		<c:if test="${repetir==1}">
			<rss:feed url="http://${param.fichero}_mes_rss.xml" feedId="${param.fichero}${repetir}"/>
			<c:set value="feeds.agregador.mes" scope="page" var="titulo"/>
		</c:if>
		<c:if test="${repetir==2}">
			<rss:feed url="http://${param.fichero}_anio_rss.xml" feedId="${param.fichero}${repetir}"/>
			<c:set value="feeds.agregador.anio" scope="page" var="titulo"/>
		</c:if>
		<div class="globo_gris" >
			<div class="globo_gris_01">
				<div class="globo_gris_02">
					<div class="globo_gris_03">
					<!--  INICIO CAJA DE FORMULARIO   -->
		
					<div id="formulario" >
					
						<div class="caja_tabla bordeada" >
							<table border="1" class="administracion_tareas" cellpadding="0" cellspacing="0" width="100%" summary="Tabla de Lo Más Mostrado">
								<caption><strong><bean:message key='${param.titulo}'/></strong></caption>
								<tr>
									<th align="left" class="th_001"><bean:message key='${param.titulo}'/>&nbsp;<bean:message key='${titulo}'/></th>
								</tr>
								<%int cont=1; %>
								<fmt:formatNumber var="contIndices" value="0" type="number"/>
								<rss:forEachItem feedId="${param.fichero}${repetir}" startIndex="0" endIndex="10">
									<!--  impar   -->		
									<c:if test="${contIndices%2!=0}">
										<tr class="tr_gris">
											<td colspan="3" valign="top" align="left"  class="tar2"><span class="bld"><%=cont %>.</span> &nbsp;<a href="<rss:itemLink feedId="${param.fichero}${repetir}" />"><rss:itemTitle feedId="${param.fichero}${repetir}" /></a></td>
										</tr>
									</c:if>
									<!--  impar   -->		
									<c:if test="${contIndices%2==0}">
										<tr class="tr_blanco">
											<td colspan="3" valign="top" align="left"  class="tar2"><span class="bld"><%=cont %>.</span> &nbsp;<a href="<rss:itemLink feedId="${param.fichero}${repetir}" />"><rss:itemTitle feedId="${param.fichero}${repetir}" /></a></td>
										</tr>
									</c:if>
									<%cont=cont+1; %>
									<c:set var="contIndices" value="${contIndices+1}"/>
								</rss:forEachItem>
		
							</table>
						</div>
					
					</div>
								
					<!--  FIN CAJA DE FORMULARIO   -->
		
		
					</div>
				</div>
			</div>
		</div>
		<!--  FIN GLOBO GRIS   -->
		<!--  FIN GLOBO GRIS   -->	
		
		<br />
	
	</c:forEach>
</c:if>
	
	

<form action="<html:rewrite action="/AgregadorFeedsCU/AgregadorFeedsCU.do"/>" method="post">
	<fieldset class="tipo ft_centrada">
		<input class="boton_125"  type="submit"  value="<bean:message key='feeds.agregador.queEsEsto.volver'/>" />
	</fieldset>
</form>





</div>



<!--		Fin de la capa plantilla_contenido		-->


</tiles:put>


</tiles:insert>