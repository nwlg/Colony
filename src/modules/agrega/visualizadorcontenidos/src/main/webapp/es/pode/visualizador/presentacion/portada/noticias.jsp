<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://jsptags.com/tags/navigation/pager" prefix="pg" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="/WEB-INF/tags/cabeceraTag.tld" prefix="cabecera" %>

<tiles:insert definition="layout-portada">
<tiles:put name="title" type="string">
	<bean:message key="title.Comun"/>
</tiles:put>

<tiles:put name="body" type="string">

<%@ include file="/taglib-imports.jspf" %>
<%@ include file="/es/pode/visualizador/presentacion/portada/noticias-vars.jspf" %>
<div class="plantilla_contenido">
<%@ include file="/layout/messages.jsp" %>


<!-- Middle column -->

<div id="contenido_central_middle">
<%-- 08/09/2010 Fernando Garcia --%>
<%--            This new block is to insert the random pictures jsp --%>
<%--            it's in another webapp so another context is needed --%>
<div><br><p style="font-size: 57%;">&nbsp;</p></div>
<!-- Random pictures -->
<div class="lb_bubble_topleft">
        <div class="lb_bubble_bottomleft">
                <div class="lb_bubble_topright">
                        <div class="lb_bubble_bottomright">
<%  //TODO: try to find another way to do it without scriptlets
    request.getSession(true);
    Object objForm = session.getAttribute("form");
    int numObj = 0;
    if (objForm instanceof es.pode.visualizador.presentacion.portada.PortadaFormImpl) {
            numObj = new Integer (((es.pode.visualizador.presentacion.portada.PortadaFormImpl)objForm).getObjetos());
    }

    ServletContext thisContext = getServletContext();
          ServletContext anotherContext = thisContext.getContext("/indexador");

    anotherContext.getRequestDispatcher("/random-pics.jsp").include(request, new org.apache.jasper.runtime.ServletResponseWrapperInclude (response, out));

%>
                        </div>
                </div>
        </div>
</div>
<!-- End Random pictures -->
<p>&nbsp;</p>
<%-- 08/09/2010 Fernando Garcia --%>
<%--            End of block --%>

<div class="heading_text heading_indent">search</div>

<!-- Search box bubble -->
<div class="search_box_bubble">

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

<div class="lb_bubble_content">

<form name="search" method="get" action="<rewrite:rewrite url="${initParam.url_buscador}"/>">
	<div style="">

	<!-- Start of search bubble -->
	<div style="float: right;">
	<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
		<div class="db_bubble_content">
		<a href="javascript:document.forms['search'].submit();"><bean:message key="buscador.buscador.boton"/></a>
		</div>
	</div></div></div></div>
	</div>

	<p style="float:left; display:inline;">Keywords</p>
	<div id="arrow_grey_right"/></div>

	<input style="border:1px solid #FFC20E;" type="text" id="buscadorGeneral" class="caja_buscador" value="" title="<bean:message key="buscador.buscador.alt"/>" name="buscadorGeneral" />

	<br/>

        <%-- 
            // 18/11/2010   Fernando Garcia
            //    Sorting method by default           --%>
        <input type="hidden" name="sortingMethod" value="RELEVANCE" />

	<input style="display:none;" type="submit" alt="<bean:message key="buscador.boton.buscar.alt"/>" class="buscar" value="<bean:message key="buscador.buscador.boton"/>" name="buscar" />

	</div>

</div>

	</div></div></div></div>
</div>
<!-- End of search box bubble -->

<div class="lb_bubble_end"></div>



<!-- Search filters bubble -->
<div class="heading_text heading_indent search_filter_triangle">search filters</div>
<div class="search_filter_bubble">

<!-- Start of bubble -->
<div class="lb_bubble_topleft" style="height: 130px;"><div class="lb_bubble_bottomleft" style="height: 130px;"><div class="lb_bubble_topright" style="height: 130px;"><div class="lb_bubble_bottomright" style="height: 130px;">

