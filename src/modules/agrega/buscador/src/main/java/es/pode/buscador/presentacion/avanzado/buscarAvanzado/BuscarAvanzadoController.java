// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.buscarAvanzado;

/**
 * 
 */
public abstract class BuscarAvanzadoController implements java.io.Serializable
{
    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.CargaFormularioBusquedaAvanzadaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargaFormularioBusquedaAvanzada(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.CargaFormularioBusquedaAvanzadaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.ValidarFormularioForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void validarFormulario(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.ValidarFormularioForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizaPulsacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String analizaPulsacion(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizaPulsacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.EjecutarBusquedaAvanzadaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void ejecutarBusquedaAvanzada(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.EjecutarBusquedaAvanzadaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizaResultadosForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return String
     */
    public abstract String analizaResultados(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizaResultadosForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizaValidacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String analizaValidacion(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizaValidacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.EliminarAreaCurricularForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void eliminarAreaCurricular(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.EliminarAreaCurricularForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.GuardarBusquedaEnSesionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void guardarBusquedaEnSesion(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.GuardarBusquedaEnSesionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizaEntradaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String analizaEntrada(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizaEntradaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.ListarIdsForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void listarIds(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.ListarIdsForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.CargarFormularioQuisoDecirForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarFormularioQuisoDecir(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.CargarFormularioQuisoDecirForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizarVisualizacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String analizarVisualizacion(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizarVisualizacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizaSeleccionEliminacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String analizaSeleccionEliminacion(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizaSeleccionEliminacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.EliminarTesauroForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void eliminarTesauro(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.EliminarTesauroForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.LimpiarFormularioForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void limpiarFormulario(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.LimpiarFormularioForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.GenerarRSSForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void generarRSS(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.GenerarRSSForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizaTipoBusquedaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String analizaTipoBusqueda(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.avanzado.buscarAvanzado.AnalizaTipoBusquedaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     * Returns the current BuscarSession from the session found in the argument request.
     * <p/>
     * In case an object was found in the session but it was not of the correct type, this method
     * will return <code>null</code>.
     * <p/>
     * If there is no session, it will be created; if the session would not contain a session-object
     * the object will be instantiated and subsequently stored in the session.
     *
     * @param request javax.servlet.http.HttpServletRequest          
     * @return es.pode.buscador.presentacion.BuscarSession
     */
    protected final es.pode.buscador.presentacion.BuscarSession getBuscarSession(javax.servlet.http.HttpServletRequest request)
    {
        es.pode.buscador.presentacion.BuscarSession object = null;
        javax.servlet.http.HttpSession session = request.getSession(true);

        Object attribute = session.getAttribute(es.pode.buscador.presentacion.BuscarSession.SESSION_KEY);
        if (attribute instanceof es.pode.buscador.presentacion.BuscarSession)
        {
            object = (es.pode.buscador.presentacion.BuscarSession)attribute;
        }
        else if (attribute == null)
        {
            object = new es.pode.buscador.presentacion.BuscarSession ();
            setBuscarSession(request, object);
        }

        return object;
    }

    /**
     * Set the argument BuscarSession object in the session corresponding with the argument request.
     * In case the session would not exist it will be created.
     *
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.buscador.presentacion.BuscarSession                          
     */
    protected final void setBuscarSession(javax.servlet.http.HttpServletRequest request, es.pode.buscador.presentacion.BuscarSession object)
    {
        setBuscarSession(request, object, true);
    }

    /**
     * Set the argument BuscarSession object in the session corresponding with the argument request.
     * Any existing object will be overwritten.
     *
     * @param createSession denotes whether or not the session should be created automatically in case it
     * would not yet exist
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.buscador.presentacion.BuscarSession             
     */
    protected final void setBuscarSession(javax.servlet.http.HttpServletRequest request, es.pode.buscador.presentacion.BuscarSession object, boolean createSession)
    {
        javax.servlet.http.HttpSession session = request.getSession(createSession);
        if (session != null)
        {
            session.setAttribute(es.pode.buscador.presentacion.BuscarSession.SESSION_KEY, object);
        }
    }

    /**
     * Removes the argument BuscarSession object from the session corresponding with the argument request.
     * In any of the following cases this method will do nothing:
     * <ul>
     *   <li>No session corresponds to the argument request</li>
     *   <li>No BuscarSession object could be found in the request</li>
     *   <li>The object is not of the correct type</li>
     * </ul>
     * @param request javax.servlet.http.HttpServletRequest            
     */
    protected final void removeBuscarSession(javax.servlet.http.HttpServletRequest request)
    {
        javax.servlet.http.HttpSession session = request.getSession(false);
        if (session != null)
        {
            Object attribute = session.getAttribute(es.pode.buscador.presentacion.BuscarSession.SESSION_KEY);
            if (attribute instanceof es.pode.buscador.presentacion.BuscarSession)
            {
                session.removeAttribute(es.pode.buscador.presentacion.BuscarSession.SESSION_KEY);
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
	        java.io.InputStream srvVocabulariosControladosServiceInputStream=BuscarAvanzadoController.class.getClassLoader().getResourceAsStream(srvVocabulariosControladosServiceFile);
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
	     * Returns a reference to the srvBuscadorService imported service.
         * @return es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService getSrvBuscadorService()
	        throws java.lang.Exception
	    {
            String srvBuscadorServiceFile="importedServices.properties";	    
	        java.io.InputStream srvBuscadorServiceInputStream=BuscarAvanzadoController.class.getClassLoader().getResourceAsStream(srvBuscadorServiceFile);
	        java.util.Properties srvBuscadorServiceProperties = new java.util.Properties();
	        srvBuscadorServiceProperties.load(srvBuscadorServiceInputStream);
	        String srvBuscadorServiceEndPointAddress="";
	        srvBuscadorServiceEndPointAddress=(String) srvBuscadorServiceProperties.get("srvBuscadorServicePort");
            System.out.println("srvBuscadorServiceEndPointAddress del fichero --> " + srvBuscadorServiceEndPointAddress);
  			es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorServiceService srvBuscadorService = new es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvBuscadorServiceEndPointAddress.length()>0) 
				((es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorServiceServiceLocator)srvBuscadorService).setSrvBuscadorServiceEndpointAddress(srvBuscadorServiceEndPointAddress);				
	    	es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService port = srvBuscadorService.getSrvBuscadorService();	    
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
	        java.io.InputStream srvTaxonomiaServiceInputStream=BuscarAvanzadoController.class.getClassLoader().getResourceAsStream(srvTaxonomiaServiceFile);
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
	     * Returns a reference to the srvNodoService imported service.
         * @return es.pode.buscar.negocio.administrar.servicio.SrvNodoService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.buscar.negocio.administrar.servicio.SrvNodoService getSrvNodoService()
	        throws java.lang.Exception
	    {
            String srvNodoServiceFile="importedServices.properties";	    
	        java.io.InputStream srvNodoServiceInputStream=BuscarAvanzadoController.class.getClassLoader().getResourceAsStream(srvNodoServiceFile);
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
	     * Returns a reference to the srvBuscarService imported service.
         * @return es.pode.buscar.negocio.buscar.servicios.SrvBuscarService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.buscar.negocio.buscar.servicios.SrvBuscarService getSrvBuscarService()
	        throws java.lang.Exception
	    {
            String srvBuscarServiceFile="importedServices.properties";	    
	        java.io.InputStream srvBuscarServiceInputStream=BuscarAvanzadoController.class.getClassLoader().getResourceAsStream(srvBuscarServiceFile);
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
	     * Returns a reference to the srvAgregadorRssService imported service.
         * @return es.pode.agregador.negocio.agregador.servicio.SrvAgregadorRssService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.agregador.negocio.agregador.servicio.SrvAgregadorRssService getSrvAgregadorRssService()
	        throws java.lang.Exception
	    {
            String srvAgregadorRssServiceFile="importedServices.properties";	    
	        java.io.InputStream srvAgregadorRssServiceInputStream=BuscarAvanzadoController.class.getClassLoader().getResourceAsStream(srvAgregadorRssServiceFile);
	        java.util.Properties srvAgregadorRssServiceProperties = new java.util.Properties();
	        srvAgregadorRssServiceProperties.load(srvAgregadorRssServiceInputStream);
	        String srvAgregadorRssServiceEndPointAddress="";
	        srvAgregadorRssServiceEndPointAddress=(String) srvAgregadorRssServiceProperties.get("srvAgregadorRssServicePort");
            System.out.println("srvAgregadorRssServiceEndPointAddress del fichero --> " + srvAgregadorRssServiceEndPointAddress);
  			es.pode.agregador.negocio.agregador.servicio.SrvAgregadorRssServiceService srvAgregadorRssService = new es.pode.agregador.negocio.agregador.servicio.SrvAgregadorRssServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvAgregadorRssServiceEndPointAddress.length()>0) 
				((es.pode.agregador.negocio.agregador.servicio.SrvAgregadorRssServiceServiceLocator)srvAgregadorRssService).setSrvAgregadorRssServiceEndpointAddress(srvAgregadorRssServiceEndPointAddress);				
	    	es.pode.agregador.negocio.agregador.servicio.SrvAgregadorRssService port = srvAgregadorRssService.getSrvAgregadorRssService();	    
	        return port;
	    }

	

			    /**
	     * Returns a reference to the srvGestionSqiService imported service.
         * @return es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiService getSrvGestionSqiService()
	        throws java.lang.Exception
	    {
            String srvGestionSqiServiceFile="importedServices.properties";	    
	        java.io.InputStream srvGestionSqiServiceInputStream=BuscarAvanzadoController.class.getClassLoader().getResourceAsStream(srvGestionSqiServiceFile);
	        java.util.Properties srvGestionSqiServiceProperties = new java.util.Properties();
	        srvGestionSqiServiceProperties.load(srvGestionSqiServiceInputStream);
	        String srvGestionSqiServiceEndPointAddress="";
	        srvGestionSqiServiceEndPointAddress=(String) srvGestionSqiServiceProperties.get("srvGestionSqiServicePort");
            System.out.println("srvGestionSqiServiceEndPointAddress del fichero --> " + srvGestionSqiServiceEndPointAddress);
  			es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiServiceService srvGestionSqiService = new es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvGestionSqiServiceEndPointAddress.length()>0) 
				((es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiServiceServiceLocator)srvGestionSqiService).setSrvGestionSqiServiceEndpointAddress(srvGestionSqiServiceEndPointAddress);				
	    	es.pode.buscar.negocio.nodosSQI.servicio.SrvGestionSqiService port = srvGestionSqiService.getSrvGestionSqiService();	    
	        return port;
	    }

	
	/**
	 * Gets the reference to the dozer bean mapper used in the application (singleton).
	 * @return MapperIF
	 */
    public final net.sf.dozer.util.mapping.MapperIF getBeanMapper()
    {
		        return es.pode.buscador.presentacion.ServiceLocator.instance().getBeanMapper();
    }
}