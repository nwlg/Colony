/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.oaipmh.negocio.resumptionToken;

import java.io.IOException;
import java.io.InputStream;

import java.util.Date;
import java.util.Properties;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

import es.pode.oaipmh.negocio.servicios.ResumptionTokenCacheHit;
import es.pode.oaipmh.soporte.OAIPMHProperties;
import es.pode.soporte.utiles.date.DateManager;

public class ResumptionTokenManager {
	
	private Properties props = null;
	private CacheManager cacheManager;
	private Cache resumptionToken;	
	private Logger logger = Logger.getLogger(this.getClass());
	
	public static final String FROM = "From";
	public static final String TO = "to";	
	public static final String PAG = "pag";	
	
	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
	
	public Cache getResumptionToken() {
		return resumptionToken;
	}

	public void setResumptionToken(Cache resumptionToken) {
		this.resumptionToken = resumptionToken;
	}	
	
	public ResumptionTokenManager()
	{
			
		InputStream is = null;
		try {
	//		Configuramos la clase de propiedades
			is = this.getClass().getResourceAsStream("/oaiPmh.properties");
			props = new Properties();
			props.load(is);
	//		Configuramos la cache de resumption token
			cacheManager= CacheManager.create();
			resumptionToken = new Cache("resumptionToken", //name
					100, //maxElementsInMemory
					false, //overflowToDisk
					false, //eternal
					new Long(props.getProperty("segundosCaducidad")).longValue(),//tiempo de vida de los elementos en la cache
					new Long(props.getProperty("segundosCaducidad")).longValue());//tiempo de vida de los elementos desde su ultimo acceso o su ultima modificacion
			cacheManager.addCache(resumptionToken);			
			
		} catch (IOException e) {
			logger.error("ERROR: Accediendo a la cache manager",e);
			throw new RuntimeException(e);
		} finally {
			if( is != null ) {
				try {
					is.close();
				} catch (IOException e) {
					logger.error(e);
				}
			}
		}
	}		
	
	public Element devuelveElementoResumptionToken(String identificador) throws Exception	{
		
		Element elemento = null;
		if (logger.isDebugEnabled())logger.debug("comprobarIdResumptionToken-- Buscando en cache con identificador["+identificador+"]");
		elemento = this.getResumptionToken().get(identificador);		
		return elemento;
		
	}
	
	public String devuelveClaveResumptionToken() throws Exception
	{		
		return(String.valueOf(System.currentTimeMillis()));		
    	
	}
	
	public ResumptionTokenCacheHit generateFirstResumptionToken (String idquery, String idConsulta, Integer numResultadosTotales) throws Exception
	{
//		No habia resumption token anterior	
		
		//Declaracion de variables
		//Numero maximo de resultados por pagina
		Integer numMaxPaginaInteger = new Integer(OAIPMHProperties.getPropertyValue(OAIPMHProperties.NUM_RESULT_PAG));				
		int numMaxPaginaInt = numMaxPaginaInteger.intValue();		
		ResumptionTokenCacheHit tokenCacheHit = new ResumptionTokenCacheHit();
		Date fechaActual = new Date();			
		long tiempoExpiracion = new Long(props.getProperty("tiempoExpiracion")).longValue();
		
//		Se genera un identificador de resumption token porque hay una nueva pagina
		String claveToken = devuelveClaveResumptionToken();		

		//Se rellena el vo
		tokenCacheHit.setDesde(new Integer(numMaxPaginaInt));
		tokenCacheHit.setHasta(new Integer(numMaxPaginaInt+(numMaxPaginaInt-1)));			
		tokenCacheHit.setFechaExpiracion(DateManager.dateToCalendar(new Date(fechaActual.getTime() + tiempoExpiracion)));
		tokenCacheHit.setIdConsulta(idConsulta);
		tokenCacheHit.setIdQuery(idquery);
		tokenCacheHit.setIdResumptionToken(claveToken);	
		
		if (logger.isDebugEnabled()) logger.debug("generateFirstResumptionToken-- El vo de resumptionTodenCacheHit tiene los siguientes valores:" +
				"IdQuery: ["+tokenCacheHit.getIdQuery()+"], " +
				"Desde: ["+tokenCacheHit.getDesde()+"], " +
				"Hasta: ["+tokenCacheHit.getHasta()+"], " +
				"FechaExpiracion: ["+tokenCacheHit.getFechaExpiracion()+"], " +
				"IdConsulta: ["+tokenCacheHit.getIdConsulta()+"], " +
				"IdResumptionToken: ["+tokenCacheHit.getIdResumptionToken()+"]");	
		this.getResumptionToken().put(new Element(claveToken,tokenCacheHit));		
		
		return tokenCacheHit;
	}
	
	public ResumptionTokenCacheHit generateNextResumptionToken(ResumptionTokenCacheHit resumptionTokenOld, Integer numResultadosTotales) throws Exception
	{
		//Declaracion de variables
		ResumptionTokenCacheHit tokenCacheHit = new ResumptionTokenCacheHit();
		Date fechaActual = new Date();			
		long tiempoExpiracion = new Long(props.getProperty("tiempoExpiracion")).longValue();		
		
		//Numero maximo de resultados por pagina		
		Integer numMaxPaginaInteger = new Integer(OAIPMHProperties.getPropertyValue(OAIPMHProperties.NUM_RESULT_PAG));				
		int numMaxPaginaInt = numMaxPaginaInteger.intValue();	
		
//			Se calcula el hasta
		Integer hasta = new Integer(resumptionTokenOld.getHasta().intValue() + numMaxPaginaInt);
			
			if(hasta.intValue() <= (numResultadosTotales.intValue()-1))
			{
//				Se genera un identificador de resumption token porque hay una nueva pagina
				String claveToken = devuelveClaveResumptionToken();

				if (logger.isDebugEnabled()) logger.debug("generateNextResumptionToken-- El valor de la claveToken es ["+claveToken+"]");
				//Se construye el vo de resumptionTokenCacheHit		
				tokenCacheHit.setDesde(new Integer(resumptionTokenOld.getHasta().intValue() + 1));
				tokenCacheHit.setHasta(hasta);			
				tokenCacheHit.setFechaExpiracion(DateManager.dateToCalendar(new Date(fechaActual.getTime() + tiempoExpiracion)));
				tokenCacheHit.setIdConsulta(resumptionTokenOld.getIdConsulta());
				tokenCacheHit.setIdQuery(resumptionTokenOld.getIdQuery());
				tokenCacheHit.setIdResumptionToken(claveToken);				
				
				if (logger.isDebugEnabled()) logger.debug("generateNextResumptionToken-- El vo de resumptionTodenCacheHit tiene los siguientes valores:" +
															"IdQuery: ["+tokenCacheHit.getIdQuery()+"], " +
															"Desde: ["+tokenCacheHit.getDesde()+"], " +
															"Hasta: ["+tokenCacheHit.getHasta()+"], " +
															"FechaExpiracion: ["+tokenCacheHit.getFechaExpiracion()+"], " +
															"IdConsulta: ["+tokenCacheHit.getIdConsulta()+"], " +
															"IdResumptionToken: ["+tokenCacheHit.getIdResumptionToken()+"]");	
				this.getResumptionToken().put(new Element(claveToken,tokenCacheHit));
			}
			else
				tokenCacheHit = null;
		
		
		//Se retorna el vo del resumptionToken
		return tokenCacheHit;
	}

}
