/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.buscar.negocio.monitorizar.servicio;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import es.pode.buscar.negocio.administrar.servicio.NodoVO;
import es.pode.buscar.negocio.monitorizar.dominio.EstadoNodoVO;
import es.pode.buscar.negocio.monitorizar.pool.MultiSearcher;


/**
 * @see es.pode.buscar.negocio.monitorizar.servicio.SrvMonitorizarService
 */

public class SrvMonitorizarServiceImpl
    extends es.pode.buscar.negocio.monitorizar.servicio.SrvMonitorizarServiceBase
{

	private static Logger log = Logger.getLogger(SrvMonitorizarServiceImpl.class);
	private Properties props = null;
	
	/**
	 * Obtiene el estado de los servicios asociados a los nodos
	 * 
	 * 
	 * @return EstadoNodoVO[] Array de VOs que contienen el estado de los nodos
	 * @throws Exception
	 */
	
	
	public SrvMonitorizarServiceImpl(){
		super();
		InputStream is = null;
		try {
	//		Configuramos la clase de propiedades
			is = this.getClass().getResourceAsStream("/buscar.properties");
			props = new Properties();
			props.load(is);
		} catch (IOException e) {
			log.error("ERROR: fichero no encontrado: buscar.properties",e);
			throw new RuntimeException(e);
		} finally {
			if( is != null ) {
				try {
					is.close();
				} catch (IOException e) {
					log.error(e);
				}
				
			}
		}
	}
	/**
	 * Obtiene el estado de los servicios asociados a los nodos
	 * 
	 * 
	 * @return EstadoNodoVO[] Array de VOs que contienen el estado de los nodos
	 * @throws Exception
	 */
    protected es.pode.buscar.negocio.monitorizar.dominio.EstadoNodoVO[] handleObtenerEstadoNodos()
        throws java.lang.Exception
    {
    	NodoVO[] nodos = this.getSrvNodoService().listarNodos();
    	EstadoNodoVO[] estados = MultiSearcher.search(nodos, Integer.parseInt(props.getProperty("monitorizar_maxNumObjPool")),Integer.parseInt(props.getProperty("monitorizar_maxWaitThread")),Integer.parseInt(props.getProperty("monitorizar_maxWaitPool")));
        return estados;
    }
    
	
	
}