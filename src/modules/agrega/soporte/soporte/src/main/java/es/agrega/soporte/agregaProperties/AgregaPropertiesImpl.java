/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
/**
 * 
 */
package es.agrega.soporte.agregaProperties;

import java.util.Date;
import java.util.ResourceBundle;
//import java.io.File;
//import java.net.URL;

import org.apache.log4j.Logger;

/**
 * @author aleal
 *
 */
public class AgregaPropertiesImpl implements AgregaProperties {

	private ResourceBundle properties = null;
	private static AgregaProperties agregaProperties = null;
	private static Date fecha = null;
	
	//private static final String PROPERTIES_EXT=".properties";
	
	private static Logger log = Logger.getLogger(AgregaPropertiesImpl.class);
	
	private AgregaPropertiesImpl()
	{
		super();
		properties = ResourceBundle.getBundle(AgregaProperties.PROPERTIES_FILE_NAME);
		AgregaPropertiesImpl.fecha = new Date();
		if (log.isDebugEnabled())
			log.debug("Se han cargado los properties correctamente");
	}

	public static AgregaProperties getInstance()
    {
		if (AgregaPropertiesImpl.agregaProperties == null)
		{
			AgregaPropertiesImpl.agregaProperties = new AgregaPropertiesImpl();
		}
		/*
		 * Con este código cualquier cambio que se realice en el fichero agrega.properties en tiempo de ejecución se recogería dinámicamente
		  if (AgregaPropertiesImpl.agregaProperties == null || AgregaPropertiesImpl.isFileChanged())
		  {
			  	if (log.isDebugEnabled() && AgregaPropertiesImpl.fecha == null)
			  		log.debug("Primera instancia");
			  	else if (log.isDebugEnabled() && AgregaPropertiesImpl.fecha != null )
					log.debug("Ha cambiado la fecha FECHA["+AgregaPropertiesImpl.fecha.getTime()+"]");
			  AgregaPropertiesImpl.agregaProperties = new AgregaPropertiesImpl();
		  }
		  */
	      return AgregaPropertiesImpl.agregaProperties;
    }

	/* (non-Javadoc)
	 * @see es.agrega.soporte.agregaProperties.AgregaProperties#getProperty(java.lang.String)
	 */
	public String getProperty(String sKey) 
	{
		if (log.isDebugEnabled())
			log.debug("Se va a devolver el valor de la propiedad["+sKey+"]");
		return this.properties.getString(sKey);
	}
	/*
	private static boolean isFileChanged()
	{
		if (log.isDebugEnabled())
			log.debug("Se va chequear si el fichero ha cambiado");
		URL url = AgregaPropertiesImpl.class.getResource("/"+
									AgregaPropertiesImpl.PROPERTIES_FILE_NAME+
									AgregaPropertiesImpl.PROPERTIES_EXT);
		if (log.isDebugEnabled())
			log.debug("La ruta del fichero es ["+url.getFile()+"]");
		File file = new File(url.getFile());
		long lastModified = file.lastModified();
		if (log.isDebugEnabled())
			log.debug("La fecha del ultimo cambio fue ["+AgregaPropertiesImpl.fecha.getTime()+"] y la fecha actual del fichero es ["+lastModified+"]");
		
		return (lastModified != AgregaPropertiesImpl.fecha.getTime());
	}
	*/

}
