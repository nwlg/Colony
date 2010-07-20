// license-header java merge-point
package es.pode.gestorFlujo.presentacion.objetosCompartidos;

/**
 * 
 */
public abstract class ObjetosCompartidosController implements java.io.Serializable
{
    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.gestorFlujo.presentacion.objetosCompartidos.CargarODESCompartidosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarODESCompartidos(org.apache.struts.action.ActionMapping mapping, es.pode.gestorFlujo.presentacion.objetosCompartidos.CargarODESCompartidosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

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
	        java.io.InputStream srvPublicacionServiceInputStream=ObjetosCompartidosController.class.getClassLoader().getResourceAsStream(srvPublicacionServiceFile);
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
	        java.io.InputStream srvLocalizadorServiceInputStream=ObjetosCompartidosController.class.getClassLoader().getResourceAsStream(srvLocalizadorServiceFile);
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
	     * Returns a reference to the srvEntregarService imported service.
         * @return es.pode.entregar.negocio.servicios.SrvEntregarService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.entregar.negocio.servicios.SrvEntregarService getSrvEntregarService()
	        throws java.lang.Exception
	    {
            String srvEntregarServiceFile="importedServices.properties";	    
	        java.io.InputStream srvEntregarServiceInputStream=ObjetosCompartidosController.class.getClassLoader().getResourceAsStream(srvEntregarServiceFile);
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
	     * Returns a reference to the srvAdminUsuariosService imported service.
         * @return es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.adminusuarios.negocio.servicios.SrvAdminUsuariosService getSrvAdminUsuariosService()
	        throws java.lang.Exception
	    {
            String srvAdminUsuariosServiceFile="importedServices.properties";	    
	        java.io.InputStream srvAdminUsuariosServiceInputStream=ObjetosCompartidosController.class.getClassLoader().getResourceAsStream(srvAdminUsuariosServiceFile);
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
	 * Gets the reference to the dozer bean mapper used in the application (singleton).
	 * @return MapperIF
	 */
    public final net.sf.dozer.util.mapping.MapperIF getBeanMapper()
    {
		        return es.pode.ServiceLocator.instance().getBeanMapper();
    }
}