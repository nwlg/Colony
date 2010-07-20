// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.buscarAvanzado;

/**
 * 
 */
public final class MostrarQuisoDecirAvanzadoBuscarQuisoDecir extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final MostrarQuisoDecirAvanzadoBuscarQuisoDecirFormImpl specificForm = (MostrarQuisoDecirAvanzadoBuscarQuisoDecirFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _validarFormulario(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _validarFormulario(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().validarFormulario(mapping, (MostrarQuisoDecirAvanzadoBuscarQuisoDecirFormImpl)form, request, response);
        forward = __analizaValidacion(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _mostrarResultados(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = mapping.findForward("mostrar.resultados");
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _buscarSQI(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = mapping.findForward("busqueda.sqicu");
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cargarDatosFormularioAvanzado(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().cargaFormularioBusquedaAvanzada(mapping, (MostrarQuisoDecirAvanzadoBuscarQuisoDecirFormImpl)form, request, response);
        forward = mapping.findForward("mostrar");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cargarFormularioQuisoDecir(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().cargarFormularioQuisoDecir(mapping, (MostrarQuisoDecirAvanzadoBuscarQuisoDecirFormImpl)form, request, response);
        forward = mapping.findForward("mostrar.quiso.decir.avanzado");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _concentradorCargarFormulario(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = _cargarDatosFormularioAvanzado(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _analizaVisualizacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __analizarVisualizacion(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _buscarAvanzada(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().ejecutarBusquedaAvanzada(mapping, (MostrarQuisoDecirAvanzadoBuscarQuisoDecirFormImpl)form, request, response);
        forward = __analizaResultados(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _concentradorBusqueda(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __analizaTipoBusqueda(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __analizaTipoBusqueda(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().analizaTipoBusqueda(mapping, (MostrarQuisoDecirAvanzadoBuscarQuisoDecirFormImpl)form, request, response));

        if (value.equals("AGREGA"))
        {
            return _buscarAvanzada(mapping, form, request, response);
        }
        if (value.equals("SQI"))
        {
            return _buscarSQI(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _buscarSQI(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __analizaResultados(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().analizaResultados(mapping, (MostrarQuisoDecirAvanzadoBuscarQuisoDecirFormImpl)form, request, response));

        if (value.equals("CON_SUGERENCIAS"))
        {
            return mapping.findForward("mostrar.quiso.decir.avanzado");
        }
        if (value.equals("CON_RESULTADOS"))
        {
            return _analizaVisualizacion(mapping, form, request, response);
        }
        if (value.equals("SIN_RESULTADOS"))
        {
            return _concentradorCargarFormulario(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _concentradorCargarFormulario(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __analizarVisualizacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().analizarVisualizacion(mapping, (MostrarQuisoDecirAvanzadoBuscarQuisoDecirFormImpl)form, request, response));

        if (value.equals("SIN_IMAGENES"))
        {
            return mapping.findForward("mostrar.resultados.avanzado");
        }
        if (value.equals("CON_IMAGENES"))
        {
            return _mostrarResultados(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _mostrarResultados(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __analizaValidacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoControllerFactory.getBuscarAvanzadoControllerInstance().analizaValidacion(mapping, (MostrarQuisoDecirAvanzadoBuscarQuisoDecirFormImpl)form, request, response));

        if (value.equals("FORMULARIO_INVALIDO"))
        {
            return _cargarFormularioQuisoDecir(mapping, form, request, response);
        }
        if (value.equals("FORMULARIO_VALIDO"))
        {
            return _concentradorBusqueda(mapping, form, request, response);
        }
        if (value.equals("FORMULARIO_INVALIDO_AVANZADO"))
        {
            return _concentradorCargarFormulario(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _concentradorCargarFormulario(mapping, form, request, response);
    }

}
