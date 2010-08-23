/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.buscar.negocio.nodosSQI.servicio;



import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import es.pode.buscar.negocio.nodosSQI.dominio.NodoSQI;
import es.pode.buscar.negocio.nodosSQI.dominio.NodosSQIPorIDCriteria;



/**
 * @see es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSQI
 */

public class SrvGestionSqiServiceImpl
    extends SrvGestionSqiServiceBase
{
	
	private static Logger logger = Logger.getLogger(SrvGestionSqiServiceImpl.class);
	private static final String LENGUAJE_CONSULTA_VSQL="VSQL";
//	private static final String LENGUAJE_CONSULTA_QEL="QEL";//Seguramente seran solo VSQL y LOM (Corregir la validacion de alta)
//	private static final String LENGUAJE_CONSULTA_FIRE="FIRE";
	private static final String LENGUAJE_RESPUESTA_LOM="LOM";
//	private static final String LENGUAJE_RESPUESTA_RDF="RDF";
	private static final String LENGUAJE_RESPUESTA_LOMES="LOM-ES";
	/**
	 * Metodo para dar de alta un nodo de tipo SQI. 
	 * 
	 * @param nodoSQI
	 *                NodoSQIVO con los datos del nodo de tipo SQI que se dara de alta
	 * @return Long
	 * @throws Exception
	 */
	protected Long handleAltaNodoSQI(NodoSQIVO nodoSQI) throws Exception {
		Long identificador=null;
		try{
			String nombre=nodoSQI.getNombreNodo();
			if(nombre==null || nombre.equals("")){				
				logger.error("El nombre del nodo SQI es obligatorio ["+nombre+"]");
				throw new Exception("El nombre del nodo es obligatorio["+nombre+"]");
			}
			String url=nodoSQI.getUrlServicio();
			if(url==null || url.equals("")){
				logger.error("La URL del servicio es obligatorio ["+url+"]");
				throw new Exception("La URL del servicio es obligatorio ["+url+"]");
			}
			String desc=nodoSQI.getDescripcionNodo();
			if(desc==null || desc.equals("")){				
				logger.error("La descripcion del nodo SQI es obligatorio ["+desc+"]");
				throw new Exception("La descripcion del nodo es obligatorio["+desc+"]");
			}
			String consulta=nodoSQI.getLenguajeConsulta().toUpperCase();//Constantes
			String respuesta=nodoSQI.getLenguajeRespuesta().toUpperCase();//Constantes
			if(consulta !=null && !consulta.equals("")){
				if(!consulta.equalsIgnoreCase(LENGUAJE_CONSULTA_VSQL )){
					logger.error("El lenguaje de consulta debe ser de tipo "+ LENGUAJE_CONSULTA_VSQL +", ["+consulta+"]");
					throw new Exception("El lenguaje de consulta debe ser de tipo "+ LENGUAJE_CONSULTA_VSQL+ ", ["+consulta+"]");
				}
			}else{
				logger.error("El lenguaje de consulta es obligatorio ["+consulta+"]");
				throw new Exception("El lenguaje de consulta es obligatorio ["+consulta+"]");
			}
			if(respuesta !=null && !respuesta.equals("")){
				if(!respuesta.equalsIgnoreCase(LENGUAJE_RESPUESTA_LOM)&&!respuesta.equalsIgnoreCase(LENGUAJE_RESPUESTA_LOMES) ){
					logger.error("El lenguaje de respuesta debe ser de tipo "+ LENGUAJE_RESPUESTA_LOM+ "o tipo "+LENGUAJE_RESPUESTA_LOMES+"["+respuesta+"]");
					throw new Exception("{errors.altanodoSQI.lenguajeRespuesta} ");
				}
			}else{
				logger.error("El lenguaje de respuesta es obligatorio ["+respuesta+"]");
				throw new Exception("El respuesta de consulta es obligatorio["+respuesta+"]");
			}
			
			//Para guardarlos en la base de datos en mayuscula
			nodoSQI.setLenguajeConsulta(nodoSQI.getLenguajeConsulta().toUpperCase());
			nodoSQI.setLenguajeRespuesta(nodoSQI.getLenguajeRespuesta().toUpperCase());
			String idSesion=nodoSQI.getIdentificadorSesion();
			if(idSesion==null || idSesion.equals("")){
				String gestor=nodoSQI.getGestorSesion();
				if(gestor==null || gestor.equals("")){
					logger.error("La URL del gestor de sesiones o el identificador de la sesion es obligatorio, identificadorSesion ["+idSesion+"] el gestor de sesiones ["+gestor+"]");
					throw new Exception("La URL del gestor de sesiones o el identificador de la sesion es obligatorio,identificadorSesion ["+idSesion+"] el gestor de sesiones  ["+gestor+"]");
				}
			}
						
			String usuario=nodoSQI.getUsuario();
			String clave=nodoSQI.getClave();
			if(usuario!=null && !usuario.equals("")){
				if(clave==null || clave.equals("")){
					logger.error("Si existe usuario,"+usuario+", es obligatoria la clave ["+clave+"]");
					throw new Exception("Si existe usuario,"+usuario+", es obligatoria la clave ["+clave+"]");
				}
			}
			if(clave!=null && !clave.equals("")){
				if(usuario==null || usuario.equals("")){
					logger.error("Si existe clave,"+clave+", es obligatorio el usuario ["+usuario+"]");
					throw new Exception("Si existe clave,"+clave+", es obligatorio el usuario ["+usuario+"]");
				}
			}
			NodoSQI nodo = this.getNodoSQIDao().fromNodoSQIVO(nodoSQI);
			if(logger.isDebugEnabled()) {
					logger.debug("Se introduce el nodo en la base de datos");
			}
			NodoSQI nodoS = this.getNodoSQIDao().create(nodo);
			identificador=nodoS.getId();
			
		}catch(Exception e){
			logger.error("Error al dar de alta al nodo de tipo SQI con identificador [ "+nodoSQI.getId()+"]", e);
			throw new Exception("Error al dar de alta al nodo de tipo SQI con identificador [ "+nodoSQI.getId()+"]", e);
		}
		return identificador;
	}


	/**
	 * Metodo para listar los nodos de tipo SQI. 
	 * 
	 * @return NodoCortoSQIVO[]
	 * 				El NodoCortoSQIVO es un 2-tupla de identificador y la descripcion del nodo de tipo SQI
	 * @throws java.lang.Exception
	 */
    protected NodoDescripcionSQIVO[] handleListarNodosSQI()
        throws java.lang.Exception
    { 
    	try {
//    		NodoSQIVO[] nodo=(NodoSQIVO[])(this.getNodoSQIDao().listarNodosSQI(this.getNodoSQIDao().TRANSFORM_NODOSQIVO)).toArray(new NodoSQIVO[this.getNodoSQIDao().listarNodosSQI(this.getNodoSQIDao().TRANSFORM_NODOSQIVO).size()]);//Listar nodos da error
////    		NodoSQIVO[] nodo=(NodoSQIVO[])lista.toArray(new NodoSQIVO[lista.size()]);
//    		for (int i = 0; i < nodo.length; i++) {
//				System.out.println("Identificador: [" + nodo[i].getId()+"]");
//				System.out.println("Nodo: [" + nodo[i].getNombreNodo()+"]");			
//			}
    		NodoDescripcionSQIVO[] nodos = ((NodoDescripcionSQIVO[]) (this.getNodoSQIDao().listarNodosSQI(this.getNodoSQIDao().TRANSFORM_NODODESCRIPCIONSQIVO)).toArray(new NodoDescripcionSQIVO[0]));

    		if (logger.isDebugEnabled()) {		
    			for (int i = 0; i < nodos.length; i++) {
    				logger.debug("Identificador: [" + nodos[i].getId()+"]");
    				logger.debug("Nodo: [" + nodos[i].getNombreNodo()+"]");			
    			}
    		}
     	   
    	    return nodos;
    	    
    	} catch (java.lang.Exception e) {
    	    logger.error("Error obteniendo la lista de los nodos de tipo SQI: " + e);
    	    throw  new java.lang.Exception("Error obteniendo la lista de los nodos de tipo SQI: " ,e);
    	}
    }
    /**
	 * Metodo para dar de baja los nodos de tipo SQI con identificadores que corresponden con los del array de Long. 
	 * 
	 * @param ids, un array de Long
	 * @throws Exception
	 */
	protected void handleBajaNodosSQI(Long[] ids) throws Exception {
		
    	try{
    		NodosSQIPorIDCriteria criterio=new NodosSQIPorIDCriteria(ids);
    		List lista=this.getNodoSQIDao().consultarNodosSQI(criterio);
    		this.getNodoSQIDao().remove(lista);
    		if(logger.isDebugEnabled()){
		    	for (int i=0; i<ids.length;i++){		    		
		    		logger.debug("Eliminando nodo SQI con id: " + ids[i]);
		    	}
    		}
//    		}
	    	
    	} catch (Exception e){
    	    logger.error("Error al eliminar["+ids.length+"] nodos SQI", e);
    	    throw new Exception("Error al eliminar["+ids.length+"] nodos SQI", e);
    	}
		
	}
	/**
	 * Metodo para modificar el nodo de tipo SQI. 
	 * @param nodo, de tipo NodoSQIVO
	 * @return Long
	 * 				El identificador del nodo que se modifica
	 * @throws Exception
	 */
	protected Long handleModificarNodoSQI(NodoSQIVO nodo) throws Exception {
		
		try{
			NodosSQIPorIDCriteria criterio=new NodosSQIPorIDCriteria();
			Long[] identi=new Long[1];
			identi[0]=nodo.getId();
			criterio.setIds(identi);
			List nodos = this.getNodoSQIDao().consultarNodosSQI(criterio);
			NodoSQI nodoV=(NodoSQI)nodos.get(0);

	    	if(nodoV!=null){
	    		String nombre=nodo.getNombreNodo();
		    	if(nombre==null || nombre.equals("")){				
					logger.error("El nombre del nodo SQI es obligatorio ["+nombre+"]");
					throw new Exception("El nombre del nodo es obligatorio["+nombre+"]");
				}
		    	nodoV.setNombreNodo(nombre);
		    	
		    	String url=nodo.getUrlServicio();
				if(url==null || url.equals("")){
					logger.error("La URL del servicio es obligatorio ["+url+"]");
					throw new Exception("La URL del servicio es obligatorio ["+url+"]");
				}
		    	nodoV.setUrlServicio(url);
		    	
		    	String desc=nodo.getDescripcionNodo();
				if(desc==null || desc.equals("")){				
					logger.error("La descripcion del nodo SQI es obligatorio ["+desc+"]");
					throw new Exception("La descripcion del nodo es obligatorio["+desc+"]");
				}
		    	nodoV.setDescripcionNodo(desc);
		    	
		    	String consulta=nodo.getLenguajeConsulta().toUpperCase();//Constantes
				String respuesta=nodo.getLenguajeRespuesta().toUpperCase();//Constantes
				if(consulta !=null && !consulta.equals("")){
					if(!consulta.equalsIgnoreCase(LENGUAJE_CONSULTA_VSQL)){
						logger.error("El lenguaje de consulta debe ser de tipo "+ LENGUAJE_CONSULTA_VSQL+ ", ["+consulta+"]");
						throw new Exception("El lenguaje de consulta debe ser de tipo "+ LENGUAJE_CONSULTA_VSQL+ ", ["+consulta+"]");
					}
				}else{
					logger.error("El lenguaje de consulta es obligatorio ["+consulta+"]");
					throw new Exception("El lenguaje de consulta es obligatorio ["+consulta+"]");
				}
				if(respuesta !=null && !respuesta.equals("")){
					if(!respuesta.equalsIgnoreCase(LENGUAJE_RESPUESTA_LOM)&&!respuesta.equalsIgnoreCase(LENGUAJE_RESPUESTA_LOMES) ){
						logger.error("El lenguaje de respuesta debe ser de tipo "+ LENGUAJE_RESPUESTA_LOM+ "o tipo "+LENGUAJE_RESPUESTA_LOMES+"["+respuesta+"]");
						throw new Exception("{errors.altanodoSQI.lenguajeRespuesta} ");
					}
				}else{
					logger.error("El lenguaje de respuesta es obligatorio ["+respuesta+"]");
					throw new Exception("El respuesta de consulta es obligatorio["+respuesta+"]");
				}
				nodoV.setLenguajeConsulta(consulta);
		    	nodoV.setLenguajeRespuesta(respuesta);
				
				String idSesion=nodo.getIdentificadorSesion();
				String gestor="";
				if(idSesion==null || idSesion.equals("")){
					gestor=nodo.getGestorSesion();
					if(gestor==null || gestor.equals("")){
						logger.error("La URL del gestor de sesiones o el identificador de la sesion es obligatorio, identificadorSesion ["+idSesion+"] el gestor de sesiones ["+gestor+"]");
						throw new Exception("La URL del gestor de sesiones o el identificador de la sesion es obligatorio,identificadorSesion ["+idSesion+"] el gestor de sesiones  ["+gestor+"]");
					}
				}
		    	nodoV.setIdentificadorSesion(idSesion);
		    	nodoV.setGestorSesion(gestor);
		    	
	    		String clave=nodo.getClave();
	    		String usuario=nodo.getUsuario();
	    		if(clave!=null && !clave.equals("")){
					if(usuario==null || usuario.equals("")){
						logger.error("Si existe clave,"+clave+", es obligatorio el usuario ["+usuario+"]");
						throw new Exception("Si existe clave,"+clave+", es obligatorio el usuario ["+usuario+"]");
					}
				}
	    		if(usuario!=null && !usuario.equals("")){
					if(clave==null || clave.equals("")){
						logger.error("Si existe usuario,"+usuario+", es obligatoria la clave ["+clave+"]");
						throw new Exception("Si existe usuario,"+usuario+", es obligatoria la clave ["+clave+"]");
					}
				}
	    		nodoV.setClave(clave);
	    		nodoV.setUsuario(usuario); 

		    	//actualizamos los datos del nodo
		    	this.getNodoSQIDao().update(nodoV);
	    	}else{
	    		logger.error("El nodo con identificador ["+nodo.getId()+"] que se quiere modificar no existe en la base de datos");
	    		throw new Exception("El nodo con identificador ["+nodo.getId()+"] que se quiere modificar no existe en la base de datos");
	    	}
	    	
		} catch (Exception e){
		    logger.error("Error al actualizar el nodo SQI con identificador ["+nodo.getId()+"],nombre del nodo ["+nodo.getNombreNodo()+"], descripcion del nodo ["+nodo.getDescripcionNodo()+"]" +
		    		",lenguaje de consulta ["+nodo.getLenguajeConsulta()+"], lenguaje de respuesta ["+nodo.getLenguajeRespuesta()+"], " +
		    		"la URL del servicio ["+nodo.getUrlServicio()+"],el gestor de sesiones ["+nodo.getGestorSesion()+"], " +
		    		"el identificador de la sesion ["+ nodo.getIdentificadorSesion()+"], la clave ["+nodo.getClave()+"]," +
		    		" y el usuario ["+nodo.getUsuario()+"]", e);
		    throw new Exception("Error al actualizar el nodo SQI con identificador ["+nodo.getId()+"],nombre del nodo ["+nodo.getNombreNodo()+"], descripcion del nodo ["+nodo.getDescripcionNodo()+"]" +
		    		",lenguaje de consulta ["+nodo.getLenguajeConsulta()+"], lenguaje de respuesta ["+nodo.getLenguajeRespuesta()+"], " +
		    		"la URL del servicio ["+nodo.getUrlServicio()+"],el gestor de sesiones ["+nodo.getGestorSesion()+"], " +
		    		"el identificador de la sesion ["+ nodo.getIdentificadorSesion()+"], la clave ["+nodo.getClave()+"]," +
		    		" y el usuario ["+nodo.getUsuario()+"]", e);
		}
		
		return nodo.getId();
	}

	/**
	 * Metodo para consultar los nodos de tipo SQI que coincidan con los identificadores del array de Long. 
	 * @param ids, un array de Long
	 * @return NodoSQIVO[]
	 * 				Un array de NodoSQIVO
	 * @throws Exception
	 */

	protected NodoSQIVO[] handleConsultaNodosSQI(Long[] ids) throws Exception {
		NodoSQIVO[] todosNodos=null;
		try{
			NodosSQIPorIDCriteria criterio=new NodosSQIPorIDCriteria();
			criterio.setIds(ids);
			List listaNodos=new ArrayList();
			listaNodos =this.getNodoSQIDao().consultarNodosSQI(this.getNodoSQIDao().TRANSFORM_NODOSQIVO,criterio);
			todosNodos=(NodoSQIVO[])(listaNodos.toArray(new NodoSQIVO[listaNodos.size()]));
		}catch(Exception e){
			logger.error("Error al hacer la consulta para los nodos ["+ ids+"]");
			throw new Exception("Error al hacer la consulta para los nodos ["+ ids+"]");
		}
		return todosNodos;
	}


	/**
	 * Este metodo resuelve la búsqueda SQI sobre los nodos federados en la plataforma que implementan el interfaz SQI. 
	 * @return NodoSQIVO[]
	 * 				Un array de NodoSQIVO con todos los nodos dados de alta en la plataforma.
	 * @throws Exception
	 */
	protected NodoSQIVO[] handleObtenerNodosSQI() throws Exception {
		return (NodoSQIVO[])this.getNodoSQIDao().loadAll(this.getNodoSQIDao().TRANSFORM_NODOSQIVO).toArray(new NodoSQIVO[0]);
	}
	
	
}