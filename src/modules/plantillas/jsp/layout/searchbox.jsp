<%@ include file="/taglib-imports.jspf"%>
<%@ taglib uri="/WEB-INF/tags/rewriteTag.tld" prefix="rewrite" %>

<!-- Search box as used in buscador -->
<div class="search_box_bubble">

<!-- Start of bubble -->
<div class="lb_bubble_topleft"><div class="lb_bubble_bottomleft"><div class="lb_bubble_topright"><div class="lb_bubble_bottomright">

<div class="lb_bubble_content">

	<form name="search" method="get" action="<rewrite:rewrite url="${initParam.url_buscador}"/>">

	<!-- Start of search bubble -->
	<div style="float: right;">
	<div class="db_bubble_topleft"><div class="db_bubble_bottomleft"><div class="db_bubble_topright"><div class="db_bubble_bottomright">
		<div class="db_bubble_content">
		<a href="javascript:document.forms['search'].submit();"><bean:message key="buscador.buscador.boton"/></a>
		</div>
	</div></div></div></div>
	</div>

	<input type="text" id="buscadorGeneral" class="caja_buscador" style="width: 13em;" value="" title="<bean:message key="buscador.buscador.alt"/>" name="buscadorGeneral" />

    <!-- 
         Placeholder for search filters if we agree a layout with NWLG
         that allows the selection labels and widgets to fit.  In the
         meantime, these fields serve as a means for resetting any
         previous search filters when a user performs a new search.

         Attempting the same in the controller code is not a sensible
         idea; higher maintenance route in terms of not only tracking
         all search types and patterns, but also tracking referers
         (for edge cases) the names for whom are prone to change.

         Also, we do not intend to introduce undue server processing
         overhead when client request input works.
    -->

    <input type="hidden" name="subjectSearchFilter" value="" />
    <input type="hidden" name="keystageSearchFilter" value="" />
    <input type="hidden" name="learningTimeSearchFilter" value="" />
    <input type="hidden" name="intendedEndUserRoleSearchFilter" value="" />

	<input style="display:none;" type="submit" alt="<bean:message key="buscador.boton.buscar.alt"/>" class="buscar" value="<bean:message key="buscador.buscador.boton"/>" name="buscar" />

        </div>
	</form>

</div></div></div></div>
<!-- End of search bubble -->

</div>
