// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.volver;

/**
 * 
 */
public final class ConfirmarGuardarDatosSubmit extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ConfirmarGuardarDatosSubmitFormImpl specificForm = (ConfirmarGuardarDatosSubmitFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _submitForm(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _cancelar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __esCatalogadorAvanzado(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _guardarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.volver.VolverControllerFactory.getVolverControllerInstance().guardar(mapping, (ConfirmarGuardarDatosSubmitFormImpl)form, request, response);
        forward = _salir(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _salir(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.volver.VolverControllerFactory.getVolverControllerInstance().borrarSesion(mapping, (ConfirmarGuardarDatosSubmitFormImpl)form, request, response);
        forward = null;


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _submitForm(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __submitVolver(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __esCatalogadorAvanzado(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.volver.VolverControllerFactory.getVolverControllerInstance().esCatalogadorAvanzado(mapping, (ConfirmarGuardarDatosSubmitFormImpl)form, request, response));

        if (value.equals("Avanzado"))
        {
            return mapping.findForward("catalogador.avanzado");
        }
        if (value.equals("Basico"))
        {
            return mapping.findForward("catalogador.basico");
        }
        if (value.equals("BasicPlus"))
        {
            return mapping.findForward("catalogador.basic.plus");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("catalogador.basic.plus");
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __submitVolver(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.volver.VolverControllerFactory.getVolverControllerInstance().submitVolver(mapping, (ConfirmarGuardarDatosSubmitFormImpl)form, request, response));

        if (value.equals("Guardar"))
        {
            return _guardarDatos(mapping, form, request, response);
        }
        if (value.equals("Salir"))
        {
            return _salir(mapping, form, request, response);
        }
        if (value.equals("Cancelar"))
        {
            return _cancelar(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _cancelar(mapping, form, request, response);
    }

}
