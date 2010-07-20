// license-header java merge-point
package es.pode.empaquetador.presentacion.basico.asociar;

/**
 * 
 */
public final class SeleccionarSubmit extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final SeleccionarSubmitFormImpl specificForm = (SeleccionarSubmitFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = __seleccionar(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _borrarSesion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.basico.asociar.AsociarControllerFactory.getAsociarControllerInstance().borrarSesion(mapping, (SeleccionarSubmitFormImpl)form, request, response);
        forward = mapping.findForward("gestor.basico");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _recuperaURL(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.basico.asociar.AsociarControllerFactory.getAsociarControllerInstance().recuperaURL(mapping, (SeleccionarSubmitFormImpl)form, request, response);
        forward = mapping.findForward("url");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _recuperaObject(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.basico.asociar.AsociarControllerFactory.getAsociarControllerInstance().recuperarObject(mapping, (SeleccionarSubmitFormImpl)form, request, response);
        forward = mapping.findForward("object");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __seleccionar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.basico.asociar.AsociarControllerFactory.getAsociarControllerInstance().seleccionar(mapping, (SeleccionarSubmitFormImpl)form, request, response));

        if (value.equals("Archivos"))
        {
            return mapping.findForward("asociacion.archivos");
        }
        if (value.equals("Cancelar"))
        {
            return _borrarSesion(mapping, form, request, response);
        }
        if (value.equals("Url"))
        {
            return _recuperaURL(mapping, form, request, response);
        }
        if (value.equals("Object"))
        {
            return _recuperaObject(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _recuperaObject(mapping, form, request, response);
    }

}
