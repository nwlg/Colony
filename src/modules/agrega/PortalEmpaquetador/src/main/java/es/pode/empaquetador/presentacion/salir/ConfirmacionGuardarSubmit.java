// license-header java merge-point
package es.pode.empaquetador.presentacion.salir;

/**
 * 
 */
public final class ConfirmacionGuardarSubmit extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final ConfirmacionGuardarSubmitFormImpl specificForm = (ConfirmacionGuardarSubmitFormImpl)form;

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
    private org.apache.struts.action.ActionForward _submit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __selectAction(mapping, form, request, response);
        return forward;
    }

    /**
     * <p>
     * Actividad que invoca al servicio de Empaquetacion para guardar
     * los cambios del ODE.
     * </p>
     */
    private org.apache.struts.action.ActionForward _guardarOde(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.salir.SalirControllerFactory.getSalirControllerInstance().guardar(mapping, (ConfirmacionGuardarSubmitFormImpl)form, request, response);
        forward = _cerrarSesion(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _union(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __esAvanzado(mapping, form, request, response);
        return forward;
    }

    /**
     * <p>
     * Actividad que cierra la sesión del Empaquetado Básico.
     * </p>
     */
    private org.apache.struts.action.ActionForward _cerrarSesion(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.salir.SalirControllerFactory.getSalirControllerInstance().cerrarSesion(mapping, (ConfirmacionGuardarSubmitFormImpl)form, request, response);
        forward = null;


        return forward;
    }

    /**
     * <p>
     * Actividad que elimina el ODE en edición del directorio del
     * usuario.
     * </p>
     */
    private org.apache.struts.action.ActionForward _restaurarBackup(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.salir.SalirControllerFactory.getSalirControllerInstance().restaurarBackup(mapping, (ConfirmacionGuardarSubmitFormImpl)form, request, response);
        forward = _cerrarSesion(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __esAvanzado(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.salir.SalirControllerFactory.getSalirControllerInstance().esAvanzado(mapping, (ConfirmacionGuardarSubmitFormImpl)form, request, response));

        if (value.equals("Basico"))
        {
            return mapping.findForward("gestor.basico");
        }
        if (value.equals("Avanzado"))
        {
            return mapping.findForward("gestor.organizaciones");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("gestor.organizaciones");
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __selectAction(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.salir.SalirControllerFactory.getSalirControllerInstance().selectAction(mapping, (ConfirmacionGuardarSubmitFormImpl)form, request, response));

        if (value.equals("Guardar"))
        {
            return _guardarOde(mapping, form, request, response);
        }
        if (value.equals("Salir"))
        {
            return _restaurarBackup(mapping, form, request, response);
        }
        if (value.equals("Cancelar"))
        {
            return _union(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _union(mapping, form, request, response);
    }

}
