/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.negocio.cambios.configuracion;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * Wrapper para obtener una propiedad del fichero modificador.properties. Esta
 * clase se registrara como singleton en el contexto de spring.
 * 
 * @author fjespino
 * 
 */
public class ModificadorProperties {
	private static Properties props = null;
	private static Logger logger = Logger.getLogger(ModificadorProperties.class);

	public ModificadorProperties() {
		if(props==null) {
			props = new Properties();
			InputStream is = this.getClass().getResourceAsStream("/modificador.properties");
			if(is==null) {
				logger.error("No se pudo abrir modificador.properties para lectura");
			} else {
				try {
					props.load(is);
				} catch (IOException e) {
					logger.error("No se pudo abrir modificador.properties para lectura");
				} finally {
					try {
						is.close();
					} catch (Exception e) {
						// No hacer nada
					}
				}
			}
		}
	}
	
	public String getProperty(String key) {
		String resultado = null;
		if(props!=null) {
			resultado = props.getProperty(key);
		} else logger.error("El objeto de propiedades no esta instanciado");
		if(resultado==null) logger.error("No se ha encontrado la propiedad " + key);
		if(logger.isDebugEnabled()) logger.debug("Propiedad recuperada " + key +" = " + resultado);
		return resultado;
	}
}
