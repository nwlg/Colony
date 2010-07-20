// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar;

/**
 * 
 */
public final class SeleccionarDestinoAceptar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final SeleccionarDestinoAceptarFormImpl specificForm = (SeleccionarDestinoAceptarFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _submit(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _desagregar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar.DesagregarSubmanifiestoControllerFactory.getDesagregarSubmanifiestoControllerInstance().desagregarLocal(mapping, (SeleccionarDestinoAceptarFormImpl)form, request, response);
        forward = null;


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _submit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar.DesagregarSubmanifiestoControllerFactory.getDesagregarSubmanifiestoControllerInstance().submit(mapping, (SeleccionarDestinoAceptarFormImpl)form, request, response);
        forward = __selectAction(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _borrarObjetoSesion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar.DesagregarSubmanifiestoControllerFactory.getDesagregarSubmanifiestoControllerInstance().borrarObjetoSesion(mapping, (SeleccionarDestinoAceptarFormImpl)form, request, response);
        forward = mapping.findForward("gestor.submanifiestos");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _desagregarPersonales(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar.DesagregarSubmanifiestoControllerFactory.getDesagregarSubmanifiestoControllerInstance().desagregarPersonales(mapping, (SeleccionarDestinoAceptarFormImpl)form, request, response);
        forward = _borrarObjetoSesion(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __selectAction(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.avanzado.submanifiestos.desagregar.DesagregarSubmanifiestoControllerFactory.getDesagregarSubmanifiestoControllerInstance().selectAction(mapping, (SeleccionarDestinoAceptarFormImpl)form, request, response));

        if (value.equals("local"))
        {
            return _desagregar(mapping, form, request, response);
        }
        if (value.equals("personales"))
        {
            return _desagregarPersonales(mapping, form, request, response);
        }
        if (value.equals("cancelar"))
        {
            return _borrarObjetoSesion(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _borrarObjetoSesion(mapping, form, request, response);
    }

}
