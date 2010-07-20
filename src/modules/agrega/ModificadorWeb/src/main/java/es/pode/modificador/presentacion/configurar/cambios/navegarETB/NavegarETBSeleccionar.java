// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.navegarETB;

/**
 * 
 */
public final class NavegarETBSeleccionar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final NavegarETBSeleccionarFormImpl specificForm = (NavegarETBSeleccionarFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = __selectAction(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _comprobarJerarquias(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __comprobarJerarquias(mapping, form, request, response);
        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _prepararSeleccion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.modificador.presentacion.configurar.cambios.navegarETB.NavegarETBControllerFactory.getNavegarETBControllerInstance().prepararSeleccion(mapping, (NavegarETBSeleccionarFormImpl)form, request, response);
        forward = mapping.findForward("seleccionar.ruta");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _guardarTermino(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.modificador.presentacion.configurar.cambios.navegarETB.NavegarETBControllerFactory.getNavegarETBControllerInstance().guardarTermino(mapping, (NavegarETBSeleccionarFormImpl)form, request, response);
        forward = mapping.findForward("cerrar");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __comprobarJerarquias(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.modificador.presentacion.configurar.cambios.navegarETB.NavegarETBControllerFactory.getNavegarETBControllerInstance().comprobarJerarquias(mapping, (NavegarETBSeleccionarFormImpl)form, request, response));

        if (value.equals("UnPadre"))
        {
            return _guardarTermino(mapping, form, request, response);
        }
        if (value.equals("VariosPadres"))
        {
            return _prepararSeleccion(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _prepararSeleccion(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __selectAction(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.modificador.presentacion.configurar.cambios.navegarETB.NavegarETBControllerFactory.getNavegarETBControllerInstance().selectAction(mapping, (NavegarETBSeleccionarFormImpl)form, request, response));

        if (value.equals("Volver"))
        {
            return mapping.findForward("tipo.anadir");
        }
        if (value.equals("Aceptar"))
        {
            return _comprobarJerarquias(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _comprobarJerarquias(mapping, form, request, response);
    }

}
