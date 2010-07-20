/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.auditoria.negocio.servicios.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.log4j.Logger;
import es.pode.auditoria.negocio.servicios.InformeAgregacionFederadaVO;
import es.pode.auditoria.negocio.servicios.InformeCoberturaFederadoVO;
import es.pode.auditoria.negocio.servicios.InformeOdesIdiomaFederadoVO;
import es.pode.auditoria.negocio.servicios.InformeOdesPublicadosFederadaVO;
import es.pode.auditoria.negocio.servicios.ParametrosInformeFederadoVO;
//import es.pode.auditoria.negocio.servicios.SrvAuditoriaFederadaServicioImpl;
import es.pode.buscar.negocio.administrar.servicio.NodoVO;

//import es.pode.indexador.negocio.servicios.busqueda.DocumentosVO;

public class MultiSearcher {
	private static Logger logger = Logger.getLogger(MultiSearcher.class);
	
	private static ThreadPool pool = new ThreadPool(new ThreadObjectFactory());
	
	/**
	 * Este método hace la llamada al método nivelAgregacionFederado en todos los hilos del pool. 
	 * @param parametros parámetros necesarios para hacer la llamada al método 
	 * @param comunidades nodos sobre la federación donde se va a hacer la llamada
	 * @param servicio Servicio sobre el cual se va a hacer la llamada
	 * @param maxWaitThread número máximo de tiempo de espera del hilo.
	 * @param maxWaitPool número máximo de tiempo de espera del pool.
	 * @return un array de VOs con el resultado del método en todos los nodos de la federación
	 * @throws Exception
	 */
	public static InformeAgregacionFederadaVO[] searchNivelAgregacion(ParametrosInformeFederadoVO parametros,List comunidades, String servicio, int maxWaitThread, int maxWaitPool) throws Exception{ 
	
		ArrayList informeNivelAgregacion = new ArrayList();
        logger.info("MultiSearcher - searchNivelAgregacion : Solicitud de hilos="+comunidades.size()+" hilos");
		List searched = search(parametros, comunidades, servicio, maxWaitThread, maxWaitPool);
		logger.debug("searched "+searched);
		InformeAgregacionFederadaVO[] resultado = new InformeAgregacionFederadaVO[new Integer(searched.get(0).toString()).intValue()];
		logger.debug("resultado.length "+resultado.length);
		int ind = 0;
		int indComunidades = 0;
		logger.debug("searched.size() "+searched.size());
		logger.debug("Posicion 0 "+searched.get(0));
		logger.debug("Posicion 1 "+searched.get(1));
		
		for(int i = 0; i < ((List)searched.get(1)).size() ; i++ ){
			Object[] documento = (Object[])((List)searched.get(1)).get(i);
			logger.debug("documento "+documento);
			if(!(documento == null) && documento.length > 0)
			{
				for(int j = 0; j < documento.length ; j++ ){
					if(!(documento[j] == null))
					{
						
						informeNivelAgregacion.add((InformeAgregacionFederadaVO)documento[j]);
					}
				}
				
			}
	
		}
		logger.debug("informeNivelAgregacion.size() "+informeNivelAgregacion.size());
		resultado = (InformeAgregacionFederadaVO[])informeNivelAgregacion.toArray(new InformeAgregacionFederadaVO[0]);
		logger.debug("resultado "+resultado);
		return resultado;
	}
	
