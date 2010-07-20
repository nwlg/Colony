// license-header java merge-point
package es.pode.buscador.presentacion.avanzado.busquedaSQI;

/**
 * 
 */
public final class BusquedaSQICU extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final BusquedaSQICUFormImpl specificForm = (BusquedaSQICUFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarQuisoDecirAvanzadoBuscarQuisoDecirFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarQuisoDecirAvanzadoBuscarQuisoDecirFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarQuisoDecirAvanzadoBuscarQuisoDecirFormImpl)previousFormObject;
            specificForm.setBuscadorContenido(previousForm.getBuscadorContenido());
            specificForm.setTipoBusqueda(previousForm.getTipoBusqueda());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosAvanzadoBuscarResultadosFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosAvanzadoBuscarResultadosFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosAvanzadoBuscarResultadosFormImpl)previousFormObject;
            specificForm.setBuscadorContenido(previousForm.getBuscadorContenido());
            specificForm.setTipoBusqueda(previousForm.getTipoBusqueda());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosAvanzadoPaginarFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosAvanzadoPaginarFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosAvanzadoPaginarFormImpl)previousFormObject;
            specificForm.setBuscadorContenido(previousForm.getBuscadorContenido());
            specificForm.setTipoBusqueda(previousForm.getTipoBusqueda());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosImagenesEliminarODEFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosImagenesEliminarODEFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosImagenesEliminarODEFormImpl)previousFormObject;
            specificForm.setBuscadorContenido(previousForm.getBuscadorContenido());
            specificForm.setTipoBusqueda(previousForm.getTipoBusqueda());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosImagenesPaginarImagenesFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosImagenesPaginarImagenesFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosImagenesPaginarImagenesFormImpl)previousFormObject;
            specificForm.setBuscadorContenido(previousForm.getBuscadorContenido());
            specificForm.setTipoBusqueda(previousForm.getTipoBusqueda());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarResultadosAvanzadoBuscarResultadosImagenesFormImpl)previousFormObject;
            specificForm.setBuscadorContenido(previousForm.getBuscadorContenido());
            specificForm.setTipoBusqueda(previousForm.getTipoBusqueda());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarQuisoDecirAvanzadoQuisoDecirFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarQuisoDecirAvanzadoQuisoDecirFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarQuisoDecirAvanzadoQuisoDecirFormImpl)previousFormObject;
            specificForm.setBuscadorContenido(previousForm.getBuscadorContenido());
            specificForm.setTipoBusqueda(previousForm.getTipoBusqueda());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoCUFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoCUFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.buscarAvanzado.BuscarAvanzadoCUFormImpl)previousFormObject;
            specificForm.setBuscadorContenido(previousForm.getBuscadorContenido());
            specificForm.setTipoBusqueda(previousForm.getTipoBusqueda());
        }
        else
        if (previousFormObject instanceof es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarFormularioAvanzadoAnalizaPulsacionFormImpl)
        {
            final es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarFormularioAvanzadoAnalizaPulsacionFormImpl previousForm = (es.pode.buscador.presentacion.avanzado.buscarAvanzado.MostrarFormularioAvanzadoAnalizaPulsacionFormImpl)previousFormObject;
            specificForm.setBuscadorContenido(previousForm.getBuscadorContenido());
            specificForm.setTipoBusqueda(previousForm.getTipoBusqueda());
        }
        else
        {
            // do nothing
        }
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
        forward = __analizarFormulario(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _buscarSQI(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.buscador.presentacion.avanzado.busquedaSQI.BusquedaSQIControllerFactory.getBusquedaSQIControllerInstance().ejecutarBusquedaSQI(mapping, (BusquedaSQICUFormImpl)form, request, response);
        forward = mapping.findForward("mostrar.resultados.busqueda");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _mostrarError(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = mapping.findForward("mostrar.error.formulario");
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __analizarFormulario(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.avanzado.busquedaSQI.BusquedaSQIControllerFactory.getBusquedaSQIControllerInstance().analizarFormulario(mapping, (BusquedaSQICUFormImpl)form, request, response));

        if (value.equals("FORMULARIO_VALIDO"))
        {
            return _buscarSQI(mapping, form, request, response);
        }
        if (value.equals("FORMULARIO_ERROR"))
        {
            return _mostrarError(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _mostrarError(mapping, form, request, response);
    }

}
