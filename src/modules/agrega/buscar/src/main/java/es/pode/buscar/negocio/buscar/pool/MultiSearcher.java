/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.buscar.negocio.buscar.pool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.buscar.negocio.buscar.servicios.ParametrosBusquedaAvanzadaVO;
import es.pode.buscar.negocio.buscar.servicios.ParametrosDocsCountVO;
import es.pode.buscar.negocio.buscar.servicios.ResultadosNodoCountVO;
import es.pode.buscar.negocio.federada.servicios.SrvBuscarFederadaServiceImpl;
import es.pode.indexador.negocio.servicios.busqueda.DocumentosVO;

public class MultiSearcher {
	private static Logger logger = Logger.getLogger(MultiSearcher.class);
	private static ThreadPool pool = new ThreadPool(new ThreadObjectFactory());
	
	/**
	 * Este método hace la llamada al método busquedaFederada en todos los hilos del pool. 
	 * @param parametros parámetros necesarios para hacer la llamada al método 
	 * @param comunidades nodos sobre la federación donde se va a hacer la llamada
	 * @param servicio Servicio sobre el cual se va a hacer la llamada
	 * @param maxWaitThread número máximo de tiempo de espera del hilo.
	 * @param maxWaitPool número máximo de tiempo de espera del pool.
	 * @return un array de VOs con el resultado del método en todos los nodos de la federación
	 * @throws Exception
	 */
	public static DocumentosVO[] searchDocuments(ParametrosBusquedaAvanzadaVO parametros,List comunidades, String servicio, int maxWaitThread, int maxWaitPool) throws Exception{ 
        if (logger.isDebugEnabled()) 
    		logger.debug("MultiSearcher - searchDocuments : Solicitud de hilos="+comunidades.size()+" hilos");
		List searched = search(parametros, comunidades, servicio, maxWaitThread, maxWaitPool);
		DocumentosVO[] resultado = new DocumentosVO[new Integer(searched.get(0).toString()).intValue()];
		int ind = 0;
		int indComunidades = 0;
		for(int i = 0; i < ((List)searched.get(1)).size() ; i++ ){
			Object[] documentos = (Object[]) ((List)searched.get(1)).get(i);
			if(documentos!=null && documentos.length > 0){
				for(int j = 0; j < documentos.length ; j++ ){
					if(!((NodoVO)comunidades.get(indComunidades)).getUrlWS().equals(((NodoVO)comunidades.get(0)).getUrlWS())&& documentos[j]!=null && ((DocumentosVO)documentos[j]).getResultados()!=null && ((DocumentosVO)documentos[j]).getResultados().length>0){
                        if (logger.isDebugEnabled()) 
			    		    Logger.getLogger(SrvBuscarFederadaServiceImpl.class).debug("SrvBuscarFederadaServiceImpl - handleBusquedaFederada: Resultados devueltos="+((DocumentosVO)documentos[j]).getResultados().length+". Se añade IP server="+((NodoVO)comunidades.get(indComunidades)).getUrl());
			    		for(int k=0; k < ((DocumentosVO)documentos[j]).getResultados().length;k++){
			    			((DocumentosVO)documentos[j]).getResultados()[k].setNodo(((NodoVO)comunidades.get(indComunidades)).getUrl());
						}
					}
					if(documentos[j]!=null) {
                        if (logger.isDebugEnabled()) 
                            logger.debug("MultiSearcher - searchDocuments : Comunidad="+((NodoVO)comunidades.get(indComunidades)).getNodo()+" con IP WS="+((NodoVO)comunidades.get(indComunidades)).getUrlWS()+" Número resultados="+((DocumentosVO)documentos[j]).getNumeroResultados());
                    }
					else {
                        if (logger.isDebugEnabled()) 
                            logger.debug("MultiSearcher - searchDocuments : Comunidad="+((NodoVO)comunidades.get(indComunidades)).getNodo()+" con IP WS="+((NodoVO)comunidades.get(indComunidades)).getUrlWS()+" No devuelve.");
                    }
					resultado[ind]=((DocumentosVO)documentos[j]);
					ind++;
					indComunidades++;
				}
			}else indComunidades++;
		}
		return resultado;
	}
	/**
	 * Este método hace la llamada al método buscarDocsNodoArbolCurricular en todos los hilos del pool. 
	 * @param parametros parámetros necesarios para hacer la llamada al método 
	 * @param nodos nodos sobre la federación donde se va a hacer la llamada
	 * @param servicio Servicio sobre el cual se va a hacer la llamada
	 * @param maxWaitThread número máximo de tiempo de espera del hilo.
	 * @param maxWaitPool número máximo de tiempo de espera del pool.
	 * @return un array de VOs con el resultado del método en todos los nodos de la federación
	 * @throws Exception
	 */
	public static ResultadosNodoCountVO[] searchDocsCountArbolCurricularFederada(ParametrosDocsCountVO parametros,NodoVO[] nodos, String servicio, int maxWaitThread, int maxWaitPool) throws Exception{ 
        if (logger.isDebugEnabled()) 
		    logger.debug("MultiSearcher - searchDocsCountArbolCurricularFederada : Solicitud de hilos="+nodos.length+" hilos");
		List searched = search(parametros, Arrays.asList(nodos), servicio, maxWaitThread, maxWaitPool);
		ResultadosNodoCountVO[] resultado = new ResultadosNodoCountVO[new Integer(searched.get(0).toString()).intValue()];
		int ind = 0;
		int indComunidades = 0;
		for(int i = 0; i < ((List)searched.get(1)).size() ; i++ ){
			Object[] documentos = (Object[]) ((List)searched.get(1)).get(i);
			if(documentos!=null && documentos.length > 0){
				for(int j = 0; j < documentos.length ; j++ ){
					if(documentos[j]!=null) {
                        if (logger.isDebugEnabled()) 
                            logger.debug("MultiSearcher - searchDocsCountArbolCurricularFederada : Comunidad="+nodos[indComunidades].getNodo()+" con IP WS="+nodos[indComunidades].getUrlWS()+" Número resultados="+((ResultadosNodoCountVO)documentos[j]).getNumeroResultados());
                    }
					else { 
                        if (logger.isDebugEnabled()) 
                            logger.debug("MultiSearcher - searchDocsCountArbolCurricularFederada : Comunidad="+nodos[indComunidades].getNodo()+" con IP WS="+nodos[indComunidades].getUrlWS()+" No devuelve.");
                    }
					resultado[ind]=((ResultadosNodoCountVO)documentos[j]);
					ind++;
					indComunidades++;
				}
			}else indComunidades ++;
		}
		return resultado;
	}
	
