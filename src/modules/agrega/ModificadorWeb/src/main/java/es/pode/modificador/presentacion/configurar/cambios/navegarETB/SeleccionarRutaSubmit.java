// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.navegarETB;

/**
 * 
 */
public final class SeleccionarRutaSubmit extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final SeleccionarRutaSubmitFormImpl specificForm = (SeleccionarRutaSubmitFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = __selectActionRutas(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _guardarTermino(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.modificador.presentacion.configurar.cambios.navegarETB.NavegarETBControllerFactory.getNavegarETBControllerInstance().guardarTermino(mapping, (SeleccionarRutaSubmitFormImpl)form, request, response);
        forward = mapping.findForward("cerrar");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _navegar(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.modificador.presentacion.configurar.cambios.navegarETB.NavegarETBControllerFactory.getNavegarETBControllerInstance().navegarETB(mapping, (SeleccionarRutaSubmitFormImpl)form, request, response);
        forward = mapping.findForward("datos");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __selectActionRutas(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.modificador.presentacion.configurar.cambios.navegarETB.NavegarETBControllerFactory.getNavegarETBControllerInstance().selectActionRutas(mapping, (SeleccionarRutaSubmitFormImpl)form, request, response));

        if (value.equals("Cancelar"))
        {
            return _navegar(mapping, form, request, response);
        }
        if (value.equals("Aceptar"))
        {
            return _guardarTermino(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _guardarTermino(mapping, form, request, response);
    }

}
