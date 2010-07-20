// license-header java merge-point
package es.pode.buscador.presentacion.arbolCurricular.listarODEArea;

/**
 * 
 */
public final class ListadoODEDecidirSalida extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ListadoODEDecidirSalidaFormImpl specificForm = (ListadoODEDecidirSalidaFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = __decidirSalida(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _detalleFederada(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = null;
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _arbolCurricular(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = mapping.findForward("navegar.arbol.curricular.cu");
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _detalleODE(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = mapping.findForward("detallar.odecu");
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __decidirSalida(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.buscador.presentacion.arbolCurricular.listarODEArea.ListarODEAreaControllerFactory.getListarODEAreaControllerInstance().decidirSalida(mapping, (ListadoODEDecidirSalidaFormImpl)form, request, response));

        if (value.equals("BUSQUEDA_ARBOL"))
        {
            return _arbolCurricular(mapping, form, request, response);
        }
        if (value.equals("DETALLE_ODE"))
        {
            return _detalleODE(mapping, form, request, response);
        }
        if (value.equals("DETALLE_FEDERADA"))
        {
            return _detalleFederada(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _detalleFederada(mapping, form, request, response);
    }

}
