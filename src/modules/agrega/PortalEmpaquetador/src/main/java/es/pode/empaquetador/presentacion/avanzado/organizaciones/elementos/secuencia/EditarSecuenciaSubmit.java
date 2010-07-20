// license-header java merge-point
package es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia;

/**
 * 
 */
public final class EditarSecuenciaSubmit extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final EditarSecuenciaSubmitFormImpl specificForm = (EditarSecuenciaSubmitFormImpl)form;

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
    private org.apache.struts.action.ActionForward _asociarSecuencia(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia.SecuenciaControllerFactory.getSecuenciaControllerInstance().asociarSecuencia(mapping, (EditarSecuenciaSubmitFormImpl)form, request, response);
        forward = mapping.findForward("gestor.elementos");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _submit(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia.SecuenciaControllerFactory.getSecuenciaControllerInstance().submit(mapping, (EditarSecuenciaSubmitFormImpl)form, request, response);
        forward = __selectAction(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward _porDefecto(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia.SecuenciaControllerFactory.getSecuenciaControllerInstance().fijarPorDefecto(mapping, (EditarSecuenciaSubmitFormImpl)form, request, response);
        forward = mapping.findForward("editar.secuencia");


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __selectAction(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.empaquetador.presentacion.avanzado.organizaciones.elementos.secuencia.SecuenciaControllerFactory.getSecuenciaControllerInstance().selectAction(mapping, (EditarSecuenciaSubmitFormImpl)form, request, response));

        if (value.equals("default"))
        {
            return _porDefecto(mapping, form, request, response);
        }
        if (value.equals("aceptar"))
        {
            return _asociarSecuencia(mapping, form, request, response);
        }
        if (value.equals("cancelar"))
        {
            return mapping.findForward("gestor.elementos");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("gestor.elementos");
    }

}
