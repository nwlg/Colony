// license-header java merge-point
package es.pode.presentacion.visualizador;

/**
 * 
 */
public abstract class VisualizadorController implements java.io.Serializable
{
    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.presentacion.visualizador.CargarDatosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDatos(org.apache.struts.action.ActionMapping mapping, es.pode.presentacion.visualizador.CargarDatosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.presentacion.visualizador.CargarTipoVisForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return boolean
     */
    public abstract boolean cargarTipoVis(org.apache.struts.action.ActionMapping mapping, es.pode.presentacion.visualizador.CargarTipoVisForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.presentacion.visualizador.CargarDatosNavForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDatosNav(org.apache.struts.action.ActionMapping mapping, es.pode.presentacion.visualizador.CargarDatosNavForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.presentacion.visualizador.NodoOnClickForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void nodoOnClick(org.apache.struts.action.ActionMapping mapping, es.pode.presentacion.visualizador.NodoOnClickForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.presentacion.visualizador.NodoOnClickBotonForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void nodoOnClickBoton(org.apache.struts.action.ActionMapping mapping, es.pode.presentacion.visualizador.NodoOnClickBotonForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.presentacion.visualizador.FinSessionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void finSession(org.apache.struts.action.ActionMapping mapping, es.pode.presentacion.visualizador.FinSessionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     * Returns the current VisualizadorSession from the session found in the argument request.
     * <p/>
     * In case an object was found in the session but it was not of the correct type, this method
     * will return <code>null</code>.
     * <p/>
     * If there is no session, it will be created; if the session would not contain a session-object
     * the object will be instantiated and subsequently stored in the session.
     *
     * @param request javax.servlet.http.HttpServletRequest          
     * @return es.pode.presentacion.VisualizadorSession
     */
    protected final es.pode.presentacion.VisualizadorSession getVisualizadorSession(javax.servlet.http.HttpServletRequest request)
    {
        es.pode.presentacion.VisualizadorSession object = null;
        javax.servlet.http.HttpSession session = request.getSession(true);

        Object attribute = session.getAttribute(es.pode.presentacion.VisualizadorSession.SESSION_KEY);
        if (attribute instanceof es.pode.presentacion.VisualizadorSession)
        {
            object = (es.pode.presentacion.VisualizadorSession)attribute;
        }
        else if (attribute == null)
        {
            object = new es.pode.presentacion.VisualizadorSession ();
            setVisualizadorSession(request, object);
        }

        return object;
    }

    /**
     * Set the argument VisualizadorSession object in the session corresponding with the argument request.
     * In case the session would not exist it will be created.
     *
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.presentacion.VisualizadorSession                          
     */
    protected final void setVisualizadorSession(javax.servlet.http.HttpServletRequest request, es.pode.presentacion.VisualizadorSession object)
    {
        setVisualizadorSession(request, object, true);
    }

    /**
     * Set the argument VisualizadorSession object in the session corresponding with the argument request.
     * Any existing object will be overwritten.
     *
     * @param createSession denotes whether or not the session should be created automatically in case it
     * would not yet exist
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.presentacion.VisualizadorSession             
     */
    protected final void setVisualizadorSession(javax.servlet.http.HttpServletRequest request, es.pode.presentacion.VisualizadorSession object, boolean createSession)
    {
        javax.servlet.http.HttpSession session = request.getSession(createSession);
        if (session != null)
        {
            session.setAttribute(es.pode.presentacion.VisualizadorSession.SESSION_KEY, object);
        }
    }

    /**
     * Removes the argument VisualizadorSession object from the session corresponding with the argument request.
     * In any of the following cases this method will do nothing:
     * <ul>
     *   <li>No session corresponds to the argument request</li>
     *   <li>No VisualizadorSession object could be found in the request</li>
     *   <li>The object is not of the correct type</li>
     * </ul>
     * @param request javax.servlet.http.HttpServletRequest            
     */
    protected final void removeVisualizadorSession(javax.servlet.http.HttpServletRequest request)
    {
        javax.servlet.http.HttpSession session = request.getSession(false);
        if (session != null)
        {
            Object attribute = session.getAttribute(es.pode.presentacion.VisualizadorSession.SESSION_KEY);
            if (attribute instanceof es.pode.presentacion.VisualizadorSession)
            {
                session.removeAttribute(es.pode.presentacion.VisualizadorSession.SESSION_KEY);
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
	     * Returns a reference to the srvBuscarService imported service.
         * @return es.pode.buscar.negocio.buscar.servicios.SrvBuscarService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.buscar.negocio.buscar.servicios.SrvBuscarService getSrvBuscarService()
	        throws java.lang.Exception
	    {
            String srvBuscarServiceFile="importedServices.properties";	    
	        java.io.InputStream srvBuscarServiceInputStream=VisualizadorController.class.getClassLoader().getResourceAsStream(srvBuscarServiceFile);
	        java.util.Properties srvBuscarServiceProperties = new java.util.Properties();
	        srvBuscarServiceProperties.load(srvBuscarServiceInputStream);
	        String srvBuscarServiceEndPointAddress="";
	        srvBuscarServiceEndPointAddress=(String) srvBuscarServiceProperties.get("srvBuscarServicePort");
            System.out.println("srvBuscarServiceEndPointAddress del fichero --> " + srvBuscarServiceEndPointAddress);
  			es.pode.buscar.negocio.buscar.servicios.SrvBuscarServiceService srvBuscarService = new es.pode.buscar.negocio.buscar.servicios.SrvBuscarServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvBuscarServiceEndPointAddress.length()>0) 
				((es.pode.buscar.negocio.buscar.servicios.SrvBuscarServiceServiceLocator)srvBuscarService).setSrvBuscarServiceEndpointAddress(srvBuscarServiceEndPointAddress);				
	    	es.pode.buscar.negocio.buscar.servicios.SrvBuscarService port = srvBuscarService.getSrvBuscarService();	    
	        return port;
	    }

	

			    /**
	     * Returns a reference to the srvEntregarService imported service.
         * @return es.pode.entregar.negocio.servicios.SrvEntregarService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.entregar.negocio.servicios.SrvEntregarService getSrvEntregarService()
	        throws java.lang.Exception
	    {
            String srvEntregarServiceFile="importedServices.properties";	    
	        java.io.InputStream srvEntregarServiceInputStream=VisualizadorController.class.getClassLoader().getResourceAsStream(srvEntregarServiceFile);
	        java.util.Properties srvEntregarServiceProperties = new java.util.Properties();
	        srvEntregarServiceProperties.load(srvEntregarServiceInputStream);
	        String srvEntregarServiceEndPointAddress="";
	        srvEntregarServiceEndPointAddress=(String) srvEntregarServiceProperties.get("srvEntregarServicePort");
            System.out.println("srvEntregarServiceEndPointAddress del fichero --> " + srvEntregarServiceEndPointAddress);
  			es.pode.entregar.negocio.servicios.SrvEntregarServiceService srvEntregarService = new es.pode.entregar.negocio.servicios.SrvEntregarServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvEntregarServiceEndPointAddress.length()>0) 
				((es.pode.entregar.negocio.servicios.SrvEntregarServiceServiceLocator)srvEntregarService).setSrvEntregarServiceEndpointAddress(srvEntregarServiceEndPointAddress);				
	    	es.pode.entregar.negocio.servicios.SrvEntregarService port = srvEntregarService.getSrvEntregarService();	    
	        return port;
	    }

	
	/**
	 * Gets the reference to the dozer bean mapper used in the application (singleton).
	 * @return MapperIF
	 */
    public final net.sf.dozer.util.mapping.MapperIF getBeanMapper()
    {
		        return es.pode.visualizador.presentacion.ServiceLocator.instance().getBeanMapper();
    }
}