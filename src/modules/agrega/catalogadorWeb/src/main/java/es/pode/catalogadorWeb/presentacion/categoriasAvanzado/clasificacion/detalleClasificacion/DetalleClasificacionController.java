// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion;

/**
 * 
 */
public abstract class DetalleClasificacionController implements java.io.Serializable
{
    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.CargarDetalleClasificacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDetalleClasificacion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.CargarDetalleClasificacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AnadirRutaTaxonomicaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void anadirRutaTaxonomica(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AnadirRutaTaxonomicaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EliminarRutaTaxonomicaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void eliminarRutaTaxonomica(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EliminarRutaTaxonomicaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.CargarTaxonesForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarTaxones(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.CargarTaxonesForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AnadirDescripcionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void anadirDescripcion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AnadirDescripcionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EliminarDescripcionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void eliminarDescripcion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EliminarDescripcionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AnadirPalabraClaveForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void anadirPalabraClave(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AnadirPalabraClaveForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EliminarPalabraClaveForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void eliminarPalabraClave(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EliminarPalabraClaveForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AccionSubmitForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String accionSubmit(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AccionSubmitForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EsValidoClasificacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return boolean
     */
    public abstract boolean esValidoClasificacion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EsValidoClasificacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.GuardarClasificacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void guardarClasificacion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.GuardarClasificacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.CancelarForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cancelar(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.CancelarForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.CargarClassificationValidarForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarClassificationValidar(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.CargarClassificationValidarForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AnadirContenidoPalabraClaveForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void anadirContenidoPalabraClave(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.AnadirContenidoPalabraClaveForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EliminarContenidoPalabraClaveForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void eliminarContenidoPalabraClave(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.EliminarContenidoPalabraClaveForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.ResetForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void reset(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.ResetForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.HayClasificacionesForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return boolean
     */
    public abstract boolean hayClasificaciones(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.HayClasificacionesForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.HayClasificacionesGuardarForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return boolean
     */
    public abstract boolean hayClasificacionesGuardar(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.clasificacion.detalleClasificacion.HayClasificacionesGuardarForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

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
	     * Returns a reference to the srvTesaurosServices imported service.
         * @return es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.fuentestaxonomicas.negocio.servicio.SrvTesaurosServices getSrvTesaurosServices()
	        throws java.lang.Exception
	    {
            String srvTesaurosServicesFile="importedServices.properties";	    
	        java.io.InputStream srvTesaurosServicesInputStream=DetalleClasificacionController.class.getClassLoader().getResourceAsStream(srvTesaurosServicesFile);
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
	     * Returns a reference to the srvVocabulariosControladosService imported service.
         * @return es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService getSrvVocabulariosControladosService()
	        throws java.lang.Exception
	    {
            String srvVocabulariosControladosServiceFile="importedServices.properties";	    
	        java.io.InputStream srvVocabulariosControladosServiceInputStream=DetalleClasificacionController.class.getClassLoader().getResourceAsStream(srvVocabulariosControladosServiceFile);
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
	     * Returns a reference to the srvCatalogacionAvanzadaService imported service.
         * @return es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService getSrvCatalogacionAvanzadaService()
	        throws java.lang.Exception
	    {
            String srvCatalogacionAvanzadaServiceFile="importedServices.properties";	    
	        java.io.InputStream srvCatalogacionAvanzadaServiceInputStream=DetalleClasificacionController.class.getClassLoader().getResourceAsStream(srvCatalogacionAvanzadaServiceFile);
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
	     * Returns a reference to the srvTaxonomiaService imported service.
         * @return es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService getSrvTaxonomiaService()
	        throws java.lang.Exception
	    {
            String srvTaxonomiaServiceFile="importedServices.properties";	    
	        java.io.InputStream srvTaxonomiaServiceInputStream=DetalleClasificacionController.class.getClassLoader().getResourceAsStream(srvTaxonomiaServiceFile);
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
	 * Gets the reference to the dozer bean mapper used in the application (singleton).
	 * @return MapperIF
	 */
    public final net.sf.dozer.util.mapping.MapperIF getBeanMapper()
    {
		        return es.pode.catalogadorWeb.presentacion.ServiceLocator.instance().getBeanMapper();
    }
}