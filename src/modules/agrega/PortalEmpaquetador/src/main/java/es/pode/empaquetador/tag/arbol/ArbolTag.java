/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.pode.empaquetador.tag.arbol;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import es.pode.empaquetador.negocio.servicio.GrupoVO;
import es.pode.empaquetador.negocio.servicio.OrganizacionVO;

/**
 * @author dgonzalezd
 *
 */
public class ArbolTag extends TagSupport {

	private Integer niveles;
	private GrupoVO datosIter;
	private List idCollection;
	private String actionNavegar;
	private String tipoEmpaquetador;
	
	private static Logger logger = Logger.getLogger(ArbolTag.class);
	
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
		StringBuffer sb= new StringBuffer();
		flushJsp(doTag(niveles, idCollection, datosIter, actionNavegar, tipoEmpaquetador, sb));
		return SKIP_BODY;
	}

	/**
	 * @param niveles TODO
	 * @param idCollection TODO
	 * @param datosIter TODO
	 * @param actionNavegar TODO
	 * @param tipoEmpaquetador TODO
	 * @param sb TODO
	 * @return
	 * @throws JspException
	 */
	private StringBuffer doTag(Integer niveles, List idCollection, GrupoVO datosIter, String actionNavegar, String tipoEmpaquetador, StringBuffer sb) throws JspException {
		sb.append("<ul>");
		NumberFormat numberFormat=NumberFormat.getInstance();
		numberFormat.setMaximumIntegerDigits(3);
		numberFormat.setMinimumIntegerDigits(2);
		//<fmt:formatNumber var="nv" value="${niveles}" minIntegerDigits="2" maxIntegerDigits="3" />
		String nivelesFormatted=numberFormat.format(niveles);
		
		//<c:set var="claseOrgAbierto" value="nivel${nv }_grupo_abierto" />
		String claseOrgAbierto=new StringBuffer(NIVEL).append(nivelesFormatted).append(GRUPO_ABIERTO).toString();
		//<c:set var="claseOrgCerrado" value="nivel${nv }_grupo_cerrado" />
		String claseOrgCerrado=new StringBuffer(NIVEL).append(nivelesFormatted).append(GRUPO_CERRADO).toString();
		
//		<c:set var="esAbierta" value="false"/>
		boolean esAbierta=false;
		
//		<logic:iterate id="elemento" name="idCollection">
//		<logic:equal name="elemento" property="identifier" value="${datosIter.identifier }">
//			<c:set var="esAbierta" value="true"/>
//		</logic:equal>
//		</logic:iterate>
		String datosIterId=datosIter.getIdentifier();
		for (Iterator iterator = idCollection.iterator(); iterator.hasNext();) {
			Object elemento = (Object) iterator.next();
			String identifier;
			if(elemento instanceof GrupoVO) {
				identifier=((GrupoVO)elemento).getIdentifier();
			} else {
				identifier=((OrganizacionVO)elemento).getIdentifier();
			}
			if(datosIterId.equals(identifier)) esAbierta=true;
		}
		
//		<logic:equal name="esAbierta" value="false">
//		<li id="${datosIter.identifier }" class="${claseOrgCerrado }">
//		</logic:equal>
//		<logic:equal name="esAbierta" value="true">
//			<li id="${datosIter.identifier }" class="${claseOrgAbierto }">
//		</logic:equal>
		sb.append("<li id=\"").append(datosIter.getIdentifier()).append("\" class=\"");
		sb.append(esAbierta?claseOrgAbierto:claseOrgCerrado).append("\">");
		
		
		//<span onclick="P7_swapClass(1,'${datosIter.identifier }','${claseOrgAbierto}',
		//'${claseOrgCerrado}','li');return false" onkeypress="P7_swapClass(1,'${datosIter.identifier }',
		//'${claseOrgAbierto}','${claseOrgCerrado}','li');return false">&nbsp;</span>
		String comillasComaComillas="','";
		sb.append("<span onclick=\"P7_swapClass(1,'");
		sb.append(datosIterId).append(comillasComaComillas);
		sb.append(claseOrgAbierto).append(comillasComaComillas);
		sb.append(claseOrgCerrado).append(comillasComaComillas);
		sb.append("li');return false\" onkeypress=\"P7_swapClass(1,'");
		sb.append(datosIterId).append(comillasComaComillas);
		sb.append(claseOrgAbierto).append(comillasComaComillas);
		sb.append(claseOrgCerrado).append(comillasComaComillas);
		sb.append("li');return false\">&nbsp;</span>");
		
		//<a href="<html:rewrite action="${actionNavegar }"/>?identifier=${datosIter.identifier }" onclick="P7_swapClass(1,
		//'${datosIter.identifier }','${claseOrgAbierto }','${claseOrgCerrado }','li');return true" onkeypress="P7_swapClass(1,
		//'${datosIter.identifier }','${claseOrgAbierto }','${claseOrgCerrado }','li');return true">${datosIter.title}</a>
		
		sb.append("<a href=\"").append(actionNavegar);
		sb.append("?identifier=").append(datosIterId).append("\" onclick=\"P7_swapClass(1,'").append(datosIterId);
		sb.append(comillasComaComillas).append(claseOrgAbierto).append(comillasComaComillas).append(claseOrgCerrado);
		sb.append(comillasComaComillas).append("li');return true\" onkeypress=\"P7_swapClass(1,'");
		sb.append(datosIterId).append(comillasComaComillas).append(claseOrgAbierto).append(comillasComaComillas);
		sb.append(claseOrgCerrado).append(comillasComaComillas).append("li');return true\">");
		sb.append(datosIter.getTitle()).append("</a>");
		
		
//		<logic:notEmpty name="datosIter" property="grupos">
//	 	<logic:iterate id="grupo" name="datosIter" property="grupos">
		//Recursividad a manita...
		GrupoVO[] grupos=datosIter.getGrupos();
		if(grupos!=null&&grupos.length>0) {
			for (int i = 0; i < grupos.length; i++) {
				//<arb:arbol niveles ="${niveles +1}" datosIter="${grupo}" idCollection="${idCollection}" actionNavegar="${actionNavegar }"
				//tipoEmpaquetador="${tipoEmpaquetador}"/>
				//sb.append(
				doTag(new Integer(niveles.intValue()+1), idCollection, grupos[i], actionNavegar, tipoEmpaquetador, sb);
				//		);
			}
		}
		
		sb.append("</li></ul>");
		
		return sb;
	}

	/**
	 * @param actionNavegar
	 * @return
	 */
	private String rewrite(String actionNavegar) {
		PageContext contexto=pageContext;
		String hostname= contexto.getRequest().getServerName();
		String url= (String)contexto.getAttribute("urlArchivos");
		String urlFinal="http://"+(hostname.equals("localhost")?hostname+":8080":hostname)+"/"+url.split("/")[1]+actionNavegar+".do";
		return urlFinal;
	}

	/**
	 * @param sb
	 * @throws JspException
	 */
	private void flushJsp(StringBuffer sb) throws JspException {
		JspWriter out= pageContext.getOut();
		try {
			out.write(sb.toString());
			sb=new StringBuffer();
		} catch (IOException e) {
			logger.error("Error dibujando ArbolTag",e);
			throw new JspException("Error dibujando ArbolTag",e);
			
		}
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
	 * @return the datosIter
	 */
	public GrupoVO getDatosIter() {
		return datosIter;
	}

	/**
	 * @param datosIter the datosIter to set
	 */
	public void setDatosIter(GrupoVO datosIter) {
		this.datosIter = datosIter;
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

	/**
	 * @return the tipoEmpaquetador
	 */
	public String getTipoEmpaquetador() {
		return tipoEmpaquetador;
	}

	/**
	 * @param tipoEmpaquetador the tipoEmpaquetador to set
	 */
	public void setTipoEmpaquetador(String tipoEmpaquetador) {
		this.tipoEmpaquetador = tipoEmpaquetador;
	}

	/**
	 * @return the idCollection
	 */
	public List getIdCollection() {
		return idCollection;
	}

	/**
	 * @param idCollection the idCollection to set
	 */
	public void setIdCollection(List idCollection) {
		this.idCollection = idCollection;
	}

}
