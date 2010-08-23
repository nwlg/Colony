/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.agrega.soporte.tag.url;

import java.net.URLEncoder;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

public class CodificadorURL extends TagSupport {

	private String url;
	private static Logger logger = Logger.getLogger(CodificadorURL.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -2210056531767189553L;

	@Override
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return SKIP_BODY;
	}

	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		String encoding = super.pageContext.getResponse().getCharacterEncoding();
		String finalUrl = url;
		if(encoding!=null && url!=null) {
			try {
				String encodedSlash = URLEncoder.encode("/", encoding);
				String encodedColon = URLEncoder.encode(":", encoding);
				finalUrl = URLEncoder.encode(url, encoding);
				finalUrl = finalUrl.replaceAll(encodedSlash, "/");
				finalUrl = finalUrl.replaceAll("\\+", "%20");
				finalUrl = finalUrl.replaceAll(encodedColon, ":");
				logger.debug("Url " + url + " codificada como " + finalUrl);
			} catch (Exception e) {
				logger.error("No se pudo codificar la url " + url + ". " + e.getLocalizedMessage());
				if(logger.isDebugEnabled()) logger.debug(e);
			}
		}
		JspWriter out = pageContext.getOut();
		try {
			out.write(finalUrl);
		} catch (Exception e) {
			logger.error("Error de escritura de JSP",e);
		}
		return SKIP_BODY;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

}
