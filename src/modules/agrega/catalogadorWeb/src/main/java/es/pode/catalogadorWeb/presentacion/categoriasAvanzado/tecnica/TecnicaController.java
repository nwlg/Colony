// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica;

/**
 * 
 */
public abstract class TecnicaController implements java.io.Serializable
{
    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.CargarDatosTecnicaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarDatosTecnica(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.CargarDatosTecnicaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirFormatoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void anadirFormato(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirFormatoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarFormatoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void eliminarFormato(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarFormatoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirLocalizacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void anadirLocalizacion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirLocalizacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarLocalizacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void eliminarLocalizacion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarLocalizacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirRequerimientoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void anadirRequerimiento(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirRequerimientoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarRequerimientoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void eliminarRequerimiento(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarRequerimientoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirAgregadorForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void anadirAgregador(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirAgregadorForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarAgregadorForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void eliminarAgregador(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarAgregadorForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirInstalacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void anadirInstalacion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirInstalacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarInstalacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void eliminarInstalacion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarInstalacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirMasRequerimientosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void anadirMasRequerimientos(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirMasRequerimientosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarMasRequerimientosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void eliminarMasRequerimientos(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarMasRequerimientosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirDescDuracionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void anadirDescDuracion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AnadirDescDuracionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarDescDuracionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void eliminarDescDuracion(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EliminarDescDuracionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AccionSubmitForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String accionSubmit(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.AccionSubmitForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EsValidaTecnicaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return boolean
     */
    public abstract boolean esValidaTecnica(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.EsValidaTecnicaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.GuardarTecnicaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void guardarTecnica(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.GuardarTecnicaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.CancelarForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cancelar(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.CancelarForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.CargarTechnicalValidarForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarTechnicalValidar(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.CargarTechnicalValidarForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.ResetForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void reset(org.apache.struts.action.ActionMapping mapping, es.pode.catalogadorWeb.presentacion.categoriasAvanzado.tecnica.ResetForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

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
	        java.io.InputStream srvVocabulariosControladosServiceInputStream=TecnicaController.class.getClassLoader().getResourceAsStream(srvVocabulariosControladosServiceFile);
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
	        java.io.InputStream srvCatalogacionAvanzadaServiceInputStream=TecnicaController.class.getClassLoader().getResourceAsStream(srvCatalogacionAvanzadaServiceFile);
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