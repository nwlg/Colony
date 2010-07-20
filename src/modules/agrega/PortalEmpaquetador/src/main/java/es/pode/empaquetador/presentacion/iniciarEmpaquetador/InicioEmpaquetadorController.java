// license-header java merge-point
package es.pode.empaquetador.presentacion.iniciarEmpaquetador;

/**
 * 
 */
public abstract class InicioEmpaquetadorController implements java.io.Serializable
{
    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.empaquetador.presentacion.iniciarEmpaquetador.EsEdicionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String esEdicion(org.apache.struts.action.ActionMapping mapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.EsEdicionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.empaquetador.presentacion.iniciarEmpaquetador.CrearOdeForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void crearOde(org.apache.struts.action.ActionMapping mapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.CrearOdeForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.empaquetador.presentacion.iniciarEmpaquetador.EditarOdeForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void editarOde(org.apache.struts.action.ActionMapping mapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.EditarOdeForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.empaquetador.presentacion.iniciarEmpaquetador.CrearSesionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void crearSesion(org.apache.struts.action.ActionMapping mapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.CrearSesionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.empaquetador.presentacion.iniciarEmpaquetador.EsAvanzadoForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String esAvanzado(org.apache.struts.action.ActionMapping mapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.EsAvanzadoForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.empaquetador.presentacion.iniciarEmpaquetador.CompruebaSesionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void compruebaSesion(org.apache.struts.action.ActionMapping mapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.CompruebaSesionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.empaquetador.presentacion.iniciarEmpaquetador.SelectActionForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String selectAction(org.apache.struts.action.ActionMapping mapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.SelectActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.empaquetador.presentacion.iniciarEmpaquetador.RedirectForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void redirect(org.apache.struts.action.ActionMapping mapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.RedirectForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.empaquetador.presentacion.iniciarEmpaquetador.TieneLomesForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return boolean
     */
    public abstract boolean tieneLomes(org.apache.struts.action.ActionMapping mapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.TieneLomesForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.empaquetador.presentacion.iniciarEmpaquetador.CrearLomesInicialForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     */
    public abstract void crearLomesInicial(org.apache.struts.action.ActionMapping mapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.CrearLomesInicialForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     *
     * This operation delegates to
     * <code>${operation.backEndServiceOperation.owner.fullyQualifiedName}.${operation.backEndServiceOperation.name}</code>
     *
     * @param mapping org.apache.struts.action.ActionMapping          
     * @param form es.pode.empaquetador.presentacion.iniciarEmpaquetador.SelectActionEditarForm
     * @param request javax.servlet.http.HttpServletRequest
     * @param response javax.servlet.http.HttpServletResponse
     * @throws java.lang.Exception Exception
     * @return java.lang.String
     */
    public abstract java.lang.String selectActionEditar(org.apache.struts.action.ActionMapping mapping, es.pode.empaquetador.presentacion.iniciarEmpaquetador.SelectActionEditarForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception;

    /**
     * Returns the current CrearElementoSession from the session found in the argument request.
     * <p/>
     * In case an object was found in the session but it was not of the correct type, this method
     * will return <code>null</code>.
     * <p/>
     * If there is no session, it will be created; if the session would not contain a session-object
     * the object will be instantiated and subsequently stored in the session.
     *
     * @param request javax.servlet.http.HttpServletRequest          
     * @return es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession
     */
    protected final es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession getCrearElementoSession(javax.servlet.http.HttpServletRequest request)
    {
        es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession object = null;
        javax.servlet.http.HttpSession session = request.getSession(true);

        Object attribute = session.getAttribute(es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession.SESSION_KEY);
        if (attribute instanceof es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession)
        {
            object = (es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession)attribute;
        }
        else if (attribute == null)
        {
            object = new es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession ();
            setCrearElementoSession(request, object);
        }

        return object;
    }

    /**
     * Set the argument CrearElementoSession object in the session corresponding with the argument request.
     * In case the session would not exist it will be created.
     *
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession                          
     */
    protected final void setCrearElementoSession(javax.servlet.http.HttpServletRequest request, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession object)
    {
        setCrearElementoSession(request, object, true);
    }

    /**
     * Set the argument CrearElementoSession object in the session corresponding with the argument request.
     * Any existing object will be overwritten.
     *
     * @param createSession denotes whether or not the session should be created automatically in case it
     * would not yet exist
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession             
     */
    protected final void setCrearElementoSession(javax.servlet.http.HttpServletRequest request, es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession object, boolean createSession)
    {
        javax.servlet.http.HttpSession session = request.getSession(createSession);
        if (session != null)
        {
            session.setAttribute(es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession.SESSION_KEY, object);
        }
    }

    /**
     * Removes the argument CrearElementoSession object from the session corresponding with the argument request.
     * In any of the following cases this method will do nothing:
     * <ul>
     *   <li>No session corresponds to the argument request</li>
     *   <li>No CrearElementoSession object could be found in the request</li>
     *   <li>The object is not of the correct type</li>
     * </ul>
     * @param request javax.servlet.http.HttpServletRequest            
     */
    protected final void removeCrearElementoSession(javax.servlet.http.HttpServletRequest request)
    {
        javax.servlet.http.HttpSession session = request.getSession(false);
        if (session != null)
        {
            Object attribute = session.getAttribute(es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession.SESSION_KEY);
            if (attribute instanceof es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession)
            {
                session.removeAttribute(es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoSession.SESSION_KEY);
            }
        }
    }

    /**
     * Returns the current EmpaquetadorSession from the session found in the argument request.
     * <p/>
     * In case an object was found in the session but it was not of the correct type, this method
     * will return <code>null</code>.
     * <p/>
     * If there is no session, it will be created; if the session would not contain a session-object
     * the object will be instantiated and subsequently stored in the session.
     *
     * @param request javax.servlet.http.HttpServletRequest          
     * @return es.pode.empaquetador.presentacion.EmpaquetadorSession
     */
    protected final es.pode.empaquetador.presentacion.EmpaquetadorSession getEmpaquetadorSession(javax.servlet.http.HttpServletRequest request)
    {
        es.pode.empaquetador.presentacion.EmpaquetadorSession object = null;
        javax.servlet.http.HttpSession session = request.getSession(true);

        Object attribute = session.getAttribute(es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY);
        if (attribute instanceof es.pode.empaquetador.presentacion.EmpaquetadorSession)
        {
            object = (es.pode.empaquetador.presentacion.EmpaquetadorSession)attribute;
        }
        else if (attribute == null)
        {
            object = new es.pode.empaquetador.presentacion.EmpaquetadorSession ();
            setEmpaquetadorSession(request, object);
        }

        return object;
    }

    /**
     * Set the argument EmpaquetadorSession object in the session corresponding with the argument request.
     * In case the session would not exist it will be created.
     *
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.empaquetador.presentacion.EmpaquetadorSession                          
     */
    protected final void setEmpaquetadorSession(javax.servlet.http.HttpServletRequest request, es.pode.empaquetador.presentacion.EmpaquetadorSession object)
    {
        setEmpaquetadorSession(request, object, true);
    }

    /**
     * Set the argument EmpaquetadorSession object in the session corresponding with the argument request.
     * Any existing object will be overwritten.
     *
     * @param createSession denotes whether or not the session should be created automatically in case it
     * would not yet exist
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.empaquetador.presentacion.EmpaquetadorSession             
     */
    protected final void setEmpaquetadorSession(javax.servlet.http.HttpServletRequest request, es.pode.empaquetador.presentacion.EmpaquetadorSession object, boolean createSession)
    {
        javax.servlet.http.HttpSession session = request.getSession(createSession);
        if (session != null)
        {
            session.setAttribute(es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY, object);
        }
    }

    /**
     * Removes the argument EmpaquetadorSession object from the session corresponding with the argument request.
     * In any of the following cases this method will do nothing:
     * <ul>
     *   <li>No session corresponds to the argument request</li>
     *   <li>No EmpaquetadorSession object could be found in the request</li>
     *   <li>The object is not of the correct type</li>
     * </ul>
     * @param request javax.servlet.http.HttpServletRequest            
     */
    protected final void removeEmpaquetadorSession(javax.servlet.http.HttpServletRequest request)
    {
        javax.servlet.http.HttpSession session = request.getSession(false);
        if (session != null)
        {
            Object attribute = session.getAttribute(es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY);
            if (attribute instanceof es.pode.empaquetador.presentacion.EmpaquetadorSession)
            {
                session.removeAttribute(es.pode.empaquetador.presentacion.EmpaquetadorSession.SESSION_KEY);
            }
        }
    }

    /**
     * Returns the current CrearRecursoArchivosSession from the session found in the argument request.
     * <p/>
     * In case an object was found in the session but it was not of the correct type, this method
     * will return <code>null</code>.
     * <p/>
     * If there is no session, it will be created; if the session would not contain a session-object
     * the object will be instantiated and subsequently stored in the session.
     *
     * @param request javax.servlet.http.HttpServletRequest          
     * @return es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession
     */
    protected final es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession getCrearRecursoArchivosSession(javax.servlet.http.HttpServletRequest request)
    {
        es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession object = null;
        javax.servlet.http.HttpSession session = request.getSession(true);

        Object attribute = session.getAttribute(es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession.SESSION_KEY);
        if (attribute instanceof es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession)
        {
            object = (es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession)attribute;
        }
        else if (attribute == null)
        {
            object = new es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession ();
            setCrearRecursoArchivosSession(request, object);
        }

        return object;
    }

    /**
     * Set the argument CrearRecursoArchivosSession object in the session corresponding with the argument request.
     * In case the session would not exist it will be created.
     *
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession                          
     */
    protected final void setCrearRecursoArchivosSession(javax.servlet.http.HttpServletRequest request, es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession object)
    {
        setCrearRecursoArchivosSession(request, object, true);
    }

    /**
     * Set the argument CrearRecursoArchivosSession object in the session corresponding with the argument request.
     * Any existing object will be overwritten.
     *
     * @param createSession denotes whether or not the session should be created automatically in case it
     * would not yet exist
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession             
     */
    protected final void setCrearRecursoArchivosSession(javax.servlet.http.HttpServletRequest request, es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession object, boolean createSession)
    {
        javax.servlet.http.HttpSession session = request.getSession(createSession);
        if (session != null)
        {
            session.setAttribute(es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession.SESSION_KEY, object);
        }
    }

    /**
     * Removes the argument CrearRecursoArchivosSession object from the session corresponding with the argument request.
     * In any of the following cases this method will do nothing:
     * <ul>
     *   <li>No session corresponds to the argument request</li>
     *   <li>No CrearRecursoArchivosSession object could be found in the request</li>
     *   <li>The object is not of the correct type</li>
     * </ul>
     * @param request javax.servlet.http.HttpServletRequest            
     */
    protected final void removeCrearRecursoArchivosSession(javax.servlet.http.HttpServletRequest request)
    {
        javax.servlet.http.HttpSession session = request.getSession(false);
        if (session != null)
        {
            Object attribute = session.getAttribute(es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession.SESSION_KEY);
            if (attribute instanceof es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession)
            {
                session.removeAttribute(es.pode.empaquetador.presentacion.avanzado.recursos.crear.archivos.CrearRecursoArchivosSession.SESSION_KEY);
            }
        }
    }

    /**
     * Returns the current CrearRecursoAvanzadoSession from the session found in the argument request.
     * <p/>
     * In case an object was found in the session but it was not of the correct type, this method
     * will return <code>null</code>.
     * <p/>
     * If there is no session, it will be created; if the session would not contain a session-object
     * the object will be instantiated and subsequently stored in the session.
     *
     * @param request javax.servlet.http.HttpServletRequest          
     * @return es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession
     */
    protected final es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession getCrearRecursoAvanzadoSession(javax.servlet.http.HttpServletRequest request)
    {
        es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession object = null;
        javax.servlet.http.HttpSession session = request.getSession(true);

        Object attribute = session.getAttribute(es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession.SESSION_KEY);
        if (attribute instanceof es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession)
        {
            object = (es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession)attribute;
        }
        else if (attribute == null)
        {
            object = new es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession ();
            setCrearRecursoAvanzadoSession(request, object);
        }

        return object;
    }

    /**
     * Set the argument CrearRecursoAvanzadoSession object in the session corresponding with the argument request.
     * In case the session would not exist it will be created.
     *
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession                          
     */
    protected final void setCrearRecursoAvanzadoSession(javax.servlet.http.HttpServletRequest request, es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession object)
    {
        setCrearRecursoAvanzadoSession(request, object, true);
    }

    /**
     * Set the argument CrearRecursoAvanzadoSession object in the session corresponding with the argument request.
     * Any existing object will be overwritten.
     *
     * @param createSession denotes whether or not the session should be created automatically in case it
     * would not yet exist
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession             
     */
    protected final void setCrearRecursoAvanzadoSession(javax.servlet.http.HttpServletRequest request, es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession object, boolean createSession)
    {
        javax.servlet.http.HttpSession session = request.getSession(createSession);
        if (session != null)
        {
            session.setAttribute(es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession.SESSION_KEY, object);
        }
    }

    /**
     * Removes the argument CrearRecursoAvanzadoSession object from the session corresponding with the argument request.
     * In any of the following cases this method will do nothing:
     * <ul>
     *   <li>No session corresponds to the argument request</li>
     *   <li>No CrearRecursoAvanzadoSession object could be found in the request</li>
     *   <li>The object is not of the correct type</li>
     * </ul>
     * @param request javax.servlet.http.HttpServletRequest            
     */
    protected final void removeCrearRecursoAvanzadoSession(javax.servlet.http.HttpServletRequest request)
    {
        javax.servlet.http.HttpSession session = request.getSession(false);
        if (session != null)
        {
            Object attribute = session.getAttribute(es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession.SESSION_KEY);
            if (attribute instanceof es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession)
            {
                session.removeAttribute(es.pode.empaquetador.presentacion.avanzado.recursos.crear.CrearRecursoAvanzadoSession.SESSION_KEY);
            }
        }
    }

    /**
     * Returns the current GestorArchivosSession from the session found in the argument request.
     * <p/>
     * In case an object was found in the session but it was not of the correct type, this method
     * will return <code>null</code>.
     * <p/>
     * If there is no session, it will be created; if the session would not contain a session-object
     * the object will be instantiated and subsequently stored in the session.
     *
     * @param request javax.servlet.http.HttpServletRequest          
     * @return es.pode.empaquetador.presentacion.archivos.GestorArchivosSession
     */
    protected final es.pode.empaquetador.presentacion.archivos.GestorArchivosSession getGestorArchivosSession(javax.servlet.http.HttpServletRequest request)
    {
        es.pode.empaquetador.presentacion.archivos.GestorArchivosSession object = null;
        javax.servlet.http.HttpSession session = request.getSession(true);

        Object attribute = session.getAttribute(es.pode.empaquetador.presentacion.archivos.GestorArchivosSession.SESSION_KEY);
        if (attribute instanceof es.pode.empaquetador.presentacion.archivos.GestorArchivosSession)
        {
            object = (es.pode.empaquetador.presentacion.archivos.GestorArchivosSession)attribute;
        }
        else if (attribute == null)
        {
            object = new es.pode.empaquetador.presentacion.archivos.GestorArchivosSession ();
            setGestorArchivosSession(request, object);
        }

        return object;
    }

    /**
     * Set the argument GestorArchivosSession object in the session corresponding with the argument request.
     * In case the session would not exist it will be created.
     *
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.empaquetador.presentacion.archivos.GestorArchivosSession                          
     */
    protected final void setGestorArchivosSession(javax.servlet.http.HttpServletRequest request, es.pode.empaquetador.presentacion.archivos.GestorArchivosSession object)
    {
        setGestorArchivosSession(request, object, true);
    }

    /**
     * Set the argument GestorArchivosSession object in the session corresponding with the argument request.
     * Any existing object will be overwritten.
     *
     * @param createSession denotes whether or not the session should be created automatically in case it
     * would not yet exist
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.empaquetador.presentacion.archivos.GestorArchivosSession             
     */
    protected final void setGestorArchivosSession(javax.servlet.http.HttpServletRequest request, es.pode.empaquetador.presentacion.archivos.GestorArchivosSession object, boolean createSession)
    {
        javax.servlet.http.HttpSession session = request.getSession(createSession);
        if (session != null)
        {
            session.setAttribute(es.pode.empaquetador.presentacion.archivos.GestorArchivosSession.SESSION_KEY, object);
        }
    }

    /**
     * Removes the argument GestorArchivosSession object from the session corresponding with the argument request.
     * In any of the following cases this method will do nothing:
     * <ul>
     *   <li>No session corresponds to the argument request</li>
     *   <li>No GestorArchivosSession object could be found in the request</li>
     *   <li>The object is not of the correct type</li>
     * </ul>
     * @param request javax.servlet.http.HttpServletRequest            
     */
    protected final void removeGestorArchivosSession(javax.servlet.http.HttpServletRequest request)
    {
        javax.servlet.http.HttpSession session = request.getSession(false);
        if (session != null)
        {
            Object attribute = session.getAttribute(es.pode.empaquetador.presentacion.archivos.GestorArchivosSession.SESSION_KEY);
            if (attribute instanceof es.pode.empaquetador.presentacion.archivos.GestorArchivosSession)
            {
                session.removeAttribute(es.pode.empaquetador.presentacion.archivos.GestorArchivosSession.SESSION_KEY);
            }
        }
    }

    /**
     * Returns the current CrearOrganizacionSession from the session found in the argument request.
     * <p/>
     * In case an object was found in the session but it was not of the correct type, this method
     * will return <code>null</code>.
     * <p/>
     * If there is no session, it will be created; if the session would not contain a session-object
     * the object will be instantiated and subsequently stored in the session.
     *
     * @param request javax.servlet.http.HttpServletRequest          
     * @return es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionSession
     */
    protected final es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionSession getCrearOrganizacionSession(javax.servlet.http.HttpServletRequest request)
    {
        es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionSession object = null;
        javax.servlet.http.HttpSession session = request.getSession(true);

        Object attribute = session.getAttribute(es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionSession.SESSION_KEY);
        if (attribute instanceof es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionSession)
        {
            object = (es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionSession)attribute;
        }
        else if (attribute == null)
        {
            object = new es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionSession ();
            setCrearOrganizacionSession(request, object);
        }

        return object;
    }

    /**
     * Set the argument CrearOrganizacionSession object in the session corresponding with the argument request.
     * In case the session would not exist it will be created.
     *
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionSession                          
     */
    protected final void setCrearOrganizacionSession(javax.servlet.http.HttpServletRequest request, es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionSession object)
    {
        setCrearOrganizacionSession(request, object, true);
    }

    /**
     * Set the argument CrearOrganizacionSession object in the session corresponding with the argument request.
     * Any existing object will be overwritten.
     *
     * @param createSession denotes whether or not the session should be created automatically in case it
     * would not yet exist
     * @param request javax.servlet.http.HttpServletRequest 
     * @param object es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionSession             
     */
    protected final void setCrearOrganizacionSession(javax.servlet.http.HttpServletRequest request, es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionSession object, boolean createSession)
    {
        javax.servlet.http.HttpSession session = request.getSession(createSession);
        if (session != null)
        {
            session.setAttribute(es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionSession.SESSION_KEY, object);
        }
    }

    /**
     * Removes the argument CrearOrganizacionSession object from the session corresponding with the argument request.
     * In any of the following cases this method will do nothing:
     * <ul>
     *   <li>No session corresponds to the argument request</li>
     *   <li>No CrearOrganizacionSession object could be found in the request</li>
     *   <li>The object is not of the correct type</li>
     * </ul>
     * @param request javax.servlet.http.HttpServletRequest            
     */
    protected final void removeCrearOrganizacionSession(javax.servlet.http.HttpServletRequest request)
    {
        javax.servlet.http.HttpSession session = request.getSession(false);
        if (session != null)
        {
            Object attribute = session.getAttribute(es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionSession.SESSION_KEY);
            if (attribute instanceof es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionSession)
            {
                session.removeAttribute(es.pode.empaquetador.presentacion.avanzado.organizaciones.crear.CrearOrganizacionSession.SESSION_KEY);
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
	     * Returns a reference to the srvGestorArchivosService imported service.
         * @return es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService getSrvGestorArchivosService()
	        throws java.lang.Exception
	    {
            String srvGestorArchivosServiceFile="importedServices.properties";	    
	        java.io.InputStream srvGestorArchivosServiceInputStream=InicioEmpaquetadorController.class.getClassLoader().getResourceAsStream(srvGestorArchivosServiceFile);
	        java.util.Properties srvGestorArchivosServiceProperties = new java.util.Properties();
	        srvGestorArchivosServiceProperties.load(srvGestorArchivosServiceInputStream);
	        String srvGestorArchivosServiceEndPointAddress="";
	        srvGestorArchivosServiceEndPointAddress=(String) srvGestorArchivosServiceProperties.get("srvGestorArchivosServicePort");
            System.out.println("srvGestorArchivosServiceEndPointAddress del fichero --> " + srvGestorArchivosServiceEndPointAddress);
  			es.pode.empaquetador.negocio.servicio.SrvGestorArchivosServiceService srvGestorArchivosService = new es.pode.empaquetador.negocio.servicio.SrvGestorArchivosServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvGestorArchivosServiceEndPointAddress.length()>0) 
				((es.pode.empaquetador.negocio.servicio.SrvGestorArchivosServiceServiceLocator)srvGestorArchivosService).setSrvGestorArchivosServiceEndpointAddress(srvGestorArchivosServiceEndPointAddress);				
	    	es.pode.empaquetador.negocio.servicio.SrvGestorArchivosService port = srvGestorArchivosService.getSrvGestorArchivosService();	    
	        return port;
	    }

	

			    /**
	     * Returns a reference to the srvGestorManifestService imported service.
         * @return es.pode.empaquetador.negocio.servicio.SrvGestorManifestService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.empaquetador.negocio.servicio.SrvGestorManifestService getSrvGestorManifestService()
	        throws java.lang.Exception
	    {
            String srvGestorManifestServiceFile="importedServices.properties";	    
	        java.io.InputStream srvGestorManifestServiceInputStream=InicioEmpaquetadorController.class.getClassLoader().getResourceAsStream(srvGestorManifestServiceFile);
	        java.util.Properties srvGestorManifestServiceProperties = new java.util.Properties();
	        srvGestorManifestServiceProperties.load(srvGestorManifestServiceInputStream);
	        String srvGestorManifestServiceEndPointAddress="";
	        srvGestorManifestServiceEndPointAddress=(String) srvGestorManifestServiceProperties.get("srvGestorManifestServicePort");
            System.out.println("srvGestorManifestServiceEndPointAddress del fichero --> " + srvGestorManifestServiceEndPointAddress);
  			es.pode.empaquetador.negocio.servicio.SrvGestorManifestServiceService srvGestorManifestService = new es.pode.empaquetador.negocio.servicio.SrvGestorManifestServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvGestorManifestServiceEndPointAddress.length()>0) 
				((es.pode.empaquetador.negocio.servicio.SrvGestorManifestServiceServiceLocator)srvGestorManifestService).setSrvGestorManifestServiceEndpointAddress(srvGestorManifestServiceEndPointAddress);				
	    	es.pode.empaquetador.negocio.servicio.SrvGestorManifestService port = srvGestorManifestService.getSrvGestorManifestService();	    
	        return port;
	    }

	

			    /**
	     * Returns a reference to the srvEmpaquetadorBasicoService imported service.
         * @return es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService  
         * @throws java.lang.Exception Exception
	     */
	    protected final es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService getSrvEmpaquetadorBasicoService()
	        throws java.lang.Exception
	    {
            String srvEmpaquetadorBasicoServiceFile="importedServices.properties";	    
	        java.io.InputStream srvEmpaquetadorBasicoServiceInputStream=InicioEmpaquetadorController.class.getClassLoader().getResourceAsStream(srvEmpaquetadorBasicoServiceFile);
	        java.util.Properties srvEmpaquetadorBasicoServiceProperties = new java.util.Properties();
	        srvEmpaquetadorBasicoServiceProperties.load(srvEmpaquetadorBasicoServiceInputStream);
	        String srvEmpaquetadorBasicoServiceEndPointAddress="";
	        srvEmpaquetadorBasicoServiceEndPointAddress=(String) srvEmpaquetadorBasicoServiceProperties.get("srvEmpaquetadorBasicoServicePort");
            System.out.println("srvEmpaquetadorBasicoServiceEndPointAddress del fichero --> " + srvEmpaquetadorBasicoServiceEndPointAddress);
  			es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoServiceService srvEmpaquetadorBasicoService = new es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoServiceServiceLocator();                                                                                                                                                                                                                                                    
            if (srvEmpaquetadorBasicoServiceEndPointAddress.length()>0) 
				((es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoServiceServiceLocator)srvEmpaquetadorBasicoService).setSrvEmpaquetadorBasicoServiceEndpointAddress(srvEmpaquetadorBasicoServiceEndPointAddress);				
	    	es.pode.empaquetador.negocio.servicio.SrvEmpaquetadorBasicoService port = srvEmpaquetadorBasicoService.getSrvEmpaquetadorBasicoService();	    
	        return port;
	    }

	
	/**
	 * Gets the reference to the dozer bean mapper used in the application (singleton).
	 * @return MapperIF
	 */
    public final net.sf.dozer.util.mapping.MapperIF getBeanMapper()
    {
		        return es.pode.empaquetador.presentacion.ServiceLocator.instance().getBeanMapper();
    }
}