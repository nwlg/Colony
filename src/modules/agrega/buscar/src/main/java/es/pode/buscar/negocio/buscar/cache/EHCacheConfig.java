/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.buscar.negocio.buscar.cache;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;

public class EHCacheConfig {
	
	private Properties props = null;
	private CacheManager cacheManager;
	private Cache hits;
	private Cache hitsLength;
	private Cache hitsSQI;
	private Cache hitsSQIAriadne;
	private Logger logger = Logger.getLogger(this.getClass());
	
	public EHCacheConfig(){
		
		InputStream is = null;
		try {
	//		Configuramos la clase de propiedades
			is = this.getClass().getResourceAsStream("/buscar.properties");
			props = new Properties();
			props.load(is);
	//		Configuramos la cache de hits
			cacheManager= CacheManager.create();
			hits = new Cache("hits", //name
					100, //maxElementsInMemory
					false, //overflowToDisk
					false, //eternal
					new Long(props.getProperty("segundosCaducidadHit")).longValue(),//tiempo de vida de los elementos en la cache
					new Long(props.getProperty("segundosCaducidadHit")).longValue());//tiempo de vida de los elementos desde su ultimo acceso o su ultima modificacion
			cacheManager.addCache(hits);
			
			hitsLength = new Cache("hitsLength", //name
					100, //maxElementsInMemory
					false, //overflowToDisk
					false, //eternal
					new Long(props.getProperty("segundosCaducidadHit")).longValue(),//tiempo de vida de los elementos en la cache
					new Long(props.getProperty("segundosCaducidadHit")).longValue());//tiempo de vida de los elementos desde su ultimo acceso o su ultima modificacion
			cacheManager.addCache(hitsLength);
			
			hitsSQI = new Cache("hitsSQI", //name
					100, //maxElementsInMemory
					false, //overflowToDisk
					false, //eternal
					new Long(props.getProperty("segundosCaducidadHit")).longValue(),//tiempo de vida de los elementos en la cache
					new Long(props.getProperty("segundosCaducidadHit")).longValue());//tiempo de vida de los elementos desde su ultimo acceso o su ultima modificacion
			cacheManager.addCache(hitsSQI);
			
			hitsSQIAriadne = new Cache("hitsSQIAriadne", //name
					100, //maxElementsInMemory
					false, //overflowToDisk
					false, //eternal
					new Long(props.getProperty("segundosCaducidadHit")).longValue(),//tiempo de vida de los elementos en la cache
					new Long(props.getProperty("segundosCaducidadHit")).longValue());//tiempo de vida de los elementos desde su ultimo acceso o su ultima modificacion
			cacheManager.addCache(hitsSQIAriadne);
			
		} catch (IOException e) {
			logger.error("ERROR: fichero no encontrado: buscar.properties",e);
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

	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}
	
	public Cache getHits() {
		return hits;
	}

	public void setHits(Cache hits) {
		this.hits = hits;
	}

	public Cache getHitsLength() {
		return hitsLength;
	}

	public void setHitsLength(Cache hitsLength) {
		this.hitsLength = hitsLength;
	}
	
	public Cache getHitsSQI() {
		return hitsSQI;
	}

	public void setHitsSQI(Cache hitsSQI) {
		this.hitsSQI = hitsSQI;
	}
	
	public boolean removeHitsCache() throws Exception {
		try{
			getHits().removeAll();
		}catch (Exception e){
			Exception exc = new Exception("SrvBuscarServiceImpl - borrarHitCache: ERROR: no se ha podido eliminar los hits de cache.",e);
			logger.error(exc);
			throw exc;
		}
		return true;
	}
	
	public boolean removeHitsLenghtCache() throws Exception {
		try{
			getHitsLength().removeAll();
		}catch (Exception e){
			Exception exc = new Exception("SrvBuscarServiceImpl - borrarHitCache: ERROR: no se ha podido eliminar los hits de cache taxonómica.",e);
			logger.error(exc);
			throw exc;
		}
		return true;
	}
	
	public boolean removeHitsSQICache() throws Exception {
		try{
			getHitsSQI().removeAll();
		}catch (Exception e){
			Exception exc = new Exception("SrvBuscarServiceImpl - borrarCacheSQI: ERROR: no se ha podido eliminar los hits de cache SQI.",e);
			logger.error(exc);
			throw exc;
		}
		return true;
	}
	
	public boolean removeHitsSQIAriadneCache() throws Exception {
		try{
			getHitsSQIAriadne().removeAll();
		}catch (Exception e){
			Exception exc = new Exception("SrvBuscarServiceImpl - borrarCacheSQIAriadne: ERROR: no se ha podido eliminar los hits de cache SQIAriadne.",e);
			logger.error(exc);
			throw exc;
		}
		return true;
	}
	
	public boolean removeHitCache(String hit) throws Exception {
		boolean idBorrado=false;
		try{
			if (getHits().isElementInMemory(hit)){
				if (logger.isDebugEnabled()){
					logger.debug("SrvBuscarServiceImpl - borrarHitCache: El ODE con identificador: " + hit+ "esta en cache");
				}
				idBorrado=getHits().remove(hit);
				if (logger.isDebugEnabled()){
					logger.debug("SrvBuscarServiceImpl - borrarHitCache: El ODE con identificador: " + hit+ "ha sido eliminado de cache correctamente");
				}
			}else{
				if (logger.isDebugEnabled()){
					logger.debug("SrvBuscarServiceImpl - borrarHitCache: El ODE con identificador: " + hit+ "no se encuentra en cache");
				}
			}
		}catch (Exception e){
			Exception exc = new Exception("SrvBuscarServiceImpl - borrarHitCache: ERROR: no se ha podido eliminar de cache el ODE con identificador: " + hit);
			logger.error(exc);
			throw exc;
		}
		return idBorrado;
	}

	public Cache getHitsSQIAriadne() {
		return hitsSQIAriadne;
	}

	public void setHitsSQIAriadne(Cache hitsSQIAriadne) {
		this.hitsSQIAriadne = hitsSQIAriadne;
	}
}
