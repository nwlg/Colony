/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.administracion.presentacion.planificador.informeTrabajo;


import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.administracion.presentacion.planificador.comun.Utiles;
import es.pode.planificador.negocio.servicios.RegistroTareaEjecutadaVO;
import es.pode.planificador.negocio.servicios.TareaEjecutadaVO;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;

/**
 * @see es.pode.administracion.presentacion.planificador.informeTrabajo.InformeController
 */
public class InformeControllerImpl extends InformeController {

    private static Logger log = Logger.getLogger(InformeControllerImpl.class);

    ResourceBundle ficheroRecursos = null;

    private Properties pSpringProperties = null;

    Utiles utilidades = new Utiles();

    public final void obtenerInformeTrabajo(ActionMapping mapping, ObtenerInformeTrabajoForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	
		try {
		    Long informe = null;
	
		    ficheroRecursos = ResourceBundle.getBundle("application-resources", request.getLocale());
	
		    if (form instanceof InformeFormImpl)
			informe = ((InformeFormImpl) form).getId();
		    else
			informe = ((MostrarDescripcionVolverFormImpl) form).getId();
	
		    RegistroTareaEjecutadaVO[] informeTrabajo = this.getSrvPlanificadorService().obtenerInformeTrabajo(informe);
	
		    RegistroTareaEjecutadaDate[] registroTareasDate = null;
	
		    if (informeTrabajo != null) {
			registroTareasDate = cambiarFormatoRegistroTareas(informeTrabajo, informe);
			form.setInformeTrabajoAsArray(registroTareasDate);
		    }
	
		    /* Cabecera del informe */
		    TareaEjecutadaVO cabecera = this.getSrvPlanificadorService().obtenerTrabajoEjecutado(informe);
	
		    /**
	                 * Recortamos el nombre de la tarea quitandole lo agregado al
	                 * nombre original Lo agregado son dos # seguidas de la fecha en
	                 * la que se ejecuta la tarea La fecha se compone de
	                 * "año+mes+dia+hora+minutos+segundos"
	                 */
		    int posicion = cabecera.getTrabajo().indexOf("!!");
	
		    if (posicion > 0)
			form.setTrabajo(cabecera.getTrabajo().substring(0, posicion));
		    else
			form.setTrabajo(cabecera.getTrabajo());
	
		    form.setDescripcion(cabecera.getDescripcion());
	
		    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
		    
		    
		    if(log.isDebugEnabled())log.debug("cabecera.getFechaInicio()" + cabecera.getFechaInicio());
		    String fechaInicio = formato.format(cabecera.getFechaInicio().getTime()); 
		    form.setFechaInicio(fechaInicio);
		    //log("fecha inicio despues del set" + form.getFechaInicio());
	
		    if (cabecera.getFechaFin() != null)
			form.setFechaFin(formato.format(cabecera.getFechaFin().getTime()));
	
		    
		} catch (Exception e) {
		    log.error("Error: " + e);
		    throw new ValidatorException("{tareas.error}");
		}
    }

    /**
         * Copiamos todas las tareas que vienen en el arrays de tareas recibidas
         * en un nuevo array de tareas cambiandole la fecha a tipo Date en vez
         * de Calendar
         */
    private RegistroTareaEjecutadaDate[] cambiarFormatoRegistroTareas(RegistroTareaEjecutadaVO[] informeTrabajo,
	    Long idTarea) {
    	
		RegistroTareaEjecutadaDate[] registroTareasDate = new RegistroTareaEjecutadaDate[informeTrabajo.length];
	
		for (int i = 0; i < informeTrabajo.length; i++) {
		    registroTareasDate[i] = cambiarFormatoRegistroTarea(informeTrabajo[i], idTarea);
		}
	
		return registroTareasDate;
    }

    /**
         * Copiamos todos los campos de la tarea recibida y los metemos en la
         * nueva tarea cambiando la fecha a Date
         */
    private RegistroTareaEjecutadaDate cambiarFormatoRegistroTarea(RegistroTareaEjecutadaVO registroTarea, Long idTarea) {
		RegistroTareaEjecutadaDate registroTareaDate = new RegistroTareaEjecutadaDate();
	
		String descripcion = registroTarea.getDescripcion();
	
		/*
	         * Sustituimos los tabuladores, saltos de linea y simbolos @ y > por
	         * espacio
	         */
		descripcion = descripcion.replace('\r', ' ');
		descripcion = descripcion.replace('\n', ' ');
		descripcion = descripcion.replace('\t', ' ');
		descripcion = descripcion.replace('>', '-');
		descripcion = descripcion.replace('@', '-');
	
		/* Limitamos el tamaño de la descripción del error */
		if (descripcion.length() > 300)
		    descripcion = descripcion.substring(0, 300);
	
		// Se comprueba el valor del campo codigo para concatenarlo a la
	        // descripcion
	
		if (registroTarea.getCodigo() != null) {
		    Locale locale = new Locale(LdapUserDetailsUtils.getIdioma());
		    ResourceBundle ficheroRecursos = this.getFicherRecursos(locale);
		    String codigo;
		    
		    //Controlamos que el codigo no este en el fichero de internacionalizacion
		    try
		    {
		    	codigo = ficheroRecursos.getString(registroTarea.getCodigo());
		    	log.debug("El codigo de la tarea ejecutada es " + registroTarea.getCodigo());		    	
		    }
		    catch(Exception e)
		    {
		    	codigo = " ";
		    	log.debug("El codigo de la tarea ejecutada no esta internacionalizado");
		    }
		    registroTareaDate.setDescripcion(descripcion + ". " + codigo);
		} else {
		    log.debug("El codigo de la tarea ejecutada es null");
		    registroTareaDate.setDescripcion(descripcion);
		}
		registroTareaDate.setFecha(registroTarea.getFecha().getTime());
		// registroTareaDate.setId(registroTarea.getId());
		registroTareaDate.setId(idTarea);
	
		if (registroTarea.getEstado() != null) {
		    if (registroTarea.getEstado().equals("OK"))
			registroTareaDate.setEstado(ficheroRecursos.getString("tareas.OK"));
		    else
			registroTareaDate.setEstado(ficheroRecursos.getString("tareas.ERROR"));
		} else
		    registroTareaDate.setEstado(" ");
	
		return registroTareaDate;
    }

