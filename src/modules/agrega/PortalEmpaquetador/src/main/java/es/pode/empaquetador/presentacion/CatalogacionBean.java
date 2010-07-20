/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.empaquetador.presentacion;

import java.io.Serializable;

public class CatalogacionBean implements Serializable {
	private String identifier = null;
	private String href = null;
	/**
	 * @return the href
	 */
	public String getHref() {
		return href;
	}
	/**
	 * @param href the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}
	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}
	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public String toString() {
		return (new StringBuffer()).append("CatalogacionBean[identifier="+identifier+":href="+href+"]").toString();
	}
	
	public boolean equals(Object o) {
		boolean result = false;
		if (o instanceof CatalogacionBean) {
			CatalogacionBean cb = (CatalogacionBean) o;
			boolean hrefResult = false;
			boolean identifierResult = false;
			if(cb.getHref()==href || (href!=null && href.equals(cb.getHref()))) hrefResult=true;
			if(cb.getIdentifier()==identifier || (identifier!=null && identifier.equals(cb.getIdentifier()))) identifierResult=true;
			result = hrefResult && identifierResult;
		}
		return result;
	}
}
