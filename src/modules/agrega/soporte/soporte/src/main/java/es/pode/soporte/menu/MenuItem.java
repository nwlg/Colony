/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.soporte.menu;

public class MenuItem implements java.io.Serializable
{
	private static final long serialVersionUID = 4307978396380378157L;
	private String id = "";
	private String link = null;
	private String linkConcatVar = null;
	private String target = null;
	private boolean selected = false;
	private String i18nKey = "";
	
	public MenuItem() 
	{
		super();
	}
	

	public String getLink() {
		return link;
	}
	public void setLink(String sLink) {
		if (sLink != null && !sLink.equals(""))
			this.link = sLink;
	}
	
	public void setRelativeLink(String sLink)
	{
		
		if (sLink != null && !sLink.equals(""))
		{
			// Si el link es una URL completa tiene http:// se deja como está.
//			String regexURL = new String ("^(http|https|ftp):\\/\\/.*");
			String regexURL = "^(http|https|ftp):\\/\\/.*";
			if (sLink.matches(regexURL))
					this.link = sLink;
			else if (sLink.indexOf('/') != 0)
				this.link = "/"+sLink;
			else 
				this.link = sLink;
		}
	}

	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setI18nKey(String i18nKey) {
		this.i18nKey = i18nKey;
	}

	public String getI18nKey() {
		return i18nKey;
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(id);
		sb.append("-");
		sb.append(link);
		sb.append("-");
		sb.append(selected);
		sb.append("-");
		sb.append(i18nKey);
		
		if (MenuController.logger.isDebugEnabled())
			MenuController.logger.debug(sb.toString());
		return sb.toString();
	}


	public String getTarget() {
		return target;
	}


	public void setTarget(String target) {
		this.target = target;
	}


	public boolean equals(Object o) 
	{
		return (this.getId().equals(((MenuItem)o).getId()));
	}


	public String getLinkConcatVar() {
		return linkConcatVar;
	}


	public void setLinkConcatVar(String linkConcatVar) {
		this.linkConcatVar = linkConcatVar;
	}
}
