/* Agrega es una federación de repositorios de objetos digitales educativos formada por todas las Comunidades Autónomas propiedad de Red.es. Este código ha sido desarrollado por la Entidad Pública Empresarial red.es adscrita al Ministerio de Industria,Turismo y Comercio a través de la Secretaría de Estado de Telecomunicaciones y para la Sociedad de la Información, dentro del Programa Internet en el Aula, que se encuadra dentro de las actuaciones previstas en el Plan Avanza (Plan 2006-2010 para el desarrollo de la Sociedad de la Información y de Convergencia con Europa y entre Comunidades Autónomas y Ciudades Autónomas) y ha sido cofinanciado con fondos FEDER del Programa Operativo FEDER 2000-2006 “Sociedad de la Información”

This program is free software: you can redistribute it and/or modify it under the terms of the European Union Public Licence (EUPL v.1.0).  This program is distributed in the hope that it will be useful,  but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the European Union Public Licence (EUPL v.1.0). You should have received a copy of the EUPL licence along with this program.  If not, see http://ec.europa.eu/idabc/en/document/7330.
*/
// license-header java merge-point
package es.pode.modificador.presentacion.configurar.modificacion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.validator.ValidatorException;
import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.MessageResources;

import es.pode.modificador.negocio.servicio.Change;
import es.pode.modificador.negocio.servicio.Changes;
import es.pode.modificador.negocio.servicio.ConfiguracionTarea;
import es.pode.modificador.negocio.servicio.Folder;
import es.pode.modificador.negocio.servicio.ODE;
import es.pode.modificador.negocio.servicio.Objects;
import es.pode.modificador.presentacion.configurar.cambios.CambioSession;
import es.pode.modificador.presentacion.idiomasBuscador.IdiomasBuscadorSingleton;
import es.pode.soporte.constantes.ConstantesAgrega;
import es.pode.soporte.seguridad.ldap.LdapUserDetailsUtils;



/**
 * @see es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionController
 */
public class ConfigurarModificacionControllerImpl extends ConfigurarModificacionController
{

	private static final Logger logger = Logger.getLogger(ConfigurarModificacionControllerImpl.class);
	private static final String APPLICATION_RESOURCES="application-resources";
	private static final MessageResources resources = MessageResources.getMessageResources(APPLICATION_RESOURCES);


