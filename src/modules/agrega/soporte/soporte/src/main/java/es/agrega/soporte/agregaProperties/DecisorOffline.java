/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.agrega.soporte.agregaProperties;

public class DecisorOffline {
	public static final String FILE = "/offline.properties";
	public static final String KEY = "offline";
	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DecisorOffline.class);
	
	public static boolean esOffline() {
		boolean result = false;
		java.net.URL file = DecisorOffline.class.getResource(FILE);
		logger.debug("Hay fichero offline.properties? : " + (file!=null));
		if(file!=null) {
			java.util.Properties props = new java.util.Properties();
			try {
				props.load(file.openStream());
				String property = props.getProperty(KEY);
				if("true".equalsIgnoreCase(property)) result=true;
			} catch (Exception e) {
				logger.debug("No se ha podido cargar el fichero offline.properties",e);
			}
		}
		return result;
	}
}
