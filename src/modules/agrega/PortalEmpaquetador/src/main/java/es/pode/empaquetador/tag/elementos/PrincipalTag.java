/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.empaquetador.tag.elementos;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import es.pode.empaquetador.negocio.servicio.GrupoVO;
import es.pode.empaquetador.negocio.servicio.RecursoVO;

public class PrincipalTag extends TagSupport {

	private GrupoVO grupo = null;
	private String url = null;
	private String i18nKey = null;
	private RecursoVO[] recursos = null;
	private static Logger logger = Logger.getLogger(PrincipalTag.class);
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doEndTag()
	 */
	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return SKIP_BODY;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException {
		String idRef = grupo.getElementoReferenciado();
		JspWriter out = pageContext.getOut();
		String begin = "<td valign=\"top\" class=\"ejec\"><span class=\"oculto\">-</span>";
		String end = "</td>";
		String outText = begin + end;
		try {
			logger.debug("idRef es " + idRef);
			if(idRef!=null)  {
				RecursoVO recurso = null;
				for(int i=0;i<recursos.length && recurso==null;i++) {
					if(idRef.equals(recursos[i].getIdentifier())) {
						recurso=recursos[i];
					}
				}
				logger.debug("Recurso es " + recurso);
				if(recurso!=null)  {
					logger.debug("recurso fileList es " + recurso.getFileList());
					if(recurso.getFileList()!=null && recurso.getFileList().length>1) {
						ResourceBundle i18n = ResourceBundle.getBundle("application-resources",pageContext.getRequest().getLocale());
						String linkText = i18n.getString(i18nKey);
						outText = begin + "<a href=\"" + url + "?identifier=" + grupo.getIdentifier() +"\">" + linkText + "</a>" + end;
					}
				}
			}
			out.write(outText);
		} catch (IOException e) {
			logger.error("Error dibujando PrincipalTag",e);
			throw new JspException("Error dibujando PrincipalTag",e);
		} catch (Exception e) {
			logger.error("Error dibujando PrincipalTag",e);
			throw new JspException("Error dibujando PrincipalTag",e);
		}
		return super.SKIP_BODY;
	}

	/**
	 * @return the action
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param action the action to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the grupo
	 */
	public GrupoVO getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(GrupoVO grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return the i18nKey
	 */
	public String getI18nKey() {
		return i18nKey;
	}

	/**
	 * @param key the i18nKey to set
	 */
	public void setI18nKey(String key) {
		i18nKey = key;
	}

	/**
	 * @return the recursos
	 */
	public RecursoVO[] getRecursos() {
		return recursos;
	}

	/**
	 * @param recursos the recursos to set
	 */
	public void setRecursos(RecursoVO[] recursos) {
		this.recursos = recursos;
	}

}
