// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * <p>
 * Clase que se encarga de mostrar los datos de detalle de un
 * elemento buscado.
 * </p>
 */
public abstract class DetallarController implements java.io.Serializable
{
    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.BuscarDetalleODEForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void buscarDetalleODE(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.BuscarDetalleODEForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.DeterminaAtrasForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String determinaAtras(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.DeterminaAtrasForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.SeleccionaCSSecuenciaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void seleccionaCSSecuencia(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.SeleccionaCSSecuenciaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.DeterminaLogadoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String determinaLogado(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.DeterminaLogadoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.AgregarOdesForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void agregarOdes(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.AgregarOdesForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.AgregarODEFederadoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void agregarODEFederado(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.AgregarODEFederadoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.AnalizaEntradaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String analizaEntrada(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.AnalizaEntradaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.AnalizaAgregacionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String analizaAgregacion(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.AnalizaAgregacionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.CargarMetadatosCatalogadorForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void cargarMetadatosCatalogador(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.CargarMetadatosCatalogadorForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.GestionarBotoneraForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void gestionarBotonera(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.GestionarBotoneraForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.GestionarPosicionamientoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void gestionarPosicionamiento(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.GestionarPosicionamientoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.AnalizaPosicionamientoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String analizaPosicionamiento(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.AnalizaPosicionamientoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.GestionarBusquedaForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void gestionarBusqueda(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.GestionarBusquedaForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.AnalizaFlujoPosicionamientoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String analizaFlujoPosicionamiento(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.AnalizaFlujoPosicionamientoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.PrepararQueEsEstoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void prepararQueEsEsto(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.PrepararQueEsEstoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.ValorarODEForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void valorarODE(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.ValorarODEForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.buscador.presentacion.basico.detallar.TipoVisualizadorForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String tipoVisualizador(org.apache.struts.action.ActionMapping mapping, es.pode.buscador.presentacion.basico.detallar.TipoVisualizadorForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

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
	     * Returns a reference to the srvBuscadorService imported service.
         * @return es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.indexador.negocio.servicios.busqueda.SrvBuscadorService getSrvBuscadorService()
	        throws java.lang.Exception
	    {
            String srvBuscadorServiceFile="importedServices.properties";	    
	        java.io.InputStream srvBuscadorServiceInputStream=DetallarController.class.getClassLoader().getResourceAsStream(srvBuscadorServiceFile);
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
	     * Returns a reference to the srvVocabulariosControladosService imported service.
         * @return es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.fuentestaxonomicas.negocio.servicio.SrvVocabulariosControladosService getSrvVocabulariosControladosService()
	        throws java.lang.Exception
	    {
            String srvVocabulariosControladosServiceFile="importedServices.properties";	    
	        java.io.InputStream srvVocabulariosControladosServiceInputStream=DetallarController.class.getClassLoader().getResourceAsStream(srvVocabulariosControladosServiceFile);
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
	     * Returns a reference to the srvBuscarService imported service.
         * @return es.pode.buscar.negocio.buscar.servicios.SrvBuscarService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.buscar.negocio.buscar.servicios.SrvBuscarService getSrvBuscarService()
	        throws java.lang.Exception
	    {
            String srvBuscarServiceFile="importedServices.properties";	    
	        java.io.InputStream srvBuscarServiceInputStream=DetallarController.class.getClassLoader().getResourceAsStream(srvBuscarServiceFile);
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
	     * Returns a reference to the srvFachadaAgregarService imported service.
         * @return es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService getSrvFachadaAgregarService()
	        throws java.lang.Exception
	    {
            String srvFachadaAgregarServiceFile="importedServices.properties";	    
	        java.io.InputStream srvFachadaAgregarServiceInputStream=DetallarController.class.getClassLoader().getResourceAsStream(srvFachadaAgregarServiceFile);
	        java.util.Properties srvFachadaAgregarServiceProperties = new java.util.Properties();
	        srvFachadaAgregarServiceProperties.load(srvFachadaAgregarServiceInputStream);
	        String srvFachadaAgregarServiceEndPointAddress="";
	        srvFachadaAgregarServiceEndPointAddress=(String) srvFachadaAgregarServiceProperties.get("srvFachadaAgregarServicePort");
            System.out.println("srvFachadaAgregarServiceEndPointAddress del fichero --> " + srvFachadaAgregarServiceEndPointAddress);
  			es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarServiceService srvFachadaAgregarService = new es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvFachadaAgregarServiceEndPointAddress.length()>0) 
				((es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarServiceServiceLocator)srvFachadaAgregarService).setSrvFachadaAgregarServiceEndpointAddress(srvFachadaAgregarServiceEndPointAddress);				
	    	es.pode.empaquetador.negocio.servicio.SrvFachadaAgregarService port = srvFachadaAgregarService.getSrvFachadaAgregarService();	    
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
	        java.io.InputStream srvNodoServiceInputStream=DetallarController.class.getClassLoader().getResourceAsStream(srvNodoServiceFile);
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
	     * Returns a reference to the srvTaxonomiaService imported service.
         * @return es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.fuentestaxonomicas.negocio.servicio.SrvTaxonomiaService getSrvTaxonomiaService()
	        throws java.lang.Exception
	    {
            String srvTaxonomiaServiceFile="importedServices.properties";	    
	        java.io.InputStream srvTaxonomiaServiceInputStream=DetallarController.class.getClassLoader().getResourceAsStream(srvTaxonomiaServiceFile);
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
	     * Returns a reference to the srvValoracionService imported service.
         * @return es.pode.valoracion.negocio.servicios.SrvValoracionService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.valoracion.negocio.servicios.SrvValoracionService getSrvValoracionService()
	        throws java.lang.Exception
	    {
            String srvValoracionServiceFile="importedServices.properties";	    
	        java.io.InputStream srvValoracionServiceInputStream=DetallarController.class.getClassLoader().getResourceAsStream(srvValoracionServiceFile);
	        java.util.Properties srvValoracionServiceProperties = new java.util.Properties();
	        srvValoracionServiceProperties.load(srvValoracionServiceInputStream);
	        String srvValoracionServiceEndPointAddress="";
	        srvValoracionServiceEndPointAddress=(String) srvValoracionServiceProperties.get("srvValoracionServicePort");
            System.out.println("srvValoracionServiceEndPointAddress del fichero --> " + srvValoracionServiceEndPointAddress);
  			es.pode.valoracion.negocio.servicios.SrvValoracionServiceService srvValoracionService = new es.pode.valoracion.negocio.servicios.SrvValoracionServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvValoracionServiceEndPointAddress.length()>0) 
				((es.pode.valoracion.negocio.servicios.SrvValoracionServiceServiceLocator)srvValoracionService).setSrvValoracionServiceEndpointAddress(srvValoracionServiceEndPointAddress);				
	    	es.pode.valoracion.negocio.servicios.SrvValoracionService port = srvValoracionService.getSrvValoracionService();	    
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
	        java.io.InputStream srvEntregarServiceInputStream=DetallarController.class.getClassLoader().getResourceAsStream(srvEntregarServiceFile);
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
	     * Returns a reference to the srvAuditoriaServicio imported service.
         * @return es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio getSrvAuditoriaServicio()
	        throws java.lang.Exception
	    {
            String srvAuditoriaServicioFile="importedServices.properties";	    
	        java.io.InputStream srvAuditoriaServicioInputStream=DetallarController.class.getClassLoader().getResourceAsStream(srvAuditoriaServicioFile);
	        java.util.Properties srvAuditoriaServicioProperties = new java.util.Properties();
	        srvAuditoriaServicioProperties.load(srvAuditoriaServicioInputStream);
	        String srvAuditoriaServicioEndPointAddress="";
	        srvAuditoriaServicioEndPointAddress=(String) srvAuditoriaServicioProperties.get("srvAuditoriaServicioPort");
            System.out.println("srvAuditoriaServicioEndPointAddress del fichero --> " + srvAuditoriaServicioEndPointAddress);
  			es.pode.auditoria.negocio.servicios.SrvAuditoriaServicioService srvAuditoriaServicio = new es.pode.auditoria.negocio.servicios.SrvAuditoriaServicioServiceLocator();                                                                                                                                                                                                                                                    
            if (srvAuditoriaServicioEndPointAddress.length()>0) 
				((es.pode.auditoria.negocio.servicios.SrvAuditoriaServicioServiceLocator)srvAuditoriaServicio).setSrvAuditoriaServicioEndpointAddress(srvAuditoriaServicioEndPointAddress);				
	    	es.pode.auditoria.negocio.servicios.SrvAuditoriaServicio port = srvAuditoriaServicio.getSrvAuditoriaServicio();	    
	        return port;
	    }

	

			    /**
	     * Returns a reference to the srvTaggingServer imported service.
         * @return es.pode.tagging.negocio.servicios.SrvTaggingServer  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.tagging.negocio.servicios.SrvTaggingServer getSrvTaggingServer()
	        throws java.lang.Exception
	    {
            String srvTaggingServerFile="importedServices.properties";	    
	        java.io.InputStream srvTaggingServerInputStream=DetallarController.class.getClassLoader().getResourceAsStream(srvTaggingServerFile);
	        java.util.Properties srvTaggingServerProperties = new java.util.Properties();
	        srvTaggingServerProperties.load(srvTaggingServerInputStream);
	        String srvTaggingServerEndPointAddress="";
	        srvTaggingServerEndPointAddress=(String) srvTaggingServerProperties.get("srvTaggingServerPort");
            System.out.println("srvTaggingServerEndPointAddress del fichero --> " + srvTaggingServerEndPointAddress);
  			es.pode.tagging.negocio.servicios.SrvTaggingServerService srvTaggingServer = new es.pode.tagging.negocio.servicios.SrvTaggingServerServiceLocator();                                                                                                                                                                                                                                                    
            if (srvTaggingServerEndPointAddress.length()>0) 
				((es.pode.tagging.negocio.servicios.SrvTaggingServerServiceLocator)srvTaggingServer).setSrvTaggingServerEndpointAddress(srvTaggingServerEndPointAddress);				
	    	es.pode.tagging.negocio.servicios.SrvTaggingServer port = srvTaggingServer.getSrvTaggingServer();	    
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