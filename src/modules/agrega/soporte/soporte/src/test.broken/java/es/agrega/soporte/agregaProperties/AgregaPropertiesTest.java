/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.agrega.soporte.agregaProperties;

import java.io.File;
import java.net.URL;
import java.util.Date;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

public class AgregaPropertiesTest extends TestCase {
	
	public static Logger log = Logger.getLogger(AgregaPropertiesTest.class);

	public void testGetProperties() 
	{
		String sImgApachePath = this.getPropertyApachePath();
		assertEquals(sImgApachePath, "/galeriaimg");
	}

	public void testChangeFile() 
	{
		try
		{
			String sImgApachePath = this.getPropertyApachePath();
			
			assertEquals(sImgApachePath, "/galeriaimg");
			
			Date fecha = new Date();
			if (log.isDebugEnabled())
				log.debug("Voy a cambiar la fecha del fichero a ["+fecha.getTime()+"]");
			
			URL url = AgregaPropertiesImpl.class.getResource("/"+
					AgregaPropertiesImpl.PROPERTIES_FILE_NAME+
					".properties");
			
			if (log.isDebugEnabled())
				log.debug("La ruta del fichero es ["+url.getFile()+"]");
			File file = new File(url.getFile());
			
			file.setLastModified(fecha.getTime());
			if (log.isDebugEnabled())
				log.debug("Cojo de nuevo la propiedad chequeando que ha cambiado la hora");
			sImgApachePath = this.getPropertyApachePath();
			assertEquals(sImgApachePath, "/galeriaimg");
		}
		catch (Exception ex)
		{
			log.error("Se ha producido una excepcion en testChangeFile", ex);
			ex.printStackTrace();
		}
		

	}
	
	private String getPropertyApachePath()
	{
		String sImgApachePath = AgregaPropertiesImpl.getInstance().getProperty(AgregaProperties.PROPERTY_IMAGE_APACHE_PATH);
		if (log.isDebugEnabled())
			log.debug("El valor de la propiedad ["+AgregaProperties.PROPERTY_IMAGE_APACHE_PATH+"] es [" + sImgApachePath+"]");
		return sImgApachePath;
		
	}
}
