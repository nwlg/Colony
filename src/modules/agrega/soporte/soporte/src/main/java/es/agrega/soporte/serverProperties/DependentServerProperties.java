/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.agrega.soporte.serverProperties;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Clase encargada de leer las propiedades dependeintes del servidor
 *
 * @author aleal
 *
 */
public class DependentServerProperties implements DependentServerPropertiesItf
{
	private static HashMap hash = null;
	private ResourceBundle dependentProperties = null;
	private String serverOn = null;
	
	
	private DependentServerProperties(Locale locale)
	{
		super();
		this.dependentProperties = ResourceBundle.getBundle(DependentServerPropertiesItf.PROPERTIES_FILE_NAME, locale);
		this.serverOn = this.dependentProperties.getString(DependentServerProperties.SERVER_ON);
	}

	public static DependentServerPropertiesItf getInstance(Locale locale)
    {
		if (hash == null)
	    	  hash = new HashMap(5);
	      Object obj = hash.get(locale);
	      if (obj == null)
	      {
	    	  if (locale == null)
	    		  locale = DependentServerProperties.DEFAULT_LOCALE;
	    	  obj = new DependentServerProperties(locale);
	    	  hash.put(locale, obj);
	      }
	      return (DependentServerPropertiesItf)obj;
    }

	public static DependentServerPropertiesItf getInstance()
    {
		return DependentServerProperties.getInstance(DEFAULT_LOCALE);
    }

	public String getProperty(String sKey) 
	{
		String propertyValue = null;
		if (sKey != null)
			propertyValue = this.dependentProperties.getString(this.getKey(sKey));
		return propertyValue;
	}
	
	public String getServerOn() 
	{
		return this.serverOn;
	}
	private String getKey(String sKey)
	{
		StringBuffer sb = new StringBuffer();
		sb.append(this.serverOn);
		sb.append(".");
		sb.append(sKey);
		return sb.toString();
	}
	
	public String getNodos() 
	{
		String propertyValue = null;		
		propertyValue = this.dependentProperties.getString(PROPERTY_NODOS);		
		return propertyValue;
	}
	
	public String getCCAAs() 
	{
		String propertyValue = null;		
		propertyValue = this.dependentProperties.getString(PROPERTY_CCAAS);		
		return propertyValue;
	}
	
	public String getUrlNodo() 
	{
		String propertyValue = null;		
		propertyValue = this.dependentProperties.getString(PROPERTY_URLNODO);		
		return propertyValue;
	}
}
