<%@ include file="/taglib-imports.jspf" %>


<div class="box2">
    <h4><bean:message key="menu.usecases.title"/></h4>
    <ul>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/CatalogadorBasico/CatalogadorBasico" titleKey="catalogador.basico.title">
                    <bean:message key="catalogador.basico.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/Taxonomias/Taxonomias" titleKey="taxonomias.title">
                    <bean:message key="taxonomias.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/CatalogadorAvanzado/CatalogadorAvanzado" titleKey="catalogador.avanzado.title">
                    <bean:message key="catalogador.avanzado.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/InicioCatalogador/InicioCatalogador" titleKey="inicio.catalogador.title">
                    <bean:message key="inicio.catalogador.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/General/General" titleKey="general.title">
                    <bean:message key="general.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/CicloDeVida/CicloDeVida" titleKey="ciclo.de.vida.title">
                    <bean:message key="ciclo.de.vida.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/MetaMetadatos/MetaMetadatos" titleKey="meta.metadatos.title">
                    <bean:message key="meta.metadatos.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/Tecnica/Tecnica" titleKey="tecnica.title">
                    <bean:message key="tecnica.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/UsoEducativo/UsoEducativo" titleKey="uso.educativo.title">
                    <bean:message key="uso.educativo.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/DetalleUsoEdu/DetalleUsoEdu" titleKey="detalle.uso.edu.title">
                    <bean:message key="detalle.uso.edu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/Derechos/Derechos" titleKey="derechos.title">
                    <bean:message key="derechos.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/Relacion/Relacion" titleKey="relacion.title">
                    <bean:message key="relacion.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/DetalleRelacionCU/DetalleRelacionCU" titleKey="detalle.relacion.cu.title">
                    <bean:message key="detalle.relacion.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/Anotacion/Anotacion" titleKey="anotacion.title">
                    <bean:message key="anotacion.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/DetalleAnotacionCU/DetalleAnotacionCU" titleKey="detalle.anotacion.cu.title">
                    <bean:message key="detalle.anotacion.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/Clasificacion/Clasificacion" titleKey="clasificacion.title">
                    <bean:message key="clasificacion.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/DetalleClasificacion/DetalleClasificacion" titleKey="detalle.clasificacion.title">
                    <bean:message key="detalle.clasificacion.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/Tesauros/Tesauros" titleKey="tesauros.title">
                    <bean:message key="tesauros.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/VerMetadatos/VerMetadatos" titleKey="ver.metadatos.title">
                    <bean:message key="ver.metadatos.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/Volver/Volver" titleKey="volver.title">
                    <bean:message key="volver.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ImportarLomes/ImportarLomes" titleKey="importar.lomes.title">
                    <bean:message key="importar.lomes.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ExportarLomes/ExportarLomes" titleKey="exportar.lomes.title">
                    <bean:message key="exportar.lomes.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/InicioPortal/InicioPortal" titleKey="inicio.portal.title">
                    <bean:message key="inicio.portal.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/CatalogadorBasicPlus/CatalogadorBasicPlus" titleKey="catalogador.basic.plus.title">
                    <bean:message key="catalogador.basic.plus.title"/>
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

