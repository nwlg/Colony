// license-header java merge-point
package es.pode.buscador.presentacion.basico.detallar;

/**
 * 
 */
public final class OdeAgregadoAgregarNuevo extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final OdeAgregadoAgregarNuevoFormImpl specificForm = (OdeAgregadoAgregarNuevoFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _volverBusqueda(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _volverBusqueda(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __determinaAtras(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _busquedaBasica(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = mapping.findForward("listar.odecu");
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _busquedaAvanzada(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = mapping.findForward("buscar.avanzado.cu");
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _busquedaArbol(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = mapping.findForward("listar.odearea.cu");
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _busquedaFederada(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = null;
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _busquedaTesauro(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = mapping.findForward("listar.odetesauro.cu");
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __determinaAtras(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.basico.detallar.DetallarControllerFactory.getDetallarControllerInstance().determinaAtras(mapping, (OdeAgregadoAgregarNuevoFormImpl)form, request, response));

        if (value.equals("BUSQUEDA_BASICA"))
        {
            return _busquedaBasica(mapping, form, request, response);
        }
        if (value.equals("BUSCAR"))
        {
            return _busquedaAvanzada(mapping, form, request, response);
        }
        if (value.equals("BUSQUEDA_ARBOL"))
        {
            return _busquedaArbol(mapping, form, request, response);
        }
        if (value.equals("BUSQUEDA_FEDERADA"))
        {
            return _busquedaFederada(mapping, form, request, response);
        }
        if (value.equals("BUSQUEDA_TESAURO"))
        {
            return _busquedaTesauro(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _busquedaTesauro(mapping, form, request, response);
    }

}
