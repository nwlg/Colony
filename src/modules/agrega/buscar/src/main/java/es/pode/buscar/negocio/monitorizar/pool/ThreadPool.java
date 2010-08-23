/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.buscar.negocio.monitorizar.pool;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.pool.impl.GenericObjectPool;
import org.apache.log4j.Logger;

public class ThreadPool extends GenericObjectPool {
	
	private Logger logger = Logger.getLogger(this.getClass());
	private Properties props = null;
	
	   //First constructor.
	   public ThreadPool(ThreadObjectFactory objFactory) {
	      super(objFactory);
			InputStream is = null;
			try {
		//		Configuramos la clase de propiedades
				is = this.getClass().getResourceAsStream("/monitorizar.properties");
				props = new Properties();
				props.load(is);
				this.setMaxWait(Integer.parseInt(props.getProperty("maxWait")));
				this.setMinIdle(Integer.parseInt(props.getProperty("minIdle")));// Minimum number of objects allowed in the pool before the evictor thread spawns new objects
				this.setMaxIdle(Integer.parseInt(props.getProperty("maxIdle"))); // Maximum idle threads.
			    this.setMaxActive(Integer.parseInt(props.getProperty("maxActive"))); // Maximum active threads.
			    this.setTimeBetweenEvictionRunsMillis(Long.parseLong(props.getProperty("timeBetweenEvictionRunsMillis")));//Sets the number of milliseconds to sleep between runs of the idle object evictor thread.
			    //this.setMinEvictableIdleTimeMillis(Long.parseLong(props.getProperty("minEvictableIdleTimeMillis"))); //The minimum amount of time an object may sit idle in the pool before it is eligible for eviction by the idle object evictor
			    this.setTestOnBorrow(true); // Check if the thread is still valid.
			    // this.setMaxWait(3000);  Wait 3 second till a thread is available
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

	   //Second constructor.
	   public ThreadPool(ThreadObjectFactory objFactory, GenericObjectPool.Config config) {
	      super(objFactory, config);
	   }


	   public Object borrowObject() throws Exception {
		   logger.debug(" borrowing object..");
	      return super.borrowObject();
	   }
	   
	   public synchronized MultiSearcherThread[] borrowObjects(int num, int max) {
		   num = returnNumObjs(num, max);
		   MultiSearcherThread[] rtArr = new MultiSearcherThread[num];
	       for (int i = 0; i < num; i++) {
	    	   MultiSearcherThread rt; 
	    	   try {
	    		   rt = (MultiSearcherThread) borrowObject();
	    		   rtArr[i] = rt;
	    	   } catch (Exception e) {
	    		   logger.error(" borrowObjects failed.. ", e);
	    	   }
	      }
	      return rtArr;
	   }
	   
	   public int returnNumObjs(int num, int max) {
		   int numObjPool = super.getMaxActive() - super.getNumActive();
		   if(num > numObjPool) num = numObjPool;
		   if(num > max) num = max;
		   logger.debug(" returning NumObjs.." + num);
		   return num;
	   }

	   public void returnObject(Object obj) throws Exception {
		   logger.debug(" returning object.." + obj);
	       super.returnObject(obj);
	   }
	}
