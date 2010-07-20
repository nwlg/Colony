// license-header java merge-point
package es.pode.tagging.presentacion.inicioTagging;

/**
 * 
 */
public final class InicioTagging extends org.apache.struts.action.Action
{
    public org.apache.struts.action.ActionForward execute(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final InicioTaggingFormImpl specificForm = (InicioTaggingFormImpl)form;

        final Object previousFormObject = request.getSession().getAttribute("form");

        org.apache.struts.action.ActionForward forward = null;

        try
        {
            forward = _inicio(mapping, form, request, response);
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
    private org.apache.struts.action.ActionForward _inicio(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        org.apache.struts.action.ActionForward forward = null;

        es.pode.tagging.presentacion.inicioTagging.InicioTaggingControllerFactory.getInicioTaggingControllerInstance().crearSession(mapping, (InicioTaggingFormImpl)form, request, response);
        forward = __estaAutenticado(mapping, form, request, response);


        return forward;
    }

    /**
     * 
     */
    private org.apache.struts.action.ActionForward __estaAutenticado(org.apache.struts.action.ActionMapping mapping, org.apache.struts.action.ActionForm form, javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws java.lang.Exception
    {
        final java.lang.String value = java.lang.String.valueOf(es.pode.tagging.presentacion.inicioTagging.InicioTaggingControllerFactory.getInicioTaggingControllerInstance().estaAutenticado(mapping, (InicioTaggingFormImpl)form, request, response));

        if (value.equals("false"))
        {
            return mapping.findForward("listar.agrega.tags");
        }
        if (value.equals("true"))
        {
            return mapping.findForward("listar.mis.tags");
        }

        // we take the last action in case we have an invalid return value from the controller
        return mapping.findForward("listar.mis.tags");
    }

}
