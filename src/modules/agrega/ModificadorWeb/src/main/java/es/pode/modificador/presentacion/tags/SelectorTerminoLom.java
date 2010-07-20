/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.presentacion.tags;

import java.util.Locale;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;
import org.apache.struts.util.MessageResources;

import es.pode.modificador.negocio.servicio.CambioTypes;
import es.pode.modificador.negocio.servicio.TerminoLomVO;
import es.pode.soporte.constantes.ConstantesAgrega;

public class SelectorTerminoLom extends TagSupport {

	private TerminoLomVO termino = null;

	private String tipoCambio = null;

	private String action = null;

	/**
	 * @return the tipoCambio
	 */
	public String getTipoCambio() {
		return tipoCambio;
	}

	/**
	 * @param tipoCambio
	 *            the tipoCambio to set
	 */
	public void setTipoCambio(String tipoCambio) {
		this.tipoCambio = tipoCambio;
	}

	/**
	 * @return the termino
	 */
	public TerminoLomVO getTermino() {
		return termino;
	}

	/**
	 * @param termino
	 *            the termino to set
	 */
	public void setTermino(TerminoLomVO termino) {
		this.termino = termino;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	public int doEndTag() throws JspException {

		return SKIP_BODY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException {
		boolean pintarBoton = false;
		if ((tipoCambio.equals(CambioTypes._modification) && termino
				.getModificable().booleanValue())
				|| (tipoCambio.equals(CambioTypes._removal) && termino
						.getEliminable().booleanValue())
				|| (tipoCambio.equals(CambioTypes._addition) && termino
						.getAniadir().booleanValue())) {
			pintarBoton = true;
		} else if(tipoCambio.equals(CambioTypes._check) && termino.getIdTermino()!=null) pintarBoton=true;
		if (pintarBoton) {
			JspWriter out = pageContext.getOut();
			StringBuffer sb = new StringBuffer();
			sb.append("<input type=\"submit\" ");
			sb.append("class=\"boton_125_de_2\" ");
			if (action != null)
				sb.append("name=\"").append(action).append("\" ");
			MessageResources res = MessageResources
					.getMessageResources("application-resources");
			String value = res.getMessage((Locale)pageContext.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE),"comun.seleccionar");
			sb.append("value=\"").append(value).append("\"/>");
			try {
				out.write(sb.toString());
			} catch (Exception e) {
				Logger.getLogger(this.getClass()).debug(e);
				throw new JspException(e.getMessage());
			}
		}
		return SKIP_BODY;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action
	 *            the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

}
