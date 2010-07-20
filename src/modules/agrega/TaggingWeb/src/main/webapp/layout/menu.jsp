<%@ include file="/taglib-imports.jspf" %>


<div class="box2">
    <h4><bean:message key="menu.usecases.title"/></h4>
    <ul>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/InicioTagging/InicioTagging" titleKey="inicio.tagging.title">
                    <bean:message key="inicio.tagging.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ListarMisTags/ListarMisTags" titleKey="listar.mis.tags.title">
                    <bean:message key="listar.mis.tags.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ListarAgregaTags/ListarAgregaTags" titleKey="listar.agrega.tags.title">
                    <bean:message key="listar.agrega.tags.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/MostrarOdesMisTags/MostrarOdesMisTags" titleKey="mostrar.odes.mis.tags.title">
                    <bean:message key="mostrar.odes.mis.tags.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/MostrarOdesAgregaTags/MostrarOdesAgregaTags" titleKey="mostrar.odes.agrega.tags.title">
                    <bean:message key="mostrar.odes.agrega.tags.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ModificarTag/ModificarTag" titleKey="modificar.tag.title">
                    <bean:message key="modificar.tag.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ListarTag/ListarTag" titleKey="listar.tag.title">
                    <bean:message key="listar.tag.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/Modificar/Modificar" titleKey="modificar.title">
                    <bean:message key="modificar.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/MostrarOdes/MostrarOdes" titleKey="mostrar.odes.title">
                    <bean:message key="mostrar.odes.title"/>
                </html:link>
                </td>


    
	<td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>
    <a href="" style="display:inline;" onclick="openWindow('<html:rewrite action="/applicationHelp"/>','onlinehelp',true,false,760,540); return false;">
        <bean:message key="online.help.href"/>
    </a>
    </td>

				</tr></table>
</div>

	<table>
		<tr>
			<td>
				<a href="<c:url value='/j_acegi_logout'/>">[Logout]</a>
			</td>
		</tr>
	</table>

