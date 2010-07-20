// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.verMetadatos;

/**
 * 
 */
public abstract class VerMetadatosController implements java.io.Serializable
{
    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosAvForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDatosAv(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosAvForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.verMetadatos.VolverAForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void volverA(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.verMetadatos.VolverAForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosGeneralForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDatosGeneral(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosGeneralForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosCicloDeVidaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDatosCicloDeVida(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosCicloDeVidaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosMetaMetadatosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDatosMetaMetadatos(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosMetaMetadatosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosTecnicaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDatosTecnica(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosTecnicaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.verMetadatos.CargarUsosEducativosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarUsosEducativos(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.verMetadatos.CargarUsosEducativosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDetalleUsoEduForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDetalleUsoEdu(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDetalleUsoEduForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosDerechosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDatosDerechos(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDatosDerechosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.verMetadatos.CargarRelacionesForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarRelaciones(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.verMetadatos.CargarRelacionesForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDetalleRelacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDetalleRelacion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDetalleRelacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.verMetadatos.CargarAnotacionesForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarAnotaciones(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.verMetadatos.CargarAnotacionesForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDetalleAnotacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDetalleAnotacion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDetalleAnotacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.verMetadatos.CargarClasificacionesForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarClasificaciones(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.verMetadatos.CargarClasificacionesForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDetalleClasificacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDetalleClasificacion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.verMetadatos.CargarDetalleClasificacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

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
	     * Returns a reference to the srvVocabulariosControladosService imported service.
         * @return es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService getSrvVocabulariosControladosService()
	        throws java.lang.Exception
	    {
            String srvVocabulariosControladosServiceFile="importedServices.properties";	    
	        java.io.InputStream srvVocabulariosControladosServiceInputStream=VerMetadatosController.class.getClassLoader().getResourceAsStream(srvVocabulariosControladosServiceFile);
	        java.util.Properties srvVocabulariosControladosServiceProperties = new java.util.Properties();
	        srvVocabulariosControladosServiceProperties.load(srvVocabulariosControladosServiceInputStream);
	        String srvVocabulariosControladosServiceEndPointAddress="";
	        srvVocabulariosControladosServiceEndPointAddress=(String) srvVocabulariosControladosServiceProperties.get("srvVocabulariosControladosServicePort");
            System.out.println("srvVocabulariosControladosServiceEndPointAddress del fichero --> " + srvVocabulariosControladosServiceEndPointAddress);
  			es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosServiceService srvVocabulariosControladosService = new es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvVocabulariosControladosServiceEndPointAddress.length()>0) 
				((es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosServiceServiceLocator)srvVocabulariosControladosService).setSrvVocabulariosControladosServiceEndpointAddress(srvVocabulariosControladosServiceEndPointAddress);				
	    	es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService port = srvVocabulariosControladosService.getSrvVocabulariosControladosService();	    
	        return port;
	    }

	

			    /**
	     * Returns a reference to the srvTesaurosServices imported service.
         * @return es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices getSrvTesaurosServices()
	        throws java.lang.Exception
	    {
            String srvTesaurosServicesFile="importedServices.properties";	    
	        java.io.InputStream srvTesaurosServicesInputStream=VerMetadatosController.class.getClassLoader().getResourceAsStream(srvTesaurosServicesFile);
	        java.util.Properties srvTesaurosServicesProperties = new java.util.Properties();
	        srvTesaurosServicesProperties.load(srvTesaurosServicesInputStream);
	        String srvTesaurosServicesEndPointAddress="";
	        srvTesaurosServicesEndPointAddress=(String) srvTesaurosServicesProperties.get("srvTesaurosServicesPort");
            System.out.println("srvTesaurosServicesEndPointAddress del fichero --> " + srvTesaurosServicesEndPointAddress);
  			es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServicesService srvTesaurosServices = new es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServicesServiceLocator();                                                                                                                                                                                                                                                    
            if (srvTesaurosServicesEndPointAddress.length()>0) 
				((es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServicesServiceLocator)srvTesaurosServices).setSrvTesaurosServicesEndpointAddress(srvTesaurosServicesEndPointAddress);				
	    	es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices port = srvTesaurosServices.getSrvTesaurosServices();	    
	        return port;
	    }

	

			    /**
	     * Returns a reference to the srvTaxonomiaService imported service.
         * @return es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService getSrvTaxonomiaService()
	        throws java.lang.Exception
	    {
            String srvTaxonomiaServiceFile="importedServices.properties";	    
	        java.io.InputStream srvTaxonomiaServiceInputStream=VerMetadatosController.class.getClassLoader().getResourceAsStream(srvTaxonomiaServiceFile);
	        java.util.Properties srvTaxonomiaServiceProperties = new java.util.Properties();
	        srvTaxonomiaServiceProperties.load(srvTaxonomiaServiceInputStream);
	        String srvTaxonomiaServiceEndPointAddress="";
	        srvTaxonomiaServiceEndPointAddress=(String) srvTaxonomiaServiceProperties.get("srvTaxonomiaServicePort");
            System.out.println("srvTaxonomiaServiceEndPointAddress del fichero --> " + srvTaxonomiaServiceEndPointAddress);
  			es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaServiceService srvTaxonomiaService = new es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvTaxonomiaServiceEndPointAddress.length()>0) 
				((es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaServiceServiceLocator)srvTaxonomiaService).setSrvTaxonomiaServiceEndpointAddress(srvTaxonomiaServiceEndPointAddress);				
	    	es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService port = srvTaxonomiaService.getSrvTaxonomiaService();	    
	        return port;
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
	        java.io.InputStream srvCatalogacionAvanzadaServiceInputStream=VerMetadatosController.class.getClassLoader().getResourceAsStream(srvCatalogacionAvanzadaServiceFile);
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
	     * Returns a reference to the srvNodoService imported service.
         * @return es.pode.buscar.negocio.administrar.servicio.SrvNodoService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.buscar.negocio.administrar.servicio.SrvNodoService getSrvNodoService()
	        throws java.lang.Exception
	    {
            String srvNodoServiceFile="importedServices.properties";	    
	        java.io.InputStream srvNodoServiceInputStream=VerMetadatosController.class.getClassLoader().getResourceAsStream(srvNodoServiceFile);
	        java.util.Properties srvNodoServiceProperties = new java.util.Properties();
	        srvNodoServiceProperties.load(srvNodoServiceInputStream);
	        String srvNodoServiceEndPointAddress="";
	        srvNodoServiceEndPointAddress=(String) srvNodoServiceProperties.get("srvNodoServicePort");
            System.out.println("srvNodoServiceEndPointAddress del fichero --> " + srvNodoServiceEndPointAddress);
  			es.pode.buscar.negocio.administrar.servicio.SrvNodoServiceService srvNodoService = new es.pode.buscar.negocio.administrar.servicio.SrvNodoServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvNodoServiceEndPointAddress.length()>0) 
				((es.pode.buscar.negocio.administrar.servicio.SrvNodoServiceServiceLocator)srvNodoService).setSrvNodoServiceEndpointAddress(srvNodoServiceEndPointAddress);				
	    	es.pode.buscar.negocio.administrar.servicio.SrvNodoService port = srvNodoService.getSrvNodoService();	    
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