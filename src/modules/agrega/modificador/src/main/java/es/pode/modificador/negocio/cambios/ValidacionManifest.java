/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.negocio.cambios;

import javax.xml.rpc.ServiceException;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;

import es.pode.modificador.negocio.servicio.SrvHerramientaModificacionBase;
import es.pode.parseadorXML.castor.Manifest;
import es.pode.validador.negocio.servicio.ErrorParseoVO;
import es.pode.validador.negocio.servicio.SrvValidadorService;
import es.pode.validador.negocio.servicio.ValidaVO;

public class ValidacionManifest implements Cambio {

	private Logger logger = Logger.getLogger(this.getClass());

	
	public boolean ejecutar(Manifest manifest, Appender informe, String path) {
		boolean result = false;
		if(logger.isDebugEnabled()) logger.debug("Añadiendo appender para generar fichero de traza");
		logger.addAppender(informe);
		SrvValidadorService validador = null;
		try {
			validador = getSrvValidadorService();
		
			logger.info("Iniciando validacion de " + path);
			ValidaVO resultado = validador.validarCargaOde(path);
			if(resultado.getEsValidoManifest().booleanValue()) {
				logger.info("La validación del ode " + path + " se ha terminado con éxito");
				result = true;
			} else {
				logger.error("Se han encontrado errores de validación : " + resultado.getResultadoValidacion());
				if(resultado.getErrores()!=null && resultado.getErrores().length>0) {
					String errores = formatearErrores(resultado.getErrores());
					logger.error("El detalle de los errores es:\n" + errores);
				}
			}
		} catch (ServiceException e) {
			logger.fatal("No se ha podido obtener una referencia al servicio de validación");
		} catch (Exception e) {
			logger.fatal("Error inesperado al validar " + path);
			if(logger.isDebugEnabled()) logger.debug(e);
		} finally {
			// Quito el appender del logger
			logger.removeAppender(informe);
		}
		return result;
	}

	/**
	 * 
	 * Genera un mensaje de error con el fomato:
	 * 
	 * L=#, C=# : xerces error message
	 * 
	 * @param errores
	 * @return
	 */
	private String formatearErrores(ErrorParseoVO[] errores) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<errores.length;i++) {
			sb.append("linea=").append(errores[i].getLinea().intValue()).append(
					", columna=").append(errores[i].getColumna().intValue()).append(
					" : ").append(errores[i].getMensaje()).append("\n");
		}
		return sb.toString();
	}
	
	protected final es.pode.validador.negocio.servicio.SrvValidadorService getSrvValidadorService()
			throws java.lang.Exception {
		String srvValidadorServiceFile = "importedServices.properties";
		java.io.InputStream srvValidadorServiceInputStream = SrvHerramientaModificacionBase.class
				.getClassLoader().getResourceAsStream(srvValidadorServiceFile);
		java.util.Properties srvValidadorServiceProperties = new java.util.Properties();
		srvValidadorServiceProperties.load(srvValidadorServiceInputStream);
		String srvValidadorServiceEndPointAddress = "";
		srvValidadorServiceEndPointAddress = (String) srvValidadorServiceProperties
				.get("srvValidadorServicePort");
		logger.debug("srvValidadorServiceEndPointAddress del fichero --> "
				+ srvValidadorServiceEndPointAddress);
		es.pode.validador.negocio.servicio.SrvValidadorServiceService srvValidadorService = new es.pode.validador.negocio.servicio.SrvValidadorServiceServiceLocator();
		if (srvValidadorServiceEndPointAddress.length() > 0)
			((es.pode.validador.negocio.servicio.SrvValidadorServiceServiceLocator) srvValidadorService)
					.setSrvValidadorServiceEndpointAddress(srvValidadorServiceEndPointAddress);
		es.pode.validador.negocio.servicio.SrvValidadorService port = srvValidadorService
				.getSrvValidadorService();
		return port;
	}
	
}
