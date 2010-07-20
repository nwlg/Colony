/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.modificador.presentacion.idiomasBuscador;

//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.apache.log4j.Logger;

//import es.pode.indexador.negocio.servicios.busqueda.LocalizacionIdiomaVO;

public class IdiomasBuscadorSingleton {

	private static IdiomasBuscadorSingleton instance = null;
	private static HashMap mapaIdiomas = new HashMap(6); 
	private static final Logger logger = Logger.getLogger(IdiomasBuscadorSingleton.class);
	
	protected IdiomasBuscadorSingleton() {
		super();
	}
	
	public static IdiomasBuscadorSingleton getInstance() {
		if(instance == null ) {
			instance = new IdiomasBuscadorSingleton();
		}
		return instance;
	}
	
	public Collection obtenerIdiomas(String idioma) {
//		Collection idiomas = null;
//		if(logger.isDebugEnabled()) logger.debug("Recuperando combo de idiomas para sesion en idioma " + idioma);
//		idiomas = (Collection)mapaIdiomas.get(idioma);
//		if(idiomas == null) {
//			if(logger.isDebugEnabled()) logger.debug("El combo de idiomas en " + idioma + " no estaba cacheado");
//			try {
//				LocalizacionIdiomaVO[] idiomasArray = getSrvBuscadorService().obtenerIdiomasLocalizados(idioma);
//				if(idiomasArray==null) {
//					logger.error("No se han podido obtener los idiomas localizados a " + idioma);
//					idiomas = new ArrayList();
//				} else {
//					if(logger.isDebugEnabled()) logger.debug("Idiomas recuperados en " + idioma);
//					idiomas = Arrays.asList(idiomasArray);
//					mapaIdiomas.put(idioma, idiomas);
//				}
//			} catch (Exception e) {
//				logger.error("No se han podido obtener los idiomas localizados a " + idioma + " : " + e.getMessage());
//				if(logger.isDebugEnabled()) logger.debug(e);
//			}
//		}
		return null;
	}
	
	protected final es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService getSrvBuscadorService()
    throws java.lang.Exception
    {
	    String srvBuscadorServiceFile="importedServices.properties";	    
	    java.io.InputStream srvBuscadorServiceInputStream=IdiomasBuscadorSingleton.class.getClassLoader().getResourceAsStream(srvBuscadorServiceFile);
	    java.util.Properties srvBuscadorServiceProperties = new java.util.Properties();
	    srvBuscadorServiceProperties.load(srvBuscadorServiceInputStream);
	    String srvBuscadorServiceEndPointAddress="";
	    srvBuscadorServiceEndPointAddress=(String) srvBuscadorServiceProperties.get("srvBuscadorServicePort");
	    System.out.println("srvBuscadorServiceEndPointAddress del fichero --> " + srvBuscadorServiceEndPointAddress);
			es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorServiceService srvBuscadorService = new es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorServiceServiceLocator();                                                                                                                                                                                                                                                    
	    if (srvBuscadorServiceEndPointAddress.length()>0) 
			((es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorServiceServiceLocator)srvBuscadorService).setSrvBuscadorServiceEndpointAddress(srvBuscadorServiceEndPointAddress);				
		es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService port = srvBuscadorService.getSrvBuscadorService();	    
	    return port;
    }
	
}
