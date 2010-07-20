// license-header java merge-point
package es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos;

/**
 * 
 */
public final class DerechosFormSubmitForm extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final DerechosFormSubmitFormFormImpl specificForm = (DerechosFormSubmitFormFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = __accionSubmit(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _guardarDerechos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosControllerFactory.getDerechosControllerInstance().guardarDerechos(mapping, (DerechosFormSubmitFormFormImpl)form, request, response);
        forward = __comprobarErrores(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _reset(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosControllerFactory.getDerechosControllerInstance().reset(mapping, (DerechosFormSubmitFormFormImpl)form, request, response);
        forward = mapping.findForward("derechos.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _validarDerechos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __esValidoDerechos(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosControllerFactory.getDerechosControllerInstance().eliminarDescripcion(mapping, (DerechosFormSubmitFormFormImpl)form, request, response);
        forward = mapping.findForward("derechos.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _anadirDescripcion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosControllerFactory.getDerechosControllerInstance().anadirDescripcion(mapping, (DerechosFormSubmitFormFormImpl)form, request, response);
        forward = mapping.findForward("derechos.form");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _cancelar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosControllerFactory.getDerechosControllerInstance().cancelar(mapping, (DerechosFormSubmitFormFormImpl)form, request, response);
        forward = mapping.findForward("catalogador.avanzado");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __esValidoDerechos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosControllerFactory.getDerechosControllerInstance().esValidoDerechos(mapping, (DerechosFormSubmitFormFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("valido.ok");
        }
        if (value.equals("false"))
        {
            return mapping.findForward("valido.no.ok");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("valido.no.ok");
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __accionSubmit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosControllerFactory.getDerechosControllerInstance().accionSubmit(mapping, (DerechosFormSubmitFormFormImpl)form, request, response));

        if (value.equals("Aceptar"))
        {
            return _guardarDerechos(mapping, form, request, response);
        }
        if (value.equals("Añadir"))
        {
            return _anadirDescripcion(mapping, form, request, response);
        }
        if (value.equals("Eliminar"))
        {
            return _eliminarDescripcion(mapping, form, request, response);
        }
        if (value.equals("Validar"))
        {
            return _validarDerechos(mapping, form, request, response);
        }
        if (value.equals("Cancelar"))
        {
            return _cancelar(mapping, form, request, response);
        }
        if (value.equals("Reset"))
        {
            return _reset(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _reset(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __comprobarErrores(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.catalogadorWeb.presentacion.categoriasAvanzado.derechos.DerechosControllerFactory.getDerechosControllerInstance().comprobarErrores(mapping, (DerechosFormSubmitFormFormImpl)form, request, response));

        if (value.equals("SinErrores"))
        {
            return mapping.findForward("catalogador.avanzado");
        }
        if (value.equals("ConErrores"))
        {
            return mapping.findForward("derechos.form");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("derechos.form");
    }

}