	private static List search(Object parametros,List comunidades, String servicio, int maxWaitThread, int maxWaitPool) throws Exception{
		long start = System.currentTimeMillis();
		if(logger.isDebugEnabled())logger.debug("Start time millis ="+start);
		List retorno = new ArrayList();
		List peticionesDocumentos = new ArrayList();
		int numDocumentos = 0;
		int numObjExecute = 0;
		int numObjToExecute = comunidades.size();
		Object[] rtArr = null;
		try{
				rtArr = pool.borrowObjects(comunidades.size());
				if(rtArr!=null && rtArr.length > 0){
					NodoVO[] nodos = new NodoVO[rtArr.length];
					for(int i = 0; i < rtArr.length;i++){
						nodos[i] = (NodoVO) comunidades.get(i);
					}
					Object[] documentos = executor(rtArr, parametros, nodos, servicio, maxWaitThread, maxWaitPool);
					peticionesDocumentos.add(documentos);
					numDocumentos += documentos.length;
					numObjExecute += rtArr.length;
					numObjToExecute -= rtArr.length;
				}
				//if(logger.isDebugEnabled())logger.debug("Número de hilos ejecutados="+numObjExecute+" y número de hilos por ejecutar="+numObjToExecute+" .Time millis ="+System.currentTimeMillis());
				
		} catch(Exception e) {
		    if(logger.isDebugEnabled())
			    logger.debug("Fallo en peticion executor, se retornan ="+rtArr.length+" hilos"); 
			for(int i = 0; i < rtArr.length; i++){
				try{
					pool.returnObject(rtArr[i]);
				}catch(Exception ex){
					logger.error("MultiSearcher - executor ERROR: No se pudo retornar el hilo al pool despues de timeout de pool.",ex);
				}	
			}
	    	logger.error("MultiSearcher - search ERROR: Pool fallido",e);
	    }
		long end = System.currentTimeMillis();
		retorno.add(String.valueOf(numDocumentos));
		retorno.add(peticionesDocumentos);
		if(logger.isDebugEnabled())
		    logger.debug("MultiSearcher - search : Hilos terminados federada en =" + (end - start)+ " milisegundos, comienza obtención de datos del pool");
		return retorno;
	}
	
