/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.adl.util;

import java.io.File;

import org.apache.log4j.Logger;

/**
 * 
 * Clase de utilidades para el RTE ADL integrado en visualizador.
 * 
 * @author fjespino
 *
 */
public class ADLUtils {
	
	private static String USER_DIR=null;

	public static final String getADLUserDir() {

		/*
		 * El directorio raíz para ADL es siempre el mismo. A partir de el, ADL
		 * se crea sus propios subdirectorios. Lo creo una sola vez y almaceno
		 * la ruta de forma estática.
		 */
		if (USER_DIR==null) {
			String dir = System.getProperty("java.io.tmpdir");
			if(dir!=null && !dir.endsWith(java.io.File.separator)) dir = dir+java.io.File.separator;
			if(dir!=null) dir = dir + "agrega-adlscorm";
			USER_DIR=dir;
			File ruta_userdir = new File(USER_DIR);
			if (!ruta_userdir.exists()) {
				ruta_userdir.mkdir();
			}
			ruta_userdir=null;
		}
		Logger.getLogger(ADLUtils.class).debug("Ruta para ficheros ADL = " + USER_DIR);
		return USER_DIR;
	}
	
}
