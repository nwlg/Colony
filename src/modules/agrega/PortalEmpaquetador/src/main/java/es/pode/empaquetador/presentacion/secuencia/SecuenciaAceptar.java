// license-header java merge-point
package es.pode.empaquetador.presentacion.secuencia;

/**
 * 
 */
public final class SecuenciaAceptar extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final SecuenciaAceptarFormImpl specificForm = (SecuenciaAceptarFormImpl)form;

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
     * <p>
     * Actividad que modifica la secuencia según los cambios
     * introducidos por el usuario.
     * </p>
     */
    private org.apache.struts.action.ActionForward _asociarSecuencia(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.secuencia.SecuenciaControllerFactory.getSecuenciaControllerInstance().asociarSecuencia(mapping, (SecuenciaAceptarFormImpl)form, request, response);
        forward = _union(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _union(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;
        forward = __tipoEmpaquetador(mapping, form, request, response);
        return forward;
    }

    /**
     * <p>
     * Actividad que asigna los valores por defecto a la secuencia de
     * la organización principal del ODE. La organizacion principal es:
     * </p>
     * <p>
     * choice=true
     * </p>
     * <p>
     * choiceExit=false
     * </p>
     * <p>
     * flow=true
     * </p>
     * <p>
     * forwardOnly=false
     * </p>
     */
    private org.apache.struts.action.ActionForward _valoresPorDefecto(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.secuencia.SecuenciaControllerFactory.getSecuenciaControllerInstance().fijarPorDefecto(mapping, (SecuenciaAceptarFormImpl)form, request, response);
        forward = mapping.findForward("secuencia");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __selectAction(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.secuencia.SecuenciaControllerFactory.getSecuenciaControllerInstance().selectAction(mapping, (SecuenciaAceptarFormImpl)form, request, response));

        if (value.equals("Default"))
        {
            return _valoresPorDefecto(mapping, form, request, response);
        }
        if (value.equals("Aceptar"))
        {
            return _asociarSecuencia(mapping, form, request, response);
        }
        if (value.equals("Cancelar"))
        {
            return _union(mapping, form, request, response);
        }

        // we take the last action in case we have an invalid return value from the controller
        return _union(mapping, form, request, response);
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __tipoEmpaquetador(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.secuencia.SecuenciaControllerFactory.getSecuenciaControllerInstance().tipoEmpaquetador(mapping, (SecuenciaAceptarFormImpl)form, request, response));

        if (value.equals("Avanzado"))
        {
            return mapping.findForward("gestor.elementos");
        }
        if (value.equals("Basico"))
        {
            return mapping.findForward("gestor.basico");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("gestor.basico");
    }

}
