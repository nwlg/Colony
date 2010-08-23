/* Agrega es una federaci�n de repositorios de objetos digitales educativos formada por todas las Comunidades Aut�nomas propiedad de Red.es. Este c�digo ha sido desarrollado por la Entidad P�blica Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a trav�s de la Secretar�a de Estado de Telecomunicaciones y para la Sociedad de la Informaci�n, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Informaci�n y de Convergencia con Europa y entre Comunidades Aut�nomas y Ciudades Aut�nomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 �Sociedad de la Informaci�n�

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.buscar.negocio.buscar.pool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import es.pode.buscar.negocio.buscar.servicios.LomEsVO;
import es.pode.buscar.negocio.buscar.servicios.ParamBusquedaSQIVO;
import es.pode.buscar.negocio.nodosSQI.servicio.NodoSQIVO;

public class MultiSearcherSQI {
	private static Logger logger = Logger.getLogger(MultiSearcherSQI.class);
	private static ThreadPool pool = new ThreadPool(new ThreadObjectSQIFactory());
	
	/**
	 * Este m�todo hace la llamada al m�todo buscarSQI en todos los hilos del pool. 
	 * @param parametros par�metros necesarios para hacer la llamada al m�todo 
	 * @param comunidades nodos sobre la federaci�n donde se va a hacer la llamada
	 * @param servicio Servicio sobre el cual se va a hacer la llamada
	 * @param maxWaitThread n�mero m�ximo de tiempo de espera del hilo.
	 * @param maxWaitPool n�mero m�ximo de tiempo de espera del pool.
	 * @return un array de VOs con el resultado del m�todo en todos los nodos de la federaci�n
	 * @throws Exception
	 */
	public static LomEsVO[] searchDocuments(ParamBusquedaSQIVO parametros,List nodosSQI, int maxWaitThread, int maxWaitPool) throws Exception{ 
        if (logger.isDebugEnabled()) 
    		logger.debug("MultiSearcherSQI - searchDocuments : Solicitud de hilos="+nodosSQI.size()+" hilos");
//        Invocamos la busqueda sobre todos los nodos
		List searched = search(parametros, nodosSQI, "", maxWaitThread, maxWaitPool);
		
		int ind = 0;
		int indNodosSQI = 0;
		LomEsVO[] resultado=null;
		List<LomEsVO> todos=new ArrayList(); 
//		Para cada nodo SQI
		for(int i = 0; i < ((List)searched.get(1)).size() ; i++ ){
			Object[] documentos = (Object[]) ((List)searched.get(1)).get(i);
			if (logger.isDebugEnabled()) 
    		    logger.debug("MultiSearcherSQI- searchDocuments: Los documentos miden ["+documentos.length+"]");
//			Me recorro todos los documentos resultado de la busqueda.
			
			if(documentos!=null && documentos.length > 0){
				for(int j = 0; j < documentos.length ; j++ ){
					
					if(documentos[j]!=null && 
									((LomEsVO[])documentos[j])!=null && 
										((LomEsVO[])documentos[j]).length>0){
						
                        if (logger.isDebugEnabled()) 
                        	logger.debug("MultiSearcherSQI- searchDocuments: Resultados devueltos="+((LomEsVO[])documentos[j]).length+". Se a�ade IP server="+((NodoSQIVO)nodosSQI.get(indNodosSQI)).getUrlServicio());
			    		for(int k=0; k < ((LomEsVO[])documentos[j]).length;k++){
			    			((LomEsVO[])documentos[j])[k].setNodo(((NodoSQIVO)nodosSQI.get(indNodosSQI)).getUrlServicio());
			    			todos.add(((LomEsVO[])documentos[j])[k]);
			    			
						}
					}
					if(documentos[j]!=null) {
                        if (logger.isDebugEnabled()) 
                            logger.debug("MultiSearcherSQI - searchDocuments : NodoSQI="+((NodoSQIVO)nodosSQI.get(indNodosSQI)).getNombreNodo()+" con IP WS="+((NodoSQIVO)nodosSQI.get(indNodosSQI)).getUrlServicio()+" N�mero resultados="+((LomEsVO[])documentos[j]).length);
                    }
					else {
                        if (logger.isDebugEnabled()) 
                            logger.debug("MultiSearcherSQI - searchDocuments : NodoSQI="+((NodoSQIVO)nodosSQI.get(indNodosSQI)).getNombreNodo()+" con IP WS="+((NodoSQIVO)nodosSQI.get(indNodosSQI)).getUrlServicio()+" No devuelve.");
                    }
					
					ind++;
					indNodosSQI++;
					
				}
			}else indNodosSQI++;
		}
		resultado=(LomEsVO[]) todos.toArray(new LomEsVO[todos.size()]);
		return resultado;
	}
	
	private static List search(Object parametros,List nodosSQI, String servicio, int maxWaitThread, int maxWaitPool) throws Exception{
		long start = System.currentTimeMillis();
		if(logger.isDebugEnabled())logger.debug("Start time millis ="+start);
		List retorno = new ArrayList();
		List peticionesDocumentos = new ArrayList();
		int numDocumentos = 0;
		int numObjExecute = 0;
		int numObjToExecute = nodosSQI.size();
//		MultiSearcherSQIThread
		Object[] rtArr = null;
		try{
				List lista = Arrays.asList(pool.borrowObjects(nodosSQI.size())); 
//				rtArr = pool.borrowObjects(nodosSQI.size()); 
				rtArr = lista.toArray(new Object[0]);
				if(rtArr!=null && rtArr.length > 0){
					NodoSQIVO[] nodos = (NodoSQIVO[])nodosSQI.toArray(new NodoSQIVO[0]);
					Object[] documentos = executor(rtArr, parametros, nodos, maxWaitThread, maxWaitPool);
					
					if (logger.isDebugEnabled()) 
                        logger.debug("MultiSearcherSQI- search: Los documentos decibidos del executor mide ["+documentos.length+"]");
					peticionesDocumentos.add(documentos);
					numDocumentos += documentos.length;
					numObjExecute += rtArr.length;
					numObjToExecute -= rtArr.length;
				}
				//if(logger.isDebugEnabled())logger.debug("N�mero de hilos ejecutados="+numObjExecute+" y n�mero de hilos por ejecutar="+numObjToExecute+" .Time millis ="+System.currentTimeMillis());
				
		} catch(Exception e) {
		    if(logger.isDebugEnabled())
			    logger.debug("Fallo en peticion executor, se retornan ="+rtArr.length+" hilos"); 
			for(int i = 0; i < rtArr.length; i++){
				try{
					pool.returnObject(rtArr[i]);
				}catch(Exception ex){
					logger.error("MultiSearcherSQI - executor ERROR: No se pudo retornar el hilo al pool despues de timeout de pool.",ex);
				}	
			}
	    	logger.error("MultiSearcherSQI - search ERROR: Pool fallido",e);
	    }
		long end = System.currentTimeMillis();
		retorno.add(String.valueOf(numDocumentos));
		retorno.add(peticionesDocumentos);
		if(logger.isDebugEnabled())
		    logger.debug("MultiSearcherSQI - search : Hilos terminados federada en =" + (end - start)+ " milisegundos, comienza obtenci�n de datos del pool");
		return retorno;
	}
	
	private static Object[] executor(Object[] rtArr, Object parametros, NodoSQIVO[] nodosSQI, int maxWaitThread, int maxWaitPool){
		Object[] result = new Object[rtArr.length];
		Object synObj = new Object();
		long startObjectPool = System.currentTimeMillis();
		if(logger.isDebugEnabled()) logger.debug("Numero de hilos a ejecuar: " + rtArr.length);
		
		/* Ejecuci�n de los hilos */
		for(int j = 0; j < rtArr.length ; j++ ){
			try{					//Deber�a ser url 
		        if(logger.isDebugEnabled()) {
				    logger.debug("MultiSearcherSQI - executor : Direccion="+nodosSQI[j].getUrlServicio());
                    logger.debug("Hilo " + j + " : " + rtArr[j]);
                }
//		        Ejecutamos el hilo con el contenido del nodo y los parametros de la consulta
		        ((MultiSearcherSQIThread)rtArr[j]).execute(nodosSQI[j], parametros);
			}
			catch(Exception e) {
				logger.error("MultiSearcherSQI - executor ERROR: Hilo fallido="+ nodosSQI[j].getUrlServicio(),e);	
			}
		}
		
		/* Recuperaci�n de las ejecuci�nes y devoluci�n de los hilos al pool */
		for(int i=0;i<rtArr.length;i++) {
			long startObject = System.currentTimeMillis();
			try {
				long tiempoHilos = System.currentTimeMillis() - startObjectPool;
				if(tiempoHilos <= maxWaitPool) { // No hemos sobrepasado el tiempo total de la ejecuci�n del conjunto de hilos
				
					while(!((MultiSearcherSQIThread)rtArr[i]).isDone()) {
						Thread.sleep(500L);
						long tiempoHilo = System.currentTimeMillis() - startObject;
						if(tiempoHilo >= maxWaitThread) { // Hemos sobrepasado el tiempo de un hilo 							
							logger.info("Hilo fuera de tiempo. Hilo: " + i + " " + rtArr[i].toString() + " Tiempo: " + tiempoHilo + " M�ximo de tiempo:" + maxWaitThread);
                        
							throw new NoSuchElementException("Hilo fuera de tiempo. Timeout waiting thread: " + maxWaitThread+" max wait thread miliseg.");
						} 
					}
					result[i] = ((MultiSearcherSQIThread)rtArr[i]).getResult();
				}
				else { // Hemos sobrepasado el tiempo total del conjunto de hilos
					logger.info("Conjunto de hilos fuera de tiempo. Hilo: " + i + " " + rtArr[i].toString() + " Tiempo hilos: " + tiempoHilos + " M�ximo de tiempo para el conjunto de hilos: " + maxWaitPool);
				}
									            
	            pool.returnObject(rtArr[i]);
			} 
			catch(Exception e) {
            	logger.error("MultiSearcherSQI - executor ERROR: Hilo fallido " + i + " " + rtArr[i].toString() + " " + e.getMessage() + " - " + e.getCause());
            	try{
					pool.returnObject(rtArr[i]);
				}catch(Exception ex){
					logger.error("MultiSearcherSQI - executor ERROR: No se pudo retornar el hilo " + rtArr[i].toString() + " al pool="+ nodosSQI[i].getUrlServicio(),e);
				}	
            }
		    if(logger.isDebugEnabled())
			    logger.debug("MultiSearcherSQI - executor : "+(System.currentTimeMillis() - startObject)+" Milisegundos en comunidad="+nodosSQI[i].getNombreNodo()+", direccion="+nodosSQI[i].getUrlServicio()+" servidor sesiones="+nodosSQI[i].getGestorSesion());
        }
		return result;
	}
}