	private static Object[] executor(Object[] rtArr, Object parametros, NodoVO[] comunidades, String servicio, int maxWaitThread, int maxWaitPool){
		Object[] result = new Object[rtArr.length];
		Object synObj = new Object();
		long startObjectPool = System.currentTimeMillis();
		if(logger.isDebugEnabled()) logger.debug("Numero de hilos a ejecuar: " + rtArr.length);
		
		/* Ejecución de los hilos */
		for(int j = 0; j < rtArr.length ; j++ ){
			try{					//Debería ser url 
		        if(logger.isDebugEnabled()) {
				    logger.debug("MultiSearcher - executor : Direccion="+comunidades[j].getUrlWS()+" puerto="+comunidades[j].getPuerto()+" servicio="+servicio);
                    logger.debug("Hilo " + j + " : " + rtArr[j]);
                }
		        ((MultiSearcherThread)rtArr[j]).execute(comunidades[j].getUrlWS(), comunidades[j].getPuerto(), servicio, parametros, synObj);
			}
			catch(Exception e) {
				logger.error("MultiSearcher - executor ERROR: Hilo fallido="+ comunidades[j].getUrl(),e);	
			}
		}
		
		/* Recuperación de las ejecuciónes y devolución de los hilos al pool */
		for(int i=0;i<rtArr.length;i++) {
			long startObject = System.currentTimeMillis();
			try {
				long tiempoHilos = System.currentTimeMillis() - startObjectPool;
				if(tiempoHilos <= maxWaitPool) { // No hemos sobrepasado el tiempo total de la ejecución del conjunto de hilos
				
					while(!((MultiSearcherThread)rtArr[i]).isDone()) {
						Thread.sleep(500L);
						long tiempoHilo = System.currentTimeMillis() - startObject;
						if(tiempoHilo >= maxWaitThread) { // Hemos sobrepasado el tiempo de un hilo 							
							logger.info("Hilo fuera de tiempo. Hilo: " + i + " " + rtArr[i].toString() + " Tiempo: " + tiempoHilo + " Máximo de tiempo:" + maxWaitThread);
                        
							throw new NoSuchElementException("Hilo fuera de tiempo. Timeout waiting thread: " + maxWaitThread+" max wait thread miliseg.");
						} 
					}
					result[i] = ((MultiSearcherThread)rtArr[i]).getResult();
				}
				else { // Hemos sobrepasado el tiempo total del conjunto de hilos
					logger.info("Conjunto de hilos fuera de tiempo. Hilo: " + i + " " + rtArr[i].toString() + " Tiempo hilos: " + tiempoHilos + " Máximo de tiempo para el conjunto de hilos: " + maxWaitPool);
				}
									            
	            pool.returnObject(rtArr[i]);
			} 
			catch(Exception e) {
            	logger.error("MultiSearcher - executor ERROR: Hilo fallido " + i + " de "+comunidades[i].getUrl()+" " + rtArr[i].toString() + " " + e.getMessage() + " - " + e.getCause());
            	try{
					pool.returnObject(rtArr[i]);
				}catch(Exception ex){
					logger.error("MultiSearcher - executor ERROR: No se pudo retornar el hilo " + rtArr[i].toString() + " al pool="+ comunidades[i].getUrl(),e);
				}	
            }
		    if(logger.isDebugEnabled())
			    logger.debug("MultiSearcher - executor : "+(System.currentTimeMillis() - startObject)+" Milisegundos en comunidad="+comunidades[i].getNodo()+", direccion="+comunidades[i].getUrlWS()+", con puerto="+comunidades[i].getPuerto()+" y servicio="+servicio);
        }
		return result;
	}
}
