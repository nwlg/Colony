// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus;

/**
 * <p>
 * Controller que contiene los metodos que gestionan el
 * funcionamiento del catalogador basico.
 * </p>
 */
public abstract class CatBasicPlusController implements java.io.Serializable
{
    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CargarDatosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDatos(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CargarDatosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.GuardarMetadatosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void guardarMetadatos(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.GuardarMetadatosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CargarDatosSesionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDatosSesion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CargarDatosSesionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ValidarMetadatosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void validarMetadatos(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ValidarMetadatosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.SonValidosMDBOForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return boolean
     */
    public abstract boolean sonValidosMDBO(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.SonValidosMDBOForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CargarDatosGuardarForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDatosGuardar(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.CargarDatosGuardarForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.EliminarArbolForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void eliminarArbol(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.EliminarArbolForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.VolverAEmpaquetadorForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void volverAEmpaquetador(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.VolverAEmpaquetadorForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.RealizarSubmitForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void realizarSubmit(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.RealizarSubmitForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.RecogeAccionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String recogeAccion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.RecogeAccionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ValidarExportarForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void validarExportar(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ValidarExportarForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.SonValidosExportarForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return boolean
     */
    public abstract boolean sonValidosExportar(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.SonValidosExportarForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ExportarLomesForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void exportarLomes(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ExportarLomesForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.SubmitAdvertenciaExportarForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String submitAdvertenciaExportar(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.SubmitAdvertenciaExportarForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ActualizadosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return boolean
     */
    public abstract boolean actualizados(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ActualizadosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ChequearDatosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void chequearDatos(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ChequearDatosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.SubmitImportarForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String submitImportar(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.SubmitImportarForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ComprobarLomesVacioForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String comprobarLomesVacio(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.ComprobarLomesVacioForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.SubmitAdvertenciaImportarForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String submitAdvertenciaImportar(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.SubmitAdvertenciaImportarForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.SubirFicheroForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void subirFichero(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.SubirFicheroForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.GuardarDatosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String guardarDatos(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.catalogadorBasicPlus.GuardarDatosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

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
            Object attribute = session.getAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorBSession.SESSION_KEY);
            if (attribute instanceof es.pode.catalogadorWeb.presentacion.CatalogadorBPSession)
            {
                session.removeAttribute(es.pode.catalogadorWeb.presentacion.CatalogadorBPSession.SESSION_KEY);
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
	     * Returns a reference to the srvTaxonomiaService imported service.
         * @return es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService getSrvTaxonomiaService()
	        throws java.lang.Exception
	    {
            String srvTaxonomiaServiceFile="importedServices.properties";	    
	        java.io.InputStream srvTaxonomiaServiceInputStream=CatBasicPlusController.class.getClassLoader().getResourceAsStream(srvTaxonomiaServiceFile);
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
         * @return es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadoService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.catalogacion.negocio.servicios.SrvCatalogacionAvanzadaService getSrvCatalogacionAvanzadaService()
	        throws java.lang.Exception
	    {
            String srvCatalogacionAvanzadaServiceFile="importedServices.properties";	    
	        java.io.InputStream srvCatalogacionAvanzadaServiceInputStream=CatBasicPlusController.class.getClassLoader().getResourceAsStream(srvCatalogacionAvanzadaServiceFile);
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
	     * Returns a reference to the srvValidadorService imported service.
         * @return es.pode.validador.negocio.servicio.SrvValidadorService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.validador.negocio.servicio.SrvValidadorService getSrvValidadorService()
	        throws java.lang.Exception
	    {
            String srvValidadorServiceFile="importedServices.properties";	    
	        java.io.InputStream srvValidadorServiceInputStream=CatBasicPlusController.class.getClassLoader().getResourceAsStream(srvValidadorServiceFile);
	        java.util.Properties srvValidadorServiceProperties = new java.util.Properties();
	        srvValidadorServiceProperties.load(srvValidadorServiceInputStream);
	        String srvValidadorServiceEndPointAddress="";
	        srvValidadorServiceEndPointAddress=(String) srvValidadorServiceProperties.get("srvValidadorServicePort");
            System.out.println("srvValidadorServiceEndPointAddress del fichero --> " + srvValidadorServiceEndPointAddress);
  			es.pode.validador.negocio.servicio.SrvValidadorServiceService srvValidadorService = new es.pode.validador.negocio.servicio.SrvValidadorServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvValidadorServiceEndPointAddress.length()>0) 
				((es.pode.validador.negocio.servicio.SrvValidadorServiceServiceLocator)srvValidadorService).setSrvValidadorServiceEndpointAddress(srvValidadorServiceEndPointAddress);				
	    	es.pode.validador.negocio.servicio.SrvValidadorService port = srvValidadorService.getSrvValidadorService();	    
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
	        java.io.InputStream srvVocabulariosControladosServiceInputStream=CatBasicPlusController.class.getClassLoader().getResourceAsStream(srvVocabulariosControladosServiceFile);
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
	 * Gets the reference to the dozer bean mapper used in the application (singleton).
	 * @return MapperIF
	 */
    public final net.sf.dozer.util.mapping.MapperIF getBeanMapper()
    {
		        return es.pode.catalogadorWeb.presentacion.ServiceLocator.instance().getBeanMapper();
    }
}