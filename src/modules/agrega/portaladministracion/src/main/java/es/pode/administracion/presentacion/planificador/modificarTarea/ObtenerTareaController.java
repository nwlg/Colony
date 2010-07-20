// license-header java merge-point
package es.pode.administracion.presentacion.planificador.modificarTarea;

/**
 * 
 */
public abstract class ObtenerTareaController implements java.io.Serializable
{
    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaModificarCargaODEsForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void obtenerTareaModificarCargaODEs(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaModificarCargaODEsForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTipoTareaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String obtenerTipoTarea(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTipoTareaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaReindexadoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void obtenerTareaReindexado(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaReindexadoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaCargaODEsForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void modificarTareaCargaODEs(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaCargaODEsForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaReindexadoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void modificarTareaReindexado(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaReindexadoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ValidarFormularioCargaODEsForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void validarFormularioCargaODEs(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ValidarFormularioCargaODEsForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ValidarFormularioReindexadoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void validarFormularioReindexado(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ValidarFormularioReindexadoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaNoDisponibleForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void obtenerTareaNoDisponible(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaNoDisponibleForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ValidarFormularioNoDisponiblesForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void validarFormularioNoDisponibles(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ValidarFormularioNoDisponiblesForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaNoDisponiblesForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void modificarTareaNoDisponibles(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaNoDisponiblesForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeFechaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void obtenerTareaInformeFecha(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeFechaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeFechaRangoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void obtenerTareaInformeFechaRango(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeFechaRangoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeFechaUsuarioForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void obtenerTareaInformeFechaUsuario(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeFechaUsuarioForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ValidarFormularioFechaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void validarFormularioFecha(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ValidarFormularioFechaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ValidarInformeFechaRangoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void validarInformeFechaRango(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ValidarInformeFechaRangoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ValidarInformeFechaUsuarioForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void validarInformeFechaUsuario(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ValidarInformeFechaUsuarioForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaInformeFechaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void modificarTareaInformeFecha(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaInformeFechaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaInformeFechaRangoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void modificarTareaInformeFechaRango(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaInformeFechaRangoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaInformeFechaUsuarioForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void modificarTareaInformeFechaUsuario(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaInformeFechaUsuarioForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeFederadoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void obtenerTareaInformeFederado(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeFederadoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ValidarInformeFederadoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void validarInformeFederado(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ValidarInformeFederadoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaInformeFederadoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void modificarTareaInformeFederado(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ModificarTareaInformeFederadoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeCatalogoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void obtenerTareaInformeCatalogo(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ObtenerTareaInformeCatalogoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.planificador.modificarTarea.ValidarInformeCatalogoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void validarInformeCatalogo(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.planificador.modificarTarea.ValidarInformeCatalogoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     * Stores a warning message in the session, if any other warning messages exist, this one
     * is simply added. This message will be removed from the session after the first time
     * it has been accessed (a feature supported by Struts since version 1.2.4).
     *
     * @param request the session to which the messages will be saved.
     * @param message the message key to lookup the actual message to display
     * @param arguments any arguments used within the message
     */
    protected final void saveWarningMessage(javax.servlet.http.HttpServletRequest request, java.lang.String message, java.lang.String[] arguments)
    {
        final javax.servlet.http.HttpSession session = request.getSession();

        // we explicitely store and retrieve the messages from the session, as opposed to using
        // Action.saveMessages because this constroller does not have access to the current Action instance
        org.apache.struts.action.ActionMessages messages = (org.apache.struts.action.ActionMessages)session.getAttribute(org.apache.struts.Globals.MESSAGE_KEY);
        if (messages == null)
        {
            messages = new org.apache.struts.action.ActionMessages();
            session.setAttribute(org.apache.struts.Globals.MESSAGE_KEY, messages);
        }
        messages.add("org.andromda.bpm4struts.warningmessages", new org.apache.struts.action.ActionMessage(message, arguments));
    }

    /**
     * Stores a warning message in the session, if any other warning messages exist, this one
     * is simply added. This message will be removed from the session after the first time
     * it has been accessed (a feature supported by Struts since version 1.2.4).
     *
     * @param request the session to which the messages will be saved.
     * @param message the message key to lookup the actual message to display
     * @see #saveWarningMessage(javax.servlet.http.HttpServletRequest, java.lang.String, java.lang.String[])
     */
    protected final void saveWarningMessage(javax.servlet.http.HttpServletRequest request, java.lang.String message)
    {
        this.saveWarningMessage(request, message, null);
    }

    /**
     * Stores a success message in the session, if any other success messages exist, this one
     * is simply added. This message will be removed from the session after the first time
     * it has been accessed (a feature supported by Struts since version 1.2.4).
     *
     * @param request the request from which the session will be taken into which the messages will be saved.
     * @param message the message key to lookup the actual message to display
     * @param arguments java.lang.String[]            
     */
    protected final void saveSuccessMessage(javax.servlet.http.HttpServletRequest request, java.lang.String message, java.lang.String[] arguments)
    {
        final javax.servlet.http.HttpSession session = request.getSession();

        // we explicitely store and retrieve the messages from the session, as opposed to using
        // Action.saveMessages because this constroller does not have access to the current Action instance
        org.apache.struts.action.ActionMessages messages = (org.apache.struts.action.ActionMessages)session.getAttribute(org.apache.struts.Globals.MESSAGE_KEY);
        if (messages == null)
        {
            messages = new org.apache.struts.action.ActionMessages();
            session.setAttribute(org.apache.struts.Globals.MESSAGE_KEY, messages);
        }
        messages.add("org.andromda.bpm4struts.successmessages", new org.apache.struts.action.ActionMessage(message, arguments));
    }

    /**
     * Stores a success message in the session, if any other success messages exist, this one
     * is simply added. This message will be removed from the session after the first time
     * it has been accessed (a feature supported by Struts since version 1.2.4).
     *
     * @param request the request from which the session will be taken into which the messages will be saved.
     * @param message the message key to lookup the actual message to display
     * @see #saveSuccessMessage(javax.servlet.http.HttpServletRequest, java.lang.String, java.lang.String[])
     */
    protected final void saveSuccessMessage(javax.servlet.http.HttpServletRequest request, java.lang.String message)
    {
        this.saveSuccessMessage(request, message, null);
    }

    /**
     * Stores an error message in the session, if any other error messages exist, this one
     * is simply added. This message will be removed from the session after the first time
     * it has been accessed (a feature supported by Struts since version 1.2.4).
     *
     * @param request the request from which the session will be taken into which the messages will be saved.
     * @param message the message key to lookup the actual message to display
     * @param arguments java.lang.String[]            
     * @see #saveSuccessMessage(javax.servlet.http.HttpServletRequest, java.lang.String, java.lang.String[])
     */
    protected final void saveErrorMessage(javax.servlet.http.HttpServletRequest request, java.lang.String message, java.lang.String[] arguments)
    {
        final javax.servlet.http.HttpSession session = request.getSession();

        // we explicitely store and retrieve the messages from the session, as opposed to using
        // Action.saveMessages because this constroller does not have access to the current Action instance
        org.apache.struts.action.ActionMessages messages = (org.apache.struts.action.ActionMessages)session.getAttribute(org.apache.struts.Globals.MESSAGE_KEY);
        if (messages == null)
        {
            messages = new org.apache.struts.action.ActionMessages();
            session.setAttribute(org.apache.struts.Globals.MESSAGE_KEY, messages);
        }
        messages.add("org.andromda.bpm4struts.errormessages", new org.apache.struts.action.ActionMessage(message, arguments));
    }

    /**
     * Stores an error message in the session, if any other error messages exist, this one
     * is simply added. This message will be removed from the session after the first time
     * it has been accessed (a feature supported by Struts since version 1.2.4).
     *
     * @param request the request from which the session will be taken into which the messages will be saved.
     * @param message the message key to lookup the actual message to display
     * @see #saveSuccessMessage(javax.servlet.http.HttpServletRequest, java.lang.String, java.lang.String[])
     */
    protected final void saveErrorMessage(javax.servlet.http.HttpServletRequest request, java.lang.String message)
    {
        this.saveErrorMessage(request, message, null);
    }



			    /**
	     * Returns a reference to the srvBuscadorService imported service.
         * @return es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService getSrvBuscadorService()
	        throws java.lang.Exception
	    {
            String srvBuscadorServiceFile="importedServices.properties";	    
	        java.io.InputStream srvBuscadorServiceInputStream=ObtenerTareaController.class.getClassLoader().getResourceAsStream(srvBuscadorServiceFile);
	        java.util.Properties srvBuscadorServiceProperties = new java.util.Properties();
	        srvBuscadorServiceProperties.load(srvBuscadorServiceInputStream);
	        String srvBuscadorServiceEndPointAddress="";
	        srvBuscadorServiceEndPointAddress=(String) srvBuscadorServiceProperties.get("srvBuscadorServicePort");
            System.out.println("srvBuscadorServiceEndPointAddress del fichero --> " + srvBuscadorServiceEndPointAddress);
  			es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorServiceService srvBuscadorService = new es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvBuscadorServiceEndPointAddress.length()>0) 
				((es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorServiceServiceLocator)srvBuscadorService).setSrvBuscadorServiceEndpointAddress(srvBuscadorServiceEndPointAddress);				
	    	es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService port = srvBuscadorService.getSrvBuscadorService();	    
	        return port;
	    }

	

			    /**
	     * Returns a reference to the srvAdminUsuariosService imported service.
         * @return es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService getSrvAdminUsuariosService()
	        throws java.lang.Exception
	    {
            String srvAdminUsuariosServiceFile="importedServices.properties";	    
	        java.io.InputStream srvAdminUsuariosServiceInputStream=ObtenerTareaController.class.getClassLoader().getResourceAsStream(srvAdminUsuariosServiceFile);
	        java.util.Properties srvAdminUsuariosServiceProperties = new java.util.Properties();
	        srvAdminUsuariosServiceProperties.load(srvAdminUsuariosServiceInputStream);
	        String srvAdminUsuariosServiceEndPointAddress="";
	        srvAdminUsuariosServiceEndPointAddress=(String) srvAdminUsuariosServiceProperties.get("srvAdminUsuariosServicePort");
            System.out.println("srvAdminUsuariosServiceEndPointAddress del fichero --> " + srvAdminUsuariosServiceEndPointAddress);
  			es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosServiceService srvAdminUsuariosService = new es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvAdminUsuariosServiceEndPointAddress.length()>0) 
				((es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosServiceServiceLocator)srvAdminUsuariosService).setSrvAdminUsuariosServiceEndpointAddress(srvAdminUsuariosServiceEndPointAddress);				
	    	es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService port = srvAdminUsuariosService.getSrvAdminUsuariosService();	    
	        return port;
	    }

	

			    /**
	     * Returns a reference to the srvPlanificadorService imported service.
         * @return es.pode.planificador.negocio.servicios.SrvPlanificadorService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.planificador.negocio.servicios.SrvPlanificadorService getSrvPlanificadorService()
	        throws java.lang.Exception
	    {
            String srvPlanificadorServiceFile="importedServices.properties";	    
	        java.io.InputStream srvPlanificadorServiceInputStream=ObtenerTareaController.class.getClassLoader().getResourceAsStream(srvPlanificadorServiceFile);
	        java.util.Properties srvPlanificadorServiceProperties = new java.util.Properties();
	        srvPlanificadorServiceProperties.load(srvPlanificadorServiceInputStream);
	        String srvPlanificadorServiceEndPointAddress="";
	        srvPlanificadorServiceEndPointAddress=(String) srvPlanificadorServiceProperties.get("srvPlanificadorServicePort");
            System.out.println("srvPlanificadorServiceEndPointAddress del fichero --> " + srvPlanificadorServiceEndPointAddress);
  			es.pode.planificador.negocio.servicios.SrvPlanificadorServiceService srvPlanificadorService = new es.pode.planificador.negocio.servicios.SrvPlanificadorServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvPlanificadorServiceEndPointAddress.length()>0) 
				((es.pode.planificador.negocio.servicios.SrvPlanificadorServiceServiceLocator)srvPlanificadorService).setSrvPlanificadorServiceEndpointAddress(srvPlanificadorServiceEndPointAddress);				
	    	es.pode.planificador.negocio.servicios.SrvPlanificadorService port = srvPlanificadorService.getSrvPlanificadorService();	    
	        return port;
	    }

	
	/**
	 * Gets the reference to the dozer bean mapper used in the application (singleton).
	 * @return MapperIF
	 */
    public final net.sf.dozer.util.mapping.MapperIF getBeanMapper()
    {
		        return es.pode.administracion.presentacion.ServiceLocator.instance().getBeanMapper();
    }
}