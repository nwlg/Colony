// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.navegarLom;

/**
 * 
 */
public final class NavegarLom extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final NavegarLomFormImpl specificForm = (NavegarLomFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.cambios.ConfigurarCambiosSelectActionFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.cambios.ConfigurarCambiosSelectActionFormImpl previousForm = (es.pode.modificador.presentacion.configurar.cambios.ConfigurarCambiosSelectActionFormImpl)previousFormObject;
            specificForm.setIdTermino(previousForm.getIdTermino());
        }
        else
        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.cambios.add.TipoAnadirSelectActionFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.cambios.add.TipoAnadirSelectActionFormImpl previousForm = (es.pode.modificador.presentacion.configurar.cambios.add.TipoAnadirSelectActionFormImpl)previousFormObject;
            specificForm.setIdTermino(previousForm.getIdTermino());
        }
        else
        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.cambios.add.otro.AddTerminoActionFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.cambios.add.otro.AddTerminoActionFormImpl previousForm = (es.pode.modificador.presentacion.configurar.cambios.add.otro.AddTerminoActionFormImpl)previousFormObject;
            specificForm.setIdTermino(previousForm.getIdTermino());
        }
        else
        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.cambios.modificar.ModificarTerminoSelectActionFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.cambios.modificar.ModificarTerminoSelectActionFormImpl previousForm = (es.pode.modificador.presentacion.configurar.cambios.modificar.ModificarTerminoSelectActionFormImpl)previousFormObject;
            specificForm.setIdTermino(previousForm.getIdTermino());
        }
        else
        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.cambios.eliminar.EliminarTerminoSelectActionFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.cambios.eliminar.EliminarTerminoSelectActionFormImpl previousForm = (es.pode.modificador.presentacion.configurar.cambios.eliminar.EliminarTerminoSelectActionFormImpl)previousFormObject;
            specificForm.setIdTermino(previousForm.getIdTermino());
        }
        else
        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.cambios.comprobar.ComprobarTerminoSelectActionFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.cambios.comprobar.ComprobarTerminoSelectActionFormImpl previousForm = (es.pode.modificador.presentacion.configurar.cambios.comprobar.ComprobarTerminoSelectActionFormImpl)previousFormObject;
            specificForm.setIdTermino(previousForm.getIdTermino());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _navegar(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _navegar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.modificador.presentacion.configurar.cambios.navegarLom.NavegarLomControllerFactory.getNavegarLomControllerInstance().navegarLom(mapping, (NavegarLomFormImpl)form, request, response);
        forward = mapping.findForward("navegar.lom");


        return forward;
    }

}
