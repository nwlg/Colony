// license-header java merge-point
package es.pode.modificador.presentacion.configurar.cambios.navegarLom;

/**
 * 
 */
public final class NavegarLOMSeleccionar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final NavegarLOMSeleccionarFormImpl specificForm = (NavegarLOMSeleccionarFormImpl)form;

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _guardarTermino(mapping, form, request, response);
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

        es.pode.modificador.presentacion.configurar.cambios.navegarLom.NavegarLomControllerFactory.getNavegarLomControllerInstance().guardarTermino(mapping, (NavegarLOMSeleccionarFormImpl)form, request, response);
        forward = __selectTipo(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __selectTipo(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.modificador.presentacion.configurar.cambios.navegarLom.NavegarLomControllerFactory.getNavegarLomControllerInstance().selectTipo(mapping, (NavegarLOMSeleccionarFormImpl)form, request, response));

        if (value.equals("Comprobar"))
        {
            return mapping.findForward("comprobar.termino");
        }
        if (value.equals("Eliminar"))
        {
            return mapping.findForward("eliminar.termino");
        }
        if (value.equals("Modificar"))
        {
            return mapping.findForward("modificar.termino");
        }
        if (value.equals("AddOtro"))
        {
            return mapping.findForward("add.termino");
        }
        if (value.equals("Volver1"))
        {
            return mapping.findForward("configurar.cambios");
        }
        if (value.equals("Volver2"))
        {
            return mapping.findForward("tipo.anadir");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("tipo.anadir");
    }

}
