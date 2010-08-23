/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point

package es.pode.planificador.negocio.trabajos;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.InterruptableJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

import es.pode.ServiceLocator;
import es.pode.planificador.negocio.comun.CtesPlanificador;
import es.pode.planificador.negocio.comun.Planificador;
import es.pode.planificador.negocio.servicios.RegistrarTrabajoException;
import es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO;
import es.pode.planificador.negocio.servicios.TareaEjecutadaVO;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.encriptacion.Autenticar;
import es.pode.soporte.utiles.ficheros.UtilesFicheros;


/**
 * Trabajo de publicación automática de los ODEs en la plataforma.
 * Si la publicación es correcta se mueve al directorio de ficheros cargados correctamente
 * Si la publicación no se lleva acabo se mueve el fichero al directorio ODEs no publicados
 */

public class CargaODEs implements Job, InterruptableJob
{
	
	private static Log log = LogFactory.getLog(CargaODEs.class);
	private boolean interrupcion = false;
	private static final String PUBLICACION_CORRECTA = "0.0";
	private static final String EXCEPCION_NO_CONTROLADA = "20.1";
	
	/**
	 * Método de ejecución de la tarea.
	 * Publicación de los ODEs en la plataforma de manera automática.
	 */
	public void execute(JobExecutionContext context)
			throws JobExecutionException
	{         		
		Long idTarea = null;
		String usuario = (String) context.getJobDetail().getJobDataMap().get(CtesPlanificador.USUARIO);		
		boolean ejecucionIncorrecta = false;
		
		/* Añadimos la seguridad al proceso */
		log("Usuario que lanza la tarea: " + usuario);
        boolean contextoCargado = Autenticar.cargarContextoSeguridad(usuario);
		
		if(!contextoCargado) {
			log.error("ERROR: No han cargado los datos en el contexto de seguridad");
			return;			
		}
		
		/*
		 *	Parámetros propios del trabajo:
		 * 		pathODEs, pathODEsCargados, pathODEsNoCargados
		 * 		msgPublicado, msgNoPublicado y msgDescTrabajo
		 * 		
		*/		
		ArrayList parametros = (ArrayList)context.getJobDetail().getJobDataMap().get(CtesPlanificador.PARAMETROS);
		String pathODEs = (String) parametros.get(0);
		String pathODEsCargados = (String) parametros.get(1);
		String pathODEsNoCargados = (String) parametros.get(2);
		String msgPublicado = (String) parametros.get(3);
		String msgNoPublicado = (String) parametros.get(4);
		String msgDescTrabajo = (String) parametros.get(5);
		String sobrescribir = (String) parametros.get(6);
	
		log("CargaODEs: " + context.getJobDetail().getFullName() + " ejecutandose a las " + new Date());

		/* Comprobamos si existen los directorios de trabajo de la carga de ODEs */  
		File fPathODEs = new File(pathODEs); 
		if (!fPathODEs.exists()) {
			log.error("Error: El directorio donde se deben encontrar los ODEs no existe o no se puede acceder a él " 
					+ fPathODEs.getAbsolutePath());
			JobExecutionException excepcion = new JobExecutionException("Error: No se ha podido registrar. El directorio de los ODEs no existe: " 
					+ fPathODEs.getAbsolutePath());
			throw excepcion;
		}

		File fpathODEsCargados = new File(pathODEsCargados); 
		if (!fpathODEsCargados.exists()) {
			log.error("Error: El directorio donde se deben mover los ODEs cargados no existe o no se puede acceder a él " 
					+ fPathODEs.getAbsolutePath());
			JobExecutionException excepcion = 
					new JobExecutionException("Error: No se ha podido registrar. No exste el directorio donde se deben moven los ODEs publicados: " 
					+ fpathODEsCargados.getAbsolutePath());
			throw excepcion;
		}

		File fpathODEsNoCargados = new File(pathODEsNoCargados); 
		if (!fpathODEsNoCargados.exists()) {
			log.error("Error: El directorio donde se deben mover los ODEs no cargados no existe o no se puede acceder a él " 
					+ fpathODEsNoCargados.getAbsolutePath());
			JobExecutionException excepcion = 
				new JobExecutionException("Error: El directorio donde se deben mover los ODEs no cargados no existe o no se puede acceder a él " 
				+ fpathODEsNoCargados.getAbsolutePath());
			throw excepcion;
		}

		/* Registramos el inicio del trabajo */		
		idTarea = Planificador.registrarInicioTarea(context.getJobDetail().getName(), 
				context.getJobDetail().getGroup(), msgDescTrabajo, usuario);
		
		log("Identificador de la tarea: " + idTarea);
		
		/* Recorremos el directorio donde estan los ficheros(ODEs) a publicar */
		
		/* Antiguamente:: Se recogian los odes de una direccion en concreto
			File ODEs = new File(pathODEs);
			File[] arrayList = ODEs.listFiles();
		 */
		
		File fileOde = null;
		
		String[] odes = UtilesFicheros.obtenerOdesDePath(pathODEs,true,true);
		
		//recorremos todos los odes
		for (int i=0; i < odes.length; i++) {			
			try { 	
				log("Carga del ODE: " + odes[i]);
				
				/* Se comprueba si la tarea ha sido interrumpida */
				if(interrupcion) {
					log("Se para la tarea por petición del cliente");
					break;
				}
				
				/* Antes se ignoraba los directorios, ahora obtenermos una lista de los path de los odes
				 * que esten dentro de una carpeta o de subcarpetas. no hace falta ignorar los directorios
				 * Los directorios no se cargan en el nodo 
				
				if (arrayList[i].isDirectory()) {
					log("Directorio: " + arrayList[i].getAbsolutePath());
					continue;
				}
				
				//Nos aseguramos que siga existiendo el fichero a cargar
				if (!arrayList[i].exists()) {
					log("El fichero " + arrayList[i].getAbsolutePath() + " ha sido borrado o movido");
					continue;
				}
				
				*/
				
				//recogemos el ode correspondiente en un FILE para tratarlo
				fileOde = new File(odes[i]);
				
				//comprobamos que el ode existe todavia
				if (!fileOde.exists()) {
					log("El fichero " + odes[i] + " ha sido borrado o movido");
					continue;
				}
				
				FileDataSource fileDS = new FileDataSource(odes[i]);
				log("FileDataSource: " + fileDS.toString());
				
				/* Llamada al servicio de publicación con el ODE */
				DataHandler pif = new DataHandler(fileDS);
				log("DataHandler: " + pif.toString());
							
                String codPublicacion = ServiceLocator.instance().getSrvPlanificadorService().
                		publicarPIF(pif, usuario.toString(), msgDescTrabajo + " " + fileOde.getName(), sobrescribir, fileOde.getName());    
                
                //Tratamos el codigo para que solo contenga el primero si tuviera mas de uno
                String codigoCapado = null;
    			
                if(codPublicacion == null || codPublicacion.equals(""))
                	codigoCapado = "20.1";
                else {
                	int posicion = codPublicacion.indexOf(";");
    				if(posicion == -1)
    					codigoCapado = codPublicacion;
    				else
    					codigoCapado = codPublicacion.substring(0,posicion);
                }
                
                log("PublicarPIF: " + codigoCapado);
				
				 /* Preparación del registro del resultado de la publicación */
        		TareaEjecutadaVO tarea = new TareaEjecutadaVO();
            	tarea.setId(idTarea);
            	RegistroTareaEjecutadaVO registro = new RegistroTareaEjecutadaVO();
            	registro.setTarea_ejecutada(tarea);
            	registro.setFecha(new GregorianCalendar());
            	registro.setCodigo(codigoCapado);
                
            	/* Publicación correcta */
            	if (codigoCapado.equals(PUBLICACION_CORRECTA)) {
                	log.debug("Registramos que la publicación ha sido correcta. ODE: " + fileOde.getName());
                	registro.setEstado(ConstantesAgrega.TRABAJO_CORRECTO);	
                	registro.setDescripcion(msgPublicado + ". " + fileOde.getName());
                	
    				/* Se mueve el ODE publicado al directorio correspondiente */
    				try {
    					log.debug("Fichero: " + pathODEsCargados + File.separator + fileOde.getName()); 

    					File ficheroCargado = new File(pathODEsCargados + File.separator + fileOde.getName());
    					
    					if (ficheroCargado.exists()) {
    						log.warn("Ya existe un fichero con ese nombre: " + ficheroCargado.getAbsolutePath() + " en la carpeta de cargados. Se elimina para mover el nuevo fichero");
    						ficheroCargado.delete();
    					}
    					
    					boolean mov = fileOde.renameTo(ficheroCargado);													
    					if (!mov)
    						log.error("El fichero no se ha podido mover: " + fileOde.getAbsolutePath());					
    				}
    				catch (Exception e2) {
    					RegistrarTrabajoException excepcion = 
    							new RegistrarTrabajoException("Error: No se ha podido mover el ODE cargado al directorio de ODEs publicados " 
    							+ fileOde.getAbsolutePath(), e2);
    					log.error(excepcion);
    				}
                }
                else { // Publicación incorrecta. El ODE no pasa la validación
                	log.info("El ODE: " + fileOde.getName() + " no es válido. Código de error: " + codPublicacion);
                	registro.setEstado(ConstantesAgrega.TRABAJO_ERRONEO);	
                	// vamos a recoger el error de publicacion
                	if (codPublicacion.indexOf(";") != -1)
                		msgNoPublicado = codPublicacion.substring(codPublicacion.indexOf(";")+1);
                	registro.setDescripcion(msgNoPublicado + ". " + fileOde.getName());
                	registro.setCodigo(codigoCapado);
    				ejecucionIncorrecta = true;
    				
    				/* Se mueve el ODE no publicado al directorio correspondiente */
    				try {
    					log.debug("Fichero no publicado: " + pathODEsNoCargados + File.separator + fileOde.getName()); 
    					
    					File ficheroNoCargado = new File(pathODEsNoCargados + File.separator + fileOde.getName());
    					
    					if (ficheroNoCargado.exists()) {
    						log.warn("Ya existe un fichero con ese nombre: " + ficheroNoCargado.getAbsolutePath() + " en la carpeta de no cargados. Se elimina para mover el nuevo fichero");
    						ficheroNoCargado.delete();
    					}
    						
    					boolean mov = fileOde.renameTo(ficheroNoCargado);
    					
    					if (!mov)
    						log.error("El fichero no se ha podido mover: " + fileOde.getAbsolutePath());					
    				}
    				catch (Exception e2) {
    					RegistrarTrabajoException excepcion = 
    							new RegistrarTrabajoException("Error: No se ha podido mover el ODE no publicado " 
    							+ fileOde.getAbsolutePath(), e2);
    					log.error(excepcion);
    				}	
                }
                
                // Se registra en la tabla derivada como ha ido la carga de ese ODE
				try {
					ServiceLocator.instance().getSrvRegistroPlanificadorService().registrarTrabajoHijo(registro);
				}
				catch (Exception e1) {
					RegistrarTrabajoException excepcion = 
							new RegistrarTrabajoException("Error: No se ha podido registrar la tarea derivada " + e1.getMessage(), e1);
		    		log.error(excepcion);
				}
			}
			catch (Exception e) { // Deberían ser excepciones enviadas del servicio de publicación de ODEs

				String path = "";
				
				if (fileOde != null || fileOde.getAbsolutePath() != null)
					path = fileOde.getAbsolutePath();
				
				log.error("Error publicando ODE: " + path + " " + e);
				ejecucionIncorrecta = true;
				
				TareaEjecutadaVO tarea = new TareaEjecutadaVO();            	
				tarea.setId(idTarea);
				RegistroTareaEjecutadaVO registro = new RegistroTareaEjecutadaVO();
				registro.setTarea_ejecutada(tarea);
				registro.setDescripcion(msgNoPublicado + ". " + fileOde.getName() + " " + e.getMessage());
				registro.setEstado(ConstantesAgrega.TRABAJO_ERRONEO);
				registro.setCodigo(EXCEPCION_NO_CONTROLADA);
				registro.setFecha(new GregorianCalendar());
				
				/* Registramos la no publicación del ODE */
				try {
					ServiceLocator.instance().getSrvRegistroPlanificadorService().registrarTrabajoHijo(registro);
				}
				catch (Exception e1) {
					RegistrarTrabajoException excepcion = new RegistrarTrabajoException("Error: No se ha podido registrar", e1);
		    		log.error(excepcion);
				}
		    		
				/* Se mueve el ODE no publicado al directorio correspondiente */
				try {
					log("Fichero no publicado: " + pathODEsNoCargados + File.separator + fileOde.getName()); 
					File ficheroNoCargado = new File(pathODEsNoCargados + File.separator + fileOde.getName());
					
					if (ficheroNoCargado.exists()) {
						log.warn("Ya existe un fichero con ese nombre: " + ficheroNoCargado.getAbsolutePath() + " en la carpeta de no cargados. Se elimina para mover el nuevo fichero");
						ficheroNoCargado.delete();
					}
						
					boolean mov = fileOde.renameTo(ficheroNoCargado);
					
					if (!mov)
						log.error("El fichero no se ha podido mover: " + fileOde.getAbsolutePath());					
				}
				catch (Exception e2) {
					RegistrarTrabajoException excepcion = 
							new RegistrarTrabajoException("Error: No se ha podido mover el ODE no publicado " 
							+ fileOde.getAbsolutePath(), e2);
					log.error(excepcion);
				}
			}
		}
		
		//TODO: De este registro se deberá encargar la tarea ejecutada
		/* Registramos la hora de finalización de la tarea y si ha sido correcta/incorrecta la publicación */
		try {
			TareaEjecutadaVO trabajoEjecutado = new TareaEjecutadaVO();
			trabajoEjecutado.setId(idTarea);
			trabajoEjecutado.setFechaFin(new GregorianCalendar());
			
			if (interrupcion)
				trabajoEjecutado.setEstado(ConstantesAgrega.TRABAJO_INTERRUMPIDO);
			else if (ejecucionIncorrecta)
				trabajoEjecutado.setEstado(ConstantesAgrega.TRABAJO_ERRONEO);
			else
				trabajoEjecutado.setEstado(ConstantesAgrega.TRABAJO_CORRECTO);
			
			ServiceLocator.instance().getSrvRegistroPlanificadorService().registrarTrabajoFechaFin(trabajoEjecutado);
		}
		catch (Exception e1) {
			RegistrarTrabajoException excepcion = 
					new RegistrarTrabajoException("Error: No se ha podido registrar el fin del trabajo", e1);
	    	log.error(excepcion);
		}
	}	
	
	 /**
     * Este código se llama cuando un usuario interrumpe una tarea
     * @throws UnableToInterruptJobException
     */
    public void interrupt() throws UnableToInterruptJobException {
        log.info("Se para el trabajo por petición del usuario (interrupt)");
        interrupcion = true;
    }
	
	private void log (Object obj) {
		if (log.isDebugEnabled())
			log.debug(obj);
	}
}
