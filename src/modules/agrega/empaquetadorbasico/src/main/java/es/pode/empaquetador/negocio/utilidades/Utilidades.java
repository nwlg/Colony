/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.empaquetador.negocio.utilidades;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.log4j.Logger;

import es.pode.empaquetador.negocio.servicio.AlmacenamientoException;
import es.pode.localizador.negocio.servicios.LocalizadorVO;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;

/**
 * Clase con metodos de uso comun a los servicios de empaquetacion.
 * 
 * @author fjespino
 *
 */
public class Utilidades {
	
	private Properties props = new Properties();
	private static Logger logger = Logger.getLogger(Utilidades.class);
	public static final String MANIFEST_NAME = "imsmanifest.xml";
	
	public Utilidades() {
		super();
		java.io.InputStream is = this.getClass().getResourceAsStream(
				"/empaquetador.properties");
		try {
			if (is != null)
				props.load(is);
		} catch (IOException e) {
			logger.error("No se pudo cargar el fichero empaquetador.properties");
		}
	}
	
	public String obtenerRutaTemporal(String identificador, String localizador, boolean crear) throws AlmacenamientoException {
		String resultado = null;
		String carpetaTemporal = props.getProperty("carpeta.temporal");
		
		if(carpetaTemporal == null ) {
			logger.error("No se pudo leer la carpeta temporal de empaquetador.properties");
			throw new NullPointerException("carpeta.temporal ausente en empaquetador.properties");
		}
		if(localizador == null ) {
			logger.error("localizador null en el calculo de la carpeta temporal");
			throw new NullPointerException("localizador null en el calculo de la carpeta temporal");
		}
		if(identificador == null ) {
			logger.error("identificador null en el calculo de la carpeta temporal");
			throw new NullPointerException("identificador null en el calculo de la carpeta temporal");
		}
		StringBuffer sb = new StringBuffer();
		sb.append(localizador).append(carpetaTemporal).append("/").append(identificador);
		resultado = sb.toString();
		if(logger.isDebugEnabled()) logger.debug("Carpeta temporal : " + resultado);
		if(crear) {
			if(logger.isDebugEnabled()) logger.debug("Comprobando si existe");
			File fTemporal = new File(resultado);
			if(!fTemporal.exists()) {
				if(logger.isDebugEnabled()) logger.debug(resultado + " no existe; creando");
				boolean creacion = fTemporal.mkdirs();
				if(!creacion) {
					logger.error("No se pudo crear la carpeta temporal");
				} else {
					String tmp = null;
					try {
						tmp = fTemporal.getCanonicalPath();
						resultado = tmp;
					} catch (Exception e) {
						logger.warn("No se pudo obtener la ruta canonica. Dejo la ruta normal");
					}
				}
		}
		}
		return resultado;
	}
	
	public String getProperty(String key) {
		return getProperty(key, null);
	}
	
	public String getProperty(String key, String defaultValue) {
		String resultado = null;
		if(logger.isDebugEnabled()) logger.debug("Recuperando propiedad " + key);
		try {
			resultado = props.getProperty(key, defaultValue);
		} catch (Exception e) {
			logger.error("Error al recuperar " + key);
		}
		return resultado;
	}
	
	public File obtenerRecursoClassPathAsFile(String name) {
		File resultado = null;
		URL url = null;
		try {
			url = this.getClass().getResource("/".concat(name));
			if(url==null) {
				logger.warn("El recurso " + name + " no se encuentra en el classpath");
			} else {
				resultado = new File(url.getFile());
				if(!resultado.exists()) {
					logger.error("El recurso " + name + " no existe en el classpath");
				}
			}
		} catch (Exception e) {
			logger.error("Error al recuperar recurso del classpath.",e);
		}
		return resultado;
	}
	
	public String getI18NMessage(String isoLanguage, String key) {
		
		Locale locale = new Locale(isoLanguage);
		
		String mensaje ="***";
		try {
			// En los tests no se puede acceder a la internacionalizacion: lo omito
			ResourceBundle i18n = ResourceBundle.getBundle("application-resources", locale);
			mensaje = i18n.getString(key);
		} catch (Exception e) {
			logger.error("No se pudo recuperar el mensaje internacionalizado",e);
		}
		return mensaje;
	}
	
	public void copiarEsquemas(String rutaDestino)
	throws Exception
	{
		/*
		 * Copiamos los esquemas XSD a la carpeta del ODE
		 */
		File ficheroNuevo = new File(rutaDestino);
		File ficheroViejo = new File(getProperty("carpeta.schema"));
		
		if (ficheroViejo.exists()) {
			logger.debug("vamos a copiar el esquema");
			UtilesFicheros.copiar(ficheroViejo, ficheroNuevo);
		} else {
			logger.error("El fichero origen no existe");
			throw new AlmacenamientoException("El fichero origen "
					+ ficheroViejo.getName() + " no existe en la ruta "
					+ ficheroViejo.getPath());
		}

	}
	
	public java.io.File crearCarpetaSeguro(LocalizadorVO localizador,
			String nombre) {
		java.io.File destino = new java.io.File(localizador.getPath(), nombre);
		boolean creada = destino.mkdirs();
		int contador = 1;
		while (!creada && contador < 100) {
			java.io.File nuevoIntento = new java.io.File(localizador.getPath(),
					nombre + "_" + String.valueOf(contador));
			logger.warn("La carpeta " + destino.getPath()
					+ " ya existe. Intento la creacion de " + nuevoIntento);
			destino = nuevoIntento;
			creada = destino.mkdirs();
			contador++;
		}
		return destino;
	}
	
	public String nombreSinExtension(String nombre) {
		String result = null;
		if(nombre !=null) {
			int index = nombre.lastIndexOf('.');
			if(index>1) {
				String sub = nombre.substring(0, index);
				result = sub;
			} else result = nombre;
		}
		return result;
	}
	
	public DataHandler serializarExportado(String valorRetorno) {
		File fichero = new File(valorRetorno);
		FileDataSource fds = new FileDataSource(fichero);
		DataHandler dh = new DataHandler(fds);
//		logger.debug("Borro el archivo " + valorRetorno);
//		fichero.deleteOnExit();
//		boolean borrar = fichero.delete();
//		logger.debug("Resultado del borrado = " + borrar);
		return dh;
	}
}
