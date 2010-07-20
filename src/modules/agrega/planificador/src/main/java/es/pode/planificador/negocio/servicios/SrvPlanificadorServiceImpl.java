/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point

package es.pode.planificador.negocio.servicios;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import javax.activation.DataHandler;

import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleTrigger;
import org.quartz.Trigger;

import es.pode.auditoria.negocio.servicios.ParametroCrearInformeVO;
import es.pode.planificador.negocio.comun.CtesPlanificador;
import es.pode.planificador.negocio.comun.Planificador;
import es.pode.planificador.negocio.dominio.RegistroTareaEjecutada;
import es.pode.planificador.negocio.dominio.RegistroTareaEjecutadaDao;
import es.pode.planificador.negocio.dominio.TareaEjecutada;
import es.pode.planificador.negocio.dominio.TareaEjecutadaDao;
import es.pode.planificador.negocio.dominio.TareaTrabajoFFinCriteria;
import es.pode.planificador.negocio.dominio.TrabajosActivosCriteria;
import es.pode.planificador.negocio.dominio.TrabajosEjecutadosDesdeHastaCriteria;
import es.pode.planificador.negocio.dominio.TrabajosNoCorrectosCriteria;
import es.pode.planificador.negocio.trabajos.CargaODEs;
import es.pode.planificador.negocio.trabajos.EliminarNoDisponibles;
import es.pode.planificador.negocio.trabajos.GenerarInforme;
import es.pode.planificador.negocio.trabajos.GenerarInformeFederado;
import es.pode.planificador.negocio.trabajos.InformeCatalogo;
import es.pode.planificador.negocio.trabajos.Reindexado;
import es.pode.planificador.negocio.trabajos.TareaModificacion;
import es.pode.publicacion.negocio.servicios.EliminarNoDisponiblesVO;
import es.pode.publicacion.negocio.servicios.EliminarResultadoVO;
import es.pode.publicacion.negocio.servicios.RegeneracionIndiceVO;
import es.pode.publicacion.negocio.servicios.ReindexarODEResultadoVO;
import es.pode.publicacion.negocio.servicios.ResultadoOperacionVO;
import es.pode.publicacion.negocio.servicios.SrvPublicacionService;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.utiles.date.DateManager;

/**
 * Servicios asociados a la planificación de las tareas
 * 
 * 	Trigger: Es la programación de la tarea.
 *  Trabajo: Es la tarea planificada para ejecutarse.
 *  
 *  Una tarea engloba la programación (trigger) y el trabajo asociado.
 */

