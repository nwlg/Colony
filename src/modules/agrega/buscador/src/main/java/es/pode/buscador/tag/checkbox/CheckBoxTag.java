/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.pode.buscador.tag.checkbox;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

/**
 * @author srecio y pcanales
 * 
 */
public class CheckBoxTag extends TagSupport {
	private static Logger logger = Logger.getLogger(CheckBoxTag.class);


	private String name = null;	
	private String id = null;	
	private String url = null;	
	private String titulo = null;	
	private String administrador = null;	
	private String numeroODE = null;
	private String nodoODE = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();

		try {					
			out.write("<table width=\"6%\" border=\"1\">" );
				out.write("<tr>" );
					//Escribo el número del ode
					out.write("<td class=\"numeracion\"><strong>" + numeroODE + "</strong></td>" );
					//Escribo el checkbox si el usuario es administrador
					if(administrador.equals("true") && (nodoODE==null || nodoODE.equals(""))){
						out.write("<td class=\"numeracion\"><strong><input type=\"checkbox\" id=\"" + id + "\" "	+ " name=\"" + name + "\" value=\"" + id + "\"/></strong></td>");
					}
				out.write("</tr>" );
			out.write("</table>" );
		} catch (Exception e) {
			logger.error("CheckBoxTag - doStartTag():Error al dibujar checkbox del elemento", e);
			throw new JspException("CheckBoxTag - doStartTag(): Error al dibujar checkbox del elemento", e);
		}
		return SKIP_BODY;	
	}

	public int doEndTag() throws JspException {
		return SKIP_BODY;
	}	

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * @return the administrador
	 */
	public String getAdministrador() {
		return administrador;
	}
	/**
	 * @param administrador
	 *            the administrador to set
	 */
	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}
	public String getNumeroODE() {
		return numeroODE;
	}

	public void setNumeroODE(String numeroODE) {
		this.numeroODE = numeroODE;
	}
	
	public String getNodoODE() {
		return nodoODE;
	}

	public void setNodoODE(String nodoODE) {
		this.nodoODE = nodoODE;
	}
}
