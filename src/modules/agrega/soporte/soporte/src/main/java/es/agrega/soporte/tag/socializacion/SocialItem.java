/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.agrega.soporte.tag.socializacion;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Attribute;
import org.jdom.Element;

public class SocialItem implements java.io.Serializable
{

	private static final long serialVersionUID = 7404055177410409474L;

	protected static Log logger = LogFactory.getLog(SocialItem.class); 
	
	public static final String KEY_XML_ID_TAG 	= SocialTag.getPropertyValue("tag_id");
	public static final String KEY_XML_NAME_TAG	= SocialTag.getPropertyValue("tag_name");
	public static final String KEY_XML_URL_TAG 	= SocialTag.getPropertyValue("tag_url");
	
	public static final String KEY_TARGET_SELF 	= SocialTag.getPropertyValue("target_self");
	public static final String KEY_DELICIOUS 	= SocialTag.getPropertyValue("target_delicious");
	
	
	private String id = "";
	private String name = "";
	private String link = null;
	private String target = null;
	private String i18nKey = "";	
	
	public SocialItem(Element el, String sTarget, String sURL)
	{
		this.setTarget(sTarget);
		this.parsingSocialItem(el,sURL);
	}
	
	public String getI18nKey() {
		return i18nKey;
	}
	public void setI18nKey(String key) {
		if (isChangeable(key))
			i18nKey = key;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		if (isChangeable(id))
			this.id = id;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		if (isChangeable(link))
			this.link = link;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if (isChangeable(name))
			this.name = name;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		if (isChangeable(target))
			this.target = target;
	}
	
	private void parsingSocialItem(Element el,String sURL)
	{
		   Iterator it = SocialTag.checkList(el.getAttributes());
		   if (it != null)
		   {
			   while (it.hasNext())
			   {
				   Attribute attr = (Attribute)it.next();				   
				   
				   if (attr.getName().equals(SocialTag.KEY_XML_I18N_TAG))
				   {
					   //Aqui no hacemos nada de momento
				   }
				   else if (attr.getName().equals(SocialTag.KEY_XML_TARGET_TAG))
				   {				   
					   this.setTarget(attr.getValue());
					   if (logger.isDebugEnabled())
						   logger.debug("El target es ["+this.getTarget()+"]");
				   }
				   else if (attr.getName().equals(SocialItem.KEY_XML_ID_TAG))
				   {
					   this.setId(attr.getValue());
					   if (logger.isDebugEnabled())
						   logger.debug("El ID es ["+this.getId()+"]");
				   }
				   else if (attr.getName().equals(SocialItem.KEY_XML_NAME_TAG))
				   {
					   this.setName(attr.getValue());
					   if (logger.isDebugEnabled())
						   logger.debug("El Name es ["+this.getName()+"]");
				   }
				   else if (attr.getName().equals(SocialItem.KEY_XML_URL_TAG))
				   {				   
					 this.setLink(attr.getValue() + sURL);
					   if (logger.isDebugEnabled())
						   logger.debug("El Link es ["+this.getLink()+"]");
				   }
			   }
		   }
	}
	
	private boolean isChangeable(Object oValue)
	{
		return (oValue != null && !oValue.equals(""));
	}	
	

}
