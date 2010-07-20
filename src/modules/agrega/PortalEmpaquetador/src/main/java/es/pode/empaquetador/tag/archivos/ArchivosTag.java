/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.pode.empaquetador.tag.archivos;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import es.pode.empaquetador.negocio.servicio.ArchivoVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * @author dgonzalezd
 *
 */
public class ArchivosTag extends TagSupport {

	private ArchivoVO arbol;
	private Integer niveles;
	private List path;
	private String actionNavegar;
	
	
	private static Logger logger = Logger.getLogger(ArchivosTag.class);
	
	private static String NIVEL="nivel";
	private static String GRUPO_ABIERTO="_grupo_abierto";
	private static String GRUPO_CERRADO="_grupo_cerrado";
	
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	public int doEndTag() throws JspException {
		return SKIP_BODY;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException {
		
		StringBuffer sb = new StringBuffer();
		flushJsp(doTag(niveles, path, arbol, actionNavegar, sb));
	return SKIP_BODY;
	}

	/**
	 * @param niveles TODO
	 * @param path TODO
	 * @param arbol TODO
	 * @param actionNavegar TODO
	 * @param sb TODO
	 * @return
	 * @throws JspException
	 */
	private StringBuffer doTag(Integer niveles, List path, ArchivoVO arbol, String actionNavegar, StringBuffer sb) throws JspException {
//		sb.append("<ul>");
		NumberFormat numberFormat=NumberFormat.getInstance();
		numberFormat.setMaximumIntegerDigits(3);
		numberFormat.setMinimumIntegerDigits(2);
		//<fmt:formatNumber var="nv" value="${niveles}" minIntegerDigits="2" maxIntegerDigits="3" />
		String nivelesFormatted=numberFormat.format(niveles);
		
		//<c:set var="claseOrgAbierto" value="nivel${nv }_grupo_abierto" />
		String claseOrgAbierto=new StringBuffer(NIVEL).append(nivelesFormatted).append(GRUPO_ABIERTO).toString();
		//<c:set var="claseOrgCerrado" value="nivel${nv }_grupo_cerrado" />
		String claseOrgCerrado=new StringBuffer(NIVEL).append(nivelesFormatted).append(GRUPO_CERRADO).toString();
		
//		<bean:define id="esProtegido">${arbol.esProtegido}</bean:define>
		boolean esProtegido=arbol.getEsProtegido().booleanValue();		
//		<logic:equal name="esProtegido" value="false">
		if(!esProtegido) {
//			<logic:equal name="arbol" property="esFichero" value="false">
			if(!arbol.getEsFichero().booleanValue()) {
//				<c:set var="esAbierta" value="false"/>
				boolean esAbierta=false;
//				<logic:iterate id="elemento" name="path">
				for (Iterator iterator = path.iterator(); iterator.hasNext();) {
					ArchivoVO elemento = (ArchivoVO) iterator.next();
//					<logic:equal name="elemento" property="href" value="${arbol.href}">
					if(elemento.getHref().equals(arbol.getHref())) {
//						<c:set var="esAbierta" value="true"/>
						esAbierta=true;
//					</logic:equal>
					}
//				</logic:iterate>
				}
//				<logic:equal name="esAbierta" value="false">
				sb.append("<li id=\"").append(arbol.getHref()).append("\" class=\"");
				if(!esAbierta) {
//					<li id="${arbol.href}" class="${claseOrgCerrado }">
					sb.append(claseOrgCerrado).append("\">");
//				</logic:equal>
//					<logic:equal name="esAbierta" value="true">
				} else {
//					<li id="${arbol.href}" class="${claseOrgAbierto }">
					sb.append(claseOrgAbierto).append("\">");
//				</logic:equal>
				}
//				<span onclick="P7_swapClass(1,'${arbol.href}','${claseOrgAbierto }','${claseOrgCerrado }','li');return false" onkeypress="P7_swapClass(1,'${arbol.href}','${claseOrgAbierto }','${claseOrgCerrado }','li');return false">&nbsp;</span>
				String comillasComaComillas="','";
				String clases=comillasComaComillas+claseOrgAbierto+comillasComaComillas+claseOrgCerrado+comillasComaComillas;
				sb.append("<span onclick=\"P7_swapClass(1,'").append(arbol.getHref()).append(clases);
				sb.append("li');return false\" onkeypress=\"P7_swapClass(1,'").append(arbol.getHref()).append(clases);
				sb.append("li');return false\">&nbsp;</span>");
//				<a href="<html:rewrite action="${actionNavegar }"/>?href=${arbol.href}" onclick="P7_swapClass(1,'${arbol.href}','${claseOrgAbierto }','${claseOrgCerrado }','li');return true" onkeypress="P7_swapClass(1,'${arbol.href}','${claseOrgAbierto }','${claseOrgCerrado }','li');return true">${arbol.nombre}</a>
				sb.append("<a href=\"").append(actionNavegar).append("?href=").append(arbol.getHref());
				sb.append("\" onclick=\"P7_swapClass(1,'").append(arbol.getHref()).append(clases).append("li');return true\" onkeypress=\"P7_swapClass(1,'");
				sb.append(arbol.getHref()).append(clases).append("li');return true\">").append(arbol.getNombre()).append("</a>");
//				<ul>
				sb.append("<ul>");
//					<logic:notEmpty name="arbol" property="contenidos">
				if(arbol.getContenidos()!=null&&arbol.getContenidos().length>0) {
//						 	<logic:iterate id="archivo" name="arbol" property="contenidos">
					for (int i = 0; i < arbol.getContenidos().length; i++) {
						ArchivoVO archivo = arbol.getContenidos()[i];
						doTag(new Integer(niveles.intValue()+1), path, archivo, actionNavegar, sb);
//						   		<arb:archivos niveles="${niveles +1}" arbol="${archivo}" path="${path}" actionNavegar="${actionNavegar }"/>
//							</logic:iterate>
					}
//					</logic:notEmpty>
				}
//					
//				</ul>
//				</li>	
				sb.append("</ul></li>");
//				
//			</logic:equal>
//			<logic:equal name="arbol" property="esFichero" value="true">				
			} else {
//			<li class="item3"><span>&nbsp;<a href="${arbol.href }">${arbol.nombre }</a></span></li>
				//Compongo la ruta host/agrega del recurso
				String base = "http://"+LdapUserDetailsUtils.getHost()+LdapUserDetailsUtils.getSubdominio();
				sb.append("<li class=\"item3\"><span>&nbsp;<a href=\"").append(base).append(arbol.getHref()).append("\" target=\"_blank\">").append(arbol.getNombre()).append("</a></span></li>");
//			</logic:equal>
			}
//		</logic:equal>
		}
		
		return sb;
	}
	
	/**
	 * @param sb
	 * @throws JspException
	 */
	private void flushJsp(StringBuffer sb) throws JspException {
		JspWriter out= pageContext.getOut();
		try {
			out.write(sb.toString());
		} catch (IOException e) {
			logger.error("Error dibujando ArchivosTag",e);
			throw new JspException("Error dibujando ArchivosTag",e);
			
		}
	}
	
	/**
	 * Metodo fuera de uso tras cambios para urls tipo host/agrega.
	 * 
	 * @param actionNavegar
	 * @return
	 */
//	private String rewrite(String actionNavegar) {
//		PageContext contexto=pageContext;
//		String hostname= contexto.getRequest().getServerName();
//		String url= (String)contexto.getAttribute("urlArchivos");
//		String urlFinal="http://"+(hostname.equals("localhost")?hostname+":8080":hostname)+"/"+url.split("/")[1]+actionNavegar+".do";
//		return urlFinal;
//	}

	/**
	 * @return the arbol
	 */
	public ArchivoVO getArbol() {
		return arbol;
	}

	/**
	 * @param arbol the arbol to set
	 */
	public void setArbol(ArchivoVO arbol) {
		this.arbol = arbol;
	}

	/**
	 * @return the niveles
	 */
	public Integer getNiveles() {
		return niveles;
	}

	/**
	 * @param niveles the niveles to set
	 */
	public void setNiveles(Integer niveles) {
		this.niveles = niveles;
	}

	/**
	 * @return the path
	 */
	public List getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(List path) {
		this.path = path;
	}

	/**
	 * @return the actionNavegar
	 */
	public String getActionNavegar() {
		return actionNavegar;
	}

	/**
	 * @param actionNavegar the actionNavegar to set
	 */
	public void setActionNavegar(String actionNavegar) {
		this.actionNavegar = actionNavegar;
	}

	
}
