<%@ include file="/taglib-imports.jspf" %>


<div class="box2">
    <h4><bean:message key="menu.usecases.title"/></h4>
    <ul>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ObjetosPropuestosCU/ObjetosPropuestosCU" titleKey="objetos.propuestos.cu.title">
                    <bean:message key="objetos.propuestos.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ObjetosPersonalesCU/ObjetosPersonalesCU" titleKey="objetos.personales.cu.title">
                    <bean:message key="objetos.personales.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/VerHistorialCU/VerHistorialCU" titleKey="ver.historial.cu.title">
                    <bean:message key="ver.historial.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ImportarCU/ImportarCU" titleKey="importar.cu.title">
                    <bean:message key="importar.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ExportarCU/ExportarCU" titleKey="exportar.cu.title">
                    <bean:message key="exportar.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ProponerCatalogacionCU/ProponerCatalogacionCU" titleKey="proponer.catalogacion.cu.title">
                    <bean:message key="proponer.catalogacion.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/EliminarPersonalesCU/EliminarPersonalesCU" titleKey="eliminar.personales.cu.title">
                    <bean:message key="eliminar.personales.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ImportarURLCU/ImportarURLCU" titleKey="importar.urlcu.title">
                    <bean:message key="importar.urlcu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ObjetosPublicadosCU/ObjetosPublicadosCU" titleKey="objetos.publicados.cu.title">
                    <bean:message key="objetos.publicados.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ObjetosDespublicadosCU/ObjetosDespublicadosCU" titleKey="objetos.despublicados.cu.title">
                    <bean:message key="objetos.despublicados.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/PublicarCU/PublicarCU" titleKey="publicar.cu.title">
                    <bean:message key="publicar.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/RechazarCU/RechazarCU" titleKey="rechazar.cu.title">
                    <bean:message key="rechazar.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ObjetosPendientesCU/ObjetosPendientesCU" titleKey="objetos.pendientes.cu.title">
                    <bean:message key="objetos.pendientes.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/EliminarCU/EliminarCU" titleKey="eliminar.cu.title">
                    <bean:message key="eliminar.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ObjetosPendientesCatalogacionCU/ObjetosPendientesCatalogacionCU" titleKey="objetos.pendientes.catalogacion.cu.title">
                    <bean:message key="objetos.pendientes.catalogacion.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ProponerCU/ProponerCU" titleKey="proponer.cu.title">
                    <bean:message key="proponer.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/RechazarPendCatalogacionCU/RechazarPendCatalogacionCU" titleKey="rechazar.pend.catalogacion.cu.title">
                    <bean:message key="rechazar.pend.catalogacion.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ImportarCompartidosCU/ImportarCompartidosCU" titleKey="importar.compartidos.cu.title">
                    <bean:message key="importar.compartidos.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ObjetosCompartidosCU/ObjetosCompartidosCU" titleKey="objetos.compartidos.cu.title">
                    <bean:message key="objetos.compartidos.cu.title"/>
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

