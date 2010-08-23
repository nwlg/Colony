/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package es.pode.planificador.negocio.servicios;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import es.pode.planificador.negocio.dominio.RegistroTareaEjecutada;
import es.pode.planificador.negocio.dominio.TareaEjecutada;
import es.pode.planificador.negocio.dominio.TareaEjecutadaDao;
import es.pode.planificador.negocio.dominio.TareaTrabajoFFinCriteria;
import es.pode.soporte.constantes.ConstantesAgrega;

/**
 * Servicios asociados a la planificación de las tareas
 * 
 * 	Trigger: Es la programación de la tarea.
 *  Trabajo: Es la tarea planificada para ejecutarse.
 *  
 *  Una tarea engloba la programación (trigger) y el trabajo asociado.
 */


public class SrvRegistroPlanificadorServiceImpl
    extends es.pode.planificador.negocio.servicios.SrvRegistroPlanificadorServiceBase
{

	private static Logger log = Logger.getLogger(SrvRegistroPlanificadorServiceImpl.class);

    
	/**
	 * Registra en la tabla de Tareaejecutada la tarea ejecuta
	 * @param trabajo Trabajo que se va a registrar
	 * @retun tareaCreada.getId() El id de la tarea que se registra
	 * @throws Exception
	 */
    protected Long handleRegistrarTrabajo(TareaEjecutadaVO trabajo)
        throws java.lang.Exception
    {
		TareaEjecutada tareaCreada = null;

		try
		{
			TareaEjecutada tareaEjecutadaEntity = this.getTareaEjecutadaDao().fromTareaEjecutadaVO(trabajo);
			
			if (trabajo.getFechaInicio() == null)
				tareaEjecutadaEntity.setFechaInicio(new GregorianCalendar());
			else
				tareaEjecutadaEntity.setFechaInicio(trabajo.getFechaInicio());
			
			if (trabajo.getDescripcion() != null && !trabajo.getDescripcion().equals(""))
				tareaEjecutadaEntity.setDescripcion(trabajo.getDescripcion());
			else
				tareaEjecutadaEntity.setDescripcion(" ");
			
			if(trabajo.getUsuario() != null)
				tareaEjecutadaEntity.setUsuario(trabajo.getUsuario());
			
			if (trabajo.getGrupoTrabajo() != null && !trabajo.getGrupoTrabajo().equals(""))
				tareaEjecutadaEntity.setGrupoTrabajo(trabajo.getGrupoTrabajo());
			else
			{
				log.error("Error: No se puede registrar la tarea porque el grupo de trabajo es nulo");
				return null;
			}
			
			if (trabajo.getTrabajo() != null && !trabajo.getTrabajo().equals(""))
				tareaEjecutadaEntity.setTrabajo(trabajo.getTrabajo());
			else
			{
				log.error("Error: No se puede registrar la tarea porque el trabajo es nulo");
				return null;
			}
			log("Tarea ejecutada: " + tareaEjecutadaEntity);
			tareaCreada = this.getTareaEjecutadaDao().create(tareaEjecutadaEntity);			
		}
		catch (Exception e)
		{
			log.error(e);
    		RegistrarTrabajoException excepcion = new RegistrarTrabajoException("Error: No se ha podido registrar el trabajo. ", e);    		
    		throw excepcion;
		}

		return tareaCreada.getId();    
    }

    
    /**
     * Registra en la tabla correspodiente si ha ido o no bien la carga de las sub-tareas que estan
     * asociadas a una tarea en concreto 
     * @param trabajoHijo El sub-trabajo de un trabajo concreto
     * @return registroEntity.getId() El id del registro
     * @throws Exception
     */
    protected Long handleRegistrarTrabajoHijo(RegistroTareaEjecutadaVO trabajoHijo)
        throws java.lang.Exception
    {    	
    	RegistroTareaEjecutada registroEntity = null;
    	TareaEjecutada tareaEjecutadaEntity = null;
    	
		try
		{			
			registroEntity = this.getRegistroTareaEjecutadaDao().fromRegistroTareaEjecutadaVO(trabajoHijo);
			log("Tarea derivada: " + tareaEjecutadaEntity);
			this.getRegistroTareaEjecutadaDao().create(registroEntity);
		}
		catch (Exception e)
		{
			log.error("Error: No se pudo realizar el registro del trabajo dependiente. " + e);
			throw e;
		}

    	return registroEntity.getId();
    }
    
    /**
     * Se registra la fecha en la que se ha finalizado la ejecucion de un trabajo 
     * y se comprueba si la ejecución ha sido o no correcta
     * @param trabajoEjecutado Un TareaEjecutadaVO
     * @return tareaEntity.getId() El id de la trabajo
     * @throws Exception
     */
	protected Long handleRegistrarTrabajoFechaFin(TareaEjecutadaVO trabajoEjecutado) 
			throws Exception 
	{
		TareaEjecutada tareaEntity = null;
		
    	try
    	{
    		tareaEntity= this.getTareaEjecutadaDao().load(trabajoEjecutado.getId());
    		tareaEntity.setFechaFin(trabajoEjecutado.getFechaFin());
    		tareaEntity.setEstado(trabajoEjecutado.getEstado());
    		log("Tarea actualizada: " + tareaEntity);
    		this.getTareaEjecutadaDao().update(tareaEntity);
		}
    	catch (Exception e)
    	{
    		log.error(e);
    		throw e;
    	}
    	
		return tareaEntity.getId();
	}
	
	
	private void log (Object obj)
	{
		if (log.isDebugEnabled())
			log.debug(obj);
	}

	/**
	 * Realiza la operacion de cambio de estado a INTERRUMPIDO de los trabajos 
	 * que no finalizaron cuando el servidor de aplicaciones se ha parado inesperadamente
	 * @return filasModificadas Las filas modificadas
	 * @throws Exception
	*/
	protected Long handleRegistrarTrabajoInterrumpido() throws Exception 
	{
		List listaTareas = null;
		Long filasModificadas = null;
		Collection listaTareaEntity = new ArrayList();
		
		try
		{
    		TareaEjecutadaDao tareaEjecutadaDao = this.getTareaEjecutadaDao();
    		TareaTrabajoFFinCriteria criterios = new TareaTrabajoFFinCriteria();
    		criterios.setFechaFin(null);
    		
    		listaTareas = tareaEjecutadaDao.buscarTareaByTrabajoAndFFin(
    				tareaEjecutadaDao.TRANSFORM_TAREAEJECUTADAVO, criterios);

			Iterator it = listaTareas.iterator();
	    		
	    	while (it.hasNext())
	    	{
    			TareaEjecutadaVO tareaVO = (TareaEjecutadaVO) it.next();	
				TareaEjecutada tarea = tareaEjecutadaDao.load(tareaVO.getId());
    			tarea.setFechaFin(new GregorianCalendar());
    			tarea.setEstado(ConstantesAgrega.TRABAJO_INTERRUMPIDO);
				listaTareaEntity.add(tarea);				
			}
	    	
	    	log("Tareas interrumpidas: " + listaTareaEntity.size());   	
	    	tareaEjecutadaDao.update(listaTareaEntity);
		}
		catch (Exception e)
		{
			log.error(e);
			throw e;
		}
		
		filasModificadas = new Long(listaTareaEntity.size());
		
		return filasModificadas;
	}
}