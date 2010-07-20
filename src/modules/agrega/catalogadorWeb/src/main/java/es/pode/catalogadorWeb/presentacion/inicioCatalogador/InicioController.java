// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.inicioCatalogador;

/**
 * 
 */
public abstract class InicioController implements java.io.Serializable
{
    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.inicioCatalogador.CargarTipoCatalogadorForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String cargarTipoCatalogador(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.inicioCatalogador.CargarTipoCatalogadorForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.inicioCatalogador.CrearSesionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void crearSesion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.inicioCatalogador.CrearSesionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     * Returns the current CatalogadorBSession from the session found in the argument request.
     * <p/>
     * In case an object was found in the session but it was not of the correct type, this method
     * will return <code>null</code>.
     * <p/>
     * If there is no session, it will be created; if the session would not contain a session-object
     * the object will be instantiated and subsequently stored in the session.
     *
     * @param request javax.servlet.http.HttpServletRequest          
     * @return es.pode.catalogadorWeb.presentacion.CatalogadorBSession
     */
    protected final es.pode.catalogadorWeb.presentacion.CatalogadorBSession getCatalogadorBSession(javax.servlet.http.HttpServletRequest request)
    {
        es.pode.catalogadorWeb.presentacion.CatalogadorBSession object = null;
        javax.servlet.http.HttpSession session = request.getSession(true);

        Object attribute = session.getAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorBSession.SESSION_KEY);
        if (attribute instanceof es.pode.catalogadorWeb.presentacion.CatalogadorBSession)
        {
            object = (es.pode.catalogadorWeb.presentacion.CatalogadorBSession)attribute;
        }
        else if (attribute == null)
        {
            object = new es.pode.catalogadorWeb.presentacion.CatalogadorBSession ();
            setCatalogadorBSession(request, object);
        }

        return object;
    }

    /**
     * Set the argument CatalogadorBSession object in the session corresponding with the argument request.
     * In case the session would not exist it will be created.
     *
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.catalogadorWeb.presentacion.CatalogadorBSession                          
     */
    protected final void setCatalogadorBSession(javax.servlet.http.HttpServletRequest request, es.pode.catalogadorWeb.presentacion.CatalogadorBSession object)
    {
        setCatalogadorBSession(request, object, true);
    }

