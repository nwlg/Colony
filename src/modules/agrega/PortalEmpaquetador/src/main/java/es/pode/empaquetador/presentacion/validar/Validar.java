// license-header java merge-point
package es.pode.empaquetador.presentacion.validar;

/**
 * 
 */
public final class Validar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ValidarFormImpl specificForm = (ValidarFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _validar(mapping, form, request, response);
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
     * <p>
     * Llama al servicio de Empaquetacion para ejecutar una validación
     * binaria sobre el ODE en edición.
     * </p>
     */
    private org.apache.struts.action.ActionForward _validar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.validar.ValidarControllerFactory.getValidarControllerInstance().validar(mapping, (ValidarFormImpl)form, request, response);
        forward = __esValido(mapping, form, request, response);


        return forward;
    }

    /**
     * <p>
     * Analiza los resultados devueltos por el validador para redirigir
     * el flujo a la pantalla correspondiente.
     * </p>
     */
    private org.apache.struts.action.ActionForward __esValido(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.validar.ValidarControllerFactory.getValidarControllerInstance().esValido(mapping, (ValidarFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("validacion.ok");
        }
        if (value.equals("false"))
        {
            return mapping.findForward("validacion.error");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("validacion.error");
    }

}
