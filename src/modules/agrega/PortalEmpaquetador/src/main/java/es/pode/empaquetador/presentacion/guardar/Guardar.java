// license-header java merge-point
package es.pode.empaquetador.presentacion.guardar;

/**
 * 
 */
public final class Guardar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final GuardarFormImpl specificForm = (GuardarFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosGuardarFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosGuardarFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.recursos.gestor.GestorRecursosGuardarFormImpl)previousFormObject;
            specificForm.setReturnURL(previousForm.getReturnURL());
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoGuardarFormImpl)
        {
            final es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoGuardarFormImpl previousForm = (es.pode.empaquetador.presentacion.basico.gestor.GestorBasicoGuardarFormImpl)previousFormObject;
            specificForm.setReturnURL(previousForm.getReturnURL());
        }
        else
        if (previousFormObject instanceof es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosGuardarFormImpl)
        {
            final es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosGuardarFormImpl previousForm = (es.pode.empaquetador.presentacion.archivos.gestor.GestorArchivosGuardarFormImpl)previousFormObject;
            specificForm.setReturnURL(previousForm.getReturnURL());
        }
        else
        {
            // do nothing
        }
        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _recuperarDatos(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _guardar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.guardar.GuardarControllerFactory.getGuardarControllerInstance().guardar(mapping, (GuardarFormImpl)form, request, response);
        forward = null;


        return forward;
    }

    /**
     * <p>
     * Actividad vacia para la documentacion del parametro returnURL.
     * </p>
     */
    private org.apache.struts.action.ActionForward _recuperarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = _guardar(mapping, form, request, response);
        return forward;
    }

}
