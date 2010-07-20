// license-header java merge-point
package es.pode.modificador.presentacion.configurar.objetos;

/**
 * 
 */
public final class ConfigurarObjetos extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ConfigurarObjetosFormImpl specificForm = (ConfigurarObjetosFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.objetos.ruta.IndicarRutaSelectActionFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.objetos.ruta.IndicarRutaSelectActionFormImpl previousForm = (es.pode.modificador.presentacion.configurar.objetos.ruta.IndicarRutaSelectActionFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.objetos.buscar.BuscarObjetoSelectActionFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.objetos.buscar.BuscarObjetoSelectActionFormImpl previousForm = (es.pode.modificador.presentacion.configurar.objetos.buscar.BuscarObjetoSelectActionFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionSubmitObjetosFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionSubmitObjetosFormImpl previousForm = (es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionSubmitObjetosFormImpl)previousFormObject;
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _decisorOffline(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _recuperarIdioma(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.modificador.presentacion.configurar.objetos.ConfigurarObjetosControllerFactory.getConfigurarObjetosControllerInstance().recuperarIdioma(mapping, (ConfigurarObjetosFormImpl)form, request, response);
        forward = mapping.findForward("buscar");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _decisorOffline(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __esOffline(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __esOffline(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.modificador.presentacion.configurar.objetos.ConfigurarObjetosControllerFactory.getConfigurarObjetosControllerInstance().esOffline(mapping, (ConfigurarObjetosFormImpl)form, request, response));

        if (value.equals("true"))
        {
            return mapping.findForward("indicar.ruta");
        }
        if (value.equals("false"))
        {
            return _recuperarIdioma(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _recuperarIdioma(mapping, form, request, response);
    }

}
