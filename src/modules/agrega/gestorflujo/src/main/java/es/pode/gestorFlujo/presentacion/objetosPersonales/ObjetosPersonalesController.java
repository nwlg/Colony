// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosPersonales;

/**
 * <p>
 * Esta clase implementa todos los metodos necesarios para el caso
 * de uso de Objetos Personales.
 * </p>
 */
public abstract class ObjetosPersonalesController implements java.io.Serializable
{
    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.gestorFlujo.presentacion.objetosPersonales.CargarODESPersonalesForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarODESPersonales(org.apache.struts.action.ActionMapping mapping, es.pode.gestorFlujo.presentacion.objetosPersonales.CargarODESPersonalesForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.gestorFlujo.presentacion.objetosPersonales.SubmitArchivosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void submitArchivos(org.apache.struts.action.ActionMapping mapping, es.pode.gestorFlujo.presentacion.objetosPersonales.SubmitArchivosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.gestorFlujo.presentacion.objetosPersonales.CompartirDescompartirODEForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void compartirDescompartirODE(org.apache.struts.action.ActionMapping mapping, es.pode.gestorFlujo.presentacion.objetosPersonales.CompartirDescompartirODEForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     * Returns the current ObjetosPersonalesSession from the session found in the argument request.
     * <p/>
     * In case an object was found in the session but it was not of the correct type, this method
     * will return <code>null</code>.
     * <p/>
     * If there is no session, it will be created; if the session would not contain a session-object
     * the object will be instantiated and subsequently stored in the session.
     *
     * @param request javax.servlet.http.HttpServletRequest          
     * @return es.pode.gestorFlujo.presentacion.ObjetosPersonalesSession
     */
    protected final es.pode.gestorFlujo.presentacion.ObjetosPersonalesSession getObjetosPersonalesSession(javax.servlet.http.HttpServletRequest request)
    {
        es.pode.gestorFlujo.presentacion.ObjetosPersonalesSession object = null;
        javax.servlet.http.HttpSession session = request.getSession(true);

        Object attribute = session.getAttribute(es.pode.gestorFlujo.presentacion.ObjetosPersonalesSession.SESSION_KEY);
        if (attribute instanceof es.pode.gestorFlujo.presentacion.ObjetosPersonalesSession)
        {
            object = (es.pode.gestorFlujo.presentacion.ObjetosPersonalesSession)attribute;
        }
        else if (attribute == null)
        {
            object = new es.pode.gestorFlujo.presentacion.ObjetosPersonalesSession ();
            setObjetosPersonalesSession(request, object);
        }

        return object;
    }

    /**
     * Set the argument ObjetosPersonalesSession object in the session corresponding with the argument request.
     * In case the session would not exist it will be created.
     *
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.gestorFlujo.presentacion.ObjetosPersonalesSession                          
     */
    protected final void setObjetosPersonalesSession(javax.servlet.http.HttpServletRequest request, es.pode.gestorFlujo.presentacion.ObjetosPersonalesSession object)
    {
        setObjetosPersonalesSession(request, object, true);
    }

    /**
     * Set the argument ObjetosPersonalesSession object in the session corresponding with the argument request.
     * Any existing object will be overwritten.
     *
     * @param createSession denotes whether or not the session should be created automatically in case it
     * would not yet exist
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.gestorFlujo.presentacion.ObjetosPersonalesSession             
     */
    protected final void setObjetosPersonalesSession(javax.servlet.http.HttpServletRequest request, es.pode.gestorFlujo.presentacion.ObjetosPersonalesSession object, boolean createSession)
    {
        javax.servlet.http.HttpSession session = request.getSession(createSession);
        if (session != null)
        {
            session.setAttribute(es.pode.gestorFlujo.presentacion.ObjetosPersonalesSession.SESSION_KEY, object);
        }
    }

    /**
     * Removes the argument ObjetosPersonalesSession object from the session corresponding with the argument request.
     * In any of the following cases this method will do nothing:
     * <ul>
     *   <li>No session corresponds to the argument request</li>
     *   <li>No ObjetosPersonalesSession object could be found in the request</li>
     *   <li>The object is not of the correct type</li>
     * </ul>
     * @param request javax.servlet.http.HttpServletRequest            
     */
    protected final void removeObjetosPersonalesSession(javax.servlet.http.HttpServletRequest request)
    {
        javax.servlet.http.HttpSession session = request.getSession(false);
        if (session != null)
        {
            Object attribute = session.getAttribute(es.pode.gestorFlujo.presentacion.ObjetosPersonalesSession.SESSION_KEY);
            if (attribute instanceof es.pode.gestorFlujo.presentacion.ObjetosPersonalesSession)
            {
                session.removeAttribute(es.pode.gestorFlujo.presentacion.ObjetosPersonalesSession.SESSION_KEY);
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
	     * Returns a reference to the srvPublicacionService imported service.
         * @return es.pode.publicacion.negocio.servicios.SrvPublicacionService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.publicacion.negocio.servicios.SrvPublicacionService getSrvPublicacionService()
	        throws java.lang.Exception
	    {
            String srvPublicacionServiceFile="importedServices.properties";	    
	        java.io.InputStream srvPublicacionServiceInputStream=ObjetosPersonalesController.class.getClassLoader().getResourceAsStream(srvPublicacionServiceFile);
	        java.util.Properties srvPublicacionServiceProperties = new java.util.Properties();
	        srvPublicacionServiceProperties.load(srvPublicacionServiceInputStream);
	        String srvPublicacionServiceEndPointAddress="";
	        srvPublicacionServiceEndPointAddress=(String) srvPublicacionServiceProperties.get("srvPublicacionServicePort");
            System.out.println("srvPublicacionServiceEndPointAddress del fichero --> " + srvPublicacionServiceEndPointAddress);
  			es.pode.publicacion.negocio.servicios.SrvPublicacionServiceService srvPublicacionService = new es.pode.publicacion.negocio.servicios.SrvPublicacionServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvPublicacionServiceEndPointAddress.length()>0) 
				((es.pode.publicacion.negocio.servicios.SrvPublicacionServiceServiceLocator)srvPublicacionService).setSrvPublicacionServiceEndpointAddress(srvPublicacionServiceEndPointAddress);				
	    	es.pode.publicacion.negocio.servicios.SrvPublicacionService port = srvPublicacionService.getSrvPublicacionService();	    
	        return port;
	    }

	

			    /**
	     * Returns a reference to the srvLocalizadorService imported service.
         * @return es.pode.localizador.negocio.servicios.SrvLocalizadorService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.localizador.negocio.servicios.SrvLocalizadorService getSrvLocalizadorService()
	        throws java.lang.Exception
	    {
            String srvLocalizadorServiceFile="importedServices.properties";	    
	        java.io.InputStream srvLocalizadorServiceInputStream=ObjetosPersonalesController.class.getClassLoader().getResourceAsStream(srvLocalizadorServiceFile);
	        java.util.Properties srvLocalizadorServiceProperties = new java.util.Properties();
	        srvLocalizadorServiceProperties.load(srvLocalizadorServiceInputStream);
	        String srvLocalizadorServiceEndPointAddress="";
	        srvLocalizadorServiceEndPointAddress=(String) srvLocalizadorServiceProperties.get("srvLocalizadorServicePort");
            System.out.println("srvLocalizadorServiceEndPointAddress del fichero --> " + srvLocalizadorServiceEndPointAddress);
  			es.pode.localizador.negocio.servicios.SrvLocalizadorServiceService srvLocalizadorService = new es.pode.localizador.negocio.servicios.SrvLocalizadorServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvLocalizadorServiceEndPointAddress.length()>0) 
				((es.pode.localizador.negocio.servicios.SrvLocalizadorServiceServiceLocator)srvLocalizadorService).setSrvLocalizadorServiceEndpointAddress(srvLocalizadorServiceEndPointAddress);				
	    	es.pode.localizador.negocio.servicios.SrvLocalizadorService port = srvLocalizadorService.getSrvLocalizadorService();	    
	        return port;
	    }

	
	/**
	 * Gets the reference to the dozer bean mapper used in the application (singleton).
	 * @return MapperIF
	 */
    public final net.sf.dozer.util.mapping.MapperIF getBeanMapper()
    {
		        return es.pode.ServiceLocator.instance().getBeanMapper();
    }
}