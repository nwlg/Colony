/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.planificador.listarTareasEjecutadas;


import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import es.pode.administracion.presentacion.planificador.comun.Utiles;
import es.pode.planificador.negocio.servicios.TareaEjecutadaVO;


public class TareasEjecutadasControllerImpl extends TareasEjecutadasController
{
	private static Logger log = Logger.getLogger(TareasEjecutadasControllerImpl.class);
	private Properties pSpringProperties = null;
	ResourceBundle ficheroRecursos = null;
	
	/**
	 * metodo que obtiene los trabajos ejecutados que se han seleccionado para ser eliminados
	 */
	public final void obtenerIdsTrabajos(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.listarTareasEjecutadas.ObtenerIdsTrabajosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
	{
		try {
			
			List lista = ((ListarEliminarFormImpl)form).getIdRowSelection();
			
		    if (lista == null) 
		    {
		    	throw new ValidatorException("{tareas.errorEliminar}");
		    } 
		    else 
		    {
		    	form.setIds((Collection)lista);
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
	
	
	/**
	 * metodo que obtiene los trabajos que ya estan ejecutados
	 */
    public final void obtenerTrabajosEjecutados(ActionMapping mapping, ObtenerTrabajosEjecutadosForm form, 
    		HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	
    	try 
    	{
    		Utiles utilidades = new Utiles();
    		
    		ficheroRecursos = ResourceBundle.getBundle("application-resources", request.getLocale());
    		
       		
    		TareaEjecutadaVO[] tareas = this.getSrvPlanificadorService().obtenerTrabajosEjecutados();
    		
    		TareaEjecutadaDate[] tareasDate = null;
    		
    		if (tareas != null) {
    			tareasDate = cambiarFormatoTareas(tareas);
    			tareasDate = ordenaDescendente(tareasDate);
    			((ListarTareasEjecutadasFormImpl)form).setTareasEjecutadasAsArray(tareasDate);
    		}
    		    		
    	}
    	catch (Exception e)
    	{
    		log.error("Error: " + e);
    		throw new ValidatorException("{tareas.error}");
    	}
    }
    
    
    /** Copiamos todas las tareas que vienene en el arrays de tareas recibidas en un nuevo array 
     * array de tareas cambiandole la fecha a tipo Date en vez de Calendar
     * */
    private TareaEjecutadaDate[] cambiarFormatoTareas(TareaEjecutadaVO[] tareas) 
    {

    	TareaEjecutadaDate[] tareasDate = new TareaEjecutadaDate[tareas.length];
    	
		for(int i=0;i<tareas.length;i++)
		{
			tareasDate[i]=cambiarFormatoTarea(tareas[i]);
		}

		return tareasDate;
    }
    
    
    /** Copiamos todos los campos de la tarea recibida y los metemos en la nueva tarea cambiando 
     * la fecha a Date
     * */
    private TareaEjecutadaDate cambiarFormatoTarea(TareaEjecutadaVO tarea) 
    {

    	TareaEjecutadaDate tareaDate = new TareaEjecutadaDate();
    	
    	tareaDate.setDescripcion(tarea.getDescripcion());
    	if (tarea.getFechaFin() != null)
    			tareaDate.setFechaFin(tarea.getFechaFin().getTime());
    	if (tarea.getFechaInicio() != null)
    		tareaDate.setFechaInicio(tarea.getFechaInicio().getTime());
    	tareaDate.setGrupoTrabajo(tarea.getGrupoTrabajo());
    	tareaDate.setId(tarea.getId());
    	
    	if (tarea.getEstado() != null)
    	{
	    	if (tarea.getEstado().equals("OK"))
	    		tareaDate.setEstado(ficheroRecursos.getString("tareas.OK"));
	    	else if (tarea.getEstado().equals("ERROR"))
	    		tareaDate.setEstado(ficheroRecursos.getString("tareas.ERROR"));
	    	else if(tarea.getEstado().equals("INTERRUMPIDO"))
	    		tareaDate.setEstado(ficheroRecursos.getString("tareas.INTERRUMPIDO"));
    	}
    	else 
    		tareaDate.setEstado(" ");
    	
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
     * This dummy variable is used to populate the "tareasEjecutadas" table.
     * You may delete it when you add you own code in this controller.
     */
    private static final java.util.Collection tareasEjecutadasDummyList =
        java.util.Arrays.asList( new Object[] {
            new TareasEjecutadasDummy("job-1"),
            new TareasEjecutadasDummy("job-2"),
            new TareasEjecutadasDummy("job-3"),
            new TareasEjecutadasDummy("job-4"),
            new TareasEjecutadasDummy("job-5")
        } );

    /**
     * This inner class is used in the dummy implementation in order to get the web application
     * running without any manual programming.
     * You may delete this class when you add you own code in this controller.
     */
    public static final class TareasEjecutadasDummy implements java.io.Serializable
    {
        private String job = null;

        public TareasEjecutadasDummy(String job)
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


    public class TareaEjecutadaDate  {
    	
        /* Descripcion de una tarea ejecutada (trabajo) */
        private java.lang.String descripcion;

        private java.lang.String trabajo;

        private java.lang.String grupoTrabajo;

        private java.util.Date fechaInicio;

        private java.lang.Long id;

        private java.util.Date fechaFin;

        private java.lang.String usuario;

        private java.lang.String estado;
        
        private es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO[] registroTareaEjecutadaVOs;

        public TareaEjecutadaDate() {
        }

        /**
         * Gets the descripcion value for this TareaEjecutadaVO.
         * 
         * @return descripcion   * Descripcion de una tarea ejecutada (trabajo)
         */
        public java.lang.String getDescripcion() {
            return descripcion;
        }


        /**
         * Sets the descripcion value for this TareaEjecutadaVO.
         * 
         * @param descripcion   * Descripcion de una tarea ejecutada (trabajo)
         */
        public void setDescripcion(java.lang.String descripcion) {
            this.descripcion = descripcion;
        }


        /**
         * Gets the trabajo value for this TareaEjecutadaVO.
         * 
         * @return trabajo
         */
        public java.lang.String getTrabajo() {
            return trabajo;
        }


        /**
         * Sets the trabajo value for this TareaEjecutadaVO.
         * 
         * @param trabajo
         */
        public void setTrabajo(java.lang.String trabajo) {
            this.trabajo = trabajo;
        }


        /**
         * Gets the grupoTrabajo value for this TareaEjecutadaVO.
         * 
         * @return grupoTrabajo
         */
        public java.lang.String getGrupoTrabajo() {
            return grupoTrabajo;
        }

        
        /**
         * Sets the grupoTrabajo value for this TareaEjecutadaVO.
         * 
         * @param grupoTrabajo
         */
        public void setGrupoTrabajo(java.lang.String grupoTrabajo) {
            this.grupoTrabajo = grupoTrabajo;
        }

        public java.lang.String getEstado() {
            return estado;
        }

        public void setEstado(java.lang.String estado) {
            this.estado = estado;
        }
        
        /**
         * Gets the fechaInicio value for this TareaEjecutadaVO.
         * 
         * @return fechaInicio
         */
        public java.util.Date getFechaInicio() {
            return fechaInicio;
        }


        /**
         * Sets the fechaInicio value for this TareaEjecutadaVO.
         * 
         * @param fechaInicio
         */
        public void setFechaInicio(java.util.Date fechaInicio) {
            this.fechaInicio = fechaInicio;
        }


        /**
         * Gets the id value for this TareaEjecutadaVO.
         * 
         * @return id
         */
        public java.lang.Long getId() {
            return id;
        }


        /**
         * Sets the id value for this TareaEjecutadaVO.
         * 
         * @param id
         */
        public void setId(java.lang.Long id) {
            this.id = id;
        }


        /**
         * Gets the fechaFin value for this TareaEjecutadaVO.
         * 
         * @return fechaFin
         */
        public java.util.Date getFechaFin() {
            return fechaFin;
        }


        /**
         * Sets the fechaFin value for this TareaEjecutadaVO.
         * 
         * @param fechaFin
         */
        public void setFechaFin(java.util.Date fechaFin) {
            this.fechaFin = fechaFin;
        }


        /**
         * Gets the usuario value for this TareaEjecutadaVO.
         * 
         * @return usuario
         */
        public java.lang.String getUsuario() {
            return usuario;
        }


        /**
         * Sets the usuario value for this TareaEjecutadaVO.
         * 
         * @param usuario
         */
        public void setUsuario(java.lang.String usuario) {
            this.usuario = usuario;
        }
    }
    /**
	 * Obtiene una array de Value Objets ordenados 
	 * @param  array Array de Value Objects que se quiere ordenar
	 * @return TareaDate[] Array con los Value Object ordenados
	 * @throws Exception
	 */
	private TareaEjecutadaDate[] ordenaDescendente(TareaEjecutadaDate[] array)
	{
		TareaEjecutadaDate tmp;
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
}