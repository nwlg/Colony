// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * 
 */
public final class MostrarDetalleODEValorarODE extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final MostrarDetalleODEValorarODEFormImpl specificForm = (MostrarDetalleODEValorarODEFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _valorarFicha(mapping, form, request, response);
        }
        catch (java.lang.Exception exception)
        {
            // we populate the current form with only the request parameters
            Object currentForm = request.getSession().getAttribute("form");
            // if we can't get the 'form' from the session, try from the request
            if (currentForm == null)
            {
                currentForm = request.getAttribute("form");
            }
            if (currentForm != null)
            {
                final java.util.Map parameters = new java.util.HashMap();
                for (final java.util.Enumeration names = request.getParameterNames(); names.hasMoreElements();)
                {
                    final String name = String.valueOf(names.nextElement());
                    parameters.put(name, request.getParameter(name));
                }
                try
                {
                    org.apache.commons.beanutils.BeanUtils.populate(currentForm, parameters);
                }
                catch (java.lang.Exception populateException)
                {
                    // ignore if we have an exception here (we just don't populate).
                }
            }
            throw exception;
        }
        request.getSession().setAttribute("form", form);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _buscarDetalleODE(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.basico.detallar.DetallarControllerFactory.getDetallarControllerInstance().buscarDetalleODE(mapping, (MostrarDetalleODEValorarODEFormImpl)form, request, response);
        forward = mapping.findForward("mostrar.detalle.ode");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _agregarODEFederado(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.basico.detallar.DetallarControllerFactory.getDetallarControllerInstance().agregarODEFederado(mapping, (MostrarDetalleODEValorarODEFormImpl)form, request, response);
        forward = mapping.findForward("ode.agregado");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _prepararEntrada(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __analizaEntrada(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _valorarFicha(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.basico.detallar.DetallarControllerFactory.getDetallarControllerInstance().valorarODE(mapping, (MostrarDetalleODEValorarODEFormImpl)form, request, response);
        forward = _prepararEntrada(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _detalleFederado(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = null;
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _gestionarBotonera(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.basico.detallar.DetallarControllerFactory.getDetallarControllerInstance().gestionarBotonera(mapping, (MostrarDetalleODEValorarODEFormImpl)form, request, response);
        forward = __analizaPosicionamiento(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _gestionarAnteriorSiguiente(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.basico.detallar.DetallarControllerFactory.getDetallarControllerInstance().gestionarPosicionamiento(mapping, (MostrarDetalleODEValorarODEFormImpl)form, request, response);
        forward = _gestionarBotonera(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _gestionarBusqueda(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.basico.detallar.DetallarControllerFactory.getDetallarControllerInstance().gestionarBusqueda(mapping, (MostrarDetalleODEValorarODEFormImpl)form, request, response);
        forward = _gestionarBotonera(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __analizaPosicionamiento(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.basico.detallar.DetallarControllerFactory.getDetallarControllerInstance().analizaPosicionamiento(mapping, (MostrarDetalleODEValorarODEFormImpl)form, request, response));

        if (value.equals("ODE_FEDERADO"))
        {
            return _detalleFederado(mapping, form, request, response);
        }
        if (value.equals("ODE_LOCAL"))
        {
            return _buscarDetalleODE(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _buscarDetalleODE(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __analizaEntrada(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.basico.detallar.DetallarControllerFactory.getDetallarControllerInstance().analizaEntrada(mapping, (MostrarDetalleODEValorarODEFormImpl)form, request, response));

        if (value.equals("DETALLE_FEDERADO"))
        {
            return _agregarODEFederado(mapping, form, request, response);
        }
        if (value.equals("POSICIONADO_DETALLE"))
        {
            return _gestionarAnteriorSiguiente(mapping, form, request, response);
        }
        if (value.equals("DETALLE"))
        {
            return _gestionarBusqueda(mapping, form, request, response);
        }
        if (value.equals("DETALLE_SIN_POSICIONAMIENTO"))
        {
            return _buscarDetalleODE(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _buscarDetalleODE(mapping, form, request, response);
    }

}
