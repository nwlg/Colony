/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.modificador.presentacion.informes.tarea;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;

import es.pode.modificador.negocio.servicio.ResultadoModificacionVO;
import es.pode.modificador.presentacion.idiomasBuscador.IdiomasBuscadorSingleton;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.modificador.presentacion.informes.tarea.InformeTareaController
 */
public class InformeTareaControllerImpl extends InformeTareaController
{
	private static final Logger logger = Logger.getLogger(InformeTareaControllerImpl.class);

    /**
     * @see es.pode.modificador.presentacion.informes.tarea.InformeTareaController#obtenerDatos(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.informes.tarea.ObtenerDatosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerDatos(ActionMapping mapping, es.pode.modificador.presentacion.informes.tarea.ObtenerDatosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	form.setNombreTarea(this.getInformeSession(request).getNombreTarea());
    	form.setDescResultado(this.getInformeSession(request).getDescResultado());  	
    	form.setResultadoTarea(this.getInformeSession(request).getResultadoTarea());
    	form.setOdes(this.getInformeSession(request).getOdes());
    	form.setIdiomaBuscadorBackingList(IdiomasBuscadorSingleton.getInstance().obtenerIdiomas(LdapUserDetailsUtils.getIdioma()), "idLocalizacion", "nombre");

     }


    /**
     * @see es.pode.modificador.presentacion.informes.tarea.InformeTareaController#restaurarODEs(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.informes.tarea.RestaurarODEsForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void restaurarODEs(ActionMapping mapping, es.pode.modificador.presentacion.informes.tarea.RestaurarODEsForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	Long idModificacion = this.getInformeSession(request).getIdModificacion();
    	if(idModificacion!=null) {
	    	String idODE = form.getId();
			Boolean result = this.getSrvHerramientaModificacion().restaurar(idModificacion, Long.valueOf(idODE));
			if(Boolean.FALSE.equals(result)) {
				throw new ValidatorException("{tareas.error.restaurar}");
			}
			// Recupero la modificacion para reinsertarla en la sesion
			ResultadoModificacionVO[] odes = this.getSrvHerramientaModificacion().obtenerResultadoModificacion(idModificacion);
			this.getInformeSession(request).setOdes(Arrays.asList(odes));
    	} else {
    		logger.debug("Se ha intentado restaurar un ODE desde el informe de simulacion. Ignorando");
    	}
		
     }

    /**
     * @see es.pode.modificador.presentacion.informes.tarea.InformeTareaController#obtenerOde(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.informes.tarea.ObtenerOdeForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void obtenerOde(ActionMapping mapping, es.pode.modificador.presentacion.informes.tarea.ObtenerOdeForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
	    try
	    {
	    	String idOde = form.getId();
	    	Long idModificacion = this.getInformeSession(request).getIdModificacion();
	    	ResultadoModificacionVO ode =null;
	    	if(idModificacion==null) {
	    		ode = buscarOde(Long.valueOf(idOde),this.getInformeSession(request).getOdes());
	    	} else {
	    		ode = this.getSrvHerramientaModificacion().recuperarResultadoODE(idModificacion, Long.valueOf(idOde));
	    	}
	    	form.setOde(ode);
	     }
	    catch (Exception e) 
	    {
			logger.error("No se pudo obtener el ODE debido a "+e.getMessage());
			if(logger.isDebugEnabled()) logger.debug(e);
			throw new ValidatorException("{informe.exception}");
	    }
    }

    private ResultadoModificacionVO buscarOde(Long idOde,Collection odes) {
    	ResultadoModificacionVO result = null;
    	for(Iterator it=odes.iterator();it.hasNext() && result == null;) {
    		ResultadoModificacionVO temp = (ResultadoModificacionVO)it.next(); 
    		if(temp.getId().equals(idOde)) result = temp;
    	}
    	return result;
    }

	public String submitConfirmacion(ActionMapping mapping, SubmitConfirmacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		java.util.Locale locale = (java.util.Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
    	String accion = form.getAction();
    	if (accion.equals(i18n.getString("modificacionesEjecutadas.aceptar")))
    	{
    		return "Aceptar";
    		
    	}
    	else
    	{
    		return "Cancelar";
    	}
	}

	public String selectOrigin(ActionMapping mapping, SelectOriginForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String origen = this.getInformeSession(request).getOrigen();
		
		String result="";				
		
		result = "Ejecutadas";
		 
		if ((origen!=null) && origen.equals(ConstantesInforme.Configurar)) 
		{
			form.setIdModificacion(this.getInformeSession(request).getTareaSeleccionada());
			result = "Configurar";
		}
		//Reseteamos sesión
		removeInformeSession(request);
		
        return result;
	}
}