    /**
     * Set the argument CatalogadorBSession object in the session corresponding with the argument request.
     * Any existing object will be overwritten.
     *
     * @param createSession denotes whether or not the session should be created automatically in case it
     * would not yet exist
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.catalogadorWeb.presentacion.CatalogadorBSession             
     */
    protected final void setCatalogadorBSession(javax.servlet.http.HttpServletRequest request, es.pode.catalogadorWeb.presentacion.CatalogadorBSession object, boolean createSession)
    {
        javax.servlet.http.HttpSession session = request.getSession(createSession);
        if (session != null)
        {
            session.setAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorBSession.SESSION_KEY, object);
        }
    }

    /**
     * Removes the argument CatalogadorBSession object from the session corresponding with the argument request.
     * In any of the following cases this method will do nothing:
     * <ul>
     *   <li>No session corresponds to the argument request</li>
     *   <li>No CatalogadorBSession object could be found in the request</li>
     *   <li>The object is not of the correct type</li>
     * </ul>
     * @param request javax.servlet.http.HttpServletRequest            
     */
    protected final void removeCatalogadorBSession(javax.servlet.http.HttpServletRequest request)
    {
        javax.servlet.http.HttpSession session = request.getSession(false);
        if (session != null)
        {
            Object attribute = session.getAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorBSession.SESSION_KEY);
            if (attribute instanceof es.pode.catalogadorWeb.presentacion.CatalogadorBSession)
            {
                session.removeAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorBSession.SESSION_KEY);
            }
        }
    }

    
    /**
     * Returns the current CatalogadorBPSession from the session found in the argument request.
     * <p/>
     * In case an object was found in the session but it was not of the correct type, this method
     * will return <code>null</code>.
     * <p/>
     * If there is no session, it will be created; if the session would not contain a session-object
     * the object will be instantiated and subsequently stored in the session.
     *
     * @param request javax.servlet.http.HttpServletRequest          
     * @return es.pode.catalogadorWeb.presentacion.CatalogadorBPSession
     */
    protected final es.pode.catalogadorWeb.presentacion.CatalogadorBPSession getCatalogadorBPSession(javax.servlet.http.HttpServletRequest request)
    {
        es.pode.catalogadorWeb.presentacion.CatalogadorBPSession object = null;
        javax.servlet.http.HttpSession session = request.getSession(true);

        Object attribute = session.getAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorBPSession.SESSION_KEY);
        if (attribute instanceof es.pode.catalogadorWeb.presentacion.CatalogadorBPSession)
        {
            object = (es.pode.catalogadorWeb.presentacion.CatalogadorBPSession)attribute;
        }
        else if (attribute == null)
        {
            object = new es.pode.catalogadorWeb.presentacion.CatalogadorBPSession ();
            setCatalogadorBPSession(request, object);
        }

        return object;
    }

    /**
     * Set the argument CatalogadorBPSession object in the session corresponding with the argument request.
     * In case the session would not exist it will be created.
     *
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.catalogadorWeb.presentacion.CatalogadorBPSession                          
     */
    protected final void setCatalogadorBPSession(javax.servlet.http.HttpServletRequest request, es.pode.catalogadorWeb.presentacion.CatalogadorBPSession object)
    {
        setCatalogadorBPSession(request, object, true);
    }

    /**
     * Set the argument CatalogadorBPSession object in the session corresponding with the argument request.
     * Any existing object will be overwritten.
     *
     * @param createSession denotes whether or not the session should be created automatically in case it
     * would not yet exist
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.catalogadorWeb.presentacion.CatalogadorBPSession             
     */
    protected final void setCatalogadorBPSession(javax.servlet.http.HttpServletRequest request, es.pode.catalogadorWeb.presentacion.CatalogadorBPSession object, boolean createSession)
    {
        javax.servlet.http.HttpSession session = request.getSession(createSession);
        if (session != null)
        {
            session.setAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorBPSession.SESSION_KEY, object);
        }
    }

    /**
     * Removes the argument CatalogadorBPSession object from the session corresponding with the argument request.
     * In any of the following cases this method will do nothing:
     * <ul>
     *   <li>No session corresponds to the argument request</li>
     *   <li>No CatalogadorBPSession object could be found in the request</li>
     *   <li>The object is not of the correct type</li>
     * </ul>
     * @param request javax.servlet.http.HttpServletRequest            
     */
    protected final void removeCatalogadorBPSession(javax.servlet.http.HttpServletRequest request)
    {
        javax.servlet.http.HttpSession session = request.getSession(false);
        if (session != null)
        {
            Object attribute = session.getAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorBPSession.SESSION_KEY);
            if (attribute instanceof es.pode.catalogadorWeb.presentacion.CatalogadorBPSession)
            {
                session.removeAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorBPSession.SESSION_KEY);
            }
        }
    }
    
    
    /**
     * Returns the current CatalogadorAvSession from the session found in the argument request.
     * <p/>
     * In case an object was found in the session but it was not of the correct type, this method
     * will return <code>null</code>.
     * <p/>
     * If there is no session, it will be created; if the session would not contain a session-object
     * the object will be instantiated and subsequently stored in the session.
     *
     * @param request javax.servlet.http.HttpServletRequest          
     * @return es.pode.catalogadorWeb.presentacion.CatalogadorAvSession
     */
    protected final es.pode.catalogadorWeb.presentacion.CatalogadorAvSession getCatalogadorAvSession(javax.servlet.http.HttpServletRequest request)
    {
        es.pode.catalogadorWeb.presentacion.CatalogadorAvSession object = null;
        javax.servlet.http.HttpSession session = request.getSession(true);

        Object attribute = session.getAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorAvSession.SESSION_KEY);
        if (attribute instanceof es.pode.catalogadorWeb.presentacion.CatalogadorAvSession)
        {
            object = (es.pode.catalogadorWeb.presentacion.CatalogadorAvSession)attribute;
        }
        else if (attribute == null)
        {
            object = new es.pode.catalogadorWeb.presentacion.CatalogadorAvSession ();
            setCatalogadorAvSession(request, object);
        }

        return object;
    }

    /**
     * Set the argument CatalogadorAvSession object in the session corresponding with the argument request.
     * In case the session would not exist it will be created.
     *
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.catalogadorWeb.presentacion.CatalogadorAvSession                          
     */
    protected final void setCatalogadorAvSession(javax.servlet.http.HttpServletRequest request, es.pode.catalogadorWeb.presentacion.CatalogadorAvSession object)
    {
        setCatalogadorAvSession(request, object, true);
    }

    /**
     * Set the argument CatalogadorAvSession object in the session corresponding with the argument request.
     * Any existing object will be overwritten.
     *
     * @param createSession denotes whether or not the session should be created automatically in case it
     * would not yet exist
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.catalogadorWeb.presentacion.CatalogadorAvSession             
     */
    protected final void setCatalogadorAvSession(javax.servlet.http.HttpServletRequest request, es.pode.catalogadorWeb.presentacion.CatalogadorAvSession object, boolean createSession)
    {
        javax.servlet.http.HttpSession session = request.getSession(createSession);
        if (session != null)
        {
            session.setAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorAvSession.SESSION_KEY, object);
        }
    }

    /**
     * Removes the argument CatalogadorAvSession object from the session corresponding with the argument request.
     * In any of the following cases this method will do nothing:
     * <ul>
     *   <li>No session corresponds to the argument request</li>
     *   <li>No CatalogadorAvSession object could be found in the request</li>
     *   <li>The object is not of the correct type</li>
     * </ul>
     * @param request javax.servlet.http.HttpServletRequest            
     */
    protected final void removeCatalogadorAvSession(javax.servlet.http.HttpServletRequest request)
    {
        javax.servlet.http.HttpSession session = request.getSession(false);
        if (session != null)
        {
            Object attribute = session.getAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorAvSession.SESSION_KEY);
            if (attribute instanceof es.pode.catalogadorWeb.presentacion.CatalogadorAvSession)
            {
                session.removeAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorAvSession.SESSION_KEY);
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
	     * Returns a reference to the srvCatalogacionAvanzadaService imported service.
         * @return es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService getSrvCatalogacionAvanzadaService()
	        throws java.lang.Exception
	    {
            String srvCatalogacionAvanzadaServiceFile="importedServices.properties";	    
	        java.io.InputStream srvCatalogacionAvanzadaServiceInputStream=InicioController.class.getClassLoader().getResourceAsStream(srvCatalogacionAvanzadaServiceFile);
	        java.util.Properties srvCatalogacionAvanzadaServiceProperties = new java.util.Properties();
	        srvCatalogacionAvanzadaServiceProperties.load(srvCatalogacionAvanzadaServiceInputStream);
	        String srvCatalogacionAvanzadaServiceEndPointAddress="";
	        srvCatalogacionAvanzadaServiceEndPointAddress=(String) srvCatalogacionAvanzadaServiceProperties.get("srvCatalogacionAvanzadaServicePort");
            System.out.println("srvCatalogacionAvanzadaServiceEndPointAddress del fichero --> " + srvCatalogacionAvanzadaServiceEndPointAddress);
  			es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaServiceService srvCatalogacionAvanzadaService = new es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvCatalogacionAvanzadaServiceEndPointAddress.length()>0) 
				((es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaServiceServiceLocator)srvCatalogacionAvanzadaService).setSrvCatalogacionAvanzadaServiceEndpointAddress(srvCatalogacionAvanzadaServiceEndPointAddress);				
	    	es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService port = srvCatalogacionAvanzadaService.getSrvCatalogacionAvanzadaService();	    
	        return port;
	    }

	
	/**
	 * Gets the reference to the dozer bean mapper used in the application (singleton).
	 * @return MapperIF
	 */
    public final net.sf.dozer.util.mapping.MapperIF getBeanMapper()
    {
		        return es.pode.catalogadorWeb.presentacion.ServiceLocator.instance().getBeanMapper();
    }
}