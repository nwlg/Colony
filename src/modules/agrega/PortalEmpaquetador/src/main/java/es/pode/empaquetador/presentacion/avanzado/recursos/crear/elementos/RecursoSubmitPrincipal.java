// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos;

/**
 * 
 */
public final class RecursoSubmitPrincipal extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final RecursoSubmitPrincipalFormImpl specificForm = (RecursoSubmitPrincipalFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = __submitArchivoPrincipal(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _recuperarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosControllerFactory.getCrearRecursoAvanzadoElementosControllerInstance().recuperarDatos(mapping, (RecursoSubmitPrincipalFormImpl)form, request, response);
        forward = mapping.findForward("recurso");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _seleccionarPrincipal(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosControllerFactory.getCrearRecursoAvanzadoElementosControllerInstance().seleccionarPrincipal(mapping, (RecursoSubmitPrincipalFormImpl)form, request, response);
        forward = _recuperarDatos(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _recuperarPrincipal(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosControllerFactory.getCrearRecursoAvanzadoElementosControllerInstance().recuperarURL(mapping, (RecursoSubmitPrincipalFormImpl)form, request, response);
        forward = mapping.findForward("editar");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _recuperarArchivos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosControllerFactory.getCrearRecursoAvanzadoElementosControllerInstance().recuperarArchivos(mapping, (RecursoSubmitPrincipalFormImpl)form, request, response);
        forward = __esUnArchivo(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __submitArchivoPrincipal(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosControllerFactory.getCrearRecursoAvanzadoElementosControllerInstance().submitArchivoPrincipal(mapping, (RecursoSubmitPrincipalFormImpl)form, request, response));

        if (value.equals("Principal"))
        {
            return _recuperarArchivos(mapping, form, request, response);
        }
        if (value.equals("Editar"))
        {
            return _recuperarPrincipal(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _recuperarPrincipal(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __esUnArchivo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.avanzado.recursos.crear.elementos.CrearRecursoAvanzadoElementosControllerFactory.getCrearRecursoAvanzadoElementosControllerInstance().esUnArchivo(mapping, (RecursoSubmitPrincipalFormImpl)form, request, response));

        if (value.equals("No"))
        {
            return mapping.findForward("archivo.principal");
        }
        if (value.equals("Si"))
        {
            return _seleccionarPrincipal(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _seleccionarPrincipal(mapping, form, request, response);
    }

}