public class SrvPlanificadorServiceImpl
    extends es.pode.planificador.negocio.servicios.SrvPlanificadorServiceBase
{
	private static Logger log = Logger.getLogger(SrvPlanificadorServiceImpl.class);
 			
	/** 
	 * Eliminación de las tareas elegidas. 
	 * @param tareas Un array de trabajos.
	 * @return retorno Indica si todo ha ido bien(true) o si ha habido algun error(false).
	 */
	
    protected Boolean handleEliminarTareas(TrabajoVO[] tareas)
        throws java.lang.Exception
    {
    	Boolean retorno = new Boolean(false);
    	
    	try {
    		Scheduler agenda = Planificador.getAgenda();
    		boolean borrada = false;
			boolean todasBorradas = true;
					
	    	for (int i = 0; i < tareas.length; i++) {    			
	    		log("Tarea a borrar: " + tareas[i].getTrabajo());
	    		
				if (tareas[i].getTrabajo() == null || tareas[i].getGrupoTrabajo() == null) {
					todasBorradas = false;
					log.error("Nombre o grupo de la tarea/trabajo a nulo");
				}
				else {
					agenda.unscheduleJob(tareas[i].getTrabajo(), tareas[i].getGrupoTrabajo());
					borrada = agenda.deleteJob(tareas[i].getTrabajo(), tareas[i].getGrupoTrabajo());
				}
					
	    		if (!borrada) { 
	    			todasBorradas = false;
	    			log("No se ha podido eliminar la tarea " + tareas[i].getTrabajo() + "  " 
	    					+ tareas[i].getGrupoTrabajo());
	    		}
	    		else
	    			log("Eliminada la tarea " + tareas[i].getTrabajo() + "  " + tareas[i].getGrupoTrabajo());
	    	}
	    	
	    	if (todasBorradas)
	    		retorno = Boolean.TRUE;
		}
    	catch (Exception e) {
    		log.error("Error: No se ha podido eliminar la tarea/s " + e);
    		throw e;
    	}
    	
        return retorno;	
    }

    /**
     * Obtención de los trabajos pendientes de ejecutar del grupo por defecto
     * El planificador permite programar tareas propias del sistema que 
     * puede que no sea interesante mostrarlas en la pantalla de administración de tareas 
     * @return tareasPendientes Un array con las tareas pendientes
     * @throws Exception
     */
    
    protected TareaVO[] handleObtenerTareasPendientes() 
    	throws java.lang.Exception
    {
    	TareaVO[] tareasPendientes = null;
    	TareaVO tarea = null;
    	List listaTareas = new ArrayList();
    	
    	try {
    		Scheduler agenda = Planificador.getAgenda();
	    			
			/* Recuperar triggers y del grupo por defecto */	        
	        String[] triggerNombres = agenda.getTriggerNames(CtesPlanificador.GRUPO_TRIGGER);
	            
	        for (int j = 0; j < triggerNombres.length; j++) {
	            log("Tareas pendientes: " + triggerNombres[j]);
	            Trigger trigerRecup = agenda.getTrigger(triggerNombres[j], CtesPlanificador.GRUPO_TRIGGER);
	            	            	
            	tarea = new TareaVO();
            	tarea.setTrabajo(trigerRecup.getJobName());
            	tarea.setGrupoTrabajo(trigerRecup.getJobGroup());
            	tarea.setTrigger(trigerRecup.getName());
            	tarea.setGrupoTrigger(trigerRecup.getGroup());
            	tarea.setFechaInicio(DateManager.dateToCalendar(trigerRecup.getStartTime()));	            		            	
            	
            	if (trigerRecup instanceof CronTrigger) { 
            		log("CronTrigger");
            		tarea.setCron(((CronTrigger)trigerRecup).getCronExpression());
            		String periodicidad = getPeriodicidadFromCron(((CronTrigger)trigerRecup).getCronExpression());
            		tarea.setPeriodicidad(periodicidad);
            	}
            	else {
            		log("Trigger");
            		tarea.setPeriodicidad(ConstantesAgrega.NO_PERIODICA);
            	}
            		
                listaTareas.add(tarea);
            }
	        
	        tareasPendientes = (TareaVO[])listaTareas.toArray(new TareaVO[0]);
		}
    	catch (Exception e) {
    		log.error("Error: " + e);
    		throw e;
    	}
   
        return tareasPendientes;
    }

    /**
     * Obtención de los trabajos en ejecución
     * @return tareasEnEjecucion Un array de tareas con las tareas que se estan ejecutando
     * @throws Exception
     */
    protected TareaVO[] handleObtenerTareasEnEjecucion() 
    	throws Exception
    {
    	TareaVO[] tareasEnEjecucion = null;
    	
    	/* Rellenar tareas en ejecucion de la base de datos */
    	try {
    		TareaEjecutadaDao tareaEjecutadaDao = this.getTareaEjecutadaDao();
    		TareaTrabajoFFinCriteria criterios = new TareaTrabajoFFinCriteria();
    		
    		criterios.setFechaFin(null);
    		   		
    		List list = tareaEjecutadaDao.buscarTareaByTrabajoAndFFin(
    				tareaEjecutadaDao.TRANSFORM_TAREAEJECUTADAVO, criterios);
    		
    		tareasEnEjecucion = new TareaVO[list.size()];
    		
    		for (int i = 0; i < list.size(); i++) {
    			tareasEnEjecucion[i] = new TareaVO();
    			tareasEnEjecucion[i].setTrabajo(((TareaEjecutadaVO)list.get(i)).getTrabajo());
    			tareasEnEjecucion[i].setGrupoTrabajo(((TareaEjecutadaVO)list.get(i)).getGrupoTrabajo());
    		}
    	}
    	catch (Exception e) {
    		log.error("Error: " + e);
    		throw e;
    	}
    	
        return tareasEnEjecucion;
    }

    /**
     * Obtención de los trabajos ejecutados
     * @return res Un array con las tareas ejecutadas
     * @throws Exception
     */
    protected TareaEjecutadaVO[] handleObtenerTrabajosEjecutados() 
    	throws Exception
    {
    	TareaEjecutadaVO[] res = null;
    	
    	try {
    		TareaEjecutadaDao tareaEjecutadaDao = this.getTareaEjecutadaDao();    		
    		TrabajosActivosCriteria criterios = new TrabajosActivosCriteria();
    		criterios.setFechaBaja(null);
    		   		
    		List listaTareaEjecutadas = tareaEjecutadaDao.buscarTrabajosActivos(
    				tareaEjecutadaDao.TRANSFORM_TAREAEJECUTADAVO, criterios);
    		res = (TareaEjecutadaVO[])listaTareaEjecutadas.toArray(new TareaEjecutadaVO[0]);    		    		
		}
    	catch (Exception e) {
    		log.error("Error: " + e);
    		throw e;
    	}
    	
        return res;
    }

    
    /**
     * Eliminar un trabajo ejecutado junto con el informe asociado.
     * Eliminamos un registro de la entity de tareasejecutas partiendo del id que nos pasan por parametro
     * @param idTrabajo El id de la trabajo
     * @return retorno Indica si todo ha ido bien(true) o si ha habido algun error(false)
     * @throws Exception
     */

    protected Boolean handleEliminarTrabajoEjecutado(Long[] idTrabajo) 
    	throws Exception
    {
    	Boolean retorno = new Boolean(false);
    	
    	try {
    		for (int i = 0; i < idTrabajo.length; i++) {   
    			log("Trabajo a eliminar: " + idTrabajo[i]);
    			
    			TareaEjecutada entity = this.getTareaEjecutadaDao().load(idTrabajo[i]);
    			entity.setFechaBaja(new GregorianCalendar());
    			this.getTareaEjecutadaDao().update(entity);    			
    		}
    		
    		retorno = Boolean.TRUE;
    	}
    	catch (Exception e) {
    		log.error("Error: No se ha podido eliminar el trabajo ejecutado " + e);
    		throw e;
    	}
    	
        return retorno;
    }

    /**
     * Obtención del informe asociado a la ejecución de un trabajo
     * Recuperamos un informe sacando la fecha de la descripcion de un trabajo segun el id que le pasamos
     * @param idTarea El id de la tarea
     * @return informe Las filas de las entitys que corresponden con el id de tarea ejecutada que se ha 
     * pasado como parametro
     * @throws Exception
     */
    protected RegistroTareaEjecutadaVO[] handleObtenerInformeTrabajo(Long idTarea) 
    	throws java.lang.Exception
    {
    	RegistroTareaEjecutadaVO[] informe = null;
    	
    	try {
    		Collection informeCol = this.getTareaEjecutadaDao().load(idTarea).getRegistroTareaEjecutadas();
    		log("Tareas ejecutadas: " + informeCol);
    		Iterator it = informeCol.iterator();
    		informe = new RegistroTareaEjecutadaVO[informeCol.size()]; 
    		int i=0;
    		
    		while (it.hasNext()) {
    			RegistroTareaEjecutada reg = (RegistroTareaEjecutada)it.next();
    			informe[i] = new RegistroTareaEjecutadaVO();
    			informe[i].setDescripcion(reg.getDescripcion());
    			informe[i].setFecha(reg.getFecha());
    			informe[i].setEstado(reg.getEstado());
    			informe[i].setCodigo(reg.getCodigo());
    			i++;	
    		}
		}
    	catch (Exception e) {
    		log.error("Error: No se ha podido obtener el informe " + e);
    		throw e;
    	}
    	
        return informe;
    }

    /**
     * Obtenemos una tarea que queremos modificar en la carga de ODEs
     * @param tarea Tarea a modificar
     * @return tareaModificar La tarea modificada
     * @throws Exception
     */
    protected TareaCargaODEsVO handleObtenerTareaModificarCargaODEs(TareaVO tarea)
    	throws java.lang.Exception
    {
    	TareaCargaODEsVO tareaModificar = null;
    	
    	try {
    		log("Tarea a modificar: " + tarea.getTrigger() + " " + tarea.getGrupoTrigger());
    		
    		Scheduler agenda = Planificador.getAgenda();
    		
    		JobDetail trabajo = agenda.getJobDetail(tarea.getTrabajo(), tarea.getGrupoTrabajo());
			Trigger trigerModif = agenda.getTrigger(tarea.getTrigger(), tarea.getGrupoTrigger());
			
			log("trigerModif: " + trigerModif.toString());
			tareaModificar = new TareaCargaODEsVO();
			
			tareaModificar.setPeriodicidad((String)trabajo.getJobDataMap().get(CtesPlanificador.PERIODICIDAD));
			ArrayList parametros = (ArrayList)trabajo.getJobDataMap().get(CtesPlanificador.PARAMETROS);
			tareaModificar.setPathODE((String) parametros.get(0));
			tareaModificar.setPathODEsCargados((String) parametros.get(1));
			tareaModificar.setPathODEsNoCargados((String) parametros.get(2));
			tareaModificar.setTrabajo(trabajo.getName());			
			tareaModificar.setGrupoTrabajo(trabajo.getGroup());
			tareaModificar.setTrigger(trigerModif.getName());
			tareaModificar.setGrupoTrigger(trigerModif.getGroup());
			tareaModificar.setFechaInicio(DateManager.dateToCalendar(trigerModif.getStartTime()));	
			tareaModificar.setTipoTarea(Planificador.ultimoCampo(trabajo.getJobClass().toString()));
			tareaModificar.setMsgPublicado((String) parametros.get(3));
			tareaModificar.setMsgNoPublicado((String) parametros.get(4));
			tareaModificar.setMsgDescripcionTrabajo((String) parametros.get(5));
			tareaModificar.setSobrescribir((String) parametros.get(6));
			
			log("Tarea a modificar: " + tareaModificar.toString());
   		}
    	catch (Exception e) {
    		log.error("Error: No se ha podido modificar la tarea " + e);
    		throw e;
    	}

        return tareaModificar;
    }

    /** 
     * Ejecutar manualmente un trabajo
     * Se lanza una tarea con un determinado trigger que pasamos por parametro.
     * @param tarea 
     * @return retorno Indica si todo ha ido bien(true) o si ha habido algun error(false)
     * @throws Exception
     */
    protected Boolean handleLanzarTarea(TareaVO tarea) 
    	throws java.lang.Exception
    {
    	log("Lanzar tarea " + tarea.getTrabajo() + " " + tarea.getGrupoTrabajo() + " trigger: "    
    			+ tarea.getTrigger() + " " + tarea.getGrupoTrigger());
    	Boolean retorno = new Boolean(false);
 
		try {    	
			Scheduler agenda = Planificador.getAgenda();
	
			String trabajoNuevo = tarea.getTrabajo() + CtesPlanificador.SEPARACION_TAREA
					+ Planificador.getFechaAAMMDDHHMMSS();
			
			String nombreTrigger = CtesPlanificador.TRIGGER + Planificador.getFechaAAMMDDHHMMSS();
			
			Trigger triggerNuevo = new SimpleTrigger(nombreTrigger, tarea.getGrupoTrigger(),
					new Date(System.currentTimeMillis()+ 3L*1000));
			
			JobDetail jobTarea = agenda.getJobDetail(tarea.getTrabajo(), tarea.getGrupoTrabajo());
			JobDetail jobTareaNueva = new JobDetail();			
			jobTareaNueva.setName(trabajoNuevo);
			jobTareaNueva.setGroup(jobTarea.getGroup());
			jobTareaNueva.setJobClass(jobTarea.getJobClass());
			jobTareaNueva.setJobDataMap(jobTarea.getJobDataMap());
		
			Date ft = agenda.scheduleJob(jobTareaNueva, triggerNuevo);
			
			/* Realizamos una pausa de unos segundos para que se lance la tarea */	 
			log("Antes del sleep");
            Thread.sleep(6L * 1000L); 
            log("Despues del sleep");

            agenda.resumeAll();
            this.reiniciarPlanificador();
            Thread.sleep(1L * 1000L);
            
			log("Se ha lanzado manualmente " + trabajoNuevo + " " + tarea.getGrupoTrabajo() + nombreTrigger);
			
			retorno = Boolean.TRUE;
		}
		catch (Exception e) {
    		log.error("No se ha podido lanzar el trabajo manualmente " + e);
    		throw e;
		}		
		
        return retorno;
    }
       
    /**
     * Parada de un trabajo en ejecución
     * Se interrupe la ejecucion de una tarea
     * @param trabajo
     * @return boo Indica si todos ha ido bien(true) o si ha habido algun error(false)
     * @throws Exception
     */
    protected Boolean handlePararTarea(TrabajoVO trabajo)
        throws java.lang.Exception
    {
    	log("Parar tarea " + trabajo.getTrabajo() + " " + trabajo.getGrupoTrabajo());
    	boolean boo = false;
    	
    	try {
    		Scheduler agenda = Planificador.getAgenda();		
    		  		
    		/*
    		JobDetail jobTarea =  agenda.getJobDetail(trabajo.getTrabajo(), trabajo.getGrupoTrabajo());

    		if (jobTarea.getClass() == CargaODEs.class)
    		{	
    			/* Debido a que no funciona correctamente la interrupción de la tarea de la clase Scheduler de Quartz 1.6.0 
    			 * para parar la tarea de Carga de ODEs se mueven los ficheros a la carpeta de no cagados  
    			ArrayList parametros = (ArrayList)jobTarea.getJobDataMap().get(CtesPlanificador.PARAMETROS);
    			String pathODEs = (String) parametros.get(0);
    			String pathODEsNoCargados = (String) parametros.get(2);
    			
    			File ODEs = new File(pathODEs);
    			File[] arrayList = ODEs.listFiles();
    		
    			for (int i=0; i<arrayList.length; i++)
    			{	
    				if (!arrayList[i].isDirectory())
    				{
    					File ficheroNoCargado = new File(pathODEsNoCargados + File.separator + arrayList[i].getName());
    					if (ficheroNoCargado.exists()) 
    					{
    						log("Ya existe un fichero con ese nombre: " + ficheroNoCargado.getAbsolutePath() + " en la carpeta de no cargados. Se elimina para mover el nuevo fichero");
    						ficheroNoCargado.delete();
    					}
    						
    					boolean mov = arrayList[i].renameTo(ficheroNoCargado);
    					log("Fichero movido " + ficheroNoCargado.getAbsolutePath() + " " + mov);    					   					
    				}
    			}
    		}
    		*/	
    		/* No funciona correctamente el método interrupt del Scheduler 
    		 * debido a que el método getCurrentlyExecutingJobs() no siempre devuelve bien los trabajos ejecutandose */
    		boo = agenda.interrupt(trabajo.getTrabajo(), trabajo.getGrupoTrabajo());
    		log("Trabajo interrumpido: " + boo);
		}	
    	catch (Exception e) {
    		log.error("No se ha podido parar el trabajo manualmente " + e);
    		throw e;
    	}		
    	
    	/* Registrar la parada de la tarea */
    	try {
    		TareaEjecutadaDao tareaEjecutadaDao = this.getTareaEjecutadaDao();
    		TareaTrabajoFFinCriteria criterios = new TareaTrabajoFFinCriteria();
    		criterios.setTrabajo(trabajo.getTrabajo());
    		criterios.setGrupoTrabajo(trabajo.getGrupoTrabajo());    		
    		List list = tareaEjecutadaDao.buscarTareaByTrabajoAndFFin(
    				tareaEjecutadaDao.TRANSFORM_TAREAEJECUTADAVO, criterios);
    		
    		if (list == null || list.size() == 0) 
    			return null;
    		else {
    			if (list.size() > 1)
    				log.warn("El trabajo " + trabajo.getTrabajo() + " del grupo" + trabajo.getGrupoTrabajo() 
    						+ " tiene procesos sin finalizar");
    			
    			TareaEjecutadaVO tarea = (TareaEjecutadaVO)list.get(0);
    			tarea.setFechaFin(new GregorianCalendar());
    			tarea.setEstado(ConstantesAgrega.TRABAJO_INTERRUMPIDO);
      			this.getSrvRegistroPlanificadorService().registrarTrabajoFechaFin(tarea);
    		}
    	}
    	catch (Exception e) {
    		log.error("Error al registrar la parada manual de la tarea " + e);
    	}
    	
        return new Boolean(boo);
    }
    
    /**
     * Inicia el planificador si no está iniciado
     * @return boo Indica si el planificador se inicia o estaba iniciado(true) o si hay algún error(false)
     * @throws Exception  
     */
   
    protected Boolean handleIniciarPlanificador() 
    	throws java.lang.Exception
    {
    	boolean boo;
    	
    	try {
    		if (!Planificador.getAgenda().isStarted())
    			Planificador.getAgenda().start();
    		
    		boo = true;
    	}
    	catch (Exception e) {
    		log.error("No se ha podido iniciar el planificador " + e);
    		throw e;
    	}
    	
    	return new Boolean(boo);
    }
   
    /**
     * Para el planificador si está iniciado
     * @return 	boo Indica si el planificador se para o estaba parado(true) 
     * o si hay algún error(false)
     * @throws Exception  
     */
    protected Boolean handlePararPlanificador()
    	throws java.lang.Exception
    {
    	boolean boo;
    	
    	try {
    		if (Planificador.getAgenda().isStarted())
    			Planificador.getAgenda().shutdown();
    		
    		boo = true;
    	}
    	catch (Exception e) {
    		log.error("No se ha podido parar el planificador " + e);
    		throw e;
    	}
    	
    	return new Boolean(boo);
    }
    
    /**
     * Reinicia el planificador
     * @return 	boo Indica si el planificador se para o estaba parado(true) o si hay algún error(false)
     * @throws Exception  
     */
    protected Boolean handleReiniciarPlanificador()
    	throws java.lang.Exception
    {
    	boolean boo;
    	
    	try {
    		if (Planificador.getAgenda().isStarted()) 
    			this.pararPlanificador();
    		
    		this.iniciarPlanificador();
    		
    		boo = true;
    	}
    	catch (Exception e) {
    		log.error("Error: " + e);
    		throw e;
    	}
    	
    	return new Boolean(boo);
    }
    
    /**
     * Muestra en la situación que se encuentra el planificador
     * @return boo Indica si el planificador está arrancado(true)o si el planificador está parado(false)
     * @throws Exception
     */
    protected Boolean handleEstaIniciado()
    	throws java.lang.Exception
    {
    	boolean boo;
    	
    	try {
    		if (Planificador.getAgenda().isStarted())
    			boo = true;
    		else	
    			boo = false;
    	}
    	catch (Exception e) {
    		log.error("Error: " + e);
    		throw e;
    	}
    	
    	return new Boolean(boo);
    }
    
    /**
     * Creación de una tarea de carga de ODEs
     * @param datosTarea Datos de la tarea
     * @return tareaCreada Los datos de la tarea creada
     * @throws Exception
     *	
     */
    protected TareaCargaODEsVO handleCrearTareaCargaODEs(TareaCargaODEsVO datosTarea)
    	throws java.lang.Exception
    {    
    	TareaCargaODEsVO tareaCreada = new TareaCargaODEsVO();
    	TareaVO tareaRetornada = null;
    	TareaVO tareaGenerica = new TareaVO();
    	List parametrosTarea = new ArrayList();
    	String msgPublicado = CtesPlanificador.MSG_PUBLICADO;
    	String msgNoPublicado = CtesPlanificador.MSG_NOPUBLICADO;
    	 
    	try {
    		tareaGenerica.setTrabajo(datosTarea.getTrabajo());
    		tareaGenerica.setTrigger(datosTarea.getTrigger());
    		tareaGenerica.setFechaInicio(datosTarea.getFechaInicio());
    		tareaGenerica.setPeriodicidad(datosTarea.getPeriodicidad());
    		tareaGenerica.setGrupoTrabajo(datosTarea.getGrupoTrabajo());
    		tareaGenerica.setGrupoTrigger(datosTarea.getGrupoTrigger());
    		tareaGenerica.setUsuario(datosTarea.getUsuario());
    		tareaGenerica.setTipoTarea(datosTarea.getTipoTarea());
    		
    		log("Tarea generica: " + tareaGenerica);
    		
    		/* Mensajes internacionalizados que se muestran al incluir ODEs en la plataforma */
    		if (null != datosTarea.getMsgPublicado())
    			msgPublicado = datosTarea.getMsgPublicado();

    		if (null != datosTarea.getMsgNoPublicado())
    			msgNoPublicado = datosTarea.getMsgNoPublicado();

    		/* Validamos que existan los directorios de carga de ODEs */
    		File fODEs = new File(datosTarea.getPathODE()); 
    		if (!fODEs.exists()) {
    			log("El directorio de carga de ODEs no existe. " + fODEs.getAbsolutePath());
    			tareaCreada.setError("tareas.NoExisteDirectorioODEs");
    			return tareaCreada;
    		}
    		fODEs = new File(datosTarea.getPathODEsCargados()); 
    		if (!fODEs.exists()) {
    			log("El directorio donde mover los ODEs cargados no existe. " + fODEs.getAbsolutePath());
    			tareaCreada.setError("tareas.NoExisteDirectorioODEsCargados");
    			return tareaCreada;
    		}
    		fODEs = new File(datosTarea.getPathODEsNoCargados()); 
    		if (!fODEs.exists()) {
    			log("El directorio donde mover los ODEs no cargados no existe. " + fODEs.getAbsolutePath());
    			tareaCreada.setError("tareas.NoExisteDirectorioODEsNoCargados");
    			return tareaCreada;
    		}
    		
    		/* Parámetros propios de la tarea */
    		parametrosTarea.add(datosTarea.getPathODE());
    		parametrosTarea.add(datosTarea.getPathODEsCargados());
    		parametrosTarea.add(datosTarea.getPathODEsNoCargados());
    		parametrosTarea.add(msgPublicado);
    		parametrosTarea.add(msgNoPublicado);
    		parametrosTarea.add(datosTarea.getTrabajo());
    		parametrosTarea.add(datosTarea.getSobrescribir());
    		
    		tareaRetornada = handleCrearTarea(tareaGenerica, parametrosTarea, CargaODEs.class);
    		
    		log("Parámetros de la tarea: " + parametrosTarea);
    		
    		/* Cargamos los datos de la tarea creada en el objeto */
    		tareaCreada.setTrabajo(tareaRetornada.getTrabajo());
    		tareaCreada.setGrupoTrabajo(tareaRetornada.getGrupoTrabajo()); 
    		tareaCreada.setTrigger(tareaRetornada.getTrigger());
    		tareaCreada.setGrupoTrigger(tareaRetornada.getGrupoTrabajo());
    		tareaCreada.setFechaInicio(tareaRetornada.getFechaInicio());		
    		tareaCreada.setCron(tareaRetornada.getCron());
    		tareaCreada.setPeriodicidad(tareaRetornada.getPeriodicidad());
    		tareaCreada.setPathODE(datosTarea.getPathODE());			
    		tareaCreada.setPathODEsCargados(datosTarea.getPathODEsCargados());
    		tareaCreada.setPathODEsNoCargados(datosTarea.getPathODEsNoCargados());
    		tareaCreada.setTipoTarea(datosTarea.getTipoTarea());
    		tareaCreada.setSobrescribir(datosTarea.getSobrescribir());
    		
			log("Tarea creada: " + tareaCreada);
		}
    	catch (Exception e) {
    		log.error("Error: No se ha podido crear la tarea " + e);
    		throw e;
    	}
    	
        return tareaCreada;
    }
    
    /**
     * Modificación de los datos de una tarea de carga de ODEs
     * @param datosTarea Los datos que se quieren modificar en la tarea
     * @param modificarTarea El identificativo de la tarea a modificar
     * @return 	tarea Indica si se ha podido modificar(true) o si no se ha podido modificar(false)
     * @throws Exception
     * 
     * Se opta por eliminar el trabajo y crear uno nuevo ya que se permite modificar datos que pertenecen 
     * a la identificación de la tarea y que se almacenan en el contexto
     */
    protected TareaCargaODEsVO handleModificarTareaCargaODEs(TareaCargaODEsVO datosTarea, TrabajoVO modificarTarea) 
    	throws java.lang.Exception
    {
    	/* Modificación de una tarea */
    	log("Modificar tarea " + modificarTarea.getTrabajo() + " " + modificarTarea.getGrupoTrabajo() 
    			+ " usuario: " + datosTarea.getUsuario()/*.toString()*/);
    	Boolean boo = new Boolean(false);
    	TareaCargaODEsVO tarea = null;	
    	
    	try {
    		TrabajoVO[] datosJob = new TrabajoVO[1]; 
    		datosJob[0] = modificarTarea;
    		
    		/* Validamos que existan los directorios de carga de ODEs */
    		File fODEs = new File(datosTarea.getPathODE()); 
    		if (!fODEs.exists()) {
    			log("El directorio de carga de ODEs no existe. " + fODEs.getAbsolutePath());
    			tarea.setError("tareas.NoExisteDirectorioODEs");
    			return tarea;
    		}
    		fODEs = new File(datosTarea.getPathODEsCargados()); 
    		if (!fODEs.exists()) {
    			log("El directorio donde mover los ODEs cargados no existe. " + fODEs.getAbsolutePath());
    			tarea.setError("tareas.NoExisteDirectorioODEsCargados");
    			return tarea;
    		}
    		fODEs = new File(datosTarea.getPathODEsNoCargados()); 
    		if (!fODEs.exists()) {
    			log("El directorio donde mover los ODEs no cargados no existe. " + fODEs.getAbsolutePath());
    			tarea.setError("tareas.NoExisteDirectorioODEsNoCargados");
    			return tarea;
    		}
    		
    		/* Eliminamos la tarea */
    		boo = handleEliminarTareas(datosJob);
    		
    		if (boo.booleanValue()) {
    			log("Modificar tarea " + datosTarea.toString());
    			tarea = handleCrearTareaCargaODEs(datosTarea);
    		}
    	}	
    	catch (Exception e) {
    		log.error("No se ha podido modificar la tarea de carga de ODEs " + e);
    		throw e;
    	}		
	
    	return tarea;	  
    }
    
    /** 
     * Construcción de la cadena de programación de la tarea (cron) a partir de la periodicidad y la fecha de inicio
     *  @param fechaInicio Fecha de inicio de la tarea
     *  @param periodicidad Periodicidad de la tarea
     *  @return cron La expresión de la programación de la tarea en formato cron  
     * */
    protected String getCronFromPeriodicidad(Date fechaInicio, String periodicidad) 
    {
    	String cron = null;
    	Calendar fecha = new GregorianCalendar();
    	    	
    	fecha.setTime(fechaInicio);
    	StringBuffer hora = new StringBuffer(new Integer(fecha.get(Calendar.HOUR_OF_DAY)).toString());
    	StringBuffer minutos = new StringBuffer(new Integer(fecha.get(Calendar.MINUTE)).toString());
    	
    	if (ConstantesAgrega.DIARIA.equals(periodicidad)) {
    		log("Periodicidad diaria");
    		cron = "0 " + minutos + " " + hora + " * * ?";
    	}
    	else if (ConstantesAgrega.SEMANAL.equals(periodicidad)) {
    		log("Periodicidad semanal");
    		StringBuffer diaSemana = new StringBuffer(new Integer(fecha.get(Calendar.DAY_OF_WEEK)).toString());
    		cron = "0 " + minutos + " " + hora + " ? * " + diaSemana;
    	}
    	else if (ConstantesAgrega.MENSUAL.equals(periodicidad)) {
    		log("Periodicidad mensual");
    		StringBuffer diaMes = new StringBuffer(new Integer(fecha.get(Calendar.DAY_OF_MONTH)).toString());
    		cron = "0 " + minutos + " " + hora + " " + diaMes + " * ?"; 
    	}
    	else if (ConstantesAgrega.ANUAL.equals(periodicidad)) {
    		log("Periodicidad anual");
    		StringBuffer diaMes = new StringBuffer(new Integer(fecha.get(Calendar.DAY_OF_MONTH)).toString());
    		StringBuffer mes = new StringBuffer(new Integer(fecha.get(Calendar.MONTH) + 1).toString());
    		
    		cron = "0 " + minutos + " " + hora + " " + diaMes + " " + mes + " ? ";
    	}
    	else if (ConstantesAgrega.HORARIA.equals(periodicidad)) {
    		log("Periodicidad cada hora");
    		cron = "0 " + minutos + " * * * ?"; 
    	}
    	else {
    		log.error("Periodicidad no existente");
    		return null;
    	}
    	
    	return cron;    	    	
    }
    
    
    /** 

     * Construcción de la periodicidad a partir de la cadena de programación de la tarea (cron)
     *  @param cron Cadena de programacion de tarea en formati cron
     *  @return devolver Constante que indica 
     *                  N: No periodica
     *            D: Diaria
     *            S: Semanal
     *            M: Mensual
     *            A: Anual
     *            H: Horaria
     *    
     * */

    protected String getPeriodicidadFromCron(String cron) 

    {

      String [] partes=cron.split(" ");
      String devolver = null;


      if(partes[5].equals("?") && partes[4].equals("*") && partes[3].equals("*"))
            devolver =  ConstantesAgrega.DIARIA;
      else if(!partes[5].equals("?") && partes[4].equals("*") && partes[3].equals("?"))
            devolver =  ConstantesAgrega.SEMANAL;
      else if(partes[5].equals("?") && partes[4].equals("*") && !partes[3].equals("?") && !partes[3].equals("*"))
            devolver =  ConstantesAgrega.MENSUAL;
      else if(partes[5].equals("?") && !partes[4].equals("?") && !partes[4].equals("*") && !partes[3].equals("?") && !partes[3].equals("*"))
            devolver = ConstantesAgrega.ANUAL;
      else if(partes[2].equals("*"))
            devolver = ConstantesAgrega.HORARIA;
      else {
            log.error("Parseado Cron incorrecto");
            devolver = ConstantesAgrega.PERIODICA;
      }

      return devolver;
    }

    
    /**
     * Creación de una tarea genérica
     * @param tarea Datos comunes de la tarea 
     * @param parametrosTarea Parámetros propios de cada tarea
     * @param claseTrabajo Clase que implementa el trabajo a realizar
     * @return tareaCreada Un objeto TareaVO con los datos de la tarea creada 
     * @throws Exception
     *	
     */
       
    public TareaVO handleCrearTarea(TareaVO tarea, List parametrosTarea, Class claseTrabajo)
    	throws java.lang.Exception 
    {    
    	TareaVO tareaCreada = new TareaVO();
    	Trigger trigger = null;
    	String programacion = null;
    	String trabajo = null;
    	String grupoTrabajo = null;
    	String nombreTrigger = null;
    	String grupoTrigger = null;
    	  	
    	try {
    		grupoTrabajo = CtesPlanificador.GRUPO_JOBS;
    		
    		/* Asignación de nombre al trabajo y al triger/disparador */
    		if (tarea.getTrabajo() == null || tarea.getTrabajo().equals(""))    		
    			trabajo = CtesPlanificador.JOB + Planificador.getFechaAAMMDDHHMMSS();
    		else
    			trabajo = tarea.getTrabajo();
    	
    		if (tarea.getGrupoTrabajo() == null || tarea.getGrupoTrabajo().equals(""))    		
    			grupoTrabajo = CtesPlanificador.GRUPO_JOBS;
    		else
    			grupoTrabajo = tarea.getGrupoTrabajo();

    		if (tarea.getTrigger() == null || tarea.getTrigger().equals(""))    		
    			nombreTrigger = CtesPlanificador.TRIGGER + Planificador.getFechaAAMMDDHHMMSS();
    		else
    			nombreTrigger = tarea.getTrigger();
    		
    		if (tarea.getGrupoTrigger() == null || tarea.getGrupoTrigger().equals(""))    		
    			grupoTrigger = CtesPlanificador.GRUPO_TRIGGER;
    		else
    			grupoTrigger = tarea.getGrupoTrigger();

    		log("Tarea a crear: nombre " + trabajo + " grupo trabajo " + grupoTrabajo + " trigger " 
    				+ nombreTrigger + " grupo trigger " + grupoTrigger);
    		
    		TrabajoVO trab = new TrabajoVO();
    		trab.setTrabajo(trabajo);
    		trab.setGrupoTrabajo(grupoTrabajo);
    		
    		if(this.handleExisteTrabajo(trab).booleanValue()){
    			CrearTareaException excepcion = new CrearTareaException("Error: Ya existe una tarea con ese nombre");
        		log.error(excepcion);
        		throw excepcion;
    		}
    		
    		Scheduler agenda = Planificador.getAgenda();
    		log("La agenda: " + agenda.toString());
    			
    		/* Creación de la tarea/job */
    		JobDetail jobTarea = new JobDetail(trabajo, grupoTrabajo, claseTrabajo);
			
    		/* Situamos en el contexto los parámetros que se necesitarán en el trabajo */
    		jobTarea.getJobDataMap().put(CtesPlanificador.PERIODICIDAD, tarea.getPeriodicidad());
    		jobTarea.getJobDataMap().put(CtesPlanificador.PARAMETROS, parametrosTarea);
    		jobTarea.getJobDataMap().put(CtesPlanificador.USUARIO, tarea.getUsuario());
    		
    		log("Parámetros de la tarea en el contexto: " + jobTarea.toString());
    			
    		if (ConstantesAgrega.NO_PERIODICA.equals(tarea.getPeriodicidad())) {
    			log("Tarea carga de ODEs. No periódica: " + trabajo);
    		    	        	    
    			/* Creación de un trigger simple */
    			trigger = new SimpleTrigger(nombreTrigger, grupoTrigger, tarea.getFechaInicio().getTime());
    	       
    			/* Asociamos Trigger/Job */
    			Date ft = agenda.scheduleJob(jobTarea, trigger);    
    			
    			log(jobTarea.getFullName() + " se ha añadido a la agenda para dispararse a las: " + ft);						
    		}
    		else {
    			log("Tarea carga de ODEs. Periódica: " + trabajo);
    		    
    			/* Si es periódica crear la cadena del Cron con la fecha ini y la periodicidad */
    			programacion = getCronFromPeriodicidad(tarea.getFechaInicio().getTime(), tarea.getPeriodicidad());
    	    
    			trigger = new CronTrigger(nombreTrigger, grupoTrigger, trabajo, 
    					grupoTrabajo, tarea.getFechaInicio().getTime(), 
    					new GregorianCalendar(2200, Calendar.DECEMBER, 31).getTime(), programacion);
    	    		    	
    			/* Se añade la tarea/trabajo */ 
    			agenda.addJob(jobTarea, true);
    	    	
    			/* Se programa el disparador */ 
    			Date ft = agenda.scheduleJob(trigger);   	 
    	    	
    			log(jobTarea.getFullName() + " se ha añadido a la agenda para dispararse a las: " + ft
    						+ " y repetirse en base a la expresión: "+ ((CronTrigger)trigger).getCronExpression());
    		}    
    			
			/* Cargamos los datos de la tarea creada en el objeto */
			tareaCreada.setTrabajo(trigger.getJobName());
			tareaCreada.setGrupoTrabajo(trigger.getJobGroup());
			tareaCreada.setTrigger(trigger.getName());
			tareaCreada.setGrupoTrigger(trigger.getGroup());
			tareaCreada.setPeriodicidad(tarea.getPeriodicidad());
			tareaCreada.setCron(programacion);
			tareaCreada.setFechaInicio(DateManager.dateToCalendar(trigger.getStartTime()));
			tareaCreada.setTipoTarea(tarea.getTipoTarea());
			
			log("Tarea creada: " + tareaCreada.toString());

		}
    	catch (Exception e) {
    		log.error("Error: No se ha podido crear la tarea " + e);
    		throw e;    	
    	}
    	
        return tareaCreada;
    }
    
    /**
     * Obtención de todos los trabajos pendientes de ejecutar
     * @return tareasPendientes Un array con las tareas
     * @throws Exception
     */
    protected TareaVO[] handleObtenerTareasPendientesTodas()
        throws java.lang.Exception
    {
    	TareaVO[] tareasPendientes = null;
    	TareaVO tarea = null;
    	List listaTareas = new ArrayList();
    	
    	try {
    		Scheduler agenda = Planificador.getAgenda();
	    		
			/* Recuperar trigger y grupos de triggers */
			String[] triggersGrupos = agenda.getTriggerGroupNames();
	        
	        for (int i = 0; i < triggersGrupos.length; i++) {            
	        	String[] triggerNombres = agenda.getTriggerNames(triggersGrupos[i]);
	            
	            for (int j = 0; j < triggerNombres.length; j++) {
	            	log("Tareas pendientes: " + triggerNombres[j]);
	            	Trigger trigerRecup = agenda.getTrigger(triggerNombres[j], triggersGrupos[i]);
	            	            	
	            	tarea = new TareaVO();
	            	tarea.setTrabajo(trigerRecup.getJobName());
	            	tarea.setGrupoTrabajo(trigerRecup.getJobGroup());
	            	tarea.setTrigger(trigerRecup.getName());
	            	tarea.setGrupoTrigger(trigerRecup.getGroup());
	            	tarea.setFechaInicio(DateManager.dateToCalendar(trigerRecup.getStartTime()));	            		            	
	            	
	            	if (trigerRecup instanceof CronTrigger) 
	            		tarea.setCron(((CronTrigger)trigerRecup).getCronExpression());
	            	       	
	                 listaTareas.add(tarea);
	            }
	        }
	        log("Lista de tareas: " + listaTareas.toString());
	        tareasPendientes = (TareaVO[])listaTareas.toArray(new TareaVO[0]);
		}
    	catch (Exception e) {
    		log.error("Error: " + e);
    		throw e;
    	}
   
        return tareasPendientes;
    }   
    
    /**
     * Obtiene el informe de los sub-trabajos que son erroneos de un trabajo concreto
     * @param id El id indica el trabajo que se va a consultar
     * @return array El registro de tareas ejecutadas
     * @throws Exception
     * 
     */
	protected RegistroTareaEjecutadaVO[] handleObtenerInformeTrabajoErroneos(Long id) 
		throws Exception 
	{
		RegistroTareaEjecutadaDao registroDao = this.getRegistroTareaEjecutadaDao();
		log("Dao: " + registroDao.toString());
		
		TrabajosNoCorrectosCriteria criterios = new TrabajosNoCorrectosCriteria();
		log("Criterios: " + criterios.toString());
		criterios.setIdTrabajo(this.getTareaEjecutadaDao().load(id));
		criterios.setEstado(ConstantesAgrega.TRABAJO_ERRONEO);
		List list = registroDao.buscarTrabajosNoCorrectos(
				RegistroTareaEjecutadaDao.TRANSFORM_REGISTROTAREAEJECUTADAVO, criterios);
	 	
		if (list == null || list.size() == 0) 
            return null;
		else {
			RegistroTareaEjecutadaVO[] array = null;
			array = (RegistroTareaEjecutadaVO[])list.toArray(new RegistroTareaEjecutadaVO[0]);
			return (RegistroTareaEjecutadaVO[]) array;
		}	
	}

	
	/**
	 * Obtiene un trabajo ejecutado con el id de una tarea en concreto
	 * @param id El id de una tarea en concreto
	 * @return tarea La tarea con los datos correspodientes al trabajo con el id pasado por parametro
	 * @throws Exception
	 */
	protected TareaEjecutadaVO handleObtenerTrabajoEjecutado(Long id) 
		throws Exception 
	{
		TareaEjecutadaVO tarea= new TareaEjecutadaVO();
		
		try {
			tarea.setId(id);
			tarea.setGrupoTrabajo(this.getTareaEjecutadaDao().load(id).getGrupoTrabajo());
			tarea.setFechaFin(this.getTareaEjecutadaDao().load(id).getFechaFin());
			tarea.setFechaInicio(this.getTareaEjecutadaDao().load(id).getFechaInicio()); 
    		tarea.setDescripcion(this.getTareaEjecutadaDao().load(id).getDescripcion());
    		tarea.setTrabajo(this.getTareaEjecutadaDao().load(id).getTrabajo());
		}
		catch (Exception e) {
			log.error("Error " + e);
    		throw e;
		}
		return tarea;
	}

	
	/**
	 * Crea la una tarea del tipo reindexado
	 * @param datosTarea Los datos correspodientes a la tarea reindexada
	 * @return tareaCreada Una tarea del tipo reindexada
	 * @throws Exception
	 */
	protected TareaReindexadoVO handleCrearTareaReindexado(TareaReindexadoVO datosTarea) 
		throws Exception 
	{
		TareaReindexadoVO tareaCreada = new TareaReindexadoVO();
		TareaVO tareaRetornada = null;
		TareaVO tareaGenerica = new TareaVO();
		List parametrosTarea = new ArrayList();
	   	String msgReindexado = CtesPlanificador.MSG_REINDEXADO;
    	String msgNoReindexado = CtesPlanificador.MSG_NOREINDEXADO;
    	
		try {
			tareaGenerica.setTrabajo(datosTarea.getTrabajo());
			tareaGenerica.setTrigger(datosTarea.getTrigger());
			tareaGenerica.setFechaInicio(datosTarea.getFechaInicio());
			tareaGenerica.setPeriodicidad(datosTarea.getPeriodicidad());
			tareaGenerica.setGrupoTrabajo(datosTarea.getGrupoTrabajo());
			tareaGenerica.setGrupoTrigger(datosTarea.getGrupoTrigger());
			tareaGenerica.setUsuario(datosTarea.getUsuario());
			
			log("Tarea genérica: " + tareaGenerica.toString());
			
			/* Mensajes internacionalizados que se muestran al reindexar los ODEs de la plataforma */
    		if (null != datosTarea.getMsgReindexado())
    			msgReindexado = datosTarea.getMsgReindexado();

    		if (null != datosTarea.getMsgNoReindexado())
    			msgNoReindexado = datosTarea.getMsgNoReindexado();
    		    	
			/* Parámetros propios de la tarea */
			parametrosTarea.add(datosTarea.getRepositorioIndices());
    		parametrosTarea.add(msgReindexado);
    		parametrosTarea.add(msgNoReindexado);
    		parametrosTarea.add(datosTarea.getTrabajo());
			
			tareaRetornada = handleCrearTarea( tareaGenerica, parametrosTarea, Reindexado.class);
			log("Parámetros tarea: " + parametrosTarea.toString());
			/* Cargamos los datos de la tarea creada en el objeto */
			tareaCreada.setTrabajo(tareaRetornada.getTrabajo());
			tareaCreada.setGrupoTrabajo(tareaRetornada.getGrupoTrabajo()); 
			tareaCreada.setTrigger(tareaRetornada.getTrigger());
			tareaCreada.setGrupoTrigger(tareaRetornada.getGrupoTrigger());
			tareaCreada.setFechaInicio(tareaRetornada.getFechaInicio());		
			tareaCreada.setCron(tareaRetornada.getCron());
			tareaCreada.setPeriodicidad(tareaRetornada.getPeriodicidad());
			tareaCreada.setRepositorioIndices(datosTarea.getRepositorioIndices());

			log("Tarea creada: " + tareaCreada.toString());
		}
		catch (Exception e) {
    		log.error("Error: No se ha podido crear la tarea. " + e);
    		throw e;			
		}
			
		return tareaCreada;
	}

	
	/**
	 * Modificación de los datos de una tarea de Reindexado
	 * @param datosTarea Datos de la tarea de reindexado
	 * @param trabajo Tarea que hay que modificar con los datos de reindexado
	 * @return tarea Tarea modificada de reindexado
	 * @throws Exception
	 */
	protected TareaReindexadoVO handleModificarTareaReindexado(TareaReindexadoVO datosTarea, TrabajoVO trabajo)
			throws Exception 
	{
		log("Modificar tarea " + trabajo.getTrabajo() + " " + trabajo.getGrupoTrabajo() 
			+ " usuario: " + datosTarea.getUsuario()/*.toString()*/);
		
		Boolean boo = new Boolean(false);
		TareaReindexadoVO tarea = null;		
		
		try {
			TrabajoVO[] datosJob = new TrabajoVO[1]; 
			datosJob[0] = trabajo;
			
			/* Eliminamos la tarea */
			log("Se elimina la tarea " + datosJob.toString());
			boo = handleEliminarTareas(datosJob);
			
			if (boo.booleanValue()) 
				tarea = handleCrearTareaReindexado(datosTarea);    		
	
		}	
		catch (Exception e) {
			log.error("No se ha podido modificar la reindexacion " + e);
			throw e;
		}		
	
		return tarea;	  
	}
	
	
	/**
	 * Obtiene una tarea Reindexada a partir de una tarea
	 * @param tarea Una tarea que identifica que tarea reindexada debemos coger
	 * @return tareaModificar Una tarea reindexada rellena que corresponde a la tarea pasada por parametro
	 * @throws Exception
	 */
	protected TareaReindexadoVO handleObtenerTareaReindexado(TareaVO tarea)
    		throws java.lang.Exception
    {
		TareaReindexadoVO tareaModificar = null;
	
		try {
			log("Tarea a modificar: " + tarea.getTrigger() + " " + tarea.getGrupoTrigger());
		
			Scheduler agenda = Planificador.getAgenda();
    		
    		JobDetail trabajo = agenda.getJobDetail(tarea.getTrabajo(), tarea.getGrupoTrabajo());
			Trigger trigerModif = agenda.getTrigger(tarea.getTrigger(), tarea.getGrupoTrigger());
			
			log("trigerModif: " + trigerModif.toString());
			tareaModificar = new TareaReindexadoVO();
			
			tareaModificar.setPeriodicidad((String)trabajo.getJobDataMap().get(CtesPlanificador.PERIODICIDAD));
			ArrayList parametros = (ArrayList)trabajo.getJobDataMap().get(CtesPlanificador.PARAMETROS);			
			tareaModificar.setTrabajo(trabajo.getName());			
			tareaModificar.setGrupoTrabajo(trabajo.getGroup());
			tareaModificar.setTrigger(trigerModif.getName());
			tareaModificar.setGrupoTrigger(trigerModif.getGroup());
			tareaModificar.setFechaInicio(DateManager.dateToCalendar(trigerModif.getStartTime()));	
			tareaModificar.setTipoTarea(Planificador.ultimoCampo(trabajo.getJobClass().toString()));
			tareaModificar.setRepositorioIndices((String) parametros.get(0));
			tareaModificar.setMsgReindexado((String) parametros.get(1));
			tareaModificar.setMsgNoReindexado((String) parametros.get(2));
			tareaModificar.setMsgDescripcionTrabajo((String) parametros.get(3));
			
			log("Tarea a modificar: " + tareaModificar.toString());
		}
		catch (Exception e) {
			log.error("Error: No se ha podido modificar la tarea " + e);
			throw e;
		}

		return tareaModificar;
    }

	
	/**
	 * Metodo que se encarga de crear una tarea de eliminacion de ODEs en estado no disponible.
	 * @param datosTarea Parametros de la tarea de eliminacion de ODEs no publicados.
	 * @return TareaEliminaNoDisponiblesVO Una tarea del tipo eliminar no disponible
	 * @throws Exception
	 */
	protected TareaEliminaNoDisponiblesVO handleCrearTareaEliminarNoDisponibles(TareaEliminaNoDisponiblesVO datosTarea) throws Exception {
		TareaEliminaNoDisponiblesVO tareaCreada = new TareaEliminaNoDisponiblesVO();
		TareaVO tareaRetornada = null;
		TareaVO tareaGenerica = new TareaVO();
		List parametrosTarea = new ArrayList();
	   	String msgEliminaciones = CtesPlanificador.MSG_ELIMINACIONODES_OK;
    	String msgNoEliminaciones = CtesPlanificador.MSG_ELIMINACIONODES_KO;
    			
		try {
			tareaGenerica.setTrabajo(datosTarea.getTrabajo());
			tareaGenerica.setTrigger(datosTarea.getTrigger());
			tareaGenerica.setFechaInicio(datosTarea.getFechaInicio());
			tareaGenerica.setPeriodicidad(datosTarea.getPeriodicidad());
			tareaGenerica.setGrupoTrabajo(datosTarea.getGrupoTrabajo());
			tareaGenerica.setGrupoTrigger(datosTarea.getGrupoTrigger());
			tareaGenerica.setUsuario(datosTarea.getUsuario());
			
			log("Tarea genérica: " + tareaGenerica.toString());
			
			/* Mensajes internacionalizados que se muestran al eliminar los ODEs de la plataforma */
    		if (null != datosTarea.getMsgEliminado())
    			msgEliminaciones = datosTarea.getMsgEliminado();

    		if (null != datosTarea.getMsgNoEliminado())
    			msgNoEliminaciones = datosTarea.getMsgNoEliminado();

			/* Parámetros propios de la tarea */
			parametrosTarea.add(datosTarea.getFechaDesde());
			parametrosTarea.add(datosTarea.getFechaHasta());
    		parametrosTarea.add(msgEliminaciones);
    		parametrosTarea.add(msgNoEliminaciones);
    		parametrosTarea.add(datosTarea.getTrabajo());
			
			tareaRetornada = handleCrearTarea( tareaGenerica, parametrosTarea, EliminarNoDisponibles.class);
			log("Parámetros tarea: " + parametrosTarea.toString());
			/* Cargamos los datos de la tarea creada en el objeto */
			tareaCreada.setTrabajo(tareaRetornada.getTrabajo());
			tareaCreada.setGrupoTrabajo(tareaRetornada.getGrupoTrabajo()); 
			tareaCreada.setTrigger(tareaRetornada.getTrigger());
			tareaCreada.setGrupoTrigger(tareaRetornada.getGrupoTrigger());
			tareaCreada.setFechaInicio(tareaRetornada.getFechaInicio());		
			tareaCreada.setCron(tareaRetornada.getCron());
			tareaCreada.setPeriodicidad(tareaRetornada.getPeriodicidad());

			log("Tarea creada: " + tareaCreada.toString());
		}
		catch (Exception e) {
    		log.error("Error: No se ha podido crear la tarea. " + e);
    		throw e;			
		}
			
		return tareaCreada;
	}

	/**
	 * Este metodo modifica una tarea de eliminacion de ODEs no disponibles.
	 * @param datosTarea Nuevos datos de la tarea de eliminar ODEs no disponibles.
	 * @param trabajo Tarea que hay que modificar con los datos de reindexado
	 * @return TareaEliminaNoDisponiblesVO Tarea del tipo eliminar no disponible
	 * @throws Exception
	 */
	protected TareaEliminaNoDisponiblesVO handleModificarTareaEliminarNoDisponibles(TareaEliminaNoDisponiblesVO datosTarea, TrabajoVO trabajo) throws Exception {
		log("Modificar tarea " + trabajo.getTrabajo() + " " + trabajo.getGrupoTrabajo() 
				+ " usuario: " + datosTarea.getUsuario());
			
			Boolean boo = new Boolean(false);
			TareaEliminaNoDisponiblesVO tarea = null;		
			
			try {
				TrabajoVO[] datosJob = new TrabajoVO[1]; 
				datosJob[0] = trabajo;
				
				/* Eliminamos la tarea */
				log("Se elimina la tarea " + datosJob.toString());
				boo = handleEliminarTareas(datosJob);
				
				if (boo.booleanValue()) 
					tarea = handleCrearTareaEliminarNoDisponibles(datosTarea);    		
		
			}	
			catch (Exception e) {
				log.error("No se ha podido modificar la tarea eliminar ODEs " + e);
				throw e;
			}		
		
			return tarea;	
	}

	/**
	 * Este metodo devuelve la tarea de eliminacion de ODEs no disponibles que coincida con la tarea.
	 * @param tarea Tarea que se quiere obtener.
	 * @return TareaEliminaNoDisponiblesVO Una tarea de eliminacion rellena que corresponde a la tarea pasada por parametro
	 * @throws Exception
	 */
	protected TareaEliminaNoDisponiblesVO handleObtenerTareaEliminarrNoDisponibles(TareaVO tarea) throws Exception {
		TareaEliminaNoDisponiblesVO tareaModificar = null;
		
		try {
			log("Tarea a modificar: " + tarea.getTrigger() + " " + tarea.getGrupoTrigger());
		
			Scheduler agenda = Planificador.getAgenda();
    		
    		JobDetail trabajo = agenda.getJobDetail(tarea.getTrabajo(), tarea.getGrupoTrabajo());
			Trigger trigerModif = agenda.getTrigger(tarea.getTrigger(), tarea.getGrupoTrigger());
			
			log("trigerModif: " + trigerModif.toString());
			tareaModificar = new TareaEliminaNoDisponiblesVO();
			
			tareaModificar.setPeriodicidad((String)trabajo.getJobDataMap().get(CtesPlanificador.PERIODICIDAD));
			ArrayList parametros = (ArrayList)trabajo.getJobDataMap().get(CtesPlanificador.PARAMETROS);
			log("Parametros " + parametros.toString());
			tareaModificar.setTrabajo(trabajo.getName());			
			tareaModificar.setGrupoTrabajo(trabajo.getGroup());
			tareaModificar.setTrigger(trigerModif.getName());
			tareaModificar.setGrupoTrigger(trigerModif.getGroup());
			tareaModificar.setFechaInicio(DateManager.dateToCalendar(trigerModif.getStartTime()));	
			tareaModificar.setTipoTarea(Planificador.ultimoCampo(trabajo.getJobClass().toString()));			
			tareaModificar.setFechaDesde((GregorianCalendar)parametros.get(0));
			tareaModificar.setFechaHasta((GregorianCalendar)parametros.get(1));
			tareaModificar.setMsgEliminado((String) parametros.get(2));
			tareaModificar.setMsgNoEliminado((String) parametros.get(3));
			tareaModificar.setMsgDescripcionTrabajo((String) parametros.get(4));
			
		}
		catch (Exception e) {
			log.error("Error: No se ha podido obtener la tarea de elimina ODEs " + e);
			throw e;
		}

		return tareaModificar;
	}

	/** 
	 *  Metodo fachada para la eliminacion de los ODEs en estado no disponible que hayan pasado a dicho 
	 *  estado en un periodo concreto de tiempo.
	 * @param fechaInicio Periodo de inicio desde el que se esta interesado en borrar ODEs no disponibles.
	 * @param fechaFin Periodo de fin desde el que se esta interesado en borrar ODEs no disponibles.
	 * 	@return String Devuelve lo mismo que la correspondiente llamada al servicio de publicacion.
	 * @throws Exception
	 * */
	protected String handleEliminarNoDisponibles(Calendar fechaInicio, Calendar fechaFin, Long idTarea) throws Exception {
		
		EliminarNoDisponiblesVO paramEliminar = new EliminarNoDisponiblesVO();
		paramEliminar.setFechaFin(fechaFin);
		paramEliminar.setFechaInicio(fechaInicio);
		paramEliminar.setIdUsuarios(new String[]{});
		paramEliminar.setIdTarea(idTarea);
		
		try {
			EliminarResultadoVO[] resultados = this.getSrvPublicacionService().eliminarNoDisponibles(paramEliminar);
			if (resultados!= null && resultados.length >0)
			{
				log.debug("ODEs afectados por la elmininacion["+resultados.length+"]");
				return ""+resultados.length;
			}
		} 
		catch (Exception e) {
			log.error("Error: No se ha podido realizar el eliminado de ODEs " + e);
			throw e;
		}
		return "0";
	}	
	
	/** 
	 *  Método que llama al servicio externo de publicación
	 * 	@param pif Objeto Digital Educativo comprimido (PIF)
	 * 	@param idUsuario Identificador del usuario
	 * 	@param comentarios Los comentarios que se quieran incluir en la publicación
	 * 	@param sobrescribir Determina si el ODE se debe sobrescribir o no (s/n)
	 * 	@return devolver Indica si todo va bien(true) o si no se ha podido publicar(false)
	 * @throws Exception
	 * */
	protected String handlePublicarPIF(DataHandler pif, String idUsuario, String comentarios, String sobrescribir, String titulo) 
		throws Exception 
	{
		ResultadoOperacionVO res = this.getSrvPublicacionService().publicarPIF(pif, idUsuario, comentarios, sobrescribir,titulo);
		String codPublicacion = res.getIdResultado();
		if (res.getDescripcion() != null && !res.getDescripcion().equals(""))
			codPublicacion+= ";"+ res.getDescripcion();  // concatenamos al codigo de error la descripcion si existe.
		return codPublicacion;	
	}
	
	/** 
	 * Recuperación del tipo de la tarea
	 * @param trabajo  
	 * @return tipoTarea La clase que ejecuta la tarea
	 * @throws Exception
	 * 
	 */
	protected String handleObtenerTipoTarea(TrabajoVO trabajo) 
		throws Exception 
	{
    	String tipoTarea = null;
    	JobDetail trabajoDetalle = null;
    	
    	try {    		
    		Scheduler agenda = Planificador.getAgenda();    		
    		trabajoDetalle = agenda.getJobDetail(trabajo.getTrabajo(), trabajo.getGrupoTrabajo());    		
    		tipoTarea = Planificador.ultimoCampo(trabajoDetalle.getJobClass().toString());
        		
			log("Tipo tarea: " + tipoTarea);
   		}
    	catch (Exception e) {
    		log.error("Error: No se ha podido obtener el tipo de la tarea" + e);
    		throw e;
    	}

        return tipoTarea;	
	}
	
	
	/**
	 * Reindexado de una tarea
	 * @param repositorio Indice de repositorio (coincide con el locale)
	 * @param idTarea Identificador de la tarea
	 * @return objReindexados  
	 * @throws Exception
	 */
	protected Long handleReindexado(String repositorio, Long idTarea) 
		throws Exception 
	{
		Long objReindexados = null;
		ReindexarODEResultadoVO[] resultadosReindexado = null;
		try {
			SrvPublicacionService servicio = this.getSrvPublicacionService();
			RegeneracionIndiceVO paramRegenera = new RegeneracionIndiceVO();
			paramRegenera.setIdIdiomas(new String[]{repositorio});
			paramRegenera.setIdTarea(idTarea);
			resultadosReindexado = servicio.regeneraIndiceIdioma(paramRegenera);
			objReindexados = resultadosReindexado!= null?new Long(resultadosReindexado.length): new Long(0);
		}
		catch (Exception e) {
			log.error("Error: No se ha podido realizar el reindexado " + e);
			throw e;
		}
		
		return objReindexados;
	}

	/**
	 * Elimina los trabajos que se pasan por parametro
	 * Sólo se permite eliminar tareas del grupo por defecto de la administración
	 * @param trabajos Array de trabajos a eliminar
	 * @return devolver Indica si todo ha ido bien(true) o si ha habido algun error(false)
	 * 
	 */
	protected Boolean handleEliminarTareasAdm(TrabajoVO[] trabajos) 
		throws Exception 
	{
		for (int i = 0; i < trabajos.length; i++) {    			
			trabajos[i].setGrupoTrabajo(CtesPlanificador.GRUPO_JOBS);	
    	}
		
		Boolean devolver = handleEliminarTareas(trabajos);
		return devolver;
	}

	/** 
	 * Se comprueba si ya existe un trabajo con ese nombre o grupo
     * @param trabajo Trabajo que contiene el nombre del trabajo y el grupo ha comparar
     * @return 	devolver Indica si exite(true) o si no existe(false)
     * @throws Exception
     */
	
	protected Boolean handleExisteTrabajo(TrabajoVO trabajo) throws Exception 
	{
		Scheduler agenda = Planificador.getAgenda();
		Boolean devolver = Boolean.FALSE;
		// Recuperar trabajos y grupos de trabajo 
		String[] trabajosGrupos = agenda.getJobGroupNames();
		String grupoTrabajo = null;
		
		// Si el grupo de trabajo viene a nulo asignamos el grupo por defecto
   		if (trabajo.getGrupoTrabajo() == null || trabajo.getGrupoTrabajo().equals(""))    		
			grupoTrabajo = CtesPlanificador.GRUPO_JOBS;
		else
			grupoTrabajo = trabajo.getGrupoTrabajo();
		
		for (int i = 0; i < trabajosGrupos.length; i++)  {     
			//Comparo todos los grupos y si se llaman igual comparo los trabajo
			//devuelvo false si no encuentro las dos condicciones y true si las encuentro
			if(grupoTrabajo.equals(trabajosGrupos[i])) {	
				String[] trabajos = agenda.getJobNames(trabajosGrupos[i]);
		
				for (int j = 0; j < trabajos.length; j++) {
					if (trabajo.getTrabajo().equals(trabajos[j])) {
						log("Existe un trabajo con ese nombre " + trabajo.getTrabajo());
						devolver =  Boolean.TRUE;
						return devolver;
					}
				}
			}
		}
		
		return devolver;
	}
	
	/** 
	 * Se recuperan los trabajos ejecutados entre dos fechas
     * @param parametros Fechas entre las que recuperar los informes
     * @return 	res Informes ejecutados entre las dos fechas
     * @throws Exception
     */
	protected TareaEjecutadaVO[] handleObtenerTrabajosEjecutadosDesdeHasta(ParametrosVO parametros) 
		throws Exception 
	{
    	TareaEjecutadaVO[] res = null;
    	
    	try {
    		TareaEjecutadaDao tareaEjecutadaDao = this.getTareaEjecutadaDao();     		
        	TrabajosEjecutadosDesdeHastaCriteria criterios = new TrabajosEjecutadosDesdeHastaCriteria();
    		
    		criterios.setFechaDesde(parametros.getFechaDesde());
    		criterios.setFechaHasta(parametros.getFechaHasta());
        	
    		List listaTareaEjecutadas = tareaEjecutadaDao.buscarTrabajosDesdeHasta(
    				tareaEjecutadaDao.TRANSFORM_TAREAEJECUTADAVO, criterios);
    		    		
    		res = (TareaEjecutadaVO[])listaTareaEjecutadas.toArray(new TareaEjecutadaVO[0]);    		    		
		}
    	catch (Exception e) {
    		log.error("Error: " + e);
    		throw e;
    	}
    	
        return res;
	}
	
	private void log (Object obj)
	{
		if (log.isDebugEnabled())
			log.debug(obj);
	}

	
	/**
	 * Crea una tarea del tipo informes
	 * @param datosTarea Nuevos datos de la tarea generación de informes
	 * @return TareaInformesVO Tarea con los datos nuevos
	 * @throws Exception
	 */
	protected TareaInformesVO handleCrearTareaInformes(TareaInformesVO datosTarea) throws Exception {
		
		TareaInformesVO tareaCreada = new TareaInformesVO();
		TareaVO tareaRetornada = null;
		TareaVO tareaGenerica = new TareaVO();
		List parametrosTarea = new ArrayList();
		
		try {
			tareaGenerica.setTrabajo(datosTarea.getTrabajo());
			tareaGenerica.setTrigger(datosTarea.getTrigger());
			tareaGenerica.setFechaInicio(datosTarea.getFechaInicio());
			tareaGenerica.setPeriodicidad(datosTarea.getPeriodicidad());
			tareaGenerica.setGrupoTrabajo(datosTarea.getGrupoTrabajo());
			tareaGenerica.setGrupoTrigger(datosTarea.getGrupoTrigger());
			tareaGenerica.setUsuario(datosTarea.getUsuario());
			
			log("Tarea genérica: " + tareaGenerica.toString());
			
			/* Mensajes internacionalizados que se muestran al reindexar los ODEs de la plataforma */
    		if (null == datosTarea.getMsgInforme() || datosTarea.getMsgInforme().equals(""))
    			datosTarea.setMsgInforme(CtesPlanificador.MSG_INFORMES_OK);

    		if (null == datosTarea.getMsgNoInforme() || datosTarea.getMsgNoInforme().equals(""))
    			datosTarea.setMsgNoInforme(CtesPlanificador.MSG_INFORMES_KO);

    		if (null == datosTarea.getMsgDescripcionTrabajo() || datosTarea.getMsgDescripcionTrabajo().equals(""))
    			datosTarea.setMsgDescripcionTrabajo(datosTarea.getTrabajo());

			/* Parámetros propios de la tarea */
			parametrosTarea.add(datosTarea);
    		    		
			tareaRetornada = handleCrearTarea (tareaGenerica, parametrosTarea, GenerarInforme.class);
			
			/* Cargamos los datos de la tarea creada en el objeto */
			tareaCreada.setTrabajo(tareaRetornada.getTrabajo());
			tareaCreada.setGrupoTrabajo(tareaRetornada.getGrupoTrabajo()); 
			tareaCreada.setTrigger(tareaRetornada.getTrigger());
			tareaCreada.setGrupoTrigger(tareaRetornada.getGrupoTrigger());
			tareaCreada.setFechaInicio(tareaRetornada.getFechaInicio());		
			tareaCreada.setCron(tareaRetornada.getCron());
			tareaCreada.setPeriodicidad(tareaRetornada.getPeriodicidad());
			//tareaCreada. setRepositorioIndices(datosTarea.getRepositorioIndices());

			log("Tarea creada: " + tareaCreada.toString());
		}
		catch (Exception e) {
    		log.error("Error: No se ha podido crear la tarea. " + e);
    		throw e;			
		}
			
		return tareaCreada;
	}

	
	/**
	 * Crea una tarea del tipo informes Federada
	 * @param datosTarea Nuevos datos de la tarea generación de informes federada
	 * @return TareaInformesVO Tarea con los datos nuevos
	 * @throws Exception
	 */
	protected TareaInformesVO handleCrearTareaInformesFederado(TareaInformesVO datosTarea) throws Exception {
		
		TareaInformesVO tareaCreada = new TareaInformesVO();
		TareaVO tareaRetornada = null;
		TareaVO tareaGenerica = new TareaVO();
		List parametrosTarea = new ArrayList();
		
		try {
			tareaGenerica.setTrabajo(datosTarea.getTrabajo());
			tareaGenerica.setTrigger(datosTarea.getTrigger());
			tareaGenerica.setFechaInicio(datosTarea.getFechaInicio());
			tareaGenerica.setPeriodicidad(datosTarea.getPeriodicidad());
			tareaGenerica.setGrupoTrabajo(datosTarea.getGrupoTrabajo());
			tareaGenerica.setGrupoTrigger(datosTarea.getGrupoTrigger());
			tareaGenerica.setUsuario(datosTarea.getUsuario());
			
			log("Tarea genérica: " + tareaGenerica.toString());
			
			/* Mensajes internacionalizados que se muestran al reindexar los ODEs de la plataforma */
    		if (null == datosTarea.getMsgInforme() || datosTarea.getMsgInforme().equals(""))
    			datosTarea.setMsgInforme(CtesPlanificador.MSG_INFORMES_OK);

    		if (null == datosTarea.getMsgNoInforme() || datosTarea.getMsgNoInforme().equals(""))
    			datosTarea.setMsgNoInforme(CtesPlanificador.MSG_INFORMES_KO);

    		if (null == datosTarea.getMsgDescripcionTrabajo() || datosTarea.getMsgDescripcionTrabajo().equals(""))
    			datosTarea.setMsgDescripcionTrabajo(datosTarea.getTrabajo());

			/* Parámetros propios de la tarea */
			parametrosTarea.add(datosTarea);
    		    		
			tareaRetornada = handleCrearTarea (tareaGenerica, parametrosTarea, GenerarInformeFederado.class);
			
			/* Cargamos los datos de la tarea creada en el objeto */
			tareaCreada.setTrabajo(tareaRetornada.getTrabajo());
			tareaCreada.setGrupoTrabajo(tareaRetornada.getGrupoTrabajo()); 
			tareaCreada.setTrigger(tareaRetornada.getTrigger());
			tareaCreada.setGrupoTrigger(tareaRetornada.getGrupoTrigger());
			tareaCreada.setFechaInicio(tareaRetornada.getFechaInicio());		
			tareaCreada.setCron(tareaRetornada.getCron());
			tareaCreada.setPeriodicidad(tareaRetornada.getPeriodicidad());
			//tareaCreada. setRepositorioIndices(datosTarea.getRepositorioIndices());

			log("Tarea creada: " + tareaCreada.toString());
		}
		catch (Exception e) {
    		log.error("Error: No se ha podido crear la tarea. " + e);
    		throw e;			
		}
			
		return tareaCreada;
	}
	
	
	
	/**
	 * Este metodo modifica una tarea de generación de informes
	 * @param datosTarea Nuevos datos de la tarea generación de informes
	 * @param trabajo Tarea que hay que modificar
	 * @return TareaInformesVO Tarea con los datos nuevos
	 * @throws Exception
	 */
	protected TareaInformesVO handleModificarTareaInformes(TareaInformesVO datosTarea, TrabajoVO trabajo) throws Exception 
	{
    	/* Modificación de una tarea */
    	log("Modificar tarea " + datosTarea.getTrabajo() + " " + datosTarea.getGrupoTrabajo() 
    			+ " usuario: " + datosTarea.getUsuario());
    	Boolean boo = new Boolean(false);
    	TareaInformesVO tarea = null;	
    	
    	try {
    		TrabajoVO[] datosJob = new TrabajoVO[1]; 
    		datosJob[0] = trabajo;
    					
    		/* Eliminamos la tarea */
    		boo = handleEliminarTareas(datosJob);
    		
    		if (boo.booleanValue()) {
    			log("Crear tarea " + datosTarea.toString());
    			tarea = handleCrearTareaInformes(datosTarea);
    		}
    	}	
    	catch (Exception e) {
    		log.error("No se ha podido modificar la tarea " + e);
    		throw e;
    	}		
	
    	return tarea;	  
	}
	
	/**
	 * Este metodo modifica una tarea de generación de informes federados
	 * @param datosTarea Nuevos datos de la tarea generación de informes
	 * @param trabajo Tarea que hay que modificar
	 * @return TareaInformesVO Tarea con los datos nuevos
	 * @throws Exception
	 */
	protected TareaInformesVO handleModificarTareaInformesFederado(TareaInformesVO datosTarea, TrabajoVO trabajo) throws Exception 
	{
    	/* Modificación de una tarea */
    	log("Modificar tarea " + datosTarea.getTrabajo() + " " + datosTarea.getGrupoTrabajo() 
    			+ " usuario: " + datosTarea.getUsuario());
    	Boolean boo = new Boolean(false);
    	TareaInformesVO tarea = null;	
    	
    	try {
    		TrabajoVO[] datosJob = new TrabajoVO[1]; 
    		datosJob[0] = trabajo;
    					
    		/* Eliminamos la tarea */
    		boo = handleEliminarTareas(datosJob);
    		
    		if (boo.booleanValue()) {
    			log("Crear tarea " + datosTarea.toString());
    			tarea = handleCrearTareaInformesFederado(datosTarea);
    		}
    	}	
    	catch (Exception e) {
    		log.error("No se ha podido modificar la tarea " + e);
    		throw e;
    	}		
	
    	return tarea;	  
	}
	

	/**
	 * Crea una tarea del tipo informes de catalogo
	 * @param datosTarea Nuevos datos de la tarea generación de informes federada
	 * @return TareaInformesVO Tarea con los datos nuevos
	 * @throws Exception
	 */
	protected TareaInformesVO handleCrearTareaInformesCatalogo(TareaInformesVO datosTarea) throws Exception {
		
		TareaInformesVO tareaCreada = new TareaInformesVO();
		TareaVO tareaRetornada = null;
		TareaVO tareaGenerica = new TareaVO();
		List parametrosTarea = new ArrayList();
		
		try {
			tareaGenerica.setTrabajo(datosTarea.getTrabajo());
			tareaGenerica.setTrigger(datosTarea.getTrigger());
			tareaGenerica.setFechaInicio(datosTarea.getFechaInicio());
			tareaGenerica.setPeriodicidad(datosTarea.getPeriodicidad());
			tareaGenerica.setGrupoTrabajo(datosTarea.getGrupoTrabajo());
			tareaGenerica.setGrupoTrigger(datosTarea.getGrupoTrigger());
			tareaGenerica.setUsuario(datosTarea.getUsuario());
			
			log("Tarea genérica: " + tareaGenerica.toString());
			
			/* Mensajes internacionalizados que se muestran al reindexar los ODEs de la plataforma */
    		if (null == datosTarea.getMsgInforme() || datosTarea.getMsgInforme().equals(""))
    			datosTarea.setMsgInforme(CtesPlanificador.MSG_INFORMES_OK);

    		if (null == datosTarea.getMsgNoInforme() || datosTarea.getMsgNoInforme().equals(""))
    			datosTarea.setMsgNoInforme(CtesPlanificador.MSG_INFORMES_KO);

    		if (null == datosTarea.getMsgDescripcionTrabajo() || datosTarea.getMsgDescripcionTrabajo().equals(""))
    			datosTarea.setMsgDescripcionTrabajo(datosTarea.getTrabajo());

			/* Parámetros propios de la tarea */
			parametrosTarea.add(datosTarea);
    		    		
			tareaRetornada = handleCrearTarea (tareaGenerica, parametrosTarea, InformeCatalogo.class);
			
			/* Cargamos los datos de la tarea creada en el objeto */
			tareaCreada.setTrabajo(tareaRetornada.getTrabajo());
			tareaCreada.setGrupoTrabajo(tareaRetornada.getGrupoTrabajo()); 
			tareaCreada.setTrigger(tareaRetornada.getTrigger());
			tareaCreada.setGrupoTrigger(tareaRetornada.getGrupoTrigger());
			tareaCreada.setFechaInicio(tareaRetornada.getFechaInicio());		
			tareaCreada.setCron(tareaRetornada.getCron());
			tareaCreada.setPeriodicidad(tareaRetornada.getPeriodicidad());
			//tareaCreada. setRepositorioIndices(datosTarea.getRepositorioIndices());

			log("Tarea creada: " + tareaCreada.toString());
		}
		catch (Exception e) {
    		log.error("Error: No se ha podido crear la tarea. " + e);
    		throw e;			
		}
			
		return tareaCreada;
	}
	
	
	/**
	 * Este metodo modifica una tarea de generación de informes de catalogo
	 * @param datosTarea Nuevos datos de la tarea generación de informes
	 * @param trabajo Tarea que hay que modificar
	 * @return TareaInformesVO Tarea con los datos nuevos
	 * @throws Exception
	 */
	protected TareaInformesVO handleModificarTareaInformesCatalogo(TareaInformesVO datosTarea, TrabajoVO trabajo) throws Exception 
	{
    	/* Modificación de una tarea */
    	log("Modificar tarea " + datosTarea.getTrabajo() + " " + datosTarea.getGrupoTrabajo() 
    			+ " usuario: " + datosTarea.getUsuario());
    	Boolean boo = new Boolean(false);
    	TareaInformesVO tarea = null;	
    	
    	try {
    		TrabajoVO[] datosJob = new TrabajoVO[1]; 
    		datosJob[0] = trabajo;
    					
    		/* Eliminamos la tarea */
    		boo = handleEliminarTareas(datosJob);
    		
    		if (boo.booleanValue()) {
    			log("Crear tarea " + datosTarea.toString());
    			tarea = handleCrearTareaInformesCatalogo(datosTarea);
    		}
    	}	
    	catch (Exception e) {
    		log.error("No se ha podido modificar la tarea " + e);
    		throw e;
    	}		
	
    	return tarea;	  
	}
	
	
	
	/**
	 * Este metodo obtiene una tarea del tipo de informes
	 * @param tarea nombre de la tarea que se recuperara los datos
	 * @return TareaInformesVO Tarea rellena con los datos especificos correspondientes
	 * @throws Exception
	 */
	protected TareaInformesVO handleObtenerTareaInformes(TareaInformesVO tarea) throws Exception 
	{
		TareaInformesVO tareaModificar = null;
    	
    	try {
    		log("Tarea a modificar: " + tarea.getTrigger() + " " + tarea.getGrupoTrigger());
    		
    		Scheduler agenda = Planificador.getAgenda();
    		
    		JobDetail trabajo = agenda.getJobDetail(tarea.getTrabajo(), tarea.getGrupoTrabajo());
			Trigger trigerModif = agenda.getTrigger(tarea.getTrigger(), tarea.getGrupoTrigger());
			
			log("trigerModif: " + trigerModif.toString());
			tareaModificar = new TareaInformesVO();
			
			tareaModificar.setPeriodicidad((String)trabajo.getJobDataMap().get(CtesPlanificador.PERIODICIDAD));
			ArrayList parametros = (ArrayList)trabajo.getJobDataMap().get(CtesPlanificador.PARAMETROS);
			
			TareaInformesVO datosInforme = (TareaInformesVO) parametros.get(0);
	
			tareaModificar.setTrabajo(trabajo.getName());			
			tareaModificar.setGrupoTrabajo(trabajo.getGroup());
			tareaModificar.setTrigger(trigerModif.getName());
			tareaModificar.setGrupoTrigger(trigerModif.getGroup());
			tareaModificar.setFechaInicio(DateManager.dateToCalendar(trigerModif.getStartTime()));	
			tareaModificar.setTipoTarea(Planificador.ultimoCampo(trabajo.getJobClass().toString()));
			tareaModificar.setFechaDesde(datosInforme.getFechaDesde());
			tareaModificar.setFechaHasta(datosInforme.getFechaHasta());
			tareaModificar.setFormato(datosInforme.getFormato());
			tareaModificar.setInforme(datosInforme.getInforme());
			tareaModificar.setRango(datosInforme.getRango());
			tareaModificar.setUsuarioInforme(datosInforme.getUsuarioInforme());
   		}
    	catch (Exception e) {
    		log.error("Error: No se ha podido modificar la tarea de informes " + e);
    		throw e;
    	}

        return tareaModificar;
	}

	
	/**
	 * Crea la generacion de un informe
	 * @param datosInforme Datos que necesita el informe para lanzarse
	 * @param idTarea Identificador de la tarea para registrar como ha ido la generacion de la misma
	 * @throws Exception
	 */
	protected void handleGenerarInforme(TareaInformesVO datosInforme, Long idTarea) throws Exception {
		
		try {			
			
			/* Conversión de TareaInformesVO a ParametroCrearInformeVO */
			ParametroCrearInformeVO parametros = new ParametroCrearInformeVO();
			tareaInformesVO2ParametroCrearInformeVO(datosInforme, parametros);
			
			this.getSrvAuditoriaServicio().crearGuardarInforme(parametros);
		}
		catch (Exception e) {
			log.error("Error: al llamar al generar informe: " + e);
		}
	}
	
	/**
	 * Crea la generacion de un informe Federado
	 * @param datosInforme Datos que necesita el informe Federado para lanzarse
	 * @param idTarea Identificador de la tarea para registrar como ha ido la generacion de la misma
	 * @throws Exception
	 */
	protected void handleGenerarInformeFederado(TareaInformesVO datosInforme, Long idTarea) throws Exception {
		
		try {			
			log("dentro de generarInformeFederado del planificador");
			/* Conversión de TareaInformesVO a ParametroCrearInformeVO */
			ParametroCrearInformeVO parametros = new ParametroCrearInformeVO();
			tareaInformesVO2ParametroCrearInformeVOFederado(datosInforme, parametros);
						
			this.getSrvAuditoriaServicio().crearGuardarInformeFederado(parametros);

		}
		catch (Exception e) {
			log.error("Error: al llamar al generar informe: " + e);
		}
	}
	
	
	
	/** 
	 * Se transforma el objeto TareaInformesVO a CrearInformeVO
     * @param datosInforme Objeto TareaInformesVO
     * @param parametros Objeto ParametroCrearInformeVO
     */
	
	private void tareaInformesVO2ParametroCrearInformeVO(TareaInformesVO datosInforme, ParametroCrearInformeVO parametros)
	{
		parametros.setUsuario(datosInforme.getUsuarioInforme());
		parametros.setNombreInforme(datosInforme.getInforme());
		parametros.setRango(datosInforme.getRango());
		parametros.setFormato(datosInforme.getFormato());
		
		String dia = null;
		String mes = null;
		String anio = null;
		Calendar fecha = new GregorianCalendar();
		fecha.setTime(datosInforme.getFechaDesde().getTime());
		
		if (fecha.get(Calendar.DAY_OF_MONTH) < 10)
			dia = "0" + new Integer(fecha.get(Calendar.DAY_OF_MONTH)).toString();
		else
			dia = new Integer(fecha.get(Calendar.DAY_OF_MONTH)).toString();
		
		if (fecha.get(Calendar.MONTH) + 1 < 10)
			mes = "0" + new Integer(fecha.get(Calendar.MONTH) + 1).toString();
		else
			mes = new Integer(fecha.get(Calendar.MONTH) + 1).toString();
		
		anio = new Integer(fecha.get(Calendar.YEAR)).toString();
						
		parametros.setDiaDesde(dia);
		parametros.setMesDesde(mes);
		parametros.setAnioDesde(anio);
		
		log("Desde- dia: " + dia + " mes: " + mes + " anio: " + anio);
		
		fecha.setTime(datosInforme.getFechaHasta().getTime());
		
		if (fecha.get(Calendar.DAY_OF_MONTH) < 10)
			dia = "0" + new Integer(fecha.get(Calendar.DAY_OF_MONTH)).toString();
		else
			dia = new Integer(fecha.get(Calendar.DAY_OF_MONTH)).toString();
		
		if (fecha.get(Calendar.MONTH) + 1 < 10)
			mes = "0" + new Integer(fecha.get(Calendar.MONTH) + 1).toString();
		else
			mes = new Integer(fecha.get(Calendar.MONTH) + 1).toString();
		
		anio = new Integer(fecha.get(Calendar.YEAR)).toString();
		
		parametros.setDiaHasta(dia);
		parametros.setMesHasta(mes);
		parametros.setAnioHasta(anio);
		
		log("Hasta- dia: " + dia + " mes: " + mes + " anio: " + anio);
	}

	/** 
	 * Se transforma el objeto TareaInformesVO a CrearInformeVO
     * @param datosInforme Objeto TareaInformesVO
     * @param parametros Objeto ParametroCrearInformeVO
     */
	
	private void tareaInformesVO2ParametroCrearInformeVOFederado(TareaInformesVO datosInforme, ParametroCrearInformeVO parametros)
	{
		parametros.setUsuario(datosInforme.getUsuarioInforme());
		parametros.setNombreInforme(datosInforme.getInforme());
		parametros.setRango(datosInforme.getRango());
		parametros.setFormato(datosInforme.getFormato());
		
	}
	
	
	
	/**
	 * Registra en Quartz la ejecucion de la tarea de modificacion descrita en
	 * datosTarea. Se genera un nombre para identificarlo en el quartz a partir
	 * del identificador proporcionado por el modificador.
	 * 
	 * @see es.pode.planificador.negocio.servicios.SrvPlanificadorServiceBase#handleCrearTareaModificacion(es.pode.planificador.negocio.servicios.TareaModificacionVO)
	 */
	protected TareaModificacionVO handleCrearTareaModificacion(TareaModificacionVO datosTarea) throws Exception {
		TareaModificacionVO result = null;
		String nombre = ConstantesAgrega.NOMBRE_MODIFICADOR + datosTarea.getIdModificacion();
		String grupo = ConstantesAgrega.GRUPO_MODIFICADOR;
		ArrayList parametros = new ArrayList();
		parametros.add(datosTarea.getIdModificacion());
		parametros.add(datosTarea.getUsuario());
		TareaVO tarea = new TareaVO();
		tarea.setGrupoTrabajo(grupo);
		tarea.setTrabajo(nombre);
		tarea.setFechaInicio(datosTarea.getFechaInicio());
		tarea.setPeriodicidad(CtesPlanificador.NO_PERIODICA);
		tarea.setUsuario(datosTarea.getUsuario());
		tarea.setTrigger(nombre);
		tarea.setGrupoTrigger(grupo);
		try {
			TareaVO retorno = handleCrearTarea(tarea, parametros, TareaModificacion.class);
			
			result = new TareaModificacionVO();
			result.setFechaInicio(retorno.getFechaInicio());
			result.setTrabajo(retorno.getTrabajo());
			result.setIdModificacion(datosTarea.getIdModificacion());
			result.setUsuario(retorno.getUsuario());
			Logger.getLogger(this.getClass()).info("Tarea " + result.getTrabajo() + " registrada en el planificador");
		} catch (Exception e) {
			Logger.getLogger(this.getClass()).error("Error en la creacion de la tarea de modificacion " + datosTarea.getIdModificacion() + ": " + e.getMessage());
			log(e);
			throw new CrearTareaException("No se ha podido crear la tarea de modificacion " + nombre,e);
		}
		
		return result;
	}

	/**
	 * Elimina la tarea programada y la vuelve a crear.
	 * @see es.pode.planificador.negocio.servicios.SrvPlanificadorServiceBase#handleModificarTareaModificacion(es.pode.planificador.negocio.servicios.TareaModificacionVO)
	 */
	protected TareaModificacionVO handleModificarTareaModificacion(TareaModificacionVO datosTarea) throws Exception {

		Boolean result = Boolean.FALSE;
		TareaModificacionVO resultVO = null;
		try {
			// Borro la tarea y la creo de nuevo con los nuevos datos
			TrabajoVO trabajo = new TrabajoVO();
			trabajo.setGrupoTrabajo(ConstantesAgrega.GRUPO_MODIFICADOR);
			trabajo.setTrabajo(datosTarea.getTrabajo());
			trabajo.setUsuario(datosTarea.getUsuario());
			result = handleEliminarTareas(new TrabajoVO[]{trabajo});
			if(result.booleanValue()) {
				log("Tarea " + trabajo +" eliminada. La creo de nuevo");
				resultVO = handleCrearTareaModificacion(datosTarea);
			}
		} catch (Exception e) {
			String msg = "Error durante la modificacion de la tarea " + datosTarea.getTrabajo() + ": " + e.getMessage();
			Logger.getLogger(this.getClass()).error(msg);
			log(e);
			throw new ModificarTareaException(msg,e);
		}
		return resultVO;
	}

	/**
	 * Creación de los RSS
	 * @throws Exception
	 */
	protected void handleLanzarRSS() throws Exception {
			
		this.getSrvAgregadorRssService().crearXML();
	}
	
	/**
	 * Creación de los informes de portada
	 * @throws Exception
	 */
	protected void handleInformesPortada() throws Exception {
			
		this.getSrvAuditoriaServicio().crearInformesPortada();
	}
	
	/**
	 * Creación de la imágen aleatoria para sites externos
	 * @throws Exception
	 */
	protected void handlePortadaODE() throws Exception {
			
		this.getSrvGeneracionDinamicaService().generaODEDiario();
	}
	
	/**
	 * Creación de los ficheros sitemap.xml
	 * @throws Exception
	 */
	protected void handleGenerarSitemaps() throws Exception {
		log("GENERAR SITEMAPS");
		this.getSrvSitemapService().generarSitemapXml();
	
	}
	
	/**
	 * Creación de los informes de portada
	 * @throws Exception
	 */
	protected void handleGenerarCatalogo() throws Exception {
		log("handleGenerarCatalogo");	
		
		this.getSrvAuditoriaServicio().crearInformeRepositorio();
	}	
}