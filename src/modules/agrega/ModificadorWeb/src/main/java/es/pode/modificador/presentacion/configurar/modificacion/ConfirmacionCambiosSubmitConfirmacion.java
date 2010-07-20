// license-header java merge-point
package es.pode.modificador.presentacion.configurar.modificacion;

/**
 * 
 */
public final class ConfirmacionCambiosSubmitConfirmacion extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ConfirmacionCambiosSubmitConfirmacionFormImpl specificForm = (ConfirmacionCambiosSubmitConfirmacionFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = __submitConfirmacion(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _obtenerDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionControllerFactory.getConfigurarModificacionControllerInstance().obtenerDatos(mapping, (ConfirmacionCambiosSubmitConfirmacionFormImpl)form, request, response);
        forward = mapping.findForward("configurar.modificacion");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _eliminarCambios(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionControllerFactory.getConfigurarModificacionControllerInstance().eliminarCambios(mapping, (ConfirmacionCambiosSubmitConfirmacionFormImpl)form, request, response);
        forward = _obtenerDatos(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __submitConfirmacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionControllerFactory.getConfigurarModificacionControllerInstance().submitConfirmacion(mapping, (ConfirmacionCambiosSubmitConfirmacionFormImpl)form, request, response));

        if (value.equals("Aceptar"))
        {
            return _eliminarCambios(mapping, form, request, response);
        }
        if (value.equals("Cancelar"))
        {
            return _obtenerDatos(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _obtenerDatos(mapping, form, request, response);
    }

}
