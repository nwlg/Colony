/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.pode.empaquetador.tag.elementos;

import java.util.Collection;
import java.util.Iterator;
import java.util.ResourceBundle;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import es.pode.empaquetador.negocio.servicio.ArchivoVO;
import es.pode.empaquetador.negocio.servicio.GrupoVO;

/**
 * @author fjespino
 * 
 */
public class CheckBoxTag extends TagSupport {
	private static Logger logger = Logger.getLogger(CheckBoxTag.class);

	private final static String TIPO_AVANZADO = "Avanzado";

	private final static String TIPO_BASICO = "Basico";

	private final static String ACCION_NORMAL = "Normal";

	private Collection portapapeles = null;

	private Object grupo = null;

	private String tipoEmp = null;

	private String accion = null;

	private String name = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
	 */
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",
				pageContext.getRequest().getLocale());
		try {
			String id = null;
			if (grupo instanceof GrupoVO) {
				id = ((GrupoVO) grupo).getIdentifier();
			} else if (grupo instanceof ArchivoVO) {
				id = ((ArchivoVO) grupo).getNombre();
			}

			// Columna del checkbox
			out.write("<td valign=\"top\"  class=\"sin_b\">");
			out.write("<label for=\"" + id + "\" class=\"oculto\" >"
					+ i18n.getString("gestor_basico.seleccione") + "</label>");
			String disabled = null;
			if (ACCION_NORMAL.equalsIgnoreCase(accion)) {
				// No hay que desactivar ningun checkbox
				disabled = " ";
			} else {
				// Hay que desactivar el checkbox si grupo se encuentra en
				// portapapeles
				if (logger.isDebugEnabled()&&portapapeles!=null)
					logger.debug("grupo " + id + " : " + grupo
							+ " esta en portapapeles (" + portapapeles + " ? "
							+ contains(portapapeles, grupo));
				if (contains(portapapeles, grupo)) {
					disabled = " disabled=\"true\"";
				} else
					disabled = " ";
			}
			out.write("<input type=\"checkbox\" id=\"" + id + "\" " + disabled
					+ " name=\"" + name + "\" value=\"" + id + "\"/></td>");
		} catch (Exception e) {
			logger.error("Error al dibujar checkbox del elemento", e);
			throw new JspException("Error al dibujar checkbox del elemento", e);
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return SKIP_BODY;
	}

	/**
	 * @return the accion
	 */
	public String getAccion() {
		return accion;
	}

	/**
	 * @param accion
	 *            the accion to set
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}

	/**
	 * @return the grupo
	 */
	public Object getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo
	 *            the grupo to set
	 */
	public void setGrupo(Object grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return the portapapeles
	 */
	public Collection getPortapapeles() {
		return portapapeles;
	}

	/**
	 * @param portapapeles
	 *            the portapapeles to set
	 */
	public void setPortapapeles(Collection portapapeles) {
		this.portapapeles = portapapeles;
	}

	/**
	 * @return the tipoEmp
	 */
	public String getTipoEmp() {
		return tipoEmp;
	}

	/**
	 * @param tipoEmp
	 *            the tipoEmp to set
	 */
	public void setTipoEmp(String tipoEmp) {
		this.tipoEmp = tipoEmp;
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

	private boolean contains(Collection collection, Object obj) {
		boolean result = false;
		String identificador = null;
		if (obj instanceof GrupoVO) {
			GrupoVO grupo = (GrupoVO) obj;
			identificador = grupo.getIdentifier();
		} else if (obj instanceof ArchivoVO) {
			ArchivoVO archivo = (ArchivoVO) obj;
			identificador = archivo.getHref();
		}
		if (collection!=null && identificador != null) {
			for (Iterator it = collection.iterator(); it.hasNext() && !result;) {
				obj = it.next();
				if (obj instanceof GrupoVO) {
					GrupoVO grupo = (GrupoVO) obj;
					result = identificador.equals(grupo.getIdentifier());
				} else if (obj instanceof ArchivoVO) {
					ArchivoVO archivo = (ArchivoVO) obj;
					result = identificador.equals(archivo.getHref());
				}
			}
		}
		return result;
	}

}