    public void cargaIdiomas(ActionMapping mapping,
	    es.pode.administracion.presentacion.planificador.informeTrabajo.CargaIdiomasForm form,
	    HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    
    }

    /**
         * This dummy variable is used to populate the "informeTrabajo" table.
         * You may delete it when you add you own code in this controller.
         */
    private static final java.util.Collection informeTrabajoDummyList = java.util.Arrays.asList(new Object[] {
	    new InformeTrabajoDummy("descripcion-1"), new InformeTrabajoDummy("descripcion-2"),
	    new InformeTrabajoDummy("descripcion-3"), new InformeTrabajoDummy("descripcion-4"),
	    new InformeTrabajoDummy("descripcion-5") });

    /**
         * This inner class is used in the dummy implementation in order to get
         * the web application running without any manual programming. You may
         * delete this class when you add you own code in this controller.
         */
    public static final class InformeTrabajoDummy implements java.io.Serializable {
	private String descripcion = null;

	public InformeTrabajoDummy(String descripcion) {
	    this.descripcion = descripcion;
	}

	public void setDescripcion(String descripcion) {
	    this.descripcion = descripcion;
	}

	public String getDescripcion() {
	    return this.descripcion;
	}
    }

    public class RegistroTareaEjecutadaDate {
	private java.lang.String descripcion;

	private java.util.Date fecha;

	private java.lang.Long id;

	private java.lang.String estado;

	private es.pode.planificador.negocio.servicios.TareaEjecutadaVO tarea_ejecutada;

	public RegistroTareaEjecutadaDate() {
	}

	/**
         * Gets the descripcion value for this RegistroTareaEjecutadaVO.
         * 
         * @return descripcion
         */
	public java.lang.String getDescripcion() {
	    return descripcion;
	}

	/**
         * Sets the descripcion value for this RegistroTareaEjecutadaVO.
         * 
         * @param descripcion
         */
	public void setDescripcion(java.lang.String descripcion) {
	    this.descripcion = descripcion;
	}

	/**
         * Gets the fecha value for this RegistroTareaEjecutadaVO.
         * 
         * @return fecha
         */
	public java.util.Date getFecha() {
	    return fecha;
	}

	/**
         * Sets the fecha value for this RegistroTareaEjecutadaVO.
         * 
         * @param fecha
         */
	public void setFecha(java.util.Date fecha) {
	    this.fecha = fecha;
	}

	/**
         * Gets the id value for this RegistroTareaEjecutadaVO.
         * 
         * @return id
         */
	public java.lang.Long getId() {
	    return id;
	}

	/**
         * Sets the id value for this RegistroTareaEjecutadaVO.
         * 
         * @param id
         */
	public void setId(java.lang.Long id) {
	    this.id = id;
	}

	/**
         * Gets the estado value for this RegistroTareaEjecutadaVO.
         * 
         * @return estado
         */
	public java.lang.String getEstado() {
	    return estado;
	}

	/**
         * Sets the estado value for this RegistroTareaEjecutadaVO.
         * 
         * @param estado
         */
	public void setEstado(java.lang.String estado) {
	    this.estado = estado;
	}

	/**
         * Gets the tarea_ejecutada value for this RegistroTareaEjecutadaVO.
         * 
         * @return tarea_ejecutada
         */
	public es.pode.planificador.negocio.servicios.TareaEjecutadaVO getTarea_ejecutada() {
	    return tarea_ejecutada;
	}

	/**
         * Sets the tarea_ejecutada value for this RegistroTareaEjecutadaVO.
         * 
         * @param tarea_ejecutada
         */
	public void setTarea_ejecutada(es.pode.planificador.negocio.servicios.TareaEjecutadaVO tarea_ejecutada) {
	    this.tarea_ejecutada = tarea_ejecutada;
	}

    }

    private ResourceBundle getFicherRecursos(Locale locale) {
	ResourceBundle ficheroRecursos = null;
	ficheroRecursos = ResourceBundle.getBundle("application-resources", locale);
	return ficheroRecursos;
    }
    
}
