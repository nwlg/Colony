<%@ include file="/taglib-imports.jspf" %>


<div class="box2">
    <h4><bean:message key="menu.usecases.title"/></h4>
    <ul>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ListarODECU/ListarODECU" titleKey="listar.odecu.title">
                    <bean:message key="listar.odecu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/DetallarODECU/DetallarODECU" titleKey="detallar.odecu.title">
                    <bean:message key="detallar.odecu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/DescargarODECU/DescargarODECU" titleKey="descargar.odecu.title">
                    <bean:message key="descargar.odecu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/EnviarMailCU/EnviarMailCU" titleKey="enviar.mail.cu.title">
                    <bean:message key="enviar.mail.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ListarComentariosCU/ListarComentariosCU" titleKey="listar.comentarios.cu.title">
                    <bean:message key="listar.comentarios.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/IntroducirComentariosCU/IntroducirComentariosCU" titleKey="introducir.comentarios.cu.title">
                    <bean:message key="introducir.comentarios.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/AnadirCarpetaPersonalCU/AnadirCarpetaPersonalCU" titleKey="anadir.carpeta.personal.cu.title">
                    <bean:message key="anadir.carpeta.personal.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/AreaCurricularCU/AreaCurricularCU" titleKey="area.curricular.cu.title">
                    <bean:message key="area.curricular.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/BuscarAvanzadoCU/BuscarAvanzadoCU" titleKey="buscar.avanzado.cu.title">
                    <bean:message key="buscar.avanzado.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/EliminarOdesCU/EliminarOdesCU" titleKey="eliminar.odes.cu.title">
                    <bean:message key="eliminar.odes.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/TesaurosCU/TesaurosCU" titleKey="tesauros.cu.title">
                    <bean:message key="tesauros.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/FormularioAvanzadoCU/FormularioAvanzadoCU" titleKey="formulario.avanzado.cu.title">
                    <bean:message key="formulario.avanzado.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/BusquedaSQICU/BusquedaSQICU" titleKey="busqueda.sqicu.title">
                    <bean:message key="busqueda.sqicu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/NavegarArbolCurricularCU/NavegarArbolCurricularCU" titleKey="navegar.arbol.curricular.cu.title">
                    <bean:message key="navegar.arbol.curricular.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ListarODEAreaCU/ListarODEAreaCU" titleKey="listar.odearea.cu.title">
                    <bean:message key="listar.odearea.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/NavegarTesauroCU/NavegarTesauroCU" titleKey="navegar.tesauro.cu.title">
                    <bean:message key="navegar.tesauro.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/ListarODETesauroCU/ListarODETesauroCU" titleKey="listar.odetesauro.cu.title">
                    <bean:message key="listar.odetesauro.cu.title"/>
                </html:link>
                </td>

	            <td>&nbsp;&nbsp;-&nbsp;&nbsp;</td><td>	
                <html:link action="/SeleccionTipoBusquedaCU/SeleccionTipoBusquedaCU" titleKey="seleccion.tipo.busqueda.cu.title">
                    <bean:message key="seleccion.tipo.busqueda.cu.title"/>
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

