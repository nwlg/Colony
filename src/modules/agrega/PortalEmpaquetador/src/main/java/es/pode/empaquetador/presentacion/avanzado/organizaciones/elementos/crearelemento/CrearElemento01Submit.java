// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento;

/**
 * 
 */
public final class CrearElemento01Submit extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final CrearElemento01SubmitFormImpl specificForm = (CrearElemento01SubmitFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _submit01(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _recuperarIdRef(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoControllerFactory.getCrearElementoControllerInstance().recuperarIdRef(mapping, (CrearElemento01SubmitFormImpl)form, request, response);
        forward = mapping.findForward("crear.elemento02");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _terminarSesion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoControllerFactory.getCrearElementoControllerInstance().terminarSesion(mapping, (CrearElemento01SubmitFormImpl)form, request, response);
        forward = mapping.findForward("gestor.elementos");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _elementoVacio(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __validaTipo(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _crear(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoControllerFactory.getCrearElementoControllerInstance().crear(mapping, (CrearElemento01SubmitFormImpl)form, request, response);
        forward = _terminarSesion(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _submit01(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoControllerFactory.getCrearElementoControllerInstance().submit01(mapping, (CrearElemento01SubmitFormImpl)form, request, response);
        forward = __selectAction01(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __selectAction01(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoControllerFactory.getCrearElementoControllerInstance().selectAction01(mapping, (CrearElemento01SubmitFormImpl)form, request, response));

        if (value.equals("Cancelar"))
        {
            return _terminarSesion(mapping, form, request, response);
        }
        if (value.equals("Continuar"))
        {
            return _elementoVacio(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _elementoVacio(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __validaTipo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.crearelemento.CrearElementoControllerFactory.getCrearElementoControllerInstance().validaTipo(mapping, (CrearElemento01SubmitFormImpl)form, request, response));

        if (value.equals("No"))
        {
            return _recuperarIdRef(mapping, form, request, response);
        }
        if (value.equals("Si"))
        {
            return _crear(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _crear(mapping, form, request, response);
    }

}
