/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.buscar.negocio.administrar.servicio;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import es.pode.buscar.negocio.administrar.dominio.Ccaa;
import es.pode.buscar.negocio.administrar.dominio.CcaaDao;
import es.pode.buscar.negocio.administrar.dominio.Nodo;
import es.pode.buscar.negocio.administrar.dominio.NodoDao;
import es.pode.buscar.negocio.administrar.dominio.ServicioDao;
import es.pode.buscar.negocio.administrar.dominio.ThreadIdNodo;



/**
 * @see es.pode.buscar.negocio.administrar.servicio.SrvNodoService
 */

public class SrvNodoServiceImpl
    extends es.pode.buscar.negocio.administrar.servicio.SrvNodoServiceBase
{

	private static Logger log = Logger.getLogger(SrvNodoServiceImpl.class);
	private java.util.Properties pBuscarProperties = null;

	/**
	 * Metodo para dar de alta un nodo. 
	 * 
	 * @param nodo
	 *                nodoVO con los datos del nodo que se dara de alta
	 * @return void
	 * @throws Exception
	 */
	protected Integer handleCrearNodo(es.pode.buscar.negocio.administrar.servicio.NodoVO nodo)
    throws java.lang.Exception
{
	Integer codigo_devuelto;
	try{
		//Asociamos todos los servicios al nodo
		ServicioVO[] servicios = obtenerServicios();
		nodo.setServicio(servicios);
    	Nodo nodoEntity = this.getNodoDao().fromNodoVO(nodo);
    	nodoEntity.setFechaAlta(new Date());
    	if (nodo.getCcaa()!=null){
	    	Ccaa ccaa = obtenerCCAA (nodo.getCcaa());
	    	nodoEntity.setCcaa(ccaa);
    	}
    	   		
		
    	/*
    	 * ----------------------------------------------------------------------------------------------
    	 * ---------------------------- CREAMOS UN NUEVO HILO PARA: -------------------------------------
    	 * 1. Obtener el identificador del nodo que se quiere dar de alta
    	 * 	1.1 Via llamada al webService obtenemos el identificador 
    	 * 2. Introducir el identificador obtenido en la base de datos.
    	 * ----------------------------------------------------------------------------------------------
    	 * Se devuelve 0 o 1 para saber si la direccion es buena o no y tratar la Exception en el controller
    	 * */    	

    	//Instanciamos el hilo para ejecutar la consulta del identificador del nodo
    	ThreadIdNodo threadNodo = new ThreadIdNodo();
    	
    	//Creamos el address del nodo que se quiere dar de alta
    	String puerto = ((nodo.getPuerto()== null || nodo.getPuerto().equals(""))?"":":"+nodo.getPuerto());  //si el puerto no viene (no es obligatorio) no se usa.
	    String address ="http://"+nodo.getUrlWS()+puerto+ this.getPropertyValue("srvFederada"); 
	    log.debug("El valor de address es ["+address+"]");
       
	    //Realizamos el set de los campos necesarios
        threadNodo.setAddress(address);
        threadNodo.setNodo(nodo);        	
	      
        //Wait for the thread to finish but don't wait longer than a specified time		        
	    String idNodo = "";
	    long delayMillis = 5000; // 5 seconds
	 
	    Thread hilo = new Thread(threadNodo);
	        	
	    //Invocamos la ejecucion del hilo
	    log.debug("Ejecutamos el hilo que obtiene el identificador del nodo que se quiere dar de alta");
		hilo.start();
		log.debug("Fin de la ejecucion del hilo que obtiene el identificador del nodo que se quiere dar de alta");
	        	
		hilo.join(delayMillis);
	        
	    if (hilo.isAlive()) {
	    	log.error("No se ha podido realizar la consulta del identificador del nodo. El tiempo de espera por el hilo ha finalizado");
	        hilo.interrupt();
	        throw new InterruptedException("El tiempo de espera por el hilo ha finalizado");
	        
	    } else {
	    	
	    	log.debug("Se ha podido realizar la consulta del identificador del nodo.");
	        
	    	//Se recupera el valor del identificador del nodo
			idNodo = threadNodo.getResult();
			
			//Comprobamos si el valor devuelto es null lo que significa que la direccion no es ok
			if(idNodo == null)
				throw new InterruptedException("El tiempo de espera por el hilo ha finalizado");
			
			log.debug("El identificador del nodo obtenido es ["+idNodo+"]");
			
			codigo_devuelto = new Integer(0);
	    }	  

	    //Introducimos el identificador del nodo en el vo
	    nodoEntity.setIdNodo(idNodo);
	     
    	//Introducir en la BD el nodo creado
        log.debug("Se introduce el nodo en la base de datos con idNodo" +idNodo);
    	Nodo nodoVuelta=this.getNodoDao().create(nodoEntity);
    	log.debug("Los valores del nodo de vuelta son:IdNodo " +nodoVuelta.getIdNodo()+"la url "+nodoVuelta.getUrl()+"la fecha de alta "+nodoVuelta.getFechaAlta().toString());
    	
	}catch (InterruptedException Ie){
	    log.error("Error al insertar el nodo ", Ie);
	    codigo_devuelto = new Integer(1);
	    //throw Ie;

	} catch (Exception e){
	    log.error("Error al insertar el nodo ", e);
	    codigo_devuelto= new Integer(2);
	    //throw e;
	}
	
	return codigo_devuelto;
}
    
	/**
	 * Metodo para obtener los datos de una ccaa
	 * 
	 * @param ccaa
	 *                ccaaVO con el id de la ccaa que se quiere recuperar
	 * @return Ccaa con los datos de la ccaa
	 * @throws Exception
	 */

    private Ccaa obtenerCCAA (CcaaVO ccaa) throws Exception{
    	return this.getCcaaDao().load(ccaa.getId());
    }

	/**
	 * Metodo para modificar un nodo. Actualiza los datos del nodo.
	 * 
	 * @param nodo
	 *                nodoVO con los datos del nodo que se modificará
	 * @return void
	 * @throws Exception
	 */
    protected Integer handleModificarNodo(es.pode.buscar.negocio.administrar.servicio.NodoVO nodo)
    throws java.lang.Exception
{
	
	Integer codigo_devuelto;
	
	try{
		
    	Nodo nodoEntity = this.getNodoDao().load(nodo.getId());
    	if (nodo.getCcaa()!=null){
	    	Ccaa ccaa = obtenerCCAA (nodo.getCcaa());
	    	nodoEntity.setCcaa(ccaa);
	    	nodo.setCcaa(this.getCcaaDao().toCcaaVO(ccaa));
    	}
    	nodoEntity.setNodo(nodo.getNodo());
    	nodoEntity.setPuerto(nodo.getPuerto());
    	nodoEntity.setUrl(nodo.getUrl());
    	nodoEntity.setUrlWS(nodo.getUrlWS());
    	
    	
    	//Instanciamos el hilo para ejecutar la consulta del identificador del nodo
    	ThreadIdNodo threadNodo = new ThreadIdNodo();
    	
    	//Creamos el address del nodo que se quiere dar de alta
    	String puerto = ((nodo.getPuerto()== null || nodo.getPuerto().equals(""))?"":":"+nodo.getPuerto());
	    String address ="http://"+nodo.getUrlWS()+puerto+ this.getPropertyValue("srvFederada"); 
	    log.debug("El valor de address es ["+address+"]");
       
	    //Realizamos el set de los campos necesarios
        threadNodo.setAddress(address);
        threadNodo.setNodo(nodo);        	
	      
        //Wait for the thread to finish but don't wait longer than a specified time		        
	    String idNodo = "";
	    long delayMillis = 5000; // 5 seconds
	 
	    Thread hilo = new Thread(threadNodo);
	        	
	    //Invocamos la ejecucion del hilo
	    log.debug("Ejecutamos el hilo que obtiene el identificador del nodo que se quiere dar de alta");
		hilo.start();
		log.debug("Fin de la ejecucion del hilo que obtiene el identificador del nodo que se quiere dar de alta");
	        	
		hilo.join(delayMillis);
	        
	    if (hilo.isAlive()) {
	    	log.error("No se ha podido realizar la consulta del identificador del nodo. El tiempo de espera por el hilo ha finalizado");
	        hilo.interrupt();
	        throw new InterruptedException("El tiempo de espera por el hilo ha finalizado");
	        
	    } 
	    else 
	    {
	    	
	    	log.debug("No se ha podido realizar la consulta del identificador del nodo. El tiempo de espera por el hilo ha finalizado");
	        
	    	//Se recupera el valor del identificador del nodo
			idNodo = threadNodo.getResult();
			
			//Comprobamos si el valor devuelto es null lo que significa que la direccion no es ok
			if(idNodo == null)
				throw new InterruptedException("El tiempo de espera por el hilo ha finalizado");
			
			log.debug("El identificador del nodo obtenido es ["+idNodo+"]");
			
			codigo_devuelto = new Integer(0);
	    }	  

	    //Introducimos el identificador del nodo en el vo
	    nodoEntity.setIdNodo(idNodo);
    
    	//actualizamos los datos del nodo
    	this.getNodoDao().update(nodoEntity);
    	
    	
	} catch (InterruptedException Ie){
	    log.error("Error al insertar el nodo ", Ie);
	    codigo_devuelto = new Integer(1);
	    //throw Ie;

	} catch (Exception e){
	    log.error("Error al insertar el nodo ", e);
	    codigo_devuelto= new Integer(2);
	    //throw e;
	}
	
	return codigo_devuelto;
}
    

	/**
	 * Metodo para eliminar un nodo.
	 * 
	 * @param ids
	 *                Long[] con los identificadores de los nodos que 
	 *                serán eliminados
	 * @return ValidaBajaNodoVO que contiene el resultado de la eliminación
	 * así como los nodos que han sido eliminados.
	 * @throws Exception
	 */
    protected es.pode.buscar.negocio.administrar.servicio.ValidaBajaNodoVO handleEliminarNodo(java.lang.Long[] ids)
        throws java.lang.Exception
    {
    	ValidaBajaNodoVO validaBajaNodoVO = new ValidaBajaNodoVO();
    	try{
    		int nodosBorrados = 0;
    		List itemsBorrados = new ArrayList();
    		Nodo nodoBorrado;
	    	for (int i=0; i<ids.length;i++){
	    		nodoBorrado = this.getNodoDao().load(ids[i]);
	    		this.getNodoDao().remove(ids[i]);
	    		log("[ELIMINAR_NODO] Nodo eliminado con id: " + ids[i]);
	    		nodosBorrados ++;
	    		itemsBorrados.add(this.getNodoDao().toNodoVO(nodoBorrado));
	    	}
	    	validaBajaNodoVO.setNodosBorrados((NodoVO[])itemsBorrados.toArray(new NodoVO[0]));
	    	if (nodosBorrados == ids.length){
	    		validaBajaNodoVO.setDescripcionBaja("ok.borrarNodos");
	    	} else {
	    		validaBajaNodoVO.setDescripcionBaja("fallo.borrarNodos");
	    	}
    	} catch (Exception e){
    	    log.error("Error al eliminar el nodo ", e);
    	    throw e;
    	}
    	return validaBajaNodoVO;
    }

	/**
	 * Metodo para recuperar los datos de un nodo.
	 * 
	 * @param id
	 *                Long con el identificador del nodo.
	 * @return NodoVO con los datos del nodo que se ha recuperado
	 * @throws Exception
	 */
    protected es.pode.buscar.negocio.administrar.servicio.NodoVO handleObtenerNodo(java.lang.Long id)
        throws java.lang.Exception
    {
        return (NodoVO)this.getNodoDao().load(NodoDao.TRANSFORM_NODOVO, id);
    }
    
	/**
	 * Metodo público para recuperar los datos de un nodo.
	 * 
	 * @param id
	 *                Long con el identificador del nodo.
	 * @return NodoVO con los datos del nodo que se ha recuperado
	 * @throws Exception
	 */
    public es.pode.buscar.negocio.administrar.servicio.NodoVO obtenerNodoPublic(java.lang.Long id) throws Exception
    {
    	return handleObtenerNodo(id);
    }

	/**
	 * Metodo para recuperar un listado de los nodos almacenados en el sistema
	 * 
	 * @return NodoVO[] array con los nodos recuperados
	 * @throws Exception
	 */
	protected NodoVO[] handleListarNodos() throws Exception {
    	try {
    		NodoVO[] nodos = (NodoVO[]) this.getNodoDao().listarNodos(
    				NodoDao.TRANSFORM_NODOVO).toArray(new NodoVO[0]);

    		if (log.isDebugEnabled()) {		
    			for (int i = 0; i < nodos.length; i++) {
    				log.debug("Nodo: " + nodos[i].getNodo());
    				log.debug("URL: " + nodos[i].getUrl());				
    				log.debug("puerto: " + nodos[i].getPuerto());
    			}
    		}
     	   
    	    return nodos;
    	    
    	} catch (Exception e) {
    	    log.error("[OBTENER_NODOS] Error: " + e);
    	    throw e;
    	}
	}
	
	
    private void log(Object obj) {
    	if (log.isDebugEnabled())
    	    log.debug(obj);
    }

	/**
	 * Metodo para recuperar los datos de una ccaa
	 * 
	 * @param id
	 *                Long con el identificador de la ccaa
	 * @return CcaaVO con los datos de la ccaa.
	 * @throws Exception
	 */
	protected CcaaVO handleObtenerCCAA(Long id) throws Exception {
		return (CcaaVO)this.getCcaaDao().load(CcaaDao.TRANSFORM_CCAAVO,id);
	}

	/**
	 * Metodo que devuelve un listado de las ccaa.
	 * 
	 * @return CcaaVO[] con los datos de las ccaa.
	 * @throws Exception
	 */
	protected CcaaVO[] handleObtenerCCAAs() throws Exception {
	
		CcaaVO[] ccaa = (CcaaVO[]) this.getCcaaDao().obtenerCCAAs(
				CcaaDao.TRANSFORM_CCAAVO).toArray(new CcaaVO[0]);

		if (log.isDebugEnabled()) {		
			for (int i = 0; i < ccaa.length; i++) {
				log.debug("ID: " + ccaa[i].getId());
				log.debug("Código: " + ccaa[i].getCodigo());				
				log.debug("Descripción: " + ccaa[i].getDescripcion());
			}
		}
		
		return ccaa;
	}

	/**
	 * Metodo para recuperar los datos de un servicio.
	 * 
	 * @param id
	 *                Long con el identificador del servicio.
	 * @return ServicioVO con los datos del servicio.
	 * @throws Exception
	 */
	protected ServicioVO handleObtenerServicio(Long id) throws Exception {
		return (ServicioVO)this.getServicioDao().load(ServicioDao.TRANSFORM_SERVICIOVO, id);
	}

	/**
	 * Metodo para recuperar los servicios almacenados en el sistema.
	 * 
	 * @return ServicioVO[] con los datos de los servicios.
	 * @throws Exception
	 */
	protected ServicioVO[] handleObtenerServicios() throws Exception {
		return (ServicioVO[])this.getServicioDao().obtenerServicios(ServicioDao.TRANSFORM_SERVICIOVO).toArray(new ServicioVO[0]);
	}

	/**
	 * Obtiene el valor almacenado en el fichero properties auditoria de una determinada cadena 
	 * @param  sKey cadena de la que se quiere obtener el valor
	 * @return String
	 * @throws Exception
	 */
	private String getPropertyValue(String sKey) throws IOException
	{
		InputStream fIsSpringProperties = this.getClass().getResourceAsStream("/buscar.properties");
		if (this.pBuscarProperties == null)
		{
			pBuscarProperties = new java.util.Properties();
			pBuscarProperties.load(fIsSpringProperties);
		}
		fIsSpringProperties.close();

		// devolvemos la propiedad
		return pBuscarProperties.getProperty(sKey);
	}
	
	/**
	 * Metodo para comprobar si ya existe un nodo dado de alta en el sistema con los mismos valores de url y 
	 * url del WebService.
	 * 
	 * @param url String. url del nodo
	 * @param urlWS String. url del webService
	 * @return Boolean
	 * @throws Exception
	 */
    protected Boolean handleEstaDadoAlta(String url, String urlWS)
        throws java.lang.Exception
    {
    	Boolean resultado = new Boolean(false);
//    	Comprobamos si la url y la urlWS ya esta dado de alta en la BD
    	NodosCriteria criterios = new NodosCriteria();
    	criterios.setUrl(url);
    	criterios.setUrlWS(urlWS);
    	log("Se ha creado el criterio de Nodo para hacer la comprobacion");
		List listaNodos = this.getNodoDao().ListarNodosSemejantes(this.getNodoDao().TRANSFORM_NODOVO, criterios);
		
		if((!(listaNodos == null))&&(listaNodos.size() > 0))
		{
			log("Existe algun nodo con los mismos valores de url "+listaNodos.size());
			resultado = new Boolean(true);
		} 
		log("¿Esta dado de alta? "+resultado);
    	return resultado;
    }

    /**
     * Metodo que comprueba si un nodo ya creado tiene un nombre de nodo que se intenta dar de alta.
     * 
     * @param nombreNodo String. Nombre del nodo
     * 
     * @return Boolean se devuelve true si existe un nodo con ese nombre y false si no existe
     * @throws java.lang.Exception
     */
    protected Boolean handleExisteNombreNodo(String nombreNodo)
    throws java.lang.Exception
    {
		Boolean resultado = new Boolean(false);
		
		//Comprobamos si nombre de nodo ya esta dado de alta en la BD
		NombresNodosCriteria criterios = new NombresNodosCriteria();
		criterios.setNodo(nombreNodo);
		
		log("Se ha creado el criterio de NombreNodo para hacer la comprobacion");
		log("Nombre Nodo = " + nombreNodo);
		
		List listaNodos = this.getNodoDao().ListarNodosNombresSemejantes(criterios);
		log("listar nodos = " + listaNodos);
		log("tamaño de listar nodos = " + listaNodos.size());
		
		if(listaNodos == null || listaNodos.size() == 0)
		{
			resultado = new Boolean(false);
		}
		else
		{
			resultado = new Boolean(true);
		}
		
		
		return resultado;
	}


}