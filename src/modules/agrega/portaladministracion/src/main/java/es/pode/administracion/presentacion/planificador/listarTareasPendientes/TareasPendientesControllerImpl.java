/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.planificador.listarTareasPendientes;



import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.planificador.negocio.servicios.TareaVO;


public class TareasPendientesControllerImpl extends TareasPendientesController
{
	private static Logger log = Logger.getLogger(TareasPendientesControllerImpl.class);
	private Properties pSpringProperties = null;
	
	
	
	public final void obtenerNombresTrabajos(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.listarTareasPendientes.ObtenerNombresTrabajosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
	{
		String nombreTarea = "";
		List listaCodigoSeparador = new ArrayList();
		int i=1;
		try {
			
			List lista = ((ListarEliminarFormImpl)form).getTrabajoRowSelection();
			
		    if (lista == null) 
		    {
		    	throw new ValidatorException("{tareas.errorEliminar}");
		    } 
		    else 
		    {
		    	form.setTrabajos(lista);
		    }
		    
		} 
		catch (ValidatorException validator) 
		{
		    log.error("validator eception : " + validator);
		    throw validator;
		} 
		catch (Exception e) 
		{
		    log.error("Se produce una excepcion ", e);
		    throw new ValidatorException("{tareas.error}");
		}
	}
	
	
    public final void obtenerTareasPendientes(ActionMapping mapping, ObtenerTareasPendientesForm form, 
    		HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	try 
    	{
    		
    		TareaVO[] tareas = this.getSrvPlanificadorService().obtenerTareasPendientes();
    		TareaDate[] tareasDate = null;
    		
    		if (tareas != null) 
    		{
    			tareasDate = cambiarFormatoTareas(tareas, request.getLocale()); 
    			tareasDate = ordenaAscendente(tareasDate,form.getTareaModificada());
    			((ListarTareasPendientesFormImpl)form).setTareasPendientesAsArray(tareasDate);
    		}
    	}
    	catch (Exception e)
    	{
    		log.error("Error: " + e);
    		throw new ValidatorException("{tareas.error}");    	
    	}
    }
    
    private TareaDate[] cambiarFormatoTareas(TareaVO[] tareas, Locale locale) 
    {
    	TareaDate[] tareasDate = new TareaDate[tareas.length];
    	
		for(int i=0;i<tareas.length;i++)
		{
			tareasDate[i]=cambiarFormatoTarea(tareas[i], locale);
		}

		return tareasDate;
    }
    
    
    /** 
     * Copiamos todos los campos de la tarea recibida y los metemos en la nueva tarea cambiando 
     * la fecha a Date
     * */
    private TareaDate cambiarFormatoTarea(TareaVO tarea, Locale locale) 
    {
    	TareaDate tareaDate = new TareaDate();
    	
    	tareaDate.setCron(tarea.getCron());
    	if (tarea.getFechaInicio() != null)
    		tareaDate.setFechaInicio(tarea.getFechaInicio().getTime());
    	tareaDate.setGrupoTrabajo(tarea.getGrupoTrabajo());
    	tareaDate.setGrupoTrigger(tarea.getGrupoTrigger());
    	
    	ResourceBundle ficheroRecursos = ResourceBundle.getBundle("application-resources", locale);
    	
    	if(tarea.getPeriodicidad().equals("N"))
    		tarea.setPeriodicidad(ficheroRecursos.getString("tareas.vacia"));
    	else if(tarea.getPeriodicidad().equals("D"))
    		tarea.setPeriodicidad(ficheroRecursos.getString("crearTarea.D"));
    	else if(tarea.getPeriodicidad().equals("S"))
    		tarea.setPeriodicidad(ficheroRecursos.getString("crearTarea.S"));
    	else if(tarea.getPeriodicidad().equals("M"))
    		tarea.setPeriodicidad(ficheroRecursos.getString("crearTarea.M"));
    	else if(tarea.getPeriodicidad().equals("A"))
    		tarea.setPeriodicidad(ficheroRecursos.getString("crearTarea.A"));


    	tareaDate.setPeriodicidad(tarea.getPeriodicidad());
    	tareaDate.setTipoTarea(tarea.getTipoTarea());
    	tareaDate.setTrabajo(tarea.getTrabajo());
    	tareaDate.setTrigger(tarea.getTrigger());
    	tareaDate.setUsuario(tarea.getUsuario());
    	
    	/**
   		 * Recortamos el nombre de la tarea quitandole lo agregado al nombre original
   		 * Lo agregado son dos # seguidas de la fecha en la que se ejecuta la tarea
   		 * La fecha se compone de "año+mes+dia+hora+minutos+segundos"
   		 * */
    	int posicion = tarea.getTrabajo().indexOf("!!");
    	
    	if (posicion > 0)
    		tareaDate.setTrabajo(tarea.getTrabajo().substring(0, posicion));
    	else 
    		tareaDate.setTrabajo(tarea.getTrabajo());
    	
    	//tareaDate.setTrabajo(tarea.getTrabajo());
    	tareaDate.setUsuario(tarea.getUsuario());
    	
		return tareaDate;
    }
    
    

    /**
	 * Obtiene una array de Value Objets ordenados 
	 * @param  array Array de Value Objects que se quiere ordenar
	 * @return TareaDate[] Array con los Value Object ordenados
	 * @throws Exception
	 */
	private TareaDate[] ordenaDescendente(TareaDate[] array)
	{
		TareaDate tmp;
		int i, j, pos_max;
		int N = array.length;
		for (i = 0; i < N - 1; i++)
		{
			//Mayor elemento del vector
			pos_max = i;
			for (j = i + 1; j < N; j++)
			{
				if (array[j].getFechaInicio().after(array[pos_max].getFechaInicio()))
					pos_max = j;
			}
			//coloca el maximo en la posicion i
			tmp = array[i];
			array[i] = array[pos_max];
			array[pos_max] = tmp;
		}
		
		return array;
	}
	
	
    /**
	 * Obtiene una array de Value Objets ordenados 
	 * @param  array Array de Value Objects que se quiere ordenar
	 * @return TareaDate[] Array con los Value Object ordenados
	 * @throws Exception
	 */
	private TareaDate[] ordenaAscendente(TareaDate[] array,String tareaModificada)
	{
//		TareaDate tmp;
//		int i, j, pos_min;
//		int N = array.length;
//		boolean encTareaModif = false;
//		TareaDate[] auxArray = new TareaDate[N];
//		
//		for (i = 0; i < N - 1; i++)
//		{
//			//Menor elemento del vector
//			pos_min = i;
//
//			for (j = i + 1; j < N; j++)
//			{
//				if (array[j].getFechaInicio().before(array[pos_min].getFechaInicio()))
//					pos_min = j;
//			}
//			
//			//ordenacion de array cuando se modifica una tarea
//			//la tarea modificada se coloca en la primera posicion del array y el resto a continuación en orden
//			//ascendente de la fecha de inicio
//			if(!encTareaModif){
//				if (array[pos_min].getTrabajo().equals(tareaModificada)){
//					auxArray[0]= array[pos_min];
//					encTareaModif = true;
//				}
//				else{
//					auxArray[i+1]= array[pos_min];
//				}
//			}
//			else{
//				auxArray[i] = array[pos_min];
//			}
//			//coloca el minimo en la posicion i
//			tmp = array[i];
//			array[i] = array[pos_min];
//			array[pos_min] = tmp;
//		}
//		if(tareaModificada != null){
//			if(!encTareaModif){
//				//no se ha encontrado la tarea ha modificar lo que quiere decir que 
//				//se encuentra en la ultima posicion de array
//				auxArray[0]=array[N-1];
//			}
//			else{//falta incluir la ultima posicion de array
//				auxArray[N-1]=array[N-1];
//			}
//			array = auxArray;
//		}
		
		TareaDate tmp;
		int i, j, pos_min;
		int N = array.length;
		for (i = 0; i < N - 1; i++)
		{
			//Mayor elemento del vector
			pos_min = i;
			for (j = i + 1; j < N; j++)
			{
				if (array[j].getFechaInicio().before(array[pos_min].getFechaInicio()))
					pos_min = j;
			}
			//coloca el maximo en la posicion i
			tmp = array[i];
			array[i] = array[pos_min];
			array[pos_min] = tmp;
		}
		return array;
	}
	
	
    /**
     * This inner class is used in the dummy implementation in order to get the web application
     * running without any manual programming.
     * You may delete this class when you add you own code in this controller.
     */
    public static final class TareasPendientesDummy implements java.io.Serializable
    {
        private String job = null;

        public TareasPendientesDummy(String job)
        {
            this.job = job;
        }
        
        public void setJob(String job)
        {
            this.job = job;
        }

        public String getJob()
        {
            return this.job;
        }
    }
    
    
    /**
     * Declaramos la clase TareaDate para poder rellenarla con la clase TareaVO que nos llega del formulario
     * y cambiar el formato de la fecha de Calendar a Date para poder visualizarla correctamente en la jsp
     * @author jmpeinado
     *
     */
    public class TareaDate  
    {
        /* Nombre descriptivo de la tarea */
        private java.lang.String trabajo;

        /* Nombre del grupo de la tarea */
        private java.lang.String grupoTrabajo;

        /* Nombre del trigger */
        private java.lang.String trigger;

        /* Nombre del grupo del trigger */
        private java.lang.String grupoTrigger;

        /* Expresion del cron */
        private java.lang.String cron;

        /* Fecha de inicio del trabajo / trigger */
        private java.util.Date fechaInicio;

        /* Periodicidad de la tarea */
        private java.lang.String periodicidad;

        private java.lang.String usuario;

        private java.lang.String tipoTarea;


        /**
         * Gets the trabajo value for this TareaVO.
         * 
         * @return trabajo   * Nombre descriptivo de la tarea
         */
        public java.lang.String getTrabajo() {
            return trabajo;
        }


        /**
         * Sets the trabajo value for this TareaVO.
         * 
         * @param trabajo   * Nombre descriptivo de la tarea
         */
        public void setTrabajo(java.lang.String trabajo) {
            this.trabajo = trabajo;
        }


        /**
         * Gets the grupoTrabajo value for this TareaVO.
         * 
         * @return grupoTrabajo   * Nombre del grupo de la tarea
         */
        public java.lang.String getGrupoTrabajo() {
            return grupoTrabajo;
        }


        /**
         * Sets the grupoTrabajo value for this TareaVO.
         * 
         * @param grupoTrabajo   * Nombre del grupo de la tarea
         */
        public void setGrupoTrabajo(java.lang.String grupoTrabajo) {
            this.grupoTrabajo = grupoTrabajo;
        }


        /**
         * Gets the trigger value for this TareaVO.
         * 
         * @return trigger   * Nombre del trigger
         */
        public java.lang.String getTrigger() {
            return trigger;
        }


        /**
         * Sets the trigger value for this TareaVO.
         * 
         * @param trigger   * Nombre del trigger
         */
        public void setTrigger(java.lang.String trigger) {
            this.trigger = trigger;
        }


        /**
         * Gets the grupoTrigger value for this TareaVO.
         * 
         * @return grupoTrigger   * Nombre del grupo del trigger
         */
        public java.lang.String getGrupoTrigger() {
            return grupoTrigger;
        }


        /**
         * Sets the grupoTrigger value for this TareaVO.
         * 
         * @param grupoTrigger   * Nombre del grupo del trigger
         */
        public void setGrupoTrigger(java.lang.String grupoTrigger) {
            this.grupoTrigger = grupoTrigger;
        }


        /**
         * Gets the cron value for this TareaVO.
         * 
         * @return cron   * Expresion del cron
         */
        public java.lang.String getCron() {
            return cron;
        }


        /**
         * Sets the cron value for this TareaVO.
         * 
         * @param cron   * Expresion del cron
         */
        public void setCron(java.lang.String cron) {
            this.cron = cron;
        }


        /**
         * Gets the fechaInicio value for this TareaVO.
         * 
         * @return fechaInicio   * Fecha de inicio del trabajo / trigger
         */
        public java.util.Date getFechaInicio() {
            return fechaInicio;
        }


        /**
         * Sets the fechaInicio value for this TareaVO.
         * 
         * @param fechaInicio   * Fecha de inicio del trabajo / trigger
         */
        public void setFechaInicio(java.util.Date fechaInicio) {
            this.fechaInicio = fechaInicio;
        }


        /**
         * Gets the periodicidad value for this TareaVO.
         * 
         * @return periodicidad   * Periodicidad de la tarea
         */
        public java.lang.String getPeriodicidad() {
            return periodicidad;
        }


        /**
         * Sets the periodicidad value for this TareaVO.
         * 
         * @param periodicidad   * Periodicidad de la tarea
         */
        public void setPeriodicidad(java.lang.String periodicidad) {
            this.periodicidad = periodicidad;
        }


        /**
         * Gets the usuario value for this TareaVO.
         * 
         * @return usuario
         */
        public java.lang.String getUsuario() {
            return usuario;
        }


        /**
         * Sets the usuario value for this TareaVO.
         * 
         * @param usuario
         */
        public void setUsuario(java.lang.String usuario) {
            this.usuario = usuario;
        }


        /**
         * Gets the tipoTarea value for this TareaVO.
         * 
         * @return tipoTarea
         */
        public java.lang.String getTipoTarea() {
            return tipoTarea;
        }


        /**
         * Sets the tipoTarea value for this TareaVO.
         * 
         * @param tipoTarea
         */
        public void setTipoTarea(java.lang.String tipoTarea) {
            this.tipoTarea = tipoTarea;
        }
    }
}