	/**
	 * Este método hace la llamada al método coberturaFederado en todos los hilos del pool. 
	 * @param parametros parámetros necesarios para hacer la llamada al método 
	 * @param comunidades nodos sobre la federación donde se va a hacer la llamada
	 * @param servicio Servicio sobre el cual se va a hacer la llamada
	 * @param maxWaitThread número máximo de tiempo de espera del hilo.
	 * @param maxWaitPool número máximo de tiempo de espera del pool.
	 * @return un array de VOs con el resultado del método en todos los nodos de la federación
	 * @throws Exception
	 */
	public static InformeCoberturaFederadoVO[] searchCoberturaCurricular(ParametrosInformeFederadoVO parametros,List comunidades, String servicio, int maxWaitThread, int maxWaitPool) throws Exception{ 
		
		ArrayList informeCoberturaCurricular = new ArrayList();
        logger.info("MultiSearcher - searchCoberturaCurricular : Solicitud de hilos="+comunidades.size()+" hilos");
		List searched = search(parametros, comunidades, servicio, maxWaitThread, maxWaitPool);
		logger.debug("searched "+searched);
		InformeCoberturaFederadoVO[] resultado = new InformeCoberturaFederadoVO[new Integer(searched.get(0).toString()).intValue()];
		logger.debug("resultado.length "+resultado.length);
		int ind = 0;
		int indComunidades = 0;
		logger.debug("searched.size() "+searched.size());
		logger.debug("Posicion 0 "+searched.get(0));
		logger.debug("Posicion 1 "+searched.get(1));
		
		for(int i = 0; i < ((List)searched.get(1)).size() ; i++ ){
			Object[] documento = (Object[])((List)searched.get(1)).get(i);
			logger.debug("documento "+documento);
			if(!(documento == null) && documento.length > 0)
			{
				for(int j = 0; j < documento.length ; j++ ){
					if(!(documento[j] == null))
					{
						
						informeCoberturaCurricular.add((InformeCoberturaFederadoVO)documento[j]);
					}
				}
				
			}
	
		}
		logger.debug("informeCoberturaCurricular.size() "+informeCoberturaCurricular.size());
		resultado = (InformeCoberturaFederadoVO[])informeCoberturaCurricular.toArray(new InformeCoberturaFederadoVO[0]);
		logger.debug("resultado "+resultado);
		return resultado;
	}
	
	/**
	 * Este método hace la llamada al método odesIdiomaFederado en todos los hilos del pool. 
	 * @param parametros parámetros necesarios para hacer la llamada al método 
	 * @param comunidades nodos sobre la federación donde se va a hacer la llamada
	 * @param servicio Servicio sobre el cual se va a hacer la llamada
	 * @param maxWaitThread número máximo de tiempo de espera del hilo.
	 * @param maxWaitPool número máximo de tiempo de espera del pool.
	 * @return un array de VOs con el resultado del método en todos los nodos de la federación
	 * @throws Exception
	 */
	public static InformeOdesIdiomaFederadoVO[] searchOdesIdioma(ParametrosInformeFederadoVO parametros,List comunidades, String servicio, int maxWaitThread, int maxWaitPool) throws Exception{ 
		
		ArrayList informeOdesIdioma = new ArrayList();
        logger.info("MultiSearcher - searchOdesIdioma : Solicitud de hilos=" + comunidades.size()+" hilos");
		List searched = search(parametros, comunidades, servicio, maxWaitThread, maxWaitPool);
		logger.debug("searched "+searched);
		InformeOdesIdiomaFederadoVO[] resultado = new InformeOdesIdiomaFederadoVO[new Integer(searched.get(0).toString()).intValue()];
		logger.debug("resultado.length "+resultado.length);
		int ind = 0;
		int indComunidades = 0;
		logger.debug("searched.size() "+searched.size());
		logger.debug("Posicion 0 "+searched.get(0));
		logger.debug("Posicion 1 "+searched.get(1));
		
		for(int i = 0; i < ((List)searched.get(1)).size() ; i++ ){
			Object[] documento = (Object[])((List)searched.get(1)).get(i);
			logger.debug("documento "+documento);
			if(!(documento == null) && documento.length > 0)
			{
				for(int j = 0; j < documento.length ; j++ ){
					if(!(documento[j] == null))
					{
						
						informeOdesIdioma.add((InformeOdesIdiomaFederadoVO)documento[j]);
					}
				}
				
			}
	
		}
		logger.debug("informeOdesIdioma.size() "+informeOdesIdioma.size());
		resultado = (InformeOdesIdiomaFederadoVO[])informeOdesIdioma.toArray(new InformeOdesIdiomaFederadoVO[0]);
		logger.debug("resultado "+resultado);
		return resultado;
	}