<div class="lb_bubble_content">

	<!-- Fix some display bugs... -->
	<div style="float: left; display: inline;">

	<!-- Subject -->
	<div class="search_filter_row">
		<div class="search_filter_name">Subject:</div>
		<div class="search_filter_choice">
			<html:select name="form" property="subjectSearchFilter" styleClass="search_filter_select">
				<c:forEach items="${form.subjectSearchFilterBackingList}" var="listItem" begin="0" end="${fn:length(form.subjectSearchFilterLabelList)}">
					<html:option value="${listItem.value}">${listItem.label}</html:option>
				</c:forEach>
			</html:select>
		</div>
		<div style="clear:left;"></div>
	</div>
	
	<!-- Keystage -->
	<div class="search_filter_row">
		<div class="search_filter_name">Keystage:</div>
		<div class="search_filter_choice">
			<html:select name="form" property="keystageSearchFilter" styleClass="search_filter_select">
				<c:forEach items="${form.keystageSearchFilterBackingList}" var="listItem" begin="0" end="${fn:length(form.keystageSearchFilterLabelList)}">
					<html:option value="${listItem.value}">${listItem.label}</html:option>
				</c:forEach>
			</html:select>
		</div>
		<div style="clear:left;"></div>
	</div>




        <!-- End user -->
	<div class="search_filter_row">
		<div class="search_filter_name">End User:</div>
		<div class="search_filter_choice">
			<html:select name="form" property="intendedEndUserRoleSearchFilter" styleClass="search_filter_select">
				<c:forEach items="${form.intendedEndUserRoleSearchFilterBackingList}" var="listItem" begin="0" end="${fn:length(form.intendedEndUserRoleSearchFilterLabelList)}">
					<html:option value="${listItem.value}">${listItem.label}</html:option>
				</c:forEach>
			</html:select>
		</div>
		<div style="clear:left;"></div>
	</div>


        <%--
        //19/10/2010    Fernando Garcia
        //              Adding a new filter for file mime types
        --%>
	<!-- Format -->
	<div class="search_filter_row">
		<div class="search_filter_name">Format:</div>
		<div class="search_filter_choice">
			<html:select name="form" property="intendedFMTSearchFilter" styleClass="search_filter_select">
				<c:forEach items="${form.intendedFMTSearchFilterBackingList}" var="listItem" begin="0" end="${fn:length(form.intendedFMTSearchFilterLabelList)}">
					<html:option value="${listItem.value}">${listItem.label}</html:option>
				</c:forEach>
			</html:select>
		</div>
		<div style="clear:left;"></div>
	</div>


        </div>
	<div style="clear:both;"></div>
		
</div>

</div></div></div></div>
</div>
<!-- End of bubble -->


<div class="lb_bubble_end"></div>
<!-- End of search filters bubble -->

</form>

</div>
<!-- End of middle column -->

<!-- End of plantilla_contenido -->
</div>

<!--  Establecer el cursor por defecto en la caja del buscador   -->	
<script type="text/javascript">
  document.forms[0].buscadorGeneral.focus();
</script>


</tiles:put>

<tiles:put name="menu.cabacera.top.rhs" type="string">
<!-- User and object counts -->
<div style="float: right;">
<span class="header_users">${form.usuarios} <bean:message key="portada.mensaje.usuarios"/></span>
<br class="oculto" />
<span class="header_objects">${form.objetos} <bean:message key="portada.mensaje.objetos"/></span>
<br class="oculto" />
</div> 

</tiles:put>


<tiles:put name="menu-rhs" type="string">
<!-- Front page contains the tag cloud -->
<div id="search-menu-rhs">

<div id="tagcloud">
<div class="heading_text">popular tags </div>
<tiles:insert definition="agrega.tagcloud" flush="false"/>
</div>

</div>
</tiles:put>

</tiles:insert>
