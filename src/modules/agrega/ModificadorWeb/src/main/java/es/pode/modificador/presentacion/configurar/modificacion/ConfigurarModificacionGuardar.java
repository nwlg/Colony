// license-header java merge-point
package es.pode.modificador.presentacion.configurar.modificacion;

/**
 * 
 */
public final class ConfigurarModificacionGuardar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ConfigurarModificacionGuardarFormImpl specificForm = (ConfigurarModificacionGuardarFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = __submitBotones(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _guardarModificacion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionControllerFactory.getConfigurarModificacionControllerInstance().guardarModificacion(mapping, (ConfigurarModificacionGuardarFormImpl)form, request, response);
        forward = mapping.findForward("simular.modificacion");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _borrarSesion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionControllerFactory.getConfigurarModificacionControllerInstance().borrarSesion(mapping, (ConfigurarModificacionGuardarFormImpl)form, request, response);
        forward = mapping.findForward("modificaciones.pendientes");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __submitBotones(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionControllerFactory.getConfigurarModificacionControllerInstance().submitBotones(mapping, (ConfigurarModificacionGuardarFormImpl)form, request, response));

        if (value.equals("Volver"))
        {
            return mapping.findForward("configurar.nombre");
        }
        if (value.equals("Guardar"))
        {
            return _guardarModificacion(mapping, form, request, response);
        }
        if (value.equals("Cancelar"))
        {
            return _borrarSesion(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _borrarSesion(mapping, form, request, response);
    }

}
