// license-header java merge-point
package es.pode.modificador.presentacion.configurar.modificacion;

/**
 * 
 */
public final class ConfigurarModificacion extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ConfigurarModificacionFormImpl specificForm = (ConfigurarModificacionFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.cambios.ConfigurarCambiosSelectActionFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.cambios.ConfigurarCambiosSelectActionFormImpl previousForm = (es.pode.modificador.presentacion.configurar.cambios.ConfigurarCambiosSelectActionFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.cambios.modificar.ModificarTerminoSelectActionFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.cambios.modificar.ModificarTerminoSelectActionFormImpl previousForm = (es.pode.modificador.presentacion.configurar.cambios.modificar.ModificarTerminoSelectActionFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.cambios.eliminar.EliminarTerminoSelectActionFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.cambios.eliminar.EliminarTerminoSelectActionFormImpl previousForm = (es.pode.modificador.presentacion.configurar.cambios.eliminar.EliminarTerminoSelectActionFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.cambios.comprobar.ComprobarTerminoSelectActionFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.cambios.comprobar.ComprobarTerminoSelectActionFormImpl previousForm = (es.pode.modificador.presentacion.configurar.cambios.comprobar.ComprobarTerminoSelectActionFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.objetos.ConfigurarObjetosSubmitFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.objetos.ConfigurarObjetosSubmitFormImpl previousForm = (es.pode.modificador.presentacion.configurar.objetos.ConfigurarObjetosSubmitFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.objetos.ruta.IndicarRutaSelectActionFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.objetos.ruta.IndicarRutaSelectActionFormImpl previousForm = (es.pode.modificador.presentacion.configurar.objetos.ruta.IndicarRutaSelectActionFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.nombre.CrearModificacionContinuarFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.nombre.CrearModificacionContinuarFormImpl previousForm = (es.pode.modificador.presentacion.configurar.nombre.CrearModificacionContinuarFormImpl)previousFormObject;
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _obtenerDatos(mapping, form, request, response);
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

        es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionControllerFactory.getConfigurarModificacionControllerInstance().obtenerDatos(mapping, (ConfigurarModificacionFormImpl)form, request, response);
        forward = mapping.findForward("configurar.modificacion");


        return forward;
    }

}
