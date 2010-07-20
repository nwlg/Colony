/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.presentacion.tags;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;
import org.apache.struts.util.MessageResources;

import es.pode.modificador.negocio.servicio.CambioTypes;
import es.pode.modificador.negocio.servicio.TerminoLomVO;
import es.pode.soporte.constantes.ConstantesAgrega;

public class Submit extends TagSupport {

	private String valueKey = null;
	private String name = null;
	private TerminoLomVO termino = null;
	private String tipoCambio = null;
	private static final String APPLICATION_RESOURCES = "application-resources";
	private static final Logger logger = Logger.getLogger(Submit.class);
	
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	public int doEndTag() throws JspException {
		return SKIP_BODY;
	}

	private boolean isDisabled() {
		boolean result = true;
		if(CambioTypes._addition.equals(tipoCambio) && termino.getAniadir().booleanValue()) result = false;
		else if (CambioTypes._modification.equals(tipoCambio) && termino.getModificable().booleanValue()) result = false;
		else if(CambioTypes._removal.equals(tipoCambio) && termino.getEliminable().booleanValue()) result = false;
		else if(CambioTypes._check.equals(tipoCambio)) result = false;
		return result;
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException {
		String value = null;
		MessageResources resources = MessageResources.getMessageResources(APPLICATION_RESOURCES);
		value = resources.getMessage((Locale)pageContext.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE),valueKey);
		JspWriter out = pageContext.getOut();
		StringBuffer sb = new StringBuffer("<input type=\"submit\" name=\"");
		sb.append(name).append("\" value=\"").append(value).append("\" ");
		if(isDisabled()) {
			sb.append("disabled=\"disabled\" ");
		}
		sb.append("/>");
		try {
		out.write(sb.toString());
		} catch (IOException e) {
			logger.error("Error al pintar el boton de submit para termino LOM" + termino.getIdTermino());
			if(logger.isDebugEnabled()) logger.debug(e);
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the termino
	 */
	public TerminoLomVO getTermino() {
		return termino;
	}

	/**
	 * @param termino the termino to set
	 */
	public void setTermino(TerminoLomVO termino) {
		this.termino = termino;
	}

	/**
	 * @return the tipoCambio
	 */
	public String getTipoCambio() {
		return tipoCambio;
	}

	/**
	 * @param tipoCambio the tipoCambio to set
	 */
	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	/**
	 * @return the valueKey
	 */
	public String getValueKey() {
		return valueKey;
	}

	/**
	 * @param valueKey the valueKey to set
	 */
	public void setValueKey(String valueKey) {
		this.valueKey = valueKey;
	}

}
