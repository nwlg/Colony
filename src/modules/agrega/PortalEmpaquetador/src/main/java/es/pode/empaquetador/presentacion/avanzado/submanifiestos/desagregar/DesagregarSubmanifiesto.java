// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar;

/**
 * 
 */
public final class DesagregarSubmanifiesto extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final DesagregarSubmanifiestoFormImpl specificForm = (DesagregarSubmanifiestoFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        if (previousFormObject instanceof es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.GestorSubmanifiestosSubmitFormImpl)
        {
            final es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.GestorSubmanifiestosSubmitFormImpl previousForm = (es.pode.empaquetador.presentacion.avanzado.submanifiestos.gestor.GestorSubmanifiestosSubmitFormImpl)previousFormObject;
            specificForm.setIdentificadores(previousForm.getIdentificadores());
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
    private org.apache.struts.action.ActionForward _recuperarDatos(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar.DesagregarSubmanifiestoControllerFactory.getDesagregarSubmanifiestoControllerInstance().recuperarDatos(mapping, (DesagregarSubmanifiestoFormImpl)form, request, response);
        forward = _offline(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _desagregar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar.DesagregarSubmanifiestoControllerFactory.getDesagregarSubmanifiestoControllerInstance().desagregarLocal(mapping, (DesagregarSubmanifiestoFormImpl)form, request, response);
        forward = null;


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _offline(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
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
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar.DesagregarSubmanifiestoControllerFactory.getDesagregarSubmanifiestoControllerInstance().esOffline(mapping, (DesagregarSubmanifiestoFormImpl)form, request, response));

        if (value.equals("false"))
        {
            return mapping.findForward("seleccionar.destino");
        }
        if (value.equals("true"))
        {
            return _desagregar(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _desagregar(mapping, form, request, response);
    }

}
