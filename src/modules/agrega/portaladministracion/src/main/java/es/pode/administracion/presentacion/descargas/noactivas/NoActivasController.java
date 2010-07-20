// license-header java merge-point
package es.pode.administracion.presentacion.descargas.noactivas;

/**
 * 
 */
public abstract class NoActivasController implements java.io.Serializable
{
    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.descargas.noactivas.ObtenerDatosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void obtenerDatos(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.descargas.noactivas.ObtenerDatosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.administracion.presentacion.descargas.noactivas.ActivarForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void activar(org.apache.struts.action.ActionMapping mapping, es.pode.administracion.presentacion.descargas.noactivas.ActivarForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     * Returns the current ConfigurarDescargaSession from the session found in the argument request.
     * <p/>
     * In case an object was found in the session but it was not of the correct type, this method
     * will return <code>null</code>.
     * <p/>
     * If there is no session, it will be created; if the session would not contain a session-object
     * the object will be instantiated and subsequently stored in the session.
     *
     * @param request javax.servlet.http.HttpServletRequest          
     * @return es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession
     */
    protected final es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession getConfigurarDescargaSession(javax.servlet.http.HttpServletRequest request)
    {
        es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession object = null;
        javax.servlet.http.HttpSession session = request.getSession(true);

        Object attribute = session.getAttribute(es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession.SESSION_KEY);
        if (attribute instanceof es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession)
        {
            object = (es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession)attribute;
        }
        else if (attribute == null)
        {
            object = new es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession ();
            setConfigurarDescargaSession(request, object);
        }

        return object;
    }

    /**
     * Set the argument ConfigurarDescargaSession object in the session corresponding with the argument request.
     * In case the session would not exist it will be created.
     *
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession                          
     */
    protected final void setConfigurarDescargaSession(javax.servlet.http.HttpServletRequest request, es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession object)
    {
        setConfigurarDescargaSession(request, object, true);
    }

    /**
     * Set the argument ConfigurarDescargaSession object in the session corresponding with the argument request.
     * Any existing object will be overwritten.
     *
     * @param createSession denotes whether or not the session should be created automatically in case it
     * would not yet exist
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession             
     */
    protected final void setConfigurarDescargaSession(javax.servlet.http.HttpServletRequest request, es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession object, boolean createSession)
    {
        javax.servlet.http.HttpSession session = request.getSession(createSession);
        if (session != null)
        {
            session.setAttribute(es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession.SESSION_KEY, object);
        }
    }

    /**
     * Removes the argument ConfigurarDescargaSession object from the session corresponding with the argument request.
     * In any of the following cases this method will do nothing:
     * <ul>
     *   <li>No session corresponds to the argument request</li>
     *   <li>No ConfigurarDescargaSession object could be found in the request</li>
     *   <li>The object is not of the correct type</li>
     * </ul>
     * @param request javax.servlet.http.HttpServletRequest            
     */
    protected final void removeConfigurarDescargaSession(javax.servlet.http.HttpServletRequest request)
    {
        javax.servlet.http.HttpSession session = request.getSession(false);
        if (session != null)
        {
            Object attribute = session.getAttribute(es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession.SESSION_KEY);
            if (attribute instanceof es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession)
            {
                session.removeAttribute(es.pode.administracion.presentacion.descargas.ConfigurarDescargaSession.SESSION_KEY);
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
	     * Returns a reference to the srvDescargas imported service.
         * @return es.pode.contenidos.negocio.descargas.servicio.SrvDescargas  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.contenidos.negocio.descargas.servicio.SrvDescargas getSrvDescargas()
	        throws java.lang.Exception
	    {
            String srvDescargasFile="importedServices.properties";	    
	        java.io.InputStream srvDescargasInputStream=NoActivasController.class.getClassLoader().getResourceAsStream(srvDescargasFile);
	        java.util.Properties srvDescargasProperties = new java.util.Properties();
	        srvDescargasProperties.load(srvDescargasInputStream);
	        String srvDescargasEndPointAddress="";
	        srvDescargasEndPointAddress=(String) srvDescargasProperties.get("srvDescargasPort");
            System.out.println("srvDescargasEndPointAddress del fichero --> " + srvDescargasEndPointAddress);
  			es.pode.contenidos.negocio.descargas.servicio.SrvDescargasService srvDescargas = new es.pode.contenidos.negocio.descargas.servicio.SrvDescargasServiceLocator();                                                                                                                                                                                                                                                    
            if (srvDescargasEndPointAddress.length()>0) 
				((es.pode.contenidos.negocio.descargas.servicio.SrvDescargasServiceLocator)srvDescargas).setSrvDescargasEndpointAddress(srvDescargasEndPointAddress);				
	    	es.pode.contenidos.negocio.descargas.servicio.SrvDescargas port = srvDescargas.getSrvDescargas();	    
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