	/**
	 * Este método hace la llamada al método odesPublicadosFederado en todos los hilos del pool. 
	 * @param parametros parámetros necesarios para hacer la llamada al método 
	 * @param comunidades nodos sobre la federación donde se va a hacer la llamada
	 * @param servicio Servicio sobre el cual se va a hacer la llamada
	 * @param maxWaitThread número máximo de tiempo de espera del hilo.
	 * @param maxWaitPool número máximo de tiempo de espera del pool.
	 * @return un array de VOs con el resultado del método en todos los nodos de la federación
	 * @throws Exception
	 */
	public static InformeOdesPublicadosFederadaVO[] searchOdesPublicados(ParametrosInformeFederadoVO parametros,List comunidades, String servicio, int maxWaitThread, int maxWaitPool) throws Exception{ 
		
		ArrayList informeOdesPublicados = new ArrayList();
	    logger.info("MultiSearcher - searchOdesPublicados : Solicitud de hilos="+comunidades.size()+" hilos");
		List searched = search(parametros, comunidades, servicio, maxWaitThread, maxWaitPool);
		logger.debug("searched "+searched);
		InformeOdesPublicadosFederadaVO[] resultado = new InformeOdesPublicadosFederadaVO[new Integer(searched.get(0).toString()).intValue()];
		logger.debug("resultado.length "+resultado.length);
		int ind = 0;
		int indComunidades = 0;
		logger.debug("searched.size() "+searched.size());
		logger.debug("Posicion 0 "+searched.get(0));
		logger.debug("Posicion 1 "+searched.get(1));
		
		for(int i = 0; i < ((List)searched.get(1)).size() ; i++ ){
			Object[] documento = (Object[])((List)searched.get(1)).get(i);
			logger.debug("documento "+documento);
			if(!(documento == null) && documento.length > 0)
			{
				for(int j = 0; j < documento.length ; j++ ){
					if(!(documento[j] == null))
					{
						
						informeOdesPublicados.add((InformeOdesPublicadosFederadaVO)documento[j]);
					}
				}
				
			}
	
		}
		logger.debug("informeNivelAgregacion.size() "+informeOdesPublicados.size());
		resultado = (InformeOdesPublicadosFederadaVO[])informeOdesPublicados.toArray(new InformeOdesPublicadosFederadaVO[0]);
		logger.debug("resultado "+resultado);
		return resultado;
	}
	
	
	
	private static List search(Object parametros,List comunidades, String servicio, int maxWaitThread, int maxWaitPool) throws Exception{
		long start = System.currentTimeMillis();
		
		logger.debug("Start time millis ="+start);
		List retorno = new ArrayList();
		List peticionesDocumentos = new ArrayList();
		int numDocumentos = 0;
		int numObjExecute = 0;
		int numObjToExecute = comunidades.size();
		MultiSearcherThread[] rtArr = null;
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
		logger.debug("peticionesDocumentos "+peticionesDocumentos);
		logger.debug("peticionesDocumentos.size() "+peticionesDocumentos.size());
		return retorno;
	}
	
	private static Object[] executor(MultiSearcherThread[] rtArr, Object parametros, NodoVO[] comunidades, String servicio, int maxWaitThread, int maxWaitPool){
		Object[] result = new Object[rtArr.length];
		Object synObj = new Object();
		long startObjectPool = System.currentTimeMillis();
		logger.debug("Numero de hilos a ejecuar: " + rtArr.length);
		
		/* Ejecución de los hilos */
		for(int j = 0; j < rtArr.length ; j++ ){
			try{
		       
		        	logger.debug("MultiSearcher - executor : Direccion="+comunidades[j].getUrlWS()+" puerto="+comunidades[j].getPuerto()+" servicio="+servicio);
		        	logger.debug("Hilo " + j + " : " + rtArr[j]);
		        	
               
				rtArr[j].execute(comunidades[j].getUrlWS(), comunidades[j].getPuerto(), servicio, parametros, synObj);
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
				
					while(!(rtArr[i]).isDone()) {
						Thread.sleep(500L);
						long tiempoHilo = System.currentTimeMillis() - startObject;
						if(tiempoHilo >= maxWaitThread) { // Hemos sobrepasado el tiempo de un hilo 							
							logger.info("Hilo fuera de tiempo. Hilo: " + i + " " + rtArr[i].toString() + " Tiempo: " + tiempoHilo + " Máximo de tiempo:" + maxWaitThread);
                        
							throw new NoSuchElementException("Hilo fuera de tiempo. Timeout waiting thread: " + maxWaitThread+" max wait thread miliseg.");
						} 
					}
					result[i] = rtArr[i].getResult();
				}
				else { // Hemos sobrepasado el tiempo total del conjunto de hilos
					logger.info("Conjunto de hilos fuera de tiempo. Hilo: " + i + " " + rtArr[i].toString() + " Tiempo hilos: " + tiempoHilos + " Máximo de tiempo para el conjunto de hilos: " + maxWaitPool);
				}
									            
	            pool.returnObject(rtArr[i]);
			} 
			catch(Exception e) {
            	logger.error("MultiSearcher - executor ERROR: Hilo fallido " + i + " " + rtArr[i].toString() + " " + e.getMessage() + " - " + e.getCause());
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
