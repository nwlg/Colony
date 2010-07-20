// license-header java merge-point
package es.pode.modificador.presentacion.configurar.modificacion;

/**
 * 
 */
public abstract class ConfigurarModificacionController implements java.io.Serializable
{
    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.modificador.presentacion.configurar.modificacion.SubmitObjetosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void submitObjetos(org.apache.struts.action.ActionMapping mapping, es.pode.modificador.presentacion.configurar.modificacion.SubmitObjetosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.modificador.presentacion.configurar.modificacion.SelectActionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String selectAction(org.apache.struts.action.ActionMapping mapping, es.pode.modificador.presentacion.configurar.modificacion.SelectActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.modificador.presentacion.configurar.modificacion.ObtenerDatosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void obtenerDatos(org.apache.struts.action.ActionMapping mapping, es.pode.modificador.presentacion.configurar.modificacion.ObtenerDatosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.modificador.presentacion.configurar.modificacion.SubmitBotonesForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String submitBotones(org.apache.struts.action.ActionMapping mapping, es.pode.modificador.presentacion.configurar.modificacion.SubmitBotonesForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.modificador.presentacion.configurar.modificacion.EliminarObjetosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void eliminarObjetos(org.apache.struts.action.ActionMapping mapping, es.pode.modificador.presentacion.configurar.modificacion.EliminarObjetosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.modificador.presentacion.configurar.modificacion.EliminarCambiosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void eliminarCambios(org.apache.struts.action.ActionMapping mapping, es.pode.modificador.presentacion.configurar.modificacion.EliminarCambiosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.modificador.presentacion.configurar.modificacion.SelectActionObjetosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String selectActionObjetos(org.apache.struts.action.ActionMapping mapping, es.pode.modificador.presentacion.configurar.modificacion.SelectActionObjetosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.modificador.presentacion.configurar.modificacion.GuardarModificacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void guardarModificacion(org.apache.struts.action.ActionMapping mapping, es.pode.modificador.presentacion.configurar.modificacion.GuardarModificacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.modificador.presentacion.configurar.modificacion.SubmitConfirmacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String submitConfirmacion(org.apache.struts.action.ActionMapping mapping, es.pode.modificador.presentacion.configurar.modificacion.SubmitConfirmacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.modificador.presentacion.configurar.modificacion.BorrarSesionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void borrarSesion(org.apache.struts.action.ActionMapping mapping, es.pode.modificador.presentacion.configurar.modificacion.BorrarSesionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.modificador.presentacion.configurar.modificacion.ModificarCambioForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void modificarCambio(org.apache.struts.action.ActionMapping mapping, es.pode.modificador.presentacion.configurar.modificacion.ModificarCambioForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     * Returns the current ConfigurarModificacionSession from the session found in the argument request.
     * <p/>
     * In case an object was found in the session but it was not of the correct type, this method
     * will return <code>null</code>.
     * <p/>
     * If there is no session, it will be created; if the session would not contain a session-object
     * the object will be instantiated and subsequently stored in the session.
     *
     * @param request javax.servlet.http.HttpServletRequest          
     * @return es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession
     */
    protected final es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession getConfigurarModificacionSession(javax.servlet.http.HttpServletRequest request)
    {
        es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession object = null;
        javax.servlet.http.HttpSession session = request.getSession(true);

        Object attribute = session.getAttribute(es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession.SESSION_KEY);
        if (attribute instanceof es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession)
        {
            object = (es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession)attribute;
        }
        else if (attribute == null)
        {
            object = new es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession ();
            setConfigurarModificacionSession(request, object);
        }

        return object;
    }

    /**
     * Set the argument ConfigurarModificacionSession object in the session corresponding with the argument request.
     * In case the session would not exist it will be created.
     *
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession                          
     */
    protected final void setConfigurarModificacionSession(javax.servlet.http.HttpServletRequest request, es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession object)
    {
        setConfigurarModificacionSession(request, object, true);
    }

    /**
     * Set the argument ConfigurarModificacionSession object in the session corresponding with the argument request.
     * Any existing object will be overwritten.
     *
     * @param createSession denotes whether or not the session should be created automatically in case it
     * would not yet exist
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession             
     */
    protected final void setConfigurarModificacionSession(javax.servlet.http.HttpServletRequest request, es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession object, boolean createSession)
    {
        javax.servlet.http.HttpSession session = request.getSession(createSession);
        if (session != null)
        {
            session.setAttribute(es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession.SESSION_KEY, object);
        }
    }

    /**
     * Removes the argument ConfigurarModificacionSession object from the session corresponding with the argument request.
     * In any of the following cases this method will do nothing:
     * <ul>
     *   <li>No session corresponds to the argument request</li>
     *   <li>No ConfigurarModificacionSession object could be found in the request</li>
     *   <li>The object is not of the correct type</li>
     * </ul>
     * @param request javax.servlet.http.HttpServletRequest            
     */
    protected final void removeConfigurarModificacionSession(javax.servlet.http.HttpServletRequest request)
    {
        javax.servlet.http.HttpSession session = request.getSession(false);
        if (session != null)
        {
            Object attribute = session.getAttribute(es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession.SESSION_KEY);
            if (attribute instanceof es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession)
            {
                session.removeAttribute(es.pode.modificador.presentacion.configurar.ConfigurarModificacionSession.SESSION_KEY);
            }
        }
    }

    /**
     * Returns the current CambioSession from the session found in the argument request.
     * <p/>
     * In case an object was found in the session but it was not of the correct type, this method
     * will return <code>null</code>.
     * <p/>
     * If there is no session, it will be created; if the session would not contain a session-object
     * the object will be instantiated and subsequently stored in the session.
     *
     * @param request javax.servlet.http.HttpServletRequest          
     * @return es.pode.modificador.presentacion.configurar.cambios.CambioSession
     */
    protected final es.pode.modificador.presentacion.configurar.cambios.CambioSession getCambioSession(javax.servlet.http.HttpServletRequest request)
    {
        es.pode.modificador.presentacion.configurar.cambios.CambioSession object = null;
        javax.servlet.http.HttpSession session = request.getSession(true);

        Object attribute = session.getAttribute(es.pode.modificador.presentacion.configurar.cambios.CambioSession.SESSION_KEY);
        if (attribute instanceof es.pode.modificador.presentacion.configurar.cambios.CambioSession)
        {
            object = (es.pode.modificador.presentacion.configurar.cambios.CambioSession)attribute;
        }
        else if (attribute == null)
        {
            object = new es.pode.modificador.presentacion.configurar.cambios.CambioSession ();
            setCambioSession(request, object);
        }

        return object;
    }

    /**
     * Set the argument CambioSession object in the session corresponding with the argument request.
     * In case the session would not exist it will be created.
     *
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.modificador.presentacion.configurar.cambios.CambioSession                          
     */
    protected final void setCambioSession(javax.servlet.http.HttpServletRequest request, es.pode.modificador.presentacion.configurar.cambios.CambioSession object)
    {
        setCambioSession(request, object, true);
    }

    /**
     * Set the argument CambioSession object in the session corresponding with the argument request.
     * Any existing object will be overwritten.
     *
     * @param createSession denotes whether or not the session should be created automatically in case it
     * would not yet exist
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.modificador.presentacion.configurar.cambios.CambioSession             
     */
    protected final void setCambioSession(javax.servlet.http.HttpServletRequest request, es.pode.modificador.presentacion.configurar.cambios.CambioSession object, boolean createSession)
    {
        javax.servlet.http.HttpSession session = request.getSession(createSession);
        if (session != null)
        {
            session.setAttribute(es.pode.modificador.presentacion.configurar.cambios.CambioSession.SESSION_KEY, object);
        }
    }

    /**
     * Removes the argument CambioSession object from the session corresponding with the argument request.
     * In any of the following cases this method will do nothing:
     * <ul>
     *   <li>No session corresponds to the argument request</li>
     *   <li>No CambioSession object could be found in the request</li>
     *   <li>The object is not of the correct type</li>
     * </ul>
     * @param request javax.servlet.http.HttpServletRequest            
     */
    protected final void removeCambioSession(javax.servlet.http.HttpServletRequest request)
    {
        javax.servlet.http.HttpSession session = request.getSession(false);
        if (session != null)
        {
            Object attribute = session.getAttribute(es.pode.modificador.presentacion.configurar.cambios.CambioSession.SESSION_KEY);
            if (attribute instanceof es.pode.modificador.presentacion.configurar.cambios.CambioSession)
            {
                session.removeAttribute(es.pode.modificador.presentacion.configurar.cambios.CambioSession.SESSION_KEY);
            }
        }
    }

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
	     * Returns a reference to the srvHerramientaModificacion imported service.
         * @return es.pode.modificador.negocio.servicio.SrvHerramientaModificacion  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.modificador.negocio.servicio.SrvHerramientaModificacion getSrvHerramientaModificacion()
	        throws java.lang.Exception
	    {
            String srvHerramientaModificacionFile="importedServices.properties";	    
	        java.io.InputStream srvHerramientaModificacionInputStream=ConfigurarModificacionController.class.getClassLoader().getResourceAsStream(srvHerramientaModificacionFile);
	        java.util.Properties srvHerramientaModificacionProperties = new java.util.Properties();
	        srvHerramientaModificacionProperties.load(srvHerramientaModificacionInputStream);
	        String srvHerramientaModificacionEndPointAddress="";
	        srvHerramientaModificacionEndPointAddress=(String) srvHerramientaModificacionProperties.get("srvHerramientaModificacionPort");
            System.out.println("srvHerramientaModificacionEndPointAddress del fichero --> " + srvHerramientaModificacionEndPointAddress);
  			es.pode.modificador.negocio.servicio.SrvHerramientaModificacionService srvHerramientaModificacion = new es.pode.modificador.negocio.servicio.SrvHerramientaModificacionServiceLocator();                                                                                                                                                                                                                                                    
            if (srvHerramientaModificacionEndPointAddress.length()>0) 
				((es.pode.modificador.negocio.servicio.SrvHerramientaModificacionServiceLocator)srvHerramientaModificacion).setSrvHerramientaModificacionEndpointAddress(srvHerramientaModificacionEndPointAddress);				
	    	es.pode.modificador.negocio.servicio.SrvHerramientaModificacion port = srvHerramientaModificacion.getSrvHerramientaModificacion();	    
	        return port;
	    }

	
	/**
	 * Gets the reference to the dozer bean mapper used in the application (singleton).
	 * @return MapperIF
	 */
    public final net.sf.dozer.util.mapping.MapperIF getBeanMapper()
    {
		        return es.pode.modificador.ServiceLocator.instance().getBeanMapper();
    }
}