    /**
     * @see es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionController#submitObjetos(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.modificacion.SubmitObjetosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void submitObjetos(
			ActionMapping mapping,
			es.pode.modificador.presentacion.configurar.modificacion.SubmitObjetosForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List pathRowSelect = form.getPathRowSelection();
		String action = form.getAction();
		if (logger.isDebugEnabled())
			logger.debug("Submit de objetos; action = " + action);
		if (resources.getMessage((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE),"configurarModificacion.objetos.eliminar")
				.equals(action)) {
			// Valido que hay objetos que eliminar
			if (pathRowSelect == null || pathRowSelect.size() == 0) {
				throw new ValidatorException(
						"{configurarModificacion.objetos.eliminar.error}");
			}
			form.setPaths(pathRowSelect);
		}
	}

    /**
	 * @see es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionController#selectAction(org.apache.struts.action.ActionMapping,
	 *      es.pode.modificador.presentacion.configurar.modificacion.SelectActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
    public final java.lang.String selectAction(
			ActionMapping mapping,
			es.pode.modificador.presentacion.configurar.modificacion.SelectActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String result = null;

		if (logger.isDebugEnabled())
			logger.debug("Submit de los cambios con action = "
					+ form.getAction());
		if (resources.getMessage((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE),"configurarModificacion.cambios.eliminar")
				.equals(form.getAction())) {
			// Valida que hay algo que eliminar
			int[] posiciones = form.getPosiciones();
			if (posiciones == null || posiciones.length == 0) {
				throw new ValidatorException(
						"{configurarModificacion.cambios.eliminar.error}");
			}
			result = "Eliminar";
			// Meto en la sesion el array de enteros
			request.getSession().setAttribute("posiciones", posiciones);
		} else if (resources.getMessage((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE),"configurarModificacion.cambios.crear")
				.equals(form.getAction())) {
			result = "Añadir";
		}
		return result;
	}

    /**
	 * @see es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionController#obtenerDatos(org.apache.struts.action.ActionMapping,
	 *      es.pode.modificador.presentacion.configurar.modificacion.ObtenerDatosForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
    public final void obtenerDatos(
			ActionMapping mapping,
			es.pode.modificador.presentacion.configurar.modificacion.ObtenerDatosForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Long idModificacion = this.getConfigurarModificacionSession(request)
				.getIdModificacion();
		
		if(idModificacion!=null) form.setIdModificacion(idModificacion);

		// Si no hay configuracion creada, genero una vacia
		if(this.getConfigurarModificacionSession(request).getConfiguracion()==null) {
			if(logger.isDebugEnabled()) logger.debug("Generando configuracion vacia");
			ConfiguracionTarea tarea = new ConfiguracionTarea();
			tarea.setObjetos(new Objects());
			tarea.setCambios(new Changes());
			tarea.getObjetos().setObjetos(new ODE[0]);
			tarea.getObjetos().setPaths(new Folder[0]);
			tarea.getCambios().setCambios(new Change[0]);
			this.getConfigurarModificacionSession(request).setConfiguracion(tarea);
		}
		
		ConfiguracionTarea confTarea = this.getConfigurarModificacionSession(
				request).getConfiguracion();
		Changes cambios = confTarea.getCambios();
		List cambiosList = new ArrayList();
		cambiosList.addAll(Arrays.asList(cambios.getCambios()));
		form.setCambios(cambiosList);

		Objects objetos = confTarea.getObjetos();

		List objetosList = new ArrayList();
		objetosList.addAll(Arrays.asList(objetos.getPaths()));
		objetosList.addAll(Arrays.asList(objetos.getObjetos()));
		
		form.setObjetos(objetosList);
		form.setIdiomaBuscadorBackingList(IdiomasBuscadorSingleton.getInstance().obtenerIdiomas(LdapUserDetailsUtils.getIdioma()), "idLocalizacion", "nombre");
	}

    /**
	 * @see es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionController#submitBotones(org.apache.struts.action.ActionMapping,
	 *      es.pode.modificador.presentacion.configurar.modificacion.SubmitBotonesForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
    public final String submitBotones(ActionMapping mapping, es.pode.modificador.presentacion.configurar.modificacion.SubmitBotonesForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	java.util.Locale locale = (java.util.Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE);
		ResourceBundle i18n = ResourceBundle.getBundle("application-resources",locale);
    	String accion = form.getAction();
    	if (accion.equals(i18n.getString("configurarModificacion.objetos.volver")))
    	{
    		return "Volver";
    		
    	}
    	else if (accion.equals(i18n.getString("configurarModificacion.objetos.cancelar"))) 
    	{
    		return "Cancelar";
    	}
    	else
    	{
    		return "Guardar";
    	}
     }

    /**
     * @see es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionController#eliminarObjetos(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.modificacion.EliminarObjetosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarObjetos(
			ActionMapping mapping,
			es.pode.modificador.presentacion.configurar.modificacion.EliminarObjetosForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
    	List paths = (List)request.getSession().getAttribute("paths");
    	request.getSession().removeAttribute("paths");
    	if(paths!=null) {
    		if(logger.isDebugEnabled()) logger.debug("Se han seleccionado " + paths.size() + " paths para eliminar");
    		ConfiguracionTarea configuracion = this.getConfigurarModificacionSession(request).getConfiguracion();
    		List odes = new ArrayList();
    		odes.addAll(Arrays.asList(configuracion.getObjetos().getObjetos()));
    		List folders = new ArrayList();
    		folders.addAll(Arrays.asList(configuracion.getObjetos().getPaths()));
    		for(int i=0;i<paths.size();i++) {
	    		for(Iterator it=odes.iterator();it.hasNext();) {
	    			ODE ode = (ODE)it.next();
	    			if(paths.get(i).equals(ode.getPath())) {
	    				if(logger.isDebugEnabled()) logger.debug("Eliminando " + ode.getPath());
	    				it.remove();
	    			}
	    		}
	    		for(Iterator it=folders.iterator();it.hasNext();) {
	    			Folder folder = (Folder)it.next();
	    			if(paths.get(i).equals(folder.getPath())) {
	    				if(logger.isDebugEnabled()) logger.debug("Eliminando " + folder.getPath());
	    				it.remove();
	    			}
	    		}
    		}
    		configuracion.getObjetos().setObjetos((ODE[])odes.toArray(new ODE[odes.size()]));
    		configuracion.getObjetos().setPaths((Folder[])folders.toArray(new Folder[folders.size()]));
    		if(logger.isDebugEnabled()) logger.debug("Introduciendo configuracion en la sesion");
    		this.getConfigurarModificacionSession(request).setConfiguracion(configuracion);
    	} else {
    		logger.error("No habia ningun path para eliminar");
    	}
	}

    /**
     * @see es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionController#eliminarCambios(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.modificacion.EliminarCambiosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final void eliminarCambios(ActionMapping mapping, es.pode.modificador.presentacion.configurar.modificacion.EliminarCambiosForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
    {
    	int[] posiciones = (int[])request.getSession().getAttribute("posiciones");
    	request.getSession().removeAttribute("posiciones");
    	if(posiciones!=null) {
    		if(logger.isDebugEnabled()) logger.debug("Se han seleccionado " + posiciones.length + " cambios para eliminar");
    		ArrayList cambios = new ArrayList();
    		cambios.addAll(Arrays.asList(this.getConfigurarModificacionSession(request).getConfiguracion().getCambios().getCambios()));
    		ArrayList paraBorrar = new ArrayList();
    		for(int i=0;i<posiciones.length;i++) {
    			paraBorrar.add((Change)cambios.get(posiciones[i]));
    		}
    		for(int i=0;i<paraBorrar.size();i++) {
    			cambios.remove(paraBorrar.get(i));
    		}
			if(logger.isDebugEnabled()) logger.debug("Actualizando el objeto de sesion");
    		this.getConfigurarModificacionSession(request).getConfiguracion().getCambios().setCambios((Change[])cambios.toArray(new Change[cambios.size()]));
    	} else {
    		logger.error("No habia ningun cambio para eliminar");
    	}
    }

    /**
     * @see es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionController#selectActionObjetos(org.apache.struts.action.ActionMapping, es.pode.modificador.presentacion.configurar.modificacion.SelectActionObjetosForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public final java.lang.String selectActionObjetos(
			ActionMapping mapping,
			es.pode.modificador.presentacion.configurar.modificacion.SelectActionObjetosForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String action = form.getAction();
		List paths = form.getPaths();
		String result = null;
		if (logger.isDebugEnabled())
			logger.debug("selectActionObjetos con action = " + action
					+ " y paths = " + paths);
		if (resources.getMessage((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE),"configurarModificacion.objetos.eliminar")
				.equals(action)) {
			result = "Eliminar";
			request.getSession().setAttribute("paths", paths);
		} else if (resources.getMessage((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE),"configurarModificacion.objetos.crear")
				.equals(action)) {
			result = "Añadir";
		}
		return result;
	}

   
	public void guardarModificacion(ActionMapping mapping, GuardarModificacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		ConfiguracionTarea configuracion = this.getConfigurarModificacionSession(request).getConfiguracion();
		Long idModificacion = this.getConfigurarModificacionSession(request).getIdModificacion();
		String nombre = this.getConfigurarModificacionSession(request).getNombre();
		
		try {
			if(logger.isDebugEnabled()) logger.debug("Guardando tarea idModificacion = " + idModificacion + " con nombre " + nombre);
			Long idMod = this.getSrvHerramientaModificacion().configurar(idModificacion, configuracion,nombre);
			if(idModificacion==null) this.getConfigurarModificacionSession(request).setIdModificacion(idMod);
		} catch (Exception e) {
			logger.error("No se pudo almacenar la tarea de modificacion: " + e.getMessage());
			if(logger.isDebugEnabled()) logger.debug(e);
		}
	}


	public String submitConfirmacion(ActionMapping mapping, SubmitConfirmacionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		String action = form.getAction();
		String result = null;
		if(logger.isDebugEnabled()) logger.debug("Confirmacion de eliminar cambios: action = " + action);
		if(resources.getMessage((Locale)request.getSession().getAttribute(ConstantesAgrega.DEFAULT_LOCALE),"configurarModificacion.cambios.eliminar.confirmacion.si").equals(action)) {
			result = "Aceptar";
		} else {
			result = "Cancelar";
			// elimino las posiciones de la sesion
			request.getSession().removeAttribute("posiciones");
			request.getSession().removeAttribute("paths");
		}
		return result;
	}

	
	public void borrarSesion(ActionMapping mapping, es.pode.modificador.presentacion.configurar.modificacion.BorrarSesionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		this.removeConfigurarModificacionSession(request);
		
	}

	public void modificarCambio(ActionMapping mapping, ModificarCambioForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String sPosicion = form.getPosicion();
		if(sPosicion!=null) {
			int posicicion = Integer.parseInt(sPosicion);
			ConfiguracionTarea tarea = this.getConfigurarModificacionSession(request).getConfiguracion();
			logger.debug("Recuperando cambio " + posicicion + " del array de cambios");
			Change cambio = tarea.getCambios().getCambios()[posicicion];
			CambioSession cambioSession = this.getCambioSession(request);
			cambioSession.setTipo(cambio.getType().getValue());
			cambioSession.setAlcance(cambio.getMainLomOnly());
			cambioSession.setExprReg(cambio.getRegExp());
			cambioSession.setIdioma(cambio.getLanguage());
			cambioSession.setIdLomTerm(cambio.getIdLomTerm());
			cambioSession.setLomTerm(cambio.getLomTerm());
			cambioSession.setPosicion(new Integer(posicicion));
			cambioSession.setReplaceAll(cambio.getReplaceAll());
			cambioSession.setTipoAniadir(cambio.getTermType()==null? null :cambio.getTermType().getValue());
			cambioSession.setValor(cambio.getValue());
			cambioSession.setValorNuevo(cambio.getNewValue());
		}

	}




}