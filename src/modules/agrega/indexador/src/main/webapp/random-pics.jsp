<%@ page import="es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.net.URL" %>
<%@ page import="es.agrega.soporte.agregaProperties.AgregaProperties" %>
<%@ page import="es.agrega.soporte.agregaProperties.AgregaPropertiesImpl" %>
<%
es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService sbsi = es.pode.indexador.ServiceLocator.instance().getSrvBuscadorService();

InputStreamReader in = null;

/* Agrega weird way to know if information stored about images is right */
/* please have a look to es.pode.buscar.negocio.buscar.servicios.SrvBuscarServiceImpl.comprobarImagen */
/* TODO: move this code to a class */
/* TODO: write right information at the lucene index */

es.pode.indexador.negocio.servicios.busqueda.DocVO docVO1 = sbsi.obtenerODERandom();
String imgODE1 = "http://"+ LdapUserDetailsUtils.getHost() + docVO1.getImagen();
try {
    in = new InputStreamReader(new URL(imgODE1).openStream());
} catch (Exception e) { //if fails, default img
    imgODE1 = "http://"+LdapUserDetailsUtils.getHost()+"/"+AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO_100x100);
}
    
es.pode.indexador.negocio.servicios.busqueda.DocVO docVO2 = sbsi.obtenerODERandom();
String imgODE2 = "http://"+ LdapUserDetailsUtils.getHost() + docVO2.getImagen();
try {
    in = new InputStreamReader(new URL(imgODE2).openStream());
} catch (Exception e) { //if fails, default img
    imgODE2 = "http://"+LdapUserDetailsUtils.getHost()+"/"+AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO_100x100);
}

es.pode.indexador.negocio.servicios.busqueda.DocVO docVO3 = sbsi.obtenerODERandom();
String imgODE3 = "http://"+ LdapUserDetailsUtils.getHost() + docVO3.getImagen();
try {
    in = new InputStreamReader(new URL(imgODE3).openStream());
} catch (Exception e) { //if fails, default img
    imgODE3 = "http://"+LdapUserDetailsUtils.getHost()+"/"+AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.URL_IMAGEN_DEFECTO_100x100);
}


if (docVO1!=null && docVO2!=null && docVO3!=null) {
 %>
<!-- pics layer -->
<div>
	<table width="100%" style="padding: 5px;">
		<tr>
			<td width="30%" style="border:1px solid #FFC20E;padding: 10px;background: white; height: 140px;">
				<a href='http://<%=LdapUserDetailsUtils.getHost()+""+LdapUserDetailsUtils.getSubdominio()%>/ODE/en/<%=docVO1.getIdentificadorODE()%>'>
						<center><img style="border:1px solid #9DBEDD;" src='<%=imgODE1%>' alt='<%=docVO1.getTitulo()%>'/></center>
				</a>
			</td>
			<td witdh="5%">&nbsp;</td>
			<td width="30%" style="border:1px solid #FFC20E;padding: 10px;background: white; height: 140px;">
				<a href='http://<%=LdapUserDetailsUtils.getHost()+""+LdapUserDetailsUtils.getSubdominio()%>/ODE/en/<%=docVO2.getIdentificadorODE()%>'>
						<center><img style="border:1px solid #9DBEDD;" src='<%=imgODE2%>' alt='<%=docVO2.getTitulo()%>'/></center>
				</a>
			</td>
			<td witdh="5%">&nbsp;</td>
			<td width="30%" style="border:1px solid #FFC20E;padding: 10px;background: white; height: 140px;">
				<a href='http://<%=LdapUserDetailsUtils.getHost()+""+LdapUserDetailsUtils.getSubdominio()%>/ODE/en/<%=docVO3.getIdentificadorODE()%>'>
						<center><img style="border:1px solid #9DBEDD;" src='<%=imgODE3%>' alt='<%=docVO3.getTitulo()%>'/></center>
				</a>
			</td>
		</tr>
		<tr>
			<td  width="30%">
						<center><span style="font-size: 80%;"><%=docVO1.getTitulo()%></span></center>
			</td>
			<td witdh="5%">&nbsp;</td>
			<td width="30%">
						<center><span style="font-size: 80%;"><%=docVO2.getTitulo()%></span></center>
			</td>
			<td witdh="5%">&nbsp;</td>
			<td width="30%">
						<center><span style="font-size: 80%;"><%=docVO3.getTitulo()%></span></center>
			</td>
		</tr>
	</table>
</div>
<!-- end pics layer -->
<%
}
%>