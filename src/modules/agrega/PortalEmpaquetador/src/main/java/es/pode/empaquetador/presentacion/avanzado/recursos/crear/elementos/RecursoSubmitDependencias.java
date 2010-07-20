// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos;

/**
 * 
 */
public final class RecursoSubmitDependencias extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final RecursoSubmitDependenciasFormImpl specificForm = (RecursoSubmitDependenciasFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _submitDependencias(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _recuperarDependencias(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosControllerFactory.getCrearRecursoAvanzadoElementosControllerInstance().recuperarDependencias(mapping, (RecursoSubmitDependenciasFormImpl)form, request, response);
        forward = mapping.findForward("dependencias");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _recuperarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosControllerFactory.getCrearRecursoAvanzadoElementosControllerInstance().recuperarDatos(mapping, (RecursoSubmitDependenciasFormImpl)form, request, response);
        forward = mapping.findForward("recurso");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarDependencias(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosControllerFactory.getCrearRecursoAvanzadoElementosControllerInstance().eliminarDependencias(mapping, (RecursoSubmitDependenciasFormImpl)form, request, response);
        forward = _recuperarDatos(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _submitDependencias(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosControllerFactory.getCrearRecursoAvanzadoElementosControllerInstance().submitDependencias(mapping, (RecursoSubmitDependenciasFormImpl)form, request, response);
        forward = __selectActionDependencias(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __selectActionDependencias(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosControllerFactory.getCrearRecursoAvanzadoElementosControllerInstance().selectActionDependencias(mapping, (RecursoSubmitDependenciasFormImpl)form, request, response));

        if (value.equals("Eliminar"))
        {
            return _eliminarDependencias(mapping, form, request, response);
        }
        if (value.equals("Crear"))
        {
            return _recuperarDependencias(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _recuperarDependencias(mapping, form, request, response);
    }

}
