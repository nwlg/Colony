/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
package es.pode.buscar.negocio.monitorizar.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.buscar.negocio.monitorizar.dominio.EstadoNodoVO;

public class MultiSearcher {
	private static Logger logger = Logger.getLogger(MultiSearcher.class);
	private static ThreadPool pool = new ThreadPool(new ThreadObjectFactory());
	
	/**
	 * Este método hace la llamada al método obtenerEstado en todos los hilos del pool. 
	 * @param parametros parámetros necesarios para hacer la llamada al método 
	 * @param comunidades nodos sobre la federación donde se va a hacer la llamada
	 * @param servicio Servicio sobre el cual se va a hacer la llamada
	 * @param maxWaitThread número máximo de tiempo de espera del hilo.
	 * @param maxWaitPool número máximo de tiempo de espera del pool.
	 * @return un array de VOs con el resultado del método en todos los nodos de la federación
	 * @throws Exception
	 */
	public static EstadoNodoVO[] search(NodoVO[] listaNodos, int maxNumObjPool, int maxWaitThread, int maxWaitPool) throws Exception{
		List peticiones = new ArrayList();
		for(int i = 0; i < listaNodos.length; i++){
			for (int j = 0; j < listaNodos[i].getServicio().length; j++){
				EstadoNodoVO estadoNodo = new EstadoNodoVO();
				estadoNodo.setNombreServicio(listaNodos[i].getServicio()[j].getNombre());
				estadoNodo.setDescripcionServicio(listaNodos[i].getServicio()[j].getDescripcion());
				estadoNodo.setNodo(listaNodos[i].getNodo());
				estadoNodo.setUrlWS(getAdress(listaNodos[i].getUrlWS(), listaNodos[i].getPuerto(), listaNodos[i].getServicio()[j].getUrl()));
				estadoNodo.setEstado("estadoServicio.INACTIVO");
				peticiones.add(estadoNodo);
			}
		}
		
		long start = System.currentTimeMillis();
		//DocumentosVO[] documentos = new DocumentosVO[comunidades.size()];
		List resultadoNodos = new ArrayList();
		int numDocumentos = 0;
		int numObjExecute = 0;
		int numObjToExecute = peticiones.size();
		try{
			while(numObjExecute < peticiones.size()){
				MultiSearcherThread[] rtArr = pool.borrowObjects(numObjToExecute, maxNumObjPool); //Número mayor que el máximo admitido por el pool
				EstadoNodoVO[] nodos = new EstadoNodoVO[rtArr.length];
				for(int i = numObjExecute, j = 0; i < numObjExecute+rtArr.length;i++, j++){
					nodos[j] = (EstadoNodoVO) peticiones.get(i);
				}
				EstadoNodoVO[] resultado = executor(rtArr, nodos, maxWaitThread);
				resultadoNodos.add(resultado);
				numDocumentos += resultado.length;
				numObjExecute += rtArr.length;
				numObjToExecute -= rtArr.length;
				if((System.currentTimeMillis() - start) >= maxWaitPool) {
                    throw new NoSuchElementException("Timeout waiting pool: "+maxWaitPool+" max wait pool miliseg.");
                } else {
                    continue; // keep looping
                }
			}
		} catch(Exception e) {
	    	logger.error("MultiSearcher - search ERROR: Pool fallido",e);
	    }
		long end = System.currentTimeMillis();
		logger.debug("MultiSearcher - search : Hilos terminados federada en =" + (end - start)+ " milisegundos, comienza obtención de datos del pool");
		
		
		
		EstadoNodoVO[] retorno = new EstadoNodoVO[peticiones.size()];
		int ind=0;
		for (int i = 0; i<resultadoNodos.size(); i++){
			if (resultadoNodos.get(i)!=null && ((EstadoNodoVO[])resultadoNodos.get(i)).length > 0){
				for (int j=0; j<((EstadoNodoVO[])resultadoNodos.get(i)).length; j++){
					retorno[ind] = ((EstadoNodoVO[])resultadoNodos.get(i))[j];
					ind++;
				}
			}
		}
		
		
		
		return retorno;
	}
	
	private static EstadoNodoVO[] executor(MultiSearcherThread[] rtArr, EstadoNodoVO[] nodos, int maxWaitThread){
		for(int j = 0; j < rtArr.length ; j++ ){
			try{					//Debería ser url 
				logger.debug("MultiSearcher1 - executor : Direccion="+nodos[j].getUrlWS());
				rtArr[j].execute(nodos[j].getUrlWS());
			}catch(Exception e){
				logger.error("MultiSearcher - executor ERROR: Hilo fallido="+ nodos[j].getUrlWS()+" ERROR:",e);
				try{
					pool.returnObject(rtArr[j]);
				}catch(Exception ex){
					logger.error("MultiSearcher - executor ERROR: No se pudo retornar el hilo al pool="+ nodos[j].getUrlWS(),e);
				}	
			}
		}
		for(int i=0;i<rtArr.length;i++) {
			long startObject = System.currentTimeMillis();
			try {
	            while(!(rtArr[i]).isDone()) {
	            	Thread.sleep(500L);
	            	if((System.currentTimeMillis() - startObject) >= maxWaitThread) {
                        throw new NoSuchElementException("Timeout waiting thread: "+maxWaitThread+" max wait thread miliseg.");
                    } else {
                        continue; // keep looping
                    }
	            }
	            nodos[i].setEstado(rtArr[i].getResult());
	            //Nombre nodo...
	            pool.returnObject(rtArr[i]);
			} catch(Exception e) {
            	logger.error("MultiSearcher - executor ERROR: Hilo fallido",e);
            	try{
					pool.returnObject(rtArr[i]);
					nodos[i].setEstado("estadoServicio.INACTIVO");
	        		logger.info("SERVICIO INACTIVO: " + nodos[i].getUrlWS() + " --> " +e);
				}catch(Exception ex){
					nodos[i].setEstado("estadoServicio.INACTIVO");
	        		logger.info("SERVICIO INACTIVO: " + nodos[i].getUrlWS() + " --> " +e);
					logger.error("MultiSearcher - executor ERROR: No se pudo retornar el hilo al pool="+ nodos[i].getUrlWS(),e);
				}	
            }
        }
		return nodos;
	}
	
	private static String getAdress(String nodo, String puerto, String urlServicio) {
		logger.debug("getAdress: nodo=[" + nodo + "]puerto=[" +puerto+"] urlservicio="+urlServicio);
		if(puerto!=null && !puerto.trim().equals(""))return "http://"+nodo+":"+puerto+urlServicio;
		else return "http://"+nodo+urlServicio;
	}
}