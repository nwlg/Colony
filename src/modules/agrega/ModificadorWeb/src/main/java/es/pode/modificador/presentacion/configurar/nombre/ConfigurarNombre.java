// license-header java merge-point
package es.pode.modificador.presentacion.configurar.nombre;

/**
 * 
 */
public final class ConfigurarNombre extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ConfigurarNombreFormImpl specificForm = (ConfigurarNombreFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.modificador.presentacion.pendientes.ListadoSubmitFormImpl)
        {
            final es.pode.modificador.presentacion.pendientes.ListadoSubmitFormImpl previousForm = (es.pode.modificador.presentacion.pendientes.ListadoSubmitFormImpl)previousFormObject;
            specificForm.setTarea(previousForm.getTarea());
        }
        else
        if (previousFormObject instanceof es.pode.modificador.presentacion.pendientes.ListadoModificarFormImpl)
        {
            final es.pode.modificador.presentacion.pendientes.ListadoModificarFormImpl previousForm = (es.pode.modificador.presentacion.pendientes.ListadoModificarFormImpl)previousFormObject;
            specificForm.setTarea(previousForm.getTarea());
        }
        else
        if (previousFormObject instanceof es.pode.modificador.presentacion.importar.ImportarModificacionImportarFormImpl)
        {
            final es.pode.modificador.presentacion.importar.ImportarModificacionImportarFormImpl previousForm = (es.pode.modificador.presentacion.importar.ImportarModificacionImportarFormImpl)previousFormObject;
        }
        else
        if (previousFormObject instanceof es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionGuardarFormImpl)
        {
            final es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionGuardarFormImpl previousForm = (es.pode.modificador.presentacion.configurar.modificacion.ConfigurarModificacionGuardarFormImpl)previousFormObject;
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _guardaTarea(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _guardaTarea(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.modificador.presentacion.configurar.nombre.ConfigurarNombreControllerFactory.getConfigurarNombreControllerInstance().recuperaNombre(mapping, (ConfigurarNombreFormImpl)form, request, response);
        forward = mapping.findForward("crear.modificacion");


        return forward;
    }

}
